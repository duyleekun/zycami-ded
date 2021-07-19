/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.content.pm.Signature
 *  android.os.Build
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.huawei.appgallery.serviceverifykit.api;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit$Builder$ComponentType;
import com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit$a;
import d.j.b.a.b.a;
import d.j.b.a.b.c;
import d.j.b.a.b.d.b;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ServiceVerifyKit {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private Map g;
    private Map h;
    private int i;
    private int j;
    private int k;
    private String l;
    private String m;
    private String n;
    private Intent o;
    private ServiceVerifyKit$Builder$ComponentType p;

    private ServiceVerifyKit() {
        HashMap hashMap;
        this.g = hashMap = new HashMap();
        this.h = hashMap = new HashMap();
        this.j = 0;
        this.k = 0;
    }

    public /* synthetic */ ServiceVerifyKit(ServiceVerifyKit$a serviceVerifyKit$a) {
        this();
    }

    public static /* synthetic */ String A(ServiceVerifyKit serviceVerifyKit, String string2) {
        serviceVerifyKit.b = string2;
        return string2;
    }

    public static /* synthetic */ String B(ServiceVerifyKit serviceVerifyKit, String string2) {
        serviceVerifyKit.l = string2;
        return string2;
    }

    private int a(Bundle object, String string2) {
        int n10;
        String string3 = this.l;
        boolean bl2 = object.containsKey(string3);
        if (bl2) {
            string3 = this.l;
            n10 = (int)(((String)(object = object.getString(string3))).equalsIgnoreCase(string2) ? 1 : 0);
            n10 = n10 != 0 ? 1 : -1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10;
    }

    public static /* synthetic */ int b(ServiceVerifyKit serviceVerifyKit, int n10) {
        serviceVerifyKit.i = n10;
        return n10;
    }

    public static /* synthetic */ Context c(ServiceVerifyKit serviceVerifyKit, Context context) {
        serviceVerifyKit.a = context;
        return context;
    }

    public static /* synthetic */ Intent d(ServiceVerifyKit serviceVerifyKit, Intent intent) {
        serviceVerifyKit.o = intent;
        return intent;
    }

    /*
     * Enabled aggressive block sorting
     */
    private d.j.b.a.a.a e(PackageInfo object, String charSequence, String string2, int n10) {
        int n11;
        block6: {
            block8: {
                String string3;
                block3: {
                    String string4;
                    block7: {
                        block4: {
                            block5: {
                                block2: {
                                    object = object.applicationInfo.metaData;
                                    string3 = "ServiceVerifyKit";
                                    if (object != null) break block2;
                                    object = d.j.b.a.b.d.b.b;
                                    charSequence = new StringBuilder();
                                    String string5 = "skip package ";
                                    ((StringBuilder)charSequence).append(string5);
                                    ((StringBuilder)charSequence).append(string2);
                                    string2 = " for metadata is null";
                                    break block3;
                                }
                                String string6 = this.n;
                                n11 = this.a((Bundle)object, string6);
                                String string7 = this.e;
                                boolean bl2 = object.containsKey(string7);
                                if (bl2 || (bl2 = object.containsKey(string7 = this.f))) break block4;
                                int n12 = this.o(string2, (String)charSequence);
                                if (n12 == 0) break block5;
                                this.k = 1;
                                object = (Integer)this.h.get(string2);
                                this.j = n12 = ((Integer)object).intValue();
                                break block6;
                            }
                            object = d.j.b.a.b.d.b.b;
                            charSequence = new StringBuilder();
                            string4 = "Legacy is false, packageName is ";
                            break block7;
                        }
                        boolean bl3 = this.n((Bundle)object, string2, (String)charSequence);
                        if (bl3) break block8;
                        object = d.j.b.a.b.d.b.b;
                        charSequence = new StringBuilder();
                        string4 = "checkSinger failed, packageName is ";
                    }
                    ((StringBuilder)charSequence).append(string4);
                }
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                ((b)object).a(string3, (String)charSequence);
                return null;
            }
            this.j = n10;
        }
        int n13 = this.j;
        n10 = this.k;
        return new d.j.b.a.a.a(string2, n13, n10, n11);
    }

    public static /* synthetic */ ServiceVerifyKit$Builder$ComponentType f(ServiceVerifyKit serviceVerifyKit, ServiceVerifyKit$Builder$ComponentType serviceVerifyKit$Builder$ComponentType) {
        serviceVerifyKit.p = serviceVerifyKit$Builder$ComponentType;
        return serviceVerifyKit$Builder$ComponentType;
    }

    private String g() {
        int n10;
        String string2 = "ServiceVerifyKit";
        String string3 = "skip package ";
        PackageManager packageManager = this.a.getPackageManager();
        Object object = this.l(packageManager);
        int n11 = object.size();
        if (n11 == 0) {
            return null;
        }
        Object object2 = this.m;
        n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
        object2 = n11 != 0 ? Build.MANUFACTURER : ServiceVerifyKit.k(this.m);
        this.n = object2;
        object2 = new Object();
        int n12 = this.i | 0x80 | 0x40;
        object = object.iterator();
        while ((n10 = object.hasNext()) != 0) {
            Object object3;
            String string4;
            Object object4;
            block12: {
                boolean bl2;
                Object object5;
                block11: {
                    object4 = (ResolveInfo)object.next();
                    string4 = this.h((ResolveInfo)object4);
                    try {
                        object3 = packageManager.getPackageInfo(string4, n12);
                        object5 = ((PackageInfo)object3).applicationInfo;
                        if (object5 != null) break block11;
                        object4 = d.j.b.a.b.d.b.b;
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append(string3);
                    }
                    catch (PackageManager.NameNotFoundException nameNotFoundException) {
                        object4 = d.j.b.a.b.d.b.b;
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append(string3);
                        ((StringBuilder)object3).append(string4);
                        string4 = " for PackageInfo is null";
                    }
                    ((StringBuilder)object3).append(string4);
                    string4 = " for ApplicationInfo is null";
                    break block12;
                }
                object5 = ((PackageInfo)object3).signatures;
                if (object5 != null && (bl2 = ((Signature[])object5).length) > false) {
                    Object object6 = null;
                    bl2 = ((Signature[])(object5 = (Object)object5[0].toByteArray())).length;
                    if (!bl2) {
                        object4 = d.j.b.a.b.d.b.b;
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append(string3);
                        ((StringBuilder)object3).append(string4);
                        string4 = " for sign is empty";
                    } else {
                        object6 = "SHA-256";
                        object6 = MessageDigest.getInstance((String)object6);
                        try {
                            object5 = ((MessageDigest)object6).digest((byte[])object5);
                            bl2 = true;
                        }
                        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                            object4 = d.j.b.a.b.d.b.b;
                            object3 = new StringBuilder();
                            ((StringBuilder)object3).append(string3);
                            ((StringBuilder)object3).append(string4);
                            string4 = " for AlgorithmException";
                        }
                        object5 = d.j.b.a.b.b.c((byte[])object5, bl2);
                        n10 = ((ResolveInfo)object4).priority;
                        object4 = this.e((PackageInfo)object3, (String)object5, string4, n10);
                        if (object4 == null) continue;
                        object2.add(object4);
                        continue;
                    }
                } else {
                    object4 = d.j.b.a.b.d.b.b;
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append(string3);
                    ((StringBuilder)object3).append(string4);
                    string4 = " for no sign";
                }
            }
            ((StringBuilder)object3).append(string4);
            string4 = ((StringBuilder)object3).toString();
            ((b)object4).a(string2, string4);
        }
        return this.s((List)object2);
    }

    private String h(ResolveInfo resolveInfo) {
        ServiceVerifyKit$Builder$ComponentType serviceVerifyKit$Builder$ComponentType = this.p;
        ServiceVerifyKit$Builder$ComponentType serviceVerifyKit$Builder$ComponentType2 = ServiceVerifyKit$Builder$ComponentType.ACTIVITY;
        resolveInfo = serviceVerifyKit$Builder$ComponentType != serviceVerifyKit$Builder$ComponentType2 && serviceVerifyKit$Builder$ComponentType != (serviceVerifyKit$Builder$ComponentType2 = ServiceVerifyKit$Builder$ComponentType.BROADCAST) ? resolveInfo.serviceInfo.applicationInfo : resolveInfo.activityInfo.applicationInfo;
        return resolveInfo.packageName;
    }

    public static /* synthetic */ String i(ServiceVerifyKit serviceVerifyKit) {
        return serviceVerifyKit.g();
    }

    public static /* synthetic */ String j(ServiceVerifyKit serviceVerifyKit, String string2) {
        serviceVerifyKit.m = string2;
        return string2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String k(String object) {
        String string2 = "";
        String string3 = "ServiceVerifyKit";
        Object object2 = "android.os.SystemProperties";
        try {
            Class<String> clazz;
            object2 = Class.forName((String)object2);
            String string4 = "get";
            int n10 = 1;
            Class[] classArray = new Class[n10];
            classArray[0] = clazz = String.class;
            object2 = ((Class)object2).getMethod(string4, classArray);
            string4 = null;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            object = ((Method)object2).invoke(null, objectArray);
            return (String)object;
        }
        catch (Exception exception) {
            block3: {
                object = d.j.b.a.b.d.b.b;
                object2 = "getSystemProperties Exception while getting system property";
                break block3;
                catch (ClassNotFoundException classNotFoundException) {
                    object = d.j.b.a.b.d.b.b;
                    object2 = "getSystemProperties ClassNotFoundException";
                }
            }
            ((b)object).a(string3, (String)object2);
            return string2;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private List l(PackageManager object) {
        void var1_5;
        ServiceVerifyKit$Builder$ComponentType serviceVerifyKit$Builder$ComponentType = this.p;
        if (serviceVerifyKit$Builder$ComponentType == null) {
            String string2 = this.b;
            serviceVerifyKit$Builder$ComponentType = new Intent(string2);
        } else {
            ServiceVerifyKit$Builder$ComponentType serviceVerifyKit$Builder$ComponentType2 = ServiceVerifyKit$Builder$ComponentType.ACTIVITY;
            if (serviceVerifyKit$Builder$ComponentType == serviceVerifyKit$Builder$ComponentType2) {
                serviceVerifyKit$Builder$ComponentType = this.o;
                int n10 = this.i;
                List list = object.queryIntentActivities((Intent)serviceVerifyKit$Builder$ComponentType, n10);
                return var1_5;
            }
            serviceVerifyKit$Builder$ComponentType2 = ServiceVerifyKit$Builder$ComponentType.BROADCAST;
            if (serviceVerifyKit$Builder$ComponentType == serviceVerifyKit$Builder$ComponentType2) {
                serviceVerifyKit$Builder$ComponentType = this.o;
                int n11 = this.i;
                List list = object.queryBroadcastReceivers((Intent)serviceVerifyKit$Builder$ComponentType, n11);
                return var1_5;
            }
            serviceVerifyKit$Builder$ComponentType = this.o;
        }
        int n12 = this.i;
        List list = object.queryIntentServices((Intent)serviceVerifyKit$Builder$ComponentType, n12);
        return var1_5;
    }

    private List m(List list) {
        boolean bl2;
        ArrayList<d.j.b.a.a.a> arrayList = new ArrayList<d.j.b.a.a.a>();
        Iterator iterator2 = list.iterator();
        while (bl2 = iterator2.hasNext()) {
            d.j.b.a.a.a a10 = (d.j.b.a.a.a)iterator2.next();
            int n10 = a10.a();
            if (n10 != 0) continue;
            arrayList.add(a10);
        }
        boolean bl3 = arrayList.isEmpty();
        if (!bl3) {
            return arrayList;
        }
        return list;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean n(Bundle object, String string2, String charSequence) {
        CharSequence charSequence2 = this.e;
        boolean bl2 = object.containsKey((String)charSequence2);
        String string3 = "ServiceVerifyKit";
        if (bl2 && (bl2 = object.containsKey((String)(charSequence2 = this.f)))) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append(string2);
            ((StringBuilder)charSequence2).append("&");
            ((StringBuilder)charSequence2).append((String)charSequence);
            string2 = ((StringBuilder)charSequence2).toString();
            charSequence = this.e;
            charSequence = object.getString((String)charSequence);
            charSequence2 = this.f;
            object = object.getString((String)charSequence2);
            boolean bl3 = this.p(string2, (String)charSequence, (String)object);
            if (bl3) {
                return true;
            }
            object = d.j.b.a.b.d.b.b;
            string2 = "checkSinger failed";
        } else {
            object = d.j.b.a.b.d.b.b;
            charSequence = new StringBuilder();
            charSequence2 = "skip package ";
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(" for no signer or no certChain");
            string2 = ((StringBuilder)charSequence).toString();
        }
        ((b)object).a(string3, string2);
        return false;
    }

    private boolean o(String stringArray, String string2) {
        Map map = this.g;
        int n10 = map.containsKey(stringArray);
        if (n10 != 0 && (stringArray = (String[])(map = this.g).get(stringArray)) != null) {
            for (String string3 : stringArray) {
                boolean bl2 = string2.equals(string3);
                if (!bl2) continue;
                return true;
            }
        }
        return false;
    }

    private boolean p(String string2, String object, String object2) {
        int n10 = TextUtils.isEmpty((CharSequence)object);
        String string3 = "ServiceVerifyKit";
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)object2)) == 0) {
            n10 = (object2 = d.j.b.a.b.c.k((String)object2)).size();
            if (n10 == 0) {
                d.j.b.a.b.d.b.b.a(string3, "certChain is empty");
                return false;
            }
            Object object3 = d.j.b.a.b.c.b(this.a);
            n10 = (int)(d.j.b.a.b.c.h((X509Certificate)object3, (List)object2) ? 1 : 0);
            if (n10 == 0) {
                d.j.b.a.b.d.b.b.a(string3, "failed to verify cert chain");
                return false;
            }
            n10 = (int)(d.j.b.a.b.c.f((X509Certificate)(object2 = (X509Certificate)object2.get(0)), (String)(object3 = this.c)) ? 1 : 0);
            if (n10 == 0) {
                d.j.b.a.b.d.b.b.a(string3, "CN is invalid");
                return false;
            }
            object3 = this.d;
            n10 = (int)(d.j.b.a.b.c.m((X509Certificate)object2, (String)object3) ? 1 : 0);
            if (n10 == 0) {
                d.j.b.a.b.d.b.b.a(string3, "OU is invalid");
                return false;
            }
            n10 = 0;
            object3 = null;
            String string4 = "UTF-8";
            try {
                object3 = string2.getBytes(string4);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                b b10 = d.j.b.a.b.d.b.b;
                String string5 = "checkCertChain UnsupportedEncodingException:";
                b10.b(string3, string5, unsupportedEncodingException);
            }
            object = d.j.b.a.b.a.a((String)object);
            boolean bl2 = d.j.b.a.b.c.i((X509Certificate)object2, (byte[])object3, (byte[])object);
            if (!bl2) {
                object = d.j.b.a.b.d.b.b;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("signature is invalid: ");
                ((StringBuilder)object2).append(string2);
                string2 = ((StringBuilder)object2).toString();
                ((b)object).a(string3, string2);
                return false;
            }
            return true;
        }
        d.j.b.a.b.d.b.b.a(string3, "args is invalid");
        return false;
    }

    public static /* synthetic */ String[] q(String[] stringArray, String string2) {
        return ServiceVerifyKit.u(stringArray, string2);
    }

    public static /* synthetic */ String r(ServiceVerifyKit serviceVerifyKit, String string2) {
        serviceVerifyKit.f = string2;
        return string2;
    }

    private String s(List object) {
        object = this.w((List)object);
        object = this.m((List)object);
        int n10 = object.size();
        String string2 = "";
        if (n10 > 0) {
            boolean bl2;
            object = object.iterator();
            n10 = 0;
            while (bl2 = object.hasNext()) {
                d.j.b.a.a.a a10 = (d.j.b.a.a.a)object.next();
                int n11 = a10.d();
                if (n11 < n10) continue;
                n10 = a10.d();
                string2 = a10.c();
            }
        }
        return string2;
    }

    public static /* synthetic */ Map t(ServiceVerifyKit serviceVerifyKit) {
        return serviceVerifyKit.g;
    }

    private static String[] u(String[] stringArray, String string2) {
        if (stringArray == null) {
            stringArray = new String[]{string2};
            return stringArray;
        }
        int n10 = stringArray.length;
        String[] stringArray2 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3 = stringArray[i10];
            boolean bl2 = TextUtils.equals((CharSequence)string3, (CharSequence)string2);
            if (!bl2) continue;
            return stringArray;
        }
        stringArray2 = new String[n10 + 1];
        System.arraycopy(stringArray, 0, stringArray2, 0, n10);
        stringArray2[n10] = string2;
        return stringArray2;
    }

    public static /* synthetic */ String v(ServiceVerifyKit serviceVerifyKit, String string2) {
        serviceVerifyKit.e = string2;
        return string2;
    }

    private List w(List list) {
        boolean bl2;
        ArrayList<d.j.b.a.a.a> arrayList = new ArrayList<d.j.b.a.a.a>();
        Iterator iterator2 = list.iterator();
        while (bl2 = iterator2.hasNext()) {
            int n10;
            d.j.b.a.a.a a10 = (d.j.b.a.a.a)iterator2.next();
            int n11 = a10.b();
            if (n11 <= (n10 = -1)) continue;
            arrayList.add(a10);
        }
        boolean bl3 = arrayList.isEmpty();
        if (!bl3) {
            return arrayList;
        }
        return list;
    }

    public static /* synthetic */ Map x(ServiceVerifyKit serviceVerifyKit) {
        return serviceVerifyKit.h;
    }

    public static /* synthetic */ String y(ServiceVerifyKit serviceVerifyKit, String string2) {
        serviceVerifyKit.c = string2;
        return string2;
    }

    public static /* synthetic */ String z(ServiceVerifyKit serviceVerifyKit, String string2) {
        serviceVerifyKit.d = string2;
        return string2;
    }
}

