/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.data.database;

import androidx.room.RoomDatabase$Callback;
import androidx.room.RoomOpenHelper$Delegate;
import androidx.room.RoomOpenHelper$ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo$Column;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.zhiyun.account.data.database.AccountDatabase_Impl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountDatabase_Impl$1
extends RoomOpenHelper$Delegate {
    public final /* synthetic */ AccountDatabase_Impl this$0;

    public AccountDatabase_Impl$1(AccountDatabase_Impl accountDatabase_Impl, int n10) {
        this.this$0 = accountDatabase_Impl;
        super(n10);
    }

    public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `UserInfo` (`errcode` INTEGER NOT NULL, `errmsg` TEXT, `id` INTEGER NOT NULL, `avatar` TEXT, `nickname` TEXT, `birthday` TEXT, `country` TEXT, `city` TEXT, `introduction` TEXT, `hobby` TEXT, `sex` INTEGER NOT NULL, `share_post_count` INTEGER NOT NULL, `follows_count` INTEGER NOT NULL, `followers_count` INTEGER NOT NULL, `token` TEXT, `followed` INTEGER NOT NULL, `verified` INTEGER NOT NULL, `mobile` TEXT, `mail` TEXT, `adnotification` INTEGER NOT NULL, `status` TEXT, `longitude` REAL NOT NULL, `latitude` REAL NOT NULL, `memberId` INTEGER NOT NULL, `applicantId` INTEGER NOT NULL, `activity` INTEGER NOT NULL, `rank` INTEGER NOT NULL, `isAgree` INTEGER NOT NULL, `blocked` INTEGER NOT NULL, `prime` INTEGER NOT NULL, `primeId` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ec6dec70e235d74b541838d16b001381')");
    }

    public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `UserInfo`");
        List list = AccountDatabase_Impl.access$000(this.this$0);
        if (list != null) {
            list = null;
            List list2 = AccountDatabase_Impl.access$100(this.this$0);
            int n10 = list2.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                RoomDatabase$Callback roomDatabase$Callback = (RoomDatabase$Callback)AccountDatabase_Impl.access$200(this.this$0).get(i10);
                roomDatabase$Callback.onDestructiveMigration(supportSQLiteDatabase);
            }
        }
    }

    public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        List list = AccountDatabase_Impl.access$300(this.this$0);
        if (list != null) {
            list = null;
            List list2 = AccountDatabase_Impl.access$400(this.this$0);
            int n10 = list2.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                RoomDatabase$Callback roomDatabase$Callback = (RoomDatabase$Callback)AccountDatabase_Impl.access$500(this.this$0).get(i10);
                roomDatabase$Callback.onCreate(supportSQLiteDatabase);
            }
        }
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        AccountDatabase_Impl.access$602(this.this$0, supportSQLiteDatabase);
        AccountDatabase_Impl.access$700(this.this$0, supportSQLiteDatabase);
        List list = AccountDatabase_Impl.access$800(this.this$0);
        if (list != null) {
            list = null;
            List list2 = AccountDatabase_Impl.access$900(this.this$0);
            int n10 = list2.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                RoomDatabase$Callback roomDatabase$Callback = (RoomDatabase$Callback)AccountDatabase_Impl.access$1000(this.this$0).get(i10);
                roomDatabase$Callback.onOpen(supportSQLiteDatabase);
            }
        }
    }

    public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
    }

    public RoomOpenHelper$ValidationResult onValidateSchema(SupportSQLiteDatabase object) {
        int n10 = 31;
        Object object2 = new HashMap(n10);
        boolean bl2 = true;
        Serializable serializable = new TableInfo$Column("errcode", "INTEGER", bl2, 0, null, 1);
        ((HashMap)object2).put("errcode", serializable);
        int n11 = 1;
        HashSet hashSet = serializable;
        serializable = new TableInfo$Column("errmsg", "TEXT", false, 0, null, n11);
        ((HashMap)object2).put("errmsg", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("id", "INTEGER", true, 1, null, n11);
        ((HashMap)object2).put("id", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("avatar", "TEXT", false, 0, null, n11);
        ((HashMap)object2).put("avatar", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("nickname", "TEXT", false, 0, null, n11);
        ((HashMap)object2).put("nickname", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("birthday", "TEXT", false, 0, null, n11);
        ((HashMap)object2).put("birthday", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("country", "TEXT", false, 0, null, n11);
        ((HashMap)object2).put("country", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("city", "TEXT", false, 0, null, n11);
        ((HashMap)object2).put("city", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("introduction", "TEXT", false, 0, null, n11);
        ((HashMap)object2).put("introduction", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("hobby", "TEXT", false, 0, null, n11);
        ((HashMap)object2).put("hobby", serializable);
        boolean bl3 = true;
        hashSet = serializable;
        serializable = new TableInfo$Column("sex", "INTEGER", bl3, 0, null, n11);
        ((HashMap)object2).put("sex", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("share_post_count", "INTEGER", bl3, 0, null, n11);
        ((HashMap)object2).put("share_post_count", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("follows_count", "INTEGER", bl3, 0, null, n11);
        ((HashMap)object2).put("follows_count", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("followers_count", "INTEGER", bl3, 0, null, n11);
        ((HashMap)object2).put("followers_count", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("token", "TEXT", false, 0, null, n11);
        ((HashMap)object2).put("token", serializable);
        bl3 = true;
        hashSet = serializable;
        serializable = new TableInfo$Column("followed", "INTEGER", bl3, 0, null, n11);
        ((HashMap)object2).put("followed", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("verified", "INTEGER", bl3, 0, null, n11);
        ((HashMap)object2).put("verified", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("mobile", "TEXT", false, 0, null, n11);
        ((HashMap)object2).put("mobile", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("mail", "TEXT", false, 0, null, n11);
        ((HashMap)object2).put("mail", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("adnotification", "INTEGER", true, 0, null, n11);
        ((HashMap)object2).put("adnotification", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("status", "TEXT", false, 0, null, n11);
        ((HashMap)object2).put("status", serializable);
        bl3 = true;
        hashSet = serializable;
        serializable = new TableInfo$Column("longitude", "REAL", bl3, 0, null, n11);
        ((HashMap)object2).put("longitude", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("latitude", "REAL", bl3, 0, null, n11);
        ((HashMap)object2).put("latitude", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("memberId", "INTEGER", bl3, 0, null, n11);
        ((HashMap)object2).put("memberId", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("applicantId", "INTEGER", bl3, 0, null, n11);
        ((HashMap)object2).put("applicantId", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("activity", "INTEGER", bl3, 0, null, n11);
        ((HashMap)object2).put("activity", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("rank", "INTEGER", bl3, 0, null, n11);
        ((HashMap)object2).put("rank", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("isAgree", "INTEGER", bl3, 0, null, n11);
        ((HashMap)object2).put("isAgree", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("blocked", "INTEGER", bl3, 0, null, n11);
        ((HashMap)object2).put("blocked", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("prime", "INTEGER", bl3, 0, null, n11);
        ((HashMap)object2).put("prime", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("primeId", "INTEGER", bl3, 0, null, n11);
        ((HashMap)object2).put("primeId", serializable);
        serializable = new HashSet(0);
        hashSet = new HashSet(0);
        String string2 = "UserInfo";
        TableInfo tableInfo = new TableInfo(string2, (Map)object2, (Set)((Object)serializable), hashSet);
        object = TableInfo.read((SupportSQLiteDatabase)object, string2);
        boolean bl4 = tableInfo.equals(object);
        if (!bl4) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("UserInfo(com.zhiyun.account.data.database.model.UserInfo).\n Expected:\n");
            ((StringBuilder)serializable).append(tableInfo);
            ((StringBuilder)serializable).append("\n Found:\n");
            ((StringBuilder)serializable).append(object);
            object = ((StringBuilder)serializable).toString();
            object2 = new RoomOpenHelper$ValidationResult(false, (String)object);
            return object2;
        }
        object = new RoomOpenHelper$ValidationResult(true, null);
        return object;
    }
}

