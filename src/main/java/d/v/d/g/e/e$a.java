/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.v.d.g.e;

import android.net.Uri;
import androidx.camera.core.ImageCapture$OnImageSavedCallback;
import androidx.camera.core.ImageCapture$OutputFileResults;
import androidx.camera.core.ImageCaptureException;
import d.v.d.g.e.e;
import d.v.d.h.f;
import java.util.Objects;

public class e$a
implements ImageCapture$OnImageSavedCallback {
    public final /* synthetic */ e a;

    public e$a(e e10) {
        this.a = e10;
    }

    public void onError(ImageCaptureException imageCaptureException) {
    }

    public void onImageSaved(ImageCapture$OutputFileResults imageCapture$OutputFileResults) {
        imageCapture$OutputFileResults = imageCapture$OutputFileResults.getSavedUri();
        Objects.requireNonNull(imageCapture$OutputFileResults);
        f.a(((Uri)imageCapture$OutputFileResults).toString());
    }
}

