/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location;

public class Jni {
    private static int a = 0;
    private static int b = 1;
    private static int c = 2;
    private static int d = 11;
    private static int e = 12;
    private static int f = 13;
    private static int g = 14;
    private static int h = 15;
    private static int i = 1024;
    private static boolean j = false;

    static {
        String string2 = "locSDK8a";
        try {
            System.loadLibrary(string2);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            boolean bl2;
            unsatisfiedLinkError.printStackTrace();
            j = bl2 = true;
        }
    }

    private static native String a(byte[] var0, int var1);

    private static native String b(double var0, double var2, int var4, int var5);

    private static native String c(byte[] var0, int var1);

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static double[] coorEncrypt(double d10, double d11, String string2) {
        String string3;
        String string4;
        int n10 = 2;
        double[] dArray = new double[n10];
        dArray[0] = 0.0;
        dArray[1] = 0.0;
        int n11 = j;
        if (n11 != 0) {
            return dArray;
        }
        n11 = -1;
        String string5 = "bd09";
        boolean bl2 = string2.equals(string5);
        if (bl2) {
            n11 = a;
        } else {
            string5 = "bd09ll";
            bl2 = string2.equals(string5);
            if (bl2) {
                n11 = b;
            } else {
                string5 = "gcj02";
                bl2 = string2.equals(string5);
                if (bl2) {
                    n11 = c;
                } else {
                    string5 = "gps2gcj";
                    bl2 = string2.equals(string5);
                    if (bl2) {
                        n11 = d;
                    } else {
                        string5 = "bd092gcj";
                        bl2 = string2.equals(string5);
                        if (bl2) {
                            n11 = e;
                        } else {
                            string5 = "bd09ll2gcj";
                            bl2 = string2.equals(string5);
                            if (bl2) {
                                n11 = f;
                            } else {
                                string5 = "wgs842mc";
                                bl2 = string2.equals(string5);
                                if (bl2) {
                                    n11 = h;
                                }
                            }
                        }
                    }
                }
            }
        }
        string5 = "gcj2wgs";
        boolean bl3 = string2.equals(string5);
        if (bl3) {
            n11 = 16;
        }
        int n12 = 132456;
        try {
            string4 = Jni.b(d10, d11, n11, n12);
            string3 = ":";
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            return dArray;
        }
        String[] stringArray = string4.split(string3);
        int n13 = 0;
        string3 = null;
        String string6 = stringArray[0];
        d11 = Double.parseDouble(string6);
        dArray[0] = d11;
        n13 = 1;
        String string7 = stringArray[n13];
        d11 = Double.parseDouble(string7);
        dArray[n13] = d11;
        return dArray;
    }

    private static native String ee(String var0, int var1);

    public static String en1(String object) {
        int n10 = j;
        String string2 = "err!";
        if (n10 != 0) {
            return string2;
        }
        if (object == null) {
            return "null";
        }
        object = ((String)object).getBytes();
        n10 = i;
        byte[] byArray = new byte[n10];
        int n11 = ((Object)object).length;
        int n12 = 740;
        if (n11 > n12) {
            n11 = n12;
        }
        int n13 = 0;
        for (n12 = 0; n12 < n11; ++n12) {
            Object object2 = object[n12];
            if (object2 == false) continue;
            object2 = object[n12];
            byArray[n13] = (byte)object2;
            ++n13;
        }
        int n14 = 132456;
        try {
            string2 = Jni.a(byArray, n14);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            unsatisfiedLinkError.printStackTrace();
        }
        return string2;
    }

    public static String encode(String string2) {
        boolean bl2 = j;
        if (bl2) {
            return "err!";
        }
        StringBuilder stringBuilder = new StringBuilder();
        string2 = Jni.en1(string2);
        stringBuilder.append(string2);
        stringBuilder.append("|tp=3");
        return stringBuilder.toString();
    }

    public static String encode2(String object) {
        int n10 = j;
        String string2 = "err!";
        if (n10 != 0) {
            return string2;
        }
        if (object == null) {
            return "null";
        }
        object = ((String)object).getBytes();
        n10 = 132456;
        try {
            string2 = Jni.c((byte[])object, n10);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            unsatisfiedLinkError.printStackTrace();
        }
        return string2;
    }

    public static Long encode3(String object) {
        String string2;
        boolean bl2 = j;
        Long l10 = null;
        if (bl2) {
            return null;
        }
        object = ((String)object).getBytes();
        String string3 = "UTF-8";
        try {
            string2 = new String((byte[])object, string3);
        }
        catch (Exception exception) {
            string2 = "";
        }
        long l11 = Jni.murmur(string2);
        try {
            l10 = l11;
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            unsatisfiedLinkError.printStackTrace();
        }
        return l10;
    }

    private static native String encodeNotLimit(String var0, int var1);

    public static String encodeOfflineLocationUpdateRequest(String object) {
        String string2;
        boolean bl2 = j;
        String string3 = "err!";
        if (bl2) {
            return string3;
        }
        object = ((String)object).getBytes();
        String string4 = "UTF-8";
        try {
            string2 = new String((byte[])object, string4);
        }
        catch (Exception exception) {
            string2 = "";
        }
        int n10 = 132456;
        try {
            string3 = Jni.encodeNotLimit(string2, n10);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            unsatisfiedLinkError.printStackTrace();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append("|tp=3");
        return ((StringBuilder)object).toString();
    }

    public static String encodeTp4(String object) {
        String string2;
        boolean bl2 = j;
        String string3 = "err!";
        if (bl2) {
            return string3;
        }
        object = ((String)object).getBytes();
        String string4 = "UTF-8";
        try {
            string2 = new String((byte[])object, string4);
        }
        catch (Exception exception) {
            string2 = "";
        }
        int n10 = 132456;
        try {
            string3 = Jni.ee(string2, n10);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            unsatisfiedLinkError.printStackTrace();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append("|tp=4");
        return ((StringBuilder)object).toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static double getGpsSwiftRadius(float f10, double d10, double d11) {
        boolean bl2 = j;
        double d12 = 0.0;
        if (bl2) {
            return d12;
        }
        try {
            return Jni.gsr(f10, d10, d11);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            return d12;
        }
    }

    public static String getldkaiv() {
        boolean bl2 = j;
        String string2 = null;
        if (bl2) {
            return null;
        }
        try {
            string2 = Jni.ldkaiv();
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            unsatisfiedLinkError.printStackTrace();
        }
        return string2;
    }

    private static native double gsr(float var0, double var1, double var3);

    private static native String ldkaiv();

    private static native long murmur(String var0);
}

