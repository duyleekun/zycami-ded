/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.PerfSession$1;
import com.google.firebase.perf.v1.PerfSession$2;
import com.google.firebase.perf.v1.PerfSession$Builder;
import com.google.firebase.perf.v1.PerfSessionOrBuilder;
import com.google.firebase.perf.v1.SessionVerbosity;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Internal$IntList;
import com.google.protobuf.Internal$ListAdapter;
import com.google.protobuf.Internal$ListAdapter$Converter;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class PerfSession
extends GeneratedMessageLite
implements PerfSessionOrBuilder {
    private static final PerfSession DEFAULT_INSTANCE;
    private static volatile Parser PARSER;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    public static final int SESSION_VERBOSITY_FIELD_NUMBER = 2;
    private static final Internal$ListAdapter$Converter sessionVerbosity_converter_;
    private int bitField0_;
    private String sessionId_ = "";
    private Internal$IntList sessionVerbosity_;

    static {
        Object object = new PerfSession$1();
        sessionVerbosity_converter_ = object;
        DEFAULT_INSTANCE = object = new PerfSession();
        GeneratedMessageLite.registerDefaultInstance(PerfSession.class, (GeneratedMessageLite)object);
    }

    private PerfSession() {
        Internal$IntList intList;
        this.sessionVerbosity_ = intList = GeneratedMessageLite.emptyIntList();
    }

    public static /* synthetic */ PerfSession access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(PerfSession perfSession, String string2) {
        perfSession.setSessionId(string2);
    }

    public static /* synthetic */ void access$200(PerfSession perfSession) {
        perfSession.clearSessionId();
    }

    public static /* synthetic */ void access$300(PerfSession perfSession, ByteString byteString) {
        perfSession.setSessionIdBytes(byteString);
    }

    public static /* synthetic */ void access$400(PerfSession perfSession, int n10, SessionVerbosity sessionVerbosity) {
        perfSession.setSessionVerbosity(n10, sessionVerbosity);
    }

    public static /* synthetic */ void access$500(PerfSession perfSession, SessionVerbosity sessionVerbosity) {
        perfSession.addSessionVerbosity(sessionVerbosity);
    }

    public static /* synthetic */ void access$600(PerfSession perfSession, Iterable iterable) {
        perfSession.addAllSessionVerbosity(iterable);
    }

    public static /* synthetic */ void access$700(PerfSession perfSession) {
        perfSession.clearSessionVerbosity();
    }

    private void addAllSessionVerbosity(Iterable object) {
        int n10;
        this.ensureSessionVerbosityIsMutable();
        object = object.iterator();
        while ((n10 = object.hasNext()) != 0) {
            SessionVerbosity sessionVerbosity = (SessionVerbosity)object.next();
            Internal$IntList internal$IntList = this.sessionVerbosity_;
            n10 = sessionVerbosity.getNumber();
            internal$IntList.addInt(n10);
        }
    }

    private void addSessionVerbosity(SessionVerbosity sessionVerbosity) {
        sessionVerbosity.getClass();
        this.ensureSessionVerbosityIsMutable();
        Internal$IntList internal$IntList = this.sessionVerbosity_;
        int n10 = sessionVerbosity.getNumber();
        internal$IntList.addInt(n10);
    }

    private void clearSessionId() {
        String string2;
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.sessionId_ = string2 = PerfSession.getDefaultInstance().getSessionId();
    }

    private void clearSessionVerbosity() {
        Internal$IntList internal$IntList;
        this.sessionVerbosity_ = internal$IntList = GeneratedMessageLite.emptyIntList();
    }

    private void ensureSessionVerbosityIsMutable() {
        Internal$IntList internal$IntList = this.sessionVerbosity_;
        boolean bl2 = internal$IntList.isModifiable();
        if (!bl2) {
            this.sessionVerbosity_ = internal$IntList = GeneratedMessageLite.mutableCopy(internal$IntList);
        }
    }

    public static PerfSession getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static PerfSession$Builder newBuilder() {
        return (PerfSession$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static PerfSession$Builder newBuilder(PerfSession perfSession) {
        return (PerfSession$Builder)DEFAULT_INSTANCE.createBuilder(perfSession);
    }

    public static PerfSession parseDelimitedFrom(InputStream inputStream) {
        return (PerfSession)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PerfSession parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PerfSession)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PerfSession parseFrom(ByteString byteString) {
        return (PerfSession)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static PerfSession parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PerfSession)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PerfSession parseFrom(CodedInputStream codedInputStream) {
        return (PerfSession)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static PerfSession parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PerfSession)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static PerfSession parseFrom(InputStream inputStream) {
        return (PerfSession)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static PerfSession parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PerfSession)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PerfSession parseFrom(ByteBuffer byteBuffer) {
        return (PerfSession)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static PerfSession parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PerfSession)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PerfSession parseFrom(byte[] byArray) {
        return (PerfSession)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static PerfSession parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (PerfSession)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSessionId(String string2) {
        int n10;
        string2.getClass();
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.sessionId_ = string2;
    }

    private void setSessionIdBytes(ByteString object) {
        int n10;
        this.sessionId_ = object = ((ByteString)object).toStringUtf8();
        this.bitField0_ = n10 = this.bitField0_ | 1;
    }

    private void setSessionVerbosity(int n10, SessionVerbosity sessionVerbosity) {
        sessionVerbosity.getClass();
        this.ensureSessionVerbosityIsMutable();
        Internal$IntList internal$IntList = this.sessionVerbosity_;
        int n11 = sessionVerbosity.getNumber();
        internal$IntList.setInt(n10, n11);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<PerfSession>)PerfSession$2.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = PerfSession.class;
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
                objectArray = new Object[4];
                objectArray[0] = "bitField0_";
                objectArray[by2] = "sessionId_";
                objectArray[2] = "sessionVerbosity_";
                objectArray[3] = object = SessionVerbosity.internalGetVerifier();
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u1008\u0000\u0002\u001e", objectArray);
            }
            case 2: {
                return new PerfSession$Builder(null);
            }
            case 1: 
        }
        return new PerfSession();
    }

    public String getSessionId() {
        return this.sessionId_;
    }

    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    public SessionVerbosity getSessionVerbosity(int n10) {
        Internal$ListAdapter$Converter internal$ListAdapter$Converter = sessionVerbosity_converter_;
        Integer n11 = this.sessionVerbosity_.getInt(n10);
        return (SessionVerbosity)internal$ListAdapter$Converter.convert(n11);
    }

    public int getSessionVerbosityCount() {
        return this.sessionVerbosity_.size();
    }

    public List getSessionVerbosityList() {
        Internal$IntList internal$IntList = this.sessionVerbosity_;
        Internal$ListAdapter$Converter internal$ListAdapter$Converter = sessionVerbosity_converter_;
        Internal$ListAdapter internal$ListAdapter = new Internal$ListAdapter(internal$IntList, internal$ListAdapter$Converter);
        return internal$ListAdapter;
    }

    public boolean hasSessionId() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }
}

