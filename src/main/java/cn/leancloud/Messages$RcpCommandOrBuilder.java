/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface Messages$RcpCommandOrBuilder
extends MessageOrBuilder {
    public String getCid();

    public ByteString getCidBytes();

    public String getFrom();

    public ByteString getFromBytes();

    public String getId();

    public ByteString getIdBytes();

    public boolean getRead();

    public long getT();

    public boolean hasCid();

    public boolean hasFrom();

    public boolean hasId();

    public boolean hasRead();

    public boolean hasT();
}

