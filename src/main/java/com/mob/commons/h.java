/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 *  android.text.TextUtils
 */
package com.mob.commons;

import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.PrivacyPolicy;
import com.mob.commons.MobProductCollector;
import com.mob.commons.a;
import com.mob.commons.i;
import com.mob.commons.j;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class h {
    private static final String a;
    private int b;
    private String c;
    private int d;
    private String e;
    private String f;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = j.a();
        stringBuilder.append(string2);
        stringBuilder.append("/privacy/policy");
        a = stringBuilder.toString();
    }

    public h() {
        String string2;
        int n10;
        this.b = n10 = i.w();
        this.c = string2 = i.v();
        this.d = n10 = i.y();
        this.e = string2 = i.x();
        this.f = string2 = i.z();
    }

    private void a(int n10, String string2, String string3) {
        PrivacyPolicy privacyPolicy = new PrivacyPolicy(string3);
        int n11 = 1;
        if (n10 == n11) {
            this.e = string3;
            this.d = n10 = privacyPolicy.getPpVersion();
            String string4 = this.e;
            i.l(string4);
            n10 = this.d;
            i.b(n10);
        } else {
            n11 = 2;
            if (n10 == n11) {
                this.c = string3;
                this.b = n10 = privacyPolicy.getPpVersion();
                String string5 = this.c;
                i.k(string5);
                n10 = this.b;
                i.a(n10);
            }
        }
        this.f = string2;
        i.m(string2);
    }

    private boolean c(int n10, Locale object) {
        int n11 = 1;
        if (n10 == n11) {
            String string2 = this.e;
            n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
            if (n10 != 0) {
                return false;
            }
            n10 = this.d;
            int n12 = com.mob.commons.a.h();
            if (n10 < n12) {
                return false;
            }
            if (object != null && (n10 = (int)((string2 = ((Locale)object).toString()).equals(object = this.f) ? 1 : 0)) == 0) {
                return false;
            }
            return n11;
        }
        int n13 = 2;
        if (n10 == n13) {
            String string3 = this.c;
            n10 = (int)(TextUtils.isEmpty((CharSequence)string3) ? 1 : 0);
            if (n10 != 0) {
                return false;
            }
            n10 = this.b;
            n13 = com.mob.commons.a.h();
            if (n10 < n13) {
                return false;
            }
            if (object != null && (n10 = (int)((string3 = ((Locale)object).toString()).equals(object = this.f) ? 1 : 0)) == 0) {
                return false;
            }
            return n11;
        }
        return false;
    }

    public PrivacyPolicy a(int n10, Locale object) {
        int n11;
        int n12 = 1;
        if (n10 != n12 && n10 != (n11 = 2)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Parameter 'type' should be either 1 or 2");
            throw illegalArgumentException;
        }
        if (object == null) {
            n11 = Build.VERSION.SDK_INT;
            int n13 = 24;
            if (n11 >= n13) {
                LocaleList localeList = MobSDK.getContext().getResources().getConfiguration().getLocales();
                if (localeList != null && (n13 = (int)(localeList.isEmpty() ? 1 : 0)) == 0) {
                    object = localeList.get(0);
                }
            } else {
                object = MobSDK.getContext().getResources().getConfiguration().locale;
            }
        }
        if ((n11 = (int)(this.c(n10, (Locale)object) ? 1 : 0)) != 0) {
            PrivacyPolicy privacyPolicy;
            if (n10 == n12) {
                object = this.e;
                privacyPolicy = new PrivacyPolicy((String)object);
            } else {
                object = this.c;
                privacyPolicy = new PrivacyPolicy((String)object);
            }
            return privacyPolicy;
        }
        return this.b(n10, (Locale)object);
    }

    public PrivacyPolicy b(int n10, Locale object) {
        int n11;
        Object object2 = DeviceHelper.getInstance(MobSDK.getContext());
        Object object3 = MobSDK.getAppkey();
        object2 = ((DeviceHelper)object2).getPackageName();
        Object object4 = new ArrayList();
        CharSequence charSequence = String.valueOf(n10);
        String string2 = "type";
        Object object5 = new KVPair(string2, charSequence);
        ((ArrayList)object4).add(object5);
        charSequence = "appkey";
        object5 = new KVPair((String)charSequence, object3);
        ((ArrayList)object4).add(object5);
        object5 = "apppkg";
        object3 = new KVPair((String)object5, object2);
        ((ArrayList)object4).add(object3);
        int n12 = 1;
        n12 = n10 == n12 ? i.y() : i.w();
        object2 = String.valueOf(n12);
        object3 = new KVPair("ppVersion", object2);
        ((ArrayList)object4).add(object3);
        object3 = ((Locale)object).toString();
        object2 = new KVPair("language", object3);
        ((ArrayList)object4).add(object2);
        object2 = new NetworkHelper$NetworkTimeOut();
        ((NetworkHelper$NetworkTimeOut)object2).readTimout = 30000;
        ((NetworkHelper$NetworkTimeOut)object2).connectionTimeout = n11 = 10000;
        object3 = new ArrayList();
        charSequence = MobProductCollector.getUserIdentity();
        object5 = new KVPair("User-Identity", charSequence);
        ((ArrayList)object3).add(object5);
        object5 = MobLog.getInstance();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Request: ");
        string2 = a;
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("\nHeaders: ");
        ((StringBuilder)charSequence).append(object3);
        ((StringBuilder)charSequence).append("\nValues: ");
        ((StringBuilder)charSequence).append(object4);
        charSequence = ((StringBuilder)charSequence).toString();
        Object[] objectArray = new Object[]{};
        object5.d(charSequence, objectArray);
        object5 = new NetworkHelper();
        object2 = object5.httpGet(string2, (ArrayList)object4, (ArrayList)object3, (NetworkHelper$NetworkTimeOut)object2);
        object3 = MobLog.getInstance();
        object4 = new StringBuilder();
        ((StringBuilder)object4).append("Response: ");
        ((StringBuilder)object4).append((String)object2);
        object4 = ((StringBuilder)object4).toString();
        object5 = new Object[]{};
        ((NLog)object3).d(object4, object5);
        object3 = new Hashon();
        object4 = ((Hashon)object3).fromJson((String)object2);
        object5 = "Response is illegal: ";
        if (object4 != null) {
            string2 = "200";
            charSequence = String.valueOf(((HashMap)object4).get("code"));
            boolean bl2 = string2.equals(charSequence);
            if (bl2) {
                charSequence = "data";
                if ((object4 = ((HashMap)object4).get(charSequence)) != null) {
                    boolean bl3 = TextUtils.isEmpty((CharSequence)(object3 = ((Hashon)object3).fromObject(object4)));
                    if (!bl3) {
                        object = ((Locale)object).toString();
                        this.a(n10, (String)object, (String)object3);
                        PrivacyPolicy privacyPolicy = new PrivacyPolicy((String)object3);
                        return privacyPolicy;
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append((String)object5);
                    ((StringBuilder)object).append((String)object2);
                    object = ((StringBuilder)object).toString();
                    Throwable throwable = new Throwable((String)object);
                    throw throwable;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append((String)object5);
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                Throwable throwable = new Throwable((String)object);
                throw throwable;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Response code is not 200: ");
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            Throwable throwable = new Throwable((String)object);
            throw throwable;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append((String)object5);
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        Throwable throwable = new Throwable((String)object);
        throw throwable;
    }
}

