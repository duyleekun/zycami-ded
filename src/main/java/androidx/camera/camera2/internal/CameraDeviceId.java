/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.AutoValue_CameraDeviceId;

public abstract class CameraDeviceId {
    public static CameraDeviceId create(String string2, String string3, String string4, String string5) {
        string2 = string2.toLowerCase();
        string3 = string3.toLowerCase();
        string4 = string4.toLowerCase();
        string5 = string5.toLowerCase();
        AutoValue_CameraDeviceId autoValue_CameraDeviceId = new AutoValue_CameraDeviceId(string2, string3, string4, string5);
        return autoValue_CameraDeviceId;
    }

    public abstract String getBrand();

    public abstract String getCameraId();

    public abstract String getDevice();

    public abstract String getModel();
}

