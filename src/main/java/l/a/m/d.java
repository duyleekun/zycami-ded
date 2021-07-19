/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 */
package l.a.m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import l.a.c$c;

public class d
implements c$c {
    public Drawable a(Context context, String string2, int n10) {
        return null;
    }

    public String b(Context object, String string2) {
        l.a.j.a.d d10 = l.a.j.a.d.h();
        Resources resources = object.getResources();
        object = object.getPackageName();
        d10.x(resources, (String)object, string2, this);
        return string2;
    }

    public String c(Context object, String string2, int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("_");
        object = object.getResources().getResourceEntryName(n10);
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public ColorStateList d(Context context, String string2, int n10) {
        return null;
    }

    public ColorStateList e(Context context, String string2, int n10) {
        return null;
    }

    public int getType() {
        return 2;
    }
}

