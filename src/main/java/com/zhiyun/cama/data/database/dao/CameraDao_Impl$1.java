/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.TypeCameraModeConverters;
import com.zhiyun.cama.data.database.TypeFpsSizeConverters;
import com.zhiyun.cama.data.database.dao.CameraDao_Impl;
import com.zhiyun.cama.data.database.model.CameraParam;
import d.v.d.i.g.k$a;

public class CameraDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ CameraDao_Impl this$0;

    public CameraDao_Impl$1(CameraDao_Impl cameraDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = cameraDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, CameraParam cameraParam) {
        long l10 = cameraParam.getFacing();
        supportSQLiteStatement.bindLong(1, l10);
        int n10 = TypeCameraModeConverters.modeToId(cameraParam.getMode());
        l10 = n10;
        int n11 = 2;
        supportSQLiteStatement.bindLong(n11, l10);
        Object object = CameraDao_Impl.access$000(this.this$0);
        k$a k$a = cameraParam.getVideoResolution();
        object = ((TypeFpsSizeConverters)object).fpsSizeToString(k$a);
        int n12 = 3;
        if (object == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            supportSQLiteStatement.bindString(n12, (String)object);
        }
        long l11 = cameraParam.getWhiteBalance();
        supportSQLiteStatement.bindLong(4, l11);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `CameraParam` (`facing`,`mode`,`videoResolution`,`whiteBalance`) VALUES (?,?,?,?)";
    }
}

