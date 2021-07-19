/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$ReadTuple;
import cn.leancloud.Messages$ReadTupleOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface Messages$ReadCommandOrBuilder
extends MessageOrBuilder {
    public String getCid();

    public ByteString getCidBytes();

    public String getCids(int var1);

    public ByteString getCidsBytes(int var1);

    public int getCidsCount();

    public List getCidsList();

    public Messages.ReadTuple getConvs(int var1);

    public int getConvsCount();

    public List getConvsList();

    public Messages.ReadTupleOrBuilder getConvsOrBuilder(int var1);

    public List getConvsOrBuilderList();

    public boolean hasCid();
}

