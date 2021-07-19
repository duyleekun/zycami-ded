/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.internal.compat.quirk.ImageCaptureRotationOptionQuirk;
import androidx.camera.core.internal.compat.quirk.IncompleteCameraListQuirk;
import java.util.ArrayList;
import java.util.List;

public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    public static List loadQuirks() {
        Quirk quirk;
        ArrayList<IncompleteCameraListQuirk> arrayList = new ArrayList<IncompleteCameraListQuirk>();
        boolean bl2 = IncompleteCameraListQuirk.load();
        if (bl2) {
            quirk = new IncompleteCameraListQuirk();
            arrayList.add((IncompleteCameraListQuirk)quirk);
        }
        if (bl2 = ImageCaptureRotationOptionQuirk.load()) {
            quirk = new ImageCaptureRotationOptionQuirk();
            arrayList.add((IncompleteCameraListQuirk)quirk);
        }
        return arrayList;
    }
}

