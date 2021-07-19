/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase$JournalMode;
import androidx.room.RoomDatabase$MigrationContainer;
import androidx.room.RoomDatabase$PrepackagedDatabaseCallback;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Factory;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List callbacks;
    public final Context context;
    public final String copyFromAssetPath;
    public final File copyFromFile;
    public final Callable copyFromInputStream;
    public final RoomDatabase$JournalMode journalMode;
    private final Set mMigrationNotRequiredFrom;
    public final RoomDatabase$MigrationContainer migrationContainer;
    public final boolean multiInstanceInvalidation;
    public final String name;
    public final RoomDatabase$PrepackagedDatabaseCallback prepackagedDatabaseCallback;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SupportSQLiteOpenHelper$Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;
    public final List typeConverters;

    public DatabaseConfiguration(Context context, String string2, SupportSQLiteOpenHelper$Factory factory, RoomDatabase$MigrationContainer migrationContainer, List list, boolean bl2, RoomDatabase$JournalMode journalMode, Executor executor, Executor executor2, boolean bl3, boolean bl4, boolean bl5, Set set) {
        this(context, string2, factory, migrationContainer, list, bl2, journalMode, executor, executor2, bl3, bl4, bl5, set, null, null, null, null, null);
    }

    public DatabaseConfiguration(Context context, String string2, SupportSQLiteOpenHelper$Factory factory, RoomDatabase$MigrationContainer migrationContainer, List list, boolean bl2, RoomDatabase$JournalMode journalMode, Executor executor, Executor executor2, boolean bl3, boolean bl4, boolean bl5, Set set, String string3, File file) {
        this(context, string2, factory, migrationContainer, list, bl2, journalMode, executor, executor2, bl3, bl4, bl5, set, string3, file, null, null, null);
    }

    public DatabaseConfiguration(Context context, String string2, SupportSQLiteOpenHelper$Factory factory, RoomDatabase$MigrationContainer migrationContainer, List list, boolean bl2, RoomDatabase$JournalMode journalMode, Executor executor, Executor executor2, boolean bl3, boolean bl4, boolean bl5, Set set, String string3, File file, Callable callable) {
        this(context, string2, factory, migrationContainer, list, bl2, journalMode, executor, executor2, bl3, bl4, bl5, set, string3, file, callable, null, null);
    }

    public DatabaseConfiguration(Context context, String string2, SupportSQLiteOpenHelper$Factory factory, RoomDatabase$MigrationContainer migrationContainer, List list, boolean bl2, RoomDatabase$JournalMode journalMode, Executor executor, Executor executor2, boolean bl3, boolean bl4, boolean bl5, Set set, String string3, File file, Callable callable, RoomDatabase$PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
        this(context, string2, factory, migrationContainer, list, bl2, journalMode, executor, executor2, bl3, bl4, bl5, set, string3, file, callable, prepackagedDatabaseCallback, null);
    }

    public DatabaseConfiguration(Context context, String string2, SupportSQLiteOpenHelper$Factory supportSQLiteOpenHelper$Factory, RoomDatabase$MigrationContainer roomDatabase$MigrationContainer, List list, boolean bl2, RoomDatabase$JournalMode roomDatabase$JournalMode, Executor executor, Executor executor2, boolean bl3, boolean bl4, boolean bl5, Set set, String string3, File file, Callable callable, RoomDatabase$PrepackagedDatabaseCallback roomDatabase$PrepackagedDatabaseCallback, List list2) {
        DatabaseConfiguration databaseConfiguration = this;
        List list3 = supportSQLiteOpenHelper$Factory;
        this.sqliteOpenHelperFactory = supportSQLiteOpenHelper$Factory;
        list3 = context;
        this.context = context;
        list3 = string2;
        this.name = string2;
        list3 = roomDatabase$MigrationContainer;
        this.migrationContainer = roomDatabase$MigrationContainer;
        list3 = list;
        this.callbacks = list;
        this.allowMainThreadQueries = bl2;
        list3 = roomDatabase$JournalMode;
        this.journalMode = roomDatabase$JournalMode;
        list3 = executor;
        this.queryExecutor = executor;
        list3 = executor2;
        this.transactionExecutor = executor2;
        this.multiInstanceInvalidation = bl3;
        this.requireMigration = bl4;
        this.allowDestructiveMigrationOnDowngrade = bl5;
        list3 = set;
        this.mMigrationNotRequiredFrom = set;
        list3 = string3;
        this.copyFromAssetPath = string3;
        list3 = file;
        this.copyFromFile = file;
        list3 = callable;
        this.copyFromInputStream = callable;
        list3 = roomDatabase$PrepackagedDatabaseCallback;
        this.prepackagedDatabaseCallback = roomDatabase$PrepackagedDatabaseCallback;
        list3 = list2 == null ? Collections.emptyList() : list2;
        databaseConfiguration.typeConverters = list3;
    }

    public DatabaseConfiguration(Context context, String string2, SupportSQLiteOpenHelper$Factory supportSQLiteOpenHelper$Factory, RoomDatabase$MigrationContainer roomDatabase$MigrationContainer, List list, boolean bl2, RoomDatabase$JournalMode roomDatabase$JournalMode, Executor executor, boolean bl3, Set set) {
        this(context, string2, supportSQLiteOpenHelper$Factory, roomDatabase$MigrationContainer, list, bl2, roomDatabase$JournalMode, executor, executor, false, bl3, false, set, null, null, null, null, null);
    }

    /*
     * WARNING - void declaration
     */
    public boolean isMigrationRequired(int n10, int n11) {
        Integer n12;
        boolean bl2;
        void var2_5;
        Set set;
        boolean bl3 = true;
        if (n10 > n11) {
            boolean bl4 = bl3;
        } else {
            boolean bl5 = false;
            set = null;
        }
        if (var2_5 != false && (bl2 = this.allowDestructiveMigrationOnDowngrade)) {
            return false;
        }
        boolean bl6 = this.requireMigration;
        if (!bl6 || (set = this.mMigrationNotRequiredFrom) != null && (n10 = (int)(set.contains(n12 = Integer.valueOf(n10)) ? 1 : 0)) != 0) {
            bl3 = false;
        }
        return bl3;
    }

    public boolean isMigrationRequiredFrom(int n10) {
        int n11 = n10 + 1;
        return this.isMigrationRequired(n10, n11);
    }
}

