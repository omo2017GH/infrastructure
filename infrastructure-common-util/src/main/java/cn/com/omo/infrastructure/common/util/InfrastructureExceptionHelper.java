package cn.com.omo.infrastructure.common.util;

import org.apache.commons.lang3.StringUtils;

import cn.com.omo.infrastructure.common.constant.CommonConstants;

/**
 *
 * @date 2017年12月29日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public class InfrastructureExceptionHelper extends CommonConstants {

    private static final String EXCODE = "code";
    private static final String EXMSG = "msg";

    public static final String CODE_00000 = "00000";
    public static final String MSG_00000 = "系统异常";

    public static final String buildExceptionMessage(String exCode, String exMsg, String message) {
        if (StringUtils.isBlank(exCode)) {
            exCode = CODE_00000;
        }

        if (StringUtils.isBlank(exMsg)) {
            exMsg = MSG_00000;
        }

        if (StringUtils.isBlank(message)) {
            message = StringUtils.EMPTY;
        }

        StringBuffer messageSbf = new StringBuffer();
        messageSbf.append(LEFT_BRACKET).append(EXCODE).append(EQUAL);
        messageSbf.append(exCode).append(COMMA).append(EXMSG).append(EQUAL).append(exMsg);
        messageSbf.append(RIGHT_BRACKET).append(BLANK).append(message);

        return messageSbf.toString();
    }
}
