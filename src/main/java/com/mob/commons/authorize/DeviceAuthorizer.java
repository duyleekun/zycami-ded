/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.mob.commons.authorize;

import android.text.TextUtils;
import com.mob.commons.MobProduct;
import com.mob.commons.MobProductCollector;
import com.mob.commons.a;
import com.mob.commons.authorize.DeviceAuthorizer$1;
import com.mob.commons.b;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.HashSet;

public final class DeviceAuthorizer
implements PublicMemberKeeper {
    public static String a;
    private static HashSet b;
    private static Object c;

    static {
        Object object = new HashSet();
        b = object;
        c = object = new Object();
    }

    public static /* synthetic */ String a(MobProduct mobProduct, String string2) {
        return DeviceAuthorizer.b(mobProduct, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String authorize(MobProduct object) {
        Class<DeviceAuthorizer> clazz = DeviceAuthorizer.class;
        synchronized (clazz) {
            boolean bl2;
            Object object2;
            boolean bl3 = false;
            Object object3 = null;
            boolean bl4 = true;
            if (object != null) {
                MobProductCollector.registerProduct((MobProduct)object);
                object3 = b;
                object2 = object.getProductTag();
                bl3 = ((HashSet)object3).contains(object2) ^ bl4;
                if (bl3) {
                    object2 = b;
                    String string2 = object.getProductTag();
                    ((HashSet)object2).add(string2);
                }
            }
            if (bl2 = TextUtils.isEmpty((CharSequence)(object2 = a))) {
                object3 = new com.mob.commons.authorize.a();
                a = object3 = ((com.mob.commons.authorize.a)object3).a(bl4, bl4);
            } else {
                bl4 = bl3;
            }
            object3 = a;
            bl3 = TextUtils.isEmpty((CharSequence)object3);
            if (bl3) {
                bl3 = false;
                object3 = null;
                a = object = DeviceAuthorizer.b((MobProduct)object, null);
                boolean bl5 = TextUtils.isEmpty((CharSequence)object);
                if (!bl5) return a;
                object = new com.mob.commons.authorize.a();
                return ((com.mob.commons.authorize.a)object).a();
            }
            if (!bl4) return a;
            object3 = new DeviceAuthorizer$1((MobProduct)object);
            ((Thread)object3).start();
            return a;
        }
    }

    public static String authorizeForOnce() {
        boolean bl2 = com.mob.commons.b.aa();
        if (bl2) {
            return null;
        }
        Object object = a;
        if (object != null) {
            return object;
        }
        object = new com.mob.commons.authorize.a();
        boolean bl3 = true;
        return ((com.mob.commons.authorize.a)object).a(bl3, bl3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String b(MobProduct object, String string2) {
        Object object2 = c;
        synchronized (object2) {
            com.mob.commons.authorize.a a10 = new com.mob.commons.authorize.a();
            com.mob.commons.a.b();
            boolean bl2 = com.mob.commons.b.Z();
            if (!bl2 && (bl2 = com.mob.commons.b.i())) {
                return a10.a((MobProduct)object, string2);
            }
            object = null;
            boolean bl3 = true;
            return a10.a(false, bl3);
        }
    }
}

