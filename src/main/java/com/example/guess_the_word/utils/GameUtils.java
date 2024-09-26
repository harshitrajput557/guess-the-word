package com.example.guess_the_word.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.example.guess_the_word.services.GameService;

@Component
public class GameUtils {
	
	@Autowired
	ConfigurableApplicationContext applicationContext;
	private int MAX_TRIES = 5;
	
	
	public int reduceTry() {
		
		
		MAX_TRIES-=1;
		return MAX_TRIES;
	}
	public int getTriesReamaining() {
		
		return MAX_TRIES;
	}
	public void resetTry() {
		MAX_TRIES = 5;
	}
	
	public GameService reload() {
		GameService gameService = applicationContext.getBean(GameService.class); 
		return gameService;
	}
	

}
