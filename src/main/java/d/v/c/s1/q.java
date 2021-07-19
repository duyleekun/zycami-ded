/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s1;

import com.zhiyun.cama.data.api.entity.speed.CurveTemp$CurveTempBean;
import d.v.c.s1.u;
import java.util.function.Consumer;

public final class q
implements Consumer {
    public final /* synthetic */ u a;
    public final /* synthetic */ long b;

    public /* synthetic */ q(u u10, long l10) {
        this.a = u10;
        this.b = l10;
    }

    public final void accept(Object object) {
        u u10 = this.a;
        long l10 = this.b;
        object = (CurveTemp$CurveTempBean)object;
        u10.n(l10, (CurveTemp$CurveTempBean)object);
    }
}

