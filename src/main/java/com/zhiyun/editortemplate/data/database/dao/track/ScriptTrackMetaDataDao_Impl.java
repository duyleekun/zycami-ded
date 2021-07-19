/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackMetaDataDao;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackMetaDataDao_Impl$1;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackMetaDataDao_Impl$5;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackMetaDataDao_Impl$6;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackMetaData;
import e.a.i0;
import java.util.Collections;
import java.util.List;

public final class ScriptTrackMetaDataDao_Impl
implements ScriptTrackMetaDataDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfScriptTrackMetaData;
    private final EntityInsertionAdapter __insertionAdapterOfScriptTrackMetaData;
    private final EntityInsertionAdapter __insertionAdapterOfScriptTrackMetaData_1;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfScriptTrackMetaData;

    public ScriptTrackMetaDataDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new ScriptTrackMetaDataDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfScriptTrackMetaData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfScriptTrackMetaData_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfScriptTrackMetaData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfScriptTrackMetaData = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(ScriptTrackMetaDataDao_Impl scriptTrackMetaDataDao_Impl) {
        return scriptTrackMetaDataDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(ScriptTrackMetaDataDao_Impl scriptTrackMetaDataDao_Impl) {
        return scriptTrackMetaDataDao_Impl.__insertionAdapterOfScriptTrackMetaData;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(ScriptTrackMetaDataDao_Impl scriptTrackMetaDataDao_Impl) {
        return scriptTrackMetaDataDao_Impl.__insertionAdapterOfScriptTrackMetaData_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(ScriptTrackMetaData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfScriptTrackMetaData;
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
            object2 = this.__deletionAdapterOfScriptTrackMetaData;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public long insert(ScriptTrackMetaData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfScriptTrackMetaData_1;
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
            object = this.__insertionAdapterOfScriptTrackMetaData_1;
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
        ScriptTrackMetaDataDao_Impl$6 scriptTrackMetaDataDao_Impl$6 = new ScriptTrackMetaDataDao_Impl$6(this, list);
        return i0.o0(scriptTrackMetaDataDao_Impl$6);
    }

    public long replace(ScriptTrackMetaData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfScriptTrackMetaData;
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
            object = this.__insertionAdapterOfScriptTrackMetaData;
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
        ScriptTrackMetaDataDao_Impl$5 scriptTrackMetaDataDao_Impl$5 = new ScriptTrackMetaDataDao_Impl$5(this, list);
        return i0.o0(scriptTrackMetaDataDao_Impl$5);
    }

    public void update(ScriptTrackMetaData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfScriptTrackMetaData;
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

