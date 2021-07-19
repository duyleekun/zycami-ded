/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.SharedPreferences$Editor
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.database.ContentObserver
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.Messenger
 *  android.os.RemoteException
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.ag;
import com.xiaomi.mipush.sdk.aj;
import com.xiaomi.mipush.sdk.aq$a;
import com.xiaomi.mipush.sdk.as;
import com.xiaomi.mipush.sdk.at;
import com.xiaomi.mipush.sdk.au;
import com.xiaomi.mipush.sdk.av;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.h;
import com.xiaomi.push.az;
import com.xiaomi.push.be;
import com.xiaomi.push.df;
import com.xiaomi.push.fb;
import com.xiaomi.push.hm;
import com.xiaomi.push.hn;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.hw;
import com.xiaomi.push.hz;
import com.xiaomi.push.ii;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.is;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.l;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.aw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class aq {
    private static aq a;
    private static final ArrayList a;
    private static boolean b = false;
    private Context a;
    private Intent a;
    private Handler a;
    private Messenger a;
    private Integer a;
    private String a;
    private List a;
    private boolean a = null;
    private boolean c;

    static {
        ArrayList arrayList;
        a = arrayList = new ArrayList();
    }

    private aq(Context object) {
        boolean bl2;
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
        this.c = false;
        this.a = null;
        this.a = null;
        this.a = object = object.getApplicationContext();
        this.a = null;
        this.a = bl2 = this.c();
        b = bl2 = this.d();
        Looper looper = Looper.getMainLooper();
        super(this, looper);
        this.a = object;
        object = this.b();
        if (object != null) {
            this.b((Intent)object);
        }
    }

    private int a() {
        synchronized (this) {
            Context context = this.a;
            String string2 = "mipush_extra";
            int n10 = 0;
            context = context.getSharedPreferences(string2, 0);
            string2 = "service_boot_mode";
            n10 = -1;
            int n11 = context.getInt(string2, n10);
            return n11;
        }
    }

    public static /* synthetic */ Context a(aq aq2) {
        return aq2.a;
    }

    private Intent a() {
        String string2;
        String string3;
        boolean bl2 = this.a();
        if (bl2 && !(bl2 = (string3 = "com.xiaomi.xmsf").equals(string2 = this.a.getPackageName()))) {
            return this.d();
        }
        return this.e();
    }

    private Message a(Intent intent) {
        Message message = Message.obtain();
        message.what = 17;
        message.obj = intent;
        return message;
    }

    public static /* synthetic */ Messenger a(aq aq2) {
        return aq2.a;
    }

    public static /* synthetic */ Messenger a(aq aq2, Messenger messenger) {
        aq2.a = messenger;
        return messenger;
    }

    public static aq a(Context object) {
        Class<aq> clazz = aq.class;
        synchronized (clazz) {
            aq aq2 = a;
            if (aq2 == null) {
                a = aq2 = new aq((Context)object);
            }
            object = a;
            return object;
        }
    }

    public static /* synthetic */ Integer a(aq aq2) {
        return aq2.a;
    }

    public static /* synthetic */ Integer a(aq aq2, Integer n10) {
        aq2.a = n10;
        return n10;
    }

    private String a() {
        Context context;
        try {
            context = this.a;
        }
        catch (Exception exception) {}
        context = context.getPackageManager();
        String string2 = "com.xiaomi.xmsf";
        int n10 = 4;
        context = context.getPackageInfo(string2, n10);
        int n11 = context.versionCode;
        int n12 = 106;
        if (n11 >= n12) {
            return "com.xiaomi.push.service.XMPushService";
        }
        return "com.xiaomi.xmsf.push.service.XMPushService";
    }

    public static /* synthetic */ List a(aq aq2) {
        return aq2.a;
    }

    public static /* synthetic */ void a(aq aq2, String string2, av av2, boolean bl2, HashMap hashMap) {
        aq2.a(string2, av2, bl2, hashMap);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string2, av av2, boolean bl2, HashMap object) {
        int n10;
        Object object2;
        int n11;
        Object object3;
        Object object4;
        il il2;
        Context context;
        Intent intent;
        boolean bl3;
        Object object5;
        block19: {
            object5 = com.xiaomi.mipush.sdk.b.a(this.a);
            boolean bl4 = ((b)object5).b();
            if (!bl4) return;
            object5 = this.a;
            bl4 = az.b((Context)object5);
            if (!bl4) {
                return;
            }
            object5 = new il();
            bl3 = true;
            ((il)object5).a(bl3);
            intent = this.a();
            boolean bl5 = TextUtils.isEmpty((CharSequence)string2);
            context = null;
            if (bl5) {
                string2 = an.a();
                ((il)object5).a(string2);
                if (bl2) {
                    il2 = new il(string2, bl3);
                } else {
                    bl5 = false;
                    il2 = null;
                }
                object4 = ag.class;
                synchronized (object4) {
                    object3 = this.a;
                    object3 = ag.a((Context)object3);
                    ((ag)object3).a(string2);
                }
            } else {
                ((il)object5).a(string2);
                if (bl2) {
                    il2 = new il(string2, bl3);
                } else {
                    bl5 = false;
                    il2 = null;
                }
            }
            object4 = au.a;
            int n12 = av2.ordinal();
            n11 = object4[n12];
            switch (n11) {
                default: {
                    break block19;
                }
                case 3: 
                case 4: 
                case 5: 
                case 6: {
                    object4 = hw.M.a;
                    ((il)object5).c((String)object4);
                    if (object != null) {
                        ((il)object5).a((Map)object);
                    }
                    break block19;
                }
                case 2: {
                    object4 = (Object)hw.E;
                    object3 = object4.a;
                    ((il)object5).c((String)object3);
                    object4 = object4.a;
                    il2.c((String)object4);
                    if (object != null) {
                        ((il)object5).a((Map)object);
                        il2.a((Map)object);
                    }
                    object = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    break;
                }
                case 1: {
                    object4 = (Object)hw.D;
                    object3 = object4.a;
                    ((il)object5).c((String)object3);
                    object4 = object4.a;
                    il2.c((String)object4);
                    if (object != null) {
                        ((il)object5).a((Map)object);
                        il2.a((Map)object);
                    }
                    object = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                }
            }
            intent.setAction((String)object);
        }
        object = com.xiaomi.mipush.sdk.b.a(this.a).a();
        ((il)object5).b((String)object);
        object = this.a.getPackageName();
        ((il)object5).d((String)object);
        object = hm.i;
        n11 = 0;
        object4 = null;
        this.a((ix)object5, (hm)((Object)object), false, null);
        if (bl2) {
            object2 = com.xiaomi.mipush.sdk.b.a(this.a).a();
            il2.b((String)object2);
            object2 = this.a.getPackageName();
            il2.d((String)object2);
            object4 = this.a;
            String string3 = object4.getPackageName();
            String string4 = com.xiaomi.mipush.sdk.b.a(this.a).a();
            object3 = il2;
            object2 = iw.a(aj.a((Context)object4, il2, (hm)((Object)object), false, string3, string4));
            if (object2 != null) {
                object5 = this.a.getPackageName();
                context = this.a;
                n11 = ((Message)object2).length;
                df.a((String)object5, context, il2, (hm)((Object)object), n11);
                intent.putExtra("mipush_payload", (byte[])object2);
                intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", bl3);
                object = com.xiaomi.mipush.sdk.b.a(this.a).a();
                intent.putExtra("mipush_app_id", (String)object);
                object2 = "mipush_app_token";
                object = com.xiaomi.mipush.sdk.b.a(this.a).b();
                intent.putExtra((String)object2, (String)object);
                this.c(intent);
            }
        }
        object2 = Message.obtain();
        object2.what = n10 = 19;
        int n13 = av2.ordinal();
        object2.obj = string2;
        object2.arg1 = n13;
        string2 = this.a;
        long l10 = 5000L;
        string2.sendMessageDelayed(object2, l10);
    }

    public static /* synthetic */ boolean a(aq aq2, boolean bl2) {
        aq2.c = bl2;
        return bl2;
    }

    private Intent b() {
        String string2 = "com.xiaomi.xmsf";
        String string3 = this.a.getPackageName();
        boolean bl2 = string2.equals(string3);
        if (!bl2) {
            return this.c();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
        return this.e();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(Intent intent) {
        try {
            int n10;
            int n11 = l.a();
            if (n11 == 0 && (n11 = Build.VERSION.SDK_INT) >= (n10 = 26)) {
                this.d(intent);
                return;
            }
            Context context = this.a;
            context.startService(intent);
            return;
        }
        catch (Exception exception) {
            com.xiaomi.channel.commonutils.logger.b.a(exception);
        }
    }

    private Intent c() {
        boolean bl2 = this.a();
        if (bl2) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return this.d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return this.e();
    }

    private void c(int n10) {
        synchronized (this) {
            Context context = this.a;
            String string2 = "mipush_extra";
            context = context.getSharedPreferences(string2, 0);
            context = context.edit();
            string2 = "service_boot_mode";
            SharedPreferences.Editor editor = context.putInt(string2, n10);
            editor.commit();
            return;
        }
    }

    private void c(Intent intent) {
        ak ak2 = ak.a(this.a);
        hr hr2 = hr.T;
        int n10 = hr2.a();
        hn hn2 = hn.a;
        int n11 = hn2.a();
        int n12 = ak2.a(n10, n11);
        n10 = this.a();
        hn hn3 = hn.b;
        int n13 = hn3.a();
        if (n12 == n13 && (n12 = (int)(b ? 1 : 0)) != 0) {
            n12 = 1;
        } else {
            n12 = 0;
            ak2 = null;
        }
        int n14 = n12 != 0 ? hn3.a() : hn2.a();
        if (n14 != n10) {
            this.a(n14);
        }
        if (n12 != 0) {
            this.d(intent);
        } else {
            this.b(intent);
        }
    }

    private boolean c() {
        PackageManager packageManager;
        block3: {
            packageManager = this.a.getPackageManager();
            String string2 = "com.xiaomi.xmsf";
            int n10 = 4;
            try {
                packageManager = packageManager.getPackageInfo(string2, n10);
                if (packageManager != null) break block3;
                return false;
            }
            catch (Throwable throwable) {
                return false;
            }
        }
        int n11 = packageManager.versionCode;
        int n12 = 105;
        return n11 >= n12;
    }

    private Intent d() {
        Intent intent = new Intent();
        String string2 = this.a.getPackageName();
        String string3 = "com.xiaomi.xmsf";
        intent.setPackage(string3);
        String string4 = this.a();
        intent.setClassName(string3, string4);
        intent.putExtra("mipush_app_package", string2);
        this.f();
        return intent;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void d(Intent intent) {
        synchronized (this) {
            int n10 = this.c;
            at at2 = null;
            if (n10 != 0) {
                int n11;
                intent = this.a(intent);
                List list = this.a;
                n10 = list.size();
                if (n10 >= (n11 = 50)) {
                    list = this.a;
                    list.remove(0);
                }
                list = this.a;
                list.add(intent);
                return;
            }
            Object object = this.a;
            if (object == null) {
                object = this.a;
                at2 = new at(this);
                int n12 = 1;
                object.bindService(intent, (ServiceConnection)at2, n12);
                this.c = n12;
                object = this.a;
                object.clear();
                intent = this.a(intent);
                object = this.a;
                object.add(intent);
            } else {
                intent = this.a(intent);
                try {
                    object = this.a;
                    object.send((Message)intent);
                }
                catch (RemoteException remoteException) {
                    intent = null;
                    this.a = null;
                    this.c = false;
                }
            }
            return;
        }
    }

    private boolean d() {
        int n10 = this.a();
        boolean bl2 = true;
        if (n10 != 0) {
            Context context;
            try {
                context = this.a;
            }
            catch (Exception exception) {}
            context = context.getPackageManager();
            String string2 = "com.xiaomi.xmsf";
            int n11 = 4;
            context = context.getPackageInfo(string2, n11);
            n10 = context.versionCode;
            int n12 = 108;
            if (n10 >= n12) {
                return bl2;
            }
            return false;
        }
        return bl2;
    }

    private Intent e() {
        Intent intent = new Intent();
        String string2 = this.a.getPackageName();
        this.g();
        Context context = this.a;
        ComponentName componentName = new ComponentName(context, "com.xiaomi.push.service.XMPushService");
        intent.setComponent(componentName);
        intent.putExtra("mipush_app_package", string2);
        return intent;
    }

    private boolean e() {
        int n10;
        String string2 = this.a.getPackageName();
        String string3 = "miui";
        boolean bl2 = string2.contains(string3);
        int n11 = 1;
        if (!bl2 && (n10 = string2.contains(string3 = "xiaomi")) == 0) {
            string2 = this.a.getApplicationInfo();
            n10 = ((ApplicationInfo)string2).flags & n11;
            if (n10 == 0) {
                n11 = 0;
            }
        }
        return n11 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void f() {
        Context context;
        try {
            context = this.a;
        }
        catch (Throwable throwable) {
            return;
        }
        context = context.getPackageManager();
        Context context2 = this.a;
        String string2 = "com.xiaomi.push.service.XMPushService";
        ComponentName componentName = new ComponentName(context2, string2);
        int n10 = context.getComponentEnabledSetting(componentName);
        int n11 = 2;
        if (n10 == n11) {
            return;
        }
        n10 = 1;
        context.setComponentEnabledSetting(componentName, n11, n10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void g() {
        int n10;
        ComponentName componentName;
        Context context;
        block9: {
            try {
                context = this.a;
            }
            catch (Throwable throwable) {
                return;
            }
            context = context.getPackageManager();
            Context context2 = this.a;
            String string2 = "com.xiaomi.push.service.XMPushService";
            componentName = new ComponentName(context2, string2);
            int n11 = context.getComponentEnabledSetting(componentName);
            n10 = 1;
            if (n11 != n10) break block9;
            return;
        }
        context.setComponentEnabledSetting(componentName, n10, n10);
    }

    public void a() {
        Intent intent = this.a();
        this.b(intent);
    }

    public void a(int n10) {
        Intent intent = this.a();
        intent.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        String string2 = com.xiaomi.push.service.at.z;
        String string3 = this.a.getPackageName();
        intent.putExtra(string2, string3);
        string2 = com.xiaomi.push.service.at.A;
        intent.putExtra(string2, n10);
        this.c(intent);
    }

    public void a(int n10, String string2) {
        Intent intent = this.a();
        intent.setAction("com.xiaomi.mipush.thirdparty");
        intent.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", n10);
        intent.putExtra("com.xiaomi.mipush.thirdparty_DESC", string2);
        this.b(intent);
    }

    public void a(Intent intent) {
        Intent intent2 = this.a();
        intent.fillIn(intent2, 24);
        this.c(intent);
    }

    public final void a(hq object) {
        Intent intent = this.a();
        if ((object = (Object)iw.a((ix)object)) == null) {
            com.xiaomi.channel.commonutils.logger.b.a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        intent.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        intent.putExtra("mipush_payload", (byte[])object);
        this.b(intent);
    }

    public final void a(im object, boolean bl2) {
        Object object2 = fb.a(this.a.getApplicationContext());
        Object object3 = this.a.getPackageName();
        String string2 = ((im)object).a();
        String string3 = "E100003";
        int n10 = 6001;
        ((fb)object2).a((String)object3, string3, string2, n10, null);
        this.a = null;
        b b10 = com.xiaomi.mipush.sdk.b.a(this.a);
        b10.a = object2 = ((im)object).a();
        b10 = this.a();
        object2 = this.a;
        object3 = hm.a;
        object = iw.a(aj.a((Context)object2, (ix)object, (hm)((Object)object3)));
        if (object == null) {
            com.xiaomi.channel.commonutils.logger.b.a("register fail, because msgBytes is null.");
            return;
        }
        b10.setAction("com.xiaomi.mipush.REGISTER_APP");
        object2 = com.xiaomi.mipush.sdk.b.a(this.a).a();
        object3 = "mipush_app_id";
        b10.putExtra((String)object3, (String)object2);
        b10.putExtra("mipush_payload", (byte[])object);
        object = this.a;
        object2 = "mipush_session";
        b10.putExtra((String)object2, (String)object);
        b10.putExtra("mipush_env_chanage", bl2);
        int n11 = com.xiaomi.mipush.sdk.b.a(this.a).a();
        String string4 = "mipush_env_type";
        b10.putExtra(string4, n11);
        object = this.a;
        n11 = (int)(az.b((Context)object) ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(this.b() ? 1 : 0)) != 0) {
            this.c((Intent)b10);
        } else {
            this.a = b10;
        }
    }

    public final void a(is object) {
        Context context = this.a;
        Object object2 = hm.b;
        if ((object = (Object)iw.a(aj.a(context, (ix)object, object2))) == null) {
            com.xiaomi.channel.commonutils.logger.b.a("unregister fail, because msgBytes is null.");
            return;
        }
        context = this.a();
        context.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        object2 = com.xiaomi.mipush.sdk.b.a(this.a).a();
        context.putExtra("mipush_app_id", (String)object2);
        context.putExtra("mipush_payload", (byte[])object);
        this.c((Intent)context);
    }

    public final void a(ix ix2, hm hm2, hz hz2) {
        hm hm3 = hm.a;
        boolean bl2 = hm2.equals((Object)hm3) ^ true;
        this.a(ix2, hm2, bl2, hz2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(ix serializable, hm hm2, boolean n10) {
        aq$a aq$a = new aq$a();
        aq$a.a = serializable;
        aq$a.a = hm2;
        aq$a.a = n10;
        serializable = a;
        synchronized (serializable) {
            ((ArrayList)serializable).add(aq$a);
            int n11 = ((ArrayList)serializable).size();
            n10 = 10;
            if (n11 > n10) {
                n11 = 0;
                hm2 = null;
                ((ArrayList)serializable).remove(0);
            }
            return;
        }
    }

    public final void a(ix ix2, hm hm2, boolean bl2, hz hz2) {
        this.a(ix2, hm2, bl2, true, hz2, true);
    }

    public final void a(ix ix2, hm hm2, boolean bl2, hz hz2, boolean bl3) {
        this.a(ix2, hm2, bl2, true, hz2, bl3);
    }

    public final void a(ix ix2, hm hm2, boolean bl2, boolean bl3, hz hz2, boolean bl4) {
        String string2 = this.a.getPackageName();
        String string3 = com.xiaomi.mipush.sdk.b.a(this.a).a();
        this.a(ix2, hm2, bl2, bl3, hz2, bl4, string2, string3);
    }

    public final void a(ix object, hm object2, boolean bl2, boolean bl3, hz hz2, boolean bl4, String string2, String string3) {
        b b10 = com.xiaomi.mipush.sdk.b.a(this.a);
        boolean bl5 = b10.c();
        if (!bl5) {
            if (bl3) {
                this.a((ix)object, (hm)((Object)object2), bl2);
            } else {
                object = "drop the message before initialization.";
                com.xiaomi.channel.commonutils.logger.b.a((String)object);
            }
        } else {
            b10 = this.a;
            Object object3 = aj.a((Context)b10, (ix)object, object2, bl2, string2, string3);
            if (hz2 != null) {
                ((ii)object3).a(hz2);
            }
            if ((object3 = (Object)iw.a((ix)object3)) == null) {
                com.xiaomi.channel.commonutils.logger.b.a("send message fail, because msgBytes is null.");
                return;
            }
            String string4 = this.a.getPackageName();
            hz2 = this.a;
            int n10 = ((Object)object3).length;
            df.a(string4, (Context)hz2, (ix)object, object2, n10);
            object = this.a();
            object.setAction("com.xiaomi.mipush.SEND_MESSAGE");
            object.putExtra("mipush_payload", (byte[])object3);
            object2 = "com.xiaomi.mipush.MESSAGE_CACHE";
            object.putExtra((String)object2, bl4);
            this.c((Intent)object);
        }
    }

    public final void a(String string2, av av2, d object) {
        ag.a(this.a).a(av2, "syncing");
        object = h.a(this.a, object);
        this.a(string2, av2, false, (HashMap)object);
    }

    public void a(String string2, String string3) {
        Intent intent = this.a();
        intent.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        String string4 = com.xiaomi.push.service.at.z;
        String string5 = this.a.getPackageName();
        intent.putExtra(string4, string5);
        string4 = com.xiaomi.push.service.at.E;
        intent.putExtra(string4, string2);
        string2 = com.xiaomi.push.service.at.F;
        intent.putExtra(string2, string3);
        this.c(intent);
    }

    public final void a(boolean bl2) {
        this.a(bl2, null);
    }

    public final void a(boolean bl2, String string2) {
        av av2;
        ag ag2;
        boolean bl3 = true;
        String string3 = "";
        Object object = "syncing";
        if (bl2) {
            ag2 = ag.a(this.a);
            av2 = av.a;
            ag2.a(av2, (String)object);
            ag2 = ag.a(this.a);
            object = av.b;
        } else {
            ag2 = ag.a(this.a);
            av2 = av.b;
            ag2.a(av2, (String)object);
            ag2 = ag.a(this.a);
            object = av.a;
        }
        ag2.a((av)((Object)object), string3);
        this.a(string2, av2, bl3, null);
    }

    public boolean a() {
        b b10;
        int n10 = this.a;
        int n11 = 1;
        if (n10 == 0 || n11 != (n10 = (b10 = com.xiaomi.mipush.sdk.b.a(this.a)).a())) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean a(int n10) {
        Object object = com.xiaomi.mipush.sdk.b.a(this.a);
        boolean bl2 = ((b)object).b();
        if (!bl2) {
            return false;
        }
        this.c(n10);
        object = new il();
        Object object2 = an.a();
        ((il)object).a((String)object2);
        object2 = com.xiaomi.mipush.sdk.b.a(this.a).a();
        ((il)object).b((String)object2);
        object2 = this.a.getPackageName();
        ((il)object).d((String)object2);
        object2 = hw.F.a;
        ((il)object).c((String)object2);
        ((il)object).a = object2 = new Object();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n10);
        stringBuilder.append("");
        Object object3 = stringBuilder.toString();
        object2.put("boot_mode", (String)object3);
        object3 = aq.a(this.a);
        object2 = hm.i;
        ((aq)object3).a((ix)object, (hm)((Object)object2), false, null);
        return true;
    }

    public final void b() {
        Intent intent = this.a();
        intent.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        this.c(intent);
    }

    public void b(int n10) {
        Intent intent = this.a();
        intent.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        String string2 = com.xiaomi.push.service.at.z;
        CharSequence charSequence = this.a.getPackageName();
        intent.putExtra(string2, (String)charSequence);
        string2 = com.xiaomi.push.service.at.B;
        intent.putExtra(string2, n10);
        string2 = com.xiaomi.push.service.at.D;
        charSequence = new StringBuilder();
        String string3 = this.a.getPackageName();
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(n10);
        String string4 = be.b(((StringBuilder)charSequence).toString());
        intent.putExtra(string2, string4);
        this.c(intent);
    }

    public boolean b() {
        int n10 = this.a();
        boolean bl2 = true;
        if (n10 != 0 && (n10 = this.e()) != 0) {
            Object object = this.a;
            if (object == null) {
                this.a = object = Integer.valueOf(aw.a(this.a).a());
                n10 = object;
                if (n10 == 0) {
                    Looper looper = Looper.getMainLooper();
                    Handler handler = new Handler(looper);
                    object = new as(this, handler);
                    handler = this.a.getContentResolver();
                    looper = aw.a(this.a).a();
                    handler.registerContentObserver((Uri)looper, false, (ContentObserver)object);
                }
            }
            if ((n10 = (object = this.a).intValue()) == 0) {
                bl2 = false;
            }
        }
        return bl2;
    }

    public void c() {
        Intent intent = this.a;
        if (intent != null) {
            this.c(intent);
            intent = null;
            this.a = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d() {
        ArrayList arrayList = a;
        synchronized (arrayList) {
            Object object = arrayList.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    object = a;
                    ((ArrayList)object).clear();
                    return;
                }
                Object object2 = object.next();
                object2 = (aq$a)object2;
                ix ix2 = ((aq$a)object2).a;
                hm hm2 = ((aq$a)object2).a;
                boolean bl3 = ((aq$a)object2).a;
                boolean bl4 = true;
                this.a(ix2, hm2, bl3, false, null, bl4);
            }
        }
    }

    public void e() {
        Intent intent = this.a();
        intent.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        String string2 = com.xiaomi.push.service.at.z;
        String string3 = this.a.getPackageName();
        intent.putExtra(string2, string3);
        string2 = com.xiaomi.push.service.at.D;
        string3 = be.b(this.a.getPackageName());
        intent.putExtra(string2, string3);
        this.c(intent);
    }
}

