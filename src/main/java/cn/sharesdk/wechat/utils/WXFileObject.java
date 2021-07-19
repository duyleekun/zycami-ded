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

public class WXFileObject
implements WXMediaMessage$IMediaObject {
    public byte[] fileData;
    public String filePath;

    public WXFileObject() {
        this.fileData = null;
        this.filePath = null;
    }

    public WXFileObject(String string2) {
        this.filePath = string2;
    }

    public WXFileObject(byte[] byArray) {
        this.fileData = byArray;
    }

    public boolean checkArgs() {
        Object object;
        block9: {
            int n10;
            block8: {
                int n11;
                object = this.fileData;
                if (!(object != null && (n11 = ((byte[])object).length) != 0 || (object = (Object)this.filePath) != null && (n11 = object.length()) != 0)) break block9;
                object = this.fileData;
                int n12 = 0xA00000;
                if (object != null && (n11 = ((byte[])object).length) > n12) {
                    object = SSDKLog.b();
                    Object[] objectArray = new Object[]{};
                    object.d("checkArgs fail, fileData is too large", objectArray);
                    return false;
                }
                object = this.filePath;
                n10 = 1;
                if (object == null) break block8;
                Object object2 = this.filePath;
                object = new File((String)object2);
                long l10 = object.length();
                long l11 = 0xA00000L;
                n11 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                if (n11 <= 0) break block8;
                object = SSDKLog.b();
                object2 = "checkArgs fail, fileSize is too large";
                Object[] objectArray = new Object[]{};
                try {
                    object.d(object2, objectArray);
                    return false;
                }
                catch (Throwable throwable) {
                    Object object3;
                    object2 = SSDKLog.b();
                    objectArray = new Object[n10];
                    StringBuilder stringBuilder = new StringBuilder();
                    String string2 = " WXAppExendObject catch don't worry will be two style ";
                    stringBuilder.append(string2);
                    stringBuilder.append(throwable);
                    objectArray[0] = object3 = stringBuilder.toString();
                    ((NLog)object2).d("ShareSDK", objectArray);
                    object3 = n.a();
                    object2 = this.filePath;
                    n11 = ((n)object3).a((String)object2);
                    if (n11 == 0 || n11 <= n12) break block8;
                    return false;
                }
            }
            return n10 != 0;
        }
        object = SSDKLog.b();
        Object[] objectArray = new Object[]{};
        object.d("checkArgs fail, both arguments is null", objectArray);
        return false;
    }

    public void serialize(Bundle bundle) {
        Object object = this.fileData;
        bundle.putByteArray("_wxfileobject_fileData", object);
        object = this.filePath;
        bundle.putString("_wxfileobject_filePath", (String)object);
    }

    public void setFileData(byte[] byArray) {
        this.fileData = byArray;
    }

    public void setFilePath(String string2) {
        this.filePath = string2;
    }

    public int type() {
        return 6;
    }

    public void unserialize(Bundle object) {
        byte[] byArray = object.getByteArray("_wxfileobject_fileData");
        this.fileData = byArray;
        object = object.getString("_wxfileobject_filePath");
        this.filePath = object;
    }
}

