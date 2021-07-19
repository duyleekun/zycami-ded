/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet
 */
package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.view.View;
import androidx.constraintlayout.motion.widget.KeyCache;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;

public class TimeCycleSplineSet$TranslationZset
extends TimeCycleSplineSet {
    public boolean setProperty(View view, float f10, long l10, KeyCache keyCache) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            f10 = this.get(f10, l10, view, keyCache);
            view.setTranslationZ(f10);
        }
        return this.mContinue;
    }
}

