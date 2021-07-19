/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.AndroidApplicationInfo;
import com.google.firebase.perf.v1.AndroidApplicationInfo$1;
import com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite$Builder;

public final class AndroidApplicationInfo$Builder
extends GeneratedMessageLite$Builder
implements AndroidApplicationInfoOrBuilder {
    private AndroidApplicationInfo$Builder() {
        AndroidApplicationInfo androidApplicationInfo = AndroidApplicationInfo.access$000();
        super(androidApplicationInfo);
    }

    public /* synthetic */ AndroidApplicationInfo$Builder(AndroidApplicationInfo$1 androidApplicationInfo$1) {
        this();
    }

    public AndroidApplicationInfo$Builder clearPackageName() {
        this.copyOnWrite();
        AndroidApplicationInfo.access$200((AndroidApplicationInfo)this.instance);
        return this;
    }

    public AndroidApplicationInfo$Builder clearSdkVersion() {
        this.copyOnWrite();
        AndroidApplicationInfo.access$500((AndroidApplicationInfo)this.instance);
        return this;
    }

    public AndroidApplicationInfo$Builder clearVersionName() {
        this.copyOnWrite();
        AndroidApplicationInfo.access$800((AndroidApplicationInfo)this.instance);
        return this;
    }

    public String getPackageName() {
        return ((AndroidApplicationInfo)this.instance).getPackageName();
    }

    public ByteString getPackageNameBytes() {
        return ((AndroidApplicationInfo)this.instance).getPackageNameBytes();
    }

    public String getSdkVersion() {
        return ((AndroidApplicationInfo)this.instance).getSdkVersion();
    }

    public ByteString getSdkVersionBytes() {
        return ((AndroidApplicationInfo)this.instance).getSdkVersionBytes();
    }

    public String getVersionName() {
        return ((AndroidApplicationInfo)this.instance).getVersionName();
    }

    public ByteString getVersionNameBytes() {
        return ((AndroidApplicationInfo)this.instance).getVersionNameBytes();
    }

    public boolean hasPackageName() {
        return ((AndroidApplicationInfo)this.instance).hasPackageName();
    }

    public boolean hasSdkVersion() {
        return ((AndroidApplicationInfo)this.instance).hasSdkVersion();
    }

    public boolean hasVersionName() {
        return ((AndroidApplicationInfo)this.instance).hasVersionName();
    }

    public AndroidApplicationInfo$Builder setPackageName(String string2) {
        this.copyOnWrite();
        AndroidApplicationInfo.access$100((AndroidApplicationInfo)this.instance, string2);
        return this;
    }

    public AndroidApplicationInfo$Builder setPackageNameBytes(ByteString byteString) {
        this.copyOnWrite();
        AndroidApplicationInfo.access$300((AndroidApplicationInfo)this.instance, byteString);
        return this;
    }

    public AndroidApplicationInfo$Builder setSdkVersion(String string2) {
        this.copyOnWrite();
        AndroidApplicationInfo.access$400((AndroidApplicationInfo)this.instance, string2);
        return this;
    }

    public AndroidApplicationInfo$Builder setSdkVersionBytes(ByteString byteString) {
        this.copyOnWrite();
        AndroidApplicationInfo.access$600((AndroidApplicationInfo)this.instance, byteString);
        return this;
    }

    public AndroidApplicationInfo$Builder setVersionName(String string2) {
        this.copyOnWrite();
        AndroidApplicationInfo.access$700((AndroidApplicationInfo)this.instance, string2);
        return this;
    }

    public AndroidApplicationInfo$Builder setVersionNameBytes(ByteString byteString) {
        this.copyOnWrite();
        AndroidApplicationInfo.access$900((AndroidApplicationInfo)this.instance, byteString);
        return this;
    }
}

