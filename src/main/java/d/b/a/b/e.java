/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ServiceInfo
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.os.ResultReceiver
 *  android.text.TextUtils
 *  org.json.JSONException
 */
package d.b.a.b;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.android.billingclient.api.ProxyBillingActivity;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.Purchase$b;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetails$a;
import com.android.billingclient.api.zzah;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzb;
import d.b.a.b.a0;
import d.b.a.b.a1;
import d.b.a.b.b;
import d.b.a.b.b1;
import d.b.a.b.c;
import d.b.a.b.c0;
import d.b.a.b.c1;
import d.b.a.b.d;
import d.b.a.b.e$a;
import d.b.a.b.e$b;
import d.b.a.b.f;
import d.b.a.b.g;
import d.b.a.b.g0;
import d.b.a.b.h;
import d.b.a.b.h$a;
import d.b.a.b.i;
import d.b.a.b.j;
import d.b.a.b.j0;
import d.b.a.b.k;
import d.b.a.b.l;
import d.b.a.b.l0;
import d.b.a.b.m;
import d.b.a.b.n;
import d.b.a.b.n0;
import d.b.a.b.o;
import d.b.a.b.o0;
import d.b.a.b.p;
import d.b.a.b.q0;
import d.b.a.b.r;
import d.b.a.b.r0;
import d.b.a.b.s;
import d.b.a.b.s0;
import d.b.a.b.t;
import d.b.a.b.u;
import d.b.a.b.v0;
import d.b.a.b.w0;
import d.b.a.b.x0;
import d.b.a.b.y0;
import d.b.a.b.z0;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;

