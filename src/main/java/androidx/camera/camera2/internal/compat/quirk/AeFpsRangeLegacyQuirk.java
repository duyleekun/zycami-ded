/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.util.Range
 */
package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

public class AeFpsRangeLegacyQuirk
implements Quirk {
    private final Range mAeFpsRange;

    public AeFpsRangeLegacyQuirk(CameraCharacteristicsCompat range) {
        CameraCharacteristics.Key key = CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES;
        range = (Range)range.get(key);
        this.mAeFpsRange = range = this.pickSuitableFpsRange((Range[])range);
    }

    private Range getCorrectedFpsRange(Range object) {
        int n10;
        Integer n11 = (Integer)object.getUpper();
        int n12 = n11;
        Integer n13 = (Integer)object.getLower();
        int n14 = n13;
        Integer n15 = (Integer)object.getUpper();
        int n16 = n15;
        if (n16 >= (n10 = 1000)) {
            n11 = (Integer)object.getUpper();
            n12 = n11 / n10;
        }
        if ((n16 = (n15 = (Integer)object.getLower()).intValue()) >= n10) {
            object = (Integer)object.getLower();
            int n17 = (Integer)object;
            n14 = n17 / 1000;
        }
        n13 = n14;
        n11 = n12;
        object = new Range((Comparable)n13, (Comparable)n11);
        return object;
    }

    public static boolean load(CameraCharacteristicsCompat object) {
        int n10;
        int n11;
        CameraCharacteristics.Key key = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
        if ((object = (Integer)((CameraCharacteristicsCompat)object).get(key)) != null && (n11 = ((Integer)object).intValue()) == (n10 = 2)) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }

    private Range pickSuitableFpsRange(Range[] rangeArray) {
        int n10;
        Range range = null;
        if (rangeArray != null && (n10 = rangeArray.length) != 0) {
            for (Range range2 : rangeArray) {
                Integer n11;
                int n12;
                Integer n13 = (Integer)(range2 = this.getCorrectedFpsRange(range2)).getUpper();
                int n14 = n13;
                if (n14 != (n12 = 30) || range != null && (n14 = (n13 = (Integer)range2.getLower()).intValue()) >= (n12 = (n11 = (Integer)range.getLower()).intValue())) continue;
                range = range2;
            }
        }
        return range;
    }

    public Range getRange() {
        return this.mAeFpsRange;
    }
}

