/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.lifecycle;

import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public final class LifecycleCamera
implements LifecycleObserver,
Camera {
    private final CameraUseCaseAdapter mCameraUseCaseAdapter;
    private volatile boolean mIsActive;
    private final LifecycleOwner mLifecycleOwner;
    private final Object mLock;
    private boolean mReleased;
    private boolean mSuspended;

    public LifecycleCamera(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter cameraUseCaseAdapter) {
        Object object;
        this.mLock = object = new Object();
        this.mIsActive = false;
        this.mSuspended = false;
        this.mReleased = false;
        this.mLifecycleOwner = lifecycleOwner;
        this.mCameraUseCaseAdapter = cameraUseCaseAdapter;
        object = lifecycleOwner.getLifecycle().getCurrentState();
        Lifecycle$State lifecycle$State = Lifecycle$State.STARTED;
        boolean bl2 = ((Lifecycle$State)((Object)object)).isAtLeast(lifecycle$State);
        if (bl2) {
            cameraUseCaseAdapter.attachUseCases();
        } else {
            cameraUseCaseAdapter.detachUseCases();
        }
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void bind(Collection collection) {
        Object object = this.mLock;
        synchronized (object) {
            CameraUseCaseAdapter cameraUseCaseAdapter = this.mCameraUseCaseAdapter;
            cameraUseCaseAdapter.addUseCases(collection);
            return;
        }
    }

    public CameraControl getCameraControl() {
        return this.mCameraUseCaseAdapter.getCameraControl();
    }

    public CameraInfo getCameraInfo() {
        return this.mCameraUseCaseAdapter.getCameraInfo();
    }

    public LinkedHashSet getCameraInternals() {
        return this.mCameraUseCaseAdapter.getCameraInternals();
    }

    public CameraUseCaseAdapter getCameraUseCaseAdapter() {
        return this.mCameraUseCaseAdapter;
    }

    public CameraConfig getExtendedConfig() {
        return this.mCameraUseCaseAdapter.getExtendedConfig();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public LifecycleOwner getLifecycleOwner() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mLifecycleOwner;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getUseCases() {
        Object object = this.mLock;
        synchronized (object) {
            List list = this.mCameraUseCaseAdapter;
            list = ((CameraUseCaseAdapter)((Object)list)).getUseCases();
            return Collections.unmodifiableList(list);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isActive() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mIsActive;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isBound(UseCase useCase) {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mCameraUseCaseAdapter;
            object2 = ((CameraUseCaseAdapter)object2).getUseCases();
            return object2.contains(useCase);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDestroy(LifecycleOwner object) {
        object = this.mLock;
        synchronized (object) {
            CameraUseCaseAdapter cameraUseCaseAdapter = this.mCameraUseCaseAdapter;
            List list = cameraUseCaseAdapter.getUseCases();
            cameraUseCaseAdapter.removeUseCases(list);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onStart(LifecycleOwner object) {
        object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.mSuspended;
            if (!bl2 && !(bl2 = this.mReleased)) {
                CameraUseCaseAdapter cameraUseCaseAdapter = this.mCameraUseCaseAdapter;
                cameraUseCaseAdapter.attachUseCases();
                this.mIsActive = bl2 = true;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onStop(LifecycleOwner object) {
        object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.mSuspended;
            if (!bl2 && !(bl2 = this.mReleased)) {
                CameraUseCaseAdapter cameraUseCaseAdapter = this.mCameraUseCaseAdapter;
                cameraUseCaseAdapter.detachUseCases();
                bl2 = false;
                cameraUseCaseAdapter = null;
                this.mIsActive = false;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2;
            this.mReleased = bl2 = true;
            bl2 = false;
            Object object2 = null;
            this.mIsActive = false;
            object2 = this.mLifecycleOwner;
            object2 = object2.getLifecycle();
            ((Lifecycle)object2).removeObserver(this);
            return;
        }
    }

    public void setExtendedConfig(CameraConfig cameraConfig) {
        this.mCameraUseCaseAdapter.setExtendedConfig(cameraConfig);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void suspend() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.mSuspended;
            if (bl2) {
                return;
            }
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            this.onStop(lifecycleOwner);
            this.mSuspended = bl2 = true;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unbind(Collection object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            ArrayList arrayList = new ArrayList(object);
            object = this.mCameraUseCaseAdapter;
            object = ((CameraUseCaseAdapter)object).getUseCases();
            arrayList.retainAll((Collection<?>)object);
            object = this.mCameraUseCaseAdapter;
            ((CameraUseCaseAdapter)object).removeUseCases(arrayList);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unbindAll() {
        Object object = this.mLock;
        synchronized (object) {
            CameraUseCaseAdapter cameraUseCaseAdapter = this.mCameraUseCaseAdapter;
            List list = cameraUseCaseAdapter.getUseCases();
            cameraUseCaseAdapter.removeUseCases(list);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unsuspend() {
        Object object = this.mLock;
        synchronized (object) {
            Lifecycle$State lifecycle$State;
            boolean bl2 = this.mSuspended;
            if (!bl2) {
                return;
            }
            bl2 = false;
            Object object2 = null;
            this.mSuspended = false;
            object2 = this.mLifecycleOwner;
            object2 = object2.getLifecycle();
            bl2 = ((Lifecycle$State)((Object)(object2 = ((Lifecycle)object2).getCurrentState()))).isAtLeast(lifecycle$State = Lifecycle$State.STARTED);
            if (bl2) {
                object2 = this.mLifecycleOwner;
                this.onStart((LifecycleOwner)object2);
            }
            return;
        }
    }
}

