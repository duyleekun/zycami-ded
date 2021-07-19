/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabaseLockedException
 *  android.os.SystemClock
 *  android.util.Base64
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.EventInternal$Builder;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportContext$Builder;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$1;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$10;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$11;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$12;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$13;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$14;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$15;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$16;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$17;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$18;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$19;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$20;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$21;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$4;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$5;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$6;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$7;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$8;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$9;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Function;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Metadata;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Producer;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class SQLiteEventStore
implements EventStore,
SynchronizationGuard {
    private static final int LOCK_RETRY_BACK_OFF_MILLIS = 50;
    private static final String LOG_TAG = "SQLiteEventStore";
    public static final int MAX_RETRIES = 16;
    private static final Encoding PROTOBUF_ENCODING = Encoding.of("proto");
    private final EventStoreConfig config;
    private final Clock monotonicClock;
    private final SchemaManager schemaManager;
    private final Clock wallClock;

    public SQLiteEventStore(Clock clock, Clock clock2, EventStoreConfig eventStoreConfig, SchemaManager schemaManager) {
        this.schemaManager = schemaManager;
        this.wallClock = clock;
        this.monotonicClock = clock2;
        this.config = eventStoreConfig;
    }

    private void ensureBeginTransaction(SQLiteDatabase object) {
        object = SQLiteEventStore$$Lambda$18.lambdaFactory$(object);
        SQLiteEventStore$Function sQLiteEventStore$Function = SQLiteEventStore$$Lambda$19.lambdaFactory$();
        this.retryIfDbLocked((SQLiteEventStore$Producer)object, sQLiteEventStore$Function);
    }

    private long ensureTransportContext(SQLiteDatabase sQLiteDatabase, TransportContext object) {
        Long l10 = this.getTransportContextId(sQLiteDatabase, (TransportContext)object);
        if (l10 != null) {
            return l10;
        }
        l10 = new ContentValues();
        Object object2 = ((TransportContext)object).getBackendName();
        l10.put("backend_name", (String)object2);
        object2 = PriorityMapping.toInt(((TransportContext)object).getPriority());
        l10.put("priority", (Integer)object2);
        object2 = null;
        Object object3 = 0;
        String string2 = "next_request_ms";
        l10.put(string2, (Integer)object3);
        object3 = ((TransportContext)object).getExtras();
        if (object3 != null) {
            object = Base64.encodeToString((byte[])((TransportContext)object).getExtras(), (int)0);
            object2 = "extras";
            l10.put((String)object2, (String)object);
        }
        return sQLiteDatabase.insert("transport_contexts", null, (ContentValues)l10);
    }

    private long getPageCount() {
        return this.getDb().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private long getPageSize() {
        return this.getDb().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private Long getTransportContextId(SQLiteDatabase sQLiteDatabase, TransportContext object) {
        String string2;
        StringBuilder stringBuilder = new StringBuilder("backend_name = ? and priority = ?");
        int n10 = 2;
        Object object2 = new String[n10];
        object2[0] = string2 = object.getBackendName();
        int n11 = PriorityMapping.toInt(object.getPriority());
        string2 = String.valueOf(n11);
        int n12 = 1;
        object2[n12] = string2;
        object2 = Arrays.asList(object2);
        ArrayList<String[]> arrayList = new ArrayList<String[]>((Collection<String[]>)object2);
        object2 = object.getExtras();
        if (object2 != null) {
            object2 = " and extras = ?";
            stringBuilder.append((String)object2);
            object = Base64.encodeToString((byte[])object.getExtras(), (int)0);
            arrayList.add((String[])object);
        } else {
            object = " and extras is null";
            stringBuilder.append((String)object);
        }
        String[] stringArray = new String[]{"_id"};
        String string3 = stringBuilder.toString();
        object = new String[]{};
        String[] stringArray2 = object = arrayList.toArray((T[])object);
        stringArray2 = object;
        sQLiteDatabase = sQLiteDatabase.query("transport_contexts", stringArray, string3, stringArray2, null, null, null);
        object = SQLiteEventStore$$Lambda$6.lambdaFactory$();
        return (Long)SQLiteEventStore.tryWithCursor((Cursor)sQLiteDatabase, (SQLiteEventStore$Function)object);
    }

    private boolean isStorageAtLimit() {
        long l10 = this.getPageCount();
        long l11 = this.getPageSize();
        EventStoreConfig eventStoreConfig = this.config;
        long l12 = (l10 *= l11) - (l11 = eventStoreConfig.getMaxStorageSizeInBytes());
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    private List join(List list, Map map) {
        boolean bl2;
        ListIterator<Object> listIterator = list.listIterator();
        while (bl2 = listIterator.hasNext()) {
            boolean bl3;
            Object object = (PersistedEvent)listIterator.next();
            long l10 = ((PersistedEvent)object).getId();
            Object object2 = l10;
            boolean bl4 = map.containsKey(object2);
            if (!bl4) continue;
            object2 = ((PersistedEvent)object).getEvent().toBuilder();
            long l11 = ((PersistedEvent)object).getId();
            Object object3 = l11;
            object3 = ((Set)map.get(object3)).iterator();
            while (bl3 = object3.hasNext()) {
                Object object4 = (SQLiteEventStore$Metadata)object3.next();
                String string2 = ((SQLiteEventStore$Metadata)object4).key;
                object4 = ((SQLiteEventStore$Metadata)object4).value;
                ((EventInternal$Builder)object2).addMetadata(string2, (String)object4);
            }
            l11 = ((PersistedEvent)object).getId();
            object = ((PersistedEvent)object).getTransportContext();
            object2 = ((EventInternal$Builder)object2).build();
            object = PersistedEvent.create(l11, (TransportContext)object, (EventInternal)object2);
            listIterator.set(object);
        }
        return list;
    }

    public static /* synthetic */ Integer lambda$cleanUp$10(long l10, SQLiteDatabase sQLiteDatabase) {
        String string2 = String.valueOf(l10);
        String[] stringArray = new String[]{string2};
        return sQLiteDatabase.delete("events", "timestamp_ms < ?", stringArray);
    }

    public static /* synthetic */ Object lambda$clearDb$11(SQLiteDatabase sQLiteDatabase) {
        String[] stringArray = new String[]{};
        sQLiteDatabase.delete("events", null, stringArray);
        String[] stringArray2 = new String[]{};
        sQLiteDatabase.delete("transport_contexts", null, stringArray2);
        return null;
    }

    public static /* synthetic */ Object lambda$ensureBeginTransaction$15(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    public static /* synthetic */ Object lambda$ensureBeginTransaction$16(Throwable throwable) {
        SynchronizationException synchronizationException = new SynchronizationException("Timed out while trying to acquire the lock.", throwable);
        throw synchronizationException;
    }

    public static /* synthetic */ SQLiteDatabase lambda$getDb$0(Throwable throwable) {
        SynchronizationException synchronizationException = new SynchronizationException("Timed out while trying to open db.", throwable);
        throw synchronizationException;
    }

    public static /* synthetic */ Long lambda$getNextCallTime$4(Cursor cursor) {
        boolean bl2 = cursor.moveToNext();
        if (bl2) {
            return cursor.getLong(0);
        }
        return 0L;
    }

    public static /* synthetic */ Long lambda$getTransportContextId$2(Cursor cursor) {
        boolean bl2 = cursor.moveToNext();
        if (!bl2) {
            return null;
        }
        return cursor.getLong(0);
    }

    public static /* synthetic */ Boolean lambda$hasPendingEventsFor$5(SQLiteEventStore sQLiteEventStore, TransportContext object, SQLiteDatabase stringArray) {
        if ((object = sQLiteEventStore.getTransportContextId((SQLiteDatabase)stringArray, (TransportContext)object)) == null) {
            return Boolean.FALSE;
        }
        sQLiteEventStore = sQLiteEventStore.getDb();
        stringArray = new String[]{object = ((Long)object).toString()};
        sQLiteEventStore = sQLiteEventStore.rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", stringArray);
        object = SQLiteEventStore$$Lambda$21.lambdaFactory$();
        return (Boolean)SQLiteEventStore.tryWithCursor((Cursor)sQLiteEventStore, (SQLiteEventStore$Function)object);
    }

    public static /* synthetic */ List lambda$loadActiveContexts$8(Cursor cursor) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        while (bl2 = cursor.moveToNext()) {
            Object object = TransportContext.builder();
            Object object2 = cursor.getString(1);
            object = ((TransportContext$Builder)object).setBackendName((String)object2);
            object2 = PriorityMapping.valueOf(cursor.getInt(2));
            object = ((TransportContext$Builder)object).setPriority((Priority)((Object)object2));
            int n10 = 3;
            object2 = SQLiteEventStore.maybeBase64Decode(cursor.getString(n10));
            object = ((TransportContext$Builder)object).setExtras((byte[])object2).build();
            arrayList.add(object);
        }
        return arrayList;
    }

    public static /* synthetic */ List lambda$loadActiveContexts$9(SQLiteDatabase sQLiteDatabase) {
        Object object = new String[]{};
        sQLiteDatabase = sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", object);
        object = SQLiteEventStore$$Lambda$20.lambdaFactory$();
        return (List)SQLiteEventStore.tryWithCursor((Cursor)sQLiteDatabase, (SQLiteEventStore$Function)object);
    }

    public static /* synthetic */ List lambda$loadBatch$7(SQLiteEventStore sQLiteEventStore, TransportContext object, SQLiteDatabase object2) {
        object = sQLiteEventStore.loadEvents((SQLiteDatabase)object2, (TransportContext)object);
        object2 = sQLiteEventStore.loadMetadata((SQLiteDatabase)object2, (List)object);
        return sQLiteEventStore.join((List)object, (Map)object2);
    }

    public static /* synthetic */ Object lambda$loadEvents$12(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext, Cursor cursor) {
        int n10;
        while ((n10 = cursor.moveToNext()) != 0) {
            byte[] byArray;
            n10 = 0;
            Object object = null;
            long l10 = cursor.getLong(0);
            int n11 = cursor.getInt(7);
            int n12 = 1;
            if (n11 != 0) {
                n10 = n12;
            }
            EventInternal$Builder eventInternal$Builder = EventInternal.builder();
            Object object2 = cursor.getString(n12);
            eventInternal$Builder = eventInternal$Builder.setTransportName((String)object2);
            long l11 = cursor.getLong(2);
            eventInternal$Builder = eventInternal$Builder.setEventMillis(l11);
            l11 = cursor.getLong(3);
            eventInternal$Builder = eventInternal$Builder.setUptimeMillis(l11);
            n12 = 4;
            if (n10 != 0) {
                object2 = SQLiteEventStore.toEncoding(cursor.getString(n12));
                int n13 = 5;
                byArray = cursor.getBlob(n13);
                object = new EncodedPayload((Encoding)object2, byArray);
                eventInternal$Builder.setEncodedPayload((EncodedPayload)object);
            } else {
                object2 = SQLiteEventStore.toEncoding(cursor.getString(n12));
                byArray = sQLiteEventStore.readPayload(l10);
                object = new EncodedPayload((Encoding)object2, byArray);
                eventInternal$Builder.setEncodedPayload((EncodedPayload)object);
            }
            n10 = 6;
            n12 = (int)(cursor.isNull(n10) ? 1 : 0);
            if (n12 == 0) {
                n10 = cursor.getInt(n10);
                object = n10;
                eventInternal$Builder.setCode((Integer)object);
            }
            object = eventInternal$Builder.build();
            object = PersistedEvent.create(l10, transportContext, (EventInternal)object);
            list.add(object);
        }
        return null;
    }

    public static /* synthetic */ Object lambda$loadMetadata$14(Map map, Cursor cursor) {
        boolean bl2;
        while (bl2 = cursor.moveToNext()) {
            Object object;
            bl2 = false;
            long l10 = cursor.getLong(0);
            HashSet<Object> hashSet = l10;
            if ((hashSet = (Set)map.get(hashSet)) == null) {
                hashSet = new HashSet<Object>();
                object = l10;
                map.put(object, hashSet);
            }
            int n10 = 1;
            String string2 = cursor.getString(n10);
            int n11 = 2;
            String string3 = cursor.getString(n11);
            object = new SQLiteEventStore$Metadata(string2, string3, null);
            hashSet.add(object);
        }
        return null;
    }

    public static /* synthetic */ Long lambda$persist$1(SQLiteEventStore iterator2, TransportContext object, EventInternal eventInternal, SQLiteDatabase sQLiteDatabase) {
        boolean bl2;
        Object object2;
        boolean bl3 = ((SQLiteEventStore)((Object)iterator2)).isStorageAtLimit();
        if (bl3) {
            return -1;
        }
        long l10 = ((SQLiteEventStore)((Object)iterator2)).ensureTransportContext(sQLiteDatabase, (TransportContext)object);
        iterator2 = ((SQLiteEventStore)iterator2).config;
        int n10 = ((EventStoreConfig)((Object)iterator2)).getMaxBlobByteSizePerRow();
        object = eventInternal.getEncodedPayload().getBytes();
        int n11 = ((Object)object).length;
        int n12 = 0;
        Object object3 = null;
        int n13 = 1;
        if (n11 <= n10) {
            n11 = n13;
        } else {
            n11 = 0;
            object2 = null;
        }
        ContentValues contentValues = new ContentValues();
        Object object4 = l10;
        contentValues.put("context_id", (Long)object4);
        object4 = eventInternal.getTransportName();
        contentValues.put("transport_name", (String)object4);
        object4 = eventInternal.getEventMillis();
        contentValues.put("timestamp_ms", (Long)object4);
        l10 = eventInternal.getUptimeMillis();
        object4 = l10;
        contentValues.put("uptime_ms", (Long)object4);
        object4 = eventInternal.getEncodedPayload().getEncoding().getName();
        contentValues.put("payload_encoding", (String)object4);
        object4 = eventInternal.getCode();
        contentValues.put("code", (Integer)object4);
        object4 = 0;
        contentValues.put("num_attempts", (Integer)object4);
        object4 = n11 != 0;
        String string2 = "inline";
        contentValues.put(string2, (Boolean)object4);
        object4 = n11 != 0 ? object : (Object)new byte[0];
        contentValues.put("payload", (byte[])object4);
        string2 = null;
        long l11 = sQLiteDatabase.insert("events", null, contentValues);
        object4 = "event_id";
        if (n11 == 0) {
            double d10 = ((Object)object).length;
            double d11 = n10;
            d10 = Math.ceil(d10 / d11);
            n11 = (int)d10;
            while (n13 <= n11) {
                n12 = (n13 + -1) * n10;
                int n14 = n13 * n10;
                int n15 = ((Map.Entry<K, V>)object).length;
                n14 = Math.min(n14, n15);
                object3 = Arrays.copyOfRange(object, n12, n14);
                ContentValues contentValues2 = new ContentValues();
                Object object5 = l11;
                contentValues2.put((String)object4, (Long)object5);
                object5 = n13;
                String string3 = "sequence_num";
                contentValues2.put(string3, (Integer)object5);
                object5 = "bytes";
                contentValues2.put((String)object5, (byte[])object3);
                object3 = "event_payloads";
                sQLiteDatabase.insert((String)object3, null, contentValues2);
                ++n13;
            }
        }
        iterator2 = eventInternal.getMetadata().entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            object = iterator2.next();
            eventInternal = new ContentValues();
            object2 = l11;
            eventInternal.put((String)object4, (Long)object2);
            object2 = (String)object.getKey();
            object3 = "name";
            eventInternal.put((String)object3, (String)object2);
            object = (String)object.getValue();
            object2 = "value";
            eventInternal.put((String)object2, (String)object);
            object = "event_metadata";
            sQLiteDatabase.insert((String)object, null, (ContentValues)eventInternal);
        }
        return l11;
    }

    public static /* synthetic */ byte[] lambda$readPayload$13(Cursor object) {
        int n10;
        byte[] byArray;
        int n11;
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        int n12 = 0;
        while ((n11 = object.moveToNext()) != 0) {
            byArray = object.getBlob(0);
            arrayList.add(byArray);
            n11 = byArray.length;
            n12 += n11;
        }
        object = new byte[n12];
        n11 = 0;
        byArray = null;
        for (n12 = 0; n12 < (n10 = arrayList.size()); ++n12) {
            byte[] byArray2 = (byte[])arrayList.get(n12);
            int n13 = byArray2.length;
            System.arraycopy(byArray2, 0, object, n11, n13);
            n10 = byArray2.length;
            n11 += n10;
        }
        return object;
    }

    public static /* synthetic */ Object lambda$recordFailure$3(String string2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(string2).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    public static /* synthetic */ Object lambda$recordNextCallTime$6(long l10, TransportContext object, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        Object object2 = Long.valueOf(l10);
        contentValues.put("next_request_ms", (Long)object2);
        object2 = new String[2];
        String string2 = ((TransportContext)object).getBackendName();
        String string3 = null;
        object2[0] = string2;
        int n10 = PriorityMapping.toInt(((TransportContext)object).getPriority());
        string2 = String.valueOf(n10);
        int n11 = 1;
        object2[n11] = string2;
        string2 = "transport_contexts";
        int n12 = sQLiteDatabase.update(string2, contentValues, "backend_name = ? and priority = ?", object2);
        if (n12 < n11) {
            object2 = ((TransportContext)object).getBackendName();
            string3 = "backend_name";
            contentValues.put(string3, (String)object2);
            n12 = PriorityMapping.toInt(((TransportContext)object).getPriority());
            object2 = n12;
            object = "priority";
            contentValues.put((String)object, (Integer)object2);
            sQLiteDatabase.insert(string2, null, contentValues);
        }
        return null;
    }

    private List loadEvents(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        ArrayList arrayList = new ArrayList();
        Object object = this.getTransportContextId(sQLiteDatabase, transportContext);
        if (object == null) {
            return arrayList;
        }
        String[] stringArray = new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"};
        String[] stringArray2 = new String[]{object = ((Long)object).toString()};
        String string2 = String.valueOf(this.config.getLoadBatchSize());
        object = sQLiteDatabase.query("events", stringArray, "context_id = ?", stringArray2, null, null, null, string2);
        Object object2 = transportContext;
        object2 = SQLiteEventStore$$Lambda$15.lambdaFactory$(this, arrayList, transportContext);
        SQLiteEventStore.tryWithCursor((Cursor)object, (SQLiteEventStore$Function)object2);
        return arrayList;
    }

    private Map loadMetadata(SQLiteDatabase sQLiteDatabase, List object) {
        char c10;
        HashMap hashMap = new HashMap();
        StringBuilder stringBuilder = new StringBuilder("event_id IN (");
        for (char c11 = '\u0000'; c11 < (c10 = object.size()); ++c11) {
            PersistedEvent persistedEvent = (PersistedEvent)object.get(c11);
            long l10 = persistedEvent.getId();
            stringBuilder.append(l10);
            c10 = object.size() + -1;
            if (c11 >= c10) continue;
            c10 = ',';
            stringBuilder.append(c10);
        }
        stringBuilder.append(')');
        String[] stringArray = new String[]{"event_id", "name", "value"};
        String string2 = stringBuilder.toString();
        sQLiteDatabase = sQLiteDatabase.query("event_metadata", stringArray, string2, null, null, null, null);
        object = SQLiteEventStore$$Lambda$17.lambdaFactory$(hashMap);
        SQLiteEventStore.tryWithCursor((Cursor)sQLiteDatabase, (SQLiteEventStore$Function)object);
        return hashMap;
    }

    private static byte[] maybeBase64Decode(String string2) {
        if (string2 == null) {
            return null;
        }
        return Base64.decode((String)string2, (int)0);
    }

    private byte[] readPayload(long l10) {
        SQLiteDatabase sQLiteDatabase = this.getDb();
        String[] stringArray = new String[]{"bytes"};
        String string2 = String.valueOf(l10);
        String[] stringArray2 = new String[]{string2};
        string2 = sQLiteDatabase.query("event_payloads", stringArray, "event_id = ?", stringArray2, null, null, "sequence_num");
        SQLiteEventStore$Function sQLiteEventStore$Function = SQLiteEventStore$$Lambda$16.lambdaFactory$();
        return (byte[])SQLiteEventStore.tryWithCursor((Cursor)string2, sQLiteEventStore$Function);
    }

    private Object retryIfDbLocked(SQLiteEventStore$Producer sQLiteEventStore$Producer, SQLiteEventStore$Function sQLiteEventStore$Function) {
        Clock clock = this.monotonicClock;
        long l10 = clock.getTime();
        while (true) {
            try {
                return sQLiteEventStore$Producer.produce();
            }
            catch (SQLiteDatabaseLockedException sQLiteDatabaseLockedException) {
                Clock clock2 = this.monotonicClock;
                long l11 = clock2.getTime();
                EventStoreConfig eventStoreConfig = this.config;
                int n10 = eventStoreConfig.getCriticalSectionEnterTimeoutMs();
                long l12 = (long)n10 + l10;
                long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                if (l13 >= 0) {
                    return sQLiteEventStore$Function.apply((Object)sQLiteDatabaseLockedException);
                }
                long l14 = 50;
                SystemClock.sleep((long)l14);
                continue;
            }
            break;
        }
    }

    private static Encoding toEncoding(String string2) {
        if (string2 == null) {
            return PROTOBUF_ENCODING;
        }
        return Encoding.of(string2);
    }

    private static String toIdList(Iterable object) {
        char c10;
        Object object2 = "(";
        StringBuilder stringBuilder = new StringBuilder((String)object2);
        object = object.iterator();
        while ((c10 = object.hasNext()) != '\u0000') {
            object2 = (PersistedEvent)object.next();
            long l10 = ((PersistedEvent)object2).getId();
            stringBuilder.append(l10);
            c10 = object.hasNext();
            if (c10 == '\u0000') continue;
            c10 = ',';
            stringBuilder.append(c10);
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public static Object tryWithCursor(Cursor cursor, SQLiteEventStore$Function object) {
        try {
            object = object.apply(cursor);
            return object;
        }
        finally {
            cursor.close();
        }
    }

    public int cleanUp() {
        long l10 = this.wallClock.getTime();
        long l11 = this.config.getEventCleanUpAge();
        SQLiteEventStore$Function sQLiteEventStore$Function = SQLiteEventStore$$Lambda$13.lambdaFactory$(l10 - l11);
        return (Integer)this.inTransaction(sQLiteEventStore$Function);
    }

    public void clearDb() {
        SQLiteEventStore$Function sQLiteEventStore$Function = SQLiteEventStore$$Lambda$14.lambdaFactory$();
        this.inTransaction(sQLiteEventStore$Function);
    }

    public void close() {
        this.schemaManager.close();
    }

    public long getByteSize() {
        long l10 = this.getPageCount();
        long l11 = this.getPageSize();
        return l10 * l11;
    }

    public SQLiteDatabase getDb() {
        Object object = this.schemaManager;
        ((Object)object).getClass();
        object = SQLiteEventStore$$Lambda$1.lambdaFactory$(object);
        SQLiteEventStore$Function sQLiteEventStore$Function = SQLiteEventStore$$Lambda$4.lambdaFactory$();
        return (SQLiteDatabase)this.retryIfDbLocked((SQLiteEventStore$Producer)object, sQLiteEventStore$Function);
    }

    public long getNextCallTime(TransportContext object) {
        Object object2 = this.getDb();
        String string2 = ((TransportContext)object).getBackendName();
        String[] stringArray = new String[]{string2, object = String.valueOf(PriorityMapping.toInt(((TransportContext)object).getPriority()))};
        object = object2.rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", stringArray);
        object2 = SQLiteEventStore$$Lambda$8.lambdaFactory$();
        return (Long)SQLiteEventStore.tryWithCursor((Cursor)object, (SQLiteEventStore$Function)object2);
    }

    public boolean hasPendingEventsFor(TransportContext object) {
        object = SQLiteEventStore$$Lambda$9.lambdaFactory$(this, (TransportContext)object);
        return (Boolean)this.inTransaction((SQLiteEventStore$Function)object);
    }

    public Object inTransaction(SQLiteEventStore$Function object) {
        SQLiteDatabase sQLiteDatabase = this.getDb();
        sQLiteDatabase.beginTransaction();
        try {
            object = object.apply(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return object;
        }
        finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public Iterable loadActiveContexts() {
        SQLiteEventStore$Function sQLiteEventStore$Function = SQLiteEventStore$$Lambda$12.lambdaFactory$();
        return (Iterable)this.inTransaction(sQLiteEventStore$Function);
    }

    public Iterable loadBatch(TransportContext object) {
        object = SQLiteEventStore$$Lambda$11.lambdaFactory$(this, (TransportContext)object);
        return (Iterable)this.inTransaction((SQLiteEventStore$Function)object);
    }

    public PersistedEvent persist(TransportContext transportContext, EventInternal eventInternal) {
        int n10 = 3;
        Object object = new Object[n10];
        Object object2 = transportContext.getPriority();
        object[0] = object2;
        object2 = eventInternal.getTransportName();
        object[1] = object2;
        object2 = transportContext.getBackendName();
        object[2] = object2;
        object2 = LOG_TAG;
        String string2 = "Storing event with priority=%s, name=%s for destination %s";
        Logging.d((String)object2, string2, (Object[])object);
        object = SQLiteEventStore$$Lambda$5.lambdaFactory$(this, transportContext, eventInternal);
        object = (Long)this.inTransaction((SQLiteEventStore$Function)object);
        long l10 = (Long)object;
        long l11 = 1L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 < 0) {
            return null;
        }
        return PersistedEvent.create(l10, transportContext, eventInternal);
    }

    public void recordFailure(Iterable object) {
        Iterator iterator2 = object.iterator();
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            return;
        }
        iterator2 = new StringBuilder();
        ((StringBuilder)((Object)iterator2)).append("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
        object = SQLiteEventStore.toIdList((Iterable)object);
        ((StringBuilder)((Object)iterator2)).append((String)object);
        object = SQLiteEventStore$$Lambda$7.lambdaFactory$(((StringBuilder)((Object)iterator2)).toString());
        this.inTransaction((SQLiteEventStore$Function)object);
    }

    public void recordNextCallTime(TransportContext object, long l10) {
        object = SQLiteEventStore$$Lambda$10.lambdaFactory$(l10, (TransportContext)object);
        this.inTransaction((SQLiteEventStore$Function)object);
    }

    public void recordSuccess(Iterable object) {
        Iterator iterator2 = object.iterator();
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            return;
        }
        iterator2 = new StringBuilder();
        ((StringBuilder)((Object)iterator2)).append("DELETE FROM events WHERE _id in ");
        object = SQLiteEventStore.toIdList((Iterable)object);
        ((StringBuilder)((Object)iterator2)).append((String)object);
        object = ((StringBuilder)((Object)iterator2)).toString();
        this.getDb().compileStatement((String)object).execute();
    }

    public Object runCriticalSection(SynchronizationGuard$CriticalSection object) {
        SQLiteDatabase sQLiteDatabase = this.getDb();
        this.ensureBeginTransaction(sQLiteDatabase);
        try {
            object = object.execute();
            sQLiteDatabase.setTransactionSuccessful();
            return object;
        }
        finally {
            sQLiteDatabase.endTransaction();
        }
    }
}

