/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.os.Bundle
 */
package cn.sharesdk.wechat.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import cn.sharesdk.wechat.utils.l;
import com.mob.tools.log.NLog;

public class WechatHandlerActivity
extends Activity {
    public void onCreate(Bundle object) {
        int n10 = 16973839;
        this.setTheme(n10);
        super.onCreate((Bundle)object);
        object = l.a();
        try {
            ((l)object).a(this);
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            nLog.d(throwable);
        }
        this.finish();
    }

    public void onGetMessageFromWXReq(WXMediaMessage wXMediaMessage) {
    }

    public void onNewIntent(Intent object) {
        super.onNewIntent((Intent)object);
        this.setIntent((Intent)object);
        object = l.a();
        try {
            ((l)object).a(this);
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            nLog.d(throwable);
        }
        this.finish();
    }

    public void onShowMessageFromWXReq(WXMediaMessage wXMediaMessage) {
    }
}

