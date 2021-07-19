/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.z.l;

import android.text.TextUtils;
import com.google.protobuf.InvalidProtocolBufferException;
import com.zhiyun.proto.ZYDeviceInfo$DeviceInfo;
import com.zhiyun.proto.ZYDeviceInfo$DeviceInfo$a;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import com.zhiyun.remoteprotocol.constant.ProtoType;
import d.v.e.h.d;
import d.v.e.l.z1;
import d.v.z.l.b;
import d.v.z.l.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import m.a.a;

public class e
extends c {
    private static final String d = "android";
    private static final boolean e = false;
    private static final String f = "ip";
    private static final String g = "port_instruction";
    private static final String h = "device_name";
    private static final String i = "platform";
    private static final String j = "enable_hevc";
    private static final String k = "uuid";
    private static final String l = "app_name";
    private static final String m = "protocol_ver";
    private final Map c;

    static {
        e = z1.a("video/hevc");
    }

    public e() {
        HashMap<String, String> hashMap;
        this.c = hashMap = new HashMap<String, String>();
        String string2 = i;
        String string3 = d;
        hashMap.put(string2, string3);
        boolean bl2 = e;
        string2 = bl2 ? "1" : "0";
        hashMap.put(j, string2);
    }

    public ProtoType a() {
        return ProtoType.DEVICE_INFO;
    }

    public byte[] c() {
        Object object = ZYDeviceInfo$DeviceInfo.newBuilder();
        Map map = this.c;
        object = ((ZYDeviceInfo$DeviceInfo)((ZYDeviceInfo$DeviceInfo$a)object).c(map).buildPartial()).toByteArray();
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
            object = ZYDeviceInfo$DeviceInfo.parseFrom((byte[])object);
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            a.f(invalidProtocolBufferException);
            return false;
        }
        Object object2 = ((ZYDeviceInfo$DeviceInfo)object).getErrorCode();
        this.b((ZYEnumDefine$ErrorCode)object2);
        object2 = this.c;
        object2.clear();
        object2 = this.c;
        object = ((ZYDeviceInfo$DeviceInfo)object).getDeviceInfoMap();
        object2.putAll(object);
        return true;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        if (this == object) {
            return true;
        }
        if (object != null && (object2 = this.getClass()) == (clazz = object.getClass())) {
            object = (e)object;
            object2 = this.c;
            object = ((e)object).c;
            return Objects.equals(object2, object);
        }
        return false;
    }

    public int hashCode() {
        Object[] objectArray = new Object[1];
        Map map = this.c;
        objectArray[0] = map;
        return Objects.hash(objectArray);
    }

    public e i() {
        e e10 = new e();
        this.e(e10);
        Map map = this.c;
        Map map2 = e10.c;
        Objects.requireNonNull(map2);
        b b10 = new b(map2);
        map.forEach(b10);
        return e10;
    }

    public String j() {
        return (String)this.c.get(l);
    }

    public String k() {
        return (String)this.c.get(k);
    }

    public Map l() {
        return this.c;
    }

    public String m() {
        return (String)this.c.get(h);
    }

    public String n() {
        return (String)this.c.get(f);
    }

    public int o() {
        return d.v.e.h.d.a((String)this.c.get(g));
    }

    public String p() {
        Object object = this.c;
        String string2 = i;
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = (String)object.get(string2)));
        object = bl2 ? null : ((String)object).toLowerCase();
        return object;
    }

    public String q() {
        return (String)this.c.get(m);
    }

    public boolean r(e e10) {
        boolean bl2;
        boolean bl3 = false;
        if (e10 == null) {
            return false;
        }
        String string2 = d;
        String string3 = e10.p();
        boolean bl4 = string2.equals(string3);
        if (bl4 && (bl4 = this.s()) && (bl2 = e10.s())) {
            bl3 = true;
        }
        return bl3;
    }

    public boolean s() {
        String string2 = (String)this.c.get(j);
        return "1".equals(string2);
    }

    public void t(String string2) {
        this.c.put(l, string2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append("deviceInfoList=");
        object = this.c;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void u(String string2) {
        this.c.put(k, string2);
    }

    public void v(String string2) {
        this.c.put(h, string2);
    }

    public void w(String string2) {
        this.c.put(f, string2);
    }

    public void x(int n10) {
        Map map = this.c;
        String string2 = String.valueOf(n10);
        map.put(g, string2);
    }

    public void y(String string2) {
        this.c.put(m, string2);
    }
}

