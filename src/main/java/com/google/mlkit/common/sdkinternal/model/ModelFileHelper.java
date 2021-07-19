/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.google.mlkit.common.sdkinternal.model;

import android.os.Build;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.zzb;
import java.io.File;

public class ModelFileHelper {
    public static final int INVALID_INDEX = 255;
    private static final GmsLogger zza;
    private static final String zzb;
    private static final String zzc;
    private static final String zzd;
    private final MlKitContext zze;

    static {
        Object[] objectArray = new GmsLogger("ModelFileHelper", "");
        zza = objectArray;
        int n10 = 1;
        Object[] objectArray2 = new Object[n10];
        objectArray2[0] = "automl";
        String string2 = "com.google.mlkit.%s.models";
        zzb = String.format(string2, objectArray2);
        objectArray2 = new Object[n10];
        objectArray2[0] = "translate";
        zzc = String.format(string2, objectArray2);
        objectArray = new Object[n10];
        objectArray[0] = "base";
        zzd = String.format(string2, objectArray);
    }

    public ModelFileHelper(MlKitContext mlKitContext) {
        this.zze = mlKitContext;
    }

    private final File zza(String object, ModelType object2, boolean bl2) {
        block9: {
            block8: {
                boolean bl3;
                block7: {
                    bl3 = ((File)(object = this.getModelDirUnsafe((String)object, (ModelType)((Object)object2), bl2))).exists();
                    if (bl3) break block7;
                    object2 = zza;
                    String string2 = "model folder does not exist, creating one: ";
                    CharSequence charSequence = String.valueOf(((File)object).getAbsolutePath());
                    int n10 = ((String)charSequence).length();
                    if (n10 != 0) {
                        string2 = string2.concat((String)charSequence);
                    } else {
                        charSequence = new String(string2);
                        string2 = charSequence;
                    }
                    charSequence = "ModelFileHelper";
                    ((GmsLogger)object2).d((String)charSequence, string2);
                    bl3 = ((File)object).mkdirs();
                    if (!bl3) {
                        object = String.valueOf(object);
                        int n11 = String.valueOf(object).length() + 31;
                        charSequence = new StringBuilder(n11);
                        ((StringBuilder)charSequence).append("Failed to create model folder: ");
                        ((StringBuilder)charSequence).append((String)object);
                        object = ((StringBuilder)charSequence).toString();
                        object2 = new MlKitException((String)object, 13);
                        throw object2;
                    }
                    break block8;
                }
                bl3 = ((File)object).isDirectory();
                if (!bl3) break block9;
            }
            return object;
        }
        object = String.valueOf(object);
        int n12 = String.valueOf(object).length() + 71;
        StringBuilder stringBuilder = new StringBuilder(n12);
        stringBuilder.append("Can not create model folder, since an existing file has the same name: ");
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new MlKitException((String)object, 6);
        throw object2;
    }

    public void deleteAllModels(ModelType object, String string2) {
        synchronized (this) {
            boolean bl2 = false;
            File file = null;
            file = this.getModelDirUnsafe(string2, (ModelType)((Object)object), false);
            this.deleteRecursively(file);
            bl2 = true;
            object = this.getModelDirUnsafe(string2, (ModelType)((Object)object), bl2);
            this.deleteRecursively((File)object);
            return;
        }
    }

    public boolean deleteRecursively(File file) {
        boolean bl2;
        boolean bl3;
        if (file == null) {
            return false;
        }
        boolean bl4 = file.isDirectory();
        boolean bl5 = true;
        if (bl4) {
            File[] fileArray = (File[])Preconditions.checkNotNull(file.listFiles());
            int n10 = fileArray.length;
            bl3 = bl5;
            for (int i10 = 0; i10 < n10; ++i10) {
                File file2 = fileArray[i10];
                bl3 = bl3 && (bl3 = this.deleteRecursively(file2)) ? bl5 : false;
            }
        } else {
            bl3 = bl5;
        }
        if (bl3 && (bl2 = file.delete())) {
            return bl5;
        }
        return false;
    }

    public void deleteTempFilesInPrivateFolder(String object, ModelType object2) {
        boolean bl2 = true;
        boolean bl3 = this.deleteRecursively((File)(object = this.zza((String)object, (ModelType)((Object)object2), bl2)));
        if (!bl3) {
            object2 = zza;
            String string2 = "Failed to delete the temp labels file directory: ";
            object = object != null ? ((File)object).getAbsolutePath() : null;
            object = String.valueOf(object);
            int n10 = ((String)object).length();
            object = n10 != 0 ? string2.concat((String)object) : new String(string2);
            string2 = "ModelFileHelper";
            ((GmsLogger)object2).e(string2, (String)object);
        }
    }

