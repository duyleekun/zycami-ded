/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.SQLException
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteException
 *  android.net.Uri
 */
package com.google.android.exoplayer2.offline;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.offline.DefaultDownloadIndex$DownloadCursorImpl;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadCursor;
import com.google.android.exoplayer2.offline.DownloadProgress;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.offline.DownloadRequest$Builder;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.offline.WritableDownloadIndex;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;

public final class DefaultDownloadIndex
implements WritableDownloadIndex {
    private static final String[] COLUMNS;
    private static final String COLUMN_BYTES_DOWNLOADED = "bytes_downloaded";
    private static final String COLUMN_CONTENT_LENGTH = "content_length";
    private static final String COLUMN_CUSTOM_CACHE_KEY = "custom_cache_key";
    private static final String COLUMN_DATA = "data";
    private static final String COLUMN_FAILURE_REASON = "failure_reason";
    private static final String COLUMN_ID = "id";
    private static final int COLUMN_INDEX_BYTES_DOWNLOADED = 13;
    private static final int COLUMN_INDEX_CONTENT_LENGTH = 9;
    private static final int COLUMN_INDEX_CUSTOM_CACHE_KEY = 4;
    private static final int COLUMN_INDEX_DATA = 5;
    private static final int COLUMN_INDEX_FAILURE_REASON = 11;
    private static final int COLUMN_INDEX_ID = 0;
    private static final int COLUMN_INDEX_KEY_SET_ID = 14;
    private static final int COLUMN_INDEX_MIME_TYPE = 1;
    private static final int COLUMN_INDEX_PERCENT_DOWNLOADED = 12;
    private static final int COLUMN_INDEX_START_TIME_MS = 7;
    private static final int COLUMN_INDEX_STATE = 6;
    private static final int COLUMN_INDEX_STOP_REASON = 10;
    private static final int COLUMN_INDEX_STREAM_KEYS = 3;
    private static final int COLUMN_INDEX_UPDATE_TIME_MS = 8;
    private static final int COLUMN_INDEX_URI = 2;
    private static final String COLUMN_KEY_SET_ID = "key_set_id";
    private static final String COLUMN_MIME_TYPE = "mime_type";
    private static final String COLUMN_PERCENT_DOWNLOADED = "percent_downloaded";
    private static final String COLUMN_START_TIME_MS = "start_time_ms";
    private static final String COLUMN_STATE = "state";
    private static final String COLUMN_STOP_REASON = "stop_reason";
    private static final String COLUMN_STREAM_KEYS = "stream_keys";
    private static final String COLUMN_UPDATE_TIME_MS = "update_time_ms";
    private static final String COLUMN_URI = "uri";
    private static final String TABLE_PREFIX = "ExoPlayerDownloads";
    private static final String TABLE_SCHEMA = "(id TEXT PRIMARY KEY NOT NULL,mime_type TEXT,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL,key_set_id BLOB NOT NULL)";
    public static final int TABLE_VERSION = 3;
    private static final String TRUE = "1";
    private static final String WHERE_ID_EQUALS = "id = ?";
    private static final String WHERE_STATE_IS_DOWNLOADING = "state = 2";
    private static final String WHERE_STATE_IS_TERMINAL;
    private final DatabaseProvider databaseProvider;
    private final Object initializationLock;
    private boolean initialized;
    private final String name;
    private final String tableName;

    static {
        int[] nArray = new int[]{3, 4};
        WHERE_STATE_IS_TERMINAL = DefaultDownloadIndex.getStateQuery(nArray);
        COLUMNS = new String[]{COLUMN_ID, COLUMN_MIME_TYPE, COLUMN_URI, COLUMN_STREAM_KEYS, COLUMN_CUSTOM_CACHE_KEY, COLUMN_DATA, COLUMN_STATE, COLUMN_START_TIME_MS, COLUMN_UPDATE_TIME_MS, COLUMN_CONTENT_LENGTH, COLUMN_STOP_REASON, COLUMN_FAILURE_REASON, COLUMN_PERCENT_DOWNLOADED, COLUMN_BYTES_DOWNLOADED, COLUMN_KEY_SET_ID};
    }

    public DefaultDownloadIndex(DatabaseProvider databaseProvider) {
        this(databaseProvider, "");
    }

    public DefaultDownloadIndex(DatabaseProvider object, String string2) {
        this.name = string2;
        this.databaseProvider = object;
        object = String.valueOf(string2);
        int n10 = ((String)object).length();
        String string3 = TABLE_PREFIX;
        object = n10 != 0 ? string3.concat((String)object) : new String(string3);
        this.tableName = object;
        this.initializationLock = object = new Object();
    }

    public static /* synthetic */ Download access$100(Cursor cursor) {
        return DefaultDownloadIndex.getDownloadForCurrentRow(cursor);
    }

    private static List decodeStreamKeys(String stringArray) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n10 = stringArray.isEmpty();
        if (n10 != 0) {
            return arrayList;
        }
        String string2 = ",";
        for (String string3 : Util.split((String)stringArray, string2)) {
            Object object = "\\.";
            String[] stringArray2 = Util.split(string3, (String)object);
            int n11 = stringArray2.length;
            int n12 = 3;
            int n13 = 1;
            if (n11 == n12) {
                n11 = n13;
            } else {
                n11 = 0;
                object = null;
            }
            Assertions.checkState(n11 != 0);
            String string4 = stringArray2[0];
            n12 = Integer.parseInt(string4);
            String string5 = stringArray2[n13];
            n13 = Integer.parseInt(string5);
            int n14 = 2;
            String object2 = stringArray2[n14];
            int n15 = Integer.parseInt(object2);
            object = new StreamKey(n12, n13, n15);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static String encodeStreamKeys(List list) {
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            StreamKey streamKey = (StreamKey)list.get(i10);
            char c10 = streamKey.periodIndex;
            stringBuilder.append((int)c10);
            c10 = '.';
            stringBuilder.append(c10);
            int n11 = streamKey.groupIndex;
            stringBuilder.append(n11);
            stringBuilder.append(c10);
            n10 = streamKey.trackIndex;
            stringBuilder.append(n10);
            n10 = 44;
            stringBuilder.append((char)n10);
        }
        int n12 = stringBuilder.length();
        if (n12 > 0) {
            n12 = stringBuilder.length() + -1;
            stringBuilder.setLength(n12);
        }
        return stringBuilder.toString();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void ensureInitialized() {
        var1_1 = this.initializationLock;
        synchronized (var1_1) {
            var2_2 = this.initialized;
            if (var2_2 != 0) {
                return;
            }
            try {
                var3_3 = this.databaseProvider;
                var3_3 = var3_3.getReadableDatabase();
                var4_6 = this.name;
                var5_7 = 0;
                var6_8 = null;
                var2_2 = VersionTable.getVersion((SQLiteDatabase)var3_3, 0, (String)var4_6);
                var7_9 = 3;
                if (var2_2 != var7_9) {
                    var8_10 = this.databaseProvider;
                    var8_10 = var8_10.getWritableDatabase();
                    var8_10.beginTransactionNonExclusive();
                }
                ** GOTO lbl-1000
            }
            catch (SQLException var3_5) {
                var4_6 = new DatabaseIOException(var3_5);
                throw var4_6;
            }
            try {
                var9_11 = this.name;
                VersionTable.setVersion((SQLiteDatabase)var8_10, 0, (String)var9_11, var7_9);
                var7_9 = 2;
                var3_3 = var2_2 == var7_9 ? this.loadDownloadsFromVersion2((SQLiteDatabase)var8_10) : new ArrayList();
                var4_6 = "DROP TABLE IF EXISTS ";
                var6_8 = this.tableName;
                var6_8 = String.valueOf(var6_8);
                var10_12 = var6_8.length();
                if (var10_12 != 0) {
                    var4_6 = var4_6.concat(var6_8);
                } else {
                    var6_8 = new String((String)var4_6);
                    var4_6 = var6_8;
                }
                var8_10.execSQL((String)var4_6);
                var4_6 = this.tableName;
                var6_8 = String.valueOf(var4_6);
                var5_7 = var6_8.length() + 415;
                var9_11 = new StringBuilder(var5_7);
                var6_8 = "CREATE TABLE ";
                var9_11.append(var6_8);
                var9_11.append((String)var4_6);
                var4_6 = " ";
                var9_11.append((String)var4_6);
                var4_6 = "(id TEXT PRIMARY KEY NOT NULL,mime_type TEXT,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL,key_set_id BLOB NOT NULL)";
                var9_11.append((String)var4_6);
                var4_6 = var9_11.toString();
                var8_10.execSQL((String)var4_6);
                var3_3 = var3_3.iterator();
                while ((var7_9 = (int)var3_3.hasNext()) != 0) {
                    var4_6 = var3_3.next();
                    var4_6 = (Download)var4_6;
                    this.putDownloadInternal((Download)var4_6, (SQLiteDatabase)var8_10);
                }
                var8_10.setTransactionSuccessful();
            }
            finally {
                var8_10.endTransaction();
            }
lbl-1000:
            // 2 sources

            {
                var2_2 = 1;
                this.initialized = var2_2;
                return;
            }
        }
    }

    private Cursor getCursor(String string2, String[] stringArray) {
        DatabaseProvider databaseProvider;
        String string3 = "start_time_ms ASC";
        try {
            databaseProvider = this.databaseProvider;
        }
        catch (SQLiteException sQLiteException) {
            stringArray = new DatabaseIOException((SQLException)((Object)sQLiteException));
            throw stringArray;
        }
        databaseProvider = databaseProvider.getReadableDatabase();
        String string4 = this.tableName;
        String[] stringArray2 = COLUMNS;
        return databaseProvider.query(string4, stringArray2, string2, stringArray, null, null, string3);
    }

    private static Download getDownloadForCurrentRow(Cursor cursor) {
        long l10;
        int n10 = 14;
        float f10 = 2.0E-44f;
        Object object = cursor.getBlob(n10);
        int n11 = 0;
        Object object2 = cursor.getString(0);
        int n12 = 2;
        Object object3 = Uri.parse((String)cursor.getString(n12));
        DownloadRequest$Builder downloadRequest$Builder = new DownloadRequest$Builder((String)object2, (Uri)object3);
        object2 = cursor.getString(1);
        downloadRequest$Builder = downloadRequest$Builder.setMimeType((String)object2);
        object2 = DefaultDownloadIndex.decodeStreamKeys(cursor.getString(3));
        downloadRequest$Builder = downloadRequest$Builder.setStreamKeys((List)object2);
        int n13 = ((byte[])object).length;
        if (n13 <= 0) {
            n10 = 0;
            f10 = 0.0f;
            object = null;
        }
        object = downloadRequest$Builder.setKeySetId((byte[])object);
        int n14 = 4;
        object2 = cursor.getString(n14);
        object = ((DownloadRequest$Builder)object).setCustomCacheKey((String)object2);
        n13 = 5;
        object2 = cursor.getBlob(n13);
        object = ((DownloadRequest$Builder)object).setData((byte[])object2);
        object3 = ((DownloadRequest$Builder)object).build();
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.bytesDownloaded = l10 = cursor.getLong(13);
        downloadProgress.percentDownloaded = f10 = cursor.getFloat(12);
        n10 = 6;
        f10 = 8.4E-45f;
        int n15 = cursor.getInt(n10);
        if (n15 == n14) {
            n10 = 11;
            f10 = 1.5E-44f;
            n11 = cursor.getInt(n10);
        }
        long l11 = cursor.getLong(7);
        long l12 = cursor.getLong(8);
        long l13 = cursor.getLong(9);
        int n16 = cursor.getInt(10);
        object2 = object;
        object = new Download((DownloadRequest)object3, n15, l11, l12, l13, n16, n11, downloadProgress);
        return object;
    }

    private static Download getDownloadForCurrentRowV2(Cursor cursor) {
        float f10;
        long l10;
        int n10 = 0;
        Object object = cursor.getString(0);
        Object object2 = Uri.parse((String)cursor.getString(2));
        Object object3 = new DownloadRequest$Builder((String)object, (Uri)object2);
        object = DefaultDownloadIndex.inferMimeType(cursor.getString(1));
        object3 = ((DownloadRequest$Builder)object3).setMimeType((String)object);
        object = DefaultDownloadIndex.decodeStreamKeys(cursor.getString(3));
        object3 = ((DownloadRequest$Builder)object3).setStreamKeys((List)object);
        int n11 = 4;
        object2 = cursor.getString(n11);
        object3 = ((DownloadRequest$Builder)object3).setCustomCacheKey((String)object2);
        int n12 = 5;
        object2 = cursor.getBlob(n12);
        object3 = ((DownloadRequest$Builder)object3).setData((byte[])object2);
        DownloadRequest downloadRequest = ((DownloadRequest$Builder)object3).build();
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.bytesDownloaded = l10 = cursor.getLong(13);
        downloadProgress.percentDownloaded = f10 = cursor.getFloat(12);
        int n13 = 6;
        f10 = 8.4E-45f;
        int n14 = cursor.getInt(n13);
        if (n14 == n11) {
            n13 = 11;
            f10 = 1.5E-44f;
            n10 = cursor.getInt(n13);
        }
        long l11 = cursor.getLong(7);
        long l12 = cursor.getLong(8);
        long l13 = cursor.getLong(9);
        int n15 = cursor.getInt(10);
        object2 = object3;
        object3 = new Download(downloadRequest, n14, l11, l12, l13, n15, n10, downloadProgress);
        return object3;
    }

    private static String getStateQuery(int ... nArray) {
        int n10;
        int n11 = nArray.length;
        if (n11 == 0) {
            return TRUE;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(COLUMN_STATE);
        stringBuilder.append(" IN (");
        for (int i10 = 0; i10 < (n10 = nArray.length); ++i10) {
            if (i10 > 0) {
                n10 = 44;
                stringBuilder.append((char)n10);
            }
            n10 = nArray[i10];
            stringBuilder.append(n10);
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    private static String inferMimeType(String string2) {
        String string3 = "dash";
        boolean bl2 = string3.equals(string2);
        if (bl2) {
            return "application/dash+xml";
        }
        string3 = "hls";
        bl2 = string3.equals(string2);
        if (bl2) {
            return "application/x-mpegURL";
        }
        string3 = "ss";
        boolean bl3 = string3.equals(string2);
        if (bl3) {
            return "application/vnd.ms-sstr+xml";
        }
        return "video/x-unknown";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private List loadDownloadsFromVersion2(SQLiteDatabase sQLiteDatabase) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object = this.tableName;
        Object object2 = sQLiteDatabase;
        boolean bl2 = Util.tableExists(sQLiteDatabase, (String)object);
        if (!bl2) {
            return arrayList;
        }
        String string2 = COLUMN_START_TIME_MS;
        String string3 = COLUMN_UPDATE_TIME_MS;
        String string4 = COLUMN_CONTENT_LENGTH;
        String string5 = COLUMN_STOP_REASON;
        String string6 = COLUMN_FAILURE_REASON;
        String string7 = COLUMN_PERCENT_DOWNLOADED;
        String string8 = COLUMN_BYTES_DOWNLOADED;
        String[] stringArray = new String[]{COLUMN_ID, "title", COLUMN_URI, COLUMN_STREAM_KEYS, COLUMN_CUSTOM_CACHE_KEY, COLUMN_DATA, COLUMN_STATE, string2, string3, string4, string5, string6, string7, string8};
        String string9 = this.tableName;
        object = sQLiteDatabase.query(string9, stringArray, null, null, null, null, null);
        try {
            boolean bl3;
            while (bl3 = object.moveToNext()) {
                object2 = DefaultDownloadIndex.getDownloadForCurrentRowV2((Cursor)object);
                arrayList.add(object2);
            }
            if (object == null) return arrayList;
        }
        catch (Throwable throwable) {
            object2 = throwable;
            if (object == null) throw object2;
            try {
                object.close();
                throw object2;
            }
            catch (Throwable throwable2) {
                object = throwable2;
                ((Throwable)object2).addSuppressed(throwable2);
            }
            throw object2;
        }
        object.close();
        return arrayList;
    }

    private void putDownloadInternal(Download object, SQLiteDatabase sQLiteDatabase) {
        byte[] byArray = object.request.keySetId;
        if (byArray == null) {
            byArray = Util.EMPTY_BYTE_ARRAY;
        }
        ContentValues contentValues = new ContentValues();
        Object object2 = object.request.id;
        contentValues.put(COLUMN_ID, (String)object2);
        object2 = object.request.mimeType;
        contentValues.put(COLUMN_MIME_TYPE, (String)object2);
        object2 = object.request.uri.toString();
        contentValues.put(COLUMN_URI, (String)object2);
        object2 = DefaultDownloadIndex.encodeStreamKeys(object.request.streamKeys);
        contentValues.put(COLUMN_STREAM_KEYS, (String)object2);
        object2 = object.request.customCacheKey;
        contentValues.put(COLUMN_CUSTOM_CACHE_KEY, (String)object2);
        object2 = object.request.data;
        contentValues.put(COLUMN_DATA, (byte[])object2);
        object2 = ((Download)object).state;
        contentValues.put(COLUMN_STATE, (Integer)object2);
        object2 = ((Download)object).startTimeMs;
        contentValues.put(COLUMN_START_TIME_MS, (Long)object2);
        object2 = ((Download)object).updateTimeMs;
        contentValues.put(COLUMN_UPDATE_TIME_MS, (Long)object2);
        object2 = ((Download)object).contentLength;
        contentValues.put(COLUMN_CONTENT_LENGTH, (Long)object2);
        object2 = ((Download)object).stopReason;
        contentValues.put(COLUMN_STOP_REASON, (Integer)object2);
        object2 = ((Download)object).failureReason;
        contentValues.put(COLUMN_FAILURE_REASON, (Integer)object2);
        object2 = Float.valueOf(((Download)object).getPercentDownloaded());
        contentValues.put(COLUMN_PERCENT_DOWNLOADED, (Float)object2);
        object = ((Download)object).getBytesDownloaded();
        contentValues.put(COLUMN_BYTES_DOWNLOADED, (Long)object);
        contentValues.put(COLUMN_KEY_SET_ID, byArray);
        object = this.tableName;
        sQLiteDatabase.replaceOrThrow((String)object, null, contentValues);
    }

    /*
     * Exception decompiling
     */
    public Download getDownload(String var1_1) {
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

    public DownloadCursor getDownloads(int ... object) {
        this.ensureInitialized();
        object = DefaultDownloadIndex.getStateQuery(object);
        object = this.getCursor((String)object, null);
        DefaultDownloadIndex$DownloadCursorImpl defaultDownloadIndex$DownloadCursorImpl = new DefaultDownloadIndex$DownloadCursorImpl((Cursor)object, null);
        return defaultDownloadIndex$DownloadCursorImpl;
    }

    public void putDownload(Download download) {
        Object object;
        this.ensureInitialized();
        try {
            object = this.databaseProvider;
        }
        catch (SQLiteException sQLiteException) {
            object = new DatabaseIOException((SQLException)((Object)sQLiteException));
            throw object;
        }
        object = object.getWritableDatabase();
        this.putDownloadInternal(download, (SQLiteDatabase)object);
    }

    public void removeDownload(String string2) {
        Object object;
        this.ensureInitialized();
        try {
            object = this.databaseProvider;
        }
        catch (SQLiteException sQLiteException) {
            object = new DatabaseIOException((SQLException)((Object)sQLiteException));
            throw object;
        }
        object = object.getWritableDatabase();
        String string3 = this.tableName;
        String string4 = WHERE_ID_EQUALS;
        int n10 = 1;
        String[] stringArray = new String[n10];
        stringArray[0] = string2;
        object.delete(string3, string4, stringArray);
    }

    public void setDownloadingStatesToQueued() {
        Object object;
        Object object2;
        ContentValues contentValues;
        this.ensureInitialized();
        try {
            contentValues = new ContentValues();
            object2 = COLUMN_STATE;
            object = null;
        }
        catch (SQLException sQLException) {
            object2 = new DatabaseIOException(sQLException);
            throw object2;
        }
        object = 0;
        contentValues.put((String)object2, (Integer)object);
        object2 = this.databaseProvider;
        object2 = object2.getWritableDatabase();
        object = this.tableName;
        String string2 = WHERE_STATE_IS_DOWNLOADING;
        object2.update((String)object, contentValues, string2, null);
    }

    public void setStatesToRemoving() {
        int n10;
        Object object;
        ContentValues contentValues;
        this.ensureInitialized();
        try {
            contentValues = new ContentValues();
            object = COLUMN_STATE;
            n10 = 5;
        }
        catch (SQLException sQLException) {
            object = new DatabaseIOException(sQLException);
            throw object;
        }
        Object object2 = n10;
        contentValues.put((String)object, (Integer)object2);
        object = COLUMN_FAILURE_REASON;
        n10 = 0;
        object2 = null;
        object2 = 0;
        contentValues.put((String)object, (Integer)object2);
        object = this.databaseProvider;
        object = object.getWritableDatabase();
        object2 = this.tableName;
        object.update((String)object2, contentValues, null, null);
    }

    public void setStopReason(int n10) {
        String string2;
        Object object;
        this.ensureInitialized();
        try {
            object = new ContentValues();
            string2 = COLUMN_STOP_REASON;
        }
        catch (SQLException sQLException) {
            object = new DatabaseIOException(sQLException);
            throw object;
        }
        Object object2 = n10;
        object.put(string2, (Integer)object2);
        object2 = this.databaseProvider;
        object2 = object2.getWritableDatabase();
        string2 = this.tableName;
        String string3 = WHERE_STATE_IS_TERMINAL;
        object2.update(string2, object, string3, null);
    }

    public void setStopReason(String string2, int n10) {
        Object object;
        String string3;
        ContentValues contentValues;
        this.ensureInitialized();
        try {
            contentValues = new ContentValues();
            string3 = COLUMN_STOP_REASON;
        }
        catch (SQLException sQLException) {
            object = new DatabaseIOException(sQLException);
            throw object;
        }
        object = n10;
        contentValues.put(string3, (Integer)object);
        object = this.databaseProvider;
        object = object.getWritableDatabase();
        string3 = this.tableName;
        String string4 = WHERE_STATE_IS_TERMINAL;
        String[] stringArray = String.valueOf(string4);
        int n11 = stringArray.length() + 11;
        StringBuilder stringBuilder = new StringBuilder(n11);
        stringBuilder.append(string4);
        string4 = " AND ";
        stringBuilder.append(string4);
        string4 = WHERE_ID_EQUALS;
        stringBuilder.append(string4);
        string4 = stringBuilder.toString();
        n11 = 1;
        stringArray = new String[n11];
        stringBuilder = null;
        stringArray[0] = string2;
        object.update(string3, contentValues, string4, stringArray);
    }
}

