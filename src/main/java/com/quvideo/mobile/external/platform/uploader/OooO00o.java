/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 */
package com.quvideo.mobile.external.platform.uploader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.quvideo.mobile.external.platform.uploader.OooO;
import com.quvideo.mobile.external.platform.uploader.OooO00o$a;
import com.quvideo.mobile.external.platform.uploader.OooO00o$b;
import com.quvideo.mobile.external.platform.uploader.OooOo00;
import com.quvideo.mobile.external.platform.uploader.db.OooO0OO;
import com.quvideo.mobile.external.platform.uploader.listener.OooO0O0;
import d.o.a.a.b.c.d;

public abstract class OooO00o {
    public volatile boolean OooO = false;
    public Context OooO00o;
    public volatile String OooO0O0;
    public volatile OooO OooO0OO;
    public volatile int OooO0Oo = 0;
    public volatile boolean OooO0o = false;
    public volatile OooO0OO OooO0o0;
    public volatile boolean OooO0oO = false;
    public volatile int OooO0oo = 0;
    public volatile OooO0O0 OooOO0;

    public OooO00o(String object) {
        OooO00o$a oooO00o$a = new OooO00o$a(this);
        this.OooOO0 = oooO00o$a;
        oooO00o$a = OooOo00.a().a;
        this.OooO00o = oooO00o$a;
        this.OooO0O0 = object;
        this.OooO0o0 = object = new OooO0OO();
    }

    private final void OooO00o(int n10) {
        d.b(this.OooO0O0, n10);
    }

    public static /* synthetic */ void OooO00o(OooO00o oooO00o) {
        oooO00o.OooO0oO();
    }

    public static /* synthetic */ void OooO00o(OooO00o oooO00o, int n10) {
        oooO00o.OooO00o(n10);
    }

    public static /* synthetic */ void OooO00o(OooO00o oooO00o, String string2) {
        oooO00o.OooO0OO(string2);
    }

    public static /* synthetic */ void OooO00o(OooO00o oooO00o, String string2, int n10, String string3) {
        oooO00o.OooO00o(string2, n10, string3);
    }

    public static /* synthetic */ void OooO00o(OooO00o oooO00o, String string2, String string3, String string4) {
        oooO00o.OooO00o(string2, string3, string4);
    }

    private void OooO00o(String string2, int n10, String string3) {
        d.d(string2, n10, string3);
    }

    private void OooO00o(String string2, String string3, String string4) {
        d.f(string2, string3, string4);
    }

    private void OooO0OO(String string2) {
        d.g(string2);
    }

    private void OooO0oO() {
        synchronized (this) {
            boolean bl2 = true;
            this.OooO = bl2;
            bl2 = false;
            Object var2_2 = null;
            this.OooO00o = null;
            this.OooO0o0 = null;
            this.OooO0OO = null;
            this.OooOO0 = null;
            this.OooO0o0();
            return;
        }
    }

    public abstract void OooO();

    public int OooO00o(String object, int n10) {
        OooO0OO oooO0OO = this.OooO0o0;
        if ((object = oooO0OO.OooO00o((String)object, n10)) != null) {
            return ((com.quvideo.mobile.external.platform.uploader.db.entity.OooO00o)object).OooO0Oo();
        }
        return 0;
    }

    public void OooO00o() {
        this.OooO0o0.OooO0o0();
        this.OooO0O0();
    }

    public final void OooO00o(int n10, int n11) {
        d.c(this.OooO0O0, n10, n11);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void OooO00o(int n10, String string2) {
        Object object = this.OooO0OO;
        if (object != null) {
            object = this.OooO0OO;
            boolean bl2 = ((OooO)object).OooO0OO;
            if (!bl2) {
                long l10 = this.OooO0OO.OooO0O0;
                String string3 = this.OooO0OO.OooO00o;
                boolean bl3 = this.OooO0OO.OooO0Oo;
                boolean bl4 = this.OooO0OO.OooO0o0;
                object = this.OooO0OO;
                String string4 = ((OooO)object).OooO0o;
                OooO00o$b oooO00o$b = new OooO00o$b(this, n10, string2);
                OooOo00.c(l10, string3, bl3, bl4, string4, oooO00o$b);
                return;
            }
        }
        object = this.OooO0o0;
        String string5 = this.OooO0O0;
        ((OooO0OO)object).OooO00o(string5);
        object = this.OooOO0;
        string5 = this.OooO0O0;
        object.OooO00o(string5, n10, string2);
    }

    public final void OooO00o(OooO oooO) {
        this.OooO0OO = oooO;
    }

    public void OooO00o(String string2, int n10, int n11) {
        com.quvideo.mobile.external.platform.uploader.db.entity.OooO00o oooO00o = new com.quvideo.mobile.external.platform.uploader.db.entity.OooO00o();
        long l10 = System.currentTimeMillis();
        oooO00o.OooO00o(l10);
        oooO00o.OooO00o(string2);
        oooO00o.OooO0OO(n10);
        oooO00o.OooO00o(n11);
        this.OooO0o0.OooO0O0(oooO00o);
    }

    public final boolean OooO00o(String string2) {
        boolean bl2;
        String string3 = "expired";
        boolean bl3 = string2.contains(string3);
        return bl3 || (bl3 = string2.contains(string3 = "socketexception")) || (bl3 = string2.contains(string3 = "econnreset")) || (bl3 = string2.contains(string3 = "hostname")) || (bl3 = string2.contains(string3 = "can't get a federation token")) || (bl3 = string2.contains(string3 = "compute signature failed")) || (bl3 = string2.contains(string3 = "timeout")) || (bl3 = string2.contains(string3 = "signature")) || (bl3 = string2.contains(string3 = "abort")) || (bl3 = string2.contains(string3 = "failed to connect")) || (bl3 = string2.contains(string3 = "connection reset")) || (bl3 = string2.contains(string3 = "unable to resolve host")) || (bl3 = string2.contains(string3 = "open failed: enoent")) || (bl2 = string2.contains(string3 = "ssl"));
        {
        }
    }

    public long OooO0O0(String object, int n10) {
        long l10;
        OooO0OO oooO0OO = this.OooO0o0;
        if ((object = oooO0OO.OooO00o((String)object, n10)) != null) {
            l10 = System.currentTimeMillis();
            long l11 = ((com.quvideo.mobile.external.platform.uploader.db.entity.OooO00o)object).OooO0O0();
            l10 -= l11;
        } else {
            l10 = -1;
        }
        return l10;
    }

    public void OooO0O0() {
    }

    public void OooO0O0(String string2) {
        OooO oooO = this.OooO0OO;
        d.h(string2, oooO);
    }

    public abstract String OooO0OO();

    public final String OooO0Oo() {
        return OooOo00.a().j();
    }

    public final boolean OooO0o() {
        int n10;
        NetworkInfo networkInfo = ((ConnectivityManager)this.OooO00o.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo == null) {
            return false;
        }
        int n11 = networkInfo.getType();
        return n11 != (n10 = -1);
    }

    public abstract void OooO0o0();

    public abstract void OooO0oo();

    public abstract void OooOO0();
}

