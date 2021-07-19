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

public class WXVideoObject
implements WXMediaMessage$IMediaObject {
    public String videoLowBandUrl;
    public String videoUrl;

    public boolean checkArgs() {
        int n10;
        Object object = this.videoUrl;
        if (object != null && (n10 = ((String)object).length()) != 0 || (object = this.videoLowBandUrl) != null && (n10 = ((String)object).length()) != 0) {
            object = this.videoUrl;
            int n11 = 10240;
            if (object != null && (n10 = ((String)object).length()) > n11) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[]{};
                ((NLog)object).d("checkArgs fail, videoUrl is too long", objectArray);
                return false;
            }
            object = this.videoLowBandUrl;
            if (object != null && (n10 = ((String)object).length()) > n11) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[]{};
                ((NLog)object).d("checkArgs fail, videoLowBandUrl is too long", objectArray);
                return false;
            }
            return true;
        }
        object = SSDKLog.b();
        Object[] objectArray = new Object[]{};
        ((NLog)object).d("both arguments are null", objectArray);
        return false;
    }

    public void serialize(Bundle bundle) {
        String string2 = this.videoUrl;
        bundle.putString("_wxvideoobject_videoUrl", string2);
        string2 = this.videoLowBandUrl;
        bundle.putString("_wxvideoobject_videoLowBandUrl", string2);
    }

    public int type() {
        return 4;
    }

    public void unserialize(Bundle object) {
        String string2;
        this.videoUrl = string2 = object.getString("_wxvideoobject_videoUrl");
        object = object.getString("_wxvideoobject_videoLowBandUrl");
        this.videoLowBandUrl = object;
    }
}

