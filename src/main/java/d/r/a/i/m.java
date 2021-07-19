/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.text.TextUtils
 */
package d.r.a.i;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import d.r.a.h$q;
import d.r.a.h$y;
import d.r.a.i.m$a;
import d.r.a.i.m$b;
import d.r.a.i.m$c;
import d.r.a.i.m$d;
import d.r.a.i.m$e;
import d.r.a.i.o;
import d.r.a.l;
import d.r.a.n;
import d.r.a.r.a;
import d.r.a.r.c;
import d.r.a.u.d;
import d.r.a.u.d0;
import d.r.a.u.s;
import d.r.a.u.t;
import java.util.HashMap;
import java.util.Map;

public final class m
extends o {
    public m(d.r.a.o o10) {
        super(o10);
    }

    public static /* synthetic */ Context d(m m10) {
        return m10.a;
    }

    public static /* synthetic */ Intent e(Intent intent, Map map) {
        return m.g(intent, map);
    }

    public static /* synthetic */ Context f(m m10) {
        return m10.a;
    }

    private static Intent g(Intent intent, Map object) {
        Object object2;
        if (object != null && (object2 = object.entrySet()) != null) {
            boolean bl2;
            object = object.entrySet().iterator();
            while (bl2 = object.hasNext()) {
                Object object3;
                object2 = (Map.Entry)object.next();
                if (object2 == null || (object3 = object2.getKey()) == null) continue;
                object3 = (String)object2.getKey();
                object2 = (String)object2.getValue();
                intent.putExtra(object3, (String)object2);
            }
        }
        return intent;
    }

    public static /* synthetic */ Context h(m m10) {
        return m10.a;
    }

    public static /* synthetic */ Context i(m m10) {
        return m10.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(d.r.a.o object) {
        Object object2;
        object = (h$q)object;
        c c10 = ((h$q)object).f;
        String string2 = "OnNotificationClickTask";
        if (c10 == null) {
            s.m(string2, "current notification item is null");
            return;
        }
        c10 = t.b((a)c10);
        Object object3 = ((h$q)object).c;
        Object object4 = this.a.getPackageName();
        int n10 = ((String)object4).equals(object3);
        if (n10 != 0) {
            object2 = this.a;
            d.r.a.u.d.a((Context)object2);
        }
        if ((object2 = ((h$q)object).d) != null) {
            object3 = object2;
        }
        if (n10 == 0) {
            object = new StringBuilder("notify is ");
            ((StringBuilder)object).append(c10);
            ((StringBuilder)object).append(" ; isMatch is ");
            ((StringBuilder)object).append(n10 != 0);
            object = ((StringBuilder)object).toString();
            s.a(string2, (String)object);
            return;
        }
        long l10 = 1030L;
        object4 = new h$y(l10);
        object2 = new HashMap();
        ((HashMap)object2).put("type", "2");
        long l11 = ((h$q)object).e;
        String string3 = String.valueOf(l11);
        String string4 = "messageID";
        ((HashMap)object2).put(string4, string3);
        ((HashMap)object2).put("platform", object3);
        string3 = d0.k(this.a, (String)object3);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2) {
            object3 = "remoteAppId";
            ((HashMap)object2).put(object3, string3);
        } else {
            string3 = "ap";
            ((HashMap)object2).put(string3, object3);
        }
        ((h$y)object4).c = object2;
        l.b().e((d.r.a.o)object4);
        object3 = new StringBuilder("notification is clicked by skip type[");
        n10 = c10.n();
        ((StringBuilder)object3).append(n10);
        object4 = "]";
        ((StringBuilder)object3).append((String)object4);
        object3 = ((StringBuilder)object3).toString();
        s.m(string2, (String)object3);
        int n11 = c10.n();
        n10 = 1;
        if (n11 == n10) {
            string2 = this.a;
            object3 = c10.k();
            object = ((h$q)object).d;
            object2 = new m$e(this, (Context)string2, (String)object, (Map)object3);
            object4 = new Thread((Runnable)object2);
            ((Thread)object4).start();
            object = new m$a(this, c10);
            n.c((Runnable)object);
            return;
        }
        int n12 = 2;
        int n13 = 0x10000000;
        if (n11 != n12) {
            n12 = 3;
            if (n11 == n12) {
                object = new m$c(this, c10);
                n.c((Runnable)object);
                return;
            }
            n12 = 4;
            if (n11 != n12) {
                object = new StringBuilder("illegitmacy skip type error : ");
                int n14 = c10.n();
                ((StringBuilder)object).append(n14);
                object = ((StringBuilder)object).toString();
                s.a(string2, (String)object);
                return;
            }
            object3 = c10.m();
            try {
                object4 = Intent.parseUri((String)object3, (int)n10);
                object2 = object4.getPackage();
                string4 = ((h$q)object).d;
                String string5 = null;
                String string6 = "; but remote pkgName is ";
                if (string4 != null) {
                    bl2 = TextUtils.isEmpty((CharSequence)object2);
                    if (!bl2 && !(bl2 = (string4 = ((h$q)object).d).equals(object2))) {
                        string3 = "open activity error : local pkgName getOpenPkgName is ";
                        object4 = new StringBuilder(string3);
                        object = ((h$q)object).d;
                        ((StringBuilder)object4).append((String)object);
                        ((StringBuilder)object4).append(string6);
                        ((StringBuilder)object4).append((String)object2);
                        object = ((StringBuilder)object4).toString();
                        s.a(string2, (String)object);
                        return;
                    }
                    object2 = object4.getComponent();
                    if (object2 != null) {
                        object2 = object4.getComponent();
                        string5 = object2.getPackageName();
                    }
                    n12 = (int)(TextUtils.isEmpty(string5) ? 1 : 0);
                    if (n12 == 0 && (n12 = (int)(((String)(object2 = ((h$q)object).d)).equals(string5) ? 1 : 0)) == 0) {
                        object2 = "open activity component error : local pkgName getOpenPkgName is ";
                        object4 = new StringBuilder((String)object2);
                        object = ((h$q)object).d;
                        ((StringBuilder)object4).append((String)object);
                        ((StringBuilder)object4).append(string6);
                        ((StringBuilder)object4).append(string5);
                        object = ((StringBuilder)object4).toString();
                        s.a(string2, (String)object);
                        return;
                    }
                } else {
                    bl2 = TextUtils.isEmpty((CharSequence)object2);
                    if (!bl2) {
                        string4 = this.a;
                        bl2 = (string4 = string4.getPackageName()).equals(object2);
                        if (!bl2) {
                            object4 = "open activity error : local pkgName is ";
                            object = new StringBuilder((String)object4);
                            object4 = this.a;
                            object4 = object4.getPackageName();
                            ((StringBuilder)object).append((String)object4);
                            ((StringBuilder)object).append(string6);
                            ((StringBuilder)object).append((String)object2);
                            object = ((StringBuilder)object).toString();
                            s.a(string2, (String)object);
                            return;
                        }
                    }
                    if ((object2 = object4.getComponent()) != null) {
                        object2 = object4.getComponent();
                        string5 = object2.getPackageName();
                    }
                    n12 = (int)(TextUtils.isEmpty(string5) ? 1 : 0);
                    if (n12 == 0) {
                        object2 = this.a;
                        n12 = (int)(((String)(object2 = object2.getPackageName())).equals(string5) ? 1 : 0);
                        if (n12 == 0) {
                            object4 = "open activity component error : local pkgName is ";
                            object = new StringBuilder((String)object4);
                            object4 = this.a;
                            object4 = object4.getPackageName();
                            ((StringBuilder)object).append((String)object4);
                            ((StringBuilder)object).append(string6);
                            ((StringBuilder)object).append(string5);
                            object = ((StringBuilder)object).toString();
                            s.a(string2, (String)object);
                            return;
                        }
                    }
                }
                if ((object = ((h$q)object).d) == null) {
                    object = this.a;
                    object = object.getPackageName();
                }
                object4.setPackage((String)object);
                object4.addFlags(n13);
                object = c10.k();
                m.g((Intent)object4, (Map)object);
                object = this.a;
                object.startActivity((Intent)object4);
            }
            catch (Exception exception) {
                object2 = "open activity error : ";
                object4 = new StringBuilder((String)object2);
                ((StringBuilder)object4).append((String)object3);
                object3 = ((StringBuilder)object4).toString();
                s.b(string2, (String)object3, exception);
            }
            object = new m$d(this, c10);
            n.c((Runnable)object);
            return;
        }
        object = c10.m();
        n11 = (int)(((String)object).startsWith((String)(object3 = "http://")) ? 1 : 0);
        if (n11 == 0 && (n11 = (int)(((String)object).startsWith((String)(object3 = "https://")) ? 1 : 0)) == 0) {
            n10 = 0;
            object4 = null;
        }
        if (n10 != 0) {
            object = Uri.parse((String)object);
            object3 = new Intent("android.intent.action.VIEW", (Uri)object);
            object3.setFlags(n13);
            object4 = c10.k();
            m.g((Intent)object3, (Map)object4);
            try {
                object4 = this.a;
                object4.startActivity((Intent)object3);
            }
            catch (Exception exception) {
                object4 = "startActivity error : ";
                object3 = new StringBuilder((String)object4);
                ((StringBuilder)object3).append(object);
                object = ((StringBuilder)object3).toString();
                s.a(string2, (String)object);
            }
        } else {
            object = "url not legal";
            s.a(string2, (String)object);
        }
        object = new m$b(this, c10);
        n.c((Runnable)object);
    }
}

