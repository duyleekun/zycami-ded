/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.g1;

import android.content.Context;
import d.v.e.d;
import d.v.e.f;

public class j
extends d {
    private static final String a = "translation_preference";
    private static final String b = "key_translation_ver";

    public static int A() {
        return d.h(j.z(), a, b, 0);
    }

    public static void B(int n10) {
        d.u(j.z(), a, b, n10);
    }

    private static Context z() {
        return f.a().c();
    }
}

