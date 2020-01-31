package com.resortworld.moneychanger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.resortworld.moneychanger.dto.ExchangeInfoDto;
import com.resortworld.moneychanger.service.MoneyExchangeService;
import com.resortworld.moneychanger.util.ExchangeHelper;

@SpringBootTest
class MoneychangerApplicationTests {

	@Autowired
	private MoneyExchangeService moneyExchangeService; 

	@Autowired
	private ExchangeHelper exchangeHelper;
	
	private MockMvc mockMvc;
	
	@Test
	void testExchangeMoney() {
		
		double amount = 2.0;
		ExchangeInfoDto exchangeInfoDto = moneyExchangeService.exchangeMoney("SGDUSD", amount);
		String rate = exchangeInfoDto.getExchangeRate();
		String exhnagedAmount = exchangeInfoDto.getExchangedAmount();
		
		double expectedRate = exchangeHelper.getMap().get("SGDUSD");
		
		assertThat(rate.equals(String.valueOf(expectedRate)));
		assertThat(exhnagedAmount.equals(String.valueOf(expectedRate*amount)));
		
	}
	
//	@Test
//	void testChangeMoney() throws Exception{
//		
//		mockMvc.perform(get("/api/exchage?amount=2.5&&type=USDSGD")).andExpect(status().isOk());  
//  
//	}
	
}
