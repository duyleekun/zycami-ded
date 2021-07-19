/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.e.a;

import android.util.Log;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import d.e.a.k;
import d.e.a.l$a;
import d.e.a.m;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

public class l
extends m {
    private static final String h = "SendLogDefaultRunnable";
    private final Map e;
    private String f;
    private k g;

    public l() {
        HashMap hashMap;
        this.e = hashMap = new HashMap();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void e(String var1_1, InputStream var2_2, Map var3_9) {
        block101: {
            block121: {
                block122: {
                    block123: {
                        block119: {
                            block120: {
                                block118: {
                                    block115: {
                                        block117: {
                                            block114: {
                                                block116: {
                                                    block113: {
                                                        block112: {
                                                            block111: {
                                                                block110: {
                                                                    block109: {
                                                                        block108: {
                                                                            block107: {
                                                                                block106: {
                                                                                    block100: {
                                                                                        block105: {
                                                                                            block104: {
                                                                                                block103: {
                                                                                                    block102: {
                                                                                                        var4_31 = 2048;
                                                                                                        var5_32 = new byte[var4_31];
                                                                                                        var6_45 = -1;
                                                                                                        var7_46 = null;
                                                                                                        var8_47 = new URL((String)var1_1);
                                                                                                        var1_1 = var8_47.openConnection();
                                                                                                        var1_1 = FirebasePerfUrlConnection.instrument(var1_1);
                                                                                                        var1_1 = (URLConnection)var1_1;
                                                                                                        var1_1 = (HttpURLConnection)var1_1;
                                                                                                        var9_48 = var1_1 instanceof HttpsURLConnection;
                                                                                                        if (var9_48 == 0) ** GOTO lbl18
                                                                                                        var8_47 = var1_1;
                                                                                                        var8_47 = (HttpsURLConnection)var1_1;
                                                                                                        var10_49 = new l$a(this);
                                                                                                        var8_47.setHostnameVerifier((HostnameVerifier)var10_49);
lbl18:
                                                                                                        // 2 sources

                                                                                                        var3_9 = var3_9.entrySet();
                                                                                                        var3_9 = var3_9.iterator();
                                                                                                        while ((var9_48 = var3_9.hasNext()) != 0) {
                                                                                                            var8_47 = var3_9.next();
                                                                                                            var8_47 = (Map.Entry)var8_47;
                                                                                                            var10_49 = var8_47.getKey();
                                                                                                            var10_49 = (String)var10_49;
                                                                                                            var8_47 = var8_47.getValue();
                                                                                                            var8_47 = (String)var8_47;
                                                                                                            ((HttpURLConnection)var1_1).addRequestProperty((String)var10_49, (String)var8_47);
                                                                                                        }
                                                                                                        var11_50 = 15000 != 0;
                                                                                                        ((HttpURLConnection)var1_1).setReadTimeout((int)var11_50);
                                                                                                        ((HttpURLConnection)var1_1).setConnectTimeout((int)var11_50);
                                                                                                        var11_50 = true;
                                                                                                        ((HttpURLConnection)var1_1).setDoInput(var11_50);
                                                                                                        ((HttpURLConnection)var1_1).setDoOutput(var11_50);
                                                                                                        var3_9 = "POST";
                                                                                                        ((HttpURLConnection)var1_1).setRequestMethod((String)var3_9);
                                                                                                        var3_9 = ((HttpURLConnection)var1_1).getOutputStream();
                                                                                                        var8_47 = new ByteArrayOutputStream(var4_31);
                                                                                                        break block100;
                                                                                                        catch (Throwable var3_12) {
                                                                                                            var13_71 = false;
                                                                                                            var14_77 = null;
                                                                                                            break block101;
                                                                                                        }
                                                                                                        catch (Exception var3_13) {
                                                                                                            var4_31 = 0;
                                                                                                            var12_51 = null;
                                                                                                            break block102;
                                                                                                        }
                                                                                                        catch (IOException var3_14) {
                                                                                                            var4_31 = 0;
                                                                                                            var12_51 = null;
                                                                                                            break block103;
                                                                                                        }
                                                                                                        catch (MalformedURLException var3_15) {
                                                                                                            var4_31 = 0;
                                                                                                            var12_51 = null;
                                                                                                            break block104;
                                                                                                        }
                                                                                                        catch (ProtocolException var3_16) {
                                                                                                            var4_31 = 0;
                                                                                                            var12_51 = null;
                                                                                                            break block105;
                                                                                                        }
                                                                                                        catch (Throwable var3_17) {
                                                                                                            var1_1 = null;
                                                                                                            var13_72 = false;
                                                                                                            var14_77 = null;
                                                                                                            break block101;
                                                                                                        }
                                                                                                        catch (Exception var3_18) {
                                                                                                            var1_1 = null;
                                                                                                            var4_31 = 0;
                                                                                                            var12_51 = null;
                                                                                                        }
                                                                                                    }
                                                                                                    var13_73 = false;
                                                                                                    var14_77 = null;
                                                                                                    break block113;
                                                                                                    catch (IOException var3_21) {
                                                                                                        var1_1 = null;
                                                                                                        var4_31 = 0;
                                                                                                        var12_51 = null;
                                                                                                    }
                                                                                                }
                                                                                                var13_74 = false;
                                                                                                var14_77 = null;
                                                                                                break block114;
                                                                                                catch (MalformedURLException var3_24) {
                                                                                                    var1_1 = null;
                                                                                                    var4_31 = 0;
                                                                                                    var12_51 = null;
                                                                                                }
                                                                                            }
                                                                                            var13_75 = false;
                                                                                            var14_77 = null;
                                                                                            break block115;
                                                                                            catch (ProtocolException var3_27) {
                                                                                                var1_1 = null;
                                                                                                var4_31 = 0;
                                                                                                var12_51 = null;
                                                                                            }
                                                                                        }
                                                                                        var13_76 = false;
                                                                                        var14_77 = null;
                                                                                        break block120;
                                                                                    }
                                                                                    while (true) {
                                                                                        var4_31 = var2_2.read(var5_32);
                                                                                        var10_49 = null;
                                                                                        if (var4_31 == var6_45) break;
                                                                                        var8_47.write(var5_32, 0, var4_31);
                                                                                    }
                                                                                    var12_51 = var8_47.toByteArray();
                                                                                    var8_47.close();
                                                                                    var3_9.write((byte[])var12_51);
                                                                                    var3_9.flush();
                                                                                    var4_31 = ((HttpURLConnection)var1_1).getResponseCode();
                                                                                    try {
                                                                                        var9_48 = var4_31 / 100;
                                                                                        var13_61 = 2;
                                                                                        if (var9_48 == var13_61) {
                                                                                            var8_47 = new ByteArrayOutputStream();
                                                                                            var14_77 = ((HttpURLConnection)var1_1).getInputStream();
                                                                                            break block106;
                                                                                        }
                                                                                        var5_32 = null;
                                                                                        break block107;
                                                                                    }
                                                                                    catch (Exception var5_37) {
                                                                                        var6_45 = var4_31;
                                                                                        var13_62 = false;
                                                                                        var14_77 = null;
                                                                                        break block108;
                                                                                    }
                                                                                    catch (IOException var5_39) {
                                                                                        var6_45 = var4_31;
                                                                                        var13_63 = false;
                                                                                        var14_77 = null;
                                                                                        break block109;
                                                                                    }
                                                                                    catch (MalformedURLException var5_41) {
                                                                                        var6_45 = var4_31;
                                                                                        var13_64 = false;
                                                                                        var14_77 = null;
                                                                                        break block110;
                                                                                    }
                                                                                    catch (ProtocolException var5_43) {
                                                                                        var6_45 = var4_31;
                                                                                        var13_65 = false;
                                                                                        var14_77 = null;
                                                                                        break block111;
                                                                                    }
                                                                                    {
                                                                                        catch (Throwable var12_54) {
                                                                                            var13_66 = false;
                                                                                            var14_77 = null;
                                                                                            break block112;
                                                                                        }
                                                                                    }
                                                                                    catch (Throwable var12_53) {
                                                                                        try {
                                                                                            var8_47.close();
                                                                                            throw var12_53;
                                                                                        }
                                                                                        catch (Exception var12_55) {
                                                                                            var13_67 = false;
                                                                                            var14_77 = null;
                                                                                            var16_79 = var12_55;
                                                                                            var12_51 = var3_9;
                                                                                            var3_9 = var16_79;
                                                                                            break block113;
                                                                                        }
                                                                                        catch (IOException var12_56) {
                                                                                            var13_68 = false;
                                                                                            var14_77 = null;
                                                                                            var16_80 = var12_56;
                                                                                            var12_51 = var3_9;
                                                                                            var3_9 = var16_80;
                                                                                            break block114;
                                                                                        }
                                                                                        catch (MalformedURLException var12_57) {
                                                                                            var13_69 = false;
                                                                                            var14_77 = null;
                                                                                            var16_81 = var12_57;
                                                                                            var12_51 = var3_9;
                                                                                            var3_9 = var16_81;
                                                                                            break block115;
                                                                                        }
                                                                                        catch (ProtocolException var12_58) {
                                                                                            var13_70 = false;
                                                                                            var14_77 = null;
                                                                                            var16_82 = var12_58;
                                                                                            var12_51 = var3_9;
                                                                                            var3_9 = var16_82;
                                                                                        }
                                                                                    }
                                                                                    break block120;
                                                                                }
                                                                                try {
                                                                                    while ((var15_78 = var14_77.read(var5_32)) != var6_45) {
                                                                                        var8_47.write(var5_32, 0, var15_78);
                                                                                    }
                                                                                    var5_32 = var8_47.toByteArray();
                                                                                    var7_46 = var14_77;
                                                                                }
                                                                                catch (Throwable var12_52) {
                                                                                    break block112;
                                                                                }
                                                                                catch (Exception var5_33) {
                                                                                    var6_45 = var4_31;
                                                                                    break block108;
                                                                                }
                                                                                catch (IOException var5_34) {
                                                                                    var6_45 = var4_31;
                                                                                    break block109;
                                                                                }
                                                                                catch (MalformedURLException var5_35) {
                                                                                    var6_45 = var4_31;
                                                                                    break block110;
                                                                                }
                                                                                catch (ProtocolException var5_36) {
                                                                                    var6_45 = var4_31;
                                                                                    break block111;
                                                                                }
                                                                            }
                                                                            if (var3_9 != null) {
                                                                                try {
                                                                                    var3_9.close();
                                                                                }
                                                                                catch (IOException var3_10) {
                                                                                    var3_10.printStackTrace();
                                                                                }
                                                                            }
                                                                            if (var7_46 != null) {
                                                                                try {
                                                                                    var7_46.close();
                                                                                }
                                                                                catch (IOException var3_11) {
                                                                                    var3_11.printStackTrace();
                                                                                }
                                                                            }
                                                                            if (var2_2 != null) {
                                                                                try {
                                                                                    var2_2.close();
                                                                                }
                                                                                catch (IOException var2_3) {
                                                                                    var2_3.printStackTrace();
                                                                                }
                                                                            }
                                                                            if (var1_1 != null) {
                                                                                ((HttpURLConnection)var1_1).disconnect();
                                                                            }
                                                                            var7_46 = var5_32;
                                                                            break block121;
                                                                        }
                                                                        var12_51 = var3_9;
                                                                        var3_9 = var5_38;
                                                                        break block113;
                                                                    }
                                                                    var12_51 = var3_9;
                                                                    var3_9 = var5_40;
                                                                    break block114;
                                                                }
                                                                var12_51 = var3_9;
                                                                var3_9 = var5_42;
                                                                break block115;
                                                            }
                                                            var12_51 = var3_9;
                                                            var3_9 = var5_44;
                                                            break block120;
                                                        }
                                                        var7_46 = var3_9;
                                                        var3_9 = var12_51;
                                                        break block101;
                                                    }
                                                    var3_9.printStackTrace();
                                                    if (var12_51 == null) break block116;
                                                    try {
                                                        var12_51.close();
                                                    }
                                                    catch (IOException var3_19) {
                                                        var3_19.printStackTrace();
                                                    }
                                                }
                                                if (var14_77 != null) {
                                                    try {
                                                        var14_77.close();
                                                    }
                                                    catch (IOException var3_20) {
                                                        var3_20.printStackTrace();
                                                    }
                                                }
                                                if (var2_2 != null) {
                                                    try {
                                                        var2_2.close();
                                                    }
                                                    catch (IOException var2_4) {
                                                        var2_4.printStackTrace();
                                                    }
                                                }
                                                if (var1_1 == null) break block122;
                                                break block123;
                                            }
                                            var3_9.printStackTrace();
                                            if (var12_51 == null) break block117;
                                            try {
                                                var12_51.close();
                                            }
                                            catch (IOException var3_22) {
                                                var3_22.printStackTrace();
                                            }
                                        }
                                        if (var14_77 != null) {
                                            try {
                                                var14_77.close();
                                            }
                                            catch (IOException var3_23) {
                                                var3_23.printStackTrace();
                                            }
                                        }
                                        if (var2_2 != null) {
                                            try {
                                                var2_2.close();
                                            }
                                            catch (IOException var2_5) {
                                                var2_5.printStackTrace();
                                            }
                                        }
                                        if (var1_1 == null) break block122;
                                        break block123;
                                    }
                                    var3_9.printStackTrace();
                                    if (var12_51 == null) break block118;
                                    try {
                                        var12_51.close();
                                    }
                                    catch (IOException var3_25) {
                                        var3_25.printStackTrace();
                                    }
                                }
                                if (var14_77 != null) {
                                    try {
                                        var14_77.close();
                                    }
                                    catch (IOException var3_26) {
                                        var3_26.printStackTrace();
                                    }
                                }
                                if (var2_2 != null) {
                                    try {
                                        var2_2.close();
                                    }
                                    catch (IOException var2_6) {
                                        var2_6.printStackTrace();
                                    }
                                }
                                if (var1_1 == null) break block122;
                                break block123;
                            }
                            var3_9.printStackTrace();
                            if (var12_51 == null) break block119;
                            try {
                                var12_51.close();
                            }
                            catch (IOException var3_28) {
                                var3_28.printStackTrace();
                            }
                        }
                        if (var14_77 != null) {
                            try {
                                var14_77.close();
                            }
                            catch (IOException var3_29) {
                                var3_29.printStackTrace();
                            }
                        }
                        if (var2_2 != null) {
                            try {
                                var2_2.close();
                            }
                            catch (IOException var2_7) {
                                var2_7.printStackTrace();
                            }
                        }
                        if (var1_1 == null) break block122;
                    }
                    ((HttpURLConnection)var1_1).disconnect();
                }
                var4_31 = var6_45;
            }
            var1_1 = new StringBuilder();
            var1_1.append("log send completed, http statusCode : ");
            var1_1.append(var4_31);
            var1_1 = var1_1.toString();
            var2_2 = "SendLogDefaultRunnable";
            Log.d((String)var2_2, (String)var1_1);
            var1_1 = this.g;
            if (var1_1 != null) {
                var1_1.a(var4_31, (byte[])var7_46);
            }
            return;
            catch (Throwable var3_30) {
                var7_46 = var12_51;
            }
        }
        if (var7_46 != null) {
            try {
                var7_46.close();
            }
            catch (IOException var12_59) {
                var12_59.printStackTrace();
            }
        }
        if (var14_77 != null) {
            try {
                var14_77.close();
            }
            catch (IOException var12_60) {
                var12_60.printStackTrace();
            }
        }
        if (var2_2 != null) {
            try {
                var2_2.close();
            }
            catch (IOException var2_8) {
                var2_8.printStackTrace();
            }
        }
        if (var1_1 != null) {
            ((HttpURLConnection)var1_1).disconnect();
        }
        throw var3_9;
    }

    private void f(File file, Map map, String string2) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            this.e(string2, fileInputStream, map);
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    public void b(File file) {
        Object object = this.e;
        String string2 = this.f;
        this.f(file, (Map)object, string2);
        this.a();
        object = file.getName();
        string2 = ".copy";
        boolean bl2 = ((String)object).contains(string2);
        if (bl2) {
            file.delete();
        }
    }

    public void g(Map map) {
        Map map2 = this.e;
        map2.clear();
        if (map != null) {
            map2 = this.e;
            map2.putAll(map);
        }
    }

    public void h(k k10) {
        this.g = k10;
    }

    public void i(String string2) {
        this.f = string2;
    }
}

