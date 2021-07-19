/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.net.ConnectivityManager
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.net.NetworkRequest
 *  android.net.NetworkRequest$Builder
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package com.mob.tools.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.NtFetcher$1;
import com.mob.tools.utils.NtFetcher$2;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.Strings;

public class NtFetcher {
    private static NtFetcher instance;
    private Context context;
    private DeviceHelper device;
    private Integer dtNtType;
    private String ntType;
    private BroadcastReceiver receiver;

    private NtFetcher(Context object) {
        this.context = object;
        object = DeviceHelper.getInstance((Context)object);
        this.device = object;
        boolean bl2 = ((DeviceHelper)object).isSensitiveDevice();
        if (bl2) {
            this.prepare();
        }
    }

    public static /* synthetic */ void access$000(NtFetcher ntFetcher) {
        ntFetcher.refreshNet();
    }

    private int getDataNtType() {
        int n10;
        int n11;
        block16: {
            Object[] objectArray;
            Object object;
            int n12;
            Object object2;
            block15: {
                object2 = this.device;
                String string2 = "phone";
                object2 = ((DeviceHelper)object2).getSystemServiceSafe(string2);
                n11 = -1;
                if (object2 == null) {
                    return n11;
                }
                n12 = Build.VERSION.SDK_INT;
                int n13 = 24;
                if (n12 < n13) break block15;
                object = this.device;
                objectArray = "android.permission.READ_PHONE_STATE";
                n12 = (int)(((DeviceHelper)object).checkPermission((String)objectArray) ? 1 : 0);
                if (n12 == 0) break block15;
                n12 = 101;
                object = Strings.getString(n12);
                objectArray = new Object[]{};
                object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object, objectArray);
                object2 = (Integer)object2;
                n10 = (Integer)object2;
                break block16;
            }
            n12 = 19;
            object = Strings.getString(n12);
            objectArray = new Object[]{};
            object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object, objectArray);
            object2 = (Integer)object2;
            try {
                n10 = (Integer)object2;
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).w(throwable);
            }
        }
        n11 = n10;
        return n11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static NtFetcher getInstance(Context context) {
        Object object = instance;
        if (object != null) return instance;
        object = NtFetcher.class;
        synchronized (object) {
            NtFetcher ntFetcher = instance;
            if (ntFetcher != null) return instance;
            instance = ntFetcher = new NtFetcher(context);
            return instance;
        }
    }

    private String getNetworkType() {
        block19: {
            Object object;
            Object object2;
            block23: {
                block22: {
                    block20: {
                        block21: {
                            object2 = this.device;
                            object = "android.permission.ACCESS_NETWORK_STATE";
                            boolean n10 = ((DeviceHelper)object2).checkPermission((String)object);
                            if (!n10) break block19;
                            object2 = this.device;
                            object = "connectivity";
                            object2 = ((DeviceHelper)object2).getSystemServiceSafe((String)object);
                            if (object2 == null) break block19;
                            object2 = (ConnectivityManager)object2;
                            object2 = object2.getActiveNetworkInfo();
                            if (object2 == null) break block19;
                            int n11 = object2.isAvailable();
                            if (n11 == 0) break block19;
                            int n12 = object2.getType();
                            if (n12 == 0) break block20;
                            n11 = 1;
                            if (n12 == n11) break block21;
                            switch (n12) {
                                default: {
                                    return String.valueOf(n12);
                                }
                                case 9: {
                                    return "ethernet";
                                }
                                case 8: {
                                    return "dummy";
                                }
                                case 7: {
                                    return "bluetooth";
                                }
                                case 6: 
                            }
                            return "wimax";
                        }
                        return "wifi";
                    }
                    boolean bl2 = this.is5GMobileNetwork();
                    if (!bl2) break block22;
                    return "5G";
                }
                boolean bl3 = this.is4GMobileNetwork();
                if (!bl3) break block23;
                return "4G";
            }
            try {
                boolean bl4 = this.isFastMobileNetwork();
                object2 = bl4 ? "3G" : "2G";
                return object2;
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).w(throwable);
            }
        }
        return "none";
    }

    private ConnectivityManager.NetworkCallback initNetworkCallback() {
        NtFetcher$1 ntFetcher$1 = new NtFetcher$1(this);
        return ntFetcher$1;
    }

    private boolean is4GMobileNetwork() {
        String string2;
        Object object = this.device.getSystemServiceSafe("phone");
        boolean bl2 = false;
        if (object == null) {
            return false;
        }
        int n10 = 19;
        try {
            string2 = Strings.getString(n10);
        }
        catch (Throwable throwable) {
            MobLog.getInstance().w(throwable);
            return false;
        }
        Object[] objectArray = new Object[]{};
        object = ReflectHelper.invokeInstanceMethod(object, string2, objectArray);
        object = (Integer)object;
        int n11 = (Integer)object;
        n10 = 13;
        if (n11 == n10) {
            bl2 = true;
        }
        return bl2;
    }

    private boolean is5GCommon() {
        String string2;
        Object object = this.device.getSystemServiceSafe("phone");
        boolean bl2 = false;
        if (object == null) {
            return false;
        }
        int n10 = 19;
        try {
            string2 = Strings.getString(n10);
        }
        catch (Throwable throwable) {
            MobLog.getInstance().w(throwable);
            return false;
        }
        Object[] objectArray = new Object[]{};
        object = ReflectHelper.invokeInstanceMethod(object, string2, objectArray);
        object = (Integer)object;
        int n11 = (Integer)object;
        n10 = 20;
        if (n11 == n10) {
            bl2 = true;
        }
        return bl2;
    }

    private boolean is5GHw() {
        block21: {
            Object object;
            Object object2;
            block23: {
                block22: {
                    object2 = this.device;
                    object = "android.permission.READ_PHONE_STATE";
                    boolean n11 = ((DeviceHelper)object2).checkPermission((String)object);
                    if (!n11) break block21;
                    object2 = this.device;
                    object2 = ((DeviceHelper)object2).getManufacturer();
                    boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
                    if (bl2) break block21;
                    object = "huawei";
                    boolean bl3 = ((String)object2).contains((CharSequence)object);
                    if (bl3) break block22;
                    object = "Huawei";
                    boolean bl4 = ((String)object2).contains((CharSequence)object);
                    if (bl4) break block22;
                    object = "HUAWEI";
                    boolean bl5 = ((String)object2).contains((CharSequence)object);
                    if (!bl5) break block21;
                }
                object2 = this.device;
                object = "phone";
                object2 = ((DeviceHelper)object2).getSystemServiceSafe((String)object);
                if (object2 != null) break block23;
                return false;
            }
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 29;
            if (n10 < n11) break block21;
            int n12 = 129;
            object = Strings.getString(n12);
            Object[] objectArray = new Object[]{};
            object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object, objectArray);
            int n13 = 131;
            object = Strings.getString(n13);
            objectArray = new Object[]{};
            object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object, objectArray);
            object2 = (Integer)object2;
            try {
                int n14 = (Integer)object2;
                int n15 = 20;
                if (n14 == n15) {
                    return true;
                }
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).w(throwable);
            }
        }
        return false;
    }

    private boolean is5GMobileNetwork() {
        boolean bl2 = this.is5GHw();
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        bl2 = this.maybe5G();
        if (bl2) {
            return bl3;
        }
        return this.is5GCommon();
    }

    private boolean isFastMobileNetwork() {
        boolean bl2;
        int n10;
        Object object = this.device.getSystemServiceSafe("phone");
        if (object == null) {
            return false;
        }
        int bl22 = 19;
        Object object2 = Strings.getString(bl22);
        Object[] objectArray = new Object[]{};
        object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
        object = (Integer)object;
        try {
            n10 = (Integer)object;
            bl2 = true;
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).w(throwable);
        }
        switch (n10) {
            default: {
                break;
            }
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 9: 
            case 10: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                return bl2;
            }
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean maybe5G() {
        String string2;
        Object object;
        boolean bl2 = false;
        try {
            object = this.device;
            string2 = "android.permission.READ_PHONE_STATE";
        }
        catch (Throwable throwable) {
            return bl2;
        }
        int n10 = ((DeviceHelper)object).checkPermission(string2);
        if (n10 == 0) return bl2;
        n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 < n11) return bl2;
        object = this.device;
        string2 = "phone";
        object = ((DeviceHelper)object).getSystemServiceSafe(string2);
        if (object == null) {
            return false;
        }
        n11 = 129;
        string2 = Strings.getString(n11);
        Object[] objectArray = new Object[]{};
        object = ReflectHelper.invokeInstanceMethod(object, string2, objectArray);
        n11 = 130;
        string2 = Strings.getString(n11);
        objectArray = new Object[]{};
        object = ReflectHelper.invokeInstanceMethod(object, string2, objectArray);
        object = (Integer)object;
        n10 = (Integer)object;
        n11 = 3;
        if (n10 != n11) return bl2;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void prepare() {
        try {
            DeviceHelper deviceHelper;
            Object object = this.device;
            Object object2 = "connectivity";
            object = ((DeviceHelper)object).getSystemServiceSafe((String)object2);
            object = (ConnectivityManager)object;
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 26;
            String string2 = "android.permission.ACCESS_NETWORK_STATE";
            if (n10 >= n11 && (n11 = (int)((deviceHelper = this.device).checkPermission(string2) ? 1 : 0)) != 0) {
                object2 = this.initNetworkCallback();
                object.registerDefaultNetworkCallback((ConnectivityManager.NetworkCallback)object2);
                return;
            }
            n11 = 21;
            if (n10 >= n11 && (n10 = (int)(((DeviceHelper)(object2 = this.device)).checkPermission(string2) ? 1 : 0)) != 0) {
                object2 = new NetworkRequest.Builder();
                object2 = object2.build();
                deviceHelper = this.initNetworkCallback();
                object.registerNetworkCallback((NetworkRequest)object2, (ConnectivityManager.NetworkCallback)deviceHelper);
                return;
            }
            this.registerRcv();
            return;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
        }
    }

    private void refreshNet() {
        Object object = this.getNetworkType();
        this.ntType = object;
        this.dtNtType = object = Integer.valueOf(this.getDataNtType());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void registerRcv() {
        int n10;
        String string2;
        Class[] classArray = new NtFetcher$2(this);
        this.receiver = classArray;
        classArray = new IntentFilter();
        String string3 = "android.net.conn.CONNECTIVITY_CHANGE";
        classArray.addAction(string3);
        try {
            string3 = this.context;
            string2 = "registerReceiver";
            n10 = 2;
        }
        catch (Throwable throwable) {
            return;
        }
        Object[] objectArray = new Object[n10];
        BroadcastReceiver broadcastReceiver = this.receiver;
        objectArray[0] = broadcastReceiver;
        int n11 = 1;
        objectArray[n11] = classArray;
        classArray = new Class[n10];
        Class<BroadcastReceiver> clazz = BroadcastReceiver.class;
        classArray[0] = clazz;
        clazz = IntentFilter.class;
        classArray[n11] = clazz;
        ReflectHelper.invokeInstanceMethod((Object)string3, string2, objectArray, classArray);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void unregisterRcv() {
        Class[] classArray = this.receiver;
        if (classArray != null) {
            try {
                Class<BroadcastReceiver> clazz;
                Context context = this.context;
                String string2 = "unregisterReceiver";
                int n10 = 1;
                Object[] objectArray = new Object[n10];
                objectArray[0] = classArray;
                classArray = new Class[n10];
                classArray[0] = clazz = BroadcastReceiver.class;
                ReflectHelper.invokeInstanceMethod((Object)context, string2, objectArray, classArray);
            }
            catch (Throwable throwable) {}
            classArray = null;
            this.receiver = null;
        }
    }

    public int getDtNtType() {
        synchronized (this) {
            Object object = this.device;
            boolean n10 = ((DeviceHelper)object).isSensitiveDevice();
            if (!n10 || (object = this.dtNtType) == null) {
                int n11 = this.getDataNtType();
                this.dtNtType = object = Integer.valueOf(n11);
            }
            object = this.dtNtType;
            int n12 = (Integer)object;
            return n12;
        }
    }

    public String getNtType() {
        synchronized (this) {
            Object object = this.device;
            boolean bl2 = ((DeviceHelper)object).isSensitiveDevice();
            if (!bl2 || (bl2 = TextUtils.isEmpty((CharSequence)(object = this.ntType)))) {
                this.ntType = object = this.getNetworkType();
            }
            object = this.ntType;
            return object;
        }
    }

    public void recycle() {
        this.unregisterRcv();
    }
}

