/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface Messages$DirectCommandOrBuilder
extends MessageOrBuilder {
    public ByteString getBinaryMsg();

    public String getCid();

    public ByteString getCidBytes();

    public int getConvType();

    public String getDt();

    public ByteString getDtBytes();

    public String getFromPeerId();

    public ByteString getFromPeerIdBytes();

    public boolean getHasMore();

    public String getId();

    public ByteString getIdBytes();

    public boolean getMentionAll();

    public String getMentionPids(int var1);

    public ByteString getMentionPidsBytes(int var1);

    public int getMentionPidsCount();

    public List getMentionPidsList();

    public String getMsg();

    public ByteString getMsgBytes();

    public boolean getOffline();

    public long getPatchTimestamp();

    public String getPushData();

    public ByteString getPushDataBytes();

    public boolean getR();

    public String getRoomId();

    public ByteString getRoomIdBytes();

    public long getTimestamp();

    public String getToPeerIds(int var1);

    public ByteString getToPeerIdsBytes(int var1);

    public int getToPeerIdsCount();

    public List getToPeerIdsList();

    public boolean getTransient();

    public String getUid();

    public ByteString getUidBytes();

    public boolean getWill();

    public boolean hasBinaryMsg();

    public boolean hasCid();

    public boolean hasConvType();

    public boolean hasDt();

    public boolean hasFromPeerId();

    public boolean hasHasMore();

    public boolean hasId();

    public boolean hasMentionAll();

    public boolean hasMsg();

    public boolean hasOffline();

    public boolean hasPatchTimestamp();

    public boolean hasPushData();

    public boolean hasR();

    public boolean hasRoomId();

    public boolean hasTimestamp();

    public boolean hasTransient();

    public boolean hasUid();

    public boolean hasWill();
}

