/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet
 */
package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.widget.KeyCache;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;

public class TimeCycleSplineSet$TranslationYset
extends TimeCycleSplineSet {
    public boolean setProperty(View view, float f10, long l10, KeyCache keyCache) {
        f10 = this.get(f10, l10, view, keyCache);
        view.setTranslationY(f10);
        return this.mContinue;
    }
}

