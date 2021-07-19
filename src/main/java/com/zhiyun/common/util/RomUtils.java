/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.text.TextUtils
 */
package com.zhiyun.common.util;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.zhiyun.common.util.RomUtils$a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.Properties;

public final class RomUtils {
    private static final String A = "ro.build.MiFavor_version";
    private static final String B = "ro.rom.version";
    private static final String C = "ro.build.rom.id";
    private static final String D = "unknown";
    private static RomUtils$a E;
    private static final String[] a;
    private static final String[] b;
    private static final String[] c;
    private static final String[] d;
    private static final String[] e;
    private static final String[] f;
    private static final String[] g;
    private static final String[] h;
    private static final String[] i;
    private static final String[] j;
    private static final String[] k;
    private static final String[] l;
    private static final String[] m;
    private static final String[] n;
    private static final String[] o;
    private static final String[] p;
    private static final String[] q;
    private static final String[] r;
    private static final String[] s;
    private static final String[] t;
    private static final String u = "ro.build.version.emui";
    private static final String v = "ro.vivo.os.build.display.id";
    private static final String w = "ro.build.version.incremental";
    private static final String x = "ro.build.version.opporom";
    private static final String y = "ro.letv.release.version";
    private static final String z = "ro.build.uiversion";

    static {
        a = new String[]{"huawei"};
        b = new String[]{"vivo"};
        c = new String[]{"xiaomi"};
        d = new String[]{"oppo"};
        e = new String[]{"leeco", "letv"};
        f = new String[]{"360", "qiku"};
        g = new String[]{"zte"};
        h = new String[]{"oneplus"};
        i = new String[]{"nubia"};
        j = new String[]{"coolpad", "yulong"};
        k = new String[]{"lg", "lge"};
        l = new String[]{"google"};
        m = new String[]{"samsung"};
        n = new String[]{"meizu"};
        o = new String[]{"lenovo"};
        p = new String[]{"smartisan"};
        q = new String[]{"htc"};
        r = new String[]{"sony"};
        s = new String[]{"gionee", "amigo"};
        t = new String[]{"motorola"};
    }

