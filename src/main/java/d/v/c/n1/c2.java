/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import com.zhiyun.cama.data.api.entity.DeviceEntity;
import java.util.function.Function;

public final class c2
implements Function {
    public static final /* synthetic */ c2 a;

    static {
        c2 c22;
        a = c22 = new c2();
    }

    public final Object apply(Object object) {
        return ((DeviceEntity)object).getTitle();
    }
}

