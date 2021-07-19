/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.os.Bundle
 */
package cn.sharesdk.wechat.utils;

import android.graphics.Bitmap;
import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.WXMediaMessage$IMediaObject;
import cn.sharesdk.wechat.utils.n;
import com.mob.tools.log.NLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

public class WXImageObject
implements WXMediaMessage$IMediaObject {
    public byte[] imageData;
    public String imagePath;
    public String imageUrl;

    public WXImageObject() {
    }

    public WXImageObject(Bitmap object) {
        int n10;
        Bitmap.CompressFormat compressFormat;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            compressFormat = Bitmap.CompressFormat.JPEG;
            n10 = 85;
        }
        catch (Exception exception) {
            SSDKLog.b().d(exception);
            return;
        }
        object.compress(compressFormat, n10, (OutputStream)byteArrayOutputStream);
        object = byteArrayOutputStream.toByteArray();
        this.imageData = (byte[])object;
        byteArrayOutputStream.close();
    }

    public WXImageObject(byte[] byArray) {
        this.imageData = byArray;
    }

    public boolean checkArgs() {
        Object object;
        block11: {
            boolean bl2;
            int n10;
            int n11;
            block10: {
                object = this.imageData;
                if (!(object != null && (n11 = ((byte[])object).length) != 0 || (object = (Object)this.imagePath) != null && (n11 = object.length()) != 0 || (object = (Object)this.imageUrl) != null && (n11 = object.length()) != 0)) break block11;
                object = this.imageData;
                int n12 = 0xA00000;
                if (object != null && (n11 = ((Object)object).length) > n12) {
                    object = SSDKLog.b();
                    Object[] objectArray = new Object[]{};
                    object.d("checkArgs fail, content is too large", objectArray);
                    return false;
                }
                object = this.imagePath;
                n10 = 10240;
                if (object != null && (n11 = object.length()) > n10) {
                    object = SSDKLog.b();
                    Object[] objectArray = new Object[]{};
                    object.d("checkArgs fail, path is invalid", objectArray);
                    return false;
                }
                object = this.imagePath;
                bl2 = true;
                if (object == null) break block10;
                Object object2 = this.imagePath;
                object = new File((String)object2);
                long l10 = object.length();
                long l11 = 0xA00000L;
                n11 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                if (n11 <= 0) break block10;
                object = SSDKLog.b();
                object2 = "checkArgs fail, image content is too large";
                Object[] objectArray = new Object[]{};
                try {
                    object.d(object2, objectArray);
                    return false;
                }
                catch (Throwable throwable) {
                    object2 = SSDKLog.b();
                    objectArray = new Object[bl2];
                    StringBuilder stringBuilder = new StringBuilder();
                    String string2 = " WXImageObject catch don't worry will betwo style ";
                    stringBuilder.append(string2);
                    stringBuilder.append(throwable);
                    objectArray[0] = object = stringBuilder.toString();
                    ((NLog)object2).d("ShareSDK", objectArray);
                    object = n.a();
                    object2 = this.imagePath;
                    n11 = object.a((String)object2);
                    if (n11 == 0 || n11 <= n12) break block10;
                    return false;
                }
            }
            if ((object = this.imageUrl) != null && (n11 = object.length()) > n10) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[]{};
                object.d("checkArgs fail, url is invalid", objectArray);
                return false;
            }
            return bl2;
        }
        object = SSDKLog.b();
        Object[] objectArray = new Object[]{};
        object.d("checkArgs fail, all arguments are null", objectArray);
        return false;
    }

    public void serialize(Bundle bundle) {
        Object object = this.imageData;
        bundle.putByteArray("_wximageobject_imageData", object);
        object = this.imagePath;
        bundle.putString("_wximageobject_imagePath", (String)object);
        object = this.imageUrl;
        bundle.putString("_wximageobject_imageUrl", (String)object);
    }

    public int type() {
        return 2;
    }

    public void unserialize(Bundle object) {
        Object object2 = object.getByteArray("_wximageobject_imageData");
        this.imageData = object2;
        object2 = object.getString("_wximageobject_imagePath");
        this.imagePath = object2;
        object = object.getString("_wximageobject_imageUrl");
        this.imageUrl = object;
    }
}

