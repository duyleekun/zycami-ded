/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.account.data.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.account.data.database.dao.UserInfoDao;
import com.zhiyun.account.data.database.dao.UserInfoDao_Impl$1;
import com.zhiyun.account.data.database.dao.UserInfoDao_Impl$2;
import com.zhiyun.account.data.database.model.UserInfo;
import java.util.Collections;
import java.util.List;

public final class UserInfoDao_Impl
implements UserInfoDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfUserInfo;

    public UserInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        UserInfoDao_Impl$1 userInfoDao_Impl$1 = new UserInfoDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfUserInfo = userInfoDao_Impl$1;
    }

    public static /* synthetic */ RoomDatabase access$000(UserInfoDao_Impl userInfoDao_Impl) {
        return userInfoDao_Impl.__db;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void insertUserInfo(UserInfo ... object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfUserInfo;
            ((EntityInsertionAdapter)object2).insert((Object[])object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public LiveData loadUserInfo(int n10) {
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM UserInfo WHERE id = ?", n11);
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"UserInfo"};
        UserInfoDao_Impl$2 userInfoDao_Impl$2 = new UserInfoDao_Impl$2(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, userInfoDao_Impl$2);
    }

    public UserInfo loadUserInfoData(int n10) {
        Object object = this;
        int n11 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM UserInfo WHERE id = ?", n11);
        int n12 = n10;
        long l10 = n10;
        roomSQLiteQuery.bindLong(n11, l10);
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        int n13 = 0;
        String string2 = null;
        int n14 = 0;
        Object object3 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "errcode";
        try {
            n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string3 = "errmsg";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "id";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "avatar";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "nickname";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "birthday";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "country";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "city";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "introduction";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "hobby";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "sex";
            n11 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            string2 = "share_post_count";
            n13 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            object3 = "follows_count";
            n14 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
            object = "followers_count";
            int n24 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n24;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }
}

