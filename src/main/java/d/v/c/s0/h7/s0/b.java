/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.s0.h7.s0.y;

public final class b
implements Observer {
    public final /* synthetic */ y a;

    public /* synthetic */ b(y y10) {
        this.a = y10;
    }

    public final void onChanged(Object object) {
        y y10 = this.a;
        object = (TemplatePOJO)object;
        y10.g0((TemplatePOJO)object);
    }
}

