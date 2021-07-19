/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 */
package androidx.camera.camera2.internal;

import android.content.Context;
import android.os.Handler;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.Camera2CameraInfoImpl;
import androidx.camera.camera2.internal.CameraSelectionOptimizer;
import androidx.camera.camera2.internal.CameraUnavailableExceptionHelper;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.CameraThreadConfig;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public final class Camera2CameraFactory
implements CameraFactory {
    private static final int DEFAULT_ALLOWED_CONCURRENT_OPEN_CAMERAS = 1;
    private final List mAvailableCameraIds;
    private final Map mCameraInfos;
    private final CameraManagerCompat mCameraManager;
    private final CameraStateRegistry mCameraStateRegistry;
    private final CameraThreadConfig mThreadConfig;

    public Camera2CameraFactory(Context object, CameraThreadConfig cameraThreadConfig, CameraSelector cameraSelector) {
        Object object2 = new HashMap();
        this.mCameraInfos = object2;
        this.mThreadConfig = cameraThreadConfig;
        this.mCameraStateRegistry = object2 = new CameraStateRegistry(1);
        cameraThreadConfig = cameraThreadConfig.getSchedulerHandler();
        object = CameraManagerCompat.from(object, (Handler)cameraThreadConfig);
        this.mCameraManager = object;
        object = CameraSelectionOptimizer.getSelectedAvailableCameraIds(this, cameraSelector);
        this.mAvailableCameraIds = object;
    }

    public Set getAvailableCameraIds() {
        List list = this.mAvailableCameraIds;
        LinkedHashSet linkedHashSet = new LinkedHashSet(list);
        return linkedHashSet;
    }

    public CameraInternal getCamera(String object) {
        Object object2 = this.mAvailableCameraIds;
        boolean bl2 = object2.contains(object);
        if (bl2) {
            CameraManagerCompat cameraManagerCompat = this.mCameraManager;
            Camera2CameraInfoImpl camera2CameraInfoImpl = this.getCameraInfo((String)object);
            CameraStateRegistry cameraStateRegistry = this.mCameraStateRegistry;
            Executor executor = this.mThreadConfig.getCameraExecutor();
            Handler handler = this.mThreadConfig.getSchedulerHandler();
            object2 = new Camera2CameraImpl(cameraManagerCompat, (String)object, camera2CameraInfoImpl, cameraStateRegistry, executor, handler);
            return object2;
        }
        object = new IllegalArgumentException("The given camera id is not on the available camera id list.");
        throw object;
    }

    public Camera2CameraInfoImpl getCameraInfo(String string2) {
        Object object;
        block9: {
            try {
                object = this.mCameraInfos;
            }
            catch (CameraAccessExceptionCompat cameraAccessExceptionCompat) {
                throw CameraUnavailableExceptionHelper.createFrom(cameraAccessExceptionCompat);
            }
            object = object.get(string2);
            object = (Camera2CameraInfoImpl)object;
            if (object != null) break block9;
            Object object2 = this.mCameraManager;
            object2 = ((CameraManagerCompat)object2).getCameraCharacteristicsCompat(string2);
            object = new Camera2CameraInfoImpl(string2, (CameraCharacteristicsCompat)object2);
            object2 = this.mCameraInfos;
            object2.put(string2, object);
        }
        return object;
    }

    public CameraManagerCompat getCameraManager() {
        return this.mCameraManager;
    }
}

