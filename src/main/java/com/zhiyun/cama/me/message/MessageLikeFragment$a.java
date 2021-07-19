/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 */
package com.zhiyun.cama.me.message;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.zhiyun.cama.data.database.model.MessageLike;
import com.zhiyun.cama.me.message.MessageLikeFragment$a$a;
import com.zhiyun.common.util.Times;
import com.zhiyun.image.Images;
import d.v.c.h1.o;
import d.v.c.j1.b.d;
import d.v.c.j1.b.f;
import d.v.c.n0.e;
import d.v.c.v0.u.w;
import d.v.c.w0.if;
import d.v.e.l.h2;
import d.v.f.f.b;

public class MessageLikeFragment$a
extends o {
    private static DiffUtil$ItemCallback i;
    private b g;
    private b h;

    static {
        MessageLikeFragment$a$a messageLikeFragment$a$a = new MessageLikeFragment$a$a();
        i = messageLikeFragment$a$a;
    }

    public MessageLikeFragment$a() {
        DiffUtil$ItemCallback diffUtil$ItemCallback = i;
        super(diffUtil$ItemCallback);
    }

    private /* synthetic */ void o(int n10, MessageLike messageLike, View view) {
        this.g.a(view, n10, messageLike);
    }

    private /* synthetic */ void q(int n10, MessageLike messageLike, View view) {
        this.h.a(view, n10, messageLike);
    }

    private /* synthetic */ void s(int n10, MessageLike messageLike, View view) {
        this.h.a(view, n10, messageLike);
    }

    public int a(int n10) {
        return 2131558707;
    }

    public void i(e object, int n10) {
        object = (if)((e)object).a;
        MessageLike messageLike = (MessageLike)this.getItem(n10);
        Object object2 = messageLike.getNickname();
        ((if)object).A((String)object2);
        object2 = Times.getTimeZoneDescribe(messageLike.getCreateAt());
        ((if)object).C((String)object2);
        ((if)object).B(n10);
        object2 = ((if)object).a;
        Object object3 = messageLike.getAvatar();
        float f10 = 8.0f;
        int n11 = h2.b(f10);
        int n12 = 2131232234;
        Images.H((ImageView)object2, object3, n11, n12);
        object2 = ((if)object).b;
        object3 = w.b(messageLike.getSourceUrls());
        int n13 = h2.b(f10);
        Images.H((ImageView)object2, object3, n13, n12);
        object2 = this.g;
        if (object2 != null) {
            object2 = ((if)object).b;
            object3 = new f(this, n10, messageLike);
            object2.setOnClickListener((View.OnClickListener)object3);
        }
        if ((object2 = this.h) != null) {
            object2 = ((if)object).a;
            object3 = new d(this, n10, messageLike);
            object2.setOnClickListener((View.OnClickListener)object3);
            object = ((if)object).d;
            object2 = new d.v.c.j1.b.e(this, n10, messageLike);
            object.setOnClickListener((View.OnClickListener)object2);
        }
    }

    public /* synthetic */ void p(int n10, MessageLike messageLike, View view) {
        this.o(n10, messageLike, view);
    }

    public /* synthetic */ void r(int n10, MessageLike messageLike, View view) {
        this.q(n10, messageLike, view);
    }

    public /* synthetic */ void t(int n10, MessageLike messageLike, View view) {
        this.s(n10, messageLike, view);
    }

    public void u(b b10) {
        this.g = b10;
    }

    public void v(b b10) {
        this.h = b10;
    }
}

