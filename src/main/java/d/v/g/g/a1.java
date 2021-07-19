/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import com.zhiyun.device.data.local.entity.FirmwareInfo;
import java.util.function.Function;

public final class a1
implements Function {
    public static final /* synthetic */ a1 a;

    static {
        a1 a12;
        a = a12 = new a1();
    }

    public final Object apply(Object object) {
        return ((FirmwareInfo)object).getUrl();
    }
}

