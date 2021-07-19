/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface Messages$MaxReadTupleOrBuilder
extends MessageOrBuilder {
    public long getMaxAckTimestamp();

    public long getMaxReadTimestamp();

    public String getPid();

    public ByteString getPidBytes();

    public boolean hasMaxAckTimestamp();

    public boolean hasMaxReadTimestamp();

    public boolean hasPid();
}

