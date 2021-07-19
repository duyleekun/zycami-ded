/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.text.TextUtils
 */
package cn.sharesdk.framework.loopshare.watermark;

import android.os.Build;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class e {
    private static String a;
    private static String b;

    public static boolean a() {
        return e.a("EMUI");
    }

    public static boolean a(String string2) {
        String string3 = a;
        if (string3 != null) {
            return string3.equals(string2);
        }
        b = string3 = e.b("ro.miui.ui.version.name");
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2) {
            a = string3 = "MIUI";
        } else {
            b = string3 = e.b("ro.build.version.emui");
            bl2 = TextUtils.isEmpty((CharSequence)string3);
            if (!bl2) {
                a = string3 = "EMUI";
            } else {
                b = string3 = e.b("ro.build.version.opporom");
                bl2 = TextUtils.isEmpty((CharSequence)string3);
                if (!bl2) {
                    a = string3 = "OPPO";
                } else {
                    b = string3 = e.b("ro.vivo.os.version");
                    bl2 = TextUtils.isEmpty((CharSequence)string3);
                    if (!bl2) {
                        a = string3 = "VIVO";
                    } else {
                        b = string3 = e.b("ro.smartisan.version");
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
        void var0_5;
        Object object;
        block34: {
            Object object2;
            block35: {
                void var2_11;
                Object object3;
                block33: {
                    object = null;
                    Object object4 = Runtime.getRuntime();
                    object2 = new StringBuilder();
                    object3 = "getprop ";
                    ((StringBuilder)object2).append((String)object3);
                    ((StringBuilder)object2).append(string2);
                    object2 = ((StringBuilder)object2).toString();
                    object4 = ((Runtime)object4).exec((String)object2);
                    object4 = ((Process)object4).getInputStream();
                    object3 = new InputStreamReader((InputStream)object4);
                    int n10 = 1024;
                    object2 = new BufferedReader((Reader)object3, n10);
                    object4 = ((BufferedReader)object2).readLine();
                    ((BufferedReader)object2).close();
                    try {
                        ((BufferedReader)object2).close();
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                    return object4;
                    catch (IOException iOException) {
                        break block33;
                    }
                    catch (Throwable throwable) {
                        break block34;
                    }
                    catch (IOException iOException) {
                        object2 = null;
                    }
                }
                object3 = SSDKLog.b();
                String string3 = "ShareSDK";
                int n11 = 2;
                Object[] objectArray = new Object[n11];
                StringBuilder stringBuilder = new StringBuilder();
                String string4 = "Unable to read prop ";
                stringBuilder.append(string4);
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                objectArray[0] = string2;
                int n12 = 1;
                objectArray[n12] = var2_11;
                ((NLog)object3).e(string3, objectArray);
                if (object2 == null) break block35;
                try {
                    ((BufferedReader)object2).close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            return null;
            catch (Throwable throwable) {
                object = object2;
            }
        }
        if (object != null) {
            try {
                ((BufferedReader)object).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        throw var0_5;
    }

    public static boolean b() {
        return e.a("VIVO");
    }
}

