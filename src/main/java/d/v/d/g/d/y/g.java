/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.camera2.CameraManager
 *  android.util.Size
 *  android.view.Surface
 */
package d.v.d.g.d.y;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.util.Size;
import android.view.Surface;
import d.v.d.e;
import d.v.d.g.d.n;
import d.v.d.g.d.o;
import d.v.d.g.d.y.h;
import d.v.d.i.g.k;
import d.v.d.i.g.k$a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class g
extends n {
    public h l;

    public g(Context object, e e10) {
        object = (CameraManager)object.getSystemService("camera");
        this.b = object;
        super(this, e10);
        this.l = object;
        this.I((o)object);
    }

    private k V() {
        return this.l.e1();
    }

    public List A() {
        return this.F();
    }

    public List F() {
        Surface[] surfaceArray = ((k$a)this.V().get()).a;
        boolean bl2 = k.s((Size)surfaceArray);
        if (bl2) {
            return Collections.singletonList(this.l.J());
        }
        Surface surface = this.l.J();
        surfaceArray = new Surface[]{surface, surface = this.l.j()};
        return Arrays.asList(surfaceArray);
    }

    public int G() {
        return 3;
    }

    public void b() {
        this.l.q1();
        super.b();
    }
}

