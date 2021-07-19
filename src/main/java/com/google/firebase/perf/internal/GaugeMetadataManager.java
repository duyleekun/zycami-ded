/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$MemoryInfo
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Process
 */
package com.google.firebase.perf.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Utils;

public class GaugeMetadataManager {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final ActivityManager activityManager;
    private final Context applicationContext;
    private final String currentProcessName;
    private final ActivityManager.MemoryInfo memoryInfo;
    private final Runtime runtime;

    public GaugeMetadataManager(Context context) {
        Runtime runtime = Runtime.getRuntime();
        this(runtime, context);
    }

    public GaugeMetadataManager(Runtime object, Context context) {
        this.runtime = object;
        this.applicationContext = context;
        object = (ActivityManager)context.getSystemService("activity");
        this.activityManager = object;
        this.memoryInfo = context;
        object.getMemoryInfo((ActivityManager.MemoryInfo)context);
        this.currentProcessName = object = this.getCurrentProcessName();
    }

    private String getCurrentProcessName() {
        int n10 = Process.myPid();
        Object object = this.activityManager.getRunningAppProcesses();
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)object.next();
                int n11 = runningAppProcessInfo.pid;
                if (n11 != n10) continue;
                return runningAppProcessInfo.processName;
            }
        }
        return this.applicationContext.getPackageName();
    }

    public int getDeviceRamSizeKb() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            StorageUnit storageUnit = StorageUnit.BYTES;
            long l10 = this.memoryInfo.totalMem;
            return Utils.saturatedIntCast(storageUnit.toKilobytes(l10));
        }
        return this.readTotalRAM("/proc/meminfo");
    }

    public int getMaxAppJavaHeapMemoryKb() {
        StorageUnit storageUnit = StorageUnit.BYTES;
        long l10 = this.runtime.maxMemory();
        return Utils.saturatedIntCast(storageUnit.toKilobytes(l10));
    }

    public int getMaxEncouragedAppJavaHeapMemoryKb() {
        StorageUnit storageUnit = StorageUnit.MEGABYTES;
        long l10 = this.activityManager.getMemoryClass();
        return Utils.saturatedIntCast(storageUnit.toKilobytes(l10));
    }

    public String getProcessName() {
        return this.currentProcessName;
    }

    /*
     * Exception decompiling
     */
    public int readTotalRAM(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [19[DOLOOP]], but top level block is 5[TRYBLOCK]
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
}

