/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPointDao_Impl;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPoint;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPointItem;

public class ScriptTrackPointDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ ScriptTrackPointDao_Impl this$0;

    public ScriptTrackPointDao_Impl$1(ScriptTrackPointDao_Impl scriptTrackPointDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = scriptTrackPointDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, ScriptTrackPoint object) {
        double d10;
        double d11;
        long l10 = ((ScriptTrackPoint)object).getId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = ((ScriptTrackPoint)object).getTrackPointId();
        int n10 = 2;
        float f10 = 2.8E-45f;
        supportSQLiteStatement.bindLong(n10, l10);
        Object object2 = ((ScriptTrackPoint)object).getType();
        int n11 = 3;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((ScriptTrackPoint)object).getType();
            supportSQLiteStatement.bindString(n11, (String)object2);
        }
        int n12 = 4;
        float f11 = 5.6E-45f;
        long l11 = ((ScriptTrackPoint)object).getDuration();
        supportSQLiteStatement.bindLong(n12, l11);
        object2 = ((ScriptTrackPoint)object).getYaw();
        n11 = 5;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((ScriptTrackPoint)object).getYaw();
            f11 = ((Float)object2).floatValue();
            d11 = f11;
            supportSQLiteStatement.bindDouble(n11, d11);
        }
        object2 = ((ScriptTrackPoint)object).getPitch();
        n11 = 6;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((ScriptTrackPoint)object).getPitch();
            f11 = ((Float)object2).floatValue();
            d11 = f11;
            supportSQLiteStatement.bindDouble(n11, d11);
        }
        object2 = ((ScriptTrackPoint)object).getRoll();
        n11 = 7;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((ScriptTrackPoint)object).getRoll();
            f11 = ((Float)object2).floatValue();
            d11 = f11;
            supportSQLiteStatement.bindDouble(n11, d11);
        }
        object2 = ((ScriptTrackPoint)object).getOrientation();
        n11 = 8;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((ScriptTrackPoint)object).getOrientation();
            supportSQLiteStatement.bindString(n11, (String)object2);
        }
        object2 = ((ScriptTrackPoint)object).getFunc();
        n11 = 9;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((ScriptTrackPoint)object).getFunc();
            supportSQLiteStatement.bindString(n11, (String)object2);
        }
        object2 = ((ScriptTrackPoint)object).getZoom();
        n11 = 11;
        n10 = 12;
        f10 = 1.7E-44f;
        int n13 = 10;
        float f12 = 1.4E-44f;
        if (object2 != null) {
            Float f13 = ((ScriptTrackPointItem)object2).getStart();
            if (f13 == null) {
                supportSQLiteStatement.bindNull(n13);
            } else {
                f13 = ((ScriptTrackPointItem)object2).getStart();
                float f14 = f13.floatValue();
                double d12 = f14;
                supportSQLiteStatement.bindDouble(n13, d12);
            }
            f12 = ((ScriptTrackPointItem)object2).getEnd();
            d10 = f12;
            supportSQLiteStatement.bindDouble(n11, d10);
            String string2 = ((ScriptTrackPointItem)object2).getType();
            if (string2 == null) {
                supportSQLiteStatement.bindNull(n10);
            } else {
                object2 = ((ScriptTrackPointItem)object2).getType();
                supportSQLiteStatement.bindString(n10, (String)object2);
            }
        } else {
            supportSQLiteStatement.bindNull(n13);
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n10);
        }
        object = ((ScriptTrackPoint)object).getFocus();
        n12 = 14;
        f11 = 2.0E-44f;
        n11 = 15;
        n10 = 13;
        f10 = 1.8E-44f;
        if (object != null) {
            Float f15 = ((ScriptTrackPointItem)object).getStart();
            if (f15 == null) {
                supportSQLiteStatement.bindNull(n10);
            } else {
                f15 = ((ScriptTrackPointItem)object).getStart();
                f12 = f15.floatValue();
                d10 = f12;
                supportSQLiteStatement.bindDouble(n10, d10);
            }
            f10 = ((ScriptTrackPointItem)object).getEnd();
            d11 = f10;
            supportSQLiteStatement.bindDouble(n12, d11);
            object2 = ((ScriptTrackPointItem)object).getType();
            if (object2 == null) {
                supportSQLiteStatement.bindNull(n11);
            } else {
                object = ((ScriptTrackPointItem)object).getType();
                supportSQLiteStatement.bindString(n11, (String)object);
            }
        } else {
            supportSQLiteStatement.bindNull(n10);
            supportSQLiteStatement.bindNull(n12);
            supportSQLiteStatement.bindNull(n11);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `script_track_point` (`id`,`track_point_id`,`type`,`duration`,`yaw`,`pitch`,`roll`,`orientation`,`func`,`zoom_start`,`zoom_end`,`zoom_type`,`focus_start`,`focus_end`,`focus_type`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}

