/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 */
package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import com.google.android.material.internal.CircularBorderDrawable;
import com.google.android.material.internal.CircularBorderDrawable$1;

public class CircularBorderDrawable$CircularBorderState
extends Drawable.ConstantState {
    public final /* synthetic */ CircularBorderDrawable this$0;

    private CircularBorderDrawable$CircularBorderState(CircularBorderDrawable circularBorderDrawable) {
        this.this$0 = circularBorderDrawable;
    }

    public /* synthetic */ CircularBorderDrawable$CircularBorderState(CircularBorderDrawable circularBorderDrawable, CircularBorderDrawable$1 circularBorderDrawable$1) {
        this(circularBorderDrawable);
    }

    public int getChangingConfigurations() {
        return 0;
    }

    public Drawable newDrawable() {
        return this.this$0;
    }
}

