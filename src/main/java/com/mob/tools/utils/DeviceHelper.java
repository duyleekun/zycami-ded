/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager
 *  android.app.ActivityManager$MemoryInfo
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.app.ActivityManager$RunningServiceInfo
 *  android.app.ActivityManager$RunningTaskInfo
 *  android.app.KeyguardManager
 *  android.app.UiModeManager
 *  android.app.WallpaperManager
 *  android.app.usage.UsageStats
 *  android.app.usage.UsageStatsManager
 *  android.bluetooth.BluetoothAdapter
 *  android.content.ActivityNotFoundException
 *  android.content.BroadcastReceiver
 *  android.content.ClipData
 *  android.content.ClipboardManager
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.ServiceConnection
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.content.res.Configuration
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.drawable.BitmapDrawable
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CameraManager
 *  android.location.Location
 *  android.net.Proxy
 *  android.net.TrafficStats
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.Handler$Callback
 *  android.os.IBinder
 *  android.os.Looper
 *  android.os.Parcel
 *  android.os.PowerManager
 *  android.os.Process
 *  android.os.StatFs
 *  android.os.SystemClock
 *  android.provider.MediaStore$Images$Media
 *  android.provider.Settings$Secure
 *  android.provider.Settings$System
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.util.Size
 *  android.view.View
 *  android.view.inputmethod.InputMethodInfo
 *  android.view.inputmethod.InputMethodManager
 */
