/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.Camera;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInternal$State;
import androidx.camera.core.impl.CameraStateRegistry$CameraRegistration;
import androidx.camera.core.impl.CameraStateRegistry$OnOpenAvailableListener;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;

public final class CameraStateRegistry {
    private static final String TAG = "CameraStateRegistry";
    private int mAvailableCameras;
    private final Map mCameraStates;
    private final StringBuilder mDebugString;
    private final Object mLock;
    private final int mMaxAllowedOpenedCameras;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CameraStateRegistry(int n10) {
        Object object = new StringBuilder();
        this.mDebugString = object;
        this.mLock = object = new Object();
        object = new HashMap();
        this.mCameraStates = object;
        this.mMaxAllowedOpenedCameras = n10;
        object = "mLock";
        synchronized (object) {
            this.mAvailableCameras = n10;
            return;
        }
    }

    private static boolean isOpen(CameraInternal$State cameraInternal$State) {
        boolean bl2;
        if (cameraInternal$State != null && (bl2 = cameraInternal$State.holdsCameraSlot())) {
            bl2 = true;
        } else {
            bl2 = false;
            cameraInternal$State = null;
        }
        return bl2;
    }

    private void recalculateAvailableCameras() {
        int n10;
        boolean bl2;
        Object object;
        Object[] objectArray;
        Object object2;
        Object object3;
        String string2 = TAG;
        boolean bl3 = Logger.isDebugEnabled(string2);
        Object object4 = "-------------------------------------------------------------------\n";
        Object[] objectArray2 = "%-45s%-22s\n";
        int n11 = 2;
        int n12 = 1;
        if (bl3) {
            this.mDebugString.setLength(0);
            this.mDebugString.append("Recalculating open cameras:\n");
            object3 = this.mDebugString;
            object2 = Locale.US;
            objectArray = new Object[n11];
            objectArray[0] = "Camera";
            object = "State";
            objectArray[n12] = object;
            object2 = String.format((Locale)object2, (String)objectArray2, objectArray);
            ((StringBuilder)object3).append((String)object2);
            object3 = this.mDebugString;
            ((StringBuilder)object3).append((String)object4);
        }
        object3 = this.mCameraStates.entrySet().iterator();
        int n13 = 0;
        object2 = null;
        while (bl2 = object3.hasNext()) {
            objectArray = (Map.Entry)object3.next();
            boolean bl4 = Logger.isDebugEnabled(string2);
            if (bl4) {
                object = ((CameraStateRegistry$CameraRegistration)objectArray.getValue()).getState();
                object = object != null ? ((CameraStateRegistry$CameraRegistration)objectArray.getValue()).getState().toString() : "UNKNOWN";
                StringBuilder stringBuilder = this.mDebugString;
                Locale locale = Locale.US;
                Object[] objectArray3 = new Object[n11];
                String string3 = ((Camera)objectArray.getKey()).toString();
                objectArray3[0] = string3;
                objectArray3[n12] = object;
                object = String.format(locale, (String)objectArray2, objectArray3);
                stringBuilder.append((String)object);
            }
            if (!(bl2 = CameraStateRegistry.isOpen((CameraInternal$State)(objectArray = ((CameraStateRegistry$CameraRegistration)objectArray.getValue()).getState())))) continue;
            ++n13;
        }
        bl3 = Logger.isDebugEnabled(string2);
        if (bl3) {
            Object object5;
            this.mDebugString.append((String)object4);
            object3 = this.mDebugString;
            object4 = Locale.US;
            objectArray2 = new Object[n11];
            objectArray2[0] = object5 = Integer.valueOf(n13);
            n11 = this.mMaxAllowedOpenedCameras;
            objectArray2[n12] = object5 = Integer.valueOf(n11);
            object5 = "Open count: %d (Max allowed: %d)";
            object4 = String.format((Locale)object4, (String)object5, objectArray2);
            ((StringBuilder)object3).append((String)object4);
            object3 = this.mDebugString.toString();
            Logger.d(string2, (String)object3);
        }
        this.mAvailableCameras = n10 = Math.max(this.mMaxAllowedOpenedCameras - n13, 0);
    }

    private CameraInternal$State unregisterCamera(Camera object) {
        Map map = this.mCameraStates;
        if ((object = (CameraStateRegistry$CameraRegistration)map.remove(object)) != null) {
            this.recalculateAvailableCameras();
            return ((CameraStateRegistry$CameraRegistration)object).getState();
        }
        return null;
    }

    private CameraInternal$State updateAndVerifyState(Camera object, CameraInternal$State cameraInternal$State) {
        object = ((CameraStateRegistry$CameraRegistration)Preconditions.checkNotNull((CameraStateRegistry$CameraRegistration)this.mCameraStates.get(object), "Cannot update state of camera which has not yet been registered. Register with CameraStateRegistry.registerCamera()")).setState(cameraInternal$State);
        CameraInternal$State cameraInternal$State2 = CameraInternal$State.OPENING;
        if (cameraInternal$State == cameraInternal$State2) {
            boolean bl2;
            boolean bl3 = CameraStateRegistry.isOpen(cameraInternal$State);
            if (!bl3 && object != cameraInternal$State2) {
                bl2 = false;
                cameraInternal$State2 = null;
            } else {
                bl2 = true;
            }
            String string2 = "Cannot mark camera as opening until camera was successful at calling CameraStateRegistry.tryOpenCamera()";
            Preconditions.checkState(bl2, string2);
        }
        if (object != cameraInternal$State) {
            this.recalculateAvailableCameras();
        }
        return object;
    }

