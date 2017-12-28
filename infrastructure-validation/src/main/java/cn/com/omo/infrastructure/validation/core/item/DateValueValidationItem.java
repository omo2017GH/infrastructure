package cn.com.omo.infrastructure.validation.core.item;

import java.text.SimpleDateFormat;

import cn.com.omo.infrastructure.common.util.date.DateFormatUtils;

/**
 *
 * @date 2017年11月29日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class DateValueValidationItem extends BaseStringValidationItem<String> {

    public DateValueValidationItem(String itemValue) {
        super(itemValue);
    }

    @Override
    protected boolean checkData(String data) {
        String dateFormatPattern = getItemValue();
        if (dateFormatPattern.length() != data.toString().length()) {
            return false;
        }

        SimpleDateFormat simpleDateFormat = DateFormatUtils.getSimpleDateFormat(dateFormatPattern);
        if (simpleDateFormat == null) {
            simpleDateFormat = DateFormatUtils.getSimpleDateFormat(DateFormatUtils.DEFAULT_PATTERN);
        }

        try {
            simpleDateFormat.parse(data.toString());
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
