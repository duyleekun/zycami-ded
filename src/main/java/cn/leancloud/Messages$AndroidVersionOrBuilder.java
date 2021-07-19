/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface Messages$AndroidVersionOrBuilder
extends MessageOrBuilder {
    public String getApiLevel();

    public ByteString getApiLevelBytes();

    public String getCodename();

    public ByteString getCodenameBytes();

    public boolean hasApiLevel();

    public boolean hasCodename();
}

