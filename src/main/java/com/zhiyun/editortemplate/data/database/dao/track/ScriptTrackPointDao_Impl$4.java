/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPointDao_Impl;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPoint;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPointItem;

public class ScriptTrackPointDao_Impl$4
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ ScriptTrackPointDao_Impl this$0;

    public ScriptTrackPointDao_Impl$4(ScriptTrackPointDao_Impl scriptTrackPointDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = scriptTrackPointDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, ScriptTrackPoint scriptTrackPoint) {
        String string2;
        double d10;
        double d11;
        float f10;
        Float f11;
        double d12;
        long l10 = scriptTrackPoint.getId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = scriptTrackPoint.getTrackPointId();
        int n10 = 2;
        supportSQLiteStatement.bindLong(n10, l10);
        Object object = scriptTrackPoint.getType();
        int n11 = 3;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = scriptTrackPoint.getType();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
        int n12 = 4;
        float f12 = 5.6E-45f;
        long l11 = scriptTrackPoint.getDuration();
        supportSQLiteStatement.bindLong(n12, l11);
        object = scriptTrackPoint.getYaw();
        n11 = 5;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = scriptTrackPoint.getYaw();
            f12 = ((Float)object).floatValue();
            d12 = f12;
            supportSQLiteStatement.bindDouble(n11, d12);
        }
        object = scriptTrackPoint.getPitch();
        n11 = 6;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = scriptTrackPoint.getPitch();
            f12 = ((Float)object).floatValue();
            d12 = f12;
            supportSQLiteStatement.bindDouble(n11, d12);
        }
        object = scriptTrackPoint.getRoll();
        n11 = 7;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = scriptTrackPoint.getRoll();
            f12 = ((Float)object).floatValue();
            d12 = f12;
            supportSQLiteStatement.bindDouble(n11, d12);
        }
        object = scriptTrackPoint.getOrientation();
        n11 = 8;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = scriptTrackPoint.getOrientation();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
        object = scriptTrackPoint.getFunc();
        n11 = 9;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = scriptTrackPoint.getFunc();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
        object = scriptTrackPoint.getZoom();
        n11 = 11;
        n10 = 12;
        int n13 = 10;
        float f13 = 1.4E-44f;
        if (object != null) {
            f11 = ((ScriptTrackPointItem)object).getStart();
            if (f11 == null) {
                supportSQLiteStatement.bindNull(n13);
            } else {
                f11 = ((ScriptTrackPointItem)object).getStart();
                f10 = f11.floatValue();
                d11 = f10;
                supportSQLiteStatement.bindDouble(n13, d11);
            }
            f13 = ((ScriptTrackPointItem)object).getEnd();
            d10 = f13;
            supportSQLiteStatement.bindDouble(n11, d10);
            string2 = ((ScriptTrackPointItem)object).getType();
            if (string2 == null) {
                supportSQLiteStatement.bindNull(n10);
            } else {
                object = ((ScriptTrackPointItem)object).getType();
                supportSQLiteStatement.bindString(n10, (String)object);
            }
        } else {
            supportSQLiteStatement.bindNull(n13);
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n10);
        }
        object = scriptTrackPoint.getFocus();
        n11 = 14;
        n10 = 15;
        n13 = 13;
        f13 = 1.8E-44f;
        if (object != null) {
            f11 = ((ScriptTrackPointItem)object).getStart();
            if (f11 == null) {
                supportSQLiteStatement.bindNull(n13);
            } else {
                f11 = ((ScriptTrackPointItem)object).getStart();
                f10 = f11.floatValue();
                d11 = f10;
                supportSQLiteStatement.bindDouble(n13, d11);
            }
            f13 = ((ScriptTrackPointItem)object).getEnd();
            d10 = f13;
            supportSQLiteStatement.bindDouble(n11, d10);
            string2 = ((ScriptTrackPointItem)object).getType();
            if (string2 == null) {
                supportSQLiteStatement.bindNull(n10);
            } else {
                object = ((ScriptTrackPointItem)object).getType();
                supportSQLiteStatement.bindString(n10, (String)object);
            }
        } else {
            supportSQLiteStatement.bindNull(n13);
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n10);
        }
        l11 = scriptTrackPoint.getId();
        supportSQLiteStatement.bindLong(16, l11);
    }

    public String createQuery() {
        return "UPDATE OR REPLACE `script_track_point` SET `id` = ?,`track_point_id` = ?,`type` = ?,`duration` = ?,`yaw` = ?,`pitch` = ?,`roll` = ?,`orientation` = ?,`func` = ?,`zoom_start` = ?,`zoom_end` = ?,`zoom_type` = ?,`focus_start` = ?,`focus_end` = ?,`focus_type` = ? WHERE `id` = ?";
    }
}

