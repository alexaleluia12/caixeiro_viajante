package algoritmogenetico;

// a solucao do problema nao pode ter duas cidades no array de solucao
// considera e todas estao ligadas com todas

public class Main {
	public static void main(String[] args) {
		AG ag = new AG();
		
		Individuo e;
		Double dist_anterior;
		int epocas = 0;
		
		e = ag.populacao[0];
		System.out.println(e.get_distancia_percurso(ag.dados));
		System.out.println(Utils.join_interable(e.genes, ","));
		System.out.println(e.repete());
		
//		// saber quando nao repetiram
//		int c = 0, i;
//		for(i=0; i<ag.quantidade; i++){
//			e  = ag.populacao[i];
//			if(e.repete()){
//				c++;
//			}
//		}
//		System.out.println("Quantidade de repetidos: " + c);
		
//		while(true){
//			System.out.println(epocas);
//			e = ag.get_mais_apto(ag.populacao);
//			
//			ag.proxima_geracao();
//			if(e.get_distancia_percurso(ag.dados) == 0.0){
//				System.out.println(Utils.join_interable(e.genes, ","));
//				break;
//			}
//			epocas++;
//			if(epocas == 10)break;
//			
//		}
//		System.out.println("> " + e.get_distancia_percurso(ag.dados));
//		
		
	}
}
