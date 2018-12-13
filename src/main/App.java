package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.WordlistGenerator;

public class App {
	
	public static void main(String[] args) {
		
		List<String> wordlist = WordlistGenerator.generate(10000);		
		printList(wordlist);
		System.out.println("WORDLIST SIZE: " + wordlist.size());
		
	}	
	
	private static void printList(List<String> wordlist) {
		int count = 1;
		for(String word : wordlist) {
			System.out.print(word+" ");
			count++;
			if(count > 14) {
				System.out.println();
				count = 1;
			}
		}
		System.out.println();
	}
}
