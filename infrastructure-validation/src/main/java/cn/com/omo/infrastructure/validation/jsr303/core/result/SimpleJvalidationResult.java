/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.jsr303.core.result;

import java.util.HashMap;
import java.util.Map;

import cn.com.omo.infrastructure.validation.core.result.SimpleMultiElementValidationResult;

/**
 *
 * @date 2017年12月8日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class SimpleJvalidationResult extends SimpleMultiElementValidationResult implements JvalidationResult {

    public SimpleJvalidationResult() {
        this(true);
    }
    
    public SimpleJvalidationResult(boolean pass) {
        super(pass);
    }
    
    /**
     * 
     */
    private static final long serialVersionUID = 8952301551882951324L;

    private Map<String, String> illegalElementMessages;

    /**
     * @see com.huifu.ubs.service.common.model.validation.result.ValidationMessage#getIllegalElementMessages()
     */
    @Override
    public Map<String, String> getIllegalElementMessages() {
        return illegalElementMessages;
    }

    public void setIllegalElementMessages(Map<String, String> illegalElementMessages) {
        this.illegalElementMessages = illegalElementMessages;
    }

    public void addIllegalElementMessage(String name, String message) {
        if (name == null) {
            return;
        }

        if (illegalElementMessages == null) {
            init();
        }
        illegalElementMessages.put(name, message);
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.result.SimpleMultiElementValidationResult#init()
     */
    @Override
    protected void init() {
        super.init();
        illegalElementMessages = new HashMap<String, String>();
    }
}
