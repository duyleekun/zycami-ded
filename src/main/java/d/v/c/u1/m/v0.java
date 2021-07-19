/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.template.edit.EditorTemplateFilterFragment;
import java.util.List;

public final class v0
implements Observer {
    public final /* synthetic */ EditorTemplateFilterFragment a;

    public /* synthetic */ v0(EditorTemplateFilterFragment editorTemplateFilterFragment) {
        this.a = editorTemplateFilterFragment;
    }

    public final void onChanged(Object object) {
        EditorTemplateFilterFragment editorTemplateFilterFragment = this.a;
        object = (List)object;
        editorTemplateFilterFragment.R((List)object);
    }
}

