/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface Messages$ReportCommandOrBuilder
extends MessageOrBuilder {
    public String getData();

    public ByteString getDataBytes();

    public boolean getInitiative();

    public String getType();

    public ByteString getTypeBytes();

    public boolean hasData();

    public boolean hasInitiative();

    public boolean hasType();
}

