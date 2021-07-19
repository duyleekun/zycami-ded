/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import d.v.j.g.b0;
import java.util.function.ToLongFunction;

public final class g0
implements ToLongFunction {
    public static final /* synthetic */ g0 a;

    static {
        g0 g02;
        a = g02 = new g0();
    }

    public final long applyAsLong(Object object) {
        return b0.h((TemplateVideo)object);
    }
}

