package com.sapient.metro.smartcard;

import com.spaient.metro.smartcard.report.STATION;

public interface ISmartCard {
SmartCard purchaseNewCard();
void handOver(SmartCard smartCard);
void swipeIN(SmartCard smartCard, STATION station);
SmartCard swipeOUT(SmartCard smartCard, STATION destStation, WEEK day);
}
