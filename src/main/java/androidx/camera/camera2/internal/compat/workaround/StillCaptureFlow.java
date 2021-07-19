/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Key
 */
package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.StillCaptureFlashStopRepeatingQuirk;
import java.util.List;

public class StillCaptureFlow {
    private final boolean mShouldStopRepeatingBeforeStillCapture;

    public StillCaptureFlow() {
        boolean bl2;
        StillCaptureFlashStopRepeatingQuirk stillCaptureFlashStopRepeatingQuirk = (StillCaptureFlashStopRepeatingQuirk)DeviceQuirks.get(StillCaptureFlashStopRepeatingQuirk.class);
        if (stillCaptureFlashStopRepeatingQuirk != null) {
            bl2 = true;
        } else {
            bl2 = false;
            stillCaptureFlashStopRepeatingQuirk = null;
        }
        this.mShouldStopRepeatingBeforeStillCapture = bl2;
    }

    public boolean shouldStopRepeatingBeforeCapture(List object, boolean n10) {
        int n11 = this.mShouldStopRepeatingBeforeStillCapture;
        if (n11 != 0 && n10 != 0) {
            object = object.iterator();
            while ((n10 = object.hasNext()) != 0) {
                Object object2 = (CaptureRequest)object.next();
                CaptureRequest.Key key = CaptureRequest.CONTROL_AE_MODE;
                n10 = (Integer)(object2 = (Integer)object2.get(key));
                if (n10 != (n11 = 2) && n10 != (n11 = 3)) continue;
                return true;
            }
        }
        return false;
    }
}

