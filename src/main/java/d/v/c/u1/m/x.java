/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity;

public final class x
implements Observer {
    public final /* synthetic */ EditorTemplateEditActivity a;

    public /* synthetic */ x(EditorTemplateEditActivity editorTemplateEditActivity) {
        this.a = editorTemplateEditActivity;
    }

    public final void onChanged(Object object) {
        EditorTemplateEditActivity editorTemplateEditActivity = this.a;
        object = (Float)object;
        editorTemplateEditActivity.I((Float)object);
    }
}

