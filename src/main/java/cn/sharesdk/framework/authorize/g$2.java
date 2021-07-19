/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.webkit.CookieManager
 *  android.webkit.CookieSyncManager
 */
package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.a;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.UIHandler;

public class g$2
extends Thread {
    public final /* synthetic */ g a;

    public g$2(g g10) {
        this.a = g10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        try {
            int n10;
            Message message = new Message();
            message.what = n10 = 2;
            Object object = this.a;
            object = g.a((g)object);
            object = DeviceHelper.getInstance((Context)object);
            String string2 = "none";
            object = ((DeviceHelper)object).getDetailNetworkTypeForStatic();
            n10 = (int)(string2.equals(object) ? 1 : 0);
            if (n10 != 0) {
                message.arg1 = n10 = 1;
                object = this.a;
                UIHandler.sendMessage(message, (Handler.Callback)object);
                return;
            }
            n10 = (int)(ShareSDK.isRemoveCookieOnAuthorize() ? 1 : 0);
            if (n10 != 0) {
                object = this.a;
                object = g.b((g)object);
                CookieSyncManager.createInstance((Context)object);
                object = CookieManager.getInstance();
                object.removeAllCookie();
            }
            object = this.a;
            object = ((a)object).a;
            message.obj = object = object.getAuthorizeUrl();
            object = this.a;
            UIHandler.sendMessage(message, (Handler.Callback)object);
            return;
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            nLog.w(throwable);
        }
    }
}

