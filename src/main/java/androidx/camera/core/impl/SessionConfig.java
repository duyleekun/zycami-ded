/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureConfig$Builder;
import androidx.camera.core.impl.Config;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SessionConfig {
    private final List mDeviceStateCallbacks;
    private final List mErrorListeners;
    private final CaptureConfig mRepeatingCaptureConfig;
    private final List mSessionStateCallbacks;
    private final List mSingleCameraCaptureCallbacks;
    private final List mSurfaces;

    public SessionConfig(List list, List list2, List list3, List list4, List list5, CaptureConfig captureConfig) {
        this.mSurfaces = list;
        this.mDeviceStateCallbacks = list = Collections.unmodifiableList(list2);
        this.mSessionStateCallbacks = list = Collections.unmodifiableList(list3);
        this.mSingleCameraCaptureCallbacks = list = Collections.unmodifiableList(list4);
        this.mErrorListeners = list = Collections.unmodifiableList(list5);
        this.mRepeatingCaptureConfig = captureConfig;
    }

    public static SessionConfig defaultEmptySessionConfig() {
        SessionConfig sessionConfig;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(0);
        ArrayList arrayList3 = new ArrayList(0);
        ArrayList arrayList4 = new ArrayList(0);
        ArrayList arrayList5 = new ArrayList(0);
        Object object = new CaptureConfig$Builder();
        CaptureConfig captureConfig = ((CaptureConfig$Builder)object).build();
        object = sessionConfig;
        sessionConfig = new SessionConfig(arrayList, arrayList2, arrayList3, arrayList4, arrayList5, captureConfig);
        return sessionConfig;
    }

    public List getDeviceStateCallbacks() {
        return this.mDeviceStateCallbacks;
    }

    public List getErrorListeners() {
        return this.mErrorListeners;
    }

    public Config getImplementationOptions() {
        return this.mRepeatingCaptureConfig.getImplementationOptions();
    }

    public List getRepeatingCameraCaptureCallbacks() {
        return this.mRepeatingCaptureConfig.getCameraCaptureCallbacks();
    }

    public CaptureConfig getRepeatingCaptureConfig() {
        return this.mRepeatingCaptureConfig;
    }

    public List getSessionStateCallbacks() {
        return this.mSessionStateCallbacks;
    }

    public List getSingleCameraCaptureCallbacks() {
        return this.mSingleCameraCaptureCallbacks;
    }

    public List getSurfaces() {
        return Collections.unmodifiableList(this.mSurfaces);
    }

    public int getTemplateType() {
        return this.mRepeatingCaptureConfig.getTemplateType();
    }
}

