/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.lifecycle;

import androidx.camera.lifecycle.LifecycleCameraRepository;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

public class LifecycleCameraRepository$LifecycleCameraRepositoryObserver
implements LifecycleObserver {
    private final LifecycleCameraRepository mLifecycleCameraRepository;
    private final LifecycleOwner mLifecycleOwner;

    public LifecycleCameraRepository$LifecycleCameraRepositoryObserver(LifecycleOwner lifecycleOwner, LifecycleCameraRepository lifecycleCameraRepository) {
        this.mLifecycleOwner = lifecycleOwner;
        this.mLifecycleCameraRepository = lifecycleCameraRepository;
    }

    public LifecycleOwner getLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        this.mLifecycleCameraRepository.unregisterLifecycle(lifecycleOwner);
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        this.mLifecycleCameraRepository.setActive(lifecycleOwner);
    }

    public void onStop(LifecycleOwner lifecycleOwner) {
        this.mLifecycleCameraRepository.setInactive(lifecycleOwner);
    }
}