    private RomUtils() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("u can't instantiate me...");
        throw unsupportedOperationException;
    }

    public static boolean A() {
        String string2 = c[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean B() {
        String string2 = g[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    private static String a() {
        block4: {
            String string2;
            try {
                string2 = Build.BRAND;
            }
            catch (Throwable throwable) {}
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) break block4;
            return string2.toLowerCase();
        }
        return D;
    }

    private static String b() {
        block4: {
            String string2;
            try {
                string2 = Build.MANUFACTURER;
            }
            catch (Throwable throwable) {}
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) break block4;
            return string2.toLowerCase();
        }
        return D;
    }

    public static RomUtils$a c() {
        String[] stringArray;
        Object object;
        Object object2 = E;
        if (object2 != null) {
            return object2;
        }
        object2 = new RomUtils$a();
        E = object2;
        object2 = RomUtils.a();
        int n10 = RomUtils.v((String)object2, (String)(object = RomUtils.b()), stringArray = a);
        if (n10 != 0) {
            object2 = E;
            object = stringArray[0];
            RomUtils$a.b((RomUtils$a)object2, (String)object);
            object2 = RomUtils.d(u);
            object = ((String)object2).split("_");
            int n11 = ((String[])object).length;
            n10 = 1;
            if (n11 > n10) {
                object2 = E;
                object = object[n10];
                RomUtils$a.c((RomUtils$a)object2, (String)object);
            } else {
                object = E;
                RomUtils$a.c((RomUtils$a)object, (String)object2);
            }
            return E;
        }
        stringArray = b;
        n10 = RomUtils.v((String)object2, (String)object, stringArray);
        if (n10 != 0) {
            object2 = E;
            object = stringArray[0];
            RomUtils$a.b((RomUtils$a)object2, (String)object);
            object2 = E;
            object = RomUtils.d(v);
            RomUtils$a.c((RomUtils$a)object2, (String)object);
            return E;
        }
        stringArray = c;
        n10 = RomUtils.v((String)object2, (String)object, stringArray);
        if (n10 != 0) {
            object2 = E;
            object = stringArray[0];
            RomUtils$a.b((RomUtils$a)object2, (String)object);
            object2 = E;
            object = RomUtils.d(w);
            RomUtils$a.c((RomUtils$a)object2, (String)object);
            return E;
        }
        stringArray = d;
        n10 = (int)(RomUtils.v((String)object2, (String)object, stringArray) ? 1 : 0);
        if (n10 != 0) {
            object2 = E;
            object = stringArray[0];
            RomUtils$a.b((RomUtils$a)object2, (String)object);
            object2 = E;
            object = RomUtils.d(x);
            RomUtils$a.c((RomUtils$a)object2, (String)object);
            return E;
        }
        stringArray = e;
        n10 = (int)(RomUtils.v((String)object2, (String)object, stringArray) ? 1 : 0);
        if (n10 != 0) {
            object2 = E;
            object = stringArray[0];
            RomUtils$a.b((RomUtils$a)object2, (String)object);
            object2 = E;
            object = RomUtils.d(y);
            RomUtils$a.c((RomUtils$a)object2, (String)object);
            return E;
        }
        stringArray = f;
        n10 = (int)(RomUtils.v((String)object2, (String)object, stringArray) ? 1 : 0);
        if (n10 != 0) {
            object2 = E;
            object = stringArray[0];
            RomUtils$a.b((RomUtils$a)object2, (String)object);
            object2 = E;
            object = RomUtils.d(z);
            RomUtils$a.c((RomUtils$a)object2, (String)object);
            return E;
        }
        stringArray = g;
        n10 = (int)(RomUtils.v((String)object2, (String)object, stringArray) ? 1 : 0);
        if (n10 != 0) {
            object2 = E;
            object = stringArray[0];
            RomUtils$a.b((RomUtils$a)object2, (String)object);
            object2 = E;
            object = RomUtils.d(A);
            RomUtils$a.c((RomUtils$a)object2, (String)object);
            return E;
        }
        stringArray = h;
        n10 = (int)(RomUtils.v((String)object2, (String)object, stringArray) ? 1 : 0);
        if (n10 != 0) {
            object2 = E;
            object = stringArray[0];
            RomUtils$a.b((RomUtils$a)object2, (String)object);
            object2 = E;
            object = RomUtils.d(B);
            RomUtils$a.c((RomUtils$a)object2, (String)object);
            return E;
        }
        stringArray = i;
        n10 = (int)(RomUtils.v((String)object2, (String)object, stringArray) ? 1 : 0);
        if (n10 != 0) {
            object2 = E;
            object = stringArray[0];
            RomUtils$a.b((RomUtils$a)object2, (String)object);
            object2 = E;
            object = RomUtils.d(C);
            RomUtils$a.c((RomUtils$a)object2, (String)object);
            return E;
        }
        stringArray = j;
        n10 = (int)(RomUtils.v((String)object2, (String)object, stringArray) ? 1 : 0);
        if (n10 != 0) {
            object2 = E;
            object = stringArray[0];
            RomUtils$a.b((RomUtils$a)object2, (String)object);
        } else {
            stringArray = k;
            n10 = (int)(RomUtils.v((String)object2, (String)object, stringArray) ? 1 : 0);
            if (n10 != 0) {
                object2 = E;
                object = stringArray[0];
                RomUtils$a.b((RomUtils$a)object2, (String)object);
            } else {
                stringArray = l;
                n10 = (int)(RomUtils.v((String)object2, (String)object, stringArray) ? 1 : 0);
                if (n10 != 0) {
                    object2 = E;
                    object = stringArray[0];
                    RomUtils$a.b((RomUtils$a)object2, (String)object);
                } else {
                    stringArray = m;
                    n10 = (int)(RomUtils.v((String)object2, (String)object, stringArray) ? 1 : 0);
                    if (n10 != 0) {
                        object2 = E;
                        object = stringArray[0];
                        RomUtils$a.b((RomUtils$a)object2, (String)object);
                    } else {
                        stringArray = n;
                        n10 = (int)(RomUtils.v((String)object2, (String)object, stringArray) ? 1 : 0);
                        if (n10 != 0) {
                            object2 = E;
                            object = stringArray[0];
                            RomUtils$a.b((RomUtils$a)object2, (String)object);
                        } else {
                            stringArray = o;
                            n10 = (int)(RomUtils.v((String)object2, (String)object, stringArray) ? 1 : 0);
                            if (n10 != 0) {
                                object2 = E;
                                object = stringArray[0];
                                RomUtils$a.b((RomUtils$a)object2, (String)object);
                            } else {
                                stringArray = p;
                                n10 = (int)(RomUtils.v((String)object2, (String)object, stringArray) ? 1 : 0);
                                if (n10 != 0) {
                                    object2 = E;
                                    object = stringArray[0];
                                    RomUtils$a.b((RomUtils$a)object2, (String)object);
                                } else {
                                    stringArray = q;
                                    n10 = (int)(RomUtils.v((String)object2, (String)object, stringArray) ? 1 : 0);
                                    if (n10 != 0) {
                                        object2 = E;
                                        object = stringArray[0];
                                        RomUtils$a.b((RomUtils$a)object2, (String)object);
                                    } else {
                                        stringArray = r;
                                        n10 = (int)(RomUtils.v((String)object2, (String)object, stringArray) ? 1 : 0);
                                        if (n10 != 0) {
                                            object2 = E;
                                            object = stringArray[0];
                                            RomUtils$a.b((RomUtils$a)object2, (String)object);
                                        } else {
                                            stringArray = s;
                                            n10 = (int)(RomUtils.v((String)object2, (String)object, stringArray) ? 1 : 0);
                                            if (n10 != 0) {
                                                object2 = E;
                                                object = stringArray[0];
                                                RomUtils$a.b((RomUtils$a)object2, (String)object);
                                            } else {
                                                stringArray = t;
                                                boolean bl2 = RomUtils.v((String)object2, (String)object, stringArray);
                                                if (bl2) {
                                                    object2 = E;
                                                    object = stringArray[0];
                                                    RomUtils$a.b((RomUtils$a)object2, (String)object);
                                                } else {
                                                    object2 = E;
                                                    RomUtils$a.b((RomUtils$a)object2, (String)object);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        object2 = E;
        object = RomUtils.d("");
        RomUtils$a.c((RomUtils$a)object2, (String)object);
        return E;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String d(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        string2 = !bl2 ? RomUtils.e(string2) : "";
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = D;
        if (bl2 || (bl2 = string2.equals(string3))) {
            try {
                String string4 = Build.DISPLAY;
                boolean bl3 = TextUtils.isEmpty((CharSequence)string4);
                if (!bl3) {
                    string2 = string4.toLowerCase();
                }
            }
            catch (Throwable throwable) {}
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)string2)) {
            return string3;
        }
        return string2;
    }

    private static String e(String string2) {
        String string3 = RomUtils.f(string2);
        int n10 = TextUtils.isEmpty((CharSequence)string3);
        if (n10 == 0) {
            return string3;
        }
        string3 = RomUtils.g(string2);
        n10 = TextUtils.isEmpty((CharSequence)string3);
        if (n10 == 0) {
            return string3;
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 < n11) {
            return RomUtils.getSystemPropertyByReflect(string2);
        }
        return string3;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String f(String object) {
        void var0_3;
        Object object2;
        block30: {
            block29: {
                Object object3;
                block28: {
                    object2 = null;
                    object3 = Runtime.getRuntime();
                    Object object4 = new StringBuilder();
                    String string2 = "getprop ";
                    ((StringBuilder)object4).append(string2);
                    ((StringBuilder)object4).append((String)object);
                    object = ((StringBuilder)object4).toString();
                    object = ((Runtime)object3).exec((String)object);
                    object = ((Process)object).getInputStream();
                    object4 = new InputStreamReader((InputStream)object);
                    int n10 = 1024;
                    object3 = new BufferedReader((Reader)object4, n10);
                    object = ((BufferedReader)object3).readLine();
                    if (object == null) break block28;
                    ((BufferedReader)object3).close();
                    return object;
                }
                try {
                    ((BufferedReader)object3).close();
                    return "";
                }
                catch (IOException iOException) {
                    return "";
                }
                catch (Throwable throwable) {
                    object2 = object3;
                    break block29;
                }
                catch (IOException iOException) {
                    object2 = object3;
                    break block30;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            if (object2 != null) {
                ((BufferedReader)object2).close();
            }
            throw var0_3;
            catch (IOException iOException) {}
        }
        if (object2 != null) {
            ((BufferedReader)object2).close();
        }
        return "";
        catch (IOException iOException) {
            return object;
        }
        catch (IOException iOException) {
            throw var0_3;
        }
    }

    private static String g(String string2) {
        Properties properties;
        String string3 = "";
        try {
            properties = new Properties();
        }
        catch (Exception exception) {
            return string3;
        }
        File file = Environment.getRootDirectory();
        String string4 = "build.prop";
        File file2 = new File(file, string4);
        FileInputStream fileInputStream = new FileInputStream(file2);
        properties.load(fileInputStream);
        return properties.getProperty(string2, string3);
    }

    private static String getSystemPropertyByReflect(String object) {
        int n10;
        Object[] objectArray;
        Object object2 = String.class;
        String string2 = "";
        Object object3 = "android.os.SystemProperties";
        try {
            object3 = Class.forName((String)object3);
            objectArray = "get";
            n10 = 2;
        }
        catch (Exception exception) {
            return string2;
        }
        Class[] classArray = new Class[n10];
        classArray[0] = object2;
        int n11 = 1;
        classArray[n11] = object2;
        object2 = ((Class)object3).getMethod((String)objectArray, classArray);
        objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[n11] = string2;
        object = ((Method)object2).invoke(object3, objectArray);
        return (String)object;
    }

    public static boolean h() {
        String string2 = f[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean i() {
        String string2 = j[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean j() {
        String string2 = s[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean k() {
        String string2 = l[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean l() {
        String string2 = q[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean m() {
        String string2 = a[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean n() {
        String string2 = e[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean o() {
        String string2 = o[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean p() {
        String string2 = k[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean q() {
        String string2 = n[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean r() {
        String string2 = t[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean s() {
        String string2 = i[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean t() {
        String string2 = h[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean u() {
        String string2 = d[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    private static boolean v(String string2, String string3, String ... stringArray) {
        for (String string4 : stringArray) {
            boolean bl2;
            boolean bl3 = string2.contains(string4);
            if (!bl3 && !(bl2 = string3.contains(string4))) {
                continue;
            }
            return true;
        }
        return false;
    }

    public static boolean w() {
        String string2 = m[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean x() {
        String string2 = p[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean y() {
        String string2 = r[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }

    public static boolean z() {
        String string2 = b[0];
        String string3 = RomUtils$a.a(RomUtils.c());
        return string2.equals(string3);
    }
}

