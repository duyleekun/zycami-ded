/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$AndroidVersion;
import cn.leancloud.Messages$AndroidVersionOrBuilder;
import cn.leancloud.Messages$DeviceType;
import cn.leancloud.Messages$SemanticVersion;
import cn.leancloud.Messages$SemanticVersionOrBuilder;
import com.google.protobuf.MessageOrBuilder;

public interface Messages$SystemInfoOrBuilder
extends MessageOrBuilder {
    public Messages$AndroidVersion getAndroidVersion();

    public Messages$AndroidVersionOrBuilder getAndroidVersionOrBuilder();

    public Messages$DeviceType getDeviceType();

    public boolean getIsEmulator();

    public Messages$SemanticVersion getOsVersion();

    public Messages$SemanticVersionOrBuilder getOsVersionOrBuilder();

    public boolean hasAndroidVersion();

    public boolean hasDeviceType();

    public boolean hasIsEmulator();

    public boolean hasOsVersion();
}

