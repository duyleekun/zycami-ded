/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import java.io.File;
import java.util.Map;

public interface FileMetaAccessor {
    public Map getImageMeta(File var1);

    public String getMimeType(String var1);

    public Map mediaInfo(File var1);
}

