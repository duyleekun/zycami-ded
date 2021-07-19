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

public class WXTextObject
implements WXMediaMessage$IMediaObject {
    public String text;

    public WXTextObject() {
        this(null);
    }

    public WXTextObject(String string2) {
        this.text = string2;
    }

    public boolean checkArgs() {
        int n10;
        int n11;
        Object object = this.text;
        if (object != null && (n11 = ((String)object).length()) != 0 && (n11 = ((String)(object = this.text)).length()) <= (n10 = 10240)) {
            return true;
        }
        object = SSDKLog.b();
        Object[] objectArray = new Object[]{};
        ((NLog)object).d("checkArgs fail, text is invalid", objectArray);
        return false;
    }

    public void serialize(Bundle bundle) {
        String string2 = this.text;
        bundle.putString("_wxtextobject_text", string2);
    }

    public int type() {
        return 1;
    }

    public void unserialize(Bundle object) {
        object = object.getString("_wxtextobject_text");
        this.text = object;
    }
}

