/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 */
package com.google.mlkit.common.sdkinternal.model;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import com.google.mlkit.common.sdkinternal.model.ModelValidator;
import com.google.mlkit.common.sdkinternal.model.RemoteModelFileMover;
import java.io.File;

public class RemoteModelFileManager {
    private static final GmsLogger zza;
    private final MlKitContext zzb;
    private final String zzc;
    private final ModelType zzd;
    private final ModelValidator zze;
    private final RemoteModelFileMover zzf;
    private final SharedPrefManager zzg;
    private final ModelFileHelper zzh;

    static {
        GmsLogger gmsLogger;
        zza = gmsLogger = new GmsLogger("RemoteModelFileManager", "");
    }

    public RemoteModelFileManager(MlKitContext object, RemoteModel object2, ModelValidator modelValidator, ModelFileHelper modelFileHelper, RemoteModelFileMover remoteModelFileMover) {
        ModelType modelType;
        this.zzb = object;
        this.zzd = modelType = ((RemoteModel)object2).getModelType();
        ModelType modelType2 = ModelType.TRANSLATE;
        object2 = modelType == modelType2 ? ((RemoteModel)object2).getModelNameForBackend() : ((RemoteModel)object2).getUniqueModelNameForPersist();
        this.zzc = object2;
        this.zze = modelValidator;
        this.zzg = object = SharedPrefManager.getInstance((MlKitContext)object);
        this.zzh = modelFileHelper;
        this.zzf = remoteModelFileMover;
    }

    public File getModelDirUnsafe(boolean bl2) {
        ModelFileHelper modelFileHelper = this.zzh;
        String string2 = this.zzc;
        ModelType modelType = this.zzd;
        return modelFileHelper.getModelDirUnsafe(string2, modelType, bl2);
    }

    /*
     * Exception decompiling
     */
    public File moveModelToPrivateFolder(ParcelFileDescriptor var1_1, String var2_6, RemoteModel var3_9) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [87[UNCONDITIONALDOLOOP]], but top level block is 17[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public final String zza() {
        synchronized (this) {
            Object object = this.zzh;
            String string2 = this.zzc;
            ModelType modelType = this.zzd;
            object = ((ModelFileHelper)object).zza(string2, modelType);
            return object;
        }
    }

    public final boolean zza(File file) {
        synchronized (this) {
            int n10;
            File[] fileArray;
            block14: {
                fileArray = this.zzh;
                String string2 = this.zzc;
                ModelType modelType = this.zzd;
                fileArray = fileArray.getModelDir(string2, modelType);
                n10 = fileArray.exists();
                modelType = null;
                if (n10 != 0) break block14;
                return false;
            }
            fileArray = fileArray.listFiles();
            n10 = fileArray.length;
            boolean bl2 = true;
            for (int i10 = 0; i10 < n10; ++i10) {
                File file2 = fileArray[i10];
                boolean bl3 = file2.equals(file);
                if (bl3) continue;
                ModelFileHelper modelFileHelper = this.zzh;
                boolean bl4 = modelFileHelper.deleteRecursively(file2);
                if (bl4) continue;
                bl2 = false;
            }
            return bl2;
        }
    }

    public final void zzb(File file) {
        synchronized (this) {
            int n10;
            File[] fileArray;
            ModelFileHelper modelFileHelper;
            block11: {
                modelFileHelper = null;
                fileArray = this.getModelDirUnsafe(false);
                n10 = fileArray.exists();
                if (n10 != 0) break block11;
                return;
            }
            fileArray = fileArray.listFiles();
            n10 = fileArray.length;
            for (int i10 = 0; i10 < n10; ++i10) {
                File file2 = fileArray[i10];
                boolean bl2 = file2.equals(file);
                if (!bl2) continue;
                modelFileHelper = this.zzh;
                modelFileHelper.deleteRecursively(file);
                return;
            }
            return;
        }
    }

    public final File zzc(File file) {
        synchronized (this) {
            block13: {
                boolean bl2;
                Object object;
                block12: {
                    Object object2 = this.zzh;
                    object = this.zzc;
                    ModelType modelType = this.zzd;
                    object2 = ((ModelFileHelper)object2).getModelDir((String)object, modelType);
                    object2 = ((File)object2).getAbsolutePath();
                    object2 = String.valueOf(object2);
                    object = "/0";
                    object2 = ((String)object2).concat((String)object);
                    object = new File((String)object2);
                    bl2 = ((File)object).exists();
                    if (!bl2) break block12;
                    return file;
                }
                bl2 = file.renameTo((File)object);
                if (!bl2) break block13;
                return object;
            }
            return file;
        }
    }
}

