/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.z;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class y {
    public static final String[] a = new String[]{"jpg", "png", "bmp", "gif", "webp"};

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(File object) {
        void var0_3;
        InputStreamReader inputStreamReader;
        StringWriter stringWriter;
        block9: {
            InputStreamReader inputStreamReader2;
            Object object2;
            block8: {
                stringWriter = new StringWriter();
                inputStreamReader = null;
                object2 = new FileInputStream((File)object);
                Object object3 = new BufferedInputStream((InputStream)object2);
                inputStreamReader2 = new InputStreamReader((InputStream)object3);
                int n10 = 2048;
                try {
                    int n11;
                    int n12;
                    object3 = new char[n10];
                    while ((n12 = inputStreamReader2.read((char[])object3)) != (n11 = -1)) {
                        n11 = 0;
                        Object var9_15 = null;
                        stringWriter.write((char[])object3, 0, n12);
                    }
                    object = stringWriter.toString();
                }
                catch (IOException iOException) {
                    break block8;
                }
                y.a(inputStreamReader2);
                y.a(stringWriter);
                return object;
                catch (Throwable throwable) {
                    break block9;
                }
                catch (IOException iOException) {
                    inputStreamReader2 = null;
                }
            }
            try {
                void var4_10;
                object2 = new StringBuilder();
                String string2 = "read file :";
                ((StringBuilder)object2).append(string2);
                object = ((File)object).getAbsolutePath();
                ((StringBuilder)object2).append((String)object);
                object = " failure :";
                ((StringBuilder)object2).append((String)object);
                object = var4_10.getMessage();
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                b.c((String)object);
            }
            catch (Throwable throwable) {
                inputStreamReader = inputStreamReader2;
            }
            y.a(inputStreamReader2);
            y.a(stringWriter);
            return null;
        }
        y.a(inputStreamReader);
        y.a(stringWriter);
        throw var0_3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static void a(File file) {
        block5: {
            block4: {
                boolean bl2;
                block3: {
                    int n10;
                    bl2 = file.isDirectory();
                    if (!bl2) break block3;
                    File[] fileArray = file.listFiles();
                    for (int i10 = 0; i10 < (n10 = fileArray.length); ++i10) {
                        File file2 = fileArray[i10];
                        y.a(file2);
                    }
                    break block4;
                }
                bl2 = file.exists();
                if (!bl2) break block5;
            }
            file.delete();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(File var0, File var1_1) {
        block10: {
            block9: {
                var2_7 = null;
                var3_8 = new FileOutputStream((File)var0, false);
                var0 = new ZipOutputStream((OutputStream)var3_8);
                try {
                    y.a((ZipOutputStream)var0, (File)var1_1, null, null);
                }
                catch (Throwable var1_2) {
                    var2_7 = var0;
                    break block9;
                }
                catch (IOException var1_3) {
                    var2_7 = var0;
                    ** GOTO lbl-1000
                }
                catch (FileNotFoundException v0) {
                    var2_7 = var0;
                    break block10;
                }
                y.a((Closeable)var0);
                return;
                catch (Throwable var1_4) {
                    break block9;
                }
                catch (IOException var1_5) {
                    // empty catch block
                }
lbl-1000:
                // 2 sources

                {
                    var0 = new StringBuilder();
                    var3_8 = "zip file failure + ";
                    var0.append((String)var3_8);
                    var1_1 = var1_1.getMessage();
                    var0.append((String)var1_1);
                    var0 = var0.toString();
                    b.a((String)var0);
                    break block10;
                }
            }
            y.a(var2_7);
            throw var1_6;
            catch (FileNotFoundException v1) {}
        }
        y.a(var2_7);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(File var0, String var1_4) {
        block8: {
            var2_8 = var0.exists();
            if (!var2_8) {
                var3_9 = new StringBuilder();
                var3_9.append("mkdir ");
                var4_10 = var0.getAbsolutePath();
                var3_9.append((String)var4_10);
                b.c(var3_9.toString());
                var3_9 = var0.getParentFile();
                var3_9.mkdirs();
            }
            var2_8 = false;
            var3_9 = null;
            try {
                var6_12 = new FileOutputStream((File)var0);
                var5_11 = new OutputStreamWriter(var6_12);
                var4_10 = new BufferedWriter((Writer)var5_11);
            }
            catch (Throwable var0_2) {
                break block8;
            }
            catch (IOException var1_6) {
                // empty catch block
                ** GOTO lbl-1000
            }
            try {
                var4_10.write(var1_4);
            }
            catch (Throwable var0_1) {
                var3_9 = var4_10;
                break block8;
            }
            catch (IOException var1_5) {
                var3_9 = var4_10;
                ** GOTO lbl-1000
            }
            y.a((Closeable)var4_10);
            return;
lbl-1000:
            // 2 sources

            {
                var4_10 = new StringBuilder();
                var5_11 = "write file :";
                var4_10.append((String)var5_11);
                var0 = var0.getAbsolutePath();
                var4_10.append((String)var0);
                var0 = " failure :";
                var4_10.append((String)var0);
                var0 = var1_7.getMessage();
                var4_10.append((String)var0);
                var0 = var4_10.toString();
                b.c((String)var0);
            }
            y.a((Closeable)var3_9);
            return;
        }
        y.a((Closeable)var3_9);
        throw var0_3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(ZipOutputStream object, File object2, String object3, FileFilter object4) {
        void var0_5;
        Object object5;
        block18: {
            block17: {
                CharSequence charSequence = "";
                if (object3 == null) {
                    object3 = charSequence;
                }
                object5 = null;
                boolean bl2 = ((File)object2).isDirectory();
                int n10 = 0;
                if (bl2) {
                    int n11;
                    Object object6 = object4 != null ? ((File)object2).listFiles((FileFilter)object4) : ((File)object2).listFiles();
                    CharSequence charSequence2 = new StringBuilder();
                    ((StringBuilder)charSequence2).append((String)object3);
                    Object object7 = File.separator;
                    ((StringBuilder)charSequence2).append((String)object7);
                    charSequence2 = ((StringBuilder)charSequence2).toString();
                    Object object8 = new ZipEntry((String)charSequence2);
                    ((ZipOutputStream)object).putNextEntry((ZipEntry)object8);
                    int n12 = TextUtils.isEmpty((CharSequence)object3);
                    if (n12 == 0) {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append((String)object3);
                        ((StringBuilder)charSequence).append((String)object7);
                        charSequence = ((StringBuilder)charSequence).toString();
                    }
                    object3 = null;
                    for (n11 = 0; n11 < (n12 = ((File[])object6).length); object7 = ((File)object7).getName(), charSequence2 = ((StringBuilder)charSequence2).toString(), ++n11) {
                        object8 = object6[n11];
                        charSequence2 = new StringBuilder();
                        ((StringBuilder)charSequence2).append((String)charSequence);
                        object7 = object6[n11];
                        ((StringBuilder)charSequence2).append((String)object7);
                        y.a((ZipOutputStream)object, (File)object8, (String)charSequence2, null);
                    }
                    object3 = new z();
                    if ((object2 = ((File)object2).listFiles((FileFilter)object3)) != null) {
                        n11 = ((Object)object2).length;
                        while (n10 < n11) {
                            object6 = object2[n10];
                            object8 = new StringBuilder();
                            ((StringBuilder)object8).append((String)charSequence);
                            charSequence2 = File.separator;
                            ((StringBuilder)object8).append((String)charSequence2);
                            charSequence2 = ((File)object6).getName();
                            ((StringBuilder)object8).append((String)charSequence2);
                            object8 = ((StringBuilder)object8).toString();
                            y.a((ZipOutputStream)object, (File)object6, (String)object8, (FileFilter)object4);
                            ++n10;
                        }
                    }
                    break block17;
                }
                int n13 = TextUtils.isEmpty((CharSequence)object3);
                if (n13 == 0) {
                    object4 = new ZipEntry((String)object3);
                } else {
                    object3 = new Date();
                    charSequence = new StringBuilder();
                    long l10 = ((Date)object3).getTime();
                    object3 = String.valueOf(l10);
                    ((StringBuilder)charSequence).append((String)object3);
                    object3 = ".txt";
                    ((StringBuilder)charSequence).append((String)object3);
                    object3 = ((StringBuilder)charSequence).toString();
                    object4 = new ZipEntry((String)object3);
                }
                ((ZipOutputStream)object).putNextEntry((ZipEntry)object4);
                object3 = new FileInputStream((File)object2);
                int n14 = 1024;
                try {
                    int n15;
                    object2 = new byte[n14];
                    while ((n13 = ((FileInputStream)object3).read((byte[])object2)) != (n15 = -1)) {
                        ((ZipOutputStream)object).write((byte[])object2, 0, n13);
                    }
                }
                catch (IOException iOException) {}
                finally {
                    object5 = object3;
                    break block17;
                }
                catch (Throwable throwable) {
                    break block18;
                }
                catch (IOException iOException) {
                    // empty catch block
                }
                {
                    object2 = new StringBuilder();
                    object3 = "zipFiction failed with exception:";
                    ((StringBuilder)object2).append((String)object3);
                    object = ((Throwable)object).toString();
                    ((StringBuilder)object2).append((String)object);
                    object = ((StringBuilder)object2).toString();
                    b.d((String)object);
                }
            }
            y.a(object5);
            return;
        }
        y.a(object5);
        throw var0_5;
    }

    public static boolean a(File file) {
        block9: {
            boolean bl2;
            block8: {
                block7: {
                    try {
                        bl2 = file.isDirectory();
                        if (!bl2) break block7;
                        return false;
                    }
                    catch (Throwable throwable) {
                        throwable.printStackTrace();
                        return false;
                    }
                }
                bl2 = file.exists();
                if (!bl2) break block8;
                return true;
            }
            File file2 = file.getParentFile();
            boolean bl3 = file2.exists();
            if (bl3) break block9;
            bl2 = file2.mkdirs();
            if (bl2) break block9;
            return false;
        }
        return file.createNewFile();
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static byte[] a(byte[] object) {
        void var0_2;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        }
        catch (Exception exception) {
            return var0_2;
        }
        Object object2 = new GZIPOutputStream(byteArrayOutputStream);
        ((FilterOutputStream)object2).write((byte[])object);
        ((GZIPOutputStream)object2).finish();
        ((DeflaterOutputStream)object2).close();
        object2 = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        Object object3 = object2;
        return var0_2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void b(File object, File object2) {
        void var1_4;
        Object object3;
        block10: {
            Object object4;
            block11: {
                int n11;
                object3 = ((File)object).getAbsolutePath();
                boolean n10 = ((String)object3).equals(object4 = ((File)object2).getAbsolutePath());
                if (n10) {
                    return;
                }
                boolean bl2 = false;
                object3 = null;
                try {
                    object4 = new FileInputStream((File)object);
                }
                catch (Throwable throwable) {
                    object = null;
                    break block10;
                }
                try {
                    object = new FileOutputStream((File)object2);
                    n11 = 1024;
                }
                catch (Throwable throwable) {
                    object = null;
                    break block11;
                }
                try {
                    int n12;
                    object2 = new byte[n11];
                    while ((n12 = ((InputStream)object4).read((byte[])object2)) >= 0) {
                        ((OutputStream)object).write((byte[])object2, 0, n12);
                    }
                }
                catch (Throwable throwable) {
                    break block11;
                }
                ((InputStream)object4).close();
                ((OutputStream)object).close();
                return;
            }
            object3 = object4;
        }
        if (object3 != null) {
            ((InputStream)object3).close();
        }
        if (object != null) {
            ((OutputStream)object).close();
        }
        throw var1_4;
    }
}

