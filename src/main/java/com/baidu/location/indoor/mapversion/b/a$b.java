/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.baidu.location.indoor.mapversion.b.a
 */
package com.baidu.location.indoor.mapversion.b;

import com.baidu.location.indoor.mapversion.b.a;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class a$b
extends Thread {
    public final /* synthetic */ a a;
    private String b;
    private String c;

    public a$b(a a10, String string2, String string3) {
        this.a = a10;
        this.b = string2;
        this.c = string3;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        try {
            block11: {
                block9: {
                    block10: {
                        var2_3 = this.a;
                        var2_3 = com.baidu.location.indoor.mapversion.b.a.a((a)var2_3);
                        var1_1 = new File((String)var2_3);
                        var3_4 = var1_1.exists();
                        if (!var3_4 || !(var3_4 = var1_1.isDirectory())) {
                            var1_1.mkdirs();
                        }
                        var4_5 = "https://loc.map.baidu.com/cfgs/indoorloc/indoorroadnet";
                        var2_3 = new URL(var4_5);
                        var2_3 = var2_3.openConnection();
                        var2_3 = FirebasePerfUrlConnection.instrument(var2_3);
                        var2_3 = (URLConnection)var2_3;
                        var2_3 = (HttpsURLConnection)var2_3;
                        var5_6 = true;
                        var2_3.setDoInput(var5_6);
                        var2_3.setDoOutput(var5_6);
                        var6_7 = "POST";
                        var2_3.setRequestMethod((String)var6_7);
                        var6_7 = "Accept-encoding";
                        var7_8 = "gzip";
                        var2_3.addRequestProperty((String)var6_7, (String)var7_8);
                        var6_7 = var2_3.getOutputStream();
                        var7_8 = new StringBuilder();
                        var8_9 = "bldg=";
                        var7_8.append(var8_9);
                        var8_9 = this.b;
                        var7_8.append(var8_9);
                        var8_9 = "&md5=";
                        var7_8.append(var8_9);
                        var8_9 = this.c;
                        if (var8_9 == null) {
                            var8_9 = "null";
                        }
                        var7_8.append(var8_9);
                        var7_8 = var7_8.toString();
                        var7_8 = var7_8.getBytes();
                        var6_7.write((byte[])var7_8);
                        var9_10 = var2_3.getResponseCode();
                        var10_11 = 0;
                        var7_8 = null;
                        var11_12 = 200;
                        if (var9_10 != var11_12) break block9;
                        var4_5 = "Hash";
                        var4_5 = var2_3.getHeaderField(var4_5);
                        var2_3 = var2_3.getInputStream();
                        var7_8 = this.a;
                        var8_9 = this.b;
                        var7_8 = com.baidu.location.indoor.mapversion.b.a.a((a)var7_8, (String)var8_9, (String)var4_5);
                        var6_7 = new File((File)var1_1, (String)var7_8);
                        var1_1 = new FileOutputStream((File)var6_7);
                        var10_11 = 1024;
                        var7_8 = new byte[var10_11];
                        while ((var11_12 = var2_3.read((byte[])var7_8)) >= 0) {
                            var1_1.write((byte[])var7_8, 0, var11_12);
                        }
                        var1_1.flush();
                        var1_1.close();
                        var1_1 = com.baidu.location.indoor.mapversion.b.a.a((File)var6_7);
                        var12_13 = (int)var1_1.equalsIgnoreCase(var4_5);
                        if (var12_13 == 0) break block10;
                        var1_1 = this.a;
                        var2_3 = this.b;
                        var4_5 = this.c;
                        com.baidu.location.indoor.mapversion.b.a.b((a)var1_1, (String)var2_3, (String)var4_5);
                        var1_1 = this.a;
                        var2_3 = this.b;
                        com.baidu.location.indoor.mapversion.b.a.b((a)var1_1, (String)var2_3);
                        var1_1 = this.a;
                        var12_13 = (int)com.baidu.location.indoor.mapversion.b.a.b((a)var1_1);
                        var7_8 = var2_3 = "OK";
                        break block11;
                    }
                    var1_1 = "Download failed";
                    var6_7.delete();
                    var7_8 = var1_1;
                    ** GOTO lbl120
                }
                var12_13 = 304;
                if (var9_10 == var12_13) {
                    var1_1 = this.a;
                    var2_3 = this.b;
                    com.baidu.location.indoor.mapversion.b.a.b((a)var1_1, (String)var2_3);
                    var1_1 = this.a;
                    var12_13 = (int)com.baidu.location.indoor.mapversion.b.a.b(var1_1);
                    var2_3 = new StringBuilder();
                    var4_5 = "No roadnet update for ";
                    var2_3.append(var4_5);
                    var4_5 = this.b;
                    var2_3.append(var4_5);
                    var4_5 = ",";
                    var2_3.append(var4_5);
                    var4_5 = this.c;
                    var2_3.append(var4_5);
                    var7_8 = var2_3.toString();
                } else {
                    var12_13 = 204;
                    if (var9_10 == var12_13) {
                        var1_1 = new StringBuilder();
                        var2_3 = "Not found bldg ";
                        var1_1.append((String)var2_3);
                        var2_3 = this.b;
                        var1_1.append((String)var2_3);
                        var7_8 = var1_1.toString();
                        var1_1 = this.a;
                        com.baidu.location.indoor.mapversion.b.a.a((a)var1_1, (boolean)var5_6);
                    }
lbl120:
                    // 4 sources

                    var12_13 = 0;
                    var1_1 = null;
                }
            }
            var2_3 = this.a;
            var2_3 = com.baidu.location.indoor.mapversion.b.a.c((a)var2_3);
            if (var2_3 != null) {
                var2_3 = this.a;
                var2_3 = com.baidu.location.indoor.mapversion.b.a.c((a)var2_3);
                var2_3.a((boolean)var12_13, (String)var7_8);
            }
        }
        catch (Exception var1_2) {
            var1_2.printStackTrace();
        }
        com.baidu.location.indoor.mapversion.b.a.b((a)this.a, (boolean)false);
    }
}

