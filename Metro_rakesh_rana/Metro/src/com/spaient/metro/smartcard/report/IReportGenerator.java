package com.spaient.metro.smartcard.report;

import com.sapient.metro.smartcard.SmartCard;

public interface IReportGenerator {
String getPerCardReport(SmartCard card);
Integer getTotalFootFall(STATION station);
}
