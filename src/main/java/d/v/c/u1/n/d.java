/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.n;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.template.list.EditorTemplateListFragment;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;

public final class d
implements Observer {
    public final /* synthetic */ EditorTemplateListFragment a;

    public /* synthetic */ d(EditorTemplateListFragment editorTemplateListFragment) {
        this.a = editorTemplateListFragment;
    }

    public final void onChanged(Object object) {
        EditorTemplateListFragment editorTemplateListFragment = this.a;
        object = (TemplatePOJO)object;
        editorTemplateListFragment.M((TemplatePOJO)object);
    }
}

