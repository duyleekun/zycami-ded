/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.mlkit.common.internal.model;

import android.content.Context;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.internal.model.ModelUtils$ModelLoggingInfo;
import com.google.mlkit.common.model.LocalModel;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ModelUtils {
    private static final GmsLogger zza;

    static {
        GmsLogger gmsLogger;
        zza = gmsLogger = new GmsLogger("ModelUtils", "");
    }

    private ModelUtils() {
    }

    /*
     * Exception decompiling
     */
    public static ModelUtils$ModelLoggingInfo getModelLoggingInfo(Context var0, LocalModel var1_10) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 11[TRYBLOCK] [15, 14 : 229->232)] java.lang.Throwable
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

    /*
     * Exception decompiling
     */
    public static String getSHA256(File var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String zza(InputStream object) {
        String string2 = "ModelUtils";
        Object object2 = "SHA-256";
        try {
            int n10;
            char c10;
            char c11;
            object2 = MessageDigest.getInstance((String)object2);
            int n11 = 0x100000;
            Object object3 = new byte[n11];
            while (true) {
                c11 = ((InputStream)object).read((byte[])object3);
                c10 = '\uffffffff';
                n10 = 0;
                if (c11 == c10) break;
                ((MessageDigest)object2).update((byte[])object3, 0, c11);
            }
            object = ((MessageDigest)object2).digest();
            object2 = new StringBuilder();
            while (n10 < (n11 = ((Object)object).length)) {
                n11 = object[n10] & 0xFF;
                object3 = Integer.toHexString(n11);
                c11 = ((String)object3).length();
                if (c11 == (c10 = '\u0001')) {
                    c11 = '0';
                    ((StringBuilder)object2).append(c11);
                }
                ((StringBuilder)object2).append((String)object3);
                ++n10;
            }
            return ((StringBuilder)object2).toString();
        }
        catch (IOException iOException) {
            object = zza;
            object2 = "Failed to read model file";
            ((GmsLogger)object).e(string2, (String)object2);
            return null;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object = zza;
            object2 = "Do not have SHA-256 algorithm";
            ((GmsLogger)object).e(string2, (String)object2);
        }
        return null;
    }

    public static boolean zza(File object, String string2) {
        object = ModelUtils.getSHA256((File)object);
        GmsLogger gmsLogger = zza;
        String string3 = String.valueOf(object);
        int n10 = string3.length();
        String string4 = "Calculated hash value is: ";
        string3 = n10 != 0 ? string4.concat(string3) : new String(string4);
        gmsLogger.d("ModelUtils", string3);
        return string2.equals(object);
    }
}

