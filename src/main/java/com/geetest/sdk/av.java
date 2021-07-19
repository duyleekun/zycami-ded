/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import java.util.Observable;
import java.util.Observer;

public abstract class av
implements Observer {
    public abstract void a();

    public abstract void a(String var1, String var2);

    public abstract void a(boolean var1, String var2);

    public abstract void b();

    public void update(Observable observable, Object object) {
    }
}

