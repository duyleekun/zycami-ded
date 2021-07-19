/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.g;

import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import java.util.Objects;
import java.util.function.Predicate;

public final class x
implements Predicate {
    public static final /* synthetic */ x a;

    static {
        x x10;
        a = x10 = new x();
    }

    public final boolean test(Object object) {
        return Objects.nonNull((TemplatePOJO)object);
    }
}

