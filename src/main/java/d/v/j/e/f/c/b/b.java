/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.c.b;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import java.util.function.Function;

public final class b
implements Function {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final Object apply(Object object) {
        return ((TemplateSticker)object).clone();
    }
}

