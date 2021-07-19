/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ai;
import com.xiaomi.push.hh;
import com.xiaomi.push.hi$a;
import com.xiaomi.push.hl;
import com.xiaomi.push.service.bj;
import com.xiaomi.push.y;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class hi {
    private static boolean a = false;

    private static void a(Context object) {
        StringBuilder stringBuilder = new StringBuilder();
        object = object.getFilesDir();
        stringBuilder.append(object);
        stringBuilder.append("/tdReadTemp");
        object = stringBuilder.toString();
        File file = new File((String)object);
        boolean bl2 = file.exists();
        if (!bl2) {
            file.mkdirs();
        }
    }

    public static void a(Context context, hl hl2) {
        ai ai2 = ai.a(context);
        hi$a hi$a = new hi$a(context, hl2);
        ai2.a(hi$a);
    }

    /*
     * Exception decompiling
     */
    private static void a(Context var0, hl var1_6, File var2_7, byte[] var3_8) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 35[TRYBLOCK] [82 : 452->456)] java.lang.Throwable
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

    private static void b(Context context) {
        context = context.getSharedPreferences("mipush_extra", 4).edit();
        long l10 = System.currentTimeMillis() / 1000L;
        context.putLong("last_tiny_data_upload_timestamp", l10);
        context.commit();
    }

    public static /* synthetic */ void b(Context context, hl hl2) {
        hi.c(context, hl2);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    private static void c(Context context, hl hl2) {
        String string2 = "/";
        String string3 = "/tdReadTemp";
        boolean bl2 = a;
        if (!bl2) {
            void var0_3;
            boolean bl3;
            Object object;
            Object object2;
            block33: {
                Object object3;
                String string4;
                File file;
                String string5;
                Object object4;
                block30: {
                    block31: {
                        block32: {
                            a = bl2 = true;
                            object4 = context.getFilesDir();
                            string5 = "tiny_data.data";
                            file = new File((File)object4, string5);
                            boolean bl4 = file.exists();
                            string4 = "TinyData no ready file to get data.";
                            if (!bl4) {
                                b.a(string4);
                                return;
                            }
                            hi.a(context);
                            object4 = bj.a(context);
                            object2 = null;
                            object = context.getFilesDir();
                            CharSequence charSequence = "tiny_data.lock";
                            object3 = new File((File)object, (String)charSequence);
                            y.a((File)object3);
                            charSequence = "rw";
                            object = new RandomAccessFile((File)object3, (String)charSequence);
                            object3 = ((RandomAccessFile)object).getChannel();
                            object2 = ((FileChannel)object3).lock();
                            charSequence = new StringBuilder();
                            File file2 = context.getFilesDir();
                            ((StringBuilder)charSequence).append(file2);
                            ((StringBuilder)charSequence).append(string3);
                            ((StringBuilder)charSequence).append(string2);
                            ((StringBuilder)charSequence).append(string5);
                            charSequence = ((StringBuilder)charSequence).toString();
                            object3 = new File((String)charSequence);
                            file.renameTo((File)object3);
                            if (object2 == null || !(bl2 = ((FileLock)object2).isValid())) break block30;
                            try {
                                ((FileLock)object2).release();
                                break block30;
                            }
                            catch (IOException iOException) {
                                break block31;
                            }
                            catch (Exception exception) {
                                break block32;
                            }
                            catch (Throwable throwable) {
                                object = null;
                                break block33;
                            }
                            catch (Exception exception) {
                                object = null;
                            }
                        }
                        b.a((Throwable)((Object)file));
                        if (object2 == null || !(bl2 = ((FileLock)object2).isValid())) break block30;
                        try {
                            ((FileLock)object2).release();
                            break block30;
                        }
                        catch (IOException iOException) {
                            // empty catch block
                        }
                    }
                    b.a((Throwable)((Object)file));
                }
                y.a((Closeable)object);
                object2 = new StringBuilder();
                object3 = context.getFilesDir();
                ((StringBuilder)object2).append(object3);
                ((StringBuilder)object2).append(string3);
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(string5);
                string2 = ((StringBuilder)object2).toString();
                file = new File(string2);
                boolean bl5 = file.exists();
                if (!bl5) {
                    b.a(string4);
                    return;
                }
                hi.a(context, hl2, file, (byte[])object4);
                hh.a(false);
                hi.b(context);
                a = false;
                return;
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            if (object2 != null && (bl3 = ((FileLock)object2).isValid())) {
                try {
                    ((FileLock)object2).release();
                }
                catch (IOException iOException) {
                    b.a(iOException);
                }
            }
            y.a((Closeable)object);
            throw var0_3;
        }
        b.a("TinyData extractTinyData is running");
    }
}

