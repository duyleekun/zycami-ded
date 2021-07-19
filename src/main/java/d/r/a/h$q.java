/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.r.a;

import android.text.TextUtils;
import d.r.a.g;
import d.r.a.o;
import d.r.a.r.a;
import d.r.a.r.c;
import d.r.a.u.t;

public final class h$q
extends o {
    public String c;
    public String d;
    public long e;
    public a f;

    public h$q() {
        super(5);
    }

    public h$q(String string2, long l10, a a10) {
        super(5);
        this.c = string2;
        this.e = l10;
        this.f = a10;
        this.d = null;
    }

    public final void d(g g10) {
        String string2 = this.c;
        g10.f("package_name", string2);
        long l10 = this.e;
        g10.d("notify_id", l10);
        string2 = t.c(this.f);
        g10.f("notification_v1", string2);
        string2 = this.d;
        g10.f("open_pkg_name", string2);
    }

    public final void e(g object) {
        long l10;
        String string2;
        this.c = string2 = ((g)object).b("package_name");
        long l11 = -1;
        this.e = l10 = ((g)object).i("notify_id", l11);
        this.d = string2 = ((g)object).b("open_pkg_name");
        string2 = "notification_v1";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((g)object).b(string2)));
        if (!bl2) {
            this.f = object = t.a((String)object);
        }
        if ((object = this.f) != null) {
            l10 = this.e;
            ((c)object).z(l10);
        }
    }

    public final String toString() {
        return "OnNotificationClickCommand";
    }
}

