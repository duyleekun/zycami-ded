/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.util.Log
 */
package d.l.a.f.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.kwai.auth.common.InternalRequest;
import d.l.a.c;
import d.l.a.f.b.a;
import d.l.a.g.d;

public class a$a
implements Runnable {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ String b;
    public final /* synthetic */ c c;
    public final /* synthetic */ a d;

    public a$a(a a10, Activity activity, String string2, c c10) {
        this.d = a10;
        this.a = activity;
        this.b = string2;
        this.c = c10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object = "GameKwaiLoginRequest";
        Object object2 = d.l.a.f.b.a.a(this.d);
        Activity activity = this.a;
        Object object3 = this.b;
        object2 = ((InternalRequest)object2).buildIntent(activity, (String)object3);
        activity = new Bundle();
        object3 = this.d;
        Activity activity2 = this.a;
        d.l.a.f.b.a.b((a)object3, activity2, (Bundle)activity);
        object2.putExtras((Bundle)activity);
        activity = null;
        try {
            object3 = this.a;
            int n10 = object3.isFinishing();
            if (n10 != 0) {
                object2 = "Please don't finish activity";
                Log.e((String)object, (String)object2);
                return;
            }
            object3 = this.a;
            object3.startActivityForResult((Intent)object2, 0);
            object2 = this.d;
            object2 = d.l.a.f.b.a.a((a)object2);
            boolean bl2 = ((InternalRequest)object2).hasForwardAnime();
            if (!bl2) return;
            object2 = this.a;
            object3 = "kwai_fade_in";
            n10 = d.l.a.g.d.a((Context)object2, (String)object3);
            object2.overridePendingTransition(n10, 0);
            return;
        }
        catch (Exception exception) {
            object2 = "Kwai activity not found";
            Log.e((String)object, (String)object2);
            object = this.c.g();
            object3 = "fail";
            object.onFailed((String)object3, 0, (String)object2);
        }
    }
}

