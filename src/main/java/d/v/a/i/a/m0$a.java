/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.a.i.a;

import android.view.View;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;
import com.zhiyun.account.data.me.remote.ThirdLoginManager$OnThirdCallback;
import d.v.a.f.b.a;
import d.v.a.i.a.m0;
import d.v.f.i.g;

public class m0$a
implements ThirdLoginManager$OnThirdCallback {
    public final /* synthetic */ a a;
    public final /* synthetic */ View b;
    public final /* synthetic */ m0 c;

    public m0$a(m0 m02, a a10, View view) {
        this.c = m02;
        this.a = a10;
        this.b = view;
    }

    public void onCancel(int n10, int n11) {
        a a10 = this.a;
        if (a10 != null) {
            String string2;
            Object object;
            View view;
            int n12 = -1;
            if (n12 != n11) {
                view = this.b;
                int n13 = 1;
                Object[] objectArray = new Object[n13];
                objectArray[0] = object = g.q(view, n11);
                string2 = g.r(view, n10, objectArray);
            } else {
                object = this.b;
                string2 = g.q((View)object, n10);
            }
            object = this.a;
            view = null;
            object.onError(null, n12, string2);
        }
    }

    public void onFailed(int n10) {
        a a10 = this.a;
        if (a10 != null) {
            String string2 = g.q(this.b, n10);
            a10 = this.a;
            int n11 = -1;
            a10.onError(null, n11, string2);
        }
    }

    public void onSuccess(ThirdPlatform thirdPlatform, AccountManager$AuthData accountManager$AuthData) {
        m0 m02 = this.c;
        a a10 = this.a;
        m0.g(m02, thirdPlatform, accountManager$AuthData, a10);
    }
}

