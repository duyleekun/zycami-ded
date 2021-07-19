/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.template.edit.EditorTemplateFilterFragment;
import d.v.c.b2.w.a;

public final class p0
implements Observer {
    public final /* synthetic */ EditorTemplateFilterFragment a;

    public /* synthetic */ p0(EditorTemplateFilterFragment editorTemplateFilterFragment) {
        this.a = editorTemplateFilterFragment;
    }

    public final void onChanged(Object object) {
        EditorTemplateFilterFragment editorTemplateFilterFragment = this.a;
        object = (a)object;
        editorTemplateFilterFragment.J((a)object);
    }
}

