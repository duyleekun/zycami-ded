/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.j.c;

import com.zhiyun.account.data.api.entity.GetCodeEntity;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.j.c.y;

public class y$c
extends a {
    public final /* synthetic */ a a;
    public final /* synthetic */ y b;

    public y$c(y y10, a a10) {
        this.b = y10;
        this.a = a10;
    }

    public void onError(Throwable throwable, int n10, String string2) {
        this.a.onError(throwable, n10, string2);
    }

    public void onSuccess(BaseEntity object) {
        int n10;
        GetCodeEntity getCodeEntity = new GetCodeEntity();
        getCodeEntity.errcode = n10 = ((BaseEntity)object).errcode;
        getCodeEntity.errmsg = object = ((BaseEntity)object).errmsg;
        this.a.onSuccess(getCodeEntity);
    }
}

