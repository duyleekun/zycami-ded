/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$ErrorCommand;
import cn.leancloud.Messages$ErrorCommandOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface Messages$BlacklistCommandOrBuilder
extends MessageOrBuilder {
    public String getAllowedPids(int var1);

    public ByteString getAllowedPidsBytes(int var1);

    public int getAllowedPidsCount();

    public List getAllowedPidsList();

    public String getBlockedCids(int var1);

    public ByteString getBlockedCidsBytes(int var1);

    public int getBlockedCidsCount();

    public List getBlockedCidsList();

    public String getBlockedPids(int var1);

    public ByteString getBlockedPidsBytes(int var1);

    public int getBlockedPidsCount();

    public List getBlockedPidsList();

    public Messages$ErrorCommand getFailedPids(int var1);

    public int getFailedPidsCount();

    public List getFailedPidsList();

    public Messages$ErrorCommandOrBuilder getFailedPidsOrBuilder(int var1);

    public List getFailedPidsOrBuilderList();

    public int getLimit();

    public String getN();

    public ByteString getNBytes();

    public String getNext();

    public ByteString getNextBytes();

    public String getS();

    public ByteString getSBytes();

    public String getSrcCid();

    public ByteString getSrcCidBytes();

    public String getSrcPid();

    public ByteString getSrcPidBytes();

    public long getT();

    public String getToCids(int var1);

    public ByteString getToCidsBytes(int var1);

    public int getToCidsCount();

    public List getToCidsList();

    public String getToPids(int var1);

    public ByteString getToPidsBytes(int var1);

    public int getToPidsCount();

    public List getToPidsList();

    public boolean hasLimit();

    public boolean hasN();

    public boolean hasNext();

    public boolean hasS();

    public boolean hasSrcCid();

    public boolean hasSrcPid();

    public boolean hasT();
}

