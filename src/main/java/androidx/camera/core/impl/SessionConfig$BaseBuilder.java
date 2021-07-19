/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CaptureConfig$Builder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SessionConfig$BaseBuilder {
    public final CaptureConfig$Builder mCaptureConfigBuilder;
    public final List mDeviceStateCallbacks;
    public final List mErrorListeners;
    public final List mSessionStateCallbacks;
    public final List mSingleCameraCaptureCallbacks;
    public final Set mSurfaces;

    public SessionConfig$BaseBuilder() {
        ArrayList arrayList = new ArrayList();
        this.mSurfaces = arrayList;
        arrayList = new ArrayList();
        this.mCaptureConfigBuilder = arrayList;
        this.mDeviceStateCallbacks = arrayList = new ArrayList();
        this.mSessionStateCallbacks = arrayList = new ArrayList();
        this.mErrorListeners = arrayList = new ArrayList();
        this.mSingleCameraCaptureCallbacks = arrayList = new ArrayList();
    }
}

