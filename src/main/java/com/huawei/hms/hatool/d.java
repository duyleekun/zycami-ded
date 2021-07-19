/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.huawei.hms.hatool;

import android.util.Pair;
import d.j.f.a.a.h.b.a;
import d.j.f.a.a.h.f.c;
import java.nio.charset.Charset;

public class d {
    public static final Charset a = Charset.forName("UTF-8");

    public static Pair a(String string2) {
        int n10;
        int n11;
        Object object = null;
        if (string2 != null && (n11 = string2.length()) >= (n10 = 32)) {
            object = string2.substring(0, n10);
            string2 = string2.substring(n10);
            object = c.c((String)object);
            Pair pair = new Pair(object, (Object)string2);
            return pair;
        }
        object = new byte[]{};
        Pair pair = new Pair(object, (Object)string2);
        return pair;
    }

    public static String a(String object, String object2) {
        object = d.a((String)object);
        Object object3 = c.c((String)((Pair)object).second);
        object2 = c.c((String)object2);
        object = (byte[])((Pair)object).first;
        object = d.j.f.a.a.h.b.a.p(object3, (byte[])object2, (byte[])object);
        object3 = a;
        object2 = new String((byte[])object, (Charset)object3);
        return object2;
    }

    public static String b(String object, String object2) {
        Charset charset = a;
        object = ((String)object).getBytes(charset);
        object2 = c.c((String)object2);
        return c.b(d.j.f.a.a.h.b.a.x((byte[])object, (byte[])object2));
    }
}

