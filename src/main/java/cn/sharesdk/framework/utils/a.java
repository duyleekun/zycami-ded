/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.text.TextUtils
 */
package cn.sharesdk.framework.utils;

import android.os.Build;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class a {
    private static String a;
    private static String b;

    public static boolean a() {
        return cn.sharesdk.framework.utils.a.a("MIUI");
    }

    public static boolean a(String string2) {
        String string3 = a;
        if (string3 != null) {
            return string3.equals(string2);
        }
        b = string3 = cn.sharesdk.framework.utils.a.b("ro.miui.ui.version.name");
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2) {
            a = string3 = "MIUI";
        } else {
            b = string3 = cn.sharesdk.framework.utils.a.b("ro.build.version.emui");
            bl2 = TextUtils.isEmpty((CharSequence)string3);
            if (!bl2) {
                a = string3 = "EMUI";
            } else {
                b = string3 = cn.sharesdk.framework.utils.a.b("ro.build.version.opporom");
                bl2 = TextUtils.isEmpty((CharSequence)string3);
                if (!bl2) {
                    a = string3 = "OPPO";
                } else {
                    b = string3 = cn.sharesdk.framework.utils.a.b("ro.vivo.os.version");
                    bl2 = TextUtils.isEmpty((CharSequence)string3);
                    if (!bl2) {
                        a = string3 = "VIVO";
                    } else {
                        b = string3 = cn.sharesdk.framework.utils.a.b("ro.smartisan.version");
                        bl2 = TextUtils.isEmpty((CharSequence)string3);
                        if (!bl2) {
                            a = string3 = "SMARTISAN";
                        } else {
                            String string4;
                            b = string3 = Build.DISPLAY;
                            bl2 = (string3 = string3.toUpperCase()).contains(string4 = "FLYME");
                            if (bl2) {
                                a = string4;
                            } else {
                                b = "unknown";
                                a = string3 = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return a.equals(string2);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public static String b(String string2) {
        void var0_7;
        Object object;
        Object object2;
        Object object3;
        Object[] objectArray;
        block34: {
            block35: {
                Object object4;
                block33: {
                    objectArray = "CheckRomAll getProp finally catch ";
                    object3 = null;
                    object2 = Runtime.getRuntime();
                    object = new StringBuilder();
                    object4 = "getprop ";
                    ((StringBuilder)object).append((String)object4);
                    ((StringBuilder)object).append(string2);
                    object = ((StringBuilder)object).toString();
                    object2 = ((Runtime)object2).exec((String)object);
                    object2 = ((Process)object2).getInputStream();
                    object4 = new InputStreamReader((InputStream)object2);
                    int n10 = 1024;
                    object = new BufferedReader((Reader)object4, n10);
                    object2 = ((BufferedReader)object).readLine();
                    ((BufferedReader)object).close();
                    try {
                        ((BufferedReader)object).close();
                    }
                    catch (IOException iOException) {
                        object3 = SSDKLog.b();
                        object = new StringBuilder();
                        ((StringBuilder)object).append((String)objectArray);
                        ((StringBuilder)object).append(iOException);
                        String string3 = ((StringBuilder)object).toString();
                        objectArray = new Object[]{};
                        ((NLog)object3).d(string3, objectArray);
                    }
                    return object2;
                    catch (IOException iOException) {
                        break block33;
                    }
                    catch (Throwable throwable) {
                        break block34;
                    }
                    catch (IOException iOException) {
                        object = null;
                    }
                }
                object4 = SSDKLog.b();
                StringBuilder stringBuilder = new StringBuilder();
                String string4 = "CheckRomAll unable to read prop ";
                stringBuilder.append(string4);
                stringBuilder.append(string2);
                string2 = " ex ";
                stringBuilder.append(string2);
                stringBuilder.append(object2);
                string2 = stringBuilder.toString();
                object2 = new Object[]{};
                ((NLog)object4).d(string2, (Object[])object2);
                if (object == null) break block35;
                try {
                    ((BufferedReader)object).close();
                }
                catch (IOException iOException) {
                    object2 = SSDKLog.b();
                    object = new StringBuilder();
                    ((StringBuilder)object).append((String)objectArray);
                    ((StringBuilder)object).append(iOException);
                    String string5 = ((StringBuilder)object).toString();
                    objectArray = new Object[]{};
                    ((NLog)object2).d(string5, objectArray);
                }
            }
            return null;
            catch (Throwable throwable) {
                object3 = object;
            }
        }
        if (object3 != null) {
            try {
                ((BufferedReader)object3).close();
            }
            catch (IOException iOException) {
                object2 = SSDKLog.b();
                object = new StringBuilder();
                ((StringBuilder)object).append((String)objectArray);
                ((StringBuilder)object).append(iOException);
                objectArray = ((StringBuilder)object).toString();
                Object[] objectArray2 = new Object[]{};
                ((NLog)object2).d(objectArray, objectArray2);
            }
        }
        throw var0_7;
    }
}

