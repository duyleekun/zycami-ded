/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.z.l;

import android.text.TextUtils;
import com.google.protobuf.InvalidProtocolBufferException;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import com.zhiyun.proto.ZYEvent$Event;
import com.zhiyun.proto.ZYEvent$Event$a;
import com.zhiyun.remoteprotocol.constant.ProtoType;
import d.v.z.l.a;
import d.v.z.l.c;
import d.v.z.l.j;
import d.v.z.o.i;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class f
extends c {
    private final Map c;
    private final StringBuilder d;
    private final Map e;

    public f() {
        HashMap hashMap = new HashMap();
        this.c = hashMap;
        this.d = hashMap;
        this.e = hashMap = new HashMap();
    }

    private void i(String string2, String string3) {
        this.c.put(string2, string3);
    }

    public ProtoType a() {
        return ProtoType.EVENT;
    }

    public byte[] c() {
        Object object;
        int n10;
        Object object2 = this.d;
        int n11 = ((StringBuilder)object2).length();
        if (n11 > 0) {
            object2 = this.d;
            n10 = ((StringBuilder)object2).length() + -1;
            StringBuilder stringBuilder = this.d;
            int n12 = stringBuilder.length();
            ((StringBuilder)object2).delete(n10, n12);
            object2 = this.d.toString();
            object = "Sta_Move";
            this.i((String)object, (String)object2);
        }
        object2 = ZYEvent$Event.newBuilder();
        object = this.getErrorCode();
        object2 = ((ZYEvent$Event$a)object2).f((ZYEnumDefine$ErrorCode)object);
        object = this.c;
        object2 = ((ZYEvent$Event)((ZYEvent$Event$a)object2).c((Map)object).buildPartial()).toByteArray();
        n10 = ((Object)object2).length;
        this.h(n10);
        return object2;
    }

    public void clear() {
        super.clear();
        this.c.clear();
        StringBuilder stringBuilder = this.d;
        int n10 = stringBuilder.length();
        stringBuilder.delete(0, n10);
        this.e.clear();
    }

    public boolean d(byte[] object) {
        try {
            object = ZYEvent$Event.parseFrom((byte[])object);
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            m.a.a.f(invalidProtocolBufferException);
            return false;
        }
        Object object2 = ((ZYEvent$Event)object).getErrorCode();
        this.b((ZYEnumDefine$ErrorCode)object2);
        object2 = this.c;
        object2.clear();
        object2 = this.c;
        object = ((ZYEvent$Event)object).getEventListMap();
        object2.putAll(object);
        object = this.e;
        object.clear();
        object = this.e;
        object2 = this.c;
        String string2 = "Sta_Move";
        object2 = object2.get(string2);
        object2 = (String)object2;
        object2 = i.p((String)object2);
        object.putAll(object2);
        return true;
    }

    public void j(String string2, float f10) {
        StringBuilder stringBuilder = this.d;
        stringBuilder.append(string2);
        stringBuilder.append(":");
        stringBuilder.append(f10);
        stringBuilder.append(",");
    }

    public f k() {
        f f10 = new f();
        this.e(f10);
        Object object = f10.c;
        Object object2 = this.c;
        object.putAll(object2);
        object = f10.d;
        object2 = this.d.toString();
        ((StringBuilder)object).append((String)object2);
        object = this.e;
        object2 = f10.e;
        Objects.requireNonNull(object2);
        a a10 = new a((Map)object2);
        object.forEach(a10);
        return f10;
    }

    public Map l() {
        return this.e;
    }

    public j m() {
        String[] stringArray = this.c;
        Object object = "P_Track";
        stringArray = (String)stringArray.get(object);
        int n10 = TextUtils.isEmpty((CharSequence)stringArray);
        float f10 = 0.0f;
        if (n10 != 0) {
            return null;
        }
        object = ",";
        stringArray = stringArray.split((String)object);
        n10 = stringArray.length;
        int n11 = 4;
        float f11 = 5.6E-45f;
        if (n10 != n11) {
            return null;
        }
        f10 = d.v.e.h.c.a(stringArray[0]);
        f11 = d.v.e.h.c.a(stringArray[1]);
        float f12 = d.v.e.h.c.a(stringArray[2]);
        float f13 = d.v.e.h.c.a(stringArray[3]);
        object = new j(f10, f11, f12, f13);
        return object;
    }

    public boolean n() {
        return this.c.containsKey("P_Capture");
    }

    public boolean o() {
        return this.c.containsKey("P_SwitchCameraPosition");
    }

    public boolean p() {
        return this.c.containsKey("P_SwitchPhotoAndVideo");
    }

    public void q() {
        this.i("P_Capture", "");
    }

    public void r() {
        this.i("P_SwitchCameraPosition", "");
    }

    public void s() {
        this.i("P_SwitchPhotoAndVideo", "");
    }

    public void t(float f10, float f11, float f12, float f13) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f10);
        String string2 = ",";
        stringBuilder.append(string2);
        stringBuilder.append(f11);
        stringBuilder.append(string2);
        stringBuilder.append(f12);
        stringBuilder.append(string2);
        stringBuilder.append(f13);
        string2 = stringBuilder.toString();
        this.i("P_Track", string2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append("eventList=");
        object = this.c;
        stringBuilder.append(object);
        stringBuilder.append(", builder=");
        object = this.d;
        stringBuilder.append(object);
        stringBuilder.append(", moveDirection=");
        object = this.e;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

