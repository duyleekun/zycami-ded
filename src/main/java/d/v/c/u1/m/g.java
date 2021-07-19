/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.template.edit.AiUseCase;
import java.util.List;

public final class g
implements Observer {
    public final /* synthetic */ AiUseCase a;

    public /* synthetic */ g(AiUseCase aiUseCase) {
        this.a = aiUseCase;
    }

    public final void onChanged(Object object) {
        AiUseCase aiUseCase = this.a;
        object = (List)object;
        aiUseCase.s((List)object);
    }
}

