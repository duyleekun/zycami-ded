/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.b2.w;

import d.v.c.b2.w.b;
import d.v.c.b2.w.l.c;
import d.v.c.b2.x.d;
import java.util.HashMap;
import java.util.List;

public class k
extends b
implements d.v.c.b2.w.l.b {
    public static final int m = 0;
    public static final int n = 1;
    private c g;
    private long h;
    private long i;
    private long j;
    private HashMap k;
    private boolean l;

    public k(d.v.h.h.b b10) {
        super(b10);
        c c10;
        String string2 = b10.k();
        long l10 = b10.e();
        this.g = c10 = new c(string2, 0L, l10, 1000);
    }

    public void A(HashMap hashMap) {
        this.k = hashMap;
    }

    public void B(long l10) {
        this.j = l10;
    }

    public void C(long l10) {
        this.i = l10;
    }

    public void D(long l10) {
        this.h = l10;
    }

    public void E(d d10) {
        this.g.n(d10);
    }

    public void b() {
        this.g.b();
    }

    public boolean f() {
        return this.g.f();
    }

    public HashMap r() {
        return this.k;
    }

    public long s() {
        return this.j;
    }

    public long t() {
        return this.i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VoiceUiData{originalVoiceTime=");
        long l10 = this.h;
        stringBuilder.append(l10);
        stringBuilder.append(", originalVoiceStartTime=");
        l10 = this.i;
        stringBuilder.append(l10);
        stringBuilder.append(", originalVoiceEndTime=");
        l10 = this.j;
        stringBuilder.append(l10);
        stringBuilder.append(", startTime=");
        l10 = this.b;
        stringBuilder.append(l10);
        stringBuilder.append(", endTime=");
        l10 = this.c;
        stringBuilder.append(l10);
        stringBuilder.append(", data=");
        d.v.h.b b10 = this.d;
        stringBuilder.append(b10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public long u() {
        return this.h;
    }

    public List v() {
        return this.g.m();
    }

    public boolean w() {
        return this.l;
    }

    public boolean x() {
        return this.w() ^ true;
    }

    public void y(int n10) {
        this.g.o(n10);
    }

    public void z(boolean bl2) {
        this.l = bl2;
    }
}

