/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.z1;

import com.zhiyun.cama.watermark.WaterMarkBean$WaterMarkDataInfo;
import d.v.c.z1.e;
import java.util.function.Predicate;

public final class a
implements Predicate {
    public final /* synthetic */ String a;

    public /* synthetic */ a(String string2) {
        this.a = string2;
    }

    public final boolean test(Object object) {
        String string2 = this.a;
        object = (WaterMarkBean$WaterMarkDataInfo)object;
        return e.i(string2, (WaterMarkBean$WaterMarkDataInfo)object);
    }
}

