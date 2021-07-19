/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.internal.compat.quirk.DeviceQuirksLoader;
import java.util.List;

public class DeviceQuirks {
    private static final Quirks QUIRKS;

    static {
        Quirks quirks;
        List list = DeviceQuirksLoader.loadQuirks();
        QUIRKS = quirks = new Quirks(list);
    }

    private DeviceQuirks() {
    }

    public static Quirk get(Class clazz) {
        return QUIRKS.get(clazz);
    }
}

