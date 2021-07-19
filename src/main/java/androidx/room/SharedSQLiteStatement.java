/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class SharedSQLiteStatement {
    private final RoomDatabase mDatabase;
    private final AtomicBoolean mLock;
    private volatile SupportSQLiteStatement mStmt;

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        AtomicBoolean atomicBoolean;
        this.mLock = atomicBoolean = new AtomicBoolean(false);
        this.mDatabase = roomDatabase;
    }

    private SupportSQLiteStatement createNewStatement() {
        String string2 = this.createQuery();
        return this.mDatabase.compileStatement(string2);
    }

    private SupportSQLiteStatement getStmt(boolean bl2) {
        SupportSQLiteStatement supportSQLiteStatement;
        if (bl2) {
            supportSQLiteStatement = this.mStmt;
            if (supportSQLiteStatement == null) {
                this.mStmt = supportSQLiteStatement = this.createNewStatement();
            }
            supportSQLiteStatement = this.mStmt;
        } else {
            supportSQLiteStatement = this.createNewStatement();
        }
        return supportSQLiteStatement;
    }

    public SupportSQLiteStatement acquire() {
        this.assertNotMainThread();
        boolean bl2 = this.mLock.compareAndSet(false, true);
        return this.getStmt(bl2);
    }

    public void assertNotMainThread() {
        this.mDatabase.assertNotMainThread();
    }

    public abstract String createQuery();

    public void release(SupportSQLiteStatement object) {
        SupportSQLiteStatement supportSQLiteStatement = this.mStmt;
        if (object == supportSQLiteStatement) {
            object = this.mLock;
            supportSQLiteStatement = null;
            ((AtomicBoolean)object).set(false);
        }
    }
}

