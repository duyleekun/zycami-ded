/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$PictureCallback
 *  android.util.Size
 */
package d.v.d.g.c.y;

import android.hardware.Camera;
import android.util.Size;
import d.v.d.e;
import d.v.d.g.c.r;
import d.v.d.g.c.y.a;
import d.v.d.g.c.y.h;
import d.v.d.h.f;
import d.v.d.i.e.b;
import d.v.d.i.e.c;
import d.v.d.i.f.l;

public class g
extends r {
    public h j;

    public g(e e10) {
        h h10;
        f.a("init camera1photo");
        this.j = h10 = new h(this, e10);
        this.A(h10);
    }

    private /* synthetic */ void S(byte[] object, Camera object2) {
        object2 = this.R();
        Integer n10 = 2;
        ((d.v.d.i.e.g)object2).r(n10);
        object2 = this.O();
        boolean bl2 = this.U();
        int n11 = this.j.n();
        ((b)object2).o((byte[])object, bl2, n11);
        object = this.R();
        object2 = 3;
        ((d.v.d.i.e.g)object).r((Integer)object2);
        this.b.startPreview();
        boolean bl3 = this.l().j();
        this.f(bl3);
    }

    private boolean U() {
        d.v.d.i.a.a a10 = this.P();
        boolean bl2 = ((c)a10).n();
        if (bl2 && (bl2 = ((l)(a10 = this.p())).s())) {
            bl2 = true;
        } else {
            bl2 = false;
            a10 = null;
        }
        return bl2;
    }

    public b O() {
        return this.j.N0();
    }

    public c P() {
        return this.j.a.l0();
    }

    public d.v.d.i.e.f Q() {
        return this.j.a.m0();
    }

    public d.v.d.i.e.g R() {
        return this.j.P0();
    }

    public /* synthetic */ void T(byte[] byArray, Camera camera) {
        this.S(byArray, camera);
    }

    public void V() {
        f.a("take photo ");
        d.v.d.i.e.g g10 = this.R();
        int n10 = g10.o();
        if (n10 == 0 && (n10 = (g10 = this.R()).o()) == 0) {
            g10 = this.b;
            if (g10 != null && (g10 = this.e) != null) {
                g10 = this.R();
                Object object = 1;
                g10.r((Integer)object);
                g10 = this.e;
                int n11 = this.j.n();
                g10.setRotation(n11);
                g10 = (Size)this.Q().get();
                object = new StringBuilder();
                ((StringBuilder)object).append("photoSize =");
                ((StringBuilder)object).append(g10);
                f.a(((StringBuilder)object).toString());
                object = this.e;
                int n12 = g10.getWidth();
                n10 = g10.getHeight();
                object.setPictureSize(n12, n10);
                this.K();
                g10 = this.b;
                object = new a(this);
                g10.takePicture(null, null, (Camera.PictureCallback)object);
                return;
            }
            f.a("current is mCamera1 or mParameters==null ,return");
            return;
        }
        f.a("current is photo start or prepare ,return");
    }
}

