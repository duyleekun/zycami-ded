/*
 * Decompiled with CFR 0.151.
 */
package androidx.sqlite.db;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;

public final class SimpleSQLiteQuery
implements SupportSQLiteQuery {
    private final Object[] mBindArgs;
    private final String mQuery;

    public SimpleSQLiteQuery(String string2) {
        this(string2, null);
    }

    public SimpleSQLiteQuery(String string2, Object[] objectArray) {
        this.mQuery = string2;
        this.mBindArgs = objectArray;
    }

    private static void bind(SupportSQLiteProgram object, int n10, Object object2) {
        block15: {
            block6: {
                long l10;
                boolean bl2;
                block14: {
                    block13: {
                        block12: {
                            block11: {
                                block10: {
                                    block9: {
                                        block8: {
                                            block7: {
                                                block5: {
                                                    if (object2 != null) break block5;
                                                    object.bindNull(n10);
                                                    break block6;
                                                }
                                                bl2 = object2 instanceof byte[];
                                                if (!bl2) break block7;
                                                object2 = (byte[])object2;
                                                object.bindBlob(n10, (byte[])object2);
                                                break block6;
                                            }
                                            bl2 = object2 instanceof Float;
                                            if (!bl2) break block8;
                                            object2 = (Float)object2;
                                            float f10 = ((Float)object2).floatValue();
                                            double d10 = f10;
                                            object.bindDouble(n10, d10);
                                            break block6;
                                        }
                                        bl2 = object2 instanceof Double;
                                        if (!bl2) break block9;
                                        object2 = (Double)object2;
                                        double d11 = (Double)object2;
                                        object.bindDouble(n10, d11);
                                        break block6;
                                    }
                                    bl2 = object2 instanceof Long;
                                    if (!bl2) break block10;
                                    object2 = (Long)object2;
                                    long l11 = (Long)object2;
                                    object.bindLong(n10, l11);
                                    break block6;
                                }
                                bl2 = object2 instanceof Integer;
                                if (!bl2) break block11;
                                object2 = (Integer)object2;
                                int n11 = (Integer)object2;
                                long l12 = n11;
                                object.bindLong(n10, l12);
                                break block6;
                            }
                            bl2 = object2 instanceof Short;
                            if (!bl2) break block12;
                            object2 = (Short)object2;
                            short s10 = (Short)object2;
                            long l13 = s10;
                            object.bindLong(n10, l13);
                            break block6;
                        }
                        bl2 = object2 instanceof Byte;
                        if (!bl2) break block13;
                        object2 = (Byte)object2;
                        byte by2 = (Byte)object2;
                        long l14 = by2;
                        object.bindLong(n10, l14);
                        break block6;
                    }
                    bl2 = object2 instanceof String;
                    if (!bl2) break block14;
                    object2 = (String)object2;
                    object.bindString(n10, (String)object2);
                    break block6;
                }
                bl2 = object2 instanceof Boolean;
                if (!bl2) break block15;
                boolean bl3 = (Boolean)(object2 = (Boolean)object2);
                if (bl3) {
                    l10 = 1L;
                    double d12 = Double.MIN_VALUE;
                } else {
                    l10 = 0L;
                    double d13 = 0.0;
                }
                object.bindLong(n10, l10);
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot bind ");
        stringBuilder.append(object2);
        stringBuilder.append(" at index ");
        stringBuilder.append(n10);
        stringBuilder.append(" Supported types: null, byte[], float, double, long, int, short, byte, string");
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public static void bind(SupportSQLiteProgram supportSQLiteProgram, Object[] objectArray) {
        if (objectArray == null) {
            return;
        }
        int n10 = objectArray.length;
        int n11 = 0;
        while (n11 < n10) {
            Object object = objectArray[n11];
            SimpleSQLiteQuery.bind(supportSQLiteProgram, ++n11, object);
        }
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        Object[] objectArray = this.mBindArgs;
        SimpleSQLiteQuery.bind(supportSQLiteProgram, objectArray);
    }

    public int getArgCount() {
        int n10;
        Object[] objectArray = this.mBindArgs;
        if (objectArray == null) {
            n10 = 0;
            objectArray = null;
        } else {
            n10 = objectArray.length;
        }
        return n10;
    }

    public String getSql() {
        return this.mQuery;
    }
}

