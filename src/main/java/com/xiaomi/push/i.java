/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.PowerManager
 *  android.os.StatFs
 *  android.provider.Settings$Secure
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.au;
import com.xiaomi.push.ba;
import com.xiaomi.push.bf;
import com.xiaomi.push.j;
import com.xiaomi.push.j$a;
import com.xiaomi.push.l;
import com.xiaomi.push.m;
import com.xiaomi.push.t;
import com.xiaomi.push.u;
import com.xiaomi.push.y;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class i {
    private static String a;
    private static volatile boolean a = false;
    private static final String[] a;
    private static String b = "";
    private static String c;
    private static String d;
    private static final String e;
    private static String f;

    static {
        e = String.valueOf('\u0002');
        a = new String[]{"--", "a-", "u-", "v-", "o-", "g-"};
        f = null;
        a = false;
    }

    private static double a(double d10) {
        double d11;
        double d12;
        double d13;
        int n10 = 1;
        while ((d13 = (d12 = (d11 = (double)n10) - d10) == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1)) < 0) {
            n10 <<= 1;
        }
        return d11;
    }

    private static float a(int n10) {
        n10 = ((n10 + 102400) / 524288 + 1) * 512 * 1024;
        float f10 = n10;
        float f11 = 1024.0f;
        double d10 = f10 = f10 / f11 / f11;
        double d11 = 0.5;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object > 0) {
            d10 = Math.ceil(d10);
            f10 = (float)d10;
        }
        return f10;
    }

    public static int a() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = -1;
        int n12 = 17;
        if (n10 < n12) {
            return n11;
        }
        n10 = 0;
        Object object = new Object[]{};
        String string2 = "android.os.UserHandle";
        String string3 = "myUserId";
        if ((object = ba.a(string2, string3, object)) == null) {
            return n11;
        }
        return (Integer)Integer.class.cast(object);
    }

    private static int a(String string2) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            return 0;
        }
        n10 = string2.length();
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            n11 *= 31;
            char c10 = string2.charAt(i10);
            n11 += c10;
        }
        return n11;
    }

    private static long a(File object) {
        long l10;
        long l11;
        object = ((File)object).getPath();
        StatFs statFs = new StatFs((String)object);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            l11 = statFs.getBlockCountLong();
            l10 = statFs.getBlockSizeLong();
        } else {
            l11 = statFs.getBlockCount();
            n10 = statFs.getBlockSize();
            l10 = n10;
        }
        return l10 * l11;
    }

    public static String a() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        Object object = null;
        int n12 = 8;
        if (n10 > n12 && n10 < n11) {
            object = Build.SERIAL;
        } else if (n10 >= n11) {
            Object object2;
            String string2 = "getSerial";
            object = object2 = ba.a("android.os.Build", string2, null);
            object = (String)object2;
        }
        return object;
    }

    private static String a(int n10) {
        String[] stringArray;
        int n11;
        if (n10 > 0 && n10 < (n11 = (stringArray = a).length)) {
            return stringArray[n10];
        }
        return a[0];
    }

    public static String a(Context object) {
        object = i.e(object);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a-");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append((String)null);
        stringBuilder2.append((String)object);
        stringBuilder2.append((String)null);
        object = bf.b(stringBuilder2.toString());
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public static String a(Context context, boolean bl2) {
        CharSequence charSequence = c;
        if (charSequence == null) {
            StringBuilder stringBuilder;
            charSequence = i.e(context);
            boolean bl3 = l.d();
            CharSequence charSequence2 = !bl3 ? (bl2 ? i.f(context) : i.p(context)) : "";
            CharSequence charSequence3 = i.a();
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 26;
            float f10 = 3.6E-44f;
            int n12 = 1;
            if (n10 < n11) {
                n10 = n12;
            } else {
                n10 = 0;
                stringBuilder = null;
            }
            n11 = 3;
            f10 = 4.2E-45f;
            if (n10 == 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)charSequence2) ? 1 : 0)) != 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)charSequence3) ? 1 : 0)) != 0) {
                charSequence2 = au.a(context).a();
                bl3 = TextUtils.isEmpty((CharSequence)charSequence2);
                if (!bl3) {
                    charSequence3 = new StringBuilder();
                    ((StringBuilder)charSequence3).append((String)charSequence2);
                    ((StringBuilder)charSequence3).append((String)charSequence);
                    charSequence = ((StringBuilder)charSequence3).toString();
                    n12 = 2;
                } else {
                    charSequence2 = i.o(context);
                    bl3 = TextUtils.isEmpty((CharSequence)charSequence2);
                    if (!bl3) {
                        charSequence = charSequence2;
                        n12 = n11;
                    } else {
                        charSequence2 = au.a(context).b();
                        bl3 = TextUtils.isEmpty((CharSequence)charSequence2);
                        if (!bl3) {
                            n12 = 4;
                            charSequence = charSequence2;
                        } else {
                            n12 = 5;
                        }
                    }
                }
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append((String)charSequence2);
                stringBuilder.append((String)charSequence);
                stringBuilder.append((String)charSequence3);
                charSequence = stringBuilder.toString();
            }
            charSequence2 = new StringBuilder();
            charSequence3 = "devid rule select:";
            ((StringBuilder)charSequence2).append((String)charSequence3);
            ((StringBuilder)charSequence2).append(n12);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            com.xiaomi.channel.commonutils.logger.b.b((String)charSequence2);
            if (n12 == n11) {
                c = charSequence;
            } else {
                charSequence2 = new StringBuilder();
                charSequence3 = i.a(n12);
                ((StringBuilder)charSequence2).append((String)charSequence3);
                charSequence = bf.b(charSequence);
                ((StringBuilder)charSequence2).append((String)charSequence);
                charSequence2 = ((StringBuilder)charSequence2).toString();
                c = charSequence2;
            }
            charSequence2 = c;
            i.b(context, (String)charSequence2);
        }
        return c;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context var0, String var1_4) {
        var2_5 = new StringBuilder();
        var3_6 = "update vdevid = ";
        var2_5.append(var3_6);
        var2_5.append((String)var1_4);
        var2_5 = var2_5.toString();
        com.xiaomi.channel.commonutils.logger.b.c((String)var2_5);
        var4_7 = TextUtils.isEmpty((CharSequence)var1_4);
        if (var4_7) {
            return;
        }
        i.f = var1_4;
        var1_4 = null;
        var4_7 = i.c(var0 /* !! */ );
        var3_6 = ".vdevid";
        if (var4_7) {
            var5_8 = Environment.getExternalStorageDirectory();
            var2_5 = new File(var5_8, var6_9 = "/.vdevdir/");
            var7_10 = var2_5.exists();
            if (var7_10 && (var7_10 = var2_5.isFile())) {
                var2_5.delete();
            }
            var5_8 = new File((File)var2_5, var3_6);
            var1_4 = u.a(var0 /* !! */ , var5_8);
            y.a(var5_8);
            var2_5 = i.f;
            y.a(var5_8, (String)var2_5);
        }
        var0 /* !! */  = var0 /* !! */ .getFilesDir();
        var2_5 = new File((File)var0 /* !! */ , var3_6);
        var0 /* !! */  = i.f;
        y.a((File)var2_5, (String)var0 /* !! */ );
        if (var1_4 == null) return;
        var1_4.a();
        return;
        {
            catch (IOException var0_2) {}
            {
                var2_5 = new StringBuilder();
                var3_6 = "update vdevid failure :";
                var2_5.append(var3_6);
                var0_3 = var0_2.getMessage();
                var2_5.append(var0_3);
                var0_3 = var2_5.toString();
                com.xiaomi.channel.commonutils.logger.b.a(var0_3);
                if (var1_4 == null) return;
            }
        }
        ** finally { 
lbl48:
        // 1 sources

        if (var1_4 == null) throw var0_1;
        var1_4.a();
        throw var0_1;
    }

    public static boolean a(Context context) {
        String string2;
        int n10;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        int n11 = 0;
        context = context.registerReceiver(null, intentFilter);
        int n12 = 0;
        intentFilter = null;
        if (context != null && ((n10 = context.getIntExtra(string2 = "status", -1)) == (n11 = 2) || n10 == (n11 = 5))) {
            n12 = n10 = 1;
        }
        return n12 != 0;
    }

    public static boolean a(String string2) {
        Object object;
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 != 0) {
            return false;
        }
        for (n11 = 0; n11 < (n10 = ((String[])(object = a)).length); ++n11) {
            boolean bl2 = string2.startsWith((String)(object = object[n11]));
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int b() {
        void var0_9;
        Object object = "/proc/meminfo";
        File file = new File((String)object);
        int n10 = file.exists();
        int n11 = 0;
        if (n10 != 0) {
            void var0_10;
            block27: {
                block26: {
                    block25: {
                        n10 = 0;
                        Object var0_1 = null;
                        Object object2 = new FileReader((String)object);
                        int n12 = 8192;
                        object = new BufferedReader((Reader)object2, n12);
                        String string22 = ((BufferedReader)object).readLine();
                        int n13 = TextUtils.isEmpty((CharSequence)string22);
                        if (n13 != 0) break block25;
                        object2 = "\\s+";
                        String[] stringArray = string22.split((String)object2);
                        if (stringArray == null) break block25;
                        n13 = stringArray.length;
                        n12 = 2;
                        if (n13 < n12) break block25;
                        n13 = 1;
                        String string3 = stringArray[n13];
                        n12 = (int)(TextUtils.isDigitsOnly((CharSequence)string3) ? 1 : 0);
                        if (n12 == 0) break block25;
                        String string4 = stringArray[n13];
                        n11 = n10 = Integer.parseInt(string4);
                    }
                    ((BufferedReader)object).close();
                    return n11;
                    catch (Throwable throwable) {
                        break block26;
                    }
                    catch (Exception exception) {
                        Object object3 = object;
                        break block27;
                    }
                    catch (Throwable throwable) {
                        object = null;
                        Throwable throwable2 = throwable;
                    }
                }
                if (object != null) {
                    ((BufferedReader)object).close();
                }
                throw var0_9;
                catch (Exception exception) {}
            }
            if (var0_10 != null) {
                var0_10.close();
            }
        }
        return n11;
        catch (IOException iOException) {
            throw var0_9;
        }
        catch (IOException iOException) {
            return n11;
        }
    }

    public static String b() {
        StringBuilder stringBuilder = new StringBuilder();
        float f10 = i.a(i.b());
        stringBuilder.append(f10);
        stringBuilder.append("GB");
        return stringBuilder.toString();
    }

    public static String b(Context object) {
        try {
            object = j.a((Context)object);
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("failure to get gaid:");
            String string2 = exception.getMessage();
            stringBuilder.append(string2);
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            return null;
        }
        return ((j$a)object).a();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void b(Context var0, String var1_4) {
        var2_5 = new StringBuilder();
        var3_6 = "write lvdd = ";
        var2_5.append((String)var3_6);
        var2_5.append((String)var1_4);
        var2_5 = var2_5.toString();
        com.xiaomi.channel.commonutils.logger.b.c((String)var2_5);
        var4_7 = TextUtils.isEmpty((CharSequence)var1_4);
        if (var4_7) {
            return;
        }
        var4_7 = false;
        var1_4 = null;
        var5_8 = i.c((Context)var0);
        if (var5_8 != 0) {
            var3_6 = Environment.getExternalStorageDirectory();
            var2_5 = new File((File)var3_6, var6_9 = "/.vdevdir/");
            var7_10 = var2_5.exists();
            if (var7_10 && (var7_10 = var2_5.isFile())) {
                var2_5.delete();
            }
            if ((var5_8 = (var3_6 = new File((File)var2_5, var6_9 = ".vdevidlocal")).exists()) != 0 && (var5_8 = var3_6.isFile()) != 0) {
                var0 = "vdr exists, not rewrite.";
                com.xiaomi.channel.commonutils.logger.b.b((String)var0);
                return;
            }
            var1_4 = u.a((Context)var0, (File)var3_6);
            y.a((File)var3_6);
            var0 = new StringBuilder();
            var2_5 = i.c;
            var0.append((String)var2_5);
            var2_5 = i.e;
            var0.append((String)var2_5);
            var2_5 = i.c;
            var5_8 = i.a((String)var2_5);
            var0.append(var5_8);
            var0 = var0.toString();
            y.a((File)var3_6, (String)var0);
            var0 = "lvdd write succ.";
            com.xiaomi.channel.commonutils.logger.b.b((String)var0);
        } else {
            var0 = "not support write lvdd.";
            com.xiaomi.channel.commonutils.logger.b.a((String)var0);
        }
        if (var1_4 == null) return;
        var1_4.a();
        return;
        {
            catch (IOException var0_2) {}
            {
                var2_5 = new StringBuilder();
                var3_6 = "write lvdd failure :";
                var2_5.append((String)var3_6);
                var0_3 = var0_2.getMessage();
                var2_5.append(var0_3);
                var0_3 = var2_5.toString();
                com.xiaomi.channel.commonutils.logger.b.a(var0_3);
                if (var1_4 == null) return;
            }
        }
        ** finally { 
lbl62:
        // 1 sources

        if (var1_4 == null) throw var0_1;
        var1_4.a();
        throw var0_1;
    }

    public static boolean b(Context context) {
        boolean bl2;
        String string2 = "power";
        if ((context = (PowerManager)context.getSystemService(string2)) != null && !(bl2 = context.isScreenOn())) {
            bl2 = false;
            context = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private static boolean b(String string2) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 != 0) {
            return false;
        }
        n11 = string2.length();
        if (n11 <= (n10 = 15) && (n11 = string2.length()) >= (n10 = 14)) {
            n11 = (int)(bf.b(string2) ? 1 : 0);
            if (n11 == 0) {
                return false;
            }
            boolean bl2 = bf.c(string2);
            return !bl2;
        }
        return false;
    }

    private static int c() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        n10 = n10 < n11 ? 10 : 0;
        return n10;
    }

    public static String c() {
        double d10 = i.a(Environment.getDataDirectory());
        double d11 = 1024.0;
        d10 = i.a(d10 / d11 / d11 / d11);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d10);
        stringBuilder.append("GB");
        return stringBuilder.toString();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String c(Context object) {
        Throwable throwable2222222;
        boolean bl2 = i.c(object);
        u u10 = null;
        if (!bl2) {
            return null;
        }
        Object object2 = f;
        bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            return f;
        }
        Object object3 = object.getFilesDir();
        String string2 = ".vdevid";
        object2 = new File((File)object3, string2);
        f = object2 = y.a((File)object2);
        bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            return f;
        }
        object3 = Environment.getExternalStorageDirectory();
        String string3 = "/.vdevdir/";
        object2 = new File((File)object3, string3);
        object3 = new File((File)object2, string2);
        u10 = u.a(object, (File)object3);
        object = "";
        f = object;
        object = y.a((File)object3);
        if (object != null) {
            f = object;
        }
        object = f;
        if (u10 != null) {
            u10.a();
        }
        return object;
        {
            catch (Throwable throwable2222222) {
            }
            catch (IOException iOException) {}
            {
                object2 = new StringBuilder();
                object3 = "getVDevID failure :";
                ((StringBuilder)object2).append((String)object3);
                String string4 = iOException.getMessage();
                ((StringBuilder)object2).append(string4);
                string4 = ((StringBuilder)object2).toString();
                com.xiaomi.channel.commonutils.logger.b.a(string4);
                if (u10 != null) {
                    u10.a();
                }
                return f;
            }
        }
        if (u10 != null) {
            u10.a();
        }
        throw throwable2222222;
    }

    private static boolean c(Context context) {
        String string2 = "android.permission.WRITE_EXTERNAL_STORAGE";
        int n10 = m.a(context, string2);
        boolean bl2 = false;
        if (n10 == 0) {
            return false;
        }
        n10 = l.a();
        if (n10 != 0) {
            return false;
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            bl2 = true;
        }
        if (!bl2) {
            return t.a(context);
        }
        return bl2;
    }

    public static String d() {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = i.b();
        stringBuilder.append(n10);
        stringBuilder.append("KB");
        return stringBuilder.toString();
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public static String d(Context object) {
        boolean bl2 = i.c((Context)object);
        Object object2 = null;
        if (bl2 && !(bl2 = a)) {
            void var0_3;
            block25: {
                int n10;
                Object object3;
                Object object4;
                String string2;
                Object object5;
                block23: {
                    String string3;
                    block24: {
                        a = bl2 = true;
                        object5 = object.getFilesDir();
                        string2 = ".vdevid";
                        object4 = new File((File)object5, string2);
                        object4 = y.a((File)object4);
                        object3 = Environment.getExternalStorageDirectory();
                        string3 = "/.vdevdir/";
                        object5 = new File((File)object3, string3);
                        object3 = new File((File)object5, string2);
                        object5 = u.a((Context)object, object3);
                        try {
                            string2 = y.a(object3);
                            if (object5 != null) {
                                ((u)object5).a();
                            }
                            break block23;
                        }
                        catch (IOException iOException) {
                            break block24;
                        }
                        catch (Throwable throwable) {
                            break block25;
                        }
                        catch (IOException iOException) {
                            n10 = 0;
                            object5 = null;
                        }
                    }
                    object3 = new StringBuilder();
                    string3 = "check id failure :";
                    ((StringBuilder)object3).append(string3);
                    string2 = ((Throwable)((Object)string2)).getMessage();
                    ((StringBuilder)object3).append(string2);
                    string2 = ((StringBuilder)object3).toString();
                    try {
                        com.xiaomi.channel.commonutils.logger.b.a(string2);
                        if (object5 != null) {
                            ((u)object5).a();
                        }
                        string2 = null;
                    }
                    catch (Throwable throwable) {
                        object2 = object5;
                    }
                }
                if ((n10 = TextUtils.isEmpty((CharSequence)object4)) == 0) {
                    int n11;
                    f = object4;
                    n10 = TextUtils.isEmpty((CharSequence)string2);
                    if (n10 == 0 && (n10 = string2.length()) <= (n11 = 128)) {
                        boolean bl3 = TextUtils.equals((CharSequence)object4, (CharSequence)string2);
                        if (!bl3) {
                            com.xiaomi.channel.commonutils.logger.b.a("vid changed, need sync");
                            return string2;
                        }
                    } else {
                        object5 = new StringBuilder();
                        object3 = "recover vid :";
                        ((StringBuilder)object5).append((String)object3);
                        ((StringBuilder)object5).append(string2);
                        object5 = ((StringBuilder)object5).toString();
                        com.xiaomi.channel.commonutils.logger.b.a((String)object5);
                        i.a((Context)object, (String)object4);
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append("vdevid = ");
                    object4 = f;
                    ((StringBuilder)object).append((String)object4);
                    ((StringBuilder)object).append(" ");
                    ((StringBuilder)object).append(string2);
                    com.xiaomi.channel.commonutils.logger.b.c(((StringBuilder)object).toString());
                    return null;
                }
                com.xiaomi.channel.commonutils.logger.b.a("empty local vid");
                return "F*";
            }
            if (object2 != null) {
                ((u)object2).a();
            }
            throw var0_3;
        }
        return null;
    }

    private static boolean d(Context context) {
        String string2;
        String string3 = context.getPackageName();
        int n10 = (context = context.getPackageManager()).checkPermission(string2 = "android.permission.READ_PHONE_STATE", string3);
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            context = null;
        }
        return n10 != 0;
    }

    public static String e() {
        long l10 = i.a(Environment.getDataDirectory());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l10 /= 1024L);
        stringBuilder.append("KB");
        return stringBuilder.toString();
    }

    public static String e(Context object) {
        object = object.getContentResolver();
        String string2 = "android_id";
        try {
            object = Settings.Secure.getString((ContentResolver)object, (String)string2);
        }
        catch (Throwable throwable) {
            com.xiaomi.channel.commonutils.logger.b.a(throwable);
            object = null;
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String f(Context context) {
        int n10 = i.c();
        String string2 = i.g(context);
        while (string2 == null) {
            int n11 = n10 + -1;
            if (n10 <= 0) break;
            long l10 = 500L;
            try {
                Thread.sleep(l10);
            }
            catch (InterruptedException interruptedException) {}
            string2 = i.g(context);
            n10 = n11;
        }
        return string2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static String g(Context var0) {
        block29: {
            block26: {
                var1_1 = l.d();
                var2_2 = "";
                if (var1_1) {
                    return var2_2;
                }
                var3_3 = i.a;
                if (var3_3 != null) {
                    return var3_3;
                }
                var1_1 = false;
                var3_3 = null;
                var4_4 = l.a();
                if (!var4_4) ** GOTO lbl-1000
                var5_5 = "miui.telephony.TelephonyManager";
                var6_6 = "getDefault";
                var7_7 = 0;
                var8_8 = null;
                var9_9 = new Object[]{};
                var5_5 = ba.a((String)var5_5, (String)var6_6, var9_9);
                if (var5_5 == null) ** GOTO lbl-1000
                var6_6 = "getMiuiDeviceId";
                var8_8 = new Object[]{};
                var5_5 = ba.a(var5_5, (String)var6_6, var8_8);
                if (var5_5 != null && (var10_10 = var5_5 instanceof String) != 0) {
                    var6_6 = String.class;
                    var5_5 = var6_6.cast(var5_5);
                    var5_5 = (String)var5_5;
                } else lbl-1000:
                // 3 sources

                {
                    var4_4 = false;
                    var5_5 = null;
                }
                if (var5_5 == null) {
                    block28: {
                        block27: {
                            var10_10 = i.d(var0 /* !! */ );
                            if (var10_10 == 0) break block26;
                            var6_6 = "phone";
                            var0 /* !! */  = var0 /* !! */ .getSystemService((String)var6_6);
                            var0 /* !! */  = (TelephonyManager)var0 /* !! */ ;
                            var10_10 = Build.VERSION.SDK_INT;
                            var7_7 = 26;
                            if (var10_10 >= var7_7) break block27;
                            var5_5 = var0 /* !! */ .getDeviceId();
                            break block26;
                        }
                        var10_10 = 1;
                        var7_7 = var0 /* !! */ .getPhoneType();
                        if (var10_10 != var7_7) break block28;
                        var5_5 = "getImei";
                        var0 /* !! */  = ba.a((Object)var0 /* !! */ , (String)var5_5, null);
lbl60:
                        // 2 sources

                        while (true) {
                            var5_5 = var0 /* !! */ ;
                            var5_5 = (String)var0 /* !! */ ;
                            break block26;
                            break;
                        }
                    }
                    var10_10 = 2;
                    var7_7 = var0 /* !! */ .getPhoneType();
                    if (var10_10 != var7_7) break block26;
                    var5_5 = "getMeid";
                    var0 /* !! */  = ba.a((Object)var0 /* !! */ , (String)var5_5, null);
                    ** continue;
                }
            }
            try {
                var11_11 = i.b((String)var5_5);
                if (!var11_11) break block29;
            }
            catch (Throwable v0) {
                com.xiaomi.channel.commonutils.logger.b.a(v0);
                return null;
            }
            i.a = var5_5;
            return var5_5;
        }
        return var2_2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String h(Context context) {
        int n10 = i.c();
        String string2 = i.j(context);
        while (string2 == null) {
            int n11 = n10 + -1;
            if (n10 <= 0) break;
            long l10 = 500L;
            try {
                Thread.sleep(l10);
            }
            catch (InterruptedException interruptedException) {}
            string2 = i.j(context);
            n10 = n11;
        }
        return string2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String i(Context object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = l.d();
        String string2 = "";
        if (n11 != 0) {
            return string2;
        }
        n11 = 22;
        if (n10 < n11) {
            return string2;
        }
        Object object2 = b;
        n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
        if (n11 == 0) {
            return b;
        }
        n11 = (int)(i.d((Context)object) ? 1 : 0);
        if (n11 == 0) {
            return string2;
        }
        i.g((Context)object);
        object2 = a;
        n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
        if (n11 != 0) {
            return string2;
        }
        object2 = "phone";
        try {
            block13: {
                int n12;
                int n13;
                int n14;
                object = object.getSystemService((String)object2);
                object = (TelephonyManager)object;
                object2 = "getPhoneCount";
                Object[] objectArray = new Object[]{};
                object2 = ba.a(object, (String)object2, objectArray);
                object2 = (Integer)object2;
                if (object2 == null || (n14 = ((Integer)object2).intValue()) <= (n13 = 1)) break block13;
                n14 = 0;
                Object var5_6 = null;
                for (int i10 = 0; i10 < (n12 = ((Integer)object2).intValue()); ++i10) {
                    void var5_7;
                    Object object3;
                    Object object4;
                    block17: {
                        void var5_10;
                        block15: {
                            block16: {
                                block14: {
                                    n12 = 26;
                                    if (n10 >= n12) break block14;
                                    String string3 = "getDeviceId";
                                    object4 = new Object[n13];
                                    object4[0] = object3 = Integer.valueOf(i10);
                                    Object object5 = ba.a(object, string3, (Object[])object4);
                                    break block15;
                                }
                                n12 = object.getPhoneType();
                                if (n13 != n12) break block16;
                                String string4 = "getImei";
                                object4 = new Object[n13];
                                object4[0] = object3 = Integer.valueOf(i10);
                                Object object6 = ba.a(object, string4, (Object[])object4);
                                break block15;
                            }
                            n12 = 2;
                            int n15 = object.getPhoneType();
                            if (n12 != n15) break block17;
                            String string5 = "getMeid";
                            object4 = new Object[n13];
                            object4[0] = object3 = Integer.valueOf(i10);
                            Object object7 = ba.a(object, string5, (Object[])object4);
                        }
                        String string6 = (String)var5_10;
                    }
                    if ((n12 = (int)(TextUtils.isEmpty((CharSequence)var5_7) ? 1 : 0)) != 0 || (n12 = (int)(TextUtils.equals((CharSequence)(object4 = a), (CharSequence)var5_7) ? 1 : 0)) != 0 || (n12 = (int)(i.b((String)var5_7) ? 1 : 0)) == 0) continue;
                    object4 = new StringBuilder();
                    object3 = b;
                    ((StringBuilder)object4).append((String)object3);
                    ((StringBuilder)object4).append((String)var5_7);
                    object3 = ",";
                    ((StringBuilder)object4).append((String)object3);
                    b = object4 = ((StringBuilder)object4).toString();
                }
                object = b;
                int n16 = ((String)object).length();
                if (n16 > 0) {
                    String string7 = b;
                    b = object = string7.substring(0, n16 -= n13);
                }
                return b;
            }
            return string2;
        }
        catch (Exception exception) {
            com.xiaomi.channel.commonutils.logger.b.d(exception.toString());
            return string2;
        }
    }

    public static String j(Context object) {
        i.i((Context)object);
        object = b;
        int n10 = TextUtils.isEmpty((CharSequence)object);
        String string2 = "";
        if (n10 != 0) {
            return string2;
        }
        object = b;
        String string3 = ",";
        for (String string4 : ((String)object).split(string3)) {
            boolean bl2 = i.b(string4);
            if (!bl2) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            string2 = bf.a(string4);
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            string2 = stringBuilder.toString();
        }
        n10 = string2.length();
        if (n10 > 0) {
            string2 = string2.substring(0, n10 += -1);
        }
        return string2;
    }

    public static String k(Context object) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            String string2;
            block11: {
                string2 = d;
                if (string2 == null) break block11;
                return string2;
            }
            object = i.e(object);
            string2 = i.a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
            object = stringBuilder.toString();
            object = bf.b((String)object);
            d = object;
            return object;
        }
    }

    public static String l(Context object) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            object = i.e(object);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append((String)null);
            object = stringBuilder.toString();
            object = bf.b((String)object);
            return object;
        }
    }

    public static String m(Context context) {
        return ((TelephonyManager)context.getSystemService("phone")).getSimOperatorName();
    }

    public static String n(Context context) {
        return "";
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String o(Context var0) {
        block18: {
            block19: {
                block17: {
                    block16: {
                        var1_1 = i.c(var0 /* !! */ );
                        var2_2 = null;
                        if (var1_1 == 0) {
                            com.xiaomi.channel.commonutils.logger.b.a("not support read lvdd.");
                            return null;
                        }
                        var4_9 = Environment.getExternalStorageDirectory();
                        var5_10 = "/.vdevdir/";
                        var3_3 /* !! */  = new File((File)var4_9, var5_10);
                        var5_10 = ".vdevidlocal";
                        var4_9 = new Comparable<File>((File)var3_3 /* !! */ , var5_10);
                        var1_1 = var4_9.exists();
                        if (var1_1 == 0 || (var1_1 = var4_9.isFile()) == 0) break block16;
                        var0 /* !! */  = u.a(var0 /* !! */ , var4_9);
                        try {
                            var3_3 /* !! */  = y.a(var4_9);
                            var6_11 = TextUtils.isEmpty((CharSequence)var3_3 /* !! */ );
                            if (var6_11 != 0 || (var6_11 = (var3_3 /* !! */  = var3_3 /* !! */ .split(var5_10 = i.e)).length) != (var7_12 = 2)) break block17;
                            var6_11 = 0;
                            var5_10 = null;
                            var5_10 = var3_3 /* !! */ [0];
                            var7_12 = 1;
                            var3_3 /* !! */  = var3_3 /* !! */ [var7_12];
                            var1_1 = Integer.parseInt((String)var3_3 /* !! */ );
                            var7_12 = i.a(var5_10);
                            if (var7_12 == var1_1) {
                                var2_2 = var5_10;
                            }
                            break block17;
                        }
                        catch (Throwable var3_4) {
                            var2_2 = var0 /* !! */ ;
                            break block18;
                        }
                    }
                    var0 /* !! */  = "lvdf not exists";
                    com.xiaomi.channel.commonutils.logger.b.b((String)var0 /* !! */ );
                    var0 /* !! */  = null;
                    break block19;
                    catch (Exception v0) {}
                }
                try {
                    var1_1 = TextUtils.isEmpty((CharSequence)var2_2);
                    if (var1_1 != 0) {
                        y.a(var4_9);
                        var3_3 /* !! */  = "lvdd content invalid, remove it.";
                        com.xiaomi.channel.commonutils.logger.b.b((String)var3_3 /* !! */ );
                    }
                    var8_13 = var2_2;
                    var2_2 = var0 /* !! */ ;
                    var0 /* !! */  = var8_13;
                }
                catch (IOException var3_5) {
                    var8_14 = var2_2;
                    var2_2 = var0 /* !! */ ;
                    var0 /* !! */  = var8_14;
                    ** GOTO lbl-1000
                }
            }
            if (var2_2 == null) return var0 /* !! */ ;
lbl59:
            // 2 sources

            while (true) {
                var2_2.a();
                return var0 /* !! */ ;
            }
            catch (Throwable var3_6) {
                break block18;
            }
            catch (IOException var3_7) {
                var0 /* !! */  = null;
            }
lbl-1000:
            // 2 sources

            {
                var4_9 = new Comparable<File>();
                var5_10 = "get lvdd failure :";
                var4_9.append(var5_10);
                var3_3 /* !! */  = var3_3 /* !! */ .getMessage();
                var4_9.append((String)var3_3 /* !! */ );
                var3_3 /* !! */  = var4_9.toString();
                com.xiaomi.channel.commonutils.logger.b.a((String)var3_3 /* !! */ );
                if (var2_2 == null) return var0 /* !! */ ;
                ** continue;
            }
        }
        if (var2_2 == null) throw var3_8;
        var2_2.a();
        throw var3_8;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String p(Context context) {
        int n10;
        int n11 = i.c();
        String string2 = i.g(context);
        while ((n10 = TextUtils.isEmpty((CharSequence)string2)) != 0) {
            n10 = n11 + -1;
            if (n11 <= 0) break;
            long l10 = 500L;
            try {
                Thread.sleep(l10);
            }
            catch (InterruptedException interruptedException) {}
            string2 = i.g(context);
            n11 = n10;
        }
        return string2;
    }
}

