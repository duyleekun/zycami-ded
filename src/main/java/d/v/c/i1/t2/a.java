/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.webkit.ValueCallback
 */
package d.v.c.i1.t2;

import android.webkit.ValueCallback;
import com.zhiyun.account.data.database.model.UserInfo;
import d.v.c.i1.t2.f0;

public final class a
implements ValueCallback {
    public final /* synthetic */ f0 a;
    public final /* synthetic */ UserInfo b;

    public /* synthetic */ a(f0 f02, UserInfo userInfo) {
        this.a = f02;
        this.b = userInfo;
    }

    public final void onReceiveValue(Object object) {
        f0 f02 = this.a;
        UserInfo userInfo = this.b;
        object = (String)object;
        f02.v(userInfo, (String)object);
    }
}

