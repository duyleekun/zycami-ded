/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  com.mob.commons.MOBLINK
 */
package com.mob.commons;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.MOBLINK;
import com.mob.commons.MobProduct;
import com.mob.commons.MobSolution;
import com.mob.commons.a;
import com.mob.commons.f;
import com.mob.commons.g;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DeviceHelper;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class MobProductCollector
implements PublicMemberKeeper {
    public static final String[] MOB_PRODUCTS;
    public static final String[] MOB_PRODUCTS_DEPRECATED;
    public static final String[] MOB_SOLUTIONS;
    private static boolean a;
    private static final HashMap b;
    private static final HashMap c;

    static {
        HashMap hashMap;
        MOB_PRODUCTS = new String[]{"SHARESDK", "SMSSDK", "MOBLINK", "MOBPUSH", "SECVERIFY", "MOBADSDK", "MOBGUARD", "GESVERIFY", "MOBAPM"};
        MOB_PRODUCTS_DEPRECATED = new String[]{"SHAREREC", "MOBAPI", "UMSSDK", "CMSSDK", "BBSSDK", "SHOPSDK", "PAYSDK", "MOBIM", "ANALYSDK", "MOBVERIFY"};
        MOB_SOLUTIONS = new String[]{"GROWSOLUTION"};
        a = false;
        b = hashMap = new HashMap();
        c = hashMap = new HashMap();
    }

    private static String a(int n10) {
        long l10 = System.currentTimeMillis();
        long l11 = SystemClock.elapsedRealtime();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(l10 ^= l11);
        Random random = new Random();
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = '\u0002';
            String string2 = "char";
            int n11 = random.nextInt(c10) % c10;
            String string3 = n11 == 0 ? string2 : "num";
            if ((c10 = (char)(string2.equalsIgnoreCase(string3) ? 1 : 0)) != '\u0000') {
                c10 = (char)(random.nextInt(26) + 97);
                n11 = i10 + 1;
                stringBuffer.insert(n11, c10);
                continue;
            }
            c10 = stringBuffer.length();
            n11 = random.nextInt(10);
            stringBuffer.insert((int)c10, n11);
        }
        return stringBuffer.toString().substring(0, 40);
    }

    private static HashMap a() {
        boolean bl2;
        Class<MobSolution> clazz = MobSolution.class;
        Class<MobProduct> clazz2 = MobProduct.class;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Iterator iterator2 = g.a.iterator();
        block27: while (bl2 = iterator2.hasNext()) {
            Object object;
            Object object2;
            block33: {
                boolean bl3;
                String string2;
                int n10;
                int n11;
                String[] stringArray;
                boolean bl4;
                block32: {
                    object2 = iterator2.next();
                    bl4 = object2 instanceof String;
                    if (bl4) {
                        object2 = String.valueOf(object2);
                        object2 = ((String)object2).trim();
                        object2 = Class.forName((String)object2);
                    } else {
                        object2 = (Class)object2;
                    }
                    bl4 = clazz2.isAssignableFrom((Class<?>)object2);
                    if (!bl4) break block32;
                    bl4 = clazz2.equals(object2);
                    if (bl4) break block32;
                    object2 = ((Class)object2).newInstance();
                    object2 = (MobProduct)object2;
                    object = object2.getProductTag();
                    stringArray = MOB_PRODUCTS;
                    n11 = stringArray.length;
                    for (n10 = 0; n10 < n11; ++n10) {
                        string2 = stringArray[n10];
                        bl3 = string2.equals(object);
                        if (!bl3) continue;
                        hashMap.put(string2, object2);
                    }
                    continue;
                }
                bl4 = clazz.isAssignableFrom((Class<?>)object2);
                if (!bl4) break block33;
                bl4 = clazz.equals(object2);
                if (bl4) break block33;
                object2 = ((Class)object2).newInstance();
                object2 = (MobSolution)object2;
                object = object2.getSolutionTag();
                stringArray = MOB_SOLUTIONS;
                n11 = stringArray.length;
                while (n10 < n11) {
                    block34: {
                        string2 = stringArray[n10];
                        bl3 = string2.equals(object);
                        if (!bl3) break block34;
                        object = c;
                        ((HashMap)object).put(string2, object2);
                        continue block27;
                    }
                    ++n10;
                }
                continue;
            }
            try {
                ((Class)object2).newInstance();
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).d(throwable);
            }
        }
        return hashMap;
    }

    private static String b() {
        return MobProductCollector.a(40);
    }

    public static void collect() {
        Class<MobProductCollector> clazz = MobProductCollector.class;
        synchronized (clazz) {
            MobProductCollector.getProducts();
            return;
        }
    }

    public static ArrayList getProducts() {
        Class<MobProductCollector> clazz = MobProductCollector.class;
        synchronized (clazz) {
            Object object;
            Cloneable cloneable;
            block10: {
                boolean bl2 = a;
                if (bl2) break block10;
                cloneable = b;
                object = MobProductCollector.a();
                ((HashMap)cloneable).putAll(object);
                bl2 = true;
                a = bl2;
            }
            cloneable = new ArrayList();
            object = b;
            object = ((HashMap)object).values();
            ((ArrayList)cloneable).addAll(object);
            return cloneable;
        }
    }

    public static String getUserIdentity() {
        Class<MobProductCollector> clazz = MobProductCollector.class;
        synchronized (clazz) {
            Object object = MobProductCollector.getProducts();
            object = MobProductCollector.getUserIdentity((ArrayList)object);
            return object;
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getUserIdentity(ArrayList arrayList) {
        Class<MobProductCollector> clazz = MobProductCollector.class;
        synchronized (clazz) {
            void var11_18;
            Object object;
            int n10;
            Object object2;
            String string2;
            Object object3;
            Object object4;
            String string3;
            CharSequence charSequence;
            CharSequence charSequence2;
            String string4;
            CharSequence charSequence3;
            Object object5;
            Object object6;
            block21: {
                int n11;
                Object object7;
                Serializable serializable;
                block18: {
                    void var23_40;
                    object6 = MobSDK.getContext();
                    object6 = DeviceHelper.getInstance((Context)object6);
                    object5 = ((DeviceHelper)object6).getPackageName();
                    charSequence3 = "utf-8";
                    object5 = URLEncoder.encode((String)object5, (String)charSequence3);
                    charSequence3 = ((DeviceHelper)object6).getAppVersionName();
                    string4 = "utf-8";
                    charSequence3 = URLEncoder.encode((String)charSequence3, string4);
                    string4 = ((DeviceHelper)object6).getManufacturer();
                    charSequence2 = "utf-8";
                    string4 = URLEncoder.encode(string4, (String)charSequence2);
                    charSequence2 = ((DeviceHelper)object6).getModel();
                    charSequence = "utf-8";
                    charSequence2 = URLEncoder.encode((String)charSequence2, (String)charSequence);
                    charSequence = ((DeviceHelper)object6).getMIUIVersion();
                    string3 = "utf-8";
                    charSequence = URLEncoder.encode((String)charSequence, string3);
                    string3 = ((DeviceHelper)object6).getOSVersionName();
                    object4 = "utf-8";
                    string3 = URLEncoder.encode(string3, (String)object4);
                    object4 = f.a();
                    object4 = ((f)object4).b();
                    object3 = new StringBuilder();
                    String string5 = "APP/";
                    ((StringBuilder)object3).append(string5);
                    ((StringBuilder)object3).append((String)object5);
                    object5 = ";";
                    ((StringBuilder)object3).append((String)object5);
                    ((StringBuilder)object3).append((String)charSequence3);
                    object5 = ((StringBuilder)object3).toString();
                    charSequence3 = new StringBuilder();
                    object3 = "SYS/Android;";
                    ((StringBuilder)charSequence3).append((String)object3);
                    int n12 = ((DeviceHelper)object6).getOSVersionInt();
                    ((StringBuilder)charSequence3).append(n12);
                    object3 = ";";
                    ((StringBuilder)charSequence3).append((String)object3);
                    ((StringBuilder)charSequence3).append(string3);
                    charSequence3 = ((StringBuilder)charSequence3).toString();
                    boolean bl2 = com.mob.commons.a.c();
                    string3 = bl2 && !(bl2 = com.mob.commons.a.d()) ? MobProductCollector.b() : ((DeviceHelper)object6).getDeviceKey();
                    object3 = new StringBuilder();
                    String string6 = "SDI/";
                    ((StringBuilder)object3).append(string6);
                    ((StringBuilder)object3).append(string3);
                    string3 = ((StringBuilder)object3).toString();
                    object3 = new StringBuilder();
                    String string7 = "FM/";
                    ((StringBuilder)object3).append(string7);
                    ((StringBuilder)object3).append(string4);
                    string4 = ";";
                    ((StringBuilder)object3).append(string4);
                    ((StringBuilder)object3).append((String)charSequence2);
                    string4 = ((StringBuilder)object3).toString();
                    boolean bl3 = TextUtils.isEmpty((CharSequence)charSequence);
                    if (!bl3) {
                        charSequence2 = new StringBuilder();
                        ((StringBuilder)charSequence2).append(string4);
                        string4 = ";";
                        ((StringBuilder)charSequence2).append(string4);
                        ((StringBuilder)charSequence2).append((String)charSequence);
                        string4 = ((StringBuilder)charSequence2).toString();
                    }
                    charSequence2 = new StringBuilder();
                    charSequence = "NE/";
                    ((StringBuilder)charSequence2).append((String)charSequence);
                    charSequence = ((DeviceHelper)object6).getNetworkTypeForStatic();
                    ((StringBuilder)charSequence2).append((String)charSequence);
                    charSequence = ";";
                    ((StringBuilder)charSequence2).append((String)charSequence);
                    charSequence = ((DeviceHelper)object6).getCarrier();
                    ((StringBuilder)charSequence2).append((String)charSequence);
                    charSequence2 = ((StringBuilder)charSequence2).toString();
                    charSequence = new StringBuilder();
                    object3 = "Lang/";
                    ((StringBuilder)charSequence).append((String)object3);
                    object3 = Locale.getDefault();
                    object3 = ((Locale)object3).toString();
                    String string8 = "-r";
                    string2 = "-";
                    object3 = ((String)object3).replace(string8, string2);
                    ((StringBuilder)charSequence).append((String)object3);
                    charSequence = ((StringBuilder)charSequence).toString();
                    object3 = new StringBuilder();
                    String string9 = "CLV/";
                    ((StringBuilder)object3).append(string9);
                    int n13 = MobSDK.SDK_VERSION_CODE;
                    ((StringBuilder)object3).append(n13);
                    object3 = ((StringBuilder)object3).toString();
                    String string10 = "SDK/";
                    int n14 = arrayList.isEmpty();
                    if (n14 != 0) break block18;
                    n14 = arrayList.size();
                    object2 = null;
                    for (n10 = 0; n10 < n14; ++n10) {
                        block20: {
                            block19: {
                                serializable = arrayList;
                                object7 = arrayList.get(n10);
                                object7 = (MobProduct)object7;
                                if (n10 == 0) break block19;
                                object = new StringBuilder();
                                ((StringBuilder)object).append((String)var11_18);
                                var23_40 = var11_18;
                                String string11 = ",";
                                ((StringBuilder)object).append(string11);
                                String string12 = ((StringBuilder)object).toString();
                                break block20;
                            }
                            var23_40 = var11_18;
                        }
                        object = new StringBuilder();
                        ((StringBuilder)object).append((String)var11_18);
                        var23_40 = var11_18;
                        try {
                            String string13 = object7.getProductTag();
                            ((StringBuilder)object).append(string13);
                            String string14 = ";";
                            ((StringBuilder)object).append(string14);
                            n13 = object7.getSdkver();
                            ((StringBuilder)object).append(n13);
                            String string15 = ";";
                            ((StringBuilder)object).append(string15);
                            String string16 = object7.getProductTag();
                            Object v10 = ((HashMap)object4).get(string16);
                            ((StringBuilder)object).append(v10);
                            String string17 = ((StringBuilder)object).toString();
                        }
                        catch (Throwable throwable) {
                            void var11_28 = var23_40;
                        }
                        continue;
                        catch (Throwable throwable) {
                            var23_40 = var11_18;
                        }
                    }
                    var23_40 = var11_18;
                }
                object4 = "DC/1";
                string2 = "";
                try {
                    object = c;
                    n10 = (int)(((HashMap)object).isEmpty() ? 1 : 0);
                    if (n10 != 0) break block21;
                    string2 = " P/";
                    object = ((HashMap)object).entrySet();
                    object = object.iterator();
                    n11 = 0;
                    while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                        object2 = object.next();
                        object2 = (Map.Entry)object2;
                        if (n11 == 0) break block22;
                    }
                }
                catch (Throwable throwable) {
                    object5 = MobLog.getInstance();
                    ((NLog)object5).w(throwable);
                    return "";
                }
                {
                    block22: {
                        try {
                            serializable = new StringBuilder();
                            ((StringBuilder)serializable).append(string2);
                            object7 = ",";
                            ((StringBuilder)serializable).append((String)object7);
                            string2 = ((StringBuilder)serializable).toString();
                        }
                        catch (Throwable throwable) {
                            continue;
                        }
                    }
                    ++n11;
                    object2 = object2.getValue();
                    object2 = (MobSolution)object2;
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append(string2);
                    object7 = object2.getSolutionTag();
                    ((StringBuilder)serializable).append((String)object7);
                    object7 = ";";
                    ((StringBuilder)serializable).append((String)object7);
                    n10 = object2.getSolutionVer();
                    ((StringBuilder)serializable).append(n10);
                    string2 = ((StringBuilder)serializable).toString();
                    continue;
                }
            }
            object = "";
            object6 = ((DeviceHelper)object6).getTimezone();
            n10 = (int)(TextUtils.isEmpty((CharSequence)object6) ? 1 : 0);
            if (n10 == 0) {
                object = new StringBuilder();
                object2 = "TZ_";
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append((String)object6);
                object = ((StringBuilder)object).toString();
            }
            object6 = new StringBuilder();
            ((StringBuilder)object6).append((String)object5);
            object5 = " ";
            ((StringBuilder)object6).append((String)object5);
            ((StringBuilder)object6).append((String)charSequence3);
            object5 = " ";
            ((StringBuilder)object6).append((String)object5);
            ((StringBuilder)object6).append(string3);
            object5 = " ";
            ((StringBuilder)object6).append((String)object5);
            ((StringBuilder)object6).append(string4);
            object5 = " ";
            ((StringBuilder)object6).append((String)object5);
            ((StringBuilder)object6).append((String)charSequence2);
            object5 = " ";
            ((StringBuilder)object6).append((String)object5);
            ((StringBuilder)object6).append((String)charSequence);
            object5 = " ";
            ((StringBuilder)object6).append((String)object5);
            ((StringBuilder)object6).append((String)object3);
            object5 = " ";
            ((StringBuilder)object6).append((String)object5);
            ((StringBuilder)object6).append((String)var11_18);
            object5 = " ";
            ((StringBuilder)object6).append((String)object5);
            ((StringBuilder)object6).append((String)object4);
            ((StringBuilder)object6).append(string2);
            object5 = " ";
            ((StringBuilder)object6).append((String)object5);
            ((StringBuilder)object6).append((String)object);
            return ((StringBuilder)object6).toString();
        }
    }

    public static boolean registerProduct(MobProduct mobProduct) {
        Class<MobProductCollector> clazz = MobProductCollector.class;
        synchronized (clazz) {
            block8: {
                if (mobProduct != null) {
                    HashMap hashMap = b;
                    String string2 = mobProduct.getProductTag();
                    boolean bl2 = hashMap.containsKey(string2);
                    if (bl2) break block8;
                    string2 = mobProduct.getProductTag();
                    hashMap.put(string2, mobProduct);
                    return true;
                }
            }
            return false;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void syncInit() {
        MOBLINK mOBLINK;
        try {
            mOBLINK = new MOBLINK();
        }
        catch (Throwable throwable) {
            return;
        }
        boolean bl2 = mOBLINK instanceof MobProduct;
        if (!bl2) return;
        {
            ((MobProduct)mOBLINK).getProductTag();
            return;
        }
    }
}

