package com.enp.blabber.api.utils;

import java.time.Clock;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class DataUtils {
	
	public LocalDateTime getTimeNow() {
		Clock cl = Clock.systemUTC(); 
		return LocalDateTime.now(cl);
	}

}
