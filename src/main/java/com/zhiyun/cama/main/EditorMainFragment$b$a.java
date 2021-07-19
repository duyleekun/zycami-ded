/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package com.zhiyun.cama.main;

import android.view.ViewTreeObserver;
import com.zhiyun.cama.main.EditorMainFragment;
import com.zhiyun.cama.main.EditorMainFragment$b;

public class EditorMainFragment$b$a
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ EditorMainFragment$b a;

    public EditorMainFragment$b$a(EditorMainFragment$b b10) {
        this.a = b10;
    }

    public void onGlobalLayout() {
        EditorMainFragment.x((EditorMainFragment)this.a.a).l.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        EditorMainFragment.J(this.a.a);
    }
}

