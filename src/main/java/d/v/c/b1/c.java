/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.b1;

import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.b1.s;
import java.util.function.Predicate;

public final class c
implements Predicate {
    public final /* synthetic */ String a;

    public /* synthetic */ c(String string2) {
        this.a = string2;
    }

    public final boolean test(Object object) {
        String string2 = this.a;
        object = (TemplatePOJO)object;
        return s.m(string2, (TemplatePOJO)object);
    }
}

