/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.room;

import android.content.Context;
import androidx.room.DatabaseConfiguration;
import androidx.room.DelegatingOpenHelper;
import androidx.room.SQLiteCopyOpenHelper$1;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration$Builder;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

public class SQLiteCopyOpenHelper
implements SupportSQLiteOpenHelper,
DelegatingOpenHelper {
    private final Context mContext;
    private final String mCopyFromAssetPath;
    private final File mCopyFromFile;
    private final Callable mCopyFromInputStream;
    private DatabaseConfiguration mDatabaseConfiguration;
    private final int mDatabaseVersion;
    private final SupportSQLiteOpenHelper mDelegate;
    private boolean mVerified;

    public SQLiteCopyOpenHelper(Context context, String string2, File file, Callable callable, int n10, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        this.mContext = context;
        this.mCopyFromAssetPath = string2;
        this.mCopyFromFile = file;
        this.mCopyFromInputStream = callable;
        this.mDatabaseVersion = n10;
        this.mDelegate = supportSQLiteOpenHelper;
    }

    private void copyDatabaseFile(File object, boolean bl2) {
        block11: {
            boolean bl3;
            boolean bl4;
            Object object2;
            Object object3;
            block9: {
                block10: {
                    block8: {
                        object3 = this.mCopyFromAssetPath;
                        if (object3 == null) break block8;
                        object3 = this.mContext.getAssets();
                        object2 = this.mCopyFromAssetPath;
                        object3 = Channels.newChannel(object3.open((String)object2));
                        break block9;
                    }
                    object3 = this.mCopyFromFile;
                    if (object3 == null) break block10;
                    object2 = this.mCopyFromFile;
                    object3 = new FileInputStream((File)object2);
                    object3 = ((FileInputStream)object3).getChannel();
                    break block9;
                }
                object3 = this.mCopyFromInputStream;
                if (object3 == null) break block11;
                try {
                    object3 = object3.call();
                }
                catch (Exception exception) {
                    IOException iOException = new IOException("inputStreamCallable exception on call", exception);
                    throw iOException;
                }
                object3 = Channels.newChannel((InputStream)object3);
            }
            object2 = this.mContext.getCacheDir();
            String string2 = ".tmp";
            object2 = File.createTempFile("room-copy-helper", string2, (File)object2);
            ((File)object2).deleteOnExit();
            Closeable closeable = new FileOutputStream((File)object2);
            closeable = closeable.getChannel();
            FileUtil.copy((ReadableByteChannel)object3, (FileChannel)closeable);
            object3 = ((File)object).getParentFile();
            if (object3 != null && !(bl4 = ((File)object3).exists()) && !(bl3 = ((File)object3).mkdirs())) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("Failed to create directories for ");
                object = ((File)object).getAbsolutePath();
                ((StringBuilder)object3).append((String)object);
                object = ((StringBuilder)object3).toString();
                IOException iOException = new IOException((String)object);
                throw iOException;
            }
            this.dispatchOnOpenPrepackagedDatabase((File)object2, bl2);
            bl2 = ((File)object2).renameTo((File)object);
            if (bl2) {
                return;
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Failed to move intermediate file (");
            object2 = ((File)object2).getAbsolutePath();
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(") to destination (");
            object = ((File)object).getAbsolutePath();
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append(").");
            object = ((StringBuilder)object3).toString();
            IOException iOException = new IOException((String)object);
            throw iOException;
        }
        object = new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
        throw object;
    }

    private SupportSQLiteOpenHelper createFrameworkOpenHelper(File object) {
        Object object2 = ((File)object).getName();
        try {
            int n10 = DBUtil.readVersion((File)object);
            FrameworkSQLiteOpenHelperFactory frameworkSQLiteOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
            object2 = SupportSQLiteOpenHelper$Configuration.builder(this.mContext).name((String)object2);
            SQLiteCopyOpenHelper$1 sQLiteCopyOpenHelper$1 = new SQLiteCopyOpenHelper$1(this, n10);
            object = ((SupportSQLiteOpenHelper$Configuration$Builder)object2).callback(sQLiteCopyOpenHelper$1).build();
            return frameworkSQLiteOpenHelperFactory.create((SupportSQLiteOpenHelper$Configuration)object);
        }
        catch (IOException iOException) {
            object2 = new RuntimeException("Malformed database file, unable to read version.", iOException);
            throw object2;
        }
    }

    /*
     * Unable to fully structure code
     */
    private void dispatchOnOpenPrepackagedDatabase(File var1_1, boolean var2_2) {
        block7: {
            block8: {
                var3_3 = this.mDatabaseConfiguration;
                if (var3_3 == null || (var3_3 = var3_3.prepackagedDatabaseCallback) == null) break block7;
                var1_1 = this.createFrameworkOpenHelper((File)var1_1);
                if (!var2_2) break block8;
                var4_4 = var1_1.getWritableDatabase();
                ** break block9
            }
            var4_4 = var1_1.getReadableDatabase();
lbl-1000:
            // 2 sources

            {
                var3_3 = this.mDatabaseConfiguration;
                var3_3 = var3_3.prepackagedDatabaseCallback;
                var3_3.onOpenPrepackagedDatabase(var4_4);
                return;
            }
            finally {
                var1_1.close();
            }
        }
    }

    /*
     * Exception decompiling
     */
    private void verifyDatabaseFile(boolean var1_1) {
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

    public void close() {
        synchronized (this) {
            SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.mDelegate;
            supportSQLiteOpenHelper.close();
            supportSQLiteOpenHelper = null;
            this.mVerified = false;
            return;
        }
    }

    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegate;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SupportSQLiteDatabase getReadableDatabase() {
        synchronized (this) {
            boolean bl2 = this.mVerified;
            if (!bl2) {
                bl2 = false;
                Object var2_2 = null;
                this.verifyDatabaseFile(false);
                this.mVerified = bl2 = true;
            }
            SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.mDelegate;
            return supportSQLiteOpenHelper.getReadableDatabase();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SupportSQLiteDatabase getWritableDatabase() {
        synchronized (this) {
            boolean bl2 = this.mVerified;
            if (!bl2) {
                bl2 = true;
                this.verifyDatabaseFile(bl2);
                this.mVerified = bl2;
            }
            SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.mDelegate;
            return supportSQLiteOpenHelper.getWritableDatabase();
        }
    }

    public void setDatabaseConfiguration(DatabaseConfiguration databaseConfiguration) {
        this.mDatabaseConfiguration = databaseConfiguration;
    }

    public void setWriteAheadLoggingEnabled(boolean bl2) {
        this.mDelegate.setWriteAheadLoggingEnabled(bl2);
    }
}

