package com.poc.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author galonsoi
 */
public enum ETimeZones {

	/**
	 * EUROPE_MADRID
	 */
	EUROPE_MADRID("Europe/Madrid"),

	/**
	 * ATLANTIC_CANARY
	 */
	ATLANTIC_CANARY("Atlantic/Canary"),

	/**
	 * EUROPE_LISBON
	 */
	EUROPE_LISBON("Europe/Lisbon"),
  
	/**
	 * GMT
	 */
	GMT("GMT");

	private static Map<String, ETimeZones> map = new HashMap<>();

	private final String timeZone;

	static {
		for (ETimeZones timeZones : ETimeZones.values()) {
			ETimeZones.map.put(timeZones.timeZone, timeZones);
		}
	}

	private ETimeZones(String timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * Status code of an email
	 *
	 * @return Status code
	 */
	public String getTimeZone() {
		return this.timeZone;
	}

	/**
	 * String with the status code value
	 *
	 * @return String with the status code value
	 */
	public String getName() {
		return name();
	}

	/**
	 * Recupera un TimeZonesTypes a partir del código
	 *
	 * @param timeZone zona horaria
	 * @return TimeZonesTypes a partir del código
	 */
	public static ETimeZones get(String timeZone) {
		return ETimeZones.map.get(timeZone);
	}

}
