/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.RoomDatabase;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPOJODao;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPOJO;
import java.util.Collections;
import java.util.List;

public final class ScriptTrackPOJODao_Impl
implements ScriptTrackPOJODao {
    private final RoomDatabase __db;

    public ScriptTrackPOJODao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void insertScriptTrack(ScriptTrackPOJO object, long l10) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            ScriptTrackPOJODao.super.insertScriptTrack((ScriptTrackPOJO)object, l10);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void insertScriptTrack(List object, long l10) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            ScriptTrackPOJODao.super.insertScriptTrack((List)object, l10);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

