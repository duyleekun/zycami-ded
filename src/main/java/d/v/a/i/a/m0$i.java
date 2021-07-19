/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.i.a;

import com.zhiyun.account.data.api.entity.GetCodeEntity;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.i.a.m0;

public class m0$i
extends a {
    public final /* synthetic */ a a;
    public final /* synthetic */ m0 b;

    public m0$i(m0 m02, a a10) {
        this.b = m02;
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

