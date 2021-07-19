/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.AspectRatioLegacyApi21Quirk;
import androidx.camera.camera2.internal.compat.quirk.CameraQuirks;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.Nexus4AndroidLTargetAspectRatioQuirk;
import androidx.camera.camera2.internal.compat.quirk.SamsungPreviewTargetAspectRatioQuirk;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.Quirks;

public class TargetAspectRatio {
    public static final int RATIO_16_9 = 1;
    public static final int RATIO_4_3 = 0;
    public static final int RATIO_MAX_JPEG = 2;
    public static final int RATIO_ORIGINAL = 3;

    public int get(ImageOutputConfig object, String clazz, CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        boolean bl2;
        SamsungPreviewTargetAspectRatioQuirk samsungPreviewTargetAspectRatioQuirk = (SamsungPreviewTargetAspectRatioQuirk)DeviceQuirks.get(SamsungPreviewTargetAspectRatioQuirk.class);
        if (samsungPreviewTargetAspectRatioQuirk != null && (bl2 = samsungPreviewTargetAspectRatioQuirk.require16_9((Config)object))) {
            return 1;
        }
        object = (Nexus4AndroidLTargetAspectRatioQuirk)DeviceQuirks.get(Nexus4AndroidLTargetAspectRatioQuirk.class);
        if (object != null) {
            return ((Nexus4AndroidLTargetAspectRatioQuirk)object).getCorrectedAspectRatio();
        }
        object = CameraQuirks.get((String)((Object)clazz), cameraCharacteristicsCompat);
        clazz = AspectRatioLegacyApi21Quirk.class;
        if ((object = (AspectRatioLegacyApi21Quirk)((Quirks)object).get(clazz)) != null) {
            return ((AspectRatioLegacyApi21Quirk)object).getCorrectedAspectRatio();
        }
        return 3;
    }
}

