/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.DhcpInfo
 *  android.net.Network
 *  android.net.NetworkInfo
 *  android.net.NetworkInfo$DetailedState
 *  android.net.wifi.WifiManager
 *  android.os.Build$VERSION
 *  android.os.UserManager
 *  android.telephony.ServiceState
 *  android.telephony.SignalStrength
 *  android.telephony.SubscriptionManager
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  com.huawei.android.os.BuildEx$VERSION
 *  com.huawei.android.telephony.ServiceStateEx
 */
package com.huawei.hms.framework.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.UserManager;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.android.os.BuildEx;
import com.huawei.android.telephony.ServiceStateEx;
import com.huawei.hms.framework.common.ActivityUtil;
import com.huawei.hms.framework.common.ContextCompat;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil$1;
import com.huawei.hms.framework.common.NetworkUtil$2;
import com.huawei.hms.framework.common.ReflectionUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.util.Arrays;
import java.util.LinkedList;

public class NetworkUtil {
    private static final int INVALID_RSSI = 129;
    private static final String TAG = "NetworkUtil";
    private static final int TYPE_WIFI_P2P = 13;

    public static String getDnsServerIps(Context context) {
        return Arrays.toString(NetworkUtil.getDnsServerIpsFromConnectionManager(context));
    }

    private static String[] getDnsServerIpsFromConnectionManager(Context object) {
        int n10;
        LinkedList<Object> linkedList;
        block22: {
            String string2;
            String string3 = "getActiveNetworkInfo failed, exception:";
            linkedList = new LinkedList<Object>();
            int n11 = Build.VERSION.SDK_INT;
            int n12 = 21;
            if (n11 >= n12 && object != null && (object = (String[])ContextCompat.getSystemService((Context)object, string2 = "connectivity")) != null) {
                string2 = object.getActiveNetworkInfo();
                if (string2 == null) break block22;
                Network[] networkArray = object.getAllNetworks();
                int n13 = networkArray.length;
                block17: for (int i10 = 0; i10 < n13; ++i10) {
                    Object object2 = networkArray[i10];
                    if (object2 == null) continue;
                    Object object3 = object.getNetworkInfo((Network)object2);
                    if (object3 == null) continue;
                    int n14 = object3.getType();
                    int n15 = string2.getType();
                    if (n14 != n15) continue;
                    object2 = object.getLinkProperties((Network)object2);
                    if (object2 == null) continue;
                    object2 = object2.getDnsServers();
                    try {
                        object2 = object2.iterator();
                    }
                    catch (RuntimeException runtimeException) {
                        string2 = TAG;
                        networkArray = new StringBuilder();
                        networkArray.append(string3);
                        object = runtimeException.getClass().getSimpleName();
                        networkArray.append((String)object);
                        object = networkArray.toString();
                        Logger.i(string2, object);
                        break;
                    }
                    catch (SecurityException securityException) {
                        string2 = TAG;
                        networkArray = new StringBuilder();
                        networkArray.append(string3);
                        object = securityException.getClass().getSimpleName();
                        networkArray.append((String)object);
                        object = networkArray.toString();
                        Logger.i(string2, object);
                        break;
                    }
                    while (true) {
                        n14 = (int)(object2.hasNext() ? 1 : 0);
                        if (n14 == 0) continue block17;
                        object3 = object2.next();
                        object3 = (InetAddress)object3;
                        object3 = ((InetAddress)object3).getHostAddress();
                        linkedList.add(object3);
                        continue;
                        break;
                    }
                }
            }
        }
        if ((n10 = linkedList.isEmpty()) != 0) {
            object = new String[]{};
        } else {
            n10 = linkedList.size();
            object = new String[n10];
            object = linkedList.toArray((T[])object);
        }
        return object;
    }

