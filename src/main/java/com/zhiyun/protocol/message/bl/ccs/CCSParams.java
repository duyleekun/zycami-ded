/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.ccs;

import com.zhiyun.protocol.constants.Model;
import com.zhiyun.protocol.message.bl.ccs.CCSParams$WireControlerType;
import com.zhiyun.protocol.message.bl.ccs.CCSStatus;
import com.zhiyun.protocol.message.bl.ccs.SDStatus;
import com.zhiyun.protocol.message.bl.ccs.VideoParams;
import d.v.y.c.s1.g.g;
import d.v.y.c.s1.g.h;
import d.v.y.d.k;
import java.util.Map;
import java.util.Objects;

public class CCSParams {
    private final CCSStatus a;
    private final Map b;

    public CCSParams(CCSStatus cCSStatus, Map map) {
        Objects.requireNonNull(cCSStatus);
        this.a = cCSStatus;
        Objects.requireNonNull(map);
        this.b = map;
    }

    private boolean E(short s10) {
        Map map = this.b;
        Short s11 = s10;
        if ((s11 = map.get(s11)) != null) {
            s10 = 1;
        } else {
            s10 = 0;
            s11 = null;
        }
        return s10 != 0;
    }

    private String a(short s10) {
        Map map = this.b;
        Object object = s10;
        if ((object = (String)map.get(object)) == null) {
            object = "";
        }
        return object;
    }

    private int o(short s10) {
        String string2;
        try {
            string2 = this.a(s10);
        }
        catch (Exception exception) {
            return 0;
        }
        return Integer.parseInt(string2);
    }

    public g A() {
        return g.a(this.a((short)120));
    }

    public h B() {
        String string2 = this.a((short)128);
        h h10 = new h(string2);
        return h10;
    }

    public String C() {
        return this.a((short)4);
    }

    public CCSParams$WireControlerType D() {
        short s10 = 117;
        String string2 = this.a(s10);
        string2.hashCode();
        String string3 = "sonyUsb";
        boolean bl2 = string2.equals(string3);
        if (!bl2) {
            string3 = "commonUsb";
            s10 = (short)(string2.equals(string3) ? 1 : 0);
            if (s10 == 0) {
                return CCSParams$WireControlerType.UNKNOW;
            }
            return CCSParams$WireControlerType.COMMON_USB;
        }
        return CCSParams$WireControlerType.SONY_USB;
    }

    public boolean F() {
        return this.E((short)17);
    }

    public boolean G() {
        return this.E((short)11);
    }

    public boolean H() {
        return this.E((short)122);
    }

    public boolean I() {
        return this.E((short)126);
    }

    public boolean J() {
        return this.E((short)125);
    }

    public boolean K() {
        return this.E((short)129);
    }

    public boolean L() {
        return this.E((short)9);
    }

    public boolean M() {
        return this.E((short)127);
    }

    public boolean N() {
        return this.E((short)3);
    }

    public boolean O() {
        return this.E((short)0);
    }

    public boolean P() {
        return this.E((short)7);
    }

    public boolean Q() {
        return this.E((short)5);
    }

    public boolean R() {
        return this.E((short)2);
    }

    public boolean S() {
        return this.E((short)8);
    }

    public boolean T() {
        return this.E((short)515);
    }

    public boolean U() {
        return this.E((short)513);
    }

    public boolean V() {
        return this.E((short)13);
    }

    public boolean W() {
        return this.E((short)124);
    }

    public boolean X() {
        return this.E((short)1);
    }

    public boolean Y() {
        return this.E((short)118);
    }

    public boolean Z() {
        return this.E((short)130);
    }

    public boolean a0() {
        return this.E((short)6);
    }

    public int[] b() {
        int n10;
        int n11;
        String[] stringArray = this.a((short)17).split("x");
        int[] nArray = new int[2];
        nArray[0] = n11 = Integer.valueOf(stringArray[0]).intValue();
        int n12 = 1;
        nArray[n12] = n10 = Integer.valueOf(stringArray[n12]).intValue();
        return nArray;
    }

    public boolean b0() {
        return this.E((short)10);
    }

    public Map c() {
        return this.b;
    }

    public boolean c0() {
        return this.E((short)254);
    }

    public int d() {
        Object object;
        short s10 = 11;
        try {
            object = this.a(s10);
        }
        catch (Exception exception) {
            return 0;
        }
        object = Integer.valueOf((String)object);
        return (Integer)object;
    }

    public boolean d0() {
        return this.E((short)12);
    }

    public String e() {
        short s10 = 123;
        String string2 = this.a(s10);
        boolean bl2 = k.a(string2);
        if (bl2) {
            return string2;
        }
        string2 = this.g();
        bl2 = k.a(string2);
        if (bl2) {
            Object[] objectArray = new Object[]{string2};
            return String.format("http://192.168.2.1/%s.json", objectArray);
        }
        return "";
    }

    public boolean e0() {
        return this.E((short)119);
    }

    public String f() {
        return this.a((short)126);
    }

    public boolean f0() {
        return this.E((short)121);
    }

    public String g() {
        return this.a((short)125);
    }

    public boolean g0() {
        return this.E((short)120);
    }

    public String h() {
        return this.a((short)9);
    }

    public boolean h0() {
        return this.E((short)128);
    }

    public String i() {
        return this.a((short)3);
    }

    public boolean i0() {
        return this.E((short)4);
    }

    public String j() {
        return this.a((short)0);
    }

    public boolean j0() {
        return this.E((short)512);
    }

    public String k() {
        return this.a((short)7);
    }

    public boolean k0() {
        String string2 = this.a((short)122);
        return "1".equals(string2);
    }

    public String l() {
        return this.a((short)5);
    }

    public boolean l0() {
        String string2 = this.a((short)129);
        return "1".equals(string2);
    }

    public String m() {
        return this.a((short)2);
    }

    public boolean m0() {
        String string2 = this.a((short)127);
        return "1".equals(string2);
    }

    public String n() {
        return this.a((short)8);
    }

    public boolean n0() {
        String string2 = this.a((short)6);
        return "Support".equals(string2);
    }

    public boolean o0() {
        String string2 = this.a((short)10);
        return "Support".equals(string2);
    }

    public String p() {
        return this.a((short)515);
    }

    public boolean p0() {
        String string2 = this.a((short)121);
        return "1".equals(string2);
    }

    public Model q() {
        return Model.from(this.o((short)513));
    }

    public boolean q0() {
        int n10 = this.o((short)512);
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    public String r() {
        return this.a((short)13);
    }

    public SDStatus s() {
        return SDStatus.from(this.o((short)130));
    }

    public String t() {
        return this.a((short)124);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CCSParams{status=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(", paramVal=");
        object = this.b;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public String u() {
        return this.a((short)1);
    }

    public CCSStatus v() {
        return this.a;
    }

    public String w() {
        return this.a((short)118);
    }

    public String x() {
        return this.a((short)254);
    }

    public String y() {
        return this.a((short)12);
    }

    public VideoParams z() {
        return VideoParams.a(this.a((short)119));
    }
}

