/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface Messages$ReadTupleOrBuilder
extends MessageOrBuilder {
    public String getCid();

    public ByteString getCidBytes();

    public String getMid();

    public ByteString getMidBytes();

    public long getTimestamp();

    public boolean hasCid();

    public boolean hasMid();

    public boolean hasTimestamp();
}

