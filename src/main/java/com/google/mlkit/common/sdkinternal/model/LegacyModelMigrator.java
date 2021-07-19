/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package com.google.mlkit.common.sdkinternal.model;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import com.google.mlkit.common.sdkinternal.model.zza;
import java.io.File;
import java.util.concurrent.Executor;

public abstract class LegacyModelMigrator {
    public final ModelFileHelper modelFileHelper;
    private final TaskCompletionSource zza;
    private final Context zzb;
    private final Executor zzc;

    public LegacyModelMigrator(Context object, ModelFileHelper modelFileHelper) {
        TaskCompletionSource taskCompletionSource;
        this.zza = taskCompletionSource = new TaskCompletionSource();
        this.zzb = object;
        this.modelFileHelper = modelFileHelper;
        object = MLTaskExecutor.workerThreadExecutor();
        this.zzc = object;
    }

    public static void deleteIfEmpty(File object) {
        int n10;
        Object object2 = ((File)object).listFiles();
        if (object2 != null && (n10 = ((File[])(object2 = ((File)object).listFiles())).length) != 0) {
            return;
        }
        boolean bl2 = ((File)object).delete();
        if (!bl2) {
            object = String.valueOf(object);
            int n11 = String.valueOf(object).length() + 31;
            StringBuilder stringBuilder = new StringBuilder(n11);
            stringBuilder.append("Error deleting model directory ");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            object2 = "MlKitLegacyMigration";
            Log.e((String)object2, (String)object);
        }
    }

    public static boolean isValidFirebasePersistenceKey(String object) {
        boolean bl2;
        String string2 = "\\+";
        boolean bl3 = ((String[])(object = object.split(string2, -1))).length;
        if (bl3 != (bl2 = 2 != 0)) {
            return false;
        }
        try {
            string2 = object[0];
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return false;
        }
        Base64Utils.decodeUrlSafeNoPadding(string2);
        bl3 = true;
        object = object[bl3];
        Base64Utils.decodeUrlSafeNoPadding((String)object);
        return bl3;
    }

    public static void migrateFile(File object, File object2) {
        int n10;
        CharSequence charSequence;
        boolean bl2 = ((File)object).exists();
        if (!bl2) {
            return;
        }
        bl2 = ((File)object2).exists();
        String string2 = "MlKitLegacyMigration";
        if (!bl2 && !(bl2 = ((File)object).renameTo((File)object2))) {
            charSequence = String.valueOf(object);
            object2 = String.valueOf(object2);
            int n11 = String.valueOf(charSequence).length() + 28;
            int n12 = String.valueOf(object2).length();
            StringBuilder stringBuilder = new StringBuilder(n11 += n12);
            String string3 = "Error moving model file ";
            stringBuilder.append(string3);
            stringBuilder.append((String)charSequence);
            charSequence = " to ";
            stringBuilder.append((String)charSequence);
            stringBuilder.append((String)object2);
            object2 = stringBuilder.toString();
            Log.e((String)string2, (String)object2);
        }
        if ((n10 = ((File)object).exists()) != 0 && (n10 = ((File)object).delete()) == 0) {
            object = String.valueOf(object);
            n10 = String.valueOf(object).length() + 26;
            charSequence = new StringBuilder(n10);
            object2 = "Error deleting model file ";
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            Log.e((String)string2, (String)object);
        }
    }

    public abstract String getLegacyModelDirName();

    public File getLegacyRootDir() {
        File file;
        String string2 = this.getLegacyModelDirName();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            File file2 = this.zzb.getNoBackupFilesDir();
            file = new File(file2, string2);
        } else {
            file = this.zzb.getApplicationContext();
            n11 = 0;
            Object var5_6 = null;
            file = file.getDir(string2, 0);
        }
        return file;
    }

    public Task getMigrationTask() {
        return this.zza.getTask();
    }

    public abstract void migrateAllModelDirs(File var1);

    public void start() {
        Executor executor = this.zzc;
        zza zza2 = new zza(this);
        executor.execute(zza2);
    }

    public final /* synthetic */ void zza() {
        File file = this.getLegacyRootDir();
        File[] fileArray = file.listFiles();
        if (fileArray != null) {
            for (File file2 : fileArray) {
                this.migrateAllModelDirs(file2);
            }
            LegacyModelMigrator.deleteIfEmpty(file);
        }
        this.zza.setResult(null);
    }
}

