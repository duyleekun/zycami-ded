/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.k1.a.x;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import java.util.function.Function;

public final class c
implements Function {
    public static final /* synthetic */ c a;

    static {
        c c10;
        a = c10 = new c();
    }

    public final Object apply(Object object) {
        return ((TemplateVideo)object).getVideoPath();
    }
}

