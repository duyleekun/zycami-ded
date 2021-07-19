/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraInfoImpl$RedirectableLiveData;
import androidx.lifecycle.Observer;

public final class w0
implements Observer {
    public final /* synthetic */ Camera2CameraInfoImpl$RedirectableLiveData a;

    public /* synthetic */ w0(Camera2CameraInfoImpl$RedirectableLiveData redirectableLiveData) {
        this.a = redirectableLiveData;
    }

    public final void onChanged(Object object) {
        this.a.setValue(object);
    }
}

