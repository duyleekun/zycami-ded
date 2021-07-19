/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.c.b;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import java.util.function.Function;

public final class a
implements Function {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final Object apply(Object object) {
        return ((TemplateVideo)object).clone();
    }
}

