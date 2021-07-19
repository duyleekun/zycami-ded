/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CameraManager
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package d.v.d;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import d.v.d.e;
import d.v.d.g.a;
import d.v.d.g.c.t;
import d.v.d.g.d.p;
import d.v.d.g.g.n;
import d.v.d.h.f;
import d.v.d.i.a.c;
import d.v.d.i.a.c$a;
import d.v.d.i.b.b;

public class d
implements d.v.d.f {
    private static final String d = "HUAWEI";
    private a a;
    private final e b;
    private int c;

    public d(Context context) {
        int n10;
        Object object = new e(context);
        this.b = object;
        this.c = n10 = d.v.d.h.d.a(context);
        Object object2 = new StringBuilder();
        Object object3 = "init camera, read mApi=";
        ((StringBuilder)object2).append((String)object3);
        int n11 = this.c;
        ((StringBuilder)object2).append(n11);
        object2 = ((StringBuilder)object2).toString();
        f.a((String)object2);
        n10 = this.c;
        n11 = -1;
        if (n10 == n11) {
            this.c = n10 = this.t(context);
        }
        object2 = ((e)object).W0();
        n11 = this.c;
        ((d.v.d.i.b.a)object2).o(n11);
        n10 = this.c;
        this.r(n10, context);
        object2 = ((e)object).W0();
        object3 = new d.v.d.a(this, context);
        ((d.v.d.i.a.a)object2).g((c$a)object3);
        object = ((e)object).X0();
        object2 = new d.v.d.b(this, context);
        ((d.v.d.i.a.a)object).g((c$a)object2);
    }

    private boolean j(String string2) {
        int n10;
        int n11;
        CharSequence charSequence = new StringBuilder();
        String string3 = "checkVersion version=";
        charSequence.append(string3);
        charSequence.append(string2);
        f.a(charSequence.toString());
        charSequence = ".";
        boolean bl2 = string2.contains(charSequence);
        boolean bl3 = false;
        if (bl2) {
            n11 = string2.indexOf((String)charSequence);
            string2 = string2.substring(0, n11);
        }
        if ((n10 = Integer.parseInt(string2)) >= (n11 = 10)) {
            bl3 = true;
        }
        return bl3;
    }

    private void k() {
        a a10 = this.a;
        if (a10 != null) {
            a10.b();
        }
    }

    private d.v.d.i.b.d l() {
        return this.b.Y0();
    }

    private boolean m() {
        Integer n10 = (Integer)this.b.X0().get();
        int n11 = n10;
        CharSequence charSequence = new StringBuilder();
        String string2 = "is special mode =";
        charSequence.append(string2);
        charSequence.append(n11);
        charSequence = charSequence.toString();
        f.a((String)charSequence);
        int n12 = 6;
        if (n12 != n11 && (n12 = 5) != n11 && (n12 = 7) != n11) {
            n11 = 0;
            n10 = null;
        } else {
            n11 = 1;
        }
        return n11 != 0;
    }

    private /* synthetic */ void n(Context context, Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Camera api change=");
        stringBuilder.append(n10);
        f.a(stringBuilder.toString());
        this.c = n11 = n10.intValue();
        int n12 = n10;
        this.s(n12, context);
    }

    private /* synthetic */ void p(Context context, Integer object, int n10) {
        boolean bl2;
        Comparable<StringBuilder> comparable = new StringBuilder();
        String string2 = "Camera mode change=";
        comparable.append(string2);
        comparable.append(object);
        comparable.append(",getSelectStatus=");
        object = this.l().get();
        comparable.append(object);
        f.a(comparable.toString());
        object = this.l();
        boolean n11 = ((d.v.d.i.b.d)object).o();
        if (n11 || (bl2 = ((d.v.d.i.b.d)(object = this.l())).n())) {
            object = this.b.Y0();
            n10 = 2;
            comparable = n10;
            ((d.v.d.i.b.d)object).q((Integer)comparable);
            int n12 = this.c;
            this.s(n12, context);
        }
    }

    private void r(int n10, Context context) {
        Object object = new StringBuilder();
        Object object2 = "open Camera Api =";
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(n10);
        f.a(((StringBuilder)object).toString());
        int n11 = 0;
        object = null;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n11 = 3;
                if (n10 == n11) {
                    object = this.b;
                    Object object3 = new n(context, (e)object);
                    this.a = object3;
                    object3 = this.b.X0();
                    ((b)object3).u(n12 != 0);
                }
            } else {
                object2 = this.b;
                Object object4 = new t(context, (e)object2);
                this.a = object4;
                object4 = this.b.X0();
                ((b)object4).u(false);
            }
        } else {
            object2 = this.b;
            Object object5 = new p(context, (e)object2);
            this.a = object5;
            object5 = this.b.X0();
            ((b)object5).u(false);
        }
    }

    private void s(int n10, Context context) {
        this.k();
        this.r(n10, context);
        this.c();
    }

    private int t(Context object) {
        int n10;
        block33: {
            int n11;
            int n12;
            CharSequence charSequence;
            Object object2;
            block32: {
                CharSequence charSequence2;
                block31: {
                    n10 = this.m();
                    if (n10 != 0) {
                        f.a("select huawei special mode ");
                        return 3;
                    }
                    String string2 = "camera";
                    object = (CameraManager)object.getSystemService(string2);
                    n10 = 2;
                    try {
                        object2 = this.b;
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                        return n10;
                    }
                    object2 = ((e)object2).w0();
                    object2 = ((d.v.d.i.a.a)object2).get();
                    object2 = String.valueOf(object2);
                    charSequence2 = new StringBuilder();
                    charSequence = "select api, current id=";
                    charSequence2.append((String)charSequence);
                    charSequence2.append((String)object2);
                    charSequence2 = charSequence2.toString();
                    f.a((String)charSequence2);
                    object = object.getCameraCharacteristics((String)object2);
                    object2 = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
                    object = object.get((CameraCharacteristics.Key)object2);
                    object = (Integer)object;
                    if (object != null) break block31;
                    object = "can not get INFO_SUPPORTED_HARDWARE_LEVEL";
                    f.a((String)object);
                    return n10;
                }
                object2 = new StringBuilder();
                charSequence2 = "deviceLevel=";
                ((StringBuilder)object2).append((String)charSequence2);
                ((StringBuilder)object2).append(object);
                object2 = ((StringBuilder)object2).toString();
                f.a((String)object2);
                int n13 = (Integer)object;
                n12 = 1;
                if (n13 == n10) break block32;
                n11 = (Integer)object;
                if (n11 == 0) break block32;
                return n12;
            }
            object = Build.MANUFACTURER;
            object2 = Build.VERSION.RELEASE;
            charSequence = new StringBuilder();
            String string3 = "manufacturer=";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append((String)object);
            charSequence = ((StringBuilder)charSequence).toString();
            f.a((String)charSequence);
            charSequence = d;
            n11 = (int)(((String)charSequence).equalsIgnoreCase((String)object) ? 1 : 0);
            if (n11 == 0) break block33;
            n11 = (int)(this.j((String)object2) ? 1 : 0);
            if (n11 == 0) break block33;
            return n12;
        }
        return n10;
    }

    public void a() {
        a a10 = this.a;
        if (a10 != null) {
            a10.a();
        }
    }

    public c b(int n10) {
        return this.a.d(n10);
    }

    public void c() {
        a a10 = this.a;
        if (a10 != null) {
            a10.c();
        }
    }

    public void d() {
        this.k();
        this.b.c1();
    }

    public c e(int n10) {
        return this.a.d(n10);
    }

    public c f(int n10) {
        return this.a.d(n10);
    }

    public c g(int n10) {
        return this.a.d(n10);
    }

    public c h(int n10) {
        return this.a.d(n10);
    }

    public c i(int n10) {
        return this.a.d(n10);
    }

    public /* synthetic */ void o(Context context, Integer n10, int n11) {
        this.n(context, n10, n11);
    }

    public /* synthetic */ void q(Context context, Integer n10, int n11) {
        this.p(context, n10, n11);
    }
}

