/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package com.google.android.material.floatingactionbutton;

import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;

public class FloatingActionButtonImpl$3
implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ FloatingActionButtonImpl this$0;

    public FloatingActionButtonImpl$3(FloatingActionButtonImpl floatingActionButtonImpl) {
        this.this$0 = floatingActionButtonImpl;
    }

    public boolean onPreDraw() {
        this.this$0.onPreDraw();
        return true;
    }
}

