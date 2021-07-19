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

public class WXMiniProgramObject
implements WXMediaMessage$IMediaObject {
    public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
    public static final int MINIPROGRAM_TYPE_TEST = 1;
    public static final int MINIPTOGRAM_TYPE_RELEASE;
    public int disableforward = 0;
    public int miniprogramType = 0;
    public String path;
    public String userName;
    public String webpageUrl;
    public boolean withShareTicket;

    public boolean checkArgs() {
        boolean bl2;
        boolean bl3;
        Object object = this.webpageUrl;
        if (object != null && (bl3 = ((String)object).length()) && (bl3 = ((String)(object = this.webpageUrl)).length()) <= (bl2 = 10240 != 0)) {
            object = this.userName;
            if (object != null && (bl3 = ((String)object).length()) && (bl3 = ((String)(object = this.userName)).length()) <= bl2) {
                boolean bl4;
                bl3 = this.miniprogramType;
                bl2 = true;
                if (bl3 >= false && bl3 <= (bl4 = 2 != 0)) {
                    return bl2;
                }
                object = SSDKLog.b();
                Object[] objectArray = new Object[bl2];
                objectArray[0] = "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW";
                ((NLog)object).d("checkArgs fail", objectArray);
                return false;
            }
            object = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            ((NLog)object).d("checkArgs fail, userName is invalid", objectArray);
            return false;
        }
        object = SSDKLog.b();
        Object[] objectArray = new Object[]{};
        ((NLog)object).d("checkArgs fail, webpageUrl is invalid", objectArray);
        return false;
    }

    public void serialize(Bundle bundle) {
        String string2 = this.webpageUrl;
        bundle.putString("_wxminiprogram_webpageurl", string2);
        string2 = this.userName;
        bundle.putString("_wxminiprogram_username", string2);
        string2 = this.path;
        bundle.putString("_wxminiprogram_path", string2);
        int n10 = this.withShareTicket;
        bundle.putBoolean("_wxminiprogram_withsharetiket", n10 != 0);
        n10 = this.miniprogramType;
        bundle.putInt("_wxminiprogram_type", n10);
        n10 = this.disableforward;
        bundle.putInt("_wxminiprogram_disableforward", n10);
    }

    public int type() {
        return 36;
    }

    public void unserialize(Bundle bundle) {
        int n10;
        int n11;
        String string2;
        this.webpageUrl = string2 = bundle.getString("_wxminiprogram_webpageurl");
        this.userName = string2 = bundle.getString("_wxminiprogram_username");
        this.path = string2 = bundle.getString("_wxminiprogram_path");
        this.withShareTicket = n11 = bundle.getBoolean("_wxminiprogram_withsharetiket");
        this.miniprogramType = n11 = bundle.getInt("_wxminiprogram_type");
        this.disableforward = n10 = bundle.getInt("_wxminiprogram_disableforward");
    }
}

