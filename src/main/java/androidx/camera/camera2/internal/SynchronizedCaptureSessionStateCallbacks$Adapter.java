/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.view.Surface
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.camera.camera2.internal.CameraCaptureSessionStateCallbacks;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback;
import java.util.List;

public class SynchronizedCaptureSessionStateCallbacks$Adapter
extends SynchronizedCaptureSession$StateCallback {
    private final CameraCaptureSession.StateCallback mCameraCaptureSessionStateCallback;

    public SynchronizedCaptureSessionStateCallbacks$Adapter(CameraCaptureSession.StateCallback stateCallback) {
        this.mCameraCaptureSessionStateCallback = stateCallback;
    }

    public SynchronizedCaptureSessionStateCallbacks$Adapter(List list) {
        list = CameraCaptureSessionStateCallbacks.createComboCallback(list);
        this((CameraCaptureSession.StateCallback)list);
    }

    public void onActive(SynchronizedCaptureSession synchronizedCaptureSession) {
        CameraCaptureSession.StateCallback stateCallback = this.mCameraCaptureSessionStateCallback;
        synchronizedCaptureSession = synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession();
        stateCallback.onActive((CameraCaptureSession)synchronizedCaptureSession);
    }

    public void onCaptureQueueEmpty(SynchronizedCaptureSession synchronizedCaptureSession) {
        CameraCaptureSession.StateCallback stateCallback = this.mCameraCaptureSessionStateCallback;
        synchronizedCaptureSession = synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession();
        stateCallback.onCaptureQueueEmpty((CameraCaptureSession)synchronizedCaptureSession);
    }

    public void onClosed(SynchronizedCaptureSession synchronizedCaptureSession) {
        CameraCaptureSession.StateCallback stateCallback = this.mCameraCaptureSessionStateCallback;
        synchronizedCaptureSession = synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession();
        stateCallback.onClosed((CameraCaptureSession)synchronizedCaptureSession);
    }

    public void onConfigureFailed(SynchronizedCaptureSession synchronizedCaptureSession) {
        CameraCaptureSession.StateCallback stateCallback = this.mCameraCaptureSessionStateCallback;
        synchronizedCaptureSession = synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession();
        stateCallback.onConfigureFailed((CameraCaptureSession)synchronizedCaptureSession);
    }

    public void onConfigured(SynchronizedCaptureSession synchronizedCaptureSession) {
        CameraCaptureSession.StateCallback stateCallback = this.mCameraCaptureSessionStateCallback;
        synchronizedCaptureSession = synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession();
        stateCallback.onConfigured((CameraCaptureSession)synchronizedCaptureSession);
    }

    public void onReady(SynchronizedCaptureSession synchronizedCaptureSession) {
        CameraCaptureSession.StateCallback stateCallback = this.mCameraCaptureSessionStateCallback;
        synchronizedCaptureSession = synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession();
        stateCallback.onReady((CameraCaptureSession)synchronizedCaptureSession);
    }

    public void onSurfacePrepared(SynchronizedCaptureSession synchronizedCaptureSession, Surface surface) {
        CameraCaptureSession.StateCallback stateCallback = this.mCameraCaptureSessionStateCallback;
        synchronizedCaptureSession = synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession();
        stateCallback.onSurfacePrepared((CameraCaptureSession)synchronizedCaptureSession, surface);
    }
}

