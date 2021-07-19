/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 */
package l.a.m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import l.a.c;
import l.a.c$c;
import l.a.o.d;

public abstract class e
implements c$c {
    public Drawable a(Context context, String string2, int n10) {
        return null;
    }

    public String b(Context object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return string2;
        }
        bl2 = d.c((String)(object = this.f((Context)object, string2)));
        if (bl2) {
            boolean bl3;
            String string3 = c.r().s((String)object);
            c c10 = c.r();
            object = c10.t((String)object);
            if (object != null && !(bl3 = TextUtils.isEmpty((CharSequence)string3))) {
                l.a.j.a.d.h().x((Resources)object, string3, string2, this);
                return string2;
            }
        }
        return null;
    }

    public String c(Context context, String string2, int n10) {
        return null;
    }

    public ColorStateList d(Context context, String string2, int n10) {
        return null;
    }

    public ColorStateList e(Context context, String string2, int n10) {
        return null;
    }

    public abstract String f(Context var1, String var2);
}

