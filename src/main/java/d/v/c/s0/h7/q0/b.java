/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.q0;

import androidx.lifecycle.Observer;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.s0.h7.q0.x;

public final class b
implements Observer {
    public final /* synthetic */ x a;

    public /* synthetic */ b(x x10) {
        this.a = x10;
    }

    public final void onChanged(Object object) {
        x x10 = this.a;
        object = (TemplatePOJO)object;
        x10.B((TemplatePOJO)object);
    }
}

