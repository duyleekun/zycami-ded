/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.v.c.b2.w;

import android.graphics.Bitmap;
import d.v.c.v0.q.c;

public class a
extends c {
    private long f;
    private String g;
    private String h;
    private Bitmap i;
    private String j;
    private String k;
    private boolean l;

    public a(long l10, String string2, String string3, boolean bl2) {
        this.f = l10;
        this.g = string2;
        this.h = string3;
        this.l = bl2;
    }

    public String G() {
        return this.g;
    }

    public Bitmap H() {
        return this.i;
    }

    public String I() {
        return this.h;
    }

    public boolean J() {
        return this.l;
    }

    public a K(long l10) {
        this.f = l10;
        return this;
    }

    public a L(String string2) {
        this.j = string2;
        return this;
    }

    public a M(String string2) {
        this.k = string2;
        return this;
    }

    public a N(boolean bl2) {
        this.l = bl2;
        return this;
    }

    public a O(String string2) {
        this.g = string2;
        return this;
    }

    public a P(Bitmap bitmap) {
        this.i = bitmap;
        return this;
    }

    public a Q(String string2) {
        this.h = string2;
        return this;
    }

    public long getId() {
        return this.f;
    }

    public String v() {
        return this.j;
    }

    public String w() {
        return this.k;
    }

    public long x() {
        return this.f;
    }
}

