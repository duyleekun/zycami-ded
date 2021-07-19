/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import java.util.function.Function;

public final class e
implements Function {
    public static final /* synthetic */ e a;

    static {
        e e10;
        a = e10 = new e();
    }

    public final Object apply(Object object) {
        return ((TemplateSticker)object).clone();
    }
}

