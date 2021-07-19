/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.cache;

import cn.leancloud.cache.LocalStorage;
import cn.leancloud.codec.MDFive;
import cn.leancloud.core.AppConfiguration;
import java.io.File;

public class FileCache
extends LocalStorage {
    private static FileCache INSTANCE;
    private static final int MAX_FILE_BUF_SIZE = 0x400000;

    private FileCache() {
        String string2 = AppConfiguration.getFileCacheDir();
        super(string2);
    }

    public static FileCache getIntance() {
        Class<FileCache> clazz = FileCache.class;
        synchronized (clazz) {
            FileCache fileCache = INSTANCE;
            if (fileCache == null) {
                INSTANCE = fileCache = new FileCache();
            }
            fileCache = INSTANCE;
            return fileCache;
        }
    }

    public File getCacheFile(String object) {
        String string2 = "UTF-8";
        try {
            object = ((String)object).getBytes(string2);
        }
        catch (Exception exception) {
            return null;
        }
        object = MDFive.computeMD5((byte[])object);
        return super.getCacheFile((String)object);
    }

    public String saveLocalFile(String string2, File file) {
        return super.saveFile(string2, file);
    }
}

