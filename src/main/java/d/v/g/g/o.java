/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import com.zhiyun.device.data.local.entity.FirmwareInfo;
import d.v.g.g.d1;
import java.util.function.Predicate;

public final class o
implements Predicate {
    public final /* synthetic */ d1 a;

    public /* synthetic */ o(d1 d12) {
        this.a = d12;
    }

    public final boolean test(Object object) {
        d1 d12 = this.a;
        object = (FirmwareInfo)object;
        return d1.p(d12, (FirmwareInfo)object);
    }
}

