/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.camera2.internal.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCapturePixelHDRPlusQuirk;
import androidx.camera.camera2.internal.compat.quirk.Nexus4AndroidLTargetAspectRatioQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewPixelHDRnetQuirk;
import androidx.camera.camera2.internal.compat.quirk.SamsungPreviewTargetAspectRatioQuirk;
import androidx.camera.camera2.internal.compat.quirk.StillCaptureFlashStopRepeatingQuirk;
import androidx.camera.core.impl.Quirk;
import java.util.ArrayList;
import java.util.List;

public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    public static List loadQuirks() {
        Quirk quirk;
        ArrayList<ImageCapturePixelHDRPlusQuirk> arrayList = new ArrayList<ImageCapturePixelHDRPlusQuirk>();
        boolean bl2 = ImageCapturePixelHDRPlusQuirk.load();
        if (bl2) {
            quirk = new ImageCapturePixelHDRPlusQuirk();
            arrayList.add((ImageCapturePixelHDRPlusQuirk)quirk);
        }
        if (bl2 = SamsungPreviewTargetAspectRatioQuirk.load()) {
            quirk = new SamsungPreviewTargetAspectRatioQuirk();
            arrayList.add((ImageCapturePixelHDRPlusQuirk)quirk);
        }
        if (bl2 = Nexus4AndroidLTargetAspectRatioQuirk.load()) {
            quirk = new Nexus4AndroidLTargetAspectRatioQuirk();
            arrayList.add((ImageCapturePixelHDRPlusQuirk)quirk);
        }
        if (bl2 = ExcludedSupportedSizesQuirk.load()) {
            quirk = new ExcludedSupportedSizesQuirk();
            arrayList.add((ImageCapturePixelHDRPlusQuirk)quirk);
        }
        if (bl2 = CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.load()) {
            quirk = new CrashWhenTakingPhotoWithAutoFlashAEModeQuirk();
            arrayList.add((ImageCapturePixelHDRPlusQuirk)quirk);
        }
        if (bl2 = PreviewPixelHDRnetQuirk.load()) {
            quirk = new PreviewPixelHDRnetQuirk();
            arrayList.add((ImageCapturePixelHDRPlusQuirk)quirk);
        }
        if (bl2 = StillCaptureFlashStopRepeatingQuirk.load()) {
            quirk = new StillCaptureFlashStopRepeatingQuirk();
            arrayList.add((ImageCapturePixelHDRPlusQuirk)quirk);
        }
        return arrayList;
    }
}

