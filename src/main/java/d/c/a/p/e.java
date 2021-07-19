/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.net.ConnectivityManager
 *  android.util.Log
 */
package d.c.a.p;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;
import d.c.a.p.c;
import d.c.a.p.c$a;
import d.c.a.p.e$a;
import d.c.a.u.k;

public final class e
implements c {
    private static final String f = "ConnectivityMonitor";
    private final Context a;
    public final c$a b;
    public boolean c;
    private boolean d;
    private final BroadcastReceiver e;

    public e(Context context, c$a c$a) {
        e$a e$a = new e$a(this);
        this.e = e$a;
        this.a = context = context.getApplicationContext();
        this.b = c$a;
    }

    private void c() {
        block8: {
            boolean bl2 = this.d;
            if (bl2) {
                return;
            }
            Context context = this.a;
            this.c = bl2 = this.b(context);
            context = this.a;
            Object object = this.e;
            String string2 = "android.net.conn.CONNECTIVITY_CHANGE";
            String string3 = new IntentFilter(string2);
            context.registerReceiver(object, (IntentFilter)string3);
            bl2 = true;
            try {
                this.d = bl2;
            }
            catch (SecurityException securityException) {
                string3 = f;
                boolean bl3 = Log.isLoggable((String)string3, (int)5);
                if (!bl3) break block8;
                object = "Failed to register";
                Log.w((String)string3, (String)object, (Throwable)securityException);
            }
        }
    }

    private void d() {
        boolean bl2 = this.d;
        if (!bl2) {
            return;
        }
        Context context = this.a;
        BroadcastReceiver broadcastReceiver = this.e;
        context.unregisterReceiver(broadcastReceiver);
        this.d = false;
    }

    public boolean b(Context context) {
        boolean bl2;
        String string2 = "connectivity";
        context = (ConnectivityManager)k.d((ConnectivityManager)context.getSystemService(string2));
        boolean bl3 = true;
        try {
            context = context.getActiveNetworkInfo();
        }
        catch (RuntimeException runtimeException) {
            String string3 = f;
            boolean bl4 = Log.isLoggable((String)string3, (int)5);
            if (bl4) {
                String string4 = "Failed to determine connectivity status when connectivity changed";
                Log.w((String)string3, (String)string4, (Throwable)runtimeException);
            }
            return bl3;
        }
        if (context == null || !(bl2 = context.isConnected())) {
            bl3 = false;
            string2 = null;
        }
        return bl3;
    }

    public void onDestroy() {
    }

    public void onStart() {
        this.c();
    }

    public void onStop() {
        this.d();
    }
}

