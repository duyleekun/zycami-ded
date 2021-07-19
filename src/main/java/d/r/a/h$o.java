/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.r.a;

import android.os.Bundle;
import d.r.a.g;
import d.r.a.h$t;

public final class h$o
extends h$t {
    public String e;
    public int f = 0;
    public boolean g = false;

    public h$o() {
        super(7);
    }

    public final void d(g g10) {
        super.d(g10);
        String string2 = this.e;
        g10.f("content", string2);
        int bl2 = this.f;
        g10.c("log_level", bl2);
        boolean bl3 = this.g;
        Bundle bundle = g10.a;
        if (bundle == null) {
            g10.a = bundle = new Bundle();
        }
        g10.a.putBoolean("is_server_log", bl3);
    }

    public final void e(g g10) {
        int n10;
        String string2;
        super.e(g10);
        this.e = string2 = g10.b("content");
        string2 = "log_level";
        boolean bl2 = false;
        this.f = n10 = g10.h(string2, 0);
        g10 = g10.a;
        if (g10 != null) {
            string2 = "is_server_log";
            bl2 = g10.getBoolean(string2, false);
        }
        this.g = bl2;
    }

    public final String toString() {
        return "OnLogCommand";
    }
}

