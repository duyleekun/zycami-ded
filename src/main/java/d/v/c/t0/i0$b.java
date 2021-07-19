/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.c.t0.h0;
import d.v.c.t0.i0;

public class i0$b
extends a {
    public final /* synthetic */ h0 a;
    public final /* synthetic */ i0 b;

    public i0$b(i0 i02, h0 h02) {
        this.b = i02;
        this.a = h02;
    }

    public void onError(Throwable throwable, int n10, String string2) {
    }

    public void onSuccess(BaseEntity object) {
        object = DatabaseHelper.getInstance().getDataBase().ceUpLoadCloudLogInfoDao();
        h0 h02 = this.a;
        h0[] h0Array = new h0[]{h02};
        object.deleteCEUpLoadCloudLogInfo(h0Array);
    }
}

