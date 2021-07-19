/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.util.Property
 */
package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import androidx.transition.ChangeTransform$PathAnimatorMatrix;

public final class ChangeTransform$2
extends Property {
    public ChangeTransform$2(Class clazz, String string2) {
        super(clazz, string2);
    }

    public PointF get(ChangeTransform$PathAnimatorMatrix changeTransform$PathAnimatorMatrix) {
        return null;
    }

    public void set(ChangeTransform$PathAnimatorMatrix changeTransform$PathAnimatorMatrix, PointF pointF) {
        changeTransform$PathAnimatorMatrix.setTranslation(pointF);
    }
}

