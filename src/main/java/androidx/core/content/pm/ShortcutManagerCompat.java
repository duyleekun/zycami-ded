/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ShortcutInfo
 *  android.content.pm.ShortcutManager
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompat$Builder;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.content.pm.ShortcutInfoCompatSaver$NoopImpl;
import androidx.core.content.pm.ShortcutManagerCompat$1;
import androidx.core.content.pm.ShortcutManagerCompat$Api25Impl;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShortcutManagerCompat {
    public static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    private static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;
    public static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static volatile ShortcutInfoCompatSaver sShortcutInfoCompatSaver;

    private ShortcutManagerCompat() {
    }

    public static boolean addDynamicShortcuts(Context context, List list) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 <= n11) {
            ShortcutManagerCompat.convertUriIconsToBitmapIcons(context, list);
        }
        if (n10 >= (n11 = 25)) {
            boolean bl2;
            ArrayList<ShortcutInfo> arrayList = new ArrayList<ShortcutInfo>();
            ShortcutManager shortcutManager = list.iterator();
            while (bl2 = shortcutManager.hasNext()) {
                ShortcutInfo shortcutInfo = ((ShortcutInfoCompat)shortcutManager.next()).toShortcutInfo();
                arrayList.add(shortcutInfo);
            }
            shortcutManager = (ShortcutManager)context.getSystemService(ShortcutManager.class);
            n10 = (int)(shortcutManager.addDynamicShortcuts(arrayList) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).addShortcuts(list);
        return true;
    }

    public static boolean convertUriIconToBitmapIcon(Context object, ShortcutInfoCompat shortcutInfoCompat) {
        int n10;
        IconCompat iconCompat = shortcutInfoCompat.mIcon;
        if (iconCompat == null) {
            return false;
        }
        int n11 = iconCompat.mType;
        boolean bl2 = true;
        int n12 = 6;
        if (n11 != n12 && n11 != (n10 = 4)) {
            return bl2;
        }
        if ((object = iconCompat.getUriInputStream((Context)object)) == null) {
            return false;
        }
        if ((object = BitmapFactory.decodeStream((InputStream)object)) == null) {
            return false;
        }
        object = n11 == n12 ? IconCompat.createWithAdaptiveBitmap((Bitmap)object) : IconCompat.createWithBitmap((Bitmap)object);
        shortcutInfoCompat.mIcon = object;
        return bl2;
    }

    public static void convertUriIconsToBitmapIcons(Context context, List list) {
        boolean bl2;
        Object object = new ArrayList(list);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat)object.next();
            boolean bl3 = ShortcutManagerCompat.convertUriIconToBitmapIcon(context, shortcutInfoCompat);
            if (bl3) continue;
            list.remove(shortcutInfoCompat);
        }
    }

    public static Intent createShortcutResultIntent(Context context, ShortcutInfoCompat shortcutInfoCompat) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            context = (ShortcutManager)context.getSystemService(ShortcutManager.class);
            ShortcutInfo shortcutInfo = shortcutInfoCompat.toShortcutInfo();
            context = context.createShortcutResultIntent(shortcutInfo);
        } else {
            context = null;
        }
        if (context == null) {
            context = new Intent();
        }
        return shortcutInfoCompat.addToIntent((Intent)context);
    }

    public static void disableShortcuts(Context context, List list, CharSequence charSequence) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 >= n11) {
            ShortcutManager shortcutManager = (ShortcutManager)context.getSystemService(ShortcutManager.class);
            shortcutManager.disableShortcuts(list, charSequence);
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).removeShortcuts(list);
    }

    public static void enableShortcuts(Context context, List list) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 >= n11) {
            boolean bl2;
            n11 = list.size();
            ArrayList<String> arrayList = new ArrayList<String>(n11);
            ShortcutManager shortcutManager = list.iterator();
            while (bl2 = shortcutManager.hasNext()) {
                String string2 = ((ShortcutInfoCompat)shortcutManager.next()).mId;
                arrayList.add(string2);
            }
            shortcutManager = (ShortcutManager)context.getSystemService(ShortcutManager.class);
            shortcutManager.enableShortcuts(arrayList);
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).addShortcuts(list);
    }

    public static List getDynamicShortcuts(Context object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 >= n11) {
            Object object2 = ((ShortcutManager)object.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
            int n12 = object2.size();
            ArrayList<ShortcutInfo> arrayList = new ArrayList<ShortcutInfo>(n12);
            object2 = object2.iterator();
            while ((n12 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                Object object3 = (ShortcutInfo)object2.next();
                ShortcutInfoCompat$Builder shortcutInfoCompat$Builder = new ShortcutInfoCompat$Builder((Context)object, (ShortcutInfo)object3);
                object3 = shortcutInfoCompat$Builder.build();
                arrayList.add((ShortcutInfo)object3);
            }
            return arrayList;
        }
        try {
            object = ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object);
        }
        catch (Exception exception) {
            object = new ArrayList();
            return object;
        }
        return ((ShortcutInfoCompatSaver)object).getShortcuts();
    }

    private static int getIconDimensionInternal(Context context, boolean bl2) {
        int n10;
        ActivityManager activityManager = (ActivityManager)context.getSystemService("activity");
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 1;
        int n13 = 19;
        if (n11 >= n13 && activityManager != null && (n10 = activityManager.isLowRamDevice()) == 0) {
            n10 = 0;
            activityManager = null;
        } else {
            n10 = n12;
        }
        n10 = n10 != 0 ? 48 : 96;
        n10 = Math.max(n12, n10);
        context = context.getResources().getDisplayMetrics();
        float f10 = bl2 ? context.xdpi : context.ydpi;
        return (int)((float)n10 * (f10 /= 160.0f));
    }

    public static int getIconMaxHeight(Context context) {
        Preconditions.checkNotNull(context);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 >= n11) {
            return ((ShortcutManager)context.getSystemService(ShortcutManager.class)).getIconMaxHeight();
        }
        return ShortcutManagerCompat.getIconDimensionInternal(context, false);
    }

    public static int getIconMaxWidth(Context context) {
        Preconditions.checkNotNull(context);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 >= n11) {
            return ((ShortcutManager)context.getSystemService(ShortcutManager.class)).getIconMaxWidth();
        }
        return ShortcutManagerCompat.getIconDimensionInternal(context, true);
    }

    public static int getMaxShortcutCountPerActivity(Context context) {
        Preconditions.checkNotNull(context);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 >= n11) {
            return ((ShortcutManager)context.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
        }
        return 5;
    }

    private static String getShortcutInfoCompatWithLowestRank(List object) {
        boolean bl2;
        object = object.iterator();
        int n10 = -1;
        int n11 = 0;
        String string2 = null;
        while (bl2 = object.hasNext()) {
            ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat)object.next();
            int n12 = shortcutInfoCompat.getRank();
            if (n12 <= n10) continue;
            String string3 = shortcutInfoCompat.getId();
            n11 = shortcutInfoCompat.getRank();
            string2 = string3;
            n10 = n11;
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static ShortcutInfoCompatSaver getShortcutInfoSaverInstance(Context object) {
        Object object2 = sShortcutInfoCompatSaver;
        if (object2 == null) {
            ShortcutInfoCompatSaver shortcutInfoCompatSaver;
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 23;
            if (n10 >= n11) {
                object2 = ShortcutManagerCompat.class;
                try {
                    ShortcutInfoCompatSaver shortcutInfoCompatSaver2;
                    Class<Context> clazz;
                    object2 = ((Class)object2).getClassLoader();
                    String string2 = "androidx.sharetarget.ShortcutInfoCompatSaverImpl";
                    object2 = Class.forName(string2, false, (ClassLoader)object2);
                    string2 = "getInstance";
                    int n12 = 1;
                    Class[] classArray = new Class[n12];
                    classArray[0] = clazz = Context.class;
                    object2 = ((Class)object2).getMethod(string2, classArray);
                    n11 = 0;
                    string2 = null;
                    Object[] objectArray = new Object[n12];
                    objectArray[0] = object;
                    Object object3 = ((Method)object2).invoke(null, objectArray);
                    sShortcutInfoCompatSaver = shortcutInfoCompatSaver2 = (ShortcutInfoCompatSaver)object3;
                }
                catch (Exception exception) {}
            }
            if ((shortcutInfoCompatSaver = sShortcutInfoCompatSaver) == null) {
                ShortcutInfoCompatSaver$NoopImpl shortcutInfoCompatSaver$NoopImpl = new ShortcutInfoCompatSaver$NoopImpl();
                sShortcutInfoCompatSaver = shortcutInfoCompatSaver$NoopImpl;
            }
        }
        return sShortcutInfoCompatSaver;
    }

    public static List getShortcuts(Context object, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 30;
        if (n11 >= n12) {
            List list = ((ShortcutManager)object.getSystemService(ShortcutManager.class)).getShortcuts(n10);
            return ShortcutInfoCompat.fromShortcuts((Context)object, list);
        }
        n12 = 25;
        if (n11 >= n12) {
            List list;
            ShortcutManager shortcutManager = (ShortcutManager)object.getSystemService(ShortcutManager.class);
            ArrayList arrayList = new ArrayList();
            int n13 = n10 & 1;
            if (n13 != 0) {
                list = shortcutManager.getManifestShortcuts();
                arrayList.addAll(list);
            }
            if ((n13 = n10 & 2) != 0) {
                list = shortcutManager.getDynamicShortcuts();
                arrayList.addAll(list);
            }
            if ((n10 &= 4) != 0) {
                List list2 = shortcutManager.getPinnedShortcuts();
                arrayList.addAll(list2);
            }
            return ShortcutInfoCompat.fromShortcuts((Context)object, arrayList);
        }
        if ((n10 &= 2) != 0) {
            try {
                object = ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object);
            }
            catch (Exception exception) {}
            return ((ShortcutInfoCompatSaver)object).getShortcuts();
        }
        return Collections.emptyList();
    }

    public static boolean isRateLimitingActive(Context context) {
        int n10;
        Preconditions.checkNotNull(context);
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 25;
        if (n11 >= n12) {
            return ((ShortcutManager)context.getSystemService(ShortcutManager.class)).isRateLimitingActive();
        }
        List list = ShortcutManagerCompat.getShortcuts(context, 3);
        n11 = list.size();
        if (n11 == (n10 = ShortcutManagerCompat.getMaxShortcutCountPerActivity(context))) {
            n10 = 1;
        } else {
            n10 = 0;
            context = null;
        }
        return n10;
    }

    public static boolean isRequestPinShortcutSupported(Context object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return ((ShortcutManager)object.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
        }
        String string2 = INSTALL_SHORTCUT_PERMISSION;
        n11 = ContextCompat.checkSelfPermission((Context)object, string2);
        if (n11 != 0) {
            return false;
        }
        object = object.getPackageManager();
        String string3 = ACTION_INSTALL_SHORTCUT;
        Object object2 = new Intent(string3);
        object = object.queryBroadcastReceivers(object2, 0).iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = ((ResolveInfo)object.next()).activityInfo.permission;
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl2 && (n11 = (int)(string2.equals(object2) ? 1 : 0)) == 0) continue;
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean pushDynamicShortcut(Context object, ShortcutInfoCompat list) {
        Object object2;
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(list);
        int n10 = ShortcutManagerCompat.getMaxShortcutCountPerActivity((Context)object);
        if (n10 == 0) {
            return false;
        }
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 29;
        if (n11 <= n12) {
            ShortcutManagerCompat.convertUriIconToBitmapIcon((Context)object, list);
        }
        n12 = 30;
        boolean bl2 = true;
        if (n11 >= n12) {
            object2 = (ShortcutManager)object.getSystemService(ShortcutManager.class);
            ShortcutInfo shortcutInfo = ((ShortcutInfoCompat)((Object)list)).toShortcutInfo();
            object2.pushDynamicShortcut(shortcutInfo);
        } else {
            n12 = 25;
            if (n11 >= n12) {
                ShortcutInfo shortcutInfo;
                object2 = (ShortcutManager)object.getSystemService(ShortcutManager.class);
                n12 = (int)(object2.isRateLimitingActive() ? 1 : 0);
                if (n12 != 0) {
                    return false;
                }
                List list2 = object2.getDynamicShortcuts();
                int n13 = list2.size();
                if (n13 >= n10) {
                    shortcutInfo = new String[bl2];
                    String string2 = ShortcutManagerCompat$Api25Impl.getShortcutInfoWithLowestRank(list2);
                    shortcutInfo[0] = string2;
                    List list3 = Arrays.asList(shortcutInfo);
                    object2.removeDynamicShortcuts(list3);
                }
                ShortcutInfo[] shortcutInfoArray = new ShortcutInfo[bl2];
                shortcutInfoArray[0] = shortcutInfo = ((ShortcutInfoCompat)((Object)list)).toShortcutInfo();
                List<ShortcutInfo> list4 = Arrays.asList(shortcutInfoArray);
                object2.addDynamicShortcuts(list4);
            }
        }
        object = ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object);
        try {
            object2 = ((ShortcutInfoCompatSaver)object).getShortcuts();
            n12 = object2.size();
            if (n12 >= n10) {
                String[] stringArray = new String[bl2];
                stringArray[0] = object2 = ShortcutManagerCompat.getShortcutInfoCompatWithLowestRank((List)object2);
                List<String> list5 = Arrays.asList(stringArray);
                ((ShortcutInfoCompatSaver)object).removeShortcuts(list5);
            }
            ShortcutInfoCompat[] shortcutInfoCompatArray = new ShortcutInfoCompat[bl2];
            shortcutInfoCompatArray[0] = list;
            list = Arrays.asList(shortcutInfoCompatArray);
            ((ShortcutInfoCompatSaver)object).addShortcuts(list);
            return bl2;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static void removeAllDynamicShortcuts(Context context) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 >= n11) {
            ShortcutManager shortcutManager = (ShortcutManager)context.getSystemService(ShortcutManager.class);
            shortcutManager.removeAllDynamicShortcuts();
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).removeAllShortcuts();
    }

    public static void removeDynamicShortcuts(Context context, List list) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 >= n11) {
            ShortcutManager shortcutManager = (ShortcutManager)context.getSystemService(ShortcutManager.class);
            shortcutManager.removeDynamicShortcuts(list);
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).removeShortcuts(list);
    }

    public static void removeLongLivedShortcuts(Context context, List list) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 < n11) {
            ShortcutManagerCompat.removeDynamicShortcuts(context, list);
            return;
        }
        ((ShortcutManager)context.getSystemService(ShortcutManager.class)).removeLongLivedShortcuts(list);
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).removeShortcuts(list);
    }

    public static void reportShortcutUsed(Context context, String string2) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(string2);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 >= n11) {
            Class<ShortcutManager> clazz = ShortcutManager.class;
            context = (ShortcutManager)context.getSystemService(clazz);
            context.reportShortcutUsed(string2);
        }
    }

    public static boolean requestPinShortcut(Context context, ShortcutInfoCompat shortcutInfoCompat, IntentSender intentSender) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            context = (ShortcutManager)context.getSystemService(ShortcutManager.class);
            shortcutInfoCompat = shortcutInfoCompat.toShortcutInfo();
            return context.requestPinShortcut((ShortcutInfo)shortcutInfoCompat, intentSender);
        }
        n10 = (int)(ShortcutManagerCompat.isRequestPinShortcutSupported(context) ? 1 : 0);
        if (n10 == 0) {
            return false;
        }
        String string2 = ACTION_INSTALL_SHORTCUT;
        Intent intent = new Intent(string2);
        Intent intent2 = shortcutInfoCompat.addToIntent(intent);
        boolean bl2 = true;
        if (intentSender == null) {
            context.sendBroadcast(intent2);
            return bl2;
        }
        ShortcutManagerCompat$1 shortcutManagerCompat$1 = new ShortcutManagerCompat$1(intentSender);
        context.sendOrderedBroadcast(intent2, null, (BroadcastReceiver)shortcutManagerCompat$1, null, -1, null, null);
        return bl2;
    }

    public static boolean setDynamicShortcuts(Context context, List list) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(list);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 >= n11) {
            boolean bl2;
            n11 = list.size();
            ArrayList<ShortcutInfo> arrayList = new ArrayList<ShortcutInfo>(n11);
            ShortcutManager shortcutManager = list.iterator();
            while (bl2 = shortcutManager.hasNext()) {
                ShortcutInfo shortcutInfo = ((ShortcutInfoCompat)shortcutManager.next()).toShortcutInfo();
                arrayList.add(shortcutInfo);
            }
            shortcutManager = (ShortcutManager)context.getSystemService(ShortcutManager.class);
            n10 = (int)(shortcutManager.setDynamicShortcuts(arrayList) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).removeAllShortcuts();
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).addShortcuts(list);
        return true;
    }

    public static void setShortcutInfoCompatSaver(ShortcutInfoCompatSaver shortcutInfoCompatSaver) {
        sShortcutInfoCompatSaver = shortcutInfoCompatSaver;
    }

    public static boolean updateShortcuts(Context context, List list) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 <= n11) {
            ShortcutManagerCompat.convertUriIconsToBitmapIcons(context, list);
        }
        if (n10 >= (n11 = 25)) {
            boolean bl2;
            ArrayList<ShortcutInfo> arrayList = new ArrayList<ShortcutInfo>();
            ShortcutManager shortcutManager = list.iterator();
            while (bl2 = shortcutManager.hasNext()) {
                ShortcutInfo shortcutInfo = ((ShortcutInfoCompat)shortcutManager.next()).toShortcutInfo();
                arrayList.add(shortcutInfo);
            }
            shortcutManager = (ShortcutManager)context.getSystemService(ShortcutManager.class);
            n10 = (int)(shortcutManager.updateShortcuts(arrayList) ? 1 : 0);
            if (n10 == 0) {
                return false;
            }
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).addShortcuts(list);
        return true;
    }
}

