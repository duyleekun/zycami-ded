/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.j.g;

import android.content.Context;
import d.v.e.d;
import d.v.e.f;

public class a0
extends d {
    private static final String a = "setting_preference";
    private static final String b = "key_use_mobile_net_editor";

    public static boolean A() {
        return d.d(a0.z(), a, b, false);
    }

    public static boolean B() {
        return d.b(a0.z(), a, b);
    }

    public static void C(boolean bl2) {
        d.s(a0.z(), a, b, bl2);
    }

    private static Context z() {
        return f.a().c();
    }
}

