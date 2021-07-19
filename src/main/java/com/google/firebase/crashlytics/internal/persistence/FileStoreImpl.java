/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Environment
 */
package com.google.firebase.crashlytics.internal.persistence;

import android.content.Context;
import android.os.Environment;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;

public class FileStoreImpl
implements FileStore {
    public static final String FILES_PATH = ".com.google.firebase.crashlytics";
    private final Context context;

    public FileStoreImpl(Context context) {
        this.context = context;
    }

    public File getFilesDir() {
        File file = this.context.getFilesDir();
        File file2 = new File(file, FILES_PATH);
        return this.prepare(file2);
    }

    public String getFilesDirPath() {
        File file = this.context.getFilesDir();
        File file2 = new File(file, FILES_PATH);
        return file2.getPath();
    }

    public boolean isExternalStorageAvailable() {
        String string2 = "mounted";
        String string3 = Environment.getExternalStorageState();
        boolean bl2 = string2.equals(string3);
        if (!bl2) {
            Logger.getLogger().w("External Storage is not mounted and/or writable\nHave you declared android.permission.WRITE_EXTERNAL_STORAGE in the manifest?");
            return false;
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public File prepare(File object) {
        if (object != null) {
            boolean bl2 = ((File)object).exists();
            if (bl2 || (bl2 = ((File)object).mkdirs())) return object;
            object = Logger.getLogger();
            String string2 = "Couldn't create file";
            ((Logger)object).w(string2);
            return null;
        } else {
            object = Logger.getLogger();
            String string3 = "Null File";
            ((Logger)object).w(string3);
        }
        return null;
    }
}

