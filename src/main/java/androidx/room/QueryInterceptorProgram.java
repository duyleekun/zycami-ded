/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.ArrayList;
import java.util.List;

public final class QueryInterceptorProgram
implements SupportSQLiteProgram {
    private List mBindArgsCache;

    public QueryInterceptorProgram() {
        ArrayList arrayList;
        this.mBindArgsCache = arrayList = new ArrayList();
    }

    private void saveArgsToCache(int n10, Object object) {
        List list = this.mBindArgsCache;
        int n11 = list.size();
        if ((n10 += -1) >= n11) {
            list = this.mBindArgsCache;
            for (n11 = list.size(); n11 <= n10; ++n11) {
                List list2 = this.mBindArgsCache;
                list2.add(null);
            }
        }
        this.mBindArgsCache.set(n10, object);
    }

    public void bindBlob(int n10, byte[] byArray) {
        this.saveArgsToCache(n10, byArray);
    }

    public void bindDouble(int n10, double d10) {
        Double d11 = d10;
        this.saveArgsToCache(n10, d11);
    }

    public void bindLong(int n10, long l10) {
        Long l11 = l10;
        this.saveArgsToCache(n10, l11);
    }

    public void bindNull(int n10) {
        this.saveArgsToCache(n10, null);
    }

    public void bindString(int n10, String string2) {
        this.saveArgsToCache(n10, string2);
    }

    public void clearBindings() {
        this.mBindArgsCache.clear();
    }

    public void close() {
    }

    public List getBindArgs() {
        return this.mBindArgsCache;
    }
}

