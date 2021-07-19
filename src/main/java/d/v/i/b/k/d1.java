/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateBaseData;
import java.util.function.Function;

public final class d1
implements Function {
    public static final /* synthetic */ d1 a;

    static {
        d1 d12;
        a = d12 = new d1();
    }

    public final Object apply(Object object) {
        return ((TemplateBaseData)object).getCustomerUUID();
    }
}

