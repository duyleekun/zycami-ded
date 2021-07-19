/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.FormatOptions;
import com.google.common.flogger.backend.FormatType;

public final class FormatChar
extends Enum {
    private static final /* synthetic */ FormatChar[] $VALUES;
    public static final /* enum */ FormatChar BOOLEAN;
    public static final /* enum */ FormatChar CHAR;
    public static final /* enum */ FormatChar DECIMAL;
    public static final /* enum */ FormatChar EXPONENT;
    public static final /* enum */ FormatChar EXPONENT_HEX;
    public static final /* enum */ FormatChar FLOAT;
    public static final /* enum */ FormatChar GENERAL;
    public static final /* enum */ FormatChar HEX;
    private static final FormatChar[] MAP;
    public static final /* enum */ FormatChar OCTAL;
    public static final /* enum */ FormatChar STRING;
    private final int allowedFlags;
    private final String defaultFormatString;
    private final char formatChar;
    private final FormatType type;

    static {
        FormatChar formatChar;
        FormatChar formatChar2;
        FormatChar formatChar3;
        FormatChar formatChar42;
        FormatChar formatChar5;
        FormatChar[] formatCharArray;
        Enum enum_ = FormatType.GENERAL;
        char c10 = 's';
        FormatChar[] formatCharArray2 = formatCharArray;
        formatCharArray = new FormatChar("STRING", 0, c10, (FormatType)enum_, "-#", true);
        STRING = formatCharArray;
        FormatType formatType = FormatType.BOOLEAN;
        formatCharArray2 = new FormatChar("BOOLEAN", 1, 'b', formatType, "-", true);
        BOOLEAN = formatCharArray2;
        FormatType formatType2 = FormatType.CHARACTER;
        Enum enum_2 = formatChar5;
        CHAR = formatChar5 = new FormatChar("CHAR", 2, 'c', formatType2, "-", true);
        FormatChar[] formatCharArray3 = FormatType.INTEGRAL;
        formatType = formatCharArray3;
        DECIMAL = formatChar42 = new FormatChar("DECIMAL", 3, 'd', (FormatType)formatCharArray3, "-0+ ,", false);
        OCTAL = enum_ = new FormatChar("OCTAL", 4, 'o', (FormatType)formatCharArray3, "-#0", false);
        boolean bl2 = true;
        HEX = formatChar3 = new FormatChar("HEX", 5, 'x', (FormatType)formatCharArray3, "-#0", bl2);
        FormatChar[] formatCharArray4 = FormatType.FLOAT;
        int n10 = 6;
        char c11 = 'f';
        String string2 = "-#0+ ,";
        enum_2 = formatCharArray3;
        formatType2 = formatCharArray4;
        formatCharArray3 = new FormatChar("FLOAT", n10, c11, (FormatType)formatCharArray4, string2, false);
        FLOAT = formatCharArray3;
        formatType = formatCharArray4;
        EXPONENT = enum_2 = new FormatChar("EXPONENT", 7, 'e', (FormatType)formatCharArray4, "-#0+ ", bl2);
        GENERAL = formatChar2 = new FormatChar("GENERAL", 8, 'g', (FormatType)formatCharArray4, "-0+ ,", bl2);
        String string3 = "EXPONENT_HEX";
        int n11 = 9;
        char c12 = 'a';
        String string4 = "-#0+ ";
        EXPONENT_HEX = formatChar = new FormatChar(string3, n11, c12, (FormatType)formatCharArray4, string4, bl2);
        int n12 = 10;
        formatCharArray4 = new FormatChar[n12];
        formatCharArray4[0] = formatCharArray;
        int n13 = 1;
        formatCharArray4[n13] = formatCharArray2;
        formatCharArray4[2] = formatChar5;
        formatCharArray4[3] = formatChar42;
        formatCharArray4[4] = enum_;
        formatCharArray4[5] = formatChar3;
        formatCharArray4[6] = formatCharArray3;
        formatCharArray4[7] = enum_2;
        formatCharArray4[8] = formatChar2;
        formatCharArray4[9] = formatChar;
        $VALUES = formatCharArray4;
        int n14 = 26;
        MAP = new FormatChar[n14];
        for (FormatChar formatChar42 : FormatChar.values()) {
            formatCharArray3 = MAP;
            int n15 = FormatChar.indexOf(formatChar42.getChar());
            formatCharArray3[n15] = formatChar42;
        }
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FormatChar(String string2, boolean bl2) {
        void var6_4;
        void var5_3;
        int n10;
        void var2_-1;
        void var1_-1;
        this.formatChar = (char)string2;
        this.type = (FormatType)bl2;
        this.allowedFlags = n10 = FormatOptions.parseValidFlags((String)var5_3, (boolean)var6_4);
        CharSequence charSequence = new StringBuilder();
        charSequence.append("%");
        charSequence.append((char)string2);
        charSequence = charSequence.toString();
        this.defaultFormatString = charSequence;
    }

    private boolean hasUpperCaseVariant() {
        int n10 = this.allowedFlags & 0x80;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    private static int indexOf(char c10) {
        return (c10 | 0x20) + -97;
    }

    private static boolean isLowerCase(char c10) {
        c10 = (c10 = (char)(c10 & 0x20)) != '\u0000' ? (char)'\u0001' : '\u0000';
        return c10 != 0;
    }

    public static FormatChar of(char c10) {
        Object object = MAP;
        int n10 = FormatChar.indexOf(c10);
        object = object[n10];
        if ((c10 = (char)(FormatChar.isLowerCase(c10) ? 1 : 0)) != '\u0000') {
            return object;
        }
        if (object == null || (c10 = (char)(super.hasUpperCaseVariant() ? 1 : 0)) == '\u0000') {
            object = null;
        }
        return object;
    }

    public static FormatChar valueOf(String string2) {
        return Enum.valueOf(FormatChar.class, string2);
    }

    public static FormatChar[] values() {
        return (FormatChar[])$VALUES.clone();
    }

    public int getAllowedFlags() {
        return this.allowedFlags;
    }

    public char getChar() {
        return this.formatChar;
    }

    public String getDefaultFormatString() {
        return this.defaultFormatString;
    }

    public FormatType getType() {
        return this.type;
    }
}

