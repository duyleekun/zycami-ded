/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Color
 */
package d.r.a.u;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import d.r.a.u.b;
import d.r.a.u.d0;
import d.r.a.u.n;

public final class m
implements b {
    private Resources a;
    private String b;

    public final void a(Context context) {
        String string2;
        this.b = string2 = context.getPackageName();
        context = context.getResources();
        this.a = context;
    }

    public final int b() {
        Resources resources = this.a;
        String string2 = this.b;
        return resources.getIdentifier("push_notify", "layout", string2);
    }

    public final int c() {
        int n10;
        Object object = "com.android.internal.R$color";
        String string2 = "vivo_notification_title_text_color";
        object = d0.b((String)object, string2);
        object = (Integer)object;
        try {
            n10 = (Integer)object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            n10 = 0;
            object = null;
        }
        if (n10 > 0) {
            return this.a.getColor(n10);
        }
        n10 = (int)(n.g ? 1 : 0);
        int n11 = -1;
        if (n10 != 0) {
            return n11;
        }
        boolean bl2 = n.f;
        if (bl2) {
            if (n10 != 0) {
                return Color.parseColor((String)"#ff999999");
            }
            return n11;
        }
        return -16777216;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final int d() {
        String string2;
        String string3;
        Resources resources;
        boolean bl2 = n.g;
        String string4 = "id";
        if (bl2) {
            resources = this.a;
            string3 = this.b;
            string2 = "notify_icon_rom30";
            return resources.getIdentifier(string2, string4, string3);
        }
        bl2 = n.f;
        if (bl2) {
            resources = this.a;
            string3 = this.b;
            string2 = "notify_icon_rom20";
            return resources.getIdentifier(string2, string4, string3);
        }
        resources = this.a;
        string3 = this.b;
        string2 = "notify_icon";
        return resources.getIdentifier(string2, string4, string3);
    }
}

