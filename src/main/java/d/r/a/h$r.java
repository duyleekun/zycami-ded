/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.r.a;

import android.text.TextUtils;
import d.r.a.g;
import d.r.a.h$w;
import d.r.a.r.a;
import d.r.a.r.c;
import d.r.a.u.t;

public final class h$r
extends h$w {
    public a g;
    private String h;

    public h$r() {
        super(4);
    }

    public final void d(g g10) {
        String string2;
        super.d(g10);
        this.h = string2 = t.c(this.g);
        g10.f("notification_v1", string2);
    }

    public final void e(g object) {
        super.e((g)object);
        String string2 = "notification_v1";
        this.h = object = ((g)object).b(string2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            this.g = object = t.a(this.h);
            if (object != null) {
                long l10 = this.f;
                ((c)object).z(l10);
            }
        }
    }

    public final a g() {
        return this.g;
    }

    public final String h() {
        Object object = this.h;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = this.g;
            if (object == null) {
                return null;
            }
            return t.c((a)object);
        }
        return this.h;
    }

    public final String toString() {
        return "OnNotifyArrivedCommand";
    }
}

