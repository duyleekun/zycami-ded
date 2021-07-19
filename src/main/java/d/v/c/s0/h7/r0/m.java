/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.r0;

import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.s0.h7.r0.u;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public final class m
implements Predicate {
    public final /* synthetic */ Set a;
    public final /* synthetic */ List b;

    public /* synthetic */ m(Set set, List list) {
        this.a = set;
        this.b = list;
    }

    public final boolean test(Object object) {
        Set set = this.a;
        List list = this.b;
        object = (TemplatePOJO)object;
        return u.j(set, list, (TemplatePOJO)object);
    }
}

