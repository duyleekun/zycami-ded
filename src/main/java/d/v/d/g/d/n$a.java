/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CameraDevice$StateCallback
 */
package d.v.d.g.d;

import android.hardware.camera2.CameraDevice;
import d.v.d.g.d.n;
import d.v.d.h.f;
import d.v.d.i.b.d;
import d.v.d.i.c.c;

public class n$a
extends CameraDevice.StateCallback {
    public final /* synthetic */ n a;

    public n$a(n n10) {
        this.a = n10;
    }

    public void onDisconnected(CameraDevice object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("device disconnect getDeviceStatus=");
        c c10 = this.a.p();
        ((StringBuilder)object).append(c10);
        f.a(((StringBuilder)object).toString());
        this.a.j();
    }

    public void onError(CameraDevice object, int n10) {
        object = new StringBuilder();
        ((StringBuilder)object).append("device error error=");
        ((StringBuilder)object).append(n10);
        f.a(((StringBuilder)object).toString());
        object = this.a.p();
        Integer n11 = 5;
        ((c)object).s(n11);
        object = this.a.E();
        n11 = 4;
        ((d)object).q(n11);
        n.e(this.a);
    }

    public void onOpened(CameraDevice cameraDevice) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("device open succeed getDeviceStatus=");
        Object object2 = this.a.p().get();
        ((StringBuilder)object).append(object2);
        f.a(((StringBuilder)object).toString());
        object = this.a;
        ((n)object).c = cameraDevice;
        n.d((n)object);
    }
}

