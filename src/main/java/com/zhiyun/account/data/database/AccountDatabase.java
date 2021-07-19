/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.data.database;

import androidx.room.RoomDatabase;
import com.zhiyun.account.data.database.dao.UserInfoDao;

public abstract class AccountDatabase
extends RoomDatabase {
    public abstract UserInfoDao userInfoDao();
}

