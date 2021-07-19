/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.data.a;
import com.xiaomi.push.y;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class e {
    private static PerfClientReport a(PerfClientReport perfClientReport, String object) {
        if (perfClientReport == null) {
            return null;
        }
        if ((object = (Object)e.a((String)object)) == null) {
            return null;
        }
        Object object2 = object[0];
        perfClientReport.perfCounts = (long)object2;
        object2 = object[1];
        perfClientReport.perfLatencies = (long)object2;
        return perfClientReport;
    }

    private static PerfClientReport a(String object) {
        PerfClientReport perfClientReport;
        block23: {
            perfClientReport = null;
            object = e.a((String)object);
            if (object == null) break block23;
            int n10 = ((String[])object).length;
            int n11 = 4;
            if (n10 < n11) break block23;
            n10 = 0;
            String string2 = null;
            String string3 = object[0];
            n11 = (int)(TextUtils.isEmpty((CharSequence)string3) ? 1 : 0);
            if (n11 != 0) break block23;
            n11 = 1;
            String string4 = object[n11];
            int n12 = TextUtils.isEmpty((CharSequence)string4);
            if (n12 != 0) break block23;
            n12 = 2;
            String string5 = object[n12];
            int n13 = TextUtils.isEmpty((CharSequence)string5);
            if (n13 != 0) break block23;
            n13 = 3;
            String string6 = object[n13];
            boolean bl2 = TextUtils.isEmpty((CharSequence)string6);
            if (bl2) break block23;
            perfClientReport = PerfClientReport.getBlankInstance();
            string2 = object[0];
            n10 = Integer.parseInt(string2);
            perfClientReport.production = n10;
            string2 = object[n11];
            perfClientReport.clientInterfaceId = string2;
            string2 = object[n12];
            n10 = Integer.parseInt(string2);
            perfClientReport.reportType = n10;
            object = object[n13];
            int n14 = Integer.parseInt((String)object);
            try {
                perfClientReport.code = n14;
            }
            catch (Exception exception) {
                object = "parse per key error";
                b.c((String)object);
            }
        }
        return perfClientReport;
    }

    public static String a(PerfClientReport perfClientReport) {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = perfClientReport.production;
        stringBuilder.append(n10);
        String string2 = "#";
        stringBuilder.append(string2);
        String string3 = perfClientReport.clientInterfaceId;
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        int n11 = perfClientReport.reportType;
        stringBuilder.append(n11);
        stringBuilder.append(string2);
        int n12 = perfClientReport.code;
        stringBuilder.append(n12);
        return stringBuilder.toString();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static HashMap a(String var0) {
        block9: {
            var1_6 = new HashMap<Object, String[]>();
            var2_7 = TextUtils.isEmpty((CharSequence)var0);
            if (var2_7 != 0) return var1_6;
            var3_8 = new File((String)var0);
            var2_7 = var3_8.exists();
            if (var2_7 == 0) {
                return var1_6;
            }
            var2_7 = 0;
            var3_8 = null;
            try {
                var5_10 = new FileReader((String)var0);
                var4_9 = new BufferedReader((Reader)var5_10);
            }
            catch (Throwable var0_3) {
                break block9;
            }
            catch (Exception var0_4) {
                // empty catch block
                ** GOTO lbl-1000
            }
            try {
                while ((var0 = var4_9.readLine()) != null) {
                    var3_8 = "%%%";
                    var2_7 = ((String[])(var0 = var0.split((String)var3_8))).length;
                    if (var2_7 < (var6_11 = 2)) continue;
                    var2_7 = 0;
                    var3_8 = null;
                    var5_10 = var0[0];
                    var6_11 = (int)TextUtils.isEmpty((CharSequence)var5_10);
                    if (var6_11 != 0 || (var8_13 = TextUtils.isEmpty((CharSequence)(var7_12 = var0[var6_11 = 1])))) continue;
                    var3_8 = var0[0];
                    var0 = var0[var6_11];
                    var1_6.put(var3_8, var0);
                }
            }
            catch (Throwable var0_1) {
                var3_8 = var4_9;
                break block9;
            }
            catch (Exception var0_2) {
                var3_8 = var4_9;
                ** GOTO lbl-1000
            }
            y.a(var4_9);
            return var1_6;
lbl-1000:
            // 2 sources

            {
                b.a((Throwable)var0);
            }
            y.a((Closeable)var3_8);
            return var1_6;
        }
        y.a((Closeable)var3_8);
        throw var0_5;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public static List a(Context object, String object2) {
        block59: {
            void var0_3;
            boolean bl2;
            BufferedReader bufferedReader;
            File file;
            Object object3;
            Object object4;
            block54: {
                block61: {
                    block60: {
                        block58: {
                            boolean bl3;
                            block55: {
                                block57: {
                                    block56: {
                                        Object object5;
                                        block53: {
                                            block52: {
                                                boolean bl4;
                                                object = new ArrayList();
                                                int n10 = TextUtils.isEmpty((CharSequence)object2);
                                                if (n10 != 0 || (n10 = ((File)(object4 = new File((String)object2))).exists()) == 0) break block59;
                                                n10 = 0;
                                                object4 = null;
                                                object3 = new StringBuilder();
                                                ((StringBuilder)object3).append((String)object2);
                                                object5 = ".lock";
                                                ((StringBuilder)object3).append((String)object5);
                                                object3 = ((StringBuilder)object3).toString();
                                                file = new File((String)object3);
                                                y.a(file);
                                                object5 = "rw";
                                                object3 = new RandomAccessFile(file, (String)object5);
                                                object5 = ((RandomAccessFile)object3).getChannel();
                                                object5 = ((FileChannel)object5).lock();
                                                Object object6 = new FileReader((String)object2);
                                                try {
                                                    bufferedReader = new BufferedReader((Reader)object6);
                                                }
                                                catch (Throwable throwable) {
                                                    bufferedReader = null;
                                                }
                                                while (true) {
                                                    object2 = bufferedReader.readLine();
                                                    if (object2 == null) break;
                                                    object4 = "%%%";
                                                    object2 = ((String)object2).split((String)object4);
                                                    n10 = ((String[])object2).length;
                                                    int n11 = 2;
                                                    if (n10 < n11) continue;
                                                    n10 = 0;
                                                    object4 = null;
                                                    object6 = object2[0];
                                                    n11 = (int)(TextUtils.isEmpty((CharSequence)object6) ? 1 : 0);
                                                    if (n11 != 0) continue;
                                                    n11 = 1;
                                                    String string2 = object2[n11];
                                                    boolean bl5 = TextUtils.isEmpty((CharSequence)string2);
                                                    if (bl5) continue;
                                                    object4 = object2[0];
                                                    object4 = e.a((String)object4);
                                                    object2 = object2[n11];
                                                    object2 = e.a((PerfClientReport)object4, (String)object2);
                                                    if (object2 == null) continue;
                                                    object2 = ((PerfClientReport)object2).toJsonString();
                                                    object.add(object2);
                                                    continue;
                                                    break;
                                                }
                                                if (object5 != null && (bl4 = ((FileLock)object5).isValid())) {
                                                    try {
                                                        ((FileLock)object5).release();
                                                    }
                                                    catch (IOException iOException) {
                                                        b.a(iOException);
                                                    }
                                                }
                                                y.a((Closeable)object3);
                                                y.a(bufferedReader);
                                                break block60;
                                                catch (Throwable throwable) {
                                                    break block52;
                                                }
                                                catch (Exception exception) {
                                                    break block53;
                                                }
                                            }
                                            object4 = object5;
                                            break block54;
                                            catch (Exception exception) {
                                                bufferedReader = null;
                                            }
                                        }
                                        object4 = object5;
                                        break block55;
                                        catch (Throwable throwable) {
                                            bufferedReader = null;
                                            break block54;
                                        }
                                        catch (Exception exception) {
                                            bufferedReader = null;
                                            break block55;
                                        }
                                        catch (Throwable throwable) {
                                            object3 = null;
                                            break block56;
                                        }
                                        catch (Exception exception) {
                                            object3 = null;
                                            break block57;
                                        }
                                        catch (Throwable throwable) {
                                            file = null;
                                            object3 = null;
                                        }
                                    }
                                    bufferedReader = null;
                                    break block54;
                                    catch (Exception exception) {
                                        file = null;
                                        object3 = null;
                                    }
                                }
                                bufferedReader = null;
                            }
                            b.a((Throwable)object2);
                            if (object4 == null || !(bl3 = ((FileLock)object4).isValid())) break block58;
                            try {
                                ((FileLock)object4).release();
                            }
                            catch (IOException iOException) {
                                b.a(iOException);
                            }
                        }
                        y.a((Closeable)object3);
                        y.a(bufferedReader);
                        if (file == null) break block61;
                    }
                    file.delete();
                }
                return object;
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            if (object4 != null && (bl2 = ((FileLock)object4).isValid())) {
                try {
                    ((FileLock)object4).release();
                }
                catch (IOException iOException) {
                    b.a(iOException);
                }
            }
            y.a((Closeable)object3);
            y.a(bufferedReader);
            if (file != null) {
                file.delete();
            }
            throw var0_3;
        }
        return object;
    }

    /*
     * Loose catch block
     */
    private static void a(String object, HashMap hashMap) {
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 == 0 && hashMap != null && (n10 = hashMap.size()) != 0) {
            BufferedWriter bufferedWriter;
            block27: {
                block25: {
                    block26: {
                        Object object2 = new File((String)object);
                        boolean bl2 = ((File)object2).exists();
                        if (bl2) {
                            ((File)object2).delete();
                        }
                        bl2 = false;
                        object = null;
                        Object object3 = new FileWriter((File)object2);
                        bufferedWriter = new BufferedWriter((Writer)object3);
                        object = hashMap.keySet();
                        try {
                            object = object.iterator();
                        }
                        catch (Exception exception) {
                            break block26;
                        }
                        while (true) {
                            n10 = (int)(object.hasNext() ? 1 : 0);
                            if (n10 == 0) break block25;
                            object2 = object.next();
                            object2 = (String)object2;
                            object3 = hashMap.get(object2);
                            object3 = (String)object3;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append((String)object2);
                            object2 = "%%%";
                            stringBuilder.append((String)object2);
                            stringBuilder.append((String)object3);
                            object2 = stringBuilder.toString();
                            bufferedWriter.write((String)object2);
                            bufferedWriter.newLine();
                            continue;
                            break;
                        }
                        catch (Throwable throwable) {
                            bufferedWriter = null;
                            object = throwable;
                            break block27;
                        }
                        catch (Exception exception) {
                            bufferedWriter = null;
                            object = exception;
                        }
                    }
                    try {
                        b.a((Throwable)object);
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                y.a(bufferedWriter);
                return;
            }
            y.a(bufferedWriter);
            throw object;
        }
    }

    /*
     * Exception decompiling
     */
    public static void a(String var0, a[] var1_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Nonsensical loop would be emitted - failure
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.LoopIdentifier.considerAsDoLoopStart(LoopIdentifier.java:438)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.LoopIdentifier.identifyLoops1(LoopIdentifier.java:65)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:676)
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
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static void a(HashMap var0, String var1_1, long var2_2, long var4_3) {
        block2: {
            var6_4 = (String)var0.get(var1_1);
            var7_5 = TextUtils.isEmpty((CharSequence)var6_4);
            var8_6 = "#";
            if (var7_5) {
                var6_4 = new StringBuilder();
lbl6:
                // 3 sources

                while (true) {
                    continue;
                    break;
                }
            }
            if ((var6_4 = (Object)e.a((String)var6_4)) == null) break block2;
            var7_5 = false;
            var10_8 = var6_4[0];
            var12_9 = 0L;
            cfr_temp_0 = var10_8 - var12_9;
            var14_10 = cfr_temp_0 == 0 ? 0 : (cfr_temp_0 < 0 ? -1 : 1);
            if (var14_10 <= 0 || (var17_12 = (cfr_temp_1 = (var15_11 = var6_4[var14_10 = (Object)true]) - var12_9) == 0 ? 0 : (cfr_temp_1 < 0 ? -1 : 1)) < 0) break block2;
            var18_13 = var6_4[0];
            var2_2 += var18_13;
            var10_8 = var6_4[var14_10];
            var4_3 += var10_8;
            var6_4 = new StringBuilder();
            ** GOTO lbl6
        }
        var6_4 = new StringBuilder();
        ** while (true)
        var6_4.append(var2_2);
        var6_4.append(var8_6);
        var6_4.append(var4_3);
        var9_7 = var6_4.toString();
        var0.put(var1_1, var9_7);
    }

    public static long[] a(String object) {
        long[] lArray;
        block11: {
            int n10 = 2;
            lArray = new long[n10];
            String string2 = "#";
            try {
                object = ((String)object).split(string2);
            }
            catch (Exception exception) {
                b.a(exception);
                return null;
            }
            int n11 = ((String[])object).length;
            if (n11 < n10) break block11;
            n10 = 0;
            string2 = object[0];
            string2 = string2.trim();
            long l10 = Long.parseLong(string2);
            lArray[0] = l10;
            n10 = 1;
            object = object[n10];
            object = ((String)object).trim();
            l10 = Long.parseLong((String)object);
            lArray[n10] = l10;
        }
        return lArray;
    }

    private static String[] a(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        return string2.split("#");
    }
}

