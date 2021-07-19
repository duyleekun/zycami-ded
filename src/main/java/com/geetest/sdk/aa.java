/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import com.geetest.sdk.ai;
import com.geetest.sdk.ap;
import com.geetest.sdk.y;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public final class aa {
    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(File object, String object2, String string2, String string3) {
        Object object3;
        block30: {
            block28: {
                block31: {
                    void var1_9;
                    block32: {
                        FileInputStream fileInputStream;
                        block29: {
                            int n10;
                            block26: {
                                byte[] byArray;
                                Object object4;
                                block27: {
                                    int n11;
                                    int n12;
                                    int n13 = 0;
                                    object3 = null;
                                    fileInputStream = new FileInputStream((File)object);
                                    n10 = 4096;
                                    Object object5 = new byte[n10];
                                    int n14 = fileInputStream.read((byte[])object5, 0, n10);
                                    int n15 = 6;
                                    if (n14 <= n15 || (n12 = object5[0]) != (n11 = 13)) break block26;
                                    n12 = 4;
                                    object4 = new byte[n12];
                                    int n16 = 1;
                                    System.arraycopy(object5, n16, object4, 0, n12);
                                    n12 = ap.a(object4);
                                    object4 = new StringBuilder;
                                    object4();
                                    String string4 = "[ flushCacheFile ] Header size: ";
                                    object4.append(string4);
                                    object4.append(n12);
                                    object4 = object4.toString();
                                    ai.a((String)object4);
                                    n11 = n12 + 5;
                                    n11 = object5[n11];
                                    n16 = 14;
                                    if (n11 != n16) break block26;
                                    object4 = new byte[n12];
                                    n16 = 5;
                                    System.arraycopy(object5, n16, object4, 0, n12);
                                    String string5 = new String((byte[])object4);
                                    string4 = new JSONObject(string5);
                                    object4 = "name";
                                    object4 = string4.getString((String)object4);
                                    n16 = n12 + 6;
                                    if (n14 <= n16) break block26;
                                    n12 = n14 - n12 - n15;
                                    byArray = new byte[n12];
                                    System.arraycopy(object5, n16, byArray, 0, n12);
                                    if (n14 != n10) break block27;
                                    object = new ByteArrayOutputStream();
                                    try {
                                        ((OutputStream)object).write(byArray);
                                        while ((n13 = fileInputStream.read((byte[])object5)) > 0) {
                                            ((ByteArrayOutputStream)object).write((byte[])object5, 0, n13);
                                        }
                                        object3 = ((ByteArrayOutputStream)object).toByteArray();
                                        object5 = new File;
                                        object5((String)object2, (String)object4);
                                        aa.a((byte[])object3, (File)object5, string2, string3);
                                        object3 = object;
                                        break block26;
                                    }
                                    catch (Throwable throwable) {
                                        object3 = fileInputStream;
                                        break block28;
                                    }
                                    catch (Exception exception) {
                                        break block29;
                                    }
                                }
                                object = new File((String)object2, (String)object4);
                                aa.a(byArray, (File)object, string2, string3);
                            }
                            try {
                                fileInputStream.close();
                            }
                            catch (IOException iOException) {
                                iOException.printStackTrace();
                            }
                            if (object3 == null) return;
                            ((ByteArrayOutputStream)object3).close();
                            return;
                            catch (Throwable throwable) {
                                object2 = null;
                                object3 = fileInputStream;
                                break block30;
                            }
                            catch (Exception exception) {
                                n10 = 0;
                                object = null;
                            }
                        }
                        object3 = fileInputStream;
                        break block32;
                        catch (Throwable throwable) {
                            object2 = null;
                            break block30;
                        }
                        catch (Exception exception) {
                            boolean bl2 = false;
                            object = null;
                        }
                    }
                    var1_9.printStackTrace();
                    if (object3 == null) break block31;
                    try {
                        ((FileInputStream)object3).close();
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
                if (object == null) return;
                try {
                    ((ByteArrayOutputStream)object).close();
                    return;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                return;
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            Object object6 = object2;
            object2 = object;
            object = object6;
        }
        if (object3 != null) {
            try {
                ((FileInputStream)object3).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        if (object2 == null) throw object;
        try {
            ((ByteArrayOutputStream)object2).close();
            throw object;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        throw object;
    }

    public static void a(File file, byte[] byArray) {
        aa.a(file, byArray, false);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(File var0, byte[] var1_7, boolean var2_9) {
        block12: {
            block13: {
                var3_10 = null;
                var4_11 = new FileOutputStream(var0, var2_9);
                var4_11.write(var1_7);
                var4_11.flush();
                try {}
                catch (IOException var0_5) {
                    var0_5.printStackTrace();
                    return;
                }
                break block13;
                catch (Throwable var0_3) {
                    break block12;
                }
                catch (Exception var0_4) {
                    // empty catch block
                    ** GOTO lbl-1000
                }
                catch (Throwable var0_1) {
                    var3_10 = var4_11;
                    break block12;
                }
                catch (Exception var0_2) {
                    var3_10 = var4_11;
                    ** GOTO lbl-1000
                }
            }
            var4_11.close();
            return;
lbl-1000:
            // 2 sources

            {
                var0.printStackTrace();
                if (var3_10 == null) return;
            }
            {
                var3_10.close();
                return;
            }
        }
        if (var3_10 == null) throw var0_6;
        try {
            var3_10.close();
            throw var0_6;
        }
        catch (IOException var1_8) {
            var1_8.printStackTrace();
        }
        throw var0_6;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public static void a(byte[] byArray, File object, String object2, String object3) {
        void var0_15;
        GZIPOutputStream gZIPOutputStream;
        Object object4;
        block46: {
            ByteArrayOutputStream byteArrayOutputStream;
            block45: {
                block44: {
                    block42: {
                        block49: {
                            block47: {
                                block48: {
                                    block43: {
                                        object4 = null;
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                                        gZIPOutputStream.write(byArray);
                                        gZIPOutputStream.close();
                                        byArray = byteArrayOutputStream.toByteArray();
                                        object2 = ((String)object2).getBytes();
                                        object3 = ((String)object3).getBytes();
                                        byArray = y.a(byArray, (byte[])object2, (byte[])object3);
                                        object2 = new FileOutputStream((File)object);
                                        ((FileOutputStream)object2).write(byArray);
                                        ((OutputStream)object2).flush();
                                        try {
                                            byteArrayOutputStream.close();
                                        }
                                        catch (IOException iOException) {
                                            iOException.printStackTrace();
                                        }
                                        try {
                                            gZIPOutputStream.close();
                                        }
                                        catch (IOException iOException) {
                                            iOException.printStackTrace();
                                        }
                                        ((FileOutputStream)object2).close();
                                        catch (Throwable throwable) {
                                            break block42;
                                        }
                                        catch (Exception exception) {
                                            break block43;
                                        }
                                        catch (Throwable throwable) {
                                            break block44;
                                        }
                                        catch (Exception exception) {
                                            object2 = null;
                                            break block43;
                                        }
                                        catch (Throwable throwable) {
                                            object = null;
                                            gZIPOutputStream = null;
                                            break block45;
                                        }
                                        catch (Exception exception) {
                                            object2 = null;
                                            gZIPOutputStream = null;
                                        }
                                    }
                                    object4 = byteArrayOutputStream;
                                    break block48;
                                    catch (Throwable throwable) {
                                        object = null;
                                        gZIPOutputStream = null;
                                        break block46;
                                    }
                                    catch (Exception exception) {
                                        object2 = null;
                                        gZIPOutputStream = null;
                                    }
                                }
                                byArray.printStackTrace();
                                if (object4 == null) break block47;
                                try {
                                    ((ByteArrayOutputStream)object4).close();
                                }
                                catch (IOException iOException) {
                                    iOException.printStackTrace();
                                }
                            }
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                }
                                catch (IOException iOException) {
                                    iOException.printStackTrace();
                                }
                            }
                            if (object2 == null) break block49;
                            try {
                                ((FileOutputStream)object2).close();
                            }
                            catch (IOException iOException) {
                                iOException.printStackTrace();
                            }
                        }
                        return;
                        catch (Throwable throwable) {
                            byteArrayOutputStream = object4;
                        }
                    }
                    object4 = object2;
                }
                object = object4;
            }
            object4 = byteArrayOutputStream;
        }
        if (object4 != null) {
            try {
                ((ByteArrayOutputStream)object4).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        if (gZIPOutputStream != null) {
            try {
                gZIPOutputStream.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        if (object != null) {
            try {
                ((FileOutputStream)object).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        throw var0_15;
    }
}

