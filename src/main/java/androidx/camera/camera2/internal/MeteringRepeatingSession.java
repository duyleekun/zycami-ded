/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.params.StreamConfigurationMap
 *  android.os.Build$VERSION
 *  android.util.Size
 *  android.view.Surface
 */
package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.MeteringRepeatingSession$1;
import androidx.camera.camera2.internal.MeteringRepeatingSession$MeteringRepeatingConfig;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$Builder;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import b.a.a.d.x0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Executor;

public class MeteringRepeatingSession {
    private static final String TAG = "MeteringRepeating";
    private DeferrableSurface mDeferrableSurface;
    private final SessionConfig mSessionConfig;

    public MeteringRepeatingSession(CameraCharacteristicsCompat object) {
        Object object2 = new MeteringRepeatingSession$MeteringRepeatingConfig();
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        object = this.getMinimumPreviewSize((CameraCharacteristicsCompat)object);
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("MerteringSession SurfaceTexture size: ");
        ((StringBuilder)object3).append(object);
        object3 = ((StringBuilder)object3).toString();
        Logger.d(TAG, (String)object3);
        int n10 = object.getWidth();
        int n11 = object.getHeight();
        surfaceTexture.setDefaultBufferSize(n10, n11);
        super(surfaceTexture);
        object2 = SessionConfig$Builder.createFrom((UseCaseConfig)object2);
        ((SessionConfig$Builder)object2).setTemplateType(1);
        this.mDeferrableSurface = object3 = new ImmediateSurface((Surface)object);
        object3 = ((DeferrableSurface)object3).getTerminationFuture();
        MeteringRepeatingSession$1 meteringRepeatingSession$1 = new MeteringRepeatingSession$1(this, (Surface)object, surfaceTexture);
        object = CameraXExecutors.directExecutor();
        Futures.addCallback((ListenableFuture)object3, meteringRepeatingSession$1, (Executor)object);
        object = this.mDeferrableSurface;
        ((SessionConfig$Builder)object2).addSurface((DeferrableSurface)object);
        this.mSessionConfig = object = ((SessionConfig$Builder)object2).build();
    }

    public static /* synthetic */ int a(Size size, Size size2) {
        long l10 = size.getWidth();
        long l11 = size.getHeight();
        l10 *= l11;
        l11 = size2.getWidth();
        long l12 = size2.getHeight();
        return Long.signum(l10 - (l11 *= l12));
    }

    private Size getMinimumPreviewSize(CameraCharacteristicsCompat size) {
        Object object = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        size = (StreamConfigurationMap)size.get((CameraCharacteristics.Key)object);
        object = TAG;
        if (size == null) {
            Logger.e((String)object, "Can not retrieve SCALER_STREAM_CONFIGURATION_MAP.");
            size = new Size(0, 0);
            return size;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 < n11) {
            Class<SurfaceTexture> clazz = SurfaceTexture.class;
            size = size.getOutputSizes(clazz);
        } else {
            n10 = 34;
            size = size.getOutputSizes(n10);
        }
        if (size == null) {
            Logger.e((String)object, "Can not get output size list.");
            size = new Size(0, 0);
            return size;
        }
        size = Arrays.asList(size);
        object = x0.a;
        return (Size)Collections.min(size, object);
    }

    public void clear() {
        String string2 = "MeteringRepeating clear!";
        Logger.d(TAG, string2);
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        this.mDeferrableSurface = null;
    }

    public String getName() {
        return TAG;
    }

    public SessionConfig getSessionConfig() {
        return this.mSessionConfig;
    }
}

