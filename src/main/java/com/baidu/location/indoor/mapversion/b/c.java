/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.baidu.location.indoor.mapversion.b;

import android.content.Context;
import com.baidu.location.indoor.mapversion.b.c$a;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class c {
    private static c a;
    private c$a b = null;
    private String c = null;
    private boolean d = false;
    private boolean e = false;
    private String f = "slr";
    private String g = "";
    private double h = 7.0;
    private Map i;

    private c(Context object) {
        Object object2 = new HashMap();
        object2 = Collections.synchronizedMap(object2);
        this.i = object2;
        object = object.getCacheDir();
        String string2 = this.f;
        object2 = new File((File)object, string2);
        object = ((File)object2).getAbsolutePath();
        this.f = object;
    }

    public static c a() {
        Class<c> clazz = c.class;
        synchronized (clazz) {
            c c10 = a;
            return c10;
        }
    }

    public static c a(Context context) {
        c c10 = a;
        if (c10 == null) {
            a = c10 = new c(context);
        }
        return a;
    }

    public boolean b() {
        return this.e;
    }

    public boolean c() {
        return this.g.equals("on");
    }

    public Map d() {
        return this.i;
    }
}

