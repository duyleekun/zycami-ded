/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteException
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.Pair
 */
package androidx.sqlite.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.io.File;
import java.io.IOException;

public abstract class SupportSQLiteOpenHelper$Callback {
    private static final String TAG = "SupportSQLite";
    public final int version;

    public SupportSQLiteOpenHelper$Callback(int n10) {
        this.version = n10;
    }

    private void deleteDatabaseFile(String string2) {
        block15: {
            Object object = ":memory:";
            int n10 = string2.equalsIgnoreCase((String)object);
            if (n10 == 0 && (n10 = ((String)(object = string2.trim())).length()) != 0) {
                String string3;
                block14: {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("deleting the database file: ");
                    ((StringBuilder)object).append(string2);
                    object = ((StringBuilder)object).toString();
                    string3 = TAG;
                    Log.w((String)string3, (String)object);
                    n10 = Build.VERSION.SDK_INT;
                    int n11 = 16;
                    if (n10 < n11) break block14;
                    object = new File(string2);
                    SQLiteDatabase.deleteDatabase((File)object);
                }
                object = new File(string2);
                n10 = (int)(((File)object).delete() ? 1 : 0);
                if (n10 != 0) break block15;
                object = new StringBuilder();
                String string4 = "Could not delete the database file ";
                ((StringBuilder)object).append(string4);
                ((StringBuilder)object).append(string2);
                string2 = ((StringBuilder)object).toString();
                try {
                    Log.e((String)string3, (String)string2);
                }
                catch (Exception exception) {
                    object = "error while deleting corrupted database file";
                    try {
                        Log.e((String)string3, (String)object, (Throwable)exception);
                    }
                    catch (Exception exception2) {
                        object = "delete failed: ";
                        Log.w((String)string3, (String)object, (Throwable)exception2);
                    }
                }
            }
        }
    }

    public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCorruption(SupportSQLiteDatabase object) {
        boolean bl2;
        Object object2;
        block14: {
            Throwable throwable2;
            block13: {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Corruption reported by sqlite on database: ");
                String string2 = object.getPath();
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                string2 = TAG;
                Log.e((String)string2, (String)object2);
                bl2 = object.isOpen();
                if (!bl2) {
                    object = object.getPath();
                    this.deleteDatabaseFile((String)object);
                    return;
                }
                bl2 = false;
                object2 = null;
                try {
                    object2 = object.getAttachedDbs();
                }
                catch (Throwable throwable2) {
                    break block13;
                }
                catch (SQLiteException sQLiteException) {}
                try {
                    object.close();
                    break block14;
                }
                catch (IOException iOException) {}
            }
            if (object2 != null) {
                object = object2.iterator();
                while (bl2 = object.hasNext()) {
                    object2 = (String)((Pair)object.next()).second;
                    this.deleteDatabaseFile((String)object2);
                }
                throw throwable2;
            } else {
                object = object.getPath();
                this.deleteDatabaseFile((String)object);
            }
            throw throwable2;
        }
        if (object2 != null) {
            object = object2.iterator();
            while (bl2 = object.hasNext()) {
                object2 = (String)((Pair)object.next()).second;
                this.deleteDatabaseFile((String)object2);
            }
            return;
        } else {
            object = object.getPath();
            this.deleteDatabaseFile((String)object);
        }
    }

    public abstract void onCreate(SupportSQLiteDatabase var1);

    public void onDowngrade(SupportSQLiteDatabase object, int n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't downgrade database from version ");
        stringBuilder.append(n10);
        stringBuilder.append(" to ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        object = new SQLiteException(string2);
        throw object;
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    public abstract void onUpgrade(SupportSQLiteDatabase var1, int var2, int var3);
}

