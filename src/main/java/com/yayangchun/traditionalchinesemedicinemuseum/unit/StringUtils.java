package com.yayangchun.traditionalchinesemedicinemuseum.unit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * @author jihua.yuan
 */
public class StringUtils {
	private static final Logger logger = LoggerFactory.getLogger(StringUtils.class);

	/**
	 * 判断对象是否为空 User:T.L Description:
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		} else if (obj instanceof String && Objects.equals(String.valueOf(obj).trim(), "")) {
			return true;
		} else if (obj instanceof Boolean && !((Boolean) obj)) {
			return true;
		} else if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
			return true;
		} else if (obj instanceof Map && ((Map) obj).isEmpty()) {
			return true;
		} else if (obj instanceof Object[] && ((Object[]) obj).length == 0) {
			return true;
		}
		return false;
	}

    /**
     * 判断对象不为空
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

}
