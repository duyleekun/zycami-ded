/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Size
 */
package d.v.z.l;

import android.text.TextUtils;
import android.util.Size;
import androidx.core.util.Pair;
import com.google.protobuf.InvalidProtocolBufferException;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import com.zhiyun.proto.ZYEnumDefine$EventTypeAction;
import com.zhiyun.proto.ZYStateInfo$StateInfo;
import com.zhiyun.proto.ZYStateInfo$StateInfo$a;
import com.zhiyun.remoteprotocol.constant.ProtoType;
import d.v.z.l.b;
import d.v.z.l.c;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import m.a.a;

public class i
extends c {
    private ZYEnumDefine$EventTypeAction c;
    private final Map d;
    private final StringBuilder e;
    private boolean f;

    public i() {
        Serializable serializable;
        this.d = serializable = new Serializable();
        this.e = serializable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private float[] V(String object) {
        Object object2 = this.d;
        int n10 = TextUtils.isEmpty((CharSequence)(object = (String)object2.get(object)));
        if (n10 != 0) {
            return null;
        }
        object2 = "~";
        object = ((String)object).split((String)object2);
        n10 = ((Object)object).length;
        int n11 = 2;
        int n12 = 1;
        if (n10 < n11) {
            object2 = new Object[n12];
            object2[0] = object = Arrays.toString((Object[])object);
            a.i("\u53d8\u91cf\u8303\u56f4\u81f3\u5c11\u5f972\u4f4d:%s", object2);
            return null;
        }
        n10 = ((Object)object).length;
        object2 = new float[n10];
        n11 = 0;
        Object[] objectArray = null;
        try {
            while (true) {
                int n13;
                if (n11 >= (n13 = ((Object)object).length)) {
                    return object2;
                }
                Object object3 = object[n11];
                float f10 = Float.parseFloat((String)object3);
                object2[n11] = f10;
                ++n11;
            }
        }
        catch (NumberFormatException numberFormatException) {
            objectArray = new Object[n12];
            objectArray[0] = object = Arrays.toString((Object[])object);
            a.k(numberFormatException, "\u6570\u636e\u89e3\u6790\u5f02\u5e38,%s", objectArray);
            return null;
        }
    }

    private final String Y(float ... fArray) {
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i10 = 0; i10 < (n10 = fArray.length); ++i10) {
            float f10 = fArray[i10];
            stringBuilder.append(f10);
            n10 = fArray.length + -1;
            if (i10 >= n10) continue;
            String string2 = "~";
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    private void j(String string2, String string3) {
        this.d.put(string2, string3);
    }

    private void r0(String string2, float ... object) {
        int n10;
        if (object != null && (n10 = ((float[])object).length) != 0) {
            object = this.Y((float)object);
            this.j(string2, (String)object);
        }
    }

    public boolean A() {
        return this.d.containsKey("P_ParaZoomDisplayArea");
    }

    public boolean B() {
        return this.d.containsKey("P_RenderSize");
    }

    public boolean C() {
        return this.d.containsKey("P_VideoTransState");
    }

    public ZYEnumDefine$EventTypeAction D() {
        return this.c;
    }

    public float[] E() {
        return this.V("P_ParaZoomArea");
    }

    public Float F() {
        return d.v.z.o.i.l((String)this.d.get("P_ParaZoom"));
    }

    public String G() {
        return (String)this.d.get("P_CameraDirection");
    }

    public Float H() {
        return d.v.z.o.i.l((String)this.d.get("P_ParaFocus"));
    }

    public String I() {
        return (String)this.d.get("P_ControllerID");
    }

    public Long J() {
        return d.v.z.o.i.n((String)this.d.get("P_RecordTime"));
    }

    public Pair K() {
        Object object = this.d;
        Object object2 = "P_Battery";
        object = (String)object.get(object2);
        int n10 = TextUtils.isEmpty((CharSequence)object);
        int n11 = 0;
        if (n10 != 0) {
            return null;
        }
        if ((object = d.v.z.o.i.m((String)object)) == null) {
            return null;
        }
        n10 = (Integer)object;
        if (n10 > (n11 = 200)) {
            n10 = 1;
        } else {
            n10 = 0;
            object2 = null;
        }
        object2 = n10 != 0;
        int n12 = (Integer)object;
        int n13 = (Integer)object;
        if (n12 >= n11) {
            n13 -= n11;
        }
        object = n13;
        return Pair.create(object2, object);
    }

    public String L() {
        return (String)this.d.get("P_CaptureState");
    }

    public String M() {
        return (String)this.d.get("P_Mode");
    }

    public String N() {
        return (String)this.d.get("P_Orientation");
    }

    public Pair O() {
        Object object = this.d;
        Object object2 = "Sta_Battery";
        object = (String)object.get(object2);
        int n10 = TextUtils.isEmpty((CharSequence)object);
        int n11 = 0;
        if (n10 != 0) {
            return null;
        }
        if ((object = d.v.z.o.i.m((String)object)) == null) {
            return null;
        }
        n10 = (Integer)object;
        if (n10 > (n11 = 200)) {
            n10 = 1;
        } else {
            n10 = 0;
            object2 = null;
        }
        object2 = n10 != 0;
        int n12 = (Integer)object;
        int n13 = (Integer)object;
        if (n12 >= n11) {
            n13 -= n11;
        }
        object = n13;
        return Pair.create(object2, object);
    }

    public String P() {
        return (String)this.d.get("Sta_ConState");
    }

    public String Q() {
        return (String)this.d.get("P_Relationship");
    }

    public Map R() {
        return d.v.z.o.i.q((String)this.d.get("P_TimeLapseParams"));
    }

    public float[] S() {
        return this.V("P_ParaZoomDisplayArea");
    }

    public Size T() {
        String string2;
        String string3;
        int n10;
        Object object = this.d;
        String string4 = "P_RenderSize";
        int n11 = TextUtils.isEmpty((CharSequence)(object = (String)object.get(string4)));
        if (n11 != 0) {
            return null;
        }
        string4 = "x";
        n11 = ((String[])(object = object.split(string4))).length;
        if (n11 != (n10 = 2)) {
            return null;
        }
        n11 = 1;
        try {
            string3 = object[0];
        }
        catch (NumberFormatException numberFormatException) {
            Object[] objectArray = new Object[n10];
            string2 = object[0];
            objectArray[0] = string2;
            objectArray[n11] = object = object[n11];
            a.g(numberFormatException, "\u6570\u636e\u89e3\u6790\u5f02\u5e38,%s,%s", objectArray);
            return null;
        }
        int n12 = Integer.parseInt(string3);
        string2 = object[n11];
        int n13 = Integer.parseInt(string2);
        string4 = new Size(n12, n13);
        return string4;
    }

    public String U() {
        return (String)this.d.get("P_VideoTransState");
    }

    public void W() {
        String string2 = "";
        this.n0(string2);
        this.g0(false, 0);
        this.h0(string2);
        this.i0(string2);
        this.j0(string2);
        this.f0(0L);
        this.e0(string2);
        Object object = this;
        this.i(0L, 0L, 0L, 0L);
        this.b0(0.0f);
        int n10 = 2;
        Object object2 = object = (Object)new float[n10];
        object2[0] = 0.0f;
        object2[1] = 0.0f;
        this.a0((float[])object);
        float[] fArray = new float[n10];
        fArray[0] = 0.0f;
        fArray[1] = 0.0f;
        this.o0(fArray);
        this.d0(0.0f);
        this.p0(0, 0);
        this.q0(string2);
        this.c0(string2);
        this.l0(false, 0);
        this.m0(string2);
    }

    public boolean X() {
        return this.f;
    }

    public void Z(ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction) {
        this.c = zYEnumDefine$EventTypeAction;
    }

    public ProtoType a() {
        return ProtoType.STATE_INFO;
    }

    public void a0(float ... fArray) {
        this.r0("P_ParaZoomArea", fArray);
    }

    public void b0(float f10) {
        String string2 = String.valueOf(f10);
        this.j("P_ParaZoom", string2);
    }

    public byte[] c() {
        Object object;
        CharSequence charSequence;
        int n10;
        Object object2 = this.e;
        int n11 = ((StringBuilder)object2).length();
        if (n11 > 0) {
            object2 = this.e;
            n10 = ((StringBuilder)object2).length() + -1;
            charSequence = this.e;
            int n12 = charSequence.length();
            ((StringBuilder)object2).delete(n10, n12);
            object2 = this.e.toString();
            object = "P_TimeLapseParams";
            this.j((String)object, (String)object2);
        }
        if ((object2 = this.c) == (object = ZYEnumDefine$EventTypeAction.EventTypeActionRead) && (n11 = (int)(this.f ? 1 : 0)) == 0) {
            object2 = this.d.entrySet().iterator();
            while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                object = (Map.Entry)object2.next();
                charSequence = "";
                object.setValue(charSequence);
            }
        }
        object2 = ZYStateInfo$StateInfo.newBuilder();
        object = this.c;
        object2 = ((ZYStateInfo$StateInfo$a)object2).g((ZYEnumDefine$EventTypeAction)object);
        object = this.d;
        object2 = ((ZYStateInfo$StateInfo$a)object2).d((Map)object);
        object = this.getErrorCode();
        object2 = ((ZYStateInfo$StateInfo)((ZYStateInfo$StateInfo$a)object2).j((ZYEnumDefine$ErrorCode)object).buildPartial()).toByteArray();
        n10 = ((Object)object2).length;
        this.h(n10);
        return object2;
    }

    public void c0(String string2) {
        this.j("P_CameraDirection", string2);
    }

    public void clear() {
        super.clear();
        this.d.clear();
        Object object = this.c;
        if (object != null) {
            object = null;
            this.c = null;
        }
        object = this.e;
        int n10 = ((StringBuilder)object).length();
        ((StringBuilder)object).delete(0, n10);
        this.f = false;
    }

    public boolean d(byte[] object) {
        try {
            object = ZYStateInfo$StateInfo.parseFrom((byte[])object);
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            a.f(invalidProtocolBufferException);
            return false;
        }
        Object object2 = ((ZYStateInfo$StateInfo)object).getErrorCode();
        this.b((ZYEnumDefine$ErrorCode)object2);
        object2 = ((ZYStateInfo$StateInfo)object).getAction();
        this.Z((ZYEnumDefine$EventTypeAction)object2);
        object2 = this.d;
        object2.clear();
        object2 = this.d;
        object = ((ZYStateInfo$StateInfo)object).getStateListMap();
        object2.putAll(object);
        return true;
    }

    public void d0(float f10) {
        String string2 = String.valueOf(f10);
        this.j("P_ParaFocus", string2);
    }

    public void e0(String string2) {
        this.j("P_ControllerID", string2);
    }

    public void f0(long l10) {
        String string2 = String.valueOf(l10);
        this.j("P_RecordTime", string2);
    }

    /*
     * WARNING - void declaration
     */
    public void g0(boolean bl2, int n10) {
        void var1_4;
        void var2_5;
        String string2;
        if (bl2) {
            int n11 = 200;
        } else {
            boolean bl3 = false;
            string2 = null;
        }
        string2 = String.valueOf((int)(var2_5 + var1_4));
        this.j("P_Battery", string2);
    }

    public void h0(String string2) {
        this.j("P_CaptureState", string2);
    }

    public void i(long l10, long l11, long l12, long l13) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("interval:");
        stringBuilder.append(l10);
        String string2 = ",";
        stringBuilder.append(string2);
        stringBuilder.append("captureDuration");
        String string3 = ":";
        stringBuilder.append(string3);
        stringBuilder.append(l11);
        stringBuilder.append(string2);
        stringBuilder.append("compoundDuration");
        stringBuilder.append(string3);
        stringBuilder.append(l12);
        stringBuilder.append(string2);
        stringBuilder.append("compoundDurationRealTime");
        stringBuilder.append(string3);
        stringBuilder.append(l13);
        string2 = stringBuilder.toString();
        this.e.append(string2);
    }

    public void i0(String string2) {
        this.j("P_Mode", string2);
    }

    public void j0(String string2) {
        this.j("P_Orientation", string2);
    }

    public void k(String string2, long l10) {
        StringBuilder stringBuilder = this.e;
        stringBuilder.append(string2);
        stringBuilder.append(":");
        stringBuilder.append(l10);
        stringBuilder.append(",");
    }

    public void k0(boolean bl2) {
        this.f = bl2;
    }

    public i l() {
        i i10 = new i();
        this.e(i10);
        Object object = ZYEnumDefine$EventTypeAction.forNumber(this.c.getNumber());
        i10.c = object;
        object = this.d;
        Object object2 = i10.d;
        Objects.requireNonNull(object2);
        b b10 = new b((Map)object2);
        object.forEach(b10);
        object = i10.e;
        object2 = this.e.toString();
        ((StringBuilder)object).append((String)object2);
        return i10;
    }

    /*
     * WARNING - void declaration
     */
    public void l0(boolean bl2, int n10) {
        void var1_4;
        void var2_5;
        String string2;
        if (bl2) {
            int n11 = 200;
        } else {
            boolean bl3 = false;
            string2 = null;
        }
        string2 = String.valueOf((int)(var2_5 + var1_4));
        this.j("Sta_Battery", string2);
    }

    public boolean m() {
        return this.d.containsKey("P_ParaZoomArea");
    }

    public void m0(String string2) {
        this.j("Sta_ConState", string2);
    }

    public boolean n() {
        return this.d.containsKey("P_ParaZoom");
    }

    public void n0(String string2) {
        this.j("P_Relationship", string2);
    }

    public boolean o() {
        return this.d.containsKey("P_CameraDirection");
    }

    public void o0(float ... fArray) {
        this.r0("P_ParaZoomDisplayArea", fArray);
    }

    public boolean p() {
        return this.d.containsKey("P_ParaFocus");
    }

    public void p0(int n10, int n11) {
        n10 = n10 / 4 * 4;
        n11 = n11 / 4 * 4;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n10);
        stringBuilder.append("x");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        this.j("P_RenderSize", string2);
    }

    public boolean q() {
        return this.d.containsKey("P_ControllerID");
    }

    public void q0(String string2) {
        this.j("P_VideoTransState", string2);
    }

    public boolean r() {
        return this.d.containsKey("P_RecordTime");
    }

    public boolean s() {
        return this.d.containsKey("P_Battery");
    }

    public boolean t() {
        return this.d.containsKey("P_CaptureState");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append("actionType=");
        object = this.c;
        stringBuilder.append(object);
        stringBuilder.append(", stateList=");
        object = this.d;
        stringBuilder.append(object);
        stringBuilder.append(", timeLapse=");
        object = this.e;
        stringBuilder.append(object);
        stringBuilder.append(", isReply=");
        boolean bl2 = this.f;
        stringBuilder.append(bl2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean u() {
        return this.d.containsKey("P_Mode");
    }

    public boolean v() {
        return this.d.containsKey("P_Orientation");
    }

    public boolean w() {
        return this.d.containsKey("Sta_Battery");
    }

    public boolean x() {
        return this.d.containsKey("Sta_ConState");
    }

    public boolean y() {
        return this.d.containsKey("P_Relationship");
    }

    public boolean z() {
        return this.d.containsKey("P_TimeLapseParams");
    }
}

