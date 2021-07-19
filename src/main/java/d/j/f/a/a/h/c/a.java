/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.j.f.a.a.h.c;

import android.text.TextUtils;
import d.j.f.a.a.h.f.c;
import d.j.f.a.a.h.f.f;
import d.j.f.a.a.h.f.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class a {
    private static final int a = 8192;
    private static final String b = "SHA-256";
    private static final String c = "a";
    private static final String d = "";
    private static final String[] e = new String[]{"SHA-256", "SHA-384", "SHA-512"};

    private static boolean a(File file) {
        long l10;
        long l11;
        long l12;
        int n10;
        boolean bl2;
        if (file != null && (bl2 = file.exists()) && (n10 = (l12 = (l11 = file.length()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            file = null;
        }
        return n10 != 0;
    }

    private static boolean b(String string2) {
        for (String string3 : e) {
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static String c(File file) {
        return d.j.f.a.a.h.c.a.d(file, b);
    }

    /*
     * Unable to fully structure code
     */
    public static String d(File var0, String var1_8) {
        block33: {
            block32: {
                block31: {
                    block30: {
                        var2_9 = TextUtils.isEmpty((CharSequence)var1_8);
                        var3_10 = "";
                        if (var2_9 || !(var2_9 = d.j.f.a.a.h.c.a.b((String)var1_8))) break block33;
                        var2_9 = d.j.f.a.a.h.c.a.a((File)var0);
                        if (!var2_9) {
                            g.f(d.j.f.a.a.h.c.a.c, "file is not valid");
                            return var3_10;
                        }
                        var2_9 = false;
                        var4_11 = null;
                        var1_8 = MessageDigest.getInstance((String)var1_8);
                        var3_10 = new FileInputStream((File)var0);
                        var5_12 = 8192;
                        try {
                            var0 = new byte[var5_12];
                            var6_13 = null;
                            var7_14 = false;
                            var8_15 = null;
                        }
                        catch (IOException var0_1) {
                            break block30;
                        }
                        catch (NoSuchAlgorithmException var0_2) {
                            break block31;
                        }
                        while (true) {
                            var9_16 = var3_10.read((byte[])var0);
                            if (var9_16 <= 0) break;
                            var1_8.update((byte[])var0, 0, var9_16);
                            var7_14 = true;
                            continue;
                            break;
                        }
                        if (var7_14) {
                            var0 = var1_8.digest();
                            var4_11 = d.j.f.a.a.h.f.c.b((byte[])var0);
                        }
lbl33:
                        // 5 sources

                        while (true) {
                            continue;
                            break;
                        }
                        catch (Throwable var0_3) {
                            break block32;
                        }
                        catch (IOException var0_4) {
                            var3_10 = null;
                        }
                    }
                    var1_8 = d.j.f.a.a.h.c.a.c;
                    var6_13 = new StringBuilder();
                    var8_15 = "IOException";
                    var6_13.append(var8_15);
                    var0 = var0.getMessage();
                    var6_13.append((String)var0);
                    var0 = var6_13.toString();
                    g.f((String)var1_8, (String)var0);
                    ** GOTO lbl33
                    catch (NoSuchAlgorithmException var0_5) {
                        var3_10 = null;
                    }
                }
                var1_8 = d.j.f.a.a.h.c.a.c;
                var6_13 = new StringBuilder();
                var8_15 = "NoSuchAlgorithmException";
                var6_13.append(var8_15);
                var0 = var0.getMessage();
                var6_13.append((String)var0);
                var0 = var6_13.toString();
                try {
                    g.f((String)var1_8, (String)var0);
                    ** continue;
                }
                catch (Throwable var0_6) {
                    var4_11 = var3_10;
                }
                f.d((InputStream)var3_10);
                return var4_11;
            }
            f.d(var4_11);
            throw var0_7;
        }
        g.f(d.j.f.a.a.h.c.a.c, "algorithm is empty or not safe");
        return var3_10;
    }

    public static String e(InputStream inputStream) {
        if (inputStream == null) {
            return d;
        }
        return d.j.f.a.a.h.c.a.f(inputStream, b);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String f(InputStream inputStream, String object) {
        Throwable throwable2222222;
        block6: {
            int n10;
            String string2 = d;
            if (inputStream == null) {
                return string2;
            }
            int n11 = 8192;
            Object object2 = new byte[n11];
            object = MessageDigest.getInstance((String)object);
            while ((n10 = inputStream.read((byte[])object2)) >= 0) {
                if (n10 <= 0) continue;
                ((MessageDigest)object).update((byte[])object2, 0, n10);
            }
            object = ((MessageDigest)object).digest();
            object = d.j.f.a.a.h.f.c.b((byte[])object);
            {
                catch (Throwable throwable2222222) {
                    break block6;
                }
                catch (IOException | NoSuchAlgorithmException exception) {}
                {
                    object = c;
                    object2 = "inputstraem exception";
                    g.f((String)object, (String)object2);
                }
                f.d(inputStream);
                return string2;
            }
            f.d(inputStream);
            return object;
        }
        f.d(inputStream);
        throw throwable2222222;
    }

    public static boolean g(File object, String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && (bl2 = d.j.f.a.a.h.c.a.b(string3))) {
            object = d.j.f.a.a.h.c.a.d((File)object, string3);
            return string2.equals(object);
        }
        g.f(c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean h(File object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return false;
        }
        object = d.j.f.a.a.h.c.a.c((File)object);
        return string2.equals(object);
    }

    public static boolean i(InputStream object, String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && (bl2 = d.j.f.a.a.h.c.a.b(string3))) {
            object = d.j.f.a.a.h.c.a.f((InputStream)object, string3);
            return string2.equals(object);
        }
        g.f(c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean j(InputStream object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return false;
        }
        object = d.j.f.a.a.h.c.a.e((InputStream)object);
        return string2.equals(object);
    }
}

