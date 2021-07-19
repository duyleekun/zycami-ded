/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.util;

public class Checks {
    private Checks() {
    }

    public static void checkArgument(boolean bl2, String string2) {
        if (bl2) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    /*
     * WARNING - void declaration
     */
    public static String checkMetadataIdentifier(String object) {
        boolean n10 = ((String)object).isEmpty();
        if (!n10) {
            IllegalArgumentException illegalArgumentException = null;
            boolean bl2 = Checks.isLetter(((String)object).charAt(0));
            if (bl2) {
                int n11;
                void var1_4;
                boolean bl3 = true;
                while (++var1_4 < (n11 = ((String)object).length())) {
                    n11 = ((String)object).charAt((int)var1_4);
                    int n12 = Checks.isLetter((char)n11);
                    if (n12 != 0 || n11 >= (n12 = 48) && n11 <= (n12 = 57) || n11 == (n12 = 95)) continue;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("identifier must contain only ASCII letters, digits or underscore: ");
                    stringBuilder.append((String)object);
                    object = stringBuilder.toString();
                    illegalArgumentException = new IllegalArgumentException((String)object);
                    throw illegalArgumentException;
                }
                return object;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("identifier must start with an ASCII letter: ");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        object = new IllegalArgumentException("identifier must not be empty");
        throw object;
    }

    public static Object checkNotNull(Object object, String string2) {
        if (object != null) {
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" must not be null");
        string2 = stringBuilder.toString();
        object = new NullPointerException(string2);
        throw object;
    }

    private static boolean isLetter(char n10) {
        int n11 = 97;
        n10 = n11 <= n10 && n10 <= (n11 = 122) || (n11 = 65) <= n10 && n10 <= (n11 = 90) ? 1 : 0;
        return n10 != 0;
    }
}

