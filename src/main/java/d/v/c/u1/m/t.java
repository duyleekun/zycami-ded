/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity;

public final class t
implements Observer {
    public final /* synthetic */ EditorTemplateEditActivity a;

    public /* synthetic */ t(EditorTemplateEditActivity editorTemplateEditActivity) {
        this.a = editorTemplateEditActivity;
    }

    public final void onChanged(Object object) {
        EditorTemplateEditActivity editorTemplateEditActivity = this.a;
        object = (Integer)object;
        editorTemplateEditActivity.C((Integer)object);
    }
}

