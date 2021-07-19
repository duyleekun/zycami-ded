/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface AndroidApplicationInfoOrBuilder
extends MessageLiteOrBuilder {
    public String getPackageName();

    public ByteString getPackageNameBytes();

    public String getSdkVersion();

    public ByteString getSdkVersionBytes();

    public String getVersionName();

    public ByteString getVersionNameBytes();

    public boolean hasPackageName();

    public boolean hasSdkVersion();

    public boolean hasVersionName();
}

