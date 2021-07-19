/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import java.util.function.Function;

public final class n1
implements Function {
    public static final /* synthetic */ n1 a;

    static {
        n1 n12;
        a = n12 = new n1();
    }

    public final Object apply(Object object) {
        return ((TemplateVideo)object).getVideoPath();
    }
}

