/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPointDao;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPointDao_Impl$1;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPointDao_Impl$5;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPointDao_Impl$6;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPoint;
import e.a.i0;
import java.util.Collections;
import java.util.List;

public final class ScriptTrackPointDao_Impl
implements ScriptTrackPointDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfScriptTrackPoint;
    private final EntityInsertionAdapter __insertionAdapterOfScriptTrackPoint;
    private final EntityInsertionAdapter __insertionAdapterOfScriptTrackPoint_1;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfScriptTrackPoint;

    public ScriptTrackPointDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new ScriptTrackPointDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfScriptTrackPoint = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfScriptTrackPoint_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfScriptTrackPoint = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfScriptTrackPoint = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(ScriptTrackPointDao_Impl scriptTrackPointDao_Impl) {
        return scriptTrackPointDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(ScriptTrackPointDao_Impl scriptTrackPointDao_Impl) {
        return scriptTrackPointDao_Impl.__insertionAdapterOfScriptTrackPoint;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(ScriptTrackPointDao_Impl scriptTrackPointDao_Impl) {
        return scriptTrackPointDao_Impl.__insertionAdapterOfScriptTrackPoint_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(ScriptTrackPoint object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfScriptTrackPoint;
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
            object2 = this.__deletionAdapterOfScriptTrackPoint;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public long insert(ScriptTrackPoint object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfScriptTrackPoint_1;
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
            object = this.__insertionAdapterOfScriptTrackPoint_1;
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
        ScriptTrackPointDao_Impl$6 scriptTrackPointDao_Impl$6 = new ScriptTrackPointDao_Impl$6(this, list);
        return i0.o0(scriptTrackPointDao_Impl$6);
    }

    public long replace(ScriptTrackPoint object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfScriptTrackPoint;
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
            object = this.__insertionAdapterOfScriptTrackPoint;
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
        ScriptTrackPointDao_Impl$5 scriptTrackPointDao_Impl$5 = new ScriptTrackPointDao_Impl$5(this, list);
        return i0.o0(scriptTrackPointDao_Impl$5);
    }

    public void update(ScriptTrackPoint object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfScriptTrackPoint;
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

