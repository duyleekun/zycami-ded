/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.b.b;

import com.mob.MobSDK;

public abstract class c {
    public long e;
    public String f;
    public String g;
    public int h;
    public String i;
    public int j;
    public String k;
    public String l;

    public abstract String a();

    public abstract void a(long var1);

    public abstract int b();

    public abstract int c();

    public abstract long d();

    public abstract long e();

    public abstract void f();

    public boolean g() {
        int n10 = this.b();
        int n11 = this.c();
        long l10 = System.currentTimeMillis();
        long l11 = this.e();
        l11 = l10 - l11;
        long l12 = n10;
        n10 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
        boolean bl2 = true;
        if (n10 < 0) {
            long l13;
            l10 = this.d();
            long l14 = l10 - (l13 = (long)n11);
            n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
            if (n10 >= 0) {
                bl2 = false;
            }
            return bl2;
        }
        this.a(l10);
        return bl2;
    }

    public void h() {
        this.f();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.a();
        stringBuilder.append(string2);
        stringBuilder.append(':');
        long l10 = this.e;
        stringBuilder.append(l10);
        char c10 = '|';
        stringBuilder.append(c10);
        String string3 = this.f;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        string3 = MobSDK.getAppkey();
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        string3 = this.g;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        int n10 = this.h;
        stringBuilder.append(n10);
        stringBuilder.append(c10);
        string3 = this.i;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        n10 = this.j;
        stringBuilder.append(n10);
        stringBuilder.append(c10);
        string2 = this.k;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

