/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.m;
import com.mob.tools.log.NLog;

public class a
extends m {
    public String a;
    public String b;

    public int a() {
        return 1;
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        String string2 = this.a;
        bundle.putString("_wxapi_sendauth_req_scope", string2);
        string2 = this.b;
        bundle.putString("_wxapi_sendauth_req_state", string2);
    }

    public boolean a(boolean n10) {
        int n11;
        Object object = this.a;
        String string2 = "MicroMsg.SDK.SendAuth.Req";
        int n12 = 1;
        if (object != null && (n10 = ((String)object).length()) != 0 && (n10 = ((String)(object = this.a)).length()) <= (n11 = 1024)) {
            object = this.b;
            if (object != null && (n10 = ((String)object).length()) > n11) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[n12];
                objectArray[0] = "checkArgs fail, state is invalid";
                ((NLog)object).d(string2, objectArray);
                return false;
            }
            return n12 != 0;
        }
        object = SSDKLog.b();
        Object[] objectArray = new Object[n12];
        objectArray[0] = "checkArgs fail, scope is invalid";
        ((NLog)object).d(string2, objectArray);
        return false;
    }
}

