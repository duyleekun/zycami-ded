/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.transition;

import com.zhiyun.cama.transition.EditorTransitionFragment;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.q0.d$a;
import d.v.h.k.b;

public class EditorTransitionFragment$a
extends d$a {
    public final /* synthetic */ EditorTransitionFragment c;

    public EditorTransitionFragment$a(EditorTransitionFragment editorTransitionFragment) {
        this.c = editorTransitionFragment;
        super(editorTransitionFragment);
    }

    public void c() {
        int n10;
        super.c();
        Object object = EditorTransitionFragment.x(this.c).M();
        if (object != null && (n10 = ((b)object).e()) != 0) {
            g g10 = EditorTransitionFragment.A(this.c);
            EditorTransitionFragment editorTransitionFragment = this.c;
            int n11 = EditorTransitionFragment.y(editorTransitionFragment);
            g10.y(n11, (b)object, false);
        } else {
            object = EditorTransitionFragment.z(this.c);
            EditorTransitionFragment editorTransitionFragment = this.c;
            n10 = EditorTransitionFragment.y(editorTransitionFragment);
            ((i2)object).M2(n10, false);
        }
    }

    public void d() {
        super.d();
        EditorTransitionFragment editorTransitionFragment = this.c;
        boolean bl2 = EditorTransitionFragment.B(editorTransitionFragment);
        if (bl2) {
            editorTransitionFragment = this.c;
            EditorTransitionFragment.C(editorTransitionFragment);
        } else {
            editorTransitionFragment = this.c;
            boolean bl3 = true;
            EditorTransitionFragment.D(editorTransitionFragment, bl3);
            editorTransitionFragment = this.c;
            long l10 = 128L;
            EditorTransitionFragment.E(editorTransitionFragment, l10);
        }
    }

    public void h() {
        EditorTransitionFragment.F((EditorTransitionFragment)this.c).h.e();
        EditorTransitionFragment.x(this.c).A();
    }
}

