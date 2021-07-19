/*
 * Decompiled with CFR 0.151.
 */
package i.h.g;

import i.h.g.c;
import i.h.h.g;
import org.slf4j.Marker;
import org.slf4j.event.Level;

public class d
implements c {
    public Level a;
    public Marker b;
    public String c;
    public g d;
    public String e;
    public String f;
    public Object[] g;
    public long h;
    public Throwable i;

    public String a() {
        return this.f;
    }

    public Object[] b() {
        return this.g;
    }

    public Marker c() {
        return this.b;
    }

    public String d() {
        return this.e;
    }

    public long e() {
        return this.h;
    }

    public Throwable f() {
        return this.i;
    }

    public g g() {
        return this.d;
    }

    public Level getLevel() {
        return this.a;
    }

    public String getLoggerName() {
        return this.c;
    }

    public void h(Object[] objectArray) {
        this.g = objectArray;
    }

    public void i(Level level) {
        this.a = level;
    }

    public void j(g g10) {
        this.d = g10;
    }

    public void k(String string2) {
        this.c = string2;
    }

    public void l(Marker marker) {
        this.b = marker;
    }

    public void m(String string2) {
        this.f = string2;
    }

    public void n(String string2) {
        this.e = string2;
    }

    public void o(Throwable throwable) {
        this.i = throwable;
    }

    public void p(long l10) {
        this.h = l10;
    }
}

