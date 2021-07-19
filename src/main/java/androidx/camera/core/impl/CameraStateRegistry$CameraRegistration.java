/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInternal$State;
import androidx.camera.core.impl.CameraStateRegistry$OnOpenAvailableListener;
import b.a.b.w1.o;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public class CameraStateRegistry$CameraRegistration {
    private final CameraStateRegistry$OnOpenAvailableListener mCameraAvailableListener;
    private final Executor mNotifyExecutor;
    private CameraInternal$State mState;

    public CameraStateRegistry$CameraRegistration(CameraInternal$State cameraInternal$State, Executor executor, CameraStateRegistry$OnOpenAvailableListener onOpenAvailableListener) {
        this.mState = cameraInternal$State;
        this.mNotifyExecutor = executor;
        this.mCameraAvailableListener = onOpenAvailableListener;
    }

    public CameraInternal$State getState() {
        return this.mState;
    }

    public void notifyListener() {
        Executor executor = this.mNotifyExecutor;
        Object object = this.mCameraAvailableListener;
        Objects.requireNonNull(object);
        Object object2 = new o((CameraStateRegistry$OnOpenAvailableListener)object);
        try {
            executor.execute((Runnable)object2);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            object = "CameraStateRegistry";
            object2 = "Unable to notify camera.";
            Logger.e((String)object, (String)object2, rejectedExecutionException);
        }
    }

    public CameraInternal$State setState(CameraInternal$State cameraInternal$State) {
        CameraInternal$State cameraInternal$State2 = this.mState;
        this.mState = cameraInternal$State;
        return cameraInternal$State2;
    }
}