    public static String getHost(String charSequence) {
        Object object;
        int n10 = TextUtils.isEmpty((CharSequence)charSequence);
        String string2 = "";
        if (n10 != 0) {
            return string2;
        }
        try {
            object = new URI((String)charSequence);
            int n11 = ((URI)object).getPort();
            int n12 = -1;
            if (n11 == n12) {
                return ((URI)object).getHost();
            }
            charSequence = new StringBuilder();
            string2 = ((URI)object).getHost();
            ((StringBuilder)charSequence).append(string2);
        }
        catch (URISyntaxException uRISyntaxException) {
            object = TAG;
            String string3 = uRISyntaxException.getClass().getSimpleName();
            Logger.w((String)object, string3);
            return string2;
        }
        ((StringBuilder)charSequence).append(":");
        n10 = ((URI)object).getPort();
        ((StringBuilder)charSequence).append(n10);
        return ((StringBuilder)charSequence).toString();
    }

    private static int getHwNetworkType(Context object) {
        int n10;
        block8: {
            String string2 = "com.huawei.android.os.BuildEx$VERSION";
            int n11 = ReflectionUtils.checkCompatible(string2);
            n10 = 0;
            if (n11 == 0) {
                return 0;
            }
            if (object != null && (object = (TelephonyManager)ContextCompat.getSystemService(object, string2 = "phone")) != null) {
                n11 = BuildEx.VERSION.EMUI_SDK_INT;
                int n12 = 21;
                if (n11 < n12) break block8;
                object = object.getServiceState();
                if (object == null) break block8;
                try {
                    int n13;
                    n10 = n13 = ServiceStateEx.getConfigRadioTechnology((ServiceState)object);
                }
                catch (NoClassDefFoundError noClassDefFoundError) {
                    object = TAG;
                    string2 = "NoClassDefFoundError occur in method getHwNetworkType.";
                    Logger.w((String)object, string2);
                }
                catch (NoSuchMethodError noSuchMethodError) {
                    object = TAG;
                    string2 = "NoSuchMethodError occur in method getHwNetworkType.";
                    Logger.w((String)object, string2);
                }
                catch (SecurityException securityException) {
                    object = TAG;
                    string2 = "requires permission maybe missing.";
                    Logger.w((String)object, string2);
                }
            }
        }
        return n10;
    }

    public static String getMNC(Context object) {
        boolean bl2;
        String string2 = "unknown";
        if (object == null) {
            return string2;
        }
        boolean bl3 = NetworkUtil.isSimReady(object);
        if (!bl3) {
            return string2;
        }
        bl3 = false;
        Object object2 = null;
        String string3 = "phone";
        boolean bl4 = (object = ContextCompat.getSystemService(object, string3)) instanceof TelephonyManager;
        if (bl4) {
            object2 = object;
            object2 = (TelephonyManager)object;
        }
        if (object2 == null) {
            Logger.e(TAG, "getSubscriptionOperatorType: other error!");
            return string2;
        }
        string2 = "46001";
        object = object2.getNetworkOperator();
        boolean bl5 = string2.equals(object);
        object = !(bl5 || (bl5 = (string2 = "46006").equals(object)) || (bl5 = (string2 = "46009").equals(object))) ? (!((bl5 = (string2 = "46000").equals(object)) || (bl5 = (string2 = "46002").equals(object)) || (bl5 = (string2 = "46004").equals(object)) || (bl5 = (string2 = "46007").equals(object))) ? (!((bl5 = (string2 = "46003").equals(object)) || (bl5 = (string2 = "46005").equals(object)) || (bl2 = (string2 = "46011").equals(object))) ? "other" : "China_Telecom") : "China_Mobile") : "China_Unicom";
        return object;
    }

    public static int getMobileRsrp(Context object) {
        object = NetworkUtil.getSignalStrength((Context)object);
        int n10 = 0;
        if (object == null) {
            return 0;
        }
        Object object2 = SignalStrength.class;
        Object[] objectArray = "getDbm";
        Class[] classArray = new Class[]{};
        object2 = ((Class)object2).getDeclaredMethod((String)objectArray, classArray);
        objectArray = new NetworkUtil$1((Method)object2);
        AccessController.doPrivileged(objectArray);
        objectArray = new Object[]{};
        object = ((Method)object2).invoke(object, objectArray);
        object = (Integer)object;
        try {
            n10 = (Integer)object;
        }
        catch (InvocationTargetException invocationTargetException) {
            object = TAG;
            object2 = "getDbm: InvocationTargetException";
            Logger.i((String)object, object2);
        }
        catch (IllegalAccessException illegalAccessException) {
            object = TAG;
            object2 = "getDbm: cannot access";
            Logger.i((String)object, object2);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object = TAG;
            object2 = "getDbm: function not found";
            Logger.i((String)object, object2);
        }
        return n10;
    }

