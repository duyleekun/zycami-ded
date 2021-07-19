/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface Messages$ErrorCommandOrBuilder
extends MessageOrBuilder {
    public int getAppCode();

    public String getAppMsg();

    public ByteString getAppMsgBytes();

    public int getCode();

    public String getDetail();

    public ByteString getDetailBytes();

    public String getPids(int var1);

    public ByteString getPidsBytes(int var1);

    public int getPidsCount();

    public List getPidsList();

    public String getReason();

    public ByteString getReasonBytes();

    public boolean hasAppCode();

    public boolean hasAppMsg();

    public boolean hasCode();

    public boolean hasDetail();

    public boolean hasReason();
}

