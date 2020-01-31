package com.resortworld.moneychanger.dto;

public class ExchangeInfoDto {

	private String exchangeRate;

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getExchangedAmount() {
		return exchangedAmount;
	}

	public void setExchangedAmount(String exchangedAmount) {
		this.exchangedAmount = exchangedAmount;
	}

	private String exchangedAmount;

}
