/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package d.r.a.u;

import android.os.Build;
import android.text.TextUtils;
import d.r.a.u.d0;
import d.r.a.u.s;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class n {
    public static final boolean a;
    public static final String b;
    public static final boolean c;
    public static final boolean d;
    public static final boolean e;
    public static final boolean f;
    public static final boolean g;
    public static final boolean h;
    private static Method i;
    private static String j;
    private static String k;
    private static String l;
    private static String m;

    static {
        String string2 = d0.l("ro.vivo.product.overseas", "no");
        a = string2.equals("yes");
        int n10 = Build.VERSION.SDK_INT;
        String string3 = "N";
        int n11 = 26;
        string2 = n10 >= n11 ? d0.l("ro.product.country.region", string3) : d0.l("ro.product.customize.bbk", string3);
        b = string2;
        c = "RU".equals(string2);
        d = "IN".equals(string2);
        e = n.e("rom_1.0");
        f = n.e("rom_2.0");
        g = n.e("rom_2.5");
        h = n.e("rom_3.0");
        j = null;
        k = null;
        l = string2 = "";
        m = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a() {
        Object object = String.class;
        Class<n> clazz = n.class;
        synchronized (clazz) {
            String string2;
            Object[] objectArray = j;
            if (objectArray == null && (objectArray = k) == null) {
                objectArray = "android.os.SystemProperties";
                try {
                    objectArray = Class.forName((String)objectArray);
                    string2 = "get";
                    int n10 = 2;
                    Class[] classArray = new Class[n10];
                    classArray[0] = object;
                    int n11 = 1;
                    classArray[n11] = object;
                    i = object = objectArray.getDeclaredMethod(string2, classArray);
                    ((Method)object).setAccessible(n11 != 0);
                    object = i;
                    objectArray = new Object[n10];
                    string2 = "ro.vivo.rom";
                    objectArray[0] = string2;
                    string2 = "@><@";
                    objectArray[n11] = string2;
                    object = ((Method)object).invoke(null, objectArray);
                    j = object = (String)object;
                    object = i;
                    objectArray = new Object[n10];
                    string2 = "ro.vivo.rom.version";
                    objectArray[0] = string2;
                    string2 = "@><@";
                    objectArray[n11] = string2;
                    object = ((Method)object).invoke(null, objectArray);
                    k = object = (String)object;
                }
                catch (Exception exception) {
                    object = "Device";
                    objectArray = "getRomCode error";
                    s.h((String)object, (String)objectArray);
                }
            }
            object = "Device";
            string2 = "sRomProperty1 : ";
            objectArray = new StringBuilder(string2);
            string2 = j;
            objectArray.append(string2);
            string2 = " ; sRomProperty2 : ";
            objectArray.append(string2);
            string2 = k;
            objectArray.append(string2);
            objectArray = objectArray.toString();
            s.m((String)object, (String)objectArray);
            object = j;
            object = n.b((String)object);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (!bl2) {
                return object;
            }
            object = k;
            bl2 = TextUtils.isEmpty((CharSequence)(object = n.b((String)object)));
            if (!bl2) {
                return object;
            }
            return null;
        }
    }

    private static String b(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        int n10 = 0;
        if (bl2) {
            return null;
        }
        int n11 = 2;
        Serializable serializable = Pattern.compile("rom_([\\d]*).?([\\d]*)", n11);
        object = ((Pattern)serializable).matcher((CharSequence)object);
        bl2 = ((Matcher)object).find();
        if (bl2) {
            serializable = new StringBuilder();
            n10 = 1;
            String string2 = ((Matcher)object).group(n10);
            ((StringBuilder)serializable).append(string2);
            string2 = ((Matcher)object).group(n11);
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (bl3) {
                object = "0";
            } else {
                object = ((Matcher)object).group(n11);
                n11 = 0;
                object = ((String)object).substring(0, n10);
            }
            ((StringBuilder)serializable).append((String)object);
            return ((StringBuilder)serializable).toString();
        }
        return null;
    }

    public static String c(String object, String string2) {
        int n10;
        Object object2 = "android.os.SystemProperties";
        object2 = Class.forName((String)object2);
        String string3 = "get";
        int n11 = 1;
        Class[] classArray = new Class[n11];
        Class<String> clazz = String.class;
        classArray[0] = clazz;
        object2 = ((Class)object2).getMethod(string3, classArray);
        string3 = null;
        Object[] objectArray = new Object[n11];
        objectArray[0] = object;
        object = ((Method)object2).invoke(null, objectArray);
        try {
            object = (String)object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object = string2;
        }
        if (object != null && (n10 = ((String)object).length()) != 0) {
            string2 = object;
        }
        return string2;
    }

    public static boolean d() {
        boolean bl2;
        String string2 = Build.MANUFACTURER;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = "Device";
        if (bl3) {
            s.m(string3, "Build.MANUFACTURER is null");
            return false;
        }
        String string4 = "Build.MANUFACTURER is ";
        CharSequence charSequence = new StringBuilder(string4);
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        s.m(string3, (String)charSequence);
        charSequence = string2.toLowerCase();
        string3 = "bbk";
        bl3 = ((String)charSequence).contains(string3);
        return bl3 || (bl2 = (string2 = string2.toLowerCase()).startsWith((String)(charSequence = "vivo")));
        {
        }
    }

    private static boolean e(String string2) {
        boolean bl2;
        boolean bl3;
        String string3 = "";
        String string4 = d0.l("ro.vivo.rom", string3);
        string3 = d0.l("ro.vivo.rom.version", string3);
        CharSequence charSequence = new StringBuilder("ro.vivo.rom = ");
        charSequence.append(string4);
        charSequence.append(" ; ro.vivo.rom.version = ");
        charSequence.append(string3);
        charSequence = charSequence.toString();
        String string5 = "Device";
        s.m(string5, (String)charSequence);
        return string4 != null && (bl3 = string4.contains(string2)) || string3 != null && (bl2 = string3.contains(string2));
    }
}

