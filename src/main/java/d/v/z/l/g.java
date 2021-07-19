/*
 * Decompiled with CFR 0.151.
 */
package d.v.z.l;

import com.google.protobuf.InvalidProtocolBufferException;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import com.zhiyun.proto.ZYHeartbeat$Heartbeat;
import com.zhiyun.proto.ZYHeartbeat$Heartbeat$a;
import com.zhiyun.remoteprotocol.constant.ProtoType;
import d.v.e.h.e;
import d.v.z.l.b;
import d.v.z.l.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import m.a.a;

public class g
extends c {
    private final Map c;

    public g() {
        HashMap hashMap;
        this.c = hashMap = new HashMap();
    }

    public ProtoType a() {
        return ProtoType.HEARTBEAT;
    }

    public byte[] c() {
        Object object = ZYHeartbeat$Heartbeat.newBuilder();
        Object object2 = this.getErrorCode();
        object = ((ZYHeartbeat$Heartbeat$a)object).f((ZYEnumDefine$ErrorCode)object2);
        object2 = this.c;
        object = ((ZYHeartbeat$Heartbeat)((ZYHeartbeat$Heartbeat$a)object).c((Map)object2).buildPartial()).toByteArray();
        int n10 = ((Object)object).length;
        this.h(n10);
        return object;
    }

    public void clear() {
        super.clear();
        this.c.clear();
    }

    public boolean d(byte[] object) {
        try {
            object = ZYHeartbeat$Heartbeat.parseFrom((byte[])object);
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            a.f(invalidProtocolBufferException);
            return false;
        }
        Object object2 = ((ZYHeartbeat$Heartbeat)object).getErrorCode();
        this.b((ZYEnumDefine$ErrorCode)object2);
        object2 = this.c;
        object2.clear();
        object2 = this.c;
        object = ((ZYHeartbeat$Heartbeat)object).getHeartbeatInfoMap();
        object2.putAll(object);
        return true;
    }

    public g i() {
        g g10 = new g();
        this.e(g10);
        Map map = this.c;
        Map map2 = g10.c;
        Objects.requireNonNull(map2);
        b b10 = new b(map2);
        map.forEach(b10);
        return g10;
    }

    public long j() {
        return e.a((String)this.c.get("receiveTime"));
    }

    public long k() {
        return e.a((String)this.c.get("sendTime"));
    }

    public void l(long l10, long l11) {
        Map map = this.c;
        Object object = String.valueOf(l10);
        map.put("sendTime", object);
        object = this.c;
        String string2 = String.valueOf(l11);
        object.put("receiveTime", string2);
    }
}

