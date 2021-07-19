/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.HandlerThread
 */
package com.baidu.location.b;

import android.os.HandlerThread;

public class z {
    private static HandlerThread a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HandlerThread a() {
        Class<z> clazz = z.class;
        synchronized (clazz) {
            HandlerThread handlerThread = a;
            if (handlerThread != null) return a;
            try {
                String string2 = "ServiceStartArguments";
                int n10 = 10;
                a = handlerThread = new HandlerThread(string2, n10);
                handlerThread.start();
                return a;
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
                handlerThread = null;
                a = null;
            }
            return a;
        }
    }
}

