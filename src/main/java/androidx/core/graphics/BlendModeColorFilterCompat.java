/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.BlendMode
 *  android.graphics.BlendModeColorFilter
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.os.Build$VERSION
 */
package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.core.graphics.BlendModeCompat;
import androidx.core.graphics.BlendModeUtils;

public class BlendModeColorFilterCompat {
    private BlendModeColorFilterCompat() {
    }

    public static ColorFilter createBlendModeColorFilterCompat(int n10, BlendModeCompat blendModeCompat) {
        int n11 = Build.VERSION.SDK_INT;
        BlendModeColorFilter blendModeColorFilter = null;
        int n12 = 29;
        if (n11 >= n12) {
            if ((blendModeCompat = BlendModeUtils.obtainBlendModeFromCompat(blendModeCompat)) != null) {
                blendModeColorFilter = new BlendModeColorFilter(n10, (BlendMode)blendModeCompat);
            }
            return blendModeColorFilter;
        }
        if ((blendModeCompat = BlendModeUtils.obtainPorterDuffFromCompat(blendModeCompat)) != null) {
            blendModeColorFilter = new PorterDuffColorFilter(n10, (PorterDuff.Mode)blendModeCompat);
        }
        return blendModeColorFilter;
    }
}

