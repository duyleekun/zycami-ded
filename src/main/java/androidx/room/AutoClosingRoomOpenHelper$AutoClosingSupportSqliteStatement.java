/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.arch.core.util.Function;
import androidx.room.AutoCloser;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import b.b.o0;
import b.b.t;
import b.b.t0;
import b.b.u;
import b.b.w;
import b.b.x0;
import java.util.ArrayList;

public class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement
implements SupportSQLiteStatement {
    private final AutoCloser mAutoCloser;
    private final ArrayList mBinds;
    private final String mSql;

    public AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement(String string2, AutoCloser autoCloser) {
        ArrayList arrayList;
        this.mBinds = arrayList = new ArrayList();
        this.mSql = string2;
        this.mAutoCloser = autoCloser;
    }

    public static /* synthetic */ Object a(SupportSQLiteStatement supportSQLiteStatement) {
        supportSQLiteStatement.execute();
        return null;
    }

    private void doBinds(SupportSQLiteStatement supportSQLiteStatement) {
        ArrayList arrayList;
        int n10;
        int n11 = 0;
        Object object = null;
        while (n11 < (n10 = (arrayList = this.mBinds).size())) {
            n10 = n11 + 1;
            ArrayList arrayList2 = this.mBinds;
            object = arrayList2.get(n11);
            if (object == null) {
                supportSQLiteStatement.bindNull(n10);
            } else {
                boolean bl2 = object instanceof Long;
                if (bl2) {
                    object = (Long)object;
                    long l10 = (Long)object;
                    supportSQLiteStatement.bindLong(n10, l10);
                } else {
                    bl2 = object instanceof Double;
                    if (bl2) {
                        object = (Double)object;
                        double d10 = (Double)object;
                        supportSQLiteStatement.bindDouble(n10, d10);
                    } else {
                        bl2 = object instanceof String;
                        if (bl2) {
                            object = (String)object;
                            supportSQLiteStatement.bindString(n10, (String)object);
                        } else {
                            bl2 = object instanceof byte[];
                            if (bl2) {
                                object = (byte[])object;
                                supportSQLiteStatement.bindBlob(n10, (byte[])object);
                            }
                        }
                    }
                }
            }
            n11 = n10;
        }
    }

    private Object executeSqliteStatementWithRefCount(Function function) {
        AutoCloser autoCloser = this.mAutoCloser;
        u u10 = new u(this, function);
        return autoCloser.executeRefCountingFunction(u10);
    }

    private /* synthetic */ Object h(Function function, SupportSQLiteDatabase closeable) {
        String string2 = this.mSql;
        closeable = closeable.compileStatement(string2);
        this.doBinds((SupportSQLiteStatement)closeable);
        return function.apply(closeable);
    }

    private void saveBinds(int n10, Object object) {
        ArrayList arrayList = this.mBinds;
        int n11 = arrayList.size();
        if ((n10 += -1) >= n11) {
            arrayList = this.mBinds;
            for (n11 = arrayList.size(); n11 <= n10; ++n11) {
                ArrayList arrayList2 = this.mBinds;
                arrayList2.add(null);
            }
        }
        this.mBinds.set(n10, object);
    }

    public void bindBlob(int n10, byte[] byArray) {
        this.saveBinds(n10, byArray);
    }

    public void bindDouble(int n10, double d10) {
        Double d11 = d10;
        this.saveBinds(n10, d11);
    }

    public void bindLong(int n10, long l10) {
        Long l11 = l10;
        this.saveBinds(n10, l11);
    }

    public void bindNull(int n10) {
        this.saveBinds(n10, null);
    }

    public void bindString(int n10, String string2) {
        this.saveBinds(n10, string2);
    }

    public void clearBindings() {
        this.mBinds.clear();
    }

    public void close() {
    }

    public void execute() {
        t t10 = t.a;
        this.executeSqliteStatementWithRefCount(t10);
    }

    public long executeInsert() {
        t0 t02 = t0.a;
        return (Long)this.executeSqliteStatementWithRefCount(t02);
    }

    public int executeUpdateDelete() {
        x0 x02 = x0.a;
        return (Integer)this.executeSqliteStatementWithRefCount(x02);
    }

    public /* synthetic */ Object q(Function function, SupportSQLiteDatabase supportSQLiteDatabase) {
        return this.h(function, supportSQLiteDatabase);
    }

    public long simpleQueryForLong() {
        o0 o02 = o0.a;
        return (Long)this.executeSqliteStatementWithRefCount(o02);
    }

    public String simpleQueryForString() {
        w w10 = w.a;
        return (String)this.executeSqliteStatementWithRefCount(w10);
    }
}

