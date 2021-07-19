/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.Camera2CameraImpl$InternalState;
import androidx.camera.camera2.internal.Camera2CameraImpl$StateCallback;
import androidx.core.util.Preconditions;
import b.a.a.d.v;
import java.util.concurrent.Executor;

public class Camera2CameraImpl$StateCallback$ScheduledReopen
implements Runnable {
    private boolean mCancelled = false;
    private Executor mExecutor;
    public final /* synthetic */ Camera2CameraImpl$StateCallback this$1;

    public Camera2CameraImpl$StateCallback$ScheduledReopen(Camera2CameraImpl$StateCallback camera2CameraImpl$StateCallback, Executor executor) {
        this.this$1 = camera2CameraImpl$StateCallback;
        this.mExecutor = executor;
    }

    private /* synthetic */ void a() {
        boolean bl2 = this.mCancelled;
        if (!bl2) {
            Object object = this.this$1.this$0.mState;
            Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.REOPENING;
            boolean bl3 = true;
            if (object == camera2CameraImpl$InternalState) {
                bl2 = bl3;
            } else {
                bl2 = false;
                object = null;
            }
            Preconditions.checkState(bl2);
            object = this.this$1.this$0;
            ((Camera2CameraImpl)object).tryOpenCameraDevice(bl3);
        }
    }

    public /* synthetic */ void b() {
        this.a();
    }

    public void cancel() {
        this.mCancelled = true;
    }

    public void run() {
        Executor executor = this.mExecutor;
        v v10 = new v(this);
        executor.execute(v10);
    }
}

