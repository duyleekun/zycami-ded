/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.a1;

import android.text.TextUtils;
import com.zhiyun.cama.data.api.entity.CountryData;
import com.zhiyun.net.BaseEntity;
import com.zhiyun.net.download.DownloadApi;
import com.zhiyun.net.download.DownloadService;
import d.v.c.a1.a$a;
import d.v.q.e;
import g.d0;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import k.r;

public class a {
    private static final String e = "https://zhiyundev-s3.zhiyun-tech.com/android/android_res_1.zip";
    private static final String f = "https://zhiyundata.oss-cn-shenzhen.aliyuncs.com/android/android_res_1.zip";
    public static final int g = 1;
    private static final int h = 3;
    private int a;
    private long b;
    private long c;
    private long d;

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    private String c() {
        int n10;
        Object object;
        Object object2;
        int n11;
        int n12;
        String string2;
        Object object3;
        block34: {
            int n13;
            block33: {
                block32: {
                    object3 = "";
                    string2 = "\u83b7\u53d6\u4e0b\u8f7d\u5730\u5740\u5931\u8d25";
                    this.a = n12 = this.a + 1;
                    n12 = 43000;
                    n11 = 3;
                    object2 = null;
                    object = d.v.c.v0.l.a.a;
                    object3 = object.g((String)object3, (String)object3);
                    object3 = object3.execute();
                    n10 = ((r)object3).b();
                    n13 = 200;
                    if (n10 != n13) break block32;
                    object = ((r)object3).a();
                    if (object == null) break block32;
                    object = ((r)object3).a();
                    object = (CountryData)object;
                    n10 = ((BaseEntity)object).errcode;
                    if (n10 != 0) break block32;
                    object3 = ((r)object3).a();
                    object3 = (CountryData)object3;
                    int n14 = ((CountryData)object3).getIs_overseas();
                    object3 = n14 == 0 ? f : e;
                    object2 = object3;
                }
                n10 = this.a;
                if (n10 >= n11) break block33;
                return this.c();
            }
            if (object3 != null) {
                object = new StringBuilder();
                ((StringBuilder)object).append(string2);
                Object object4 = " response.code = ";
                ((StringBuilder)object).append((String)object4);
                n13 = ((r)object3).b();
                ((StringBuilder)object).append(n13);
                object = ((StringBuilder)object).toString();
                object4 = ((r)object3).a();
                if (object4 == null) break block34;
                object4 = new StringBuilder();
                ((StringBuilder)object4).append((String)object);
                object = " error code = ";
                ((StringBuilder)object4).append((String)object);
                object3 = ((r)object3).a();
                object3 = (CountryData)object3;
                int n15 = ((BaseEntity)object3).errcode;
                ((StringBuilder)object4).append(n15);
                object = ((StringBuilder)object4).toString();
                break block34;
            }
            object = string2;
        }
        object3 = new Exception(string2);
        try {
            d.v.q.e.j(n12, (Throwable)object3, (String)object);
        }
        catch (Exception exception) {
            n10 = this.a;
            if (n10 < n11) {
                return this.c();
            }
            d.v.q.e.j(n12, exception, string2);
        }
        return object2;
    }

