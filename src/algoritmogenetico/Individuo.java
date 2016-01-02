package algoritmogenetico;

// genes ["A", "B", "F", "T"]
// com a letra inicial das cidades

// metodo importante
// get_distancia_percurso()
//   returna a distancia apara entre as cidade que estao no genes

public class Individuo {
	public String genes[];
	private Dados dados;
	int len_genes;
	
	// len quantidade de cidade no genes
	// ideal para ser chamado na primeira geracao
	public Individuo(int len) {
		dados = new Dados();

		genes = new String[len];// as string de genes vao ter tamanho 1
		len_genes = len;
		int i, max = len;
		
		int max_randomico = dados.quantidade;
		for(i=0; i<max; i++){
			genes[i] = Utils.at(dados.possiveis, Utils.rand(max_randomico));
		}
	}
	
	// ideal para ser chamada nas geracoes posteriores
	public Individuo(Individuo pai, Individuo mae) {
		assert pai.genes.length == mae.genes.length;
		dados = new Dados();
		len_genes = pai.len_genes;
		genes = crossover(pai, mae);
		mutacao();
	}
	
	public Double get_distancia_percurso(){
		int i, max = len_genes;
		Double count = 0.0;
		String chave_nome;
		for(i=0; i<max; i+=2){
			chave_nome = genes[i] + genes[i+1];
			count += dados.get_distancia(chave_nome);
		}
		
		return count;
	}
	
	// True se exite duas letras iguais nos genes
	public boolean repete(){
		
	}
	
	// seleciona uma gene aleatorio e subtitui por outra letra aleatoria
	public void mutacao(){
		int local = Utils.rand(len_genes);
		genes[local] = Utils.at(dados.possiveis, Utils.rand(dados.quantidade));
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
