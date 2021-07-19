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

public class g
extends m {
    public int a;
    public String b;
    public String c;

    public int a() {
        return 18;
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        int n10 = this.a;
        bundle.putInt("_wxapi_subscribemessage_req_scene", n10);
        String string2 = this.b;
        bundle.putString("_wxapi_subscribemessage_req_templateid", string2);
        string2 = this.c;
        bundle.putString("_wxapi_subscribemessage_req_reserved", string2);
    }

    public boolean a(boolean n10) {
        Object object = this.b;
        String string2 = "ShareSDK";
        int n11 = 1;
        if (object != null && (n10 = ((String)object).length()) != 0) {
            int n12;
            object = this.b;
            n10 = ((String)object).length();
            if (n10 > (n12 = 1024)) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[n11];
                objectArray[0] = "MicroMsg.SDK.SubscribeMessage.ReqcheckArgs fail, templateID is too long";
                ((NLog)object).e(string2, objectArray);
                return false;
            }
            object = this.c;
            if (object != null && (n10 = ((String)object).length()) > n12) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[n11];
                objectArray[0] = "MicroMsg.SDK.SubscribeMessage.ReqcheckArgs fail, reserved is too long";
                ((NLog)object).e(string2, objectArray);
                return false;
            }
            return n11 != 0;
        }
        object = SSDKLog.b();
        Object[] objectArray = new Object[n11];
        objectArray[0] = "MicroMsg.SDK.SubscribeMessage.ReqcheckArgs fail, templateID is null";
        ((NLog)object).e(string2, objectArray);
        return false;
    }
}

