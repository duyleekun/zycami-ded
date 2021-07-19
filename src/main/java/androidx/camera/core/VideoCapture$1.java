/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.UseCase;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$ErrorListener;
import androidx.camera.core.impl.SessionConfig$SessionError;

public class VideoCapture$1
implements SessionConfig$ErrorListener {
    public final /* synthetic */ VideoCapture this$0;
    public final /* synthetic */ String val$cameraId;
    public final /* synthetic */ Size val$resolution;

    public VideoCapture$1(VideoCapture videoCapture, String string2, Size size) {
        this.this$0 = videoCapture;
        this.val$cameraId = string2;
        this.val$resolution = size;
    }

    public void onError(SessionConfig object, SessionConfig$SessionError object2) {
        object = this.this$0;
        object2 = this.val$cameraId;
        boolean bl2 = ((UseCase)object).isCurrentCamera((String)object2);
        if (bl2) {
            object = this.this$0;
            object2 = this.val$cameraId;
            Size size = this.val$resolution;
            ((VideoCapture)object).setupEncoder((String)object2, size);
            object = this.this$0;
            ((UseCase)object).notifyReset();
        }
    }
}

