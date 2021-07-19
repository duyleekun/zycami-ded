/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.View
 *  android.view.Window
 */
package d.l.a.g;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;

public final class d {
    public static int a(Context object, String string2) {
        Resources resources = object.getResources();
        object = object.getPackageName();
        return resources.getIdentifier(string2, "anim", (String)object);
    }

    public static int b(Context object, String string2) {
        Resources resources = object.getResources();
        object = object.getPackageName();
        return resources.getIdentifier(string2, "drawable", (String)object);
    }

    public static int c(Context object, String string2) {
        Resources resources = object.getResources();
        object = object.getPackageName();
        return resources.getIdentifier(string2, "id", (String)object);
    }

    public static int d(Context object, String string2) {
        Resources resources = object.getResources();
        object = object.getPackageName();
        return resources.getIdentifier(string2, "layout", (String)object);
    }

    public static int e(Context object, String string2) {
        Resources resources = object.getResources();
        object = object.getPackageName();
        return resources.getIdentifier(string2, "style", (String)object);
    }

    public static View f(Activity activity, String string2) {
        Resources resources = activity.getResources();
        String string3 = activity.getPackageName();
        int n10 = resources.getIdentifier(string2, "id", string3);
        return activity.findViewById(n10);
    }

    public static View g(Context object, View view, String string2) {
        Resources resources = object.getResources();
        object = object.getPackageName();
        int n10 = resources.getIdentifier(string2, "id", (String)object);
        return view.findViewById(n10);
    }

    public static View h(Context object, Window window, String string2) {
        Resources resources = object.getResources();
        object = object.getPackageName();
        int n10 = resources.getIdentifier(string2, "id", (String)object);
        return window.findViewById(n10);
    }

    public static String i(Context object, String string2) {
        Resources resources = object.getResources();
        Resources resources2 = object.getResources();
        object = object.getPackageName();
        int n10 = resources2.getIdentifier(string2, "string", (String)object);
        return resources.getString(n10);
    }
}

