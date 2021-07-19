/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package androidx.camera.view;

import android.content.Context;
import android.util.Log;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.CameraController;
import androidx.lifecycle.LifecycleOwner;

public final class LifecycleCameraController
extends CameraController {
    private static final String TAG = "CamLifecycleController";
    private LifecycleOwner mLifecycleOwner;

    public LifecycleCameraController(Context context) {
        super(context);
    }

    public void bindToLifecycle(LifecycleOwner lifecycleOwner) {
        Threads.checkMainThread();
        this.mLifecycleOwner = lifecycleOwner;
        this.startCameraAndTrackStates();
    }

    public void shutDownForTests() {
        ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider != null) {
            processCameraProvider.unbindAll();
            processCameraProvider = this.mCameraProvider;
            processCameraProvider.shutdown();
        }
    }

    public Camera startCamera() {
        Object object = this.mLifecycleOwner;
        Object object2 = TAG;
        LifecycleOwner lifecycleOwner = null;
        if (object == null) {
            Log.d((String)object2, (String)"Lifecycle is not set.");
            return null;
        }
        object = this.mCameraProvider;
        if (object == null) {
            Log.d((String)object2, (String)"CameraProvider is not ready.");
            return null;
        }
        object = this.createUseCaseGroup();
        if (object == null) {
            return null;
        }
        object2 = this.mCameraProvider;
        lifecycleOwner = this.mLifecycleOwner;
        CameraSelector cameraSelector = this.mCameraSelector;
        return ((ProcessCameraProvider)object2).bindToLifecycle(lifecycleOwner, cameraSelector, (UseCaseGroup)object);
    }

    public void unbind() {
        Threads.checkMainThread();
        this.mLifecycleOwner = null;
        this.mCamera = null;
        ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider != null) {
            processCameraProvider.unbindAll();
        }
    }
}

