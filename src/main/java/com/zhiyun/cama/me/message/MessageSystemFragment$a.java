/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.widget.ImageView
 */
package com.zhiyun.cama.me.message;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.zhiyun.cama.data.database.model.MessageSystem;
import com.zhiyun.cama.me.message.MessageSystemFragment$a$a;
import com.zhiyun.common.util.Times;
import com.zhiyun.image.Images;
import d.v.c.h1.o;
import d.v.c.j1.b.k;
import d.v.c.j1.b.l;
import d.v.c.j1.b.m;
import d.v.c.j1.b.n;
import d.v.c.n0.e;
import d.v.c.v0.u.w;
import d.v.c.w0.if;
import d.v.c.w0.mf;
import d.v.e.l.h2;
import d.v.f.f.b;

public class MessageSystemFragment$a
extends o {
    private static int j = 10010;
    private static int k = 10011;
    private static DiffUtil$ItemCallback l;
    private b g;
    private b h;
    private b i;

    static {
        MessageSystemFragment$a$a messageSystemFragment$a$a = new MessageSystemFragment$a$a();
        l = messageSystemFragment$a$a;
    }

    public MessageSystemFragment$a() {
        DiffUtil$ItemCallback diffUtil$ItemCallback = l;
        super(diffUtil$ItemCallback);
    }

    private /* synthetic */ void o(int n10, MessageSystem messageSystem, View view) {
        this.h.a(view, n10, messageSystem);
    }

    private /* synthetic */ void q(int n10, MessageSystem messageSystem, View view) {
        this.g.a(view, n10, messageSystem);
    }

    private /* synthetic */ void s(int n10, MessageSystem messageSystem, View view) {
        this.g.a(view, n10, messageSystem);
    }

    private /* synthetic */ boolean u(int n10, MessageSystem messageSystem, View view) {
        this.i.a(view, n10, messageSystem);
        return true;
    }

    public int a(int n10) {
        int n11 = k;
        n10 = n10 == n11 ? 2131558707 : 2131558709;
        return n10;
    }

    public int getDefItemViewType(int n10) {
        String string2;
        Object object = (MessageSystem)this.getItem(n10 += -1);
        n10 = object != null && (n10 = (int)(((String)(object = ((MessageSystem)object).getVerb())).equals(string2 = "share_notice") ? 1 : 0)) != 0 ? k : j;
        return n10;
    }

    public void i(e e10, int n10) {
        Object object;
        int n11;
        MessageSystem messageSystem = (MessageSystem)this.getItem(n10);
        int n12 = n10 + 1;
        if ((n12 = this.getDefItemViewType(n12)) == (n11 = k)) {
            object = (if)e10.a;
            Object object2 = messageSystem.getTitle();
            ((if)object).A((String)object2);
            object2 = Times.getTimeZoneDescribe(messageSystem.getCreateAt());
            ((if)object).C((String)object2);
            ((if)object).B(n10);
            object2 = ((if)object).a;
            Object object3 = messageSystem.getAvatar();
            float f10 = 8.0f;
            int n13 = h2.b(f10);
            int n14 = 2131232234;
            Images.H((ImageView)object2, object3, n13, n14);
            object2 = ((if)object).b;
            object3 = w.b(messageSystem.getSourceUrls());
            int n15 = h2.b(f10);
            Images.H((ImageView)object2, object3, n15, n14);
            object2 = ((if)object).c;
            int n16 = 8;
            object2.setVisibility(n16);
            object2 = this.h;
            if (object2 != null) {
                object2 = ((if)object).a;
                object3 = new m(this, n10, messageSystem);
                object2.setOnClickListener((View.OnClickListener)object3);
            }
            if ((object2 = this.g) != null) {
                object = ((if)object).b;
                object2 = new n(this, n10, messageSystem);
                object.setOnClickListener((View.OnClickListener)object2);
            }
        } else {
            object = (mf)e10.a;
            Object object4 = messageSystem.getTitle();
            ((mf)object).G((String)object4);
            object4 = Times.getTimeZoneDescribe(messageSystem.getCreateAt());
            ((mf)object).J((String)object4);
            ((mf)object).H(n10);
            n11 = (int)(messageSystem.canGoNext() ? 1 : 0);
            ((mf)object).E(n11 != 0);
            object4 = messageSystem.getContent();
            ((mf)object).F((String)object4);
            n11 = messageSystem.showContent();
            ((mf)object).I(n11 != 0);
            object4 = this.g;
            if (object4 != null) {
                object = ((ViewDataBinding)object).getRoot();
                object4 = new l(this, n10, messageSystem);
                object.setOnClickListener((View.OnClickListener)object4);
            }
        }
        if ((object = this.i) != null) {
            e10 = e10.a.getRoot();
            object = new k(this, n10, messageSystem);
            e10.setOnLongClickListener((View.OnLongClickListener)object);
        }
    }

    public /* synthetic */ void p(int n10, MessageSystem messageSystem, View view) {
        this.o(n10, messageSystem, view);
    }

    public /* synthetic */ void r(int n10, MessageSystem messageSystem, View view) {
        this.q(n10, messageSystem, view);
    }

    public /* synthetic */ void t(int n10, MessageSystem messageSystem, View view) {
        this.s(n10, messageSystem, view);
    }

    public /* synthetic */ boolean v(int n10, MessageSystem messageSystem, View view) {
        return this.u(n10, messageSystem, view);
    }

    public void w(b b10) {
        this.i = b10;
    }

    public void x(b b10) {
        this.g = b10;
    }

    public void y(b b10) {
        this.h = b10;
    }
}

