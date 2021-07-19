/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$StatusType;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface Messages$PresenceCommandOrBuilder
extends MessageOrBuilder {
    public String getCid();

    public ByteString getCidBytes();

    public String getSessionPeerIds(int var1);

    public ByteString getSessionPeerIdsBytes(int var1);

    public int getSessionPeerIdsCount();

    public List getSessionPeerIdsList();

    public Messages$StatusType getStatus();

    public boolean hasCid();

    public boolean hasStatus();
}

