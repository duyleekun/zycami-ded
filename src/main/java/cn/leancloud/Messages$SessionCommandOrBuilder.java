/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$SystemInfo;
import cn.leancloud.Messages$SystemInfoOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface Messages$SessionCommandOrBuilder
extends MessageOrBuilder {
    public int getCode();

    public long getConfigBitmap();

    public String getDetail();

    public ByteString getDetailBytes();

    public String getDeviceId();

    public ByteString getDeviceIdBytes();

    public String getDeviceToken();

    public ByteString getDeviceTokenBytes();

    public long getLastPatchTime();

    public long getLastUnreadNotifTime();

    public String getN();

    public ByteString getNBytes();

    public String getOnlineSessionPeerIds(int var1);

    public ByteString getOnlineSessionPeerIdsBytes(int var1);

    public int getOnlineSessionPeerIdsCount();

    public List getOnlineSessionPeerIdsList();

    public boolean getR();

    public String getReason();

    public ByteString getReasonBytes();

    public String getS();

    public ByteString getSBytes();

    public String getSessionPeerIds(int var1);

    public ByteString getSessionPeerIdsBytes(int var1);

    public int getSessionPeerIdsCount();

    public List getSessionPeerIdsList();

    public boolean getSp();

    public String getSt();

    public ByteString getStBytes();

    public int getStTtl();

    public Messages$SystemInfo getSystemInfo();

    public Messages$SystemInfoOrBuilder getSystemInfoOrBuilder();

    public long getT();

    public String getTag();

    public ByteString getTagBytes();

    public String getUa();

    public ByteString getUaBytes();

    public boolean hasCode();

    public boolean hasConfigBitmap();

    public boolean hasDetail();

    public boolean hasDeviceId();

    public boolean hasDeviceToken();

    public boolean hasLastPatchTime();

    public boolean hasLastUnreadNotifTime();

    public boolean hasN();

    public boolean hasR();

    public boolean hasReason();

    public boolean hasS();

    public boolean hasSp();

    public boolean hasSt();

    public boolean hasStTtl();

    public boolean hasSystemInfo();

    public boolean hasT();

    public boolean hasTag();

    public boolean hasUa();
}

