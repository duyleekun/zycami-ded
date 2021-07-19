/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface Messages$ConvMemberInfoOrBuilder
extends MessageOrBuilder {
    public String getInfoId();

    public ByteString getInfoIdBytes();

    public String getPid();

    public ByteString getPidBytes();

    public String getRole();

    public ByteString getRoleBytes();

    public boolean hasInfoId();

    public boolean hasPid();

    public boolean hasRole();
}

