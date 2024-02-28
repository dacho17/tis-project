package com.tistask.popproducts.agents.interfaces;

import com.tistask.popproducts.dtos.HnbCurrencyResponse;

public interface IHnbAgent {
    HnbCurrencyResponse fetchExchangeRateEURUSD();
}
