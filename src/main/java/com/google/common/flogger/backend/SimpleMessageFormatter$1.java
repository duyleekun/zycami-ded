/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.FormatChar;

public class SimpleMessageFormatter$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$common$flogger$backend$FormatChar;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        FormatChar formatChar;
        int n12 = FormatChar.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$common$flogger$backend$FormatChar = nArray;
        try {
            formatChar = FormatChar.STRING;
            n11 = formatChar.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$common$flogger$backend$FormatChar;
            formatChar = FormatChar.DECIMAL;
            n11 = formatChar.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$common$flogger$backend$FormatChar;
            formatChar = FormatChar.BOOLEAN;
            n11 = formatChar.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$common$flogger$backend$FormatChar;
            formatChar = FormatChar.HEX;
            n11 = formatChar.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$common$flogger$backend$FormatChar;
            formatChar = FormatChar.CHAR;
            n11 = formatChar.ordinal();
            nArray[n11] = n10 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

