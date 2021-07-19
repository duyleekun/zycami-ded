/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7;

import androidx.lifecycle.Observer;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.s0.h7.m0;

public final class z
implements Observer {
    public final /* synthetic */ m0 a;

    public /* synthetic */ z(m0 m02) {
        this.a = m02;
    }

    public final void onChanged(Object object) {
        m0 m02 = this.a;
        object = (TemplatePOJO)object;
        m02.W((TemplatePOJO)object);
    }
}

