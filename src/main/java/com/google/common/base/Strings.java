/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Platform;
import com.google.common.base.Preconditions;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Strings {
    private Strings() {
    }

    public static String commonPrefix(CharSequence charSequence, CharSequence charSequence2) {
        boolean bl2;
        char c10;
        char c11;
        int n10;
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int n11 = charSequence.length();
        int n12 = charSequence2.length();
        n11 = Math.min(n11, n12);
        n12 = 0;
        for (n10 = 0; n10 < n11 && (c11 = charSequence.charAt(n10)) == (c10 = charSequence2.charAt(n10)); ++n10) {
        }
        n11 = n10 + -1;
        c11 = (char)(Strings.validSurrogatePairAt(charSequence, n11) ? 1 : 0);
        if (c11 != '\u0000' || (bl2 = Strings.validSurrogatePairAt(charSequence2, n11))) {
            n10 += -1;
        }
        return charSequence.subSequence(0, n10).toString();
    }

    public static String commonSuffix(CharSequence charSequence, CharSequence charSequence2) {
        int n10;
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int n11 = charSequence.length();
        int n12 = charSequence2.length();
        n11 = Math.min(n11, n12);
        for (n12 = 0; n12 < n11; ++n12) {
            int n13 = charSequence.length() - n12 + -1;
            n13 = charSequence.charAt(n13);
            int n14 = charSequence2.length() - n12 + -1;
            if (n13 != (n14 = (int)charSequence2.charAt(n14))) break;
        }
        n11 = charSequence.length() - n12 + -1;
        if ((n11 = (int)(Strings.validSurrogatePairAt(charSequence, n11) ? 1 : 0)) != 0 || (n10 = (int)(Strings.validSurrogatePairAt(charSequence2, n11 = charSequence2.length() - n12 + -1) ? 1 : 0)) != 0) {
            n12 += -1;
        }
        n10 = charSequence.length() - n12;
        n11 = charSequence.length();
        return charSequence.subSequence(n10, n11).toString();
    }

    public static String emptyToNull(String string2) {
        return Platform.emptyToNull(string2);
    }

    public static boolean isNullOrEmpty(String string2) {
        return Platform.stringIsNullOrEmpty(string2);
    }

    public static String lenientFormat(String object, Object ... objectArray) {
        int n10;
        String string2;
        String string3;
        int n11;
        CharSequence charSequence;
        object = String.valueOf(object);
        int n12 = 0;
        Object object2 = null;
        if (objectArray == null) {
            int n13 = 1;
            objectArray = new Object[n13];
            charSequence = "(Object[])null";
            objectArray[0] = charSequence;
        } else {
            charSequence = null;
            for (int i10 = 0; i10 < (n11 = objectArray.length); ++i10) {
                string3 = Strings.lenientToString(objectArray[i10]);
                objectArray[i10] = string3;
            }
        }
        n11 = ((String)object).length();
        int n14 = objectArray.length * 16;
        charSequence = new StringBuilder(n11 += n14);
        n11 = 0;
        string3 = null;
        while (n12 < (n14 = objectArray.length) && (n14 = ((String)object).indexOf(string2 = "%s", n11)) != (n10 = -1)) {
            ((StringBuilder)charSequence).append((CharSequence)object, n11, n14);
            n11 = n12 + 1;
            object2 = objectArray[n12];
            ((StringBuilder)charSequence).append(object2);
            n12 = n14 + 2;
            int n15 = n11;
            n11 = n12;
            n12 = n15;
        }
        n14 = ((String)object).length();
        ((StringBuilder)charSequence).append((CharSequence)object, n11, n14);
        int n16 = objectArray.length;
        if (n12 < n16) {
            object = " [";
            ((StringBuilder)charSequence).append((String)object);
            n16 = n12 + 1;
            object2 = objectArray[n12];
            ((StringBuilder)charSequence).append(object2);
            while (n16 < (n12 = objectArray.length)) {
                object2 = ", ";
                ((StringBuilder)charSequence).append((String)object2);
                n12 = n16 + '\u0001';
                object = objectArray[n16];
                ((StringBuilder)charSequence).append(object);
                n16 = n12;
            }
            n16 = 93;
            ((StringBuilder)charSequence).append((char)n16);
        }
        return ((StringBuilder)charSequence).toString();
    }

    private static String lenientToString(Object object) {
        try {
            return String.valueOf(object);
        }
        catch (Exception exception) {
            Object object2 = new StringBuilder();
            Object object3 = object.getClass().getName();
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append('@');
            object = Integer.toHexString(System.identityHashCode(object));
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            object2 = Logger.getLogger("com.google.common.base.Strings");
            object3 = Level.WARNING;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Exception during lenientFormat for ");
            charSequence.append((String)object);
            charSequence = charSequence.toString();
            ((Logger)object2).log((Level)object3, (String)charSequence, exception);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("<");
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" threw ");
            object = exception.getClass().getName();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(">");
            return ((StringBuilder)object2).toString();
        }
    }

    public static String nullToEmpty(String string2) {
        return Platform.nullToEmpty(string2);
    }

    public static String padEnd(String string2, int n10, char c10) {
        Preconditions.checkNotNull(string2);
        int n11 = string2.length();
        if (n11 >= n10) {
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append(string2);
        for (int i10 = string2.length(); i10 < n10; ++i10) {
            stringBuilder.append(c10);
        }
        return stringBuilder.toString();
    }

    public static String padStart(String string2, int n10, char c10) {
        Preconditions.checkNotNull(string2);
        int n11 = string2.length();
        if (n11 >= n10) {
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder(n10);
        for (int i10 = string2.length(); i10 < n10; ++i10) {
            stringBuilder.append(c10);
        }
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static String repeat(String object, int n10) {
        long l10;
        long l11;
        Preconditions.checkNotNull(object);
        int n11 = 1;
        String string2 = null;
        if (n10 <= n11) {
            if (n10 < 0) {
                n11 = 0;
            }
            string2 = "invalid count: %s";
            Preconditions.checkArgument(n11 != 0, string2, n10);
            if (n10 == 0) {
                object = "";
            }
            return object;
        }
        long l12 = n11;
        long l13 = n10;
        n10 = (int)(l12 *= l13);
        if ((l11 = (l10 = (l13 = (long)n10) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
            int n12;
            char[] cArray = new char[n10];
            ((String)object).getChars(0, n11, cArray, 0);
            for (n11 = ((String)object).length(); n11 < (n12 = n10 - n11); n11 <<= 1) {
                System.arraycopy(cArray, 0, cArray, n11, n11);
            }
            System.arraycopy(cArray, 0, cArray, n11, n12);
            object = new String(cArray);
            return object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Required array size too large: ");
        charSequence.append(l12);
        charSequence = charSequence.toString();
        object = new ArrayIndexOutOfBoundsException((String)charSequence);
        throw object;
    }

    public static boolean validSurrogatePairAt(CharSequence charSequence, int n10) {
        boolean bl2;
        int n11;
        int n12 = 1;
        if (n10 < 0 || n10 > (n11 = charSequence.length() + -2) || (n11 = (int)(Character.isHighSurrogate(charSequence.charAt(n10)) ? 1 : 0)) == 0 || !(bl2 = Character.isLowSurrogate(charSequence.charAt(n10 += n12)))) {
            n12 = 0;
        }
        return n12 != 0;
    }
}

