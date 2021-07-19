/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import androidx.core.util.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class JpegHalCorruptImageQuirk
implements SoftwareJpegEncodingPreferredQuirk {
    private static final Set KNOWN_AFFECTED_DEVICES;
    private static final Set SUPPORTED_HARDWARE_LEVELS;

    static {
        HashSet<Object> hashSet;
        String string2 = "heroqltetmo";
        Object object = Arrays.asList("heroqltevzw", string2);
        KNOWN_AFFECTED_DEVICES = hashSet = new HashSet<Object>((Collection<Object>)object);
        SUPPORTED_HARDWARE_LEVELS = hashSet = new HashSet<Object>();
        object = 1;
        hashSet.add(object);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            n10 = 3;
            object = n10;
            hashSet.add(object);
        }
    }

    /*
     * WARNING - void declaration
     */
    public static boolean load(CameraCharacteristicsCompat object) {
        void var2_6;
        boolean bl2;
        Object object2 = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
        object = (Integer)Preconditions.checkNotNull((Integer)((CameraCharacteristicsCompat)object).get((CameraCharacteristics.Key)object2));
        int bl22 = (Integer)object;
        object2 = KNOWN_AFFECTED_DEVICES;
        String string2 = Build.DEVICE;
        Locale locale = Locale.US;
        boolean bl3 = object2.contains(string2 = string2.toLowerCase(locale));
        if (bl3 && (bl2 = (object2 = SUPPORTED_HARDWARE_LEVELS).contains(object = Integer.valueOf(bl22)))) {
            boolean bl4 = true;
        } else {
            boolean bl5 = false;
            object = null;
        }
        return (boolean)var2_6;
    }
}

