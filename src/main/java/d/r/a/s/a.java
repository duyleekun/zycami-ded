/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.text.TextUtils
 */
package d.r.a.s;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import d.r.a.h$o;
import d.r.a.l;
import d.r.a.m;
import d.r.a.n;
import d.r.a.o;
import d.r.a.r.d;
import d.r.a.s.c;
import d.r.a.u.s;
import d.r.a.u.w;
import java.util.List;

public abstract class a
extends BroadcastReceiver
implements c {
    public static final String TAG = "PushMessageReceiver";

    public boolean isAllowNet(Context context) {
        int n10 = 0;
        Object object = null;
        String string2 = TAG;
        if (context == null) {
            s.a(string2, "isAllowNet sContext is null");
            return false;
        }
        String string3 = context.getPackageName();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            s.a(string2, "isAllowNet pkgName is null");
            return false;
        }
        object = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        object.setPackage(string3);
        PackageManager packageManager = context.getPackageManager();
        int n11 = 576;
        object = packageManager.queryIntentServices((Intent)object, n11);
        if (object != null && (n10 = object.size()) > 0) {
            return w.c(context, string3);
        }
        s.a(string2, "this is client sdk");
        return true;
    }

    public void onBind(Context context, int n10, String string2) {
    }

    public void onDelAlias(Context context, int n10, List list, List list2, String string2) {
    }

    public void onDelTags(Context context, int n10, List list, List list2, String string2) {
    }

    public void onListTags(Context context, int n10, List list, String string2) {
    }

    public void onLog(Context context, String string2, int n10, boolean bl2) {
    }

    public void onPublish(Context context, int n10, String string2) {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void onReceive(Context var1_1, Intent var2_3) {
        block35: {
            var3_4 = "PushMessageReceiver";
            var1_1 = d.r.a.u.c.c((Context)var1_1).getApplicationContext();
            l.b().d((Context)var1_1);
            var4_5 = "method";
            var5_6 = -1;
            var6_7 = var2_3 /* !! */ .getIntExtra((String)var4_5, var5_6);
            var7_8 = "req_id";
            var7_8 = var2_3 /* !! */ .getStringExtra(var7_8);
            var9_10 = "PushMessageReceiver ";
            var8_9 = new StringBuilder(var9_10);
            var1_1 = var1_1.getPackageName();
            var8_9.append((String)var1_1);
            var1_1 = " ; type = ";
            var8_9.append((String)var1_1);
            var8_9.append(var6_7);
            var1_1 = " ; requestId = ";
            var8_9.append((String)var1_1);
            var8_9.append(var7_8);
            var1_1 = var8_9.toString();
            s.m((String)var3_4, (String)var1_1);
            try {
                var1_1 = l.b();
            }
            catch (Exception v0) {
                v0.printStackTrace();
                return;
            }
            var3_4 = var1_1.q;
            var2_3 /* !! */  = var3_4.a(var2_3 /* !! */ );
            var3_4 = l.b();
            var3_4 = var3_4.g;
            var4_5 = "PushClientManager";
            if (var2_3 /* !! */  != null) ** GOTO lbl60
            var1_1 = "sendCommand, null command!";
            s.a((String)var4_5, (String)var1_1);
            if (var3_4 == null) ** GOTO lbl59
            var1_1 = "[\u6267\u884c\u6307\u4ee4\u5931\u8d25]\u6307\u4ee4\u7a7a\uff01";
            s.l((Context)var3_4, (String)var1_1);
lbl59:
            // 2 sources

            return;
lbl60:
            // 1 sources

            var1_1 = var1_1.q;
            var1_1 = var1_1.b((o)var2_3 /* !! */ );
            if (var1_1 != null) break block35;
            var7_8 = "sendCommand, null command task! pushCommand = ";
            var1_1 = new StringBuilder(var7_8);
            var1_1.append(var2_3 /* !! */ );
            var1_1 = var1_1.toString();
            s.a((String)var4_5, (String)var1_1);
            if (var3_4 == null) ** GOTO lbl88
            var4_5 = "[\u6267\u884c\u6307\u4ee4\u5931\u8d25]\u6307\u4ee4";
            var1_1 = new StringBuilder((String)var4_5);
            var1_1.append(var2_3 /* !! */ );
            var2_3 /* !! */  = "\u4efb\u52a1\u7a7a\uff01";
            var1_1.append((String)var2_3 /* !! */ );
            var1_1 = var1_1.toString();
            s.l((Context)var3_4, (String)var1_1);
lbl88:
            // 2 sources

            return;
        }
        if (var3_4 != null && (var6_7 = var2_3 /* !! */  instanceof h$o) == 0) {
            var7_8 = "[\u63a5\u6536\u6307\u4ee4]";
            var4_5 = new StringBuilder(var7_8);
            var4_5.append(var2_3 /* !! */ );
            var2_3 /* !! */  = var4_5.toString();
            s.e((Context)var3_4, (String)var2_3 /* !! */ );
        }
        var1_1.b(this);
        n.a((m)var1_1);
        return;
        catch (Exception var1_2) {
            s.i((String)var3_4, "get method error", var1_2);
            return;
        }
    }

    public void onSetAlias(Context context, int n10, List list, List list2, String string2) {
    }

    public void onSetTags(Context context, int n10, List list, List list2, String string2) {
    }

    public void onTransmissionMessage(Context context, d d10) {
    }

    public void onUnBind(Context context, int n10, String string2) {
    }
}

