/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.mediaprovider.data.local;

import androidx.room.RoomDatabase$Callback;
import androidx.room.RoomOpenHelper$Delegate;
import androidx.room.RoomOpenHelper$ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo$Column;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.zhiyun.mediaprovider.data.local.MediaDatabaseComm_Impl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MediaDatabaseComm_Impl$1
extends RoomOpenHelper$Delegate {
    public final /* synthetic */ MediaDatabaseComm_Impl this$0;

    public MediaDatabaseComm_Impl$1(MediaDatabaseComm_Impl mediaDatabaseComm_Impl, int n10) {
        this.this$0 = mediaDatabaseComm_Impl;
        super(n10);
    }

    public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `AlbumCustomizeData` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `albumTag` TEXT, `albumId` INTEGER NOT NULL, `path` TEXT)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '744bf2c9f9d331baa5f0eecfb319a5c9')");
    }

    public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `AlbumCustomizeData`");
        List list = MediaDatabaseComm_Impl.access$000(this.this$0);
        if (list != null) {
            list = null;
            List list2 = MediaDatabaseComm_Impl.access$100(this.this$0);
            int n10 = list2.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                RoomDatabase$Callback roomDatabase$Callback = (RoomDatabase$Callback)MediaDatabaseComm_Impl.access$200(this.this$0).get(i10);
                roomDatabase$Callback.onDestructiveMigration(supportSQLiteDatabase);
            }
        }
    }

    public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        List list = MediaDatabaseComm_Impl.access$300(this.this$0);
        if (list != null) {
            list = null;
            List list2 = MediaDatabaseComm_Impl.access$400(this.this$0);
            int n10 = list2.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                RoomDatabase$Callback roomDatabase$Callback = (RoomDatabase$Callback)MediaDatabaseComm_Impl.access$500(this.this$0).get(i10);
                roomDatabase$Callback.onCreate(supportSQLiteDatabase);
            }
        }
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        MediaDatabaseComm_Impl.access$602(this.this$0, supportSQLiteDatabase);
        MediaDatabaseComm_Impl.access$700(this.this$0, supportSQLiteDatabase);
        List list = MediaDatabaseComm_Impl.access$800(this.this$0);
        if (list != null) {
            list = null;
            List list2 = MediaDatabaseComm_Impl.access$900(this.this$0);
            int n10 = list2.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                RoomDatabase$Callback roomDatabase$Callback = (RoomDatabase$Callback)MediaDatabaseComm_Impl.access$1000(this.this$0).get(i10);
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
        int n10 = 4;
        Object object2 = new HashMap(n10);
        boolean bl2 = true;
        Serializable serializable = new TableInfo$Column("id", "INTEGER", bl2, 1, null, 1);
        ((HashMap)object2).put("id", serializable);
        int n11 = 1;
        HashSet hashSet = serializable;
        serializable = new TableInfo$Column("albumTag", "TEXT", false, 0, null, n11);
        ((HashMap)object2).put("albumTag", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("albumId", "INTEGER", true, 0, null, n11);
        ((HashMap)object2).put("albumId", serializable);
        hashSet = serializable;
        serializable = new TableInfo$Column("path", "TEXT", false, 0, null, n11);
        ((HashMap)object2).put("path", serializable);
        serializable = new HashSet(0);
        hashSet = new HashSet(0);
        String string2 = "AlbumCustomizeData";
        TableInfo tableInfo = new TableInfo(string2, (Map)object2, (Set)((Object)serializable), hashSet);
        object = TableInfo.read((SupportSQLiteDatabase)object, string2);
        boolean bl3 = tableInfo.equals(object);
        if (!bl3) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("AlbumCustomizeData(com.zhiyun.mediaprovider.data.local.model.AlbumCustomizeData).\n Expected:\n");
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

