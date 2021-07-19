/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import com.zhiyun.cama.template.edit.AiUseCase;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import java.util.function.ToLongFunction;

public final class e
implements ToLongFunction {
    public static final /* synthetic */ e a;

    static {
        e e10;
        a = e10 = new e();
    }

    public final long applyAsLong(Object object) {
        return AiUseCase.n((TemplatePOJO)object);
    }
}

