/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity;

public final class s
implements Observer {
    public final /* synthetic */ EditorTemplateEditActivity a;

    public /* synthetic */ s(EditorTemplateEditActivity editorTemplateEditActivity) {
        this.a = editorTemplateEditActivity;
    }

    public final void onChanged(Object object) {
        EditorTemplateEditActivity editorTemplateEditActivity = this.a;
        object = (Long)object;
        editorTemplateEditActivity.E((Long)object);
    }
}

