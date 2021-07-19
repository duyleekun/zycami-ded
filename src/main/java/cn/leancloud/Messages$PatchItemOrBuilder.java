/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface Messages$PatchItemOrBuilder
extends MessageOrBuilder {
    public ByteString getBinaryMsg();

    public String getCid();

    public ByteString getCidBytes();

    public String getData();

    public ByteString getDataBytes();

    public String getFrom();

    public ByteString getFromBytes();

    public boolean getMentionAll();

    public String getMentionPids(int var1);

    public ByteString getMentionPidsBytes(int var1);

    public int getMentionPidsCount();

    public List getMentionPidsList();

    public String getMid();

    public ByteString getMidBytes();

    public long getPatchCode();

    public String getPatchReason();

    public ByteString getPatchReasonBytes();

    public long getPatchTimestamp();

    public boolean getRecall();

    public long getTimestamp();

    public boolean hasBinaryMsg();

    public boolean hasCid();

    public boolean hasData();

    public boolean hasFrom();

    public boolean hasMentionAll();

    public boolean hasMid();

    public boolean hasPatchCode();

    public boolean hasPatchReason();

    public boolean hasPatchTimestamp();

    public boolean hasRecall();

    public boolean hasTimestamp();
}

