/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.data.local;

import androidx.room.RoomDatabase$Callback;
import androidx.room.RoomOpenHelper$Delegate;
import androidx.room.RoomOpenHelper$ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo$Column;
import androidx.room.util.TableInfo$Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.zhiyun.device.data.local.DeviceDatabaseComm_Impl;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DeviceDatabaseComm_Impl$a
extends RoomOpenHelper$Delegate {
    public final /* synthetic */ DeviceDatabaseComm_Impl a;

    public DeviceDatabaseComm_Impl$a(DeviceDatabaseComm_Impl deviceDatabaseComm_Impl, int n10) {
        this.a = deviceDatabaseComm_Impl;
        super(n10);
    }

    public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `device_info` (`serial` INTEGER NOT NULL, `device_name` TEXT, `version` TEXT, `sub_model` TEXT, `create_timestamp` INTEGER NOT NULL, `update_timestamp` INTEGER NOT NULL, PRIMARY KEY(`serial`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `firmware_info` (`_id` INTEGER NOT NULL, `serial` INTEGER NOT NULL, `union_version` TEXT, `version` TEXT, `release_date` TEXT, `force_update` INTEGER NOT NULL, `need_update` INTEGER NOT NULL, `ota_update` INTEGER NOT NULL, `notice` TEXT, `release_notes` TEXT, `before_update_tip` TEXT, `after_update_tip` TEXT, `md5` TEXT, `url` TEXT, `path` TEXT, `filesize` INTEGER NOT NULL, `has_popup` INTEGER NOT NULL, PRIMARY KEY(`serial`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `AppDeviceInfo` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userid` TEXT, `phoneid` TEXT, `model` TEXT, `deviceid` TEXT, `bts` TEXT, `ets` TEXT, `longitude` TEXT, `latitude` TEXT, `serial_num` TEXT)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `activation_data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` INTEGER NOT NULL, `account` TEXT, `serialNum` TEXT, `deviceModel` INTEGER NOT NULL, `deviceName` TEXT, `appVersion` TEXT, `longitude` TEXT, `latitude` TEXT, `activeCode` TEXT, `activeAt` TEXT, `activeStatus` TEXT, `isVisitor` INTEGER NOT NULL, `ex` TEXT)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `regional_restrictions_info` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `deviceName` TEXT, `deviceSn` TEXT, `isRestrictions` INTEGER NOT NULL)");
        supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_regional_restrictions_info_deviceSn` ON `regional_restrictions_info` (`deviceSn`)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '3d81cc47a12703bb14caf26c16d91573')");
    }

    public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `device_info`");
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `firmware_info`");
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `AppDeviceInfo`");
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `activation_data`");
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `regional_restrictions_info`");
        List list = DeviceDatabaseComm_Impl.i(this.a);
        if (list != null) {
            list = null;
            List list2 = DeviceDatabaseComm_Impl.j(this.a);
            int n10 = list2.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                RoomDatabase$Callback roomDatabase$Callback = (RoomDatabase$Callback)DeviceDatabaseComm_Impl.l(this.a).get(i10);
                roomDatabase$Callback.onDestructiveMigration(supportSQLiteDatabase);
            }
        }
    }

    public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        List list = DeviceDatabaseComm_Impl.m(this.a);
        if (list != null) {
            list = null;
            List list2 = DeviceDatabaseComm_Impl.n(this.a);
            int n10 = list2.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                RoomDatabase$Callback roomDatabase$Callback = (RoomDatabase$Callback)DeviceDatabaseComm_Impl.o(this.a).get(i10);
                roomDatabase$Callback.onCreate(supportSQLiteDatabase);
            }
        }
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        DeviceDatabaseComm_Impl.p(this.a, supportSQLiteDatabase);
        DeviceDatabaseComm_Impl.q(this.a, supportSQLiteDatabase);
        List list = DeviceDatabaseComm_Impl.r(this.a);
        if (list != null) {
            list = null;
            List list2 = DeviceDatabaseComm_Impl.s(this.a);
            int n10 = list2.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                RoomDatabase$Callback roomDatabase$Callback = (RoomDatabase$Callback)DeviceDatabaseComm_Impl.k(this.a).get(i10);
                roomDatabase$Callback.onOpen(supportSQLiteDatabase);
            }
        }
    }

    public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
    }

    public RoomOpenHelper$ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
        Serializable serializable;
        Object object = supportSQLiteDatabase;
        Object object2 = new HashMap(6);
        boolean bl2 = true;
        Object object3 = serializable;
        serializable = new TableInfo$Column("serial", "INTEGER", bl2, 1, null, 1);
        object3 = "serial";
        ((HashMap)object2).put(object3, serializable);
        boolean bl3 = false;
        HashSet<Object> hashSet = serializable;
        serializable = new TableInfo$Column("device_name", "TEXT", false, 0, null, 1);
        ((HashMap)object2).put("device_name", serializable);
        Object object4 = null;
        boolean bl4 = true;
        serializable = new TableInfo$Column("version", "TEXT", false, 0, null, (int)(bl4 ? 1 : 0));
        hashSet = "version";
        ((HashMap)object2).put(hashSet, serializable);
        serializable = new TableInfo$Column("sub_model", "TEXT", false, 0, null, (int)(bl4 ? 1 : 0));
        ((HashMap)object2).put("sub_model", serializable);
        boolean bl5 = true;
        boolean bl6 = false;
        Object object5 = null;
        bl4 = false;
        String string2 = null;
        int n10 = 1;
        Object object6 = serializable;
        serializable = new TableInfo$Column("create_timestamp", "INTEGER", bl5, 0, null, n10);
        ((HashMap)object2).put("create_timestamp", serializable);
        object6 = serializable;
        serializable = new TableInfo$Column("update_timestamp", "INTEGER", bl5, 0, null, n10);
        ((HashMap)object2).put("update_timestamp", serializable);
        serializable = new HashSet(0);
        object6 = new HashSet(0);
        Object object7 = "device_info";
        Object object8 = new TableInfo((String)object7, (Map)object2, (Set)((Object)serializable), (Set)object6);
        object2 = TableInfo.read(supportSQLiteDatabase, (String)object7);
        boolean n11 = ((TableInfo)object8).equals(object2);
        object6 = "\n Found:\n";
        if (!n11) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("device_info(com.zhiyun.device.data.local.entity.DeviceInfo).\n Expected:\n");
            ((StringBuilder)serializable).append(object8);
            ((StringBuilder)serializable).append((String)object6);
            ((StringBuilder)serializable).append(object2);
            object2 = ((StringBuilder)serializable).toString();
            object = new RoomOpenHelper$ValidationResult(false, (String)object2);
            return object;
        }
        object2 = new HashMap(17);
        object8 = serializable;
        serializable = new TableInfo$Column("_id", "INTEGER", true, 0, null, 1);
        ((HashMap)object2).put("_id", serializable);
        int n12 = 1;
        object7 = serializable;
        serializable = new TableInfo$Column("serial", "INTEGER", true, 1, null, n12);
        ((HashMap)object2).put(object3, serializable);
        boolean bl7 = false;
        String string3 = null;
        int n13 = 1;
        Object object9 = serializable;
        serializable = new TableInfo$Column("union_version", "TEXT", false, 0, null, n13);
        ((HashMap)object2).put("union_version", serializable);
        bl4 = false;
        string2 = null;
        n10 = 0;
        int n14 = 1;
        object8 = serializable;
        serializable = new TableInfo$Column("version", "TEXT", false, 0, null, n14);
        ((HashMap)object2).put(hashSet, serializable);
        Object object10 = null;
        String string4 = null;
        int n15 = 1;
        object9 = "release_date";
        Object object11 = "TEXT";
        serializable = new TableInfo$Column((String)object9, (String)object11, false, 0, null, n15);
        ((HashMap)object2).put("release_date", serializable);
        bl6 = true;
        object8 = serializable;
        serializable = new TableInfo$Column("force_update", "INTEGER", bl6, 0, null, n14);
        ((HashMap)object2).put("force_update", serializable);
        object8 = serializable;
        serializable = new TableInfo$Column("need_update", "INTEGER", bl6, 0, null, n14);
        ((HashMap)object2).put("need_update", serializable);
        object8 = serializable;
        serializable = new TableInfo$Column("ota_update", "INTEGER", bl6, 0, null, n14);
        ((HashMap)object2).put("ota_update", serializable);
        object5 = null;
        object8 = serializable;
        serializable = new TableInfo$Column("notice", "TEXT", false, 0, null, n14);
        ((HashMap)object2).put("notice", serializable);
        object8 = serializable;
        serializable = new TableInfo$Column("release_notes", "TEXT", false, 0, null, n14);
        ((HashMap)object2).put("release_notes", serializable);
        object8 = serializable;
        serializable = new TableInfo$Column("before_update_tip", "TEXT", false, 0, null, n14);
        ((HashMap)object2).put("before_update_tip", serializable);
        object8 = serializable;
        serializable = new TableInfo$Column("after_update_tip", "TEXT", false, 0, null, n14);
        ((HashMap)object2).put("after_update_tip", serializable);
        object8 = serializable;
        serializable = new TableInfo$Column("md5", "TEXT", false, 0, null, n14);
        ((HashMap)object2).put("md5", serializable);
        object8 = serializable;
        serializable = new TableInfo$Column("url", "TEXT", false, 0, null, n14);
        ((HashMap)object2).put("url", serializable);
        object8 = serializable;
        serializable = new TableInfo$Column("path", "TEXT", false, 0, null, n14);
        ((HashMap)object2).put("path", serializable);
        bl6 = true;
        object8 = serializable;
        serializable = new TableInfo$Column("filesize", "INTEGER", bl6, 0, null, n14);
        ((HashMap)object2).put("filesize", serializable);
        object7 = "has_popup";
        object4 = "INTEGER";
        object8 = serializable;
        serializable = new TableInfo$Column((String)object7, (String)object4, bl6, 0, null, n14);
        ((HashMap)object2).put("has_popup", serializable);
        serializable = new HashSet(0);
        object3 = new HashSet(0);
        object8 = "firmware_info";
        hashSet = new HashSet<Object>((String)object8, (Map)object2, serializable, object3);
        object2 = TableInfo.read(supportSQLiteDatabase, (String)object8);
        boolean bl8 = ((TableInfo)((Object)hashSet)).equals(object2);
        if (!bl8) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("firmware_info(com.zhiyun.device.data.local.entity.FirmwareInfo).\n Expected:\n");
            ((StringBuilder)serializable).append(hashSet);
            ((StringBuilder)serializable).append((String)object6);
            ((StringBuilder)serializable).append(object2);
            object2 = ((StringBuilder)serializable).toString();
            object = new RoomOpenHelper$ValidationResult(false, (String)object2);
            return object;
        }
        object2 = new HashMap(10);
        n14 = 1;
        object8 = serializable;
        serializable = new TableInfo$Column("id", "INTEGER", true, 1, null, n14);
        object3 = "id";
        ((HashMap)object2).put(object3, serializable);
        bl6 = false;
        bl4 = false;
        string2 = null;
        object8 = serializable;
        serializable = new TableInfo$Column("userid", "TEXT", false, 0, null, n14);
        ((HashMap)object2).put("userid", serializable);
        object8 = serializable;
        serializable = new TableInfo$Column("phoneid", "TEXT", false, 0, null, n14);
        ((HashMap)object2).put("phoneid", serializable);
        object8 = serializable;
        serializable = new TableInfo$Column("model", "TEXT", false, 0, null, n14);
        ((HashMap)object2).put("model", serializable);
        object8 = serializable;
        serializable = new TableInfo$Column("deviceid", "TEXT", false, 0, null, n14);
        ((HashMap)object2).put("deviceid", serializable);
        object8 = serializable;
        serializable = new TableInfo$Column("bts", "TEXT", false, 0, null, n14);
        ((HashMap)object2).put("bts", serializable);
        object8 = serializable;
        serializable = new TableInfo$Column("ets", "TEXT", false, 0, null, n14);
        ((HashMap)object2).put("ets", serializable);
        object8 = serializable;
        serializable = new TableInfo$Column("longitude", "TEXT", false, 0, null, n14);
        hashSet = "longitude";
        ((HashMap)object2).put(hashSet, serializable);
        object8 = serializable;
        serializable = new TableInfo$Column("latitude", "TEXT", false, 0, null, n14);
        object8 = "latitude";
        ((HashMap)object2).put(object8, serializable);
        n10 = 0;
        n14 = 0;
        n12 = 1;
        object7 = serializable;
        serializable = new TableInfo$Column("serial_num", "TEXT", false, 0, null, n12);
        ((HashMap)object2).put("serial_num", serializable);
        serializable = new HashSet(0);
        object7 = new HashSet(0);
        object5 = "AppDeviceInfo";
        object4 = new TableInfo((String)object5, (Map)object2, (Set)((Object)serializable), (Set)object7);
        object2 = TableInfo.read(supportSQLiteDatabase, (String)object5);
        boolean bl9 = ((TableInfo)object4).equals(object2);
        if (!bl9) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("AppDeviceInfo(com.zhiyun.device.data.local.entity.AppDeviceInfo).\n Expected:\n");
            ((StringBuilder)serializable).append(object4);
            ((StringBuilder)serializable).append((String)object6);
            ((StringBuilder)serializable).append(object2);
            object2 = ((StringBuilder)serializable).toString();
            object = new RoomOpenHelper$ValidationResult(false, (String)object2);
            return object;
        }
        object2 = new HashMap(14);
        bl4 = true;
        object7 = serializable;
        serializable = new TableInfo$Column("id", "INTEGER", bl4, 1, null, 1);
        ((HashMap)object2).put(object3, serializable);
        bl7 = true;
        object11 = "userId";
        object9 = serializable;
        serializable = new TableInfo$Column((String)object11, "INTEGER", bl7, 0, null, 1);
        ((HashMap)object2).put("userId", serializable);
        n14 = 0;
        int n16 = 1;
        object4 = serializable;
        serializable = new TableInfo$Column("account", "TEXT", false, 0, null, n16);
        ((HashMap)object2).put("account", serializable);
        object4 = serializable;
        serializable = new TableInfo$Column("serialNum", "TEXT", false, 0, null, n16);
        ((HashMap)object2).put("serialNum", serializable);
        object4 = serializable;
        serializable = new TableInfo$Column("deviceModel", "INTEGER", true, 0, null, n16);
        ((HashMap)object2).put("deviceModel", serializable);
        object4 = serializable;
        serializable = new TableInfo$Column("deviceName", "TEXT", false, 0, null, n16);
        object7 = "deviceName";
        ((HashMap)object2).put(object7, serializable);
        object4 = serializable;
        serializable = new TableInfo$Column("appVersion", "TEXT", false, 0, null, n16);
        ((HashMap)object2).put("appVersion", serializable);
        object9 = null;
        int n17 = 1;
        object5 = serializable;
        serializable = new TableInfo$Column("longitude", "TEXT", false, 0, null, n17);
        ((HashMap)object2).put(hashSet, serializable);
        n15 = 0;
        n13 = 0;
        int n18 = 0;
        int n19 = 1;
        string3 = "latitude";
        string4 = "TEXT";
        object10 = serializable;
        serializable = new TableInfo$Column(string3, string4, false, 0, null, n19);
        ((HashMap)object2).put(object8, serializable);
        n12 = 0;
        n16 = 1;
        object4 = serializable;
        serializable = new TableInfo$Column("activeCode", "TEXT", false, 0, null, n16);
        ((HashMap)object2).put("activeCode", serializable);
        object4 = serializable;
        serializable = new TableInfo$Column("activeAt", "TEXT", false, 0, null, n16);
        ((HashMap)object2).put("activeAt", serializable);
        object4 = serializable;
        serializable = new TableInfo$Column("activeStatus", "TEXT", false, 0, null, n16);
        ((HashMap)object2).put("activeStatus", serializable);
        object4 = serializable;
        serializable = new TableInfo$Column("isVisitor", "INTEGER", true, 0, null, n16);
        ((HashMap)object2).put("isVisitor", serializable);
        n10 = 0;
        object5 = "ex";
        string2 = "TEXT";
        object4 = serializable;
        serializable = new TableInfo$Column((String)object5, string2, false, 0, null, n16);
        ((HashMap)object2).put("ex", serializable);
        serializable = new HashSet(0);
        hashSet = new HashSet<Object>(0);
        object4 = "activation_data";
        object8 = new TableInfo((String)object4, (Map)object2, (Set)((Object)serializable), hashSet);
        object2 = TableInfo.read(supportSQLiteDatabase, (String)object4);
        boolean bl10 = ((TableInfo)object8).equals(object2);
        if (!bl10) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("activation_data(com.zhiyun.device.data.local.entity.ActivationData).\n Expected:\n");
            ((StringBuilder)serializable).append(object8);
            ((StringBuilder)serializable).append((String)object6);
            ((StringBuilder)serializable).append(object2);
            object2 = ((StringBuilder)serializable).toString();
            object = new RoomOpenHelper$ValidationResult(false, (String)object2);
            return object;
        }
        int n20 = 4;
        object2 = new HashMap(n20);
        n12 = 0;
        n16 = 1;
        object4 = serializable;
        serializable = new TableInfo$Column("id", "INTEGER", true, 1, null, n16);
        ((HashMap)object2).put(object3, serializable);
        string4 = null;
        n15 = 0;
        n13 = 0;
        n18 = 1;
        object10 = "deviceName";
        string3 = "TEXT";
        object11 = serializable;
        serializable = new TableInfo$Column((String)object10, string3, false, 0, null, n18);
        ((HashMap)object2).put(object7, serializable);
        object5 = "deviceSn";
        object4 = serializable;
        serializable = new TableInfo$Column((String)object5, "TEXT", false, 0, null, n16);
        object3 = "deviceSn";
        ((HashMap)object2).put(object3, serializable);
        bl6 = true;
        bl4 = false;
        string2 = null;
        n10 = 0;
        n14 = 1;
        object8 = serializable;
        serializable = new TableInfo$Column("isRestrictions", "INTEGER", bl6, 0, null, n14);
        ((HashMap)object2).put("isRestrictions", serializable);
        serializable = new HashSet(0);
        bl3 = true;
        hashSet = new HashSet<Object>((int)(bl3 ? 1 : 0));
        object3 = Arrays.asList(object3);
        object4 = "index_regional_restrictions_info_deviceSn";
        object7 = new TableInfo$Index((String)object4, bl3, (List)object3);
        hashSet.add(object7);
        object7 = "regional_restrictions_info";
        object3 = new TableInfo((String)object7, (Map)object2, (Set)((Object)serializable), hashSet);
        object = TableInfo.read(supportSQLiteDatabase, (String)object7);
        boolean bl11 = ((TableInfo)object3).equals(object);
        if (!bl11) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("regional_restrictions_info(com.zhiyun.device.data.local.entity.RegionalRestrictionsInfo).\n Expected:\n");
            ((StringBuilder)serializable).append(object3);
            ((StringBuilder)serializable).append((String)object6);
            ((StringBuilder)serializable).append(object);
            object = ((StringBuilder)serializable).toString();
            object2 = new RoomOpenHelper$ValidationResult(false, (String)object);
            return object2;
        }
        object = new RoomOpenHelper$ValidationResult(bl3, null);
        return object;
    }
}

