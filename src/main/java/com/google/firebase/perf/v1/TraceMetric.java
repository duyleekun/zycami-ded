/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.PerfSessionOrBuilder;
import com.google.firebase.perf.v1.TraceMetric$1;
import com.google.firebase.perf.v1.TraceMetric$Builder;
import com.google.firebase.perf.v1.TraceMetric$CountersDefaultEntryHolder;
import com.google.firebase.perf.v1.TraceMetric$CustomAttributesDefaultEntryHolder;
import com.google.firebase.perf.v1.TraceMetricOrBuilder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Internal$ProtobufList;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class TraceMetric
extends GeneratedMessageLite
implements TraceMetricOrBuilder {
    public static final int CLIENT_START_TIME_US_FIELD_NUMBER = 4;
    public static final int COUNTERS_FIELD_NUMBER = 6;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 8;
    private static final TraceMetric DEFAULT_INSTANCE;
    public static final int DURATION_US_FIELD_NUMBER = 5;
    public static final int IS_AUTO_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser PARSER;
    public static final int PERF_SESSIONS_FIELD_NUMBER = 9;
    public static final int SUBTRACES_FIELD_NUMBER = 7;
    private int bitField0_;
    private long clientStartTimeUs_;
    private MapFieldLite counters_;
    private MapFieldLite customAttributes_;
    private long durationUs_;
    private boolean isAuto_;
    private String name_;
    private Internal$ProtobufList perfSessions_;
    private Internal$ProtobufList subtraces_;

    static {
        TraceMetric traceMetric;
        DEFAULT_INSTANCE = traceMetric = new TraceMetric();
        GeneratedMessageLite.registerDefaultInstance(TraceMetric.class, traceMetric);
    }

    private TraceMetric() {
        Object object = MapFieldLite.emptyMapField();
        this.counters_ = object;
        object = MapFieldLite.emptyMapField();
        this.customAttributes_ = object;
        this.name_ = "";
        this.subtraces_ = object = GeneratedMessageLite.emptyProtobufList();
        this.perfSessions_ = object = GeneratedMessageLite.emptyProtobufList();
    }

    public static /* synthetic */ TraceMetric access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(TraceMetric traceMetric, String string2) {
        traceMetric.setName(string2);
    }

    public static /* synthetic */ Map access$1000(TraceMetric traceMetric) {
        return traceMetric.getMutableCountersMap();
    }

    public static /* synthetic */ void access$1100(TraceMetric traceMetric, int n10, TraceMetric traceMetric2) {
        traceMetric.setSubtraces(n10, traceMetric2);
    }

    public static /* synthetic */ void access$1200(TraceMetric traceMetric, TraceMetric traceMetric2) {
        traceMetric.addSubtraces(traceMetric2);
    }

    public static /* synthetic */ void access$1300(TraceMetric traceMetric, int n10, TraceMetric traceMetric2) {
        traceMetric.addSubtraces(n10, traceMetric2);
    }

    public static /* synthetic */ void access$1400(TraceMetric traceMetric, Iterable iterable) {
        traceMetric.addAllSubtraces(iterable);
    }

    public static /* synthetic */ void access$1500(TraceMetric traceMetric) {
        traceMetric.clearSubtraces();
    }

    public static /* synthetic */ void access$1600(TraceMetric traceMetric, int n10) {
        traceMetric.removeSubtraces(n10);
    }

    public static /* synthetic */ Map access$1700(TraceMetric traceMetric) {
        return traceMetric.getMutableCustomAttributesMap();
    }

    public static /* synthetic */ void access$1800(TraceMetric traceMetric, int n10, PerfSession perfSession) {
        traceMetric.setPerfSessions(n10, perfSession);
    }

    public static /* synthetic */ void access$1900(TraceMetric traceMetric, PerfSession perfSession) {
        traceMetric.addPerfSessions(perfSession);
    }

    public static /* synthetic */ void access$200(TraceMetric traceMetric) {
        traceMetric.clearName();
    }

    public static /* synthetic */ void access$2000(TraceMetric traceMetric, int n10, PerfSession perfSession) {
        traceMetric.addPerfSessions(n10, perfSession);
    }

    public static /* synthetic */ void access$2100(TraceMetric traceMetric, Iterable iterable) {
        traceMetric.addAllPerfSessions(iterable);
    }

    public static /* synthetic */ void access$2200(TraceMetric traceMetric) {
        traceMetric.clearPerfSessions();
    }

    public static /* synthetic */ void access$2300(TraceMetric traceMetric, int n10) {
        traceMetric.removePerfSessions(n10);
    }

    public static /* synthetic */ void access$300(TraceMetric traceMetric, ByteString byteString) {
        traceMetric.setNameBytes(byteString);
    }

    public static /* synthetic */ void access$400(TraceMetric traceMetric, boolean bl2) {
        traceMetric.setIsAuto(bl2);
    }

    public static /* synthetic */ void access$500(TraceMetric traceMetric) {
        traceMetric.clearIsAuto();
    }

    public static /* synthetic */ void access$600(TraceMetric traceMetric, long l10) {
        traceMetric.setClientStartTimeUs(l10);
    }

    public static /* synthetic */ void access$700(TraceMetric traceMetric) {
        traceMetric.clearClientStartTimeUs();
    }

    public static /* synthetic */ void access$800(TraceMetric traceMetric, long l10) {
        traceMetric.setDurationUs(l10);
    }

    public static /* synthetic */ void access$900(TraceMetric traceMetric) {
        traceMetric.clearDurationUs();
    }

    private void addAllPerfSessions(Iterable iterable) {
        this.ensurePerfSessionsIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.perfSessions_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addAllSubtraces(Iterable iterable) {
        this.ensureSubtracesIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.subtraces_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addPerfSessions(int n10, PerfSession perfSession) {
        perfSession.getClass();
        this.ensurePerfSessionsIsMutable();
        this.perfSessions_.add(n10, perfSession);
    }

    private void addPerfSessions(PerfSession perfSession) {
        perfSession.getClass();
        this.ensurePerfSessionsIsMutable();
        this.perfSessions_.add(perfSession);
    }

    private void addSubtraces(int n10, TraceMetric traceMetric) {
        traceMetric.getClass();
        this.ensureSubtracesIsMutable();
        this.subtraces_.add(n10, traceMetric);
    }

    private void addSubtraces(TraceMetric traceMetric) {
        traceMetric.getClass();
        this.ensureSubtracesIsMutable();
        this.subtraces_.add(traceMetric);
    }

    private void clearClientStartTimeUs() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.clientStartTimeUs_ = 0L;
    }

    private void clearDurationUs() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.durationUs_ = 0L;
    }

    private void clearIsAuto() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.isAuto_ = false;
    }

    private void clearName() {
        String string2;
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.name_ = string2 = TraceMetric.getDefaultInstance().getName();
    }

    private void clearPerfSessions() {
        Internal$ProtobufList internal$ProtobufList;
        this.perfSessions_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSubtraces() {
        Internal$ProtobufList internal$ProtobufList;
        this.subtraces_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePerfSessionsIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.perfSessions_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.perfSessions_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(internal$ProtobufList);
        }
    }

    private void ensureSubtracesIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.subtraces_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.subtraces_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(internal$ProtobufList);
        }
    }

    public static TraceMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map getMutableCountersMap() {
        return this.internalGetMutableCounters();
    }

    private Map getMutableCustomAttributesMap() {
        return this.internalGetMutableCustomAttributes();
    }

    private MapFieldLite internalGetCounters() {
        return this.counters_;
    }

    private MapFieldLite internalGetCustomAttributes() {
        return this.customAttributes_;
    }

    private MapFieldLite internalGetMutableCounters() {
        MapFieldLite mapFieldLite = this.counters_;
        boolean bl2 = mapFieldLite.isMutable();
        if (!bl2) {
            this.counters_ = mapFieldLite = this.counters_.mutableCopy();
        }
        return this.counters_;
    }

    private MapFieldLite internalGetMutableCustomAttributes() {
        MapFieldLite mapFieldLite = this.customAttributes_;
        boolean bl2 = mapFieldLite.isMutable();
        if (!bl2) {
            this.customAttributes_ = mapFieldLite = this.customAttributes_.mutableCopy();
        }
        return this.customAttributes_;
    }

    public static TraceMetric$Builder newBuilder() {
        return (TraceMetric$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static TraceMetric$Builder newBuilder(TraceMetric traceMetric) {
        return (TraceMetric$Builder)DEFAULT_INSTANCE.createBuilder(traceMetric);
    }

    public static TraceMetric parseDelimitedFrom(InputStream inputStream) {
        return (TraceMetric)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TraceMetric parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TraceMetric)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TraceMetric parseFrom(ByteString byteString) {
        return (TraceMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static TraceMetric parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (TraceMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TraceMetric parseFrom(CodedInputStream codedInputStream) {
        return (TraceMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static TraceMetric parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TraceMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static TraceMetric parseFrom(InputStream inputStream) {
        return (TraceMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static TraceMetric parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TraceMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TraceMetric parseFrom(ByteBuffer byteBuffer) {
        return (TraceMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static TraceMetric parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (TraceMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TraceMetric parseFrom(byte[] byArray) {
        return (TraceMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static TraceMetric parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (TraceMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePerfSessions(int n10) {
        this.ensurePerfSessionsIsMutable();
        this.perfSessions_.remove(n10);
    }

    private void removeSubtraces(int n10) {
        this.ensureSubtracesIsMutable();
        this.subtraces_.remove(n10);
    }

    private void setClientStartTimeUs(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.clientStartTimeUs_ = l10;
    }

    private void setDurationUs(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.durationUs_ = l10;
    }

    private void setIsAuto(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.isAuto_ = bl2;
    }

    private void setName(String string2) {
        int n10;
        string2.getClass();
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = string2;
    }

    private void setNameBytes(ByteString object) {
        int n10;
        this.name_ = object = ((ByteString)object).toStringUtf8();
        this.bitField0_ = n10 = this.bitField0_ | 1;
    }

    private void setPerfSessions(int n10, PerfSession perfSession) {
        perfSession.getClass();
        this.ensurePerfSessionsIsMutable();
        this.perfSessions_.set(n10, perfSession);
    }

    private void setSubtraces(int n10, TraceMetric traceMetric) {
        traceMetric.getClass();
        this.ensureSubtracesIsMutable();
        this.subtraces_.set(n10, traceMetric);
    }

    public boolean containsCounters(String string2) {
        string2.getClass();
        return this.internalGetCounters().containsKey(string2);
    }

    public boolean containsCustomAttributes(String string2) {
        string2.getClass();
        return this.internalGetCustomAttributes().containsKey(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = TraceMetric.class;
        object = TraceMetric$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
        Object object2 = objectArray.ordinal();
        object2 = object[object2];
        byte by2 = 1;
        MapEntryLite mapEntryLite = null;
        switch (object2) {
            default: {
                objectArray = new UnsupportedOperationException();
                throw objectArray;
            }
            case 7: {
                return null;
            }
            case 6: {
                return by2;
            }
            case 5: {
                objectArray = PARSER;
                if (objectArray != null) return objectArray;
                synchronized (clazz) {
                    objectArray = PARSER;
                    if (objectArray != null) return objectArray;
                    object = DEFAULT_INSTANCE;
                    PARSER = objectArray = new GeneratedMessageLite$DefaultInstanceBasedParser((GeneratedMessageLite)object);
                    return objectArray;
                }
            }
            case 4: {
                return DEFAULT_INSTANCE;
            }
            case 3: {
                objectArray = new Object[13];
                objectArray[0] = "bitField0_";
                objectArray[by2] = "name_";
                objectArray[2] = "isAuto_";
                objectArray[3] = "clientStartTimeUs_";
                objectArray[4] = "durationUs_";
                objectArray[5] = "counters_";
                mapEntryLite = TraceMetric$CountersDefaultEntryHolder.defaultEntry;
                objectArray[6] = mapEntryLite;
                objectArray[7] = "subtraces_";
                objectArray[8] = clazz;
                objectArray[9] = "customAttributes_";
                objectArray[10] = object = TraceMetric$CustomAttributesDefaultEntryHolder.defaultEntry;
                objectArray[11] = "perfSessions_";
                objectArray[12] = PerfSession.class;
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\t\b\u0002\u0002\u0000\u0001\u1008\u0000\u0002\u1007\u0001\u0004\u1002\u0002\u0005\u1002\u0003\u00062\u0007\u001b\b2\t\u001b", objectArray);
            }
            case 2: {
                return new TraceMetric$Builder(null);
            }
            case 1: 
        }
        return new TraceMetric();
    }

    public long getClientStartTimeUs() {
        return this.clientStartTimeUs_;
    }

    public Map getCounters() {
        return this.getCountersMap();
    }

    public int getCountersCount() {
        return this.internalGetCounters().size();
    }

    public Map getCountersMap() {
        return Collections.unmodifiableMap(this.internalGetCounters());
    }

    public long getCountersOrDefault(String object, long l10) {
        object.getClass();
        MapFieldLite mapFieldLite = this.internalGetCounters();
        boolean bl2 = mapFieldLite.containsKey(object);
        if (bl2) {
            object = (Long)mapFieldLite.get(object);
            l10 = (Long)object;
        }
        return l10;
    }

    public long getCountersOrThrow(String object) {
        object.getClass();
        MapFieldLite mapFieldLite = this.internalGetCounters();
        boolean bl2 = mapFieldLite.containsKey(object);
        if (bl2) {
            return (Long)mapFieldLite.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public Map getCustomAttributes() {
        return this.getCustomAttributesMap();
    }

    public int getCustomAttributesCount() {
        return this.internalGetCustomAttributes().size();
    }

    public Map getCustomAttributesMap() {
        return Collections.unmodifiableMap(this.internalGetCustomAttributes());
    }

    public String getCustomAttributesOrDefault(String string2, String string3) {
        string2.getClass();
        MapFieldLite mapFieldLite = this.internalGetCustomAttributes();
        boolean bl2 = mapFieldLite.containsKey(string2);
        if (bl2) {
            string3 = string2 = mapFieldLite.get(string2);
            string3 = string2;
        }
        return string3;
    }

    public String getCustomAttributesOrThrow(String object) {
        object.getClass();
        MapFieldLite mapFieldLite = this.internalGetCustomAttributes();
        boolean bl2 = mapFieldLite.containsKey(object);
        if (bl2) {
            return (String)mapFieldLite.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public long getDurationUs() {
        return this.durationUs_;
    }

    public boolean getIsAuto() {
        return this.isAuto_;
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    public PerfSession getPerfSessions(int n10) {
        return (PerfSession)this.perfSessions_.get(n10);
    }

    public int getPerfSessionsCount() {
        return this.perfSessions_.size();
    }

    public List getPerfSessionsList() {
        return this.perfSessions_;
    }

    public PerfSessionOrBuilder getPerfSessionsOrBuilder(int n10) {
        return (PerfSessionOrBuilder)this.perfSessions_.get(n10);
    }

    public List getPerfSessionsOrBuilderList() {
        return this.perfSessions_;
    }

    public TraceMetric getSubtraces(int n10) {
        return (TraceMetric)this.subtraces_.get(n10);
    }

    public int getSubtracesCount() {
        return this.subtraces_.size();
    }

    public List getSubtracesList() {
        return this.subtraces_;
    }

    public TraceMetricOrBuilder getSubtracesOrBuilder(int n10) {
        return (TraceMetricOrBuilder)this.subtraces_.get(n10);
    }

    public List getSubtracesOrBuilderList() {
        return this.subtraces_;
    }

    public boolean hasClientStartTimeUs() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasDurationUs() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasIsAuto() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasName() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }
}

