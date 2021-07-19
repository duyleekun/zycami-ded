/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.SQLException
 *  android.database.sqlite.SQLiteDatabase
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.upstream.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.upstream.cache.CachedContent;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage;
import com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata;
import com.google.android.exoplayer2.util.Assertions;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

public final class CachedContentIndex$DatabaseStorage
implements CachedContentIndex$Storage {
    private static final String[] COLUMNS = new String[]{"id", "key", "metadata"};
    private static final String COLUMN_ID = "id";
    private static final int COLUMN_INDEX_ID = 0;
    private static final int COLUMN_INDEX_KEY = 1;
    private static final int COLUMN_INDEX_METADATA = 2;
    private static final String COLUMN_KEY = "key";
    private static final String COLUMN_METADATA = "metadata";
    private static final String TABLE_PREFIX = "ExoPlayerCacheIndex";
    private static final String TABLE_SCHEMA = "(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)";
    private static final int TABLE_VERSION = 1;
    private static final String WHERE_ID_EQUALS = "id = ?";
    private final DatabaseProvider databaseProvider;
    private String hexUid;
    private final SparseArray pendingUpdates;
    private String tableName;

    public CachedContentIndex$DatabaseStorage(DatabaseProvider databaseProvider) {
        this.databaseProvider = databaseProvider;
        this.pendingUpdates = databaseProvider;
    }

    private void addOrUpdateRow(SQLiteDatabase sQLiteDatabase, CachedContent object) {
        Object object2 = new ByteArrayOutputStream();
        DefaultContentMetadata defaultContentMetadata = ((CachedContent)object).getMetadata();
        Object object3 = new DataOutputStream((OutputStream)object2);
        CachedContentIndex.access$200(defaultContentMetadata, (DataOutputStream)object3);
        object2 = ((ByteArrayOutputStream)object2).toByteArray();
        defaultContentMetadata = new ContentValues();
        object3 = ((CachedContent)object).id;
        defaultContentMetadata.put(COLUMN_ID, (Integer)object3);
        object = ((CachedContent)object).key;
        defaultContentMetadata.put(COLUMN_KEY, (String)object);
        defaultContentMetadata.put(COLUMN_METADATA, (byte[])object2);
        object = (String)Assertions.checkNotNull(this.tableName);
        sQLiteDatabase.replaceOrThrow((String)object, null, (ContentValues)defaultContentMetadata);
    }

    public static void delete(DatabaseProvider databaseProvider, long l10) {
        String string2 = Long.toHexString(l10);
        CachedContentIndex$DatabaseStorage.delete(databaseProvider, string2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void delete(DatabaseProvider databaseProvider, String object) {
        int n10;
        String string2;
        try {
            string2 = CachedContentIndex$DatabaseStorage.getTableName((String)object);
            databaseProvider = databaseProvider.getWritableDatabase();
            databaseProvider.beginTransactionNonExclusive();
            n10 = 1;
        }
        catch (SQLException sQLException) {
            object = new DatabaseIOException(sQLException);
            throw object;
        }
        try {
            VersionTable.removeVersion((SQLiteDatabase)databaseProvider, n10, (String)object);
            CachedContentIndex$DatabaseStorage.dropTable((SQLiteDatabase)databaseProvider, string2);
            databaseProvider.setTransactionSuccessful();
            return;
        }
        finally {
            databaseProvider.endTransaction();
        }
    }

    private void deleteRow(SQLiteDatabase sQLiteDatabase, int n10) {
        String string2 = (String)Assertions.checkNotNull(this.tableName);
        String string3 = Integer.toString(n10);
        String[] stringArray = new String[]{string3};
        sQLiteDatabase.delete(string2, WHERE_ID_EQUALS, stringArray);
    }

    private static void dropTable(SQLiteDatabase sQLiteDatabase, String string2) {
        string2 = String.valueOf(string2);
        int n10 = string2.length();
        String string3 = "DROP TABLE IF EXISTS ";
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        sQLiteDatabase.execSQL(string2);
    }

    private Cursor getCursor() {
        Object object;
        SQLiteDatabase sQLiteDatabase = this.databaseProvider.getReadableDatabase();
        Object object2 = object = Assertions.checkNotNull(this.tableName);
        object2 = (String)object;
        String[] stringArray = COLUMNS;
        return sQLiteDatabase.query((String)object2, stringArray, null, null, null, null, null);
    }

    private static String getTableName(String string2) {
        string2 = String.valueOf(string2);
        int n10 = string2.length();
        String string3 = TABLE_PREFIX;
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        return string2;
    }

    private void initializeTable(SQLiteDatabase sQLiteDatabase) {
        String string2 = (String)Assertions.checkNotNull(this.hexUid);
        int n10 = 1;
        VersionTable.setVersion(sQLiteDatabase, n10, string2, n10);
        string2 = (String)Assertions.checkNotNull(this.tableName);
        CachedContentIndex$DatabaseStorage.dropTable(sQLiteDatabase, string2);
        string2 = this.tableName;
        n10 = String.valueOf(string2).length() + 88;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("CREATE TABLE ");
        stringBuilder.append(string2);
        stringBuilder.append(" ");
        stringBuilder.append(TABLE_SCHEMA);
        string2 = stringBuilder.toString();
        sQLiteDatabase.execSQL(string2);
    }

    public void delete() {
        DatabaseProvider databaseProvider = this.databaseProvider;
        String string2 = (String)Assertions.checkNotNull(this.hexUid);
        CachedContentIndex$DatabaseStorage.delete(databaseProvider, string2);
    }

    public boolean exists() {
        int n10;
        String string2;
        boolean bl2;
        SQLiteDatabase sQLiteDatabase = this.databaseProvider.getReadableDatabase();
        int n11 = VersionTable.getVersion(sQLiteDatabase, (int)((bl2 = true) ? 1 : 0), string2 = (String)Assertions.checkNotNull(this.hexUid));
        if (n11 == (n10 = -1)) {
            bl2 = false;
        }
        return bl2;
    }

    public void initialize(long l10) {
        String string2;
        this.hexUid = string2 = Long.toHexString(l10);
        this.tableName = string2 = CachedContentIndex$DatabaseStorage.getTableName(string2);
    }

    /*
     * Exception decompiling
     */
    public void load(HashMap var1_1, SparseArray var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void onRemove(CachedContent cachedContent, boolean bl2) {
        if (bl2) {
            SparseArray sparseArray = this.pendingUpdates;
            int n10 = cachedContent.id;
            sparseArray.delete(n10);
        } else {
            SparseArray sparseArray = this.pendingUpdates;
            int n11 = cachedContent.id;
            sparseArray.put(n11, null);
        }
    }

    public void onUpdate(CachedContent cachedContent) {
        SparseArray sparseArray = this.pendingUpdates;
        int n10 = cachedContent.id;
        sparseArray.put(n10, (Object)cachedContent);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void storeFully(HashMap object) {
        Object object2;
        try {
            object2 = this.databaseProvider;
            object2 = object2.getWritableDatabase();
            object2.beginTransactionNonExclusive();
        }
        catch (SQLException sQLException) {
            object2 = new DatabaseIOException(sQLException);
            throw object2;
        }
        try {
            boolean bl2;
            this.initializeTable((SQLiteDatabase)object2);
            object = ((HashMap)object).values();
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                Object object3 = object.next();
                object3 = (CachedContent)object3;
                this.addOrUpdateRow((SQLiteDatabase)object2, (CachedContent)object3);
            }
            object2.setTransactionSuccessful();
            object = this.pendingUpdates;
            object.clear();
            return;
        }
        finally {
            object2.endTransaction();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void storeIncremental(HashMap object) {
        DatabaseIOException databaseIOException;
        object = this.pendingUpdates;
        int n10 = object.size();
        if (n10 == 0) {
            return;
        }
        try {
            object = this.databaseProvider;
            object = object.getWritableDatabase();
            object.beginTransactionNonExclusive();
            databaseIOException = null;
        }
        catch (SQLException sQLException) {
            databaseIOException = new DatabaseIOException(sQLException);
            throw databaseIOException;
        }
        try {
            Object object2;
            int n12;
            for (int n11 = 0; n11 < (n12 = (object2 = this.pendingUpdates).size()); ++n11) {
                object2 = this.pendingUpdates;
                object2 = object2.valueAt(n11);
                if ((object2 = (CachedContent)object2) == null) {
                    object2 = this.pendingUpdates;
                    n12 = object2.keyAt(n11);
                    this.deleteRow((SQLiteDatabase)object, n12);
                    continue;
                }
                this.addOrUpdateRow((SQLiteDatabase)object, (CachedContent)object2);
            }
            object.setTransactionSuccessful();
            databaseIOException = this.pendingUpdates;
            databaseIOException.clear();
            return;
        }
        finally {
            object.endTransaction();
        }
    }
}

