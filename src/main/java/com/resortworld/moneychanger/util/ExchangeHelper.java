package com.resortworld.moneychanger.util;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class ExchangeHelper {

	private static Map<String,Double> exchangeRateMap;
	
	@PostConstruct
	public static void init() {
		exchangeRateMap = new HashMap<String, Double>();
		exchangeRateMap.put("SGDUSD", 0.742164);
		exchangeRateMap.put("USDSGD", 1.34782);
	}
	
	public static Map<String,Double> getMap() {
		return exchangeRateMap;
	}
	
}
