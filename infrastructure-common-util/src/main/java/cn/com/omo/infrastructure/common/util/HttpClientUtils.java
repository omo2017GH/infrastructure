package cn.com.omo.infrastructure.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import cn.com.omo.infrastructure.common.constant.CommonConstants;

/**
 *
 * @date 2017年12月27日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public class HttpClientUtils {

    public static final String GET_METHOD = "GET";
    public static final String POST_METHOD = "POST";

    public static final int HTTP_RESPONSE_CODE_200 = 200;

    private static final int INPUT_STREAM_END_SIGN = -1;
    private static final int CHAR_BUFFER_SIZE = 1024;

    public static String sendGetRequest(String uri, String data, String charset) {
        String newUri = null;
        if (StringUtils.isNotBlank(data)) {
            newUri = uri.concat(CommonConstants.QUESTION_MARK).concat(data);
        } else {
            newUri = uri;
        }

        return sendRequest(newUri, null, charset, GET_METHOD);
    }

    public static String sendPostRequest(String uri, String data, String charset) {
        return sendRequest(uri, data, charset, POST_METHOD);
    }

    private static String sendRequest(String uri, String data, String charset, String requestMethod)
            throws RuntimeException {
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = null;
        HttpURLConnection conn = null;
        OutputStreamWriter out = null;

        try {
            URL url = new URL(uri);

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(requestMethod);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setDefaultUseCaches(false);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(60000);

            if (requestMethod.equals(POST_METHOD) && data != null) {
                out = new OutputStreamWriter(conn.getOutputStream(), charset);
                out.write(data);
                out.flush();
            }

            int repCode = conn.getResponseCode();
            if (repCode == HTTP_RESPONSE_CODE_200) {
                int count = 0;
                char[] chBuffer = new char[CHAR_BUFFER_SIZE];
                BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
                while ((count = input.read(chBuffer)) != INPUT_STREAM_END_SIGN) {
                    buffer.append(chBuffer, 0, count);
                }
            } else {
                throw new Exception(String.format("The %s[URI: %s, DATA: %s] response CODE is [%s]",
                        requestMethod, uri, data, repCode));
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (reader != null) {
                    reader.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return buffer.toString();
    }

    public static String buildHttpRequestArgs(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return "";
        }

        StringBuilder sber = new StringBuilder();
        for (Entry<String, String> entry : params.entrySet()) {
            sber.append(entry.getKey()).append(CommonConstants.EQUAL).append(entry.getValue()).append(CommonConstants.AND);
        }

        String argsStr = sber.toString();
        if (argsStr.endsWith(CommonConstants.AND)) {
            argsStr = argsStr.substring(0, argsStr.length() - 1);
        }

        return argsStr;
    }
}
