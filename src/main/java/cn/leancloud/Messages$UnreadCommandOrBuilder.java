/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$UnreadTuple;
import cn.leancloud.Messages$UnreadTupleOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface Messages$UnreadCommandOrBuilder
extends MessageOrBuilder {
    public Messages$UnreadTuple getConvs(int var1);

    public int getConvsCount();

    public List getConvsList();

    public Messages$UnreadTupleOrBuilder getConvsOrBuilder(int var1);

    public List getConvsOrBuilderList();

    public long getNotifTime();

    public boolean hasNotifTime();
}

