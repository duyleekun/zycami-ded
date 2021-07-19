/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.AndroidApplicationInfo;
import com.google.firebase.perf.v1.AndroidApplicationInfo$Builder;
import com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder;
import com.google.firebase.perf.v1.ApplicationInfo$1;
import com.google.firebase.perf.v1.ApplicationInfo$Builder;
import com.google.firebase.perf.v1.ApplicationInfo$CustomAttributesDefaultEntryHolder;
import com.google.firebase.perf.v1.ApplicationInfoOrBuilder;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

public final class ApplicationInfo
extends GeneratedMessageLite
implements ApplicationInfoOrBuilder {
    public static final int ANDROID_APP_INFO_FIELD_NUMBER = 3;
    public static final int APPLICATION_PROCESS_STATE_FIELD_NUMBER = 5;
    public static final int APP_INSTANCE_ID_FIELD_NUMBER = 2;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 6;
    private static final ApplicationInfo DEFAULT_INSTANCE;
    public static final int GOOGLE_APP_ID_FIELD_NUMBER = 1;
    private static volatile Parser PARSER;
    private AndroidApplicationInfo androidAppInfo_;
    private String appInstanceId_;
    private int applicationProcessState_;
    private int bitField0_;
    private MapFieldLite customAttributes_;
    private String googleAppId_;

    static {
        ApplicationInfo applicationInfo;
        DEFAULT_INSTANCE = applicationInfo = new ApplicationInfo();
        GeneratedMessageLite.registerDefaultInstance(ApplicationInfo.class, applicationInfo);
    }

    private ApplicationInfo() {
        Object object = MapFieldLite.emptyMapField();
        this.customAttributes_ = object;
        this.googleAppId_ = object = "";
        this.appInstanceId_ = object;
    }

    public static /* synthetic */ ApplicationInfo access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(ApplicationInfo applicationInfo, String string2) {
        applicationInfo.setGoogleAppId(string2);
    }

    public static /* synthetic */ void access$1000(ApplicationInfo applicationInfo, ApplicationProcessState applicationProcessState) {
        applicationInfo.setApplicationProcessState(applicationProcessState);
    }

    public static /* synthetic */ void access$1100(ApplicationInfo applicationInfo) {
        applicationInfo.clearApplicationProcessState();
    }

    public static /* synthetic */ Map access$1200(ApplicationInfo applicationInfo) {
        return applicationInfo.getMutableCustomAttributesMap();
    }

    public static /* synthetic */ void access$200(ApplicationInfo applicationInfo) {
        applicationInfo.clearGoogleAppId();
    }

    public static /* synthetic */ void access$300(ApplicationInfo applicationInfo, ByteString byteString) {
        applicationInfo.setGoogleAppIdBytes(byteString);
    }

    public static /* synthetic */ void access$400(ApplicationInfo applicationInfo, String string2) {
        applicationInfo.setAppInstanceId(string2);
    }

    public static /* synthetic */ void access$500(ApplicationInfo applicationInfo) {
        applicationInfo.clearAppInstanceId();
    }

    public static /* synthetic */ void access$600(ApplicationInfo applicationInfo, ByteString byteString) {
        applicationInfo.setAppInstanceIdBytes(byteString);
    }

    public static /* synthetic */ void access$700(ApplicationInfo applicationInfo, AndroidApplicationInfo androidApplicationInfo) {
        applicationInfo.setAndroidAppInfo(androidApplicationInfo);
    }

    public static /* synthetic */ void access$800(ApplicationInfo applicationInfo, AndroidApplicationInfo androidApplicationInfo) {
        applicationInfo.mergeAndroidAppInfo(androidApplicationInfo);
    }

    public static /* synthetic */ void access$900(ApplicationInfo applicationInfo) {
        applicationInfo.clearAndroidAppInfo();
    }

    private void clearAndroidAppInfo() {
        int n10;
        this.androidAppInfo_ = null;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
    }

    private void clearAppInstanceId() {
        String string2;
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.appInstanceId_ = string2 = ApplicationInfo.getDefaultInstance().getAppInstanceId();
    }

    private void clearApplicationProcessState() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.applicationProcessState_ = 0;
    }

    private void clearGoogleAppId() {
        String string2;
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.googleAppId_ = string2 = ApplicationInfo.getDefaultInstance().getGoogleAppId();
    }

    public static ApplicationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map getMutableCustomAttributesMap() {
        return this.internalGetMutableCustomAttributes();
    }

    private MapFieldLite internalGetCustomAttributes() {
        return this.customAttributes_;
    }

    private MapFieldLite internalGetMutableCustomAttributes() {
        MapFieldLite mapFieldLite = this.customAttributes_;
        boolean bl2 = mapFieldLite.isMutable();
        if (!bl2) {
            this.customAttributes_ = mapFieldLite = this.customAttributes_.mutableCopy();
        }
        return this.customAttributes_;
    }

    private void mergeAndroidAppInfo(AndroidApplicationInfo androidApplicationInfo) {
        int n10;
        AndroidApplicationInfo androidApplicationInfo2;
        androidApplicationInfo.getClass();
        AndroidApplicationInfoOrBuilder androidApplicationInfoOrBuilder = this.androidAppInfo_;
        if (androidApplicationInfoOrBuilder != null && androidApplicationInfoOrBuilder != (androidApplicationInfo2 = AndroidApplicationInfo.getDefaultInstance())) {
            androidApplicationInfoOrBuilder = AndroidApplicationInfo.newBuilder(this.androidAppInfo_);
            this.androidAppInfo_ = androidApplicationInfo = (AndroidApplicationInfo)((AndroidApplicationInfo$Builder)((GeneratedMessageLite$Builder)((Object)androidApplicationInfoOrBuilder)).mergeFrom(androidApplicationInfo)).buildPartial();
        } else {
            this.androidAppInfo_ = androidApplicationInfo;
        }
        this.bitField0_ = n10 = this.bitField0_ | 4;
    }

    public static ApplicationInfo$Builder newBuilder() {
        return (ApplicationInfo$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static ApplicationInfo$Builder newBuilder(ApplicationInfo applicationInfo) {
        return (ApplicationInfo$Builder)DEFAULT_INSTANCE.createBuilder(applicationInfo);
    }

    public static ApplicationInfo parseDelimitedFrom(InputStream inputStream) {
        return (ApplicationInfo)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ApplicationInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ApplicationInfo)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ApplicationInfo parseFrom(ByteString byteString) {
        return (ApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static ApplicationInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ApplicationInfo parseFrom(CodedInputStream codedInputStream) {
        return (ApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static ApplicationInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ApplicationInfo parseFrom(InputStream inputStream) {
        return (ApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static ApplicationInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ApplicationInfo parseFrom(ByteBuffer byteBuffer) {
        return (ApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static ApplicationInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ApplicationInfo parseFrom(byte[] byArray) {
        return (ApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static ApplicationInfo parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (ApplicationInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAndroidAppInfo(AndroidApplicationInfo androidApplicationInfo) {
        int n10;
        androidApplicationInfo.getClass();
        this.androidAppInfo_ = androidApplicationInfo;
        this.bitField0_ = n10 = this.bitField0_ | 4;
    }

    private void setAppInstanceId(String string2) {
        int n10;
        string2.getClass();
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.appInstanceId_ = string2;
    }

    private void setAppInstanceIdBytes(ByteString object) {
        int n10;
        this.appInstanceId_ = object = ((ByteString)object).toStringUtf8();
        this.bitField0_ = n10 = this.bitField0_ | 2;
    }

    private void setApplicationProcessState(ApplicationProcessState applicationProcessState) {
        int n10;
        this.applicationProcessState_ = n10 = applicationProcessState.getNumber();
        this.bitField0_ = n10 = this.bitField0_ | 8;
    }

    private void setGoogleAppId(String string2) {
        int n10;
        string2.getClass();
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.googleAppId_ = string2;
    }

    private void setGoogleAppIdBytes(ByteString object) {
        int n10;
        this.googleAppId_ = object = ((ByteString)object).toStringUtf8();
        this.bitField0_ = n10 = this.bitField0_ | 1;
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
        clazz = (Class<ApplicationInfo>)ApplicationInfo$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = ApplicationInfo.class;
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
                objectArray = new Object[8];
                objectArray[0] = "bitField0_";
                objectArray[by2] = "googleAppId_";
                objectArray[2] = "appInstanceId_";
                objectArray[3] = "androidAppInfo_";
                objectArray[4] = "applicationProcessState_";
                objectArray[5] = object = ApplicationProcessState.internalGetVerifier();
                objectArray[6] = "customAttributes_";
                objectArray[7] = object = ApplicationInfo$CustomAttributesDefaultEntryHolder.defaultEntry;
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0001\u0000\u0000\u0001\u1008\u0000\u0002\u1008\u0001\u0003\u1009\u0002\u0005\u100c\u0003\u00062", objectArray);
            }
            case 2: {
                return new ApplicationInfo$Builder(null);
            }
            case 1: 
        }
        return new ApplicationInfo();
    }

    public AndroidApplicationInfo getAndroidAppInfo() {
        AndroidApplicationInfo androidApplicationInfo = this.androidAppInfo_;
        if (androidApplicationInfo == null) {
            androidApplicationInfo = AndroidApplicationInfo.getDefaultInstance();
        }
        return androidApplicationInfo;
    }

    public String getAppInstanceId() {
        return this.appInstanceId_;
    }

    public ByteString getAppInstanceIdBytes() {
        return ByteString.copyFromUtf8(this.appInstanceId_);
    }

    public ApplicationProcessState getApplicationProcessState() {
        int n10 = this.applicationProcessState_;
        ApplicationProcessState applicationProcessState = ApplicationProcessState.forNumber(n10);
        if (applicationProcessState == null) {
            applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        }
        return applicationProcessState;
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

    public String getGoogleAppId() {
        return this.googleAppId_;
    }

    public ByteString getGoogleAppIdBytes() {
        return ByteString.copyFromUtf8(this.googleAppId_);
    }

    public boolean hasAndroidAppInfo() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasAppInstanceId() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasApplicationProcessState() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasGoogleAppId() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }
}

