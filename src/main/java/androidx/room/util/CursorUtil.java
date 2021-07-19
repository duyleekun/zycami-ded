/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.MatrixCursor
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;

public class CursorUtil {
    private CursorUtil() {
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public static Cursor copyAndClose(Cursor cursor) {
        try {
            int n10;
            Object[] objectArray = cursor.getColumnNames();
            int n11 = cursor.getCount();
            MatrixCursor matrixCursor = new MatrixCursor((String[])objectArray, n11);
            while ((n10 = cursor.moveToNext()) != 0) {
                int n12;
                n10 = cursor.getColumnCount();
                objectArray = new Object[n10];
                for (n11 = 0; n11 < (n12 = cursor.getColumnCount()); ++n11) {
                    Object object;
                    n12 = cursor.getType(n11);
                    if (n12 != 0) {
                        int n13 = 1;
                        if (n12 != n13) {
                            n13 = 2;
                            if (n12 != n13) {
                                n13 = 3;
                                if (n12 != n13) {
                                    n13 = 4;
                                    if (n12 == n13) {
                                        objectArray[n11] = object = (Object)cursor.getBlob(n11);
                                        continue;
                                    }
                                    IllegalStateException illegalStateException = new IllegalStateException();
                                    throw illegalStateException;
                                }
                                objectArray[n11] = object = cursor.getString(n11);
                                continue;
                            }
                            double d10 = cursor.getDouble(n11);
                            objectArray[n11] = object = Double.valueOf(d10);
                            continue;
                        }
                        long l10 = cursor.getLong(n11);
                        objectArray[n11] = object = Long.valueOf(l10);
                        continue;
                    }
                    n12 = 0;
                    object = null;
                    objectArray[n11] = null;
                }
                matrixCursor.addRow(objectArray);
            }
            return matrixCursor;
        }
        finally {
            cursor.close();
        }
    }

    private static int findColumnIndexBySuffix(Cursor cursor, String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = -1;
        int n12 = 25;
        if (n10 > n12) {
            return n11;
        }
        n10 = string2.length();
        if (n10 == 0) {
            return n11;
        }
        return CursorUtil.findColumnIndexBySuffix(cursor.getColumnNames(), string2);
    }

    public static int findColumnIndexBySuffix(String[] stringArray, String string2) {
        int n10;
        CharSequence charSequence = new StringBuilder();
        String string3 = ".";
        charSequence.append(string3);
        charSequence.append(string2);
        charSequence = charSequence.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("`");
        string3 = stringBuilder.toString();
        stringBuilder = null;
        for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
            int n11;
            String string4 = stringArray[i10];
            int n12 = string4.length();
            if (n12 < (n11 = string2.length() + 2)) continue;
            n12 = (int)(string4.endsWith((String)charSequence) ? 1 : 0);
            if (n12 != 0) {
                return i10;
            }
            n12 = string4.charAt(0);
            if (n12 != (n11 = 96) || (n10 = (int)(string4.endsWith(string3) ? 1 : 0)) == 0) continue;
            return i10;
        }
        return -1;
    }

    public static int getColumnIndex(Cursor cursor, String string2) {
        int n10 = cursor.getColumnIndex(string2);
        if (n10 >= 0) {
            return n10;
        }
        CharSequence charSequence = new StringBuilder();
        String string3 = "`";
        charSequence.append(string3);
        charSequence.append(string2);
        charSequence.append(string3);
        charSequence = charSequence.toString();
        n10 = cursor.getColumnIndex((String)charSequence);
        if (n10 >= 0) {
            return n10;
        }
        return CursorUtil.findColumnIndexBySuffix(cursor, string2);
    }

    public static int getColumnIndexOrThrow(Cursor object, String string2) {
        CharSequence charSequence;
        Object object2;
        int n10 = CursorUtil.getColumnIndex((Cursor)object, string2);
        if (n10 >= 0) {
            return n10;
        }
        object = object.getColumnNames();
        try {
            object = Arrays.toString(object);
        }
        catch (Exception exception) {
            object2 = "RoomCursorUtil";
            charSequence = "Cannot collect column names for debug purposes";
            Log.d((String)object2, (String)charSequence, (Throwable)exception);
            object = "";
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("column '");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("' does not exist. Available columns: ");
        ((StringBuilder)charSequence).append((String)object);
        object = ((StringBuilder)charSequence).toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }
}

