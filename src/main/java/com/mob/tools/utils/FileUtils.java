/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.utils;

import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.FileUtils$1;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;

public class FileUtils {
    public static void closeIO(Closeable ... closeableArray) {
        if (closeableArray == null) {
            return;
        }
        for (Closeable closeable : closeableArray) {
            if (closeable == null) continue;
            try {
                closeable.close();
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.d(throwable);
            }
        }
    }

    public static boolean createFileByDeleteOldFile(File file) {
        if (file == null) {
            return false;
        }
        boolean bl2 = file.exists();
        if (bl2 && !(bl2 = file.delete())) {
            return false;
        }
        File file2 = file.getParentFile();
        bl2 = FileUtils.createOrExistsDir(file2);
        if (!bl2) {
            return false;
        }
        try {
            return file.createNewFile();
        }
        catch (Throwable throwable) {
            MobLog.getInstance().d(throwable);
            return false;
        }
    }

    public static boolean createOrExistsDir(File file) {
        boolean bl2;
        boolean bl3;
        if (file != null && ((bl3 = file.exists()) ? (bl2 = file.isDirectory()) : (bl2 = file.mkdirs()))) {
            bl2 = true;
        } else {
            bl2 = false;
            file = null;
        }
        return bl2;
    }

    public static boolean deleteAllInDir(File file) {
        FileUtils$1 fileUtils$1 = new FileUtils$1();
        return FileUtils.deleteFilesInDirWithFilter(file, fileUtils$1);
    }

    public static boolean deleteAllInDir(String string2) {
        return FileUtils.deleteAllInDir(FileUtils.getFileByPath(string2));
    }

    public static boolean deleteDir(File file) {
        int n10;
        if (file == null) {
            return false;
        }
        boolean bl2 = file.exists();
        if (!bl2) {
            return true;
        }
        bl2 = file.isDirectory();
        if (!bl2) {
            return false;
        }
        File[] fileArray = file.listFiles();
        if (fileArray != null && (n10 = fileArray.length) != 0) {
            for (File file2 : fileArray) {
                boolean bl3;
                boolean bl4 = file2.isFile();
                if (!(bl4 ? !(bl3 = file2.delete()) : (bl4 = file2.isDirectory()) && !(bl3 = FileUtils.deleteDir(file2)))) continue;
                return false;
            }
        }
        return file.delete();
    }

    public static boolean deleteFile(File file) {
        boolean bl2;
        boolean bl3;
        if (file != null && (!(bl3 = file.exists()) || (bl3 = file.isFile()) && (bl2 = file.delete()))) {
            bl2 = true;
        } else {
            bl2 = false;
            file = null;
        }
        return bl2;
    }

    public static boolean deleteFile(String string2) {
        return FileUtils.deleteFile(FileUtils.getFileByPath(string2));
    }

    public static boolean deleteFilesInDirWithFilter(File fileArray, FileFilter fileFilter) {
        if (fileArray == null) {
            return false;
        }
        int n10 = fileArray.exists();
        boolean bl2 = true;
        if (n10 == 0) {
            return bl2;
        }
        n10 = fileArray.isDirectory();
        if (n10 == 0) {
            return false;
        }
        if ((fileArray = fileArray.listFiles()) != null && (n10 = fileArray.length) != 0) {
            for (File file : fileArray) {
                boolean bl3;
                boolean bl4 = fileFilter.accept(file);
                if (!bl4 || !((bl4 = file.isFile()) ? !(bl3 = file.delete()) : (bl4 = file.isDirectory()) && !(bl3 = FileUtils.deleteDir(file)))) continue;
                return false;
            }
        }
        return bl2;
    }

    public static File getFileByPath(String object) {
        boolean bl2 = FileUtils.isSpace((String)object);
        if (bl2) {
            object = null;
        } else {
            File file = new File((String)object);
            object = file;
        }
        return object;
    }

    private static boolean isSpace(String string2) {
        boolean bl2 = true;
        if (string2 == null) {
            return bl2;
        }
        int n10 = string2.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl3 = Character.isWhitespace(string2.charAt(i10));
            if (bl3) continue;
            return false;
        }
        return bl2;
    }

    public static boolean rename(File file, String string2) {
        boolean bl2;
        boolean bl3 = false;
        if (file == null) {
            return false;
        }
        boolean bl4 = file.exists();
        if (!bl4) {
            return false;
        }
        bl4 = FileUtils.isSpace(string2);
        if (bl4) {
            return false;
        }
        Object object = file.getName();
        bl4 = string2.equals(object);
        boolean bl5 = true;
        if (bl4) {
            return bl5;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = file.getParent();
        stringBuilder.append(string3);
        string3 = File.separator;
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new File(string2);
        boolean bl6 = ((File)object).exists();
        if (!bl6 && (bl2 = file.renameTo((File)object))) {
            bl3 = bl5;
        }
        return bl3;
    }

    public static boolean rename(String string2, String string3) {
        return FileUtils.rename(FileUtils.getFileByPath(string2), string3);
    }
}

