/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.decoration.text;

import com.zhiyun.cama.decoration.text.EditorTextMainFragment;
import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.c.i1.i2;
import d.v.c.q0.d$a;
import d.v.h.d.d;

public class EditorTextMainFragment$a
extends d$a {
    public final /* synthetic */ EditorTextMainFragment c;

    public EditorTextMainFragment$a(EditorTextMainFragment editorTextMainFragment) {
        this.c = editorTextMainFragment;
        super(editorTextMainFragment);
    }

    public void c() {
        super.c();
        Object object = EditorTextMainFragment.x(this.c).e();
        EditorTextMainFragment.y(this.c).S2((d)object);
        object = EditorTextMainFragment.z(this.c);
        DecorationType decorationType = DecorationType.FONT;
        boolean bl2 = true;
        ((i2)object).F3(decorationType, bl2, bl2);
    }

    public void d() {
        super.d();
        EditorTextMainFragment editorTextMainFragment = this.c;
        boolean bl2 = EditorTextMainFragment.A(editorTextMainFragment);
        if (bl2) {
            editorTextMainFragment = this.c;
            EditorTextMainFragment.B(editorTextMainFragment);
        } else {
            editorTextMainFragment = this.c;
            EditorTextMainFragment.C(editorTextMainFragment);
        }
    }
}

