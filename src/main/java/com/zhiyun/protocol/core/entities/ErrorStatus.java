/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import java.util.Objects;

public final class ErrorStatus {
    public boolean axislock;
    public boolean bit0;
    public boolean bit1;
    public boolean bit2;
    public boolean bit3;
    public final int code;
    public boolean lowpos;
    public boolean noload;
    public boolean overheat;

    public ErrorStatus(int n10) {
        this.code = n10;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<ErrorStatus> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = ErrorStatus.class) == (clazz = object.getClass())) {
            object = (ErrorStatus)object;
            int n10 = this.code;
            int n11 = ((ErrorStatus)object).code;
            if (n10 != n11) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Object[] objectArray = new Object[1];
        Integer n10 = this.code;
        objectArray[0] = n10;
        return Objects.hash(objectArray);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ErrorStatus{code=");
        int bl2 = this.code;
        stringBuilder.append(bl2);
        stringBuilder.append(", axislock=");
        boolean bl3 = this.axislock;
        stringBuilder.append(bl3);
        stringBuilder.append(", overheat=");
        boolean bl4 = this.overheat;
        stringBuilder.append(bl4);
        stringBuilder.append(", lowpos=");
        boolean bl5 = this.lowpos;
        stringBuilder.append(bl5);
        stringBuilder.append(", noload=");
        boolean bl6 = this.noload;
        stringBuilder.append(bl6);
        stringBuilder.append(", bit3=");
        boolean bl7 = this.bit3;
        stringBuilder.append(bl7);
        stringBuilder.append(", bit2=");
        boolean bl8 = this.bit2;
        stringBuilder.append(bl8);
        stringBuilder.append(", bit1=");
        boolean bl9 = this.bit1;
        stringBuilder.append(bl9);
        stringBuilder.append(", bit0=");
        boolean bl10 = this.bit0;
        stringBuilder.append(bl10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

