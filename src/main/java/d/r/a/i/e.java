/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.text.TextUtils
 */
package d.r.a.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import d.r.a.h$k;
import d.r.a.m;
import d.r.a.o;
import d.r.a.u.s;
import d.r.a.u.w;
import java.util.List;

public final class e
extends m {
    public e(o o10) {
        super(o10);
    }

    public static boolean b(Context context) {
        int n10;
        Object object = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        String string2 = context.getPackageName();
        object.setPackage(string2);
        string2 = context.getPackageManager();
        int n11 = 576;
        object = string2.queryIntentServices((Intent)object, n11);
        string2 = null;
        String string3 = "OnChangePushStatusTask";
        if (object != null && (n10 = object.size()) > 0) {
            int n12;
            ComponentName componentName;
            PackageManager packageManager = context.getPackageManager();
            int n13 = packageManager.getComponentEnabledSetting(componentName = new ComponentName(context, (String)(object = ((ResolveInfo)object.get((int)0)).serviceInfo.name)));
            if (n13 != (n12 = 1)) {
                packageManager.setComponentEnabledSetting(componentName, n12, n12);
                s.m(string3, "enableService push service.");
                return n12 != 0;
            }
            s.m(string3, "push service has enabled");
            return false;
        }
        s.a(string3, "enableService error: can not find push service.");
        return false;
    }

    public static boolean c(Context context) {
        int n10;
        Object object = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        String string2 = context.getPackageName();
        object.setPackage(string2);
        string2 = context.getPackageManager();
        int n11 = 576;
        object = string2.queryIntentServices((Intent)object, n11);
        string2 = null;
        String string3 = "OnChangePushStatusTask";
        if (object != null && (n10 = object.size()) > 0) {
            int n12;
            ComponentName componentName;
            PackageManager packageManager = context.getPackageManager();
            int n13 = packageManager.getComponentEnabledSetting(componentName = new ComponentName(context, (String)(object = ((ResolveInfo)object.get((int)0)).serviceInfo.name)));
            if (n13 != (n12 = 2)) {
                n13 = 1;
                packageManager.setComponentEnabledSetting(componentName, n12, n13);
                s.m(string3, "disableService push service.");
                return n13 != 0;
            }
            s.m(string3, "push service has disabled");
            return false;
        }
        s.a(string3, "disableService error: can not find push service.");
        return false;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static List d(Context context) {
        void var1_6;
        void var1_4;
        PackageManager packageManager;
        Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
        String string2 = context.getPackageName();
        intent.setPackage(string2);
        int n11 = 576;
        try {
            packageManager = context.getPackageManager();
            List list = packageManager.queryBroadcastReceivers(intent, n11);
        }
        catch (Exception exception) {
            Object var1_3 = null;
        }
        if (var1_4 != null) {
            int n10 = var1_4.size();
            if (n10 > 0) return var1_6;
        }
        packageManager = new Intent("com.vivo.pushclient.action.RECEIVE");
        String string3 = context.getPackageName();
        packageManager.setPackage(string3);
        try {
            context = context.getPackageManager();
            List list = context.queryBroadcastReceivers((Intent)packageManager, n11);
            return var1_6;
        }
        catch (Exception exception) {
            return var1_6;
        }
    }

    public final void a(o object) {
        Object object2;
        Object object3 = w.e(this.a);
        CharSequence charSequence = this.a.getPackageName();
        boolean n10 = ((String)charSequence).equals(object3);
        if (n10) {
            return;
        }
        object = (h$k)object;
        int n11 = ((h$k)object).e;
        int n12 = ((h$k)object).f;
        charSequence = new StringBuilder("OnChangePushStatusTask serviceStatus is ");
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append(" ; receiverStatus is ");
        ((StringBuilder)charSequence).append(n12);
        charSequence = ((StringBuilder)charSequence).toString();
        String string2 = "OnChangePushStatusTask";
        s.m(string2, (String)charSequence);
        charSequence = "push service has defaulted";
        int n13 = 2;
        ComponentName componentName = null;
        int n14 = 1;
        if (n11 == n13) {
            object3 = this.a;
            e.c((Context)object3);
        } else if (n11 == n14) {
            object3 = this.a;
            e.b((Context)object3);
        } else if (n11 == 0) {
            int n15;
            object3 = this.a;
            object2 = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            String string3 = object3.getPackageName();
            object2.setPackage(string3);
            string3 = object3.getPackageManager();
            int n16 = 576;
            object2 = string3.queryIntentServices((Intent)object2, n16);
            if (object2 != null && (n15 = object2.size()) > 0) {
                ComponentName componentName2;
                string3 = object3.getPackageManager();
                int n17 = string3.getComponentEnabledSetting(componentName2 = new ComponentName((Context)object3, (String)(object2 = ((ResolveInfo)object2.get((int)0)).serviceInfo.name)));
                if (n17 != 0) {
                    string3.setComponentEnabledSetting(componentName2, 0, n14);
                    object3 = "defaultService push service.";
                    s.m(string2, (String)object3);
                } else {
                    s.m(string2, (String)charSequence);
                }
            } else {
                object3 = "defaultService error: can not find push service.";
                s.a(string2, (String)object3);
            }
        }
        if (n12 == n13) {
            int n18;
            object = this.a;
            object3 = e.d((Context)object);
            if (object3 != null && (n18 = object3.size()) > 0) {
                object3 = ((ResolveInfo)object3.get((int)0)).activityInfo.name;
                n18 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
                if (n18 != 0) {
                    object = "disableReceiver error: className is null. ";
                    s.m(string2, (String)object);
                } else {
                    charSequence = object.getPackageManager();
                    n12 = charSequence.getComponentEnabledSetting(componentName = new ComponentName((Context)object, (String)object3));
                    if (n12 != n13) {
                        charSequence.setComponentEnabledSetting(componentName, n13, n14);
                        object = "push service disableReceiver ";
                        s.m(string2, (String)object);
                    } else {
                        object = "push service has disableReceiver ";
                        s.m(string2, (String)object);
                    }
                }
            } else {
                object = "disableReceiver error: can not find push service.";
                s.a(string2, (String)object);
            }
            d.r.a.s.e.d().e = null;
            return;
        }
        if (n12 == n14) {
            int n19;
            object = this.a;
            object3 = e.d((Context)object);
            if (object3 != null && (n19 = object3.size()) > 0) {
                ComponentName componentName3;
                object3 = ((ResolveInfo)object3.get((int)0)).activityInfo.name;
                n19 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
                if (n19 != 0) {
                    s.m(string2, "enableReceiver error: className is null. ");
                    return;
                }
                charSequence = object.getPackageManager();
                n12 = charSequence.getComponentEnabledSetting(componentName3 = new ComponentName((Context)object, (String)object3));
                if (n12 != n14) {
                    charSequence.setComponentEnabledSetting(componentName3, n14, n14);
                    s.m(string2, "push service enableReceiver ");
                    return;
                }
                s.m(string2, "push service has enableReceiver ");
                return;
            }
            s.a(string2, "enableReceiver error: can not find push service.");
            return;
        }
        if (n12 == 0) {
            object = this.a;
            object3 = e.d((Context)object);
            if (object3 != null && (n13 = object3.size()) > 0) {
                object3 = ((ResolveInfo)object3.get((int)0)).activityInfo.name;
                n13 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
                if (n13 != 0) {
                    s.m(string2, "defaultReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager = object.getPackageManager();
                n12 = packageManager.getComponentEnabledSetting((ComponentName)(object2 = new ComponentName((Context)object, (String)object3)));
                if (n12 != 0) {
                    packageManager.setComponentEnabledSetting((ComponentName)object2, 0, n14);
                    s.m(string2, "push service defaultReceiver ");
                    return;
                }
                s.m(string2, (String)charSequence);
            } else {
                object = "defaultReceiver error: can not find push service.";
                s.a(string2, (String)object);
            }
        }
    }
}

