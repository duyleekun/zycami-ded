/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.d7;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;
import com.zhiyun.account.data.me.remote.ThirdLoginManager$OnThirdCallback;
import d.v.c.s0.d7.a0;
import d.v.c.s0.d7.z;

public class z$c
implements ThirdLoginManager$OnThirdCallback {
    public final /* synthetic */ z a;

    public z$c(z z10) {
        this.a = z10;
    }

    public void onCancel(int n10, int n11) {
        MutableLiveData mutableLiveData = z.n(this.a);
        Comparable<Boolean> comparable = Boolean.FALSE;
        mutableLiveData.postValue(comparable);
        mutableLiveData = z.k(this.a);
        comparable = 375;
        mutableLiveData.postValue(comparable);
    }

    public void onFailed(int n10) {
        MutableLiveData mutableLiveData = z.n(this.a);
        Comparable<Boolean> comparable = Boolean.FALSE;
        mutableLiveData.postValue(comparable);
        mutableLiveData = z.k(this.a);
        comparable = 375;
        mutableLiveData.postValue(comparable);
    }

    public void onSuccess(ThirdPlatform object, AccountManager$AuthData object2) {
        z.j(this.a, (AccountManager$AuthData)object2);
        object = a0.e();
        String string2 = z.g(this.a).getPlatformName();
        ((a0)object).g(string2, (AccountManager$AuthData)object2);
        z.m(this.a);
        object = z.n(this.a);
        object2 = Boolean.TRUE;
        ((MutableLiveData)object).postValue(object2);
    }
}