    public static int getMobileRsrpLevel(Context object) {
        object = NetworkUtil.getSignalStrength((Context)object);
        int n10 = 0;
        if (object != null) {
            Object object2 = SignalStrength.class;
            Object[] objectArray = "getLteLevel";
            Class[] classArray = new Class[]{};
            object2 = ((Class)object2).getDeclaredMethod((String)objectArray, classArray);
            objectArray = new NetworkUtil$2((Method)object2);
            AccessController.doPrivileged(objectArray);
            objectArray = new Object[]{};
            object = ((Method)object2).invoke(object, objectArray);
            object = (Integer)object;
            try {
                n10 = (Integer)object;
            }
            catch (InvocationTargetException invocationTargetException) {
                object = TAG;
                object2 = "getLteLevel: InvocationTargetException";
                Logger.i((String)object, object2);
            }
            catch (IllegalAccessException illegalAccessException) {
                object = TAG;
                object2 = "getLteLevel: cannot access";
                Logger.i((String)object, object2);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object = TAG;
                object2 = "getLteLevel: function not found";
                Logger.i((String)object, object2);
            }
        }
        return n10;
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        String string2 = "android.permission.ACCESS_NETWORK_STATE";
        boolean bl2 = ContextCompat.checkSelfPermission(context, string2);
        NetworkInfo networkInfo = null;
        if (bl2 && (context = (ConnectivityManager)ContextCompat.getSystemService(context, string2 = "connectivity")) != null) {
            try {
                networkInfo = context.getActiveNetworkInfo();
            }
            catch (RuntimeException runtimeException) {
                string2 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getActiveNetworkInfo failed, exception:");
                String string3 = runtimeException.getClass().getSimpleName();
                stringBuilder.append(string3);
                String string4 = runtimeException.getMessage();
                stringBuilder.append(string4);
                string4 = stringBuilder.toString();
                Logger.i(string2, string4);
            }
        }
        return networkInfo;
    }

    public static NetworkInfo.DetailedState getNetworkStatus(Context object) {
        NetworkInfo.DetailedState detailedState = NetworkInfo.DetailedState.IDLE;
        if (object != null) {
            String string2 = "connectivity";
            boolean bl2 = (object = ContextCompat.getSystemService(object, string2)) instanceof ConnectivityManager;
            if (bl2) {
                block9: {
                    object = (ConnectivityManager)object;
                    object = object.getActiveNetworkInfo();
                    if (object == null) break block9;
                    object = object.getDetailedState();
                    detailedState = object;
                }
                object = TAG;
                string2 = "getNetworkStatus networkIsConnected netInfo is null!";
                try {
                    Logger.i((String)object, string2);
                }
                catch (RuntimeException runtimeException) {
                    string2 = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("getNetworkStatus exception");
                    String string3 = runtimeException.getClass().getSimpleName();
                    stringBuilder.append(string3);
                    String string4 = runtimeException.getMessage();
                    stringBuilder.append(string4);
                    string4 = stringBuilder.toString();
                    Logger.i(string2, string4);
                }
            } else {
                object = TAG;
                string2 = "getNetworkStatus ConnectivityManager is null!";
                Logger.i((String)object, string2);
            }
        }
        return detailedState;
    }

    public static int getNetworkType(Context context) {
        int n10;
        if (context != null) {
            NetworkInfo networkInfo = NetworkUtil.getNetworkInfo(context);
            n10 = NetworkUtil.getNetworkType(networkInfo, context);
        } else {
            n10 = 0;
            context = null;
        }
        return n10;
    }

    public static int getNetworkType(NetworkInfo networkInfo) {
        return NetworkUtil.getNetworkType(networkInfo, null);
    }

