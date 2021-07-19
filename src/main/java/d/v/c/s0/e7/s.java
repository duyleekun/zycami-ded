/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Notification
 *  android.app.NotificationManager
 *  android.content.Context
 *  android.content.Intent
 */
package d.v.c.s0.e7;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantState;
import d.v.c.s0.e7.p;
import d.v.c.s0.e7.q$b;
import d.v.c.s0.e7.t;
import d.v.e.i.h;

public class s
extends AndroidViewModel {
    private final p a;
    private final MutableLiveData b;
    public boolean c;
    public boolean d;
    public boolean e;
    private int f;
    private Intent g;

    public s(Application application) {
        super(application);
        LiveAssistantState liveAssistantState = LiveAssistantState.CLOSE;
        Object object = new MutableLiveData((Object)liveAssistantState);
        this.b = object;
        this.a = object = new p((Context)application);
    }

    private void b(boolean bl2) {
        Notification notification = t.a((Context)this.getApplication(), bl2);
        ((NotificationManager)this.getApplication().getSystemService("notification")).notify(16521, notification);
    }

    public void c() {
        LiveAssistantState liveAssistantState = LiveAssistantState.CLOSE;
        this.s(liveAssistantState);
        this.a.f(false);
        this.b(false);
    }

    public void d(q$b q$b) {
        boolean bl2;
        this.e = bl2 = true;
        LiveAssistantState liveAssistantState = LiveAssistantState.OPEN_SUCCESS;
        this.s(liveAssistantState);
        this.a.f(bl2);
        this.a.d(q$b);
        this.b(bl2);
    }

    public void e(boolean bl2) {
        LiveAssistantState liveAssistantState = bl2 ? LiveAssistantState.OPEN : LiveAssistantState.CLOSE;
        this.s(liveAssistantState);
        this.b(bl2);
    }

    public void f() {
        this.a.a();
    }

    public void g() {
        t.c((Context)this.getApplication());
    }

    public void i() {
        this.a.f(false);
        this.b(false);
        this.a.a();
    }

    public void j() {
        this.a.b();
    }

    public MutableLiveData k() {
        return this.b;
    }

    public LiveAssistantState l() {
        Object object = this.b.getValue();
        object = object == null ? LiveAssistantState.CLOSE : (LiveAssistantState)((Object)this.b.getValue());
        return object;
    }

    public int m() {
        return this.f;
    }

    public Intent n() {
        return this.g;
    }

    public void o() {
        this.a.c();
    }

    public boolean p() {
        Intent intent;
        int n10 = this.f;
        if (n10 && (intent = this.g) != null) {
            n10 = 1;
        } else {
            n10 = 0;
            intent = null;
        }
        return n10 != 0;
    }

    public void r(int n10, Intent intent) {
        this.f = n10;
        this.g = intent;
    }

    public void s(LiveAssistantState liveAssistantState) {
        h.g(this.b, (Object)liveAssistantState);
    }

    public void t() {
        this.a.e();
    }
}

