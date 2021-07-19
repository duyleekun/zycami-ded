/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.template.edit.EditorTemplateEndingFragment;
import d.v.c.d1.e;

public final class g0
implements Observer {
    public final /* synthetic */ EditorTemplateEndingFragment a;

    public /* synthetic */ g0(EditorTemplateEndingFragment editorTemplateEndingFragment) {
        this.a = editorTemplateEndingFragment;
    }

    public final void onChanged(Object object) {
        EditorTemplateEndingFragment editorTemplateEndingFragment = this.a;
        object = (e)object;
        editorTemplateEndingFragment.F((e)object);
    }
}

