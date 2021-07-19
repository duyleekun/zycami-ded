/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.lbsapi.auth.a;

public class i
extends Handler {
    public final /* synthetic */ LBSAuthManager a;

    public i(LBSAuthManager lBSAuthManager, Looper looper) {
        this.a = lBSAuthManager;
        super(looper);
    }

    public void handleMessage(Message object) {
        com.baidu.lbsapi.auth.a.a("handleMessage !!");
        Object object2 = object.getData().getString("listenerKey");
        object2 = (LBSAuthManagerListener)LBSAuthManager.a().get(object2);
        CharSequence charSequence = new StringBuilder();
        String string2 = "handleMessage listener = ";
        charSequence.append(string2);
        charSequence.append(object2);
        charSequence = charSequence.toString();
        com.baidu.lbsapi.auth.a.a((String)charSequence);
        if (object2 != null) {
            int n10 = object.what;
            object = object.obj.toString();
            object2.onAuthResult(n10, (String)object);
        }
    }
}

