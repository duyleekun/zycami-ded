/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package d.v.g.f.b.d;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.device.data.local.entity.RegionalRestrictionsInfo;
import d.v.g.f.b.d.g;
import d.v.g.f.b.d.h$a;

public final class h
implements g {
    private final RoomDatabase a;
    private final EntityInsertionAdapter b;
    private final EntityDeletionOrUpdateAdapter c;

    public h(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new h$a(this, roomDatabase);
        this.b = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.c = sharedSQLiteStatement;
    }

    public void a(RegionalRestrictionsInfo object) {
        this.a.assertNotSuspendingTransaction();
        Object object2 = this.a;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.b;
            ((EntityInsertionAdapter)object2).insert(object);
            object = this.a;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.a.endTransaction();
        }
    }

    public RegionalRestrictionsInfo b(String object) {
        Object object2;
        RoomSQLiteQuery roomSQLiteQuery;
        block15: {
            String string2;
            int n10;
            RegionalRestrictionsInfo regionalRestrictionsInfo;
            int n11;
            block16: {
                n11 = 1;
                roomSQLiteQuery = RoomSQLiteQuery.acquire("select * from regional_restrictions_info where deviceSn=?", n11);
                if (object == null) {
                    roomSQLiteQuery.bindNull(n11);
                } else {
                    roomSQLiteQuery.bindString(n11, (String)object);
                }
                this.a.assertNotSuspendingTransaction();
                object = this.a;
                regionalRestrictionsInfo = null;
                object2 = null;
                object = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
                String string3 = "id";
                try {
                    n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string3);
                    string2 = "deviceName";
                }
                catch (Throwable throwable) {
                    object.close();
                    roomSQLiteQuery.release();
                    throw throwable;
                }
                int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string2);
                String string4 = "deviceSn";
                int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string4);
                String string5 = "isRestrictions";
                int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string5);
                boolean bl2 = object.moveToFirst();
                if (!bl2) break block15;
                object2 = object.getString(n12);
                string2 = object.getString(n13);
                n13 = object.getInt(n14);
                if (n13 != 0) break block16;
                n11 = 0;
                Object var15_15 = null;
            }
            regionalRestrictionsInfo = new RegionalRestrictionsInfo((String)object2, string2, n11 != 0);
            n11 = object.getInt(n10);
            regionalRestrictionsInfo.setId(n11);
            object2 = regionalRestrictionsInfo;
        }
        object.close();
        roomSQLiteQuery.release();
        return object2;
    }

    public void c(RegionalRestrictionsInfo object) {
        this.a.assertNotSuspendingTransaction();
        Object object2 = this.a;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.c;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.a;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.a.endTransaction();
        }
    }
}

