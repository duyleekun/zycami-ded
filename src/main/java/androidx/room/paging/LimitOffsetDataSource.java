/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package androidx.room.paging;

import android.database.Cursor;
import androidx.paging.PositionalDataSource;
import androidx.paging.PositionalDataSource$LoadInitialCallback;
import androidx.paging.PositionalDataSource$LoadInitialParams;
import androidx.paging.PositionalDataSource$LoadRangeCallback;
import androidx.paging.PositionalDataSource$LoadRangeParams;
import androidx.room.InvalidationTracker;
import androidx.room.InvalidationTracker$Observer;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.LimitOffsetDataSource$1;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class LimitOffsetDataSource
extends PositionalDataSource {
    private final String mCountQuery;
    private final RoomDatabase mDb;
    private final boolean mInTransaction;
    private final String mLimitOffsetQuery;
    private final InvalidationTracker$Observer mObserver;
    private final AtomicBoolean mRegisteredObserver;
    private final RoomSQLiteQuery mSourceQuery;

    public LimitOffsetDataSource(RoomDatabase object, RoomSQLiteQuery object2, boolean bl2, boolean bl3, String ... stringArray) {
        AtomicBoolean atomicBoolean;
        this.mRegisteredObserver = atomicBoolean = new AtomicBoolean(false);
        this.mDb = object;
        this.mSourceQuery = object2;
        this.mInTransaction = bl2;
        object = new StringBuilder();
        ((StringBuilder)object).append("SELECT COUNT(*) FROM ( ");
        String string2 = ((RoomSQLiteQuery)object2).getSql();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(" )");
        this.mCountQuery = object = ((StringBuilder)object).toString();
        object = new StringBuilder();
        string2 = "SELECT * FROM ( ";
        ((StringBuilder)object).append(string2);
        object2 = ((RoomSQLiteQuery)object2).getSql();
        ((StringBuilder)object).append((String)object2);
        object2 = " ) LIMIT ? OFFSET ?";
        ((StringBuilder)object).append((String)object2);
        this.mLimitOffsetQuery = object = ((StringBuilder)object).toString();
        this.mObserver = object = new LimitOffsetDataSource$1(this, stringArray);
        if (bl3) {
            this.registerObserverIfNecessary();
        }
    }

    public LimitOffsetDataSource(RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean bl2, String ... stringArray) {
        this(roomDatabase, roomSQLiteQuery, bl2, true, stringArray);
    }

    public LimitOffsetDataSource(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean bl2, boolean bl3, String ... stringArray) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.copyFrom(supportSQLiteQuery);
        this(roomDatabase, roomSQLiteQuery, bl2, bl3, stringArray);
    }

    public LimitOffsetDataSource(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean bl2, String ... stringArray) {
        supportSQLiteQuery = RoomSQLiteQuery.copyFrom(supportSQLiteQuery);
        this(roomDatabase, (RoomSQLiteQuery)supportSQLiteQuery, bl2, stringArray);
    }

    private RoomSQLiteQuery getSQLiteQuery(int n10, int n11) {
        Object object = this.mLimitOffsetQuery;
        int n12 = this.mSourceQuery.getArgCount() + 2;
        object = RoomSQLiteQuery.acquire((String)object, n12);
        RoomSQLiteQuery roomSQLiteQuery = this.mSourceQuery;
        ((RoomSQLiteQuery)object).copyArgumentsFrom(roomSQLiteQuery);
        n12 = ((RoomSQLiteQuery)object).getArgCount() + -1;
        long l10 = n11;
        ((RoomSQLiteQuery)object).bindLong(n12, l10);
        n11 = ((RoomSQLiteQuery)object).getArgCount();
        long l11 = n10;
        ((RoomSQLiteQuery)object).bindLong(n11, l11);
        return object;
    }

    private void registerObserverIfNecessary() {
        Object object = this.mRegisteredObserver;
        InvalidationTracker$Observer invalidationTracker$Observer = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = this.mDb.getInvalidationTracker();
            invalidationTracker$Observer = this.mObserver;
            ((InvalidationTracker)object).addWeakObserver(invalidationTracker$Observer);
        }
    }

    public abstract List convertRows(Cursor var1);

    public int countItems() {
        RoomSQLiteQuery roomSQLiteQuery;
        Object object;
        block4: {
            this.registerObserverIfNecessary();
            object = this.mCountQuery;
            int n10 = this.mSourceQuery.getArgCount();
            object = RoomSQLiteQuery.acquire((String)object, n10);
            roomSQLiteQuery = this.mSourceQuery;
            ((RoomSQLiteQuery)object).copyArgumentsFrom(roomSQLiteQuery);
            roomSQLiteQuery = this.mDb.query((SupportSQLiteQuery)object);
            int n11 = roomSQLiteQuery.moveToFirst();
            if (n11 == 0) break block4;
            n11 = roomSQLiteQuery.getInt(0);
            return n11;
        }
        roomSQLiteQuery.close();
        ((RoomSQLiteQuery)object).release();
        return 0;
        finally {
            roomSQLiteQuery.close();
            ((RoomSQLiteQuery)object).release();
        }
    }

    public boolean isInvalid() {
        this.registerObserverIfNecessary();
        this.mDb.getInvalidationTracker().refreshVersionsSync();
        return super.isInvalid();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void loadInitial(PositionalDataSource$LoadInitialParams object, PositionalDataSource$LoadInitialCallback positionalDataSource$LoadInitialCallback) {
        void var2_5;
        RoomDatabase roomDatabase;
        Object object2;
        block9: {
            Object object3;
            int n10;
            int n11;
            block10: {
                block8: {
                    int n12;
                    this.registerObserverIfNecessary();
                    object2 = Collections.emptyList();
                    this.mDb.beginTransaction();
                    roomDatabase = null;
                    try {
                        n11 = this.countItems();
                        if (n11 == 0) break block8;
                        n12 = PositionalDataSource.computeInitialLoadPosition((PositionalDataSource$LoadInitialParams)object, n11);
                        n10 = PositionalDataSource.computeInitialLoadSize((PositionalDataSource$LoadInitialParams)object, n12, n11);
                        object = this.getSQLiteQuery(n12, n10);
                    }
                    catch (Throwable throwable) {
                        boolean bl2 = false;
                        object = null;
                        break block9;
                    }
                    try {
                        object3 = this.mDb;
                        roomDatabase = ((RoomDatabase)object3).query((SupportSQLiteQuery)object);
                        object3 = this.convertRows((Cursor)roomDatabase);
                        RoomDatabase roomDatabase2 = this.mDb;
                        roomDatabase2.setTransactionSuccessful();
                        Object object4 = object3;
                        object3 = object;
                        n10 = n12;
                        object2 = object4;
                        break block10;
                    }
                    catch (Throwable throwable) {
                        break block9;
                    }
                }
                n10 = 0;
                object = null;
                object3 = null;
            }
            if (roomDatabase != null) {
                roomDatabase.close();
            }
            roomDatabase = this.mDb;
            roomDatabase.endTransaction();
            if (object3 != null) {
                ((RoomSQLiteQuery)object3).release();
            }
            positionalDataSource$LoadInitialCallback.onResult((List)object2, n10, n11);
            return;
        }
        if (roomDatabase != null) {
            roomDatabase.close();
        }
        object2 = this.mDb;
        ((RoomDatabase)object2).endTransaction();
        if (object != null) {
            ((RoomSQLiteQuery)object).release();
        }
        throw var2_5;
    }

    public List loadRange(int n10, int n11) {
        RoomSQLiteQuery roomSQLiteQuery = this.getSQLiteQuery(n10, n11);
        n11 = (int)(this.mInTransaction ? 1 : 0);
        if (n11 != 0) {
            this.mDb.beginTransaction();
            n11 = 0;
            Cursor cursor = null;
            try {
                Object object = this.mDb;
                cursor = ((RoomDatabase)object).query(roomSQLiteQuery);
                object = this.convertRows(cursor);
                RoomDatabase roomDatabase = this.mDb;
                roomDatabase.setTransactionSuccessful();
                return object;
            }
            finally {
                if (cursor != null) {
                    cursor.close();
                }
                this.mDb.endTransaction();
                roomSQLiteQuery.release();
            }
        }
        Cursor cursor = this.mDb.query(roomSQLiteQuery);
        try {
            List list = this.convertRows(cursor);
            return list;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public void loadRange(PositionalDataSource$LoadRangeParams object, PositionalDataSource$LoadRangeCallback positionalDataSource$LoadRangeCallback) {
        int n10 = ((PositionalDataSource$LoadRangeParams)object).startPosition;
        int n11 = ((PositionalDataSource$LoadRangeParams)object).loadSize;
        object = this.loadRange(n10, n11);
        positionalDataSource$LoadRangeCallback.onResult((List)object);
    }
}

