/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.ApplicationInfo;
import com.google.firebase.perf.v1.ApplicationInfo$Builder;
import com.google.firebase.perf.v1.ApplicationInfoOrBuilder;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.GaugeMetric$Builder;
import com.google.firebase.perf.v1.GaugeMetricOrBuilder;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric$Builder;
import com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder;
import com.google.firebase.perf.v1.PerfMetric$1;
import com.google.firebase.perf.v1.PerfMetric$Builder;
import com.google.firebase.perf.v1.PerfMetricOrBuilder;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.firebase.perf.v1.TraceMetric$Builder;
import com.google.firebase.perf.v1.TraceMetricOrBuilder;
import com.google.firebase.perf.v1.TransportInfo;
import com.google.firebase.perf.v1.TransportInfo$Builder;
import com.google.firebase.perf.v1.TransportInfoOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class PerfMetric
extends GeneratedMessageLite
implements PerfMetricOrBuilder {
    public static final int APPLICATION_INFO_FIELD_NUMBER = 1;
    private static final PerfMetric DEFAULT_INSTANCE;
    public static final int GAUGE_METRIC_FIELD_NUMBER = 4;
    public static final int NETWORK_REQUEST_METRIC_FIELD_NUMBER = 3;
    private static volatile Parser PARSER;
    public static final int TRACE_METRIC_FIELD_NUMBER = 2;
    public static final int TRANSPORT_INFO_FIELD_NUMBER = 5;
    private ApplicationInfo applicationInfo_;
    private int bitField0_;
    private GaugeMetric gaugeMetric_;
    private NetworkRequestMetric networkRequestMetric_;
    private TraceMetric traceMetric_;
    private TransportInfo transportInfo_;

    static {
        PerfMetric perfMetric;
        DEFAULT_INSTANCE = perfMetric = new PerfMetric();
        GeneratedMessageLite.registerDefaultInstance(PerfMetric.class, perfMetric);
    }

    private PerfMetric() {
    }

    public static /* synthetic */ PerfMetric access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(PerfMetric perfMetric, ApplicationInfo applicationInfo) {
        perfMetric.setApplicationInfo(applicationInfo);
    }

    public static /* synthetic */ void access$1000(PerfMetric perfMetric, GaugeMetric gaugeMetric) {
        perfMetric.setGaugeMetric(gaugeMetric);
    }

    public static /* synthetic */ void access$1100(PerfMetric perfMetric, GaugeMetric gaugeMetric) {
        perfMetric.mergeGaugeMetric(gaugeMetric);
    }

    public static /* synthetic */ void access$1200(PerfMetric perfMetric) {
        perfMetric.clearGaugeMetric();
    }

    public static /* synthetic */ void access$1300(PerfMetric perfMetric, TransportInfo transportInfo) {
        perfMetric.setTransportInfo(transportInfo);
    }

    public static /* synthetic */ void access$1400(PerfMetric perfMetric, TransportInfo transportInfo) {
        perfMetric.mergeTransportInfo(transportInfo);
    }

    public static /* synthetic */ void access$1500(PerfMetric perfMetric) {
        perfMetric.clearTransportInfo();
    }

    public static /* synthetic */ void access$200(PerfMetric perfMetric, ApplicationInfo applicationInfo) {
        perfMetric.mergeApplicationInfo(applicationInfo);
    }

    public static /* synthetic */ void access$300(PerfMetric perfMetric) {
        perfMetric.clearApplicationInfo();
    }

    public static /* synthetic */ void access$400(PerfMetric perfMetric, TraceMetric traceMetric) {
        perfMetric.setTraceMetric(traceMetric);
    }

    public static /* synthetic */ void access$500(PerfMetric perfMetric, TraceMetric traceMetric) {
        perfMetric.mergeTraceMetric(traceMetric);
    }

    public static /* synthetic */ void access$600(PerfMetric perfMetric) {
        perfMetric.clearTraceMetric();
    }

    public static /* synthetic */ void access$700(PerfMetric perfMetric, NetworkRequestMetric networkRequestMetric) {
        perfMetric.setNetworkRequestMetric(networkRequestMetric);
    }

    public static /* synthetic */ void access$800(PerfMetric perfMetric, NetworkRequestMetric networkRequestMetric) {
        perfMetric.mergeNetworkRequestMetric(networkRequestMetric);
    }

    public static /* synthetic */ void access$900(PerfMetric perfMetric) {
        perfMetric.clearNetworkRequestMetric();
    }

    private void clearApplicationInfo() {
        int n10;
        this.applicationInfo_ = null;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
    }

    private void clearGaugeMetric() {
        int n10;
        this.gaugeMetric_ = null;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
    }

    private void clearNetworkRequestMetric() {
        int n10;
        this.networkRequestMetric_ = null;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
    }

    private void clearTraceMetric() {
        int n10;
        this.traceMetric_ = null;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
    }

    private void clearTransportInfo() {
        int n10;
        this.transportInfo_ = null;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
    }

    public static PerfMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeApplicationInfo(ApplicationInfo applicationInfo) {
        int n10;
        ApplicationInfo applicationInfo2;
        applicationInfo.getClass();
        ApplicationInfoOrBuilder applicationInfoOrBuilder = this.applicationInfo_;
        if (applicationInfoOrBuilder != null && applicationInfoOrBuilder != (applicationInfo2 = ApplicationInfo.getDefaultInstance())) {
            applicationInfoOrBuilder = ApplicationInfo.newBuilder(this.applicationInfo_);
            this.applicationInfo_ = applicationInfo = (ApplicationInfo)((ApplicationInfo$Builder)((GeneratedMessageLite$Builder)((Object)applicationInfoOrBuilder)).mergeFrom(applicationInfo)).buildPartial();
        } else {
            this.applicationInfo_ = applicationInfo;
        }
        this.bitField0_ = n10 = this.bitField0_ | 1;
    }

    private void mergeGaugeMetric(GaugeMetric gaugeMetric) {
        int n10;
        GaugeMetric gaugeMetric2;
        gaugeMetric.getClass();
        GaugeMetricOrBuilder gaugeMetricOrBuilder = this.gaugeMetric_;
        if (gaugeMetricOrBuilder != null && gaugeMetricOrBuilder != (gaugeMetric2 = GaugeMetric.getDefaultInstance())) {
            gaugeMetricOrBuilder = GaugeMetric.newBuilder(this.gaugeMetric_);
            this.gaugeMetric_ = gaugeMetric = (GaugeMetric)((GaugeMetric$Builder)((GeneratedMessageLite$Builder)((Object)gaugeMetricOrBuilder)).mergeFrom(gaugeMetric)).buildPartial();
        } else {
            this.gaugeMetric_ = gaugeMetric;
        }
        this.bitField0_ = n10 = this.bitField0_ | 8;
    }

    private void mergeNetworkRequestMetric(NetworkRequestMetric networkRequestMetric) {
        int n10;
        NetworkRequestMetric networkRequestMetric2;
        networkRequestMetric.getClass();
        NetworkRequestMetricOrBuilder networkRequestMetricOrBuilder = this.networkRequestMetric_;
        if (networkRequestMetricOrBuilder != null && networkRequestMetricOrBuilder != (networkRequestMetric2 = NetworkRequestMetric.getDefaultInstance())) {
            networkRequestMetricOrBuilder = NetworkRequestMetric.newBuilder(this.networkRequestMetric_);
            this.networkRequestMetric_ = networkRequestMetric = (NetworkRequestMetric)((NetworkRequestMetric$Builder)((GeneratedMessageLite$Builder)((Object)networkRequestMetricOrBuilder)).mergeFrom(networkRequestMetric)).buildPartial();
        } else {
            this.networkRequestMetric_ = networkRequestMetric;
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
    }

    private void mergeTraceMetric(TraceMetric traceMetric) {
        int n10;
        TraceMetric traceMetric2;
        traceMetric.getClass();
        TraceMetricOrBuilder traceMetricOrBuilder = this.traceMetric_;
        if (traceMetricOrBuilder != null && traceMetricOrBuilder != (traceMetric2 = TraceMetric.getDefaultInstance())) {
            traceMetricOrBuilder = TraceMetric.newBuilder(this.traceMetric_);
            this.traceMetric_ = traceMetric = (TraceMetric)((TraceMetric$Builder)((GeneratedMessageLite$Builder)((Object)traceMetricOrBuilder)).mergeFrom(traceMetric)).buildPartial();
        } else {
            this.traceMetric_ = traceMetric;
        }
        this.bitField0_ = n10 = this.bitField0_ | 2;
    }

    private void mergeTransportInfo(TransportInfo transportInfo) {
        int n10;
        TransportInfo transportInfo2;
        transportInfo.getClass();
        TransportInfoOrBuilder transportInfoOrBuilder = this.transportInfo_;
        if (transportInfoOrBuilder != null && transportInfoOrBuilder != (transportInfo2 = TransportInfo.getDefaultInstance())) {
            transportInfoOrBuilder = TransportInfo.newBuilder(this.transportInfo_);
            this.transportInfo_ = transportInfo = (TransportInfo)((TransportInfo$Builder)((GeneratedMessageLite$Builder)((Object)transportInfoOrBuilder)).mergeFrom(transportInfo)).buildPartial();
        } else {
            this.transportInfo_ = transportInfo;
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
    }

    public static PerfMetric$Builder newBuilder() {
        return (PerfMetric$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static PerfMetric$Builder newBuilder(PerfMetric perfMetric) {
        return (PerfMetric$Builder)DEFAULT_INSTANCE.createBuilder(perfMetric);
    }

    public static PerfMetric parseDelimitedFrom(InputStream inputStream) {
        return (PerfMetric)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PerfMetric parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PerfMetric)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PerfMetric parseFrom(ByteString byteString) {
        return (PerfMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static PerfMetric parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PerfMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PerfMetric parseFrom(CodedInputStream codedInputStream) {
        return (PerfMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static PerfMetric parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PerfMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static PerfMetric parseFrom(InputStream inputStream) {
        return (PerfMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static PerfMetric parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PerfMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PerfMetric parseFrom(ByteBuffer byteBuffer) {
        return (PerfMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static PerfMetric parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PerfMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PerfMetric parseFrom(byte[] byArray) {
        return (PerfMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static PerfMetric parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (PerfMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setApplicationInfo(ApplicationInfo applicationInfo) {
        int n10;
        applicationInfo.getClass();
        this.applicationInfo_ = applicationInfo;
        this.bitField0_ = n10 = this.bitField0_ | 1;
    }

    private void setGaugeMetric(GaugeMetric gaugeMetric) {
        int n10;
        gaugeMetric.getClass();
        this.gaugeMetric_ = gaugeMetric;
        this.bitField0_ = n10 = this.bitField0_ | 8;
    }

    private void setNetworkRequestMetric(NetworkRequestMetric networkRequestMetric) {
        int n10;
        networkRequestMetric.getClass();
        this.networkRequestMetric_ = networkRequestMetric;
        this.bitField0_ = n10 = this.bitField0_ | 4;
    }

    private void setTraceMetric(TraceMetric traceMetric) {
        int n10;
        traceMetric.getClass();
        this.traceMetric_ = traceMetric;
        this.bitField0_ = n10 = this.bitField0_ | 2;
    }

    private void setTransportInfo(TransportInfo transportInfo) {
        int n10;
        transportInfo.getClass();
        this.transportInfo_ = transportInfo;
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<PerfMetric>)PerfMetric$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
        Object object2 = objectArray.ordinal();
        object2 = clazz[object2];
        byte by2 = 1;
        object = null;
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
                clazz = PerfMetric.class;
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
                objectArray = new Object[6];
                objectArray[0] = "bitField0_";
                objectArray[by2] = "applicationInfo_";
                objectArray[2] = "traceMetric_";
                objectArray[3] = "networkRequestMetric_";
                objectArray[4] = "gaugeMetric_";
                objectArray[5] = "transportInfo_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1009\u0002\u0004\u1009\u0003\u0005\u1009\u0004", objectArray);
            }
            case 2: {
                return new PerfMetric$Builder(null);
            }
            case 1: 
        }
        return new PerfMetric();
    }

    public ApplicationInfo getApplicationInfo() {
        ApplicationInfo applicationInfo = this.applicationInfo_;
        if (applicationInfo == null) {
            applicationInfo = ApplicationInfo.getDefaultInstance();
        }
        return applicationInfo;
    }

    public GaugeMetric getGaugeMetric() {
        GaugeMetric gaugeMetric = this.gaugeMetric_;
        if (gaugeMetric == null) {
            gaugeMetric = GaugeMetric.getDefaultInstance();
        }
        return gaugeMetric;
    }

    public NetworkRequestMetric getNetworkRequestMetric() {
        NetworkRequestMetric networkRequestMetric = this.networkRequestMetric_;
        if (networkRequestMetric == null) {
            networkRequestMetric = NetworkRequestMetric.getDefaultInstance();
        }
        return networkRequestMetric;
    }

    public TraceMetric getTraceMetric() {
        TraceMetric traceMetric = this.traceMetric_;
        if (traceMetric == null) {
            traceMetric = TraceMetric.getDefaultInstance();
        }
        return traceMetric;
    }

    public TransportInfo getTransportInfo() {
        TransportInfo transportInfo = this.transportInfo_;
        if (transportInfo == null) {
            transportInfo = TransportInfo.getDefaultInstance();
        }
        return transportInfo;
    }

    public boolean hasApplicationInfo() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasGaugeMetric() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasNetworkRequestMetric() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasTraceMetric() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasTransportInfo() {
        int n10 = this.bitField0_ & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }
}

