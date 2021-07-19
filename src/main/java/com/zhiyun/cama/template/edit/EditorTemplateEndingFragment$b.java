/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.template.edit;

import com.zhiyun.cama.template.edit.EditorTemplateEndingFragment;
import d.v.c.d1.e;
import d.v.c.d1.h;
import d.v.c.q0.c$b;
import java.util.List;

public class EditorTemplateEndingFragment$b
extends c$b {
    public final /* synthetic */ EditorTemplateEndingFragment b;

    public EditorTemplateEndingFragment$b(EditorTemplateEndingFragment editorTemplateEndingFragment) {
        this.b = editorTemplateEndingFragment;
        super(editorTemplateEndingFragment);
    }

    public void c() {
        boolean bl2;
        List list;
        super.c();
        Object object = EditorTemplateEndingFragment.u(this.b);
        int n10 = ((h)object).m();
        if (n10 == 0 && (object = EditorTemplateEndingFragment.u(this.b).v()) != null && (list = ((e)object).b().getTemplateVideoList()) != null && !(bl2 = (list = ((e)object).b().getTemplateVideoList()).isEmpty())) {
            EditorTemplateEndingFragment.v(this.b).r((e)object, false);
            return;
        }
        EditorTemplateEndingFragment.v(this.b).A(false);
    }

    public void d() {
        super.d();
        EditorTemplateEndingFragment.v(this.b).A(true);
    }

    public void g() {
        EditorTemplateEndingFragment.w(this.b);
    }
}

