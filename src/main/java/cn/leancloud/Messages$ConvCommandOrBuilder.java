/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$ConvMemberInfo;
import cn.leancloud.Messages$ConvMemberInfoOrBuilder;
import cn.leancloud.Messages$ErrorCommand;
import cn.leancloud.Messages$ErrorCommandOrBuilder;
import cn.leancloud.Messages$JsonObjectMessage;
import cn.leancloud.Messages$JsonObjectMessageOrBuilder;
import cn.leancloud.Messages$MaxReadTuple;
import cn.leancloud.Messages$MaxReadTupleOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface Messages$ConvCommandOrBuilder
extends MessageOrBuilder {
    public String getAllowedPids(int var1);

    public ByteString getAllowedPidsBytes(int var1);

    public int getAllowedPidsCount();

    public List getAllowedPidsList();

    public Messages$JsonObjectMessage getAttr();

    public Messages$JsonObjectMessage getAttrModified();

    public Messages$JsonObjectMessageOrBuilder getAttrModifiedOrBuilder();

    public Messages$JsonObjectMessageOrBuilder getAttrOrBuilder();

    public String getCdate();

    public ByteString getCdateBytes();

    public String getCid();

    public ByteString getCidBytes();

    public String getCids(int var1);

    public ByteString getCidsBytes(int var1);

    public int getCidsCount();

    public List getCidsList();

    public int getCount();

    public boolean getExisting();

    public Messages$ErrorCommand getFailedPids(int var1);

    public int getFailedPidsCount();

    public List getFailedPidsList();

    public Messages$ErrorCommandOrBuilder getFailedPidsOrBuilder(int var1);

    public List getFailedPidsOrBuilderList();

    public int getFlag();

    public Messages$ConvMemberInfo getInfo();

    public Messages$ConvMemberInfoOrBuilder getInfoOrBuilder();

    public String getInitBy();

    public ByteString getInitByBytes();

    public int getLimit();

    public String getM(int var1);

    public ByteString getMBytes(int var1);

    public int getMCount();

    public List getMList();

    public long getMaxAckTimestamp();

    public long getMaxReadTimestamp();

    public Messages.MaxReadTuple getMaxReadTuples(int var1);

    public int getMaxReadTuplesCount();

    public List getMaxReadTuplesList();

    public Messages.MaxReadTupleOrBuilder getMaxReadTuplesOrBuilder(int var1);

    public List getMaxReadTuplesOrBuilderList();

    public String getN();

    public ByteString getNBytes();

    public String getNext();

    public ByteString getNextBytes();

    public boolean getQueryAllMembers();

    public Messages$JsonObjectMessage getResults();

    public Messages$JsonObjectMessageOrBuilder getResultsOrBuilder();

    public String getS();

    public ByteString getSBytes();

    public int getSkip();

    public String getSort();

    public ByteString getSortBytes();

    public boolean getStatusPub();

    public boolean getStatusSub();

    public int getStatusTTL();

    public long getT();

    public String getTargetClientId();

    public ByteString getTargetClientIdBytes();

    public boolean getTempConv();

    public String getTempConvIds(int var1);

    public ByteString getTempConvIdsBytes(int var1);

    public int getTempConvIdsCount();

    public List getTempConvIdsList();

    public int getTempConvTTL();

    public boolean getTransient();

    public String getUdate();

    public ByteString getUdateBytes();

    public boolean getUnique();

    public String getUniqueId();

    public ByteString getUniqueIdBytes();

    public Messages$JsonObjectMessage getWhere();

    public Messages$JsonObjectMessageOrBuilder getWhereOrBuilder();

    public boolean hasAttr();

    public boolean hasAttrModified();

    public boolean hasCdate();

    public boolean hasCid();

    public boolean hasCount();

    public boolean hasExisting();

    public boolean hasFlag();

    public boolean hasInfo();

    public boolean hasInitBy();

    public boolean hasLimit();

    public boolean hasMaxAckTimestamp();

    public boolean hasMaxReadTimestamp();

    public boolean hasN();

    public boolean hasNext();

    public boolean hasQueryAllMembers();

    public boolean hasResults();

    public boolean hasS();

    public boolean hasSkip();

    public boolean hasSort();

    public boolean hasStatusPub();

    public boolean hasStatusSub();

    public boolean hasStatusTTL();

    public boolean hasT();

    public boolean hasTargetClientId();

    public boolean hasTempConv();

    public boolean hasTempConvTTL();

    public boolean hasTransient();

    public boolean hasUdate();

    public boolean hasUnique();

    public boolean hasUniqueId();

    public boolean hasWhere();
}

