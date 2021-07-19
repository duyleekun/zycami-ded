/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.room;

import android.content.Context;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.AutoCloser;
import androidx.room.AutoClosingRoomOpenHelperFactory;
import androidx.room.DatabaseConfiguration;
import androidx.room.QueryInterceptorOpenHelperFactory;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabase$Callback;
import androidx.room.RoomDatabase$JournalMode;
import androidx.room.RoomDatabase$MigrationContainer;
import androidx.room.RoomDatabase$PrepackagedDatabaseCallback;
import androidx.room.RoomDatabase$QueryCallback;
import androidx.room.SQLiteCopyOpenHelperFactory;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Factory;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class RoomDatabase$Builder {
    private boolean mAllowDestructiveMigrationOnDowngrade;
    private boolean mAllowMainThreadQueries;
    private TimeUnit mAutoCloseTimeUnit;
    private long mAutoCloseTimeout = -1;
    private ArrayList mCallbacks;
    private final Context mContext;
    private String mCopyFromAssetPath;
    private File mCopyFromFile;
    private Callable mCopyFromInputStream;
    private final Class mDatabaseClass;
    private SupportSQLiteOpenHelper$Factory mFactory;
    private RoomDatabase$JournalMode mJournalMode;
    private final RoomDatabase$MigrationContainer mMigrationContainer;
    private Set mMigrationStartAndEndVersions;
    private Set mMigrationsNotRequiredFrom;
    private boolean mMultiInstanceInvalidation;
    private final String mName;
    private RoomDatabase$PrepackagedDatabaseCallback mPrepackagedDatabaseCallback;
    private RoomDatabase$QueryCallback mQueryCallback;
    private Executor mQueryCallbackExecutor;
    private Executor mQueryExecutor;
    private boolean mRequireMigration;
    private Executor mTransactionExecutor;
    private List mTypeConverters;

    public RoomDatabase$Builder(Context object, Class clazz, String string2) {
        this.mContext = object;
        this.mDatabaseClass = clazz;
        this.mName = string2;
        object = RoomDatabase$JournalMode.AUTOMATIC;
        this.mJournalMode = object;
        this.mRequireMigration = true;
        this.mMigrationContainer = object;
    }

    public RoomDatabase$Builder addCallback(RoomDatabase$Callback roomDatabase$Callback) {
        ArrayList arrayList = this.mCallbacks;
        if (arrayList == null) {
            this.mCallbacks = arrayList = new ArrayList();
        }
        this.mCallbacks.add(roomDatabase$Callback);
        return this;
    }

    public RoomDatabase$Builder addMigrations(Migration ... migrationArray) {
        HashSet hashSet = this.mMigrationStartAndEndVersions;
        if (hashSet == null) {
            this.mMigrationStartAndEndVersions = hashSet = new HashSet();
        }
        int n10 = migrationArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = migrationArray[i10];
            Set set = this.mMigrationStartAndEndVersions;
            int n11 = ((Migration)object).startVersion;
            Integer n12 = n11;
            set.add(n12);
            set = this.mMigrationStartAndEndVersions;
            int n13 = ((Migration)object).endVersion;
            object = n13;
            set.add(object);
        }
        this.mMigrationContainer.addMigrations(migrationArray);
        return this;
    }

    public RoomDatabase$Builder addTypeConverter(Object object) {
        ArrayList arrayList = this.mTypeConverters;
        if (arrayList == null) {
            this.mTypeConverters = arrayList = new ArrayList();
        }
        this.mTypeConverters.add(object);
        return this;
    }

    public RoomDatabase$Builder allowMainThreadQueries() {
        this.mAllowMainThreadQueries = true;
        return this;
    }

    public RoomDatabase build() {
        Object object;
        block21: {
            block22: {
                block24: {
                    block25: {
                        Object object2;
                        Object object3;
                        Object object4;
                        Object object5;
                        Object object6;
                        Object object7;
                        boolean bl2;
                        Object object8;
                        RoomDatabase$Builder roomDatabase$Builder;
                        block23: {
                            int n10;
                            int n11;
                            long l10;
                            long l11;
                            long l12;
                            long l13;
                            int n12;
                            roomDatabase$Builder = this;
                            object = this.mContext;
                            if (object == null) break block21;
                            object = this.mDatabaseClass;
                            if (object == null) break block22;
                            object = this.mQueryExecutor;
                            if (object == null && (object8 = this.mTransactionExecutor) == null) {
                                object = ArchTaskExecutor.getIOThreadExecutor();
                                this.mTransactionExecutor = object;
                                this.mQueryExecutor = object;
                            } else if (object != null && (object8 = roomDatabase$Builder.mTransactionExecutor) == null) {
                                roomDatabase$Builder.mTransactionExecutor = object;
                            } else if (object == null && (object = roomDatabase$Builder.mTransactionExecutor) != null) {
                                roomDatabase$Builder.mQueryExecutor = object;
                            }
                            object = roomDatabase$Builder.mMigrationStartAndEndVersions;
                            if (object != null && (object8 = roomDatabase$Builder.mMigrationsNotRequiredFrom) != null) {
                                object = object.iterator();
                                while (bl2 = object.hasNext()) {
                                    object7 = roomDatabase$Builder.mMigrationsNotRequiredFrom;
                                    object8 = (Integer)object.next();
                                    n12 = (int)(object7.contains(object8) ? 1 : 0);
                                    if (n12 == 0) continue;
                                    object7 = new StringBuilder();
                                    ((StringBuilder)object7).append("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ");
                                    ((StringBuilder)object7).append(object8);
                                    object8 = ((StringBuilder)object7).toString();
                                    object = new IllegalArgumentException((String)object8);
                                    throw object;
                                }
                            }
                            if ((object = roomDatabase$Builder.mFactory) == null) {
                                object = new FrameworkSQLiteOpenHelperFactory();
                            }
                            if ((l13 = (l12 = (l11 = roomDatabase$Builder.mAutoCloseTimeout) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                                object6 = roomDatabase$Builder.mName;
                                if (object6 != null) {
                                    object5 = roomDatabase$Builder.mAutoCloseTimeUnit;
                                    object4 = roomDatabase$Builder.mTransactionExecutor;
                                    object6 = new AutoCloser(l11, (TimeUnit)((Object)object5), (Executor)object4);
                                    object = object8 = new AutoClosingRoomOpenHelperFactory((SupportSQLiteOpenHelper$Factory)object, (AutoCloser)object6);
                                } else {
                                    object = new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                                    throw object;
                                }
                            }
                            if ((object8 = roomDatabase$Builder.mCopyFromAssetPath) == null && (object7 = roomDatabase$Builder.mCopyFromFile) == null && (object7 = roomDatabase$Builder.mCopyFromInputStream) == null) break block23;
                            object7 = roomDatabase$Builder.mName;
                            if (object7 == null) break block24;
                            n12 = 0;
                            object7 = null;
                            l13 = 1;
                            if (object8 == null) {
                                n11 = 0;
                                object5 = null;
                            } else {
                                n11 = l13;
                            }
                            object4 = roomDatabase$Builder.mCopyFromFile;
                            if (object4 == null) {
                                n10 = 0;
                                object3 = null;
                            } else {
                                n10 = l13;
                            }
                            n11 += n10;
                            object3 = roomDatabase$Builder.mCopyFromInputStream;
                            if (object3 != null) {
                                n12 = l13;
                            }
                            if ((n11 += n12) != l13) break block25;
                            object = object7 = new SQLiteCopyOpenHelperFactory((String)object8, (File)object4, (Callable)object3, (SupportSQLiteOpenHelper$Factory)object);
                        }
                        if ((object8 = roomDatabase$Builder.mQueryCallback) != null) {
                            object6 = roomDatabase$Builder.mQueryCallbackExecutor;
                            object2 = object7 = new QueryInterceptorOpenHelperFactory((SupportSQLiteOpenHelper$Factory)object, (RoomDatabase$QueryCallback)object8, (Executor)object6);
                        } else {
                            object2 = object;
                        }
                        object5 = object;
                        object4 = object8 = roomDatabase$Builder.mContext;
                        object3 = roomDatabase$Builder.mName;
                        RoomDatabase$MigrationContainer roomDatabase$MigrationContainer = roomDatabase$Builder.mMigrationContainer;
                        ArrayList arrayList = roomDatabase$Builder.mCallbacks;
                        boolean bl3 = roomDatabase$Builder.mAllowMainThreadQueries;
                        RoomDatabase$JournalMode roomDatabase$JournalMode = roomDatabase$Builder.mJournalMode.resolve((Context)object8);
                        Executor executor = roomDatabase$Builder.mQueryExecutor;
                        Executor executor2 = roomDatabase$Builder.mTransactionExecutor;
                        boolean bl4 = roomDatabase$Builder.mMultiInstanceInvalidation;
                        boolean bl5 = roomDatabase$Builder.mRequireMigration;
                        bl2 = roomDatabase$Builder.mAllowDestructiveMigrationOnDowngrade;
                        Set set = roomDatabase$Builder.mMigrationsNotRequiredFrom;
                        String string2 = roomDatabase$Builder.mCopyFromAssetPath;
                        File file = roomDatabase$Builder.mCopyFromFile;
                        Callable callable = roomDatabase$Builder.mCopyFromInputStream;
                        RoomDatabase$PrepackagedDatabaseCallback roomDatabase$PrepackagedDatabaseCallback = roomDatabase$Builder.mPrepackagedDatabaseCallback;
                        object8 = roomDatabase$Builder.mTypeConverters;
                        object = new DatabaseConfiguration((Context)object4, (String)object3, (SupportSQLiteOpenHelper$Factory)object2, roomDatabase$MigrationContainer, arrayList, bl3, roomDatabase$JournalMode, executor, executor2, bl4, bl5, bl2, set, string2, file, callable, roomDatabase$PrepackagedDatabaseCallback, (List)object8);
                        object8 = (RoomDatabase)Room.getGeneratedImplementation(roomDatabase$Builder.mDatabaseClass, "_Impl");
                        ((RoomDatabase)object8).init((DatabaseConfiguration)object);
                        return object8;
                    }
                    object = new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                    throw object;
                }
                object = new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                throw object;
            }
            object = new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            throw object;
        }
        object = new IllegalArgumentException("Cannot provide null context for the database.");
        throw object;
    }

    public RoomDatabase$Builder createFromAsset(String string2) {
        this.mCopyFromAssetPath = string2;
        return this;
    }

    public RoomDatabase$Builder createFromAsset(String string2, RoomDatabase$PrepackagedDatabaseCallback roomDatabase$PrepackagedDatabaseCallback) {
        this.mPrepackagedDatabaseCallback = roomDatabase$PrepackagedDatabaseCallback;
        this.mCopyFromAssetPath = string2;
        return this;
    }

    public RoomDatabase$Builder createFromFile(File file) {
        this.mCopyFromFile = file;
        return this;
    }

    public RoomDatabase$Builder createFromFile(File file, RoomDatabase$PrepackagedDatabaseCallback roomDatabase$PrepackagedDatabaseCallback) {
        this.mPrepackagedDatabaseCallback = roomDatabase$PrepackagedDatabaseCallback;
        this.mCopyFromFile = file;
        return this;
    }

    public RoomDatabase$Builder createFromInputStream(Callable callable) {
        this.mCopyFromInputStream = callable;
        return this;
    }

    public RoomDatabase$Builder createFromInputStream(Callable callable, RoomDatabase$PrepackagedDatabaseCallback roomDatabase$PrepackagedDatabaseCallback) {
        this.mPrepackagedDatabaseCallback = roomDatabase$PrepackagedDatabaseCallback;
        this.mCopyFromInputStream = callable;
        return this;
    }

    public RoomDatabase$Builder enableMultiInstanceInvalidation() {
        boolean bl2;
        String string2 = this.mName;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        this.mMultiInstanceInvalidation = bl2;
        return this;
    }

    public RoomDatabase$Builder fallbackToDestructiveMigration() {
        this.mRequireMigration = false;
        this.mAllowDestructiveMigrationOnDowngrade = true;
        return this;
    }

    public RoomDatabase$Builder fallbackToDestructiveMigrationFrom(int ... nArray) {
        HashSet hashSet = this.mMigrationsNotRequiredFrom;
        if (hashSet == null) {
            int n10 = nArray.length;
            this.mMigrationsNotRequiredFrom = hashSet = new HashSet(n10);
        }
        for (int n11 : nArray) {
            Set set = this.mMigrationsNotRequiredFrom;
            Integer n12 = n11;
            set.add(n12);
        }
        return this;
    }

    public RoomDatabase$Builder fallbackToDestructiveMigrationOnDowngrade() {
        boolean bl2;
        this.mRequireMigration = bl2 = true;
        this.mAllowDestructiveMigrationOnDowngrade = bl2;
        return this;
    }

    public RoomDatabase$Builder openHelperFactory(SupportSQLiteOpenHelper$Factory supportSQLiteOpenHelper$Factory) {
        this.mFactory = supportSQLiteOpenHelper$Factory;
        return this;
    }

    public RoomDatabase$Builder setAutoCloseTimeout(long l10, TimeUnit timeUnit) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            this.mAutoCloseTimeout = l10;
            this.mAutoCloseTimeUnit = timeUnit;
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("autoCloseTimeout must be >= 0");
        throw illegalArgumentException;
    }

    public RoomDatabase$Builder setJournalMode(RoomDatabase$JournalMode roomDatabase$JournalMode) {
        this.mJournalMode = roomDatabase$JournalMode;
        return this;
    }

    public RoomDatabase$Builder setQueryCallback(RoomDatabase$QueryCallback roomDatabase$QueryCallback, Executor executor) {
        this.mQueryCallback = roomDatabase$QueryCallback;
        this.mQueryCallbackExecutor = executor;
        return this;
    }

    public RoomDatabase$Builder setQueryExecutor(Executor executor) {
        this.mQueryExecutor = executor;
        return this;
    }

    public RoomDatabase$Builder setTransactionExecutor(Executor executor) {
        this.mTransactionExecutor = executor;
        return this;
    }
}

