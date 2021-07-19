/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.impl;

import androidx.camera.camera2.impl.CameraEventCallback;
import androidx.camera.core.impl.CaptureConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CameraEventCallbacks$ComboCameraEventCallback {
    private final List mCallbacks;

    public CameraEventCallbacks$ComboCameraEventCallback(List object) {
        boolean bl2;
        Object object2 = new ArrayList();
        this.mCallbacks = object2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (CameraEventCallback)object.next();
            List list = this.mCallbacks;
            list.add(object2);
        }
    }

    public List getCallbacks() {
        return this.mCallbacks;
    }

    public List onDisableSession() {
        boolean bl2;
        ArrayList<CaptureConfig> arrayList = new ArrayList<CaptureConfig>();
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CaptureConfig captureConfig = ((CameraEventCallback)iterator2.next()).onDisableSession();
            if (captureConfig == null) continue;
            arrayList.add(captureConfig);
        }
        return arrayList;
    }

    public List onEnableSession() {
        boolean bl2;
        ArrayList<CaptureConfig> arrayList = new ArrayList<CaptureConfig>();
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CaptureConfig captureConfig = ((CameraEventCallback)iterator2.next()).onEnableSession();
            if (captureConfig == null) continue;
            arrayList.add(captureConfig);
        }
        return arrayList;
    }

    public List onPresetSession() {
        boolean bl2;
        ArrayList<CaptureConfig> arrayList = new ArrayList<CaptureConfig>();
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CaptureConfig captureConfig = ((CameraEventCallback)iterator2.next()).onPresetSession();
            if (captureConfig == null) continue;
            arrayList.add(captureConfig);
        }
        return arrayList;
    }

    public List onRepeating() {
        boolean bl2;
        ArrayList<CaptureConfig> arrayList = new ArrayList<CaptureConfig>();
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CaptureConfig captureConfig = ((CameraEventCallback)iterator2.next()).onRepeating();
            if (captureConfig == null) continue;
            arrayList.add(captureConfig);
        }
        return arrayList;
    }
}

