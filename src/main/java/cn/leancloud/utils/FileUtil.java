/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.utils;

import cn.leancloud.AVFile;
import cn.leancloud.utils.DefaultMimeTypeDetector;
import cn.leancloud.utils.FileUtil$MimeTypeDetector;
import cn.leancloud.utils.StringUtil;
import java.util.regex.Pattern;

public class FileUtil {
    public static final String DEFAULTMIMETYPE = "application/octet-stream";
    public static final int DEFAULT_FILE_KEY_LEN = 40;
    private static FileUtil$MimeTypeDetector detector;

    static {
        DefaultMimeTypeDetector defaultMimeTypeDetector = new DefaultMimeTypeDetector();
        detector = defaultMimeTypeDetector;
    }

    public static void config(FileUtil$MimeTypeDetector fileUtil$MimeTypeDetector) {
        detector = fileUtil$MimeTypeDetector;
    }

    public static String getExtensionFromFilename(String string2) {
        String string3;
        int n10 = StringUtil.isEmpty(string2);
        if (n10 == 0 && (n10 = Pattern.matches(string3 = "[a-zA-Z_0-9\\.\\-\\(\\)\\%]+", string2)) != 0 && (n10 = string2.lastIndexOf(46)) >= 0) {
            return string2.substring(++n10);
        }
        return "";
    }

    public static String getFileMimeType(AVFile object) {
        boolean bl2;
        String string2 = ((AVFile)object).getName();
        object = ((AVFile)object).getUrl();
        boolean bl3 = StringUtil.isEmpty(string2);
        object = !bl3 ? FileUtil.getMimeTypeFromFilename(string2) : (!(bl2 = StringUtil.isEmpty((String)object)) ? FileUtil.getMimeTypeFromUrl((String)object) : null);
        bl2 = StringUtil.isEmpty((String)object);
        if (bl2) {
            object = DEFAULTMIMETYPE;
        }
        return object;
    }

    public static String getMimeTypeFromFilename(String string2) {
        FileUtil$MimeTypeDetector fileUtil$MimeTypeDetector;
        string2 = FileUtil.getExtensionFromFilename(string2);
        boolean bl2 = StringUtil.isEmpty(string2);
        String string3 = "";
        if (!bl2 && (string2 = (fileUtil$MimeTypeDetector = detector).getMimeTypeFromExtension(string2)) != null) {
            string3 = string2;
        }
        return string3;
    }

    public static String getMimeTypeFromPath(String string2) {
        FileUtil$MimeTypeDetector fileUtil$MimeTypeDetector;
        boolean bl2 = StringUtil.isEmpty(string2);
        String string3 = "";
        if (!bl2 && (string2 = (fileUtil$MimeTypeDetector = detector).getMimeTypeFromPath(string2)) != null) {
            string3 = string2;
        }
        return string3;
    }

    public static String getMimeTypeFromUrl(String string2) {
        FileUtil$MimeTypeDetector fileUtil$MimeTypeDetector;
        boolean bl2 = StringUtil.isEmpty(string2);
        String string3 = "";
        if (!bl2 && (string2 = (fileUtil$MimeTypeDetector = detector).getMimeTypeFromUrl(string2)) != null) {
            string3 = string2;
        }
        return string3;
    }
}

