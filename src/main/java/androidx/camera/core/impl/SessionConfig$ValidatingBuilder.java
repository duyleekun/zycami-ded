/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureConfig$Builder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$BaseBuilder;
import androidx.camera.core.impl.TagBundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class SessionConfig$ValidatingBuilder
extends SessionConfig$BaseBuilder {
    private static final String TAG = "ValidatingBuilder";
    private boolean mTemplateSet = false;
    private boolean mValid = true;

    public void add(SessionConfig object) {
        Object object2;
        Object object3;
        Object object4 = ((SessionConfig)object).getRepeatingCaptureConfig();
        int n10 = ((CaptureConfig)object4).getTemplateType();
        String string2 = TAG;
        int n11 = -1;
        if (n10 != n11) {
            n10 = (int)(this.mTemplateSet ? 1 : 0);
            if (n10 == 0) {
                object3 = this.mCaptureConfigBuilder;
                n11 = ((CaptureConfig)object4).getTemplateType();
                ((CaptureConfig$Builder)object3).setTemplateType(n11);
                n10 = 1;
                this.mTemplateSet = n10;
            } else {
                object3 = this.mCaptureConfigBuilder;
                n10 = ((CaptureConfig$Builder)object3).getTemplateType();
                if (n10 != (n11 = ((CaptureConfig)object4).getTemplateType())) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Invalid configuration due to template type: ");
                    n11 = this.mCaptureConfigBuilder.getTemplateType();
                    ((StringBuilder)object3).append(n11);
                    object2 = " != ";
                    ((StringBuilder)object3).append((String)object2);
                    n11 = ((CaptureConfig)object4).getTemplateType();
                    ((StringBuilder)object3).append(n11);
                    object3 = ((StringBuilder)object3).toString();
                    Logger.d(string2, (String)object3);
                    this.mValid = false;
                }
            }
        }
        object3 = ((SessionConfig)object).getRepeatingCaptureConfig().getTagBundle();
        this.mCaptureConfigBuilder.addAllTags((TagBundle)object3);
        object3 = this.mDeviceStateCallbacks;
        object2 = ((SessionConfig)object).getDeviceStateCallbacks();
        object3.addAll(object2);
        object3 = this.mSessionStateCallbacks;
        object2 = ((SessionConfig)object).getSessionStateCallbacks();
        object3.addAll(object2);
        object3 = this.mCaptureConfigBuilder;
        object2 = ((SessionConfig)object).getRepeatingCameraCaptureCallbacks();
        ((CaptureConfig$Builder)object3).addAllCameraCaptureCallbacks((Collection)object2);
        object3 = this.mSingleCameraCaptureCallbacks;
        object2 = ((SessionConfig)object).getSingleCameraCaptureCallbacks();
        object3.addAll(object2);
        object3 = this.mErrorListeners;
        object2 = ((SessionConfig)object).getErrorListeners();
        object3.addAll(object2);
        object3 = this.mSurfaces;
        object = ((SessionConfig)object).getSurfaces();
        object3.addAll(object);
        object = this.mCaptureConfigBuilder.getSurfaces();
        object3 = ((CaptureConfig)object4).getSurfaces();
        object.addAll(object3);
        object = this.mSurfaces;
        object3 = this.mCaptureConfigBuilder.getSurfaces();
        boolean bl2 = object.containsAll((Collection<?>)object3);
        if (!bl2) {
            object = "Invalid configuration due to capture request surfaces are not a subset of surfaces";
            Logger.d(string2, (String)object);
            this.mValid = false;
        }
        object = this.mCaptureConfigBuilder;
        object4 = ((CaptureConfig)object4).getImplementationOptions();
        ((CaptureConfig$Builder)object).addImplementationOptions((Config)object4);
    }

    public SessionConfig build() {
        boolean bl2 = this.mValid;
        if (bl2) {
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
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported session configuration combination");
        throw illegalArgumentException;
    }

    public boolean isValid() {
        boolean bl2 = this.mTemplateSet;
        bl2 = bl2 && (bl2 = this.mValid);
        return bl2;
    }
}

