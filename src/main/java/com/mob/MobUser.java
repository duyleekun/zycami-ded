/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.text.TextUtils
 */
package com.mob;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.MobUser$1;
import com.mob.MobUser$2;
import com.mob.MobUser$OnUserGotListener;
import com.mob.MobUser$UserWatcher;
import com.mob.commons.MobProduct;
import com.mob.commons.MobProductCollector;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.b;
import com.mob.commons.j;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class MobUser
implements PublicMemberKeeper {
    private static final String a = com.mob.commons.j.c("http://api.u.mob.com");
    private static MobCommunicator b;
    private static Handler c;
    private static String d;
    private static MobUser e;
    private boolean f;
    private String g;
    private String h;
    private String i;
    private HashMap j;
    private String k;
    private String l;
    private long m;
    private HashSet n;

    static {
        Object object = new MobCommunicator(1024, "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b671a8ca5d78efede48e291a3f", "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1");
        b = object;
        object = new MobUser$1();
        c = MobHandlerThread.newHandler("m", (Handler.Callback)object);
        e = object = new MobUser();
    }

    private MobUser() {
        HashSet hashSet;
        this.n = hashSet = new HashSet();
    }

    public static HashMap a(String[] object) {
        block13: {
            boolean bl2 = com.mob.commons.b.Z();
            if (bl2) break block13;
            HashMap<String, String[]> hashMap = new HashMap<String, String[]>();
            CharSequence charSequence = "appUserIds";
            hashMap.put((String)charSequence, (String[])object);
            object = "appkey";
            charSequence = MobSDK.getAppkey();
            hashMap.put((String)object, (String[])charSequence);
            object = b;
            charSequence = new StringBuilder();
            String string2 = a;
            ((StringBuilder)charSequence).append(string2);
            string2 = "/exchange";
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            string2 = null;
            object = ((MobCommunicator)object).requestSynchronized(hashMap, (String)charSequence, false);
            try {
                return (HashMap)object;
            }
            catch (Throwable throwable) {
                hashMap = MobLog.getInstance();
                ((NLog)((Object)hashMap)).d(throwable);
            }
        }
        return null;
    }

    public static void a() {
        c.sendEmptyMessage(3);
    }

    public static void a(MobUser$OnUserGotListener mobUser$OnUserGotListener) {
        Message message = new Message();
        message.what = 2;
        message.obj = mobUser$OnUserGotListener;
        c.sendMessage(message);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(MobUser$UserWatcher mobUser$UserWatcher) {
        HashSet hashSet = MobUser.e.n;
        synchronized (hashSet) {
            Object object = e;
            object = ((MobUser)object).n;
            ((HashSet)object).add(mobUser$UserWatcher);
            return;
        }
    }

    public static void a(String string2, String string3, String string4, HashMap hashMap, String string5) {
        int n10;
        Message message = new Message();
        message.what = n10 = 1;
        Object[] objectArray = new Object[5];
        objectArray[0] = string2;
        objectArray[n10] = string3;
        objectArray[2] = string4;
        objectArray[3] = hashMap;
        objectArray[4] = string5;
        message.obj = objectArray;
        c.sendMessage(message);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(String iterator2, String object, HashMap object2) {
        Object object3 = e;
        Object object4 = ((MobUser)object3).l;
        if (object4 == null) {
            ((MobUser)object3).h = iterator2;
            ((MobUser)object3).i = object;
            ((MobUser)object3).j = object2;
            return;
        }
        boolean bl2 = ((MobUser)object3).f();
        if (!bl2) {
            object3 = e;
            object4 = ((MobUser)object3).g;
            object3 = ((MobUser)object3).k;
            MobUser.d((String)object4, iterator2, (String)object, (HashMap)object2, (String)object3);
            return;
        }
        object3 = new HashMap();
        object4 = MobUser.e.l;
        ((HashMap)object3).put("mobUserId", object4);
        boolean bl3 = TextUtils.isEmpty(iterator2);
        Object object5 = "";
        object4 = bl3 ? object5 : iterator2;
        String string2 = "nickname";
        ((HashMap)object3).put(string2, object4);
        bl3 = TextUtils.isEmpty((CharSequence)object);
        if (!bl3) {
            object5 = object;
        }
        object4 = "avatar";
        ((HashMap)object3).put(object4, object5);
        object4 = object2 != null ? new HashMap() : object2;
        object5 = "appUserMap";
        ((HashMap)object3).put(object5, object4);
        try {
            boolean bl4;
            bl3 = com.mob.commons.b.Z();
            if (!bl3) {
                object4 = b;
                object5 = new StringBuilder();
                string2 = a;
                ((StringBuilder)object5).append(string2);
                string2 = "/modify";
                ((StringBuilder)object5).append(string2);
                object5 = ((StringBuilder)object5).toString();
                string2 = null;
                ((MobCommunicator)object4).requestSynchronized((HashMap)object3, (String)object5, false);
                object3 = e;
                ((MobUser)object3).h = iterator2;
                ((MobUser)object3).i = object;
                ((MobUser)object3).j = object2;
            }
            iterator2 = e;
            iterator2 = ((MobUser)iterator2).n;
            iterator2 = ((HashSet)((Object)iterator2)).iterator();
            while (bl4 = iterator2.hasNext()) {
                object = iterator2.next();
                object = (MobUser$UserWatcher)object;
                object2 = e;
                object.onUserStateChange((MobUser)object2);
            }
            return;
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).w(throwable);
        }
    }

    public static /* synthetic */ void b() {
        MobUser.e();
    }

    public static /* synthetic */ void b(MobUser$OnUserGotListener mobUser$OnUserGotListener) {
        MobUser.c(mobUser$OnUserGotListener);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void b(MobUser$UserWatcher mobUser$UserWatcher) {
        HashSet hashSet = MobUser.e.n;
        synchronized (hashSet) {
            Object object = e;
            object = ((MobUser)object).n;
            ((HashSet)object).remove(mobUser$UserWatcher);
            return;
        }
    }

    public static /* synthetic */ void b(String string2, String string3, String string4, HashMap hashMap, String string5) {
        MobUser.c(string2, string3, string4, hashMap, string5);
    }

    public static /* synthetic */ MobUser c() {
        return e;
    }

    private static void c(MobUser$OnUserGotListener mobUser$OnUserGotListener) {
        boolean bl2;
        Object object = e;
        Object object2 = ((MobUser)object).l;
        if (object2 == null || !(bl2 = ((MobUser)object).f())) {
            object = e;
            object2 = ((MobUser)object).g;
            String string2 = ((MobUser)object).h;
            String string3 = ((MobUser)object).i;
            HashMap hashMap = ((MobUser)object).j;
            object = ((MobUser)object).k;
            MobUser.d((String)object2, string2, string3, hashMap, (String)object);
        }
        if (mobUser$OnUserGotListener != null) {
            bl2 = false;
            object = null;
            object2 = new MobUser$2(mobUser$OnUserGotListener);
            UIHandler.sendEmptyMessage(0, (Handler.Callback)object2);
        }
    }

    private static void c(String string2, String string3, String string4, HashMap hashMap, String string5) {
        boolean bl2;
        Object object = e;
        String string6 = ((MobUser)object).l;
        if (string6 != null && (bl2 = ((MobUser)object).f()) && (bl2 = ResHelper.isEqual(string2, object = MobUser.e.g))) {
            MobUser.a(string3, string4, hashMap);
        } else {
            MobUser.d(string2, string3, string4, hashMap, string5);
        }
    }

    private static String d() {
        Object object = d;
        if (object == null) {
            object = MobProductCollector.getProducts();
            boolean bl2 = object.isEmpty();
            if (bl2) {
                object = null;
            } else {
                bl2 = false;
                object = (MobProduct)object.get(0);
            }
            d = object = DeviceAuthorizer.authorize((MobProduct)object);
        }
        return d;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void d(String object, String object2, String object3, HashMap hashMap, String string2) {
        String string3;
        boolean bl2;
        Object object4 = MobUser.e.l;
        if (object4 != null) {
            MobUser.e();
        }
        object4 = new HashMap();
        Object object5 = MobProductCollector.getProducts();
        Object object6 = new ArrayList();
        object5 = ((ArrayList)object5).iterator();
        while (bl2 = object5.hasNext()) {
            string3 = ((MobProduct)object5.next()).getProductTag();
            ((ArrayList)object6).add(string3);
        }
        object5 = "sdks";
        ((HashMap)object4).put(object5, object6);
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (!bl3) {
            object5 = "appUserId";
            ((HashMap)object4).put(object5, object);
        }
        object5 = MobSDK.getAppkey();
        ((HashMap)object4).put("appkey", object5);
        bl3 = TextUtils.isEmpty((CharSequence)object2);
        object6 = "";
        object5 = bl3 ? object6 : object2;
        string3 = "nickname";
        ((HashMap)object4).put(string3, object5);
        bl3 = TextUtils.isEmpty((CharSequence)object3);
        if (!bl3) {
            object6 = object3;
        }
        object5 = "avatar";
        ((HashMap)object4).put(object5, object6);
        object5 = hashMap == null ? new HashMap() : hashMap;
        ((HashMap)object4).put("appUserMap", object5);
        object5 = MobUser.d();
        object6 = "duid";
        ((HashMap)object4).put(object6, object5);
        bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3) {
            object5 = "sign";
            ((HashMap)object4).put(object5, string2);
        }
        try {
            boolean bl4;
            bl3 = com.mob.commons.b.Z();
            if (!bl3) {
                boolean bl5;
                object5 = b;
                object6 = new StringBuilder();
                string3 = a;
                ((StringBuilder)object6).append(string3);
                string3 = "/login";
                ((StringBuilder)object6).append(string3);
                object6 = ((StringBuilder)object6).toString();
                bl2 = false;
                string3 = null;
                object4 = ((MobCommunicator)object5).requestSynchronized((HashMap)object4, (String)object6, false);
                object4 = (HashMap)object4;
                object5 = "mobUserId";
                object5 = ((HashMap)object4).get(object5);
                object5 = (String)object5;
                object6 = "loginExpireAt";
                object4 = ((HashMap)object4).get(object6);
                object4 = String.valueOf(object4);
                long l10 = Long.parseLong((String)object4);
                com.mob.commons.b.a();
                object4 = e;
                ((MobUser)object4).g = object;
                ((MobUser)object4).f = bl5 = TextUtils.isEmpty(object);
                object = e;
                ((MobUser)object).h = object2;
                ((MobUser)object).i = object3;
                ((MobUser)object).j = hashMap;
                ((MobUser)object).k = string2;
                ((MobUser)object).l = object5;
                ((MobUser)object).m = l10;
            }
            object = e;
            object = ((MobUser)object).n;
            object = ((HashSet)object).iterator();
            while (bl4 = object.hasNext()) {
                object2 = object.next();
                object2 = (MobUser$UserWatcher)object2;
                object3 = e;
                object2.onUserStateChange((MobUser)object3);
            }
            return;
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).w(throwable);
        }
    }

    private static void e() {
        long l10;
        long l11;
        boolean bl2;
        Object object;
        boolean bl3;
        Object object2 = MobUser.e.l;
        boolean bl4 = false;
        MobUser$UserWatcher mobUser$UserWatcher = null;
        if (object2 != null && !(bl3 = com.mob.commons.b.Z())) {
            object2 = new HashMap();
            object = MobUser.e.l;
            CharSequence charSequence = "mobUserId";
            ((HashMap)object2).put(charSequence, object);
            object = b;
            charSequence = new StringBuilder();
            String string2 = a;
            ((StringBuilder)charSequence).append(string2);
            string2 = "/logout";
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            try {
                ((MobCommunicator)object).requestSynchronized((HashMap)object2, (String)charSequence, false);
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).w(throwable);
            }
        }
        object2 = e;
        object = ((MobUser)object2).l;
        long l12 = 0L;
        boolean bl5 = true;
        if (object != null || (object = ((MobUser)object2).g) != null || (object = ((MobUser)object2).h) != null || (object = ((MobUser)object2).i) != null || (object = ((MobUser)object2).j) != null || (object = ((MobUser)object2).k) != null || !(bl2 = ((MobUser)object2).f) || (bl2 = (l11 = (l10 = ((MobUser)object2).m) - l12) == 0L ? 0 : (l11 < 0L ? -1 : 1))) {
            bl4 = bl5;
        }
        bl2 = false;
        object = null;
        ((MobUser)object2).l = null;
        ((MobUser)object2).g = null;
        ((MobUser)object2).h = null;
        ((MobUser)object2).i = null;
        ((MobUser)object2).j = null;
        ((MobUser)object2).k = null;
        ((MobUser)object2).f = bl5;
        ((MobUser)object2).m = l12;
        if (bl4) {
            object2 = ((MobUser)object2).n.iterator();
            while (bl4 = object2.hasNext()) {
                mobUser$UserWatcher = (MobUser$UserWatcher)object2.next();
                object = e;
                mobUser$UserWatcher.onUserStateChange((MobUser)object);
            }
        }
    }

    private boolean f() {
        long l10;
        long l11 = com.mob.commons.b.a();
        long l12 = l11 - (l10 = this.m);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object < 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public String getAvatar() {
        return this.i;
    }

    public HashMap getExtraInfo() {
        return this.j;
    }

    public String getId() {
        return this.g;
    }

    public String getMobUserId() {
        return this.l;
    }

    public String getNickName() {
        return this.h;
    }

    public boolean isAnonymous() {
        return this.f;
    }
}

