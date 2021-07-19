/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.data.database.dao;

import androidx.lifecycle.LiveData;
import com.zhiyun.account.data.database.model.UserInfo;

public interface UserInfoDao {
    public void insertUserInfo(UserInfo ... var1);

    public LiveData loadUserInfo(int var1);

    public UserInfo loadUserInfoData(int var1);
}

