/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.l;

import androidx.lifecycle.Observer;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.u1.l.l;

public final class d
implements Observer {
    public final /* synthetic */ l a;

    public /* synthetic */ d(l l10) {
        this.a = l10;
    }

    public final void onChanged(Object object) {
        l l10 = this.a;
        object = (TemplatePOJO)object;
        l10.X((TemplatePOJO)object);
    }
}

