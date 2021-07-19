/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.a.j.c;

import android.content.Context;
import com.zhiyun.account.R$string;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;
import com.zhiyun.account.data.me.remote.ThirdLoginManager$OnThirdCallback;
import d.v.a.f.c.c;
import d.v.a.j.c.y;
import d.v.a.j.c.y$g$a;
import d.v.f.i.g;

public class y$g
implements ThirdLoginManager$OnThirdCallback {
    public final /* synthetic */ Context a;
    public final /* synthetic */ y b;

    public y$g(y y10, Context context) {
        this.b = y10;
        this.a = context;
    }

    public void onCancel(int n10, int n11) {
        String string2;
        int n12 = -1;
        if (n12 != n11) {
            Context context = this.a;
            int n13 = 1;
            Object[] objectArray = new Object[n13];
            String string3 = g.m(context, n11);
            objectArray[0] = string3;
            string2 = g.n(context, n10, objectArray);
        } else {
            Context context = this.a;
            string2 = g.m(context, n10);
        }
        y.f(this.b, n12, string2);
    }

    public void onFailed(int n10) {
        y y10 = this.b;
        Object object = this.a;
        int n11 = R$string.set_bind_failed;
        object = g.m(object, n11);
        y.f(y10, -1, (String)object);
    }

    public void onSuccess(ThirdPlatform thirdPlatform, AccountManager$AuthData accountManager$AuthData) {
        c c10 = y.g(this.b);
        y$g$a y$g$a = new y$g$a(this);
        c10.x(thirdPlatform, accountManager$AuthData, y$g$a);
    }
}

