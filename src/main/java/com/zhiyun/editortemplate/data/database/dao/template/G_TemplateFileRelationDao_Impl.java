/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl$1;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl$10;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl$11;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl$12;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl$13;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl$14;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl$15;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl$16;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl$17;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl$18;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl$19;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl$20;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl$7;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl$8;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl$9;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateFileRelation;
import e.a.i0;
import e.a.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public final class G_TemplateFileRelationDao_Impl
implements G_TemplateFileRelationDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTemplateFileRelation;
    private final EntityInsertionAdapter __insertionAdapterOfTemplateFileRelation;
    private final EntityInsertionAdapter __insertionAdapterOfTemplateFileRelation_1;
    private final SharedSQLiteStatement __preparedStmtOfCopyAndInsertRelation;
    private final SharedSQLiteStatement __preparedStmtOfDeleteRelationFromTemplateData;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfTemplateFileRelation;

    public G_TemplateFileRelationDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new G_TemplateFileRelationDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfTemplateFileRelation = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfTemplateFileRelation_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfTemplateFileRelation = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfTemplateFileRelation = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfCopyAndInsertRelation = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteRelationFromTemplateData = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(G_TemplateFileRelationDao_Impl g_TemplateFileRelationDao_Impl) {
        return g_TemplateFileRelationDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(G_TemplateFileRelationDao_Impl g_TemplateFileRelationDao_Impl) {
        return g_TemplateFileRelationDao_Impl.__insertionAdapterOfTemplateFileRelation;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(G_TemplateFileRelationDao_Impl g_TemplateFileRelationDao_Impl) {
        return g_TemplateFileRelationDao_Impl.__insertionAdapterOfTemplateFileRelation_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void copyAndInsertRelation(long l10, long l11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfCopyAndInsertRelation.acquire();
        int n10 = 1;
        supportSQLiteStatement.bindLong(n10, l11);
        int n11 = 2;
        supportSQLiteStatement.bindLong(n11, l10);
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            supportSQLiteStatement.executeInsert();
            roomDatabase = this.__db;
            roomDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfCopyAndInsertRelation.release(supportSQLiteStatement);
        }
    }

    public void delete(TemplateFileRelation object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfTemplateFileRelation;
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
            object2 = this.__deletionAdapterOfTemplateFileRelation;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void deleteRelationFromTemplateData(long l10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteRelationFromTemplateData.acquire();
        int n10 = 1;
        supportSQLiteStatement.bindLong(n10, l10);
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            roomDatabase = this.__db;
            roomDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteRelationFromTemplateData.release(supportSQLiteStatement);
        }
    }

    public long insert(TemplateFileRelation object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTemplateFileRelation_1;
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
            object = this.__insertionAdapterOfTemplateFileRelation_1;
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
        G_TemplateFileRelationDao_Impl$8 g_TemplateFileRelationDao_Impl$8 = new G_TemplateFileRelationDao_Impl$8(this, list);
        return i0.o0(g_TemplateFileRelationDao_Impl$8);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List loadRelationFromFile(String object) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateFileRelation WHERE file_hash = ?", n10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        this.__db.assertNotSuspendingTransaction();
        object = this.__db;
        n10 = 0;
        object = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        String string2 = "temp_id";
        try {
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string2);
            String string3 = "file_hash";
            int n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string3);
            int n12 = object.getCount();
            ArrayList<TemplateFileRelation> arrayList = new ArrayList<TemplateFileRelation>(n12);
            while ((n12 = (int)(object.moveToNext() ? 1 : 0)) != 0) {
                String string4;
                long l10 = object.getLong(n10);
                boolean bl2 = object.isNull(n11);
                if (bl2) {
                    bl2 = false;
                    string4 = null;
                } else {
                    string4 = object.getString(n11);
                }
                TemplateFileRelation templateFileRelation = new TemplateFileRelation(l10, string4);
                arrayList.add(templateFileRelation);
            }
            return arrayList;
        }
        finally {
            object.close();
            roomSQLiteQuery.release();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List loadRelationFromFile(List object) {
        String string2;
        int n10;
        Object object2 = StringUtil.newStringBuilder();
        String string3 = "SELECT DISTINCT * FROM TemplateFileRelation WHERE file_hash IN (";
        ((StringBuilder)object2).append(string3);
        int n11 = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object2, n11);
        ((StringBuilder)object2).append(")");
        object2 = ((StringBuilder)object2).toString();
        int n12 = 0;
        String string4 = null;
        object2 = RoomSQLiteQuery.acquire((String)object2, n11 += 0);
        object = object.iterator();
        n11 = 1;
        while ((n10 = object.hasNext()) != 0) {
            string2 = (String)object.next();
            if (string2 == null) {
                ((RoomSQLiteQuery)object2).bindNull(n11);
            } else {
                ((RoomSQLiteQuery)object2).bindString(n11, string2);
            }
            ++n11;
        }
        this.__db.assertNotSuspendingTransaction();
        object = this.__db;
        n11 = 0;
        string3 = null;
        object = DBUtil.query((RoomDatabase)object, (SupportSQLiteQuery)object2, false, null);
        string4 = "temp_id";
        try {
            n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string4);
            string2 = "file_hash";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string2);
            int n13 = object.getCount();
            ArrayList<TemplateFileRelation> arrayList = new ArrayList<TemplateFileRelation>(n13);
            while ((n13 = (int)(object.moveToNext() ? 1 : 0)) != 0) {
                String string5;
                long l10 = object.getLong(n12);
                boolean bl2 = object.isNull(n10);
                if (bl2) {
                    bl2 = false;
                    string5 = null;
                } else {
                    string5 = object.getString(n10);
                }
                TemplateFileRelation templateFileRelation = new TemplateFileRelation(l10, string5);
                arrayList.add(templateFileRelation);
            }
            return arrayList;
        }
        finally {
            object.close();
            ((RoomSQLiteQuery)object2).release();
        }
    }

    public LiveData loadRelationFromFile_LiveData(String object) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateFileRelation WHERE file_hash = ?", n10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        object = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"TemplateFileRelation"};
        G_TemplateFileRelationDao_Impl$10 g_TemplateFileRelationDao_Impl$10 = new G_TemplateFileRelationDao_Impl$10(this, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, g_TemplateFileRelationDao_Impl$10);
    }

    public LiveData loadRelationFromFile_LiveData(List object) {
        Object object2;
        boolean bl2;
        Object object3 = StringUtil.newStringBuilder();
        String[] stringArray = "SELECT DISTINCT * FROM TemplateFileRelation WHERE file_hash IN (";
        ((StringBuilder)object3).append((String)stringArray);
        int n10 = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object3, n10);
        ((StringBuilder)object3).append(")");
        object3 = ((StringBuilder)object3).toString();
        object3 = RoomSQLiteQuery.acquire((String)object3, n10 += 0);
        object = object.iterator();
        n10 = 1;
        while (bl2 = object.hasNext()) {
            object2 = (String)object.next();
            if (object2 == null) {
                ((RoomSQLiteQuery)object3).bindNull(n10);
            } else {
                ((RoomSQLiteQuery)object3).bindString(n10, (String)object2);
            }
            ++n10;
        }
        object = this.__db.getInvalidationTracker();
        stringArray = new String[]{"TemplateFileRelation"};
        object2 = new G_TemplateFileRelationDao_Impl$13(this, (RoomSQLiteQuery)object3);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, (Callable)object2);
    }

    public z loadRelationFromFile_Observable(String object) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateFileRelation WHERE file_hash = ?", n10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        object = this.__db;
        String[] stringArray = new String[]{"TemplateFileRelation"};
        G_TemplateFileRelationDao_Impl$11 g_TemplateFileRelationDao_Impl$11 = new G_TemplateFileRelationDao_Impl$11(this, roomSQLiteQuery);
        return RxRoom.createObservable((RoomDatabase)object, false, stringArray, g_TemplateFileRelationDao_Impl$11);
    }

    public z loadRelationFromFile_Observable(List object) {
        Object object2;
        boolean bl2;
        Object object3 = StringUtil.newStringBuilder();
        String[] stringArray = "SELECT DISTINCT * FROM TemplateFileRelation WHERE file_hash IN (";
        ((StringBuilder)object3).append((String)stringArray);
        int n10 = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object3, n10);
        ((StringBuilder)object3).append(")");
        object3 = ((StringBuilder)object3).toString();
        object3 = RoomSQLiteQuery.acquire((String)object3, n10 += 0);
        object = object.iterator();
        n10 = 1;
        while (bl2 = object.hasNext()) {
            object2 = (String)object.next();
            if (object2 == null) {
                ((RoomSQLiteQuery)object3).bindNull(n10);
            } else {
                ((RoomSQLiteQuery)object3).bindString(n10, (String)object2);
            }
            ++n10;
        }
        object = this.__db;
        stringArray = new String[]{"TemplateFileRelation"};
        object2 = new G_TemplateFileRelationDao_Impl$14(this, (RoomSQLiteQuery)object3);
        return RxRoom.createObservable((RoomDatabase)object, false, stringArray, (Callable)object2);
    }

    public i0 loadRelationFromFile_Single(String object) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateFileRelation WHERE file_hash = ?", n10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        object = new G_TemplateFileRelationDao_Impl$9(this, roomSQLiteQuery);
        return RxRoom.createSingle((Callable)object);
    }

    public i0 loadRelationFromFile_Single(List object) {
        boolean bl2;
        Object object2 = StringUtil.newStringBuilder();
        String string2 = "SELECT DISTINCT * FROM TemplateFileRelation WHERE file_hash IN (";
        ((StringBuilder)object2).append(string2);
        int n10 = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object2, n10);
        String string3 = ")";
        ((StringBuilder)object2).append(string3);
        object2 = ((StringBuilder)object2).toString();
        object2 = RoomSQLiteQuery.acquire((String)object2, n10 += 0);
        object = object.iterator();
        n10 = 1;
        while (bl2 = object.hasNext()) {
            string3 = (String)object.next();
            if (string3 == null) {
                ((RoomSQLiteQuery)object2).bindNull(n10);
            } else {
                ((RoomSQLiteQuery)object2).bindString(n10, string3);
            }
            ++n10;
        }
        object = new G_TemplateFileRelationDao_Impl$12(this, (RoomSQLiteQuery)object2);
        return RxRoom.createSingle((Callable)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List loadRelationFromTemplate(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateFileRelation WHERE temp_id = ?", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        this.__db.assertNotSuspendingTransaction();
        RoomDatabase roomDatabase = this.__db;
        int n11 = 0;
        n10 = 0;
        roomDatabase = DBUtil.query(roomDatabase, roomSQLiteQuery, false, null);
        String string2 = "temp_id";
        try {
            n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string2);
            String string3 = "file_hash";
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string3);
            int n13 = roomDatabase.getCount();
            ArrayList<TemplateFileRelation> arrayList = new ArrayList<TemplateFileRelation>(n13);
            while ((n13 = (int)(roomDatabase.moveToNext() ? 1 : 0)) != 0) {
                String string4;
                long l11 = roomDatabase.getLong(n11);
                boolean bl2 = roomDatabase.isNull(n12);
                if (bl2) {
                    bl2 = false;
                    string4 = null;
                } else {
                    string4 = roomDatabase.getString(n12);
                }
                TemplateFileRelation templateFileRelation = new TemplateFileRelation(l11, string4);
                arrayList.add(templateFileRelation);
            }
            return arrayList;
        }
        finally {
            roomDatabase.close();
            roomSQLiteQuery.release();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List loadRelationFromTemplate(List object) {
        Object object2;
        int n10;
        Object object3 = StringUtil.newStringBuilder();
        String string2 = "SELECT DISTINCT * FROM TemplateFileRelation WHERE temp_id IN (";
        ((StringBuilder)object3).append(string2);
        int n11 = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object3, n11);
        ((StringBuilder)object3).append(")");
        object3 = ((StringBuilder)object3).toString();
        int n12 = 0;
        String string3 = null;
        object3 = RoomSQLiteQuery.acquire((String)object3, n11 += 0);
        object = object.iterator();
        n11 = 1;
        while ((n10 = object.hasNext()) != 0) {
            object2 = (Long)object.next();
            if (object2 == null) {
                ((RoomSQLiteQuery)object3).bindNull(n11);
            } else {
                long l10 = (Long)object2;
                ((RoomSQLiteQuery)object3).bindLong(n11, l10);
            }
            ++n11;
        }
        this.__db.assertNotSuspendingTransaction();
        object = this.__db;
        n11 = 0;
        string2 = null;
        object = DBUtil.query((RoomDatabase)object, (SupportSQLiteQuery)object3, false, null);
        string3 = "temp_id";
        try {
            n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string3);
            object2 = "file_hash";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object2);
            int n13 = object.getCount();
            ArrayList<TemplateFileRelation> arrayList = new ArrayList<TemplateFileRelation>(n13);
            while ((n13 = (int)(object.moveToNext() ? 1 : 0)) != 0) {
                String string4;
                long l11 = object.getLong(n12);
                boolean bl2 = object.isNull(n10);
                if (bl2) {
                    bl2 = false;
                    string4 = null;
                } else {
                    string4 = object.getString(n10);
                }
                TemplateFileRelation templateFileRelation = new TemplateFileRelation(l11, string4);
                arrayList.add(templateFileRelation);
            }
            return arrayList;
        }
        finally {
            object.close();
            ((RoomSQLiteQuery)object3).release();
        }
    }

    public LiveData loadRelationFromTemplate_LiveData(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateFileRelation WHERE temp_id = ?", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"TemplateFileRelation"};
        G_TemplateFileRelationDao_Impl$19 g_TemplateFileRelationDao_Impl$19 = new G_TemplateFileRelationDao_Impl$19(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, g_TemplateFileRelationDao_Impl$19);
    }

    public LiveData loadRelationFromTemplate_LiveData(List object) {
        Object object2;
        boolean bl2;
        Object object3 = StringUtil.newStringBuilder();
        String[] stringArray = "SELECT DISTINCT * FROM TemplateFileRelation WHERE temp_id IN (";
        ((StringBuilder)object3).append((String)stringArray);
        int n10 = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object3, n10);
        ((StringBuilder)object3).append(")");
        object3 = ((StringBuilder)object3).toString();
        object3 = RoomSQLiteQuery.acquire((String)object3, n10 += 0);
        object = object.iterator();
        n10 = 1;
        while (bl2 = object.hasNext()) {
            object2 = (Long)object.next();
            if (object2 == null) {
                ((RoomSQLiteQuery)object3).bindNull(n10);
            } else {
                long l10 = (Long)object2;
                ((RoomSQLiteQuery)object3).bindLong(n10, l10);
            }
            ++n10;
        }
        object = this.__db.getInvalidationTracker();
        stringArray = new String[]{"TemplateFileRelation"};
        object2 = new G_TemplateFileRelationDao_Impl$16(this, (RoomSQLiteQuery)object3);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, (Callable)object2);
    }

    public z loadRelationFromTemplate_Observable(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateFileRelation WHERE temp_id = ?", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        RoomDatabase roomDatabase = this.__db;
        String[] stringArray = new String[]{"TemplateFileRelation"};
        G_TemplateFileRelationDao_Impl$20 g_TemplateFileRelationDao_Impl$20 = new G_TemplateFileRelationDao_Impl$20(this, roomSQLiteQuery);
        return RxRoom.createObservable(roomDatabase, false, stringArray, g_TemplateFileRelationDao_Impl$20);
    }

    public z loadRelationFromTemplate_Observable(List object) {
        Object object2;
        boolean bl2;
        Object object3 = StringUtil.newStringBuilder();
        String[] stringArray = "SELECT DISTINCT * FROM TemplateFileRelation WHERE temp_id IN (";
        ((StringBuilder)object3).append((String)stringArray);
        int n10 = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object3, n10);
        ((StringBuilder)object3).append(")");
        object3 = ((StringBuilder)object3).toString();
        object3 = RoomSQLiteQuery.acquire((String)object3, n10 += 0);
        object = object.iterator();
        n10 = 1;
        while (bl2 = object.hasNext()) {
            object2 = (Long)object.next();
            if (object2 == null) {
                ((RoomSQLiteQuery)object3).bindNull(n10);
            } else {
                long l10 = (Long)object2;
                ((RoomSQLiteQuery)object3).bindLong(n10, l10);
            }
            ++n10;
        }
        object = this.__db;
        stringArray = new String[]{"TemplateFileRelation"};
        object2 = new G_TemplateFileRelationDao_Impl$17(this, (RoomSQLiteQuery)object3);
        return RxRoom.createObservable((RoomDatabase)object, false, stringArray, (Callable)object2);
    }

    public i0 loadRelationFromTemplate_Single(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateFileRelation WHERE temp_id = ?", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        G_TemplateFileRelationDao_Impl$18 g_TemplateFileRelationDao_Impl$18 = new G_TemplateFileRelationDao_Impl$18(this, roomSQLiteQuery);
        return RxRoom.createSingle(g_TemplateFileRelationDao_Impl$18);
    }

    public i0 loadRelationFromTemplate_Single(List object) {
        boolean bl2;
        Object object2 = StringUtil.newStringBuilder();
        String string2 = "SELECT DISTINCT * FROM TemplateFileRelation WHERE temp_id IN (";
        ((StringBuilder)object2).append(string2);
        int n10 = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object2, n10);
        Object object3 = ")";
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        object2 = RoomSQLiteQuery.acquire((String)object2, n10 += 0);
        object = object.iterator();
        n10 = 1;
        while (bl2 = object.hasNext()) {
            object3 = (Long)object.next();
            if (object3 == null) {
                ((RoomSQLiteQuery)object2).bindNull(n10);
            } else {
                long l10 = (Long)object3;
                ((RoomSQLiteQuery)object2).bindLong(n10, l10);
            }
            ++n10;
        }
        object = new G_TemplateFileRelationDao_Impl$15(this, (RoomSQLiteQuery)object2);
        return RxRoom.createSingle((Callable)object);
    }

    public long replace(TemplateFileRelation object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTemplateFileRelation;
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
            object = this.__insertionAdapterOfTemplateFileRelation;
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
        G_TemplateFileRelationDao_Impl$7 g_TemplateFileRelationDao_Impl$7 = new G_TemplateFileRelationDao_Impl$7(this, list);
        return i0.o0(g_TemplateFileRelationDao_Impl$7);
    }

    public void update(TemplateFileRelation object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfTemplateFileRelation;
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

