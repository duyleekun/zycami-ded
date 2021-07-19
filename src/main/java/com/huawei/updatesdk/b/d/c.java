/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  android.os.Handler
 *  android.os.Message
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.b.d;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.updatesdk.a.b.a.a;
import com.huawei.updatesdk.b.d.b;
import com.huawei.updatesdk.b.d.c$a;
import com.huawei.updatesdk.b.d.c$b;
import com.huawei.updatesdk.b.d.d;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class c
extends AsyncTask {
    private String a;
    private HttpURLConnection b;
    private boolean c = false;
    private b d;
    private Handler e;

    public c(b object) {
        Object object2 = new c$b(null);
        this.e = object2;
        this.d = object;
        object2 = ((b)object).c();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            this.a = object = ((b)object).c();
        }
    }

    public static /* synthetic */ HttpURLConnection a(c c10) {
        return c10.b;
    }

    private void a(int n10, long l10, String string2, int n11) {
        b b10 = new b();
        b10.a(n10);
        b10.a(l10);
        b10.a(string2);
        Handler handler = this.e;
        if (handler == null) {
            return;
        }
        Message message = handler.obtainMessage(n11, (Object)b10);
        handler.sendMessage(message);
    }

    /*
     * Exception decompiling
     */
    private void a(b var1_1, String var2_9) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 7[TRYBLOCK] [22 : 159->162)] java.lang.Throwable
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

    private void a(InputStream object, OutputStream object2) {
        String string2 = "DownloadMarketTask";
        String string3 = "downloadUrlToStream(String urlString,OutputStream outputStream) ";
        if (object != null) {
            try {
                ((InputStream)object).close();
            }
            catch (IOException iOException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                object = iOException.toString();
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                com.huawei.updatesdk.a.a.c.a.a.a.b(string2, (String)object);
            }
        }
        if (object2 != null) {
            try {
                ((OutputStream)object2).close();
            }
            catch (IOException iOException) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string3);
                String string4 = iOException.toString();
                ((StringBuilder)object2).append(string4);
                string4 = ((StringBuilder)object2).toString();
                com.huawei.updatesdk.a.a.c.a.a.a.b(string2, string4);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private boolean a(b var1_1, OutputStream var2_2, String var3_3) {
        block83: {
            block74: {
                block79: {
                    block84: {
                        block88: {
                            block87: {
                                block75: {
                                    block82: {
                                        block81: {
                                            block80: {
                                                block71: {
                                                    block70: {
                                                        block76: {
                                                            block86: {
                                                                block78: {
                                                                    block77: {
                                                                        block73: {
                                                                            block72: {
                                                                                block68: {
                                                                                    block67: {
                                                                                        block85: {
                                                                                            block66: {
                                                                                                var4_4 = this;
                                                                                                var5_5 = 0;
                                                                                                var6_6 = null;
                                                                                                var7_7 = -1;
                                                                                                var9_8 = 0;
                                                                                                var10_9 = com.huawei.updatesdk.b.d.d.a();
                                                                                                var11_34 /* !! */  = var1_1.b();
                                                                                                var10_9 = var10_9.a(var11_34 /* !! */ );
                                                                                                this.b = var10_9;
                                                                                                if (var10_9 != null) break block66;
                                                                                                var12_35 = this.c;
                                                                                                var13_37 = this.a;
                                                                                                var9_8 = 0;
                                                                                                var7_7 = -1;
                                                                                                var14_39 = var12_35 != false ? 3 : 5;
lbl20:
                                                                                                // 3 sources

                                                                                                while (true) {
                                                                                                    var11_34 /* !! */  = this;
                                                                                                    this.a(0, var7_7, var13_37, var14_39);
                                                                                                    var4_4.a((InputStream)null, (OutputStream)null);
lbl24:
                                                                                                    // 2 sources

                                                                                                    while (true) {
                                                                                                        com.huawei.updatesdk.b.g.b.a().remove((Object)var4_4);
                                                                                                        this.d();
                                                                                                        return false;
                                                                                                    }
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            var10_9.connect();
                                                                                            var10_9 = this.b;
                                                                                            var12_36 = var10_9.getResponseCode();
                                                                                            var15_41 = 200;
                                                                                            if (var15_41 == var12_36 || (var15_41 = 206) == var12_36) break block67;
                                                                                            var12_36 = (int)this.c;
                                                                                            var13_37 = this.a;
                                                                                            if (var12_36 == 0) break block85;
                                                                                            var14_39 = 3;
                                                                                            ** GOTO lbl20
                                                                                        }
                                                                                        var9_8 = 0;
                                                                                        var7_7 = -1;
                                                                                        var14_39 = 5;
                                                                                        ** while (true)
                                                                                    }
                                                                                    var16_42 = var1_1.e();
                                                                                    var10_9 = var4_4.b;
                                                                                    var10_9 = var10_9.getInputStream();
                                                                                    var15_41 = 8192;
                                                                                    var18_43 = new BufferedInputStream((InputStream)var10_9, var15_41);
                                                                                    var10_9 = var2_2;
                                                                                    var19_44 = new BufferedOutputStream(var2_2, var15_41);
                                                                                    var10_9 = new byte[var15_41];
                                                                                    var20_45 = 0L;
                                                                                    var14_40 = 0;
                                                                                    var22_46 = null;
                                                                                    var23_47 = var20_45;
                                                                                    while (true) lbl-1000:
                                                                                    // 3 sources

                                                                                    {
                                                                                        var25_48 = var18_43.read((byte[])var10_9);
                                                                                        var26_49 = -1;
                                                                                        if (var25_48 == var26_49) break block68;
                                                                                        var19_44.write((byte[])var10_9, 0, var25_48);
                                                                                        var14_40 += var25_48;
                                                                                        break;
                                                                                    }
                                                                                    catch (Throwable var10_11) {
                                                                                        var9_8 = var14_40;
                                                                                        break block71;
                                                                                    }
                                                                                    {
                                                                                        var7_7 = System.currentTimeMillis() - var23_47;
                                                                                        var7_7 = Math.abs(var7_7);
                                                                                        var27_50 = 1000L;
                                                                                        var25_48 = (int)(var7_7 == var27_50 ? 0 : (var7_7 < var27_50 ? -1 : 1));
                                                                                        if (var25_48 > 0) {
                                                                                            block69: {
                                                                                                var27_50 = System.currentTimeMillis();
                                                                                                var23_47 = var14_40;
                                                                                                var15_41 = (int)(var23_47 == var16_42 ? 0 : (var23_47 < var16_42 ? -1 : 1));
                                                                                                if (var15_41 != 0) {
                                                                                                    var13_38 = var4_4.a;
                                                                                                    var29_51 = 2;
                                                                                                    var11_34 /* !! */  = this;
                                                                                                    var9_8 = var14_40;
                                                                                                    var7_7 = var16_42;
                                                                                                    var30_52 = var14_40;
                                                                                                    var14_40 = var29_51;
                                                                                                    try {
                                                                                                        this.a(var9_8, var16_42, var13_38, var29_51);
                                                                                                        break block69;
                                                                                                    }
                                                                                                    catch (Throwable var10_10) {
                                                                                                        break block70;
                                                                                                    }
                                                                                                }
                                                                                                var30_52 = var14_40;
                                                                                            }
                                                                                            var23_47 = var27_50;
                                                                                            var14_40 = var30_52;
                                                                                            continue;
                                                                                        }
                                                                                        var30_52 = var14_40;
                                                                                        ** while (true)
                                                                                    }
                                                                                }
                                                                                var4_4.a(var18_43, var19_44);
                                                                                var31_53 = var14_40;
                                                                                var12_36 = (int)(var31_53 == var16_42 ? 0 : (var31_53 < var16_42 ? -1 : 1));
                                                                                if (var12_36 == 0 && (var12_36 = (int)(var16_42 == var20_45 ? 0 : (var16_42 < var20_45 ? -1 : 1))) > 0) {
                                                                                    var10_9 = var1_1.d();
                                                                                    var12_36 = (int)TextUtils.isEmpty((CharSequence)var10_9);
                                                                                    if (var12_36 != 0) break block72;
                                                                                    var10_9 = var1_1.d();
                                                                                    var11_34 /* !! */  = "SHA-256";
                                                                                    var11_34 /* !! */  = com.huawei.updatesdk.a.a.d.d.a(var3_3, var11_34 /* !! */ );
                                                                                    try {
                                                                                        var12_36 = (int)var10_9.equalsIgnoreCase(var11_34 /* !! */ );
                                                                                        if (var12_36 == 0) break block72;
                                                                                        var12_36 = 1;
                                                                                        var33_54 = 1.4E-45f;
                                                                                        var34_55 = var12_36;
                                                                                        var35_59 = var33_54;
                                                                                        break block73;
                                                                                    }
                                                                                    catch (Throwable var10_12) {
                                                                                        var9_8 = var14_40;
                                                                                        var34_56 = false;
                                                                                        var18_43 = null;
                                                                                        var35_60 = 0.0f;
                                                                                        break block74;
                                                                                    }
                                                                                    catch (Exception var10_13) {
                                                                                        var9_8 = var14_40;
                                                                                        var15_41 = 0;
                                                                                        var11_34 /* !! */  = null;
                                                                                        var34_57 = false;
                                                                                        var18_43 = null;
                                                                                        var35_61 = 0.0f;
                                                                                        break block75;
                                                                                    }
                                                                                }
                                                                            }
                                                                            var34_55 = 0;
                                                                            var18_43 = null;
                                                                            var35_59 = 0.0f;
                                                                        }
                                                                        if (var34_55 == 0) break block86;
                                                                        var13_38 = var4_4.a;
                                                                        var12_36 = 4;
                                                                        var33_54 = 5.6E-45f;
                                                                        var11_34 /* !! */  = this;
                                                                        var9_8 = var14_40;
                                                                        var7_7 = var16_42;
                                                                        var30_52 = var14_40;
                                                                        var14_40 = var12_36;
                                                                        try {
                                                                            this.a(var9_8, var16_42, var13_38, var12_36);
                                                                            break block76;
                                                                        }
                                                                        catch (Throwable var10_14) {
                                                                            var5_5 = var34_55;
                                                                            var14_40 = var30_52;
                                                                            break block77;
                                                                        }
                                                                        catch (Exception var10_15) {
                                                                            break block78;
                                                                        }
                                                                        catch (Throwable var10_16) {
                                                                            var30_52 = var14_40;
                                                                            var5_5 = var34_55;
                                                                        }
                                                                    }
lbl175:
                                                                    // 2 sources

                                                                    while (true) {
                                                                        var34_55 = 0;
                                                                        var18_43 = null;
                                                                        var35_59 = 0.0f;
                                                                        break block79;
                                                                        break;
                                                                    }
                                                                    catch (Exception var10_18) {
                                                                        var30_52 = var14_40;
                                                                    }
                                                                }
                                                                var7_7 = var16_42;
                                                                var15_41 = var34_55;
                                                                var9_8 = var30_52;
                                                                break block87;
                                                            }
                                                            var30_52 = var14_40;
                                                        }
                                                        if (var34_55 == 0) {
                                                            var12_36 = (int)var4_4.c;
                                                            var13_38 = var4_4.a;
                                                            var14_40 = var12_36 != 0 ? 3 : 5;
                                                            var11_34 /* !! */  = this;
                                                            var9_8 = var30_52;
                                                            var7_7 = var16_42;
                                                            this.a(var30_52, var16_42, var13_38, var14_40);
                                                        }
                                                        var4_4.a((InputStream)null, (OutputStream)null);
                                                        com.huawei.updatesdk.b.g.b.a().remove((Object)var4_4);
                                                        this.d();
                                                        return (boolean)var34_55;
                                                        catch (Throwable var10_20) {
                                                            var30_52 = var14_40;
                                                            break block80;
                                                        }
                                                        catch (Exception var10_21) {
                                                            var30_52 = var14_40;
                                                            break block81;
                                                        }
                                                        catch (Throwable var10_22) {
                                                            var30_52 = var14_40;
                                                        }
                                                    }
                                                    var9_8 = var30_52;
                                                    break block71;
                                                    catch (Throwable var10_24) {}
                                                    break block71;
                                                    catch (Throwable var10_25) {
                                                        var19_44 = null;
                                                        break block71;
                                                    }
                                                    catch (Throwable var10_26) {
                                                        var34_55 = 0;
                                                        var18_43 = null;
                                                        var35_59 = 0.0f;
                                                        var19_44 = null;
                                                    }
                                                }
                                                var4_4.a(var18_43, var19_44);
                                                try {
                                                    throw var10_23;
                                                }
                                                catch (Throwable var10_27) {
                                                    var14_40 = var9_8;
                                                    ** continue;
                                                }
                                                catch (Exception var10_28) {
                                                    var14_40 = var9_8;
                                                    var34_55 = 0;
                                                    var18_43 = null;
                                                    var35_59 = 0.0f;
                                                    break block82;
                                                }
                                                catch (Throwable var10_29) {
                                                    var14_40 = var9_8;
                                                }
                                            }
                                            var6_6 = var19_44;
                                            break block79;
                                            catch (Exception var10_30) {
                                                var14_40 = var9_8;
                                            }
                                        }
                                        var6_6 = var19_44;
                                    }
                                    var9_8 = var14_40;
                                    var15_41 = 0;
                                    var11_34 /* !! */  = null;
                                }
                                var7_7 = var16_42;
                                break block88;
                                catch (Throwable var10_31) {
                                    var34_58 = false;
                                    var18_43 = null;
                                    var35_62 = 0.0f;
                                    break block83;
                                }
                                catch (Exception var10_32) {
                                    var15_41 = 0;
                                    var11_34 /* !! */  = null;
                                }
                            }
                            var34_55 = 0;
                            var18_43 = null;
                            var35_59 = 0.0f;
                        }
                        var13_38 = "DownloadMarketTask";
                        var22_46 = new StringBuilder();
                        var36_63 = "downloadUrlToStream(String urlString,OutputStream outputStream) ";
                        var22_46.append(var36_63);
                        var10_19 = var10_19.toString();
                        var22_46.append(var10_19);
                        var10_19 = var22_46.toString();
                        try {
                            com.huawei.updatesdk.a.a.c.a.a.a.b(var13_38, var10_19);
                            if (var15_41 != 0) break block84;
                        }
                        catch (Throwable var10_33) {
                            var5_5 = var15_41;
                            var14_40 = var9_8;
                            var16_42 = var7_7;
                        }
                        var12_36 = (int)var4_4.c;
                        var13_38 = var4_4.a;
                        var14_40 = var12_36 != 0 ? 3 : 5;
                        var11_34 /* !! */  = this;
                        this.a(var9_8, var7_7, var13_38, var14_40);
                    }
                    var4_4.a(var18_43, var6_6);
                    ** while (true)
                }
                var9_8 = var14_40;
            }
            var7_7 = var16_42;
        }
        if (var5_5 == 0) {
            var15_41 = var4_4.c;
            var13_38 = var4_4.a;
            var14_40 = var15_41 != 0 ? 3 : 5;
            var11_34 /* !! */  = this;
            this.a(var9_8, var7_7, var13_38, var14_40);
        }
        var4_4.a(var18_43, var6_6);
        com.huawei.updatesdk.b.g.b.a().remove((Object)var4_4);
        this.d();
        throw var10_17;
    }

    public static /* synthetic */ boolean a(c c10, boolean bl2) {
        c10.c = bl2;
        return bl2;
    }

    public static /* synthetic */ String c() {
        return com.huawei.updatesdk.b.d.c.e();
    }

    private void d() {
        HttpURLConnection httpURLConnection = this.b;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    private static String e() {
        String string2 = com.huawei.updatesdk.a.b.a.a.c().b();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = "";
        if (bl2) {
            return string3;
        }
        Comparable<StringBuilder> comparable = new Comparable<StringBuilder>();
        ((StringBuilder)comparable).append(string2);
        ((StringBuilder)comparable).append("/updatesdk");
        string2 = ((StringBuilder)comparable).toString();
        comparable = new Comparable<StringBuilder>(string2);
        boolean bl3 = ((File)comparable).exists();
        if (!bl3 && !(bl2 = ((File)comparable).mkdirs())) {
            return string3;
        }
        return string2;
    }

    public Void a(Void ... object) {
        com.huawei.updatesdk.b.g.b.a(this);
        object = this.d;
        String string2 = com.huawei.updatesdk.b.d.c.e();
        this.a((b)object, string2);
        return null;
    }

    public void a() {
        c$a c$a = new c$a(this);
        Thread thread = new Thread(c$a);
        thread.start();
    }

    public void b() {
        this.e = null;
    }

    public void onCancelled() {
        super.onCancelled();
        this.a();
    }
}

