/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.h.h;

import android.text.TextUtils;
import java.util.UUID;

public class b
extends d.v.h.b
implements Cloneable {
    private String b;
    private String c;
    private long d;
    private long e;
    private long f;
    private Long g;
    private float h;
    private boolean i;
    private long j;
    private long k;

    public b() {
        this.h = 1.0f;
    }

    public b(String string2, long l10, long l11, Long l12) {
        int n10;
        float f10;
        this.h = f10 = 1.0f;
        this.b = string2;
        this.d = l10;
        this.e = l11;
        this.g = l12;
        String string3 = this.c;
        if (string3 == null || (n10 = TextUtils.isEmpty((CharSequence)string3)) != 0) {
            boolean bl2;
            boolean bl3 = (string2 = string2.trim()).contains(string3 = "/");
            if (bl3) {
                n10 = string2.lastIndexOf(string3) + 1;
                this.c = string2 = string2.substring(n10);
            }
            if (bl2 = (string2 = this.c).contains(string3 = ".")) {
                string2 = this.c;
                bl3 = false;
                n10 = string2.lastIndexOf(string3);
                this.c = string2 = string2.substring(0, n10);
            }
        }
    }

    public b c() {
        b b10 = new b();
        Object object = this.d();
        object = b10.p((Long)object);
        long l10 = this.e();
        object = ((b)object).q(l10);
        String string2 = this.j();
        object = ((b)object).u(string2);
        l10 = this.f();
        object = ((b)object).r(l10);
        string2 = this.k();
        object = ((b)object).v(string2);
        boolean bl2 = this.o();
        object = ((b)object).w(bl2);
        l10 = this.m();
        object = ((b)object).x(l10);
        float f10 = this.n();
        object = ((b)object).y(f10);
        l10 = this.g();
        object = ((b)object).s(l10);
        l10 = this.i();
        object = ((b)object).t(l10);
        string2 = UUID.randomUUID().toString();
        ((d.v.h.b)object).b(string2);
        return b10;
    }

    public Long d() {
        return this.g;
    }

    public long e() {
        return this.f;
    }

    public long f() {
        return this.e;
    }

    public long g() {
        return this.j;
    }

    public long i() {
        return this.k;
    }

    public String j() {
        return this.c;
    }

    public String k() {
        return this.b;
    }

    public long l() {
        long l10 = this.f();
        long l11 = this.m();
        return l10 - l11;
    }

    public long m() {
        return this.d;
    }

    public float n() {
        return this.h;
    }

    public boolean o() {
        return this.i;
    }

    public b p(Long l10) {
        this.g = l10;
        return this;
    }

    public b q(long l10) {
        this.f = l10;
        return this;
    }

    public b r(long l10) {
        this.e = l10;
        return this;
    }

    public b s(long l10) {
        this.j = l10;
        return this;
    }

    public b t(long l10) {
        this.k = l10;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MusicInfo{musicPath='");
        Object object = this.b;
        stringBuilder.append((String)object);
        char bl2 = '\'';
        stringBuilder.append(bl2);
        stringBuilder.append(", musicName='");
        String string2 = this.c;
        stringBuilder.append(string2);
        stringBuilder.append(bl2);
        stringBuilder.append(", startTime=");
        long l10 = this.d;
        stringBuilder.append(l10);
        stringBuilder.append(", endTime=");
        l10 = this.e;
        stringBuilder.append(l10);
        stringBuilder.append(", duration=");
        l10 = this.f;
        stringBuilder.append(l10);
        stringBuilder.append(", attachTime=");
        object = this.g;
        stringBuilder.append(object);
        stringBuilder.append(", volume=");
        float f10 = this.h;
        stringBuilder.append(f10);
        stringBuilder.append(", mute=");
        boolean bl3 = this.i;
        stringBuilder.append(bl3);
        stringBuilder.append(", fadeInDuration=");
        l10 = this.j;
        stringBuilder.append(l10);
        stringBuilder.append(", fadeOutDuration=");
        l10 = this.k;
        stringBuilder.append(l10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public b u(String string2) {
        boolean bl2;
        if (string2 != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            this.c = string2;
        }
        return this;
    }

    public b v(String string2) {
        int n10;
        this.b = string2;
        String string3 = this.c;
        if (string3 == null || (n10 = TextUtils.isEmpty((CharSequence)string3)) != 0) {
            boolean bl2;
            boolean bl3 = (string2 = string2.trim()).contains(string3 = "/");
            if (bl3) {
                n10 = string2.lastIndexOf(string3) + 1;
                this.c = string2 = string2.substring(n10);
            }
            if (bl2 = (string2 = this.c).contains(string3 = ".")) {
                string2 = this.c;
                bl3 = false;
                n10 = string2.lastIndexOf(string3);
                this.c = string2 = string2.substring(0, n10);
            }
        }
        return this;
    }

    public b w(boolean bl2) {
        this.i = bl2;
        return this;
    }

    public b x(long l10) {
        this.d = l10;
        return this;
    }

    public b y(float f10) {
        this.h = f10;
        return this;
    }
}

