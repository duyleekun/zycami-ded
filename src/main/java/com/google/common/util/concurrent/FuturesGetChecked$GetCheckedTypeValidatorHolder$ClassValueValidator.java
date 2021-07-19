/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidator;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator$1;

public final class FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator
extends Enum
implements FuturesGetChecked$GetCheckedTypeValidator {
    private static final /* synthetic */ FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator[] $VALUES;
    public static final /* enum */ FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator INSTANCE;
    private static final ClassValue isValidClass;

    static {
        Object object = new FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator("INSTANCE", 0);
        INSTANCE = object;
        FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator[] futuresGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidatorArray = new FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator[]{object};
        $VALUES = futuresGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidatorArray;
        isValidClass = object = new FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator$1();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator() {
        void var2_-1;
        void var1_-1;
    }

    public static FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator valueOf(String string2) {
        return Enum.valueOf(FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator.class, string2);
    }

    public static FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator[] values() {
        return (FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator[])$VALUES.clone();
    }

    public void validateClass(Class clazz) {
        isValidClass.get(clazz);
    }
}

