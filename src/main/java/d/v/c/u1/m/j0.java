/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.template.edit.EditorTemplateEndingFragment;

public final class j0
implements Observer {
    public final /* synthetic */ EditorTemplateEndingFragment a;

    public /* synthetic */ j0(EditorTemplateEndingFragment editorTemplateEndingFragment) {
        this.a = editorTemplateEndingFragment;
    }

    public final void onChanged(Object object) {
        EditorTemplateEndingFragment editorTemplateEndingFragment = this.a;
        object = (Integer)object;
        editorTemplateEndingFragment.J((Integer)object);
    }
}

