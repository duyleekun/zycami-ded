/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$MapAdapter$Converter;

public final class Internal$MapAdapter$1
implements Internal$MapAdapter$Converter {
    public final /* synthetic */ Internal$EnumLiteMap val$enumMap;
    public final /* synthetic */ Internal$EnumLite val$unrecognizedValue;

    public Internal$MapAdapter$1(Internal$EnumLiteMap internal$EnumLiteMap, Internal$EnumLite internal$EnumLite) {
        this.val$enumMap = internal$EnumLiteMap;
        this.val$unrecognizedValue = internal$EnumLite;
    }

    public Integer doBackward(Internal$EnumLite internal$EnumLite) {
        return internal$EnumLite.getNumber();
    }

    public Internal$EnumLite doForward(Integer object) {
        Internal$EnumLiteMap internal$EnumLiteMap = this.val$enumMap;
        int n10 = (Integer)object;
        if ((object = internal$EnumLiteMap.findValueByNumber(n10)) == null) {
            object = this.val$unrecognizedValue;
        }
        return object;
    }
}

