/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import cn.sharesdk.wechat.utils.WXMediaMessage$IMediaObject;
import com.mob.tools.log.NLog;

public class WXMediaMessage$a {
    public static Bundle a(WXMediaMessage object) {
        Bundle bundle = new Bundle();
        int n10 = ((WXMediaMessage)object).sdkVer;
        bundle.putInt("_wxobject_sdkVer", n10);
        Object[] objectArray = ((WXMediaMessage)object).title;
        bundle.putString("_wxobject_title", (String)objectArray);
        objectArray = ((WXMediaMessage)object).description;
        bundle.putString("_wxobject_description", (String)objectArray);
        objectArray = ((WXMediaMessage)object).thumbData;
        String string2 = "_wxobject_thumbdata";
        bundle.putByteArray(string2, (byte[])objectArray);
        objectArray = ((WXMediaMessage)object).mediaObject;
        if (objectArray != null) {
            objectArray = new StringBuilder();
            objectArray.append("com.tencent.mm.sdk.openapi.");
            string2 = ((WXMediaMessage)object).mediaObject.getClass().getSimpleName();
            objectArray.append(string2);
            objectArray = objectArray.toString();
            string2 = "_wxobject_identifier_";
            bundle.putString(string2, (String)objectArray);
            objectArray = ((WXMediaMessage)object).mediaObject;
            objectArray.serialize(bundle);
        }
        objectArray = ((WXMediaMessage)object).mediaTagName;
        bundle.putString("_wxobject_mediatagname", (String)objectArray);
        objectArray = ((WXMediaMessage)object).messageAction;
        bundle.putString("_wxobject_message_action", (String)objectArray);
        objectArray = ((WXMediaMessage)object).messageExt;
        string2 = "_wxobject_message_ext";
        bundle.putString(string2, (String)objectArray);
        objectArray = ((WXMediaMessage)object).wxminiprogram_ext_msg;
        n10 = (int)(TextUtils.isEmpty((CharSequence)objectArray) ? 1 : 0);
        if (n10 == 0) {
            object = ((WXMediaMessage)object).wxminiprogram_ext_msg;
            objectArray = "_launch_wxminiprogram_ext_msg";
            bundle.putString((String)objectArray, (String)object);
        } else {
            object = SSDKLog.b();
            n10 = 0;
            objectArray = new Object[]{};
            string2 = "WechatResp toBundle that _launch_wxminiprogram_ext_msg is null";
            ((NLog)object).d(string2, objectArray);
        }
        return bundle;
    }

    public static WXMediaMessage a(Bundle bundle) {
        Object object;
        Object object2;
        int n10;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.sdkVer = n10 = bundle.getInt("_wxobject_sdkVer");
        Object[] objectArray = bundle.getString("_wxobject_title");
        wXMediaMessage.title = objectArray;
        objectArray = bundle.getString("_wxobject_description");
        wXMediaMessage.description = objectArray;
        objectArray = bundle.getByteArray("_wxobject_thumbdata");
        wXMediaMessage.thumbData = (byte[])objectArray;
        objectArray = bundle.getString("_wxobject_mediatagname");
        wXMediaMessage.mediaTagName = objectArray;
        objectArray = bundle.getString("_wxobject_message_action");
        wXMediaMessage.messageAction = objectArray;
        objectArray = bundle.getString("_wxobject_message_ext");
        wXMediaMessage.messageExt = objectArray;
        n10 = 0;
        objectArray = null;
        String string2 = "_launch_wxminiprogram_ext_msg";
        string2 = bundle.getString(string2);
        try {
            wXMediaMessage.wxminiprogram_ext_msg = string2;
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            object = new StringBuilder();
            String string3 = " WechatResp get _launch_wxminiprogram_ext_msg error ";
            object.append(string3);
            object.append(throwable);
            string2 = object.toString();
            object = new Object[]{};
            ((NLog)object2).d(string2, object);
        }
        string2 = "_wxapi_basereq_openid";
        object2 = bundle.getString(string2);
        int n11 = TextUtils.isEmpty((CharSequence)object2);
        if (n11 != 0) {
            string2 = "_wxapi_baseresp_openId";
        }
        wXMediaMessage.openId = string2 = bundle.getString(string2);
        string2 = bundle.getString("_wxobject_identifier_");
        if (string2 != null && (n11 = string2.length()) > 0) {
            object2 = "com.tencent.mm.sdk.openapi";
            object = "cn.sharesdk.wechat.utils";
            string2 = string2.replace((CharSequence)object2, (CharSequence)object);
            object2 = Class.forName(string2);
            object2 = ((Class)object2).newInstance();
            object2 = (WXMediaMessage$IMediaObject)object2;
            wXMediaMessage.mediaObject = object2;
            try {
                object2.unserialize(bundle);
                return wXMediaMessage;
            }
            catch (Exception exception) {
                SSDKLog.b().d(exception);
                NLog nLog = SSDKLog.b();
                object2 = new StringBuilder();
                object = "get media object from bundle failed: unknown ident ";
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(string2);
                string2 = ((StringBuilder)object2).toString();
                objectArray = new Object[]{};
                nLog.d(string2, objectArray);
            }
        }
        return wXMediaMessage;
    }
}

