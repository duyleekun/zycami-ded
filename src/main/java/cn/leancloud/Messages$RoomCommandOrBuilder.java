/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface Messages$RoomCommandOrBuilder
extends MessageOrBuilder {
    public String getByPeerId();

    public ByteString getByPeerIdBytes();

    public String getN();

    public ByteString getNBytes();

    public String getRoomId();

    public ByteString getRoomIdBytes();

    public String getRoomPeerIds(int var1);

    public ByteString getRoomPeerIdsBytes(int var1);

    public int getRoomPeerIdsCount();

    public List getRoomPeerIdsList();

    public String getS();

    public ByteString getSBytes();

    public long getT();

    public boolean getTransient();

    public boolean hasByPeerId();

    public boolean hasN();

    public boolean hasRoomId();

    public boolean hasS();

    public boolean hasT();

    public boolean hasTransient();
}

