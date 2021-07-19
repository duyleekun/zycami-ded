/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.net.wifi.ScanResult
 *  android.net.wifi.WifiInfo
 *  android.net.wifi.WifiManager
 *  android.os.Build$VERSION
 *  android.os.Handler
 */
package com.baidu.location.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import com.baidu.location.b.b;
import com.baidu.location.f;
import com.baidu.location.f.h;
import com.baidu.location.f.i$a;
import com.baidu.location.h.l;
import java.util.List;

public class i {
    public static long a;
    private static i b;
    private WifiManager c = null;
    private i$a d = null;
    private h e = null;
    private long f;
    private long g;
    private boolean h;
    private Handler i;
    private boolean j;
    private long k;
    private long l;

    private i() {
        Handler handler;
        long l10;
        this.f = l10 = 0L;
        this.g = l10;
        this.h = false;
        this.i = handler = new Handler();
        this.j = false;
        this.k = l10;
        this.l = l10;
    }

    public static i a() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i i10 = b;
            if (i10 == null) {
                b = i10 = new i();
            }
            i10 = b;
            return i10;
        }
    }

    private String a(long l10) {
        StringBuffer stringBuffer = new StringBuffer();
        long l11 = 255L;
        String string2 = String.valueOf((int)(l10 & l11));
        stringBuffer.append(string2);
        char c10 = '.';
        stringBuffer.append(c10);
        String string3 = String.valueOf((int)(l10 >> 8 & l11));
        stringBuffer.append(string3);
        stringBuffer.append(c10);
        string3 = String.valueOf((int)(l10 >> 16 & l11));
        stringBuffer.append(string3);
        stringBuffer.append(c10);
        String string4 = String.valueOf((int)(l10 >> 24 & l11));
        stringBuffer.append(string4);
        return stringBuffer.toString();
    }

    public static boolean a(h h10, h h11) {
        long l10;
        long l11;
        float f10 = com.baidu.location.h.l.aC;
        boolean bl2 = com.baidu.location.f.i.a(h10, h11, f10);
        long l12 = System.currentTimeMillis();
        long l13 = com.baidu.location.b.b.c;
        long l14 = (l12 -= l13) - (l13 = 0L);
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object > 0 && (l11 = (l10 = l12 - (l13 = 30000L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) < 0 && bl2) {
            l12 = h11.h();
            long l15 = h10.h();
            long l16 = (l12 -= l15) - (l15 = (long)30);
            Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object2 > 0) {
                bl2 = false;
                f10 = 0.0f;
            }
        }
        return bl2;
    }

    public static boolean a(h object, h object2, float f10) {
        if (object != null && object2 != null) {
            object = ((h)object).a;
            object2 = ((h)object2).a;
            boolean bl2 = true;
            if (object == object2) {
                return bl2;
            }
            if (object != null && object2 != null) {
                int n10 = object.size();
                int n11 = object2.size();
                if (n10 == 0 && n11 == 0) {
                    return bl2;
                }
                if (n10 != 0 && n11 != 0) {
                    int n12 = 0;
                    block0: for (int i10 = 0; i10 < n10; ++i10) {
                        Object object3 = object.get(i10);
                        object3 = object3 != null ? ((ScanResult)object.get((int)i10)).BSSID : null;
                        if (object3 == null) continue;
                        for (int i11 = 0; i11 < n11; ++i11) {
                            boolean bl3;
                            Object object4 = object2.get(i11);
                            if (object4 != null) {
                                object4 = ((ScanResult)object2.get((int)i11)).BSSID;
                            } else {
                                bl3 = false;
                                object4 = null;
                            }
                            if (object4 == null || !(bl3 = ((String)object3).equals(object4))) continue;
                            ++n12;
                            continue block0;
                        }
                    }
                    float f11 = n12;
                    float f12 = (float)n10 * f10;
                    float f13 = f11 - f12;
                    Object object5 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
                    if (object5 >= 0) {
                        return bl2;
                    }
                }
            }
        }
        return false;
    }

    public static /* synthetic */ boolean a(i i10) {
        return i10.j;
    }

    public static /* synthetic */ boolean a(i i10, boolean bl2) {
        i10.j = bl2;
        return bl2;
    }

    public static /* synthetic */ void b(i i10) {
        i10.s();
    }

    public static /* synthetic */ Handler c(i i10) {
        return i10.i;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void s() {
        block5: {
            boolean bl2;
            List list;
            WifiManager wifiManager = this.c;
            if (wifiManager == null) {
                return;
            }
            try {
                list = wifiManager.getScanResults();
                if (list == null) break block5;
            }
            catch (Exception exception) {
                return;
            }
            long l10 = System.currentTimeMillis();
            h h10 = new h(list, l10);
            h h11 = this.e;
            if (h11 == null || !(bl2 = h10.a(h11))) {
                this.e = h10;
            }
        }
    }

    public void b() {
        this.k = 0L;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        synchronized (this) {
            i$a i$a;
            WifiManager wifiManager;
            boolean bl2 = this.h;
            boolean bl3 = true;
            if (bl2 == bl3) {
                return;
            }
            bl2 = com.baidu.location.f.isServing;
            if (!bl2) {
                return;
            }
            Context context2 = com.baidu.location.f.getServiceContext();
            context2 = context2.getApplicationContext();
            String string2 = "wifi";
            Object object = context2.getSystemService(string2);
            this.c = wifiManager = (WifiManager)object;
            Object var4_10 = null;
            this.d = i$a = new i$a(this, null);
            try {
                Context context3 = com.baidu.location.f.getServiceContext();
                i$a i$a2 = this.d;
                String string3 = "android.net.wifi.SCAN_RESULTS";
                IntentFilter intentFilter = new IntentFilter(string3);
                context3.registerReceiver((BroadcastReceiver)i$a2, intentFilter);
            }
            catch (Exception exception) {}
            this.h = bl3;
            return;
        }
    }

    public List d() {
        List list;
        block3: {
            WifiManager wifiManager;
            list = null;
            try {
                wifiManager = this.c;
                if (wifiManager == null) break block3;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }
            list = wifiManager.getConfiguredNetworks();
        }
        return list;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e() {
        synchronized (this) {
            Context context;
            boolean bl2 = this.h;
            if (!bl2) {
                return;
            }
            try {
                long l10;
                context = com.baidu.location.f.getServiceContext();
                i$a i$a = this.d;
                context.unregisterReceiver((BroadcastReceiver)i$a);
                a = l10 = 0L;
            }
            catch (Exception exception) {}
            bl2 = false;
            context = null;
            this.d = null;
            this.c = null;
            bl2 = false;
            context = null;
            this.h = false;
            return;
        }
    }

    public boolean f() {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14 = System.currentTimeMillis();
        long l15 = l14 - (l13 = this.g);
        long l16 = l15 - (l12 = 0L);
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object > 0 && (l11 = (l10 = (l13 = l14 - l13) - (l15 = 5000L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) <= 0) {
            return false;
        }
        this.g = l14;
        this.b();
        return this.g();
    }

    public boolean g() {
        long l10;
        long l11;
        WifiManager wifiManager = this.c;
        if (wifiManager == null) {
            return false;
        }
        long l12 = System.currentTimeMillis();
        long l13 = l12 - (l11 = this.f);
        long l14 = l13 - (l10 = 0L);
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object > 0) {
            long l15;
            l13 = l12 - l11;
            l10 = this.k;
            long l16 = 5000L;
            long l17 = l10 + l16;
            long l18 = l13 - l17;
            object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object <= 0) {
                return false;
            }
            l13 = a;
            l17 = 1000L;
            l13 *= l17;
            long l19 = (l13 = l12 - l13) - (l10 += l16);
            object = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
            if (object <= 0) {
                return false;
            }
            object = Build.VERSION.SDK_INT;
            int n10 = 28;
            if (object >= n10 && (object = (l15 = (l11 = l12 - l11) - (l13 = 25000L)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) < 0) {
                return false;
            }
            object = this.j();
            if (object != false) {
                l11 = this.f;
                l13 = this.k + (l11 = 10000L);
                long l20 = (l12 -= l11) - l13;
                object = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                if (object <= 0) {
                    return false;
                }
            }
        }
        return this.i();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String h() {
        WifiManager wifiManager = this.c;
        String string2 = "";
        if (wifiManager == null) return string2;
        int n10 = wifiManager.isWifiEnabled();
        String string3 = "&wifio=1";
        if (n10 != 0) return string3;
        n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 <= n11) return string2;
        WifiManager wifiManager2 = this.c;
        try {
            n10 = (int)(wifiManager2.isScanAlwaysAvailable() ? 1 : 0);
            if (n10 == 0) return string2;
        }
        catch (Exception | NoSuchMethodError throwable) {
            return string2;
        }
        return string3;
    }

    public boolean i() {
        WifiManager wifiManager;
        long l10;
        block10: {
            block11: {
                long l11;
                long l12;
                long l13;
                l10 = System.currentTimeMillis();
                long l14 = this.l;
                long l15 = (l10 -= l14) - (l14 = 0L);
                Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (object >= 0 && (l13 = (l12 = l10 - (l11 = 2000L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0) {
                    return false;
                }
                this.l = l10 = System.currentTimeMillis();
                wifiManager = this.c;
                l13 = (long)wifiManager.isWifiEnabled();
                if (l13 != false) break block10;
                l13 = Build.VERSION.SDK_INT;
                int n10 = 17;
                if (l13 <= n10) break block11;
                wifiManager = this.c;
                l13 = (long)wifiManager.isScanAlwaysAvailable();
                if (l13 != false) break block10;
            }
            return false;
        }
        wifiManager = this.c;
        wifiManager.startScan();
        l10 = System.currentTimeMillis();
        try {
            this.f = l10;
            return true;
        }
        catch (Exception | NoSuchMethodError throwable) {
            return false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean j() {
        boolean bl2 = false;
        WifiManager wifiManager = this.c;
        wifiManager = wifiManager.getConnectionInfo();
        if (wifiManager == null) return bl2;
        String string2 = wifiManager.getBSSID();
        if (string2 == null) return bl2;
        try {
            int n10 = wifiManager.getRssi();
            int n11 = -100;
            if (n10 > n11) return true;
        }
        catch (Error | Exception throwable) {
            return bl2;
        }
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean k() {
        int n10;
        Object object;
        boolean bl2;
        block13: {
            block12: {
                bl2 = false;
                object = this.c;
                n10 = object.isWifiEnabled();
                if (n10 != 0) break block12;
                n10 = Build.VERSION.SDK_INT;
                int n11 = 17;
                if (n10 <= n11) return bl2;
                object = this.c;
                n10 = (int)(object.isScanAlwaysAvailable() ? 1 : 0);
                if (n10 == 0) return bl2;
            }
            n10 = (int)(this.j() ? 1 : 0);
            if (n10 == 0) break block13;
            return false;
        }
        WifiManager wifiManager = this.c;
        List list = wifiManager.getScanResults();
        long l10 = 0L;
        try {
            object = new h(list, l10);
            n10 = (int)(((h)object).e() ? 1 : 0);
            if (n10 == 0) return bl2;
            return true;
        }
        catch (Exception | NoSuchMethodError throwable) {
            return bl2;
        }
    }

    public WifiInfo l() {
        block10: {
            WifiManager wifiManager;
            block11: {
                block12: {
                    String string2 = "";
                    wifiManager = this.c;
                    if (wifiManager == null) {
                        return null;
                    }
                    wifiManager = wifiManager.getConnectionInfo();
                    if (wifiManager == null) break block10;
                    String string3 = wifiManager.getBSSID();
                    if (string3 == null) break block10;
                    int n10 = wifiManager.getRssi();
                    int n11 = -100;
                    if (n10 <= n11) break block10;
                    string3 = wifiManager.getBSSID();
                    if (string3 == null) break block11;
                    String string4 = ":";
                    string3 = string3.replace(string4, string2);
                    string4 = "000000000000";
                    n11 = (int)(string4.equals(string3) ? 1 : 0);
                    if (n11 != 0) break block12;
                    boolean bl2 = string2.equals(string3);
                    if (bl2) break block12;
                    string2 = "020000000000";
                    try {
                        bl2 = string3.equals(string2);
                        if (!bl2) break block11;
                    }
                    catch (Error | Exception throwable) {}
                }
                return null;
            }
            return wifiManager;
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String m() {
        boolean bl2;
        boolean bl3;
        CharSequence charSequence = new StringBuffer();
        Object object = com.baidu.location.f.i.a().l();
        if (object == null) return null;
        String string2 = object.getBSSID();
        if (string2 == null) return null;
        string2 = object.getBSSID();
        String string3 = ":";
        String string4 = "";
        string2 = string2.replace(string3, string4);
        int n10 = object.getRssi();
        String string5 = com.baidu.location.f.i.a().n();
        if (n10 < 0) {
            n10 = -n10;
        }
        if (string2 == null) return null;
        int n11 = 100;
        if (n10 >= n11) return null;
        CharSequence charSequence2 = "020000000000";
        n11 = (int)(string2.equals(charSequence2) ? 1 : 0);
        if (n11 != 0) return null;
        ((StringBuffer)charSequence).append("&wf=");
        ((StringBuffer)charSequence).append(string2);
        string2 = ";";
        ((StringBuffer)charSequence).append(string2);
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append(string4);
        ((StringBuilder)charSequence2).append(n10);
        ((StringBuilder)charSequence2).append(string2);
        string3 = ((StringBuilder)charSequence2).toString();
        ((StringBuffer)charSequence).append(string3);
        object = object.getSSID();
        if (object != null && ((bl3 = ((String)object).contains(string3 = "&")) || (bl2 = ((String)object).contains(string2)))) {
            string2 = "_";
            object = ((String)object).replace(string3, string2);
        }
        ((StringBuffer)charSequence).append((String)object);
        object = "&wf_n=1";
        ((StringBuffer)charSequence).append((String)object);
        if (string5 == null) return ((StringBuffer)charSequence).toString();
        object = "&wf_gw=";
        ((StringBuffer)charSequence).append((String)object);
        ((StringBuffer)charSequence).append(string5);
        return ((StringBuffer)charSequence).toString();
    }

    public String n() {
        Object object = this.c;
        if (object != null && (object = object.getDhcpInfo()) != null) {
            int n10 = object.gateway;
            long l10 = n10;
            object = this.a(l10);
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    public h o() {
        boolean bl2;
        h h10 = this.e;
        if (h10 != null && (bl2 = h10.k())) {
            return this.e;
        }
        return this.q();
    }

    public h p() {
        boolean bl2;
        h h10 = this.e;
        if (h10 != null && (bl2 = h10.l())) {
            return this.e;
        }
        return this.q();
    }

    public h q() {
        Object object = this.c;
        if (object != null) {
            try {
                object = object.getScanResults();
            }
            catch (Exception exception) {}
            long l10 = this.f;
            h h10 = new h((List)object, l10);
            return h10;
        }
        object = new h(null, 0L);
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean r() {
        boolean bl2 = false;
        WifiManager wifiManager = this.c;
        int n10 = wifiManager.isWifiEnabled();
        if (n10 != 0) return true;
        n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 <= n11) return false;
        wifiManager = this.c;
        try {
            n10 = (int)(wifiManager.isScanAlwaysAvailable() ? 1 : 0);
            if (n10 == 0) return false;
        }
        catch (Exception | NoSuchMethodError throwable) {
            return bl2;
        }
        return true;
    }
}