    public static int getNetworkType(NetworkInfo networkInfo, Context context) {
        int n10;
        block9: {
            float f10;
            block8: {
                String string2;
                block10: {
                    float f11;
                    int n11;
                    block11: {
                        float f12;
                        int n12;
                        block12: {
                            int n13;
                            int n14;
                            n10 = 1;
                            f10 = Float.MIN_VALUE;
                            if (networkInfo == null || (n12 = networkInfo.isConnected()) == 0) break block8;
                            n12 = networkInfo.getType();
                            if (n10 == n12 || (n14 = 13) == n12) break block9;
                            if (n12 != 0) break block10;
                            int n15 = NetworkUtil.getHwNetworkType(context);
                            string2 = TAG;
                            CharSequence charSequence = new StringBuilder();
                            String string3 = "getHwNetworkType return is: ";
                            charSequence.append(string3);
                            charSequence.append(n15);
                            charSequence = charSequence.toString();
                            Logger.v(string2, charSequence);
                            if (n15 == 0) {
                                n15 = networkInfo.getSubtype();
                            }
                            n11 = 20;
                            f11 = 2.8E-44f;
                            n10 = 3;
                            f10 = 4.2E-45f;
                            n12 = 2;
                            f12 = 2.8E-45f;
                            if (n15 != n11) {
                                switch (n15) {
                                    default: {
                                        n11 = 0;
                                        networkInfo = null;
                                        f11 = 0.0f;
                                        break;
                                    }
                                    case 13: {
                                        n11 = 4;
                                        f11 = 5.6E-45f;
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
                                        n11 = n10;
                                        f11 = f10;
                                        break;
                                    }
                                    case 1: 
                                    case 2: 
                                    case 4: 
                                    case 7: 
                                    case 11: {
                                        n11 = n12;
                                        f11 = f12;
                                        break;
                                    }
                                }
                            } else {
                                n11 = 5;
                                f11 = 7.0E-45f;
                            }
                            if (n11 != 0 || (n14 = Build.VERSION.SDK_INT) < (n13 = 25)) break block11;
                            n11 = 16;
                            f11 = 2.24E-44f;
                            if (n15 == n11) break block12;
                            n11 = 17;
                            f11 = 2.4E-44f;
                            if (n15 == n11) break block9;
                            break block10;
                        }
                        n10 = n12;
                        f10 = f12;
                        break block9;
                    }
                    n10 = n11;
                    f10 = f11;
                    break block9;
                }
                n10 = 0;
                string2 = null;
                f10 = 0.0f;
                break block9;
            }
            n10 = -1;
            f10 = 0.0f / 0.0f;
        }
        return n10;
    }

