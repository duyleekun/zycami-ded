/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.c.b;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRecording;
import java.util.function.Function;

public final class i
implements Function {
    public static final /* synthetic */ i a;

    static {
        i i10;
        a = i10 = new i();
    }

    public final Object apply(Object object) {
        return ((TemplateRecording)object).clone();
    }
}

