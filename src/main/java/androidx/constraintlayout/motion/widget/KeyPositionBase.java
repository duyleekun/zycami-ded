/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  android.view.View
 */
package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import java.util.HashSet;

public abstract class KeyPositionBase
extends Key {
    public static final float SELECTION_SLOPE = 20.0f;
    public int mCurveFit;

    public KeyPositionBase() {
        int n10;
        this.mCurveFit = n10 = Key.UNSET;
    }

    public abstract void calcPosition(int var1, int var2, float var3, float var4, float var5, float var6);

    public void getAttributeNames(HashSet hashSet) {
    }

    public abstract float getPositionX();

    public abstract float getPositionY();

    public abstract boolean intersects(int var1, int var2, RectF var3, RectF var4, float var5, float var6);

    public abstract void positionAttributes(View var1, RectF var2, RectF var3, float var4, float var5, String[] var6, float[] var7);
}

