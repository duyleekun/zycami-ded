/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 */
package d.r.a.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import d.r.a.f.a;
import d.r.a.h$d;
import d.r.a.h$f;
import d.r.a.h$x;
import d.r.a.l;
import d.r.a.m;
import d.r.a.o;
import d.r.a.r.f;
import d.r.a.u.s;
import d.r.a.u.v;
import d.r.a.u.w;

public final class t
extends m {
    public t(o o10) {
        super(o10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void a(o object) {
        Object object2;
        int n10;
        String string2;
        String string3;
        Object object3;
        block19: {
            int n11;
            block20: {
                block21: {
                    object3 = this.a;
                    string3 = "SendCommandTask ";
                    string2 = "SendCommandTask";
                    if (object3 == null) {
                        object3 = new StringBuilder(string3);
                        ((StringBuilder)object3).append(object);
                        ((StringBuilder)object3).append(" ; mContext is Null");
                        object = ((StringBuilder)object3).toString();
                        s.m(string2, (String)object);
                        return;
                    }
                    if (object == null) {
                        s.m(string2, "SendCommandTask pushCommand is Null");
                        return;
                    }
                    object3 = w.a((Context)object3);
                    n11 = ((o)object).a;
                    if (n11 == 0) break block20;
                    n10 = 2009;
                    if (n11 == n10) break block21;
                    n10 = 2011;
                    if (n11 != n10) {
                        switch (n11) {
                            default: {
                                break;
                            }
                            case 2002: 
                            case 2003: 
                            case 2004: 
                            case 2005: {
                                if (object3 != null && (n11 = (int)(((f)object3).e ? 1 : 0)) == 0) {
                                    object2 = object;
                                    object2 = (h$d)object;
                                    n10 = v.a((h$d)object2);
                                    if (n10 == 0) break;
                                    object = l.b();
                                    object3 = ((h$d)object2).c;
                                    ((l)object).g((String)object3, n10);
                                    return;
                                }
                                object2 = l.b();
                                Object object4 = object;
                                object4 = ((h$d)object).c;
                                int n12 = 1005;
                                ((l)object2).g((String)object4, n12);
                                break;
                            }
                        }
                        break block19;
                    } else {
                        object2 = d.r.a.k.a.d(this.a);
                        Object object5 = object;
                        object5 = (h$x)object;
                        n10 = ((h$x)object5).c;
                        n11 = (int)(((d.r.a.k.a)object2).k(n10) ? 1 : 0);
                        s.f(n11 != 0);
                    }
                    break block19;
                }
                object2 = d.r.a.k.a.d(this.a);
                s.f(((d.r.a.k.a)object2).j());
                n11 = (int)(s.g() ? 1 : 0);
                if (n11 != 0) {
                    l.b().i.b();
                    object2 = new d.r.a.u.f();
                    Context context = this.a;
                    ((d.r.a.u.f)object2).c(context, "com.vivo.push_preferences.hybridapptoken_v1");
                    ((d.r.a.u.f)object2).b();
                    object2 = new d.r.a.u.f();
                    context = this.a;
                    String string4 = "com.vivo.push_preferences.appconfig_v1";
                    ((d.r.a.u.f)object2).c(context, string4);
                    ((d.r.a.u.f)object2).b();
                    object2 = l.b();
                    n11 = (int)(((l)object2).p ? 1 : 0);
                    if (n11 == 0) {
                        object2 = d.r.a.k.a.d(this.a);
                        ((d.r.a.k.a)object2).b();
                    }
                }
                break block19;
            }
            object2 = l.b();
            n11 = (int)(((l)object2).p ? 1 : 0);
            if (n11 != 0) {
                int n13;
                object2 = this.a;
                Object object6 = new Intent();
                String string5 = object2.getPackageName();
                object6.setPackage(string5);
                string5 = object2.getPackageName();
                String string6 = "com.vivo.push.sdk.service.CommandService";
                object6.setClassName(string5, string6);
                string5 = object2.getPackageManager();
                int n14 = 128;
                object6 = string5.queryIntentServices((Intent)object6, n14);
                int n15 = 1;
                String string7 = "ModuleUtil";
                int n16 = 2;
                if (object6 != null && (n13 = object6.size()) > 0) {
                    ComponentName componentName;
                    PackageManager packageManager = object2.getPackageManager();
                    n11 = packageManager.getComponentEnabledSetting(componentName = new ComponentName((Context)object2, (String)(object6 = ((ResolveInfo)object6.get((int)0)).serviceInfo.name)));
                    if (n11 != n16) {
                        packageManager.setComponentEnabledSetting(componentName, n16, n15);
                    }
                } else {
                    object2 = "disableDeprecatedService is null";
                    s.m(string7, (String)object2);
                }
                object2 = this.a;
                object6 = new Intent();
                String string8 = object2.getPackageName();
                object6.setPackage(string8);
                String string9 = object2.getPackageName();
                String string10 = "com.vivo.push.sdk.service.LinkProxyActivity";
                object6.setClassName(string9, string10);
                PackageManager packageManager = object2.getPackageManager();
                object6 = packageManager.queryIntentActivities((Intent)object6, n14);
                if (object6 != null && (n14 = object6.size()) > 0) {
                    string6 = object2.getPackageManager();
                    n11 = string6.getComponentEnabledSetting((ComponentName)(string7 = new ComponentName((Context)object2, (String)(object6 = ((ResolveInfo)object6.get((int)0)).activityInfo.name))));
                    if (n11 != n16) {
                        string6.setComponentEnabledSetting((ComponentName)string7, n16, n15);
                    }
                } else {
                    object2 = "disableDeprecatedActivity is null";
                    s.m(string7, (String)object2);
                }
            }
        }
        if (object3 == null) {
            object3 = new StringBuilder(string3);
            ((StringBuilder)object3).append(object);
            ((StringBuilder)object3).append(" ; pushPkgInfo is Null");
            object = ((StringBuilder)object3).toString();
            s.m(string2, (String)object);
            return;
        }
        object2 = ((f)object3).a;
        boolean bl2 = ((f)object3).e;
        if (bl2) {
            object3 = l.b();
            object = ((h$d)object).c;
            n10 = 1004;
            ((l)object3).g((String)object, n10);
            object = new h$f();
            object3 = new StringBuilder(string3);
            ((StringBuilder)object3).append(object);
            string3 = " ; pkgName is InBlackList ";
            ((StringBuilder)object3).append(string3);
            object3 = ((StringBuilder)object3).toString();
            s.m(string2, (String)object3);
        }
        d.r.a.f.a.b(this.a, (String)object2, (o)object);
    }
}

