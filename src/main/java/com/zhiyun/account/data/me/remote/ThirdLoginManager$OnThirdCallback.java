/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.data.me.remote;

import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;

public interface ThirdLoginManager$OnThirdCallback {
    public void onCancel(int var1, int var2);

    public void onFailed(int var1);

    public void onSuccess(ThirdPlatform var1, AccountManager$AuthData var2);
}

