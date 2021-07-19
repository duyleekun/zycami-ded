/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.p0;

import androidx.fragment.app.DialogFragment;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.s0.h7.p0.p$c;
import d.v.f.f.a;

public final class d
implements a {
    public final /* synthetic */ p$c a;
    public final /* synthetic */ TemplateData b;
    public final /* synthetic */ int c;

    public /* synthetic */ d(p$c p$c, TemplateData templateData, int n10) {
        this.a = p$c;
        this.b = templateData;
        this.c = n10;
    }

    public final void a(DialogFragment dialogFragment) {
        p$c p$c = this.a;
        TemplateData templateData = this.b;
        int n10 = this.c;
        p$c.g(templateData, n10, dialogFragment);
    }
}

