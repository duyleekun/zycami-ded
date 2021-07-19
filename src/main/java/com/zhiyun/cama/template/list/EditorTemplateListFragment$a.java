/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package com.zhiyun.cama.template.list;

import android.view.ViewTreeObserver;
import com.zhiyun.cama.template.list.EditorTemplateListFragment;
import d.v.j.f.h;

public class EditorTemplateListFragment$a
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ EditorTemplateListFragment a;

    public EditorTemplateListFragment$a(EditorTemplateListFragment editorTemplateListFragment) {
        this.a = editorTemplateListFragment;
    }

    public void onGlobalLayout() {
        EditorTemplateListFragment.w(this.a).getRoot().getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        h h10 = EditorTemplateListFragment.x(this.a);
        boolean bl2 = h10.f();
        if (!bl2) {
            h10 = EditorTemplateListFragment.x(this.a);
            h10.j();
        }
    }
}

