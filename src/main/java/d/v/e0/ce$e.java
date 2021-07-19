/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.DebugMode;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ce;
import e.a.v0.o;
import e.a.z;

public class ce$e
implements o {
    public final /* synthetic */ ce a;

    public ce$e(ce ce2) {
        this.a = ce2;
    }

    public z a(Boolean object) {
        object = ce.s(this.a);
        DebugMode debugMode = DebugMode.IMU_DEBUG;
        return ((Stabilizer)object).r0(debugMode);
    }
}

