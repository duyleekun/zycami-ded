/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.CameraDeviceId;
import java.util.Objects;

public final class AutoValue_CameraDeviceId
extends CameraDeviceId {
    private final String brand;
    private final String cameraId;
    private final String device;
    private final String model;

    public AutoValue_CameraDeviceId(String string2, String string3, String string4, String string5) {
        Objects.requireNonNull(string2, "Null brand");
        this.brand = string2;
        Objects.requireNonNull(string3, "Null device");
        this.device = string3;
        Objects.requireNonNull(string4, "Null model");
        this.model = string4;
        Objects.requireNonNull(string5, "Null cameraId");
        this.cameraId = string5;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof CameraDeviceId;
        if (bl3) {
            boolean bl4;
            String string2 = this.brand;
            String string3 = ((CameraDeviceId)(object = (CameraDeviceId)object)).getBrand();
            bl3 = string2.equals(string3);
            if (!(bl3 && (bl3 = (string2 = this.device).equals(string3 = ((CameraDeviceId)object).getDevice())) && (bl3 = (string2 = this.model).equals(string3 = ((CameraDeviceId)object).getModel())) && (bl4 = (string2 = this.cameraId).equals(object = ((CameraDeviceId)object).getCameraId())))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getCameraId() {
        return this.cameraId;
    }

    public String getDevice() {
        return this.device;
    }

    public String getModel() {
        return this.model;
    }

    public int hashCode() {
        int n10 = this.brand.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.device.hashCode();
        n10 = (n10 ^ n12) * n11;
        n12 = this.model.hashCode();
        n10 = (n10 ^ n12) * n11;
        n11 = this.cameraId.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CameraDeviceId{brand=");
        String string2 = this.brand;
        stringBuilder.append(string2);
        stringBuilder.append(", device=");
        string2 = this.device;
        stringBuilder.append(string2);
        stringBuilder.append(", model=");
        string2 = this.model;
        stringBuilder.append(string2);
        stringBuilder.append(", cameraId=");
        string2 = this.cameraId;
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

