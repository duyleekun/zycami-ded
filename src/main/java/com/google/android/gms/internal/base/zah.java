/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 */
package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.internal.base.zag;

public final class zah
extends Drawable.ConstantState {
    private zah() {
    }

    public /* synthetic */ zah(zaf zaf2) {
        this();
    }

    public final int getChangingConfigurations() {
        return 0;
    }

    public final Drawable newDrawable() {
        return zag.zacg();
    }
}

