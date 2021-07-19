/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$JsonObjectMessage;
import cn.leancloud.Messages$JsonObjectMessageOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface Messages$PubsubCommandOrBuilder
extends MessageOrBuilder {
    public String getCid();

    public ByteString getCidBytes();

    public String getCids(int var1);

    public ByteString getCidsBytes(int var1);

    public int getCidsCount();

    public List getCidsList();

    public Messages$JsonObjectMessage getResults();

    public Messages$JsonObjectMessageOrBuilder getResultsOrBuilder();

    public String getSubtopic();

    public ByteString getSubtopicBytes();

    public String getSubtopics(int var1);

    public ByteString getSubtopicsBytes(int var1);

    public int getSubtopicsCount();

    public List getSubtopicsList();

    public String getTopic();

    public ByteString getTopicBytes();

    public String getTopics(int var1);

    public ByteString getTopicsBytes(int var1);

    public int getTopicsCount();

    public List getTopicsList();

    public boolean hasCid();

    public boolean hasResults();

    public boolean hasSubtopic();

    public boolean hasTopic();
}

