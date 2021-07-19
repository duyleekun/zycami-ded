/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface Messages$UnreadTupleOrBuilder
extends MessageOrBuilder {
    public ByteString getBinaryMsg();

    public String getCid();

    public ByteString getCidBytes();

    public int getConvType();

    public String getData();

    public ByteString getDataBytes();

    public String getFrom();

    public ByteString getFromBytes();

    public boolean getMentioned();

    public String getMid();

    public ByteString getMidBytes();

    public long getPatchTimestamp();

    public long getTimestamp();

    public int getUnread();

    public boolean hasBinaryMsg();

    public boolean hasCid();

    public boolean hasConvType();

    public boolean hasData();

    public boolean hasFrom();

    public boolean hasMentioned();

    public boolean hasMid();

    public boolean hasPatchTimestamp();

    public boolean hasTimestamp();

    public boolean hasUnread();
}

