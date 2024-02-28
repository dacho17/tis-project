package com.tistask.popproducts.agents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tistask.popproducts.agents.interfaces.IHnbAgent;
import com.tistask.popproducts.dtos.HnbCurrencyResponse;

@Component
public class HnbAgent implements IHnbAgent {
    private static final Logger logger = LoggerFactory.getLogger(HnbAgent.class);

    private static final String EUR_USD_URL = "https://api.hnb.hr/tecajn-eur/v3?valuta=USD";

    public HnbCurrencyResponse fetchExchangeRateEURUSD() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        try {
            logger.info("About to fetch EUR-USD exchange rate from HNB.");
            
            HttpEntity<String> request = new HttpEntity<>("parameters", headers);
            ResponseEntity<HnbCurrencyResponse[]> response =
                restTemplate.exchange(EUR_USD_URL, HttpMethod.GET, request, HnbCurrencyResponse[].class);
            HnbCurrencyResponse[] responseBody = response.getBody();

            if (responseBody.length <= 0) {
                logger.error("Exchange rate has not been received from HNB.");
                return null;    
            }

            logger.info("EUR-USD exchange rate response from HNB has been received. Response - [%s]", responseBody.toString());
            return responseBody[0];    
        } catch (Exception exc) {
            logger.error(String.format("An exeption has occurred while fetching EUR-USD exchange rate from HNB. Exception - [%s]", exc.getMessage()));
            return null;
        }            
    }
}
