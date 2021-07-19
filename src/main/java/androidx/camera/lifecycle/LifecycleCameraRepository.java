/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.lifecycle;

import androidx.camera.core.ViewPort;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.internal.CameraUseCaseAdapter$CameraException;
import androidx.camera.core.internal.CameraUseCaseAdapter$CameraId;
import androidx.camera.lifecycle.LifecycleCamera;
import androidx.camera.lifecycle.LifecycleCameraRepository$Key;
import androidx.camera.lifecycle.LifecycleCameraRepository$LifecycleCameraRepositoryObserver;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class LifecycleCameraRepository {
    private final ArrayDeque mActiveLifecycleOwners;
    private final Map mCameraMap;
    private final Map mLifecycleObserverMap;
    private final Object mLock;

    public LifecycleCameraRepository() {
        Cloneable cloneable = new Cloneable();
        this.mLock = cloneable;
        this.mCameraMap = cloneable = new Cloneable();
        this.mLifecycleObserverMap = cloneable = new Cloneable();
        this.mActiveLifecycleOwners = cloneable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private LifecycleCameraRepository$LifecycleCameraRepositoryObserver getLifecycleCameraRepositoryObserver(LifecycleOwner lifecycleOwner) {
        Object object = this.mLock;
        synchronized (object) {
            Object object2;
            LifecycleOwner lifecycleOwner2;
            boolean bl2;
            Iterator iterator2 = this.mLifecycleObserverMap;
            iterator2 = iterator2.keySet();
            iterator2 = iterator2.iterator();
            do {
                boolean bl3;
                if (!(bl3 = iterator2.hasNext())) {
                    return null;
                }
                object2 = iterator2.next();
            } while (!(bl2 = lifecycleOwner.equals(lifecycleOwner2 = ((LifecycleCameraRepository$LifecycleCameraRepositoryObserver)(object2 = (LifecycleCameraRepository$LifecycleCameraRepositoryObserver)object2)).getLifecycleOwner())));
            return object2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean hasUseCaseBound(LifecycleOwner iterator2) {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2;
            iterator2 = this.getLifecycleCameraRepositoryObserver((LifecycleOwner)((Object)iterator2));
            if (iterator2 == null) {
                return false;
            }
            Object object2 = this.mLifecycleObserverMap;
            iterator2 = object2.get(iterator2);
            iterator2 = (Set)((Object)iterator2);
            iterator2 = iterator2.iterator();
            do {
                if (!(bl2 = iterator2.hasNext())) {
                    return false;
                }
                object2 = iterator2.next();
                object2 = (LifecycleCameraRepository$Key)object2;
                Map map = this.mCameraMap;
                object2 = map.get(object2);
                object2 = (LifecycleCamera)object2;
                object2 = Preconditions.checkNotNull(object2);
                object2 = (LifecycleCamera)object2;
            } while (bl2 = (object2 = ((LifecycleCamera)object2).getUseCases()).isEmpty());
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void registerCamera(LifecycleCamera lifecycleObserver) {
        Object object = this.mLock;
        synchronized (object) {
            Set<Object> set;
            Object object2 = lifecycleObserver.getLifecycleOwner();
            Object object3 = lifecycleObserver.getCameraUseCaseAdapter();
            object3 = ((CameraUseCaseAdapter)object3).getCameraId();
            object3 = LifecycleCameraRepository$Key.create((LifecycleOwner)object2, (CameraUseCaseAdapter$CameraId)object3);
            LifecycleCameraRepository$LifecycleCameraRepositoryObserver lifecycleCameraRepository$LifecycleCameraRepositoryObserver = this.getLifecycleCameraRepositoryObserver((LifecycleOwner)object2);
            if (lifecycleCameraRepository$LifecycleCameraRepositoryObserver != null) {
                set = this.mLifecycleObserverMap;
                set = set.get(lifecycleCameraRepository$LifecycleCameraRepositoryObserver);
                set = set;
            } else {
                set = new Set<Object>();
            }
            set.add(object3);
            Map map = this.mCameraMap;
            map.put(object3, lifecycleObserver);
            if (lifecycleCameraRepository$LifecycleCameraRepositoryObserver == null) {
                lifecycleObserver = new LifecycleCameraRepository$LifecycleCameraRepositoryObserver((LifecycleOwner)object2, this);
                object3 = this.mLifecycleObserverMap;
                object3.put(lifecycleObserver, set);
                object2 = object2.getLifecycle();
                ((Lifecycle)object2).addObserver(lifecycleObserver);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void suspendUseCases(LifecycleOwner iterator2) {
        Object object = this.mLock;
        synchronized (object) {
            iterator2 = this.getLifecycleCameraRepositoryObserver((LifecycleOwner)((Object)iterator2));
            Object object2 = this.mLifecycleObserverMap;
            iterator2 = object2.get(iterator2);
            iterator2 = (Set)((Object)iterator2);
            iterator2 = iterator2.iterator();
            boolean bl2;
            while (bl2 = iterator2.hasNext()) {
                object2 = iterator2.next();
                object2 = (LifecycleCameraRepository$Key)object2;
                Map map = this.mCameraMap;
                object2 = map.get(object2);
                object2 = (LifecycleCamera)object2;
                object2 = Preconditions.checkNotNull(object2);
                object2 = (LifecycleCamera)object2;
                ((LifecycleCamera)object2).suspend();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void unsuspendUseCases(LifecycleOwner iterator2) {
        Object object = this.mLock;
        synchronized (object) {
            iterator2 = this.getLifecycleCameraRepositoryObserver((LifecycleOwner)((Object)iterator2));
            Object object2 = this.mLifecycleObserverMap;
            iterator2 = object2.get(iterator2);
            iterator2 = (Set)((Object)iterator2);
            iterator2 = iterator2.iterator();
            boolean bl2;
            while (bl2 = iterator2.hasNext()) {
                object2 = iterator2.next();
                object2 = (LifecycleCameraRepository$Key)object2;
                Object object3 = this.mCameraMap;
                object2 = object3.get(object2);
                object2 = (LifecycleCamera)object2;
                object3 = Preconditions.checkNotNull(object2);
                object3 = (LifecycleCamera)object3;
                boolean bl3 = (object3 = ((LifecycleCamera)object3).getUseCases()).isEmpty();
                if (bl3) continue;
                ((LifecycleCamera)object2).unsuspend();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void bindToLifecycleCamera(LifecycleCamera object, ViewPort object2, Collection collection) {
        Object object3 = this.mLock;
        synchronized (object3) {
            boolean bl2;
            LifecycleOwner lifecycleOwner;
            boolean bl3 = collection.isEmpty();
            if (!bl3) {
                bl3 = true;
            } else {
                bl3 = false;
                lifecycleOwner = null;
            }
            Preconditions.checkArgument(bl3);
            lifecycleOwner = ((LifecycleCamera)object).getLifecycleOwner();
            Object object4 = this.getLifecycleCameraRepositoryObserver(lifecycleOwner);
            Object object5 = this.mLifecycleObserverMap;
            object4 = object5.get(object4);
            object4 = (Set)object4;
            object4 = object4.iterator();
            while (bl2 = object4.hasNext()) {
                object5 = object4.next();
                object5 = (LifecycleCameraRepository$Key)object5;
                Map map = this.mCameraMap;
                object5 = map.get(object5);
                object5 = (LifecycleCamera)object5;
                object5 = Preconditions.checkNotNull(object5);
                boolean bl4 = (object5 = (LifecycleCamera)object5).equals(object);
                if (bl4 || (bl2 = (object5 = ((LifecycleCamera)object5).getUseCases()).isEmpty())) continue;
                object2 = "Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner.";
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
            try {
                object4 = ((LifecycleCamera)object).getCameraUseCaseAdapter();
                ((CameraUseCaseAdapter)object4).setViewPort((ViewPort)object2);
                ((LifecycleCamera)object).bind(collection);
                object = lifecycleOwner.getLifecycle();
                object = ((Lifecycle)object).getCurrentState();
                object2 = Lifecycle$State.STARTED;
                boolean bl5 = ((Lifecycle$State)((Object)object)).isAtLeast((Lifecycle$State)((Object)object2));
                if (bl5) {
                    this.setActive(lifecycleOwner);
                }
            }
            catch (CameraUseCaseAdapter$CameraException cameraUseCaseAdapter$CameraException) {
                String string2 = cameraUseCaseAdapter$CameraException.getMessage();
                object2 = new IllegalArgumentException(string2);
                throw object2;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clear() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mLifecycleObserverMap;
            object2 = object2.keySet();
            Object object3 = new HashSet(object2);
            object3 = object3.iterator();
            boolean bl2;
            while (bl2 = object3.hasNext()) {
                object2 = object3.next();
                object2 = (LifecycleCameraRepository$LifecycleCameraRepositoryObserver)object2;
                object2 = ((LifecycleCameraRepository$LifecycleCameraRepositoryObserver)object2).getLifecycleOwner();
                this.unregisterLifecycle((LifecycleOwner)object2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public LifecycleCamera createLifecycleCamera(LifecycleOwner object, CameraUseCaseAdapter object2) {
        Object object3 = this.mLock;
        synchronized (object3) {
            boolean bl2;
            Object object4 = ((CameraUseCaseAdapter)object2).getCameraId();
            object4 = LifecycleCameraRepository$Key.create((LifecycleOwner)object, (CameraUseCaseAdapter$CameraId)object4);
            Object object5 = this.mCameraMap;
            object4 = object5.get(object4);
            if (object4 == null) {
                bl2 = true;
            } else {
                bl2 = false;
                object4 = null;
            }
            object5 = "LifecycleCamera already exists for the given LifecycleOwner and set of cameras";
            Preconditions.checkArgument(bl2, object5);
            object4 = object.getLifecycle();
            object4 = ((Lifecycle)object4).getCurrentState();
            object5 = Lifecycle$State.DESTROYED;
            if (object4 == object5) {
                object2 = "Trying to create LifecycleCamera with destroyed lifecycle.";
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
            object4 = new LifecycleCamera((LifecycleOwner)object, (CameraUseCaseAdapter)object2);
            object = ((CameraUseCaseAdapter)object2).getUseCases();
            boolean bl3 = object.isEmpty();
            if (bl3) {
                ((LifecycleCamera)object4).suspend();
            }
            this.registerCamera((LifecycleCamera)object4);
            return object4;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public LifecycleCamera getLifecycleCamera(LifecycleOwner object, CameraUseCaseAdapter$CameraId cameraUseCaseAdapter$CameraId) {
        Object object2 = this.mLock;
        synchronized (object2) {
            Map map = this.mCameraMap;
            object = LifecycleCameraRepository$Key.create((LifecycleOwner)object, cameraUseCaseAdapter$CameraId);
            object = map.get(object);
            return (LifecycleCamera)object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Collection getLifecycleCameras() {
        Object object = this.mLock;
        synchronized (object) {
            Collection collection = this.mCameraMap;
            collection = collection.values();
            return Collections.unmodifiableCollection(collection);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setActive(LifecycleOwner lifecycleOwner) {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.hasUseCaseBound(lifecycleOwner);
            if (!bl2) {
                return;
            }
            Object object2 = this.mActiveLifecycleOwners;
            bl2 = ((ArrayDeque)object2).isEmpty();
            if (bl2) {
                object2 = this.mActiveLifecycleOwners;
                ((ArrayDeque)object2).push(lifecycleOwner);
            } else {
                object2 = this.mActiveLifecycleOwners;
                object2 = ((ArrayDeque)object2).peek();
                boolean bl3 = lifecycleOwner.equals(object2 = (LifecycleOwner)object2);
                if (!bl3) {
                    this.suspendUseCases((LifecycleOwner)object2);
                    object2 = this.mActiveLifecycleOwners;
                    ((ArrayDeque)object2).remove(lifecycleOwner);
                    object2 = this.mActiveLifecycleOwners;
                    ((ArrayDeque)object2).push(lifecycleOwner);
                }
            }
            this.unsuspendUseCases(lifecycleOwner);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setInactive(LifecycleOwner object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            ArrayDeque arrayDeque = this.mActiveLifecycleOwners;
            arrayDeque.remove(object);
            this.suspendUseCases((LifecycleOwner)object);
            object = this.mActiveLifecycleOwners;
            boolean bl2 = ((ArrayDeque)object).isEmpty();
            if (!bl2) {
                object = this.mActiveLifecycleOwners;
                object = ((ArrayDeque)object).peek();
                object = (LifecycleOwner)object;
                this.unsuspendUseCases((LifecycleOwner)object);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unbind(Collection collection) {
        Object object = this.mLock;
        synchronized (object) {
            Iterator iterator2 = this.mCameraMap;
            iterator2 = iterator2.keySet();
            iterator2 = iterator2.iterator();
            boolean bl2;
            while (bl2 = iterator2.hasNext()) {
                Object object2 = iterator2.next();
                object2 = (LifecycleCameraRepository$Key)object2;
                Object object3 = this.mCameraMap;
                object2 = object3.get(object2);
                object3 = ((LifecycleCamera)(object2 = (LifecycleCamera)object2)).getUseCases();
                boolean bl3 = object3.isEmpty();
                if (!bl3) {
                    bl3 = true;
                } else {
                    bl3 = false;
                    object3 = null;
                }
                ((LifecycleCamera)object2).unbind(collection);
                if (!bl3 || !(bl3 = (object3 = ((LifecycleCamera)object2).getUseCases()).isEmpty())) continue;
                object2 = ((LifecycleCamera)object2).getLifecycleOwner();
                this.setInactive((LifecycleOwner)object2);
            }
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
            Iterator iterator2 = this.mCameraMap;
            iterator2 = iterator2.keySet();
            iterator2 = iterator2.iterator();
            boolean bl2;
            while (bl2 = iterator2.hasNext()) {
                Object object2 = iterator2.next();
                object2 = (LifecycleCameraRepository$Key)object2;
                Map map = this.mCameraMap;
                object2 = map.get(object2);
                object2 = (LifecycleCamera)object2;
                ((LifecycleCamera)object2).unbindAll();
                object2 = ((LifecycleCamera)object2).getLifecycleOwner();
                this.setInactive((LifecycleOwner)object2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unregisterLifecycle(LifecycleOwner object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            LifecycleCameraRepository$LifecycleCameraRepositoryObserver lifecycleCameraRepository$LifecycleCameraRepositoryObserver = this.getLifecycleCameraRepositoryObserver((LifecycleOwner)object);
            if (lifecycleCameraRepository$LifecycleCameraRepositoryObserver == null) {
                return;
            }
            this.setInactive((LifecycleOwner)object);
            object = this.mLifecycleObserverMap;
            object = object.get(lifecycleCameraRepository$LifecycleCameraRepositoryObserver);
            object = (Set)object;
            object = object.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    object = this.mLifecycleObserverMap;
                    object.remove(lifecycleCameraRepository$LifecycleCameraRepositoryObserver);
                    object = lifecycleCameraRepository$LifecycleCameraRepositoryObserver.getLifecycleOwner();
                    object = object.getLifecycle();
                    ((Lifecycle)object).removeObserver(lifecycleCameraRepository$LifecycleCameraRepositoryObserver);
                    return;
                }
                Object object3 = object.next();
                object3 = (LifecycleCameraRepository$Key)object3;
                Map map = this.mCameraMap;
                map.remove(object3);
            }
        }
    }
}

