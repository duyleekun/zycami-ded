/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.camera2.internal.CaptureSession$3;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import java.util.concurrent.CancellationException;

public class CaptureSession$2
implements FutureCallback {
    public final /* synthetic */ CaptureSession this$0;

    public CaptureSession$2(CaptureSession captureSession) {
        this.this$0 = captureSession;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onFailure(Throwable object) {
        this.this$0.mSynchronizedCaptureSessionOpener.stop();
        Object object2 = this.this$0.mStateLock;
        synchronized (object2) {
            Object object3 = CaptureSession$3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
            Object object4 = this.this$0;
            object4 = ((CaptureSession)object4).mState;
            int n10 = ((Enum)object4).ordinal();
            int n11 = object3[n10];
            n10 = 4;
            if ((n11 == n10 || n11 == (n10 = 6) || n11 == (n10 = 7)) && (n11 = object instanceof CancellationException) == 0) {
                object3 = "CaptureSession";
                object4 = new StringBuilder();
                Object object5 = "Opening session with fail ";
                ((StringBuilder)object4).append((String)object5);
                object5 = this.this$0;
                object5 = ((CaptureSession)object5).mState;
                ((StringBuilder)object4).append(object5);
                object4 = ((StringBuilder)object4).toString();
                Logger.w((String)object3, (String)object4, (Throwable)object);
                object = this.this$0;
                ((CaptureSession)object).finishClose();
            }
            return;
        }
    }

    public void onSuccess(Void void_) {
    }
}

