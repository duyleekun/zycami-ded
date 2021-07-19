/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioData;
import java.util.function.Function;

public final class c1
implements Function {
    public static final /* synthetic */ c1 a;

    static {
        c1 c12;
        a = c12 = new c1();
    }

    public final Object apply(Object object) {
        return ((TemplateAudioData)object).clone();
    }
}

