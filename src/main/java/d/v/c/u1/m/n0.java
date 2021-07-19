/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import com.zhiyun.cama.template.edit.EditorTemplateFilterFragment;

public final class n0
implements Runnable {
    public final /* synthetic */ EditorTemplateFilterFragment a;
    public final /* synthetic */ Integer b;

    public /* synthetic */ n0(EditorTemplateFilterFragment editorTemplateFilterFragment, Integer n10) {
        this.a = editorTemplateFilterFragment;
        this.b = n10;
    }

    public final void run() {
        EditorTemplateFilterFragment editorTemplateFilterFragment = this.a;
        Integer n10 = this.b;
        editorTemplateFilterFragment.Z(n10);
    }
}

