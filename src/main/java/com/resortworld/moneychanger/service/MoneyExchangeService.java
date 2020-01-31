package com.resortworld.moneychanger.service;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resortworld.moneychanger.dto.ExchangeInfoDto;
import com.resortworld.moneychanger.util.ExchangeHelper;



@Service
public class MoneyExchangeService {

	@Autowired
	private ExchangeHelper exchangeHelper;
	
	public ExchangeInfoDto exchangeMoney(String type,double amount) {
		ExchangeInfoDto exchangeInfoDto = new ExchangeInfoDto();

		Map<String, Double> map = exchangeHelper.getMap();
		Set<String> set = map.keySet();
		double exchangeRate = map.get(type);
		
		double exchangedAmount = exchangeRate * amount;
		exchangeInfoDto.setExchangedAmount(String.valueOf(exchangedAmount));
		exchangeInfoDto.setExchangeRate(String.valueOf(exchangeRate));
		return exchangeInfoDto;
	}
}
