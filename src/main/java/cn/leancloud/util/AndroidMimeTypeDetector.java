/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.webkit.MimeTypeMap
 */
package cn.leancloud.util;

import android.webkit.MimeTypeMap;
import cn.leancloud.utils.FileUtil;
import cn.leancloud.utils.FileUtil$MimeTypeDetector;
import cn.leancloud.utils.StringUtil;
import java.io.File;

public class AndroidMimeTypeDetector
implements FileUtil$MimeTypeDetector {
    public String getMimeTypeFromExtension(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(string2);
        }
        return "";
    }

    public String getMimeTypeFromPath(String string2) {
        File file;
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2 && !(bl2 = StringUtil.isEmpty(string2 = FileUtil.getExtensionFromFilename((file = new File(string2)).getName())))) {
            return this.getMimeTypeFromExtension(string2);
        }
        return "";
    }

    public String getMimeTypeFromUrl(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            string2 = MimeTypeMap.getFileExtensionFromUrl((String)string2);
            return this.getMimeTypeFromExtension(string2);
        }
        return "";
    }
}

