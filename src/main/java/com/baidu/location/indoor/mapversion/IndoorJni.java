/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor.mapversion;

import java.io.PrintStream;

public class IndoorJni {
    public static boolean a = false;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object = "indoor";
        try {
            String string2;
            boolean bl2;
            System.loadLibrary((String)object);
            a = bl2 = true;
            if (bl2) {
                object = System.err;
                string2 = "load vdr indoor lib success.";
            } else {
                object = System.err;
                string2 = "load vdr indoor lib fail.";
            }
            ((PrintStream)object).println(string2);
            return;
        }
        catch (Throwable throwable) {
            PrintStream printStream = System.err;
            String string3 = "Cannot load indoor lib";
            printStream.println(string3);
            throwable.printStackTrace();
        }
    }

    public static native void initPf();

    public static native float[] pgo();

    public static native void phs(int var0, float var1, float var2, float var3, long var4);

    public static native void resetPf();

    public static native double[] setPfDr(double var0, double var2, long var4);

    public static native void setPfGeoMap(double[][] var0, String var1, int var2, int var3);

    public static native void setPfGeomag(double var0);

    public static native double[] setPfGps(double var0, double var2, double var4, double var6, double var8, long var10);

    public static native void setPfRdnt(String var0, short[][] var1, double var2, double var4, int var6, int var7, double var8, double var10);

    public static native double[] setPfWf(double var0, double var2, double var4, long var6);

    public static native void stopPdr();
}

