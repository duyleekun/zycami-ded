/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FuturesGetChecked;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidator;

public class FuturesGetChecked$GetCheckedTypeValidatorHolder {
    public static final FuturesGetChecked$GetCheckedTypeValidator BEST_VALIDATOR;
    public static final String CLASS_VALUE_VALIDATOR_NAME;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = FuturesGetChecked$GetCheckedTypeValidatorHolder.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append("$ClassValueValidator");
        CLASS_VALUE_VALIDATOR_NAME = stringBuilder.toString();
        BEST_VALIDATOR = FuturesGetChecked$GetCheckedTypeValidatorHolder.getBestValidator();
    }

    public static FuturesGetChecked$GetCheckedTypeValidator getBestValidator() {
        Object object;
        try {
            object = CLASS_VALUE_VALIDATOR_NAME;
        }
        catch (Throwable throwable) {
            return FuturesGetChecked.weakSetValidator();
        }
        object = Class.forName((String)object);
        object = object.getEnumConstants();
        object = object[0];
        return (FuturesGetChecked$GetCheckedTypeValidator)object;
    }
}

