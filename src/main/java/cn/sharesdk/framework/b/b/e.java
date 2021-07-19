/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package cn.sharesdk.framework.b.b;

import android.text.TextUtils;
import cn.sharesdk.framework.b.b.c;

public class e
extends c {
    private static int b;
    private static long c;
    public long a;

    public String a() {
        return "[EXT]";
    }

    public void a(long l10) {
        c = l10;
    }

    public int b() {
        return 5000;
    }

    public int c() {
        return 5;
    }

    public long d() {
        return b;
    }

    public long e() {
        return c;
    }

    public void f() {
        ++b;
    }

    public boolean g() {
        cn.sharesdk.framework.b.a.e e10 = cn.sharesdk.framework.b.a.e.a();
        b = e10.i("insertExitEventCount");
        c = e10.h("lastInsertExitEventTime");
        return super.g();
    }

    public void h() {
        super.h();
        cn.sharesdk.framework.b.a.e e10 = cn.sharesdk.framework.b.a.e.a();
        Long l10 = c;
        e10.a("lastInsertExitEventTime", l10);
        int n10 = b;
        e10.a("insertExitEventCount", n10);
    }

    public String toString() {
        String string2 = super.toString();
        StringBuilder stringBuilder = new StringBuilder(string2);
        int n10 = 124;
        stringBuilder.append((char)n10);
        String string3 = this.l;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2) {
            string3 = this.l;
            stringBuilder.append(string3);
        }
        stringBuilder.append((char)n10);
        n10 = Math.round((float)this.a / 1000.0f);
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }
}

