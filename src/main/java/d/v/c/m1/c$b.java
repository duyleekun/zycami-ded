/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1;

import com.zhiyun.account.data.database.model.UserInfo;
import d.v.a.f.b.a;
import d.v.c.m1.c;

public class c$b
extends a {
    public final /* synthetic */ c a;

    public c$b(c c10) {
        this.a = c10;
    }

    public void onError(Throwable throwable, int n10, String string2) {
    }

    public void onSuccess(UserInfo object) {
        c c10 = this.a;
        object = ((UserInfo)object).getToken();
        c10.w((String)object);
    }
}

