/*
 * Decompiled with CFR 0.151.
 */
package d.v.n;

import com.zhiyun.renderengine.business.display.DisplayRender;
import d.v.n.i;
import java.util.function.Consumer;

public final class f
implements Consumer {
    public final /* synthetic */ i a;

    public /* synthetic */ f(i i10) {
        this.a = i10;
    }

    public final void accept(Object object) {
        i i10 = this.a;
        object = (DisplayRender)object;
        i10.r((DisplayRender)object);
    }
}

