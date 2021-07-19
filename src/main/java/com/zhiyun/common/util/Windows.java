/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.os.Build$VERSION
 *  android.provider.Settings$SettingNotFoundException
 *  android.provider.Settings$System
 *  android.util.DisplayMetrics
 *  android.util.Size
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 */
package com.zhiyun.common.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import com.zhiyun.common.util.RomUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class Windows {
    private Windows() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    public static void A(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(4102);
    }

    public static void B(Window window, boolean bl2) {
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            layoutParams.layoutInDisplayCutoutMode = n10 = 1;
            window.setAttributes(layoutParams);
        }
        window.getDecorView().setSystemUiVisibility(5638);
        window.clearFlags(0x4000000);
        window.addFlags(-1 << -1);
        window.setStatusBarColor(0);
    }

    public static void a(View view) {
        Resources resources;
        int n10;
        Context context = view.getContext();
        int n11 = Windows.r(context);
        if (n11 != 0 && (n11 = view.getTop()) < (n10 = Windows.m(resources = view.getResources()))) {
            context = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
            context.topMargin = n10;
            view.setLayoutParams((ViewGroup.LayoutParams)context);
        }
    }

    public static void b(Context context, int n10) {
        context = ((Activity)context).getWindow();
        WindowManager.LayoutParams layoutParams = context.getAttributes();
        int n11 = -1;
        float f10 = 0.0f / 0.0f;
        if (n10 == n11) {
            float f11;
            n10 = -1082130432;
            layoutParams.screenBrightness = f11 = -1.0f;
        } else {
            float f12;
            if (n10 <= 0) {
                n10 = 1;
                f12 = Float.MIN_VALUE;
            }
            f12 = n10;
            n11 = 1132396544;
            f10 = 255.0f;
            layoutParams.screenBrightness = f12 /= f10;
        }
        context.setAttributes(layoutParams);
    }

    public static void c(Context context) {
        String string2;
        int n10 = 1;
        ContentResolver contentResolver = context.getContentResolver();
        int n11 = Settings.System.getInt((ContentResolver)contentResolver, (String)(string2 = "accelerometer_rotation"), (int)0);
        if (n10 != n11) {
            context = context.getContentResolver();
            Settings.System.putInt((ContentResolver)context, (String)string2, (int)n10);
        }
    }

    public static void d(Activity activity, boolean bl2) {
        int n10 = 128;
        if (bl2) {
            activity = activity.getWindow();
            activity.addFlags(n10);
        } else {
            activity = activity.getWindow();
            activity.clearFlags(n10);
        }
    }

    public static void e(Activity activity, boolean bl2) {
        int n10 = 524288;
        if (bl2) {
            activity = activity.getWindow();
            activity.addFlags(n10);
        } else {
            activity = activity.getWindow();
            activity.clearFlags(n10);
        }
    }

    public static DisplayMetrics f(Context context) {
        context = Windows.g(context).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    public static WindowManager g(Context context) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            Class<WindowManager> clazz = WindowManager.class;
            context = (WindowManager)context.getSystemService(clazz);
        } else {
            String string2 = "window";
            context = (WindowManager)context.getSystemService(string2);
        }
        return context;
    }

    public static int h(Context context) {
        context = context.getResources();
        int n10 = context.getIdentifier("navigation_bar_height", "dimen", "android");
        return context.getDimensionPixelSize(n10);
    }

    public static String i(Context context) {
        context = Windows.l(context);
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = context.getWidth();
        stringBuilder.append(n10);
        stringBuilder.append("x");
        int n11 = context.getHeight();
        stringBuilder.append(n11);
        return stringBuilder.toString();
    }

    public static int j(Context context) {
        return Windows.g(context).getDefaultDisplay().getRotation();
    }

    public static int k(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static Size l(Context context) {
        context = Windows.g(context).getDefaultDisplay();
        Point point = new Point();
        context.getRealSize(point);
        int n10 = point.x;
        int n11 = point.y;
        context = new Size(n10, n11);
        return context;
    }

    public static int m(Resources resources) {
        int n10 = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(n10);
    }

    public static int n(Context context) {
        String string2;
        try {
            context = context.getContentResolver();
            string2 = "screen_brightness";
        }
        catch (Settings.SettingNotFoundException settingNotFoundException) {
            settingNotFoundException.printStackTrace();
            return 127;
        }
        return Settings.System.getInt((ContentResolver)context, (String)string2);
    }

    public static Size o(Context context) {
        context = context.getResources().getDisplayMetrics();
        int n10 = context.widthPixels;
        int n11 = context.heightPixels;
        Size size = new Size(n10, n11);
        return size;
    }

    public static void p(Window window) {
        window.getDecorView().setSystemUiVisibility(4870);
    }

    public static boolean q(Context context) {
        int n10;
        context = context.getContentResolver();
        String string2 = "accelerometer_rotation";
        int n11 = 0;
        int n12 = Settings.System.getInt((ContentResolver)context, (String)string2, (int)0);
        if (n12 == (n10 = 1)) {
            n11 = n10;
        }
        return n11 != 0;
    }

    public static boolean r(Context object) {
        boolean bl2 = RomUtils.A();
        boolean bl3 = true;
        if (bl2) {
            object = object.getClassLoader();
            Object object2 = "android.os.SystemProperties";
            object = ((ClassLoader)object).loadClass((String)object2);
            object2 = "getInt";
            int n10 = 2;
            Object object3 = new Class[n10];
            Class clazz = String.class;
            object3[0] = clazz;
            clazz = Integer.TYPE;
            object3[bl3] = clazz;
            object2 = ((Class)object).getMethod((String)object2, (Class<?>)object3);
            Object[] objectArray = new Object[n10];
            object3 = "ro.miui.notch";
            objectArray[0] = object3;
            object3 = 0;
            objectArray[bl3] = object3;
            object = ((Method)object2).invoke(object, objectArray);
            object = (Integer)object;
            try {
                boolean bl4 = ((Integer)object).intValue();
                if (bl4 != bl3) {
                    bl3 = false;
                    Object var9_22 = null;
                }
                return bl3;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        } else {
            bl2 = RomUtils.m();
            if (bl2) {
                object = object.getClassLoader();
                Object object4 = "com.huawei.android.util.HwNotchSizeUtil";
                object = ((ClassLoader)object).loadClass((String)object4);
                object4 = "hasNotchInScreen";
                Object[] objectArray = new Class[]{};
                object4 = ((Class)object).getMethod((String)object4, (Class<?>[])objectArray);
                objectArray = new Object[]{};
                object = ((Method)object4).invoke(object, objectArray);
                object = (Boolean)object;
                try {
                    return (Boolean)object;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                bl2 = RomUtils.z();
                Object[] objectArray = "isFeatureSupport";
                if (bl2) {
                    object = object.getClassLoader();
                    Object object5 = "android.util.FtFeature";
                    object = ((ClassLoader)object).loadClass((String)object5);
                    object5 = new Class[bl3];
                    Class<Integer> clazz = Integer.TYPE;
                    object5[0] = clazz;
                    object5 = ((Class)object).getMethod((String)objectArray, (Class<?>)object5);
                    Object[] objectArray2 = new Object[bl3];
                    int n11 = 32;
                    objectArray = n11;
                    objectArray2[0] = objectArray;
                    object = ((Method)object5).invoke(object, objectArray2);
                    object = (Boolean)object;
                    try {
                        return (Boolean)object;
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } else {
                    bl2 = RomUtils.u();
                    if (bl2) {
                        return object.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
                    }
                    bl2 = RomUtils.q();
                    if (bl2) {
                        object = "flyme.config.FlymeFeature";
                        object = Class.forName((String)object);
                        String string2 = "IS_FRINGE_DEVICE";
                        object = ((Class)object).getDeclaredField(string2);
                        bl2 = false;
                        string2 = null;
                        object = ((Field)object).get(null);
                        object = (Boolean)object;
                        try {
                            return (Boolean)object;
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    } else {
                        bl2 = RomUtils.x();
                        if (bl2) {
                            object = object.getClassLoader();
                            Object object6 = "smartisanos.api.DisplayUtilsSmt";
                            object = ((ClassLoader)object).loadClass((String)object6);
                            object6 = new Class[bl3];
                            Class<Integer> clazz = Integer.TYPE;
                            object6[0] = clazz;
                            object6 = ((Class)object).getMethod((String)objectArray, (Class<?>)object6);
                            objectArray = new Object[bl3];
                            Integer n12 = (int)(bl3 ? 1 : 0);
                            objectArray[0] = n12;
                            object = ((Method)object6).invoke(object, objectArray);
                            object = (Boolean)object;
                            try {
                                return (Boolean)object;
                            }
                            catch (Exception exception) {
                                exception.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean s(Context context) {
        boolean bl2 = true;
        if (context != null) {
            int n10;
            int n11 = (context = Windows.g(context).getDefaultDisplay()).getRotation();
            if (n11 != 0 && n11 != (n10 = 2)) {
                bl2 = false;
            }
            return bl2;
        }
        context = Resources.getSystem().getDisplayMetrics();
        int n12 = context.widthPixels;
        int n13 = context.heightPixels;
        if (n12 >= n13) {
            bl2 = false;
        }
        return bl2;
    }

    public static void t(Activity activity, boolean bl2) {
        WindowManager.LayoutParams layoutParams = activity.getWindow().getAttributes();
        if (bl2) {
            float f10;
            int n10 = 1065353216;
            layoutParams.screenBrightness = f10 = 1.0f;
        } else {
            float f11;
            int n11 = -1082130432;
            layoutParams.screenBrightness = f11 = -1.0f;
        }
        activity.getWindow().setAttributes(layoutParams);
    }

    public static void u(Activity activity, boolean bl2) {
        WindowManager.LayoutParams layoutParams = activity.getWindow().getAttributes();
        if (bl2) {
            boolean bl3 = false;
            float f10 = 0.0f;
            layoutParams.screenBrightness = 0.0f;
        } else {
            float f11;
            int n10 = -1082130432;
            layoutParams.screenBrightness = f11 = -1.0f;
        }
        activity.getWindow().setAttributes(layoutParams);
    }

    public static void v(AppCompatActivity appCompatActivity) {
        Windows.A(appCompatActivity);
        Windows.d(appCompatActivity, true);
        Windows.e(appCompatActivity, false);
        Windows.t(appCompatActivity, false);
    }

    public static void w(Activity activity) {
        activity.setRequestedOrientation(8);
    }

    public static void x(Activity activity) {
        activity.setRequestedOrientation(0);
    }

    public static void y(Activity activity) {
        activity.setRequestedOrientation(9);
    }

    public static void z(Activity activity) {
        activity.setRequestedOrientation(1);
    }
}

