/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.WXMediaMessage$IMediaObject;
import com.mob.tools.log.NLog;

public class WXWebpageObject
implements WXMediaMessage$IMediaObject {
    public String canvasPageXml;
    public String extInfo;
    public String webpageUrl;

    public WXWebpageObject() {
    }

    public WXWebpageObject(String string2) {
        this.webpageUrl = string2;
    }

    public boolean checkArgs() {
        int n10;
        int n11;
        Object object = this.webpageUrl;
        if (object != null && (n11 = ((String)object).length()) != 0 && (n11 = ((String)(object = this.webpageUrl)).length()) <= (n10 = 10240)) {
            return true;
        }
        object = SSDKLog.b();
        Object[] objectArray = new Object[]{};
        ((NLog)object).d("checkArgs fail, webpageUrl is invalid", objectArray);
        return false;
    }

    public void serialize(Bundle bundle) {
        String string2 = this.webpageUrl;
        bundle.putString("_wxwebpageobject_webpageUrl", string2);
        string2 = this.extInfo;
        bundle.putString("_wxwebpageobject_extInfo", string2);
        string2 = this.canvasPageXml;
        bundle.putString("_wxwebpageobject_canvaspagexml", string2);
    }

    public int type() {
        return 5;
    }

    public void unserialize(Bundle object) {
        String string2;
        this.webpageUrl = string2 = object.getString("_wxwebpageobject_webpageUrl");
        this.extInfo = string2 = object.getString("_wxwebpageobject_extInfo");
        object = object.getString("_wxwebpageobject_canvaspagexml");
        this.canvasPageXml = object;
    }
}

