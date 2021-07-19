/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.SQLException
 *  android.database.sqlite.SQLiteDatabase
 */
package com.google.android.exoplayer2.database;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.util.Util;

public final class VersionTable {
    private static final String COLUMN_FEATURE = "feature";
    private static final String COLUMN_INSTANCE_UID = "instance_uid";
    private static final String COLUMN_VERSION = "version";
    public static final int FEATURE_CACHE_CONTENT_METADATA = 1;
    public static final int FEATURE_CACHE_FILE_METADATA = 2;
    public static final int FEATURE_EXTERNAL = 1000;
    public static final int FEATURE_OFFLINE = 0;
    private static final String PRIMARY_KEY = "PRIMARY KEY (feature, instance_uid)";
    private static final String SQL_CREATE_TABLE_IF_NOT_EXISTS = "CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))";
    private static final String TABLE_NAME = "ExoPlayerVersions";
    public static final int VERSION_UNSET = 255;
    private static final String WHERE_FEATURE_AND_INSTANCE_UID_EQUALS = "feature = ? AND instance_uid = ?";

    private VersionTable() {
    }

    private static String[] featureAndInstanceUidArguments(int n10, String string2) {
        String string3 = Integer.toString(n10);
        String[] stringArray = new String[]{string3, string2};
        return stringArray;
    }

    /*
     * Exception decompiling
     */
    public static int getVersion(SQLiteDatabase var0, int var1_3, String var2_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
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

    public static void removeVersion(SQLiteDatabase sQLiteDatabase, int n10, String string2) {
        String[] stringArray;
        String string3;
        String string4 = TABLE_NAME;
        try {
            boolean bl2 = Util.tableExists(sQLiteDatabase, string4);
            if (!bl2) {
                return;
            }
            string3 = WHERE_FEATURE_AND_INSTANCE_UID_EQUALS;
        }
        catch (SQLException sQLException) {
            stringArray = new DatabaseIOException(sQLException);
            throw stringArray;
        }
        stringArray = VersionTable.featureAndInstanceUidArguments(n10, string2);
        sQLiteDatabase.delete(string4, string3, stringArray);
    }

    public static void setVersion(SQLiteDatabase sQLiteDatabase, int n10, String object, int n11) {
        Object object2;
        String string2 = SQL_CREATE_TABLE_IF_NOT_EXISTS;
        try {
            sQLiteDatabase.execSQL(string2);
        }
        catch (SQLException sQLException) {
            object2 = new DatabaseIOException(sQLException);
            throw object2;
        }
        string2 = new ContentValues();
        String string3 = COLUMN_FEATURE;
        object2 = n10;
        string2.put(string3, (Integer)object2);
        object2 = COLUMN_INSTANCE_UID;
        string2.put((String)object2, (String)object);
        object2 = COLUMN_VERSION;
        object = n11;
        string2.put((String)object2, (Integer)object);
        object2 = TABLE_NAME;
        object = null;
        sQLiteDatabase.replaceOrThrow((String)object2, null, (ContentValues)string2);
    }
}

