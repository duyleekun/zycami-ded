/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.e.a;

import android.text.TextUtils;
import d.e.a.d$a;

public class d {
    private static final long i = 86400000L;
    private static final long j = 0x100000L;
    private static final long k = 604800000L;
    private static final long l = 0xA00000L;
    private static final long m = 0x3200000L;
    private static final int n = 500;
    public String a;
    public String b;
    public long c = 0xA00000L;
    public long d = 604800000L;
    public long e = 500L;
    public long f = 0x3200000L;
    public byte[] g;
    public byte[] h;

    private d() {
    }

    public /* synthetic */ d(d$a d$a) {
        this();
    }

    public static /* synthetic */ void a(d d10, String string2) {
        d10.i(string2);
    }

    public static /* synthetic */ void b(d d10, String string2) {
        d10.o(string2);
    }

    public static /* synthetic */ void c(d d10, long l10) {
        d10.m(l10);
    }

    public static /* synthetic */ void d(d d10, long l10) {
        d10.n(l10);
    }

    public static /* synthetic */ void e(d d10, long l10) {
        d10.j(l10);
    }

    public static /* synthetic */ void f(d d10, byte[] byArray) {
        d10.l(byArray);
    }

    public static /* synthetic */ void g(d d10, byte[] byArray) {
        d10.k(byArray);
    }

    private void i(String string2) {
        this.a = string2;
    }

    private void j(long l10) {
        this.d = l10;
    }

    private void k(byte[] byArray) {
        this.h = byArray;
    }

    private void l(byte[] byArray) {
        this.g = byArray;
    }

    private void m(long l10) {
        this.c = l10;
    }

    private void n(long l10) {
        this.f = l10;
    }

    private void o(String string2) {
        this.b = string2;
    }

    public boolean h() {
        Object object = this.a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.b))) && (object = (Object)this.g) != null && (object = (Object)this.h) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