package com.mob.tools.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.location.Location;
import android.net.Proxy;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Size;
import android.view.View;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BHelper;
import com.mob.tools.utils.BVS;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper$1;
import com.mob.tools.utils.DeviceHelper$2;
import com.mob.tools.utils.DeviceHelper$3;
import com.mob.tools.utils.DeviceHelper$4;
import com.mob.tools.utils.DeviceHelper$5;
import com.mob.tools.utils.DeviceHelper$6;
import com.mob.tools.utils.DeviceHelper$7;
import com.mob.tools.utils.DeviceHelper$BtScanCallback;
import com.mob.tools.utils.DeviceHelper$BtWatcher;
import com.mob.tools.utils.DeviceHelper$GSConnection;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.LHelper;
import com.mob.tools.utils.NtFetcher;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ReflectHelper$ReflectRunnable;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.SmltHelper;
import com.mob.tools.utils.Strings;
import com.mob.tools.utils.UIHandler;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceHelper {
    private static DeviceHelper deviceHelper;
    private String advertiseID;
    private ArrayList bufIm;
    private HashMap bufMacs;
    private String bufModel;
    private String bufUiVersion;
    private BVS bvs;
    private String cacheDeviceKey = null;
    private Context context;
    private volatile boolean hasSdcardWritePermission = false;
    private String imei;
    private String[] invalidMacList;
    private Boolean isSmlt;
    private String ln;
    private int sActCnt;
    private List sActList;
    private String serialno;
    private String swVer;
    private String wifimac;

    private DeviceHelper(Context object) {
        Cloneable cloneable = "-1";
        this.ln = cloneable;
        this.swVer = cloneable;
        this.sActCnt = -1;
        this.bufIm = cloneable = new Cloneable();
        this.bufMacs = cloneable;
        this.context = object = object.getApplicationContext();
        super();
        this.bvs = object;
    }

    private String byteToHex(byte[] byArray) {
        int n10;
        if (byArray == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n11 = byArray.length;
        int n12 = 0;
        while (true) {
            Object object;
            n10 = 1;
            if (n12 >= n11) break;
            byte by2 = byArray[n12];
            Object object2 = new Object[n10];
            object2[0] = object = Byte.valueOf(by2);
            object = "%02x:";
            object2 = String.format((String)object, object2);
            stringBuilder.append((String)object2);
            ++n12;
        }
        int n13 = stringBuilder.length();
        if (n13 > 0) {
            n13 = stringBuilder.length() - n10;
            stringBuilder.deleteCharAt(n13);
        }
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean checkMacIsValid(String string2) {
        NLog nLog = null;
        if (string2 == null) return false;
        int n10 = 1;
        try {
            int n11;
            String[] stringArray = string2.trim();
            int n12 = TextUtils.isEmpty((CharSequence)stringArray);
            if (n12 != 0) {
                return false;
            }
            stringArray = this.invalidMacList;
            if (stringArray == null) {
                this.invalidMacList = stringArray = this.getInvalidMacList();
            }
            if ((stringArray = this.invalidMacList) == null) {
                String string3;
                n12 = 2;
                stringArray = new String[n12];
                n11 = 70;
                stringArray[0] = string3 = Strings.getString(n11);
                n11 = 71;
                stringArray[n10] = string3 = Strings.getString(n11);
            }
            n11 = stringArray.length;
            int n13 = 0;
            while (n13 < n11) {
                String string4;
                boolean bl2;
                String string5 = stringArray[n13];
                if (string5 != null && (bl2 = (string4 = string2.trim()).startsWith(string5 = string5.trim()))) {
                    return false;
                }
                ++n13;
            }
            return n10 != 0;
        }
        catch (Throwable throwable) {
            nLog = MobLog.getInstance();
            nLog.d(throwable);
        }
        return n10 != 0;
    }

    private boolean checkRootApp() {
        int n10;
        String string2 = "com.koushikdutta.superuser";
        Object object = "com.thirdparty.superuser";
        String string3 = "com.yellowes.su";
        String string4 = "com.topjohnwu.magisk";
        String string5 = "com.koushikdutta.rommanager";
        String string6 = "com.koushikdutta.rommanager.license";
        String string7 = "com.dimonvideo.luckypatcher";
        String string8 = "com.chelpus.lackypatch";
        String string9 = "com.ramdroid.appquarantine";
        String string10 = "com.ramdroid.appquarantinepro";
        String string11 = "com.android.vending.billing.InAppBillingService.COIN";
        String string12 = "com.chelpus.luckypatcher";
        String[] stringArray = new String[]{"com.noshufou.android.su", "com.noshufou.android.su.elite", "eu.chainfire.supersu", string2, object, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12};
        NLog nLog = null;
        for (int i10 = 0; i10 < (n10 = 15); ++i10) {
            string2 = stringArray[i10];
            object = deviceHelper;
            try {
                n10 = (int)(((DeviceHelper)object).isPackageInstalled(string2) ? 1 : 0);
                if (n10 == 0) continue;
                return true;
            }
            catch (Throwable throwable) {
                nLog = MobLog.getInstance();
                nLog.w(throwable);
                break;
            }
        }
        return false;
    }

    private boolean checkRootFile() {
        boolean bl2;
        int n10;
        Object object = "/system/app/Superuser.apk";
        File file = new File((String)object);
        int n11 = file.exists();
        boolean bl3 = true;
        if (n11 != 0) {
            return bl3;
        }
        n11 = 16;
        String[] stringArray = "/data/local/";
        String string2 = "/data/local/bin/";
        String string3 = "/data/local/xbin/";
        Object object2 = "/sbin/";
        String string4 = "/su/bin/";
        String string5 = "/system/bin/";
        String string6 = "/system/bin/.ext/";
        String string7 = "/system/bin/failsafe/";
        String string8 = "/system/sd/xbin/";
        String string9 = "/system/usr/we-need-root/";
        String string10 = "/system/xbin/";
        String string11 = "/system/sbin/";
        String string12 = "/vendor/bin/";
        String string13 = "/cache";
        String string14 = "/data";
        String string15 = "/dev";
        stringArray = new String[]{stringArray, string2, string3, object2, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15};
        string2 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            string3 = stringArray[n10];
            string4 = "su";
            object2 = new File(string3, string4);
            bl2 = ((File)object2).exists();
            if (!bl2) continue;
            return bl3;
        }
        string2 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            string3 = stringArray[n10];
            string4 = "busybox";
            object2 = new File(string3, string4);
            bl2 = ((File)object2).exists();
            if (!bl2) continue;
            return bl3;
        }
        string2 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            string3 = stringArray[n10];
            string4 = "magisk";
            try {
                object2 = new File(string3, string4);
                bl2 = ((File)object2).exists();
                if (!bl2) continue;
                return bl3;
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).w(throwable);
                break;
            }
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean checkRootProp() {
        Object object;
        block28: {
            object = "getprop";
            object = new String[]{object};
            object = this.invokeRuntimeExec((String[])object);
            if (object != null) break block28;
            return false;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>((InputStream)object);
        object = "\\A";
        object = ((Scanner)((Object)hashMap)).useDelimiter((String)object);
        object = ((Scanner)object).next();
        hashMap = "\n";
        object = ((String)object).split((String)((Object)hashMap));
        if (object == null) return false;
        hashMap = new HashMap<String, String>();
        String string2 = "ro.debuggable";
        String string3 = "1";
        hashMap.put(string2, string3);
        string2 = "ro.secure";
        string3 = "0";
        hashMap.put(string2, string3);
        int n10 = ((Object)object).length;
        string3 = null;
        block26: for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            Object object2 = object[i10];
            Object object3 = hashMap.keySet();
            try {
                object3 = object3.iterator();
            }
            catch (Throwable throwable) {
                hashMap = MobLog.getInstance();
                ((NLog)((Object)hashMap)).w(throwable);
                return false;
            }
            while (true) {
                bl2 = object3.hasNext();
                if (!bl2) continue block26;
                break;
            }
            {
                Object object4 = object3.next();
                object4 = (String)object4;
                if (object2 == null) continue;
                boolean bl3 = ((String)object2).contains((CharSequence)object4);
                if (!bl3) continue;
                StringBuilder stringBuilder = new StringBuilder();
                String string4 = "[";
                stringBuilder.append(string4);
                object4 = hashMap.get(object4);
                stringBuilder.append(object4);
                object4 = "]";
                stringBuilder.append((String)object4);
                object4 = stringBuilder.toString();
                bl2 = ((String)object2).contains((CharSequence)object4);
                if (bl2) return true;
                continue;
            }
        }
        return false;
    }

    private boolean checkRootRw() {
        block25: {
            Object object;
            block24: {
                object = "mount";
                object = new String[]{object};
                object = this.invokeRuntimeExec((String[])object);
                if (object != null) break block24;
                return false;
            }
            Object object2 = new Scanner((InputStream)object);
            object = "\\A";
            object = ((Scanner)object2).useDelimiter((String)object);
            object = ((Scanner)object).next();
            object2 = "\n";
            object = ((String)object).split((String)object2);
            if (object == null) break block25;
            int n10 = 7;
            String[] stringArray = "/system";
            String string2 = "/system/bin";
            String string3 = "/system/sbin";
            Object object3 = "/system/xbin";
            String string4 = "/vendor/bin";
            String string5 = "/sbin";
            String string6 = "/etc";
            stringArray = new String[]{stringArray, string2, string3, object3, string4, string5, string6};
            int n11 = ((Object)object).length;
            string3 = null;
            for (int i10 = 0; i10 < n11; ++i10) {
                object3 = object[i10];
                string4 = " ";
                object3 = ((String)object3).split(string4);
                boolean bl2 = ((String[])object3).length;
                boolean bl3 = 4 != 0;
                if (bl2 < bl3) continue;
                bl2 = true;
                string5 = object3[bl2];
                int n12 = 3;
                try {
                    object3 = object3[n12];
                    string6 = null;
                }
                catch (Throwable throwable) {
                    object2 = MobLog.getInstance();
                    ((NLog)object2).w(throwable);
                    break;
                }
                for (n12 = 0; n12 < n10; ++n12) {
                    String[] stringArray2 = stringArray[n12];
                    if (string5 == null) continue;
                    boolean bl4 = string5.equalsIgnoreCase((String)stringArray2);
                    if (!bl4) continue;
                    stringArray2 = ",";
                    stringArray2 = ((String)object3).split((String)stringArray2);
                    int n13 = stringArray2.length;
                    for (int i11 = 0; i11 < n13; ++i11) {
                        String string7 = stringArray2[i11];
                        if (string7 == null) continue;
                        String string8 = "rw";
                        boolean bl5 = string7.equalsIgnoreCase(string8);
                        if (!bl5) continue;
                        return bl2;
                    }
                }
                continue;
            }
        }
        return false;
    }

    private boolean checkRootSu() {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        block18: {
            Object object;
            block17: {
                Object object2;
                InputStreamReader inputStreamReader;
                block16: {
                    Object object3;
                    block15: {
                        object = "su";
                        bl4 = true;
                        object3 = "which";
                        try {
                            object3 = new String[]{object3, object};
                        }
                        catch (Throwable throwable) {}
                        object3 = this.invokeRuntimeExec((String[])object3);
                        if (object3 == null) break block15;
                        inputStreamReader = new InputStreamReader((InputStream)object3);
                        object2 = new BufferedReader(inputStreamReader);
                        object3 = ((BufferedReader)object2).readLine();
                        if (object3 == null) break block15;
                        bl3 = bl4;
                        break block16;
                    }
                    bl3 = false;
                    object3 = null;
                }
                object2 = "/system/xbin/which";
                try {
                    object = new String[]{object2, object};
                }
                catch (Throwable throwable) {}
                object = this.invokeRuntimeExec((String[])object);
                if (object == null) break block17;
                inputStreamReader = new InputStreamReader((InputStream)object);
                object2 = new BufferedReader(inputStreamReader);
                object = ((BufferedReader)object2).readLine();
                if (object == null) break block17;
                bl2 = bl4;
                break block18;
            }
            bl2 = false;
            object = null;
        }
        if (!bl3 && !bl2) {
            bl4 = false;
        }
        return bl4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object currentActivityThread() {
        Object object;
        long l10;
        DeviceHelper$2 deviceHelper$2 = new DeviceHelper$2();
        Object object2 = Thread.currentThread();
        long l11 = ((Thread)object2).getId();
        long l12 = l11 - (l10 = ((Thread)(object = Looper.getMainLooper().getThread())).getId());
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 == false) {
            return deviceHelper$2.run((Object)null);
        }
        object2 = new Object();
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        synchronized (object2) {
            object = new DeviceHelper$3(object2, objectArray, deviceHelper$2);
            deviceHelper$2 = null;
            UIHandler.sendEmptyMessage(0, (Handler.Callback)object);
            try {
                object2.wait();
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.w(throwable);
            }
            return objectArray[0];
        }
    }

    private String genDeviceKey() {
        Object object = ":";
        Object object2 = this.getMacAddress();
        String string2 = this.getDeviceId();
        String string3 = this.getModel();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object2);
        stringBuilder.append((String)object);
        stringBuilder.append(string2);
        stringBuilder.append((String)object);
        stringBuilder.append(string3);
        object = stringBuilder.toString();
        object = Data.SHA1((String)object);
        try {
            object = Data.byteToHex((byte[])object);
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).d(throwable);
            object = null;
        }
        return object;
    }

    private HashMap getANS() {
        Object object = ".ans";
        Object object2 = this.context;
        object2 = ResHelper.getDataCacheFile((Context)object2, (String)object);
        object2 = ((File)object2).getAbsolutePath();
        object2 = ResHelper.readObjectFromFile((String)object2);
        try {
            object2 = (HashMap)object2;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.w(throwable);
            object2 = this.context;
            object = ResHelper.getDataCacheFile((Context)object2, (String)object);
            try {
                ((File)object).delete();
            }
            catch (Throwable throwable2) {
                object2 = MobLog.getInstance();
                ((NLog)object2).w(throwable2);
            }
            object2 = null;
        }
        return object2;
    }

    public static Context getApplication() {
        block6: {
            Object object = DeviceHelper.currentActivityThread();
            if (object == null) break block6;
            int n10 = 33;
            Object object2 = Strings.getString(n10);
            Object[] objectArray = null;
            objectArray = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
            try {
                return (Context)object;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).w(throwable);
            }
        }
        return null;
    }

    private String getCurrentNetworkHardwareAddress() {
        boolean bl2;
        Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
        if (enumeration == null) {
            return null;
        }
        enumeration = Collections.list(enumeration).iterator();
        while (bl2 = enumeration.hasNext()) {
            int n10;
            NetworkInterface networkInterface = (NetworkInterface)enumeration.next();
            Enumeration<InetAddress> enumeration2 = networkInterface.getInetAddresses();
            if (enumeration2 == null) continue;
            enumeration2 = Collections.list(enumeration2).iterator();
            while ((n10 = enumeration2.hasNext()) != 0) {
                Object object = (InetAddress)enumeration2.next();
                int n11 = ((InetAddress)object).isLoopbackAddress();
                if (n11 != 0 || (n10 = object instanceof Inet4Address) == 0) continue;
                n10 = Build.VERSION.SDK_INT;
                n11 = 9;
                if (n10 >= n11) {
                    object = networkInterface.getHardwareAddress();
                } else {
                    n10 = 0;
                    object = null;
                }
                if (object == null) continue;
                return this.byteToHex((byte[])object);
            }
        }
        return null;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String getDeviceKeyWithDuid(String object) {
        Object object2;
        Object object3;
        String string2;
        Object object4;
        block21: {
            block23: {
                object4 = ":";
                string2 = null;
                object3 = this.context;
                object = ResHelper.getCacheRootFile(object3, (String)object);
                if (object == null) return null;
                boolean bl2 = ((File)object).exists();
                if (!bl2) return null;
                bl2 = ((File)object).isFile();
                if (!bl2) return null;
                {
                    catch (Throwable throwable) {
                        object3 = MobLog.getInstance();
                        object3.w(throwable);
                        return null;
                    }
                }
                object3 = new FileInputStream((File)object);
                object = new ObjectInputStream((InputStream)object3);
                try {
                    object3 = ((ObjectInputStream)object).readObject();
                    object3 = (HashMap)object3;
                }
                catch (Throwable throwable) {}
                try {
                    ((ObjectInputStream)object).close();
                    break block21;
                }
                catch (Throwable throwable) {}
                break block23;
                catch (Throwable throwable) {
                    object = null;
                }
            }
            try {
                object2 = MobLog.getInstance();
                ((NLog)object2).w((Throwable)object3);
                if (object == null) return null;
            }
            catch (Throwable throwable) {
                if (object != null) {
                    try {
                        ((ObjectInputStream)object).close();
                    }
                    catch (Throwable throwable2) {}
                }
                throw throwable;
            }
            try {
                ((ObjectInputStream)object).close();
                return null;
            }
            catch (Throwable throwable) {}
            return null;
        }
        if (object3 == null) {
            return null;
        }
        object = (HashMap)object3.get("deviceInfo");
        if (object == null) {
            return null;
        }
        object3 = "mac";
        try {
            int n10;
            object3 = ((HashMap)object).get(object3);
            object3 = (String)object3;
            object2 = "imei";
            object2 = ((HashMap)object).get(object2);
            object2 = (String)object2;
            int n11 = TextUtils.isEmpty((CharSequence)object2);
            if (n11 != 0 && (n11 = Build.VERSION.SDK_INT) >= (n10 = 9)) {
                object2 = "serialno";
                object2 = ((HashMap)object).get(object2);
                object2 = (String)object2;
            }
            CharSequence charSequence = "model";
            object = ((HashMap)object).get(charSequence);
            object = (String)object;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object3);
            ((StringBuilder)charSequence).append((String)object4);
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append((String)object4);
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            object = Data.SHA1((String)object);
            return Data.byteToHex((byte[])object);
        }
        catch (Throwable throwable) {
            object4 = MobLog.getInstance();
            ((NLog)object4).d(throwable);
        }
        return string2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String getHardwareAddressFromShell(String object) {
        int n10;
        Object[] objectArray;
        Object object2;
        Object object3;
        int n11;
        block14: {
            block15: {
                n11 = 42;
                object3 = null;
                object2 = Strings.getString(n11);
                object2 = ReflectHelper.importClass((String)object2);
                int n12 = 43;
                objectArray = Strings.getString(n12);
                Object[] objectArray2 = new Object[]{};
                object2 = ReflectHelper.invokeStaticMethod((String)object2, (String)objectArray, objectArray2);
                objectArray = new StringBuilder();
                int n13 = 6;
                objectArray2 = Strings.getString(n13);
                objectArray.append((String)objectArray2);
                objectArray.append((String)object);
                n10 = 7;
                object = Strings.getString(n10);
                objectArray.append((String)object);
                object = objectArray.toString();
                n12 = 44;
                objectArray = Strings.getString(n12);
                n13 = 1;
                objectArray2 = new Object[n13];
                objectArray2[0] = object;
                object = ReflectHelper.invokeInstanceMethod(object2, (String)objectArray, objectArray2);
                n11 = 45;
                object2 = Strings.getString(n11);
                objectArray = new Object[]{};
                object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
                object = (InputStream)object;
                object2 = new InputStreamReader((InputStream)object);
                object = new BufferedReader((Reader)object2);
                try {
                    object2 = ((BufferedReader)object).readLine();
                }
                catch (Throwable throwable) {
                    break block14;
                }
                try {}
                catch (Throwable throwable) {
                }
                break block15;
                catch (Throwable throwable) {
                    n10 = 0;
                    object = null;
                }
                break block14;
            }
            ((BufferedReader)object).close();
        }
        objectArray = MobLog.getInstance();
        objectArray.d((Throwable)object2);
        n11 = 0;
        object2 = null;
        if ((n10 = TextUtils.isEmpty((CharSequence)object2)) == 0) return object2;
        return object3;
        finally {
            if (object != null) {
                ((BufferedReader)object).close();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static DeviceHelper getInstance(Context object) {
        Class<DeviceHelper> clazz = DeviceHelper.class;
        synchronized (clazz) {
            DeviceHelper deviceHelper = DeviceHelper.deviceHelper;
            if (deviceHelper != null) return DeviceHelper.deviceHelper;
            if (object == null) return DeviceHelper.deviceHelper;
            DeviceHelper.deviceHelper = deviceHelper = new DeviceHelper((Context)object);
            return DeviceHelper.deviceHelper;
        }
    }

    private String[] getInvalidMacList() {
        block18: {
            Object object = this.context;
            String[] stringArray = ".mcli";
            object = ResHelper.getDataCacheFile((Context)object, (String)stringArray);
            int n10 = 76;
            stringArray = Strings.getString(n10);
            object = ((File)object).getPath();
            object = ResHelper.readObjectFromFile((String)object);
            object = (byte[])object;
            object = Data.AES128Decode((String)stringArray, (byte[])object);
            n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
            if (n10 != 0) break block18;
            stringArray = new Hashon();
            object = stringArray.fromJson((String)object);
            stringArray = "list";
            object = ((HashMap)object).get(stringArray);
            object = (ArrayList)object;
            if (object == null) break block18;
            n10 = ((ArrayList)object).size();
            if (n10 <= 0) break block18;
            n10 = 0;
            stringArray = null;
            stringArray = new String[]{};
            object = ((ArrayList)object).toArray(stringArray);
            try {
                return (String[])object;
            }
            catch (Throwable throwable) {
                stringArray = MobLog.getInstance();
                stringArray.d(throwable);
            }
        }
        return null;
    }

    private static List getLauncherPackageNames(Context object) {
        boolean bl2;
        ArrayList<Intent> arrayList = new ArrayList<Intent>();
        object = object.getPackageManager();
        Object object2 = new Intent("android.intent.action.MAIN");
        object2.addCategory("android.intent.category.HOME");
        String string2 = "android.intent.category.DEFAULT";
        object2.addCategory(string2);
        int n10 = 65536;
        object = object.queryIntentActivities(object2, n10).iterator();
        while (bl2 = object.hasNext()) {
            object2 = ((ResolveInfo)object.next()).activityInfo.packageName;
            arrayList.add((Intent)object2);
        }
        return arrayList;
    }

    private String getLocalDeviceKey() {
        boolean bl2;
        boolean bl3;
        boolean bl4 = this.getSdcardState();
        String string2 = null;
        if (!bl4) {
            return null;
        }
        Object object = this.getSdcardPath();
        Object object2 = new File((String)object, "ShareSDK");
        bl4 = ((File)object2).exists();
        String string3 = ".dk";
        if (bl4 && (bl3 = ((File)(object = new File((File)object2, string3))).exists()) && (object2 = ResHelper.getCacheRootFile(this.context, string3)) != null && (bl3 = ((File)object).renameTo((File)object2))) {
            ((File)object).delete();
        }
        if ((object = ResHelper.getCacheRootFile(this.context, string3)) != null && !(bl3 = ((File)object).exists())) {
            return null;
        }
        object2 = new FileInputStream((File)object);
        object = new ObjectInputStream((InputStream)object2);
        if ((object2 = ((ObjectInputStream)object).readObject()) != null && (bl2 = object2 instanceof char[])) {
            object2 = (char[])object2;
            string2 = String.valueOf((char[])object2);
        }
        ((ObjectInputStream)object).close();
        return string2;
    }

    private String getLocalSerial() {
        block11: {
            String string2;
            Object object;
            try {
                object = this.context;
                string2 = ".slw";
            }
            catch (Throwable throwable) {
                MobLog.getInstance().d(throwable);
                return null;
            }
            object = ResHelper.getCacheRootFile((Context)object, string2);
            int n10 = 76;
            string2 = Strings.getString(n10);
            object = ((File)object).getPath();
            object = ResHelper.readObjectFromFile((String)object);
            object = (byte[])object;
            object = Data.AES128Decode(string2, (byte[])object);
            n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
            if (n10 != 0) break block11;
            return ((String)object).trim();
        }
        int n11 = 3;
        return this.getWAbcd(n11);
    }

    private String getLocalWifiMac() {
        block17: {
            boolean bl2;
            Object object;
            Object object2;
            block16: {
                int n10;
                block15: {
                    block14: {
                        object2 = this.context;
                        object = ".mcw";
                        object2 = ResHelper.getCacheRootFile((Context)object2, (String)object);
                        bl2 = ((File)object2).exists();
                        if (!bl2) break block14;
                        object = "1234567890abcdfg";
                        object2 = ((File)object2).getPath();
                        object2 = ResHelper.readObjectFromFile((String)object2);
                        object2 = (byte[])object2;
                        object2 = Data.AES128Decode((String)object, (byte[])object2);
                        break block15;
                    }
                    n10 = 0;
                    object2 = null;
                }
                bl2 = TextUtils.isEmpty((CharSequence)object2);
                if (!bl2) break block16;
                n10 = 2;
                object2 = this.getWAbcd(n10);
            }
            bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (bl2) break block17;
            object = ((String)object2).trim();
            String string2 = "^[a-fA-F0-9]{2}(:[a-fA-F0-9]{2}){5}$";
            bl2 = ((String)object).matches(string2);
            if (!bl2) break block17;
            try {
                return ((String)object2).trim();
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).d(throwable);
            }
        }
        return null;
    }

    private HashMap getMapFromOtherPlace(String object) {
        block21: {
            block22: {
                int n10 = 76;
                Object object2 = Strings.getString(n10);
                object = ResHelper.readObjectFromFile((String)object);
                object = (byte[])object;
                object = Data.AES128Decode((String)object2, (byte[])object);
                n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                if (n10 != 0) break block21;
                object2 = new Hashon();
                object = ((Hashon)object2).fromJson((String)object);
                n10 = 78;
                object2 = Strings.getString(n10);
                object2 = ((HashMap)object).remove(object2);
                object2 = (String)object2;
                String string2 = this.getSortWabcd((HashMap)object);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                int n11 = 77;
                string2 = Strings.getString(n11);
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                string2 = Data.MD5(string2);
                if (object2 == null) break block22;
                try {
                    n10 = (int)(((String)object2).equals(string2) ? 1 : 0);
                    if (n10 == 0) break block21;
                }
                catch (Throwable throwable) {
                    object2 = MobLog.getInstance();
                    ((NLog)object2).d(throwable);
                }
            }
            return object;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ArrayList getPL() {
        Object object;
        int n10;
        Iterator iterator2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n11 = 42;
        boolean bl2 = false;
        Object object2 = null;
        try {
            iterator2 = Strings.getString(n11);
            iterator2 = ReflectHelper.importClass((String)((Object)iterator2));
            n10 = 43;
            object = Strings.getString(n10);
            Object object3 = new Object[]{};
            iterator2 = ReflectHelper.invokeStaticMethod((String)((Object)iterator2), (String)object, (Object[])object3);
            n10 = 44;
            object = Strings.getString(n10);
            int n12 = 1;
            object3 = new Object[n12];
            int n13 = 20;
            String string2 = Strings.getString(n13);
            object3[0] = string2;
            iterator2 = ReflectHelper.invokeInstanceMethod((Object)iterator2, (String)object, (Object[])object3);
            n10 = 45;
            object = Strings.getString(n10);
            object3 = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(iterator2, (String)object, (Object[])object3);
            object = (InputStream)object;
            string2 = "utf-8";
            object3 = new InputStreamReader((InputStream)object, string2);
            object = new BufferedReader((Reader)object3);
            object3 = ((BufferedReader)object).readLine();
            while (object3 != null) {
                String string3;
                int n14;
                n13 = ((String)(object3 = ((String)object3).trim())).length();
                if (n13 > (n14 = 8) && (n13 = (int)((string2 = ((String)object3).substring(0, n14)).equalsIgnoreCase(string3 = "package:") ? 1 : 0)) != 0) {
                    object3 = ((String)object3).substring(n14);
                    n13 = (int)(TextUtils.isEmpty((CharSequence)(object3 = ((String)object3).trim())) ? 1 : 0);
                    if (n13 == 0) {
                        arrayList.add(object3);
                    }
                }
                object3 = ((BufferedReader)object).readLine();
            }
            ((BufferedReader)object).close();
            n10 = 51;
            object = Strings.getString(n10);
            object3 = new Object[]{};
            ReflectHelper.invokeInstanceMethod(iterator2, (String)object, (Object[])object3);
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).w(throwable);
        }
        n11 = (int)(arrayList.isEmpty() ? 1 : 0);
        if (n11 == 0) return arrayList;
        try {
            object = "android.intent.action.MAIN";
            iterator2 = new Iterator((String)object);
            n10 = 74;
            object = Strings.getString(n10);
            iterator2.addCategory((String)object);
            object = this.context;
            object = object.getPackageManager();
            iterator2 = object.queryIntentActivities((Intent)iterator2, 0);
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                object2 = iterator2.next();
                if ((object2 = (ResolveInfo)object2) == null || (object = ((ResolveInfo)object2).activityInfo) == null || (n10 = (int)(TextUtils.isEmpty((CharSequence)(object = ((ActivityInfo)object).packageName)) ? 1 : 0)) != 0) continue;
                object2 = ((ResolveInfo)object2).activityInfo;
                object2 = ((ActivityInfo)object2).packageName;
                arrayList.add(object2);
            }
            return arrayList;
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).w(throwable);
        }
        return arrayList;
    }

    private String getSortWabcd(HashMap object) {
        if (object == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = (String)((HashMap)object).get("0");
        if (string2 != null) {
            stringBuilder.append(string2);
        }
        if ((string2 = (String)((HashMap)object).get("1")) != null) {
            stringBuilder.append(string2);
        }
        if ((string2 = (String)((HashMap)object).get("2")) != null) {
            stringBuilder.append(string2);
        }
        if ((object = (String)((HashMap)object).get(string2 = "3")) != null) {
            stringBuilder.append((String)object);
        }
        return stringBuilder.toString();
    }

    private String getSystemProperties(String object) {
        block8: {
            int n10 = 9;
            Object object2 = Strings.getString(n10);
            object2 = ReflectHelper.importClass((String)object2);
            int n11 = 10;
            String string2 = Strings.getString(n11);
            int n12 = 1;
            Object[] objectArray = new Object[n12];
            objectArray[0] = object;
            object = ReflectHelper.invokeStaticMethod((String)object2, string2, objectArray);
            if (object == null) break block8;
            try {
                return String.valueOf(object);
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).w(throwable);
            }
        }
        return "";
    }

    public static String getTopApp(Context object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            String string2 = "usagestats";
            object = object.getSystemService(string2);
            Object object2 = object;
            object2 = (UsageStatsManager)object;
            if (object2 != null) {
                int n12 = 4;
                long l10 = System.currentTimeMillis();
                long l11 = l10 - 3600000L;
                object = object2.queryUsageStats(n12, l11, l10);
                if (object != null && (n10 = (int)(object.isEmpty() ? 1 : 0)) == 0) {
                    n10 = 0;
                    string2 = null;
                    for (int i10 = 0; i10 < (n11 = object.size()); ++i10) {
                        UsageStats usageStats;
                        object2 = (UsageStats)object.get(i10);
                        long l12 = object2.getLastTimeUsed();
                        long l13 = l12 - (l11 = (usageStats = (UsageStats)object.get(n10)).getLastTimeUsed());
                        n11 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                        if (n11 <= 0) continue;
                        n10 = i10;
                    }
                    object = ((UsageStats)object.get(n10)).getPackageName();
                } else {
                    object = "";
                }
                return object;
            }
            return null;
        }
        return ((ActivityManager.RunningTaskInfo)((ActivityManager)object.getSystemService((String)"activity")).getRunningTasks((int)1).get((int)0)).topActivity.getPackageName();
    }

    private void getTrafficBytes(String object, String object2, long[] lArray) {
        block16: {
            int n10 = ((String)object).indexOf((String)object2);
            int n11 = -1;
            if (n10 == n11) break block16;
            Object object3 = " \\d+ ";
            object3 = Pattern.compile((String)object3);
            object = ((String)object).substring(n10);
            try {
                object = ((Pattern)object3).matcher((CharSequence)object);
                n10 = 0;
                object2 = null;
                n11 = 0;
                object3 = null;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
            while (true) {
                block18: {
                    int n12;
                    block17: {
                        n12 = ((Matcher)object).find();
                        if (n12 == 0) break block16;
                        if (n11 != 0) break block17;
                        String string2 = ((Matcher)object).group();
                        string2 = string2.trim();
                        long l10 = Long.parseLong(string2);
                        lArray[0] = l10;
                        break block18;
                    }
                    n12 = 8;
                    if (n11 == n12) {
                        object = ((Matcher)object).group();
                        object = ((String)object).trim();
                        long l11 = Long.parseLong((String)object);
                        n11 = 1;
                        lArray[n11] = l11;
                    }
                }
                ++n11;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String getValidNetworkHardwareAddress() {
        boolean bl2;
        int n10;
        Object object = this.listNetworkHardware();
        if (object == null) return null;
        boolean bl3 = ((HashMap)object).isEmpty();
        if (bl3) {
            return null;
        }
        Object object2 = ((HashMap)object).keySet();
        Object object3 = new ArrayList(object2);
        object2 = new ArrayList();
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        ArrayList<String> arrayList3 = new ArrayList<String>();
        ArrayList<String> arrayList4 = new ArrayList<String>();
        ArrayList<String> arrayList5 = new ArrayList<String>();
        ArrayList<String> arrayList6 = new ArrayList<String>();
        boolean bl4 = false;
        String string2 = null;
        while ((n10 = ((ArrayList)object3).size()) > 0) {
            String string3;
            n10 = 0;
            String string4 = ((String)((ArrayList)object3).remove(0)).trim();
            boolean bl5 = string4.equals(string3 = "wlan0");
            if (bl5) {
                string2 = string3;
                continue;
            }
            string3 = "wlan";
            boolean bl6 = string4.startsWith(string3);
            if (bl6) {
                ((ArrayList)object2).add((String)string4);
                continue;
            }
            string3 = "eth";
            bl6 = string4.startsWith(string3);
            if (bl6) {
                arrayList.add(string4);
                continue;
            }
            string3 = "rev_rmnet";
            bl6 = string4.startsWith(string3);
            if (bl6) {
                arrayList2.add(string4);
                continue;
            }
            string3 = "dummy";
            bl6 = string4.startsWith(string3);
            if (bl6) {
                arrayList3.add(string4);
                continue;
            }
            string3 = "usbnet";
            bl6 = string4.startsWith(string3);
            if (bl6) {
                arrayList4.add(string4);
                continue;
            }
            string3 = "rmnet_usb";
            bl6 = string4.startsWith(string3);
            if (bl6) {
                arrayList5.add(string4);
                continue;
            }
            arrayList6.add(string4);
        }
        Collections.sort(object2);
        Collections.sort(arrayList);
        Collections.sort(arrayList2);
        Collections.sort(arrayList3);
        Collections.sort(arrayList4);
        Collections.sort(arrayList5);
        Collections.sort(arrayList6);
        n10 = (int)(TextUtils.isEmpty(string2) ? 1 : 0);
        if (n10 == 0) {
            ((ArrayList)object3).add(string2);
        }
        ((ArrayList)object3).addAll(object2);
        object2 = this.getNetworkType();
        string2 = "wifi";
        int n11 = string2.equals(object2);
        if (n11 != 0) {
            try {
                object2 = this.getCurrentNetworkHardwareAddress();
                bl4 = TextUtils.isEmpty((CharSequence)object2);
                if (!bl4) {
                    ((ArrayList)object3).add(object2);
                }
            }
            catch (Throwable throwable) {}
        }
        if ((n11 = ((ArrayList)object3).size()) > 0) {
            object2 = ((ArrayList)object3).iterator();
            while (bl4 = object2.hasNext()) {
                string2 = (String)object2.next();
                if ((string2 = (String)((HashMap)object).get(string2)) == null || (n10 = (int)(this.checkMacIsValid(string2) ? 1 : 0)) == 0) continue;
                this.wifimac = object = string2.trim();
                this.saveLocalWifiMac((String)object);
                return this.wifimac;
            }
        }
        ((ArrayList)object3).addAll(arrayList);
        ((ArrayList)object3).addAll(arrayList2);
        ((ArrayList)object3).addAll(arrayList3);
        ((ArrayList)object3).addAll(arrayList4);
        ((ArrayList)object3).addAll(arrayList5);
        ((ArrayList)object3).addAll(arrayList6);
        object3 = ((ArrayList)object3).iterator();
        do {
            if ((n11 = (int)(object3.hasNext() ? 1 : 0)) == 0) return null;
            object2 = (String)object3.next();
        } while ((object2 = (String)((HashMap)object).get(object2)) == null || !(bl2 = this.checkMacIsValid((String)object2)));
        return ((String)object2).trim();
    }

    private String getWifiMac() {
        block11: {
            String string2;
            block12: {
                string2 = null;
                Object object = "wifi";
                object = this.getSystemServiceSafe((String)object);
                if (object == null) {
                    return null;
                }
                int n10 = 2;
                Object object2 = Strings.getString(n10);
                Object[] objectArray = null;
                Object[] objectArray2 = new Object[]{};
                object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray2);
                if (object == null) break block11;
                n10 = 5;
                object2 = Strings.getString(n10);
                objectArray = new Object[]{};
                object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
                object = (String)object;
                if (object == null) break block12;
                try {
                    string2 = ((String)object).trim();
                }
                catch (Throwable throwable) {
                    object2 = MobLog.getInstance();
                    ((NLog)object2).w(throwable);
                }
            }
            return string2;
        }
        return null;
    }

    private int getWifiSecurity(String string2) {
        if (string2 != null) {
            String string3 = "WEP";
            boolean bl2 = string2.contains(string3);
            if (bl2) {
                return 1;
            }
            string3 = "PSK";
            bl2 = string2.contains(string3);
            if (bl2) {
                return 2;
            }
            string3 = "EAP";
            boolean bl3 = string2.contains(string3);
            if (bl3) {
                return 3;
            }
        }
        return 0;
    }

    private String getWlanMac() {
        block8: {
            String string2 = "wlan0";
            string2 = this.getHardwareAddressFromShell(string2);
            if (string2 == null) break block8;
            boolean bl2 = this.checkMacIsValid(string2);
            if (!bl2) break block8;
            string2 = string2.trim();
            this.wifimac = string2;
            try {
                this.saveLocalWifiMac(string2);
                return this.wifimac;
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.d(throwable);
            }
        }
        try {
            return this.getValidNetworkHardwareAddress();
        }
        catch (Throwable throwable) {
            MobLog.getInstance().d(throwable);
            return null;
        }
    }

    private InputStream invokeRuntimeExec(String[] object) {
        Object object2;
        int n10 = 42;
        try {
            object2 = Strings.getString(n10);
        }
        catch (Throwable throwable) {
            return null;
        }
        object2 = ReflectHelper.importClass((String)object2);
        int n11 = 43;
        Object[] objectArray = Strings.getString(n11);
        Object[] objectArray2 = new Object[]{};
        object2 = ReflectHelper.invokeStaticMethod((String)object2, (String)objectArray, objectArray2);
        n11 = 44;
        objectArray = Strings.getString(n11);
        int n12 = 1;
        objectArray2 = new Object[n12];
        objectArray2[0] = object;
        object = ReflectHelper.invokeInstanceMethod(object2, (String)objectArray, objectArray2);
        n10 = 45;
        object2 = Strings.getString(n10);
        objectArray = new Object[]{};
        object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
        return (InputStream)object;
    }

    private static boolean isBackground(Context object) {
        block16: {
            boolean bl2 = false;
            Object object2 = object.getApplicationContext();
            String string2 = "activity";
            object2 = object2.getSystemService(string2);
            object2 = (ActivityManager)object2;
            object2 = object2.getRunningAppProcesses();
            if (object2 == null) break block16;
            boolean bl3 = object2.isEmpty();
            if (bl3) break block16;
            object = object.getPackageName();
            object2 = object2.iterator();
            while (true) {
                boolean bl4;
                bl3 = object2.hasNext();
                if (!bl3) break block16;
                string2 = object2.next();
                string2 = (ActivityManager.RunningAppProcessInfo)string2;
                String string3 = ((ActivityManager.RunningAppProcessInfo)string2).processName;
                if (!(bl4 = string3.equals(object))) continue;
                break;
            }
            try {
                int n10 = ((ActivityManager.RunningAppProcessInfo)string2).importance;
                int n11 = 400;
                if (n10 == n11) {
                    bl2 = true;
                }
                return bl2;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).w(throwable);
            }
        }
        return false;
    }

    private boolean isSystemApp(PackageInfo packageInfo) {
        packageInfo = packageInfo.applicationInfo;
        int n10 = packageInfo.flags;
        int n11 = n10 & 1;
        int n12 = 0;
        int n13 = 1;
        n11 = n11 == n13 ? n13 : 0;
        if ((n10 &= 0x80) == n13) {
            n10 = n13;
        } else {
            n10 = 0;
            packageInfo = null;
        }
        if (n11 || n10 != 0) {
            n12 = n13;
        }
        return n12;
    }

    private void saveANS(HashMap hashMap) {
        if (hashMap != null) {
            Object object = this.context;
            String string2 = ".ans";
            object = ResHelper.getDataCacheFile((Context)object, string2);
            object = ((File)object).getAbsolutePath();
            try {
                ResHelper.saveObjectToFile((String)object, hashMap);
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).w(throwable);
            }
        }
    }

    private void saveLocalDeviceKey(String object) {
        boolean bl2;
        boolean bl3 = this.getSdcardState();
        if (!bl3) {
            return;
        }
        Object object2 = this.context;
        Object object3 = ".dk";
        if ((object2 = ResHelper.getCacheRootFile((Context)object2, (String)object3)) != null && (bl2 = ((File)object2).exists())) {
            ((File)object2).delete();
        }
        object3 = new FileOutputStream((File)object2);
        object2 = new ObjectOutputStream((OutputStream)object3);
        object = ((String)object).toCharArray();
        ((ObjectOutputStream)object2).writeObject(object);
        ((ObjectOutputStream)object2).flush();
        ((ObjectOutputStream)object2).close();
    }

    private void saveLocalSerial(String string2) {
        block12: {
            boolean n10 = TextUtils.isEmpty((CharSequence)string2);
            if (n10) break block12;
            Object object = string2.trim();
            Object object2 = "";
            boolean bl2 = ((String)object).equals(object2);
            if (bl2) break block12;
            object = this.context;
            object2 = ".slw";
            object = ResHelper.getCacheRootFile((Context)object, (String)object2);
            int n11 = 76;
            object2 = Strings.getString(n11);
            String string3 = string2.trim();
            object2 = Data.AES128Encode((String)object2, string3);
            object = ((File)object).getPath();
            ResHelper.saveObjectToFile((String)object, object2);
            string2 = string2.trim();
            int n12 = 3;
            try {
                this.saveWabcd(string2, n12);
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).d(throwable);
            }
        }
    }

    private void saveLocalWifiMac(String string2) {
        block11: {
            boolean n10 = TextUtils.isEmpty((CharSequence)string2);
            if (n10) break block11;
            Object object = string2.trim();
            Object object2 = "^[a-fA-F0-9]{2}(:[a-fA-F0-9]{2}){5}$";
            boolean bl2 = ((String)object).matches((String)object2);
            if (!bl2) break block11;
            object = this.context;
            object2 = ".mcw";
            object = ResHelper.getCacheRootFile((Context)object, (String)object2);
            object2 = "1234567890abcdfg";
            String string3 = string2.trim();
            object2 = Data.AES128Encode((String)object2, string3);
            object = ((File)object).getPath();
            ResHelper.saveObjectToFile((String)object, object2);
            string2 = string2.trim();
            int n11 = 2;
            try {
                this.saveWabcd(string2, n11);
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).d(throwable);
            }
        }
    }

    public String Base64AES(String object, String object2) {
        String string2;
        block5: {
            String string3 = "\n";
            string2 = null;
            object = Data.AES128Encode((String)object2, (String)object);
            object2 = null;
            string2 = Base64.encodeToString((byte[])object, (int)0);
            boolean bl2 = string2.contains(string3);
            if (!bl2) break block5;
            object = "";
            try {
                string2 = string2.replace(string3, (CharSequence)object);
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).w(throwable);
            }
        }
        return string2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean amIOnForeground() {
        boolean bl2;
        int n10;
        try {
            int n11 = Build.VERSION.SDK_INT;
            n10 = 27;
            bl2 = true;
            if (n11 > n10) {
                Context context = this.context;
                return DeviceHelper.isBackground(context) ^ bl2;
            }
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.w(throwable);
            return false;
        }
        {
            Object object = DeviceHelper.currentActivityThread();
            n10 = 23;
            Object object2 = Strings.getString(n10);
            object = ReflectHelper.getInstanceField(object, (String)object2);
            object = (Map)object;
            object = object.values();
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = object.next();
                int n12 = 24;
                String string2 = Strings.getString(n12);
                object2 = ReflectHelper.getInstanceField(object2, string2);
                n10 = (int)(((Boolean)(object2 = (Boolean)object2)).booleanValue() ? 1 : 0);
                if (n10 != 0) continue;
                return bl2;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int bs(Context context, Intent intent) {
        long l10;
        long l11;
        int n10;
        long l12;
        boolean bl2;
        int n11 = 1;
        boolean[] blArray = new boolean[n11];
        blArray[0] = false;
        try {
            DeviceHelper$4 deviceHelper$4 = new DeviceHelper$4(this, blArray, context);
            bl2 = context.bindService(intent, (ServiceConnection)deviceHelper$4, n11);
            if (!bl2) return 0;
            l12 = 200L;
        }
        catch (SecurityException securityException) {
            MobLog.getInstance().d(securityException);
            return 3;
        }
        while ((n10 = blArray[0]) == 0 && (n10 = (l11 = l12 - (l10 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0) {
            synchronized (blArray) {
                l10 = 20;
                l12 -= l10;
                blArray.wait(l10);
            }
        }
        bl2 = blArray[0];
        if (!bl2) return 2;
        return n11;
    }

    public int ca(Context context, String string2) {
        block4: {
            PackageManager packageManager;
            try {
                packageManager = context.getPackageManager();
            }
            catch (Throwable throwable) {
                MobLog.getInstance().d(throwable);
                return 3;
            }
            string2 = packageManager.getLaunchIntentForPackage(string2);
            if (string2 == null) break block4;
            return this.cs(context, (Intent)string2);
        }
        return 0;
    }

    public int cb(Context object, String string2) {
        block10: {
            String string3;
            block9: {
                try {
                    int n10 = Build.VERSION.SDK_INT;
                    int n11 = 11;
                    string3 = "clipboard";
                    if (n10 < n11) break block9;
                }
                catch (Throwable throwable) {
                    MobLog.getInstance().d(throwable);
                    return 2;
                }
                object = object.getSystemService(string3);
                object = (ClipboardManager)object;
                String string4 = "";
                string2 = ClipData.newPlainText((CharSequence)string4, (CharSequence)string2);
                object.setPrimaryClip((ClipData)string2);
                break block10;
            }
            object = object.getSystemService(string3);
            object = (ClipboardManager)object;
            object.setText((CharSequence)string2);
        }
        return 1;
    }

    public boolean checkADBModel(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 273;
            if (n10 != n12) {
                n12 = 16;
                if (n10 != n12) {
                    n12 = 17;
                    if (n10 != n12) {
                        return false;
                    }
                    n10 = (int)(this.usbEnable() ? 1 : 0);
                    if (n10 == 0 && (n10 = (int)(this.devEnable() ? 1 : 0)) == 0) {
                        n11 = 0;
                    }
                    return n11;
                }
                return this.devEnable();
            }
            n10 = (int)(this.usbEnable() ? 1 : 0);
            if (n10 == 0 || (n10 = (int)(this.devEnable() ? 1 : 0)) == 0) {
                n11 = 0;
            }
            return n11;
        }
        return this.usbEnable();
    }

    public boolean checkPad() {
        Configuration configuration = this.context.getResources().getConfiguration();
        int n10 = configuration.screenLayout & 0xF;
        int n11 = 3;
        if (n10 >= n11) {
            n10 = 1;
        } else {
            n10 = 0;
            configuration = null;
        }
        return n10 != 0;
    }

    public boolean checkPermission(String object) {
        int n10;
        int n11;
        block11: {
            int n12 = Build.VERSION.SDK_INT;
            n11 = -1;
            n10 = 1;
            int n13 = 23;
            if (n12 >= n13) {
                Object object2 = "android.content.Context";
                ReflectHelper.importClass((String)object2);
                object2 = this.context;
                n13 = 22;
                String string2 = Strings.getString(n13);
                Object[] objectArray = new Object[n10];
                objectArray[0] = object;
                object = ReflectHelper.invokeInstanceMethod(object2, string2, objectArray);
                object = (Integer)object;
                if (object == null) break block11;
                try {
                    int n14;
                    n11 = n14 = ((Integer)object).intValue();
                }
                catch (Throwable throwable) {
                    object2 = MobLog.getInstance();
                    ((NLog)object2).d(throwable);
                }
            } else {
                PackageManager packageManager = this.context.getPackageManager();
                String string3 = this.getPackageName();
                n11 = packageManager.checkPermission((String)object, string3);
            }
        }
        if (n11 != 0) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean checkUA() {
        int n10;
        String string2;
        Intent intent;
        boolean bl2 = false;
        String string3 = "android.intent.action.BATTERY_CHANGED";
        try {
            intent = new IntentFilter(string3);
            string3 = this.context;
            string2 = "registerReceiver";
            n10 = 2;
        }
        catch (Throwable throwable) {
            MobLog.getInstance().d(throwable);
            return false;
        }
        Object[] objectArray = new Object[n10];
        boolean bl3 = false;
        objectArray[0] = null;
        bl3 = true;
        objectArray[bl3] = intent;
        intent = new Class[n10];
        Class<BroadcastReceiver> clazz = BroadcastReceiver.class;
        intent[0] = clazz;
        clazz = IntentFilter.class;
        intent[bl3] = clazz;
        intent = ReflectHelper.invokeInstanceMethod((Object)string3, string2, objectArray, (Class[])intent);
        intent = intent;
        string3 = "plugged";
        int n11 = -1;
        int n12 = intent.getIntExtra(string3, n11);
        if (n12 == n10) {
            bl2 = bl3;
        }
        return bl2;
    }

    public int cs(Context object, Intent object2) {
        block24: {
            int n10;
            int n11;
            float f10;
            int n12;
            block25: {
                block23: {
                    block22: {
                        int n13 = Build.VERSION.SDK_INT;
                        n12 = 26;
                        f10 = 3.6E-44f;
                        if (n13 >= n12) break block24;
                        object2 = object2.getComponent();
                        String string2 = object2.getPackageName();
                        object2 = object2.getClassName();
                        String string3 = "activity";
                        object = object.getSystemService(string3);
                        object = (ActivityManager)object;
                        n12 = 1000;
                        f10 = 1.401E-42f;
                        object = object.getRunningServices(n12);
                        n12 = 1;
                        f10 = Float.MIN_VALUE;
                        if (object == null) break block22;
                        boolean n112 = object.isEmpty();
                        if (n112) break block22;
                        try {
                            object = object.iterator();
                            boolean bl2 = false;
                        }
                        catch (Throwable throwable) {
                            MobLog.getInstance().d(throwable);
                            return 3;
                        }
                        while (true) {
                            boolean bl3 = object.hasNext();
                            if (!bl3) break;
                            Object object3 = object.next();
                            object3 = (ActivityManager.RunningServiceInfo)object3;
                            Object object4 = ((ActivityManager.RunningServiceInfo)object3).service;
                            object4 = object4.getPackageName();
                            object3 = ((ActivityManager.RunningServiceInfo)object3).service;
                            object3 = object3.getClassName();
                            boolean bl4 = ((String)object4).equals(string2);
                            if (!bl4) continue;
                            int n14 = ((String)object3).equals(object2);
                            if (n14 != 0) {
                                n11 = n12;
                                break block23;
                            }
                            n14 = n12;
                            continue;
                            break;
                        }
                        n11 = 0;
                        object = null;
                        break block25;
                    }
                    n11 = 0;
                    object = null;
                }
                n10 = n11;
            }
            if (n10 != 0) {
                if (n11 == 0) {
                    n12 = 2;
                    f10 = 2.8E-45f;
                }
                return n12;
            }
            return 0;
        }
        return 4;
    }

    public int cscreen() {
        Context context = this.context;
        String string2 = "power";
        boolean bl2 = (context = (PowerManager)context.getSystemService(string2)).isScreenOn();
        if (bl2) {
            context = this.context;
            string2 = "keyguard";
            bl2 = (context = (KeyguardManager)context.getSystemService(string2)).inKeyguardRestrictedInputMode();
            if (bl2) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean cx() {
        Object object;
        Object object2;
        Object var1_1 = null;
        boolean bl2 = true;
        try {
            object2 = this.context;
            object2 = object2.getPackageManager();
            object = "de.robv.android.xposed.installer";
            object2 = object2.getPackageInfo((String)object, 0);
            if (object2 != null) {
                return bl2;
            }
        }
        catch (Throwable throwable) {}
        try {
            object = "test";
            object2 = new Exception((String)object);
            throw object2;
        }
        catch (Throwable throwable) {
            int n10;
            String string2;
            object2 = throwable.getStackTrace();
            int n11 = ((StackTraceElement[])object2).length;
            int n12 = 0;
            Object var7_9 = null;
            while (true) {
                string2 = "de.robv.android.xposed.XposedBridge";
                if (n12 >= n11) break;
                String string3 = object2[n12].getClassName();
                n10 = string3.contains(string2);
                if (n10 != 0) {
                    return bl2;
                }
                ++n12;
            }
            try {
                object2 = ClassLoader.getSystemClassLoader();
                object = "de.robv.android.xposed.XposedHelpers";
                object2 = ((ClassLoader)object2).loadClass((String)object);
                ((Class)object2).newInstance();
                object2 = ClassLoader.getSystemClassLoader();
                object2 = ((ClassLoader)object2).loadClass(string2);
                ((Class)object2).newInstance();
                return bl2;
            }
            catch (Throwable throwable2) {
                Object object3;
                block30: {
                    block29: {
                        object2 = MobLog.getInstance();
                        ((NLog)object2).d(throwable2);
                        bl2 = false;
                        object3 = null;
                        try {
                            StringBuilder stringBuilder = new StringBuilder();
                            string2 = "/proc/";
                            stringBuilder.append(string2);
                            n10 = Process.myPid();
                            stringBuilder.append(n10);
                            string2 = "/maps";
                            stringBuilder.append(string2);
                            String string4 = stringBuilder.toString();
                            object = new FileReader(string4);
                            object2 = new BufferedReader((Reader)object);
                            bl2 = false;
                            object3 = null;
                            break block29;
                        }
                        catch (Throwable throwable3) {
                            object2 = null;
                            object3 = throwable3;
                            break block30;
                        }
                        catch (IllegalAccessException | InstantiationException reflectiveOperationException) {
                            return bl2;
                        }
                        catch (IllegalAccessException | InstantiationException reflectiveOperationException) {
                            return bl2;
                        }
                    }
                    try {
                        while ((object = ((BufferedReader)object2).readLine()) != null && !bl2) {
                            object3 = ((String)object).toLowerCase();
                            object = "xposed";
                            bl2 = ((String)object3).contains((CharSequence)object);
                        }
                    }
                    catch (Throwable throwable4) {}
                    try {
                        ((BufferedReader)object2).close();
                        return bl2;
                    }
                    catch (IOException iOException) {
                        object2 = MobLog.getInstance();
                        ((NLog)object2).d(iOException);
                    }
                    return bl2;
                }
                try {
                    object = MobLog.getInstance();
                    ((NLog)object).d((Throwable)object3);
                    return false;
                }
                finally {
                    if (object2 != null) {
                        try {
                            ((BufferedReader)object2).close();
                        }
                        catch (IOException iOException) {
                            object2 = MobLog.getInstance();
                            ((NLog)object2).d(iOException);
                        }
                    }
                }
            }
        }
    }

    public boolean debugable() {
        Context context;
        boolean bl2 = false;
        try {
            context = this.context;
        }
        catch (Throwable throwable) {
            MobLog.getInstance().d(throwable);
            return false;
        }
        context = context.getPackageManager();
        Object object = this.context;
        object = object.getPackageName();
        boolean bl3 = true;
        context = context.getPackageInfo((String)object, (int)(bl3 ? 1 : 0));
        context = context.applicationInfo;
        int n10 = context.flags & 2;
        if (n10 != 0) {
            bl2 = bl3;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean devEnable() {
        boolean bl3 = false;
        try {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 17;
            boolean bl2 = true;
            String string2 = "development_settings_enabled";
            if (n10 >= n11) {
                Context context = this.context;
                n10 = Settings.Secure.getInt((ContentResolver)(context = context.getContentResolver()), (String)string2, (int)0);
                if (n10 <= 0) return bl3;
                return bl2;
            } else {
                Context context = this.context;
                n10 = Settings.Secure.getInt((ContentResolver)(context = context.getContentResolver()), (String)string2, (int)0);
                if (n10 <= 0) return bl3;
            }
            return bl2;
        }
        catch (Throwable throwable) {}
        return bl3;
    }

    public String gb(Context object) {
        String string2;
        block13: {
            block14: {
                int n10;
                try {
                    n10 = Build.VERSION.SDK_INT;
                    int n11 = 11;
                    string2 = "clipboard";
                    if (n10 < n11) break block13;
                }
                catch (Throwable throwable) {
                    MobLog.getInstance().d(throwable);
                    return null;
                }
                object = object.getSystemService(string2);
                object = (ClipboardManager)object;
                object = object.getPrimaryClip();
                if (object == null) break block14;
                n10 = object.getItemCount();
                if (n10 <= 0) break block14;
                n10 = 0;
                object = object.getItemAt(0);
                object = object.getText();
                return object.toString();
            }
            return null;
        }
        object = object.getSystemService(string2);
        object = (ClipboardManager)object;
        object = object.getText();
        return (String)object;
    }

    public ArrayList getAA() {
        return this.getAL(false, true);
    }

    public ArrayList getAL(boolean bl2, boolean bl3) {
        synchronized (this) {
            boolean bl4 = true;
            ArrayList arrayList = this.getAL(bl2, bl3, bl4);
            return arrayList;
        }
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public ArrayList getAL(boolean bl2, boolean bl3, boolean bl4) {
        synchronized (this) {
            boolean bl5;
            HashMap<Object, Object> hashMap;
            Context context;
            ArrayList<HashMap<String, String>> arrayList;
            Object object;
            block71: {
                block70: {
                    object = this.getPL();
                    arrayList = new ArrayList<HashMap<String, String>>();
                    context = this.context;
                    context = context.getPackageManager();
                    if (!bl4) break block70;
                    hashMap = this.getANS();
                    break block71;
                }
                hashMap = null;
            }
            object = ((ArrayList)object).iterator();
            boolean bl6 = false;
            Object object2 = null;
            while (true) {
                bl5 = object.hasNext();
                if (!bl5) return arrayList;
                break;
            }
            {
                catch (Throwable throwable) {
                    NLog nLog = MobLog.getInstance();
                    nLog.w(throwable);
                    return new ArrayList();
                }
            }
            {
                HashMap<String, String> hashMap2;
                Object object3 = object.next();
                object3 = (String)object3;
                try {
                    object3 = context.getPackageInfo(object3, 0);
                }
                catch (Throwable throwable) {
                    hashMap2 = MobLog.getInstance();
                    ((NLog)((Object)hashMap2)).w(throwable);
                    bl5 = false;
                    object3 = null;
                }
                if (object3 != null) {
                    int n10;
                    String string2;
                    Object object4;
                    block72: {
                        block75: {
                            block74: {
                                block73: {
                                    boolean bl7;
                                    if (bl2) {
                                        bl7 = this.isSystemApp((PackageInfo)object3);
                                        if (!bl7) {
                                            continue;
                                        }
                                    } else if (!bl3) {
                                        bl7 = this.isSystemApp((PackageInfo)object3);
                                        if (bl7) continue;
                                    }
                                    hashMap2 = new HashMap<String, String>();
                                    object4 = "pkg";
                                    string2 = ((PackageInfo)object3).packageName;
                                    hashMap2.put((String)object4, string2);
                                    if (!bl4) break block72;
                                    if (hashMap == null) break block73;
                                    object4 = ((PackageInfo)object3).packageName;
                                    object4 = Data.MD5((String)object4);
                                    object4 = hashMap.get(object4);
                                    break block74;
                                }
                                hashMap = new HashMap<Object, Object>();
                                object4 = null;
                            }
                            n10 = TextUtils.isEmpty((CharSequence)object4);
                            if (n10 == 0) break block75;
                            object2 = ((PackageInfo)object3).applicationInfo;
                            try {
                                object2 = object2.loadLabel((PackageManager)context);
                            }
                            catch (Throwable throwable) {
                                object2 = ((PackageInfo)object3).packageName;
                                object4 = ((PackageInfo)object3).applicationInfo;
                                n10 = ((ApplicationInfo)object4).labelRes;
                                try {
                                    object2 = context.getText((String)object2, n10, (ApplicationInfo)object4);
                                }
                                catch (Throwable throwable2) {
                                    bl6 = false;
                                    object2 = null;
                                }
                            }
                            if (object2 == null) {
                                object2 = ((PackageInfo)object3).packageName;
                            } else {
                                object2 = object2.toString();
                            }
                            object4 = object2;
                            object2 = ((PackageInfo)object3).packageName;
                            object2 = Data.MD5((String)object2);
                            hashMap.put(object2, object4);
                            bl6 = true;
                        }
                        string2 = "name";
                        hashMap2.put(string2, (String)object4);
                    }
                    object4 = "version";
                    string2 = ((PackageInfo)object3).versionName;
                    hashMap2.put((String)object4, string2);
                    object4 = "visible";
                    string2 = ((PackageInfo)object3).packageName;
                    string2 = context.getLaunchIntentForPackage(string2);
                    string2 = string2 == null ? "0" : "1";
                    hashMap2.put((String)object4, string2);
                    object4 = "enable";
                    string2 = ((PackageInfo)object3).applicationInfo;
                    n10 = (int)(((ApplicationInfo)string2).enabled ? 1 : 0);
                    string2 = n10 != 0 ? "1" : "0";
                    hashMap2.put((String)object4, string2);
                    object4 = "firstInstallTime";
                    long l10 = ((PackageInfo)object3).firstInstallTime;
                    string2 = String.valueOf(l10);
                    hashMap2.put((String)object4, string2);
                    object4 = "lastUpdateTime";
                    l10 = ((PackageInfo)object3).lastUpdateTime;
                    object3 = String.valueOf(l10);
                    hashMap2.put((String)object4, (String)object3);
                    arrayList.add(hashMap2);
                }
                if (!bl4 || !bl6) continue;
                this.saveANS(hashMap);
                continue;
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String getAdvertisingID() {
        void var1_6;
        IBinder iBinder;
        int n10;
        Object object;
        Looper looper = Looper.myLooper();
        if (looper == (object = Looper.getMainLooper())) {
            Throwable throwable = new Throwable("Do not call this function from the main thread !");
            throw throwable;
        }
        String string2 = this.advertiseID;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            return this.advertiseID;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        Object object2 = null;
        object = new DeviceHelper$GSConnection(this, null);
        try {
            object2 = this.context;
            n10 = 1;
            object2.bindService(intent, (ServiceConnection)object, n10);
            iBinder = ((DeviceHelper$GSConnection)object).takeBinder();
            if (iBinder == null) {
                String string3 = this.advertiseID;
                return var1_6;
            }
        }
        catch (Throwable throwable) {
            try {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
                String string4 = this.advertiseID;
                return var1_6;
            }
            finally {
                this.context.unbindService((ServiceConnection)object);
            }
        }
        {
            String string5;
            object2 = Parcel.obtain();
            Parcel parcel = Parcel.obtain();
            String string6 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
            object2.writeInterfaceToken(string6);
            string6 = null;
            iBinder.transact(n10, (Parcel)object2, parcel, 0);
            parcel.readException();
            this.advertiseID = string5 = parcel.readString();
            parcel.recycle();
            object2.recycle();
            String string7 = this.advertiseID;
            return var1_6;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int getAlbumCount() {
        int n10;
        block10: {
            n10 = 0;
            String string2 = "android.permission.READ_EXTERNAL_STORAGE";
            try {
                boolean bl2 = this.checkPermission(string2);
                if (!bl2) break block10;
            }
            catch (Throwable throwable) {
                return n10;
            }
            string2 = this.context;
            ContentResolver contentResolver = string2.getContentResolver();
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            String string3 = "bucket_display_name like ? or bucket_display_name like ? or bucket_display_name like ?";
            string2 = "%Camera%";
            String[] stringArray = "%\u76f8\u673a%";
            String string4 = "%DCIM%";
            stringArray = new String[]{string2, stringArray, string4};
            string4 = "datetaken";
            string2 = contentResolver.query(uri, null, string3, stringArray, string4);
            if (string2 == null) break block10;
            n10 = string2.getCount();
            string2.close();
        }
        return n10;
    }

    public String getAndroidID() {
        Object object;
        try {
            object = this.context;
        }
        catch (Throwable throwable) {
            MobLog.getInstance().w(throwable);
            return "";
        }
        object = object.getContentResolver();
        Object object2 = "android_id";
        object = Settings.Secure.getString((ContentResolver)object, (String)object2);
        object2 = MobLog.getInstance();
        CharSequence charSequence = new StringBuilder();
        Object[] objectArray = "getAndroidID === ";
        charSequence.append((String)objectArray);
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        objectArray = null;
        objectArray = new Object[]{};
        ((NLog)object2).i(charSequence, objectArray);
        return object;
    }

    public String getAppLanguage() {
        return this.context.getResources().getConfiguration().locale.getLanguage();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public String getAppName() {
        block17: {
            block15: {
                block16: {
                    var1_1 /* !! */  = this.context;
                    {
                        catch (Throwable var1_3) {
                            MobLog.getInstance().w(var1_3);
                            return "";
                        }
                    }
                    var1_1 /* !! */  = var1_1 /* !! */ .getApplicationInfo();
                    var2_4 = var1_1 /* !! */ .name;
                    if (var2_4 == null) break block15;
                    var3_5 = Build.VERSION.SDK_INT;
                    var4_6 = 25;
                    if (var3_5 < var4_6) break block16;
                    var5_7 = ".*";
                    var3_5 = (int)var2_4.endsWith((String)var5_7);
                    if (var3_5 != 0) break block16;
                    try {
                        ReflectHelper.importClass(var2_4);
                        var2_4 = null;
                        break block15;
                    }
                    catch (Throwable v0) {}
                }
                return var2_4;
            }
            var3_5 = var1_1 /* !! */ .labelRes;
            if (var3_5 <= 0) ** GOTO lbl-1000
            var1_1 /* !! */  = this.context;
            try {
                var2_4 = var1_1 /* !! */ .getString(var3_5);
            }
            catch (Throwable var1_2) {
                var5_7 = MobLog.getInstance();
                var5_7.w(var1_2);
            }
            break block17;
lbl-1000:
            // 1 sources

            {
                var1_1 /* !! */  = var1_1 /* !! */ .nonLocalizedLabel;
            }
            var2_4 = String.valueOf(var1_1 /* !! */ );
        }
        return var2_4;
    }

    public String getAppName(String charSequence) {
        CharSequence charSequence2;
        block8: {
            charSequence2 = null;
            boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
            if (bl2) break block8;
            NLog nLog = this.context;
            nLog = nLog.getPackageManager();
            int n10 = 1;
            charSequence = nLog.getPackageInfo((String)charSequence, n10);
            charSequence = ((PackageInfo)charSequence).applicationInfo;
            charSequence = charSequence.loadLabel((PackageManager)nLog);
            try {
                charSequence2 = charSequence = charSequence.toString();
            }
            catch (Throwable throwable) {
                nLog = MobLog.getInstance();
                nLog.d(throwable);
            }
        }
        return charSequence2;
    }

    public int getAppVersion() {
        Context context;
        block9: {
            try {
                context = this.context;
            }
            catch (Throwable throwable) {
                MobLog.getInstance().d(throwable);
                return 0;
            }
            context = context.getPackageManager();
            Object object = this.context;
            object = object.getPackageName();
            context = context.getPackageInfo((String)object, 0);
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 28;
            if (n10 < n11) break block9;
            return (int)context.getLongVersionCode();
        }
        return context.versionCode;
    }

    public String getAppVersionName() {
        Context context;
        try {
            context = this.context;
        }
        catch (Throwable throwable) {
            MobLog.getInstance().d(throwable);
            return "1.0";
        }
        context = context.getPackageManager();
        Object object = this.context;
        object = object.getPackageName();
        context = context.getPackageInfo((String)object, 0);
        return context.versionName;
    }

    /*
     * Unable to fully structure code
     */
    public ArrayList getArpList() {
        var1_1 = new ArrayList<HashMap<K, V>>();
        var4_6 = "/proc/net/arp";
        var3_4 = new FileReader((String)var4_6);
        var2_2 = new BufferedReader((Reader)var3_4);
        ** while ((var3_4 = var2_2.readLine()) != null)
lbl-1000:
        // 1 sources

        {
            var3_4 = var3_4.trim();
            var4_6 = Locale.US;
            var4_6 = var3_4.toUpperCase((Locale)var4_6);
            var5_7 = "IP";
            var6_8 = var4_6.contains(var5_7);
            if (var6_8 != 0) continue;
            var6_8 = var3_4.length();
            if (var6_8 < (var7_9 = 63)) continue;
            var6_8 = 41;
            var4_6 = var3_4.substring(var6_8, var7_9);
            var4_6 = var4_6.trim();
            var5_7 = "00:00:00:00:00:00";
            var7_9 = (int)var4_6.startsWith(var5_7);
            if (var7_9 != 0) continue;
            var7_9 = 0;
            var5_7 = null;
            var8_10 = 17;
            var5_7 = var3_4.substring(0, var8_10);
            var5_7 = var5_7.trim();
            var8_10 = 29;
            var9_11 = 32;
            var3_4 = var3_4.substring(var8_10, var9_11);
            var3_4 = var3_4.trim();
            var10_12 = new HashMap<Object, Object>();
            var11_13 = "ip";
            var10_12.put(var11_13, var5_7);
            var5_7 = "flag";
            var10_12.put(var5_7, var3_4);
            var3_4 = "mac";
            var10_12.put(var3_4, var4_6);
            try {
                var1_1.add(var10_12);
            }
            catch (Throwable var3_5) {
                var4_6 = MobLog.getInstance();
                var4_6.d(var3_5);
            }
            continue;
        }
lbl-1000:
        // 1 sources

        {
            var2_2.close();
        }
        {
            catch (Throwable var2_3) {
                var3_4 = MobLog.getInstance();
                var3_4.d(var2_3);
            }
        }
        return var1_1;
    }

    /*
     * Exception decompiling
     */
    public ArrayList getAvailableWifiList() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [45[TRYBLOCK]], but top level block is 66[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String getBTMac() {
        int n10;
        Object object;
        String string2;
        block12: {
            int n11 = Build.VERSION.SDK_INT;
            string2 = null;
            int n12 = 27;
            if (n11 >= n12) return string2;
            object = "android.permission.BLUETOOTH";
            n12 = (int)(this.checkPermission((String)object) ? 1 : 0);
            if (n12 == 0) return string2;
            {
                catch (Throwable throwable) {
                    return string2;
                }
            }
            object = BluetoothAdapter.getDefaultAdapter();
            n10 = 23;
            if (n11 >= n10) break block12;
            return object.getAddress();
        }
        Object object2 = "mService";
        object2 = ReflectHelper.getInstanceField(object, (String)object2);
        if (object2 == null) return string2;
        object = "getAddress";
        n10 = 0;
        Object[] objectArray = null;
        objectArray = new Object[]{};
        object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object, objectArray);
        try {
            return object2 = (String)object2;
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).d(throwable);
        }
        return string2;
    }

    public String getBTMacFromProvider() {
        return Settings.Secure.getString((ContentResolver)this.context.getContentResolver(), (String)"bluetooth_address");
    }

    public String getBaseband() {
        int n10 = 116;
        String string2 = Strings.getString(n10);
        try {
            string2 = this.getSystemProperties(string2);
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
            n10 = 0;
            string2 = null;
        }
        return string2;
    }

    public void getBatteryState(ReflectHelper$ReflectRunnable reflectHelper$ReflectRunnable) {
        block11: {
            Class[] classArray = new IntentFilter();
            Object object = "android.intent.action.BATTERY_CHANGED";
            classArray.addAction((String)object);
            object = new DeviceHelper$5(this, reflectHelper$ReflectRunnable);
            Context context = this.context;
            String string2 = "registerReceiver";
            int n10 = 2;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            int n11 = 1;
            objectArray[n11] = classArray;
            classArray = new Class[n10];
            Class<BroadcastReceiver> clazz = BroadcastReceiver.class;
            classArray[0] = clazz;
            clazz = IntentFilter.class;
            classArray[n11] = clazz;
            try {
                ReflectHelper.invokeInstanceMethod((Object)context, string2, objectArray, classArray);
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).w(throwable);
                if (reflectHelper$ReflectRunnable == null) break block11;
                Object var2_4 = null;
                reflectHelper$ReflectRunnable.run(null);
            }
        }
    }

    public String getBluetoothName() {
        block20: {
            Object object;
            Object object2;
            block19: {
                object2 = "-1";
                object = this.bvs;
                object = ((BVS)object).btnm;
                boolean n10 = ((String)object2).equals(object);
                if (n10) break block19;
                object2 = this.bvs;
                return ((BVS)object2).btnm;
            }
            object2 = "android.permission.BLUETOOTH";
            boolean bl2 = this.checkPermission((String)object2);
            if (!bl2) break block20;
            int n10 = 16;
            object2 = Strings.getString(n10);
            object2 = ReflectHelper.importClass((String)object2);
            int n11 = 17;
            object = Strings.getString(n11);
            Object[] objectArray = null;
            Object object3 = new Object[]{};
            object2 = ReflectHelper.invokeStaticMethod((String)object2, (String)object, object3);
            if (object2 == null) break block20;
            object = this.bvs;
            int n12 = 18;
            object3 = Strings.getString(n12);
            objectArray = new Object[]{};
            object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object3, objectArray);
            object2 = (String)object2;
            ((BVS)object).btnm = object2;
            object2 = this.bvs;
            try {
                return ((BVS)object2).btnm;
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).d(throwable);
            }
        }
        return null;
    }

    public String getBoardFromSysProperty() {
        int n10 = 117;
        String string2 = Strings.getString(n10);
        try {
            string2 = this.getSystemProperties(string2);
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
            n10 = 0;
            string2 = null;
        }
        return string2;
    }

    public String getBoardPlatform() {
        int n10 = 118;
        String string2 = Strings.getString(n10);
        try {
            string2 = this.getSystemProperties(string2);
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
            n10 = 0;
            string2 = null;
        }
        return string2;
    }

    public ArrayList getBondedBluetooth() {
        Object object;
        try {
            object = this.context;
        }
        catch (Throwable throwable) {
            MobLog.getInstance().d(throwable);
            ArrayList arrayList = new ArrayList();
            return arrayList;
        }
        object = BHelper.getInstance((Context)object);
        return ((BHelper)object).getBondedDevice();
    }

    public String getBrand() {
        return Build.BRAND;
    }

    public String getBssid() {
        block20: {
            Object object;
            Object object2;
            block22: {
                boolean bl2;
                block21: {
                    block19: {
                        object2 = "-1";
                        object = this.bvs;
                        object = ((BVS)object).bsi;
                        bl2 = ((String)object2).equals(object);
                        if (bl2) break block19;
                        object2 = this.bvs;
                        return ((BVS)object2).bsi;
                    }
                    object2 = "android.permission.ACCESS_WIFI_STATE";
                    bl2 = this.checkPermission((String)object2);
                    if (!bl2) break block20;
                    object2 = "wifi";
                    object2 = this.getSystemServiceSafe((String)object2);
                    if (object2 != null) break block21;
                    object2 = this.bvs;
                    ((BVS)object2).bsi = null;
                    return null;
                }
                int n10 = 2;
                object = Strings.getString(n10);
                Object[] objectArray = null;
                Object[] objectArray2 = new Object[]{};
                object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object, objectArray2);
                if (object2 == null) break block20;
                n10 = 4;
                object = Strings.getString(n10);
                objectArray = new Object[]{};
                object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object, objectArray);
                object2 = (String)object2;
                object = this.bvs;
                if (object2 != null) break block22;
                bl2 = false;
                object2 = null;
            }
            try {
                ((BVS)object).bsi = object2;
                return object2;
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).d(throwable);
            }
        }
        return null;
    }

    public HashMap getCPUFreq() {
        String string2;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String string3 = this.readFile("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2) {
            string2 = "currentCpuHz";
            hashMap.put(string2, string3);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(string3 = this.readFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"))))) {
            string2 = "minCpuHz";
            hashMap.put(string2, string3);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(string3 = this.readFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"))))) {
            string2 = "maxCpuHz";
            hashMap.put(string2, string3);
        }
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public HashMap getCPUInfo() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        try {
            int n10 = 41;
            Object object = Strings.getString(n10);
            FileReader fileReader = new FileReader((String)object);
            object = new BufferedReader(fileReader);
            ArrayList arrayList = new ArrayList();
            String string2 = "processors";
            hashMap.put(string2, arrayList);
            string2 = null;
            block2: while (true) {
                HashMap<String, Object> hashMap2 = null;
                while (true) {
                    int n11;
                    String string3;
                    Object object2;
                    if ((object2 = ((BufferedReader)object).readLine()) == null) {
                        ((BufferedReader)object).close();
                        fileReader.close();
                        return hashMap;
                    }
                    int n12 = TextUtils.isEmpty((CharSequence)object2);
                    if (n12 != 0) {
                        if (hashMap2 == null) continue block2;
                        arrayList.add(hashMap2);
                        continue block2;
                    }
                    n12 = ((String)(object2 = ((String)object2).trim())).startsWith(string3 = "processor");
                    if (n12 != 0) {
                        if (hashMap2 != null) {
                            arrayList.add(hashMap2);
                        }
                        hashMap2 = new HashMap<String, Object>();
                    }
                    if ((object2 = ((String)object2).split(string3 = ":")) == null || (n12 = ((String[])object2).length) <= (n11 = 1)) continue;
                    n12 = 0;
                    string3 = null;
                    if (hashMap2 == null) {
                        string3 = object2[0];
                        string3 = string3.trim();
                        object2 = object2[n11];
                        object2 = ((String)object2).trim();
                        hashMap.put(string3, object2);
                        continue;
                    }
                    string3 = object2[0];
                    string3 = string3.trim();
                    object2 = object2[n11];
                    object2 = ((String)object2).trim();
                    hashMap2.put(string3, object2);
                }
                break;
            }
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
        }
        return hashMap;
    }

    public String getCPUType() {
        Object object;
        block6: {
            int n10;
            block5: {
                try {
                    int n11 = Build.VERSION.SDK_INT;
                    n10 = 21;
                    if (n11 >= n10) break block5;
                }
                catch (Throwable throwable) {
                    MobLog.getInstance().d(throwable);
                    return null;
                }
                object = Build.CPU_ABI;
                break block6;
            }
            object = Build.SUPPORTED_ABIS;
            n10 = 0;
            object = object[0];
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ArrayList getCamResolution() {
        Object object = "android.permission.CAMERA";
        try {
            int n10;
            int n11;
            int n102 = this.checkPermission((String)object);
            if (n102 == 0 || (n102 = Build.VERSION.SDK_INT) < (n11 = 21)) return null;
            object = this.context;
            String[] stringArray = "camera";
            object = object.getSystemService((String)stringArray);
            if ((object = (CameraManager)object) == null) return null;
            n11 = 126;
            stringArray = Strings.getString(n11);
            Object object2 = new Object[]{};
            stringArray = ReflectHelper.invokeInstanceMethod(object, (String)stringArray, (Object[])object2);
            if ((stringArray = (String[])stringArray) == null || (n10 = stringArray.length) <= 0) return null;
            int n12 = stringArray.length;
            object2 = new ArrayList(n12);
            n12 = stringArray.length;
            int n13 = 0;
            while (true) {
                if (n13 >= n12) {
                    return object2;
                }
                Object object3 = stringArray[n13];
                if (object3 != null) {
                    int n14 = 127;
                    HashMap<String, String> hashMap = Strings.getString(n14);
                    int n15 = 1;
                    Object[] string2 = new Object[n15];
                    string2[0] = object3;
                    object3 = ReflectHelper.invokeInstanceMethod(object, (String)((Object)hashMap), string2);
                    if ((object3 = (CameraCharacteristics)object3) != null) {
                        hashMap = CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE;
                        object3 = object3.get((CameraCharacteristics.Key)hashMap);
                        if ((object3 = (Size)object3) != null) {
                            hashMap = new HashMap<String, String>();
                            String string4 = "width";
                            int n16 = object3.getWidth();
                            String string3 = String.valueOf(n16);
                            hashMap.put(string4, string3);
                            String string5 = "height";
                            int n17 = object3.getHeight();
                            object3 = String.valueOf(n17);
                            hashMap.put(string5, (String)object3);
                            ((ArrayList)object2).add(hashMap);
                        }
                    }
                }
                ++n13;
            }
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
        }
        return null;
    }

    public String getCarrier() {
        int n10;
        Object object = "-1";
        Object object2 = "phone";
        try {
            object2 = this.getSystemServiceSafe((String)object2);
            if (object2 == null) {
                return object;
            }
            n10 = 12;
        }
        catch (Throwable throwable) {
            MobLog.getInstance().w(throwable);
            return object;
        }
        String string2 = Strings.getString(n10);
        Object[] objectArray = null;
        objectArray = new Object[]{};
        object2 = ReflectHelper.invokeInstanceMethod(object2, string2, objectArray);
        object2 = (String)object2;
        n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
        if (n10 == 0) {
            object = object2;
        }
        return object;
    }

    public String getCarrierName() {
        block9: {
            Object object = this.getSystemServiceSafe("phone");
            Object object2 = null;
            if (object == null) {
                return null;
            }
            Object object3 = "android.permission.READ_PHONE_STATE";
            int n10 = this.checkPermission((String)object3);
            if (n10 == 0) break block9;
            n10 = 13;
            object3 = Strings.getString(n10);
            Object[] objectArray = null;
            objectArray = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(object, (String)object3, objectArray);
            object = (String)object;
            try {
                n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                if (n10 == 0) {
                    object2 = object;
                }
                return object2;
            }
            catch (Throwable throwable) {
                object3 = MobLog.getInstance();
                ((NLog)object3).w(throwable);
            }
        }
        return null;
    }

    public int getCdmaBid() {
        int n10;
        block16: {
            n10 = -1;
            Object object = "android.permission.ACCESS_COARSE_LOCATION";
            boolean bl2 = this.checkPermission((String)object);
            if (!bl2) break block16;
            object = "phone";
            object = this.getSystemServiceSafe((String)object);
            if (object == null) break block16;
            int n11 = 26;
            Object object2 = Strings.getString(n11);
            Object[] objectArray = null;
            Object object3 = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(object, (String)object2, (Object[])object3);
            if (object == null) break block16;
            object2 = "CdmaCellLocation";
            object3 = object.getClass();
            object3 = ((Class)object3).getSimpleName();
            n11 = (int)(((String)object2).equals(object3) ? 1 : 0);
            if (n11 == 0) break block16;
            n11 = 58;
            object2 = Strings.getString(n11);
            objectArray = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
            object2 = n10;
            object = ResHelper.forceCast(object, object2);
            object = (Integer)object;
            try {
                return (Integer)object;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
        }
        return n10;
    }

    public int getCdmaLat() {
        int n10;
        int n11;
        int n12;
        block18: {
            block17: {
                n12 = -1;
                Object object = "android.permission.ACCESS_COARSE_LOCATION";
                n11 = this.checkPermission((String)object);
                if (n11 == 0) break block17;
                object = "phone";
                object = this.getSystemServiceSafe((String)object);
                if (object == null) break block17;
                n10 = 26;
                Object object2 = Strings.getString(n10);
                Object[] objectArray = null;
                Object object3 = new Object[]{};
                object = ReflectHelper.invokeInstanceMethod(object, (String)object2, (Object[])object3);
                if (object == null) break block17;
                object2 = "CdmaCellLocation";
                object3 = object.getClass();
                object3 = ((Class)object3).getSimpleName();
                n10 = (int)(((String)object2).equals(object3) ? 1 : 0);
                if (n10 == 0) break block17;
                n10 = 56;
                object2 = Strings.getString(n10);
                objectArray = new Object[]{};
                object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
                object2 = n12;
                object = ResHelper.forceCast(object, object2);
                object = (Integer)object;
                try {
                    n11 = (Integer)object;
                    break block18;
                }
                catch (Throwable throwable) {
                    object2 = MobLog.getInstance();
                    ((NLog)object2).d(throwable);
                }
            }
            n11 = n12;
        }
        n10 = -1 >>> 1;
        if (n11 != n10) {
            n12 = n11;
        }
        return n12;
    }

    public int getCdmaLon() {
        int n10;
        int n11;
        int n12;
        block18: {
            block17: {
                n12 = -1;
                Object object = "android.permission.ACCESS_COARSE_LOCATION";
                n11 = this.checkPermission((String)object);
                if (n11 == 0) break block17;
                object = "phone";
                object = this.getSystemServiceSafe((String)object);
                if (object == null) break block17;
                n10 = 26;
                Object object2 = Strings.getString(n10);
                Object[] objectArray = null;
                Object object3 = new Object[]{};
                object = ReflectHelper.invokeInstanceMethod(object, (String)object2, (Object[])object3);
                if (object == null) break block17;
                object2 = "CdmaCellLocation";
                object3 = object.getClass();
                object3 = ((Class)object3).getSimpleName();
                n10 = (int)(((String)object2).equals(object3) ? 1 : 0);
                if (n10 == 0) break block17;
                n10 = 57;
                object2 = Strings.getString(n10);
                objectArray = new Object[]{};
                object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
                object2 = n12;
                object = ResHelper.forceCast(object, object2);
                object = (Integer)object;
                try {
                    n11 = (Integer)object;
                    break block18;
                }
                catch (Throwable throwable) {
                    object2 = MobLog.getInstance();
                    ((NLog)object2).d(throwable);
                }
            }
            n11 = n12;
        }
        n10 = -1 >>> 1;
        if (n11 != n10) {
            n12 = n11;
        }
        return n12;
    }

    public int getCdmaNid() {
        int n10;
        block16: {
            n10 = -1;
            Object object = "android.permission.ACCESS_COARSE_LOCATION";
            boolean bl2 = this.checkPermission((String)object);
            if (!bl2) break block16;
            object = "phone";
            object = this.getSystemServiceSafe((String)object);
            if (object == null) break block16;
            int n11 = 26;
            Object object2 = Strings.getString(n11);
            Object[] objectArray = null;
            Object object3 = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(object, (String)object2, (Object[])object3);
            if (object == null) break block16;
            object2 = "CdmaCellLocation";
            object3 = object.getClass();
            object3 = ((Class)object3).getSimpleName();
            n11 = (int)(((String)object2).equals(object3) ? 1 : 0);
            if (n11 == 0) break block16;
            n11 = 60;
            object2 = Strings.getString(n11);
            objectArray = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
            object2 = n10;
            object = ResHelper.forceCast(object, object2);
            object = (Integer)object;
            try {
                return (Integer)object;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
        }
        return n10;
    }

    public int getCdmaSid() {
        int n10;
        block16: {
            n10 = -1;
            Object object = "android.permission.ACCESS_COARSE_LOCATION";
            boolean bl2 = this.checkPermission((String)object);
            if (!bl2) break block16;
            object = "phone";
            object = this.getSystemServiceSafe((String)object);
            if (object == null) break block16;
            int n11 = 26;
            Object object2 = Strings.getString(n11);
            Object[] objectArray = null;
            Object object3 = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(object, (String)object2, (Object[])object3);
            if (object == null) break block16;
            object2 = "CdmaCellLocation";
            object3 = object.getClass();
            object3 = ((Class)object3).getSimpleName();
            n11 = (int)(((String)object2).equals(object3) ? 1 : 0);
            if (n11 == 0) break block16;
            n11 = 59;
            object2 = Strings.getString(n11);
            objectArray = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
            object2 = n10;
            object = ResHelper.forceCast(object, object2);
            object = (Integer)object;
            try {
                return (Integer)object;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
        }
        return n10;
    }

    public int getCellId() {
        int n10;
        block16: {
            n10 = -1;
            Object object = "android.permission.ACCESS_COARSE_LOCATION";
            boolean bl2 = this.checkPermission((String)object);
            if (!bl2) break block16;
            object = "phone";
            object = this.getSystemServiceSafe((String)object);
            if (object == null) break block16;
            int n11 = 26;
            Object object2 = Strings.getString(n11);
            Object[] objectArray = null;
            Object object3 = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(object, (String)object2, (Object[])object3);
            if (object == null) break block16;
            object2 = "CdmaCellLocation";
            object3 = object.getClass();
            object3 = ((Class)object3).getSimpleName();
            n11 = (int)(((String)object2).equals(object3) ? 1 : 0);
            if (n11 != 0) break block16;
            n11 = 27;
            object2 = Strings.getString(n11);
            objectArray = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
            object2 = n10;
            object = ResHelper.forceCast(object, object2);
            object = (Integer)object;
            try {
                return (Integer)object;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
        }
        return n10;
    }

    public int getCellLac() {
        int n10;
        block16: {
            n10 = -1;
            Object object = "android.permission.ACCESS_COARSE_LOCATION";
            boolean bl2 = this.checkPermission((String)object);
            if (!bl2) break block16;
            object = "phone";
            object = this.getSystemServiceSafe((String)object);
            if (object == null) break block16;
            int n11 = 26;
            Object object2 = Strings.getString(n11);
            Object[] objectArray = null;
            Object object3 = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(object, (String)object2, (Object[])object3);
            if (object == null) break block16;
            object2 = "CdmaCellLocation";
            object3 = object.getClass();
            object3 = ((Class)object3).getSimpleName();
            n11 = (int)(((String)object2).equals(object3) ? 1 : 0);
            if (n11 != 0) break block16;
            n11 = 28;
            object2 = Strings.getString(n11);
            objectArray = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
            object2 = n10;
            object = ResHelper.forceCast(object, object2);
            object = (Integer)object;
            try {
                return (Integer)object;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
        }
        return n10;
    }

    public String getCharAndNumr(int n10) {
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

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public HashMap getCurrentWifiInfo() {
        Object object;
        int n10;
        Object object2;
        Object[] objectArray;
        HashMap<Object[], Object[]> hashMap;
        Object object3;
        Object object4;
        int n11;
        block21: {
            n11 = 0;
            object4 = null;
            object3 = "android.permission.ACCESS_WIFI_STATE";
            boolean bl2 = this.checkPermission((String)object3);
            if (!bl2) return null;
            object3 = "wifi";
            if ((object3 = this.getSystemServiceSafe((String)object3)) == null) return null;
            int n12 = 2;
            hashMap = Strings.getString(n12);
            objectArray = null;
            object2 = new Object[0];
            if ((object3 = ReflectHelper.invokeInstanceMethod(object3, (String)((Object)hashMap), (Object[])object2)) == null) return null;
            hashMap = new HashMap<Object[], Object[]>();
            n10 = 4;
            try {
                object2 = Strings.getString(n10);
                object = new Object[]{};
                object2 = ReflectHelper.invokeInstanceMethod(object3, (String)object2, object);
                object2 = (String)object2;
                object = "bssid";
                hashMap.put((Object[])object, (Object[])object2);
                break block21;
            }
            catch (Throwable throwable) {}
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.d(throwable);
            }
            return null;
        }
        n10 = 3;
        try {
            object2 = Strings.getString(n10);
            object = new Object[]{};
            object2 = ReflectHelper.invokeInstanceMethod(object3, (String)object2, object);
            object2 = (String)object2;
            if (object2 != null) {
                object4 = "\"";
                object = "";
                object4 = ((String)object2).replace((CharSequence)object4, (CharSequence)object);
            }
            object2 = "ssid";
            hashMap.put((Object[])object2, (Object[])object4);
        }
        catch (Throwable throwable) {}
        n11 = 79;
        try {
            object4 = Strings.getString(n11);
            object2 = new Object[]{};
            object4 = ReflectHelper.invokeInstanceMethod(object3, (String)object4, (Object[])object2);
            object4 = (Integer)object4;
            n11 = (Integer)object4;
            object2 = "ip";
            object4 = n11;
            hashMap.put((Object[])object2, (Object[])object4);
        }
        catch (Throwable throwable) {}
        object4 = "wlanMac";
        try {
            object2 = this.getMacAddress();
            hashMap.put((Object[])object4, (Object[])object2);
        }
        catch (Throwable throwable) {}
        n11 = 80;
        try {
            object4 = Strings.getString(n11);
            object2 = new Object[]{};
            object4 = ReflectHelper.invokeInstanceMethod(object3, (String)object4, (Object[])object2);
            object4 = (Boolean)object4;
            n11 = (int)(((Boolean)object4).booleanValue() ? 1 : 0);
            object2 = "hidden";
            object4 = n11 != 0;
            hashMap.put((Object[])object2, (Object[])object4);
        }
        catch (Throwable throwable) {}
        n11 = 81;
        try {
            object4 = Strings.getString(n11);
            object2 = new Object[]{};
            object4 = ReflectHelper.invokeInstanceMethod(object3, (String)object4, (Object[])object2);
            object4 = (Integer)object4;
            n11 = (Integer)object4;
            object2 = "speed";
            object4 = n11;
            hashMap.put((Object[])object2, (Object[])object4);
        }
        catch (Throwable throwable) {}
        n11 = 60;
        try {
            object4 = Strings.getString(n11);
            object2 = new Object[]{};
            object4 = ReflectHelper.invokeInstanceMethod(object3, (String)object4, (Object[])object2);
            object4 = (Integer)object4;
            n11 = (Integer)object4;
            object2 = "networkId";
            object4 = n11;
            hashMap.put((Object[])object2, (Object[])object4);
        }
        catch (Throwable throwable) {}
        n11 = 62;
        try {
            object4 = Strings.getString(n11);
            object2 = new Object[]{};
            object4 = ReflectHelper.invokeInstanceMethod(object3, (String)object4, (Object[])object2);
            object4 = (Integer)object4;
            n11 = (Integer)object4;
            object2 = "level";
            object4 = n11;
            hashMap.put((Object[])object2, (Object[])object4);
        }
        catch (Throwable throwable) {}
        n11 = 82;
        try {
            object4 = Strings.getString(n11);
            objectArray = new Object[]{};
            object4 = ReflectHelper.invokeInstanceMethod(object3, (String)object4, objectArray);
            object4 = (Integer)object4;
            n11 = (Integer)object4;
            object3 = "frequency";
            object4 = n11;
            hashMap.put((Object[])object3, (Object[])object4);
            return hashMap;
        }
        catch (Throwable throwable) {
            return hashMap;
        }
    }

    public int getDataNtType() {
        return NtFetcher.getInstance(this.context).getDtNtType();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public HashMap getDefaultIM() {
        HashMap<Object, Object> hashMap;
        Object object;
        Object object2;
        block4: {
            String string2;
            object2 = null;
            try {
                object = this.getDefaultIMPkg();
                string2 = this.getAppName((String)object);
                hashMap = new HashMap<Object, Object>();
                object2 = "name";
            }
            catch (Throwable throwable) {
                hashMap = null;
                object2 = throwable;
                break block4;
            }
            try {
                hashMap.put(object2, string2);
                object2 = "pkg";
                hashMap.put(object2, object);
                return hashMap;
            }
            catch (Throwable throwable) {}
        }
        object = MobLog.getInstance();
        ((NLog)object).d((Throwable)object2);
        return hashMap;
    }

    public String getDefaultIMPkg() {
        Object object;
        block7: {
            object = null;
            Object object2 = this.context;
            object2 = object2.getContentResolver();
            Object object3 = "default_input_method";
            object2 = Settings.Secure.getString((ContentResolver)object2, (String)object3);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (bl2) break block7;
            object3 = "/";
            object2 = ((String)object2).split((String)object3);
            bl2 = false;
            object3 = null;
            try {
                object = object2[0];
            }
            catch (Throwable throwable) {
                object3 = MobLog.getInstance();
                ((NLog)object3).d(throwable);
            }
        }
        return object;
    }

    public String getDefaultResolvePkg(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = null;
        if (bl2) {
            return null;
        }
        Intent intent = new Intent();
        string2 = Uri.parse((String)string2);
        intent.setData((Uri)string2);
        string2 = this.context.getPackageManager();
        int n10 = 65536;
        string2 = string2.resolveActivity(intent, n10);
        if (string2 != null && (string2 = ((ResolveInfo)string2).activityInfo) != null) {
            string3 = ((ActivityInfo)string2).packageName;
        }
        return string3;
    }

    public String getDetailNetworkTypeForStatic() {
        String string2;
        block12: {
            String string3;
            String string4;
            block17: {
                String string5;
                block16: {
                    String string6;
                    block15: {
                        String string7;
                        block14: {
                            String string8;
                            block13: {
                                string4 = "bluetooth";
                                string5 = "2g";
                                string6 = "3g";
                                string7 = "4g";
                                string8 = "5g";
                                String string9 = "wifi";
                                string2 = "none";
                                try {
                                    string3 = this.getNetworkType();
                                }
                                catch (Throwable throwable) {
                                    MobLog.getInstance().w(throwable);
                                    return string2;
                                }
                                string3 = string3.toLowerCase();
                                boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
                                if (bl2) break block12;
                                bl2 = string2.equals(string3);
                                if (bl2) break block12;
                                bl2 = string3.startsWith(string9);
                                if (!bl2) break block13;
                                return string9;
                            }
                            boolean bl3 = string3.startsWith(string8);
                            if (!bl3) break block14;
                            return string8;
                        }
                        boolean bl4 = string3.startsWith(string7);
                        if (!bl4) break block15;
                        return string7;
                    }
                    boolean bl5 = string3.startsWith(string6);
                    if (!bl5) break block16;
                    return string6;
                }
                boolean bl6 = string3.startsWith(string5);
                if (!bl6) break block17;
                return string5;
            }
            boolean bl7 = string3.startsWith(string4);
            if (bl7) {
                return string4;
            }
            return string3;
        }
        return string2;
    }

    public String getDeviceData() {
        CharSequence charSequence;
        String string2;
        block17: {
            int n10;
            String string3;
            block16: {
                String string4 = "";
                string2 = "|";
                try {
                    charSequence = new StringBuilder();
                    string3 = this.getModel();
                }
                catch (Throwable throwable) {
                    MobLog.getInstance().w(throwable);
                    return string4;
                }
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(string2);
                n10 = this.getOSVersionInt();
                ((StringBuilder)charSequence).append(n10);
                ((StringBuilder)charSequence).append(string2);
                string3 = this.getManufacturer();
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(string2);
                string3 = this.getCarrier();
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(string2);
                string2 = this.getScreenSize();
                ((StringBuilder)charSequence).append(string2);
                string2 = ((StringBuilder)charSequence).toString();
                charSequence = this.getDeviceKey();
                if (charSequence != null) break block16;
                charSequence = string4;
                break block17;
            }
            n10 = ((String)charSequence).length();
            int n11 = 16;
            if (n10 <= n11) break block17;
            n10 = 0;
            string3 = null;
            charSequence = ((String)charSequence).substring(0, n11);
        }
        return this.Base64AES(string2, (String)charSequence);
    }

    public String getDeviceDataNotAES() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.getModel();
        stringBuilder.append(string2);
        string2 = "|";
        stringBuilder.append(string2);
        int n10 = this.getOSVersionInt();
        stringBuilder.append(n10);
        stringBuilder.append(string2);
        String string3 = this.getManufacturer();
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string3 = this.getCarrier();
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string2 = this.getScreenSize();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public String getDeviceId() {
        int n10;
        String string2 = this.getIMEI();
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 != 0 && (n11 = Build.VERSION.SDK_INT) >= (n10 = 9)) {
            string2 = this.getSerialno();
        }
        return string2;
    }

    public String getDeviceKey() {
        int n10;
        NLog nLog;
        String string2 = this.cacheDeviceKey;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            return this.cacheDeviceKey;
        }
        bl2 = false;
        string2 = null;
        String string3 = "comm/dbs/.duid";
        try {
            string3 = this.getDeviceKeyWithDuid(string3);
        }
        catch (Throwable throwable) {
            nLog = MobLog.getInstance();
            nLog.w(throwable);
            n10 = 0;
            string3 = null;
        }
        int n11 = TextUtils.isEmpty((CharSequence)string3);
        int n12 = 40;
        if (n11 != 0 || (n11 = string3.length()) < n12) {
            string3 = this.genDeviceKey();
        }
        if ((n11 = (int)(TextUtils.isEmpty((CharSequence)string3) ? 1 : 0)) == 0 && (n11 = string3.length()) >= n12) {
            this.cacheDeviceKey = string2 = string3.trim();
            return string2;
        }
        try {
            string2 = this.getLocalDeviceKey();
        }
        catch (Throwable throwable) {
            nLog = MobLog.getInstance();
            nLog.w(throwable);
        }
        n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 == 0 && (n10 = string2.length()) >= n12) {
            this.cacheDeviceKey = string2 = string2.trim();
            return string2;
        }
        n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n10 != 0 || (n10 = string2.length()) < n12) {
            string2 = this.getCharAndNumr(n12);
        }
        if (string2 != null) {
            string2 = string2.trim();
            try {
                this.saveLocalDeviceKey(string2);
            }
            catch (Throwable throwable) {
                nLog = MobLog.getInstance();
                nLog.w(throwable);
            }
        }
        return string2;
    }

    /*
     * Loose catch block
     */
    public HashMap getDeviceMemUsage() {
        HashMap<Object, Object> hashMap;
        block43: {
            Object object;
            Object object2;
            Object object3;
            block42: {
                hashMap = new HashMap<Object, Object>();
                int n10 = 125;
                int n11 = 0;
                object3 = null;
                object2 = Strings.getString(n10);
                FileReader fileReader = new FileReader((String)object2);
                object = new BufferedReader(fileReader);
                while (true) {
                    long l10;
                    block41: {
                        block40: {
                            block39: {
                                block38: {
                                    object2 = ((BufferedReader)object).readLine();
                                    if (object2 == null) break;
                                    object3 = "\\s+";
                                    if ((object2 = ((String)object2).split((String)object3)) == null) continue;
                                    n11 = ((String[])object2).length;
                                    int n12 = 1;
                                    if (n11 <= n12) continue;
                                    n11 = 0;
                                    object3 = null;
                                    object3 = object2[0];
                                    object2 = object2[n12];
                                    l10 = Long.parseLong((String)object2);
                                    long l11 = 1024L;
                                    l10 *= l11;
                                    object2 = "MemTotal:";
                                    n10 = (int)(((String)object2).equals(object3) ? 1 : 0);
                                    if (n10 == 0) break block38;
                                    object2 = "totalMemorySize";
                                    object3 = l10;
                                    hashMap.put(object2, object3);
                                    continue;
                                }
                                object2 = "MemFree:";
                                n10 = (int)(((String)object2).equals(object3) ? 1 : 0);
                                if (n10 == 0) break block39;
                                object2 = "freeMemorySize";
                                object3 = l10;
                                hashMap.put(object2, object3);
                                continue;
                            }
                            object2 = "MemAvailable:";
                            n10 = (int)(((String)object2).equals(object3) ? 1 : 0);
                            if (n10 == 0) break block40;
                            object2 = "availableMemorySize";
                            object3 = l10;
                            hashMap.put(object2, object3);
                            continue;
                        }
                        object2 = "Active:";
                        n10 = (int)(((String)object2).equals(object3) ? 1 : 0);
                        if (n10 == 0) break block41;
                        object2 = "activeMemorySize";
                        object3 = l10;
                        hashMap.put(object2, object3);
                        continue;
                    }
                    object2 = "Inactive:";
                    n10 = (int)(((String)object2).equals(object3) ? 1 : 0);
                    if (n10 == 0) continue;
                    object2 = "inactiveMemorySize";
                    object3 = l10;
                    hashMap.put(object2, object3);
                    continue;
                    break;
                }
                ((BufferedReader)object).close();
                catch (Throwable throwable) {
                    object3 = object;
                    break block42;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            try {
                object = MobLog.getInstance();
            }
            catch (Throwable throwable) {
                if (object3 != null) {
                    try {
                        ((BufferedReader)object3).close();
                    }
                    catch (Throwable throwable2) {
                        object3 = MobLog.getInstance();
                        ((NLog)object3).d(throwable2);
                    }
                }
                throw throwable;
            }
            ((NLog)object).d((Throwable)object2);
            if (object3 == null) break block43;
            try {
                ((BufferedReader)object3).close();
            }
            catch (Throwable throwable) {
                object3 = MobLog.getInstance();
                ((NLog)object3).d(throwable);
            }
        }
        return hashMap;
    }

    public String getDeviceType() {
        block13: {
            int n10;
            Object object = "uimode";
            object = this.getSystemServiceSafe((String)object);
            object = (UiModeManager)object;
            if (object == null) break block13;
            try {
                n10 = object.getCurrentModeType();
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.d(throwable);
            }
            switch (n10) {
                default: {
                    break;
                }
                case 7: {
                    return "VRHEADSET";
                }
                case 6: {
                    return "WATCH";
                }
                case 5: {
                    return "APPLIANCE";
                }
                case 4: {
                    return "TELEVISION";
                }
                case 3: {
                    return "CAR";
                }
                case 2: {
                    return "DESK";
                }
                case 1: {
                    return "NO_UI";
                }
            }
        }
        return "UNDEFINED";
    }

    public long getElapsedTime() {
        long l10;
        try {
            l10 = SystemClock.elapsedRealtime();
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.w(throwable);
            l10 = 0L;
        }
        return l10;
    }

    public String getFlavor() {
        int n10 = 119;
        String string2 = Strings.getString(n10);
        try {
            string2 = this.getSystemProperties(string2);
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
            n10 = 0;
            string2 = null;
        }
        return string2;
    }

    public ArrayList getIA(boolean bl2) {
        return this.getIA(bl2, true);
    }

    public ArrayList getIA(boolean bl2, boolean bl3) {
        return this.getAL(false, bl2, bl3);
    }

    public HashMap getIInfo() {
        return this.getIInfo(false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public HashMap getIInfo(boolean bl2) {
        DeviceHelper deviceHelper = this;
        Object object = "-1";
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 0;
        ArrayList<HashMap<Object[], Object[]>> arrayList = null;
        Object object2 = "phone";
        try {
            int n12;
            Object object3;
            Object object4;
            int n13;
            object2 = this.getSystemServiceSafe((String)object2);
            if (object2 == null) {
                return null;
            }
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            int n14 = 83;
            Object[] objectArray = Strings.getString(n14);
            int n15 = 84;
            HashMap<Object[], Object[]> hashMap2 = Strings.getString(n15);
            Object object5 = new Object[]{};
            hashMap2 = this.invokeInstanceMethod(object2, (String)((Object)hashMap2), (Object[])object5);
            hashMap.put(objectArray, hashMap2);
            int n16 = 85;
            objectArray = Strings.getString(n16);
            int n17 = 86;
            hashMap2 = Strings.getString(n17);
            object5 = new Object[]{};
            hashMap2 = this.invokeInstanceMethod(object2, (String)((Object)hashMap2), (Object[])object5);
            hashMap.put(objectArray, hashMap2);
            n16 = 87;
            objectArray = Strings.getString(n16);
            n17 = 88;
            hashMap2 = Strings.getString(n17);
            object5 = new Object[]{};
            hashMap2 = this.invokeInstanceMethod(object2, (String)((Object)hashMap2), (Object[])object5);
            hashMap.put(objectArray, hashMap2);
            n16 = 23;
            if (n10 >= n16) {
                n17 = 89;
                hashMap2 = Strings.getString(n17);
                n13 = 90;
                object5 = Strings.getString(n13);
                object4 = new Object[]{};
                object5 = this.invokeInstanceMethod(object2, (String)object5, object4);
                hashMap.put(hashMap2, object5);
            }
            if ((n17 = (int)(deviceHelper.checkPermission((String)((Object)(hashMap2 = "android.permission.READ_PHONE_STATE"))) ? 1 : 0)) == 0) {
                return hashMap;
            }
            n17 = 14;
            n13 = 99;
            int n18 = 25;
            int n19 = 94;
            int n20 = 96;
            float f10 = 1.35E-43f;
            int n21 = 93;
            int n22 = 92;
            n11 = 26;
            n16 = 29;
            int n23 = 95;
            int n24 = 91;
            if (n10 < n16) {
                if (n10 >= n11) {
                    arrayList = Strings.getString(n24);
                    objectArray = Strings.getString(n22);
                    object3 = new Object[]{};
                    objectArray = deviceHelper.invokeInstanceMethod(object2, (String)objectArray, (Object[])object3);
                    hashMap.put(arrayList, objectArray);
                    arrayList = Strings.getString(n21);
                    objectArray = Strings.getString(n19);
                    object3 = new Object[]{};
                    objectArray = deviceHelper.invokeInstanceMethod(object2, (String)objectArray, (Object[])object3);
                    hashMap.put(arrayList, objectArray);
                } else {
                    arrayList = Strings.getString(n24);
                    objectArray = Strings.getString(n23);
                    object3 = new Object[]{};
                    objectArray = deviceHelper.invokeInstanceMethod(object2, (String)objectArray, (Object[])object3);
                    hashMap.put(arrayList, objectArray);
                }
                arrayList = Strings.getString(n20);
                objectArray = Strings.getString(n18);
                object3 = new Object[]{};
                objectArray = deviceHelper.invokeInstanceMethod(object2, (String)objectArray, (Object[])object3);
                hashMap.put(arrayList, objectArray);
                arrayList = Strings.getString(n13);
                objectArray = Strings.getString(n17);
                object3 = new Object[]{};
                objectArray = deviceHelper.invokeInstanceMethod(object2, (String)objectArray, (Object[])object3);
                hashMap.put(arrayList, objectArray);
            }
            if (n10 >= (n11 = 24)) {
                n11 = 100;
                arrayList = Strings.getString(n11);
                objectArray = deviceHelper.context;
                objectArray = DeviceHelper.getInstance((Context)objectArray);
                n16 = objectArray.getDataNtType();
                objectArray = n16;
                hashMap.put(arrayList, objectArray);
            }
            if ((n11 = (int)(((String)object).equals(arrayList = deviceHelper.swVer) ? 1 : 0)) != 0 || (n11 = (int)(this.isSensitiveDevice() ? 1 : 0)) == 0) {
                n11 = 98;
                arrayList = Strings.getString(n11);
                objectArray = new Object[]{};
                arrayList = deviceHelper.invokeInstanceMethod(object2, (String)((Object)arrayList), objectArray);
                arrayList = (String)((Object)arrayList);
                deviceHelper.swVer = arrayList;
            }
            if ((n12 = ((String)object).equals(arrayList = deviceHelper.swVer)) == 0 && (n12 = (int)(TextUtils.isEmpty((CharSequence)(object = deviceHelper.swVer)) ? 1 : 0)) == 0) {
                n12 = 97;
                object = Strings.getString(n12);
                arrayList = deviceHelper.swVer;
                hashMap.put(object, arrayList);
            }
            if (n10 >= (n12 = 22)) {
                n12 = 114;
                object = Strings.getString(n12);
                object = deviceHelper.getSystemServiceSafe((String)object);
                n11 = deviceHelper.sActCnt;
                n16 = -1;
                if (n11 == n16 || (n11 = (int)(this.isSensitiveDevice() ? 1 : 0)) == 0) {
                    n11 = 103;
                    arrayList = Strings.getString(n11);
                    object3 = new Object[]{};
                    arrayList = deviceHelper.invokeInstanceMethod(object, (String)((Object)arrayList), (Object[])object3);
                    arrayList = (Integer)((Object)arrayList);
                    deviceHelper.sActCnt = n11 = ((Integer)((Object)arrayList)).intValue();
                }
                if ((n11 = deviceHelper.sActCnt) != n16) {
                    n11 = 102;
                    arrayList = Strings.getString(n11);
                    n16 = deviceHelper.sActCnt;
                    objectArray = n16;
                    hashMap.put(arrayList, objectArray);
                }
                if ((arrayList = deviceHelper.sActList) == null || (n11 = (int)(this.isSensitiveDevice() ? 1 : 0)) == 0) {
                    n11 = 104;
                    arrayList = Strings.getString(n11);
                    objectArray = new Object[]{};
                    object = deviceHelper.invokeInstanceMethod(object, (String)((Object)arrayList), objectArray);
                    deviceHelper.sActList = object = (List)object;
                }
                if ((object = deviceHelper.sActList) != null) {
                    n12 = object.size();
                    arrayList = new ArrayList<HashMap<Object[], Object[]>>();
                    objectArray = null;
                    for (n16 = 0; n16 < n12; ++n16) {
                        Class<Integer> clazz;
                        object3 = deviceHelper.sActList;
                        object3 = object3.get(n16);
                        hashMap2 = new HashMap<Object[], Object[]>();
                        int n25 = 105;
                        object5 = Strings.getString(n25);
                        object4 = new Object[]{};
                        object5 = deviceHelper.invokeInstanceMethod(object3, (String)object5, object4);
                        object5 = (Integer)object5;
                        n13 = (Integer)object5;
                        n18 = 106;
                        object4 = Strings.getString(n18);
                        int n26 = 107;
                        Object object6 = Strings.getString(n26);
                        Object object7 = new Object[]{};
                        object7 = deviceHelper.invokeInstanceMethod(object3, (String)object6, object7);
                        hashMap2.put((Object[])object4, (Object[])object7);
                        if (bl2) {
                            n18 = 108;
                            object4 = Strings.getString(n18);
                            n19 = 109;
                            object7 = Strings.getString(n19);
                            object6 = new Object[]{};
                            object7 = deviceHelper.invokeInstanceMethod(object3, (String)object7, object6);
                            hashMap2.put((Object[])object4, (Object[])object7);
                        }
                        n18 = 110;
                        object4 = Strings.getString(n18);
                        n19 = 111;
                        object7 = Strings.getString(n19);
                        object6 = new Object[]{};
                        object7 = deviceHelper.invokeInstanceMethod(object3, (String)object7, object6);
                        hashMap2.put((Object[])object4, (Object[])object7);
                        n18 = 112;
                        object4 = Strings.getString(n18);
                        object7 = new Object[]{};
                        object3 = deviceHelper.invokeInstanceMethod(object3, (String)object4, object7);
                        object3 = (Integer)object3;
                        n15 = (Integer)object3;
                        object4 = Strings.getString(n14);
                        n19 = 84;
                        object6 = Strings.getString(n19);
                        n14 = 1;
                        object7 = new Object[n14];
                        Integer n27 = n15;
                        object7[0] = n27;
                        Object object8 = new Class[n14];
                        object8[0] = clazz = Integer.TYPE;
                        object7 = deviceHelper.invokeInstanceMethod(object2, (String)object6, (Object[])object7, (Class[])object8);
                        hashMap2.put((Object[])object4, (Object[])object7);
                        n18 = 29;
                        if (n10 < n18) {
                            n19 = 26;
                            if (n10 >= n19) {
                                object6 = Strings.getString(n24);
                                object8 = Strings.getString(n22);
                                object4 = new Object[n14];
                                Integer n28 = n15;
                                object4[0] = n28;
                                object7 = new Class[n14];
                                object7[0] = clazz;
                                object4 = deviceHelper.invokeInstanceMethod(object2, (String)object8, (Object[])object4, (Class[])object7);
                                hashMap2.put((Object[])object6, (Object[])object4);
                                n18 = 93;
                                object7 = Strings.getString(n18);
                                n20 = 94;
                                f10 = 1.32E-43f;
                                object8 = Strings.getString(n20);
                                object4 = new Object[n14];
                                object4[0] = object3 = Integer.valueOf(n15);
                                object3 = new Class[n14];
                                object3[0] = clazz;
                                object3 = deviceHelper.invokeInstanceMethod(object2, (String)object8, (Object[])object4, (Class[])object3);
                                hashMap2.put((Object[])object7, (Object[])object3);
                            } else {
                                n20 = 94;
                                f10 = 1.32E-43f;
                                n18 = 23;
                                if (n10 >= n18) {
                                    object7 = Strings.getString(n24);
                                    object8 = Strings.getString(n23);
                                    object4 = new Object[n14];
                                    object4[0] = object3 = Integer.valueOf(n15);
                                    object3 = new Class[n14];
                                    object3[0] = clazz;
                                    object3 = deviceHelper.invokeInstanceMethod(object2, (String)object8, (Object[])object4, (Class[])object3);
                                    hashMap2.put((Object[])object7, (Object[])object3);
                                } else {
                                    object3 = Strings.getString(n24);
                                    object4 = Strings.getString(n23);
                                    object7 = new Object[]{};
                                    object4 = deviceHelper.invokeInstanceMethod(object2, (String)object4, object7);
                                    hashMap2.put((Object[])object3, (Object[])object4);
                                }
                            }
                            n15 = 96;
                            object4 = Strings.getString(n15);
                            n19 = 25;
                            object8 = Strings.getString(n19);
                            object3 = new Object[n14];
                            Integer n29 = n13;
                            object3[0] = n29;
                            object7 = new Class[n14];
                            object7[0] = clazz;
                            object3 = deviceHelper.invokeInstanceMethod(object2, (String)object8, (Object[])object3, (Class[])object7);
                            hashMap2.put((Object[])object4, (Object[])object3);
                            n15 = 99;
                            object4 = Strings.getString(n15);
                            n19 = 14;
                            object8 = Strings.getString(n19);
                            object3 = new Object[n14];
                            object3[0] = object5 = Integer.valueOf(n13);
                            Object object9 = new Class[n14];
                            object9[0] = clazz;
                            object9 = deviceHelper.invokeInstanceMethod(object2, (String)object8, (Object[])object3, (Class[])object9);
                            hashMap2.put((Object[])object4, (Object[])object9);
                        } else {
                            n19 = 14;
                            n20 = 94;
                            f10 = 1.32E-43f;
                        }
                        arrayList.add(hashMap2);
                        n17 = n19;
                        n19 = n20;
                        n14 = 83;
                        n13 = 99;
                        n18 = 25;
                        n20 = 96;
                        f10 = 1.35E-43f;
                        n21 = 93;
                    }
                    n12 = 113;
                    object = Strings.getString(n12);
                    hashMap.put(object, arrayList);
                }
            }
            return hashMap;
        }
        catch (Throwable throwable) {
            MobLog.getInstance().d(throwable);
            return null;
        }
    }

    /*
     * Loose catch block
     */
    public String getIMEI() {
        Object object;
        block39: {
            Object object2;
            Object object3;
            block40: {
                int n10;
                block38: {
                    String string2;
                    int n11;
                    block36: {
                        block37: {
                            Object object4;
                            block35: {
                                boolean bl2;
                                block34: {
                                    object = this.imei;
                                    bl2 = TextUtils.isEmpty((CharSequence)object);
                                    if (!bl2) {
                                        return this.imei;
                                    }
                                    object = this.getSystemServiceSafe("phone");
                                    object3 = null;
                                    if (object == null) {
                                        return null;
                                    }
                                    object2 = "android.permission.READ_PHONE_STATE";
                                    n11 = this.checkPermission((String)object2);
                                    if (n11 == 0) break block34;
                                    n11 = Build.VERSION.SDK_INT;
                                    n10 = 29;
                                    if (n11 >= n10) break block34;
                                    n11 = 8;
                                    object2 = Strings.getString(n11);
                                    n10 = 0;
                                    object4 = null;
                                    object4 = new Object[]{};
                                    object = ReflectHelper.invokeInstanceMethod(object, (String)object2, object4);
                                    try {
                                        object = (String)object;
                                        break block35;
                                    }
                                    catch (Throwable throwable) {
                                        object2 = MobLog.getInstance();
                                        object = throwable.getMessage();
                                        ((NLog)object2).w((String)object);
                                    }
                                }
                                bl2 = false;
                                object = null;
                            }
                            n11 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                            n10 = 1;
                            string2 = "comm/.di";
                            if (n11 == 0) break block36;
                            object2 = this.context;
                            object2 = ResHelper.getCacheRootFile((Context)object2, string2);
                            if (object2 == null) break block37;
                            boolean bl3 = ((File)object2).exists();
                            if (!bl3) break block37;
                            object4 = new FileInputStream((File)object2);
                            object2 = new ObjectInputStream((InputStream)object4);
                            object4 = ((ObjectInputStream)object2).readObject();
                            if (object4 != null && (bl3 = object4 instanceof char[])) {
                                object4 = (char[])object4;
                                object3 = String.valueOf((char[])object4);
                            }
                            ((ObjectInputStream)object2).close();
                            return object3;
                        }
                        return this.getWAbcd(n10);
                    }
                    this.imei = object;
                    object3 = this.context;
                    object3 = ResHelper.getCacheRootFile((Context)object3, string2);
                    if (object3 == null) break block38;
                    n11 = (int)(((File)object3).exists() ? 1 : 0);
                    if (n11 == 0) break block38;
                    ((File)object3).delete();
                }
                object2 = new FileOutputStream((File)object3);
                object3 = new ObjectOutputStream((OutputStream)object2);
                object2 = ((String)object).toCharArray();
                ((ObjectOutputStream)object3).writeObject(object2);
                ((ObjectOutputStream)object3).flush();
                ((ObjectOutputStream)object3).close();
                try {
                    this.saveWabcd((String)object, n10);
                    break block39;
                }
                catch (Throwable throwable) {
                    object3 = object;
                    object = throwable;
                }
                {
                    break block40;
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
            }
            object2 = MobLog.getInstance();
            ((NLog)object2).w((Throwable)object);
            object = object3;
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ArrayList getIMList() {
        ArrayList arrayList;
        Object object;
        Object object2;
        block5: {
            object2 = null;
            object = "input_method";
            try {
                object = this.getSystemServiceSafe((String)object);
                object = (InputMethodManager)object;
                object = object.getInputMethodList();
                arrayList = new ArrayList();
            }
            catch (Throwable throwable) {
                arrayList = null;
                object2 = throwable;
                break block5;
            }
            try {
                boolean bl2;
                object2 = object.iterator();
                while (bl2 = object2.hasNext()) {
                    object = object2.next();
                    if ((object = (InputMethodInfo)object) == null) continue;
                    HashMap<String, Object> hashMap = new HashMap<String, Object>();
                    Object object3 = this.context;
                    object3 = object3.getPackageManager();
                    object3 = object.loadLabel((PackageManager)object3);
                    String string2 = "name";
                    hashMap.put(string2, object3);
                    object3 = "pkg";
                    object = object.getPackageName();
                    hashMap.put((String)object3, object);
                    arrayList.add(hashMap);
                }
                return arrayList;
            }
            catch (Throwable throwable) {}
        }
        object = MobLog.getInstance();
        ((NLog)object).d((Throwable)object2);
        return arrayList;
    }

    public String getIMSI() {
        Object object;
        int n10;
        Object[] objectArray;
        int n11;
        int n12;
        boolean bl2;
        Object object2;
        block12: {
            boolean bl3;
            block11: {
                object2 = this.bvs.isi;
                bl3 = TextUtils.isEmpty((CharSequence)object2);
                if (!bl3) {
                    return this.bvs.isi;
                }
                object2 = this.getSystemServiceSafe("phone");
                if (object2 == null) {
                    return null;
                }
                bl2 = false;
                n12 = Build.VERSION.SDK_INT;
                n11 = 29;
                if (n12 >= n11) break block11;
                Object object3 = "android.permission.READ_PHONE_STATE";
                n12 = (int)(this.checkPermission((String)object3) ? 1 : 0);
                if (n12 == 0) break block11;
                n12 = 25;
                object3 = Strings.getString(n12);
                objectArray = new Object[]{};
                object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object3, objectArray);
                try {
                    object2 = (String)object2;
                    break block12;
                }
                catch (Throwable throwable) {
                    object3 = MobLog.getInstance();
                    object2 = throwable.getMessage();
                    ((NLog)object3).w((String)object2);
                }
            }
            bl3 = false;
            object2 = null;
        }
        n12 = 15;
        if ((object2 == null || (n11 = ((String)object2).length()) < n12) && (objectArray = this.queryIMSI()) != null && (n10 = objectArray.length) > 0 && (n10 = ((String)(object = objectArray[0])).length()) >= n12) {
            object2 = objectArray[0];
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)object2)) {
            return null;
        }
        this.bvs.isi = object2;
        return object2;
    }

    /*
     * Unable to fully structure code
     */
    public String getIPAddress() {
        block14: {
            var1_1 = "android.permission.INTERNET";
            var2_3 = this.checkPermission((String)var1_1);
            if (!var2_3) break block14;
            var1_1 = NetworkInterface.getNetworkInterfaces();
            block12: while (true) {
                var3_4 = var1_1.hasMoreElements();
                if (!var3_4) break block14;
                var4_5 = var1_1.nextElement();
                var4_5 = (NetworkInterface)var4_5;
                var4_5 = var4_5.getInetAddresses();
                do {
                    var5_6 = var4_5.hasMoreElements();
                    if (!var5_6) continue block12;
                    var6_7 = var4_5.nextElement();
                    ** try [egrp 8[TRYBLOCK] [8 : 74->79)] { 
lbl24:
                    // 1 sources

                    ** try [egrp 9[TRYBLOCK] [9 : 81->86)] { 
lbl25:
                    // 1 sources

                } while ((var7_8 = var6_7.isLoopbackAddress()) || !(var7_8 = var6_7 instanceof Inet4Address));
                break;
            }
            try {
                return var6_7.getHostAddress();
            }
lbl28:
            // 11 sources

            catch (Throwable var1_2) {
                var4_5 = MobLog.getInstance();
                var4_5.w(var1_2);
            }
        }
        return "0.0.0.0";
    }

    public List getIntent(String string2) {
        int n10;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        ArrayList<Object[]> arrayList = null;
        if (bl2) {
            return null;
        }
        Object object = new Intent();
        string2 = Uri.parse((String)string2);
        object.setData((Uri)string2);
        Object object2 = this.context.getPackageManager();
        object = object2.queryIntentServices((Intent)object, 0);
        if (object != null && (n10 = object.isEmpty()) == 0) {
            arrayList = new ArrayList<Object[]>();
            object = object.iterator();
            while ((n10 = object.hasNext()) != 0) {
                object2 = (ResolveInfo)object.next();
                Intent intent = new Intent();
                intent.setData((Uri)string2);
                Object object3 = object2.serviceInfo;
                String string3 = object3.packageName;
                object3 = object3.name;
                Object[] objectArray = new ComponentName(string3, (String)object3);
                intent.setComponent((ComponentName)objectArray);
                int n11 = 3;
                objectArray = new Object[n11];
                object2 = object2.serviceInfo;
                object3 = object2.packageName;
                objectArray[0] = object3;
                int n12 = 1;
                object2 = object2.name;
                objectArray[n12] = object2;
                n10 = 2;
                objectArray[n10] = intent;
                arrayList.add(objectArray);
            }
        }
        return arrayList;
    }

    public List getIntentA(String string2) {
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        ArrayList<Object[]> arrayList = null;
        if (bl3) {
            return null;
        }
        Object object = new Intent();
        string2 = Uri.parse((String)string2);
        object.setData((Uri)string2);
        Object object2 = this.context.getPackageManager();
        object = object2.queryIntentActivities((Intent)object, 0);
        if (object != null && !(bl2 = object.isEmpty())) {
            arrayList = new ArrayList<Object[]>();
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                object2 = (ResolveInfo)object.next();
                Intent intent = new Intent();
                int n10 = 0x10800000;
                intent.setFlags(n10);
                intent.setData((Uri)string2);
                String string3 = object2.activityInfo.packageName;
                string3 = this.getSignMD5(string3);
                Object object3 = object2.activityInfo;
                String string4 = object3.packageName;
                object3 = object3.name;
                Object[] objectArray = new ComponentName(string4, (String)object3);
                intent.setComponent((ComponentName)objectArray);
                int n11 = 5;
                objectArray = new Object[n11];
                object2 = object2.activityInfo;
                object3 = object2.packageName;
                objectArray[0] = object3;
                string4 = object2.name;
                objectArray[1] = string4;
                int n12 = 2;
                objectArray[n12] = intent;
                objectArray[3] = string3;
                int n13 = 4;
                bl2 = object2.exported;
                object2 = bl2;
                objectArray[n13] = object2;
                arrayList.add(objectArray);
            }
        }
        return arrayList;
    }

    public List getIntentSP(String iterator2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)((Object)iterator2));
        int n10 = 0;
        Object object = null;
        if (bl2) {
            return null;
        }
        Object object2 = new Intent();
        object2.setPackage((String)((Object)iterator2));
        iterator2 = this.context.getPackageManager().queryIntentServices((Intent)object2, 0);
        if (iterator2 != null && !(bl2 = iterator2.isEmpty())) {
            object2 = new ArrayList();
            iterator2 = iterator2.iterator();
            while ((n10 = iterator2.hasNext()) != 0) {
                object = (ResolveInfo)iterator2.next();
                Intent intent = new Intent();
                Object[] objectArray = object.serviceInfo;
                String string2 = objectArray.packageName;
                objectArray = objectArray.name;
                Object object3 = new ComponentName(string2, (String)objectArray);
                intent.setComponent(object3);
                object3 = object.serviceInfo.packageName;
                object3 = this.getSignMD5((String)object3);
                int n11 = 4;
                objectArray = new Object[n11];
                object = object.serviceInfo;
                string2 = object.packageName;
                objectArray[0] = string2;
                int n12 = 1;
                object = object.name;
                objectArray[n12] = object;
                objectArray[2] = intent;
                n10 = 3;
                objectArray[n10] = object3;
                object2.add(objectArray);
            }
            return object2;
        }
        return null;
    }

    public String getLN() {
        block13: {
            Object object;
            Object object2;
            block15: {
                block14: {
                    object2 = "android.permission.READ_PHONE_STATE";
                    boolean bl2 = this.checkPermission((String)object2);
                    if (!bl2) break block13;
                    object2 = "-1";
                    object = this.ln;
                    bl2 = ((String)object2).equals(object);
                    if (bl2) break block14;
                    bl2 = this.isSensitiveDevice();
                    if (!bl2) break block14;
                    return this.ln;
                }
                object2 = "phone";
                object2 = this.getSystemServiceSafe((String)object2);
                if (object2 != null) break block15;
                return this.ln;
            }
            int n10 = 15;
            object = Strings.getString(n10);
            Object[] objectArray = null;
            objectArray = new Object[]{};
            object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object, objectArray);
            object2 = (String)object2;
            try {
                this.ln = object2;
                return object2;
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).w(throwable);
            }
        }
        return this.ln;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ArrayList getLocalIpInfo() {
        ArrayList arrayList = "android.permission.INTERNET";
        try {
            boolean bl2 = this.checkPermission((String)((Object)arrayList));
            if (!bl2) return null;
            arrayList = new ArrayList();
            Iterator iterator2 = NetworkInterface.getNetworkInterfaces();
            iterator2 = Collections.list(iterator2);
            HashMap hashMap = this.listNetworkHardware();
            iterator2 = iterator2.iterator();
            while (true) {
                int n10;
                int n11;
                boolean bl3;
                boolean bl4;
                if (!(bl4 = iterator2.hasNext())) {
                    return arrayList;
                }
                Object object = iterator2.next();
                object = (NetworkInterface)object;
                HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
                ArrayList arrayList2 = ((NetworkInterface)object).getName();
                Object object2 = "name";
                hashMap2.put(object2, arrayList2);
                object2 = "mac";
                if (hashMap != null && !(bl3 = hashMap.isEmpty()) && (bl3 = hashMap.containsKey(arrayList2))) {
                    arrayList2 = hashMap.get(arrayList2);
                    hashMap2.put(object2, arrayList2);
                } else {
                    arrayList2 = (ArrayList)((NetworkInterface)object).getHardwareAddress();
                    arrayList2 = this.byteToHex((byte[])arrayList2);
                    hashMap2.put(object2, arrayList2);
                }
                if ((object = ((NetworkInterface)object).getInterfaceAddresses()) == null || (n11 = object.size()) <= 0) continue;
                arrayList2 = new ArrayList();
                object = object.iterator();
                while ((n10 = object.hasNext()) != 0) {
                    object2 = object.next();
                    object2 = (InterfaceAddress)object2;
                    HashMap<Object, Object> hashMap3 = new HashMap<Object, Object>();
                    HashMap<String, Object> hashMap4 = ((InterfaceAddress)object2).getAddress();
                    String string2 = "haddr";
                    Object object3 = ((InetAddress)((Object)hashMap4)).getHostAddress();
                    hashMap3.put(string2, object3);
                    string2 = "hname";
                    object3 = ((InetAddress)((Object)hashMap4)).getHostName();
                    hashMap3.put(string2, object3);
                    string2 = "lp";
                    boolean bl5 = ((InetAddress)((Object)hashMap4)).isLoopbackAddress();
                    object3 = bl5;
                    hashMap3.put(string2, object3);
                    string2 = "addr";
                    object3 = ((InetAddress)((Object)hashMap4)).getAddress();
                    object3 = this.byteToHex((byte[])object3);
                    hashMap3.put(string2, object3);
                    string2 = "len";
                    hashMap4 = (HashMap<String, Object>)((InetAddress)((Object)hashMap4)).getAddress();
                    int n12 = ((Object)hashMap4).length;
                    hashMap4 = n12;
                    hashMap3.put(string2, hashMap4);
                    object2 = ((InterfaceAddress)object2).getBroadcast();
                    if (object2 != null) {
                        hashMap4 = new HashMap<String, Object>();
                        string2 = "haddrB";
                        object3 = ((InetAddress)object2).getHostAddress();
                        hashMap4.put(string2, object3);
                        string2 = "hnameB";
                        object3 = ((InetAddress)object2).getHostName();
                        hashMap4.put(string2, object3);
                        string2 = "lpB";
                        bl5 = ((InetAddress)object2).isLoopbackAddress();
                        object3 = bl5;
                        hashMap4.put(string2, object3);
                        string2 = "addrB";
                        object3 = ((InetAddress)object2).getAddress();
                        object3 = this.byteToHex((byte[])object3);
                        hashMap4.put(string2, object3);
                        string2 = "lenB";
                        object2 = ((InetAddress)object2).getAddress();
                        n10 = ((Object)object2).length;
                        object2 = n10;
                        hashMap4.put(string2, object2);
                        object2 = "broadcast";
                        hashMap3.put(object2, hashMap4);
                    }
                    arrayList2.add(hashMap3);
                }
                object = "inets";
                hashMap2.put(object, arrayList2);
                arrayList.add(hashMap2);
            }
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
        }
        return null;
    }

    public Location getLocation(int n10, int n11, boolean bl2) {
        block8: {
            Object object;
            block7: {
                object = "android.permission.ACCESS_FINE_LOCATION";
                int n12 = this.checkPermission((String)object);
                if (n12 != 0) break block7;
                n12 = Build.VERSION.SDK_INT;
                int n13 = 29;
                if (n12 < n13) break block8;
                object = "android.permission.ACCESS_BACKGROUND_LOCATION";
                n12 = (int)(this.checkPermission((String)object) ? 1 : 0);
                if (n12 == 0) break block8;
            }
            object = LHelper.getInstance();
            Context context = this.context;
            try {
                return ((LHelper)object).getLocation(context, n10, n11, bl2);
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.d(throwable);
            }
        }
        return null;
    }

    public String getMCC() {
        int n10;
        int n11;
        String string2 = this.getIMSI();
        if (string2 != null && (n11 = string2.length()) >= (n10 = 3)) {
            return string2.substring(0, n10);
        }
        return null;
    }

    public String getMIUIVersion() {
        String string2 = this.bufUiVersion;
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 == 0) {
            return this.bufUiVersion;
        }
        n10 = 65;
        string2 = Strings.getString(n10);
        boolean bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.getSystemProperties(string2)));
        if (bl2) {
            n10 = 66;
            string2 = Strings.getString(n10);
            string2 = this.getSystemProperties(string2);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)string2)) {
            n10 = 67;
            string2 = Strings.getString(n10);
            string2 = this.getSystemProperties(string2);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)string2)) {
            n10 = 135;
            string2 = Strings.getString(n10);
            string2 = this.getSystemProperties(string2);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)string2)) {
            n10 = 136;
            string2 = Strings.getString(n10);
            string2 = this.getSystemProperties(string2);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)string2)) {
            n10 = 69;
            string2 = Strings.getString(n10);
            string2 = this.getSystemProperties(string2);
        }
        this.bufUiVersion = string2;
        return string2;
    }

    public String getMNC() {
        int n10;
        int n11;
        String string2 = this.getIMSI();
        if (string2 != null && (n11 = string2.length()) >= (n10 = 5)) {
            return string2.substring(3, n10);
        }
        return null;
    }

    public String getMacAddress() {
        String string2 = this.wifimac;
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 == 0) {
            return this.wifimac;
        }
        string2 = this.getLocalWifiMac();
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 == 0 && (n11 = this.checkMacIsValid(string2)) != 0) {
            this.wifimac = string2;
            return string2;
        }
        n10 = Build.VERSION.SDK_INT;
        n11 = 23;
        if (n10 >= n11) {
            String string3;
            string2 = this.getWlanMac();
            if (string2 != null && (n11 = (int)(TextUtils.isEmpty((CharSequence)(string3 = string2.trim())) ? 1 : 0)) == 0) {
                return string2.trim();
            }
            return this.getWifiMac();
        }
        string2 = this.getWifiMac();
        if (string2 != null && (n11 = (int)(this.checkMacIsValid(string2) ? 1 : 0)) != 0) {
            this.wifimac = string2 = string2.trim();
            this.saveLocalWifiMac(string2);
            return this.wifimac;
        }
        return this.getWlanMac();
    }

    public String getManufacturer() {
        return Build.MANUFACTURER;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public HashMap getMemoryInfo() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        long l10 = -1;
        Object object = l10;
        String string2 = "available";
        hashMap.put(string2, object);
        String string3 = "total";
        hashMap.put(string3, object);
        String string4 = "isLow";
        hashMap.put(string4, object);
        String string5 = "threshold";
        hashMap.put(string5, object);
        int n10 = 30;
        try {
            object = Strings.getString(n10);
        }
        catch (Throwable throwable) {
            return hashMap;
        }
        object = this.getSystemServiceSafe((String)object);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        int n11 = 64;
        String string6 = Strings.getString(n11);
        int n12 = 1;
        Object[] objectArray = new Object[n12];
        objectArray[0] = memoryInfo;
        ReflectHelper.invokeInstanceMethod(object, string6, objectArray);
        long l11 = memoryInfo.availMem;
        object = l11;
        hashMap.put(string2, object);
        l10 = memoryInfo.totalMem;
        object = l10;
        hashMap.put(string3, object);
        n10 = (int)(memoryInfo.lowMemory ? 1 : 0);
        l10 = n10 != 0 ? 1L : 0L;
        object = l10;
        hashMap.put(string4, object);
        l10 = memoryInfo.threshold;
        object = l10;
        hashMap.put(string5, object);
        return hashMap;
    }

    public String getModel() {
        String string2 = this.bufModel;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            return this.bufModel;
        }
        string2 = Build.MODEL;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3) {
            string2 = string2.trim();
        }
        this.bufModel = string2;
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ArrayList getNeighboringCellInfo() {
        Iterator iterator2 = "android.permission.ACCESS_COARSE_LOCATION";
        try {
            int n10;
            int n11 = this.checkPermission((String)((Object)iterator2));
            if (n11 == 0 || (n11 = this.isScopedStorage()) != 0) return null;
            iterator2 = "phone";
            if ((iterator2 = this.getSystemServiceSafe((String)((Object)iterator2))) == null) return null;
            int n12 = 61;
            ArrayList<Object> arrayList = Strings.getString(n12);
            Object object = new Object[]{};
            iterator2 = ReflectHelper.invokeInstanceMethod((Object)iterator2, (String)((Object)arrayList), (Object[])object);
            if ((iterator2 = (List)((Object)iterator2)) == null || (n12 = iterator2.size()) <= 0) return null;
            arrayList = new ArrayList<Object>();
            iterator2 = iterator2.iterator();
            while ((n10 = iterator2.hasNext()) != 0) {
                object = iterator2.next();
                int n13 = 27;
                Object object2 = Strings.getString(n13);
                Object object3 = new Object[]{};
                object2 = ReflectHelper.invokeInstanceMethod(object, (String)object2, (Object[])object3);
                int n14 = -1;
                Object object4 = n14;
                object2 = ResHelper.forceCast(object2, object4);
                object2 = (Integer)object2;
                n13 = (Integer)object2;
                int n15 = 28;
                object4 = Strings.getString(n15);
                Object object5 = new Object[]{};
                object4 = ReflectHelper.invokeInstanceMethod(object, (String)object4, (Object[])object5);
                object5 = n14;
                object4 = ResHelper.forceCast(object4, object5);
                object4 = (Integer)object4;
                n15 = (Integer)object4;
                int n16 = 62;
                object5 = Strings.getString(n16);
                Object object6 = new Object[]{};
                object5 = ReflectHelper.invokeInstanceMethod(object, (String)object5, (Object[])object6);
                object6 = n14;
                object5 = ResHelper.forceCast(object5, object6);
                object5 = (Integer)object5;
                n16 = (Integer)object5;
                int n17 = 63;
                object6 = Strings.getString(n17);
                Object object7 = new Object[]{};
                object6 = ReflectHelper.invokeInstanceMethod(object, (String)object6, object7);
                object7 = n14;
                object6 = ResHelper.forceCast(object6, object7);
                object6 = (Integer)object6;
                n17 = (Integer)object6;
                int n18 = 19;
                object7 = Strings.getString(n18);
                Object[] objectArray = new Object[]{};
                object = ReflectHelper.invokeInstanceMethod(object, (String)object7, objectArray);
                object7 = n14;
                object = ResHelper.forceCast(object, object7);
                object = (Integer)object;
                n10 = (Integer)object;
                if (n13 == n14 || n15 == n14) continue;
                object3 = new HashMap();
                object7 = "cell";
                object2 = n13;
                ((HashMap)object3).put(object7, object2);
                object2 = "lac";
                object4 = n15;
                ((HashMap)object3).put(object2, object4);
                object2 = "rssi";
                object4 = n16;
                ((HashMap)object3).put(object2, object4);
                object2 = "psc";
                object4 = n17;
                ((HashMap)object3).put(object2, object4);
                object2 = "networkType";
                object = n10;
                ((HashMap)object3).put(object2, object);
                arrayList.add(object3);
            }
            n11 = arrayList.size();
            if (n11 <= 0) return null;
            return arrayList;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
        }
        return null;
    }

    public String getNetworkOperator() {
        Object[] objectArray;
        String string2;
        Object object = this.getSystemServiceSafe("phone");
        if (object == null) {
            return null;
        }
        int n10 = 21;
        try {
            string2 = Strings.getString(n10);
            objectArray = null;
        }
        catch (Throwable throwable) {
            MobLog.getInstance().w(throwable);
            return null;
        }
        objectArray = new Object[]{};
        object = ReflectHelper.invokeInstanceMethod(object, string2, objectArray);
        return (String)object;
    }

    public String getNetworkType() {
        return NtFetcher.getInstance(this.context).getNtType();
    }

    public String getNetworkTypeForStatic() {
        String string2 = this.getNetworkType().toLowerCase();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = "none";
        if (!bl2 && !(bl2 = string3.equals(string2))) {
            String string4 = "5g";
            bl2 = string2.startsWith(string4);
            if (!(bl2 || (bl2 = string2.startsWith(string4 = "4g")) || (bl2 = string2.startsWith(string4 = "3g")) || (bl2 = string2.startsWith(string4 = "2g")))) {
                string4 = "wifi";
                boolean bl3 = string2.startsWith(string4);
                if (bl3) {
                    return string4;
                }
                return "other";
            }
            return "cell";
        }
        return string3;
    }

    public String getOSCountry() {
        return Locale.getDefault().getCountry();
    }

    public String getOSLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public int getOSVersionInt() {
        return Build.VERSION.SDK_INT;
    }

    public String getOSVersionName() {
        try {
            return Build.VERSION.RELEASE;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public String getPackageName() {
        return this.context.getPackageName();
    }

    public int getPlatformCode() {
        return 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String getProcessor() {
        NLog nLog;
        BufferedReader bufferedReader;
        Object object2;
        Object object;
        block15: {
            Object object3;
            object = null;
            try {
                int n10 = 41;
                object2 = Strings.getString(n10);
                object3 = new FileReader((String)object2);
                bufferedReader = new BufferedReader((Reader)object3);
                object3 = "Processor\\s*:\\s*(.*)";
            }
            catch (Throwable throwable) {
                bufferedReader = null;
                break block15;
            }
            try {
                object3 = Pattern.compile((String)object3);
                while ((object2 = bufferedReader.readLine()) != null) {
                    int n11 = (int)(((Matcher)(object2 = ((Pattern)object3).matcher((CharSequence)object2))).matches() ? 1 : 0);
                    if (n11 == 0) continue;
                    n11 = 1;
                    object = ((Matcher)object2).group(n11);
                }
            }
            catch (Throwable throwable) {
                BufferedReader bufferedReader2 = bufferedReader;
                bufferedReader = object;
                object = bufferedReader2;
                break block15;
            }
            try {
                bufferedReader.close();
                return object;
            }
            catch (IOException iOException) {
                object3 = MobLog.getInstance();
                ((NLog)object3).d(iOException);
                return object;
            }
        }
        try {
            object2 = MobLog.getInstance();
            ((NLog)object2).d((Throwable)((Object)nLog));
            object = bufferedReader;
            return object;
        }
        finally {
            if (object != null) {
                try {
                    ((BufferedReader)object).close();
                }
                catch (IOException iOException) {
                    nLog = MobLog.getInstance();
                    nLog.d(iOException);
                }
            }
        }
    }

    public int getPsc() {
        int n10;
        block16: {
            n10 = -1;
            Object object = "android.permission.ACCESS_COARSE_LOCATION";
            boolean bl2 = this.checkPermission((String)object);
            if (!bl2) break block16;
            object = "phone";
            object = this.getSystemServiceSafe((String)object);
            if (object == null) break block16;
            int n11 = 26;
            Object object2 = Strings.getString(n11);
            Object[] objectArray = null;
            Object object3 = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(object, (String)object2, (Object[])object3);
            if (object == null) break block16;
            object2 = "CdmaCellLocation";
            object3 = object.getClass();
            object3 = ((Class)object3).getSimpleName();
            n11 = (int)(((String)object2).equals(object3) ? 1 : 0);
            if (n11 != 0) break block16;
            n11 = 63;
            object2 = Strings.getString(n11);
            objectArray = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
            object2 = n10;
            object = ResHelper.forceCast(object, object2);
            object = (Integer)object;
            try {
                return (Integer)object;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
        }
        return n10;
    }

    public String getQemuKernel() {
        Object object = "0";
        int n10 = 9;
        Object object2 = Strings.getString(n10);
        object2 = ReflectHelper.importClass((String)object2);
        int n11 = 10;
        Object object3 = Strings.getString(n11);
        int n12 = 2;
        Object[] objectArray = new Object[n12];
        int n13 = 0;
        int n14 = 53;
        String string2 = Strings.getString(n14);
        objectArray[0] = string2;
        n13 = 1;
        objectArray[n13] = object;
        object2 = ReflectHelper.invokeStaticMethod((String)object2, (String)object3, objectArray);
        try {
            object = object2 = (String)object2;
        }
        catch (Throwable throwable) {
            object3 = MobLog.getInstance();
            ((NLog)object3).d(throwable);
        }
        return object;
    }

    public List getResolvePkgs(String iterator2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)((Object)iterator2));
        boolean bl3 = false;
        Object object = null;
        if (bl2) {
            return null;
        }
        Object object2 = new Intent();
        iterator2 = Uri.parse((String)((Object)iterator2));
        object2.setData((Uri)iterator2);
        iterator2 = this.context.getPackageManager();
        boolean bl4 = false;
        Object object3 = null;
        iterator2 = iterator2.queryIntentActivities((Intent)object2, 0);
        if (iterator2 != null && !(bl2 = iterator2.isEmpty())) {
            object2 = new ArrayList();
            iterator2 = iterator2.iterator();
            while (bl3 = iterator2.hasNext()) {
                object = (ResolveInfo)iterator2.next();
                object3 = object.activityInfo;
                if (object3 == null || (object3 = object3.packageName) == null || (bl4 = object2.contains(object3))) continue;
                object = object.activityInfo.packageName;
                object2.add(object);
            }
            return object2;
        }
        return null;
    }

    public ArrayList getSA() {
        boolean bl2 = true;
        return this.getAL(bl2, bl2);
    }

    public String getSSID() {
        block23: {
            Object object;
            Object object2;
            block25: {
                boolean bl2;
                block24: {
                    block22: {
                        object2 = "-1";
                        object = this.bvs;
                        object = ((BVS)object).ssi;
                        bl2 = ((String)object2).equals(object);
                        if (bl2) break block22;
                        object2 = this.bvs;
                        return ((BVS)object2).ssi;
                    }
                    object2 = "android.permission.ACCESS_WIFI_STATE";
                    bl2 = this.checkPermission((String)object2);
                    if (!bl2) break block23;
                    object2 = "wifi";
                    object2 = this.getSystemServiceSafe((String)object2);
                    if (object2 != null) break block24;
                    object2 = this.bvs;
                    ((BVS)object2).ssi = null;
                    return null;
                }
                int n10 = 2;
                object = Strings.getString(n10);
                Object object3 = null;
                Object object4 = new Object[]{};
                object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object, object4);
                if (object2 == null) break block23;
                n10 = 3;
                object = Strings.getString(n10);
                object3 = new Object[]{};
                object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object, object3);
                object2 = (String)object2;
                object = this.bvs;
                if (object2 == null) {
                    bl2 = false;
                    object2 = null;
                    break block25;
                }
                object3 = "\"";
                object4 = "";
                object2 = ((String)object2).replace((CharSequence)object3, (CharSequence)object4);
            }
            ((BVS)object).ssi = object2;
            object2 = this.bvs;
            try {
                return ((BVS)object2).ssi;
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).d(throwable);
            }
        }
        return null;
    }

    public int getScreenBrightness() {
        int n10;
        Context context = this.context;
        context = context.getContentResolver();
        Object object = "screen_brightness";
        try {
            n10 = Settings.System.getInt((ContentResolver)context, (String)object);
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).w(throwable);
            n10 = -1;
        }
        return n10;
    }

    public int getScreenBrightnessMode() {
        int n10;
        Context context = this.context;
        context = context.getContentResolver();
        Object object = "screen_brightness_mode";
        try {
            n10 = Settings.System.getInt((ContentResolver)context, (String)object);
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).w(throwable);
            n10 = -1;
        }
        return n10;
    }

    public String getScreenSize() {
        int[] nArray = ResHelper.getScreenSize(this.context);
        Object object = this.context.getResources().getConfiguration();
        int n10 = ((Configuration)object).orientation;
        int n11 = 0;
        String string2 = "x";
        int n12 = 1;
        if (n10 == n12) {
            object = new StringBuilder();
            n11 = nArray[0];
            ((StringBuilder)object).append(n11);
            ((StringBuilder)object).append(string2);
            int n13 = nArray[n12];
            ((StringBuilder)object).append(n13);
            return ((StringBuilder)object).toString();
        }
        object = new StringBuilder();
        n12 = nArray[n12];
        ((StringBuilder)object).append(n12);
        ((StringBuilder)object).append(string2);
        int n14 = nArray[0];
        ((StringBuilder)object).append(n14);
        return ((StringBuilder)object).toString();
    }

    /*
     * Unable to fully structure code
     */
    public String getSdcardPath() {
        var1_1 = null;
        try {
            var2_2 = this.bvs;
        }
        catch (Throwable v0) {
            ** continue;
        }
        var2_2 = var2_2.sdp;
        var3_3 = TextUtils.isEmpty((CharSequence)var2_2);
        if (var3_3 != 0) ** GOTO lbl15
        var2_2 = this.bvs;
        return var2_2.sdp;
lbl15:
        // 1 sources

        var3_3 = Build.VERSION.SDK_INT;
        var4_4 = 29;
        if (var3_3 < var4_4) ** GOTO lbl36
        var2_2 = this.context;
        var2_2 = var2_2.getApplicationInfo();
        var3_3 = var2_2.targetSdkVersion;
        if (var3_3 < var4_4) ** GOTO lbl36
        var2_2 = this.bvs;
        var5_5 = this.context;
        var5_5 = var5_5.getExternalFilesDir(null);
        var5_5 = var5_5.getAbsolutePath();
        var2_2.sdp = var5_5;
        ** GOTO lbl43
lbl36:
        // 2 sources

        var2_2 = this.bvs;
        var5_6 = Environment.getExternalStorageDirectory();
        var5_6 = var5_6.getAbsolutePath();
        var2_2.sdp = var5_6;
lbl43:
        // 2 sources

        var2_2 = this.bvs;
        var1_1 = var2_2.sdp;
lbl46:
        // 2 sources

        return var1_1;
    }

    public boolean getSdcardState() {
        boolean bl2 = this.hasSdcardWritePermission;
        if (!bl2) {
            Object object;
            block7: {
                String string2;
                block6: {
                    string2 = "android.permission.WRITE_EXTERNAL_STORAGE";
                    bl2 = this.checkPermission(string2);
                    if (!bl2) break block6;
                    string2 = "mounted";
                    object = Environment.getExternalStorageState();
                    bl2 = string2.equals(object);
                    if (!bl2) break block6;
                    bl2 = true;
                    break block7;
                }
                bl2 = false;
                string2 = null;
            }
            try {
                this.hasSdcardWritePermission = bl2;
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).w(throwable);
            }
        }
        return this.hasSdcardWritePermission;
    }

    public String getSerialno() {
        Object object;
        Object object2;
        String string2;
        String string3;
        boolean bl2;
        int n10;
        block25: {
            Object object3;
            int n11;
            int n12;
            Object object4;
            block24: {
                n10 = Build.VERSION.SDK_INT;
                object4 = this.serialno;
                bl2 = TextUtils.isEmpty((CharSequence)object4);
                if (!bl2) {
                    return this.serialno;
                }
                bl2 = false;
                object4 = null;
                n12 = 9;
                string3 = "unknown";
                string2 = null;
                if (n10 >= n12 && n10 < (n11 = 26)) {
                    object2 = Strings.getString(n12);
                    object2 = ReflectHelper.importClass((String)object2);
                    n11 = 10;
                    object3 = Strings.getString(n11);
                    int n13 = 2;
                    Object[] objectArray = new Object[n13];
                    int n14 = 11;
                    String string4 = Strings.getString(n14);
                    objectArray[0] = string4;
                    n14 = 1;
                    objectArray[n14] = string3;
                    object2 = ReflectHelper.invokeStaticMethod((String)object2, (String)object3, objectArray);
                    try {
                        object2 = (String)object2;
                        break block24;
                    }
                    catch (Throwable throwable) {
                        object3 = MobLog.getInstance();
                        ((NLog)object3).d(throwable);
                    }
                }
                n12 = 0;
                object2 = null;
            }
            n11 = (int)(TextUtils.isEmpty(object2) ? 1 : 0);
            if (n11 != 0 || (n11 = (int)(string3.equalsIgnoreCase((String)object2) ? 1 : 0)) != 0) {
                object2 = Build.SERIAL;
            }
            if ((n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0)) != 0 || (n11 = (int)(string3.equalsIgnoreCase((String)object2) ? 1 : 0)) != 0) {
                object3 = "android.permission.READ_PHONE_STATE";
                n11 = (int)(this.checkPermission((String)object3) ? 1 : 0);
                if (n11 == 0 || n10 >= (n11 = 29)) break block25;
                object = "android.os.Build";
                object = ReflectHelper.importClass((String)object);
                object2 = "getSerial";
                object4 = new Object[]{};
                object = ReflectHelper.invokeStaticMethod((String)object, (String)object2, object4);
                try {
                    object2 = object = (String)object;
                }
                catch (Throwable throwable) {
                    object4 = MobLog.getInstance();
                    object = throwable.getMessage();
                    object4.w((String)object);
                    n12 = 0;
                    object2 = null;
                }
            }
        }
        if ((n10 = (int)(string3.equalsIgnoreCase((String)object2) ? 1 : 0)) == 0) {
            string2 = object2;
        }
        n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n10 != 0) {
            object = this.getLocalSerial();
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (!bl2) {
                return object;
            }
        } else {
            this.serialno = string2;
            string2 = string2.trim();
            this.saveLocalSerial(string2);
        }
        return string2;
    }

    public String getSignMD5() {
        Object object;
        try {
            object = this.context;
        }
        catch (Exception exception) {
            MobLog.getInstance().w(exception);
            return null;
        }
        object = object.getPackageManager();
        String string2 = this.getPackageName();
        int n10 = 64;
        object = object.getPackageInfo(string2, n10);
        object = object.signatures;
        string2 = null;
        object = object[0];
        object = object.toByteArray();
        return Data.MD5((byte[])object);
    }

    public String getSignMD5(String object) {
        Context context;
        try {
            context = this.context;
        }
        catch (Exception exception) {
            MobLog.getInstance().w(exception);
            return null;
        }
        context = context.getPackageManager();
        int n10 = 64;
        object = context.getPackageInfo((String)object, n10);
        object = object.signatures;
        context = null;
        object = object[0];
        object = object.toByteArray();
        return Data.MD5((byte[])object);
    }

    public String getSimSerialNumber() {
        String string2;
        block20: {
            Object object;
            Object object2;
            block21: {
                int n10;
                block19: {
                    string2 = "-1";
                    n10 = Build.VERSION.SDK_INT;
                    int n11 = 29;
                    if (n10 >= n11) {
                        return string2;
                    }
                    object2 = "-2";
                    object = this.bvs;
                    object = ((BVS)object).ssn;
                    n10 = (int)(((String)object2).equals(object) ? 1 : 0);
                    if (n10 != 0) break block19;
                    object2 = this.bvs;
                    return ((BVS)object2).ssn;
                }
                object2 = "android.permission.READ_PHONE_STATE";
                n10 = (int)(this.checkPermission((String)object2) ? 1 : 0);
                if (n10 == 0) break block20;
                object2 = "phone";
                object2 = this.getSystemServiceSafe((String)object2);
                if (object2 != null) break block21;
                object2 = this.bvs;
                ((BVS)object2).ssn = string2;
                return string2;
            }
            object = this.bvs;
            int n12 = 14;
            String string3 = Strings.getString(n12);
            Object[] objectArray = null;
            objectArray = new Object[]{};
            object2 = ReflectHelper.invokeInstanceMethod(object2, string3, objectArray);
            object2 = (String)object2;
            ((BVS)object).ssn = object2;
            object2 = this.bvs;
            try {
                return ((BVS)object2).ssn;
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                String string4 = throwable.getMessage();
                ((NLog)object).w(string4);
            }
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public HashMap getSizeInfo() {
        long l10;
        String string2;
        int n10;
        Object object;
        Object object2;
        String string3;
        HashMap hashMap = new HashMap();
        Object object3 = "sdcard";
        Object object4 = "data";
        Object object5 = new String[]{object3, object4};
        int n11 = 0;
        String string4 = null;
        while (true) {
            string3 = "total";
            object2 = "free";
            object = "available";
            n10 = 2;
            if (n11 >= n10) break;
            string2 = object5[n11];
            HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
            l10 = -1;
            Long l11 = l10;
            hashMap2.put((String)object, l11);
            object = l10;
            hashMap2.put((String)object2, object);
            object2 = l10;
            hashMap2.put(string3, object2);
            hashMap.put(string2, hashMap2);
            ++n11;
        }
        object5 = new HashMap();
        try {
            string4 = this.getSdcardPath();
            if (string4 != null) {
                string2 = new StatFs(string4);
                ((HashMap)object5).put(object3, string2);
            }
        }
        catch (Throwable throwable) {}
        try {
            object3 = Environment.getDataDirectory();
            if (object3 != null) {
                object3 = ((File)object3).getPath();
                string4 = new StatFs((String)object3);
                ((HashMap)object5).put(object4, string4);
            }
        }
        catch (Throwable throwable) {}
        object3 = ((HashMap)object5).entrySet().iterator();
        boolean bl2;
        while (bl2 = object3.hasNext()) {
            long l12;
            long l13;
            long l14;
            object4 = (Map.Entry)object3.next();
            object5 = (StatFs)object4.getValue();
            n11 = Build.VERSION.SDK_INT;
            n10 = 18;
            if (n11 <= n10) {
                l14 = object5.getAvailableBlocks();
                l10 = object5.getBlockSize();
                l14 *= l10;
                l10 = object5.getFreeBlocks();
                l13 = object5.getBlockSize();
                l10 *= l13;
                n11 = object5.getBlockCount();
                l13 = n11;
                int n12 = object5.getBlockSize();
                l12 = n12;
            } else {
                l14 = object5.getAvailableBlocksLong();
                l10 = object5.getBlockSizeLong();
                l14 *= l10;
                l10 = object5.getFreeBlocksLong();
                l13 = object5.getBlockSizeLong();
                l10 *= l13;
                l13 = object5.getBlockCountLong();
                l12 = object5.getBlockSizeLong();
            }
            object4 = object4.getKey();
            object4 = (HashMap)hashMap.get(object4);
            object5 = l14;
            ((HashMap)object4).put(object, object5);
            object5 = l10;
            ((HashMap)object4).put(object2, object5);
            object5 = l13 *= l12;
            ((HashMap)object4).put(string3, object5);
        }
        return hashMap;
    }

    public int getStatusBarHeight() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 < n11) {
            Object object = "com.android.internal.R$dimen";
            object = ReflectHelper.importClass((String)object);
            Object object2 = "status_bar_height";
            object = ReflectHelper.getStaticField((String)object, (String)object2);
            object = (Integer)object;
            n10 = (Integer)object;
            object2 = this.context;
            object2 = object2.getResources();
            try {
                return object2.getDimensionPixelSize(n10);
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
        }
        return -1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public HashMap getSupport() {
        boolean bl2;
        boolean bl3;
        Object object;
        Object object2;
        Object object3;
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        try {
            object3 = this.context;
            object3 = object3.getPackageManager();
            if (object3 == null) return hashMap;
            object2 = "mobile";
            object = "android.hardware.telephony";
        }
        catch (Throwable throwable) {
            return hashMap;
        }
        try {
            bl3 = object3.hasSystemFeature((String)object);
            object = bl3;
            hashMap.put(object2, object);
        }
        catch (Throwable throwable) {}
        object2 = "wifi";
        object = "android.hardware.wifi";
        try {
            bl3 = object3.hasSystemFeature((String)object);
            object = bl3;
            hashMap.put(object2, object);
        }
        catch (Throwable throwable) {}
        object2 = "gps";
        object = "android.hardware.location.gps";
        try {
            bl3 = object3.hasSystemFeature((String)object);
            object = bl3;
            hashMap.put(object2, object);
        }
        catch (Throwable throwable) {}
        object2 = this.context;
        object = "phone";
        object2 = object2.getSystemService((String)object);
        object2 = (TelephonyManager)object2;
        object = "telephone";
        if (object2 != null && (bl2 = object2.getPhoneType())) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        object2 = bl2;
        hashMap.put(object, object2);
        object2 = "nfc";
        object = "android.hardware.nfc";
        try {
            bl3 = object3.hasSystemFeature((String)object);
            object = bl3;
            hashMap.put(object2, object);
        }
        catch (Throwable throwable) {}
        object2 = "bluetooth";
        object = "android.hardware.bluetooth";
        try {
            bl3 = object3.hasSystemFeature((String)object);
            object = bl3;
            hashMap.put(object2, object);
        }
        catch (Throwable throwable) {}
        object2 = "otg";
        object = "android.hardware.usb.host";
        boolean bl4 = object3.hasSystemFeature((String)object);
        object3 = bl4;
        hashMap.put(object2, object3);
        return hashMap;
    }

    public Object getSystemServiceSafe(String string2) {
        Context context;
        try {
            context = this.context;
        }
        catch (Throwable throwable) {
            MobLog.getInstance().w(throwable);
            return null;
        }
        return context.getSystemService(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ArrayList getTTYDriversInfo() {
        ArrayList<ArrayList<String>> arrayList = new ArrayList<ArrayList<String>>();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) return arrayList;
        n10 = 0;
        Object[] objectArray = null;
        try {
            int n12 = 52;
            Object object = Strings.getString(n12);
            FileReader fileReader = new FileReader((String)object);
            object = new BufferedReader(fileReader);
            while (true) {
                int n13;
                String[] stringArray;
                if ((stringArray = ((BufferedReader)object).readLine()) == null) {
                    ((BufferedReader)object).close();
                    fileReader.close();
                    return arrayList;
                }
                int n14 = TextUtils.isEmpty((CharSequence)stringArray);
                if (n14 != 0) continue;
                stringArray = stringArray.trim();
                Object object2 = " ";
                n14 = (stringArray = stringArray.split((String)object2)).length;
                if (n14 <= (n13 = 1)) continue;
                object2 = new Object();
                n13 = stringArray.length;
                for (int i10 = 0; i10 < n13; ++i10) {
                    String string2 = stringArray[i10];
                    boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                    if (bl2) continue;
                    string2 = string2.trim();
                    ((ArrayList)object2).add(string2);
                }
                arrayList.add((ArrayList<String>)object2);
            }
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            String string3 = throwable.getMessage();
            objectArray = new Object[]{};
            nLog.d(string3, objectArray);
        }
        return arrayList;
    }

    public String getTimezone() {
        String string2;
        block10: {
            NLog nLog;
            Object object;
            block9: {
                string2 = null;
                object = new Configuration();
                object.setToDefaults();
                nLog = this.context;
                nLog = nLog.getContentResolver();
                Settings.System.getConfiguration((ContentResolver)nLog, (Configuration)object);
                object = ((Configuration)object).locale;
                if (object != null) break block9;
                object = Locale.getDefault();
            }
            object = Calendar.getInstance((Locale)object);
            if (object == null) break block10;
            object = ((Calendar)object).getTimeZone();
            try {
                string2 = ((TimeZone)object).getID();
            }
            catch (Throwable throwable) {
                nLog = MobLog.getInstance();
                nLog.d(throwable);
            }
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Activity getTopActivity() {
        try {
            Object e10;
            Object object;
            int n10;
            int n11;
            Object object2;
            int n12;
            block5: {
                Object object3;
                int n13;
                int n14 = Build.VERSION.SDK_INT;
                n12 = 27;
                if (n14 > n12) {
                    return null;
                }
                object2 = DeviceHelper.currentActivityThread();
                n12 = 23;
                String string2 = Strings.getString(n12);
                object2 = ReflectHelper.getInstanceField(object2, string2);
                object2 = (Map)object2;
                Collection collection = object2.values();
                Iterator iterator2 = collection.iterator();
                do {
                    n11 = iterator2.hasNext();
                    n10 = 30;
                    if (n11 == 0) break block5;
                    object = iterator2.next();
                    n13 = 29;
                    object3 = Strings.getString(n13);
                    object3 = ReflectHelper.getInstanceField(object, (String)object3);
                } while ((n13 = (int)(((Boolean)(object3 = (Boolean)object3)).booleanValue() ? 1 : 0)) != 0);
                object2 = Strings.getString(n10);
                object2 = ReflectHelper.getInstanceField(object, (String)object2);
                return (Activity)object2;
            }
            object2 = object2.values();
            object2 = object2.iterator();
            do {
                if ((n12 = (int)(object2.hasNext() ? 1 : 0)) == 0) return null;
                e10 = object2.next();
                n11 = 24;
                object = Strings.getString(n11);
                object = ReflectHelper.getInstanceField(e10, object);
            } while ((n11 = (int)(((Boolean)(object = (Boolean)object)).booleanValue() ? 1 : 0)) != 0);
            object2 = Strings.getString(n10);
            object2 = ReflectHelper.getInstanceField(e10, (String)object2);
            return (Activity)object2;
        }
        catch (Throwable throwable) {}
        return null;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public HashMap getTraffic() {
        int n10;
        Object object;
        int n11;
        HashMap<Object, Object> hashMap;
        int n12;
        block18: {
            Object object2;
            Object object3;
            block19: {
                block17: {
                    n12 = Build.VERSION.SDK_INT;
                    hashMap = new HashMap<Object, Object>();
                    n11 = 1;
                    int n13 = 29;
                    if (n12 >= n13) break block18;
                    n13 = 0;
                    object = null;
                    int n14 = 120;
                    Object object4 = Strings.getString(n14);
                    object3 = new FileReader((String)object4);
                    object2 = new BufferedReader((Reader)object3);
                    try {
                        object = new StringBuilder();
                        while ((object3 = ((BufferedReader)object2).readLine()) != null) {
                            ((StringBuilder)object).append((String)object3);
                            object3 = "\n";
                            ((StringBuilder)object).append((String)object3);
                        }
                        if ((object = ((StringBuilder)object).toString()) == null) break block17;
                        int n15 = 2;
                        object4 = new long[n15];
                        String string2 = "wlan0:";
                        this.getTrafficBytes((String)object, string2, (long[])object4);
                        string2 = "downFlowWifi";
                        Object object5 = object4[0];
                        Long l10 = (long)object5;
                        hashMap.put(string2, l10);
                        string2 = "upwardFlowWifi";
                        object5 = object4[n11];
                        object4 = (long)object5;
                        hashMap.put(string2, object4);
                        object3 = new long[n15];
                        object4 = "rmnet0:";
                        this.getTrafficBytes((String)object, (String)object4, (long[])object3);
                        object = "downFlowCellular";
                        Object object6 = object3[0];
                        object4 = (long)object6;
                        hashMap.put(object, object4);
                        object = "upwardFlowCellular";
                        object6 = object3[n11];
                        object3 = (long)object6;
                        hashMap.put(object, object3);
                    }
                    catch (Throwable throwable) {}
                }
                ((BufferedReader)object2).close();
                break block19;
                catch (Throwable throwable) {
                    n10 = 0;
                    object2 = null;
                    object = throwable;
                }
            }
            try {
                object3 = MobLog.getInstance();
                ((NLog)object3).d((Throwable)object);
                if (object2 == null) break block18;
            }
            catch (Throwable throwable) {
                if (object2 == null) throw throwable;
                try {
                    ((BufferedReader)object2).close();
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    NLog nLog = MobLog.getInstance();
                    nLog.d(throwable2);
                }
                throw throwable;
            }
            try {
                ((BufferedReader)object2).close();
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
        }
        object = this.context;
        object = object.getPackageManager();
        n10 = 24;
        if (n12 < n10) return hashMap;
        Object object7 = this.context;
        object7 = object7.getPackageName();
        object7 = object.getApplicationInfo((String)object7, n11);
        n12 = object7.uid;
        String string3 = "upwardFlowApp";
        long l11 = TrafficStats.getUidTxBytes((int)n12);
        object = l11;
        hashMap.put(string3, object);
        string3 = "downFlowApp";
        l11 = TrafficStats.getUidRxBytes((int)n12);
        object7 = l11;
        hashMap.put(string3, object7);
        return hashMap;
        catch (Throwable throwable) {
            try {
                NLog nLog = MobLog.getInstance();
                nLog.w(throwable);
                return hashMap;
            }
            catch (Throwable throwable3) {
                NLog nLog = MobLog.getInstance();
                nLog.d(throwable3);
            }
        }
        return hashMap;
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String getWAbcd(int n10) {
        block35: {
            boolean bl2 = this.getSdcardState();
            if (bl2) break block35;
            return null;
        }
        Object object = this.getSdcardPath();
        int n11 = TextUtils.isEmpty((CharSequence)object);
        if (n11 != 0) {
            return null;
        }
        n11 = 75;
        String[] stringArray = Strings.getString(n11);
        String string2 = ",";
        stringArray = stringArray.split(string2);
        if (stringArray == null) return null;
        int n12 = stringArray.length;
        if (n12 <= 0) return null;
        n12 = stringArray.length;
        for (int i10 = 0; i10 < n12; ++i10) {
            Object object2 = stringArray[i10];
            if (object2 == null) continue;
            {
                catch (Throwable throwable) {
                    object = MobLog.getInstance();
                    ((NLog)object).d(throwable);
                    return null;
                }
            }
            object2 = ((String)object2).trim();
            boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
            if (bl3) continue;
            CharSequence charSequence = new StringBuilder();
            charSequence.append((String)object);
            charSequence.append((String)object2);
            object2 = charSequence.toString();
            charSequence = new StringBuilder();
            String string3 = ".mn_";
            charSequence.append(string3);
            int n13 = 137;
            string3 = Strings.getString(n13);
            charSequence.append(string3);
            charSequence = charSequence.toString();
            Object object3 = new File((String)object2, (String)charSequence);
            boolean bl4 = ((File)object3).exists();
            if (!bl4) continue;
            bl4 = ((File)object3).isFile();
            if (!bl4) continue;
            object2 = ((File)object3).getPath();
            object2 = this.getMapFromOtherPlace((String)object2);
            if (object2 == null) continue;
            object3 = String.valueOf(n10);
            object2 = ((HashMap)object2).get(object3);
            object2 = (String)object2;
            bl3 = TextUtils.isEmpty((CharSequence)object2);
            if (bl3) continue;
            try {
                return ((String)object2).trim();
            }
            catch (Throwable throwable) {
                object3 = MobLog.getInstance();
                ((NLog)object3).d(throwable);
            }
        }
        return null;
    }

    /*
     * Unable to fully structure code
     */
    public Bitmap getWallPaper() {
        block22: {
            block21: {
                block20: {
                    try {
                        var1_1 = this.context;
                    }
                    catch (Throwable var1_2) {
                        MobLog.getInstance().d(var1_2);
                        return null;
                    }
                    var1_1 = WallpaperManager.getInstance((Context)var1_1);
                    var2_3 = var1_1.peekDrawable();
                    if (var2_3 != null) break block20;
                    var1_1 = var1_1.getWallpaperInfo();
                    var2_3 = this.context;
                    var2_3 = var2_3.getPackageManager();
                    var2_3 = var1_1.loadThumbnail((PackageManager)var2_3);
                    if (var2_3 != null) break block20;
                    return null;
                }
                if ((var3_4 = var2_3 instanceof BitmapDrawable) == 0) ** GOTO lbl28
                var2_3 = (BitmapDrawable)var2_3;
                return var2_3.getBitmap();
lbl28:
                // 1 sources

                var3_4 = var2_3.getIntrinsicWidth();
                var4_5 = 1;
                if (var3_4 <= 0) break block21;
                var3_4 = var2_3.getIntrinsicHeight();
                if (var3_4 <= 0) break block21;
                var4_5 = var2_3.getIntrinsicWidth();
                var3_4 = var2_3.getIntrinsicHeight();
                break block22;
            }
            var3_4 = var4_5;
        }
        var5_6 = Bitmap.Config.ARGB_8888;
        var1_1 = Bitmap.createBitmap((int)var4_5, (int)var3_4, (Bitmap.Config)var5_6);
        var6_7 = new Canvas((Bitmap)var1_1);
        var7_8 = var1_1.getWidth();
        var8_9 = var1_1.getHeight();
        var2_3.setBounds(0, 0, var7_8, var8_9);
        var2_3.draw(var6_7);
        return var1_1;
    }

    public void hideSoftInput(View view) {
        Object object = this.getSystemServiceSafe("input_method");
        if (object == null) {
            return;
        }
        object = (InputMethodManager)object;
        view = view.getWindowToken();
        object.hideSoftInputFromWindow((IBinder)view, 0);
    }

    public int ih(Context object) {
        boolean bl2;
        String string2 = DeviceHelper.getTopApp((Context)object);
        if (string2 != null && (bl2 = (object = DeviceHelper.getLauncherPackageNames((Context)object)).contains(string2))) {
            return 1;
        }
        return 0;
    }

    public Object invokeInstanceMethod(Object object, String string2, Object ... objectArray) {
        try {
            return ReflectHelper.invokeInstanceMethod(object, string2, objectArray);
        }
        catch (Throwable throwable) {
            MobLog.getInstance().d(throwable);
            return null;
        }
    }

    public Object invokeInstanceMethod(Object object, String string2, Object[] objectArray, Class[] classArray) {
        try {
            return ReflectHelper.invokeInstanceMethod(object, string2, objectArray, classArray);
        }
        catch (Throwable throwable) {
            MobLog.getInstance().d(throwable);
            return null;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int ir(Context object, String iterator2) {
        int n10;
        int n11;
        int n12;
        int n13;
        block40: {
            int n14;
            Object object2;
            Object object3;
            Object object4;
            block37: {
                Object object5;
                Object object6;
                block38: {
                    n13 = Build.VERSION.SDK_INT;
                    n12 = 1;
                    n11 = 21;
                    if (n13 < n11) {
                        String string2 = "activity";
                        if ((object = ((ActivityManager)object.getSystemService(string2)).getRunningAppProcesses()) == null) return 0;
                        n13 = object.size();
                        if (n13 <= 0) return 0;
                        object = object.iterator();
                        do {
                            if ((n13 = (int)(object.hasNext() ? 1 : 0)) == 0) return 0;
                        } while ((n13 = (int)((string2 = ((ActivityManager.RunningAppProcessInfo)object.next()).processName).equals(iterator2) ? 1 : 0)) == 0);
                        return n12;
                    }
                    n11 = 24;
                    if (n13 > n11) break block40;
                    n11 = 42;
                    n10 = 0;
                    object6 = null;
                    object4 = Strings.getString(n11);
                    object4 = ReflectHelper.importClass((String)object4);
                    int n15 = 43;
                    object3 = Strings.getString(n15);
                    object5 = new Object[]{};
                    object4 = ReflectHelper.invokeStaticMethod((String)object4, (String)object3, (Object[])object5);
                    n15 = 44;
                    object3 = Strings.getString(n15);
                    object5 = new Object[n12];
                    int n16 = 46;
                    object5[0] = object2 = Strings.getString(n16);
                    object4 = ReflectHelper.invokeInstanceMethod(object4, (String)object3, (Object[])object5);
                    object4 = (java.lang.Process)object4;
                    n15 = 128;
                    object3 = Strings.getString(n15);
                    object5 = new Object[]{};
                    object3 = ReflectHelper.invokeInstanceMethod(object4, (String)object3, (Object[])object5);
                    object3 = (OutputStream)object3;
                    int n17 = 45;
                    object5 = Strings.getString(n17);
                    object2 = new Object[]{};
                    object5 = ReflectHelper.invokeInstanceMethod(object4, (String)object5, (Object[])object2);
                    object5 = (InputStream)object5;
                    object2 = new DataOutputStream((OutputStream)object3);
                    object3 = new DataInputStream((InputStream)object5);
                    try {
                        object6 = new StringBuilder();
                        object5 = "ps | grep ";
                        ((StringBuilder)object6).append((String)object5);
                        ((StringBuilder)object6).append((String)((Object)iterator2));
                        object6 = ((StringBuilder)object6).toString();
                        object6 = ((String)object6).getBytes();
                        ((FilterOutputStream)object2).write((byte[])object6);
                        object6 = "\n";
                        ((DataOutputStream)object2).writeBytes((String)object6);
                        ((DataOutputStream)object2).flush();
                        object6 = "exit\n";
                        ((DataOutputStream)object2).writeBytes((String)object6);
                        ((DataOutputStream)object2).flush();
                        object6 = new StringBuilder();
                        Object object7 = new InputStreamReader((InputStream)object3);
                        object5 = new BufferedReader((Reader)object7);
                        while ((object7 = ((BufferedReader)object5).readLine()) != null) {
                            ((StringBuilder)object6).append((String)object7);
                        }
                        ((java.lang.Process)object4).waitFor();
                        object6 = ((StringBuilder)object6).toString();
                        object6 = ((String)object6).trim();
                        n14 = TextUtils.isEmpty((CharSequence)object6) ^ n12;
                        if (object4 == null) break block37;
                    }
                    catch (Throwable throwable) {}
                    try {
                        ((java.lang.Process)object4).destroy();
                        break block37;
                    }
                    catch (Throwable throwable) {}
                    break block38;
                    catch (Throwable throwable) {
                        n15 = 0;
                        object3 = null;
                        object6 = throwable;
                        break block38;
                    }
                    catch (Throwable throwable) {
                        n16 = 0;
                        object2 = null;
                        object6 = throwable;
                        n15 = 0;
                        object3 = null;
                    }
                    break block38;
                    catch (Throwable throwable) {
                        n15 = 0;
                        object3 = null;
                        n16 = 0;
                        object2 = null;
                        object6 = throwable;
                        n11 = 0;
                        object4 = null;
                    }
                }
                object5 = MobLog.getInstance();
                ((NLog)object5).d((Throwable)object6);
                break block40;
            }
            try {
                ((FilterOutputStream)object2).close();
            }
            catch (Throwable throwable) {}
            try {
                ((FilterInputStream)object3).close();
                return n14;
            }
            catch (Throwable throwable) {
                return n14;
            }
            finally {
                if (object4 != null) {
                    ((java.lang.Process)object4).destroy();
                }
                if (object2 != null) {
                    ((FilterOutputStream)object2).close();
                }
                if (object3 != null) {
                    ((FilterInputStream)object3).close();
                }
            }
        }
        n11 = 27;
        n10 = 2;
        if (n13 >= n11) return n10;
        if ((iterator2 = this.getIntentSP((String)((Object)iterator2))) == null) return n10;
        n13 = iterator2.size();
        if (n13 <= 0) return n10;
        iterator2 = iterator2.iterator();
        do {
            if ((n13 = (int)(iterator2.hasNext() ? 1 : 0)) == 0) return n10;
            Intent intent = (Intent)((Object[])iterator2.next())[n10];
            n13 = this.cs((Context)object, intent);
            if (n13 == 0) {
                return 0;
            }
            if (n13 == n12) return n12;
        } while (n13 != n10);
        return n12;
    }

    public boolean isBT() {
        Object object;
        try {
            object = this.context;
        }
        catch (Throwable throwable) {
            return false;
        }
        object = BHelper.getInstance((Context)object);
        return ((BHelper)object).isEnabled();
    }

    public boolean isFakePass(String object) {
        int n10 = 132;
        int n11 = 0;
        Object object2 = Strings.getString(n10);
        object2 = ReflectHelper.importClass((String)object2);
        int n12 = 133;
        String string2 = Strings.getString(n12);
        int n13 = 1;
        Object[] objectArray = new Object[n13];
        objectArray[0] = object;
        object = ReflectHelper.invokeStaticMethod((String)object2, string2, objectArray);
        object = (String)object;
        n12 = 134;
        string2 = Strings.getString(n12);
        int n14 = 3;
        objectArray = new Object[n14];
        Object object3 = this.context;
        objectArray[0] = object3;
        objectArray[n13] = object;
        int n15 = 2;
        object3 = this.getPackageName();
        objectArray[n15] = object3;
        object = ReflectHelper.invokeStaticMethod((String)object2, string2, objectArray);
        object = (Integer)object;
        try {
            n15 = (Integer)object;
            if (n15 == n13) {
                n11 = n13;
            }
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).d(throwable);
        }
        return n11 != 0;
    }

    public boolean isFreeMeOS() {
        block5: {
            String string2 = "ro.build.freeme.label";
            try {
                string2 = this.getSystemProperties(string2);
            }
            catch (Throwable throwable) {}
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) break block5;
            String string3 = "FREEMEOS";
            boolean bl3 = string2.equalsIgnoreCase(string3);
            if (bl3) {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isPackageInstalled(String string2) {
        Context context;
        boolean bl2 = false;
        try {
            context = this.context;
        }
        catch (Throwable throwable) {
            return bl2;
        }
        context = context.getPackageManager();
        string2 = context.getPackageInfo(string2, 0);
        if (string2 == null) return bl2;
        return true;
    }

    public boolean isRooted() {
        String string2;
        boolean bl2;
        String string3 = Build.TAGS;
        boolean bl3 = true;
        if (string3 != null && (bl2 = string3.contains(string2 = "test-keys"))) {
            bl2 = bl3;
        } else {
            bl2 = false;
            string3 = null;
        }
        if (!(bl2 || (bl2 = this.checkRootFile()) || (bl2 = this.checkRootApp()) || (bl2 = this.checkRootSu()) || (bl2 = this.checkRootRw()) || (bl2 = this.checkRootProp()))) {
            bl3 = false;
        }
        return bl3;
    }

    public boolean isSSUIOS() {
        block5: {
            String string2 = "ro.ssui.product";
            try {
                string2 = this.getSystemProperties(string2);
            }
            catch (Throwable throwable) {}
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) break block5;
            String string3 = "unknown";
            boolean bl3 = string2.equalsIgnoreCase(string3);
            if (!bl3) {
                return true;
            }
        }
        return false;
    }

    public boolean isScopedStorage() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        int n12 = 1;
        n10 = n10 >= n11 ? n12 : 0;
        ApplicationInfo applicationInfo = this.context.getApplicationInfo();
        int n13 = applicationInfo.targetSdkVersion;
        n11 = n13 >= n11 ? n12 : 0;
        if (n10 == 0 || n11 == 0) {
            n12 = 0;
        }
        return n12 != 0;
    }

    /*
     * Loose catch block
     */
    public boolean isSensitiveDevice() {
        Object object;
        int n10;
        int n11;
        Object object2;
        Object object3;
        int n12;
        String string2;
        block16: {
            block15: {
                string2 = "";
                n12 = 0;
                object3 = this.getManufacturer();
                object2 = this.getMIUIVersion();
                int n13 = TextUtils.isEmpty((CharSequence)object2);
                n11 = 1;
                if (n13 != 0) break block15;
                n13 = object2.length();
                int n14 = 3;
                if (n13 < n14) break block15;
                object2 = object2.substring(n11);
                try {
                    n10 = Integer.parseInt((String)object2);
                    n13 = 12;
                    if (n10 < n13) break block15;
                    n10 = n11;
                    break block16;
                }
                catch (Throwable throwable) {
                    block17: {
                        object2 = throwable.getMessage();
                        if (object2 != null) break block17;
                        object2 = string2;
                    }
                    object = MobLog.getInstance();
                    Object[] objectArray = new Object[]{};
                    ((NLog)object).d(object2, objectArray);
                }
            }
            n10 = 0;
            object2 = null;
        }
        object = "xiaomi";
        boolean bl2 = ((String)object).equalsIgnoreCase((String)object3);
        if (bl2 && n10 != 0) {
            n12 = n11;
        }
        {
            catch (Throwable throwable) {
                object3 = throwable.getMessage();
                if (object3 != null) {
                    string2 = object3;
                }
                object3 = MobLog.getInstance();
                object2 = new Object[]{};
                ((NLog)object3).d(string2, object2);
            }
        }
        return n12 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public boolean isSmlt() {
        Boolean bl2;
        block51: {
            void var6_19;
            boolean bl3;
            int bl5;
            Object object;
            block50: {
                void var6_18;
                Context context;
                SmltHelper smltHelper;
                block49: {
                    void var6_17;
                    block48: {
                        void var6_16;
                        block47: {
                            void var6_15;
                            block46: {
                                void var6_14;
                                block45: {
                                    void var6_13;
                                    block44: {
                                        void var6_12;
                                        block43: {
                                            void var6_11;
                                            block42: {
                                                void var6_10;
                                                block41: {
                                                    block40: {
                                                        bl2 = Boolean.TRUE;
                                                        object = this.isSmlt;
                                                        if (object == null) break block40;
                                                        return (Boolean)object;
                                                    }
                                                    bl5 = 2;
                                                    smltHelper = new SmltHelper();
                                                    Context context2 = this.context;
                                                    boolean bl4 = smltHelper.checkBaseband(context2);
                                                    bl3 = true;
                                                    if (bl4 == bl3) {
                                                        boolean bl6 = bl3;
                                                        break block41;
                                                    }
                                                    boolean bl7 = false;
                                                    context2 = null;
                                                }
                                                context = this.context;
                                                int n10 = smltHelper.checkBoard(context);
                                                if (n10 != bl3) break block42;
                                                var6_11 = var6_10 + true;
                                            }
                                            if (var6_11 >= bl5) {
                                                this.isSmlt = bl2;
                                                return bl3;
                                            }
                                            context = this.context;
                                            boolean bl8 = smltHelper.checkPlatform(context);
                                            if (bl8 != bl3) break block43;
                                            var6_12 = var6_11 + true;
                                        }
                                        if (var6_12 >= bl5) {
                                            this.isSmlt = bl2;
                                            return bl3;
                                        }
                                        context = this.context;
                                        boolean bl9 = smltHelper.checkFlavor(context);
                                        if (bl9 != bl3) break block44;
                                        var6_13 = var6_12 + true;
                                    }
                                    if (var6_13 >= bl5) {
                                        this.isSmlt = bl2;
                                        return bl3;
                                    }
                                    boolean bl10 = smltHelper.checkCgroup();
                                    if (bl10 != bl3) break block45;
                                    var6_14 = var6_13 + true;
                                }
                                if (var6_14 >= bl5) {
                                    this.isSmlt = bl2;
                                    return bl3;
                                }
                                context = this.context;
                                boolean bl11 = smltHelper.checkBluetooth(context);
                                if (bl11 != bl3) break block46;
                                var6_15 = var6_14 + true;
                            }
                            if (var6_15 >= bl5) {
                                this.isSmlt = bl2;
                                return bl3;
                            }
                            context = this.context;
                            boolean bl12 = smltHelper.checkImei(context);
                            if (bl12 != bl3) break block47;
                            var6_16 = var6_15 + true;
                        }
                        if (var6_16 >= bl5) {
                            this.isSmlt = bl2;
                            return bl3;
                        }
                        context = this.context;
                        boolean bl13 = smltHelper.checkCommonApp(context);
                        if (bl13 != bl3) break block48;
                        var6_17 = var6_16 + true;
                    }
                    if (var6_17 >= bl5) {
                        this.isSmlt = bl2;
                        return bl3;
                    }
                    boolean bl14 = smltHelper.checkCpuInfo();
                    if (bl14 != bl3) break block49;
                    var6_18 = var6_17 + true;
                }
                if (var6_18 >= bl5) {
                    this.isSmlt = bl2;
                    return bl3;
                }
                context = this.context;
                boolean bl15 = smltHelper.checkSensor(context);
                if (bl15 != bl3) break block50;
                var6_19 = var6_18 + true;
            }
            if (var6_19 < bl5) break block51;
            try {
                this.isSmlt = bl2;
                return bl3;
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).d(throwable);
            }
        }
        this.isSmlt = bl2 = Boolean.FALSE;
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isWifiProxy() {
        String string2;
        int n10;
        int n11;
        int n12;
        boolean bl2;
        block14: {
            block12: {
                String string3;
                block13: {
                    bl2 = false;
                    try {
                        n12 = Build.VERSION.SDK_INT;
                        n11 = 14;
                        n10 = -1;
                        if (n12 < n11) break block12;
                        string2 = "http.proxyHost";
                    }
                    catch (Throwable throwable) {
                        return bl2;
                    }
                    string2 = System.getProperty(string2);
                    string3 = "http.proxyPort";
                    string3 = System.getProperty(string3);
                    if (string3 != null) break block13;
                    string3 = "-1";
                }
                try {
                    n11 = Integer.parseInt(string3);
                }
                catch (Throwable throwable) {
                    n11 = n10;
                }
                break block14;
            }
            string2 = this.context;
            string2 = Proxy.getHost((Context)string2);
            Context context = this.context;
            n11 = Proxy.getPort((Context)context);
        }
        n12 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n12 != 0) return bl2;
        if (n11 == n10) return bl2;
        return true;
    }

    public HashMap listNetworkHardware() {
        boolean bl2;
        boolean bl3;
        Enumeration<NetworkInterface> enumeration = this.bufMacs;
        if (enumeration != null && !(bl3 = ((HashMap)((Object)enumeration)).isEmpty())) {
            return this.bufMacs;
        }
        enumeration = NetworkInterface.getNetworkInterfaces();
        if (enumeration == null) {
            return null;
        }
        enumeration = Collections.list(enumeration);
        HashMap<Object, byte[]> hashMap = new HashMap<Object, byte[]>();
        enumeration = enumeration.iterator();
        while (bl2 = enumeration.hasNext()) {
            Object object;
            Object object2 = (NetworkInterface)enumeration.next();
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 9;
            if (n10 >= n11) {
                object = ((NetworkInterface)object2).getHardwareAddress();
            } else {
                n10 = 0;
                object = null;
            }
            if (object == null) continue;
            object2 = ((NetworkInterface)object2).getName();
            object = this.byteToHex((byte[])object);
            hashMap.put(object2, (byte[])object);
        }
        this.bufMacs = hashMap;
        return hashMap;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public HashMap ping(String var1_1, int var2_2, int var3_3) {
        var4_4 = new ArrayList<Object>();
        var5_5 = 0;
        var6_6 = null;
        var7_7 = new StringBuilder();
        var8_8 = "ping -c ";
        var7_7.append((String)var8_8);
        var7_7.append(var2_2);
        var8_8 = " -s ";
        var7_7.append((String)var8_8);
        var7_7.append(var3_3);
        var8_8 = " ";
        var7_7.append((String)var8_8);
        var7_7.append(var1_1);
        var7_7 = var7_7.toString();
        var3_3 += 8;
        var9_9 = 42;
        var10_10 = 5.9E-44f;
        var8_8 = Strings.getString(var9_9);
        var8_8 = ReflectHelper.importClass((String)var8_8);
        var11_11 = 43;
        var12_12 = 6.0E-44f;
        var13_13 = Strings.getString(var11_11);
        var14_15 = new Object[]{};
        var8_8 = ReflectHelper.invokeStaticMethod((String)var8_8, (String)var13_13, var14_15);
        var11_11 = 44;
        var12_12 = 6.2E-44f;
        var13_13 = Strings.getString(var11_11);
        var15_16 = 1;
        var16_17 = 1.4E-45f;
        var17_18 = new Object[var15_16];
        var17_18[0] = var7_7;
        var7_7 = ReflectHelper.invokeInstanceMethod(var8_8, (String)var13_13, (Object[])var17_18);
        var7_7 = (java.lang.Process)var7_7;
        var9_9 = 45;
        var10_10 = 6.3E-44f;
        var8_8 = Strings.getString(var9_9);
        var13_13 = new Object[]{};
        var8_8 = ReflectHelper.invokeInstanceMethod(var7_7, (String)var8_8, (Object[])var13_13);
        var8_8 = (InputStream)var8_8;
        var13_13 = new InputStreamReader((InputStream)var8_8);
        var8_8 = new BufferedReader((Reader)var13_13);
        var13_13 = var8_8.readLine();
        while (var13_13 != null) {
            var17_18 = new StringBuilder();
            var17_18.append(var3_3);
            var18_19 = " bytes from";
            var17_18.append(var18_19);
            var17_18 = var17_18.toString();
            var19_20 = var13_13.startsWith((String)var17_18);
            if (var19_20 == 0) ** GOTO lbl97
            var17_18 = "ms";
            var19_20 = var13_13.endsWith((String)var17_18);
            if (var19_20 != 0) {
                var19_20 = var13_13.length() + -2;
                var13_13 = var13_13.substring(0, var19_20);
                var13_13 = var13_13.trim();
            } else {
                var17_18 = "s";
                var19_20 = (int)var13_13.endsWith((String)var17_18);
                if (var19_20 != 0) {
                    var17_18 = new StringBuilder();
                    var20_21 /* !! */  = var13_13.length() - var15_16;
                    var13_13 = var13_13.substring(0, (int)var20_21 /* !! */ );
                    var13_13 = var13_13.trim();
                    var17_18.append((String)var13_13);
                    var13_13 = "000";
                    var17_18.append((String)var13_13);
                    var13_13 = var17_18.toString();
                }
            }
            var17_18 = "time=";
            var19_20 = var13_13.indexOf((String)var17_18);
            if (var19_20 <= 0) ** GOTO lbl97
            var13_13 = var13_13.substring(var19_20 += 5);
            var13_13 = var13_13.trim();
        }
        ** GOTO lbl99
        {
            try {
                var12_12 = Float.parseFloat((String)var13_13);
                var13_13 = Float.valueOf(var12_12);
                var4_4.add(var13_13);
                ** GOTO lbl97
            }
            catch (Throwable var13_14) {
                try {
                    var17_18 = MobLog.getInstance();
                    var17_18.w(var13_14);
lbl97:
                    // 4 sources

                    var13_13 = var8_8.readLine();
                    continue;
lbl99:
                    // 1 sources

                    var7_7.waitFor();
                    break;
                }
                catch (Throwable var21_22) {
                    var7_7 = MobLog.getInstance();
                    var7_7.d(var21_22);
                    break;
                }
            }
        }
        var3_3 = var4_4.size();
        var22_23 = var4_4.size();
        var22_23 = var2_2 - var22_23;
        var9_9 = 0;
        var10_10 = 0.0f;
        var8_8 = null;
        if (var3_3 > 0) {
            var15_16 = 0x7F7FFFFF;
            var16_17 = 3.4028235E38f;
            var11_11 = 0;
            var13_13 = null;
            var12_12 = 0.0f;
            while (var5_5 < var3_3) {
                var17_18 = (Object[])var4_4.get(var5_5);
                var23_24 = var17_18.floatValue();
                cfr_temp_0 = var23_24 - var16_17;
                var20_21 /* !! */  = (float)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 < 0.0f ? -1 : 1));
                if (var20_21 /* !! */  < 0) {
                    var16_17 = var23_24;
                }
                if ((var20_21 /* !! */  = var23_24 == var12_12 ? 0 : (var23_24 > var12_12 ? 1 : -1)) > 0) {
                    var12_12 = var23_24;
                }
                var10_10 += var23_24;
                ++var5_5;
            }
            var24_25 = var3_3;
            var24_25 = var10_10 / var24_25;
            var10_10 = var16_17;
        } else {
            var4_4 = null;
            var24_25 = 0.0f;
            var11_11 = 0;
            var13_13 = null;
            var12_12 = 0.0f;
        }
        var6_6 = new HashMap<String, String>();
        var6_6.put("address", var1_1);
        var1_1 = String.valueOf(var2_2);
        var6_6.put("transmitted", var1_1);
        var1_1 = String.valueOf(var3_3);
        var6_6.put("received", var1_1);
        var1_1 = String.valueOf(var22_23);
        var6_6.put("loss", var1_1);
        var1_1 = String.valueOf(var10_10);
        var6_6.put("min", var1_1);
        var1_1 = String.valueOf(var12_12);
        var6_6.put("max", var1_1);
        var1_1 = String.valueOf(var24_25);
        var6_6.put("avg", var1_1);
        return var6_6;
    }

    /*
     * Loose catch block
     */
    public String[] queryIMEI() {
        block59: {
            Object object;
            Object object2;
            int n10;
            Object object3;
            String[] stringArray;
            Object object4;
            int n11;
            int n12;
            Object object5;
            String[] stringArray2;
            int n13;
            String[] stringArray3;
            block54: {
                int n14;
                block57: {
                    block56: {
                        block55: {
                            stringArray3 = new ArrayList();
                            n13 = 0;
                            stringArray2 = null;
                            object5 = "android.permission.READ_PHONE_STATE";
                            n12 = this.checkPermission((String)object5);
                            if (n12 == 0) break block54;
                            n12 = Build.VERSION.SDK_INT;
                            n11 = 29;
                            if (n12 >= n11) break block54;
                            object5 = "phone";
                            object5 = this.getSystemServiceSafe((String)object5);
                            if (object5 != null) break block55;
                            return null;
                        }
                        object4 = this.getIMEI();
                        n14 = TextUtils.isEmpty((CharSequence)object4);
                        stringArray = "-1";
                        if (n14 == 0) break block56;
                        object4 = stringArray;
                    }
                    stringArray3.add(object4);
                    object4 = this.bufIm;
                    if (object4 == null) break block57;
                    n11 = (int)(((ArrayList)object4).isEmpty() ? 1 : 0);
                    if (n11 != 0) break block57;
                    object5 = this.bufIm;
                    stringArray3.addAll(object5);
                }
                object4 = null;
                for (n11 = 0; n11 <= (n14 = 5); ++n11) {
                    block58: {
                        n14 = 8;
                        object3 = Strings.getString(n14);
                        n10 = 1;
                        object2 = new Object[n10];
                        object = n11;
                        object2[0] = object;
                        object3 = ReflectHelper.invokeInstanceMethod(object5, (String)object3, (Object[])object2);
                        try {
                            object3 = (String)object3;
                        }
                        catch (Throwable throwable) {
                            n14 = 0;
                            object3 = null;
                        }
                        n10 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
                        if (n10 == 0) break block58;
                        object3 = stringArray;
                    }
                    object2 = this.bufIm;
                    ((ArrayList)object2).add(object3);
                    try {
                        stringArray3.add(object3);
                        continue;
                    }
                    catch (Throwable throwable) {
                        object4 = MobLog.getInstance();
                        ((NLog)object4).w(throwable);
                        break;
                    }
                }
            }
            n12 = 54;
            object5 = Strings.getString(n12);
            object4 = ";";
            object5 = object5.split((String)object4);
            n11 = ((String[])object5).length;
            object3 = new String[n11][];
            int n15 = 0;
            stringArray = null;
            while (true) {
                n10 = ((String[])object5).length;
                object = ",";
                if (n15 >= n10) break;
                object2 = object5[n15];
                object2 = ((String)object2).split((String)object);
                object3[n15] = object2;
                ++n15;
                continue;
                break;
            }
            object5 = null;
            for (n12 = 0; n12 < n11; ++n12) {
                stringArray = object3[n12];
                n10 = stringArray.length;
                for (int i10 = 0; i10 < n10; ++i10) {
                    String[] stringArray4 = stringArray[i10];
                    stringArray4 = this.getSystemProperties((String)stringArray4);
                    stringArray4 = stringArray4.split((String)object);
                    int n16 = stringArray4.length;
                    for (int i11 = 0; i11 < n16; ++i11) {
                        String string2 = stringArray4[i11];
                        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                        if (bl2) continue;
                        bl2 = stringArray3.contains(string2);
                        if (bl2) continue;
                        stringArray3.add(string2);
                    }
                }
            }
            n13 = stringArray3.size();
            if (n13 <= 0) break block59;
            n13 = stringArray3.size();
            stringArray2 = new String[n13];
            stringArray3 = stringArray3.toArray(stringArray2);
            return stringArray3;
            {
                catch (Throwable throwable) {
                    stringArray2 = MobLog.getInstance();
                    stringArray2.w(throwable);
                }
            }
        }
        return null;
    }

    public String[] queryIMSI() {
        block17: {
            int n10 = 55;
            String[] stringArray = Strings.getString(n10);
            stringArray = this.getSystemProperties((String)stringArray);
            ArrayList<String> arrayList = new ArrayList<String>();
            String string2 = ",";
            stringArray = stringArray.split(string2);
            int n11 = stringArray.length;
            for (int i10 = 0; i10 < n11; ++i10) {
                String string3 = stringArray[i10];
                boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
                if (bl2) continue;
                bl2 = arrayList.contains(string3);
                if (bl2) continue;
                arrayList.add(string3);
            }
            n10 = arrayList.size();
            if (n10 <= 0) break block17;
            n10 = arrayList.size();
            stringArray = new String[n10];
            stringArray = arrayList.toArray(stringArray);
            try {
                return stringArray;
            }
            catch (Throwable throwable) {
                arrayList = MobLog.getInstance();
                ((NLog)((Object)arrayList)).w(throwable);
            }
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String readFile(String object) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileReader fileReader = new FileReader((String)object);
            object = new BufferedReader(fileReader);
            while (true) {
                String string2;
                if ((string2 = ((BufferedReader)object).readLine()) == null) {
                    ((BufferedReader)object).close();
                    fileReader.close();
                    return stringBuilder.toString();
                }
                string2 = string2.trim();
                int n10 = stringBuilder.length();
                if (n10 > 0) {
                    String string3 = "\n";
                    stringBuilder.append(string3);
                }
                stringBuilder.append(string2);
            }
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
        }
        return stringBuilder.toString();
    }

    public void registerBtWatcher(String string2, DeviceHelper$BtWatcher object) {
        if (object != null) {
            Object object2 = this.context;
            object2 = BHelper.getInstance((Context)object2);
            DeviceHelper$7 deviceHelper$7 = new DeviceHelper$7(this, (DeviceHelper$BtWatcher)object);
            try {
                ((BHelper)object2).registerBOperationReceiver(string2, deviceHelper$7);
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).d(throwable);
            }
        }
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void removeWABCD() {
        block27: {
            boolean bl2 = this.getSdcardState();
            if (bl2) break block27;
            return;
        }
        String string2 = this.getSdcardPath();
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            return;
        }
        n10 = 75;
        String[] stringArray = Strings.getString(n10);
        String string3 = ",";
        stringArray = stringArray.split(string3);
        if (stringArray == null) return;
        int n11 = stringArray.length;
        if (n11 <= 0) return;
        n11 = stringArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object;
            String string4 = stringArray[i10];
            if (string4 == null) continue;
            {
                catch (Throwable throwable) {
                    stringArray = MobLog.getInstance();
                    stringArray.d(throwable);
                    return;
                }
            }
            string4 = string4.trim();
            boolean bl3 = TextUtils.isEmpty((CharSequence)string4);
            if (bl3) continue;
            CharSequence charSequence = new StringBuilder();
            charSequence.append(string2);
            charSequence.append(string4);
            string4 = charSequence.toString();
            charSequence = new StringBuilder();
            String string5 = ".mn_";
            charSequence.append(string5);
            int n12 = 137;
            string5 = Strings.getString(n12);
            charSequence.append(string5);
            charSequence = charSequence.toString();
            try {
                object = new File(string4, (String)charSequence);
                ((File)object).delete();
                continue;
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).d(throwable);
            }
        }
    }

    public int sa(Context context, Intent intent) {
        try {
            context.startActivity(intent);
            return 1;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            MobLog.getInstance().d(activityNotFoundException);
            return 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int saInUI(Context context, Intent intent) {
        int n10 = 1;
        int[] nArray = new int[n10];
        Object object = new DeviceHelper$1(this, nArray, context, intent);
        context = null;
        UIHandler.sendEmptyMessage(0, (Handler.Callback)object);
        synchronized (nArray) {
            try {
                nArray.wait();
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).w(throwable);
            }
            return nArray[0];
        }
    }

    public int sap(Context context, String string2) {
        PackageManager packageManager;
        try {
            packageManager = context.getPackageManager();
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            MobLog.getInstance().d(activityNotFoundException);
            return 0;
        }
        string2 = packageManager.getLaunchIntentForPackage(string2);
        if (string2 == null) {
            return 0;
        }
        int n10 = 0x10800000;
        string2.addFlags(n10);
        context.startActivity((Intent)string2);
        return 1;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void saveWabcd(String var1_1, int var2_3) {
        block51: {
            block50: {
                var3_4 = this.getSdcardState();
                if (var3_4) break block50;
                return;
            }
            var4_5 = this.getSdcardPath();
            var5_6 = TextUtils.isEmpty((CharSequence)var4_5);
            if (var5_6 != 0) {
                return;
            }
            var5_6 = 75;
            var6_7 = Strings.getString(var5_6);
            var7_8 = ",";
            var6_7 = var6_7.split(var7_8);
            if (var6_7 == null) break block51;
            var8_9 = var6_7.length;
            if (var8_9 <= 0) break block51;
            var8_9 = var6_7.length;
            for (var9_10 = 0; var9_10 < var8_9; ++var9_10) {
                block52: {
                    var10_11 = var6_7[var9_10];
                    if (var10_11 == null) continue;
                    var10_11 = var10_11.trim();
                    var11_13 = TextUtils.isEmpty((CharSequence)var10_11);
                    if (var11_13) continue;
                    var13_15 /* !! */  = new StringBuilder();
                    var13_15 /* !! */ .append(var4_5);
                    var13_15 /* !! */ .append((String)var10_11);
                    var10_11 = var13_15 /* !! */ .toString();
                    var13_15 /* !! */  = new StringBuilder();
                    var14_16 = ".mn_";
                    var13_15 /* !! */ .append((String)var14_16);
                    var15_17 = 137;
                    var14_16 = Strings.getString(var15_17);
                    var13_15 /* !! */ .append((String)var14_16);
                    var13_15 /* !! */  = var13_15 /* !! */ .toString();
                    var12_14 = new File((String)var10_11, (String)var13_15 /* !! */ );
                    var10_11 = null;
                    var16_18 = var12_14.exists();
                    if (var16_18 == 0) break block52;
                    var16_18 = var12_14.isFile();
                    if (var16_18 == 0) break block52;
                    var10_11 = var12_14.getPath();
                    var10_11 = this.getMapFromOtherPlace((String)var10_11);
                }
                if (var10_11 != null) ** GOTO lbl72
                var10_11 = new HashMap();
lbl72:
                // 2 sources

                var13_15 /* !! */  = String.valueOf(var2_3);
                var10_11.put(var13_15 /* !! */ , var1_1);
                var13_15 /* !! */  = this.getSortWabcd((HashMap)var10_11);
                var14_16 = new StringBuilder();
                var14_16.append((String)var13_15 /* !! */ );
                var16_18 = 77;
                var13_15 /* !! */  = Strings.getString(var16_18);
                var14_16.append((String)var13_15 /* !! */ );
                var13_15 /* !! */  = var14_16.toString();
                var13_15 /* !! */  = Data.MD5((String)var13_15 /* !! */ );
                var15_17 = 78;
                var14_16 = Strings.getString(var15_17);
                var10_11.put(var14_16, var13_15 /* !! */ );
                var16_18 = 76;
                var13_15 /* !! */  = Strings.getString(var16_18);
                var14_16 = new Hashon();
                var10_11 = var14_16.fromHashMap((HashMap)var10_11);
                var10_11 = Data.AES128Encode((String)var13_15 /* !! */ , (String)var10_11);
                var12_14 = var12_14.getPath();
                try {
                    ResHelper.saveObjectToFile((String)var12_14, var10_11);
                }
                catch (Throwable var10_12) {
                    var12_14 = MobLog.getInstance();
                    var12_14.d(var10_12);
                }
                continue;
                {
                    catch (Throwable var1_2) {
                        var17_19 = MobLog.getInstance();
                        var17_19.d(var1_2);
                        break;
                    }
                }
            }
        }
    }

    public void scanBtList(int n10, DeviceHelper$BtScanCallback object) {
        Object object2 = this.context;
        object2 = BHelper.getInstance((Context)object2);
        DeviceHelper$6 deviceHelper$6 = new DeviceHelper$6(this, (DeviceHelper$BtScanCallback)object);
        try {
            ((BHelper)object2).findLEAndClassic(n10, deviceHelper$6);
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).d(throwable);
        }
    }

    public boolean scanWifiList() {
        block9: {
            Object object = "android.permission.CHANGE_WIFI_STATE";
            boolean bl2 = this.checkPermission((String)object);
            if (!bl2) break block9;
            object = "wifi";
            object = this.getSystemServiceSafe((String)object);
            if (object == null) {
                return false;
            }
            int n10 = 40;
            Object object2 = Strings.getString(n10);
            Object[] objectArray = new Object[]{};
            object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
            object = (Boolean)object;
            try {
                return (Boolean)object;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).w(throwable);
            }
        }
        return false;
    }

    public int sh(Context context) {
        int n10;
        Intent intent;
        String string2 = "android.intent.action.MAIN";
        try {
            intent = new Intent(string2);
            n10 = 0x10000000;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            MobLog.getInstance().d(activityNotFoundException);
            return 0;
        }
        intent.setFlags(n10);
        string2 = "android.intent.category.HOME";
        intent.addCategory(string2);
        string2 = "android.intent.category.DEFAULT";
        intent.addCategory(string2);
        context.startActivity(intent);
        return 1;
    }

    public void showSoftInput(View view) {
        Object object = this.getSystemServiceSafe("input_method");
        if (object == null) {
            return;
        }
        object = (InputMethodManager)object;
        view = view.getWindowToken();
        object.toggleSoftInputFromWindow((IBinder)view, 2, 0);
    }

    public int ss(Context context, Intent intent) {
        try {
            int n10;
            context = context.startService(intent);
            if (context == null) {
                n10 = 0;
                context = null;
            } else {
                n10 = 1;
            }
            return n10;
        }
        catch (SecurityException securityException) {
            MobLog.getInstance().d(securityException);
            return 2;
        }
    }

    public void unRegisterBtScanReceiver() {
        Object object = this.context;
        object = BHelper.getInstance((Context)object);
        try {
            ((BHelper)object).unRegisterBScanReceiver();
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
        }
    }

    public void unRegisterBtWatcher(String string2) {
        Object object = this.context;
        object = BHelper.getInstance((Context)object);
        try {
            ((BHelper)object).unRegisterBOperationReceiver(string2);
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).d(throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean usbEnable() {
        boolean bl3 = false;
        try {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 17;
            boolean bl2 = true;
            String string2 = "adb_enabled";
            if (n10 >= n11) {
                Context context = this.context;
                n10 = Settings.Secure.getInt((ContentResolver)(context = context.getContentResolver()), (String)string2, (int)0);
                if (n10 <= 0) return bl3;
                return bl2;
            } else {
                Context context = this.context;
                n10 = Settings.Secure.getInt((ContentResolver)(context = context.getContentResolver()), (String)string2, (int)0);
                if (n10 <= 0) return bl3;
            }
            return bl2;
        }
        catch (Throwable throwable) {}
        return bl3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean vpn() {
        Object object;
        Iterator iterator2 = NetworkInterface.getNetworkInterfaces();
        if (iterator2 == null) return false;
        iterator2 = Collections.list(iterator2);
        try {
            iterator2 = ((ArrayList)((Object)iterator2)).iterator();
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).d(throwable);
        }
        while (true) {
            boolean bl2 = iterator2.hasNext();
            if (!bl2) return false;
            object = iterator2.next();
            object = (NetworkInterface)object;
            int n10 = ((NetworkInterface)object).isUp();
            if (n10 == 0) continue;
            Object object2 = ((NetworkInterface)object).getInterfaceAddresses();
            n10 = object2.size();
            if (n10 == 0) continue;
            object2 = "tun0";
            String string2 = ((NetworkInterface)object).getName();
            n10 = (int)(((String)object2).equals(string2) ? 1 : 0);
            if (n10 != 0) return true;
            object2 = "ppp0";
            object = ((NetworkInterface)object).getName();
            bl2 = ((String)object2).equals(object);
            if (bl2) return true;
            continue;
            break;
        }
        return false;
    }
}

