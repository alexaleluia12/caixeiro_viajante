package algoritmogenetico;

// genes ["A", "B", "F", "T"]
// com a letra inicial das cidades

// metodo importante
// get_distancia_percurso()
//   returna a distancia apara entre as cidade que estao no genes

public class Individuo {
	public String genes[];
	int len_genes;
	
	// len quantidade de cidade no genes
	// ideal para ser chamado na primeira geracao
	public Individuo(int len, Dados dados) {

		genes = new String[len];// as string de genes vao ter tamanho 1
		len_genes = len;
		int i, max = len;
		
		int max_randomico = dados.quantidade;
		for(i=0; i<max; i++){
			genes[i] = Utils.at(dados.possiveis, Utils.rand(max_randomico));
		}
	}
	
	// ideal para ser chamada nas geracoes posteriores
	public Individuo(Individuo lst[], Dados dados) {
		Individuo pai = lst[0];
		Individuo mae = lst[1];
		assert pai.genes.length == mae.genes.length;
		len_genes = pai.len_genes;
		genes = crossover(pai, mae);
		mutacao(dados);
	}
	
	public Double get_distancia_percurso(Dados dados){
		int i, max = len_genes - 1;
		Double count = 0.0;
		String chave_nome;
		for(i=0; i<max; i++){
			chave_nome = genes[i] + genes[i+1];
			count += dados.get_distancia(chave_nome);
		}
		
		return count;
	}
	
	// True se exite duas letras iguais nos genes
	public boolean repete(){
		// { a, b, a, c , e ,f }
		
		int i,j;
		String tmp;
		for(i=0; i<len_genes; i++){
			tmp = genes[i];
			for(j=i+1; j<len_genes; j++){
				if(genes[j].equals(tmp))
					return true;
			}
		}
		return false;
	}
	
	// faz um troca da posicao entre dois genes (para evitar letras repetidas)
	public void mutacao(Dados dados){
		int local1 = Utils.rand(len_genes);
		int local2 = Utils.rand(len_genes);
		while(local2 == local1){
			local2 = Utils.rand(len_genes);
		}
		String tmp = genes[local1];
		genes[local1] = genes[local2];
		genes[local2] = tmp;
	}
	
	// retorna os genes do filho (faz o cruzamento entre os pais)
	// cruzamento sigle point
	private String[] crossover(Individuo a, Individuo b){
		String lst[] = new String[a.len_genes];
		int i, max = lst.length;
		int rand_point = Utils.rand(len_genes);
		
		// de 0 ate rand_point (a), de rand_point ate max b
		
		// a Individuo
		for(i=0; i<rand_point; i++){
			lst[i] = a.genes[i];
		}
		
		// b Individuo
		for(; i<max; i++){
			lst[i] = b.genes[i];
		}
		
		return lst;
	}
	
	
}
