/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.DatabaseConfiguration;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper$Delegate;
import androidx.room.RoomOpenHelper$ValidationResult;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Callback;

public class RoomOpenHelper
extends SupportSQLiteOpenHelper$Callback {
    private DatabaseConfiguration mConfiguration;
    private final RoomOpenHelper$Delegate mDelegate;
    private final String mIdentityHash;
    private final String mLegacyHash;

    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, RoomOpenHelper$Delegate roomOpenHelper$Delegate, String string2) {
        this(databaseConfiguration, roomOpenHelper$Delegate, "", string2);
    }

    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, RoomOpenHelper$Delegate roomOpenHelper$Delegate, String string2, String string3) {
        int n10 = roomOpenHelper$Delegate.version;
        super(n10);
        this.mConfiguration = databaseConfiguration;
        this.mDelegate = roomOpenHelper$Delegate;
        this.mIdentityHash = string2;
        this.mLegacyHash = string3;
    }

    private void checkIdentity(SupportSQLiteDatabase object) {
        Object object2;
        block12: {
            block11: {
                block10: {
                    boolean bl2;
                    String string2;
                    block9: {
                        boolean bl3 = RoomOpenHelper.hasRoomMasterTable((SupportSQLiteDatabase)object);
                        if (!bl3) break block10;
                        bl3 = false;
                        string2 = null;
                        String string3 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1";
                        SimpleSQLiteQuery simpleSQLiteQuery = new SimpleSQLiteQuery(string3);
                        object = object.query(simpleSQLiteQuery);
                        boolean bl4 = object.moveToFirst();
                        if (!bl4) break block9;
                        bl3 = false;
                        string2 = null;
                        string2 = object.getString(0);
                    }
                    if (!(bl2 = ((String)(object = this.mIdentityHash)).equals(string2)) && !(bl2 = ((String)(object = this.mLegacyHash)).equals(string2))) {
                        object = new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                        throw object;
                    }
                    break block11;
                    finally {
                        object.close();
                    }
                }
                object2 = this.mDelegate.onValidateSchema((SupportSQLiteDatabase)object);
                boolean bl5 = ((RoomOpenHelper$ValidationResult)object2).isValid;
                if (!bl5) break block12;
                object2 = this.mDelegate;
                ((RoomOpenHelper$Delegate)object2).onPostMigrate((SupportSQLiteDatabase)object);
                this.updateIdentity((SupportSQLiteDatabase)object);
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pre-packaged database has an invalid schema: ");
        object2 = ((RoomOpenHelper$ValidationResult)object2).expectedFoundMsg;
        stringBuilder.append((String)object2);
        object2 = stringBuilder.toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    private void createMasterTableIfNotExists(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean hasEmptySchema(SupportSQLiteDatabase supportSQLiteDatabase) {
        boolean bl2;
        block3: {
            int n10;
            String string2 = "SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'";
            supportSQLiteDatabase = supportSQLiteDatabase.query(string2);
            try {
                n10 = supportSQLiteDatabase.moveToFirst();
                bl2 = false;
                if (n10 == 0) break block3;
            }
            catch (Throwable throwable) {
                supportSQLiteDatabase.close();
                throw throwable;
            }
            n10 = supportSQLiteDatabase.getInt(0);
            if (n10 != 0) break block3;
            bl2 = true;
        }
        supportSQLiteDatabase.close();
        return bl2;
    }

    private static boolean hasRoomMasterTable(SupportSQLiteDatabase supportSQLiteDatabase) {
        boolean bl2;
        block3: {
            int n10;
            String string2 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'";
            supportSQLiteDatabase = supportSQLiteDatabase.query(string2);
            try {
                n10 = supportSQLiteDatabase.moveToFirst();
                bl2 = false;
                if (n10 == 0) break block3;
            }
            catch (Throwable throwable) {
                supportSQLiteDatabase.close();
                throw throwable;
            }
            n10 = supportSQLiteDatabase.getInt(0);
            if (n10 == 0) break block3;
            bl2 = true;
        }
        supportSQLiteDatabase.close();
        return bl2;
    }

    private void updateIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        this.createMasterTableIfNotExists(supportSQLiteDatabase);
        String string2 = RoomMasterTable.createInsertQuery(this.mIdentityHash);
        supportSQLiteDatabase.execSQL(string2);
    }

    public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.onConfigure(supportSQLiteDatabase);
    }

    public void onCreate(SupportSQLiteDatabase object) {
        boolean bl2 = RoomOpenHelper.hasEmptySchema((SupportSQLiteDatabase)object);
        Object object2 = this.mDelegate;
        ((RoomOpenHelper$Delegate)object2).createAllTables((SupportSQLiteDatabase)object);
        if (!bl2) {
            Object object3 = this.mDelegate.onValidateSchema((SupportSQLiteDatabase)object);
            boolean bl3 = ((RoomOpenHelper$ValidationResult)object3).isValid;
            if (!bl3) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Pre-packaged database has an invalid schema: ");
                object3 = ((RoomOpenHelper$ValidationResult)object3).expectedFoundMsg;
                ((StringBuilder)object2).append((String)object3);
                object3 = ((StringBuilder)object2).toString();
                object = new IllegalStateException((String)object3);
                throw object;
            }
        }
        this.updateIdentity((SupportSQLiteDatabase)object);
        this.mDelegate.onCreate((SupportSQLiteDatabase)object);
    }

    public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int n10, int n11) {
        this.onUpgrade(supportSQLiteDatabase, n10, n11);
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.onOpen(supportSQLiteDatabase);
        this.checkIdentity(supportSQLiteDatabase);
        this.mDelegate.onOpen(supportSQLiteDatabase);
        this.mConfiguration = null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void onUpgrade(SupportSQLiteDatabase object, int n10, int n11) {
        Object object2 = this.mConfiguration;
        if (object2 != null && (object2 = ((DatabaseConfiguration)object2).migrationContainer.findMigrationPath(n10, n11)) != null) {
            boolean bl2;
            Object object3 = this.mDelegate;
            ((RoomOpenHelper$Delegate)object3).onPreMigrate((SupportSQLiteDatabase)object);
            object2 = object2.iterator();
            while (bl2 = object2.hasNext()) {
                object3 = (Migration)object2.next();
                ((Migration)object3).migrate((SupportSQLiteDatabase)object);
            }
            object2 = this.mDelegate.onValidateSchema((SupportSQLiteDatabase)object);
            bl2 = ((RoomOpenHelper$ValidationResult)object2).isValid;
            if (bl2) {
                object2 = this.mDelegate;
                ((RoomOpenHelper$Delegate)object2).onPostMigrate((SupportSQLiteDatabase)object);
                this.updateIdentity((SupportSQLiteDatabase)object);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Migration didn't properly handle: ");
            String string2 = ((RoomOpenHelper$ValidationResult)object2).expectedFoundMsg;
            stringBuilder.append(string2);
            String string3 = stringBuilder.toString();
            object = new IllegalStateException(string3);
            throw object;
        }
        boolean bl3 = false;
        object2 = null;
        if (bl3) return;
        object2 = this.mConfiguration;
        if (object2 == null || (bl3 = ((DatabaseConfiguration)object2).isMigrationRequired(n10, n11))) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("A migration from ");
            ((StringBuilder)object2).append(n10);
            ((StringBuilder)object2).append(" to ");
            ((StringBuilder)object2).append(n11);
            ((StringBuilder)object2).append(" was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
            String string4 = ((StringBuilder)object2).toString();
            object = new IllegalStateException(string4);
            throw object;
        }
        this.mDelegate.dropAllTables((SupportSQLiteDatabase)object);
        RoomOpenHelper$Delegate roomOpenHelper$Delegate = this.mDelegate;
        roomOpenHelper$Delegate.createAllTables((SupportSQLiteDatabase)object);
    }
}

