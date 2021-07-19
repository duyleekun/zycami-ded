/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.c$a;

public class k
implements c$a {
    public final /* synthetic */ String a;
    public final /* synthetic */ LBSAuthManager b;

    public k(LBSAuthManager lBSAuthManager, String string2) {
        this.b = lBSAuthManager;
        this.a = string2;
    }

    public void a(String string2) {
        LBSAuthManager lBSAuthManager = this.b;
        String string3 = this.a;
        LBSAuthManager.a(lBSAuthManager, string2, string3);
    }
}

