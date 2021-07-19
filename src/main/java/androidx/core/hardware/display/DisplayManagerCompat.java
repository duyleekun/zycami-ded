/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.display.DisplayManager
 *  android.os.Build$VERSION
 *  android.view.Display
 *  android.view.WindowManager
 */
package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import java.util.WeakHashMap;

public final class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap sInstances;
    private final Context mContext;

    static {
        WeakHashMap weakHashMap;
        sInstances = weakHashMap = new WeakHashMap();
    }

    private DisplayManagerCompat(Context context) {
        this.mContext = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static DisplayManagerCompat getInstance(Context context) {
        WeakHashMap weakHashMap = sInstances;
        synchronized (weakHashMap) {
            Object object = weakHashMap.get(context);
            object = (DisplayManagerCompat)object;
            if (object == null) {
                object = new Object(context);
                weakHashMap.put(context, object);
            }
            return object;
        }
    }

    public Display getDisplay(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 17;
        if (n11 >= n12) {
            return ((DisplayManager)this.mContext.getSystemService("display")).getDisplay(n10);
        }
        Context context = this.mContext;
        String string2 = "window";
        n12 = (context = ((WindowManager)context.getSystemService(string2)).getDefaultDisplay()).getDisplayId();
        if (n12 == n10) {
            return context;
        }
        return null;
    }

    public Display[] getDisplays() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return ((DisplayManager)this.mContext.getSystemService("display")).getDisplays();
        }
        Display display = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
        Display[] displayArray = new Display[]{display};
        return displayArray;
    }

    public Display[] getDisplays(String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return ((DisplayManager)this.mContext.getSystemService("display")).getDisplays(string2);
        }
        n10 = 0;
        if (string2 == null) {
            return new Display[0];
        }
        string2 = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
        Display[] displayArray = new Display[]{string2};
        return displayArray;
    }
}

