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
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.data.database.EditorResourceTypeConverters;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$1;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$10;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$11;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$12;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$13;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$14;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$15;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$16;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$17;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$18;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$19;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$20;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$21;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$22;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$23;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$24;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$25;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$26;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$6;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$7;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$8;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl$9;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileExt;
import e.a.i0;
import e.a.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public final class G_TemplateFileDao_Impl
implements G_TemplateFileDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfFileData;
    private final EntityInsertionAdapter __insertionAdapterOfFileData;
    private final EntityInsertionAdapter __insertionAdapterOfFileData_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllFile;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfFileData;

    public G_TemplateFileDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new G_TemplateFileDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfFileData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfFileData_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfFileData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfFileData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteAllFile = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(G_TemplateFileDao_Impl g_TemplateFileDao_Impl) {
        return g_TemplateFileDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(G_TemplateFileDao_Impl g_TemplateFileDao_Impl) {
        return g_TemplateFileDao_Impl.__insertionAdapterOfFileData;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(G_TemplateFileDao_Impl g_TemplateFileDao_Impl) {
        return g_TemplateFileDao_Impl.__insertionAdapterOfFileData_1;
    }

    public static /* synthetic */ SharedSQLiteStatement access$300(G_TemplateFileDao_Impl g_TemplateFileDao_Impl) {
        return g_TemplateFileDao_Impl.__preparedStmtOfDeleteAllFile;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(FileData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfFileData;
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
            object2 = this.__deletionAdapterOfFileData;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public i0 deleteAllFile() {
        G_TemplateFileDao_Impl$8 g_TemplateFileDao_Impl$8 = new G_TemplateFileDao_Impl$8(this);
        return i0.o0(g_TemplateFileDao_Impl$8);
    }

    public int deleteFile(List object) {
        boolean bl2;
        this.__db.assertNotSuspendingTransaction();
        Object object2 = StringUtil.newStringBuilder();
        ((StringBuilder)object2).append("DELETE FROM FileData WHERE path IN (");
        int n10 = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object2, n10);
        ((StringBuilder)object2).append(")");
        object2 = ((StringBuilder)object2).toString();
        RoomDatabase roomDatabase = this.__db;
        object2 = roomDatabase.compileStatement((String)object2);
        object = object.iterator();
        n10 = 1;
        while (bl2 = object.hasNext()) {
            String string2 = (String)object.next();
            if (string2 == null) {
                object2.bindNull(n10);
            } else {
                object2.bindString(n10, string2);
            }
            ++n10;
        }
        object = this.__db;
        ((RoomDatabase)object).beginTransaction();
        try {
            int n11 = object2.executeUpdateDelete();
            object2 = this.__db;
            ((RoomDatabase)object2).setTransactionSuccessful();
            return n11;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getAllFilePath() {
        Object var1_1 = null;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT path FROM FileData", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
        try {
            int n10 = cursor.getCount();
            ArrayList<String> arrayList = new ArrayList<String>(n10);
            while ((n10 = (int)(cursor.moveToNext() ? 1 : 0)) != 0) {
                String string2;
                n10 = (int)(cursor.isNull(0) ? 1 : 0);
                if (n10 != 0) {
                    n10 = 0;
                    string2 = null;
                } else {
                    string2 = cursor.getString(0);
                }
                arrayList.add(string2);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public LiveData getAllFilePath_LiveData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT path FROM FileData", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"FileData"};
        G_TemplateFileDao_Impl$10 g_TemplateFileDao_Impl$10 = new G_TemplateFileDao_Impl$10(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, g_TemplateFileDao_Impl$10);
    }

    public z getAllFilePath_Observable() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT path FROM FileData", 0);
        RoomDatabase roomDatabase = this.__db;
        String[] stringArray = new String[]{"FileData"};
        G_TemplateFileDao_Impl$11 g_TemplateFileDao_Impl$11 = new G_TemplateFileDao_Impl$11(this, roomSQLiteQuery);
        return RxRoom.createObservable(roomDatabase, false, stringArray, g_TemplateFileDao_Impl$11);
    }

    public i0 getAllFilePath_Single() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT path FROM FileData", 0);
        G_TemplateFileDao_Impl$9 g_TemplateFileDao_Impl$9 = new G_TemplateFileDao_Impl$9(this, roomSQLiteQuery);
        return RxRoom.createSingle(g_TemplateFileDao_Impl$9);
    }

    public FileData getFileData(String string2) {
        Cursor cursor;
        Object object;
        RoomSQLiteQuery roomSQLiteQuery;
        block54: {
            FileExt fileExt;
            Object object2;
            int n10;
            block73: {
                int n11;
                int n12;
                Object object3;
                block72: {
                    int n13;
                    block71: {
                        int n14;
                        block70: {
                            int n15;
                            block69: {
                                block68: {
                                    int n16;
                                    block67: {
                                        block66: {
                                            int n17;
                                            block65: {
                                                block64: {
                                                    block63: {
                                                        int n18;
                                                        block56: {
                                                            block62: {
                                                                int n19;
                                                                block61: {
                                                                    int n20;
                                                                    block60: {
                                                                        block59: {
                                                                            block58: {
                                                                                block57: {
                                                                                    block55: {
                                                                                        String string3;
                                                                                        G_TemplateFileDao_Impl g_TemplateFileDao_Impl = this;
                                                                                        object3 = string2;
                                                                                        int n21 = 1;
                                                                                        roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM FileData WHERE hash = ?", n21);
                                                                                        if (string2 == null) {
                                                                                            roomSQLiteQuery.bindNull(n21);
                                                                                        } else {
                                                                                            roomSQLiteQuery.bindString(n21, string2);
                                                                                        }
                                                                                        g_TemplateFileDao_Impl.__db.assertNotSuspendingTransaction();
                                                                                        object3 = g_TemplateFileDao_Impl.__db;
                                                                                        n21 = 0;
                                                                                        object = null;
                                                                                        cursor = DBUtil.query((RoomDatabase)object3, roomSQLiteQuery, false, null);
                                                                                        object3 = "hash";
                                                                                        try {
                                                                                            n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
                                                                                            string3 = "name";
                                                                                        }
                                                                                        catch (Throwable throwable) {
                                                                                            cursor.close();
                                                                                            roomSQLiteQuery.release();
                                                                                            throw throwable;
                                                                                        }
                                                                                        n17 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
                                                                                        String string4 = "category";
                                                                                        n16 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
                                                                                        String string5 = "mime";
                                                                                        n15 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
                                                                                        String string6 = "size";
                                                                                        n14 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
                                                                                        String string7 = "url";
                                                                                        n13 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
                                                                                        String string8 = "path";
                                                                                        n11 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
                                                                                        String string9 = "download_timestamp";
                                                                                        n10 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
                                                                                        object2 = "ext_lic_url";
                                                                                        n20 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
                                                                                        String string10 = "ext_lic_name";
                                                                                        n18 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
                                                                                        String string11 = "ext_lic_path";
                                                                                        n19 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
                                                                                        boolean bl2 = cursor.moveToFirst();
                                                                                        if (!bl2) break block54;
                                                                                        bl2 = cursor.isNull(n20);
                                                                                        if (!bl2) break block55;
                                                                                        bl2 = cursor.isNull(n18);
                                                                                        if (!bl2) break block55;
                                                                                        bl2 = cursor.isNull(n19);
                                                                                        if (!bl2) break block55;
                                                                                        bl2 = false;
                                                                                        fileExt = null;
                                                                                        break block56;
                                                                                    }
                                                                                    fileExt = new FileExt();
                                                                                    boolean bl3 = cursor.isNull(n20);
                                                                                    if (!bl3) break block57;
                                                                                    n20 = 0;
                                                                                    object2 = null;
                                                                                    break block58;
                                                                                }
                                                                                object2 = cursor.getString(n20);
                                                                            }
                                                                            fileExt.setLicenseUrl((String)object2);
                                                                            n20 = (int)(cursor.isNull(n18) ? 1 : 0);
                                                                            if (n20 == 0) break block59;
                                                                            n20 = 0;
                                                                            object2 = null;
                                                                            break block60;
                                                                        }
                                                                        object2 = cursor.getString(n18);
                                                                    }
                                                                    fileExt.setLicenseName((String)object2);
                                                                    n20 = (int)(cursor.isNull(n19) ? 1 : 0);
                                                                    if (n20 == 0) break block61;
                                                                    n20 = 0;
                                                                    object2 = null;
                                                                    break block62;
                                                                }
                                                                object2 = cursor.getString(n19);
                                                            }
                                                            fileExt.setLicensePath((String)object2);
                                                        }
                                                        object2 = new FileData();
                                                        n18 = (int)(cursor.isNull(n12) ? 1 : 0);
                                                        if (n18 == 0) break block63;
                                                        n12 = 0;
                                                        object3 = null;
                                                        break block64;
                                                    }
                                                    object3 = cursor.getString(n12);
                                                }
                                                ((FileData)object2).setHash((String)object3);
                                                n12 = (int)(cursor.isNull(n17) ? 1 : 0);
                                                if (n12 == 0) break block65;
                                                n12 = 0;
                                                object3 = null;
                                                break block66;
                                            }
                                            object3 = cursor.getString(n17);
                                        }
                                        ((FileData)object2).setName((String)object3);
                                        n12 = (int)(cursor.isNull(n16) ? 1 : 0);
                                        if (n12 == 0) break block67;
                                        n12 = 0;
                                        object3 = null;
                                        break block68;
                                    }
                                    object3 = cursor.getString(n16);
                                }
                                object3 = EditorResourceTypeConverters.stringToType((String)object3);
                                ((FileData)object2).setCategory((EditConfig$ResourceType)object3);
                                n12 = (int)(cursor.isNull(n15) ? 1 : 0);
                                if (n12 == 0) break block69;
                                n12 = 0;
                                object3 = null;
                                break block70;
                            }
                            object3 = cursor.getString(n15);
                        }
                        ((FileData)object2).setType((String)object3);
                        n12 = cursor.getInt(n14);
                        ((FileData)object2).setSize(n12);
                        n12 = (int)(cursor.isNull(n13) ? 1 : 0);
                        if (n12 == 0) break block71;
                        n12 = 0;
                        object3 = null;
                        break block72;
                    }
                    object3 = cursor.getString(n13);
                }
                ((FileData)object2).setUrl((String)object3);
                n12 = (int)(cursor.isNull(n11) ? 1 : 0);
                if (n12 != 0) break block73;
                object = cursor.getString(n11);
            }
            ((FileData)object2).setPath((String)object);
            long l10 = cursor.getLong(n10);
            ((FileData)object2).setDownloadTimestamp(l10);
            ((FileData)object2).setExt(fileExt);
            object = object2;
        }
        cursor.close();
        roomSQLiteQuery.release();
        return object;
    }

    public int getFileDataCount(String object) {
        int n10;
        RoomSQLiteQuery roomSQLiteQuery;
        block6: {
            int n11 = 1;
            roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM FileData WHERE hash = ?", n11);
            if (object == null) {
                roomSQLiteQuery.bindNull(n11);
            } else {
                roomSQLiteQuery.bindString(n11, (String)object);
            }
            this.__db.assertNotSuspendingTransaction();
            object = this.__db;
            n11 = 0;
            Object var4_4 = null;
            n10 = 0;
            object = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
            n11 = (int)(object.moveToFirst() ? 1 : 0);
            if (n11 == 0) break block6;
            n10 = object.getInt(0);
        }
        return n10;
        finally {
            object.close();
            roomSQLiteQuery.release();
        }
    }

    public LiveData getFileDataCount_LiveData(String object) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM FileData WHERE hash = ?", n10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        object = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"FileData"};
        G_TemplateFileDao_Impl$13 g_TemplateFileDao_Impl$13 = new G_TemplateFileDao_Impl$13(this, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, g_TemplateFileDao_Impl$13);
    }

    public z getFileDataCount_Observable(String object) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM FileData WHERE hash = ?", n10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        object = this.__db;
        String[] stringArray = new String[]{"FileData"};
        G_TemplateFileDao_Impl$14 g_TemplateFileDao_Impl$14 = new G_TemplateFileDao_Impl$14(this, roomSQLiteQuery);
        return RxRoom.createObservable((RoomDatabase)object, false, stringArray, g_TemplateFileDao_Impl$14);
    }

    public i0 getFileDataCount_Single(String object) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM FileData WHERE hash = ?", n10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        object = new G_TemplateFileDao_Impl$12(this, roomSQLiteQuery);
        return RxRoom.createSingle((Callable)object);
    }

    public LiveData getFileData_LiveData(String object) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM FileData WHERE hash = ?", n10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        object = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"FileData"};
        G_TemplateFileDao_Impl$22 g_TemplateFileDao_Impl$22 = new G_TemplateFileDao_Impl$22(this, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, g_TemplateFileDao_Impl$22);
    }

    public z getFileData_Observable(String object) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM FileData WHERE hash = ?", n10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        object = this.__db;
        String[] stringArray = new String[]{"FileData"};
        G_TemplateFileDao_Impl$23 g_TemplateFileDao_Impl$23 = new G_TemplateFileDao_Impl$23(this, roomSQLiteQuery);
        return RxRoom.createObservable((RoomDatabase)object, false, stringArray, g_TemplateFileDao_Impl$23);
    }

    public i0 getFileData_Single(String object) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM FileData WHERE hash = ?", n10);
        if (object == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            roomSQLiteQuery.bindString(n10, (String)object);
        }
        object = new G_TemplateFileDao_Impl$21(this, roomSQLiteQuery);
        return RxRoom.createSingle((Callable)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getFilePathsFromTemplateOnlyUse(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT FileData.path FROM FileData WHERE FileData.hash IN (SELECT file_hash FROM TemplateFileRelation GROUP BY file_hash HAVING COUNT(*) == 1 AND temp_id == ?)", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        this.__db.assertNotSuspendingTransaction();
        RoomDatabase roomDatabase = this.__db;
        Object var6_5 = null;
        n10 = 0;
        roomDatabase = DBUtil.query(roomDatabase, roomSQLiteQuery, false, null);
        try {
            int n11 = roomDatabase.getCount();
            ArrayList<String> arrayList = new ArrayList<String>(n11);
            while ((n11 = (int)(roomDatabase.moveToNext() ? 1 : 0)) != 0) {
                String string2;
                n11 = (int)(roomDatabase.isNull(0) ? 1 : 0);
                if (n11 != 0) {
                    n11 = 0;
                    string2 = null;
                } else {
                    string2 = roomDatabase.getString(0);
                }
                arrayList.add(string2);
            }
            return arrayList;
        }
        finally {
            roomDatabase.close();
            roomSQLiteQuery.release();
        }
    }

    public LiveData getFilePathsFromTemplateOnlyUse_LiveData(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT FileData.path FROM FileData WHERE FileData.hash IN (SELECT file_hash FROM TemplateFileRelation GROUP BY file_hash HAVING COUNT(*) == 1 AND temp_id == ?)", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"FileData", "TemplateFileRelation"};
        G_TemplateFileDao_Impl$25 g_TemplateFileDao_Impl$25 = new G_TemplateFileDao_Impl$25(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, g_TemplateFileDao_Impl$25);
    }

    public z getFilePathsFromTemplateOnlyUse_Observable(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT FileData.path FROM FileData WHERE FileData.hash IN (SELECT file_hash FROM TemplateFileRelation GROUP BY file_hash HAVING COUNT(*) == 1 AND temp_id == ?)", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        RoomDatabase roomDatabase = this.__db;
        String[] stringArray = new String[]{"FileData", "TemplateFileRelation"};
        G_TemplateFileDao_Impl$26 g_TemplateFileDao_Impl$26 = new G_TemplateFileDao_Impl$26(this, roomSQLiteQuery);
        return RxRoom.createObservable(roomDatabase, false, stringArray, g_TemplateFileDao_Impl$26);
    }

    public i0 getFilePathsFromTemplateOnlyUse_Single(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT FileData.path FROM FileData WHERE FileData.hash IN (SELECT file_hash FROM TemplateFileRelation GROUP BY file_hash HAVING COUNT(*) == 1 AND temp_id == ?)", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        G_TemplateFileDao_Impl$24 g_TemplateFileDao_Impl$24 = new G_TemplateFileDao_Impl$24(this, roomSQLiteQuery);
        return RxRoom.createSingle(g_TemplateFileDao_Impl$24);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getFilePathsFromTemplates(List object) {
        Serializable serializable;
        boolean bl2;
        Object object2 = StringUtil.newStringBuilder();
        String string2 = "SELECT FileData.path FROM FileData WHERE FileData.hash IN (SELECT DISTINCT file_hash FROM TemplateFileRelation WHERE temp_id IN (";
        ((StringBuilder)object2).append(string2);
        int n10 = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object2, n10);
        ((StringBuilder)object2).append("))");
        object2 = ((StringBuilder)object2).toString();
        object2 = RoomSQLiteQuery.acquire((String)object2, n10 += 0);
        object = object.iterator();
        n10 = 1;
        while (bl2 = object.hasNext()) {
            serializable = (Long)object.next();
            if (serializable == null) {
                ((RoomSQLiteQuery)object2).bindNull(n10);
            } else {
                long l10 = (Long)serializable;
                ((RoomSQLiteQuery)object2).bindLong(n10, l10);
            }
            ++n10;
        }
        this.__db.assertNotSuspendingTransaction();
        object = this.__db;
        n10 = 0;
        string2 = null;
        object = DBUtil.query((RoomDatabase)object, (SupportSQLiteQuery)object2, false, null);
        try {
            int n11 = object.getCount();
            serializable = new ArrayList(n11);
            while ((n11 = (int)(object.moveToNext() ? 1 : 0)) != 0) {
                String string3;
                n11 = (int)(object.isNull(0) ? 1 : 0);
                if (n11 != 0) {
                    n11 = 0;
                    string3 = null;
                } else {
                    string3 = object.getString(0);
                }
                serializable.add(string3);
            }
            return serializable;
        }
        finally {
            object.close();
            ((RoomSQLiteQuery)object2).release();
        }
    }

    public LiveData getFilePathsFromTemplates_LiveData(List object) {
        Object object2;
        boolean bl2;
        Object object3 = StringUtil.newStringBuilder();
        String[] stringArray = "SELECT FileData.path FROM FileData WHERE FileData.hash IN (SELECT DISTINCT file_hash FROM TemplateFileRelation WHERE temp_id IN (";
        ((StringBuilder)object3).append((String)stringArray);
        int n10 = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object3, n10);
        ((StringBuilder)object3).append("))");
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
        stringArray = new String[]{"FileData", "TemplateFileRelation"};
        object2 = new G_TemplateFileDao_Impl$19(this, (RoomSQLiteQuery)object3);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, (Callable)object2);
    }

    public z getFilePathsFromTemplates_Observable(List object) {
        Object object2;
        boolean bl2;
        Object object3 = StringUtil.newStringBuilder();
        String[] stringArray = "SELECT FileData.path FROM FileData WHERE FileData.hash IN (SELECT DISTINCT file_hash FROM TemplateFileRelation WHERE temp_id IN (";
        ((StringBuilder)object3).append((String)stringArray);
        int n10 = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object3, n10);
        ((StringBuilder)object3).append("))");
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
        stringArray = new String[]{"FileData", "TemplateFileRelation"};
        object2 = new G_TemplateFileDao_Impl$20(this, (RoomSQLiteQuery)object3);
        return RxRoom.createObservable((RoomDatabase)object, false, stringArray, (Callable)object2);
    }

    public i0 getFilePathsFromTemplates_Single(List object) {
        boolean bl2;
        Object object2 = StringUtil.newStringBuilder();
        String string2 = "SELECT FileData.path FROM FileData WHERE FileData.hash IN (SELECT DISTINCT file_hash FROM TemplateFileRelation WHERE temp_id IN (";
        ((StringBuilder)object2).append(string2);
        int n10 = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object2, n10);
        Object object3 = "))";
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
        object = new G_TemplateFileDao_Impl$18(this, (RoomSQLiteQuery)object2);
        return RxRoom.createSingle((Callable)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getUnuseFilePaths() {
        Object var1_1 = null;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT FileData.path FROM FileData WHERE FileData.hash NOT IN (SELECT DISTINCT file_hash FROM TemplateFileRelation)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
        try {
            int n10 = cursor.getCount();
            ArrayList<String> arrayList = new ArrayList<String>(n10);
            while ((n10 = (int)(cursor.moveToNext() ? 1 : 0)) != 0) {
                String string2;
                n10 = (int)(cursor.isNull(0) ? 1 : 0);
                if (n10 != 0) {
                    n10 = 0;
                    string2 = null;
                } else {
                    string2 = cursor.getString(0);
                }
                arrayList.add(string2);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public LiveData getUnuseFilePaths_LiveData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT FileData.path FROM FileData WHERE FileData.hash NOT IN (SELECT DISTINCT file_hash FROM TemplateFileRelation)", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"FileData", "TemplateFileRelation"};
        G_TemplateFileDao_Impl$16 g_TemplateFileDao_Impl$16 = new G_TemplateFileDao_Impl$16(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, g_TemplateFileDao_Impl$16);
    }

    public z getUnuseFilePaths_Observable() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT FileData.path FROM FileData WHERE FileData.hash NOT IN (SELECT DISTINCT file_hash FROM TemplateFileRelation)", 0);
        RoomDatabase roomDatabase = this.__db;
        String[] stringArray = new String[]{"FileData", "TemplateFileRelation"};
        G_TemplateFileDao_Impl$17 g_TemplateFileDao_Impl$17 = new G_TemplateFileDao_Impl$17(this, roomSQLiteQuery);
        return RxRoom.createObservable(roomDatabase, false, stringArray, g_TemplateFileDao_Impl$17);
    }

    public i0 getUnuseFilePaths_Single() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT FileData.path FROM FileData WHERE FileData.hash NOT IN (SELECT DISTINCT file_hash FROM TemplateFileRelation)", 0);
        G_TemplateFileDao_Impl$15 g_TemplateFileDao_Impl$15 = new G_TemplateFileDao_Impl$15(this, roomSQLiteQuery);
        return RxRoom.createSingle(g_TemplateFileDao_Impl$15);
    }

    public long insert(FileData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfFileData_1;
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
            object = this.__insertionAdapterOfFileData_1;
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
        G_TemplateFileDao_Impl$7 g_TemplateFileDao_Impl$7 = new G_TemplateFileDao_Impl$7(this, list);
        return i0.o0(g_TemplateFileDao_Impl$7);
    }

    public long replace(FileData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfFileData;
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
            object = this.__insertionAdapterOfFileData;
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
        G_TemplateFileDao_Impl$6 g_TemplateFileDao_Impl$6 = new G_TemplateFileDao_Impl$6(this, list);
        return i0.o0(g_TemplateFileDao_Impl$6);
    }

    public void update(FileData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfFileData;
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

