/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.mediaprovider.data.local;

import android.content.Context;
import androidx.room.Room;
import com.zhiyun.mediaprovider.data.local.MediaDatabaseComm;
import com.zhiyun.mediaprovider.data.local.MediaDatabaseCommHelp$SingleHolder;

public class MediaDatabaseCommHelp {
    private static final String DB_MEDIA_NAME = "media.db";
    private MediaDatabaseComm mAppDatabaseComm;

    public static MediaDatabaseCommHelp getInstance() {
        return MediaDatabaseCommHelp$SingleHolder.access$000();
    }

    public MediaDatabaseComm getDataBase(Context object) {
        Object object2 = this.mAppDatabaseComm;
        if (object2 == null) {
            object2 = MediaDatabaseComm.class;
            String string2 = DB_MEDIA_NAME;
            object = (MediaDatabaseComm)Room.databaseBuilder(object, (Class)object2, string2).allowMainThreadQueries().build();
            this.mAppDatabaseComm = object;
        }
        return this.mAppDatabaseComm;
    }
}

