/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 */
package d.r.a.s.f;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import d.r.a.s.e;
import d.r.a.u.c;
import d.r.a.u.s;

public class a
extends Service {
    public boolean a(String string2) {
        return "com.vivo.pushservice.action.RECEIVE".equals(string2);
    }

    public IBinder onBind(Intent intent) {
        s.k("CommandService", "onBind initSuc: ");
        return null;
    }

    public void onCreate() {
        CharSequence charSequence = new StringBuilder();
        String string2 = ((Object)((Object)this)).getClass().getSimpleName();
        charSequence.append(string2);
        charSequence.append(" -- oncreate ");
        string2 = this.getPackageName();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        s.k("CommandService", (String)charSequence);
        super.onCreate();
        charSequence = c.c(this.getApplicationContext());
        e.d().a((Context)charSequence);
    }

    public void onDestroy() {
        super.onDestroy();
        CharSequence charSequence = new StringBuilder();
        String string2 = ((Object)((Object)this)).getClass().getSimpleName();
        charSequence.append(string2);
        charSequence.append(" -- onDestroy ");
        string2 = this.getPackageName();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        s.k("CommandService", (String)charSequence);
    }

    public int onStartCommand(Intent object, int n10, int n11) {
        CharSequence charSequence = new StringBuilder();
        String string2 = ((Object)((Object)this)).getClass().getSimpleName();
        charSequence.append(string2);
        charSequence.append(" -- onStartCommand ");
        string2 = this.getPackageName();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        string2 = "CommandService";
        s.k(string2, (String)charSequence);
        n10 = 2;
        if (object == null) {
            return n10;
        }
        Object object2 = object.getAction();
        boolean bl2 = this.a((String)object2);
        if (!bl2) {
            object2 = new StringBuilder();
            String string3 = this.getPackageName();
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(" receive invalid action ");
            object = object.getAction();
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            s.a(string2, (String)object);
            return n10;
        }
        object2 = e.d();
        try {
            ((e)object2).f((Intent)object);
        }
        catch (Exception exception) {
            object2 = "onStartCommand -- error";
            s.b(string2, (String)object2, exception);
        }
        return n10;
    }

    public boolean onUnbind(Intent intent) {
        s.k("CommandService", "onUnbind");
        return super.onUnbind(intent);
    }
}

