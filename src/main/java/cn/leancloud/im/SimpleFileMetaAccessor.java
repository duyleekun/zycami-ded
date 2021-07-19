/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.im.FileMetaAccessor;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SimpleFileMetaAccessor
implements FileMetaAccessor {
    public Map getImageMeta(File serializable) {
        serializable = new HashMap();
        return serializable;
    }

    public String getMimeType(String string2) {
        return null;
    }

    public Map mediaInfo(File serializable) {
        serializable = new HashMap();
        return serializable;
    }
}

