/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class EntityInsertionAdapter
extends SharedSQLiteStatement {
    public EntityInsertionAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public abstract void bind(SupportSQLiteStatement var1, Object var2);

    public final void insert(Iterable object) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            object = object.iterator();
        }
        catch (Throwable throwable) {
            this.release(supportSQLiteStatement);
            throw throwable;
        }
        while (true) {
            boolean bl2 = object.hasNext();
            if (!bl2) break;
            Object e10 = object.next();
            this.bind(supportSQLiteStatement, e10);
            supportSQLiteStatement.executeInsert();
            continue;
            break;
        }
        this.release(supportSQLiteStatement);
        return;
    }

    public final void insert(Object object) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            this.bind(supportSQLiteStatement, object);
            supportSQLiteStatement.executeInsert();
            return;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final void insert(Object[] objectArray) {
        int n10;
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            n10 = objectArray.length;
        }
        catch (Throwable throwable) {
            this.release(supportSQLiteStatement);
            throw throwable;
        }
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            this.bind(supportSQLiteStatement, object);
            supportSQLiteStatement.executeInsert();
            continue;
        }
        this.release(supportSQLiteStatement);
        return;
    }

    public final long insertAndReturnId(Object object) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            this.bind(supportSQLiteStatement, object);
            long l10 = supportSQLiteStatement.executeInsert();
            return l10;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection object) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        int n10 = object.size();
        long[] lArray = new long[n10];
        int n11 = 0;
        try {
            object = object.iterator();
        }
        catch (Throwable throwable) {
            this.release(supportSQLiteStatement);
            throw throwable;
        }
        while (true) {
            boolean bl2 = object.hasNext();
            if (!bl2) break;
            Object e10 = object.next();
            this.bind(supportSQLiteStatement, e10);
            long l10 = supportSQLiteStatement.executeInsert();
            lArray[n11] = l10;
            ++n11;
            continue;
            break;
        }
        this.release(supportSQLiteStatement);
        return lArray;
    }

    public final long[] insertAndReturnIdsArray(Object[] objectArray) {
        int n10;
        int n11;
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        int n12 = objectArray.length;
        long[] lArray = new long[n12];
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
            long l10 = supportSQLiteStatement.executeInsert();
            lArray[n10] = l10;
            ++n10;
            continue;
        }
        this.release(supportSQLiteStatement);
        return lArray;
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection object) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        int n10 = object.size();
        Long[] longArray = new Long[n10];
        int n11 = 0;
        try {
            object = object.iterator();
        }
        catch (Throwable throwable) {
            this.release(supportSQLiteStatement);
            throw throwable;
        }
        while (true) {
            boolean bl2 = object.hasNext();
            if (!bl2) break;
            Object object2 = object.next();
            this.bind(supportSQLiteStatement, object2);
            long l10 = supportSQLiteStatement.executeInsert();
            object2 = l10;
            longArray[n11] = object2;
            ++n11;
            continue;
            break;
        }
        this.release(supportSQLiteStatement);
        return longArray;
    }

    public final Long[] insertAndReturnIdsArrayBox(Object[] objectArray) {
        int n10;
        int n11;
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        int n12 = objectArray.length;
        Long[] longArray = new Long[n12];
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
            long l10 = supportSQLiteStatement.executeInsert();
            object = l10;
            longArray[n10] = object;
            ++n10;
            continue;
        }
        this.release(supportSQLiteStatement);
        return longArray;
    }

    public final List insertAndReturnIdsList(Collection object) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        int n10 = object.size();
        ArrayList arrayList = new ArrayList(n10);
        n10 = 0;
        try {
            object = object.iterator();
        }
        catch (Throwable throwable) {
            this.release(supportSQLiteStatement);
            throw throwable;
        }
        while (true) {
            boolean bl2 = object.hasNext();
            if (!bl2) break;
            Object object2 = object.next();
            this.bind(supportSQLiteStatement, object2);
            long l10 = supportSQLiteStatement.executeInsert();
            object2 = l10;
            arrayList.add(n10, object2);
            ++n10;
            continue;
            break;
        }
        this.release(supportSQLiteStatement);
        return arrayList;
    }

    public final List insertAndReturnIdsList(Object[] objectArray) {
        int n10;
        ArrayList<Object> arrayList;
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        int n11 = objectArray.length;
        try {
            arrayList = new ArrayList<Object>(n11);
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
            long l10 = supportSQLiteStatement.executeInsert();
            object = l10;
            arrayList.add(n10, object);
            ++n10;
            continue;
        }
        this.release(supportSQLiteStatement);
        return arrayList;
    }
}