public class e
extends d {
    private int a;
    private final String b;
    private final Handler c;
    private g0 d;
    private Context e;
    private Context f;
    private zza g;
    private e$a h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private ExecutorService r;
    private String s;
    private final ResultReceiver t;

    private e(Activity activity, boolean bl2, String string2) {
        Context context = activity.getApplicationContext();
        zzah zzah2 = new zzah();
        this(context, bl2, zzah2, string2, null);
    }

    private e(Context context, boolean bl2, n n10, String string2, String string3) {
        Handler handler;
        this.a = 0;
        Object object = Looper.getMainLooper();
        this.c = handler = new Handler(object);
        super(this, handler);
        this.t = object;
        this.s = string3;
        this.b = string2;
        this.m(context, n10, bl2);
    }

    private e(String string2) {
        Handler handler;
        this.a = 0;
        Object object = Looper.getMainLooper();
        this.c = handler = new Handler(object);
        super(this, handler);
        this.t = object;
        this.b = string2;
    }

    public e(String string2, boolean bl2, Context context, n n10) {
        String string3 = d.b.a.b.e.x();
        this(context, bl2, n10, string3, null);
    }

    public static /* synthetic */ void A(e e10, i i10, j j10) {
        e10.C(i10, j10);
    }

    public static /* synthetic */ void B(e e10, Runnable runnable) {
        e10.D(runnable);
    }

    private final void C(i object, j j10) {
        Object object2;
        int n10;
        Object object3;
        Object object4;
        String string2;
        block33: {
            Object object5;
            block32: {
                block31: {
                    block30: {
                        block29: {
                            object5 = "BillingClient";
                            string2 = ((i)object).a();
                            object4 = "Consuming purchase with token: ";
                            try {
                                object3 = String.valueOf(string2);
                            }
                            catch (Exception exception) {
                                object5 = new c1(this, exception, j10, string2);
                                this.D((Runnable)object5);
                                return;
                            }
                            n10 = ((String)object3).length();
                            if (n10 == 0) break block29;
                            object4 = ((String)object4).concat((String)object3);
                            break block30;
                        }
                        object4 = object3 = new String((String)object4);
                    }
                    zzb.zza((String)object5, (String)object4);
                    int n11 = this.m;
                    if (n11 == 0) break block31;
                    object4 = this.g;
                    int n12 = 9;
                    Object object6 = this.f;
                    object6 = object6.getPackageName();
                    boolean bl2 = this.m;
                    object2 = this.b;
                    object = zzb.zza((i)object, bl2, (String)object2);
                    object = object4.zzc(n12, (String)object6, string2, (Bundle)object);
                    object4 = "RESPONSE_CODE";
                    n11 = object.getInt((String)object4);
                    object = zzb.zzb((Bundle)object, (String)object5);
                    n10 = n11;
                    break block32;
                }
                object = this.g;
                int n13 = 3;
                object4 = this.f;
                object4 = object4.getPackageName();
                int n14 = object.zzb(n13, (String)object4, string2);
                object5 = "";
                n10 = n14;
                object = object5;
            }
            object5 = d.b.a.b.h.c();
            object5 = ((h$a)object5).c(n10);
            object = ((h$a)object5).b((String)object);
            object2 = ((h$a)object).a();
            if (n10 != 0) break block33;
            object = new a1(this, j10, (h)object2, string2);
            this.D((Runnable)object);
            return;
        }
        object4 = object;
        object3 = this;
        object = new z0(this, n10, j10, (h)object2, string2);
        this.D((Runnable)object);
    }

    private final void D(Runnable runnable) {
        boolean bl2 = Thread.interrupted();
        if (bl2) {
            return;
        }
        this.c.post(runnable);
    }

    public static /* synthetic */ boolean E(e e10, boolean bl2) {
        e10.j = bl2;
        return bl2;
    }

    public static /* synthetic */ Context F(e e10) {
        return e10.f;
    }

    private static Bundle G() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("vr", true);
        return bundle;
    }

    public static /* synthetic */ e$b H(e e10, String string2) {
        return e10.r(string2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final h I(String object) {
        TimeUnit timeUnit;
        x0 x02 = new x0(this, (String)object);
        long l10 = 5000L;
        int n10 = 0;
        object = this.z(x02, l10, null);
        try {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        catch (Exception exception) {
            zzb.zzb("BillingClient", "Exception while checking if billing is supported; try to reconnect");
            return a0.q;
        }
        object = object.get(l10, timeUnit);
        object = (Integer)object;
        n10 = (Integer)object;
        if (n10 != 0) return a0.i;
        return a0.p;
    }

    public static /* synthetic */ boolean J(e e10, boolean bl2) {
        e10.i = bl2;
        return bl2;
    }

    private final h K() {
        int n10;
        int n11 = this.a;
        if (n11 != 0 && n11 != (n10 = 3)) {
            return a0.l;
        }
        return a0.q;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Purchase$b L(String object) {
        boolean bl2;
        Object object2 = String.valueOf(object);
        int n10 = ((String)object2).length();
        CharSequence charSequence = "Querying owned items, item type: ";
        object2 = n10 != 0 ? ((String)charSequence).concat((String)object2) : new String((String)charSequence);
        Object object3 = "BillingClient";
        zzb.zza((String)object3, (String)object2);
        object2 = new ArrayList();
        boolean bl3 = this.m;
        boolean bl4 = this.q;
        Object object4 = this.b;
        charSequence = zzb.zza(bl3, bl4, (String)object4);
        bl4 = false;
        int n11 = 0;
        String string2 = null;
        do {
            Object object5;
            CharSequence charSequence2;
            Object object6;
            int n12;
            Object object7;
            try {
                bl2 = this.m;
                if (bl2) {
                    object7 = this.g;
                    n12 = 9;
                    object4 = this.f;
                    object6 = object4.getPackageName();
                    charSequence2 = charSequence;
                    object4 = object7.zzc(n12, (String)object6, (String)object, string2, (Bundle)charSequence);
                } else {
                    object4 = this.g;
                    int n13 = 3;
                    object5 = this.f;
                    object5 = object5.getPackageName();
                    object4 = object4.zza(n13, (String)object5, (String)object, string2);
                }
            }
            catch (Exception exception) {
                object = String.valueOf(exception);
                int n16 = String.valueOf(object).length() + 57;
                charSequence = new StringBuilder(n16);
                ((StringBuilder)charSequence).append("Got exception trying to get purchases: ");
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append("; try to reconnect");
                object = ((StringBuilder)charSequence).toString();
                zzb.zzb((String)object3, (String)object);
                object2 = a0.q;
                return new Purchase$b((h)object2, null);
            }
            object7 = c0.a((Bundle)object4, (String)object3, "getPurchase()");
            object5 = a0.p;
            if (object7 != object5) {
                return new Purchase$b((h)object7, null);
            }
            object7 = object4.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            object5 = object4.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            object6 = object4.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            for (int i10 = 0; i10 < (n11 = ((ArrayList)object5).size()); ++i10) {
                string2 = (String)((ArrayList)object5).get(i10);
                charSequence2 = (String)((ArrayList)object6).get(i10);
                Object object8 = (String)((ArrayList)object7).get(i10);
                String string3 = "Sku is owned: ";
                int n14 = ((String)(object8 = String.valueOf(object8))).length();
                object8 = n14 != 0 ? string3.concat((String)object8) : new String(string3);
                zzb.zza((String)object3, (String)object8);
                try {
                    object8 = new Purchase(string2, (String)charSequence2);
                    string2 = ((Purchase)object8).h();
                }
                catch (JSONException jSONException) {
                    object = String.valueOf((Object)jSONException);
                    int n15 = String.valueOf(object).length() + 48;
                    charSequence = new StringBuilder(n15);
                    ((StringBuilder)charSequence).append("Got an exception trying to decode the purchase: ");
                    ((StringBuilder)charSequence).append((String)object);
                    object = ((StringBuilder)charSequence).toString();
                    zzb.zzb((String)object3, (String)object);
                    object2 = a0.l;
                    return new Purchase$b((h)object2, null);
                }
                n11 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
                if (n11 != 0) {
                    string2 = "BUG: empty/null token!";
                    zzb.zzb((String)object3, string2);
                }
                object2.add(object8);
            }
            string2 = object4.getString("INAPP_CONTINUATION_TOKEN");
            object4 = "Continuation token: ";
            object7 = String.valueOf(string2);
            n12 = ((String)object7).length();
            object4 = n12 != 0 ? ((String)object4).concat((String)object7) : (object7 = new String((String)object4));
            zzb.zza((String)object3, (String)object4);
        } while (!(bl2 = TextUtils.isEmpty((CharSequence)string2)));
        object3 = a0.p;
        return new Purchase$b((h)object3, (List)object2);
    }

    public static /* synthetic */ zza M(e e10) {
        return e10.g;
    }

    public static /* synthetic */ boolean N(e e10, boolean bl2) {
        e10.p = bl2;
        return bl2;
    }

    public static /* synthetic */ String O(e e10) {
        return e10.b;
    }

    public static /* synthetic */ boolean P(e e10, boolean bl2) {
        e10.o = bl2;
        return bl2;
    }

    public static /* synthetic */ Bundle Q(e e10) {
        return d.b.a.b.e.G();
    }

    public static /* synthetic */ boolean R(e e10, boolean bl2) {
        e10.n = bl2;
        return bl2;
    }

    public static /* synthetic */ h S(e e10) {
        return e10.K();
    }

    public static /* synthetic */ boolean T(e e10, boolean bl2) {
        e10.m = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean U(e e10, boolean bl2) {
        e10.l = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean V(e e10, boolean bl2) {
        e10.k = bl2;
        return bl2;
    }

    private void m(Context context, n n10, boolean bl2) {
        g0 g02;
        Context context2;
        this.f = context2 = context.getApplicationContext();
        this.d = g02 = new g0(context2, n10);
        this.e = context;
        this.q = bl2;
    }

    private int n(Activity activity, g g10) {
        return ((d)this).f(activity, g10).b();
    }

    private void o(Activity activity, l l10, long l11) {
        zzah zzah2 = new zzah(l11);
        ((d)this).g(activity, l10, zzah2);
    }

    private void p(long l10) {
        zzah zzah2 = new zzah(l10);
        ((d)this).l(zzah2);
    }

    public static /* synthetic */ int q(e e10, int n10) {
        e10.a = n10;
        return n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final e$b r(String object) {
        boolean bl2;
        Object object2 = String.valueOf(object);
        int n10 = ((String)object2).length();
        CharSequence charSequence = "Querying purchase history, item type: ";
        object2 = n10 != 0 ? ((String)charSequence).concat((String)object2) : new String((String)charSequence);
        Object object3 = "BillingClient";
        zzb.zza((String)object3, (String)object2);
        object2 = new ArrayList();
        boolean bl3 = this.m;
        boolean bl4 = this.q;
        Object object4 = this.b;
        charSequence = zzb.zza(bl3, bl4, (String)object4);
        bl4 = false;
        int n11 = 0;
        String string2 = null;
        do {
            CharSequence charSequence2;
            Object object6;
            int n12;
            Object object5;
            if (!(bl2 = this.k)) {
                zzb.zzb((String)object3, "getPurchaseHistory is not supported on current device");
                object2 = a0.j;
                return new e$b((h)object2, null);
            }
            try {
                object5 = this.g;
                n12 = 6;
                object4 = this.f;
                object6 = object4.getPackageName();
                charSequence2 = charSequence;
                object4 = object5.zza(n12, (String)object6, (String)object, string2, (Bundle)charSequence);
            }
            catch (RemoteException remoteException) {
                object = String.valueOf((Object)remoteException);
                int n15 = String.valueOf(object).length() + 64;
                charSequence = new StringBuilder(n15);
                ((StringBuilder)charSequence).append("Got exception trying to get purchase history: ");
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append("; try to reconnect");
                object = ((StringBuilder)charSequence).toString();
                zzb.zzb((String)object3, (String)object);
                object2 = a0.q;
                return new e$b((h)object2, null);
            }
            object5 = c0.a((Bundle)object4, (String)object3, "getPurchaseHistory()");
            Object object7 = a0.p;
            if (object5 != object7) {
                return new e$b((h)object5, null);
            }
            object5 = object4.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            object7 = object4.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            object6 = object4.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            for (int i10 = 0; i10 < (n11 = ((ArrayList)object7).size()); ++i10) {
                string2 = (String)((ArrayList)object7).get(i10);
                charSequence2 = (String)((ArrayList)object6).get(i10);
                Object object8 = (String)((ArrayList)object5).get(i10);
                String string3 = "Purchase record found for sku : ";
                int n13 = ((String)(object8 = String.valueOf(object8))).length();
                object8 = n13 != 0 ? string3.concat((String)object8) : new String(string3);
                zzb.zza((String)object3, (String)object8);
                try {
                    object8 = new PurchaseHistoryRecord(string2, (String)charSequence2);
                    string2 = ((PurchaseHistoryRecord)object8).d();
                }
                catch (JSONException jSONException) {
                    object = String.valueOf((Object)jSONException);
                    int n14 = String.valueOf(object).length() + 48;
                    charSequence = new StringBuilder(n14);
                    ((StringBuilder)charSequence).append("Got an exception trying to decode the purchase: ");
                    ((StringBuilder)charSequence).append((String)object);
                    object = ((StringBuilder)charSequence).toString();
                    zzb.zzb((String)object3, (String)object);
                    object2 = a0.l;
                    return new e$b((h)object2, null);
                }
                n11 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
                if (n11 != 0) {
                    string2 = "BUG: empty/null token!";
                    zzb.zzb((String)object3, string2);
                }
                object2.add(object8);
            }
            string2 = object4.getString("INAPP_CONTINUATION_TOKEN");
            object4 = "Continuation token: ";
            object5 = String.valueOf(string2);
            n12 = ((String)object5).length();
            object4 = n12 != 0 ? ((String)object4).concat((String)object5) : (object5 = new String((String)object4));
            zzb.zza((String)object3, (String)object4);
        } while (!(bl2 = TextUtils.isEmpty((CharSequence)string2)));
        object3 = a0.p;
        return new e$b((h)object3, (List)object2);
    }

    private final h s(h h10) {
        this.d.c().d(h10, null);
        return h10;
    }

    public static /* synthetic */ Purchase$b t(e e10, String string2) {
        return e10.L(string2);
    }

    public static /* synthetic */ g0 v(e e10) {
        return e10.d;
    }

    public static /* synthetic */ zza w(e e10, zza zza2) {
        e10.g = zza2;
        return zza2;
    }

    private static String x() {
        String string2;
        Object object = "com.android.billingclient.ktx.BuildConfig";
        try {
            object = Class.forName((String)object);
            string2 = "VERSION_NAME";
        }
        catch (Exception exception) {
            return "3.0.0";
        }
        object = ((Class)object).getField(string2);
        string2 = null;
        object = ((Field)object).get(null);
        return (String)object;
    }

    public static /* synthetic */ Future y(e e10, Callable callable, long l10, Runnable runnable) {
        return e10.z(callable, 30000L, runnable);
    }

    private final Future z(Callable object, long l10, Runnable runnable) {
        double d10 = l10;
        double d11 = 0.95;
        l10 = (long)(d10 *= d11);
        ExecutorService executorService = this.r;
        if (executorService == null) {
            int n10 = zzb.zza;
            this.r = executorService = Executors.newFixedThreadPool(n10);
        }
        try {
            executorService = this.r;
        }
        catch (Exception exception) {
            object = String.valueOf(exception);
            int n11 = String.valueOf(object).length() + 28;
            StringBuilder stringBuilder = new StringBuilder(n11);
            stringBuilder.append("Async task throws exception ");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            zzb.zzb("BillingClient", (String)object);
            return null;
        }
        object = executorService.submit(object);
        executorService = this.c;
        v0 v02 = new v0(this, (Future)object, runnable);
        executorService.postDelayed(v02, l10);
        return object;
    }

    public void a(b object, c c10) {
        boolean bl2 = ((d)this).e();
        if (!bl2) {
            object = a0.q;
            c10.e((h)object);
            return;
        }
        Object object2 = ((b)object).a();
        bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (bl2) {
            zzb.zzb("BillingClient", "Please provide a valid purchase token.");
            object = a0.k;
            c10.e((h)object);
            return;
        }
        bl2 = this.m;
        if (!bl2) {
            object = a0.b;
            c10.e((h)object);
            return;
        }
        object2 = new r0(this, (b)object, c10);
        long l10 = 30000L;
        object = new w0(this, c10);
        if ((object = this.z((Callable)object2, l10, (Runnable)object)) == null) {
            object = this.K();
            c10.e((h)object);
        }
    }

    public void b(i object, j j10) {
        boolean bl2 = ((d)this).e();
        if (!bl2) {
            h h10 = a0.q;
            object = ((i)object).a();
            j10.h(h10, (String)object);
            return;
        }
        Object object2 = new o0(this, (i)object, j10);
        long l10 = 30000L;
        n0 n02 = new n0(this, j10, (i)object);
        if ((object2 = this.z((Callable)object2, l10, n02)) == null) {
            object2 = this.K();
            object = ((i)object).a();
            j10.h((h)object2, (String)object);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        Throwable throwable2222222;
        String string2 = "BillingClient";
        int n10 = 3;
        Object object = this.d;
        ((g0)object).d();
        object = this.h;
        if (object != null) {
            ((e$a)object).b();
        }
        object = this.h;
        boolean bl2 = false;
        Object var5_9 = null;
        if (object != null && (object = this.g) != null) {
            object = "Unbinding from service.";
            zzb.zza(string2, (String)object);
            object = this.f;
            e$a e$a = this.h;
            object.unbindService((ServiceConnection)e$a);
            this.h = null;
        }
        this.g = null;
        object = this.r;
        if (object != null) {
            object.shutdownNow();
            this.r = null;
        }
        this.a = n10;
        return;
        {
            catch (Throwable throwable2222222) {
            }
            catch (Exception exception) {}
            {
                String string3 = String.valueOf(exception);
                String string4 = String.valueOf(string3);
                int n11 = string4.length() + 48;
                StringBuilder stringBuilder = new StringBuilder(n11);
                string4 = "There was an exception while ending connection: ";
                stringBuilder.append(string4);
                stringBuilder.append(string3);
                string3 = stringBuilder.toString();
                zzb.zzb(string2, string3);
                this.a = n10;
                return;
            }
        }
        this.a = n10;
        throw throwable2222222;
    }

    /*
     * WARNING - void declaration
     */
    public h d(String string2) {
        void var2_9;
        String string3;
        boolean n10 = ((d)this).e();
        if (!n10) {
            return a0.q;
        }
        string2.hashCode();
        int n11 = -1;
        int n12 = string2.hashCode();
        switch (n12) {
            default: {
                break;
            }
            case 1987365622: {
                String string4 = "subscriptions";
                n12 = (int)(string2.equals(string4) ? 1 : 0);
                if (n12 == 0) break;
                int n13 = 4;
                break;
            }
            case 1219490065: {
                String string5 = "subscriptionsOnVr";
                n12 = (int)(string2.equals(string5) ? 1 : 0);
                if (n12 == 0) break;
                int n14 = 3;
                break;
            }
            case 292218239: {
                String string6 = "inAppItemsOnVr";
                n12 = (int)(string2.equals(string6) ? 1 : 0);
                if (n12 == 0) break;
                int n15 = 2;
                break;
            }
            case 207616302: {
                String string7 = "priceChangeConfirmation";
                n12 = (int)(string2.equals(string7) ? 1 : 0);
                if (n12 == 0) break;
                boolean bl2 = true;
                break;
            }
            case -422092961: {
                String string8 = "subscriptionsUpdate";
                n12 = (int)(string2.equals(string8) ? 1 : 0);
                if (n12 == 0) break;
                boolean bl3 = false;
                string3 = null;
            }
        }
        switch (var2_9) {
            default: {
                string3 = "Unsupported feature: ";
                string2 = String.valueOf(string2);
                n12 = string2.length();
                string2 = n12 != 0 ? string3.concat(string2) : new String(string3);
                zzb.zzb("BillingClient", string2);
                return a0.u;
            }
            case 4: {
                boolean bl4 = this.i;
                if (bl4) {
                    return a0.p;
                }
                return a0.i;
            }
            case 3: {
                return this.I("subs");
            }
            case 2: {
                return this.I("inapp");
            }
            case 1: {
                boolean bl5 = this.l;
                if (bl5) {
                    return a0.p;
                }
                return a0.i;
            }
            case 0: 
        }
        boolean bl6 = this.j;
        if (bl6) {
            return a0.p;
        }
        return a0.i;
    }

    public boolean e() {
        Object object;
        int n10 = this.a;
        int n11 = 2;
        return n10 == n11 && (object = this.g) != null && (object = this.h) != null;
    }

    /*
     * WARNING - void declaration
     */
    public h f(Activity activity, g g10) {
        String string2;
        String string3;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        String string4;
        String string5;
        Activity activity2;
        e e10;
        block42: {
            long l10;
            Object object5;
            CharSequence charSequence;
            int n10;
            void var10_22;
            boolean bl2;
            void var15_42;
            boolean bl3;
            e10 = this;
            activity2 = activity;
            g g11 = g10;
            string5 = "BUY_INTENT";
            string4 = "; try to reconnect";
            boolean n102 = ((d)this).e();
            if (!n102) {
                h h10 = a0.q;
                return this.s(h10);
            }
            object4 = g10.k();
            boolean bl4 = false;
            object3 = null;
            object2 = ((ArrayList)object4).get(0);
            object = object2;
            object = (SkuDetails)object2;
            String string6 = ((SkuDetails)object).q();
            object2 = "subs";
            boolean bl5 = string6.equals(object2);
            string3 = "BillingClient";
            if (bl5 && !(bl3 = this.i)) {
                zzb.zzb(string3, "Current client doesn't support subscriptions.");
                object4 = a0.s;
                return this.s((h)object4);
            }
            object2 = g10.a();
            int n11 = 1;
            if (object2 != null) {
                int n12 = n11;
            } else {
                boolean bl6 = false;
                object2 = null;
            }
            if (var15_42 != false && !(bl2 = e10.j)) {
                zzb.zzb(string3, "Current client doesn't support subscriptions update.");
                object4 = a0.t;
                return e10.s((h)object4);
            }
            bl2 = g10.q();
            if (bl2 && !(bl2 = e10.k)) {
                zzb.zzb(string3, "Current client doesn't support extra params for buy intent.");
                object4 = a0.h;
                return e10.s((h)object4);
            }
            string2 = "";
            while (++var10_22 < (n10 = ((ArrayList)object4).size())) {
                string2 = String.valueOf(string2);
                charSequence = String.valueOf(((ArrayList)object4).get((int)var10_22));
                object5 = String.valueOf(string2);
                int n13 = ((String)object5).length();
                int n14 = String.valueOf(charSequence).length();
                StringBuilder stringBuilder = new StringBuilder(n13 += n14);
                stringBuilder.append(string2);
                stringBuilder.append((String)charSequence);
                string2 = stringBuilder.toString();
                n10 = ((ArrayList)object4).size() - n11;
                if (var10_22 >= n10) continue;
                string2 = String.valueOf(string2);
                charSequence = ", ";
                string2 = string2.concat((String)charSequence);
            }
            int n15 = String.valueOf(string2).length() + 41;
            n10 = String.valueOf(string6).length();
            int n16 = n15 + n10;
            charSequence = new StringBuilder(n16);
            ((StringBuilder)charSequence).append("Constructing buy intent for ");
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(", item type: ");
            ((StringBuilder)charSequence).append(string6);
            object3 = ((StringBuilder)charSequence).toString();
            zzb.zza(string3, (String)object3);
            boolean bl7 = e10.k;
            if (bl7) {
                CharSequence charSequence2;
                void var8_12;
                int n17;
                boolean bl8;
                boolean bl9;
                boolean bl10 = e10.m;
                boolean bl11 = e10.q;
                charSequence = e10.b;
                charSequence = zzb.zza(g11, bl10, bl11, (String)charSequence);
                object3 = ((SkuDetails)object).s();
                boolean bl12 = ((String)object3).isEmpty();
                if (!bl12) {
                    object3 = ((SkuDetails)object).s();
                    object2 = "skuDetailsToken";
                    charSequence.putString(object2, (String)object3);
                }
                if (!(bl9 = TextUtils.isEmpty((CharSequence)(object3 = ((SkuDetails)object).r())))) {
                    object3 = ((SkuDetails)object).r();
                    object2 = "skuPackageName";
                    charSequence.putString(object2, (String)object3);
                }
                if (!(bl8 = TextUtils.isEmpty((CharSequence)(object3 = e10.s)))) {
                    object3 = e10.s;
                    object2 = "accountName";
                    charSequence.putString(object2, (String)object3);
                }
                if ((n17 = ((ArrayList)object4).size()) > n11) {
                    int n18;
                    int n19 = ((ArrayList)object4).size() - n11;
                    object3 = new ArrayList(n19);
                    while (n11 < (n18 = ((ArrayList)object4).size())) {
                        object2 = ((SkuDetails)((ArrayList)object4).get(n11)).n();
                        ((ArrayList)object3).add(object2);
                        ++n11;
                    }
                    object4 = "additionalSkus";
                    charSequence.putStringArrayList((String)object4, (ArrayList)object3);
                }
                int n20 = 6;
                boolean bl13 = e10.m;
                if (bl13) {
                    int n21 = 9;
                } else {
                    boolean bl14 = g10.g();
                    if (bl14) {
                        int n22 = 7;
                    }
                }
                void var15_46 = var8_12;
                object4 = charSequence2;
                object3 = this;
                g11 = g10;
                object5 = charSequence2;
                charSequence2 = charSequence;
                ((s)object4)(this, (int)var8_12, (SkuDetails)object, string6, g10, (Bundle)charSequence);
                boolean bl15 = false;
                long l11 = 5000L;
                object4 = e10.z((Callable)object4, l11, null);
                l10 = l11;
            } else {
                boolean bl16 = false;
                object4 = null;
                l10 = 5000L;
                if (var15_42 != false) {
                    object3 = new r(e10, g11, (SkuDetails)object);
                    object4 = e10.z((Callable)object3, l10, null);
                } else {
                    object3 = new u(e10, (SkuDetails)object, string6);
                    object4 = e10.z((Callable)object3, l10, null);
                }
            }
            object3 = TimeUnit.MILLISECONDS;
            object4 = object4.get(l10, (TimeUnit)((Object)object3));
            object4 = (Bundle)object4;
            int n23 = zzb.zza((Bundle)object4, string3);
            object2 = zzb.zzb((Bundle)object4, string3);
            if (n23 == 0) break block42;
            int n24 = 52;
            object = new StringBuilder(n24);
            object4 = "Unable to buy item, Error response code: ";
            ((StringBuilder)object).append((String)object4);
            ((StringBuilder)object).append(n23);
            object4 = ((StringBuilder)object).toString();
            zzb.zzb(string3, (String)object4);
            object4 = d.b.a.b.h.c();
            object4 = ((h$a)object4).c(n23);
            object4 = ((h$a)object4).b((String)object2);
            object4 = ((h$a)object4).a();
            return e10.s((h)object4);
        }
        object2 = ProxyBillingActivity.class;
        object3 = new Intent((Context)activity2, object2);
        object2 = "result_receiver";
        object = e10.t;
        object3.putExtra(object2, (Parcelable)object);
        object4 = object4.getParcelable(string5);
        object4 = (PendingIntent)object4;
        object3.putExtra(string5, (Parcelable)object4);
        try {
            activity2.startActivity((Intent)object3);
            return a0.p;
        }
        catch (Exception exception) {
            int n25 = String.valueOf(string2).length() + 69;
            object3 = new StringBuilder(n25);
            ((StringBuilder)object3).append("Exception while launching billing flow: ; for sku: ");
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(string4);
            object4 = ((StringBuilder)object3).toString();
            zzb.zzb(string3, (String)object4);
            object4 = a0.q;
            return e10.s((h)object4);
        }
        catch (CancellationException | TimeoutException exception) {
            int n26 = String.valueOf(string2).length() + 68;
            object3 = new StringBuilder(n26);
            ((StringBuilder)object3).append("Time out while launching billing flow: ; for sku: ");
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(string4);
            object4 = ((StringBuilder)object3).toString();
            zzb.zzb(string3, (String)object4);
            object4 = a0.r;
            return e10.s((h)object4);
        }
    }

    public void g(Activity object, l object2, k k10) {
        Object object3;
        CharSequence charSequence = "SUBS_MANAGEMENT_INTENT";
        String string2 = "; try to reconnect";
        boolean bl2 = ((d)this).e();
        if (!bl2) {
            object = a0.q;
            k10.g((h)object);
            return;
        }
        Object object4 = "Please fix the input params. priceChangeFlowParams must contain valid sku.";
        String string3 = "BillingClient";
        if (object2 != null && (object3 = ((l)object2).a()) != null) {
            int n10;
            Object object5;
            Object object6;
            block29: {
                if ((object2 = ((l)object2).a().n()) == null) {
                    zzb.zzb(string3, (String)object4);
                    object = a0.n;
                    k10.g((h)object);
                    return;
                }
                bl2 = this.l;
                if (!bl2) {
                    zzb.zzb(string3, "Current client doesn't support price change confirmation flow.");
                    object = a0.i;
                    k10.g((h)object);
                    return;
                }
                object4 = new Bundle();
                object3 = this.b;
                object4.putString("playBillingLibraryVersion", (String)object3);
                int n11 = 1;
                object6 = "subs_price_change";
                object4.putBoolean((String)object6, n11 != 0);
                object3 = new y0(this, (String)object2, (Bundle)object4);
                bl2 = false;
                long l10 = 5000L;
                object4 = this.z((Callable)object3, l10, null);
                object3 = TimeUnit.MILLISECONDS;
                object4 = object4.get(l10, (TimeUnit)((Object)object3));
                object4 = (Bundle)object4;
                n11 = zzb.zza((Bundle)object4, string3);
                object6 = zzb.zzb((Bundle)object4, string3);
                object5 = d.b.a.b.h.c();
                object5 = ((h$a)object5).c(n11);
                object6 = ((h$a)object5).b((String)object6);
                object6 = ((h$a)object6).a();
                if (n11 == 0) break block29;
                n10 = 68;
                charSequence = new StringBuilder(n10);
                object = "Unable to launch price change flow, error response code: ";
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append(n11);
                object = ((StringBuilder)charSequence).toString();
                zzb.zzb(string3, (String)object);
                k10.g((h)object6);
                return;
            }
            object6 = this.c;
            object3 = new b1(this, (Handler)object6, k10);
            object5 = ProxyBillingActivity.class;
            object6 = new Intent((Context)object, (Class)object5);
            object4 = object4.getParcelable((String)charSequence);
            object4 = (PendingIntent)object4;
            object6.putExtra((String)charSequence, (Parcelable)object4);
            charSequence = "result_receiver";
            object6.putExtra((String)charSequence, (Parcelable)object3);
            try {
                object.startActivity((Intent)object6);
                return;
            }
            catch (Exception exception) {
                n10 = String.valueOf(object2).length() + 78;
                charSequence = new StringBuilder(n10);
                ((StringBuilder)charSequence).append("Exception caught while launching Price Change Flow for sku: ");
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append(string2);
                object = ((StringBuilder)charSequence).toString();
                zzb.zzb(string3, (String)object);
                object = a0.q;
                k10.g((h)object);
                return;
            }
            catch (CancellationException | TimeoutException exception) {
                n10 = String.valueOf(object2).length() + 70;
                charSequence = new StringBuilder(n10);
                ((StringBuilder)charSequence).append("Time out while launching Price Change Flow for sku: ");
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append(string2);
                object = ((StringBuilder)charSequence).toString();
                zzb.zzb(string3, (String)object);
                object = a0.r;
                k10.g((h)object);
                return;
            }
        }
        zzb.zzb(string3, (String)object4);
        object = a0.n;
        k10.g((h)object);
    }

    public void i(String object, m m10) {
        boolean bl2 = ((d)this).e();
        if (!bl2) {
            object = a0.q;
            m10.f((h)object, null);
            return;
        }
        q0 q02 = new q0(this, (String)object, m10);
        long l10 = 30000L;
        object = new s0(this, m10);
        if ((object = this.z(q02, l10, (Runnable)object)) == null) {
            object = this.K();
            m10.f((h)object, null);
        }
    }

    public Purchase$b j(String object) {
        boolean bl2 = ((d)this).e();
        if (!bl2) {
            h h10 = a0.q;
            object = new Purchase$b(h10, null);
            return object;
        }
        bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            zzb.zzb("BillingClient", "Please provide a valid SKU type.");
            h h11 = a0.g;
            object = new Purchase$b(h11, null);
            return object;
        }
        Object object2 = new t(this, (String)object);
        long l10 = 5000L;
        object = this.z((Callable)object2, l10, null);
        object2 = TimeUnit.MILLISECONDS;
        object = object.get(l10, (TimeUnit)((Object)object2));
        try {
            return (Purchase$b)object;
        }
        catch (Exception exception) {
            object2 = a0.l;
            object = new Purchase$b((h)object2, null);
            return object;
        }
        catch (CancellationException | TimeoutException exception) {
            object2 = a0.r;
            object = new Purchase$b((h)object2, null);
            return object;
        }
    }

    public void k(o object, p p10) {
        boolean bl2 = ((d)this).e();
        if (!bl2) {
            object = a0.q;
            p10.c((h)object, null);
            return;
        }
        String string2 = ((o)object).a();
        List list = ((o)object).b();
        String string3 = ((o)object).d();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        Object object2 = "BillingClient";
        if (bl3) {
            zzb.zzb((String)object2, "Please fix the input params. SKU type can't be empty.");
            object = a0.g;
            p10.c((h)object, null);
            return;
        }
        if (list == null) {
            zzb.zzb((String)object2, "Please fix the input params. The list of SKUs can't be empty.");
            object = a0.f;
            p10.c((h)object, null);
            return;
        }
        bl3 = this.p;
        if (!bl3 && string3 != null) {
            zzb.zzb((String)object2, "The user's client is too old to handle skuPackageName from SkuDetails.");
            object = a0.e;
            p10.c((h)object, null);
            return;
        }
        object = new j0(this, string2, list, string3, p10);
        long l10 = 30000L;
        object2 = new l0(this, p10);
        if ((object = this.z((Callable)object, l10, (Runnable)object2)) == null) {
            object = this.K();
            p10.c((h)object, null);
        }
    }

    public void l(f f10) {
        boolean bl2;
        boolean n10 = ((d)this).e();
        String string2 = "BillingClient";
        if (n10) {
            zzb.zza(string2, "Service connection is valid. No need to re-initialize.");
            h h12 = a0.p;
            f10.a(h12);
            return;
        }
        int n11 = this.a;
        int n12 = 1;
        if (n11 == n12) {
            zzb.zzb(string2, "Client is already in the process of connecting to billing service.");
            h object = a0.d;
            f10.a(object);
            return;
        }
        int n13 = 3;
        if (n11 == n13) {
            zzb.zzb(string2, "Client was already closed and can't be reused. Please create another instance.");
            h h10 = a0.q;
            f10.a(h10);
            return;
        }
        this.a = n12;
        this.d.b();
        zzb.zza(string2, "Starting in-app billing setup.");
        n13 = 0;
        Object object = new e$a(this, f10, null);
        this.h = object;
        object = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        Object object2 = "com.android.vending";
        object.setPackage((String)object2);
        Object object3 = this.f.getPackageManager().queryIntentServices((Intent)object, 0);
        if (object3 != null && !(bl2 = object3.isEmpty()) && (object3 = ((ResolveInfo)object3.get((int)0)).serviceInfo) != null) {
            String string3 = ((ServiceInfo)object3).packageName;
            object3 = ((ServiceInfo)object3).name;
            n13 = (int)(((String)object2).equals(string3) ? 1 : 0);
            if (n13 != 0 && object3 != null) {
                object2 = new ComponentName(string3, (String)object3);
                object3 = new Intent((Intent)object);
                object3.setComponent((ComponentName)object2);
                object = this.b;
                object3.putExtra("playBillingLibraryVersion", (String)object);
                object = this.f;
                object2 = this.h;
                boolean bl3 = object.bindService((Intent)object3, (ServiceConnection)object2, n12);
                if (bl3) {
                    zzb.zza(string2, "Service was bonded successfully.");
                    return;
                }
                object = "Connection to Billing service is blocked.";
                zzb.zzb(string2, (String)object);
            } else {
                object = "The device doesn't have valid Play Store.";
                zzb.zzb(string2, (String)object);
            }
        }
        this.a = 0;
        zzb.zza(string2, "Billing service unavailable on device.");
        object = a0.c;
        f10.a((h)object);
    }

    public final SkuDetails$a u(String string2, List list, String string3) {
        e e10 = this;
        Object object = "BillingClient";
        Object object2 = new ArrayList();
        int n10 = list.size();
        int n11 = 0;
        Object object3 = null;
        while (n11 < n10) {
            int n12;
            String string4;
            CharSequence charSequence;
            int n13;
            int n14;
            Object object4;
            Object object5;
            Object object6;
            Object object7;
            ArrayList arrayList;
            int n15;
            block24: {
                n15 = n11 + 20;
                int n16 = n15 > n10 ? n10 : n15;
                object3 = list.subList(n11, n16);
                arrayList = new ArrayList(object3);
                object7 = new Bundle();
                object7.putStringArrayList("ITEM_ID_LIST", arrayList);
                object3 = e10.b;
                object6 = "playBillingLibraryVersion";
                object7.putString((String)object6, (String)object3);
                n11 = 0;
                object3 = null;
                n16 = (int)(e10.n ? 1 : 0);
                if (n16 == 0) break block24;
                object5 = e10.g;
                int n17 = 10;
                object6 = e10.f;
                object4 = object6.getPackageName();
                n16 = (int)(e10.m ? 1 : 0);
                n14 = (int)(e10.p ? 1 : 0);
                n13 = e10.q;
                charSequence = e10.b;
                string4 = string3;
                charSequence = zzb.zza(n16 != 0, n14 != 0, n13 != 0, (String)charSequence, string3);
                object6 = object5.zza(n17, (String)object4, string2, (Bundle)object7, (Bundle)charSequence);
            }
            string4 = string3;
            object6 = e10.g;
            n14 = 3;
            object5 = e10.f;
            object5 = object5.getPackageName();
            try {
                object6 = object6.zza(n14, (String)object5, string2, (Bundle)object7);
            }
            catch (Exception exception) {
                String string5 = "querySkuDetailsAsync got a remote exception (try to reconnect).";
                Object object8 = String.valueOf(exception);
                int n18 = string5.length();
                n15 = String.valueOf(object8).length();
                StringBuilder stringBuilder = new StringBuilder(n18 += n15);
                stringBuilder.append(string5);
                stringBuilder.append((String)object8);
                object8 = stringBuilder.toString();
                zzb.zzb((String)object, (String)object8);
                object8 = new SkuDetails$a(-1, "Service connection is disconnected.", null);
                return object8;
            }
            n14 = 4;
            if (object6 == null) {
                zzb.zzb((String)object, "querySkuDetailsAsync got null sku details list");
                object2 = new SkuDetails$a(n14, "Null sku details list", null);
                return object2;
            }
            object5 = "DETAILS_LIST";
            boolean bl2 = object6.containsKey((String)object5);
            n13 = 6;
            if (!bl2) {
                n10 = zzb.zza((Bundle)object6, (String)object);
                string4 = zzb.zzb((Bundle)object6, (String)object);
                if (n10 != 0) {
                    StringBuilder stringBuilder = new StringBuilder(50);
                    stringBuilder.append("getSkuDetails() failed. Response code: ");
                    stringBuilder.append(n10);
                    object3 = stringBuilder.toString();
                    zzb.zzb((String)object, (String)object3);
                    object = new SkuDetails$a(n10, string4, (List)object2);
                    return object;
                }
                zzb.zzb((String)object, "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                object = new SkuDetails$a(n13, string4, (List)object2);
                return object;
            }
            if ((object6 = object6.getStringArrayList((String)object5)) == null) {
                object2 = "querySkuDetailsAsync got null response list";
                zzb.zzb((String)object, (String)object2);
                object = new SkuDetails$a(n14, (String)object2, null);
                return object;
            }
            arrayList = null;
            for (n14 = 0; n14 < (n12 = ((ArrayList)object6).size()); ++n14) {
                object5 = (String)((ArrayList)object6).get(n14);
                try {
                    object4 = new SkuDetails((String)object5);
                }
                catch (JSONException jSONException) {
                    zzb.zzb((String)object, "Got a JSON exception trying to decode SkuDetails.");
                    object2 = new SkuDetails$a(n13, "Error trying to decode SkuDetails.", null);
                    return object2;
                }
                object5 = String.valueOf(object4);
                int n19 = String.valueOf(object5).length() + 17;
                charSequence = new StringBuilder(n19);
                object7 = "Got sku details: ";
                ((StringBuilder)charSequence).append((String)object7);
                ((StringBuilder)charSequence).append((String)object5);
                object5 = ((StringBuilder)charSequence).toString();
                zzb.zza((String)object, (String)object5);
                object2.add(object4);
            }
            n11 = n15;
        }
        object = new SkuDetails$a(0, "", (List)object2);
        return object;
    }
}

