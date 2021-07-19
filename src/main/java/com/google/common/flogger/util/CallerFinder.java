/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.util;

import com.google.common.flogger.util.Checks;
import com.google.common.flogger.util.FastStackGetter;

public final class CallerFinder {
    private static final FastStackGetter stackGetter = FastStackGetter.createIfSupported();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static StackTraceElement findCallerOf(Class serializable, Throwable object, int n10) {
        Checks.checkNotNull(serializable, "target");
        Object object2 = "throwable";
        Checks.checkNotNull(object, (String)object2);
        if (n10 < 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("skip count cannot be negative: ");
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            serializable = new IllegalArgumentException((String)object);
            throw serializable;
        }
        object2 = stackGetter;
        object2 = object2 != null ? null : ((Throwable)object).getStackTrace();
        boolean bl2 = false;
        try {
            while (true) {
                String string3;
                Object object3;
                object3 = (object3 = stackGetter) != null ? ((FastStackGetter)object3).getStackTraceElement((Throwable)object, n10) : object2[n10];
                String string2 = ((Class)serializable).getName();
                boolean bl3 = string2.equals(string3 = ((StackTraceElement)object3).getClassName());
                if (bl3) {
                    bl2 = true;
                } else if (bl2) {
                    return object3;
                }
                ++n10;
            }
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static StackTraceElement[] getStackForCallerOf(Class serializable, Throwable object, int n10) {
        StackTraceElement[] stackTraceElementArray;
        int n11;
        Checks.checkNotNull(serializable, "target");
        Object object2 = "throwable";
        Checks.checkNotNull(object, (String)object2);
        if (n10 <= 0 && n10 != (n11 = -1)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("invalid maximum depth: ");
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            serializable = new IllegalArgumentException((String)object);
            throw serializable;
        }
        object2 = stackGetter;
        if (object2 != null) {
            stackTraceElementArray = null;
            n11 = ((FastStackGetter)object2).getStackTraceDepth((Throwable)object);
        } else {
            stackTraceElementArray = ((Throwable)object).getStackTrace();
            n11 = stackTraceElementArray.length;
        }
        int n12 = 0;
        int n13 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object3 = stackGetter;
            object3 = object3 != null ? ((FastStackGetter)object3).getStackTraceElement((Throwable)object, i10) : stackTraceElementArray[i10];
            String string2 = ((Class)serializable).getName();
            String string3 = ((StackTraceElement)object3).getClassName();
            boolean bl2 = string2.equals(string3);
            int n14 = 1;
            if (bl2) {
                n13 = n14;
                continue;
            }
            if (n13 == 0) continue;
            if (n10 <= 0 || n10 >= (n11 -= i10)) {
                n10 = n11;
            }
            serializable = new StackTraceElement[n10];
            serializable[0] = object3;
            while (n14 < n10) {
                object2 = stackGetter;
                if (object2 != null) {
                    n12 = i10 + n14;
                    object2 = ((FastStackGetter)object2).getStackTraceElement((Throwable)object, n12);
                } else {
                    n11 = i10 + n14;
                    object2 = stackTraceElementArray[n11];
                }
                serializable[n14] = object2;
                ++n14;
            }
            return serializable;
        }
        return new StackTraceElement[0];
    }
}

