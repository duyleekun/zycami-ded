/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.net.NetworkInfo$State
 *  android.net.wifi.WifiManager
 *  android.os.Build$VERSION
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 */
package d.v.e.l;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import d.v.e.f;
import d.v.e.l.i2;
import d.v.e.l.i2$a;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import m.a.a;

public class b2 {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;

    private static NetworkInfo a() {
        Context context = f.a().c();
        String string2 = "connectivity";
        if ((context = (ConnectivityManager)context.getSystemService(string2)) == null) {
            return null;
        }
        return context.getActiveNetworkInfo();
    }

    public static String b(Context object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 14;
        if (n10 >= n11) {
            object = NetworkInterface.getNetworkInterfaces();
            while ((n11 = (int)(object.hasMoreElements() ? 1 : 0)) != 0) {
                boolean bl2;
                Enumeration<InetAddress> enumeration = ((NetworkInterface)object.nextElement()).getInetAddresses();
                while (bl2 = enumeration.hasMoreElements()) {
                    InetAddress inetAddress = enumeration.nextElement();
                    boolean bl3 = inetAddress.isLoopbackAddress();
                    if (bl3 || !(bl3 = inetAddress instanceof Inet4Address)) continue;
                    return inetAddress.getHostAddress().toString();
                }
            }
        } else {
            object = NetworkInterface.getNetworkInterfaces();
            while ((n11 = (int)(object.hasMoreElements() ? 1 : 0)) != 0) {
                boolean bl4;
                Enumeration<InetAddress> enumeration = ((NetworkInterface)object.nextElement()).getInetAddresses();
                while (bl4 = enumeration.hasMoreElements()) {
                    InetAddress inetAddress = enumeration.nextElement();
                    boolean bl5 = inetAddress.isLoopbackAddress();
                    if (bl5) continue;
                    return inetAddress.getHostAddress().toString();
                }
            }
        }
        return null;
    }

    public static int c(Context context) {
        int n10;
        boolean bl2;
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        int n11 = 0;
        Object object = connectivityManager.getNetworkInfo(0);
        int n12 = 1;
        connectivityManager = connectivityManager.getNetworkInfo(n12);
        if (object != null && (bl2 = object.isConnected())) {
            object = "phone";
            context = (TelephonyManager)context.getSystemService((String)object);
            n10 = context.getNetworkType();
            switch (n10) {
                default: {
                    break;
                }
                case 13: {
                    n11 = 4;
                    break;
                }
                case 3: 
                case 5: 
                case 6: 
                case 8: 
                case 9: 
                case 10: 
                case 12: 
                case 14: 
                case 15: {
                    n11 = 3;
                    break;
                }
                case 1: 
                case 2: 
                case 4: 
                case 7: 
                case 11: {
                    n11 = 2;
                }
            }
        }
        if (connectivityManager == null || (n10 = connectivityManager.isConnected()) == 0) {
            n12 = n11;
        }
        return n12;
    }

