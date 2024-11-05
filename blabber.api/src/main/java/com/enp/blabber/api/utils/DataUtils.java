package com.enp.blabber.api.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.stereotype.Service;

@Service
public class DataUtils {
	
	public LocalDateTime getTimeNow() {
		ZoneId colombiaZone = ZoneId.of("America/Bogota");
		return LocalDateTime.now(colombiaZone);
	}

}