    public static a d() {
        return a$a.a();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean e(String var1_1, String var2_2, String var3_3) {
        block23: {
            block28: {
                block30: {
                    block24: {
                        block27: {
                            block26: {
                                block25: {
                                    block22: {
                                        var4_4 = this;
                                        var5_5 = var1_1;
                                        var6_6 = DownloadApi.class;
                                        var7_17 = this.a;
                                        var8_18 = 1;
                                        this.a = var7_17 += var8_18;
                                        var7_17 = 20;
                                        var9_19 = ((DownloadApi)DownloadService.getDownloadRetrofit(var1_1, var7_17).g((Class)var6_6)).download(var1_1);
                                        var10_20 = 0;
                                        var11_21 = null;
                                        var12_22 = "UTF-8";
                                        var13_23 = var3_3;
                                        try {
                                            var12_22 = URLEncoder.encode(var3_3, (String)var12_22);
                                            break block22;
                                        }
                                        catch (Throwable var6_15) {
                                            var9_19 = null;
                                            break block23;
                                        }
                                        catch (Exception var6_14) {
                                            break block24;
                                        }
                                    }
                                    try {
                                        var14_24 = new File(var2_2, (String)var12_22);
                                        var9_19 = var9_19.execute();
                                        var12_22 = var9_19.a();
                                        var12_22 = (d0)var12_22;
                                        var15_25 = var12_22.contentLength();
                                        var12_22 = var9_19.f();
                                        var17_26 = "Last-Modified";
                                        var12_22 = var12_22.f(var17_26);
                                        var18_27 = var14_24.exists();
                                        var19_28 = 0L;
                                        if (!var18_27) ** GOTO lbl51
                                        if (var12_22 == null || (var25_31 = (int)((cfr_temp_0 = (var21_29 = var12_22.getTime()) - (var23_30 = var14_24.lastModified())) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) <= 0) break block25;
                                        var14_24.delete();
                                        ** GOTO lbl51
                                    }
                                    catch (Exception var6_13) {
                                        break block24;
                                    }
                                }
                                var21_29 = var14_24.length();
                                cfr_temp_1 = var21_29 - var15_25;
                                var25_31 = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                                if (var25_31 != 0) ** GOTO lbl-1000
                                d.v.c.a1.a.a(null);
                                d.v.c.a1.a.a(null);
                                return (boolean)var8_18;
lbl-1000:
                                // 1 sources

                                {
                                    block29: {
                                        var15_25 = var14_24.length();
                                        break block29;
lbl51:
                                        // 2 sources

                                        var15_25 = var19_28;
                                    }
                                    var4_4.d = var15_25;
                                    var25_31 = var4_4.a;
                                    if (var25_31 == var8_18) {
                                        var4_4.c = var15_25;
                                    }
                                    if ((var25_31 = (int)(var15_25 == var19_28 ? 0 : (var15_25 < var19_28 ? -1 : 1))) != 0) {
                                        var9_19 = var9_19.a();
                                        var9_19 = (d0)var9_19;
                                        var9_19.close();
                                        var26_32 = DownloadService.getDownloadRetrofit((String)var5_5, var7_17);
                                        var6_6 = var26_32.g((Class)var6_6);
                                        var6_6 = (DownloadApi)var6_6;
                                        var26_32 = new StringBuilder();
                                        var9_19 = "bytes=";
                                        var26_32.append((String)var9_19);
                                        var26_32.append(var15_25);
                                        var9_19 = "-";
                                        var26_32.append((String)var9_19);
                                        var26_32 = var26_32.toString();
                                        var6_6 = var6_6.download((String)var26_32, (String)var5_5);
                                        var6_6 = var6_6.execute();
                                        var6_6 = var6_6.a();
                                        var6_6 = (d0)var6_6;
                                        var6_6 = var6_6.byteStream();
                                    } else {
                                        var6_6 = var9_19.a();
                                        var6_6 = (d0)var6_6;
                                        var6_6 = var6_6.byteStream();
                                    }
                                    var26_32 = var6_6;
                                }
                                try {
                                    var9_19 = new FileOutputStream(var14_24, (boolean)var8_18);
                                    var27_33 = 8192;
                                }
                                catch (Throwable var6_9) {
                                    var9_19 = null;
                                    break block26;
                                }
                                catch (Exception var6_11) {
                                    var9_19 = null;
                                    break block27;
                                }
                                try {
                                    var6_6 = new byte[var27_33];
                                    while ((var10_20 = var26_32.read((byte[])var6_6)) != (var25_31 = -1)) {
                                        var9_19.write((byte[])var6_6, 0, var10_20);
                                        var15_25 = var4_4.d;
                                        var28_34 = var10_20;
                                        var4_4.d = var15_25 += var28_34;
                                    }
                                    var9_19.flush();
                                }
                                catch (Throwable var6_7) {
                                    break block26;
                                }
                                catch (Exception var6_8) {
                                    break block27;
                                }
                                d.v.c.a1.a.a((Closeable)var26_32);
                                d.v.c.a1.a.a((Closeable)var9_19);
                                return (boolean)var8_18;
                            }
                            var11_21 = var26_32;
                            break block23;
                        }
                        var11_21 = var26_32;
                        break block30;
                    }
                    var9_19 = null;
                }
                try {
                    var7_17 = var4_4.a;
                    var25_31 = 3;
                    if (var7_17 >= var25_31) break block28;
                    d.v.c.a1.a.a(var11_21);
                    d.v.c.a1.a.a((Closeable)var9_19);
                    var27_33 = this.e(var1_1, var2_2, var3_3);
                }
                catch (Throwable var6_16) {
                    // empty catch block
                    break block23;
                }
                d.v.c.a1.a.a(var11_21);
                d.v.c.a1.a.a((Closeable)var9_19);
                return (boolean)var27_33;
            }
            var7_17 = 43000;
            var13_23 = "\u4e0b\u8f7d\u6587\u4ef6\u5931\u8d25,\u4e0b\u8f7d\u5730\u5740\u4e3a\uff1a%s \u4e0b\u8f7d\u8017\u65f6\u4e3a\uff1a%sms \u6b64\u6b21\u4e0b\u8f7d\u7684\u6587\u4ef6\u5927\u5c0f\u4e3a:%s";
            {
                var12_22 = new Object[var25_31];
                var12_22[0] = var5_5;
                var30_35 = System.currentTimeMillis();
                var15_25 = var4_4.b;
            }
            {
                var12_22[var8_18] = var5_5 = Long.valueOf(var30_35 -= var15_25);
                var32_36 = 2;
                var30_35 = var4_4.d;
                var15_25 = var4_4.c;
            }
            {
                var33_37 = var30_35 -= var15_25;
                var12_22[var32_36] = var33_37;
                d.v.q.e.k(var7_17, (Throwable)var6_12, var13_23, (Object[])var12_22);
            }
            d.v.c.a1.a.a(var11_21);
            d.v.c.a1.a.a((Closeable)var9_19);
            return (boolean)0;
        }
        d.v.c.a1.a.a(var11_21);
        d.v.c.a1.a.a((Closeable)var9_19);
        throw var6_10;
    }

    public boolean b(String string2, String string3) {
        long l10;
        this.a = 0;
        String string4 = this.c();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string4);
        if (bl2) {
            return false;
        }
        this.a = 0;
        this.b = l10 = System.currentTimeMillis();
        this.d = 0L;
        return this.e(string4, string2, string3);
    }
}

