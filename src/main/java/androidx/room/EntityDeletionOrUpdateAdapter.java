/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;

public abstract class EntityDeletionOrUpdateAdapter
extends SharedSQLiteStatement {
    public EntityDeletionOrUpdateAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public abstract void bind(SupportSQLiteStatement var1, Object var2);

    public abstract String createQuery();

    public final int handle(Object object) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            this.bind(supportSQLiteStatement, object);
            int n10 = supportSQLiteStatement.executeUpdateDelete();
            return n10;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final int handleMultiple(Iterable object) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        int n10 = 0;
        try {
            object = object.iterator();
        }
        catch (Throwable throwable) {
            this.release(supportSQLiteStatement);
            throw throwable;
        }
        while (true) {
            int n11 = object.hasNext();
            if (n11 == 0) break;
            Object e10 = object.next();
            this.bind(supportSQLiteStatement, e10);
            n11 = supportSQLiteStatement.executeUpdateDelete();
            n10 += n11;
            continue;
            break;
        }
        this.release(supportSQLiteStatement);
        return n10;
    }

    public final int handleMultiple(Object[] objectArray) {
        int n10;
        int n11;
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            n11 = objectArray.length;
            n10 = 0;
        }
        catch (Throwable throwable) {
            this.release(supportSQLiteStatement);
            throw throwable;
        }
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object = objectArray[i10];
            this.bind(supportSQLiteStatement, object);
            int n12 = supportSQLiteStatement.executeUpdateDelete();
            n10 += n12;
            continue;
        }
        this.release(supportSQLiteStatement);
        return n10;
    }
}

