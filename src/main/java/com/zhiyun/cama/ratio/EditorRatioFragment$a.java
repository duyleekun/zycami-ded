/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.ratio;

import android.view.View;
import com.zhiyun.cama.ratio.EditorRatioFragment;
import d.v.c.q0.d$a;

public class EditorRatioFragment$a
extends d$a {
    public final /* synthetic */ EditorRatioFragment c;

    public EditorRatioFragment$a(EditorRatioFragment editorRatioFragment) {
        this.c = editorRatioFragment;
        super(editorRatioFragment);
    }

    public void c() {
        super.c();
        int n10 = (Integer)EditorRatioFragment.x(this.c).a();
        EditorRatioFragment.y(this.c).X(n10);
    }

    public void d() {
        super.d();
        EditorRatioFragment.z(this.c, 1L);
    }

    public void h(View view, int n10) {
        EditorRatioFragment.A(this.c, n10, false);
    }
}

