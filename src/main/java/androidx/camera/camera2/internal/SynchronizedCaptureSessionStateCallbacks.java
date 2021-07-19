/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package androidx.camera.camera2.internal;

import android.view.Surface;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class SynchronizedCaptureSessionStateCallbacks
extends SynchronizedCaptureSession$StateCallback {
    private final List mCallbacks;

    public SynchronizedCaptureSessionStateCallbacks(List list) {
        ArrayList arrayList;
        this.mCallbacks = arrayList = new ArrayList();
        arrayList.addAll(list);
    }

    public static SynchronizedCaptureSession$StateCallback createComboCallback(SynchronizedCaptureSession$StateCallback ... object) {
        object = Arrays.asList(object);
        SynchronizedCaptureSessionStateCallbacks synchronizedCaptureSessionStateCallbacks = new SynchronizedCaptureSessionStateCallbacks((List)object);
        return synchronizedCaptureSessionStateCallbacks;
    }

    public void onActive(SynchronizedCaptureSession synchronizedCaptureSession) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            SynchronizedCaptureSession$StateCallback synchronizedCaptureSession$StateCallback = (SynchronizedCaptureSession$StateCallback)iterator2.next();
            synchronizedCaptureSession$StateCallback.onActive(synchronizedCaptureSession);
        }
    }

    public void onCaptureQueueEmpty(SynchronizedCaptureSession synchronizedCaptureSession) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            SynchronizedCaptureSession$StateCallback synchronizedCaptureSession$StateCallback = (SynchronizedCaptureSession$StateCallback)iterator2.next();
            synchronizedCaptureSession$StateCallback.onCaptureQueueEmpty(synchronizedCaptureSession);
        }
    }

    public void onClosed(SynchronizedCaptureSession synchronizedCaptureSession) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            SynchronizedCaptureSession$StateCallback synchronizedCaptureSession$StateCallback = (SynchronizedCaptureSession$StateCallback)iterator2.next();
            synchronizedCaptureSession$StateCallback.onClosed(synchronizedCaptureSession);
        }
    }

    public void onConfigureFailed(SynchronizedCaptureSession synchronizedCaptureSession) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            SynchronizedCaptureSession$StateCallback synchronizedCaptureSession$StateCallback = (SynchronizedCaptureSession$StateCallback)iterator2.next();
            synchronizedCaptureSession$StateCallback.onConfigureFailed(synchronizedCaptureSession);
        }
    }

    public void onConfigured(SynchronizedCaptureSession synchronizedCaptureSession) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            SynchronizedCaptureSession$StateCallback synchronizedCaptureSession$StateCallback = (SynchronizedCaptureSession$StateCallback)iterator2.next();
            synchronizedCaptureSession$StateCallback.onConfigured(synchronizedCaptureSession);
        }
    }

    public void onReady(SynchronizedCaptureSession synchronizedCaptureSession) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            SynchronizedCaptureSession$StateCallback synchronizedCaptureSession$StateCallback = (SynchronizedCaptureSession$StateCallback)iterator2.next();
            synchronizedCaptureSession$StateCallback.onReady(synchronizedCaptureSession);
        }
    }

    public void onSurfacePrepared(SynchronizedCaptureSession synchronizedCaptureSession, Surface surface) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            SynchronizedCaptureSession$StateCallback synchronizedCaptureSession$StateCallback = (SynchronizedCaptureSession$StateCallback)iterator2.next();
            synchronizedCaptureSession$StateCallback.onSurfacePrepared(synchronizedCaptureSession, surface);
        }
    }
}

