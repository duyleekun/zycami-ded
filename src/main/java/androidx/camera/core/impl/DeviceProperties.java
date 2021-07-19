/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package androidx.camera.core.impl;

import android.os.Build;
import androidx.camera.core.impl.AutoValue_DeviceProperties;

public abstract class DeviceProperties {
    public static DeviceProperties create() {
        String string2 = Build.MANUFACTURER;
        String string3 = Build.MODEL;
        int n10 = Build.VERSION.SDK_INT;
        return DeviceProperties.create(string2, string3, n10);
    }

    public static DeviceProperties create(String string2, String string3, int n10) {
        AutoValue_DeviceProperties autoValue_DeviceProperties = new AutoValue_DeviceProperties(string2, string3, n10);
        return autoValue_DeviceProperties;
    }

    public abstract String manufacturer();

    public abstract String model();

    public abstract int sdkVersion();
}

