/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;

public class AutoFlashAEModeDisabler {
    public int getCorrectedAeMode(int n10) {
        int n11;
        CrashWhenTakingPhotoWithAutoFlashAEModeQuirk crashWhenTakingPhotoWithAutoFlashAEModeQuirk = (CrashWhenTakingPhotoWithAutoFlashAEModeQuirk)DeviceQuirks.get(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class);
        if (crashWhenTakingPhotoWithAutoFlashAEModeQuirk != null && n10 == (n11 = 2)) {
            n10 = 1;
        }
        return n10;
    }
}

