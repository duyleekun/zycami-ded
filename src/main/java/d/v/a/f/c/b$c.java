/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.a.f.c;

import android.text.TextUtils;
import com.zhiyun.account.data.database.model.UserInfo;
import d.v.a.f.b.a;
import d.v.a.f.c.b;

public class b$c
extends a {
    public final /* synthetic */ a a;
    public final /* synthetic */ b b;

    public b$c(b b10, a a10) {
        this.b = b10;
        this.a = a10;
    }

    public void onError(Throwable throwable, int n10, String string2) {
        a a10 = this.a;
        if (a10 != null) {
            a10.onError(throwable, n10, string2);
        }
    }

    public void onSuccess(UserInfo userInfo) {
        this.b.r(userInfo);
        this.b.a();
        this.b.p();
        Object object = userInfo.getMobile();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)(object = userInfo.getMail())))) {
            object = this.b;
            boolean bl3 = true;
            ((b)object).e(bl3);
        }
        if ((object = this.a) != null) {
            object.onSuccess(userInfo);
        }
    }
}