    /*
     * WARNING - void declaration
     */
    public int getLatestCachedModelVersion(File fileArray) {
        int n10;
        fileArray = fileArray.listFiles();
        int n11 = -1;
        if (fileArray != null && (n10 = fileArray.length) != 0) {
            for (File file : fileArray) {
                Object object = file.getName();
                int n12 = Integer.parseInt((String)object);
                try {
                    n11 = Math.max(n11, n12);
                }
                catch (NumberFormatException numberFormatException) {
                    void var5_10;
                    object = zza;
                    String string2 = "Contains non-integer file name ";
                    String string3 = String.valueOf(file.getName());
                    int n13 = string3.length();
                    if (n13 != 0) {
                        String string4 = string2.concat(string3);
                    } else {
                        String string5 = new String(string2);
                    }
                    string2 = "ModelFileHelper";
                    ((GmsLogger)object).d(string2, (String)var5_10);
                }
            }
        }
        return n11;
    }

    public File getModelDir(String string2, ModelType modelType) {
        return this.zza(string2, modelType, false);
    }

    /*
     * Enabled aggressive block sorting
     */
    public File getModelDirUnsafe(String object, ModelType object2, boolean bl2) {
        Object object3 = com.google.mlkit.common.sdkinternal.model.zzb.zza;
        int n10 = ((Enum)object2).ordinal();
        int n11 = object3[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                n10 = 3;
                if (n11 != n10) {
                    object2 = ((Enum)object2).name();
                    int n12 = String.valueOf(object2).length() + 69;
                    object3 = new StringBuilder;
                    ((StringBuilder)object3)(n12);
                    ((StringBuilder)object3).append("Unknown model type ");
                    ((StringBuilder)object3).append((String)object2);
                    ((StringBuilder)object3).append(". Cannot find a dir to store the downloaded model.");
                    object2 = ((StringBuilder)object3).toString();
                    object = new IllegalArgumentException((String)object2);
                    throw object;
                }
                object2 = zzc;
            } else {
                object2 = zzb;
            }
        } else {
            object2 = zzd;
        }
        n11 = Build.VERSION.SDK_INT;
        n10 = 21;
        if (n11 >= n10) {
            object3 = new File;
            File file = this.zze.getApplicationContext().getNoBackupFilesDir();
            ((File)object3)(file, (String)object2);
        } else {
            object3 = this.zze.getApplicationContext();
            n10 = 0;
            Object var7_9 = null;
            object3 = object3.getDir((String)object2, 0);
        }
        if (!bl2) return new File((File)object3, (String)object);
        String string2 = "temp";
        object3 = object2 = new File((File)object3, string2);
        return new File((File)object3, (String)object);
    }

    public File getModelTempDir(String string2, ModelType modelType) {
        return this.zza(string2, modelType, true);
    }

    public File getTempFileInPrivateFolder(String object, ModelType object2, String string2) {
        object = this.zza((String)object, (ModelType)((Object)object2), true);
        boolean bl2 = ((File)object).exists();
        int n10 = 13;
        if (bl2 && (bl2 = ((File)object).isFile()) && !(bl2 = ((File)object).delete())) {
            string2 = "Failed to delete the temp labels file: ";
            int n11 = ((String)(object = String.valueOf(((File)object).getAbsolutePath()))).length();
            object = n11 != 0 ? string2.concat((String)object) : new String(string2);
            object2 = new MlKitException((String)object, n10);
            throw object2;
        }
        bl2 = ((File)object).exists();
        if (!bl2) {
            object2 = zza;
            String string3 = "Temp labels folder does not exist, creating one: ";
            String string4 = String.valueOf(((File)object).getAbsolutePath());
            int n12 = string4.length();
            string3 = n12 != 0 ? string3.concat(string4) : (string4 = new String(string3));
            string4 = "ModelFileHelper";
            ((GmsLogger)object2).d(string4, string3);
            bl2 = ((File)object).mkdirs();
            if (!bl2) {
                object = new MlKitException("Failed to create a directory to hold the AutoML model's labels file.", n10);
                throw object;
            }
        }
        object2 = new File((File)object, string2);
        return object2;
    }

    public boolean modelExistsLocally(String object, ModelType object2) {
        Object object3 = ModelType.UNKNOWN;
        if (object2 == object3) {
            return false;
        }
        if ((object = this.zza((String)object, (ModelType)((Object)object2))) == null) {
            return false;
        }
        object3 = new File((String)object);
        boolean bl2 = ((File)object3).exists();
        if (!bl2) {
            return false;
        }
        object = new File((File)object3, "model.tflite");
        Object object4 = ModelType.AUTOML;
        if (object2 != object4) {
            return ((File)object).exists();
        }
        bl2 = ((File)object).exists();
        if (bl2) {
            object = new File((File)object3, "labels.txt");
            object4 = "manifest.json";
            object2 = new File((File)object3, (String)object4);
            bl2 = ((File)object).exists();
            if (bl2 && (bl2 = ((File)object2).exists())) {
                return true;
            }
        }
        return false;
    }

    public final String zza(String object, ModelType modelType) {
        int n10;
        int n11 = this.getLatestCachedModelVersion((File)(object = this.getModelDir((String)object, modelType)));
        if (n11 == (n10 = -1)) {
            return null;
        }
        object = ((File)object).getAbsolutePath();
        n10 = String.valueOf(object).length() + 12;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append((String)object);
        stringBuilder.append("/");
        stringBuilder.append(n11);
        return stringBuilder.toString();
    }

    public final File zzb(String string2, ModelType modelType) {
        return this.zza(string2, modelType, true);
    }
}

