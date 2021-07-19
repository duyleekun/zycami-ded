/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface Messages$AckCommandOrBuilder
extends MessageOrBuilder {
    public int getAppCode();

    public String getAppMsg();

    public ByteString getAppMsgBytes();

    public String getCid();

    public ByteString getCidBytes();

    public int getCode();

    public long getFromts();

    public String getIds(int var1);

    public ByteString getIdsBytes(int var1);

    public int getIdsCount();

    public List getIdsList();

    public String getMid();

    public ByteString getMidBytes();

    public String getReason();

    public ByteString getReasonBytes();

    public long getT();

    public long getTots();

    public String getType();

    public ByteString getTypeBytes();

    public String getUid();

    public ByteString getUidBytes();

    public boolean hasAppCode();

    public boolean hasAppMsg();

    public boolean hasCid();

    public boolean hasCode();

    public boolean hasFromts();

    public boolean hasMid();

    public boolean hasReason();

    public boolean hasT();

    public boolean hasTots();

    public boolean hasType();

    public boolean hasUid();
}

