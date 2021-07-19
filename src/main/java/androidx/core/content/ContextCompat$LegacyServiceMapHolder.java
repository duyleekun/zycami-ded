/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.AccountManager
 *  android.app.ActivityManager
 *  android.app.AlarmManager
 *  android.app.AppOpsManager
 *  android.app.DownloadManager
 *  android.app.KeyguardManager
 *  android.app.NotificationManager
 *  android.app.SearchManager
 *  android.app.UiModeManager
 *  android.app.WallpaperManager
 *  android.app.admin.DevicePolicyManager
 *  android.app.job.JobScheduler
 *  android.app.usage.UsageStatsManager
 *  android.appwidget.AppWidgetManager
 *  android.bluetooth.BluetoothManager
 *  android.content.ClipboardManager
 *  android.content.RestrictionsManager
 *  android.content.pm.LauncherApps
 *  android.hardware.ConsumerIrManager
 *  android.hardware.SensorManager
 *  android.hardware.camera2.CameraManager
 *  android.hardware.display.DisplayManager
 *  android.hardware.input.InputManager
 *  android.hardware.usb.UsbManager
 *  android.location.LocationManager
 *  android.media.AudioManager
 *  android.media.MediaRouter
 *  android.media.projection.MediaProjectionManager
 *  android.media.session.MediaSessionManager
 *  android.media.tv.TvInputManager
 *  android.net.ConnectivityManager
 *  android.net.nsd.NsdManager
 *  android.net.wifi.WifiManager
 *  android.net.wifi.p2p.WifiP2pManager
 *  android.nfc.NfcManager
 *  android.os.BatteryManager
 *  android.os.Build$VERSION
 *  android.os.DropBoxManager
 *  android.os.PowerManager
 *  android.os.UserManager
 *  android.os.Vibrator
 *  android.os.storage.StorageManager
 *  android.print.PrintManager
 *  android.telecom.TelecomManager
 *  android.telephony.SubscriptionManager
 *  android.telephony.TelephonyManager
 *  android.view.LayoutInflater
 *  android.view.WindowManager
 *  android.view.accessibility.AccessibilityManager
 *  android.view.accessibility.CaptioningManager
 *  android.view.inputmethod.InputMethodManager
 *  android.view.textservice.TextServicesManager
 */
package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.DropBoxManager;
import android.os.PowerManager;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import java.util.HashMap;

public final class ContextCompat$LegacyServiceMapHolder {
    public static final HashMap SERVICES;

    static {
        String string2;
        Class<TvInputManager> clazz;
        HashMap<Class<WindowManager>, Object> hashMap;
        SERVICES = hashMap = new HashMap<Class<WindowManager>, Object>();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 22;
        if (n10 >= n11) {
            hashMap.put(SubscriptionManager.class, "telephony_subscription_service");
            clazz = UsageStatsManager.class;
            string2 = "usagestats";
            hashMap.put(clazz, string2);
        }
        if (n10 >= (n11 = 21)) {
            hashMap.put(AppWidgetManager.class, "appwidget");
            hashMap.put(BatteryManager.class, "batterymanager");
            hashMap.put(CameraManager.class, "camera");
            hashMap.put(JobScheduler.class, "jobscheduler");
            hashMap.put(LauncherApps.class, "launcherapps");
            hashMap.put(MediaProjectionManager.class, "media_projection");
            hashMap.put(MediaSessionManager.class, "media_session");
            hashMap.put(RestrictionsManager.class, "restrictions");
            hashMap.put(TelecomManager.class, "telecom");
            clazz = TvInputManager.class;
            string2 = "tv_input";
            hashMap.put(clazz, string2);
        }
        if (n10 >= (n11 = 19)) {
            hashMap.put(AppOpsManager.class, "appops");
            hashMap.put(CaptioningManager.class, "captioning");
            hashMap.put(ConsumerIrManager.class, "consumer_ir");
            clazz = PrintManager.class;
            string2 = "print";
            hashMap.put(clazz, string2);
        }
        if (n10 >= (n11 = 18)) {
            clazz = BluetoothManager.class;
            string2 = "bluetooth";
            hashMap.put(clazz, string2);
        }
        if (n10 >= (n11 = 17)) {
            hashMap.put(DisplayManager.class, "display");
            clazz = UserManager.class;
            string2 = "user";
            hashMap.put(clazz, string2);
        }
        if (n10 >= (n11 = 16)) {
            hashMap.put(InputManager.class, "input");
            hashMap.put(MediaRouter.class, "media_router");
            Class<NsdManager> clazz2 = NsdManager.class;
            clazz = "servicediscovery";
            hashMap.put(clazz2, clazz);
        }
        hashMap.put(AccessibilityManager.class, "accessibility");
        hashMap.put(AccountManager.class, "account");
        hashMap.put(ActivityManager.class, "activity");
        hashMap.put(AlarmManager.class, "alarm");
        hashMap.put(AudioManager.class, "audio");
        hashMap.put(ClipboardManager.class, "clipboard");
        hashMap.put(ConnectivityManager.class, "connectivity");
        hashMap.put(DevicePolicyManager.class, "device_policy");
        hashMap.put(DownloadManager.class, "download");
        hashMap.put(DropBoxManager.class, "dropbox");
        hashMap.put(InputMethodManager.class, "input_method");
        hashMap.put(KeyguardManager.class, "keyguard");
        hashMap.put(LayoutInflater.class, "layout_inflater");
        hashMap.put(LocationManager.class, "location");
        hashMap.put(NfcManager.class, "nfc");
        hashMap.put(NotificationManager.class, "notification");
        hashMap.put(PowerManager.class, "power");
        hashMap.put(SearchManager.class, "search");
        hashMap.put(SensorManager.class, "sensor");
        hashMap.put(StorageManager.class, "storage");
        hashMap.put(TelephonyManager.class, "phone");
        hashMap.put(TextServicesManager.class, "textservices");
        hashMap.put(UiModeManager.class, "uimode");
        hashMap.put(UsbManager.class, "usb");
        hashMap.put(Vibrator.class, "vibrator");
        hashMap.put(WallpaperManager.class, "wallpaper");
        hashMap.put(WifiP2pManager.class, "wifip2p");
        hashMap.put(WifiManager.class, "wifi");
        hashMap.put(WindowManager.class, "window");
    }

    private ContextCompat$LegacyServiceMapHolder() {
    }
}

