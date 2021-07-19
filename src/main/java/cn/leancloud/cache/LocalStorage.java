/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.cache;

import cn.leancloud.cache.PersistenceUtil;
import cn.leancloud.utils.StringUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class LocalStorage {
    private String baseDir;
    private boolean disableLocalCache;

    public LocalStorage(String string2) {
        Object object = null;
        this.disableLocalCache = false;
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            boolean bl3;
            this.disableLocalCache = bl3 = true;
        } else {
            object = "/";
            boolean bl4 = string2.endsWith((String)object);
            if (!bl4) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append((String)object);
                string2 = stringBuilder.toString();
            }
            if (!(bl4 = ((File)(object = new File(string2))).exists())) {
                ((File)object).mkdirs();
            }
            this.baseDir = string2;
        }
    }

    public void clearAllCachedFiles() {
        boolean bl2 = this.disableLocalCache;
        if (bl2) {
            return;
        }
        this.clearCacheMoreThanDays(0);
    }

    public void clearCacheMoreThanDays(int n10) {
        boolean bl2 = this.disableLocalCache;
        if (bl2) {
            return;
        }
        long l10 = System.currentTimeMillis();
        if (n10 > 0) {
            long l11 = 86400000L;
            long l12 = (long)n10 * l11;
            l10 -= l12;
        }
        PersistenceUtil persistenceUtil = PersistenceUtil.sharedInstance();
        String string2 = this.baseDir;
        persistenceUtil.clearDir(string2, l10);
    }

    public void clearCachedFile(String string2) {
        boolean bl2 = this.disableLocalCache;
        if (!bl2 && !(bl2 = StringUtil.isEmpty(string2))) {
            Object object = new StringBuilder();
            String string3 = this.baseDir;
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            object = PersistenceUtil.sharedInstance();
            ((PersistenceUtil)object).deleteFile(string2);
        }
    }

    public File getCacheFile(String string2) {
        boolean bl2 = this.disableLocalCache;
        StringBuilder stringBuilder = null;
        if (bl2) {
            return null;
        }
        bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return null;
        }
        stringBuilder = new StringBuilder();
        String string3 = this.baseDir;
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        File file = new File(string2);
        return file;
    }

    public InputStream getInputStreamFromFile(File file) {
        boolean bl2 = this.disableLocalCache;
        if (bl2) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        return fileInputStream;
    }

    public byte[] readData(File file) {
        boolean bl2 = this.disableLocalCache;
        if (bl2) {
            return null;
        }
        return PersistenceUtil.sharedInstance().readContentBytesFromFile(file);
    }

    public byte[] readData(String string2) {
        boolean bl2 = this.disableLocalCache;
        String string3 = null;
        if (bl2) {
            return null;
        }
        bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return null;
        }
        Comparable<StringBuilder> comparable = new StringBuilder();
        string3 = this.baseDir;
        comparable.append(string3);
        comparable.append(string2);
        string2 = comparable.toString();
        comparable = new File(string2);
        return this.readData((File)comparable);
    }

    public String saveData(String string2, byte[] byArray) {
        boolean bl2 = this.disableLocalCache;
        Object object = null;
        if (bl2) {
            return null;
        }
        bl2 = StringUtil.isEmpty(string2);
        if (!bl2 && byArray != null) {
            Object object2 = new StringBuilder();
            object = this.baseDir;
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
            object2 = PersistenceUtil.sharedInstance();
            object = new File(string2);
            ((PersistenceUtil)object2).saveContentToFile(byArray, (File)object);
            return string2;
        }
        return null;
    }

    public String saveFile(String string2, File file) {
        boolean bl2 = this.disableLocalCache;
        if (bl2) {
            return null;
        }
        bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return null;
        }
        if (file != null && (bl2 = file.exists()) && (bl2 = file.isFile())) {
            Object object = new StringBuilder();
            String string3 = this.baseDir;
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            object = PersistenceUtil.sharedInstance();
            boolean bl3 = ((PersistenceUtil)object).saveFileToLocal(string2, file);
            if (bl3) {
                return string2;
            }
        }
        return null;
    }
}