    public static String d(Context context) {
        return ((WifiManager)context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
    }

    public static String e(Context object) {
        String string2 = "wifi";
        if ((object = ((WifiManager)object.getSystemService(string2)).getConnectionInfo().getSSID()) == null) {
            object = "";
        }
        return object;
    }

    public static String f(Context context) {
        CharSequence charSequence = "wifi";
        int n10 = (context = ((WifiManager)context.getSystemService((String)charSequence)).getConnectionInfo()).getIpAddress();
        if (n10 == 0) {
            return null;
        }
        charSequence = new StringBuilder();
        int n11 = n10 & 0xFF;
        ((StringBuilder)charSequence).append(n11);
        String string2 = ".";
        ((StringBuilder)charSequence).append(string2);
        int n12 = n10 >> 8 & 0xFF;
        ((StringBuilder)charSequence).append(n12);
        ((StringBuilder)charSequence).append(string2);
        n12 = n10 >> 16 & 0xFF;
        ((StringBuilder)charSequence).append(n12);
        ((StringBuilder)charSequence).append(string2);
        n10 = n10 >> 24 & 0xFF;
        ((StringBuilder)charSequence).append(n10);
        return ((StringBuilder)charSequence).toString();
    }

    public static boolean g() {
        int n10;
        int n11;
        NetworkInfo networkInfo = b2.a();
        if (networkInfo != null && (n11 = networkInfo.isAvailable()) != 0 && (n10 = networkInfo.getSubtype()) == (n11 = 13)) {
            n10 = 1;
        } else {
            n10 = 0;
            networkInfo = null;
        }
        return n10 != 0;
    }

    public static boolean h() {
        return b2.i(null);
    }

    public static boolean i(String object) {
        boolean bl2;
        int n10;
        if (object == null || (n10 = ((String)object).length()) <= 0) {
            object = "223.5.5.5";
        }
        n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        object = i2.a(String.format("ping -c 1 %s", objectArray), false);
        int n11 = ((i2$a)object).a;
        if (!n11) {
            n11 = n10;
        } else {
            n11 = 0;
            objectArray = null;
        }
        Object[] objectArray2 = ((i2$a)object).c;
        if (objectArray2 != null && !(bl2 = TextUtils.isEmpty((CharSequence)objectArray2))) {
            objectArray2 = new Object[n10];
            String string2 = ((i2$a)object).c;
            objectArray2[0] = string2;
            string2 = "isAvailableByPing : error msg =  %s";
            m.a.a.e(string2, objectArray2);
        }
        if ((object = ((i2$a)object).b) != null) {
            Object[] objectArray3 = new Object[n10];
            objectArray3[0] = object;
            object = "isAvailableByPing success msg = %s";
            m.a.a.b((String)object, objectArray3);
        }
        return n11 != 0;
    }

    public static boolean j(Context context) {
        context = (WifiManager)context.getApplicationContext().getSystemService("wifi");
        Method[] methodArray = context.getClass().getDeclaredMethods();
        int n10 = methodArray.length;
        boolean bl2 = false;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object;
            block6: {
                String string2;
                object = methodArray[i10];
                Object[] objectArray = ((Method)object).getName();
                boolean bl3 = objectArray.equals(string2 = "isWifiApEnabled");
                if (!bl3) continue;
                objectArray = new Object[]{};
                object = ((Method)object).invoke(context, objectArray);
                if (object != null) break block6;
                return false;
            }
            object = (Boolean)object;
            try {
                bl2 = (Boolean)object;
                continue;
            }
            catch (Exception exception) {
                m.a.a.j(exception);
            }
        }
        return bl2;
    }

    public static boolean k(Context context) {
        return ((ConnectivityManager)context.getSystemService("connectivity")).isActiveNetworkMetered();
    }

    public static boolean l(Context context) {
        boolean bl2;
        context = (ConnectivityManager)context.getSystemService("connectivity");
        boolean bl3 = false;
        if (context != null && (context = context.getNetworkInfo(0)) != null && (bl2 = context.isConnectedOrConnecting())) {
            bl3 = true;
        }
        return bl3;
    }

    public static boolean m(Context networkInfoArray) {
        if ((networkInfoArray = (ConnectivityManager)networkInfoArray.getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        if ((networkInfoArray = networkInfoArray.getAllNetworkInfo()) != null) {
            int n10;
            for (int i10 = 0; i10 < (n10 = networkInfoArray.length); ++i10) {
                NetworkInfo.State state;
                NetworkInfo.State state2 = networkInfoArray[i10].getState();
                if (state2 != (state = NetworkInfo.State.CONNECTED)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean n(Context context) {
        return ((WifiManager)context.getSystemService("wifi")).isWifiEnabled();
    }

    public static boolean o() {
        return b2.p(f.a().c());
    }

    public static boolean p(Context context) {
        boolean bl2;
        String string2 = "connectivity";
        context = (ConnectivityManager)context.getSystemService(string2);
        boolean bl3 = true;
        if ((context = context.getNetworkInfo((int)(bl3 ? 1 : 0))) == null || !(bl2 = context.isConnectedOrConnecting())) {
            bl3 = false;
            string2 = null;
        }
        return bl3;
    }

    public static void q(Context context, boolean bl2) {
        ((WifiManager)context.getSystemService("wifi")).setWifiEnabled(bl2);
    }
}

