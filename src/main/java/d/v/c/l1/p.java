/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.account.data.database.model.UserInfo;
import d.v.c.l1.d0;
import e.a.v0.o;

public final class p
implements o {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ String e;

    public /* synthetic */ p(d0 d02, String string2, boolean bl2, boolean bl3, String string3) {
        this.a = d02;
        this.b = string2;
        this.c = bl2;
        this.d = bl3;
        this.e = string3;
    }

    public final Object apply(Object object) {
        d0 d02 = this.a;
        String string2 = this.b;
        boolean bl2 = this.c;
        boolean bl3 = this.d;
        String string3 = this.e;
        Object object2 = object;
        object2 = (UserInfo)object;
        return d02.F(string2, bl2, bl3, string3, (UserInfo)object2);
    }
}

