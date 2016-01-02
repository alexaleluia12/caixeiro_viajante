package algoritmogenetico;

import java.util.HashMap;

public class Dados {
	
	// estrutura de dados para representar as cidades
	// um dicionario onde a chave AB -> distancia 
	// entre a cidade A e B e o valor seria a distancia
	
	HashMap<String, Double> cidades;
	String possiveis;
	int quantidade;
	
	public Dados() {
		// Eh importante que as cidades nao comecem com a mesma letra
		Cidade c1 = new Cidade("Bostom");
		Cidade c2 = new Cidade("New Work");
		Cidade c3 = new Cidade("São Francisco");
		Cidade c4 = new Cidade("Texturabos");
		Cidade c5 = new Cidade("Flores");
		Cidade c6 = new Cidade("Missa");
		Cidade c7 = new Cidade("Apucarana");
		Cidade c8 = new Cidade("Utha");
		
		possiveis = c1.letra + c2.letra + c3.letra + c4.letra + 
				c5.letra + c6.letra + c7.letra + c8.letra;
		
		quantidade = possiveis.length();
		
		// distancia entre c1 c2 ... c8
		// c2 ... c8
		cidades = new HashMap<String, Double>();
		// c1
		cidades.put(duas_letras(c1, c1), 0.0);
		cidades.put(duas_letras(c1, c2), 1.0);
		cidades.put(duas_letras(c1, c3), 2.0);
		cidades.put(duas_letras(c1, c4), 3.6);
		cidades.put(duas_letras(c1, c5), 2.1);
		cidades.put(duas_letras(c1, c6), 5.2);
		cidades.put(duas_letras(c1, c7), 7.0);
		cidades.put(duas_letras(c1, c8), 2.7);
		
		// c2
		cidades.put(duas_letras(c2, c2), 0.0);
		cidades.put(duas_letras(c2, c3), 2.0);
		cidades.put(duas_letras(c2, c4), 1.1);
		cidades.put(duas_letras(c2, c5), 5.7);
		cidades.put(duas_letras(c2, c6), 8.9);
		cidades.put(duas_letras(c2, c7), 4.5);
		cidades.put(duas_letras(c2, c8), 10.4);
		
		// c3
		cidades.put(duas_letras(c3, c3), 0.0);
		cidades.put(duas_letras(c3, c4), 6.8);
		cidades.put(duas_letras(c3, c5), 8.2);
		cidades.put(duas_letras(c3, c6), 3.1);
		cidades.put(duas_letras(c3, c7), 5.0);
		cidades.put(duas_letras(c3, c8), 3.9);
		
		// c4
		cidades.put(duas_letras(c4, c4), 0.0);
		cidades.put(duas_letras(c4, c5), 4.4);
		cidades.put(duas_letras(c4, c6), 1.2);
		cidades.put(duas_letras(c4, c7), 6.4);
		cidades.put(duas_letras(c4, c8), 9.3);
		
		// c5
		cidades.put(duas_letras(c5, c5), 0.0);
		cidades.put(duas_letras(c5, c6), 5.3);
		cidades.put(duas_letras(c5, c7), 1.2);
		cidades.put(duas_letras(c5, c8), 8.4);
		
		// c6
		cidades.put(duas_letras(c6, c6), 0.0);
		cidades.put(duas_letras(c6, c7), 4.8);
		cidades.put(duas_letras(c6, c8), 4.3);
		
		// c7
		cidades.put(duas_letras(c7, c7), 0.0);
		cidades.put(duas_letras(c7, c8), 4.8);
		
		// c8
		cidades.put(duas_letras(c8, c8), 0.0);
		
		
		
	}
	
	public String duas_letras(Cidade a, Cidade b){
		return a.letra + b.letra;
	}
	
	// recebe a letra das duas ciadades e retorna a distancia delas
	public Double get_distancia(String chave){
		Double t;
		if(cidades.containsKey(chave)){
			t = cidades.get(chave);
			assert(t != null);
			return t;
		} else{
			// o valor deve estar invertido AB -> BA
			String tmp = Utils.at(chave, 1) + Utils.at(chave, 0);
			t = cidades.get(tmp);
			assert(t != null);// -ea deve ser passado como parametro para vm
			return t;
		}
	}
	
}
