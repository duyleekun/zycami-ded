/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$LogItem;
import cn.leancloud.Messages$LogItemOrBuilder;
import cn.leancloud.Messages$LogsCommand$QueryDirection;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface Messages$LogsCommandOrBuilder
extends MessageOrBuilder {
    public String getChecksum();

    public ByteString getChecksumBytes();

    public String getCid();

    public ByteString getCidBytes();

    public Messages$LogsCommand$QueryDirection getDirection();

    public int getL();

    public int getLctype();

    public int getLimit();

    public Messages$LogItem getLogs(int var1);

    public int getLogsCount();

    public List getLogsList();

    public Messages$LogItemOrBuilder getLogsOrBuilder(int var1);

    public List getLogsOrBuilderList();

    public String getMid();

    public ByteString getMidBytes();

    public boolean getStored();

    public long getT();

    public boolean getTIncluded();

    public String getTmid();

    public ByteString getTmidBytes();

    public long getTt();

    public boolean getTtIncluded();

    public boolean hasChecksum();

    public boolean hasCid();

    public boolean hasDirection();

    public boolean hasL();

    public boolean hasLctype();

    public boolean hasLimit();

    public boolean hasMid();

    public boolean hasStored();

    public boolean hasT();

    public boolean hasTIncluded();

    public boolean hasTmid();

    public boolean hasTt();

    public boolean hasTtIncluded();
}

