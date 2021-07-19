/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.m1.d;

import android.view.View;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.me.account.AccountActivity;
import d.v.a.i.a.m0;
import d.v.c.m1.d.k;

public class k$a {
    public final /* synthetic */ k a;

    public k$a(k k10) {
        this.a = k10;
    }

    public void a(View view) {
        this.a.dismiss();
    }

    public void b(View view) {
        AccountActivity.i(this.a.requireActivity(), 1);
        this.a.dismiss();
    }

    public void c(View view) {
        AccountActivity.i(this.a.requireActivity(), 2);
        this.a.dismiss();
    }

    public void d(ThirdPlatform thirdPlatform) {
        m0 m02 = k.u(this.a);
        View view = this.a.getView();
        m02.H(view, thirdPlatform);
    }
}

