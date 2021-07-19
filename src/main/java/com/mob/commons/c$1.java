/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.util.Base64
 */
package com.mob.commons;

import android.content.ContentValues;
import android.content.Context;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.commons.LockAction;
import com.mob.commons.b;
import com.mob.commons.c;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.SQLiteHelper;
import com.mob.tools.utils.SQLiteHelper$SingleTableDB;
import java.util.HashMap;

public class c$1
implements LockAction {
    public final /* synthetic */ long a;
    public final /* synthetic */ HashMap b;
    public final /* synthetic */ c c;

    public c$1(c c10, long l10, HashMap hashMap) {
        this.c = c10;
        this.a = l10;
        this.b = hashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean run(FileLocker fileLocker) {
        try {
            Object object;
            fileLocker = new ContentValues();
            Object object2 = "time";
            long l10 = this.a;
            Object object3 = String.valueOf(l10);
            fileLocker.put((String)object2, (String)object3);
            object2 = MobSDK.getContext();
            object2 = DeviceHelper.getInstance((Context)object2);
            object3 = this.b;
            if (object3 != null) {
                object = "appkey";
                Object object4 = MobSDK.getAppkey();
                ((HashMap)object3).put(object, object4);
                object3 = this.b;
                object = "apppkg";
                object4 = ((DeviceHelper)object2).getPackageName();
                ((HashMap)object3).put(object, object4);
                object3 = this.b;
                object = "appver";
                object4 = ((DeviceHelper)object2).getAppVersionName();
                ((HashMap)object3).put(object, object4);
                l10 = com.mob.commons.b.ah();
                long l11 = 0L;
                long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (l12 != false) {
                    object4 = this.b;
                    String string2 = "strategyId";
                    object3 = l10;
                    ((HashMap)object4).put(string2, object3);
                }
            }
            object2 = ((DeviceHelper)object2).getManufacturer();
            object2 = Data.rawMD5((String)object2);
            object3 = this.c;
            object3 = com.mob.commons.c.a((c)object3);
            object = this.b;
            object3 = ((Hashon)object3).fromHashMap((HashMap)object);
            object = "utf-8";
            object3 = ((String)object3).getBytes((String)object);
            object2 = Data.AES128Encode((byte[])object2, (byte[])object3);
            object3 = "data";
            int n10 = 2;
            object2 = Base64.encodeToString((byte[])object2, (int)n10);
            fileLocker.put((String)object3, (String)object2);
            object2 = this.c;
            object2 = com.mob.commons.c.b((c)object2);
            SQLiteHelper.insert((SQLiteHelper$SingleTableDB)object2, (ContentValues)fileLocker);
            return false;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.w(throwable);
        }
        return false;
    }
}

