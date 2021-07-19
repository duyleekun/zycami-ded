/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningTaskInfo
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package d.r.a.i;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import d.r.a.i.m;
import d.r.a.u.s;
import java.util.Map;

public final class m$e
implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ m d;

    public m$e(m m10, Context context, String string2, Map map) {
        this.d = m10;
        this.a = context;
        this.b = string2;
        this.c = map;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Object object = "OnNotificationClickTask";
        CharSequence charSequence = this.a.getPackageName();
        Object object2 = this.b;
        int n10 = TextUtils.isEmpty((CharSequence)object2);
        if (n10 == 0) {
            charSequence = this.b;
        }
        object2 = this.a;
        String string2 = "activity";
        object2 = (ActivityManager)object2.getSystemService(string2);
        int n11 = 100;
        try {
            object2 = object2.getRunningTasks(n11);
            if (object2 != null) {
                object2 = object2.iterator();
                while ((n11 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                    string2 = object2.next();
                    string2 = (ActivityManager.RunningTaskInfo)string2;
                    string2 = ((ActivityManager.RunningTaskInfo)string2).topActivity;
                    String string3 = string2.getPackageName();
                    boolean bl2 = string3.equals(charSequence);
                    if (!bl2) continue;
                    object2 = "topClassName=";
                    charSequence = new StringBuilder((String)object2);
                    object2 = string2.getClassName();
                    ((StringBuilder)charSequence).append((String)object2);
                    charSequence = ((StringBuilder)charSequence).toString();
                    s.m((String)object, (String)charSequence);
                    charSequence = new Intent();
                    charSequence.setComponent((ComponentName)string2);
                    n10 = 0x10200000;
                    charSequence.setFlags(n10);
                    object2 = this.c;
                    m.e((Intent)charSequence, (Map)object2);
                    object2 = this.a;
                    object2.startActivity((Intent)charSequence);
                    return;
                }
            }
        }
        catch (Exception exception) {
            object2 = "start recentIntent is error";
            s.b((String)object, object2, exception);
        }
        charSequence = this.a.getPackageManager();
        object2 = this.b;
        n10 = TextUtils.isEmpty((CharSequence)object2);
        object2 = n10 == 0 ? this.b : this.a.getPackageName();
        charSequence = charSequence.getLaunchIntentForPackage((String)object2);
        if (charSequence != null) {
            charSequence.setFlags(0x10000000);
            object = this.c;
            m.e((Intent)charSequence, (Map)object);
            this.a.startActivity((Intent)charSequence);
            return;
        }
        s.a((String)object, "LaunchIntent is null");
    }
}

