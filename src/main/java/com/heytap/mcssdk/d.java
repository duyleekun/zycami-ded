/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.os.Build$VERSION
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.heytap.mcssdk.b;
import com.heytap.mcssdk.d$1;
import com.heytap.mcssdk.d$a;
import com.heytap.mcssdk.e.a;
import com.heytap.mcssdk.f.c;
import com.heytap.mcssdk.f.e;
import com.heytap.mcssdk.f.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class d
implements b {
    public static final String a = "push_register";
    public static final String b = "push_transmit";
    private static final int[] c;
    private static final int[] d;
    private static final String e = "com.mcs.action.RECEIVE_SDK_MESSAGE";
    private static final String f = "type";
    private static final int g = 1019;
    private static final String h = "eventID";
    private static final String i = "taskID";
    private static final String j = "appPackage";
    private static final String k = "extra";
    private static final String l = "messageType";
    private static final String m = "messageID";
    private static final String n = "globalID";
    private static final String o = "supportOpenPush";
    private static final String p = "versionName";
    private static final String q = "versionCode";
    private static final String r = "pushSdkVersion";
    private static final int s = 23;
    private static final int t = 59;
    private static final int u = 24;
    private static final int v = 1000;
    private static int w;
    private static String x;
    private static boolean y;
    private Context A;
    private List B;
    private List C;
    private String D;
    private String E;
    private String F;
    private d.i.a.a.b.a G;
    private final Object z;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[15];
        int[] nArray3 = nArray;
        nArray2[0] = 99;
        nArray3[1] = 111;
        nArray2[2] = 109;
        nArray3[3] = 46;
        nArray2[4] = 99;
        nArray3[5] = 111;
        nArray2[6] = 108;
        nArray3[7] = 111;
        nArray2[8] = 114;
        nArray3[9] = 111;
        nArray2[10] = 115;
        nArray3[11] = 46;
        nArray2[12] = 109;
        nArray3[13] = 99;
        nArray3[14] = 115;
        c = nArray;
        int[] nArray4 = nArray = new int[45];
        int[] nArray5 = nArray;
        nArray4[0] = 99;
        nArray5[1] = 111;
        nArray4[2] = 109;
        nArray5[3] = 46;
        nArray4[4] = 99;
        nArray5[5] = 111;
        nArray4[6] = 108;
        nArray5[7] = 111;
        nArray4[8] = 114;
        nArray5[9] = 111;
        nArray4[10] = 115;
        nArray5[11] = 46;
        nArray4[12] = 109;
        nArray5[13] = 99;
        nArray4[14] = 115;
        nArray5[15] = 115;
        nArray4[16] = 100;
        nArray5[17] = 107;
        nArray4[18] = 46;
        nArray5[19] = 97;
        nArray4[20] = 99;
        nArray5[21] = 116;
        nArray4[22] = 105;
        nArray5[23] = 111;
        nArray4[24] = 110;
        nArray5[25] = 46;
        nArray4[26] = 82;
        nArray5[27] = 69;
        nArray4[28] = 67;
        nArray5[29] = 69;
        nArray4[30] = 73;
        nArray5[31] = 86;
        nArray4[32] = 69;
        nArray5[33] = 95;
        nArray4[34] = 83;
        nArray5[35] = 68;
        nArray4[36] = 75;
        nArray5[37] = 95;
        nArray4[38] = 77;
        nArray5[39] = 69;
        nArray4[40] = 83;
        nArray5[41] = 83;
        nArray4[42] = 65;
        nArray5[43] = 71;
        nArray5[44] = 69;
        d = nArray;
        w = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private d() {
        Object object;
        this.z = object = new Object();
        object = new ArrayList();
        this.B = object;
        object = new ArrayList();
        this.C = object;
        this.F = null;
        object = d.class;
        synchronized (object) {
            int n10 = w;
            if (n10 <= 0) {
                w = ++n10;
                // MONITOREXIT @DISABLED, blocks:[2, 3] lbl13 : MonitorExitStatement: MONITOREXIT : var1_1
                object = new com.heytap.mcssdk.d.b();
                this.a((com.heytap.mcssdk.d.d)object);
                object = new com.heytap.mcssdk.d.a();
                this.a((com.heytap.mcssdk.d.d)object);
                object = new com.heytap.mcssdk.e.b();
                this.a((com.heytap.mcssdk.e.c)object);
                object = new a();
                this.a((com.heytap.mcssdk.e.c)object);
                return;
            }
            String string2 = "PushService can't create again!";
            RuntimeException runtimeException = new RuntimeException(string2);
            throw runtimeException;
        }
    }

    public /* synthetic */ d(d$1 d$1) {
        this();
    }

    public static /* synthetic */ Context a(d d10) {
        return d10.A;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String a(Context context) {
        Object object = new Intent(e);
        PackageManager packageManager = context.getPackageManager();
        object = packageManager.queryIntentServices((Intent)object, 8192);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 < n11) return null;
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            int n12;
            int n13;
            String string2;
            block11: {
                PackageManager packageManager2;
                string2 = ((ResolveInfo)object.next()).serviceInfo.packageName;
                try {
                    packageManager2 = context.getPackageManager();
                    n13 = 0;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    continue;
                }
                packageManager2 = packageManager2.getApplicationInfo(string2, 0);
                n11 = packageManager2.flags;
                n12 = 1;
                if ((n11 &= n12) == n12) {
                    n11 = n12;
                    break block11;
                }
                n11 = 0;
                packageManager2 = null;
            }
            PackageManager packageManager3 = context.getPackageManager();
            int n14 = packageManager3.getPackageUid(string2, 0);
            PackageManager packageManager4 = context.getPackageManager();
            String string3 = "android";
            int n15 = packageManager4.getPackageUid(string3, 0);
            if (n14 == n15) {
                n13 = n12;
            }
            if (n11 == 0 && n13 == 0) continue;
            return string2;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(int n10, String string2, JSONObject jSONObject) {
        Object object = this.z;
        synchronized (object) {
            Intent intent = this.b(n10, string2, jSONObject);
            string2 = this.A;
            string2.startService(intent);
            return;
        }
    }

    public static void a(Context context, d.i.a.a.c.d d10) {
        com.heytap.mcssdk.f.e.a(context, d10);
    }

    public static void a(Context context, List list) {
        com.heytap.mcssdk.f.e.a(context, list);
    }

    private void a(com.heytap.mcssdk.d.d d10) {
        synchronized (this) {
            if (d10 != null) {
                List list = this.C;
                list.add(d10);
            }
            return;
        }
    }

    private void a(com.heytap.mcssdk.e.c c10) {
        synchronized (this) {
            if (c10 != null) {
                List list = this.B;
                list.add(c10);
            }
            return;
        }
    }

    private Intent b(int n10, String string2, JSONObject jSONObject) {
        Object object;
        Intent intent;
        String string3;
        block18: {
            string3 = k;
            intent = new Intent();
            Object object2 = this.m();
            intent.setAction((String)object2);
            object2 = this.l();
            intent.setPackage((String)object2);
            intent.putExtra(f, n10);
            object = new JSONObject();
            object2 = p;
            Object object3 = this.A;
            Object object4 = object3.getPackageName();
            object3 = com.heytap.mcssdk.f.g.c(object3, (String)object4);
            object.putOpt((String)object2, object3);
            object2 = q;
            object3 = this.A;
            object4 = object3.getPackageName();
            int n11 = com.heytap.mcssdk.f.g.b(object3, (String)object4);
            object3 = n11;
            object.putOpt((String)object2, object3);
            if (jSONObject == null) break block18;
            try {
                object2 = jSONObject.keys();
            }
            catch (Throwable throwable) {
                object = object.toString();
                intent.putExtra(string3, (String)object);
                throw throwable;
            }
            catch (Exception exception) {}
            while (true) {
                n11 = (int)(object2.hasNext() ? 1 : 0);
                if (n11 == 0) break;
                object3 = object2.next();
                object3 = (String)object3;
                object4 = jSONObject.get((String)object3);
                object.putOpt((String)object3, object4);
                continue;
                break;
            }
        }
        object = object.toString();
        intent.putExtra(string3, (String)object);
        intent.putExtra("params", string2);
        object = this.A.getPackageName();
        intent.putExtra(j, (String)object);
        object = this.D;
        intent.putExtra("appKey", (String)object);
        object = this.E;
        intent.putExtra("appSecret", (String)object);
        object = this.F;
        intent.putExtra("registerID", (String)object);
        object = com.heytap.mcssdk.d.s();
        intent.putExtra("sdkVersion", (String)object);
        return intent;
    }

    private void b(int n10, JSONObject jSONObject) {
        this.a(n10, "", jSONObject);
    }

    private static void b(Context context) {
        String string2 = context.getPackageName();
        d.i.a.a.c.d d10 = new d.i.a.a.c.d(string2, "app_start", null);
        com.heytap.mcssdk.d.a(context, d10);
    }

    public static d k() {
        return d$a.a();
    }

    public static String s() {
        return "2.1.0";
    }

    private boolean v() {
        boolean bl2;
        Context context = this.A;
        if (context != null) {
            bl2 = true;
        } else {
            bl2 = false;
            context = null;
        }
        return bl2;
    }

    private boolean w() {
        boolean bl2;
        String string2 = this.F;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    private boolean x() {
        boolean bl2 = this.v();
        bl2 = bl2 && (bl2 = this.w());
        return bl2;
    }

    public d a(Context object, boolean bl2) {
        object = object.getApplicationContext();
        this.A = object;
        object = new com.heytap.mcssdk.b.a();
        Context context = this.A;
        ((com.heytap.mcssdk.b.a)object).a(context);
        com.heytap.mcssdk.f.c.f(bl2);
        return this;
    }

    public String a() {
        return this.F;
    }

    public void a(int n10) {
        this.a(n10, null);
    }

    public void a(int n10, JSONObject object) {
        int n11 = this.x();
        if (n11 != 0) {
            n11 = 12307;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n10);
            stringBuilder.append("");
            String string2 = stringBuilder.toString();
            this.a(n11, string2, (JSONObject)object);
        } else {
            String string3 = "mcssdk---";
            object = "please call the register first!";
            com.heytap.mcssdk.f.c.e(string3, (String)object);
        }
    }

    public void a(Context context, String string2, String string3, d.i.a.a.b.a a10) {
        this.a(context, string2, string3, null, a10);
    }

    public void a(Context context, String string2, String string3, JSONObject jSONObject, d.i.a.a.b.a a10) {
        int n10 = -2;
        if (context == null) {
            if (a10 != null) {
                a10.onRegister(n10, null);
            }
            return;
        }
        String string4 = context.getPackageName();
        String string5 = a;
        d.i.a.a.c.d d10 = new d.i.a.a.c.d(string4, string5, null);
        com.heytap.mcssdk.d.a(context, d10);
        boolean bl2 = this.n();
        if (!bl2) {
            if (a10 != null) {
                a10.onRegister(n10, null);
            }
            return;
        }
        this.D = string2;
        this.E = string3;
        this.A = context = context.getApplicationContext();
        this.G = a10;
        this.b(12289, jSONObject);
    }

    public void a(d.i.a.a.b.a a10) {
        this.G = a10;
    }

    public void a(d.i.a.a.c.b object, String charSequence, int n10) {
        Intent intent = new Intent();
        String string2 = this.m();
        intent.setAction(string2);
        string2 = this.l();
        intent.setPackage(string2);
        string2 = f;
        int n11 = 12291;
        intent.putExtra(string2, n11);
        string2 = i;
        String string3 = ((d.i.a.a.c.b)object).n();
        intent.putExtra(string2, string3);
        string2 = j;
        string3 = ((d.i.a.a.c.b)object).i();
        intent.putExtra(string2, string3);
        string2 = m;
        object = ((d.i.a.a.c.b)object).l();
        intent.putExtra(string2, (String)object);
        object = l;
        intent.putExtra((String)object, n10);
        object = h;
        intent.putExtra((String)object, (String)charSequence);
        object = this.A;
        try {
            object.startService(intent);
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            String string4 = "statisticMessage--Exception";
            ((StringBuilder)charSequence).append(string4);
            String string5 = exception.getMessage();
            ((StringBuilder)charSequence).append(string5);
            string5 = ((StringBuilder)charSequence).toString();
            com.heytap.mcssdk.f.c.e(string5);
        }
    }

    public void a(String string2) {
        this.F = string2;
    }

    public void a(String string2, String string3) {
        this.D = string2;
        this.E = string3;
    }

    public void a(List list, int n10, int n11, int n12, int n13) {
        this.a(list, n10, n11, n12, n13, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(List object, int n10, int n11, int n12, int n13, JSONObject jSONObject) {
        int n14 = this.x();
        if (n14 == 0) {
            object = this.q();
            if (object == null) return;
            object = this.q();
            n10 = -2;
            String string2 = "please call the register first!";
            object.onSetPushTime(n10, string2);
            return;
        }
        if (object != null && (n14 = object.size()) > 0 && n10 >= 0 && n11 >= 0 && n12 >= n10 && n12 <= (n14 = 23) && n13 >= n11 && n13 <= (n14 = 59)) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String string3 = "weekDays";
                object = com.heytap.mcssdk.c.a.a((List)object);
                jSONObject2.put(string3, object);
                object = "startHour";
                jSONObject2.put((String)object, n10);
                object = "startMin";
                jSONObject2.put((String)object, n11);
                object = "endHour";
                jSONObject2.put((String)object, n12);
                object = "endMin";
                jSONObject2.put((String)object, n13);
                int n15 = 12298;
                String string4 = jSONObject2.toString();
                this.a(n15, string4, jSONObject);
                return;
            }
            catch (JSONException jSONException) {
                object = jSONException.getLocalizedMessage();
                String string5 = "mcssdk---";
                com.heytap.mcssdk.f.c.e(string5, (String)object);
                return;
            }
        }
        object = new IllegalArgumentException("params are not all right,please check params");
        throw object;
    }

    public void a(JSONObject object) {
        int n10 = this.v();
        if (n10 != 0) {
            n10 = 12289;
            this.b(n10, (JSONObject)object);
        } else {
            object = this.q();
            if (object != null) {
                object = this.q();
                n10 = -2;
                object.onRegister(n10, null);
            }
        }
    }

    public void b() {
        this.a((JSONObject)null);
    }

    public void b(int n10) {
        Intent intent = this.b(n10, "", null);
        Context context = this.A;
        d$1 d$1 = new d$1(this, intent);
        context.bindService(intent, (ServiceConnection)d$1, 1);
    }

    public void b(Context context, String string2, String string3, JSONObject jSONObject, d.i.a.a.b.a a10) {
        this.D = string2;
        this.E = string3;
        this.A = context = context.getApplicationContext();
        this.G = a10;
        this.b(jSONObject);
    }

    public void b(JSONObject object) {
        int n10 = this.v();
        if (n10 != 0) {
            n10 = 12290;
            this.b(n10, (JSONObject)object);
        } else {
            object = this.q();
            if (object != null) {
                object = this.q();
                n10 = -2;
                object.onUnRegister(n10);
            }
        }
    }

    public void c() {
        this.b(null);
    }

    public void c(JSONObject object) {
        int n10 = this.x();
        if (n10 != 0) {
            n10 = 12309;
            this.b(n10, (JSONObject)object);
        } else {
            object = this.q();
            if (object != null) {
                object = this.q();
                n10 = -2;
                object.onGetNotificationStatus(n10, 0);
            }
        }
    }

    public void d() {
        this.c(null);
    }

    public void d(JSONObject object) {
        int n10 = this.x();
        if (n10 != 0) {
            n10 = 12308;
            this.b(n10, (JSONObject)object);
        } else {
            object = "mcssdk---";
            String string2 = "please call the register first!";
            com.heytap.mcssdk.f.c.e((String)object, string2);
        }
    }

    public void e() {
        this.d(null);
    }

    public void e(JSONObject object) {
        int n10 = this.v();
        if (n10 != 0) {
            n10 = 12311;
            this.b(n10, (JSONObject)object);
        } else {
            object = "mcssdk---";
            String string2 = "please call the register first!";
            com.heytap.mcssdk.f.c.e((String)object, string2);
        }
    }

    public void f() {
        this.e(null);
    }

    public void f(JSONObject object) {
        int n10 = this.x();
        if (n10 != 0) {
            n10 = 12310;
            this.b(n10, (JSONObject)object);
        } else {
            object = "mcssdk---";
            String string2 = "please call the register first!";
            com.heytap.mcssdk.f.c.e((String)object, string2);
        }
    }

    public void g() {
        this.f(null);
    }

    public void g(JSONObject object) {
        int n10 = this.x();
        if (n10 != 0) {
            n10 = 12299;
            this.b(n10, (JSONObject)object);
        } else {
            object = "mcssdk---";
            String string2 = "please call the register first!";
            com.heytap.mcssdk.f.c.e((String)object, string2);
        }
    }

    public void h() {
        this.g(null);
    }

    public void h(JSONObject object) {
        int n10 = this.x();
        if (n10 != 0) {
            n10 = 12300;
            this.b(n10, (JSONObject)object);
        } else {
            object = "mcssdk---";
            String string2 = "please call the register first!";
            com.heytap.mcssdk.f.c.e((String)object, string2);
        }
    }

    public void i() {
        this.h(null);
    }

    public void j() {
        int n10 = this.v();
        if (n10 != 0) {
            n10 = 12313;
            this.b(n10);
        } else {
            String string2 = "mcssdk---";
            String string3 = "please call the register first!";
            com.heytap.mcssdk.f.c.e(string2, string3);
        }
    }

    public String l() {
        String string2 = x;
        if (string2 == null) {
            boolean bl2;
            string2 = this.A;
            if ((string2 = this.a((Context)string2)) == null) {
                x = com.heytap.mcssdk.f.g.a(c);
                bl2 = false;
                string2 = null;
            } else {
                x = string2;
                bl2 = true;
            }
            y = bl2;
        }
        return x;
    }

    public String m() {
        boolean bl2;
        String string2 = x;
        if (string2 == null) {
            string2 = this.A;
            this.a((Context)string2);
        }
        if (bl2 = y) {
            return e;
        }
        return com.heytap.mcssdk.f.g.a(d);
    }

    public boolean n() {
        String string2;
        boolean bl2;
        int n10;
        Context context = this.A;
        String string3 = this.l();
        int n11 = com.heytap.mcssdk.f.g.a(context, string3);
        if (n11 != 0 && (n11 = com.heytap.mcssdk.f.g.b(context = this.A, string3)) >= (n10 = 1019) && (bl2 = com.heytap.mcssdk.f.g.a(context = this.A, string3, string2 = o))) {
            bl2 = true;
        } else {
            bl2 = false;
            string3 = null;
        }
        return bl2;
    }

    public List o() {
        return this.C;
    }

    public List p() {
        return this.B;
    }

    public d.i.a.a.b.a q() {
        return this.G;
    }

    public void r() {
        int n10 = this.x();
        if (n10 != 0) {
            n10 = 12306;
            boolean bl2 = false;
            this.b(n10, null);
        } else {
            d.i.a.a.b.a a10 = this.q();
            if (a10 != null) {
                a10 = this.q();
                int n11 = -2;
                a10.onGetPushStatus(n11, 0);
            }
        }
    }

    public String t() {
        boolean bl2 = this.v();
        if (bl2) {
            Context context = this.A;
            String string2 = this.l();
            return com.heytap.mcssdk.f.g.c(context, string2);
        }
        return "";
    }

    public int u() {
        boolean bl2 = this.v();
        if (bl2) {
            Context context = this.A;
            String string2 = this.l();
            return com.heytap.mcssdk.f.g.b(context, string2);
        }
        return 0;
    }
}

