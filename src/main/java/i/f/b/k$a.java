/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CameraDevice$StateCallback
 */
package i.f.b;

import android.hardware.camera2.CameraDevice;
import i.f.b.k;

public class k$a
extends CameraDevice.StateCallback {
    public final /* synthetic */ k a;

    public k$a(k k10) {
        this.a = k10;
    }

    public void onDisconnected(CameraDevice cameraDevice) {
        cameraDevice.close();
        k.u(this.a, null);
    }

    public void onError(CameraDevice cameraDevice, int n10) {
        cameraDevice.close();
        k.u(this.a, null);
    }

    public void onOpened(CameraDevice cameraDevice) {
        k.u(this.a, cameraDevice);
        k.v(this.a);
    }
}

