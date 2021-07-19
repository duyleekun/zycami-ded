/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.ah;
import com.xiaomi.push.ba;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class m {
    private static int a = 255;

    public static ah a(Context context) {
        block7: {
            String string2;
            String string3;
            try {
                context = context.getPackageManager();
                string3 = "com.huawei.hwid";
                string2 = "com.huawei.hms.core.service.HMSCoreService";
            }
            catch (Exception exception) {
                return ah.f;
            }
            ComponentName componentName = new ComponentName(string3, string2);
            int n10 = 128;
            context = context.getServiceInfo(componentName, n10);
            if (context == null) break block7;
            boolean bl2 = m.a();
            if (!bl2) break block7;
            return ah.a;
        }
        return ah.f;
    }

    private static boolean a() {
        block9: {
            Object object = "android.os.SystemProperties";
            String string2 = "get";
            int n10 = 2;
            Object[] objectArray = new Object[n10];
            String string3 = "ro.build.hw_emui_api_level";
            objectArray[0] = string3;
            string3 = "";
            boolean bl2 = true;
            objectArray[bl2] = string3;
            object = ba.a((String)object, string2, objectArray);
            object = (String)object;
            int n11 = TextUtils.isEmpty((CharSequence)object);
            if (n11 != 0) break block9;
            try {
                int n12 = Integer.parseInt((String)object);
                n11 = 9;
                if (n12 >= n11) {
                    return bl2;
                }
            }
            catch (Exception exception) {
                b.a(exception);
            }
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public static boolean a(Context object) {
        boolean bl2;
        Object object2 = Integer.class;
        boolean bl3 = false;
        Object object3 = new Object[]{};
        String string2 = "com.google.android.gms.common.GoogleApiAvailability";
        object3 = ba.a(string2, "getInstance", (Object[])object3);
        boolean bl4 = true;
        Object object4 = new Object[bl4];
        object4[0] = object;
        object = ba.a(object3, "isGooglePlayServicesAvailable", object4);
        object3 = ba.a("com.google.android.gms.common.ConnectionResult", "SUCCESS");
        object4 = "google service is not avaliable";
        if (object3 != null && (bl2 = object3 instanceof Integer)) {
            void var10_17;
            object3 = (Integer)((Class)object2).cast(object3);
            int n11 = (Integer)object3;
            if (object != null) {
                bl2 = object instanceof Integer;
                if (bl2) {
                    void var9_12;
                    int n10 = (Integer)(object = (Integer)((Class)object2).cast(object));
                    if (n10 == n11) {
                        boolean bl5 = bl4;
                    } else {
                        boolean bl6 = false;
                        object = null;
                    }
                    a = var9_12;
                } else {
                    a = 0;
                    b.c((String)object4);
                }
            }
            object = new StringBuilder();
            object2 = "is google service can be used";
            ((StringBuilder)object).append((String)object2);
            int n10 = a;
            if (n10 > 0) {
                boolean bl7 = bl4;
            } else {
                boolean bl8 = false;
                object2 = null;
            }
            ((StringBuilder)object).append((boolean)var10_17);
            object = ((StringBuilder)object).toString();
            b.c((String)object);
            int n12 = a;
            if (n12 > 0) {
                bl3 = bl4;
            }
            return bl3;
        }
        b.c((String)object4);
        a = 0;
        return false;
    }

    public static boolean b(Context object) {
        int n10 = 1;
        Object object2 = new Object[n10];
        boolean bl2 = false;
        object2[0] = object;
        String string2 = "isSupportPush";
        object = ba.a("com.xiaomi.assemble.control.COSPushManager", string2, (Object[])object2);
        if (object != null && (n10 = object instanceof Boolean) != 0) {
            object2 = Boolean.class;
            object = (Boolean)((Class)object2).cast(object);
            bl2 = (Boolean)object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("color os push  is avaliable ? :");
        ((StringBuilder)object).append(bl2);
        b.c(((StringBuilder)object).toString());
        return bl2;
    }

    public static boolean c(Context object) {
        int n10 = 1;
        Object object2 = new Object[n10];
        boolean bl2 = false;
        object2[0] = object;
        String string2 = "isSupportPush";
        object = ba.a("com.xiaomi.assemble.control.FTOSPushManager", string2, (Object[])object2);
        if (object != null && (n10 = object instanceof Boolean) != 0) {
            object2 = Boolean.class;
            object = (Boolean)((Class)object2).cast(object);
            bl2 = (Boolean)object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("fun touch os push  is avaliable ? :");
        ((StringBuilder)object).append(bl2);
        b.c(((StringBuilder)object).toString());
        return bl2;
    }
}

