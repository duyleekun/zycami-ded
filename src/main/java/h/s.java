/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.o0;
import java.util.concurrent.TimeUnit;

public class s
extends o0 {
    private o0 f;

    public s(o0 o02) {
        f0.p(o02, "delegate");
        this.f = o02;
    }

    public o0 a() {
        return this.f.a();
    }

    public o0 b() {
        return this.f.b();
    }

    public long d() {
        return this.f.d();
    }

    public o0 e(long l10) {
        return this.f.e(l10);
    }

    public boolean f() {
        return this.f.f();
    }

    public void h() {
        this.f.h();
    }

    public o0 i(long l10, TimeUnit timeUnit) {
        f0.p((Object)timeUnit, "unit");
        return this.f.i(l10, timeUnit);
    }

    public long j() {
        return this.f.j();
    }

    public final o0 l() {
        return this.f;
    }

    public final s m(o0 o02) {
        f0.p(o02, "delegate");
        this.f = o02;
        return this;
    }

    public final /* synthetic */ void n(o0 o02) {
        f0.p(o02, "<set-?>");
        this.f = o02;
    }
}

