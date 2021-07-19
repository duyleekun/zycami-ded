/*
 * Decompiled with CFR 0.151.
 */
package d.v.z.l;

import com.google.protobuf.InvalidProtocolBufferException;
import com.zhiyun.proto.ZYConnect$Connect;
import com.zhiyun.proto.ZYConnect$Connect$a;
import com.zhiyun.proto.ZYEnumDefine$ConnectAction;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import com.zhiyun.remoteprotocol.constant.ProtoType;
import d.v.z.l.b;
import d.v.z.l.c;
import d.v.z.l.e;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class d
extends c {
    private static final String e = "responseCode";
    private ZYEnumDefine$ConnectAction c;
    private final Map d;

    public d() {
        HashMap hashMap;
        this.d = hashMap = new HashMap();
    }

    public ProtoType a() {
        return ProtoType.CONNECT;
    }

    public byte[] c() {
        Object object = ZYConnect$Connect.newBuilder();
        Object object2 = this.getErrorCode();
        object = ((ZYConnect$Connect$a)object).j((ZYEnumDefine$ErrorCode)object2);
        object2 = this.c;
        object = ((ZYConnect$Connect$a)object).g((ZYEnumDefine$ConnectAction)object2);
        object2 = this.d;
        object = ((ZYConnect$Connect)((ZYConnect$Connect$a)object).d((Map)object2).buildPartial()).toByteArray();
        int n10 = ((Object)object).length;
        this.h(n10);
        return object;
    }

    public void clear() {
        super.clear();
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction = this.c;
        if (zYEnumDefine$ConnectAction != null) {
            zYEnumDefine$ConnectAction = null;
            this.c = null;
        }
        this.d.clear();
    }

    public boolean d(byte[] object) {
        try {
            object = ZYConnect$Connect.parseFrom((byte[])object);
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            invalidProtocolBufferException.printStackTrace();
            return false;
        }
        Object object2 = ((ZYConnect$Connect)object).getConnectAction();
        this.c = object2;
        object2 = this.d;
        object2.clear();
        object2 = this.d;
        object = ((ZYConnect$Connect)object).getConnectExtroInfoMap();
        object2.putAll(object);
        return true;
    }

    public d i() {
        d d10 = new d();
        this.e(d10);
        Object object = ZYEnumDefine$ConnectAction.forNumber(this.c.getNumber());
        d10.c = object;
        object = this.d;
        Map map = d10.d;
        Objects.requireNonNull(map);
        b b10 = new b(map);
        object.forEach(b10);
        return d10;
    }

    public ZYEnumDefine$ConnectAction j() {
        return this.c;
    }

    public e k() {
        e e10 = new e();
        e10.clear();
        Map map = e10.l();
        Map map2 = this.d;
        map.putAll(map2);
        return e10;
    }

    public String l() {
        return (String)this.d.get(e);
    }

    public void m(ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction) {
        this.c = zYEnumDefine$ConnectAction;
    }

    public void n(e object) {
        if (object == null) {
            return;
        }
        Map map = this.d;
        object = ((e)object).l();
        map.putAll(object);
    }

    public void o(String string2) {
        this.d.put(e, string2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append("action=");
        object = this.c;
        stringBuilder.append(object);
        stringBuilder.append(", connectExtraInfoList=");
        object = this.d;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

