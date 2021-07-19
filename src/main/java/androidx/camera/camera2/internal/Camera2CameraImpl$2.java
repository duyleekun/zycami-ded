/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraAccessException
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurface$SurfaceClosedException;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

public class Camera2CameraImpl$2
implements FutureCallback {
    public final /* synthetic */ Camera2CameraImpl this$0;

    public Camera2CameraImpl$2(Camera2CameraImpl camera2CameraImpl) {
        this.this$0 = camera2CameraImpl;
    }

    public void onFailure(Throwable object) {
        block9: {
            block6: {
                boolean bl2;
                block8: {
                    block7: {
                        block5: {
                            bl2 = object instanceof CameraAccessException;
                            if (!bl2) break block5;
                            Camera2CameraImpl camera2CameraImpl = this.this$0;
                            StringBuilder stringBuilder = new StringBuilder();
                            String string2 = "Unable to configure camera due to ";
                            stringBuilder.append(string2);
                            object = ((Throwable)object).getMessage();
                            stringBuilder.append((String)object);
                            object = stringBuilder.toString();
                            camera2CameraImpl.debugLog((String)object);
                            break block6;
                        }
                        bl2 = object instanceof CancellationException;
                        if (!bl2) break block7;
                        object = this.this$0;
                        String string3 = "Unable to configure camera cancelled";
                        ((Camera2CameraImpl)object).debugLog(string3);
                        break block6;
                    }
                    bl2 = object instanceof DeferrableSurface$SurfaceClosedException;
                    if (!bl2) break block8;
                    Camera2CameraImpl camera2CameraImpl = this.this$0;
                    object = ((DeferrableSurface$SurfaceClosedException)object).getDeferrableSurface();
                    if ((object = camera2CameraImpl.findSessionConfigForSurface((DeferrableSurface)object)) != null) {
                        camera2CameraImpl = this.this$0;
                        camera2CameraImpl.postSurfaceClosedError((SessionConfig)object);
                    }
                    break block6;
                }
                bl2 = object instanceof TimeoutException;
                if (!bl2) break block9;
                object = new StringBuilder();
                ((StringBuilder)object).append("Unable to configure camera ");
                String string4 = this.this$0.mCameraInfoInternal.getCameraId();
                ((StringBuilder)object).append(string4);
                ((StringBuilder)object).append(", timeout!");
                object = ((StringBuilder)object).toString();
                string4 = "Camera2CameraImpl";
                Logger.e(string4, (String)object);
            }
            return;
        }
        RuntimeException runtimeException = new RuntimeException((Throwable)object);
        throw runtimeException;
    }

    public void onSuccess(Void void_) {
    }
}

