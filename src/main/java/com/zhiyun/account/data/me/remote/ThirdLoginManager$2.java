/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.account.data.me.remote;

import android.text.TextUtils;
import com.zhiyun.account.R$string;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;
import com.zhiyun.account.data.me.remote.ThirdLoginManager;
import com.zhiyun.account.data.me.remote.ThirdLoginManager$FacebookToken;
import k.d;
import k.f;
import k.r;

public class ThirdLoginManager$2
implements f {
    public final /* synthetic */ ThirdLoginManager this$0;
    public final /* synthetic */ AccountManager$AuthData val$thirdData;

    public ThirdLoginManager$2(ThirdLoginManager thirdLoginManager, AccountManager$AuthData accountManager$AuthData) {
        this.this$0 = thirdLoginManager;
        this.val$thirdData = accountManager$AuthData;
    }

    public void onFailure(d d10, Throwable serializable) {
        d10 = ThirdLoginManager.access$200(this.this$0);
        serializable = Integer.valueOf(R$string.me_error_net);
        d10.obtainMessage(102, serializable).sendToTarget();
    }

    public void onResponse(d object, r object2) {
        boolean bl2;
        object = ((r)object2).a();
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((ThirdLoginManager$FacebookToken)object2.a()).token_for_business)))) {
            object = this.val$thirdData;
            ((AccountManager$AuthData)object).unionid = object2 = ((ThirdLoginManager$FacebookToken)object2.a()).token_for_business;
            object = ThirdLoginManager.access$200(this.this$0);
            int n10 = 101;
            AccountManager$AuthData accountManager$AuthData = this.val$thirdData;
            object = object.obtainMessage(n10, (Object)accountManager$AuthData);
            object.sendToTarget();
        } else {
            object = ThirdLoginManager.access$200(this.this$0);
            int n11 = 102;
            int n12 = R$string.me_error_net;
            Integer n13 = n12;
            object = object.obtainMessage(n11, (Object)n13);
            object.sendToTarget();
        }
    }
}

