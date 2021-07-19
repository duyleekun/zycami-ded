/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat$FieldType;

public final class TraceMetric$CountersDefaultEntryHolder {
    public static final MapEntryLite defaultEntry;

    static {
        WireFormat$FieldType wireFormat$FieldType = WireFormat$FieldType.STRING;
        WireFormat$FieldType wireFormat$FieldType2 = WireFormat$FieldType.INT64;
        Long l10 = 0L;
        defaultEntry = MapEntryLite.newDefaultInstance(wireFormat$FieldType, "", wireFormat$FieldType2, l10);
    }

    private TraceMetric$CountersDefaultEntryHolder() {
    }
}

