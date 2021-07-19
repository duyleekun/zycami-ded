/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$Face
 *  android.hardware.Camera$FaceDetectionListener
 */
package d.v.d.g.c;

import android.hardware.Camera;
import d.v.d.g.c.r;

public final class c
implements Camera.FaceDetectionListener {
    public final /* synthetic */ r a;

    public /* synthetic */ c(r r10) {
        this.a = r10;
    }

    public final void onFaceDetection(Camera.Face[] faceArray, Camera camera) {
        this.a.E(faceArray, camera);
    }
}

