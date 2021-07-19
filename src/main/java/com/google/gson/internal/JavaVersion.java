/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

public final class JavaVersion {
    private static final int majorJavaVersion = JavaVersion.determineMajorJavaVersion();

    private JavaVersion() {
    }

    private static int determineMajorJavaVersion() {
        return JavaVersion.getMajorJavaVersion(System.getProperty("java.version"));
    }

    private static int extractBeginningInt(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = 0;
        while (true) {
            int n11 = string2.length();
            if (n10 >= n11) break;
            n11 = string2.charAt(n10);
            boolean bl2 = Character.isDigit((char)n11);
            if (!bl2) break;
            stringBuilder.append((char)n11);
            ++n10;
            continue;
            break;
        }
        try {
            string2 = stringBuilder.toString();
        }
        catch (NumberFormatException numberFormatException) {
            return -1;
        }
        return Integer.parseInt(string2);
    }

    public static int getMajorJavaVersion() {
        return majorJavaVersion;
    }

    public static int getMajorJavaVersion(String string2) {
        int n10;
        int n11 = JavaVersion.parseDotted(string2);
        if (n11 == (n10 = -1)) {
            n11 = JavaVersion.extractBeginningInt(string2);
        }
        if (n11 == n10) {
            return 6;
        }
        return n11;
    }

    public static boolean isJava9OrLater() {
        int n10 = majorJavaVersion;
        int n11 = 9;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    private static int parseDotted(String object) {
        int n10;
        block7: {
            String string2 = "[._]";
            try {
                object = object.split(string2);
                n10 = 0;
                string2 = null;
            }
            catch (NumberFormatException numberFormatException) {
                return -1;
            }
            string2 = object[0];
            n10 = Integer.parseInt(string2);
            int n11 = 1;
            if (n10 != n11) break block7;
            int n12 = ((String[])object).length;
            if (n12 <= n11) break block7;
            object = object[n11];
            return Integer.parseInt((String)object);
        }
        return n10;
    }
}

