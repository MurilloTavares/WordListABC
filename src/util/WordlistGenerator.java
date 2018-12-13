package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordlistGenerator {
	
	public static List<String> generate(int limit) {
		Character[] arrayA = {'0','1','2','3','4','5','6','7'};
		Character[] arrayB = {'a','e','i','o','u'};
		Character[] arrayC = {'b','c','d','f','g','h','j','l','m','n','p','q','r','s','t','v','x','z','k','y'};
				
		List<Character> conjuntoA = new ArrayList<>(Arrays.asList(arrayA));
		List<Character> conjuntoB = new ArrayList<>(Arrays.asList(arrayB));
		List<Character> conjuntoC = new ArrayList<>(Arrays.asList(arrayC));
		
		List<String> wordlist = new ArrayList<>();
		
		// Gerando silabas (par de consoante e vogal)
		for(Character c1: conjuntoC) {
			for(Character b1: conjuntoB) {
				
				// Silaba 1
				String s1 = c1.toString()+b1.toString();
				
				// Iteração continua com o resto das consoantes e vogais restantes
				List<Character> restanteC2 = restante(conjuntoC, c1);
				List<Character> restanteB2 = restante(conjuntoB, b1);
				
				for(Character c2: restanteC2) {
					for(Character b2: restanteB2) {
					
						// Silaba 2
						String s2 = c2.toString()+b2.toString();
						
						// Iteração continua com o resto das consoantes e vogais restantes
						List<Character> restanteC3 = restante(restanteC2, c2);
						List<Character> restanteB3 = restante(restanteB2, b2);
						
						
						for(Character c3: restanteC3) {
							for(Character b3: restanteB3) {
								
								// Silaba 3
								String s3 = c3.toString()+b3.toString();
								
								// Iterando sobre conjunto A
								// e pegando 2 números não repetidos
								for(Character a1c: conjuntoA) {
									List<Character> restanteA = restante(conjuntoA, a1c);
									for(Character a2c: restanteA) {
									
										String a1 = a1c.toString();
										String a2 = a2c.toString();
										
										// Formando words com as 10 posições diferente para a1 e a2
										wordlist.add(a1+ a2+ s1+s2+s3);
										wordlist.add(a1 +s1+ a2 +s2+s3);
										wordlist.add(a1 +s1+s2+ a2 +s3);
										wordlist.add(a1 +s1+s2+s3+ a2);
										wordlist.add(s1+ a1+ a2 +s2+s3);
										wordlist.add(s1+ a1 +s2+ a2 +s3);
										wordlist.add(s1+ a1 +s2+s3+ a2);
										wordlist.add(s1+s2+ a1+ a2 +s3);
										wordlist.add(s1+s2+ a1 +s3 +a2);
										wordlist.add(s1+s2+s3+ a1+ a2);
										
										// encerrando wordlist caso ultrapasse o limite
										if(wordlist.size() >= limit) return wordlist;
									}
								}
							}
						}
					}					
				}
			}
		}		
		return wordlist;
	}
	
	private static List<Character> restante(List<Character> lista, Character excecao){
		List<Character> novaLista = new ArrayList<>(lista);
		novaLista.remove(excecao);
		return novaLista;
	}

}
