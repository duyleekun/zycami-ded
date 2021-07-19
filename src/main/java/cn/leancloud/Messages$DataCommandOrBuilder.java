/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$JsonObjectMessage;
import cn.leancloud.Messages$JsonObjectMessageOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface Messages$DataCommandOrBuilder
extends MessageOrBuilder {
    public String getIds(int var1);

    public ByteString getIdsBytes(int var1);

    public int getIdsCount();

    public List getIdsList();

    public Messages$JsonObjectMessage getMsg(int var1);

    public int getMsgCount();

    public List getMsgList();

    public Messages$JsonObjectMessageOrBuilder getMsgOrBuilder(int var1);

    public List getMsgOrBuilderList();

    public boolean getOffline();

    public boolean hasOffline();
}

