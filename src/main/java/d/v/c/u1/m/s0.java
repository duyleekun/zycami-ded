/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.template.edit.EditorTemplateFilterFragment;

public final class s0
implements Observer {
    public final /* synthetic */ EditorTemplateFilterFragment a;

    public /* synthetic */ s0(EditorTemplateFilterFragment editorTemplateFilterFragment) {
        this.a = editorTemplateFilterFragment;
    }

    public final void onChanged(Object object) {
        EditorTemplateFilterFragment editorTemplateFilterFragment = this.a;
        object = (Integer)object;
        editorTemplateFilterFragment.N((Integer)object);
    }
}

