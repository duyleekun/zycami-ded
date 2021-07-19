/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 */
package cn.sharesdk.wechat.utils;

import android.graphics.Bitmap;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.WXMediaMessage$IMediaObject;
import com.mob.tools.log.NLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class WXMediaMessage {
    public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
    public static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
    public static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
    public String description;
    public WXMediaMessage$IMediaObject mediaObject;
    public String mediaTagName;
    public String messageAction;
    public String messageExt;
    public String openId;
    public int sdkVer;
    public byte[] thumbData;
    public String title;
    public String wxminiprogram_ext_msg;

    public WXMediaMessage() {
        this(null);
    }

    public WXMediaMessage(WXMediaMessage$IMediaObject wXMediaMessage$IMediaObject) {
        this.mediaObject = wXMediaMessage$IMediaObject;
    }

    public final int getType() {
        WXMediaMessage$IMediaObject wXMediaMessage$IMediaObject = this.mediaObject;
        if (wXMediaMessage$IMediaObject == null) {
            return 0;
        }
        return wXMediaMessage$IMediaObject.type();
    }

    public final void setThumbImage(Bitmap object) {
        int n10;
        Bitmap.CompressFormat compressFormat;
        Object[] objectArray;
        try {
            objectArray = new ByteArrayOutputStream();
            compressFormat = Bitmap.CompressFormat.JPEG;
            n10 = 85;
        }
        catch (Exception exception) {
            SSDKLog.b().d(exception);
            NLog nLog = SSDKLog.b();
            objectArray = new Object[]{};
            nLog.d("put thumb failed", objectArray);
            return;
        }
        object.compress(compressFormat, n10, (OutputStream)objectArray);
        object = objectArray.toByteArray();
        this.thumbData = (byte[])object;
        objectArray.close();
    }
}

