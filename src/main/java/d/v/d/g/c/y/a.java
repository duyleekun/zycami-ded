/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$PictureCallback
 */
package d.v.d.g.c.y;

import android.hardware.Camera;
import d.v.d.g.c.y.g;

public final class a
implements Camera.PictureCallback {
    public final /* synthetic */ g a;

    public /* synthetic */ a(g g10) {
        this.a = g10;
    }

    public final void onPictureTaken(byte[] byArray, Camera camera) {
        this.a.T(byArray, camera);
    }
}

