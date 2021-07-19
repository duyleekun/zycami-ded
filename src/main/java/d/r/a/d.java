/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
 *  android.text.TextUtils
 */
package d.r.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import d.r.a.a;
import d.r.a.h$b;
import d.r.a.h$c;
import d.r.a.h$g;
import d.r.a.l;
import d.r.a.l$a;
import d.r.a.l$c;
import d.r.a.l$d;
import d.r.a.l$f;
import d.r.a.u.d0;
import d.r.a.u.s;
import d.r.a.u.w;
import java.util.ArrayList;
import java.util.List;

public class d {
    public static final String a = "1";
    private static volatile d b;

    private d(Context context) {
        l.b().d(context);
    }

    private void c(String string2) {
        if (string2 != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("PushManager String param should not be ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static d f(Context object) {
        Class<d> clazz = d.class;
        synchronized (clazz) {
            d d10 = b;
            if (d10 == null) {
                object = object.getApplicationContext();
                b = d10 = new d((Context)object);
            }
            object = b;
            return object;
        }
    }

    public void a(String string2, a object) {
        this.c(string2);
        l l10 = l.b();
        Object object2 = l10.g;
        if (object2 == null) {
            if (object != null) {
                int n10 = 102;
                object.onStateChanged(n10);
            }
            return;
        }
        object2 = l10.k;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2 && (bl2 = ((String)(object2 = l10.k)).equals(string2))) {
            if (object != null) {
                object.onStateChanged(0);
            }
            return;
        }
        object2 = new ArrayList();
        ((ArrayList)object2).add(string2);
        boolean bl3 = true;
        String string3 = l10.g.getPackageName();
        h$b h$b = new h$b(bl3, string3, (ArrayList)object2);
        h$b.g = 100;
        bl2 = l10.p;
        if (bl2) {
            long l11;
            bl2 = l10.t();
            if (!bl2) {
                if (object != null) {
                    int n11 = 101;
                    object.onStateChanged(n11);
                }
                return;
            }
            long l12 = l10.c;
            bl2 = l.k(l12);
            if (!bl2) {
                if (object != null) {
                    int n12 = 1002;
                    object.onStateChanged(n12);
                }
                return;
            }
            l10.c = l12 = SystemClock.elapsedRealtime();
            object2 = new l$f(h$b, (a)object);
            h$b.c = object = l10.c((l$f)object2);
            object2 = l10.j;
            bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (bl2) {
                l10.g((String)object, 30001);
                return;
            }
            bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) {
                l10.g((String)object, 30002);
                return;
            }
            l12 = string2.length();
            long l13 = l12 - (l11 = (long)70);
            Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 > 0) {
                l10.g((String)object, 30003);
                return;
            }
            l10.e(h$b);
            l10.p((String)object);
            return;
        }
        l10.e(h$b);
        if (object != null) {
            object.onStateChanged(0);
        }
    }

    public void b() {
        Context context = l.b().g;
        if (context != null) {
            d0.m(context);
        }
    }

    public void d(String string2, a a10) {
        ArrayList<String> arrayList = new ArrayList<String>(1);
        arrayList.add(string2);
        l.b().n(arrayList, a10);
    }

    public String e() {
        return l.b().k;
    }

    public String g() {
        return l.b().s();
    }

    public List h() {
        return l.b().m();
    }

    public String i() {
        return "2.9.0.0";
    }

    public void j() {
        l l10 = l.b();
        h$g h$g = new h$g();
        l10.e(h$g);
    }

    public boolean k() {
        return l.b().q();
    }

    public void l(boolean bl2) {
        l.b().h = bl2;
    }

    public void m(String string2, a a10) {
        ArrayList<String> arrayList = new ArrayList<String>(1);
        arrayList.add(string2);
        l.b().i(arrayList, a10);
    }

    public void n(a object) {
        l l10 = l.b();
        Object object2 = l10.g;
        int n10 = 102;
        if (object2 == null) {
            if (object != null) {
                object.onStateChanged(n10);
            }
            return;
        }
        object2 = l10.j;
        int n11 = "".equals(object2);
        if (n11 != 0) {
            object.onStateChanged(0);
            return;
        }
        long l11 = l10.b;
        n11 = l.k(l11);
        if (n11 == 0) {
            if (object != null) {
                int n12 = 1002;
                object.onStateChanged(n12);
            }
            return;
        }
        l10.b = l11 = SystemClock.elapsedRealtime();
        object2 = l10.g.getPackageName();
        Context context = l10.g;
        l$f l$f = null;
        if (context == null) {
            if (object != null) {
                object.onStateChanged(n10);
            }
        } else {
            h$c h$c = new h$c(false, (String)object2);
            h$c.k = null;
            h$c.j = null;
            h$c.h = null;
            h$c.g = 100;
            n11 = l10.p;
            if (n11 != 0) {
                n11 = l10.t();
                if (n11 == 0) {
                    if (object != null) {
                        n11 = 101;
                        object.onStateChanged(n11);
                    }
                } else {
                    l$f = new l$f(h$c, (a)object);
                    h$c.c = object = l10.c(l$f);
                    object2 = new l$d(l10, h$c, (String)object);
                    l$f.d = object2;
                }
            } else {
                l10.e(h$c);
                if (object != null) {
                    object.onStateChanged(0);
                }
            }
        }
        if (l$f != null) {
            object = new l$c(l10);
            l$f.c = object;
            l$f.a();
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void o(a var1_1) {
        block20: {
            block21: {
                block19: {
                    var2_2 = l.b();
                    var3_3 /* !! */  = var2_2.g;
                    var4_4 = 102;
                    if (var3_3 /* !! */  == null) {
                        if (var1_1 != null) {
                            var1_1.onStateChanged(var4_4);
                        }
                        return;
                    }
                    var3_3 /* !! */  = var2_2.s();
                    var2_2.j = var3_3 /* !! */ ;
                    var5_5 = TextUtils.isEmpty((CharSequence)var3_3 /* !! */ );
                    if (var5_5 == 0) {
                        if (var1_1 != null) {
                            var1_1.onStateChanged(0);
                        }
                        return;
                    }
                    var6_6 = var2_2.a;
                    var5_5 = l.k(var6_6);
                    if (var5_5 == 0) {
                        if (var1_1 != null) {
                            var8_7 = 1002;
                            var1_1.onStateChanged(var8_7);
                        }
                        return;
                    }
                    var2_2.a = var6_6 = SystemClock.elapsedRealtime();
                    var3_3 /* !! */  = var2_2.g.getPackageName();
                    var9_8 = var2_2.g;
                    var10_9 = null;
                    if (var9_8 != null) break block19;
                    if (var1_1 != null) {
                        var1_1.onStateChanged(var4_4);
                    }
                    break block20;
                }
                var12_11 = 1;
                var11_10 = new h$c((boolean)var12_11, (String)var3_3 /* !! */ );
                var11_10.h = null;
                var11_10.k = null;
                var11_10.j = null;
                var11_10.g = 100;
                var5_5 = var2_2.p;
                if (var5_5 == 0) break block21;
                var5_5 = var2_2.t();
                if (var5_5 == 0) {
                    if (var1_1 != null) {
                        var5_5 = 101;
                        var1_1.onStateChanged(var5_5);
                    }
                } else {
                    var10_9 = var2_2.a(var11_10, var1_1);
                }
                break block20;
            }
            var3_3 /* !! */  = var2_2.g;
            var13_12 = var11_10.f;
            var14_13 = 2;
            var15_14 = -1;
            if (var13_12 != var15_14) ** GOTO lbl76
            var16_15 = var11_10.d;
            var17_16 = TextUtils.isEmpty((CharSequence)var16_15);
            if (!var17_16) ** GOTO lbl67
            var16_15 = "BaseAppCommand";
            s.a(var16_15, "pkg name is null");
            var18_17 = var11_10.b;
            var19_18 = TextUtils.isEmpty((CharSequence)var18_17);
            if (var19_18) {
                var3_3 /* !! */  = "src is null";
                s.a(var16_15, (String)var3_3 /* !! */ );
            } else {
                var16_15 = var18_17;
lbl67:
                // 2 sources

                if (var17_16 = w.d(var3_3 /* !! */ , var16_15, var18_17 = "com.vivo.pushservice.action.RECEIVE")) {
                    var15_14 = 0;
                }
                if ((var5_5 = (int)w.d(var3_3 /* !! */ , var16_15, var18_17 = "com.vivo.pushclient.action.RECEIVE")) == 0) {
                    var12_11 = var15_14;
                }
                var11_10.f = var12_11;
                var3_3 /* !! */  = var11_10.h;
                var5_5 = (int)TextUtils.isEmpty((CharSequence)var3_3 /* !! */ );
                if (var5_5 == 0) {
                    var11_10.f = var14_13;
                }
lbl76:
                // 4 sources

                var15_14 = var11_10.f;
            }
            if (var15_14 == var14_13) {
                var10_9 = var2_2.a(var11_10, var1_1);
            } else {
                var2_2.e(var11_10);
                if (var1_1 != null) {
                    var1_1.onStateChanged(0);
                }
            }
        }
        if (var10_9 != null) {
            var10_9.c = var1_1 = new l$a(var2_2, var10_9);
            var10_9.a();
        }
    }

    public void p(String string2, a object) {
        this.c(string2);
        l l10 = l.b();
        Object object2 = l10.g;
        if (object2 == null) {
            if (object != null) {
                int n10 = 102;
                object.onStateChanged(n10);
            }
            return;
        }
        object2 = l10.k;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (bl2) {
            if (object != null) {
                object.onStateChanged(0);
            }
            return;
        }
        object2 = new ArrayList();
        ((ArrayList)object2).add(string2);
        String string3 = l10.g.getPackageName();
        h$b h$b = new h$b(false, string3, (ArrayList)object2);
        h$b.g = 100;
        bl2 = l10.p;
        if (bl2) {
            long l11;
            bl2 = l10.t();
            if (!bl2) {
                if (object != null) {
                    int n11 = 101;
                    object.onStateChanged(n11);
                }
                return;
            }
            long l12 = l10.d;
            bl2 = l.k(l12);
            if (!bl2) {
                if (object != null) {
                    int n12 = 1002;
                    object.onStateChanged(n12);
                }
                return;
            }
            l10.d = l12 = SystemClock.elapsedRealtime();
            object2 = new l$f(h$b, (a)object);
            h$b.c = object = l10.c((l$f)object2);
            object2 = l10.j;
            bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (bl2) {
                l10.g((String)object, 30001);
                return;
            }
            bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) {
                l10.g((String)object, 30002);
                return;
            }
            l12 = string2.length();
            long l13 = l12 - (l11 = (long)70);
            Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 > 0) {
                l10.g((String)object, 30003);
                return;
            }
            l10.e(h$b);
            l10.p((String)object);
            return;
        }
        l10.e(h$b);
        if (object != null) {
            object.onStateChanged(0);
        }
    }
}

