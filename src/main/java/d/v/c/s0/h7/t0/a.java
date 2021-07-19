/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.t0;

import androidx.lifecycle.Observer;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.s0.h7.t0.b;

public final class a
implements Observer {
    public final /* synthetic */ b a;

    public /* synthetic */ a(b b10) {
        this.a = b10;
    }

    public final void onChanged(Object object) {
        b b10 = this.a;
        object = (TemplatePOJO)object;
        b10.x((TemplatePOJO)object);
    }
}

