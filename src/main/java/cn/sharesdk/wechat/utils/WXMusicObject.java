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
import com.mob.tools.log.NLog;

public class WXMusicObject
implements WXMediaMessage$IMediaObject {
    public String musicDataUrl;
    public String musicLowBandDataUrl;
    public String musicLowBandUrl;
    public String musicUrl;
    public String songAlbumUrl;
    public String songLyric;

    public boolean checkArgs() {
        Object object = this.musicUrl;
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 != 0 && (n10 = TextUtils.isEmpty((CharSequence)(object = this.musicLowBandUrl))) != 0) {
            object = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            ((NLog)object).d("both musicUrl and musicLowBandUrl are null", objectArray);
            return false;
        }
        object = this.musicUrl;
        int n11 = 10240;
        if (object != null && (n10 = ((String)object).length()) > n11) {
            object = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            ((NLog)object).d("checkArgs fail, musicUrl is too long", objectArray);
            return false;
        }
        object = this.musicLowBandUrl;
        if (object != null && (n10 = ((String)object).length()) > n11) {
            object = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            ((NLog)object).d("checkArgs fail, musicLowBandUrl is too long", objectArray);
            return false;
        }
        object = this.songAlbumUrl;
        if (object != null && (n10 = ((String)object).length()) > n11) {
            object = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            ((NLog)object).d("checkArgs fail, songAlbumUrl is too long", objectArray);
            return false;
        }
        object = this.songLyric;
        if (object != null && (n10 = ((String)object).length()) > (n11 = 32768)) {
            object = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            ((NLog)object).d("checkArgs fail, songLyric is too long", objectArray);
            return false;
        }
        return true;
    }

    public void serialize(Bundle bundle) {
        String string2 = this.musicUrl;
        bundle.putString("_wxmusicobject_musicUrl", string2);
        string2 = this.musicLowBandUrl;
        bundle.putString("_wxmusicobject_musicLowBandUrl", string2);
        string2 = this.musicDataUrl;
        bundle.putString("_wxmusicobject_musicDataUrl", string2);
        string2 = this.musicLowBandDataUrl;
        bundle.putString("_wxmusicobject_musicLowBandDataUrl", string2);
        string2 = this.songAlbumUrl;
        bundle.putString("_wxmusicobject_musicAlbumUrl", string2);
        string2 = this.songLyric;
        bundle.putString("_wxmusicobject_musicLyric", string2);
    }

    public int type() {
        return 3;
    }

    public void unserialize(Bundle object) {
        String string2;
        this.musicUrl = string2 = object.getString("_wxmusicobject_musicUrl");
        this.musicLowBandUrl = string2 = object.getString("_wxmusicobject_musicLowBandUrl");
        this.musicDataUrl = string2 = object.getString("_wxmusicobject_musicDataUrl");
        this.musicLowBandDataUrl = string2 = object.getString("_wxmusicobject_musicLowBandDataUrl");
        this.songAlbumUrl = string2 = object.getString("_wxmusicobject_musicAlbumUrl");
        object = object.getString("_wxmusicobject_musicLyric");
        this.songLyric = object;
    }
}

