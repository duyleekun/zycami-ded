/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.AndroidApplicationInfo$1;
import com.google.firebase.perf.v1.AndroidApplicationInfo$Builder;
import com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class AndroidApplicationInfo
extends GeneratedMessageLite
implements AndroidApplicationInfoOrBuilder {
    private static final AndroidApplicationInfo DEFAULT_INSTANCE;
    public static final int PACKAGE_NAME_FIELD_NUMBER = 1;
    private static volatile Parser PARSER;
    public static final int SDK_VERSION_FIELD_NUMBER = 2;
    public static final int VERSION_NAME_FIELD_NUMBER = 3;
    private int bitField0_;
    private String packageName_;
    private String sdkVersion_;
    private String versionName_;

    static {
        AndroidApplicationInfo androidApplicationInfo;
        DEFAULT_INSTANCE = androidApplicationInfo = new AndroidApplicationInfo();
        GeneratedMessageLite.registerDefaultInstance(AndroidApplicationInfo.class, androidApplicationInfo);
    }

    private AndroidApplicationInfo() {
        String string2;
        this.packageName_ = string2 = "";
        this.sdkVersion_ = string2;
        this.versionName_ = string2;
    }

    public static /* synthetic */ AndroidApplicationInfo access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(AndroidApplicationInfo androidApplicationInfo, String string2) {
        androidApplicationInfo.setPackageName(string2);
    }

    public static /* synthetic */ void access$200(AndroidApplicationInfo androidApplicationInfo) {
        androidApplicationInfo.clearPackageName();
    }

    public static /* synthetic */ void access$300(AndroidApplicationInfo androidApplicationInfo, ByteString byteString) {
        androidApplicationInfo.setPackageNameBytes(byteString);
    }

    public static /* synthetic */ void access$400(AndroidApplicationInfo androidApplicationInfo, String string2) {
        androidApplicationInfo.setSdkVersion(string2);
    }

    public static /* synthetic */ void access$500(AndroidApplicationInfo androidApplicationInfo) {
        androidApplicationInfo.clearSdkVersion();
    }

    public static /* synthetic */ void access$600(AndroidApplicationInfo androidApplicationInfo, ByteString byteString) {
        androidApplicationInfo.setSdkVersionBytes(byteString);
    }

    public static /* synthetic */ void access$700(AndroidApplicationInfo androidApplicationInfo, String string2) {
        androidApplicationInfo.setVersionName(string2);
    }

    public static /* synthetic */ void access$800(AndroidApplicationInfo androidApplicationInfo) {
        androidApplicationInfo.clearVersionName();
    }

    public static /* synthetic */ void access$900(AndroidApplicationInfo androidApplicationInfo, ByteString byteString) {
        androidApplicationInfo.setVersionNameBytes(byteString);
    }

    private void clearPackageName() {
        String string2;
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.packageName_ = string2 = AndroidApplicationInfo.getDefaultInstance().getPackageName();
    }

    private void clearSdkVersion() {
        String string2;
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.sdkVersion_ = string2 = AndroidApplicationInfo.getDefaultInstance().getSdkVersion();
    }

    private void clearVersionName() {
        String string2;
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.versionName_ = string2 = AndroidApplicationInfo.getDefaultInstance().getVersionName();
    }

    public static AndroidApplicationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static AndroidApplicationInfo$Builder newBuilder() {
        return (AndroidApplicationInfo$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static AndroidApplicationInfo$Builder newBuilder(AndroidApplicationInfo androidApplicationInfo) {
        return (AndroidApplicationInfo$Builder)DEFAULT_INSTANCE.createBuilder(androidApplicationInfo);
    }

    public static AndroidApplicationInfo parseDelimitedFrom(InputStream inputStream) {
        return (AndroidApplicationInfo)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AndroidApplicationInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AndroidApplicationInfo)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AndroidApplicationInfo parseFrom(ByteString byteString) {
        return (AndroidApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static AndroidApplicationInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AndroidApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AndroidApplicationInfo parseFrom(CodedInputStream codedInputStream) {
        return (AndroidApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static AndroidApplicationInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AndroidApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static AndroidApplicationInfo parseFrom(InputStream inputStream) {
        return (AndroidApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static AndroidApplicationInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AndroidApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AndroidApplicationInfo parseFrom(ByteBuffer byteBuffer) {
        return (AndroidApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static AndroidApplicationInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (AndroidApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AndroidApplicationInfo parseFrom(byte[] byArray) {
        return (AndroidApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static AndroidApplicationInfo parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (AndroidApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPackageName(String string2) {
        int n10;
        string2.getClass();
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.packageName_ = string2;
    }

    private void setPackageNameBytes(ByteString object) {
        int n10;
        this.packageName_ = object = ((ByteString)object).toStringUtf8();
        this.bitField0_ = n10 = this.bitField0_ | 1;
    }

    private void setSdkVersion(String string2) {
        int n10;
        string2.getClass();
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.sdkVersion_ = string2;
    }

    private void setSdkVersionBytes(ByteString object) {
        int n10;
        this.sdkVersion_ = object = ((ByteString)object).toStringUtf8();
        this.bitField0_ = n10 = this.bitField0_ | 2;
    }

    private void setVersionName(String string2) {
        int n10;
        string2.getClass();
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.versionName_ = string2;
    }

    private void setVersionNameBytes(ByteString object) {
        int n10;
        this.versionName_ = object = ((ByteString)object).toStringUtf8();
        this.bitField0_ = n10 = this.bitField0_ | 4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<AndroidApplicationInfo>)AndroidApplicationInfo$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = AndroidApplicationInfo.class;
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
                objectArray[by2] = "packageName_";
                objectArray[2] = "sdkVersion_";
                objectArray[3] = "versionName_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1008\u0001\u0003\u1008\u0002", objectArray);
            }
            case 2: {
                return new AndroidApplicationInfo$Builder(null);
            }
            case 1: 
        }
        return new AndroidApplicationInfo();
    }

    public String getPackageName() {
        return this.packageName_;
    }

    public ByteString getPackageNameBytes() {
        return ByteString.copyFromUtf8(this.packageName_);
    }

    public String getSdkVersion() {
        return this.sdkVersion_;
    }

    public ByteString getSdkVersionBytes() {
        return ByteString.copyFromUtf8(this.sdkVersion_);
    }

    public String getVersionName() {
        return this.versionName_;
    }

    public ByteString getVersionNameBytes() {
        return ByteString.copyFromUtf8(this.versionName_);
    }

    public boolean hasPackageName() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasSdkVersion() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasVersionName() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }
}

