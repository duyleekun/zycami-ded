/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package cn.sharesdk.framework.b.b;

import android.text.TextUtils;
import cn.sharesdk.framework.b.a.e;
import cn.sharesdk.framework.b.b.c;

public class g
extends c {
    private static int a;
    private static long b;

    public String a() {
        return "[RUN]";
    }

    public void a(long l10) {
        b = l10;
    }

    public int b() {
        return 5000;
    }

    public int c() {
        return 5;
    }

    public long d() {
        return a;
    }

    public long e() {
        return b;
    }

    public void f() {
        ++a;
    }

    public boolean g() {
        e e10 = cn.sharesdk.framework.b.a.e.a();
        a = e10.i("insertRunEventCount");
        b = e10.h("lastInsertRunEventTime");
        return super.g();
    }

    public void h() {
        super.h();
        e e10 = cn.sharesdk.framework.b.a.e.a();
        Long l10 = b;
        e10.a("lastInsertRunEventTime", l10);
        int n10 = a;
        e10.a("insertRunEventCount", n10);
    }

    public String toString() {
        String string2 = super.toString();
        StringBuilder stringBuilder = new StringBuilder(string2);
        stringBuilder.append('|');
        string2 = this.l;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            string2 = this.l;
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }
}

