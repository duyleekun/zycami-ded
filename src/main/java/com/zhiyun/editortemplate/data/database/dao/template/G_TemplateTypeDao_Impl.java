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
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$1;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$10;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$11;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$12;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$13;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$14;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$15;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$16;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$17;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$18;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$19;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$20;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$21;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$22;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$23;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$24;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$25;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$26;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$27;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$28;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$6;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$7;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$8;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl$9;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateType;
import e.a.i0;
import e.a.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public final class G_TemplateTypeDao_Impl
implements G_TemplateTypeDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTemplateType;
    private final EntityInsertionAdapter __insertionAdapterOfTemplateType;
    private final EntityInsertionAdapter __insertionAdapterOfTemplateType_1;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfTemplateType;

    public G_TemplateTypeDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new G_TemplateTypeDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfTemplateType = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfTemplateType_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfTemplateType = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfTemplateType = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDelete = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase access$000(G_TemplateTypeDao_Impl g_TemplateTypeDao_Impl) {
        return g_TemplateTypeDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(G_TemplateTypeDao_Impl g_TemplateTypeDao_Impl) {
        return g_TemplateTypeDao_Impl.__insertionAdapterOfTemplateType;
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(G_TemplateTypeDao_Impl g_TemplateTypeDao_Impl) {
        return g_TemplateTypeDao_Impl.__insertionAdapterOfTemplateType_1;
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(long l10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDelete.acquire();
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
            this.__preparedStmtOfDelete.release(supportSQLiteStatement);
        }
    }

    public void delete(TemplateType object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfTemplateType;
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
            object2 = this.__deletionAdapterOfTemplateType;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
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
    public List getAllTemplateType(List list) {
        Object object;
        int n10;
        G_TemplateTypeDao_Impl g_TemplateTypeDao_Impl = this;
        Object object2 = StringUtil.newStringBuilder();
        ((StringBuilder)object2).append("SELECT * FROM TemplateType WHERE TemplateType.id IN (");
        int n11 = list.size();
        StringUtil.appendPlaceholders((StringBuilder)object2, n11);
        ((StringBuilder)object2).append(")");
        object2 = ((StringBuilder)object2).toString();
        Cursor cursor = null;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)object2, n11 += 0);
        object2 = list.iterator();
        int n12 = 1;
        while ((n10 = object2.hasNext()) != 0) {
            object = (Long)object2.next();
            if (object == null) {
                roomSQLiteQuery.bindNull(n12);
            } else {
                long l10 = (Long)object;
                roomSQLiteQuery.bindLong(n12, l10);
            }
            ++n12;
        }
        g_TemplateTypeDao_Impl.__db.assertNotSuspendingTransaction();
        object2 = g_TemplateTypeDao_Impl.__db;
        n12 = 0;
        cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "id";
        try {
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            object = "label";
            n10 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            String string2 = "label_tw";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            String string3 = "label_en";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "resource_type";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "template_proto_type";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            int n18 = cursor.getCount();
            ArrayList<Object> arrayList = new ArrayList<Object>(n18);
            while ((n18 = (int)(cursor.moveToNext() ? 1 : 0)) != 0) {
                String string6;
                String string7;
                Object object3;
                String string8;
                long l11 = cursor.getLong(n13);
                n18 = (int)(cursor.isNull(n10) ? 1 : 0);
                if (n18 != 0) {
                    string8 = null;
                } else {
                    object3 = cursor.getString(n10);
                    string8 = object3;
                }
                n18 = (int)(cursor.isNull(n14) ? 1 : 0);
                if (n18 != 0) {
                    string7 = null;
                } else {
                    object3 = cursor.getString(n14);
                    string7 = object3;
                }
                n18 = (int)(cursor.isNull(n15) ? 1 : 0);
                if (n18 != 0) {
                    string6 = null;
                } else {
                    object3 = cursor.getString(n15);
                    string6 = object3;
                }
                int n19 = cursor.getInt(n16);
                int n20 = cursor.getInt(n17);
                object3 = TemplateType.create(l11, string8, string7, string6, n19, n20);
                arrayList.add(object3);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public LiveData getAllTemplateType_LiveData(List object) {
        Object object2;
        boolean bl2;
        Object object3 = StringUtil.newStringBuilder();
        String[] stringArray = "SELECT * FROM TemplateType WHERE TemplateType.id IN (";
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
        stringArray = new String[]{"TemplateType"};
        object2 = new G_TemplateTypeDao_Impl$18(this, (RoomSQLiteQuery)object3);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, (Callable)object2);
    }

    public z getAllTemplateType_Observable(List object) {
        Object object2;
        boolean bl2;
        Object object3 = StringUtil.newStringBuilder();
        String[] stringArray = "SELECT * FROM TemplateType WHERE TemplateType.id IN (";
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
        stringArray = new String[]{"TemplateType"};
        object2 = new G_TemplateTypeDao_Impl$19(this, (RoomSQLiteQuery)object3);
        return RxRoom.createObservable((RoomDatabase)object, false, stringArray, (Callable)object2);
    }

    public i0 getAllTemplateType_Single(List object) {
        boolean bl2;
        Object object2 = StringUtil.newStringBuilder();
        String string2 = "SELECT * FROM TemplateType WHERE TemplateType.id IN (";
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
        object = new G_TemplateTypeDao_Impl$17(this, (RoomSQLiteQuery)object2);
        return RxRoom.createSingle((Callable)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public TemplateType getTemplateType(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateType WHERE TemplateType.id == ?", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        this.__db.assertNotSuspendingTransaction();
        Object object = this.__db;
        n10 = 0;
        Object object2 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        object = "id";
        try {
            int n11 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            String string2 = "label";
            int n12 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            String string3 = "label_tw";
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "label_en";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "resource_type";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "template_proto_type";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            boolean bl2 = cursor.moveToFirst();
            if (!bl2) return object2;
            long l11 = cursor.getLong(n11);
            n11 = (int)(cursor.isNull(n12) ? 1 : 0);
            Object object3 = n11 != 0 ? null : (object = cursor.getString(n12));
            n11 = (int)(cursor.isNull(n13) ? 1 : 0);
            Object object4 = n11 != 0 ? null : (object = cursor.getString(n13));
            n11 = (int)(cursor.isNull(n14) ? 1 : 0);
            if (n11 == 0) {
                object2 = cursor.getString(n14);
            }
            int n17 = cursor.getInt(n15);
            int n18 = cursor.getInt(n16);
            object2 = TemplateType.create(l11, (String)object3, (String)object4, (String)object2, n17, n18);
            return object2;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getTemplateType(Integer n10, Integer n11) {
        long l10;
        int n12;
        G_TemplateTypeDao_Impl g_TemplateTypeDao_Impl = this;
        Object object = "SELECT * FROM TemplateType WHERE (? IS NULL OR TemplateType.resource_type == ?) AND (? IS NULL OR TemplateType.template_proto_type == ?) ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC";
        int n13 = 4;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)object, n13);
        int n14 = 1;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n12 = n10;
            l10 = n12;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 2;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n12 = n10;
            l10 = n12;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 3;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n12 = n11;
            l10 = n12;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n14 = n11;
            l10 = n14;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        g_TemplateTypeDao_Impl.__db.assertNotSuspendingTransaction();
        object = g_TemplateTypeDao_Impl.__db;
        n13 = 0;
        n12 = 0;
        Cursor cursor = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        object = "id";
        try {
            n14 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            String string2 = "label";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            String string3 = "label_tw";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "label_en";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "resource_type";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "template_proto_type";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            int n20 = cursor.getCount();
            ArrayList<Object> arrayList = new ArrayList<Object>(n20);
            while ((n20 = (int)(cursor.moveToNext() ? 1 : 0)) != 0) {
                String string7;
                String string8;
                Object object2;
                String string9;
                long l11 = cursor.getLong(n14);
                n20 = (int)(cursor.isNull(n15) ? 1 : 0);
                if (n20 != 0) {
                    string9 = null;
                } else {
                    object2 = cursor.getString(n15);
                    string9 = object2;
                }
                n20 = (int)(cursor.isNull(n16) ? 1 : 0);
                if (n20 != 0) {
                    string8 = null;
                } else {
                    object2 = cursor.getString(n16);
                    string8 = object2;
                }
                n20 = (int)(cursor.isNull(n17) ? 1 : 0);
                if (n20 != 0) {
                    string7 = null;
                } else {
                    object2 = cursor.getString(n17);
                    string7 = object2;
                }
                int n21 = cursor.getInt(n18);
                int n22 = cursor.getInt(n19);
                object2 = TemplateType.create(l11, string9, string8, string7, n21, n22);
                arrayList.add(object2);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getTemplateTypeFromTemplateData(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2) {
        long l10;
        Object object;
        int n13;
        long l11;
        int n14;
        G_TemplateTypeDao_Impl g_TemplateTypeDao_Impl = this;
        Object object2 = string2;
        int n15 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT DISTINCT TemplateType.* FROM TemplateType JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC", n15);
        int n16 = 1;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = n10;
            l11 = n14;
            roomSQLiteQuery.bindLong(n16, l11);
        }
        n16 = 2;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = n10;
            l11 = n14;
            roomSQLiteQuery.bindLong(n16, l11);
        }
        n16 = 3;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = n11;
            l11 = n14;
            roomSQLiteQuery.bindLong(n16, l11);
        }
        n16 = 4;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = n11;
            l11 = n14;
            roomSQLiteQuery.bindLong(n16, l11);
        }
        n16 = 5;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = n12;
            l11 = n14;
            roomSQLiteQuery.bindLong(n16, l11);
        }
        n16 = 6;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = n12;
            l11 = n14;
            roomSQLiteQuery.bindLong(n16, l11);
        }
        n16 = 7;
        n14 = 0;
        if (bl2 == null) {
            n13 = 0;
            object = null;
        } else {
            n13 = bl2.booleanValue();
            object = n13;
        }
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n13 = (Integer)object;
            l10 = n13;
            roomSQLiteQuery.bindLong(n16, l10);
        }
        n16 = 8;
        if (bl2 == null) {
            n13 = 0;
            object = null;
        } else {
            n13 = (int)(bl2.booleanValue() ? 1 : 0);
            object = n13;
        }
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n13 = (Integer)object;
            l10 = n13;
            roomSQLiteQuery.bindLong(n16, l10);
        }
        n16 = 9;
        if (object2 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            roomSQLiteQuery.bindString(n16, (String)object2);
        }
        if (object2 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            roomSQLiteQuery.bindString(n15, (String)object2);
        }
        g_TemplateTypeDao_Impl.__db.assertNotSuspendingTransaction();
        object2 = g_TemplateTypeDao_Impl.__db;
        n15 = 0;
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "id";
        try {
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string3 = "label";
            n16 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            object = "label_tw";
            n13 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            String string4 = "label_en";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "resource_type";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "template_proto_type";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            int n21 = cursor.getCount();
            ArrayList<Object> arrayList = new ArrayList<Object>(n21);
            while ((n21 = (int)(cursor.moveToNext() ? 1 : 0)) != 0) {
                String string7;
                String string8;
                Object object3;
                String string9;
                long l12 = cursor.getLong(n17);
                n21 = (int)(cursor.isNull(n16) ? 1 : 0);
                if (n21 != 0) {
                    string9 = null;
                } else {
                    object3 = cursor.getString(n16);
                    string9 = object3;
                }
                n21 = (int)(cursor.isNull(n13) ? 1 : 0);
                if (n21 != 0) {
                    string8 = null;
                } else {
                    object3 = cursor.getString(n13);
                    string8 = object3;
                }
                n21 = (int)(cursor.isNull(n18) ? 1 : 0);
                if (n21 != 0) {
                    string7 = null;
                } else {
                    object3 = cursor.getString(n18);
                    string7 = object3;
                }
                int n22 = cursor.getInt(n19);
                int n23 = cursor.getInt(n20);
                object3 = TemplateType.create(l12, string9, string8, string7, n22, n23);
                arrayList.add(object3);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getTemplateTypeFromTemplateDataNonNullParam(int[] nArray, int[] nArray2, int[] nArray3, Boolean bl2, String string2) {
        int n10;
        int n11;
        long l10;
        int n12;
        int n13;
        int n14;
        G_TemplateTypeDao_Impl g_TemplateTypeDao_Impl = this;
        int[] nArray4 = nArray;
        int[] nArray5 = nArray2;
        Object object = nArray3;
        String string3 = string2;
        Object object2 = StringUtil.newStringBuilder();
        String string4 = "SELECT DISTINCT TemplateType.* FROM TemplateType JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE TemplateData.temp_type IN (";
        ((StringBuilder)object2).append(string4);
        int n15 = nArray.length;
        StringUtil.appendPlaceholders((StringBuilder)object2, n15);
        String string5 = ") AND TemplateData.template_use_type IN (";
        ((StringBuilder)object2).append(string5);
        int n16 = nArray2.length;
        StringUtil.appendPlaceholders((StringBuilder)object2, n16);
        String string6 = ") AND TemplateData.template_proto_type IN (";
        ((StringBuilder)object2).append(string6);
        int n17 = nArray3.length;
        StringUtil.appendPlaceholders((StringBuilder)object2, n17);
        ((StringBuilder)object2).append(") AND  (");
        String string7 = "?";
        ((StringBuilder)object2).append(string7);
        ((StringBuilder)object2).append(" IS NULL OR TemplateData.download_finished == ");
        ((StringBuilder)object2).append(string7);
        ((StringBuilder)object2).append(")  AND  (");
        ((StringBuilder)object2).append(string7);
        ArrayList<Object> arrayList = " IS NULL OR TemplateData.video_ratio == ";
        ((StringBuilder)object2).append((String)((Object)arrayList));
        ((StringBuilder)object2).append(string7);
        string7 = ")  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC";
        ((StringBuilder)object2).append(string7);
        object2 = ((StringBuilder)object2).toString();
        int n18 = n15 + 4 + n16 + n17;
        object2 = RoomSQLiteQuery.acquire((String)object2, n18);
        int n19 = nArray.length;
        int n20 = n14 = 1;
        for (n13 = 0; n13 < n19; n20 += n14, ++n13) {
            n12 = nArray4[n13];
            l10 = n12;
            ((RoomSQLiteQuery)object2).bindLong(n20, l10);
        }
        int n21 = n15 + 1;
        n19 = nArray5.length;
        n13 = n21;
        Object object3 = null;
        for (n11 = 0; n11 < n19; n13 += n14, ++n11) {
            n20 = nArray5[n11];
            long l11 = n20;
            ((RoomSQLiteQuery)object2).bindLong(n13, l11);
        }
        int n22 = ((int[])object).length;
        n11 = n21 += n16;
        arrayList = null;
        for (n19 = 0; n19 < n22; n11 += n14, ++n19) {
            n13 = object[n19];
            long l12 = n13;
            ((RoomSQLiteQuery)object2).bindLong(n11, l12);
        }
        n21 += n17;
        n22 = 0;
        nArray5 = null;
        if (bl2 == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = bl2.booleanValue();
            object = n10;
        }
        if (object == null) {
            ((RoomSQLiteQuery)object2).bindNull(n21);
        } else {
            n10 = (Integer)object;
            l10 = n10;
            ((RoomSQLiteQuery)object2).bindLong(n21, l10);
        }
        n21 = n15 + 2 + n16 + n17;
        if (bl2 == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = (int)(bl2.booleanValue() ? 1 : 0);
            object = n10;
        }
        if (object == null) {
            ((RoomSQLiteQuery)object2).bindNull(n21);
        } else {
            n10 = (Integer)object;
            l10 = n10;
            ((RoomSQLiteQuery)object2).bindLong(n21, l10);
        }
        n15 = n15 + 3 + n16 + n17;
        if (string3 == null) {
            ((RoomSQLiteQuery)object2).bindNull(n15);
        } else {
            ((RoomSQLiteQuery)object2).bindString(n15, string3);
        }
        if (string3 == null) {
            ((RoomSQLiteQuery)object2).bindNull(n18);
        } else {
            ((RoomSQLiteQuery)object2).bindString(n18, string3);
        }
        g_TemplateTypeDao_Impl.__db.assertNotSuspendingTransaction();
        RoomDatabase roomDatabase = g_TemplateTypeDao_Impl.__db;
        n10 = 0;
        object = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object2, false, null);
        String string8 = "id";
        try {
            n21 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string8);
            string3 = "label";
            int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string3);
            string4 = "label_tw";
            n15 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string4);
            string5 = "label_en";
            n16 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string5);
            string6 = "resource_type";
            n17 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string6);
            string7 = "template_proto_type";
            n18 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string7);
            n11 = object.getCount();
            arrayList = new ArrayList<Object>(n11);
            while ((n11 = (int)(object.moveToNext() ? 1 : 0)) != 0) {
                String string9;
                String string10;
                String string11;
                long l13 = object.getLong(n21);
                n11 = (int)(object.isNull(n23) ? 1 : 0);
                if (n11 != 0) {
                    n20 = 0;
                    string11 = null;
                } else {
                    object3 = object.getString(n23);
                    string11 = object3;
                }
                n11 = (int)(object.isNull(n15) ? 1 : 0);
                if (n11 != 0) {
                    n12 = 0;
                    string10 = null;
                } else {
                    object3 = object.getString(n15);
                    string10 = object3;
                }
                n11 = (int)(object.isNull(n16) ? 1 : 0);
                if (n11 != 0) {
                    string9 = null;
                } else {
                    object3 = object.getString(n16);
                    string9 = object3;
                }
                int n24 = object.getInt(n17);
                int n25 = object.getInt(n18);
                object3 = TemplateType.create(l13, string11, string10, string9, n24, n25);
                arrayList.add(object3);
            }
            return arrayList;
        }
        finally {
            object.close();
            ((RoomSQLiteQuery)object2).release();
        }
    }

    public LiveData getTemplateTypeFromTemplateDataNonNullParam_LiveData(int[] nArray, int[] nArray2, int[] nArray3, Boolean bl2, String string2) {
        int n10;
        int n11;
        long l10;
        int n12;
        int n13;
        G_TemplateTypeDao_Impl g_TemplateTypeDao_Impl = this;
        Object object = nArray;
        Object object2 = nArray2;
        Object object3 = nArray3;
        String string3 = string2;
        Object object4 = StringUtil.newStringBuilder();
        String string4 = "SELECT DISTINCT TemplateType.* FROM TemplateType JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE TemplateData.temp_type IN (";
        ((StringBuilder)object4).append(string4);
        int n14 = nArray.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n14);
        String string5 = ") AND TemplateData.template_use_type IN (";
        ((StringBuilder)object4).append(string5);
        int n15 = nArray2.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n15);
        String string6 = ") AND TemplateData.template_proto_type IN (";
        ((StringBuilder)object4).append(string6);
        int n16 = nArray3.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n16);
        ((StringBuilder)object4).append(") AND  (");
        String string7 = "?";
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(" IS NULL OR TemplateData.download_finished == ");
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(")  AND  (");
        ((StringBuilder)object4).append(string7);
        String string8 = " IS NULL OR TemplateData.video_ratio == ";
        ((StringBuilder)object4).append(string8);
        ((StringBuilder)object4).append(string7);
        string7 = ")  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC";
        ((StringBuilder)object4).append(string7);
        object4 = ((StringBuilder)object4).toString();
        int n17 = n14 + 4 + n15 + n16;
        object4 = RoomSQLiteQuery.acquire((String)object4, n17);
        int n18 = nArray.length;
        int n19 = n13 = 1;
        for (n12 = 0; n12 < n18; ++n12) {
            int n20 = object[n12];
            l10 = n20;
            ((RoomSQLiteQuery)object4).bindLong(n19, l10);
            n19 += n13;
        }
        int n21 = n14 + 1;
        n18 = ((int[])object2).length;
        n12 = n21;
        for (n11 = 0; n11 < n18; ++n11) {
            n19 = object2[n11];
            long l11 = n19;
            ((RoomSQLiteQuery)object4).bindLong(n12, l11);
            n12 += n13;
        }
        int n22 = ((int[])object3).length;
        n11 = n21 += n15;
        string8 = null;
        for (n18 = 0; n18 < n22; ++n18) {
            n12 = object3[n18];
            long l12 = n12;
            ((RoomSQLiteQuery)object4).bindLong(n11, l12);
            n11 += n13;
        }
        n21 += n16;
        n22 = 0;
        object2 = null;
        if (bl2 == null) {
            n10 = 0;
            object3 = null;
        } else {
            n10 = bl2.booleanValue();
            object3 = n10;
        }
        if (object3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n10 = (Integer)object3;
            l10 = n10;
            ((RoomSQLiteQuery)object4).bindLong(n21, l10);
        }
        n21 = n14 + 2 + n15 + n16;
        if (bl2 != null) {
            n22 = (int)(bl2.booleanValue() ? 1 : 0);
            object2 = n22;
        }
        if (object2 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n22 = object2.intValue();
            long l13 = n22;
            ((RoomSQLiteQuery)object4).bindLong(n21, l13);
        }
        n14 = n14 + 3 + n15 + n16;
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n14);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n14, string3);
        }
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n17);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n17, string3);
        }
        object = g_TemplateTypeDao_Impl.__db.getInvalidationTracker();
        object2 = new String[]{"TemplateType", "Template", "TemplateData"};
        object3 = new G_TemplateTypeDao_Impl$15(g_TemplateTypeDao_Impl, (RoomSQLiteQuery)object4);
        return ((InvalidationTracker)object).createLiveData((String[])object2, false, (Callable)object3);
    }

    public z getTemplateTypeFromTemplateDataNonNullParam_Observable(int[] nArray, int[] nArray2, int[] nArray3, Boolean bl2, String string2) {
        int n10;
        int n11;
        long l10;
        int n12;
        int n13;
        G_TemplateTypeDao_Impl g_TemplateTypeDao_Impl = this;
        Object object = nArray;
        Object object2 = nArray2;
        Object object3 = nArray3;
        String string3 = string2;
        Object object4 = StringUtil.newStringBuilder();
        String string4 = "SELECT DISTINCT TemplateType.* FROM TemplateType JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE TemplateData.temp_type IN (";
        ((StringBuilder)object4).append(string4);
        int n14 = nArray.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n14);
        String string5 = ") AND TemplateData.template_use_type IN (";
        ((StringBuilder)object4).append(string5);
        int n15 = nArray2.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n15);
        String string6 = ") AND TemplateData.template_proto_type IN (";
        ((StringBuilder)object4).append(string6);
        int n16 = nArray3.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n16);
        ((StringBuilder)object4).append(") AND  (");
        String string7 = "?";
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(" IS NULL OR TemplateData.download_finished == ");
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(")  AND  (");
        ((StringBuilder)object4).append(string7);
        String string8 = " IS NULL OR TemplateData.video_ratio == ";
        ((StringBuilder)object4).append(string8);
        ((StringBuilder)object4).append(string7);
        string7 = ")  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC";
        ((StringBuilder)object4).append(string7);
        object4 = ((StringBuilder)object4).toString();
        int n17 = n14 + 4 + n15 + n16;
        object4 = RoomSQLiteQuery.acquire((String)object4, n17);
        int n18 = nArray.length;
        int n19 = n13 = 1;
        for (n12 = 0; n12 < n18; ++n12) {
            int n20 = object[n12];
            l10 = n20;
            ((RoomSQLiteQuery)object4).bindLong(n19, l10);
            n19 += n13;
        }
        int n21 = n14 + 1;
        n18 = ((int[])object2).length;
        n12 = n21;
        for (n11 = 0; n11 < n18; ++n11) {
            n19 = object2[n11];
            long l11 = n19;
            ((RoomSQLiteQuery)object4).bindLong(n12, l11);
            n12 += n13;
        }
        int n22 = ((int[])object3).length;
        n11 = n21 += n15;
        string8 = null;
        for (n18 = 0; n18 < n22; ++n18) {
            n12 = object3[n18];
            long l12 = n12;
            ((RoomSQLiteQuery)object4).bindLong(n11, l12);
            n11 += n13;
        }
        n21 += n16;
        n22 = 0;
        object2 = null;
        if (bl2 == null) {
            n10 = 0;
            object3 = null;
        } else {
            n10 = bl2.booleanValue();
            object3 = n10;
        }
        if (object3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n10 = (Integer)object3;
            l10 = n10;
            ((RoomSQLiteQuery)object4).bindLong(n21, l10);
        }
        n21 = n14 + 2 + n15 + n16;
        if (bl2 != null) {
            n22 = (int)(bl2.booleanValue() ? 1 : 0);
            object2 = n22;
        }
        if (object2 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n22 = object2.intValue();
            long l13 = n22;
            ((RoomSQLiteQuery)object4).bindLong(n21, l13);
        }
        n14 = n14 + 3 + n15 + n16;
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n14);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n14, string3);
        }
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n17);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n17, string3);
        }
        object = g_TemplateTypeDao_Impl.__db;
        object2 = new String[]{"TemplateType", "Template", "TemplateData"};
        object3 = new G_TemplateTypeDao_Impl$16(g_TemplateTypeDao_Impl, (RoomSQLiteQuery)object4);
        return RxRoom.createObservable((RoomDatabase)object, false, (String[])object2, (Callable)object3);
    }

    public i0 getTemplateTypeFromTemplateDataNonNullParam_Single(int[] nArray, int[] nArray2, int[] nArray3, Boolean bl2, String string2) {
        int n10;
        long l10;
        int n11;
        int n12;
        Object object = nArray;
        Object object2 = nArray2;
        Object object3 = nArray3;
        String string3 = string2;
        Object object4 = StringUtil.newStringBuilder();
        String string4 = "SELECT DISTINCT TemplateType.* FROM TemplateType JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE TemplateData.temp_type IN (";
        ((StringBuilder)object4).append(string4);
        int n13 = nArray.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n13);
        String string5 = ") AND TemplateData.template_use_type IN (";
        ((StringBuilder)object4).append(string5);
        int n14 = nArray2.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n14);
        String string6 = ") AND TemplateData.template_proto_type IN (";
        ((StringBuilder)object4).append(string6);
        int n15 = nArray3.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n15);
        ((StringBuilder)object4).append(") AND  (");
        String string7 = "?";
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(" IS NULL OR TemplateData.download_finished == ");
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(")  AND  (");
        ((StringBuilder)object4).append(string7);
        String string8 = " IS NULL OR TemplateData.video_ratio == ";
        ((StringBuilder)object4).append(string8);
        ((StringBuilder)object4).append(string7);
        string7 = ")  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC";
        ((StringBuilder)object4).append(string7);
        object4 = ((StringBuilder)object4).toString();
        int n16 = n13 + 4 + n14 + n15;
        object4 = RoomSQLiteQuery.acquire((String)object4, n16);
        int n17 = nArray.length;
        int n18 = 0;
        int n19 = 1;
        int n20 = n19;
        for (n12 = 0; n12 < n17; ++n12) {
            n11 = object[n12];
            l10 = n11;
            ((RoomSQLiteQuery)object4).bindLong(n20, l10);
            n20 += n19;
        }
        int n21 = n13 + 1;
        n17 = ((int[])object2).length;
        n20 = n21;
        for (n12 = 0; n12 < n17; ++n12) {
            n11 = object2[n12];
            l10 = n11;
            ((RoomSQLiteQuery)object4).bindLong(n20, l10);
            n20 += n19;
        }
        int n22 = ((int[])object3).length;
        n17 = n21 += n14;
        while (n18 < n22) {
            n12 = object3[n18];
            long l11 = n12;
            ((RoomSQLiteQuery)object4).bindLong(n17, l11);
            n17 += n19;
            ++n18;
        }
        n21 += n15;
        n22 = 0;
        object2 = null;
        if (bl2 == null) {
            n10 = 0;
            object3 = null;
        } else {
            n10 = bl2.booleanValue();
            object3 = n10;
        }
        if (object3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n10 = (Integer)object3;
            long l12 = n10;
            ((RoomSQLiteQuery)object4).bindLong(n21, l12);
        }
        n21 = n13 + 2 + n14 + n15;
        if (bl2 != null) {
            n22 = (int)(bl2.booleanValue() ? 1 : 0);
            object2 = n22;
        }
        if (object2 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n22 = object2.intValue();
            long l13 = n22;
            ((RoomSQLiteQuery)object4).bindLong(n21, l13);
        }
        n13 = n13 + 3 + n14 + n15;
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n13);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n13, string3);
        }
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n16);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n16, string3);
        }
        object = new G_TemplateTypeDao_Impl$14;
        object2 = this;
        object(this, (RoomSQLiteQuery)object4);
        return RxRoom.createSingle((Callable)object);
    }

    public LiveData getTemplateTypeFromTemplateData_LiveData(Integer object, Integer stringArray, Integer n10, Boolean object2, String string2) {
        long l10;
        int n12;
        long l11;
        int n13;
        long l12;
        int n14 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT DISTINCT TemplateType.* FROM TemplateType JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC", n14);
        int n15 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            int n16 = (Integer)object;
            l12 = n16;
            roomSQLiteQuery.bindLong(n15, l12);
        }
        n15 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n13 = (Integer)object;
            l12 = n13;
            roomSQLiteQuery.bindLong(n15, l12);
        }
        n13 = 3;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n15 = stringArray.intValue();
            l11 = n15;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 4;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = stringArray.intValue();
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 5;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 6;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 7;
        n12 = 0;
        stringArray = null;
        if (object2 == null) {
            boolean n11 = false;
            n10 = null;
        } else {
            int n11 = ((Boolean)object2).booleanValue();
            n10 = n11;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            int n16 = n10;
            l11 = n16;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 8;
        if (object2 != null) {
            n12 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
            stringArray = n12;
        }
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = stringArray.intValue();
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            roomSQLiteQuery.bindString(n13, string2);
        }
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        object = this.__db.getInvalidationTracker();
        stringArray = new String[]{"TemplateType", "Template", "TemplateData"};
        object2 = new G_TemplateTypeDao_Impl$24(this, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, (Callable)object2);
    }

    public z getTemplateTypeFromTemplateData_Observable(Integer object, Integer n10, Integer stringArray, Boolean object2, String string2) {
        long l10;
        int n12;
        long l11;
        int n13;
        long l12;
        int n14 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT DISTINCT TemplateType.* FROM TemplateType JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC", n14);
        int n15 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            int n16 = (Integer)object;
            l12 = n16;
            roomSQLiteQuery.bindLong(n15, l12);
        }
        n15 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n13 = (Integer)object;
            l12 = n13;
            roomSQLiteQuery.bindLong(n15, l12);
        }
        n13 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n15 = n10;
            l11 = n15;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 4;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 5;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = (Integer)stringArray;
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 6;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = (Integer)stringArray;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 7;
        n12 = 0;
        n10 = null;
        if (object2 == null) {
            boolean n11 = false;
            stringArray = null;
        } else {
            int n11 = ((Boolean)object2).booleanValue();
            stringArray = n11;
        }
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            int n16 = (Integer)stringArray;
            l11 = n16;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 8;
        if (object2 != null) {
            n12 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
            n10 = n12;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            roomSQLiteQuery.bindString(n13, string2);
        }
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        object = this.__db;
        stringArray = new String[]{"TemplateType", "Template", "TemplateData"};
        object2 = new G_TemplateTypeDao_Impl$25(this, roomSQLiteQuery);
        return RxRoom.createObservable((RoomDatabase)object, false, (String[])stringArray, (Callable)object2);
    }

    public i0 getTemplateTypeFromTemplateData_Single(Integer object, Integer n10, Integer n11, Boolean bl2, String string2) {
        int n12;
        long l10;
        int n13;
        long l11;
        int n14;
        long l12;
        int n15 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT DISTINCT TemplateType.* FROM TemplateType JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC", n15);
        int n16 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            int n17 = (Integer)object;
            l12 = n17;
            roomSQLiteQuery.bindLong(n16, l12);
        }
        n16 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = (Integer)object;
            l12 = n14;
            roomSQLiteQuery.bindLong(n16, l12);
        }
        n14 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n16 = n10;
            l11 = n16;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 4;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n10;
            l11 = n13;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 5;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n11;
            l11 = n13;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 6;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n11;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 7;
        n13 = 0;
        n10 = null;
        if (bl2 == null) {
            n12 = 0;
            n11 = null;
        } else {
            n12 = bl2.booleanValue();
            n11 = n12;
        }
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n12 = n11;
            l11 = n12;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 8;
        if (bl2 != null) {
            n13 = (int)(bl2.booleanValue() ? 1 : 0);
            n10 = n13;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n10;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            roomSQLiteQuery.bindString(n15, string2);
        }
        object = new G_TemplateTypeDao_Impl$23(this, roomSQLiteQuery);
        return RxRoom.createSingle((Callable)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getTemplateTypeIds(Integer object, Integer n10) {
        int n11;
        long l10;
        int n12;
        int n13 = 4;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT DISTINCT TemplateType.id FROM TemplateType WHERE (? IS NULL OR TemplateType.resource_type == ?) AND (? IS NULL OR TemplateType.template_proto_type == ?) ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC", n13);
        int n14 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n12 = (Integer)object;
            l10 = n12;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n11 = (Integer)object;
            l10 = n11;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n11 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n11);
        } else {
            n14 = n10;
            long l11 = n14;
            roomSQLiteQuery.bindLong(n11, l11);
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n11 = n10;
            long l12 = n11;
            roomSQLiteQuery.bindLong(n13, l12);
        }
        this.__db.assertNotSuspendingTransaction();
        object = this.__db;
        n10 = null;
        n13 = 0;
        object = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        try {
            n12 = object.getCount();
            ArrayList<Long> arrayList = new ArrayList<Long>(n12);
            while ((n12 = (int)(object.moveToNext() ? 1 : 0)) != 0) {
                Long l13;
                n12 = (int)(object.isNull(0) ? 1 : 0);
                if (n12 != 0) {
                    n12 = 0;
                    l13 = null;
                } else {
                    l10 = object.getLong(0);
                    l13 = l10;
                }
                arrayList.add(l13);
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
    public List getTemplateTypeIdsFromTemplateData(Integer object, Integer n10, Integer n11, Boolean serializable, String object2) {
        int n12;
        int n13;
        long l10;
        int n14;
        long l11;
        int n15 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT DISTINCT TemplateType.id FROM TemplateType JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC", n15);
        int n16 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            int n17 = (Integer)object;
            l11 = n17;
            roomSQLiteQuery.bindLong(n16, l11);
        }
        n16 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = (Integer)object;
            l11 = n14;
            roomSQLiteQuery.bindLong(n16, l11);
        }
        n14 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n16 = n10;
            l10 = n16;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 4;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n10;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 5;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n11;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 6;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n11;
            long l12 = n13;
            roomSQLiteQuery.bindLong(n14, l12);
        }
        n14 = 7;
        n13 = 0;
        n10 = null;
        if (serializable == null) {
            n12 = 0;
            n11 = null;
        } else {
            n12 = ((Boolean)serializable).booleanValue();
            n11 = n12;
        }
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n12 = n11;
            l10 = n12;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 8;
        if (serializable == null) {
            n12 = 0;
            n11 = null;
        } else {
            n12 = (int)(((Boolean)serializable).booleanValue() ? 1 : 0);
            n11 = n12;
        }
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n12 = n11;
            long l13 = n12;
            roomSQLiteQuery.bindLong(n14, l13);
        }
        n14 = 9;
        if (object2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, (String)object2);
        }
        if (object2 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            roomSQLiteQuery.bindString(n15, (String)object2);
        }
        this.__db.assertNotSuspendingTransaction();
        object = this.__db;
        n12 = 0;
        n11 = null;
        object = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        try {
            int n18 = object.getCount();
            serializable = new ArrayList(n18);
            while ((n18 = (int)(object.moveToNext() ? 1 : 0)) != 0) {
                n18 = (int)(object.isNull(0) ? 1 : 0);
                if (n18 != 0) {
                    n18 = 0;
                    object2 = null;
                } else {
                    long l14 = object.getLong(0);
                    object2 = l14;
                }
                serializable.add(object2);
            }
            return serializable;
        }
        finally {
            object.close();
            roomSQLiteQuery.release();
        }
    }

    public LiveData getTemplateTypeIdsFromTemplateData_LiveData(Integer object, Integer stringArray, Integer n10, Boolean object2, String string2) {
        long l10;
        int n12;
        long l11;
        int n13;
        long l12;
        int n14 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT DISTINCT TemplateType.id FROM TemplateType JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC", n14);
        int n15 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            int n16 = (Integer)object;
            l12 = n16;
            roomSQLiteQuery.bindLong(n15, l12);
        }
        n15 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n13 = (Integer)object;
            l12 = n13;
            roomSQLiteQuery.bindLong(n15, l12);
        }
        n13 = 3;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n15 = stringArray.intValue();
            l11 = n15;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 4;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = stringArray.intValue();
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 5;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 6;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 7;
        n12 = 0;
        stringArray = null;
        if (object2 == null) {
            boolean n11 = false;
            n10 = null;
        } else {
            int n11 = ((Boolean)object2).booleanValue();
            n10 = n11;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            int n16 = n10;
            l11 = n16;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 8;
        if (object2 != null) {
            n12 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
            stringArray = n12;
        }
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = stringArray.intValue();
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            roomSQLiteQuery.bindString(n13, string2);
        }
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        object = this.__db.getInvalidationTracker();
        stringArray = new String[]{"TemplateType", "Template", "TemplateData"};
        object2 = new G_TemplateTypeDao_Impl$9(this, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, (Callable)object2);
    }

    public z getTemplateTypeIdsFromTemplateData_Observable(Integer object, Integer n10, Integer stringArray, Boolean object2, String string2) {
        long l10;
        int n12;
        long l11;
        int n13;
        long l12;
        int n14 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT DISTINCT TemplateType.id FROM TemplateType JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC", n14);
        int n15 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            int n16 = (Integer)object;
            l12 = n16;
            roomSQLiteQuery.bindLong(n15, l12);
        }
        n15 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n13 = (Integer)object;
            l12 = n13;
            roomSQLiteQuery.bindLong(n15, l12);
        }
        n13 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n15 = n10;
            l11 = n15;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 4;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 5;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = (Integer)stringArray;
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 6;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = (Integer)stringArray;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 7;
        n12 = 0;
        n10 = null;
        if (object2 == null) {
            boolean n11 = false;
            stringArray = null;
        } else {
            int n11 = ((Boolean)object2).booleanValue();
            stringArray = n11;
        }
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            int n16 = (Integer)stringArray;
            l11 = n16;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 8;
        if (object2 != null) {
            n12 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
            n10 = n12;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            roomSQLiteQuery.bindString(n13, string2);
        }
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        object = this.__db;
        stringArray = new String[]{"TemplateType", "Template", "TemplateData"};
        object2 = new G_TemplateTypeDao_Impl$10(this, roomSQLiteQuery);
        return RxRoom.createObservable((RoomDatabase)object, false, (String[])stringArray, (Callable)object2);
    }

    public i0 getTemplateTypeIdsFromTemplateData_Single(Integer object, Integer n10, Integer n11, Boolean bl2, String string2) {
        int n12;
        long l10;
        int n13;
        long l11;
        int n14;
        long l12;
        int n15 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT DISTINCT TemplateType.id FROM TemplateType JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC", n15);
        int n16 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            int n17 = (Integer)object;
            l12 = n17;
            roomSQLiteQuery.bindLong(n16, l12);
        }
        n16 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = (Integer)object;
            l12 = n14;
            roomSQLiteQuery.bindLong(n16, l12);
        }
        n14 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n16 = n10;
            l11 = n16;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 4;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n10;
            l11 = n13;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 5;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n11;
            l11 = n13;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 6;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n11;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 7;
        n13 = 0;
        n10 = null;
        if (bl2 == null) {
            n12 = 0;
            n11 = null;
        } else {
            n12 = bl2.booleanValue();
            n11 = n12;
        }
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n12 = n11;
            l11 = n12;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 8;
        if (bl2 != null) {
            n13 = (int)(bl2.booleanValue() ? 1 : 0);
            n10 = n13;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n10;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            roomSQLiteQuery.bindString(n15, string2);
        }
        object = new G_TemplateTypeDao_Impl$8(this, roomSQLiteQuery);
        return RxRoom.createSingle((Callable)object);
    }

    public LiveData getTemplateTypeIds_LiveData(Integer object, Integer stringArray) {
        int n10;
        long l10;
        int n11 = 4;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT DISTINCT TemplateType.id FROM TemplateType WHERE (? IS NULL OR TemplateType.resource_type == ?) AND (? IS NULL OR TemplateType.template_proto_type == ?) ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC", n11);
        int n12 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n12);
        } else {
            int n13 = (Integer)object;
            l10 = n13;
            roomSQLiteQuery.bindLong(n12, l10);
        }
        n12 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n12);
        } else {
            n10 = (Integer)object;
            l10 = n10;
            roomSQLiteQuery.bindLong(n12, l10);
        }
        n10 = 3;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            n12 = stringArray.intValue();
            long l11 = n12;
            roomSQLiteQuery.bindLong(n10, l11);
        }
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n11);
        } else {
            n10 = stringArray.intValue();
            long l12 = n10;
            roomSQLiteQuery.bindLong(n11, l12);
        }
        object = this.__db.getInvalidationTracker();
        stringArray = new String[]{"TemplateType"};
        G_TemplateTypeDao_Impl$27 g_TemplateTypeDao_Impl$27 = new G_TemplateTypeDao_Impl$27(this, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, g_TemplateTypeDao_Impl$27);
    }

    public z getTemplateTypeIds_Observable(Integer object, Integer n10) {
        int n11;
        long l10;
        int n12 = 4;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT DISTINCT TemplateType.id FROM TemplateType WHERE (? IS NULL OR TemplateType.resource_type == ?) AND (? IS NULL OR TemplateType.template_proto_type == ?) ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC", n12);
        int n13 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            int n14 = (Integer)object;
            l10 = n14;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n11 = (Integer)object;
            l10 = n11;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n11 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n11);
        } else {
            n13 = n10;
            long l11 = n13;
            roomSQLiteQuery.bindLong(n11, l11);
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n12);
        } else {
            n11 = n10;
            long l12 = n11;
            roomSQLiteQuery.bindLong(n12, l12);
        }
        object = this.__db;
        String[] stringArray = new String[]{"TemplateType"};
        G_TemplateTypeDao_Impl$28 g_TemplateTypeDao_Impl$28 = new G_TemplateTypeDao_Impl$28(this, roomSQLiteQuery);
        return RxRoom.createObservable((RoomDatabase)object, false, stringArray, g_TemplateTypeDao_Impl$28);
    }

    public i0 getTemplateTypeIds_Single(Integer object, Integer n10) {
        int n11;
        long l10;
        int n12 = 4;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT DISTINCT TemplateType.id FROM TemplateType WHERE (? IS NULL OR TemplateType.resource_type == ?) AND (? IS NULL OR TemplateType.template_proto_type == ?) ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC", n12);
        int n13 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            int n14 = (Integer)object;
            l10 = n14;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n11 = (Integer)object;
            l10 = n11;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n11 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n11);
        } else {
            n13 = n10;
            long l11 = n13;
            roomSQLiteQuery.bindLong(n11, l11);
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n12);
        } else {
            n11 = n10;
            long l12 = n11;
            roomSQLiteQuery.bindLong(n12, l12);
        }
        object = new G_TemplateTypeDao_Impl$26(this, roomSQLiteQuery);
        return RxRoom.createSingle((Callable)object);
    }

    public LiveData getTemplateType_LiveData(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateType WHERE TemplateType.id == ?", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"TemplateType"};
        G_TemplateTypeDao_Impl$21 g_TemplateTypeDao_Impl$21 = new G_TemplateTypeDao_Impl$21(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, g_TemplateTypeDao_Impl$21);
    }

    public LiveData getTemplateType_LiveData(Integer object, Integer stringArray) {
        int n10;
        long l10;
        int n11 = 4;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateType WHERE (? IS NULL OR TemplateType.resource_type == ?) AND (? IS NULL OR TemplateType.template_proto_type == ?) ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC", n11);
        int n12 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n12);
        } else {
            int n13 = (Integer)object;
            l10 = n13;
            roomSQLiteQuery.bindLong(n12, l10);
        }
        n12 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n12);
        } else {
            n10 = (Integer)object;
            l10 = n10;
            roomSQLiteQuery.bindLong(n12, l10);
        }
        n10 = 3;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n10);
        } else {
            n12 = stringArray.intValue();
            long l11 = n12;
            roomSQLiteQuery.bindLong(n10, l11);
        }
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n11);
        } else {
            n10 = stringArray.intValue();
            long l12 = n10;
            roomSQLiteQuery.bindLong(n11, l12);
        }
        object = this.__db.getInvalidationTracker();
        stringArray = new String[]{"TemplateType"};
        G_TemplateTypeDao_Impl$12 g_TemplateTypeDao_Impl$12 = new G_TemplateTypeDao_Impl$12(this, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, g_TemplateTypeDao_Impl$12);
    }

    public z getTemplateType_Observable(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateType WHERE TemplateType.id == ?", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        RoomDatabase roomDatabase = this.__db;
        String[] stringArray = new String[]{"TemplateType"};
        G_TemplateTypeDao_Impl$22 g_TemplateTypeDao_Impl$22 = new G_TemplateTypeDao_Impl$22(this, roomSQLiteQuery);
        return RxRoom.createObservable(roomDatabase, false, stringArray, g_TemplateTypeDao_Impl$22);
    }

    public z getTemplateType_Observable(Integer object, Integer n10) {
        int n11;
        long l10;
        int n12 = 4;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateType WHERE (? IS NULL OR TemplateType.resource_type == ?) AND (? IS NULL OR TemplateType.template_proto_type == ?) ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC", n12);
        int n13 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            int n14 = (Integer)object;
            l10 = n14;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n11 = (Integer)object;
            l10 = n11;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n11 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n11);
        } else {
            n13 = n10;
            long l11 = n13;
            roomSQLiteQuery.bindLong(n11, l11);
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n12);
        } else {
            n11 = n10;
            long l12 = n11;
            roomSQLiteQuery.bindLong(n12, l12);
        }
        object = this.__db;
        String[] stringArray = new String[]{"TemplateType"};
        G_TemplateTypeDao_Impl$13 g_TemplateTypeDao_Impl$13 = new G_TemplateTypeDao_Impl$13(this, roomSQLiteQuery);
        return RxRoom.createObservable((RoomDatabase)object, false, stringArray, g_TemplateTypeDao_Impl$13);
    }

    public i0 getTemplateType_Single(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateType WHERE TemplateType.id == ?", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        G_TemplateTypeDao_Impl$20 g_TemplateTypeDao_Impl$20 = new G_TemplateTypeDao_Impl$20(this, roomSQLiteQuery);
        return RxRoom.createSingle(g_TemplateTypeDao_Impl$20);
    }

    public i0 getTemplateType_Single(Integer object, Integer n10) {
        int n11;
        long l10;
        int n12 = 4;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateType WHERE (? IS NULL OR TemplateType.resource_type == ?) AND (? IS NULL OR TemplateType.template_proto_type == ?) ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC", n12);
        int n13 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            int n14 = (Integer)object;
            l10 = n14;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n11 = (Integer)object;
            l10 = n11;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n11 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n11);
        } else {
            n13 = n10;
            long l11 = n13;
            roomSQLiteQuery.bindLong(n11, l11);
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n12);
        } else {
            n11 = n10;
            long l12 = n11;
            roomSQLiteQuery.bindLong(n12, l12);
        }
        object = new G_TemplateTypeDao_Impl$11(this, roomSQLiteQuery);
        return RxRoom.createSingle((Callable)object);
    }

    public long insert(TemplateType object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTemplateType_1;
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
            object = this.__insertionAdapterOfTemplateType_1;
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
        G_TemplateTypeDao_Impl$7 g_TemplateTypeDao_Impl$7 = new G_TemplateTypeDao_Impl$7(this, list);
        return i0.o0(g_TemplateTypeDao_Impl$7);
    }

    public long replace(TemplateType object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTemplateType;
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
            object = this.__insertionAdapterOfTemplateType;
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
        G_TemplateTypeDao_Impl$6 g_TemplateTypeDao_Impl$6 = new G_TemplateTypeDao_Impl$6(this, list);
        return i0.o0(g_TemplateTypeDao_Impl$6);
    }

    public void update(TemplateType object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfTemplateType;
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

