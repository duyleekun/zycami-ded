/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package com.zhiyun.cama.main;

import android.view.ViewTreeObserver;
import com.zhiyun.cama.main.EditorMainFragment;

public class EditorMainFragment$a
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ EditorMainFragment a;

    public EditorMainFragment$a(EditorMainFragment editorMainFragment) {
        this.a = editorMainFragment;
    }

    public void onGlobalLayout() {
        EditorMainFragment.x(this.a).getRoot().getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        EditorMainFragment.y(this.a);
        EditorMainFragment.J(this.a);
        EditorMainFragment editorMainFragment = this.a;
        int n10 = EditorMainFragment.x((EditorMainFragment)editorMainFragment).l.getScrollX();
        EditorMainFragment.V(editorMainFragment, n10);
    }
}

