/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package com.zhiyun.cama.main;

import android.view.ViewTreeObserver;
import com.zhiyun.cama.main.EditorMainFragment;
import com.zhiyun.cama.main.EditorMainFragment$b$a;
import com.zhiyun.cama.widget.EditorHorizontalScrollView$b;

public class EditorMainFragment$b
implements EditorHorizontalScrollView$b {
    public final /* synthetic */ EditorMainFragment a;

    public EditorMainFragment$b(EditorMainFragment editorMainFragment) {
        this.a = editorMainFragment;
    }

    public void a(float f10) {
        EditorMainFragment.e0(this.a).g(f10);
        ViewTreeObserver viewTreeObserver = EditorMainFragment.x((EditorMainFragment)this.a).l.getViewTreeObserver();
        EditorMainFragment$b$a editorMainFragment$b$a = new EditorMainFragment$b$a(this);
        viewTreeObserver.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)editorMainFragment$b$a);
    }

    public void b() {
    }

    public void c() {
    }
}

