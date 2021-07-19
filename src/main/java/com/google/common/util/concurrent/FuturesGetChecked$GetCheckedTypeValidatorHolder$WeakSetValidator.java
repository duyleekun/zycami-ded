/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FuturesGetChecked;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidator;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator
extends Enum
implements FuturesGetChecked$GetCheckedTypeValidator {
    private static final /* synthetic */ FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator[] $VALUES;
    public static final /* enum */ FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator INSTANCE;
    private static final Set validClasses;

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet("INSTANCE", 0);
        INSTANCE = copyOnWriteArraySet;
        FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator[] futuresGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidatorArray = new FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator[]{copyOnWriteArraySet};
        $VALUES = futuresGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidatorArray;
        validClasses = copyOnWriteArraySet = new CopyOnWriteArraySet();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator() {
        void var2_-1;
        void var1_-1;
    }

    public static FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator valueOf(String string2) {
        return Enum.valueOf(FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator.class, string2);
    }

    public static FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator[] values() {
        return (FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator[])$VALUES.clone();
    }

    public void validateClass(Class clazz) {
        Object object;
        int n10;
        Object object2 = validClasses.iterator();
        while ((n10 = object2.hasNext()) != 0) {
            object = ((WeakReference)object2.next()).get();
            n10 = (int)(clazz.equals(object) ? 1 : 0);
            if (n10 == 0) continue;
            return;
        }
        FuturesGetChecked.checkExceptionClassValidity(clazz);
        object2 = validClasses;
        n10 = object2.size();
        int n11 = 1000;
        if (n10 > n11) {
            object2.clear();
        }
        object = new Object((Class)clazz);
        object2.add(object);
    }
}

