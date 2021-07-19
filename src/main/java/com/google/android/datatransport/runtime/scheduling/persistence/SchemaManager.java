/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteOpenHelper
 *  android.os.Build$VERSION
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager$$Lambda$1;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager$$Lambda$2;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager$$Lambda$3;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager$$Lambda$4;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager$Migration;
import java.util.Arrays;
import java.util.List;

public final class SchemaManager
extends SQLiteOpenHelper {
    private static final String CREATE_CONTEXTS_SQL_V1 = "CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)";
    private static final String CREATE_CONTEXT_BACKEND_PRIORITY_INDEX_V1 = "CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)";
    private static final String CREATE_EVENTS_SQL_V1 = "CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)";
    private static final String CREATE_EVENT_BACKEND_INDEX_V1 = "CREATE INDEX events_backend_id on events(context_id)";
    private static final String CREATE_EVENT_METADATA_SQL_V1 = "CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)";
    private static final String CREATE_PAYLOADS_TABLE_V4 = "CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))";
    public static final String DB_NAME = "com.google.android.datatransport.events";
    private static final String DROP_CONTEXTS_SQL = "DROP TABLE transport_contexts";
    private static final String DROP_EVENTS_SQL = "DROP TABLE events";
    private static final String DROP_EVENT_METADATA_SQL = "DROP TABLE event_metadata";
    private static final String DROP_PAYLOADS_SQL = "DROP TABLE IF EXISTS event_payloads";
    private static final List INCREMENTAL_MIGRATIONS;
    private static final SchemaManager$Migration MIGRATE_TO_V1;
    private static final SchemaManager$Migration MIGRATE_TO_V2;
    private static final SchemaManager$Migration MIGRATE_TO_V3;
    private static final SchemaManager$Migration MIGRATE_TO_V4;
    public static int SCHEMA_VERSION = 4;
    private boolean configured = false;
    private final int schemaVersion;

    static {
        SchemaManager$Migration schemaManager$Migration;
        SchemaManager$Migration schemaManager$Migration2;
        SchemaManager$Migration schemaManager$Migration3;
        SchemaManager$Migration schemaManager$Migration4;
        MIGRATE_TO_V1 = schemaManager$Migration4 = SchemaManager$$Lambda$1.lambdaFactory$();
        MIGRATE_TO_V2 = schemaManager$Migration3 = SchemaManager$$Lambda$2.lambdaFactory$();
        MIGRATE_TO_V3 = schemaManager$Migration2 = SchemaManager$$Lambda$3.lambdaFactory$();
        MIGRATE_TO_V4 = schemaManager$Migration = SchemaManager$$Lambda$4.lambdaFactory$();
        SchemaManager$Migration[] schemaManager$MigrationArray = new SchemaManager$Migration[]{schemaManager$Migration4, schemaManager$Migration3, schemaManager$Migration2, schemaManager$Migration};
        INCREMENTAL_MIGRATIONS = Arrays.asList(schemaManager$MigrationArray);
    }

    public SchemaManager(Context context, String string2, int n10) {
        super(context, string2, null, n10);
        this.schemaVersion = n10;
    }

    private void ensureConfigured(SQLiteDatabase sQLiteDatabase) {
        boolean bl2 = this.configured;
        if (!bl2) {
            this.onConfigure(sQLiteDatabase);
        }
    }

    public static /* synthetic */ void lambda$static$0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CREATE_EVENTS_SQL_V1);
        sQLiteDatabase.execSQL(CREATE_EVENT_METADATA_SQL_V1);
        sQLiteDatabase.execSQL(CREATE_CONTEXTS_SQL_V1);
        sQLiteDatabase.execSQL(CREATE_EVENT_BACKEND_INDEX_V1);
        sQLiteDatabase.execSQL(CREATE_CONTEXT_BACKEND_PRIORITY_INDEX_V1);
    }

    public static /* synthetic */ void lambda$static$1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public static /* synthetic */ void lambda$static$2(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }

    public static /* synthetic */ void lambda$static$3(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL(DROP_PAYLOADS_SQL);
        sQLiteDatabase.execSQL(CREATE_PAYLOADS_TABLE_V4);
    }

    private void onCreate(SQLiteDatabase sQLiteDatabase, int n10) {
        this.ensureConfigured(sQLiteDatabase);
        this.upgrade(sQLiteDatabase, 0, n10);
    }

    private void upgrade(SQLiteDatabase object, int n10, int n11) {
        Object object2 = INCREMENTAL_MIGRATIONS;
        int n12 = object2.size();
        if (n11 <= n12) {
            while (n10 < n11) {
                object2 = (SchemaManager$Migration)INCREMENTAL_MIGRATIONS.get(n10);
                object2.upgrade((SQLiteDatabase)object);
                ++n10;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Migration from ");
        stringBuilder.append(n10);
        stringBuilder.append(" to ");
        stringBuilder.append(n11);
        stringBuilder.append(" was requested, but cannot be performed. Only ");
        n10 = object2.size();
        stringBuilder.append(n10);
        stringBuilder.append(" migrations are provided");
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        boolean bl2;
        this.configured = bl2 = true;
        String[] stringArray = new String[]{};
        String string2 = "PRAGMA busy_timeout=0;";
        stringArray = sQLiteDatabase.rawQuery(string2, stringArray);
        stringArray.close();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            sQLiteDatabase.setForeignKeyConstraintsEnabled(bl2);
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        int n10 = this.schemaVersion;
        this.onCreate(sQLiteDatabase, n10);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int n10, int n11) {
        sQLiteDatabase.execSQL(DROP_EVENTS_SQL);
        sQLiteDatabase.execSQL(DROP_EVENT_METADATA_SQL);
        sQLiteDatabase.execSQL(DROP_CONTEXTS_SQL);
        sQLiteDatabase.execSQL(DROP_PAYLOADS_SQL);
        this.onCreate(sQLiteDatabase, n11);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        this.ensureConfigured(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n10, int n11) {
        this.ensureConfigured(sQLiteDatabase);
        this.upgrade(sQLiteDatabase, n10, n11);
    }
}

