/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.CancellationSignal
 *  android.os.Process
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.util.Log
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TypefaceCompatUtil {
    private static final String CACHE_FILE_PREFIX = ".font";
    private static final String TAG = "TypefaceCompatUtil";

    private TypefaceCompatUtil() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public static ByteBuffer copyToDirectBuffer(Context object, Resources object2, int n10) {
        block5: {
            if ((object = TypefaceCompatUtil.getTempFile((Context)object)) == null) {
                return null;
            }
            boolean bl2 = TypefaceCompatUtil.copyToFile((File)object, object2, n10);
            if (bl2) break block5;
            ((File)object).delete();
            return null;
        }
        object2 = TypefaceCompatUtil.mmap((File)object);
        return object2;
        finally {
            ((File)object).delete();
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean copyToFile(File file, Resources object, int n10) {
        void var0_3;
        block4: {
            boolean bl2;
            try {
                object = object.openRawResource(n10);
            }
            catch (Throwable throwable) {
                object = null;
                break block4;
            }
            try {
                bl2 = TypefaceCompatUtil.copyToFile(file, (InputStream)object);
            }
            catch (Throwable throwable) {
                break block4;
            }
            TypefaceCompatUtil.closeQuietly((Closeable)object);
            return bl2;
        }
        TypefaceCompatUtil.closeQuietly((Closeable)object);
        throw var0_3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean copyToFile(File object, InputStream object2) {
        void var0_5;
        Object object3;
        StrictMode.ThreadPolicy threadPolicy;
        block8: {
            Object object4;
            block9: {
                int n10;
                threadPolicy = StrictMode.allowThreadDiskWrites();
                int n11 = 0;
                object3 = null;
                try {
                    object4 = new FileOutputStream((File)object, false);
                    n10 = 1024;
                }
                catch (Throwable throwable) {
                    break block8;
                }
                catch (IOException iOException) {
                    // empty catch block
                    break block9;
                }
                try {
                    int n12;
                    object = new byte[n10];
                    while ((n11 = ((InputStream)object2).read((byte[])object)) != (n12 = -1)) {
                        ((FileOutputStream)object4).write((byte[])object, 0, n11);
                    }
                }
                catch (Throwable throwable) {
                    object3 = object4;
                    break block8;
                }
                catch (IOException iOException) {
                    object3 = object4;
                    break block9;
                }
                TypefaceCompatUtil.closeQuietly((Closeable)object4);
                StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
                return true;
            }
            object2 = TAG;
            {
                object4 = new StringBuilder();
                String string2 = "Error copying resource contents to temp file: ";
                ((StringBuilder)object4).append(string2);
                object = ((Throwable)object).getMessage();
                ((StringBuilder)object4).append((String)object);
                object = ((StringBuilder)object4).toString();
                Log.e((String)object2, (String)object);
            }
            TypefaceCompatUtil.closeQuietly((Closeable)object3);
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
            return false;
        }
        TypefaceCompatUtil.closeQuietly(object3);
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        throw var0_5;
    }

    public static File getTempFile(Context object) {
        if ((object = object.getCacheDir()) == null) {
            return null;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append(CACHE_FILE_PREFIX);
        int n10 = Process.myPid();
        charSequence.append(n10);
        String string2 = "-";
        charSequence.append(string2);
        int n11 = Process.myTid();
        charSequence.append(n11);
        charSequence.append(string2);
        charSequence = charSequence.toString();
        string2 = null;
        for (n10 = 0; n10 < (n11 = 100); ++n10) {
            CharSequence charSequence2 = new StringBuilder();
            charSequence2.append((String)charSequence);
            charSequence2.append(n10);
            charSequence2 = charSequence2.toString();
            File file = new File((File)object, (String)charSequence2);
            try {
                boolean bl2 = file.createNewFile();
                if (!bl2) continue;
                return file;
            }
            catch (IOException iOException) {}
        }
        return null;
    }

    /*
     * Exception decompiling
     */
    public static ByteBuffer mmap(Context var0, CancellationSignal var1_2, Uri var2_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
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
     * Exception decompiling
     */
    private static ByteBuffer mmap(File var0) {
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

    public static Map readFontInfoIntoByteBuffer(Context context, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArray, CancellationSignal cancellationSignal) {
        HashMap<FontsContractCompat$FontInfo, ByteBuffer> hashMap = new HashMap<FontsContractCompat$FontInfo, ByteBuffer>();
        for (FontsContractCompat$FontInfo fontsContractCompat$FontInfo : fontsContractCompat$FontInfoArray) {
            int n10 = fontsContractCompat$FontInfo.getResultCode();
            if (n10 != 0 || (n10 = (int)(hashMap.containsKey(fontsContractCompat$FontInfo = fontsContractCompat$FontInfo.getUri()) ? 1 : 0)) != 0) continue;
            ByteBuffer byteBuffer = TypefaceCompatUtil.mmap(context, cancellationSignal, (Uri)fontsContractCompat$FontInfo);
            hashMap.put(fontsContractCompat$FontInfo, byteBuffer);
        }
        return Collections.unmodifiableMap(hashMap);
    }
}

