/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.AeFpsRangeLegacyQuirk;
import androidx.camera.camera2.internal.compat.quirk.AspectRatioLegacyApi21Quirk;
import androidx.camera.camera2.internal.compat.quirk.JpegHalCorruptImageQuirk;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;
import java.util.ArrayList;

public class CameraQuirks {
    private CameraQuirks() {
    }

    public static Quirks get(String arrayList, CameraCharacteristicsCompat object) {
        boolean bl2;
        Quirk quirk;
        arrayList = new ArrayList<AeFpsRangeLegacyQuirk>();
        boolean bl3 = AeFpsRangeLegacyQuirk.load((CameraCharacteristicsCompat)object);
        if (bl3) {
            quirk = new AeFpsRangeLegacyQuirk((CameraCharacteristicsCompat)object);
            arrayList.add((AeFpsRangeLegacyQuirk)quirk);
        }
        if (bl3 = AspectRatioLegacyApi21Quirk.load((CameraCharacteristicsCompat)object)) {
            quirk = new AspectRatioLegacyApi21Quirk();
            arrayList.add((AeFpsRangeLegacyQuirk)quirk);
        }
        if (bl2 = JpegHalCorruptImageQuirk.load((CameraCharacteristicsCompat)object)) {
            object = new JpegHalCorruptImageQuirk();
            arrayList.add((AeFpsRangeLegacyQuirk)object);
        }
        object = new Quirks(arrayList);
        return object;
    }
}

