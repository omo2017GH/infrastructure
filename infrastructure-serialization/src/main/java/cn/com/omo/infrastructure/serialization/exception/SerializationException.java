package cn.com.omo.infrastructure.serialization.exception;

import cn.com.omo.infrastructure.common.model.exception.InfrastructureException;

/**
 *
 * @date 2017年12月29日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class SerializationException extends InfrastructureException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5287190312667399686L;

    public SerializationException(String message) {
        super(message);
    }

    public SerializationException(String message, Throwable t) {
        super(message, t);
    }
}
