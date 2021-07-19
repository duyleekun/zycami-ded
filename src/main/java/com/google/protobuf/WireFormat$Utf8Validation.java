/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.WireFormat$1;
import com.google.protobuf.WireFormat$Utf8Validation$1;
import com.google.protobuf.WireFormat$Utf8Validation$2;
import com.google.protobuf.WireFormat$Utf8Validation$3;

public abstract class WireFormat$Utf8Validation
extends Enum {
    private static final /* synthetic */ WireFormat$Utf8Validation[] $VALUES;
    public static final /* enum */ WireFormat$Utf8Validation LAZY;
    public static final /* enum */ WireFormat$Utf8Validation LOOSE;
    public static final /* enum */ WireFormat$Utf8Validation STRICT;

    static {
        WireFormat$Utf8Validation$1 wireFormat$Utf8Validation$1 = new WireFormat$Utf8Validation$1();
        LOOSE = wireFormat$Utf8Validation$1;
        int n10 = 1;
        WireFormat$Utf8Validation$2 wireFormat$Utf8Validation$2 = new WireFormat$Utf8Validation$2();
        STRICT = wireFormat$Utf8Validation$2;
        int n11 = 2;
        WireFormat$Utf8Validation$3 wireFormat$Utf8Validation$3 = new WireFormat$Utf8Validation$3();
        LAZY = wireFormat$Utf8Validation$3;
        WireFormat$Utf8Validation[] wireFormat$Utf8ValidationArray = new WireFormat$Utf8Validation[3];
        wireFormat$Utf8ValidationArray[0] = wireFormat$Utf8Validation$1;
        wireFormat$Utf8ValidationArray[n10] = wireFormat$Utf8Validation$2;
        wireFormat$Utf8ValidationArray[n11] = wireFormat$Utf8Validation$3;
        $VALUES = wireFormat$Utf8ValidationArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private WireFormat$Utf8Validation() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ WireFormat$Utf8Validation(WireFormat$1 wireFormat$1) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static WireFormat$Utf8Validation valueOf(String string2) {
        return Enum.valueOf(WireFormat$Utf8Validation.class, string2);
    }

    public static WireFormat$Utf8Validation[] values() {
        return (WireFormat$Utf8Validation[])$VALUES.clone();
    }

    public abstract Object readString(CodedInputStream var1);
}

