/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.security.NetworkSecurityPolicy
 *  android.text.TextUtils
 */
package com.mob.commons;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.j$1;
import com.mob.commons.k;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ReflectHelper;

public class j {
    public static String a() {
        String string2 = "api.fc.mob.com";
        Object object = MobSDK.getContext();
        object = DeviceHelper.getInstance((Context)object);
        int n10 = 17;
        Object object2 = k.a(n10);
        boolean bl2 = ((DeviceHelper)object).isPackageInstalled((String)object2);
        try {
            n10 = (int)(MobSDK.checkV6() ? 1 : 0);
            if (n10 == 0 && !bl2) {
                string2 = "m.data.mob.com";
            }
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).d(throwable);
        }
        return j.b(string2);
    }

    public static String a(String string2) {
        Object object;
        int n10;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return string2;
        }
        String string3 = "http://";
        Object object2 = string2.startsWith(string3);
        String string4 = "";
        if (object2 != 0) {
            string2 = string2.replace(string3, string4);
        }
        if ((n10 = string2.startsWith((String)(object = "https://"))) != 0) {
            string2 = string2.replace((CharSequence)object, string4);
        }
        object = j$1.a;
        Object object3 = MobSDK.getDomain();
        n10 = ((Enum)object3).ordinal();
        object2 = object[n10];
        if (object2 != (n10 = 1)) {
            n10 = 2;
            if (object2 == n10) {
                string4 = "us";
            }
        } else {
            string4 = "jp";
        }
        object2 = TextUtils.isEmpty((CharSequence)string4);
        if (object2 != 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            return j.c(((StringBuilder)object).toString());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(string4);
        object3 = ".";
        ((StringBuilder)object).append((String)object3);
        object = ((StringBuilder)object).toString();
        object2 = string2.startsWith((String)object);
        if (object2 != 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            return j.c(((StringBuilder)object).toString());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append(string4);
        ((StringBuilder)object).append((String)object3);
        ((StringBuilder)object).append(string2);
        return j.c(((StringBuilder)object).toString());
    }

    public static String b() {
        String string2 = "api.fd.mob.com";
        Object object = MobSDK.getContext();
        object = DeviceHelper.getInstance((Context)object);
        int n10 = 17;
        Object object2 = k.a(n10);
        boolean bl2 = ((DeviceHelper)object).isPackageInstalled((String)object2);
        try {
            n10 = (int)(MobSDK.checkV6() ? 1 : 0);
            if (n10 == 0 && !bl2) {
                string2 = "c.data.mob.com";
            }
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).d(throwable);
        }
        return j.b(string2);
    }

    public static String b(String string2) {
        Object object;
        Object object2;
        int n10;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return string2;
        }
        String string3 = "http://";
        Object object3 = string2.startsWith(string3);
        String string4 = "";
        if (object3 != 0) {
            string2 = string2.replace(string3, string4);
        }
        if ((n10 = string2.startsWith((String)(object2 = "https://"))) != 0) {
            string2 = string2.replace((CharSequence)object2, string4);
        }
        if ((object3 = MobSDK.checkV6()) != 0) {
            string4 = "v6";
        } else {
            object2 = j$1.a;
            object = MobSDK.getDomain();
            n10 = ((Enum)object).ordinal();
            object3 = object2[n10];
            if (object3 != (n10 = 1)) {
                n10 = 2;
                if (object3 == n10) {
                    string4 = "us";
                }
            } else {
                string4 = "jp";
            }
        }
        object3 = TextUtils.isEmpty((CharSequence)string4);
        if (object3 != 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(string2);
            return j.c(((StringBuilder)object2).toString());
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string4);
        object = ".";
        ((StringBuilder)object2).append((String)object);
        object2 = ((StringBuilder)object2).toString();
        object3 = string2.startsWith((String)object2);
        if (object3 != 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(string2);
            return j.c(((StringBuilder)object2).toString());
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string3);
        ((StringBuilder)object2).append(string4);
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(string2);
        return j.c(((StringBuilder)object2).toString());
    }

    public static String c(String string2) {
        block41: {
            Object object;
            Object throwable;
            String string3;
            block46: {
                String string4;
                String string5;
                Object[] objectArray;
                block45: {
                    CharSequence charSequence;
                    block42: {
                        StringBuilder stringBuilder;
                        int n10;
                        int n11;
                        int n12;
                        block44: {
                            block43: {
                                int n13;
                                block40: {
                                    block39: {
                                        n12 = Build.VERSION.SDK_INT;
                                        n11 = TextUtils.isEmpty((CharSequence)string2);
                                        if (n11 == 0) break block39;
                                        return string2;
                                    }
                                    n11 = MobSDK.checkForceHttps();
                                    if (n11 != 0) break block40;
                                    n10 = 23;
                                    if (n12 < n10) break block41;
                                    objectArray = NetworkSecurityPolicy.getInstance();
                                    n10 = (int)(objectArray.isCleartextTrafficPermitted() ? 1 : 0);
                                    if (n10 != 0) break block41;
                                }
                                string2 = string2.trim();
                                objectArray = "http://";
                                n10 = (int)(string2.startsWith((String)objectArray) ? 1 : 0);
                                if (n10 == 0) break block41;
                                objectArray = string2.trim();
                                objectArray = Uri.parse((String)objectArray);
                                if (objectArray == null) break block41;
                                charSequence = objectArray.getScheme();
                                if (charSequence == null) break block41;
                                string5 = "http";
                                boolean n132 = ((String)charSequence).equals(string5);
                                if (!n132) break block41;
                                charSequence = objectArray.getHost();
                                string5 = objectArray.getPath();
                                string4 = objectArray.getQuery();
                                string3 = "";
                                if (charSequence == null) break block42;
                                n10 = objectArray.getPort();
                                stringBuilder = new StringBuilder();
                                stringBuilder.append((String)charSequence);
                                if (n10 <= 0 || n10 == (n13 = 80)) break block43;
                                charSequence = new StringBuilder();
                                String string6 = ":";
                                ((StringBuilder)charSequence).append(string6);
                                ((StringBuilder)charSequence).append(n10);
                                objectArray = ((StringBuilder)charSequence).toString();
                                break block44;
                            }
                            objectArray = string3;
                        }
                        stringBuilder.append((String)objectArray);
                        charSequence = stringBuilder.toString();
                        if (n11 != 0 || n12 < (n11 = 24)) break block42;
                        throwable = NetworkSecurityPolicy.getInstance();
                        object = "isCleartextTrafficPermitted";
                        n10 = 1;
                        objectArray = new Object[n10];
                        stringBuilder = null;
                        objectArray[0] = charSequence;
                        throwable = ReflectHelper.invokeInstanceMethod(throwable, (String)object, objectArray);
                        throwable = (Boolean)throwable;
                        n12 = (int)(((Boolean)throwable).booleanValue() ? 1 : 0);
                        if (n12 == 0) break block42;
                        return string2;
                    }
                    throwable = new StringBuilder();
                    object = "https://";
                    ((StringBuilder)throwable).append((String)object);
                    ((StringBuilder)throwable).append((String)charSequence);
                    if (string5 != null) break block45;
                    string5 = string3;
                }
                ((StringBuilder)throwable).append(string5);
                if (string4 == null) break block46;
                object = new StringBuilder();
                objectArray = "?";
                ((StringBuilder)object).append((String)objectArray);
                ((StringBuilder)object).append(string4);
                string3 = ((StringBuilder)object).toString();
            }
            try {
                ((StringBuilder)throwable).append(string3);
                return ((StringBuilder)throwable).toString();
            }
            catch (Throwable throwable2) {
                object = MobLog.getInstance();
                ((NLog)object).d(throwable2);
            }
        }
        return string2;
    }
}

