/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.a;

import com.zhiyun.account.data.api.entity.VisitorAccountEntity;
import com.zhiyun.account.data.database.model.UserInfo;
import d.v.a.f.b.a;
import d.v.a.f.c.b;
import d.v.c.y0.a.p;
import d.v.c.y0.a.p$c;

public class p$a
extends a {
    public final /* synthetic */ p$c a;
    public final /* synthetic */ p b;

    public p$a(p p10, p$c p$c) {
        this.b = p10;
        this.a = p$c;
    }

    public void a(VisitorAccountEntity object) {
        if (object != null) {
            UserInfo userInfo = ((VisitorAccountEntity)object).getUserInfo();
            object = ((VisitorAccountEntity)object).getToken();
            userInfo.setToken((String)object);
            object = d.v.c.v0.x.b.j();
            int n10 = userInfo.getId();
            ((d.v.c.v0.x.b)object).a(n10);
            d.v.a.f.c.b.N().r(userInfo);
            d.v.a.f.c.b.N().a();
            d.v.a.f.c.b.N().p();
            object = this.a;
            if (object != null) {
                object.a(userInfo);
            }
        } else {
            object = this.a;
            Object var2_3 = null;
            object.b(false);
        }
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.a;
        int n11 = -1;
        n10 = n10 == n11 ? 1 : 0;
        object.b(n10 != 0);
    }
}

