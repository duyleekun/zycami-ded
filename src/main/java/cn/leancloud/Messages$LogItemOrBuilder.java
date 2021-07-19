/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface Messages$LogItemOrBuilder
extends MessageOrBuilder {
    public long getAckAt();

    public boolean getBin();

    public int getConvType();

    public String getData();

    public ByteString getDataBytes();

    public String getFrom();

    public ByteString getFromBytes();

    public boolean getMentionAll();

    public String getMentionPids(int var1);

    public ByteString getMentionPidsBytes(int var1);

    public int getMentionPidsCount();

    public List getMentionPidsList();

    public String getMsgId();

    public ByteString getMsgIdBytes();

    public long getPatchTimestamp();

    public long getReadAt();

    public long getTimestamp();

    public boolean hasAckAt();

    public boolean hasBin();

    public boolean hasConvType();

    public boolean hasData();

    public boolean hasFrom();

    public boolean hasMentionAll();

    public boolean hasMsgId();

    public boolean hasPatchTimestamp();

    public boolean hasReadAt();

    public boolean hasTimestamp();
}

