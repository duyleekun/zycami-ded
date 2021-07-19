/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import com.zhiyun.cama.template.edit.EditorTemplateEditActivity;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import java.util.List;
import java.util.function.Consumer;

public final class d0
implements Consumer {
    public final /* synthetic */ EditorTemplateEditActivity a;
    public final /* synthetic */ long b;
    public final /* synthetic */ TemplatePOJO c;

    public /* synthetic */ d0(EditorTemplateEditActivity editorTemplateEditActivity, long l10, TemplatePOJO templatePOJO) {
        this.a = editorTemplateEditActivity;
        this.b = l10;
        this.c = templatePOJO;
    }

    public final void accept(Object object) {
        EditorTemplateEditActivity editorTemplateEditActivity = this.a;
        long l10 = this.b;
        TemplatePOJO templatePOJO = this.c;
        object = (List)object;
        editorTemplateEditActivity.N(l10, templatePOJO, (List)object);
    }
}

