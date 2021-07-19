/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l;

import d.v.e.l.s1;
import d.v.e.l.u1;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

public class p2 {
    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(File object) {
        void var1_4;
        FileInputStream fileInputStream;
        block21: {
            String string2;
            block26: {
                block27: {
                    FileInputStream fileInputStream2;
                    block20: {
                        block19: {
                            int n10;
                            int n11;
                            byte[] byArray;
                            int n12;
                            block18: {
                                string2 = "GBK";
                                n12 = 3;
                                byArray = new byte[n12];
                                n11 = 0;
                                fileInputStream = null;
                                fileInputStream2 = new FileInputStream((File)object);
                                object = new BufferedInputStream(fileInputStream2);
                                n11 = 0;
                                fileInputStream = null;
                                ((BufferedInputStream)object).mark(0);
                                n12 = ((BufferedInputStream)object).read(byArray, 0, n12);
                                n10 = -1;
                                if (n12 != n10) break block18;
                                u1.a(fileInputStream2);
                                u1.a((Closeable)object);
                                return string2;
                            }
                            try {
                                int n13;
                                int n14;
                                String string3;
                                block25: {
                                    int n15;
                                    block23: {
                                        block24: {
                                            block22: {
                                                n12 = byArray[0];
                                                string3 = "UTF-8";
                                                n14 = -2;
                                                n15 = 1;
                                                if (n12 != n10 || (n12 = byArray[n15]) != n14) break block22;
                                                string2 = "UTF-16LE";
                                                break block23;
                                            }
                                            n12 = byArray[0];
                                            if (n12 != n14 || (n12 = byArray[n15]) != n10) break block24;
                                            string2 = "UTF-16BE";
                                            break block23;
                                        }
                                        n12 = byArray[0];
                                        n14 = -17;
                                        if (n12 != n14 || (n12 = byArray[n15]) != (n14 = -69)) break block25;
                                        n12 = 2;
                                        n13 = -65;
                                        if ((n12 = byArray[n12]) != n13) break block25;
                                        string2 = string3;
                                    }
                                    n11 = n15;
                                }
                                ((BufferedInputStream)object).reset();
                                if (n11 == 0) {
                                    while ((n12 = ((BufferedInputStream)object).read()) != n10 && n12 < (n13 = 240)) {
                                        n13 = 191;
                                        n11 = 128;
                                        if (n11 <= n12 && n12 <= n13) break;
                                        n14 = 192;
                                        if (n14 <= n12 && n12 <= (n14 = 223)) {
                                            n12 = ((BufferedInputStream)object).read();
                                            if (n11 > n12 || n12 > n13) break;
                                            continue;
                                        }
                                        n14 = 224;
                                        if (n14 > n12 || n12 > (n14 = 239)) continue;
                                        n12 = ((BufferedInputStream)object).read();
                                        if (n11 > n12 || n12 > n13 || n11 > (n12 = ((BufferedInputStream)object).read()) || n12 > n13) break;
                                        string2 = string3;
                                        break;
                                    }
                                }
                                ((BufferedInputStream)object).close();
                            }
                            catch (Throwable throwable) {
                                break block19;
                            }
                            catch (Exception exception) {
                                break block20;
                            }
                            u1.a(fileInputStream2);
                            break block26;
                            catch (Throwable throwable) {
                                object = null;
                            }
                        }
                        fileInputStream = fileInputStream2;
                        break block21;
                        catch (Exception exception) {
                            object = null;
                        }
                    }
                    fileInputStream = fileInputStream2;
                    break block27;
                    catch (Throwable throwable) {
                        object = null;
                        break block21;
                    }
                    catch (Exception exception) {
                        object = null;
                    }
                }
                try {
                    void var12_19;
                    var12_19.printStackTrace();
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                u1.a(fileInputStream);
            }
            u1.a((Closeable)object);
            return string2;
        }
        u1.a(fileInputStream);
        u1.a((Closeable)object);
        throw var1_4;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean b(String string2, String object) {
        void var0_6;
        Object object2;
        Object object3;
        block25: {
            block26: {
                FileInputStream fileInputStream;
                block24: {
                    block23: {
                        Object object4;
                        int n10;
                        block22: {
                            object3 = ".zip";
                            n10 = ((String)object).endsWith((String)object3);
                            if (n10 == 0) {
                                return false;
                            }
                            object3 = new File(string2);
                            boolean bl2 = ((File)object3).exists();
                            if (!bl2) {
                                ((File)object3).mkdir();
                            }
                            n10 = 0;
                            object3 = null;
                            fileInputStream = new FileInputStream((String)object);
                            object4 = new BufferedInputStream(fileInputStream);
                            object = new ZipInputStream((InputStream)object4);
                            int n11 = 1024;
                            try {
                                object4 = new byte[n11];
                                break block22;
                            }
                            catch (Throwable throwable) {
                                object2 = object3;
                                break block23;
                            }
                            catch (IOException iOException) {
                                object2 = object3;
                                break block24;
                            }
                            catch (Throwable throwable) {
                                object = null;
                                boolean bl3 = false;
                                object2 = null;
                                break block23;
                            }
                            catch (IOException iOException) {
                                object = null;
                                boolean bl4 = false;
                                object2 = null;
                                break block24;
                            }
                            catch (Throwable throwable) {
                                object = null;
                                boolean bl5 = false;
                                object2 = null;
                                break block25;
                            }
                            catch (IOException iOException) {
                                object = null;
                                boolean bl6 = false;
                                object2 = null;
                                break block26;
                            }
                        }
                        while (true) {
                            CharSequence charSequence;
                            String string3;
                            object2 = ((ZipInputStream)object).getNextEntry();
                            int n12 = 1;
                            if (object2 != null) {
                                boolean bl7;
                                String string4;
                                string3 = ((java.util.zip.ZipEntry)object2).getName();
                                boolean bl8 = string3.contains(string4 = File.separator);
                                if (bl8) {
                                    int n13 = string3.indexOf(string4) + n12;
                                    string3 = string3.substring(n13);
                                }
                                if (bl7 = ((java.util.zip.ZipEntry)object2).isDirectory()) {
                                    charSequence = new StringBuilder();
                                    charSequence.append(string2);
                                    charSequence.append(string3);
                                    charSequence = charSequence.toString();
                                    object2 = new File((String)charSequence);
                                    ((File)object2).mkdirs();
                                    continue;
                                }
                            } else {
                                u1.a(fileInputStream);
                                u1.a((Closeable)object);
                                u1.a((Closeable)object3);
                                return n12 != 0;
                            }
                            charSequence = new StringBuilder();
                            charSequence.append(string2);
                            charSequence.append(string3);
                            charSequence = charSequence.toString();
                            object2 = new FileOutputStream((String)charSequence);
                            try {
                                while ((n10 = ((FilterInputStream)object).read((byte[])object4)) != (n12 = -1)) {
                                    ((FileOutputStream)object2).write((byte[])object4, 0, n10);
                                }
                                ((FileOutputStream)object2).close();
                                ((ZipInputStream)object).closeEntry();
                                object3 = object2;
                            }
                            catch (Throwable throwable) {
                                break;
                            }
                            catch (IOException iOException) {
                                break block24;
                            }
                        }
                    }
                    object3 = fileInputStream;
                    break block25;
                }
                object3 = fileInputStream;
            }
            try {
                void var0_8;
                var0_8.printStackTrace();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            u1.a((Closeable)object3);
            u1.a((Closeable)object);
            u1.a(object2);
            return false;
        }
        u1.a((Closeable)object3);
        u1.a((Closeable)object);
        u1.a(object2);
        throw var0_6;
    }

    /*
     * Unable to fully structure code
     */
    public static boolean c(String var0, String var1_11) {
        block48: {
            block49: {
                block47: {
                    var2_14 = 0;
                    var3_15 = null;
                    var4_16 = new File((String)var0);
                    var0 = p2.a((File)var4_16);
                    var5_17 = new ZipFile((File)var4_16, (String)var0);
                    var0 = var5_17.getEntries();
                    var6_18 = 1024;
                    var4_16 = new byte[var6_18];
                    var7_19 = null;
                    while (true) {
                        var8_20 = var0.hasMoreElements();
                        if (!var8_20) break block47;
                        var9_21 = var0.nextElement();
                        var9_21 = (ZipEntry)var9_21;
                        var11_23 = new StringBuilder();
                        var11_23.append(var1_11);
                        var12_24 = var9_21.getName();
                        var11_23.append(var12_24);
                        var11_23 = var11_23.toString();
                        var10_22 = new File((String)var11_23);
                        var13_25 = var9_21.isDirectory();
                        if (!var13_25) break;
                        var8_20 = var10_22.exists();
                        if (var8_20) continue;
                        var10_22.mkdirs();
                        continue;
                        break;
                    }
                    var12_24 = var10_22.getParent();
                    var11_23 = new File(var12_24);
                    var14_26 = var11_23.exists();
                    if (var14_26) ** GOTO lbl52
                    var11_23.mkdirs();
lbl52:
                    // 2 sources

                    var10_22.createNewFile();
                    var7_19 = var5_17.getInputStream((ZipEntry)var9_21);
                    var11_23 = new FileOutputStream(var10_22);
                    var9_21 = new BufferedOutputStream((OutputStream)var11_23);
                    try {
                        while ((var2_14 = var7_19.read((byte[])var4_16)) > 0) {
                            var9_21.write((byte[])var4_16, 0, var2_14);
                        }
                        var9_21.flush();
                        var9_21.close();
                    }
                    catch (IOException var0_2) {}
                    finally {
                        var3_15 = var9_21;
                        break block48;
                    }
                }
                var15_27 = true;
                u1.a(var3_15);
                u1.a(var7_19);
                try {
                    var5_17.close();
                }
                catch (IOException var1_12) {
                    var1_12.printStackTrace();
                }
                return var15_27;
                catch (IOException var0_3) {
                    break block49;
                }
                catch (Throwable var0_4) {
                    var7_19 = null;
                    break block48;
                }
                catch (IOException var0_5) {
                    var7_19 = null;
                    break block49;
                }
                catch (Throwable var0_6) {
                    var5_17 = null;
                    var7_19 = null;
                    break block48;
                }
                catch (IOException var0_7) {
                    var5_17 = null;
                    var7_19 = null;
                }
            }
            try {
                var0.printStackTrace();
            }
            catch (Throwable var0_9) {
                // empty catch block
            }
            u1.a(var3_15);
            u1.a(var7_19);
            if (var5_17 != null) {
                try {
                    var5_17.close();
                }
                catch (IOException var0_8) {
                    var0_8.printStackTrace();
                }
            }
            return false;
        }
        u1.a(var3_15);
        u1.a(var7_19);
        if (var5_17 != null) {
            try {
                var5_17.close();
            }
            catch (IOException var1_13) {
                var1_13.printStackTrace();
            }
        }
        throw var0_10;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public static boolean d(String object, String string2) {
        void var0_10;
        Object object2;
        ZipFile zipFile;
        Object object3;
        block52: {
            block53: {
                boolean bl2;
                block51: {
                    File file;
                    Object object4;
                    Object object5;
                    boolean bl3;
                    Object object6;
                    int n10;
                    block50: {
                        block49: {
                            n10 = 0;
                            object3 = null;
                            object6 = new File((String)object);
                            bl2 = ((File)object6).exists();
                            if (bl2) break block49;
                            u1.a(null);
                            u1.a(null);
                            return false;
                        }
                        object = p2.a((File)object6);
                        zipFile = new ZipFile((File)object6, (String)object);
                        object = zipFile.getEntries();
                        int n11 = 1024;
                        object6 = new byte[n11];
                        object2 = new File(string2);
                        bl3 = ((File)object2).exists();
                        if (bl3) break block50;
                        ((File)object2).mkdirs();
                    }
                    object2 = null;
                    while (true) {
                        boolean bl4;
                        bl3 = object.hasMoreElements();
                        if (!bl3) break block51;
                        object5 = object.nextElement();
                        object5 = (ZipEntry)object5;
                        object4 = ((ZipEntry)object5).getName();
                        object4 = s1.D((String)object4);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(string2);
                        stringBuilder.append((String)object4);
                        object4 = stringBuilder.toString();
                        file = new File((String)object4);
                        if (bl4 = ((ZipEntry)object5).isDirectory()) continue;
                        break;
                    }
                    file.createNewFile();
                    object2 = zipFile.getInputStream((ZipEntry)object5);
                    object4 = new FileOutputStream(file);
                    object5 = new BufferedOutputStream((OutputStream)object4);
                    try {
                        while ((n10 = ((InputStream)object2).read((byte[])object6)) > 0) {
                            ((BufferedOutputStream)object5).write((byte[])object6, 0, n10);
                        }
                        ((BufferedOutputStream)object5).flush();
                        ((FilterOutputStream)object5).close();
                    }
                    catch (IOException iOException) {}
                    finally {
                        object3 = object5;
                        break block52;
                    }
                }
                bl2 = true;
                u1.a(object3);
                u1.a((Closeable)object2);
                try {
                    zipFile.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                return bl2;
                catch (IOException iOException) {
                    break block53;
                }
                catch (Throwable throwable) {
                    object2 = null;
                    break block52;
                }
                catch (IOException iOException) {
                    object2 = null;
                    break block53;
                }
                catch (Throwable throwable) {
                    zipFile = null;
                    object2 = null;
                    break block52;
                }
                catch (IOException iOException) {
                    zipFile = null;
                    object2 = null;
                }
            }
            try {
                ((Throwable)object).printStackTrace();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            u1.a(object3);
            u1.a(object2);
            if (zipFile != null) {
                try {
                    zipFile.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            return false;
        }
        u1.a(object3);
        u1.a(object2);
        if (zipFile != null) {
            try {
                zipFile.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        throw var0_10;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String e(String string2) {
        void var0_13;
        ZipOutputStream zipOutputStream;
        BufferedOutputStream bufferedOutputStream;
        Object object;
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        block41: {
            FileInputStream fileInputStream2;
            block32: {
                block42: {
                    block31: {
                        block35: {
                            block38: {
                                block40: {
                                    boolean bl2;
                                    block30: {
                                        block34: {
                                            block37: {
                                                block39: {
                                                    block33: {
                                                        block36: {
                                                            fileInputStream = null;
                                                            if (string2 == null) {
                                                                return null;
                                                            }
                                                            Object object2 = new File(string2);
                                                            bl2 = ((File)object2).exists();
                                                            if (!bl2) {
                                                                return null;
                                                            }
                                                            fileInputStream2 = new FileInputStream((File)object2);
                                                            bufferedInputStream = new BufferedInputStream(fileInputStream2);
                                                            int n10 = 1024;
                                                            byte[] byArray = new byte[n10];
                                                            object = new StringBuilder();
                                                            ((StringBuilder)object).append(string2);
                                                            string2 = ".zip";
                                                            ((StringBuilder)object).append(string2);
                                                            string2 = ((StringBuilder)object).toString();
                                                            object = new File(string2);
                                                            boolean bl3 = ((File)object).exists();
                                                            if (bl3) {
                                                                ((File)object).delete();
                                                            }
                                                            object = new FileOutputStream(string2);
                                                            bufferedOutputStream = new BufferedOutputStream((OutputStream)object);
                                                            zipOutputStream = new ZipOutputStream(bufferedOutputStream);
                                                            try {
                                                                int n11;
                                                                int n12;
                                                                object2 = ((File)object2).getName();
                                                                java.util.zip.ZipEntry zipEntry = new java.util.zip.ZipEntry((String)object2);
                                                                zipOutputStream.putNextEntry(zipEntry);
                                                                while ((n12 = bufferedInputStream.read(byArray)) != (n11 = -1)) {
                                                                    n11 = 0;
                                                                    zipEntry = null;
                                                                    zipOutputStream.write(byArray, 0, n12);
                                                                    zipOutputStream.flush();
                                                                }
                                                            }
                                                            catch (IOException iOException) {
                                                                break block30;
                                                            }
                                                            catch (FileNotFoundException fileNotFoundException) {
                                                                break block31;
                                                            }
                                                            u1.a(fileInputStream2);
                                                            u1.a(bufferedInputStream);
                                                            u1.a((Closeable)object);
                                                            u1.a(bufferedOutputStream);
                                                            u1.a(zipOutputStream);
                                                            return string2;
                                                            catch (Throwable throwable) {
                                                                zipOutputStream = null;
                                                                break block32;
                                                            }
                                                            catch (IOException iOException) {
                                                                zipOutputStream = null;
                                                                break block30;
                                                            }
                                                            catch (FileNotFoundException fileNotFoundException) {
                                                                zipOutputStream = null;
                                                                break block31;
                                                            }
                                                            catch (Throwable throwable) {
                                                                bl3 = false;
                                                                bufferedOutputStream = null;
                                                                break block33;
                                                            }
                                                            catch (IOException iOException) {
                                                                bl3 = false;
                                                                bufferedOutputStream = null;
                                                                break block34;
                                                            }
                                                            catch (FileNotFoundException fileNotFoundException) {
                                                                bl3 = false;
                                                                bufferedOutputStream = null;
                                                                break block35;
                                                            }
                                                            catch (Throwable throwable) {
                                                                object = null;
                                                                break block36;
                                                            }
                                                            catch (IOException iOException) {
                                                                object = null;
                                                                break block37;
                                                            }
                                                            catch (FileNotFoundException fileNotFoundException) {
                                                                object = null;
                                                                break block38;
                                                            }
                                                            catch (Throwable throwable) {
                                                                bufferedInputStream = null;
                                                                object = null;
                                                            }
                                                        }
                                                        boolean bl4 = false;
                                                        bufferedOutputStream = null;
                                                    }
                                                    zipOutputStream = null;
                                                    break block32;
                                                    catch (IOException iOException) {
                                                        bufferedInputStream = null;
                                                        break block39;
                                                    }
                                                    catch (FileNotFoundException fileNotFoundException) {
                                                        bufferedInputStream = null;
                                                        break block40;
                                                    }
                                                    catch (Throwable throwable) {
                                                        bufferedInputStream = null;
                                                        object = null;
                                                        boolean bl5 = false;
                                                        bufferedOutputStream = null;
                                                        zipOutputStream = null;
                                                        break block41;
                                                    }
                                                    catch (IOException iOException) {
                                                        bl2 = false;
                                                        fileInputStream2 = null;
                                                        bufferedInputStream = null;
                                                    }
                                                }
                                                object = null;
                                            }
                                            boolean bl6 = false;
                                            bufferedOutputStream = null;
                                        }
                                        zipOutputStream = null;
                                    }
                                    ((Throwable)((Object)string2)).printStackTrace();
                                    break block42;
                                    catch (FileNotFoundException fileNotFoundException) {
                                        bl2 = false;
                                        fileInputStream2 = null;
                                        bufferedInputStream = null;
                                    }
                                }
                                object = null;
                            }
                            boolean bl7 = false;
                            bufferedOutputStream = null;
                        }
                        zipOutputStream = null;
                    }
                    try {
                        ((Throwable)((Object)string2)).printStackTrace();
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                u1.a(fileInputStream2);
                u1.a(bufferedInputStream);
                u1.a((Closeable)object);
                u1.a(bufferedOutputStream);
                u1.a(zipOutputStream);
                return null;
            }
            fileInputStream = fileInputStream2;
        }
        u1.a(fileInputStream);
        u1.a(bufferedInputStream);
        u1.a((Closeable)object);
        u1.a(bufferedOutputStream);
        u1.a(zipOutputStream);
        throw var0_13;
    }
}

