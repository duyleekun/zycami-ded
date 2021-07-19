/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.j.f.a.a.j.o;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import d.j.f.a.a.j.o.e;
import d.j.f.a.a.j.o.h;
import d.j.f.a.a.j.o.i;
import d.j.f.a.a.j.o.j;
import d.j.f.a.a.j.o.k;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class a {
    private static final String a = "BksUtil";
    private static final String b = "com.huawei.hwid";
    private static final String c = "com.huawei.hwid";
    private static final String d = "com.huawei.hms";
    private static final String e = "com.huawei.hwid.tv";
    private static final Uri f = Uri.parse((String)"content://com.huawei.hwid");
    private static final String g = "files/hmsrootcas.bks";
    private static final String h = "4.0.2.300";
    private static final String i = "aegis";
    private static final String j = "hmsrootcas.bks";
    private static final long k = 604800000L;
    private static final String l = "last_update_time";
    private static final String m = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
    private static final String n = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    private static final String o = "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539";
    private static final String[] p = new String[]{"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539"};
    private static final String q = "";
    private static final String r = "bks_hash";

    private a() {
    }

    private static int a(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        int n10 = -1;
        if (bl2) {
            return n10;
        }
        File file = new File(string2);
        boolean bl3 = file.exists();
        String string3 = a;
        if (bl3) {
            d.j.f.a.a.j.o.i.g(string3, "The directory  has already exists");
            return 1;
        }
        bl3 = file.mkdirs();
        if (bl3) {
            d.j.f.a.a.j.o.i.b(string3, "create directory  success");
            return 0;
        }
        d.j.f.a.a.j.o.i.d(string3, "create directory  failed");
        return n10;
    }

    private static String b(Context object) {
        int n10 = Build.VERSION.SDK_INT;
        String string2 = i;
        int n11 = 24;
        if (n10 >= n11) {
            StringBuilder stringBuilder = new StringBuilder();
            object = object.createDeviceProtectedStorageContext().getFilesDir();
            stringBuilder.append(object);
            object = File.separator;
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
            object = stringBuilder.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            object = object.getApplicationContext().getFilesDir();
            stringBuilder.append(object);
            object = File.separator;
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
            object = stringBuilder.toString();
        }
        return object;
    }

    private static String c(byte[] byArray) {
        int n10;
        if (byArray != null && (n10 = byArray.length) != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            int n11 = byArray.length;
            for (int i10 = 0; i10 < n11; ++i10) {
                int n12;
                int n13 = byArray[i10] & 0xFF;
                String string2 = Integer.toHexString(n13);
                int n14 = string2.length();
                if (n14 == (n12 = 1)) {
                    n14 = 48;
                    stringBuilder.append((char)n14);
                }
                stringBuilder.append(string2);
            }
            return stringBuilder.toString();
        }
        return q;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void d(InputStream object, Context object2) {
        void var0_3;
        block11: {
            Object object3;
            int n10;
            String string2 = a;
            if (object == null) return;
            if (object2 == null) {
                return;
            }
            Object object4 = new File((String)(object2 = d.j.f.a.a.j.o.a.b(object2)));
            boolean bl2 = ((File)object4).exists();
            if (!bl2) {
                d.j.f.a.a.j.o.a.a((String)object2);
            }
            if ((n10 = ((File)(object4 = new File((String)object2, (String)(object3 = j)))).exists()) != 0) {
                ((File)object4).delete();
            }
            n10 = 0;
            object2 = null;
            object3 = "write output stream ";
            d.j.f.a.a.j.o.i.e(string2, (String)object3);
            object3 = new FileOutputStream((File)object4);
            n10 = 2048;
            {
                block12: {
                    catch (Throwable throwable) {
                        // empty catch block
                        break block11;
                    }
                    catch (IOException iOException) {
                        break block12;
                    }
                    try {
                        int n11;
                        int n12;
                        object4 = new byte[n10];
                        while ((n12 = ((InputStream)object).read((byte[])object4, 0, n10)) != (n11 = -1)) {
                            ((OutputStream)object3).write((byte[])object4, 0, n12);
                        }
                    }
                    catch (Throwable throwable) {
                        object2 = object3;
                        break block11;
                    }
                    catch (IOException iOException) {}
                    d.j.f.a.a.j.o.h.h((OutputStream)object3);
                    return;
                    object2 = object3;
                }
                object = " IOException";
                {
                    d.j.f.a.a.j.o.i.d(string2, (String)object);
                }
                d.j.f.a.a.j.o.h.h((OutputStream)object2);
            }
            return;
        }
        d.j.f.a.a.j.o.h.h((OutputStream)object2);
        throw var0_3;
    }

    private static boolean e(int n10) {
        int n11 = 40002300;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    private static byte[] f(Context signature, String charSequence) {
        int n10;
        String string2 = a;
        if (signature != null && (n10 = TextUtils.isEmpty((CharSequence)charSequence)) == 0) {
            block8: {
                signature = signature.getPackageManager();
                if (signature == null) break block8;
                n10 = 64;
                signature = signature.getPackageInfo((String)charSequence, n10);
                if (signature == null) break block8;
                signature = signature.signatures;
                signature = signature[0];
                try {
                    return signature.toByteArray();
                }
                catch (Exception exception) {
                    charSequence = new StringBuilder();
                    String string3 = "get pm exception : ";
                    ((StringBuilder)charSequence).append(string3);
                    String string4 = exception.getMessage();
                    ((StringBuilder)charSequence).append(string4);
                    string4 = ((StringBuilder)charSequence).toString();
                    Log.e((String)string2, (String)string4);
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    charSequence = new StringBuilder();
                    String string5 = "PackageManager.NameNotFoundException : ";
                    ((StringBuilder)charSequence).append(string5);
                    String string6 = nameNotFoundException.getMessage();
                    ((StringBuilder)charSequence).append(string6);
                    string6 = ((StringBuilder)charSequence).toString();
                    Log.e((String)string2, (String)string6);
                }
            }
            return new byte[0];
        }
        Log.e((String)string2, (String)"packageName is null or context is null");
        return new byte[0];
    }

    private static String g(Context object) {
        StringBuilder stringBuilder = new StringBuilder();
        object = d.j.f.a.a.j.o.a.b(object);
        stringBuilder.append((String)object);
        object = File.separator;
        stringBuilder.append((String)object);
        stringBuilder.append(j);
        return stringBuilder.toString();
    }

    private static String h(byte[] byArray) {
        String string2 = q;
        if (byArray == null) {
            return string2;
        }
        Object object = "SHA-256";
        try {
            object = MessageDigest.getInstance((String)object);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            d.j.f.a.a.j.o.i.d(a, "inputstraem exception");
            return string2;
        }
        ((MessageDigest)object).update(byArray);
        byArray = ((MessageDigest)object).digest();
        return d.j.f.a.a.j.o.a.c(byArray);
    }

    private static boolean i(Context object, String string2) {
        object = d.j.f.a.a.j.o.a.k(d.j.f.a.a.j.o.a.f(object, string2));
        return o.equalsIgnoreCase((String)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean j(String stringArray) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)stringArray);
        boolean bl3 = false;
        if (bl2) {
            return false;
        }
        Object object = new StringBuilder();
        ((StringBuilder)object).append("hms version code is : ");
        ((StringBuilder)object).append((String)stringArray);
        object = ((StringBuilder)object).toString();
        String string2 = a;
        d.j.f.a.a.j.o.i.e(string2, (String)object);
        object = "\\.";
        stringArray = stringArray.split((String)object);
        String string3 = h;
        object = string3.split((String)object);
        int n10 = stringArray.length;
        int n11 = ((String[])object).length;
        int n12 = Math.max(n10, n11);
        int n13 = 0;
        while (true) {
            int n14;
            int n15;
            boolean bl4;
            block11: {
                String string4;
                block10: {
                    Exception exception2;
                    block9: {
                        block8: {
                            String string5;
                            bl4 = true;
                            if (n13 >= n12) {
                                return bl4;
                            }
                            if (n13 < n10) {
                                try {
                                    string5 = stringArray[n13];
                                    n15 = Integer.parseInt(string5);
                                    break block8;
                                }
                                catch (Exception exception2) {
                                    break block9;
                                }
                            }
                            n15 = 0;
                            string5 = null;
                        }
                        if (n13 >= n11) break block10;
                        string4 = object[n13];
                        n14 = Integer.parseInt(string4);
                        break block11;
                    }
                    object = new StringBuilder();
                    string3 = " exception : ";
                    ((StringBuilder)object).append(string3);
                    String string6 = exception2.getMessage();
                    ((StringBuilder)object).append(string6);
                    string6 = ((StringBuilder)object).toString();
                    d.j.f.a.a.j.o.i.d(string2, string6);
                    if (n13 < n11) return bl3;
                    return bl4;
                }
                n14 = 0;
                string4 = null;
            }
            if (n15 < n14) {
                return false;
            }
            if (n15 > n14) {
                return bl4;
            }
            ++n13;
        }
    }

    private static String k(byte[] byArray) {
        int n10;
        String string2 = q;
        if (byArray != null && (n10 = byArray.length) != 0) {
            Object object = "SHA-256";
            object = MessageDigest.getInstance((String)object);
            byArray = ((MessageDigest)object).digest(byArray);
            try {
                string2 = d.j.f.a.a.j.o.a.c(byArray);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                object = new StringBuilder();
                String string3 = "NoSuchAlgorithmException";
                ((StringBuilder)object).append(string3);
                String string4 = noSuchAlgorithmException.getMessage();
                ((StringBuilder)object).append(string4);
                string4 = ((StringBuilder)object).toString();
                object = a;
                Log.e((String)object, (String)string4);
            }
        }
        return string2;
    }

    private static boolean l(Context object) {
        Comparable<StringBuilder> comparable = new Comparable<StringBuilder>();
        object = d.j.f.a.a.j.o.a.b(object);
        ((StringBuilder)comparable).append((String)object);
        object = File.separator;
        ((StringBuilder)comparable).append((String)object);
        ((StringBuilder)comparable).append(j);
        object = ((StringBuilder)comparable).toString();
        comparable = new Comparable<StringBuilder>((String)object);
        return ((File)comparable).exists();
    }

    private static boolean m(Context object, String stringArray) {
        object = d.j.f.a.a.j.o.a.f(object, (String)stringArray);
        for (String string2 : p) {
            String string3 = d.j.f.a.a.j.o.a.k((byte[])object);
            boolean bl2 = string2.equalsIgnoreCase(string3);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static InputStream n(Context var0) {
        var1_5 = a.class;
        synchronized (var1_5) {
            block23: {
                block24: {
                    block26: {
                        var2_6 = "BksUtil";
                        var3_7 = "get bks from tss begin";
                        d.j.f.a.a.j.o.i.e((String)var2_6, (String)var3_7);
                        if (var0 != null) {
                            d.j.f.a.a.j.o.e.b((Context)var0);
                        }
                        var0 = d.j.f.a.a.j.o.e.a();
                        var4_8 = false;
                        var2_6 = null;
                        if (var0 == null) {
                            var0 = "BksUtil";
                            var3_7 = "context is null";
                            d.j.f.a.a.j.o.i.d((String)var0, (String)var3_7);
                            return null;
                        }
                        var3_7 = "com.huawei.hwid";
                        var5_9 = d.j.f.a.a.j.o.a.j((String)(var3_7 = d.j.f.a.a.j.o.j.a((String)var3_7)));
                        if (!var5_9) {
                            var3_7 = "com.huawei.hms";
                            var5_9 = d.j.f.a.a.j.o.a.j((String)(var3_7 = d.j.f.a.a.j.o.j.a((String)var3_7)));
                            if (!var5_9) {
                                var0 = new StringBuilder();
                                var3_7 = "hms version code is too low : ";
                                var0.append((String)var3_7);
                                var3_7 = "com.huawei.hwid";
                                var3_7 = d.j.f.a.a.j.o.j.a((String)var3_7);
                                var0.append((String)var3_7);
                                var0 = var0.toString();
                                var3_7 = "BksUtil";
                                d.j.f.a.a.j.o.i.d((String)var3_7, (String)var0);
                                return null;
                            }
                        }
                        if (!(var5_9 = d.j.f.a.a.j.o.a.m((Context)var0, (String)(var3_7 = "com.huawei.hwid"))) && !(var5_9 = d.j.f.a.a.j.o.a.i((Context)var0, (String)(var3_7 = "com.huawei.hms")))) {
                            var0 = "BksUtil";
                            var3_7 = "hms sign error";
                            d.j.f.a.a.j.o.i.d((String)var0, (String)var3_7);
                            return null;
                        }
                        var3_7 = new ByteArrayOutputStream();
                        var6_10 = d.j.f.a.a.j.o.a.f;
                        var7_11 = "files/hmsrootcas.bks";
                        var6_10 = Uri.withAppendedPath((Uri)var6_10, (String)var7_11);
                        var7_11 = var0.getContentResolver();
                        var6_10 = var7_11.openInputStream((Uri)var6_10);
                        var8_12 = 1024;
                        ** try [egrp 2[TRYBLOCK] [29, 28 : 233->298)] { 
lbl48:
                        // 1 sources

                        break block26;
lbl49:
                        // 1 sources

                        catch (Throwable var0_3) {
                            // empty catch block
                            break block23;
                        }
lbl52:
                        // 1 sources

                        catch (Exception v0) {
                            break block24;
                        }
                        catch (Throwable var0_2) {
                            var6_10 = null;
                            break block23;
                        }
                        catch (Exception v1) {
                            var6_10 = null;
                            break block24;
                        }
                    }
                    var7_11 = new byte[var8_12];
                    while ((var9_13 = var6_10.read((byte[])var7_11)) > (var10_14 = -1)) {
                        var10_14 = 0;
                        var11_15 = null;
                        var3_7.write((byte[])var7_11, 0, var9_13);
                    }
                    var3_7.flush();
                    var12_16 = var3_7.toByteArray();
                    var7_11 = new ByteArrayInputStream((byte[])var12_16);
                    var2_6 = "bks_hash";
                    var12_16 = "";
                    try {
                        var2_6 = d.j.f.a.a.j.o.k.c((String)var2_6, (String)var12_16, (Context)var0);
                        var12_16 = var3_7.toByteArray();
                        var12_16 = d.j.f.a.a.j.o.a.h((byte[])var12_16);
                        var10_14 = (int)d.j.f.a.a.j.o.a.l((Context)var0);
                        if (var10_14 != 0 && (var4_8 = var2_6.equals(var12_16))) {
                            var2_6 = "BksUtil";
                            var12_16 = "bks not update";
                            d.j.f.a.a.j.o.i.e((String)var2_6, (String)var12_16);
                        } else {
                            var2_6 = "BksUtil";
                            var11_15 = "update bks and sp";
                            d.j.f.a.a.j.o.i.e((String)var2_6, var11_15);
                            d.j.f.a.a.j.o.a.d((InputStream)var7_11, (Context)var0);
                            var2_6 = "bks_hash";
                            d.j.f.a.a.j.o.k.i((String)var2_6, (String)var12_16, (Context)var0);
                        }
                    }
                    catch (Throwable var0_1) {
                        var2_6 = var7_11;
                        break block23;
                    }
                    catch (Exception v2) {
                        var2_6 = var7_11;
                        break block24;
                    }
                    d.j.f.a.a.j.o.h.g((InputStream)var6_10);
                    d.j.f.a.a.j.o.h.h((OutputStream)var3_7);
                    d.j.f.a.a.j.o.h.g((InputStream)var7_11);
                    return d.j.f.a.a.j.o.a.o((Context)var0);
                }
                var7_11 = "BksUtil";
                var12_16 = "Get bks from HMS_VERSION_CODE exception : No content provider";
                {
                    d.j.f.a.a.j.o.i.d((String)var7_11, (String)var12_16);
                }
                d.j.f.a.a.j.o.h.g((InputStream)var6_10);
                d.j.f.a.a.j.o.h.h((OutputStream)var3_7);
                d.j.f.a.a.j.o.h.g((InputStream)var2_6);
                return d.j.f.a.a.j.o.a.o((Context)var0);
            }
            d.j.f.a.a.j.o.h.g((InputStream)var6_10);
            d.j.f.a.a.j.o.h.h((OutputStream)var3_7);
            d.j.f.a.a.j.o.h.g((InputStream)var2_6);
            throw var0_4;
        }
    }

    public static InputStream o(Context object) {
        boolean bl2 = d.j.f.a.a.j.o.a.l(object);
        if (bl2) {
            String string2 = a;
            Object object2 = "getFilesBksIS ";
            d.j.f.a.a.j.o.i.e(string2, (String)object2);
            object = d.j.f.a.a.j.o.a.g(object);
            try {
                object2 = new FileInputStream((String)object);
                return object2;
            }
            catch (FileNotFoundException fileNotFoundException) {
                object = "FileNotFoundExceptio: ";
                d.j.f.a.a.j.o.i.d(string2, (String)object);
            }
        }
        return null;
    }
}

