/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.view.View
 *  android.widget.SeekBar
 */
package com.zhiyun.cama.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.SeekBar;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.cama.help.EditorHelpActivity;
import com.zhiyun.cama.main.EditorMainActivity;
import d.v.c.b1.t.g;
import d.v.c.i1.b;
import d.v.c.i1.c;
import d.v.c.i1.i2;
import d.v.c.m1.d.l;
import d.v.c.m1.d.l$b;
import d.v.c.q0.f.a;
import d.v.e.l.n2;

public class EditorMainActivity$b
implements a {
    public final /* synthetic */ EditorMainActivity a;

    public EditorMainActivity$b(EditorMainActivity editorMainActivity) {
        this.a = editorMainActivity;
    }

    private /* synthetic */ void d() {
        d.v.c.m1.b.d(this.a);
    }

    private /* synthetic */ void f() {
        d.v.c.m1.b.d(this.a);
    }

    public void a(View object) {
        object = EditorMainActivity.i(this.a);
        boolean bl2 = ((i2)object).A1();
        if (bl2) {
            this.i();
        } else {
            object = this.a;
            EditorMainActivity.k((EditorMainActivity)object);
        }
    }

    public void b(View object) {
        long l10;
        object = this.a;
        int n10 = 1;
        Object object2 = EditorMainActivity.l((EditorMainActivity)object, n10);
        if (object2 == 0) {
            return;
        }
        object = EditorMainActivity.i(this.a);
        object2 = ((i2)object).F();
        n10 = 2131952070;
        int n11 = 2;
        if (object2 == 0) {
            object2 = d.v.c.m1.b.a();
            if (object2 != 0) {
                object = d.v.f.i.g.o(this.a.getResources(), n10);
                n2.e((String)object);
            } else {
                object = l.y(n11);
                Object object3 = new c(this);
                object = ((l)object).z((l$b)object3);
                object3 = this.a.getSupportFragmentManager();
                ((d.v.f.g.b)object).q((FragmentManager)object3);
            }
            return;
        }
        object = EditorMainActivity.i(this.a);
        long l11 = ((i2)object).d2();
        long l12 = l11 - (l10 = 300000000L);
        object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 < 0) {
            object = this.a;
            EditorMainActivity.m((EditorMainActivity)object);
        } else {
            object2 = d.v.c.m1.b.a();
            if (object2 == 0) {
                object = l.y(n11);
                Object object4 = new b(this);
                object = ((l)object).z((l$b)object4);
                object4 = this.a.getSupportFragmentManager();
                ((d.v.f.g.b)object).q((FragmentManager)object4);
            } else {
                object = EditorMainActivity.i(this.a);
                object2 = ((i2)object).F();
                if (object2 != 0) {
                    object = this.a;
                    EditorMainActivity.m((EditorMainActivity)object);
                } else {
                    object = d.v.f.i.g.o(this.a.getResources(), n10);
                    n2.e((String)object);
                }
            }
        }
    }

    public void c() {
        EditorMainActivity editorMainActivity = this.a;
        EditorMainActivity editorMainActivity2 = this.a;
        Intent intent = new Intent((Context)editorMainActivity2, EditorHelpActivity.class);
        editorMainActivity.startActivity(intent);
    }

    public /* synthetic */ void e() {
        this.d();
    }

    public /* synthetic */ void g() {
        this.f();
    }

    public void h(SeekBar object, int n10, boolean bl2) {
        if (bl2) {
            object = EditorMainActivity.i(this.a);
            long l10 = n10;
            g g10 = EditorMainActivity.i(this.a);
            long l11 = g10.d2();
            l10 *= l11;
            l11 = 100;
            ((i2)object).a3(l10 /= l11);
        }
    }

    public void i() {
        EditorMainActivity.j(this.a);
    }
}

