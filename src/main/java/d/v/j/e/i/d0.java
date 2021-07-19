/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import androidx.arch.core.util.Function;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.SortResult;
import d.v.j.e.i.c1$b;

public final class d0
implements Function {
    public final /* synthetic */ c1$b a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ d0(c1$b c1$b, boolean bl2) {
        this.a = c1$b;
        this.b = bl2;
    }

    public final Object apply(Object object) {
        c1$b c1$b = this.a;
        boolean bl2 = this.b;
        object = (SortResult)object;
        return c1$b.u(bl2, (SortResult)object);
    }
}

