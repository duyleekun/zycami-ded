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

public class h$d
extends o {
    public String c = null;
    public String d;
    private long e = -1;
    public int f = -1;
    public int g;
    public String h;

    public h$d(int n10, String string2) {
        super(n10);
        this.d = string2;
    }

    public void d(g g10) {
        String string2 = this.c;
        g10.f("req_id", string2);
        string2 = this.d;
        g10.f("package_name", string2);
        long l10 = 305L;
        g10.d("sdk_version", l10);
        int n10 = this.f;
        String string3 = "PUSH_APP_STATUS";
        g10.c(string3, n10);
        string2 = this.h;
        n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n10 == 0) {
            string2 = this.h;
            string3 = "BaseAppCommand.EXTRA__HYBRIDVERSION";
            g10.f(string3, string2);
        }
    }

    public void e(g object) {
        int n10;
        long l10;
        String string2;
        this.c = string2 = ((g)object).b("req_id");
        this.d = string2 = ((g)object).b("package_name");
        this.e = l10 = ((g)object).i("sdk_version", 0L);
        this.f = n10 = ((g)object).h("PUSH_APP_STATUS", 0);
        this.h = object = ((g)object).b("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public String toString() {
        return "BaseAppCommand";
    }
}

