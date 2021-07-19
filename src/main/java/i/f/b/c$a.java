/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CameraDevice$StateCallback
 */
package i.f.b;

import android.hardware.camera2.CameraDevice;
import i.f.b.c;

public class c$a
extends CameraDevice.StateCallback {
    public final /* synthetic */ c a;

    public c$a(c c10) {
        this.a = c10;
    }

    public void onDisconnected(CameraDevice cameraDevice) {
        cameraDevice.close();
        c.w(this.a, null);
        c.x(this.a).release();
    }

    public void onError(CameraDevice cameraDevice, int n10) {
        cameraDevice.close();
        c.w(this.a, null);
        c.x(this.a).release();
    }

    public void onOpened(CameraDevice cameraDevice) {
        c.w(this.a, cameraDevice);
        c.x(this.a).release();
        c.y(this.a);
    }
}