    public void markCameraState(Camera camera, CameraInternal$State cameraInternal$State) {
        this.markCameraState(camera, cameraInternal$State, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void markCameraState(Camera object, CameraInternal$State object2, boolean bl2) {
        int n10;
        Object object3 = this.mLock;
        synchronized (object3) {
            Object object4;
            int n11 = this.mAvailableCameras;
            Object object5 = CameraInternal$State.RELEASED;
            object5 = object2 == object5 ? this.unregisterCamera((Camera)object) : this.updateAndVerifyState((Camera)object, (CameraInternal$State)((Object)object2));
            if (object5 == object2) {
                return;
            }
            int n12 = 1;
            if (n11 < n12 && (n11 = this.mAvailableCameras) > 0) {
                object2 = new HashMap();
                object4 = this.mCameraStates;
                object4 = object4.entrySet();
                object4 = object4.iterator();
                while ((n12 = (int)(object4.hasNext() ? 1 : 0)) != 0) {
                    CameraInternal$State cameraInternal$State;
                    object5 = object4.next();
                    object5 = (Map.Entry)object5;
                    Object object6 = object5.getValue();
                    object6 = (CameraStateRegistry$CameraRegistration)object6;
                    if ((object6 = ((CameraStateRegistry$CameraRegistration)object6).getState()) != (cameraInternal$State = CameraInternal$State.PENDING_OPEN)) continue;
                    object6 = object5.getKey();
                    object6 = (Camera)object6;
                    object5 = object5.getValue();
                    object5 = (CameraStateRegistry$CameraRegistration)object5;
                    object2.put(object6, object5);
                }
            } else {
                object4 = CameraInternal$State.PENDING_OPEN;
                if (object2 != object4) return;
                n10 = this.mAvailableCameras;
                if (n10 <= 0) return;
                object2 = new HashMap();
                object4 = this.mCameraStates;
                object4 = object4.get(object);
                object4 = (CameraStateRegistry$CameraRegistration)object4;
                object2.put(object, object4);
            }
            if (object2 != null && !bl2) {
                object2.remove(object);
            }
        }
        if (object2 == null) return;
        object = object2.values().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = (CameraStateRegistry$CameraRegistration)object.next();
            ((CameraStateRegistry$CameraRegistration)object2).notifyListener();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void registerCamera(Camera camera, Executor executor, CameraStateRegistry$OnOpenAvailableListener cameraStateRegistry$OnOpenAvailableListener) {
        Object object = this.mLock;
        synchronized (object) {
            Map map = this.mCameraStates;
            boolean bl2 = map.containsKey(camera);
            if (!bl2) {
                bl2 = true;
            } else {
                bl2 = false;
                map = null;
            }
            Object object2 = new StringBuilder();
            String string2 = "Camera is already registered: ";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(camera);
            object2 = ((StringBuilder)object2).toString();
            Preconditions.checkState(bl2, (String)object2);
            map = this.mCameraStates;
            string2 = null;
            object2 = new CameraStateRegistry$CameraRegistration(null, executor, cameraStateRegistry$OnOpenAvailableListener);
            map.put(camera, object2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean tryOpenCamera(Camera object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            int n10;
            String string2;
            Object object3;
            Object object4 = this.mCameraStates;
            object4 = object4.get(object);
            object4 = (CameraStateRegistry$CameraRegistration)object4;
            Object object5 = "Camera must first be registered with registerCamera()";
            object4 = Preconditions.checkNotNull(object4, object5);
            object4 = (CameraStateRegistry$CameraRegistration)object4;
            object5 = TAG;
            boolean bl2 = Logger.isDebugEnabled((String)object5);
            int n11 = 1;
            if (bl2) {
                object5 = this.mDebugString;
                ((StringBuilder)object5).setLength(0);
                object5 = this.mDebugString;
                object3 = Locale.US;
                string2 = "tryOpenCamera(%s) [Available Cameras: %d, Already Open: %b (Previous state: %s)]";
                int n12 = 4;
                Object[] objectArray = new Object[n12];
                objectArray[0] = object;
                n10 = this.mAvailableCameras;
                object = n10;
                objectArray[n11] = object;
                n10 = 2;
                Object object6 = ((CameraStateRegistry$CameraRegistration)object4).getState();
                boolean bl3 = CameraStateRegistry.isOpen(object6);
                object6 = bl3;
                objectArray[n10] = object6;
                n10 = 3;
                object6 = ((CameraStateRegistry$CameraRegistration)object4).getState();
                objectArray[n10] = object6;
                object = String.format((Locale)object3, string2, objectArray);
                ((StringBuilder)object5).append((String)object);
            }
            if ((n10 = this.mAvailableCameras) <= 0 && (n10 = (int)(CameraStateRegistry.isOpen((CameraInternal$State)((Object)(object = ((CameraStateRegistry$CameraRegistration)object4).getState()))) ? 1 : 0)) == 0) {
                n10 = 0;
                object = null;
            } else {
                object = CameraInternal$State.OPENING;
                ((CameraStateRegistry$CameraRegistration)object4).setState((CameraInternal$State)((Object)object));
                n10 = n11;
            }
            object4 = TAG;
            boolean bl4 = Logger.isDebugEnabled((String)object4);
            if (bl4) {
                object4 = this.mDebugString;
                object5 = Locale.US;
                object3 = " --> %s";
                Object[] objectArray = new Object[n11];
                string2 = n10 != 0 ? "SUCCESS" : "FAIL";
                objectArray[0] = string2;
                object5 = String.format((Locale)object5, (String)object3, objectArray);
                ((StringBuilder)object4).append((String)object5);
                object4 = TAG;
                object5 = this.mDebugString;
                object5 = ((StringBuilder)object5).toString();
                Logger.d((String)object4, (String)object5);
            }
            if (n10 != 0) {
                this.recalculateAvailableCameras();
            }
            return n10 != 0;
        }
    }
}

