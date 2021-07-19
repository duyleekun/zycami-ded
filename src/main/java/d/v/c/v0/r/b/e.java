/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.r.b;

import com.zhiyun.cama.data.api.entity.filter.AssetsFilterListBean$AssetsFilterBean;
import d.v.c.v0.r.b.g;
import java.util.function.Function;

public final class e
implements Function {
    public final /* synthetic */ g a;

    public /* synthetic */ e(g g10) {
        this.a = g10;
    }

    public final Object apply(Object object) {
        g g10 = this.a;
        object = (AssetsFilterListBean$AssetsFilterBean)object;
        return g10.w((AssetsFilterListBean$AssetsFilterBean)object);
    }
}

