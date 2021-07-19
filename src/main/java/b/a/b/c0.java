/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package b.a.b;

import android.util.Size;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$ErrorListener;
import androidx.camera.core.impl.SessionConfig$SessionError;

public final class c0
implements SessionConfig$ErrorListener {
    public final /* synthetic */ ImageCapture a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ImageCaptureConfig c;
    public final /* synthetic */ Size d;

    public /* synthetic */ c0(ImageCapture imageCapture, String string2, ImageCaptureConfig imageCaptureConfig, Size size) {
        this.a = imageCapture;
        this.b = string2;
        this.c = imageCaptureConfig;
        this.d = size;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig$SessionError sessionConfig$SessionError) {
        ImageCapture imageCapture = this.a;
        String string2 = this.b;
        ImageCaptureConfig imageCaptureConfig = this.c;
        Size size = this.d;
        imageCapture.e(string2, imageCaptureConfig, size, sessionConfig, sessionConfig$SessionError);
    }
}

