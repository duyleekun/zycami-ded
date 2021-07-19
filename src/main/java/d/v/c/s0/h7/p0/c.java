/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.p0;

import androidx.lifecycle.Observer;
import com.zhiyun.protocol.constants.Model;
import d.v.c.s0.h7.p0.p;
import java.util.List;

public final class c
implements Observer {
    public final /* synthetic */ p a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Model c;

    public /* synthetic */ c(p p10, boolean bl2, Model model) {
        this.a = p10;
        this.b = bl2;
        this.c = model;
    }

    public final void onChanged(Object object) {
        p p10 = this.a;
        boolean bl2 = this.b;
        Model model = this.c;
        object = (List)object;
        p10.A(bl2, model, (List)object);
    }
}

