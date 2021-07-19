/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import com.zhiyun.cama.template.edit.AiUseCase;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import java.util.function.ToIntFunction;

public final class h
implements ToIntFunction {
    public static final /* synthetic */ h a;

    static {
        h h10;
        a = h10 = new h();
    }

    public final int applyAsInt(Object object) {
        return AiUseCase.k((TemplatePOJO)object);
    }
}

