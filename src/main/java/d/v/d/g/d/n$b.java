/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 */
package d.v.d.g.d;

import android.hardware.camera2.CameraCaptureSession;
import d.v.d.g.d.n;
import d.v.d.h.f;
import d.v.d.i.b.d;
import d.v.d.i.c.c;

public class n$b
extends CameraCaptureSession.StateCallback {
    public final /* synthetic */ n a;

    public n$b(n n10) {
        this.a = n10;
    }

    public void onConfigureFailed(CameraCaptureSession object) {
        f.a("session onConfigured Failed ");
        object = this.a.p();
        Integer n10 = 5;
        ((c)object).s(n10);
        object = this.a.E();
        n10 = 4;
        ((d)object).q(n10);
        n.e(this.a);
    }

    public void onConfigured(CameraCaptureSession object) {
        f.a("session onConfigured succeed");
        Object object2 = this.a;
        ((n)object2).d = object;
        object = ((n)object2).p();
        object2 = 3;
        ((c)object).s((Integer)object2);
        n.f(this.a);
        n.e(this.a);
    }
}

