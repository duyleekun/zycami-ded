/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.messages;

import cn.leancloud.callback.SaveCallback;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.im.v2.messages.AVIMFileMessage;
import java.io.File;
import java.util.Map;

public class AVIMFileMessageAccessor {
    public static Map getImageMeta(File file) {
        return InternalConfiguration.getFileMetaAccessor().getImageMeta(file);
    }

    public static String getMimeType(String string2) {
        return InternalConfiguration.getFileMetaAccessor().getMimeType(string2);
    }

    public static Map mediaInfo(File file) {
        return InternalConfiguration.getFileMetaAccessor().mediaInfo(file);
    }

    public static void upload(AVIMFileMessage aVIMFileMessage, SaveCallback saveCallback) {
        aVIMFileMessage.upload(saveCallback);
    }
}

