/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.c.t0.h0;
import d.v.c.t0.i0;

public class i0$a
extends a {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ i0 e;

    public i0$a(i0 i02, String string2, String string3, int n10, int n11) {
        this.e = i02;
        this.a = string2;
        this.b = string3;
        this.c = n10;
        this.d = n11;
    }

    public void onError(Throwable object, int n10, String object2) {
        object = new h0();
        h0[] h0Array = this.a;
        ((h0)object).m((String)h0Array);
        h0Array = i0.a(this.e);
        ((h0)object).k((String)h0Array);
        h0Array = i0.c(this.e);
        ((h0)object).j((String)h0Array);
        h0Array = this.b;
        ((h0)object).o((String)h0Array);
        n10 = this.c;
        ((h0)object).n(n10);
        n10 = this.d;
        ((h0)object).i(n10);
        n10 = 1;
        ((h0)object).l(n10);
        object2 = DatabaseHelper.getInstance().getDataBase().ceUpLoadCloudLogInfoDao();
        h0Array = new h0[n10];
        h0Array[0] = object;
        object2.insertCEUpLoadCloudLogInfo(h0Array);
    }

    public void onSuccess(BaseEntity baseEntity) {
    }
}

