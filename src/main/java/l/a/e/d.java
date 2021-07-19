/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.Window
 */
package l.a.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;
import l.a.c;
import l.a.e.e;
import l.a.j.a.h;
import l.a.n.a;
import l.a.n.b;
import l.a.q.j;

public class d
extends AppCompatActivity
implements b {
    private e a;

    public void b(a a10, Object object) {
        this.f();
        this.h();
        this.d().a();
    }

    public e d() {
        e e10 = this.a;
        if (e10 == null) {
            this.a = e10 = e.b((Context)this);
        }
        return this.a;
    }

    public void f() {
    }

    public void h() {
        Drawable drawable2;
        int n10 = l.a.j.a.e.h((Context)this);
        int n11 = j.b(n10);
        if (n11 != 0 && (drawable2 = h.a((Context)this, n10)) != null) {
            Window window = this.getWindow();
            window.setBackgroundDrawable(drawable2);
        }
    }

    public void onCreate(Bundle bundle) {
        LayoutInflater layoutInflater = this.getLayoutInflater();
        e e10 = this.d();
        LayoutInflaterCompat.setFactory2(layoutInflater, e10);
        super.onCreate(bundle);
        this.f();
        this.h();
    }

    public void onDestroy() {
        super.onDestroy();
        c.r().c(this);
    }

    public void onResume() {
        super.onResume();
        c.r().a(this);
    }
}

