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
import cn.sharesdk.wechat.utils.n;
import com.mob.tools.log.NLog;
import java.io.File;

public class WXAppExtendObject
implements WXMediaMessage$IMediaObject {
    public String extInfo;
    public byte[] fileData;
    public String filePath;

    public WXAppExtendObject() {
    }

    public WXAppExtendObject(String string2, String string3) {
        this.extInfo = string2;
        this.filePath = string3;
    }

    public WXAppExtendObject(String string2, byte[] byArray) {
        this.extInfo = string2;
        this.fileData = byArray;
    }

    public boolean checkArgs() {
        Object object;
        block11: {
            boolean bl2;
            int n10;
            int n11;
            block10: {
                object = this.extInfo;
                if (!(object != null && (n11 = ((String)object).length()) != 0 || (object = this.filePath) != null && (n11 = ((String)object).length()) != 0) && ((object = (Object)this.fileData) == null || (n11 = ((Object)object).length) == 0)) break block11;
                object = this.extInfo;
                if (object != null && (n11 = ((String)object).length()) > (n10 = 2048)) {
                    object = SSDKLog.b();
                    Object[] objectArray = new Object[]{};
                    ((NLog)object).d("checkArgs fail, extInfo is invalid", objectArray);
                    return false;
                }
                object = this.filePath;
                if (object != null && (n11 = ((String)object).length()) > (n10 = 10240)) {
                    object = SSDKLog.b();
                    Object[] objectArray = new Object[]{};
                    ((NLog)object).d("checkArgs fail, filePath is invalid", objectArray);
                    return false;
                }
                object = this.filePath;
                n10 = 0xA00000;
                bl2 = true;
                if (object == null) break block10;
                Object object2 = this.filePath;
                object = new File((String)object2);
                long l10 = ((File)object).length();
                long l11 = 0xA00000L;
                n11 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                if (n11 <= 0) break block10;
                object = SSDKLog.b();
                object2 = "checkArgs fail, fileSize is too large";
                Object[] objectArray = new Object[]{};
                try {
                    ((NLog)object).d(object2, objectArray);
                    return false;
                }
                catch (Throwable throwable) {
                    object2 = SSDKLog.b();
                    objectArray = new Object[bl2];
                    StringBuilder stringBuilder = new StringBuilder();
                    String string2 = " WXAppExendObject catch don't worry will be two style ";
                    stringBuilder.append(string2);
                    stringBuilder.append(throwable);
                    objectArray[0] = object = stringBuilder.toString();
                    ((NLog)object2).d("ShareSDK", objectArray);
                    object = n.a();
                    object2 = this.filePath;
                    n11 = ((n)object).a((String)object2);
                    if (n11 == 0 || n11 <= n10) break block10;
                    return false;
                }
            }
            if ((object = (Object)this.fileData) != null && (n11 = ((Object)object).length) > n10) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[]{};
                ((NLog)object).d("checkArgs fail, fileData is too large", objectArray);
                return false;
            }
            return bl2;
        }
        object = SSDKLog.b();
        Object[] objectArray = new Object[]{};
        ((NLog)object).d("checkArgs fail, all arguments is null", objectArray);
        return false;
    }

    public void serialize(Bundle bundle) {
        Object object = this.extInfo;
        bundle.putString("_wxappextendobject_extInfo", (String)object);
        object = this.fileData;
        bundle.putByteArray("_wxappextendobject_fileData", (byte[])object);
        object = this.filePath;
        bundle.putString("_wxappextendobject_filePath", (String)object);
    }

    public int type() {
        return 7;
    }

    public void unserialize(Bundle object) {
        Object object2 = object.getString("_wxappextendobject_extInfo");
        this.extInfo = object2;
        object2 = object.getByteArray("_wxappextendobject_fileData");
        this.fileData = (byte[])object2;
        object = object.getString("_wxappextendobject_filePath");
        this.filePath = object;
    }
}

