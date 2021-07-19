/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.widget.Toast
 */
package com.zhiyun.cama.wxapi;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import cn.sharesdk.wechat.utils.WXAppExtendObject;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import cn.sharesdk.wechat.utils.WechatHandlerActivity;

public class WXEntryActivity
extends WechatHandlerActivity {
    public void onGetMessageFromWXReq(WXMediaMessage wXMediaMessage) {
        if (wXMediaMessage != null) {
            wXMediaMessage = this.getPackageManager();
            String string2 = this.getPackageName();
            wXMediaMessage = wXMediaMessage.getLaunchIntentForPackage(string2);
            this.startActivity((Intent)wXMediaMessage);
        }
    }

    public void onShowMessageFromWXReq(WXMediaMessage object) {
        boolean bl2;
        if (object != null && (object = ((WXMediaMessage)object).mediaObject) != null && (bl2 = object instanceof WXAppExtendObject)) {
            object = ((WXAppExtendObject)object).extInfo;
            bl2 = false;
            object = Toast.makeText((Context)this, (CharSequence)object, (int)0);
            object.show();
        }
    }
}