    private static SignalStrength getSignalStrength(Context object) {
        String string2;
        int n10;
        int n11;
        if (object != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 28) && (n11 = (object = ContextCompat.getSystemService(object, string2 = "phone")) instanceof TelephonyManager) != 0) {
            object = (TelephonyManager)object;
            n11 = SubscriptionManager.getDefaultDataSubscriptionId();
            return object.createForSubscriptionId(n11).getSignalStrength();
        }
        return null;
    }

    public static String getWifiGatewayIp(Context object) {
        String string2;
        block12: {
            string2 = " ";
            if (object != null) {
                object = object.getApplicationContext();
                Object object2 = "wifi";
                int n10 = (object = ContextCompat.getSystemService((Context)object, (String)object2)) instanceof WifiManager;
                if (n10 != 0) {
                    String string3;
                    object = (WifiManager)object;
                    object = object.getDhcpInfo();
                    int n11 = ((DhcpInfo)object).gateway;
                    n10 = 4;
                    object2 = new byte[n10];
                    int n12 = 0;
                    StringBuilder stringBuilder = null;
                    byte by2 = (byte)(n11 & 0xFF);
                    object2[0] = by2;
                    n12 = 1;
                    by2 = (byte)(n11 >> 8 & 0xFF);
                    object2[n12] = by2;
                    n12 = 2;
                    by2 = (byte)(n11 >> 16 & 0xFF);
                    object2[n12] = by2;
                    n12 = 3;
                    n11 = (byte)(n11 >> 24 & 0xFF);
                    object2[n12] = n11;
                    object = InetAddress.getByAddress((byte[])object2);
                    try {
                        string2 = ((InetAddress)object).getHostAddress();
                        break block12;
                    }
                    catch (UnknownHostException unknownHostException) {
                    }
                    catch (RuntimeException runtimeException) {
                        // empty catch block
                    }
                    object2 = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("getWifiGatewayIp error!");
                    String string4 = string3.getClass().getSimpleName();
                    stringBuilder.append(string4);
                    string3 = ((Throwable)((Object)string3)).getMessage();
                    stringBuilder.append(string3);
                    string3 = stringBuilder.toString();
                    Logger.i((String)object2, string3);
                }
            }
        }
        return string2;
    }

    public static int getWifiRssi(Context object) {
        int n10;
        block6: {
            n10 = -127;
            if (object != null) {
                object = object.getApplicationContext();
                String string2 = "wifi";
                boolean bl2 = (object = ContextCompat.getSystemService(object, string2)) instanceof WifiManager;
                if (bl2) {
                    object = (WifiManager)object;
                    object = object.getConnectionInfo();
                    if (object == null) break block6;
                    string2 = object.getBSSID();
                    if (string2 == null) break block6;
                    try {
                        int n11;
                        n10 = n11 = object.getRssi();
                    }
                    catch (RuntimeException runtimeException) {
                        string2 = TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("getWifiRssiLevel did not has permission!");
                        String string3 = runtimeException.getClass().getSimpleName();
                        stringBuilder.append(string3);
                        String string4 = runtimeException.getMessage();
                        stringBuilder.append(string4);
                        string4 = stringBuilder.toString();
                        Logger.i(string2, string4);
                    }
                }
            }
        }
        return n10;
    }

    public static int getWifiRssiLevel(Context context) {
        return WifiManager.calculateSignalLevel((int)NetworkUtil.getWifiRssi(context), (int)5);
    }

    public static boolean isForeground(Context context) {
        return ActivityUtil.isForeground(context);
    }

    public static boolean isNetworkAvailable(Context context) {
        boolean bl2;
        String string2 = "android.permission.ACCESS_NETWORK_STATE";
        boolean bl3 = ContextCompat.checkSelfPermission(context, string2);
        boolean bl4 = true;
        if (bl3 && ((context = NetworkUtil.getNetworkInfo(context)) == null || !(bl2 = context.isConnected()))) {
            bl4 = false;
        }
        return bl4;
    }

    public static boolean isSimReady(Context object) {
        int n10;
        String string2 = "phone";
        int n11 = (object = ContextCompat.getSystemService(object, string2)) instanceof TelephonyManager;
        if (n11 != 0) {
            object = (TelephonyManager)object;
        } else {
            n10 = 0;
            object = null;
        }
        if (object != null && (n10 = object.getSimState()) == (n11 = 5)) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public static boolean isUserUnlocked(Context context) {
        String string2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11 && (context = (UserManager)ContextCompat.getSystemService(context, string2 = "user")) != null) {
            try {
                return context.isUserUnlocked();
            }
            catch (RuntimeException runtimeException) {
                string2 = TAG;
                String string3 = "dealType rethrowFromSystemServer:";
                Logger.e(string2, string3, runtimeException);
            }
        }
        return true;
    }

    public static NetworkInfo.DetailedState networkStatus(Context context) {
        return NetworkUtil.getNetworkStatus(context);
    }

    public static int readDataSaverMode(Context object) {
        String string2;
        int n10;
        int n11;
        int n12 = 0;
        if (object != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 24) && (n11 = (int)(ContextCompat.checkSelfPermission(object, string2 = "android.permission.ACCESS_NETWORK_STATE") ? 1 : 0)) != 0 && (n11 = (object = ContextCompat.getSystemService(object, string2 = "connectivity")) instanceof ConnectivityManager) != 0) {
            block6: {
                int n13;
                object = (ConnectivityManager)object;
                n11 = (int)(object.isActiveNetworkMetered() ? 1 : 0);
                if (n11 == 0) break block6;
                n12 = n13 = object.getRestrictBackgroundStatus();
            }
            object = TAG;
            string2 = "ConnectType is not Mobile Network!";
            try {
                Logger.v((String)object, string2);
            }
            catch (RuntimeException runtimeException) {
                string2 = TAG;
                String string3 = "SystemServer error:";
                Logger.e(string2, string3, runtimeException);
            }
        }
        return n12;
    }
}

