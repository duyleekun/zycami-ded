/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.main.EditorMainActivity;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;

public final class g
implements Observer {
    public final /* synthetic */ EditorMainActivity a;
    public final /* synthetic */ long b;

    public /* synthetic */ g(EditorMainActivity editorMainActivity, long l10) {
        this.a = editorMainActivity;
        this.b = l10;
    }

    public final void onChanged(Object object) {
        EditorMainActivity editorMainActivity = this.a;
        long l10 = this.b;
        object = (TemplatePOJO)object;
        editorMainActivity.t(l10, (TemplatePOJO)object);
    }
}

