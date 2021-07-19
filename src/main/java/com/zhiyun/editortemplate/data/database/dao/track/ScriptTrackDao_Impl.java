/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackDao;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackDao_Impl$1;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackDao_Impl$5;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackDao_Impl$6;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrack;
import e.a.i0;
import java.util.Collections;
import java.util.List;

public final class ScriptTrackDao_Impl
implements ScriptTrackDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfScriptTrack;
    private final EntityInsertionAdapter __insertionAdapterOfScriptTrack;
    private final EntityInsertionAdapter __insertionAdapterOfScriptTrack_1;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfScriptTrack;

    public ScriptTrackDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new ScriptTrackDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfScriptTrack = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfScriptTrack_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfScriptTrack = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfScriptTrack = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(ScriptTrackDao_Impl scriptTrackDao_Impl) {
        return scriptTrackDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(ScriptTrackDao_Impl scriptTrackDao_Impl) {
        return scriptTrackDao_Impl.__insertionAdapterOfScriptTrack;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(ScriptTrackDao_Impl scriptTrackDao_Impl) {
        return scriptTrackDao_Impl.__insertionAdapterOfScriptTrack_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(ScriptTrack object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfScriptTrack;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void delete(List object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfScriptTrack;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public long insert(ScriptTrack object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfScriptTrack_1;
            long l10 = ((EntityInsertionAdapter)object2).insertAndReturnId(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return l10;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public List insert(List list) {
        this.__db.assertNotSuspendingTransaction();
        Object object = this.__db;
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.__insertionAdapterOfScriptTrack_1;
            list = ((EntityInsertionAdapter)object).insertAndReturnIdsList(list);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return list;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public i0 insertSingle(List list) {
        ScriptTrackDao_Impl$6 scriptTrackDao_Impl$6 = new ScriptTrackDao_Impl$6(this, list);
        return i0.o0(scriptTrackDao_Impl$6);
    }

    public long replace(ScriptTrack object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfScriptTrack;
            long l10 = ((EntityInsertionAdapter)object2).insertAndReturnId(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return l10;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public List replace(List list) {
        this.__db.assertNotSuspendingTransaction();
        Object object = this.__db;
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.__insertionAdapterOfScriptTrack;
            list = ((EntityInsertionAdapter)object).insertAndReturnIdsList(list);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return list;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public i0 replaceSingle(List list) {
        ScriptTrackDao_Impl$5 scriptTrackDao_Impl$5 = new ScriptTrackDao_Impl$5(this, list);
        return i0.o0(scriptTrackDao_Impl$5);
    }

    public void update(ScriptTrack object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfScriptTrack;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

