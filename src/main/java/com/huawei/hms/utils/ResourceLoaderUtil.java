/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 */
package com.huawei.hms.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public abstract class ResourceLoaderUtil {
    public static Context a;
    public static String b;

    public static int getAnimId(String string2) {
        Resources resources = a.getResources();
        String string3 = b;
        return resources.getIdentifier(string2, "anim", string3);
    }

    public static int getColorId(String string2) {
        Resources resources = a.getResources();
        String string3 = b;
        return resources.getIdentifier(string2, "color", string3);
    }

    public static Drawable getDrawable(String string2) {
        Resources resources = a.getResources();
        int n10 = ResourceLoaderUtil.getDrawableId(string2);
        return resources.getDrawable(n10);
    }

    public static int getDrawableId(String string2) {
        Resources resources = a.getResources();
        String string3 = b;
        return resources.getIdentifier(string2, "drawable", string3);
    }

    public static int getIdId(String string2) {
        Resources resources = a.getResources();
        String string3 = b;
        return resources.getIdentifier(string2, "id", string3);
    }

    public static int getLayoutId(String string2) {
        Resources resources = a.getResources();
        String string3 = b;
        return resources.getIdentifier(string2, "layout", string3);
    }

    public static String getString(String string2) {
        Resources resources = a.getResources();
        int n10 = ResourceLoaderUtil.getStringId(string2);
        return resources.getString(n10);
    }

    public static String getString(String string2, Object ... objectArray) {
        Resources resources = a.getResources();
        int n10 = ResourceLoaderUtil.getStringId(string2);
        return resources.getString(n10, objectArray);
    }

    public static int getStringId(String string2) {
        Resources resources = a.getResources();
        String string3 = b;
        return resources.getIdentifier(string2, "string", string3);
    }

    public static int getStyleId(String string2) {
        Resources resources = a.getResources();
        String string3 = b;
        return resources.getIdentifier(string2, "style", string3);
    }

    public static Context getmContext() {
        return a;
    }

    public static void setmContext(Context context) {
        a = context;
        b = context.getPackageName();
    }
}

