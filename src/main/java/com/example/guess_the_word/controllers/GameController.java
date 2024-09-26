package com.example.guess_the_word.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.guess_the_word.services.GameService;
import com.example.guess_the_word.utils.GameUtils;

@Controller
public class GameController {
	
	@Autowired
	private GameService gameService; 
	
	@Autowired
	private GameUtils gameUtils; 
	@GetMapping("/home")
	public String showGameHomePage(@RequestParam(value = "guessedChar", required =   false) String guessedChar, Model model){
		
		System.out.println("guessed character is " + guessedChar);
		
		String randomWord = gameService.toString(); 
		  
		
		if(guessedChar != null) {
		boolean isGuessCorrect = gameService.addGuess(guessedChar.charAt(0));
		randomWord = gameService.toString();
		if(isGuessCorrect == false) {
			gameUtils.reduceTry();
			List<String> rejectedCharIs = gameService.rejectedWords(guessedChar.charAt(0));
			model.addAttribute("rejectedAlphabetList", rejectedCharIs);
  			
			
			
		}
		
		
		
		}
		
		System.out.println("no. of tries re4maining" + gameUtils.getTriesReamaining());
		model.addAttribute("wordToDisplay", randomWord);
		model.addAttribute("triesLeft", gameUtils.getTriesReamaining());

		return "game-home-page";
	}
	
	@GetMapping("/reload")
	public String reloadGame() {
		gameService = gameUtils.reload();
		gameUtils.resetTry();
		return "redirect:/home";
	}

}
   