package com.smalltalk.content.center;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @author OneBoA
 */
@Slf4j
public class SignUtil {


    private static final int TIME_OUT = 600;
    public static final String TIMESTAMP = "timestamp";
    public static final String SIGN = "sign";
    public static final String APP_ID = "app_id";
    public static final String NULL = "null";
    private static final List<String> IGNORE_LIST = Arrays.asList(SIGN, APP_ID, TIMESTAMP);

    /**
     * 将有序map 所有参数Keys按字母序排序，将所有Key对应的值使用“:”拼接，得到values
     * sign = MD5(values + ":" + timestamp + ":" + appSecret)
     * MD5使用32大写字母
     *
     * @param map
     * @param secret
     * @return
     */
    public static String sign(Map<String, String> map, String secret) {
        log.info("sign.start");
        validate(map);

        StringBuilder sb = new StringBuilder();
        map.forEach((k, v) -> {
            if (StringUtils.isNotBlank(v) && !container(k)) {
                sb.append(v).append(":");
            }
        });
        sb.append(map.get(TIMESTAMP)).append(":").append(secret);

        log.info("sign.secret: {}", sb);
        return DigestUtils.md5Hex(sb.toString()).toUpperCase();
    }

    private static void validate(Map<String, String> map) {
        long curTime = System.currentTimeMillis();

        String timeStr = map.get(TIMESTAMP);
        if (StringUtils.isBlank(timeStr)) {
            throw new RuntimeException("参数错误，参数缺失或者格式不对.");
        }

        long timestamp = Long.valueOf(timeStr);

        Calendar calAfter = Calendar.getInstance();
        calAfter.setTimeInMillis(curTime);
        calAfter.set(Calendar.SECOND, calAfter.get(Calendar.SECOND) + TIME_OUT);

        Calendar calBefore = Calendar.getInstance();
        calBefore.setTimeInMillis(curTime);
        calBefore.set(Calendar.SECOND, calBefore.get(Calendar.SECOND) - TIME_OUT);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp * 1000);

        log.info("validate.timestamp: {}, {}, {}", calendar.getTime().getTime(), calAfter.getTime().getTime(), calBefore.getTime().getTime());
        if (!(calendar.before(calAfter) && calendar.after(calBefore))) {
            throw new RuntimeException("时间戳错误，时间戳缺失或者时间戳偏差超过10分钟.");
        }
    }

    private static boolean container(String key) {
        return IGNORE_LIST.contains(key);
    }

}