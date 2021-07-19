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
import cn.sharesdk.wechat.utils.WXMediaMessage$IMediaObject;
import cn.sharesdk.wechat.utils.n;
import com.mob.tools.log.NLog;
import java.io.File;

public class WXEmojiObject
implements WXMediaMessage$IMediaObject {
    public byte[] emojiData;
    public String emojiPath;

    public WXEmojiObject() {
    }

    public WXEmojiObject(String string2) {
        this.emojiPath = string2;
    }

    public WXEmojiObject(byte[] byArray) {
        this.emojiData = byArray;
    }

    public boolean checkArgs() {
        int n10;
        block16: {
            CharSequence charSequence;
            Object[] objectArray;
            int n11;
            int n12;
            Object object;
            Object object2;
            block15: {
                object2 = this.emojiData;
                object = "MicroMsg.SDK.WXEmojiObject";
                n10 = 1;
                if ((object2 == null || (n12 = ((byte[])object2).length) == 0) && (n12 = (int)(TextUtils.isEmpty((CharSequence)(object2 = (Object)this.emojiPath)) ? 1 : 0)) != 0) {
                    object2 = SSDKLog.b();
                    Object[] objectArray2 = new Object[n10];
                    objectArray2[0] = "checkArgs fail, both arguments is null";
                    ((NLog)object2).d(object, objectArray2);
                    return false;
                }
                object2 = this.emojiData;
                n11 = 0xA00000;
                if (object2 != null && (n12 = ((byte[])object2).length) > n11) {
                    object2 = SSDKLog.b();
                    Object[] objectArray3 = new Object[n10];
                    objectArray3[0] = "checkArgs fail, emojiData is too large";
                    ((NLog)object2).d(object, objectArray3);
                    return false;
                }
                object2 = this.emojiPath;
                if (object2 == null) break block16;
                object2 = new File;
                objectArray = this.emojiPath;
                ((File)object2)((String)objectArray);
                boolean bl2 = ((File)object2).exists();
                if (bl2) break block15;
                object2 = SSDKLog.b();
                objectArray = new Object[n10];
                charSequence = "checkArgs fail, emojiPath not found";
                objectArray[0] = charSequence;
                ((NLog)object2).d(object, objectArray);
                return false;
            }
            long l10 = ((File)object2).length();
            long l11 = 0xA00000L;
            n12 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
            if (n12 <= 0) break block16;
            object2 = SSDKLog.b();
            objectArray = new Object[n10];
            charSequence = "checkArgs fail, emojiSize is too large";
            objectArray[0] = charSequence;
            try {
                ((NLog)object2).d(object, objectArray);
                return false;
            }
            catch (Throwable throwable) {
                Object object3;
                object = SSDKLog.b();
                objectArray = new Object[n10];
                charSequence = new StringBuilder();
                String string2 = " WXEmojiObject catch don't worry will be two style ";
                charSequence.append(string2);
                charSequence.append(throwable);
                objectArray[0] = object3 = charSequence.toString();
                ((NLog)object).d("ShareSDk", objectArray);
                object3 = n.a();
                object = this.emojiPath;
                n12 = ((n)object3).a((String)object);
                if (n12 == 0 || n12 <= n11) break block16;
                return false;
            }
        }
        return n10 != 0;
    }

    public void serialize(Bundle bundle) {
        Object object = this.emojiData;
        bundle.putByteArray("_wxemojiobject_emojiData", object);
        object = this.emojiPath;
        bundle.putString("_wxemojiobject_emojiPath", (String)object);
    }

    public void setEmojiData(byte[] byArray) {
        this.emojiData = byArray;
    }

    public void setEmojiPath(String string2) {
        this.emojiPath = string2;
    }

    public int type() {
        return 8;
    }

    public void unserialize(Bundle object) {
        byte[] byArray = object.getByteArray("_wxemojiobject_emojiData");
        this.emojiData = byArray;
        object = object.getString("_wxemojiobject_emojiPath");
        this.emojiPath = object;
    }
}

