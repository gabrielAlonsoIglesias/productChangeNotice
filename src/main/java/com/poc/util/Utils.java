package com.poc.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author galonsoi
 */
@Component("utils")
public class Utils {

	private static final Log LOG = LogFactory.getLog(Utils.class);

	private static final String EMPTY = "";	

	private Utils() {}

	public String concat(String... params) {
		StringBuilder result = new StringBuilder();
		for (String param : params) {
			result.append(param);
		}
		return result.toString();
	}

	public String toUpperCase(String str){
		String newStr = EMPTY;

		if (!StringUtils.isEmpty(str)) {
			newStr= str.toUpperCase();
		}

		return newStr;
	}

	public String replace(String str, String oldChars){
		String newStr = EMPTY;

		if (!StringUtils.isEmpty(str)) {
			newStr = str.replace(oldChars, EMPTY);
			newStr = newStr.trim();
		}

		return newStr;
	}

	public String trunc(String str, int limit) {
		if (!StringUtils.isEmpty(str) && limit <= str.length()) {
			return str.substring(0, limit);
		}
		return str;
	}

    public Float safeParseFloat(String strValue) {
    	Float fValue = null;

        if (!StringUtils.isEmpty(strValue)) {
            try {
            	fValue = Float.valueOf(strValue);
            } catch (NumberFormatException e) {
            	LOG.error("safeParseFloat # Error. Cause: " + e);
            }
        }
        return fValue;
    }

    public Integer safeParseInteger(String strValue) {
    	Integer iValue = null;

        if (!StringUtils.isEmpty(strValue)) {
            try {
            	iValue = Integer.valueOf(strValue);
            } catch (NumberFormatException e) {
            	LOG.error("safeParseInteger # Error. Cause: " + e);
            }
        }
        return iValue;
    }

}
