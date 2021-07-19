/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package com.google.android.gms.common.config;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.config.GservicesValue$zza;
import com.google.android.gms.common.config.zza;
import com.google.android.gms.common.config.zzb;
import com.google.android.gms.common.config.zzc;
import com.google.android.gms.common.config.zzd;
import com.google.android.gms.common.config.zze;
import java.util.Set;

public abstract class GservicesValue {
    private static final Object zzc;
    private static GservicesValue$zza zzd;
    private static int zze;
    private static Context zzf;
    private static Set zzg;
    public final String zza;
    public final Object zzb;
    private Object zzh = null;

    static {
        Object object;
        zzc = object = new Object();
    }

    public GservicesValue(String string2, Object object) {
        this.zza = string2;
        this.zzb = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean isInitialized() {
        Object object = zzc;
        synchronized (object) {
            return false;
        }
    }

    public static GservicesValue value(String string2, Float f10) {
        zzc zzc2 = new zzc(string2, f10);
        return zzc2;
    }

    public static GservicesValue value(String string2, Integer n10) {
        zzd zzd2 = new zzd(string2, n10);
        return zzd2;
    }

    public static GservicesValue value(String string2, Long l10) {
        zza zza2 = new zza(string2, l10);
        return zza2;
    }

    public static GservicesValue value(String string2, String string3) {
        zze zze2 = new zze(string2, string3);
        return zze2;
    }

    public static GservicesValue value(String string2, boolean bl2) {
        Boolean bl3 = bl2;
        zzb zzb2 = new zzb(string2, bl3);
        return zzb2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean zza() {
        Object object = zzc;
        synchronized (object) {
            return false;
        }
    }

    /*
     * Exception decompiling
     */
    public final Object get() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 4[TRYBLOCK] [8 : 57->60)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
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

    public final Object getBinderSafe() {
        return this.get();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void override(Object object) {
        String string2 = "GservicesValue";
        String string3 = "GservicesValue.override(): test should probably call initForTests() first";
        Log.w((String)string2, (String)string3);
        this.zzh = object;
        object = zzc;
        synchronized (object) {
            GservicesValue.zza();
            return;
        }
    }

    public void resetOverride() {
        this.zzh = null;
    }

    public abstract Object zza(String var1);
}

