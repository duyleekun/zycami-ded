/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.PowerMode;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.rd;
import e.a.v0.o;

public final class v1
implements o {
    public final /* synthetic */ Stabilizer a;
    public final /* synthetic */ PowerMode b;

    public /* synthetic */ v1(Stabilizer stabilizer, PowerMode powerMode) {
        this.a = stabilizer;
        this.b = powerMode;
    }

    public final Object apply(Object object) {
        Stabilizer stabilizer = this.a;
        PowerMode powerMode = this.b;
        object = (rd)object;
        return stabilizer.S5(powerMode, (rd)object);
    }
}

