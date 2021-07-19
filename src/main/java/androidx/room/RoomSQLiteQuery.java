/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.RoomSQLiteQuery$1;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Arrays;
import java.util.TreeMap;

public class RoomSQLiteQuery
implements SupportSQLiteQuery,
SupportSQLiteProgram {
    private static final int BLOB = 5;
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    public static final TreeMap sQueryPool;
    public int mArgCount;
    private final int[] mBindingTypes;
    public final byte[][] mBlobBindings;
    public final int mCapacity;
    public final double[] mDoubleBindings;
    public final long[] mLongBindings;
    private volatile String mQuery;
    public final String[] mStringBindings;

    static {
        TreeMap treeMap;
        sQueryPool = treeMap = new TreeMap();
    }

    private RoomSQLiteQuery(int n10) {
        this.mCapacity = n10++;
        Object[] objectArray = new int[n10];
        this.mBindingTypes = objectArray;
        objectArray = new long[n10];
        this.mLongBindings = objectArray;
        objectArray = new double[n10];
        this.mDoubleBindings = objectArray;
        objectArray = new String[n10];
        this.mStringBindings = (String[])objectArray;
        byte[][] byArrayArray = new byte[n10][];
        this.mBlobBindings = byArrayArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static RoomSQLiteQuery acquire(String string2, int n10) {
        Object object = sQueryPool;
        synchronized (object) {
            Object object2 = n10;
            object2 = ((TreeMap)object).ceilingEntry(object2);
            if (object2 != null) {
                Object k10 = object2.getKey();
                ((TreeMap)object).remove(k10);
                object2 = object2.getValue();
                object2 = (RoomSQLiteQuery)object2;
                ((RoomSQLiteQuery)object2).init(string2, n10);
                return object2;
            }
        }
        object = new RoomSQLiteQuery(n10);
        ((RoomSQLiteQuery)object).init(string2, n10);
        return object;
    }

    public static RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        Object object = supportSQLiteQuery.getSql();
        int n10 = supportSQLiteQuery.getArgCount();
        object = RoomSQLiteQuery.acquire((String)object, n10);
        RoomSQLiteQuery$1 roomSQLiteQuery$1 = new RoomSQLiteQuery$1((RoomSQLiteQuery)object);
        supportSQLiteQuery.bindTo(roomSQLiteQuery$1);
        return object;
    }

    private static void prunePoolLocked() {
        int n10;
        Object object = sQueryPool;
        int n11 = ((TreeMap)object).size();
        if (n11 > (n10 = 15)) {
            n11 = ((TreeMap)object).size() + -10;
            object = ((TreeMap)object).descendingKeySet().iterator();
            while (true) {
                n10 = n11 + -1;
                if (n11 <= 0) break;
                object.next();
                object.remove();
                n11 = n10;
            }
        }
    }

    public void bindBlob(int n10, byte[] byArray) {
        this.mBindingTypes[n10] = 5;
        this.mBlobBindings[n10] = byArray;
    }

    public void bindDouble(int n10, double d10) {
        this.mBindingTypes[n10] = 3;
        this.mDoubleBindings[n10] = d10;
    }

    public void bindLong(int n10, long l10) {
        this.mBindingTypes[n10] = 2;
        this.mLongBindings[n10] = l10;
    }

    public void bindNull(int n10) {
        this.mBindingTypes[n10] = 1;
    }

    public void bindString(int n10, String string2) {
        this.mBindingTypes[n10] = 4;
        this.mStringBindings[n10] = string2;
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        int n10;
        int n11;
        for (int i10 = n10 = 1; i10 <= (n11 = this.mArgCount); ++i10) {
            Object object = this.mBindingTypes;
            n11 = object[i10];
            if (n11 != n10) {
                int n12 = 2;
                if (n11 != n12) {
                    n12 = 3;
                    if (n11 != n12) {
                        n12 = 4;
                        if (n11 != n12) {
                            n12 = 5;
                            if (n11 != n12) continue;
                            object = this.mBlobBindings[i10];
                            supportSQLiteProgram.bindBlob(i10, (byte[])object);
                            continue;
                        }
                        object = this.mStringBindings[i10];
                        supportSQLiteProgram.bindString(i10, (String)object);
                        continue;
                    }
                    object = this.mDoubleBindings;
                    int n13 = object[i10];
                    supportSQLiteProgram.bindDouble(i10, n13);
                    continue;
                }
                object = this.mLongBindings;
                int n14 = object[i10];
                supportSQLiteProgram.bindLong(i10, n14);
                continue;
            }
            supportSQLiteProgram.bindNull(i10);
        }
    }

    public void clearBindings() {
        Arrays.fill(this.mBindingTypes, 1);
        Arrays.fill(this.mStringBindings, null);
        Arrays.fill((Object[])this.mBlobBindings, null);
        this.mQuery = null;
    }

    public void close() {
    }

    public void copyArgumentsFrom(RoomSQLiteQuery object) {
        int n10 = ((RoomSQLiteQuery)object).getArgCount() + 1;
        Object object2 = ((RoomSQLiteQuery)object).mBindingTypes;
        Object object3 = this.mBindingTypes;
        System.arraycopy(object2, 0, object3, 0, n10);
        object2 = ((RoomSQLiteQuery)object).mLongBindings;
        object3 = this.mLongBindings;
        System.arraycopy(object2, 0, object3, 0, n10);
        object2 = ((RoomSQLiteQuery)object).mStringBindings;
        object3 = this.mStringBindings;
        System.arraycopy(object2, 0, object3, 0, n10);
        object2 = ((RoomSQLiteQuery)object).mBlobBindings;
        object3 = this.mBlobBindings;
        System.arraycopy(object2, 0, object3, 0, n10);
        object = ((RoomSQLiteQuery)object).mDoubleBindings;
        object2 = this.mDoubleBindings;
        System.arraycopy(object, 0, object2, 0, n10);
    }

    public int getArgCount() {
        return this.mArgCount;
    }

    public String getSql() {
        return this.mQuery;
    }

    public void init(String string2, int n10) {
        this.mQuery = string2;
        this.mArgCount = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        TreeMap treeMap = sQueryPool;
        synchronized (treeMap) {
            int n10 = this.mCapacity;
            Integer n11 = n10;
            treeMap.put(n11, this);
            RoomSQLiteQuery.prunePoolLocked();
            return;
        }
    }
}

