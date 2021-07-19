/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import androidx.arch.core.util.Function;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.SortResult;
import d.v.j.e.i.c1$b;

public final class e0
implements Function {
    public final /* synthetic */ c1$b a;

    public /* synthetic */ e0(c1$b c1$b) {
        this.a = c1$b;
    }

    public final Object apply(Object object) {
        c1$b c1$b = this.a;
        object = (SortResult)object;
        return c1$b.w((SortResult)object);
    }
}

