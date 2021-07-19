/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.AndroidApplicationInfo;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

public interface ApplicationInfoOrBuilder
extends MessageLiteOrBuilder {
    public boolean containsCustomAttributes(String var1);

    public AndroidApplicationInfo getAndroidAppInfo();

    public String getAppInstanceId();

    public ByteString getAppInstanceIdBytes();

    public ApplicationProcessState getApplicationProcessState();

    public Map getCustomAttributes();

    public int getCustomAttributesCount();

    public Map getCustomAttributesMap();

    public String getCustomAttributesOrDefault(String var1, String var2);

    public String getCustomAttributesOrThrow(String var1);

    public String getGoogleAppId();

    public ByteString getGoogleAppIdBytes();

    public boolean hasAndroidAppInfo();

    public boolean hasAppInstanceId();

    public boolean hasApplicationProcessState();

    public boolean hasGoogleAppId();
}

