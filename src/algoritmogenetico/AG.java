package algoritmogenetico;


public class AG {
	public Individuo[] populacao;
	Dados dados;
	int quantidade = 40;
	int qnt_cidades = 8;

	public AG() {
		populacao = new Individuo[quantidade];
		dados = new Dados();
		// inicializa o array de Individuo
		int i;
		for(i=0; i<quantidade; i++){
			populacao[i] = new Individuo(qnt_cidades, dados);
		}
	}
	
	public Individuo get_mais_apto(Individuo lst[]){
		// o mais apto
		// nao repete letra
		// e tem o menor percurso
		
		return lst[get_indice_mais_apto(lst)];
		
	}
	
	public int get_indice_mais_apto(Individuo lst[]){
		// o mais apto
		// nao repete letra
		// e tem o menor percurso
		
		Double menor = 0.0, aux;
		int local_menor = -1, i, len = lst.length;
		Individuo tmp;
		
		for(i=0; i<len; i++){
			tmp = lst[i];
			if(tmp == null)continue;
			if(!tmp.repete()){// caso nao repita
				aux = tmp.get_distancia_percurso(dados);
				if(local_menor == -1 || aux <  menor){
					local_menor = i;
					menor = aux;
				}
			}
		}
		assert local_menor != -1;
		
		return local_menor;
		
	}
	
	// fazer
	
	// retorna dois individuos
	public Individuo[] torneio(){
		int qnt_torneio = 9;
		Individuo to_return[] = new Individuo[2];
		Individuo lst[] = new Individuo[qnt_torneio];
		
		int i;
		// seleciona qnt_torneio Individuos aleatoriamente
		for(i=0; i<qnt_torneio; i++){
			lst[i] = populacao[Utils.rand(quantidade)];
		}
		
		// seleciona os dois mais aptos para retornar
		
		int i1;
		i1 = get_indice_mais_apto(lst);
		to_return[0] = populacao[i1];
		lst[i1] = null;
		
		to_return[1] = get_mais_apto(lst);
		
		return to_return;
		
	}
	
	public void proxima_geracao(){
		Individuo prox_populacao[] = new Individuo[quantidade];
		int i;
		// preserva o mais apto
		prox_populacao[0] = get_mais_apto(populacao);
		
		for(i=1; i<quantidade; i++){
			prox_populacao[i] = new Individuo(torneio(), dados);
		}
		
		populacao = prox_populacao;
		
	}
	
	
}
