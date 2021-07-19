/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.n;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.template.list.EditorTemplateListFragment;
import d.v.j.e.h.k;

public final class e
implements Observer {
    public final /* synthetic */ EditorTemplateListFragment a;

    public /* synthetic */ e(EditorTemplateListFragment editorTemplateListFragment) {
        this.a = editorTemplateListFragment;
    }

    public final void onChanged(Object object) {
        EditorTemplateListFragment editorTemplateListFragment = this.a;
        object = (k)object;
        editorTemplateListFragment.I((k)object);
    }
}

