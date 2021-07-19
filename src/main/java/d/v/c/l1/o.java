/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 */
package d.v.c.l1;

import android.app.Application;
import d.v.c.l1.b0;
import d.v.w.y;
import java.util.Observable;
import java.util.Observer;

public final class o
implements Observer {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ Application b;
    public final /* synthetic */ y c;

    public /* synthetic */ o(b0 b02, Application application, y y10) {
        this.a = b02;
        this.b = application;
        this.c = y10;
    }

    public final void update(Observable observable, Object object) {
        b0 b02 = this.a;
        Application application = this.b;
        y y10 = this.c;
        b02.k(application, y10, observable, object);
    }
}

