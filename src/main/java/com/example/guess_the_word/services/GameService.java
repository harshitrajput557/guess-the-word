package com.example.guess_the_word.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class GameService {
	
	private String randomlyChosenWord = null;
	
	private String[] randomWords = {"mother","father","teacher","actor","hi","food","bgmi","machine"};
	
	private char[] allCharactersOfWord;
	
	        
	Random random = new Random(); 
	                                                                                                                                                                                             
	
	public GameService() {
		randomlyChosenWord = randomWords[random.nextInt(randomWords.length)];
		allCharactersOfWord = new char[randomlyChosenWord.length()];
		
	}


	@Override
	public String toString() {
		
		String ret = "";
		for(char c: allCharactersOfWord) {
			if(c == '\u0000') {
				ret = ret + "_ ";
			}
			
			else {
				ret = ret + c; 
			}
			
		}
		return ret;
	}


	public boolean addGuess(char guessedChar) {
		
		boolean isGuessCorrect = false;
		for(int i = 0; i < randomlyChosenWord.length(); i++) {
			if(guessedChar == randomlyChosenWord.charAt(i)) {
				allCharactersOfWord[i] = guessedChar;
				isGuessCorrect = true;
				
			}
			
		}
		return isGuessCorrect;
		
		
		
		
	}
	
public List<String> rejectedWords(char guessedChar) {
	List<String> rejectedList = new ArrayList<>();
	 String rej = "";
	 
	 int count = 0;
		
		
		for(int i = 0; i < randomlyChosenWord.length(); i++) {
			if(guessedChar != randomlyChosenWord.charAt(i)) {
				count++;
				
			}
		}
		if(count == randomlyChosenWord.length()) {
			rej = rej + guessedChar ;
			rejectedList.add(rej);
			
			
			
		}
		return rejectedList;
		
		
		
		
	}

//public boolean winGame() {
//	boolean gameWin = false;
//	int count = 0;
//	for(char c : allCharactersOfWord) {
//		if(c != '\u0000') {
//			count++;
//			
//			
//		}
//		
//	}
//	if(count == allCharactersOfWord.length) {
//		gameWin = true;
//	}
//	
//	return gameWin;
//}

	
	
	
	
	
	

}
