/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.c.b;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateMusic;
import java.util.function.Function;

public final class h
implements Function {
    public static final /* synthetic */ h a;

    static {
        h h10;
        a = h10 = new h();
    }

    public final Object apply(Object object) {
        return ((TemplateMusic)object).clone();
    }
}

