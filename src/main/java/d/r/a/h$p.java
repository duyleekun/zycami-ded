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
import d.r.a.r.d;

public final class h$p
extends h$w {
    public d g;

    public h$p() {
        super(3);
    }

    public final void d(g g10) {
        super.d(g10);
        String string2 = this.g.l();
        g10.f("msg_v1", string2);
    }

    public final void e(g object) {
        super.e((g)object);
        Object object2 = "msg_v1";
        object = ((g)object).b((String)object2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            this.g = object2 = new d((String)object);
            long l10 = this.f;
            ((d)object2).h(l10);
        }
    }

    public final String g() {
        d d10 = this.g;
        if (d10 == null) {
            return null;
        }
        return d10.l();
    }

    public final d h() {
        return this.g;
    }

    public final String toString() {
        return "OnMessageCommand";
    }
}

