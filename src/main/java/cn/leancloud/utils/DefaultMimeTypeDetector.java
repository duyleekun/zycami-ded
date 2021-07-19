/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.utils;

import cn.leancloud.utils.FileUtil;
import cn.leancloud.utils.FileUtil$MimeTypeDetector;
import cn.leancloud.utils.MimeUtils;
import cn.leancloud.utils.StringUtil;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class DefaultMimeTypeDetector
implements FileUtil$MimeTypeDetector {
    public String getMimeTypeFromExtension(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return "";
        }
        return MimeUtils.guessMimeTypeFromExtension(string2);
    }

    public String getMimeTypeFromPath(String object) {
        try {
            File file = new File((String)object);
            object = file.toPath();
        }
        catch (Exception exception) {
            return "";
        }
        return Files.probeContentType((Path)object);
    }

    public String getMimeTypeFromUrl(String string2) {
        int n10 = StringUtil.isEmpty(string2);
        if (n10 == 0) {
            n10 = string2.lastIndexOf(35);
            if (n10 > 0) {
                string2 = string2.substring(0, n10);
            }
            if ((n10 = string2.lastIndexOf(63)) > 0) {
                string2 = string2.substring(0, n10);
            }
            if ((n10 = string2.lastIndexOf(47)) >= 0) {
                string2 = string2.substring(++n10);
            }
            string2 = FileUtil.getExtensionFromFilename(string2);
            return this.getMimeTypeFromExtension(string2);
        }
        return "";
    }
}

