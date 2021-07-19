/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.baidu.lbsapi.auth;

import android.content.Context;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.a;
import com.baidu.lbsapi.auth.b;
import com.baidu.lbsapi.auth.m;
import java.util.Hashtable;

public class j
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Hashtable e;
    public final /* synthetic */ LBSAuthManager f;

    public j(LBSAuthManager lBSAuthManager, int n10, boolean bl2, String string2, String string3, Hashtable hashtable) {
        this.f = lBSAuthManager;
        this.a = n10;
        this.b = bl2;
        this.c = string2;
        this.d = string3;
        this.e = hashtable;
    }

    public void run() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("status = ");
        int n10 = this.a;
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("; forced = ");
        n10 = (int)(this.b ? 1 : 0);
        ((StringBuilder)object).append(n10 != 0);
        ((StringBuilder)object).append("checkAK = ");
        Object object2 = this.f;
        String string2 = this.c;
        n10 = LBSAuthManager.a((LBSAuthManager)object2, string2);
        ((StringBuilder)object).append(n10 != 0);
        object = ((StringBuilder)object).toString();
        com.baidu.lbsapi.auth.a.a((String)object);
        int n11 = this.a;
        n10 = 601;
        if (n11 != n10 && (n10 = (int)(this.b ? 1 : 0)) == 0 && n11 != (n10 = -1) && (n11 = (int)(LBSAuthManager.a((LBSAuthManager)(object = this.f), (String)(object2 = this.c)) ? 1 : 0)) == 0) {
            n11 = 602;
            n10 = this.a;
            boolean bl2 = false;
            string2 = null;
            if (n11 == n10) {
                com.baidu.lbsapi.auth.a.a("authenticate wait ");
                object = LBSAuthManager.c();
                if (object != null) {
                    object = LBSAuthManager.c();
                    ((m)object).b();
                }
            } else {
                object = "authenticate else";
                com.baidu.lbsapi.auth.a.a((String)object);
            }
            object = this.f;
            object2 = this.c;
            LBSAuthManager.a((LBSAuthManager)object, null, (String)object2);
        } else {
            com.baidu.lbsapi.auth.a.a("authenticate sendAuthRequest");
            object = LBSAuthManager.b();
            String[] stringArray = com.baidu.lbsapi.auth.b.b((Context)object);
            if (stringArray != null && (n11 = stringArray.length) > (n10 = 1)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("authStrings.length:");
                n10 = stringArray.length;
                ((StringBuilder)object).append(n10);
                com.baidu.lbsapi.auth.a.a(((StringBuilder)object).toString());
                object = "more sha1 auth";
                com.baidu.lbsapi.auth.a.a((String)object);
                object2 = this.f;
                boolean bl3 = this.b;
                String string3 = this.d;
                Hashtable hashtable = this.e;
                String string4 = this.c;
                LBSAuthManager.a((LBSAuthManager)object2, bl3, string3, hashtable, stringArray, string4);
            } else {
                object = this.f;
                n10 = (int)(this.b ? 1 : 0);
                string2 = this.d;
                Hashtable hashtable = this.e;
                String string5 = this.c;
                LBSAuthManager.a((LBSAuthManager)object, n10 != 0, string2, hashtable, string5);
            }
        }
    }
}

