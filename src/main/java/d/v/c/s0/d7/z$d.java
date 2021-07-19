/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.d7;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;
import com.zhiyun.live.data.api.entity.ThirdpartyAccessTokenInfo;
import d.v.c.s0.d7.a0;
import d.v.c.s0.d7.z;
import d.v.n.l.d$f;

public class z$d
implements d$f {
    public final /* synthetic */ z a;

    public z$d(z z10) {
        this.a = z10;
    }

    public void a() {
        MutableLiveData mutableLiveData = z.n(this.a);
        Comparable<Boolean> comparable = Boolean.FALSE;
        mutableLiveData.postValue(comparable);
        mutableLiveData = z.k(this.a);
        comparable = 375;
        mutableLiveData.postValue(comparable);
    }

    public void b(ThirdpartyAccessTokenInfo object) {
        long l10;
        Object object2 = z.i(this.a);
        Object object3 = ((ThirdpartyAccessTokenInfo)object).accessToken;
        ((AccountManager$AuthData)object2).access_token = object3;
        object2 = z.i(this.a);
        object3 = ((ThirdpartyAccessTokenInfo)object).openid;
        ((AccountManager$AuthData)object2).openid = object3;
        object2 = z.i(this.a);
        ((AccountManager$AuthData)object2).expires_at = l10 = (long)((ThirdpartyAccessTokenInfo)object).expiresAt;
        object = a0.e();
        object2 = z.g(this.a).getPlatformName();
        object3 = z.i(this.a);
        ((a0)object).g((String)object2, (AccountManager$AuthData)object3);
        z.m(this.a);
        object = z.n(this.a);
        object2 = Boolean.TRUE;
        ((MutableLiveData)object).postValue(object2);
    }

    public void c(String object, String string2) {
        z.i((z)this.a).nickname = object;
        z.i((z)this.a).avatar = string2;
        z.m(this.a);
        object = a0.e();
        string2 = z.g(this.a).getPlatformName();
        AccountManager$AuthData accountManager$AuthData = z.i(this.a);
        ((a0)object).g(string2, accountManager$AuthData);
    }
}

