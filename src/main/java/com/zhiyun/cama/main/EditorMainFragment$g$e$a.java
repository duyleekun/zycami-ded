/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package com.zhiyun.cama.main;

import android.view.ViewTreeObserver;
import com.zhiyun.cama.main.EditorMainFragment;
import com.zhiyun.cama.main.EditorMainFragment$g$e;

public class EditorMainFragment$g$e$a
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ EditorMainFragment$g$e a;

    public EditorMainFragment$g$e$a(EditorMainFragment$g$e e10) {
        this.a = e10;
    }

    public void onGlobalLayout() {
        EditorMainFragment.x((EditorMainFragment)this.a.a.a).m.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        EditorMainFragment.o0(this.a.a.a).i4();
    }
}

