package com.poc.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Component;

import com.poc.domain.ETimeZones;


/**
 * @author galonsoi
 */
@Component("dateUtils")
public class DateUtils {

	private DateUtils() {}

	public LocalDateTime getCurrentLocalDateTime() {
		return ZonedDateTime.now(ZoneId.of(ETimeZones.EUROPE_MADRID.getTimeZone())).toLocalDateTime();
	}
  
	public LocalDateTime getCurrentLocalDateTime(ETimeZones timeZone) {
		return ZonedDateTime.now(ZoneId.of(timeZone.getTimeZone())).toLocalDateTime();
	}

	public LocalDateTime getCurrentLocalDateTime(LocalDateTime localDateTime, ETimeZones timeZoneOld, ETimeZones timeZoneResult) {
		return localDateTime.atZone(ZoneId.of(timeZoneOld.getTimeZone()))
							.withZoneSameInstant(ZoneId.of(timeZoneResult.getTimeZone()))
							.toLocalDateTime();
	}
  
	public LocalDateTime getCurrentLocalDateTime(LocalDateTime localDateTime) {
		return getCurrentLocalDateTime(localDateTime, ETimeZones.GMT, ETimeZones.EUROPE_MADRID);
	}

	public LocalDate getDefaultCurrentLocalDate() {
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
		return zonedDateTime.toLocalDate();
	}

}
