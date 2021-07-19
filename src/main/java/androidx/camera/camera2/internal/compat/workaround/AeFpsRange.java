/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.util.Range
 */
package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig$Builder;
import androidx.camera.camera2.internal.compat.quirk.AeFpsRangeLegacyQuirk;
import androidx.camera.core.impl.Quirks;

public class AeFpsRange {
    private final Range mAeTargetFpsRange;

    public AeFpsRange(Quirks object) {
        Class<AeFpsRangeLegacyQuirk> clazz = AeFpsRangeLegacyQuirk.class;
        object = (AeFpsRangeLegacyQuirk)((Quirks)object).get(clazz);
        if (object == null) {
            object = null;
            this.mAeTargetFpsRange = null;
        } else {
            object = ((AeFpsRangeLegacyQuirk)object).getRange();
            this.mAeTargetFpsRange = object;
        }
    }

    public void addAeFpsRangeOptions(Camera2ImplConfig$Builder camera2ImplConfig$Builder) {
        Range range = this.mAeTargetFpsRange;
        if (range != null) {
            CaptureRequest.Key key = CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE;
            camera2ImplConfig$Builder.setCaptureRequestOption(key, range);
        }
    }
}

