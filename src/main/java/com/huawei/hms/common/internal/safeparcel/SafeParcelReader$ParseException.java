/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.huawei.hms.common.internal.safeparcel;

import android.os.Parcel;

public class SafeParcelReader$ParseException
extends RuntimeException {
    public SafeParcelReader$ParseException(String string2, Parcel parcel) {
        int n10 = String.valueOf(string2).length() + 41;
        StringBuffer stringBuffer = new StringBuffer(n10);
        stringBuffer.append(string2);
        stringBuffer.append(" Parcel: pos=");
        int n11 = parcel.dataPosition();
        stringBuffer.append(n11);
        stringBuffer.append(" size=");
        n11 = parcel.dataSize();
        stringBuffer.append(n11);
        string2 = stringBuffer.toString();
        super(string2);
    }
}

