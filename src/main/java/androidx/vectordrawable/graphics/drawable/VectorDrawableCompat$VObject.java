/*
 * Decompiled with CFR 0.151.
 */
package androidx.vectordrawable.graphics.drawable;

import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$1;

public abstract class VectorDrawableCompat$VObject {
    private VectorDrawableCompat$VObject() {
    }

    public /* synthetic */ VectorDrawableCompat$VObject(VectorDrawableCompat$1 vectorDrawableCompat$1) {
        this();
    }

    public boolean isStateful() {
        return false;
    }

    public boolean onStateChanged(int[] nArray) {
        return false;
    }
}

