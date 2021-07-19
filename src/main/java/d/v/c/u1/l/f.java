/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.l;

import androidx.fragment.app.DialogFragment;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.u1.l.l;
import d.v.f.f.a;

public final class f
implements a {
    public final /* synthetic */ l a;
    public final /* synthetic */ TemplatePOJO b;

    public /* synthetic */ f(l l10, TemplatePOJO templatePOJO) {
        this.a = l10;
        this.b = templatePOJO;
    }

    public final void a(DialogFragment dialogFragment) {
        l l10 = this.a;
        TemplatePOJO templatePOJO = this.b;
        l10.R(templatePOJO, dialogFragment);
    }
}

