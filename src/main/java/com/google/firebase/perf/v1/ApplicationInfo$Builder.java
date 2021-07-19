/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.AndroidApplicationInfo;
import com.google.firebase.perf.v1.AndroidApplicationInfo$Builder;
import com.google.firebase.perf.v1.ApplicationInfo;
import com.google.firebase.perf.v1.ApplicationInfo$1;
import com.google.firebase.perf.v1.ApplicationInfoOrBuilder;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.util.Collections;
import java.util.Map;

public final class ApplicationInfo$Builder
extends GeneratedMessageLite$Builder
implements ApplicationInfoOrBuilder {
    private ApplicationInfo$Builder() {
        ApplicationInfo applicationInfo = ApplicationInfo.access$000();
        super(applicationInfo);
    }

    public /* synthetic */ ApplicationInfo$Builder(ApplicationInfo$1 applicationInfo$1) {
        this();
    }

    public ApplicationInfo$Builder clearAndroidAppInfo() {
        this.copyOnWrite();
        ApplicationInfo.access$900((ApplicationInfo)this.instance);
        return this;
    }

    public ApplicationInfo$Builder clearAppInstanceId() {
        this.copyOnWrite();
        ApplicationInfo.access$500((ApplicationInfo)this.instance);
        return this;
    }

    public ApplicationInfo$Builder clearApplicationProcessState() {
        this.copyOnWrite();
        ApplicationInfo.access$1100((ApplicationInfo)this.instance);
        return this;
    }

    public ApplicationInfo$Builder clearCustomAttributes() {
        this.copyOnWrite();
        ApplicationInfo.access$1200((ApplicationInfo)this.instance).clear();
        return this;
    }

    public ApplicationInfo$Builder clearGoogleAppId() {
        this.copyOnWrite();
        ApplicationInfo.access$200((ApplicationInfo)this.instance);
        return this;
    }

    public boolean containsCustomAttributes(String string2) {
        string2.getClass();
        return ((ApplicationInfo)this.instance).getCustomAttributesMap().containsKey(string2);
    }

    public AndroidApplicationInfo getAndroidAppInfo() {
        return ((ApplicationInfo)this.instance).getAndroidAppInfo();
    }

    public String getAppInstanceId() {
        return ((ApplicationInfo)this.instance).getAppInstanceId();
    }

    public ByteString getAppInstanceIdBytes() {
        return ((ApplicationInfo)this.instance).getAppInstanceIdBytes();
    }

    public ApplicationProcessState getApplicationProcessState() {
        return ((ApplicationInfo)this.instance).getApplicationProcessState();
    }

    public Map getCustomAttributes() {
        return this.getCustomAttributesMap();
    }

    public int getCustomAttributesCount() {
        return ((ApplicationInfo)this.instance).getCustomAttributesMap().size();
    }

    public Map getCustomAttributesMap() {
        return Collections.unmodifiableMap(((ApplicationInfo)this.instance).getCustomAttributesMap());
    }

    public String getCustomAttributesOrDefault(String string2, String string3) {
        string2.getClass();
        Map map = ((ApplicationInfo)this.instance).getCustomAttributesMap();
        boolean bl2 = map.containsKey(string2);
        if (bl2) {
            string3 = string2 = map.get(string2);
            string3 = string2;
        }
        return string3;
    }

    public String getCustomAttributesOrThrow(String object) {
        object.getClass();
        Map map = ((ApplicationInfo)this.instance).getCustomAttributesMap();
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            return (String)map.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public String getGoogleAppId() {
        return ((ApplicationInfo)this.instance).getGoogleAppId();
    }

    public ByteString getGoogleAppIdBytes() {
        return ((ApplicationInfo)this.instance).getGoogleAppIdBytes();
    }

    public boolean hasAndroidAppInfo() {
        return ((ApplicationInfo)this.instance).hasAndroidAppInfo();
    }

    public boolean hasAppInstanceId() {
        return ((ApplicationInfo)this.instance).hasAppInstanceId();
    }

    public boolean hasApplicationProcessState() {
        return ((ApplicationInfo)this.instance).hasApplicationProcessState();
    }

    public boolean hasGoogleAppId() {
        return ((ApplicationInfo)this.instance).hasGoogleAppId();
    }

    public ApplicationInfo$Builder mergeAndroidAppInfo(AndroidApplicationInfo androidApplicationInfo) {
        this.copyOnWrite();
        ApplicationInfo.access$800((ApplicationInfo)this.instance, androidApplicationInfo);
        return this;
    }

    public ApplicationInfo$Builder putAllCustomAttributes(Map map) {
        this.copyOnWrite();
        ApplicationInfo.access$1200((ApplicationInfo)this.instance).putAll(map);
        return this;
    }

    public ApplicationInfo$Builder putCustomAttributes(String string2, String string3) {
        string2.getClass();
        string3.getClass();
        this.copyOnWrite();
        ApplicationInfo.access$1200((ApplicationInfo)this.instance).put(string2, string3);
        return this;
    }

    public ApplicationInfo$Builder removeCustomAttributes(String string2) {
        string2.getClass();
        this.copyOnWrite();
        ApplicationInfo.access$1200((ApplicationInfo)this.instance).remove(string2);
        return this;
    }

    public ApplicationInfo$Builder setAndroidAppInfo(AndroidApplicationInfo$Builder androidApplicationInfoOrBuilder) {
        this.copyOnWrite();
        ApplicationInfo applicationInfo = (ApplicationInfo)this.instance;
        androidApplicationInfoOrBuilder = (AndroidApplicationInfo)androidApplicationInfoOrBuilder.build();
        ApplicationInfo.access$700(applicationInfo, (AndroidApplicationInfo)androidApplicationInfoOrBuilder);
        return this;
    }

    public ApplicationInfo$Builder setAndroidAppInfo(AndroidApplicationInfo androidApplicationInfo) {
        this.copyOnWrite();
        ApplicationInfo.access$700((ApplicationInfo)this.instance, androidApplicationInfo);
        return this;
    }

    public ApplicationInfo$Builder setAppInstanceId(String string2) {
        this.copyOnWrite();
        ApplicationInfo.access$400((ApplicationInfo)this.instance, string2);
        return this;
    }

    public ApplicationInfo$Builder setAppInstanceIdBytes(ByteString byteString) {
        this.copyOnWrite();
        ApplicationInfo.access$600((ApplicationInfo)this.instance, byteString);
        return this;
    }

    public ApplicationInfo$Builder setApplicationProcessState(ApplicationProcessState applicationProcessState) {
        this.copyOnWrite();
        ApplicationInfo.access$1000((ApplicationInfo)this.instance, applicationProcessState);
        return this;
    }

    public ApplicationInfo$Builder setGoogleAppId(String string2) {
        this.copyOnWrite();
        ApplicationInfo.access$100((ApplicationInfo)this.instance, string2);
        return this;
    }

    public ApplicationInfo$Builder setGoogleAppIdBytes(ByteString byteString) {
        this.copyOnWrite();
        ApplicationInfo.access$300((ApplicationInfo)this.instance, byteString);
        return this;
    }
}

