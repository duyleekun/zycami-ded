/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.util.AndroidRuntimeException
 *  android.util.Pair
 */
package com.huawei.hms.hatool;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import com.huawei.hms.hatool.f;
import com.huawei.hms.hatool.p0;
import com.huawei.hms.hatool.y;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class z0
extends f {
    /*
     * Loose catch block
     */
    public static String c() {
        Object object;
        block19: {
            Object object2;
            String string2;
            block26: {
                block25: {
                    block24: {
                        block23: {
                            block22: {
                                block21: {
                                    block20: {
                                        string2 = "hmsSdk";
                                        object2 = "";
                                        object = "com.huawei.android.os.BuildEx";
                                        object = Class.forName((String)object);
                                        String string3 = "getUDID";
                                        Object[] objectArray = null;
                                        Class[] classArray = new Class[]{};
                                        object = ((Class)object).getMethod(string3, classArray);
                                        string3 = null;
                                        objectArray = new Object[]{};
                                        object = ((Method)object).invoke(null, objectArray);
                                        object = (String)object;
                                        object2 = "getUDID success";
                                        try {
                                            y.c(string2, (String)object2);
                                            break block19;
                                        }
                                        catch (InvocationTargetException invocationTargetException) {
                                            object2 = object;
                                            break block20;
                                        }
                                        catch (IllegalArgumentException illegalArgumentException) {
                                            object2 = object;
                                            break block21;
                                        }
                                        catch (IllegalAccessException illegalAccessException) {
                                            object2 = object;
                                            break block22;
                                        }
                                        catch (NoSuchMethodException noSuchMethodException) {
                                            object2 = object;
                                            break block23;
                                        }
                                        catch (AndroidRuntimeException androidRuntimeException) {
                                            object2 = object;
                                            break block24;
                                        }
                                        catch (ClassNotFoundException classNotFoundException) {
                                            object2 = object;
                                            break block25;
                                        }
                                        catch (InvocationTargetException invocationTargetException) {}
                                    }
                                    object = "getUDID method invoke failed : InvocationTargetException";
                                    break block26;
                                    catch (IllegalArgumentException illegalArgumentException) {}
                                }
                                object = "getUDID method invoke failed : Illegal ArgumentException";
                                break block26;
                                catch (IllegalAccessException illegalAccessException) {}
                            }
                            object = "getUDID method invoke failed : Illegal AccessException";
                            break block26;
                            catch (NoSuchMethodException noSuchMethodException) {}
                        }
                        object = "getUDID method invoke failed : NoSuchMethodException";
                        break block26;
                        catch (AndroidRuntimeException androidRuntimeException) {}
                    }
                    object = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
                    break block26;
                    catch (ClassNotFoundException classNotFoundException) {}
                }
                object = "getUDID method invoke failed";
            }
            y.f(string2, (String)object);
            object = object2;
        }
        return object;
    }

    public static Pair e(Context object) {
        int n10;
        String string2 = "android.permission.READ_PHONE_STATE";
        int n11 = p0.a((Context)object, string2);
        String string3 = "";
        if (n11 != 0) {
            y.f("hmsSdk", "getMccAndMnc() Pair value is empty");
            object = new Pair((Object)string3, (Object)string3);
            return object;
        }
        string2 = "phone";
        if ((object = (TelephonyManager)object.getSystemService(string2)) == null) {
            object = new Pair((Object)string3, (Object)string3);
            return object;
        }
        n11 = object.getSimState();
        if (n11 != (n10 = 5)) {
            object = new Pair((Object)string3, (Object)string3);
            return object;
        }
        n11 = (int)(TextUtils.isEmpty((CharSequence)(object = object.getNetworkOperator())) ? 1 : 0);
        if (n11 == 0 && (n11 = (int)(TextUtils.equals((CharSequence)object, (CharSequence)(string2 = "null")) ? 1 : 0)) == 0) {
            n11 = ((String)object).length();
            if (n11 > (n10 = 3)) {
                string2 = ((String)object).substring(0, n10);
                object = ((String)object).substring(n10);
                string3 = new Pair((Object)string2, object);
                return string3;
            }
            object = new Pair((Object)string3, (Object)string3);
            return object;
        }
        object = new Pair((Object)string3, (Object)string3);
        return object;
    }

    public static String f(Context object) {
        String string2;
        block5: {
            String string3 = "android.permission.READ_PHONE_STATE";
            boolean bl2 = p0.a(object, string3);
            string2 = "";
            if (bl2) {
                return string2;
            }
            string3 = "phone";
            object = object.getSystemService(string3);
            object = (TelephonyManager)object;
            if (object == null) break block5;
            try {
                string2 = object.getDeviceId();
            }
            catch (SecurityException securityException) {
                object = "hmsSdk";
                string3 = "getDeviceID Incorrect permissions!";
                y.b((String)object, string3);
            }
        }
        return string2;
    }

    public static String g(Context object) {
        String string2;
        block5: {
            String string3 = "hmsSdk";
            y.a(string3, "getSerial : is executed.");
            string2 = "";
            if (object == null) {
                return string2;
            }
            String string4 = "android.permission.READ_PHONE_STATE";
            int n10 = p0.a(object, string4);
            if (n10 != 0) {
                return string2;
            }
            n10 = Build.VERSION.SDK_INT;
            int n11 = 26;
            if (n10 < n11) break block5;
            try {
                string2 = Build.getSerial();
            }
            catch (SecurityException securityException) {
                object = "getSerial() Incorrect permissions!";
                y.f(string3, (String)object);
            }
        }
        return string2;
    }

    public static String h(Context context) {
        String string2;
        String string3 = Build.SERIAL;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2 && !(bl2 = string3.equalsIgnoreCase(string2 = "unknown"))) {
            return string3;
        }
        return z0.g(context);
    }
}

