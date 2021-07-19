/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import com.zhiyun.cama.template.edit.EditorTemplateEndingFragment;

public final class i0
implements Runnable {
    public final /* synthetic */ EditorTemplateEndingFragment a;
    public final /* synthetic */ Integer b;

    public /* synthetic */ i0(EditorTemplateEndingFragment editorTemplateEndingFragment, Integer n10) {
        this.a = editorTemplateEndingFragment;
        this.b = n10;
    }

    public final void run() {
        EditorTemplateEndingFragment editorTemplateEndingFragment = this.a;
        Integer n10 = this.b;
        editorTemplateEndingFragment.P(n10);
    }
}

