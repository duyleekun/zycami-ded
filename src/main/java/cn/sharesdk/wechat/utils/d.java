/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import cn.sharesdk.wechat.utils.WXMediaMessage$a;
import cn.sharesdk.wechat.utils.m;
import com.mob.tools.log.NLog;

public class d
extends m {
    public WXMediaMessage a;
    public int b;
    public String c;

    public int a() {
        return 2;
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        Object object = WXMediaMessage$a.a(this.a);
        bundle.putAll(object);
        int n10 = this.b;
        bundle.putInt("_wxapi_sendmessagetowx_req_scene", n10);
        n10 = this.a.getType();
        bundle.putInt("_wxapi_sendmessagetowx_req_media_type", n10);
        object = this.c;
        bundle.putString("_wxapi_sendmessagetowx_req_use_open_id", (String)object);
    }

    public boolean a(boolean n10) {
        String string2;
        Object object;
        int n11;
        Object object2 = this.a;
        int n12 = object2.getType();
        if (n12 == (n11 = 8) && ((object2 = (Object)this.a.thumbData) == null || (n12 = ((Object)object2).length) <= 0)) {
            NLog nLog = SSDKLog.b();
            object2 = new Object[]{};
            nLog.d("checkArgs fail, thumbData should not be null when send emoji", object2);
            return false;
        }
        object2 = "checkArgs fail, thumbData is invalid";
        if (n10 != 0) {
            object = this.a.thumbData;
            if (object != null && (n10 = ((byte[])object).length) > (n11 = 131072)) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[]{};
                object.d(object2, objectArray);
                return false;
            }
        } else {
            object = this.a.thumbData;
            if (object != null && (n10 = ((byte[])object).length) > (n11 = 32768)) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[]{};
                object.d(object2, objectArray);
                return false;
            }
        }
        if ((object = (Object)this.a.title) != null && (n10 = object.length()) > (n12 = 512)) {
            object = SSDKLog.b();
            object2 = new Object[]{};
            object.d("checkArgs fail, title is invalid", object2);
            return false;
        }
        object = this.a.description;
        if (object != null && (n10 = object.length()) > (n12 = 1024)) {
            object = this.a;
            object2 = new StringBuilder();
            String string3 = this.a.description;
            int n13 = 1021;
            string3 = string3.substring(0, n13);
            object2.append(string3);
            string3 = "...";
            object2.append(string3);
            object.description = object2 = object2.toString();
        }
        if ((object = this.a.mediaObject) == null) {
            object = SSDKLog.b();
            object2 = new Object[]{};
            object.d("checkArgs fail, mediaObject is null", object2);
            return false;
        }
        n12 = this.b;
        n11 = 3;
        if (n12 == n11 && (string2 = this.c) == null) {
            object = SSDKLog.b();
            object2 = new Object[]{};
            object.d("Send specifiedContact userOpenId can not be null.", object2);
            return false;
        }
        if (n12 == n11 && (object2 = this.f) == null) {
            object = SSDKLog.b();
            object2 = new Object[]{};
            object.d("Send specifiedContact openid can not be null.", object2);
            return false;
        }
        return object.checkArgs();
    }
}

