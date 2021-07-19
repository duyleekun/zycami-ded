/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$PreviewCallback
 */
package d.v.d.g.c;

import android.hardware.Camera;
import d.v.d.g.c.r;

public final class b
implements Camera.PreviewCallback {
    public final /* synthetic */ r a;

    public /* synthetic */ b(r r10) {
        this.a = r10;
    }

    public final void onPreviewFrame(byte[] byArray, Camera camera) {
        this.a.C(byArray, camera);
    }
}

