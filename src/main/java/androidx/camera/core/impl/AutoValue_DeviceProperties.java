/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.DeviceProperties;
import java.util.Objects;

public final class AutoValue_DeviceProperties
extends DeviceProperties {
    private final String manufacturer;
    private final String model;
    private final int sdkVersion;

    public AutoValue_DeviceProperties(String string2, String string3, int n10) {
        Objects.requireNonNull(string2, "Null manufacturer");
        this.manufacturer = string2;
        Objects.requireNonNull(string3, "Null model");
        this.model = string3;
        this.sdkVersion = n10;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof DeviceProperties;
        if (n10 != 0) {
            int n11;
            String string2 = this.manufacturer;
            String string3 = ((DeviceProperties)(object = (DeviceProperties)object)).manufacturer();
            n10 = string2.equals(string3);
            if (n10 == 0 || (n10 = (string2 = this.model).equals(string3 = ((DeviceProperties)object).model())) == 0 || (n10 = this.sdkVersion) != (n11 = ((DeviceProperties)object).sdkVersion())) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.manufacturer.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.model.hashCode();
        n10 = (n10 ^ n12) * n11;
        n11 = this.sdkVersion;
        return n10 ^ n11;
    }

    public String manufacturer() {
        return this.manufacturer;
    }

    public String model() {
        return this.model;
    }

    public int sdkVersion() {
        return this.sdkVersion;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DeviceProperties{manufacturer=");
        String string2 = this.manufacturer;
        stringBuilder.append(string2);
        stringBuilder.append(", model=");
        string2 = this.model;
        stringBuilder.append(string2);
        stringBuilder.append(", sdkVersion=");
        int n10 = this.sdkVersion;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

