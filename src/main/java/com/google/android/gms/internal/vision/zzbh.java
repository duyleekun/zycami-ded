/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.util.Log
 */
package com.google.android.gms.internal.vision;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.internal.vision.zzas;
import com.google.android.gms.internal.vision.zzbe;
import com.google.android.gms.internal.vision.zzcy;
import java.io.File;

public final class zzbh {
    /*
     * Exception decompiling
     */
    private static zzbe zza(File var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[TRYBLOCK]], but top level block is 42[UNCONDITIONALDOLOOP]
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

    public static zzcy zzg(Context object) {
        boolean bl2;
        String string2 = Build.TYPE;
        String string3 = Build.TAGS;
        String string4 = "eng";
        boolean bl3 = string2.equals(string4);
        boolean bl4 = false;
        if ((bl3 || (bl2 = string2.equals(string4 = "userdebug"))) && ((bl2 = string3.contains(string2 = "dev-keys")) || (bl2 = string3.contains(string2 = "test-keys")))) {
            bl4 = true;
        }
        if (!bl4) {
            return zzcy.zzcb();
        }
        bl2 = zzas.zzu();
        if (bl2 && !(bl2 = object.isDeviceProtectedStorage())) {
            object = object.createDeviceProtectedStorageContext();
        }
        if (bl2 = ((zzcy)(object = zzbh.zzh((Context)object))).isPresent()) {
            return zzcy.zzb(zzbh.zza((File)((zzcy)object).get()));
        }
        return zzcy.zzcb();
    }

    /*
     * Enabled aggressive exception aggregation
     */
    private static zzcy zzh(Context object) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
        try {
            File file;
            StrictMode.allowThreadDiskWrites();
            try {
                String string2 = "phenotype_hermetic";
                object = object.getDir(string2, 0);
                string2 = "overrides.txt";
                file = new File((File)object, string2);
            }
            catch (RuntimeException runtimeException) {
                String string3 = "HermeticFileOverrides";
                String string4 = "no data dir";
                Log.e((String)string3, (String)string4, (Throwable)runtimeException);
                zzcy zzcy2 = zzcy.zzcb();
                StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
                return zzcy2;
            }
            boolean bl2 = file.exists();
            object = bl2 ? zzcy.zzb(file) : zzcy.zzcb();
            return object;
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
    }
}

