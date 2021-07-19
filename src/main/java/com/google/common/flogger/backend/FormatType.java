/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.FormatType$1;
import com.google.common.flogger.backend.FormatType$2;
import com.google.common.flogger.backend.FormatType$3;
import com.google.common.flogger.backend.FormatType$4;
import com.google.common.flogger.backend.FormatType$5;

public abstract class FormatType
extends Enum {
    private static final /* synthetic */ FormatType[] $VALUES;
    public static final /* enum */ FormatType BOOLEAN;
    public static final /* enum */ FormatType CHARACTER;
    public static final /* enum */ FormatType FLOAT;
    public static final /* enum */ FormatType GENERAL;
    public static final /* enum */ FormatType INTEGRAL;
    private final boolean isNumeric;
    private final boolean supportsPrecision;

    static {
        int n10 = 1;
        FormatType$1 formatType$1 = new FormatType$1(false, n10 != 0);
        GENERAL = formatType$1;
        FormatType$2 formatType$2 = new FormatType$2(false, false);
        BOOLEAN = formatType$2;
        int n11 = 2;
        FormatType$3 formatType$3 = new FormatType$3(false, false);
        CHARACTER = formatType$3;
        int n12 = 3;
        FormatType$4 formatType$4 = new FormatType$4(n10 != 0, false);
        INTEGRAL = formatType$4;
        int n13 = 4;
        FormatType$5 formatType$5 = new FormatType$5(n10 != 0, n10 != 0);
        FLOAT = formatType$5;
        FormatType[] formatTypeArray = new FormatType[5];
        formatTypeArray[0] = formatType$1;
        formatTypeArray[n10] = formatType$2;
        formatTypeArray[n11] = formatType$3;
        formatTypeArray[n12] = formatType$4;
        formatTypeArray[n13] = formatType$5;
        $VALUES = formatTypeArray;
    }

    /*
     * WARNING - void declaration
     */
    private FormatType() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.isNumeric = var3_1;
        this.supportsPrecision = var4_2;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ FormatType(boolean bl2, boolean bl3, FormatType$1 formatType$1) {
        this((String)var1_-1, (int)(bl3 ? 1 : 0), (boolean)formatType$1, (boolean)var4_3);
        void var4_3;
        void var1_-1;
    }

    public static FormatType valueOf(String string2) {
        return Enum.valueOf(FormatType.class, string2);
    }

    public static FormatType[] values() {
        return (FormatType[])$VALUES.clone();
    }

    public abstract boolean canFormat(Object var1);

    public boolean isNumeric() {
        return this.isNumeric;
    }

    public boolean supportsPrecision() {
        return this.supportsPrecision;
    }
}

