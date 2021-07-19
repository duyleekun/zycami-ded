/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Preconditions;

public final class Ascii {
    public static final byte ACK = 6;
    public static final byte BEL = 7;
    public static final byte BS = 8;
    public static final byte CAN = 24;
    private static final char CASE_MASK = ' ';
    public static final byte CR = 13;
    public static final byte DC1 = 17;
    public static final byte DC2 = 18;
    public static final byte DC3 = 19;
    public static final byte DC4 = 20;
    public static final byte DEL = 127;
    public static final byte DLE = 16;
    public static final byte EM = 25;
    public static final byte ENQ = 5;
    public static final byte EOT = 4;
    public static final byte ESC = 27;
    public static final byte ETB = 23;
    public static final byte ETX = 3;
    public static final byte FF = 12;
    public static final byte FS = 28;
    public static final byte GS = 29;
    public static final byte HT = 9;
    public static final byte LF = 10;
    public static final char MAX = '\u007f';
    public static final char MIN = '\u0000';
    public static final byte NAK = 21;
    public static final byte NL = 10;
    public static final byte NUL = 0;
    public static final byte RS = 30;
    public static final byte SI = 15;
    public static final byte SO = 14;
    public static final byte SOH = 1;
    public static final byte SP = 32;
    public static final byte SPACE = 32;
    public static final byte STX = 2;
    public static final byte SUB = 26;
    public static final byte SYN = 22;
    public static final byte US = 31;
    public static final byte VT = 11;
    public static final byte XOFF = 19;
    public static final byte XON = 17;

    private Ascii() {
    }

    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        int n10 = charSequence.length();
        boolean bl2 = true;
        if (charSequence == charSequence2) {
            return bl2;
        }
        int n11 = charSequence2.length();
        if (n10 != n11) {
            return false;
        }
        for (n11 = 0; n11 < n10; ++n11) {
            int n12;
            int n13;
            int n14 = charSequence.charAt(n11);
            if (n14 == (n13 = charSequence2.charAt(n11)) || (n14 = Ascii.getAlphaIndex((char)n14)) < (n12 = 26) && n14 == (n13 = Ascii.getAlphaIndex((char)n13))) {
                continue;
            }
            return false;
        }
        return bl2;
    }

    private static int getAlphaIndex(char c10) {
        return (char)((c10 | 0x20) + -97);
    }

    public static boolean isLowerCase(char n10) {
        int n11 = 97;
        n10 = n10 >= n11 && n10 <= (n11 = 122) ? 1 : 0;
        return n10 != 0;
    }

    public static boolean isUpperCase(char n10) {
        int n11 = 65;
        n10 = n10 >= n11 && n10 <= (n11 = 90) ? 1 : 0;
        return n10 != 0;
    }

    public static char toLowerCase(char c10) {
        boolean bl2 = Ascii.isUpperCase(c10);
        if (bl2) {
            c10 = (char)(c10 ^ 0x20);
        }
        return c10;
    }

    public static String toLowerCase(CharSequence charSequence) {
        int n10 = charSequence instanceof String;
        if (n10 != 0) {
            return Ascii.toLowerCase((String)charSequence);
        }
        n10 = charSequence.length();
        char[] cArray = new char[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10;
            cArray[i10] = c10 = Ascii.toLowerCase(charSequence.charAt(i10));
        }
        return String.valueOf(cArray);
    }

    public static String toLowerCase(String object) {
        int n10 = ((String)object).length();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = Ascii.isUpperCase(((String)object).charAt(i10));
            if (!object2) continue;
            object = ((String)object).toCharArray();
            while (i10 < n10) {
                object2 = object[i10];
                boolean bl2 = Ascii.isUpperCase((char)object2);
                if (bl2) {
                    object2 = (char)(object2 ^ 0x20);
                    object[i10] = object2;
                }
                ++i10;
            }
            return String.valueOf((char[])object);
        }
        return object;
    }

    public static char toUpperCase(char c10) {
        boolean bl2 = Ascii.isLowerCase(c10);
        if (bl2) {
            c10 = (char)(c10 ^ 0x20);
        }
        return c10;
    }

    public static String toUpperCase(CharSequence charSequence) {
        int n10 = charSequence instanceof String;
        if (n10 != 0) {
            return Ascii.toUpperCase((String)charSequence);
        }
        n10 = charSequence.length();
        char[] cArray = new char[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10;
            cArray[i10] = c10 = Ascii.toUpperCase(charSequence.charAt(i10));
        }
        return String.valueOf(cArray);
    }

    public static String toUpperCase(String object) {
        int n10 = ((String)object).length();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = Ascii.isLowerCase(((String)object).charAt(i10));
            if (!object2) continue;
            object = ((String)object).toCharArray();
            while (i10 < n10) {
                object2 = object[i10];
                boolean bl2 = Ascii.isLowerCase((char)object2);
                if (bl2) {
                    object2 = (char)(object2 ^ 0x20);
                    object[i10] = object2;
                }
                ++i10;
            }
            return String.valueOf((char[])object);
        }
        return object;
    }

    public static String truncate(CharSequence charSequence, int n10, String string2) {
        StringBuilder stringBuilder;
        int n11;
        Preconditions.checkNotNull(charSequence);
        int n12 = string2.length();
        n12 = n10 - n12;
        if (n12 >= 0) {
            n11 = 1;
        } else {
            n11 = 0;
            stringBuilder = null;
        }
        int n13 = string2.length();
        String string3 = "maxLength (%s) must be >= length of the truncation indicator (%s)";
        Preconditions.checkArgument(n11 != 0, string3, n10, n13);
        n11 = charSequence.length();
        if (n11 <= n10 && (n11 = ((String)(charSequence = charSequence.toString())).length()) <= n10) {
            return charSequence;
        }
        stringBuilder = new StringBuilder(n10);
        stringBuilder.append(charSequence, 0, n12);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

