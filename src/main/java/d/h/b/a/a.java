/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  androidx.camera.core.Preview$OnPreviewOutputUpdateListener
 *  androidx.camera.core.Preview$PreviewOutput
 */
package d.h.b.a;

import android.app.Activity;
import androidx.camera.core.Preview;
import com.google.mediapipe.components.CameraHelper$CameraFacing;
import com.google.mediapipe.components.CameraXPreviewHelper;

public final class a
implements Preview.OnPreviewOutputUpdateListener {
    public final /* synthetic */ CameraXPreviewHelper a;
    public final /* synthetic */ CameraHelper$CameraFacing b;
    public final /* synthetic */ Activity c;

    public /* synthetic */ a(CameraXPreviewHelper cameraXPreviewHelper, CameraHelper$CameraFacing cameraHelper$CameraFacing, Activity activity) {
        this.a = cameraXPreviewHelper;
        this.b = cameraHelper$CameraFacing;
        this.c = activity;
    }

    public final void a(Preview.PreviewOutput previewOutput) {
        CameraXPreviewHelper cameraXPreviewHelper = this.a;
        CameraHelper$CameraFacing cameraHelper$CameraFacing = this.b;
        Activity activity = this.c;
        cameraXPreviewHelper.lambda$startCamera$0$CameraXPreviewHelper(cameraHelper$CameraFacing, activity, previewOutput);
    }
}

