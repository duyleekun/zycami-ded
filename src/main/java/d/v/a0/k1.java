/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.v.a0;

import android.content.Context;
import android.text.TextUtils;
import com.zhiyun.common.util.Devices;
import com.zhiyun.zysocket.util.SocketUtil;
import d.v.a0.y0;
import d.v.a0.z0;
import d.v.e.g.e;
import d.v.e.l.b2;
import d.v.e.l.d1;
import d.v.z.j;
import d.v.z.k.d;
import d.v.z.n.g;
import d.v.z.o.i;
import e.a.b0;
import e.a.z;
import java.util.concurrent.TimeUnit;
import m.a.a;

public class k1 {
    private static final String a = d1.a();

    public static z a(e object) {
        Object object2 = new z0((e)object);
        object = z.y1(object2);
        object2 = TimeUnit.MILLISECONDS;
        return ((z)object).E6(500L, (TimeUnit)((Object)object2)).U4(3);
    }

    public static String b(Context object) {
        String string2 = b2.f((Context)object);
        boolean bl2 = b2.j((Context)object);
        if (!bl2) {
            return string2;
        }
        object = SocketUtil.l();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (bl3 && (bl3 = object.isEmpty())) {
            return null;
        }
        bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (bl3) {
            return (String)object.get(0);
        }
        object = object.stream();
        y0 y02 = new y0(string2);
        return object.filter(y02).findFirst().orElse(string2);
    }

    public static /* synthetic */ void c(e e10, b0 b02) {
        if (e10 != null) {
            e10.a();
        }
    }

    public static /* synthetic */ boolean d(String string2, String string3) {
        return string3.equals(string2) ^ true;
    }

    public static d.v.z.l.e e(Context object) {
        String string2 = Devices.n(object);
        String string3 = k1.b(object);
        object = Devices.k(object);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!(bl2 || (bl2 = TextUtils.isEmpty((CharSequence)string3)) || (bl2 = TextUtils.isEmpty((CharSequence)object)))) {
            d.v.z.l.e e10 = new d.v.z.l.e();
            e10.v(string2);
            e10.w(string3);
            e10.u((String)object);
            object = a;
            e10.t((String)object);
            object = j.b();
            e10.y((String)object);
            return e10;
        }
        Object[] objectArray = new Object[]{string2, string3, object};
        m.a.a.i("\u83b7\u53d6\u8bbe\u5907\u4fe1\u606f\u5f02\u5e38,model:%s,ip:%s,deviceId:%s", objectArray);
        return null;
    }

    public static d.v.z.l.e f(Context object) {
        if ((object = k1.e((Context)object)) == null) {
            object = new d.v.z.l.e();
            String string2 = a;
            ((d.v.z.l.e)object).t(string2);
            string2 = j.b();
            ((d.v.z.l.e)object).y(string2);
        }
        return object;
    }

    public static boolean g(g object, d.v.k0.f.d.a object2) {
        boolean bl2;
        d d10;
        d d11;
        boolean bl3 = i.f((byte[])(object2 = (Object)((d.v.k0.f.d.a)object2).c()));
        if (bl3 && (bl3 = (d11 = ((g)object).m()).equals(d10 = i.b((byte[])object2))) && (object = ((g)object).n()) == (object2 = i.a((byte[])object2))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean h(Context context) {
        return b2.j(context);
    }
}

