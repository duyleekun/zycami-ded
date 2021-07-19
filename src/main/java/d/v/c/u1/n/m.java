/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.n;

import androidx.fragment.app.DialogFragment;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.u1.n.d0;
import d.v.f.f.a;

public final class m
implements a {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ TemplatePOJO b;

    public /* synthetic */ m(d0 d02, TemplatePOJO templatePOJO) {
        this.a = d02;
        this.b = templatePOJO;
    }

    public final void a(DialogFragment dialogFragment) {
        d0 d02 = this.a;
        TemplatePOJO templatePOJO = this.b;
        d02.i0(templatePOJO, dialogFragment);
    }
}

