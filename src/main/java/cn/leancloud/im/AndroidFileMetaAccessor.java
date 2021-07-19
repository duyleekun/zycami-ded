/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.media.MediaMetadataRetriever
 *  android.webkit.MimeTypeMap
 */
package cn.leancloud.im;

import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.webkit.MimeTypeMap;
import cn.leancloud.im.FileMetaAccessor;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AndroidFileMetaAccessor
implements FileMetaAccessor {
    public Map getImageMeta(File comparable) {
        Object object = new BitmapFactory.Options();
        object.inJustDecodeBounds = true;
        BitmapFactory.decodeFile((String)comparable.getAbsolutePath(), (BitmapFactory.Options)object);
        int n10 = object.outWidth;
        int n11 = object.outHeight;
        object = object.outMimeType;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("format", object);
        comparable = n10;
        hashMap.put("width", comparable);
        comparable = n11;
        hashMap.put("height", comparable);
        return hashMap;
    }

    public String getMimeType(String string2) {
        if ((string2 = MimeTypeMap.getFileExtensionFromUrl((String)string2)) != null) {
            MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
            string2 = mimeTypeMap.getMimeTypeFromExtension(string2);
        } else {
            string2 = null;
        }
        return string2;
    }

    public Map mediaInfo(File object) {
        String string2 = "format";
        String string3 = "duration";
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Object object2 = new MediaMetadataRetriever();
        String string4 = ((File)object).getAbsolutePath();
        object2.setDataSource(string4);
        int n10 = 9;
        object2 = object2.extractMetadata(n10);
        object = ((File)object).getAbsolutePath();
        object = this.getMimeType((String)object);
        long l10 = Long.parseLong((String)object2);
        double d10 = l10;
        double d11 = 1000.0;
        d10 /= d11;
        hashMap.put(string2, object);
        object = d10;
        try {
            hashMap.put(string3, object);
        }
        catch (Exception exception) {
            l10 = 0L;
            d10 = 0.0;
            object = l10;
            hashMap.put(string3, object);
            object = "";
            hashMap.put(string2, object);
        }
        return hashMap;
    }
}

