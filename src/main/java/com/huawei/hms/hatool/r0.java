/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.o0;
import com.huawei.hms.hatool.y;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;

public final class r0 {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(File object) {
        void var0_3;
        Object object2;
        block13: {
            String string2;
            String string3;
            block15: {
                block14: {
                    FileInputStream fileInputStream;
                    block12: {
                        int n10;
                        int n11;
                        string3 = "hmsSdk";
                        string2 = "";
                        int n12 = 0;
                        object2 = null;
                        fileInputStream = new FileInputStream((File)object);
                        n12 = 1024;
                        object = new o0(n12);
                        object2 = new byte[n12];
                        while ((n11 = fileInputStream.read((byte[])object2)) != (n10 = -1)) {
                            ((o0)object).a((byte[])object2, n11);
                        }
                        n12 = ((o0)object).b();
                        if (n12 != 0) break block12;
                        r0.a((Closeable)fileInputStream);
                        return string2;
                    }
                    try {
                        object = ((o0)object).a();
                        String string4 = "UTF-8";
                        object2 = new String((byte[])object, string4);
                    }
                    catch (Throwable throwable) {
                        object2 = fileInputStream;
                        break block13;
                    }
                    catch (IOException iOException) {
                        object2 = fileInputStream;
                        break block14;
                    }
                    catch (FileNotFoundException fileNotFoundException) {
                        object2 = fileInputStream;
                        break block15;
                    }
                    r0.a((Closeable)fileInputStream);
                    return object2;
                    catch (Throwable throwable) {
                        break block13;
                    }
                    catch (IOException iOException) {}
                }
                object = "getInfoFromFile(): stream.read or new string exception";
                {
                    y.f(string3, (String)object);
                }
                r0.a((Closeable)object2);
                return string2;
                catch (FileNotFoundException fileNotFoundException) {}
            }
            object = "getInfoFromFile(): No files need to be read";
            {
                y.f(string3, (String)object);
            }
            r0.a((Closeable)object2);
            return string2;
        }
        r0.a(object2);
        throw var0_3;
    }

    public static String a(InputStream object) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n10 = 1024;
        byte[] byArray = new byte[n10];
        while (true) {
            int n11 = ((InputStream)object).read(byArray);
            int n12 = -1;
            if (n11 == n12) break;
            n12 = 0;
            byteArrayOutputStream.write(byArray, 0, n11);
            continue;
            break;
        }
        object = "UTF-8";
        try {
            object = byteArrayOutputStream.toString((String)object);
            return object;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            r0.a((Closeable)byteArrayOutputStream);
        }
    }

    public static void a(Closeable object) {
        if (object != null) {
            try {
                object.close();
            }
            catch (IOException iOException) {
                object = "hmsSdk";
                String string2 = "closeQuietly(): Exception when closing the closeable!";
                y.f((String)object, string2);
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(File var0, String var1_4) {
        block10: {
            block9: {
                block12: {
                    block11: {
                        var2_5 = "hmsSdk";
                        var3_6 = null;
                        var4_7 = new FileOutputStream((File)var0);
                        var0 = "UTF-8";
                        try {
                            var0 = var1_4.getBytes((String)var0);
                            var4_7.write((byte[])var0);
                            var4_7.flush();
                            break block9;
                        }
                        catch (Throwable var0_1) {
                            var3_6 = var4_7;
                            break block10;
                        }
                        catch (IOException v0) {
                            var3_6 = var4_7;
                            break block11;
                        }
                        catch (FileNotFoundException v1) {
                            var3_6 = var4_7;
                            break block12;
                        }
                        catch (Throwable var0_2) {
                            break block10;
                        }
                        catch (IOException v2) {}
                    }
                    var0 = "saveInfoToFile(): io exc from write info to file!";
                    ** GOTO lbl-1000
                    catch (FileNotFoundException v3) {}
                }
                var0 = "saveInfoToFile(): No files need to be read";
lbl-1000:
                // 2 sources

                {
                    y.f(var2_5, (String)var0);
                }
                var4_7 = var3_6;
            }
            r0.a((Closeable)var4_7);
            return;
        }
        r0.a(var3_6);
        throw var0_3;
    }

    public static void a(OutputStream object) {
        if (object != null) {
            try {
                ((OutputStream)object).close();
            }
            catch (IOException iOException) {
                object = "hmsSdk";
                String string2 = "closeStream(): Exception: close OutputStream error!";
                y.f((String)object, string2);
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection) {
        String string2 = "hmsSdk";
        Object object = httpURLConnection.getInputStream();
        try {
            ((InputStream)object).close();
        }
        catch (Exception exception) {
            object = "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission";
            y.f(string2, (String)object);
        }
        httpURLConnection.disconnect();
        y.a(string2, " connHttp disconnect");
    }

    public static byte[] a(byte[] byArray) {
        int n10;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(byArray);
        deflater.finish();
        int n11 = 1024;
        byArray = new byte[n11];
        while ((n10 = deflater.finished()) == 0) {
            n10 = deflater.deflate(byArray);
            byteArrayOutputStream.write(byArray, 0, n10);
        }
        byArray = byteArrayOutputStream.toByteArray();
        deflater.end();
        r0.a(byteArrayOutputStream);
        return byArray;
    }
}

