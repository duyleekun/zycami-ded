/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.Surface
 */
package d.v.b0.b;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import d.v.b0.h.a;
import java.util.Objects;

public class c {
    private Object a;
    private a b;
    private boolean c;
    private String d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private int j;

    public c(int n10, int n11) {
        this.c = true;
        this.e = false;
        this.f = false;
        if (n10 > 0 && n11 > 0) {
            this.i = n10;
            this.j = n11;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("");
            n11 = this.hashCode();
            charSequence.append(n11);
            long l10 = System.currentTimeMillis();
            charSequence.append(l10);
            charSequence = charSequence.toString();
            this.d = charSequence;
            this.c = false;
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("params width and height of OutputSurfaceConstructor , must be > 0");
        throw illegalArgumentException;
    }

    public c(Object object, boolean bl2, a object2) {
        boolean bl3;
        this.c = bl3 = true;
        this.e = false;
        this.f = false;
        String string2 = "param surface of OutputSurface Constructor can not be null.";
        Objects.requireNonNull(object, string2);
        boolean bl4 = object instanceof Surface;
        if (!bl4 && !(bl4 = object instanceof SurfaceTexture)) {
            object = new IllegalArgumentException("param surface of OutputSurface Constructor ,must be surface or surfaceTexture.");
            throw object;
        }
        this.a = object;
        this.b = object2;
        object2 = new StringBuilder();
        object = object.toString();
        ((StringBuilder)object2).append((String)object);
        long l10 = System.currentTimeMillis();
        ((StringBuilder)object2).append(l10);
        this.d = object = ((StringBuilder)object2).toString();
        this.c = bl3;
        this.f = bl2;
    }

    public int a() {
        return this.j;
    }

    public String b() {
        return this.d;
    }

    public boolean c() {
        return this.f;
    }

    public int d() {
        return this.h;
    }

    public int e() {
        return this.g;
    }

    public Object f() {
        return this.a;
    }

    public int g() {
        return this.i;
    }

    public boolean h() {
        return this.e;
    }

    public boolean i() {
        return this.c;
    }

    public void j(boolean bl2) {
        this.e = bl2;
    }

    public void k(int n10) {
        this.h = n10;
    }

    public void l(int n10) {
        this.g = n10;
    }
}

