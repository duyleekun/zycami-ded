/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.provider.Settings$System
 */
package d.r.a.u;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import d.r.a.u.h;
import d.r.a.u.n;
import d.r.a.u.s;

public final class z
implements h {
    private ContentResolver a;

    public final String a(String string2, String string3) {
        Object object = this.a;
        try {
            string3 = Settings.System.getString((ContentResolver)object, (String)string2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            String string4 = "getString error by ";
            object = new StringBuilder(string4);
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            object = "SettingsCache";
            s.h((String)object, string2);
        }
        return string3;
    }

    public final boolean a(Context context) {
        boolean bl2 = n.d();
        if (bl2) {
            context = context.getContentResolver();
            this.a = context;
            return true;
        }
        return false;
    }

    public final void b(String string2, String charSequence) {
        ContentResolver contentResolver;
        try {
            contentResolver = this.a;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            charSequence = new StringBuilder("putString error by ");
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            s.h("SettingsCache", string2);
            return;
        }
        Settings.System.putString((ContentResolver)contentResolver, (String)string2, (String)charSequence);
    }
}

