package cn.com.omo.infrastructure.validation.core.result;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @date 2017年12月7日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class SimpleMultiElementValidationResult implements MultiElementValidationResult {

    public SimpleMultiElementValidationResult() {
        this(true);
    }

    public SimpleMultiElementValidationResult(boolean pass) {
        super();
        setPass(pass);
        init();
    }

    /**
     * 
     */
    private static final long serialVersionUID = 5184869823724767583L;

    private boolean pass;

    private Map<String, String> illegalElements;

    /**
     * @see com.huifu.ubs.service.common.model.validation.result.MultiElementValidationResult#isPass()
     */
    @Override
    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.result.MultiElementValidationResult#getIllegalElements()
     */
    @Override
    public Map<String, String> getIllegalElements() {
        return illegalElements;
    }

    public void setIllegalElements(Map<String, String> illegalElements) {
        this.illegalElements = illegalElements;
    }

    public void addIllegalElement(String name, String value) {
        if (name == null) {
            return;
        }

        if (illegalElements == null) {
            init();
        }
        illegalElements.put(name, value);
    }

    protected void init() {
        illegalElements = new HashMap<String, String>();
    }
}
