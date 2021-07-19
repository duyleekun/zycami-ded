/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 */
package com.zhiyun.editorsdk.fundation;

import android.app.Application;
import android.content.Context;
import com.zhiyun.editorinterface.EditConfig;
import d.v.v.c;

public class EditorConfig {
    public static final long a = 500000L;
    public static final long b = 3000000L;
    public static final long[] c;
    public static final long d = 0L;
    public static final long e = 0L;
    public static final int f = 1000000;
    public static final int g = 21;
    public static final String h = "videofx";
    public static final String i = "animatedsticker";
    public static final String j = "captionstyle";
    public static final String k = "videotransition";

    static {
        long[] lArray;
        long[] lArray2 = lArray = new long[4];
        long[] lArray3 = lArray;
        lArray2[0] = 500000L;
        lArray3[1] = 1000000L;
        lArray2[2] = 1500000L;
        lArray3[3] = 2000000L;
        c = lArray;
        d = lArray[1];
        e = lArray[3];
    }

    public static void a(Application application) {
        c c10 = new c();
        ((EditConfig)c10).b((Context)application);
    }
}

