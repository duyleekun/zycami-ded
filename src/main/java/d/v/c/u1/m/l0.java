/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.template.edit.EditorTemplateEndingFragment;
import d.v.j.e.h.k;

public final class l0
implements Observer {
    public final /* synthetic */ EditorTemplateEndingFragment a;

    public /* synthetic */ l0(EditorTemplateEndingFragment editorTemplateEndingFragment) {
        this.a = editorTemplateEndingFragment;
    }

    public final void onChanged(Object object) {
        EditorTemplateEndingFragment editorTemplateEndingFragment = this.a;
        object = (k)object;
        editorTemplateEndingFragment.D((k)object);
    }
}

