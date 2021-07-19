/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.p0;

import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.protocol.constants.Model;
import d.v.c.s0.h7.p0.q;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public final class l
implements Predicate {
    public final /* synthetic */ q a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Model c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Set e;
    public final /* synthetic */ List f;
    public final /* synthetic */ Map g;

    public /* synthetic */ l(q q10, boolean bl2, Model model, String string2, Set set, List list, Map map) {
        this.a = q10;
        this.b = bl2;
        this.c = model;
        this.d = string2;
        this.e = set;
        this.f = list;
        this.g = map;
    }

    public final boolean test(Object object) {
        q q10 = this.a;
        boolean bl2 = this.b;
        Model model = this.c;
        String string2 = this.d;
        Set set = this.e;
        List list = this.f;
        Map map = this.g;
        Object object2 = object;
        object2 = (TemplatePOJO)object;
        return q10.o(bl2, model, string2, set, list, map, (TemplatePOJO)object2);
    }
}

