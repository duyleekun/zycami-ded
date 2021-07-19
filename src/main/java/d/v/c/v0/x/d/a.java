/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.v0.x.d;

import android.content.Context;
import d.v.c.v0.x.d.a$a;
import d.v.e.d;
import d.v.e.f;
import java.util.HashSet;
import java.util.Set;

public class a
extends d {
    private static final String a = "app_state_preference";
    private static final String b = "start_time";
    private static final String c = "end_time";
    private static final String d = "start_save";
    private static final String e = "end_save";
    private static final String f = "production";
    private static final String g = "fail_app_state";

    public static a D() {
        return a$a.a();
    }

    private static Context z() {
        return d.v.e.f.a().c();
    }

    public boolean A() {
        return d.v.e.d.d(d.v.c.v0.x.d.a.z(), a, e, true);
    }

    public String B() {
        return d.v.e.d.l(d.v.c.v0.x.d.a.z(), a, c);
    }

    public Set C() {
        HashSet hashSet = new HashSet();
        return d.v.e.d.o(d.v.c.v0.x.d.a.z(), a, g, hashSet);
    }

    public String E() {
        return d.v.e.d.l(d.v.c.v0.x.d.a.z(), a, f);
    }

    public boolean F() {
        return d.v.e.d.d(d.v.c.v0.x.d.a.z(), a, d, true);
    }

    public String G() {
        return d.v.e.d.l(d.v.c.v0.x.d.a.z(), a, b);
    }

    public void H(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.x.d.a.z(), a, e, bl2);
    }

    public void I(String string2) {
        d.v.e.d.x(d.v.c.v0.x.d.a.z(), a, c, string2);
    }

    public void J(Set set) {
        d.v.e.d.y(d.v.c.v0.x.d.a.z(), a, g, set);
    }

    public void K(String string2) {
        d.v.e.d.x(d.v.c.v0.x.d.a.z(), a, f, string2);
    }

    public void L(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.x.d.a.z(), a, d, bl2);
    }

    public void M(String string2) {
        d.v.e.d.x(d.v.c.v0.x.d.a.z(), a, b, string2);
    }
}

