/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import java.util.Arrays;

public final class LottieResult {
    private final Throwable exception;
    private final Object value;

    public LottieResult(Object object) {
        this.value = object;
        this.exception = null;
    }

    public LottieResult(Throwable throwable) {
        this.exception = throwable;
        this.value = null;
    }

    public boolean equals(Object object) {
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof LottieResult;
        if (!bl3) {
            return false;
        }
        object = (LottieResult)object;
        Object object3 = this.getValue();
        if (object3 != null && (bl3 = (object3 = this.getValue()).equals(object2 = ((LottieResult)object).getValue()))) {
            return bl2;
        }
        Object object4 = this.getException();
        if (object4 != null && (object = ((LottieResult)object).getException()) != null) {
            object = this.getException().toString();
            object4 = this.getException().toString();
            return ((String)object).equals(object4);
        }
        return false;
    }

    public Throwable getException() {
        return this.exception;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        Object object = this.getValue();
        Object[] objectArray = new Object[]{object, object = this.getException()};
        return Arrays.hashCode(objectArray);
    }
}

