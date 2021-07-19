/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  mediapipe.MediapipeOptions$MediaPipeOptions
 *  mediapipe.MediapipeOptions$MediaPipeOptions$Builder
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorProto$1;
import com.google.mediapipe.proto.CalculatorProto$ExecutorConfig$Builder;
import com.google.mediapipe.proto.CalculatorProto$ExecutorConfigOrBuilder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import mediapipe.MediapipeOptions;

public final class CalculatorProto$ExecutorConfig
extends GeneratedMessageLite
implements CalculatorProto$ExecutorConfigOrBuilder {
    private static final CalculatorProto$ExecutorConfig DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile Parser PARSER;
    public static final int TYPE_FIELD_NUMBER = 2;
    private byte memoizedIsInitialized = (byte)2;
    private String name_;
    private MediapipeOptions.MediaPipeOptions options_;
    private String type_;

    static {
        CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig;
        DEFAULT_INSTANCE = calculatorProto$ExecutorConfig = new CalculatorProto$ExecutorConfig();
        GeneratedMessageLite.registerDefaultInstance(CalculatorProto$ExecutorConfig.class, calculatorProto$ExecutorConfig);
    }

    private CalculatorProto$ExecutorConfig() {
        String string2;
        this.name_ = string2 = "";
        this.type_ = string2;
    }

    public static /* synthetic */ CalculatorProto$ExecutorConfig access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig, String string2) {
        calculatorProto$ExecutorConfig.setName(string2);
    }

    public static /* synthetic */ void access$200(CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig) {
        calculatorProto$ExecutorConfig.clearName();
    }

    public static /* synthetic */ void access$300(CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig, ByteString byteString) {
        calculatorProto$ExecutorConfig.setNameBytes(byteString);
    }

    public static /* synthetic */ void access$400(CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig, String string2) {
        calculatorProto$ExecutorConfig.setType(string2);
    }

    public static /* synthetic */ void access$500(CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig) {
        calculatorProto$ExecutorConfig.clearType();
    }

    public static /* synthetic */ void access$600(CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig, ByteString byteString) {
        calculatorProto$ExecutorConfig.setTypeBytes(byteString);
    }

    public static /* synthetic */ void access$700(CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig, MediapipeOptions.MediaPipeOptions mediaPipeOptions) {
        calculatorProto$ExecutorConfig.setOptions(mediaPipeOptions);
    }

    public static /* synthetic */ void access$800(CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig, MediapipeOptions.MediaPipeOptions mediaPipeOptions) {
        calculatorProto$ExecutorConfig.mergeOptions(mediaPipeOptions);
    }

    public static /* synthetic */ void access$900(CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig) {
        calculatorProto$ExecutorConfig.clearOptions();
    }

    private void clearName() {
        String string2;
        this.name_ = string2 = CalculatorProto$ExecutorConfig.getDefaultInstance().getName();
    }

    private void clearOptions() {
        this.options_ = null;
    }

    private void clearType() {
        String string2;
        this.type_ = string2 = CalculatorProto$ExecutorConfig.getDefaultInstance().getType();
    }

    public static CalculatorProto$ExecutorConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOptions(MediapipeOptions.MediaPipeOptions mediaPipeOptions) {
        MediapipeOptions.MediaPipeOptions mediaPipeOptions2;
        mediaPipeOptions.getClass();
        MediapipeOptions.MediaPipeOptions mediaPipeOptions3 = this.options_;
        if (mediaPipeOptions3 != null && mediaPipeOptions3 != (mediaPipeOptions2 = MediapipeOptions.MediaPipeOptions.getDefaultInstance())) {
            mediaPipeOptions3 = MediapipeOptions.MediaPipeOptions.newBuilder((MediapipeOptions.MediaPipeOptions)this.options_);
            this.options_ = mediaPipeOptions = (MediapipeOptions.MediaPipeOptions)((MediapipeOptions.MediaPipeOptions.Builder)mediaPipeOptions3.mergeFrom((GeneratedMessageLite)mediaPipeOptions)).buildPartial();
        } else {
            this.options_ = mediaPipeOptions;
        }
    }

    public static CalculatorProto$ExecutorConfig$Builder newBuilder() {
        return (CalculatorProto$ExecutorConfig$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static CalculatorProto$ExecutorConfig$Builder newBuilder(CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig) {
        return (CalculatorProto$ExecutorConfig$Builder)DEFAULT_INSTANCE.createBuilder(calculatorProto$ExecutorConfig);
    }

    public static CalculatorProto$ExecutorConfig parseDelimitedFrom(InputStream inputStream) {
        return (CalculatorProto$ExecutorConfig)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CalculatorProto$ExecutorConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$ExecutorConfig)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CalculatorProto$ExecutorConfig parseFrom(ByteString byteString) {
        return (CalculatorProto$ExecutorConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static CalculatorProto$ExecutorConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$ExecutorConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CalculatorProto$ExecutorConfig parseFrom(CodedInputStream codedInputStream) {
        return (CalculatorProto$ExecutorConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static CalculatorProto$ExecutorConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$ExecutorConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static CalculatorProto$ExecutorConfig parseFrom(InputStream inputStream) {
        return (CalculatorProto$ExecutorConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static CalculatorProto$ExecutorConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$ExecutorConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CalculatorProto$ExecutorConfig parseFrom(ByteBuffer byteBuffer) {
        return (CalculatorProto$ExecutorConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static CalculatorProto$ExecutorConfig parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$ExecutorConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CalculatorProto$ExecutorConfig parseFrom(byte[] byArray) {
        return (CalculatorProto$ExecutorConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static CalculatorProto$ExecutorConfig parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$ExecutorConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setName(String string2) {
        string2.getClass();
        this.name_ = string2;
    }

    private void setNameBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.name_ = object = ((ByteString)object).toStringUtf8();
    }

    private void setOptions(MediapipeOptions.MediaPipeOptions mediaPipeOptions) {
        mediaPipeOptions.getClass();
        this.options_ = mediaPipeOptions;
    }

    private void setType(String string2) {
        string2.getClass();
        this.type_ = string2;
    }

    private void setTypeBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.type_ = object = ((ByteString)object).toStringUtf8();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        object = CalculatorProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
        Object object2 = objectArray.ordinal();
        object2 = object[object2];
        int n10 = 1;
        switch (object2) {
            default: {
                objectArray = new UnsupportedOperationException();
                throw objectArray;
            }
            case 7: {
                if (clazz == null) {
                    n10 = 0;
                    object = null;
                }
                object2 = (byte)n10;
                this.memoizedIsInitialized = (byte)object2;
                return null;
            }
            case 6: {
                return this.memoizedIsInitialized;
            }
            case 5: {
                objectArray = PARSER;
                if (objectArray != null) return objectArray;
                clazz = CalculatorProto$ExecutorConfig.class;
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
                objectArray = new Object[3];
                objectArray[0] = "name_";
                objectArray[n10] = "type_";
                objectArray[2] = "options_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0001\u0001\u0208\u0002\u0208\u0003\u0409", objectArray);
            }
            case 2: {
                return new CalculatorProto$ExecutorConfig$Builder(null);
            }
            case 1: 
        }
        return new CalculatorProto$ExecutorConfig();
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    public MediapipeOptions.MediaPipeOptions getOptions() {
        MediapipeOptions.MediaPipeOptions mediaPipeOptions = this.options_;
        if (mediaPipeOptions == null) {
            mediaPipeOptions = MediapipeOptions.MediaPipeOptions.getDefaultInstance();
        }
        return mediaPipeOptions;
    }

    public String getType() {
        return this.type_;
    }

    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    public boolean hasOptions() {
        boolean bl2;
        MediapipeOptions.MediaPipeOptions mediaPipeOptions = this.options_;
        if (mediaPipeOptions != null) {
            bl2 = true;
        } else {
            bl2 = false;
            mediaPipeOptions = null;
        }
        return bl2;
    }
}

