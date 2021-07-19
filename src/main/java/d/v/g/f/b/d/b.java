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
import com.zhiyun.device.data.local.entity.ActivationData;
import d.v.g.f.b.d.a;
import d.v.g.f.b.d.b$a;

public final class b
implements a {
    private final RoomDatabase a;
    private final EntityInsertionAdapter b;
    private final EntityDeletionOrUpdateAdapter c;

    public b(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new b$a(this, roomDatabase);
        this.b = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.c = sharedSQLiteStatement;
    }

    public ActivationData a() {
        Cursor cursor;
        Object object;
        RoomSQLiteQuery roomSQLiteQuery;
        block35: {
            int n10;
            block34: {
                boolean bl2;
                Object object2 = this;
                boolean bl22 = false;
                String string2 = null;
                roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM activation_data ORDER BY id DESC LIMIT 1", 0);
                this.a.assertNotSuspendingTransaction();
                Object object3 = this.a;
                n10 = 0;
                object = null;
                cursor = DBUtil.query((RoomDatabase)object3, roomSQLiteQuery, false, null);
                object3 = "id";
                int n11 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
                String string3 = "userId";
                int n12 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
                String string4 = "account";
                int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
                String string5 = "serialNum";
                int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
                String string6 = "deviceModel";
                int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
                String string7 = "deviceName";
                int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
                String string8 = "appVersion";
                int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
                String string9 = "longitude";
                int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
                String string10 = "latitude";
                int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
                String string11 = "activeCode";
                int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
                String string12 = "activeAt";
                int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
                string2 = "activeStatus";
                int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
                object = "isVisitor";
                n10 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
                object2 = "ex";
                int n23 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
                boolean bl3 = cursor.moveToFirst();
                if (!bl3) break block34;
                int n24 = cursor.getInt(n12);
                String string13 = cursor.getString(n13);
                String string14 = cursor.getString(n14);
                int n25 = cursor.getInt(n15);
                String string15 = cursor.getString(n16);
                String string16 = cursor.getString(n17);
                String string17 = cursor.getString(n18);
                String string18 = cursor.getString(n19);
                String string19 = cursor.getString(n20);
                String string20 = cursor.getString(n21);
                String string21 = cursor.getString(n22);
                int n26 = cursor.getInt(n10);
                boolean bl4 = n26 != 0 ? (bl2 = true) : false;
                String string22 = cursor.getString(n23);
                object = new ActivationData(n24, string13, string14, n25, string15, string16, string17, string18, string19, string20, string21, bl4, string22);
                n11 = cursor.getInt(n11);
                ((ActivationData)object).setId(n11);
                break block35;
            }
            n10 = 0;
            object = null;
        }
        return object;
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public void b(ActivationData ... object) {
        this.a.assertNotSuspendingTransaction();
        Object object2 = this.a;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.b;
            ((EntityInsertionAdapter)object2).insert((Object[])object);
            object = this.a;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.a.endTransaction();
        }
    }

    public void c(ActivationData object) {
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

