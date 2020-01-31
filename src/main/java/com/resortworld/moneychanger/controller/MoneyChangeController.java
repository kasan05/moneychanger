package com.resortworld.moneychanger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.resortworld.moneychanger.dto.ExchangeInfoDto;
import com.resortworld.moneychanger.exception.ConverstionTypeNotFoundException;
import com.resortworld.moneychanger.service.MoneyExchangeService;
import com.resortworld.moneychanger.util.ExchangeHelper;

@RestController
@RequestMapping("/api")
public class MoneyChangeController {

	@Autowired
	private MoneyExchangeService moneyExchangeService;

	@Autowired
	ExchangeHelper exchangeHelper;
	
	
	@GetMapping("/exchage")
	public ResponseEntity<ExchangeInfoDto> changeMoney(@RequestParam("amount") double amount,
			@RequestParam("type") String type) throws Exception {
		
		if(!exchangeHelper.getMap().containsKey(type)) {
			throw new ConverstionTypeNotFoundException("Please try with some other Convertion Type");
		}
			
		ExchangeInfoDto exchangeInfoDto = moneyExchangeService.exchangeMoney(type, amount);
		return new ResponseEntity<ExchangeInfoDto>(exchangeInfoDto, HttpStatus.OK);

	}
}
