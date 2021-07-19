/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CameraDevice$StateCallback
 */
package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$BaseBuilder;
import androidx.camera.core.impl.SessionConfig$ErrorListener;
import androidx.camera.core.impl.UseCaseConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SessionConfig$Builder
extends SessionConfig$BaseBuilder {
    public static SessionConfig$Builder createFrom(UseCaseConfig object) {
        Object object2 = object.getSessionOptionUnpacker(null);
        if (object2 != null) {
            SessionConfig$Builder sessionConfig$Builder = new SessionConfig$Builder();
            object2.unpack((UseCaseConfig)object, sessionConfig$Builder);
            return sessionConfig$Builder;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Implementation is missing option unpacker for ");
        String string2 = object.toString();
        object = object.getTargetName(string2);
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public void addAllCameraCaptureCallbacks(Collection collection) {
        this.mCaptureConfigBuilder.addAllCameraCaptureCallbacks(collection);
        this.mSingleCameraCaptureCallbacks.addAll(collection);
    }

    public void addAllDeviceStateCallbacks(Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            CameraDevice.StateCallback stateCallback = (CameraDevice.StateCallback)object.next();
            this.addDeviceStateCallback(stateCallback);
        }
    }

    public void addAllRepeatingCameraCaptureCallbacks(Collection collection) {
        this.mCaptureConfigBuilder.addAllCameraCaptureCallbacks(collection);
    }

    public void addAllSessionStateCallbacks(List object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            CameraCaptureSession.StateCallback stateCallback = (CameraCaptureSession.StateCallback)object.next();
            this.addSessionStateCallback(stateCallback);
        }
    }

    public void addCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
        this.mCaptureConfigBuilder.addCameraCaptureCallback(cameraCaptureCallback);
        this.mSingleCameraCaptureCallbacks.add(cameraCaptureCallback);
    }

    public void addDeviceStateCallback(CameraDevice.StateCallback object) {
        List list = this.mDeviceStateCallbacks;
        boolean bl2 = list.contains(object);
        if (!bl2) {
            this.mDeviceStateCallbacks.add(object);
            return;
        }
        object = new IllegalArgumentException("Duplicate device state callback.");
        throw object;
    }

    public void addErrorListener(SessionConfig$ErrorListener sessionConfig$ErrorListener) {
        this.mErrorListeners.add(sessionConfig$ErrorListener);
    }

    public void addImplementationOptions(Config config) {
        this.mCaptureConfigBuilder.addImplementationOptions(config);
    }

    public void addNonRepeatingSurface(DeferrableSurface deferrableSurface) {
        this.mSurfaces.add(deferrableSurface);
    }

    public void addRepeatingCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
        this.mCaptureConfigBuilder.addCameraCaptureCallback(cameraCaptureCallback);
    }

    public void addSessionStateCallback(CameraCaptureSession.StateCallback object) {
        List list = this.mSessionStateCallbacks;
        boolean bl2 = list.contains(object);
        if (!bl2) {
            this.mSessionStateCallbacks.add(object);
            return;
        }
        object = new IllegalArgumentException("Duplicate session state callback.");
        throw object;
    }

    public void addSurface(DeferrableSurface deferrableSurface) {
        this.mSurfaces.add(deferrableSurface);
        this.mCaptureConfigBuilder.addSurface(deferrableSurface);
    }

    public void addTag(String string2, Integer n10) {
        this.mCaptureConfigBuilder.addTag(string2, n10);
    }

    public SessionConfig build() {
        SessionConfig sessionConfig;
        Object object = this.mSurfaces;
        ArrayList arrayList = new ArrayList(object);
        List list = this.mDeviceStateCallbacks;
        List list2 = this.mSessionStateCallbacks;
        List list3 = this.mSingleCameraCaptureCallbacks;
        List list4 = this.mErrorListeners;
        CaptureConfig captureConfig = this.mCaptureConfigBuilder.build();
        object = sessionConfig;
        sessionConfig = new SessionConfig(arrayList, list, list2, list3, list4, captureConfig);
        return sessionConfig;
    }

    public void clearSurfaces() {
        this.mSurfaces.clear();
        this.mCaptureConfigBuilder.clearSurfaces();
    }

    public List getSingleCameraCaptureCallbacks() {
        return Collections.unmodifiableList(this.mSingleCameraCaptureCallbacks);
    }

    public void removeSurface(DeferrableSurface deferrableSurface) {
        this.mSurfaces.remove(deferrableSurface);
        this.mCaptureConfigBuilder.removeSurface(deferrableSurface);
    }

    public void setImplementationOptions(Config config) {
        this.mCaptureConfigBuilder.setImplementationOptions(config);
    }

    public void setTemplateType(int n10) {
        this.mCaptureConfigBuilder.setTemplateType(n10);
    }
}

