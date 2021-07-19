/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 */
package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.base.zae;

public final class zai
extends Drawable.ConstantState {
    public int mChangingConfigurations;
    public int zanw;

    public zai(zai zai2) {
        if (zai2 != null) {
            int n10;
            int n11;
            this.mChangingConfigurations = n11 = zai2.mChangingConfigurations;
            this.zanw = n10 = zai2.zanw;
        }
    }

    public final int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }

    public final Drawable newDrawable() {
        zae zae2 = new zae(this);
        return zae2;
    }
}

