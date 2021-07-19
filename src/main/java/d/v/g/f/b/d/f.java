/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package d.v.g.f.b.d;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.device.data.local.entity.FirmwareInfo;
import d.v.g.f.b.d.e;
import d.v.g.f.b.d.f$a;
import d.v.g.f.b.d.f$c;
import d.v.g.f.b.d.f$d;
import java.util.List;

public final class f
implements e {
    private final RoomDatabase c;
    private final EntityInsertionAdapter d;
    private final EntityDeletionOrUpdateAdapter e;

    public f(RoomDatabase roomDatabase) {
        this.c = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new f$a(this, roomDatabase);
        this.d = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.e = sharedSQLiteStatement;
    }

    public static /* synthetic */ RoomDatabase g(f f10) {
        return f10.c;
    }

    public void a(FirmwareInfo object) {
        this.c.assertNotSuspendingTransaction();
        Object object2 = this.c;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.d;
            ((EntityInsertionAdapter)object2).insert(object);
            object = this.c;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.c.endTransaction();
        }
    }

    public void b(FirmwareInfo object) {
        this.c.assertNotSuspendingTransaction();
        Object object2 = this.c;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.e;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.c;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.c.endTransaction();
        }
    }

    public void c(List object) {
        this.c.assertNotSuspendingTransaction();
        Object object2 = this.c;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.d;
            ((EntityInsertionAdapter)object2).insert((Iterable)object);
            object = this.c;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.c.endTransaction();
        }
    }

    public FirmwareInfo d(int n10, String string2) {
        Object object = this;
        Object object2 = string2;
        int n11 = 2;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM firmware_info WHERE serial=? AND union_version=? AND has_popup = 1 AND (need_update OR force_update) LIMIT 1", n11);
        int n12 = n10;
        long l10 = n10;
        int n13 = 1;
        roomSQLiteQuery.bindLong(n13, l10);
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n11);
        } else {
            roomSQLiteQuery.bindString(n11, string2);
        }
        ((f)object).c.assertNotSuspendingTransaction();
        object2 = ((f)object).c;
        n11 = 0;
        String string3 = null;
        n12 = 0;
        Object object3 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "_id";
        try {
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string4 = "serial";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "union_version";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "version";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "release_date";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "force_update";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "need_update";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "ota_update";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "notice";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "release_notes";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            string3 = "before_update_tip";
            n11 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            object3 = "after_update_tip";
            n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
            String string13 = "md5";
            n13 = CursorUtil.getColumnIndexOrThrow(cursor, string13);
            object = "url";
            int n24 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n24;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public LiveData e(int n10, String stringArray) {
        int n11 = 2;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM firmware_info WHERE serial=? AND union_version=? AND (need_update OR force_update) LIMIT 1", n11);
        long l10 = n10;
        n10 = 1;
        roomSQLiteQuery.bindLong(n10, l10);
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n11);
        } else {
            roomSQLiteQuery.bindString(n11, (String)stringArray);
        }
        InvalidationTracker invalidationTracker = this.c.getInvalidationTracker();
        stringArray = new String[]{"firmware_info"};
        f$d f$d = new f$d(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, f$d);
    }

    public LiveData f(int n10, String stringArray) {
        int n11 = 2;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM firmware_info WHERE serial=? AND union_version=? AND has_popup = 1 AND (need_update OR force_update) LIMIT 1", n11);
        long l10 = n10;
        n10 = 1;
        roomSQLiteQuery.bindLong(n10, l10);
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n11);
        } else {
            roomSQLiteQuery.bindString(n11, (String)stringArray);
        }
        InvalidationTracker invalidationTracker = this.c.getInvalidationTracker();
        stringArray = new String[]{"firmware_info"};
        f$c f$c = new f$c(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, f$c);
    }
}

