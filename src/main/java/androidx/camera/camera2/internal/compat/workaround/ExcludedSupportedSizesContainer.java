/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import java.util.ArrayList;
import java.util.List;

public class ExcludedSupportedSizesContainer {
    private final String mCameraId;

    public ExcludedSupportedSizesContainer(String string2) {
        this.mCameraId = string2;
    }

    public List get(int n10) {
        ExcludedSupportedSizesQuirk excludedSupportedSizesQuirk = (ExcludedSupportedSizesQuirk)DeviceQuirks.get(ExcludedSupportedSizesQuirk.class);
        if (excludedSupportedSizesQuirk == null) {
            ArrayList arrayList = new ArrayList();
            return arrayList;
        }
        String string2 = this.mCameraId;
        return excludedSupportedSizesQuirk.getExcludedSizes(string2, n10);
    }
}

