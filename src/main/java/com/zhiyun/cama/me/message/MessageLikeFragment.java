/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.View
 */
package com.zhiyun.cama.me.message;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.data.MessagePageType;
import com.zhiyun.cama.data.database.model.MessageLike;
import com.zhiyun.cama.main.me.user.UserPageActivity;
import com.zhiyun.cama.me.message.MessageLikeFragment$a;
import d.v.c.h1.o;
import d.v.c.h1.p;
import d.v.c.j1.b.c;
import d.v.c.j1.b.g;
import d.v.c.j1.b.h;
import d.v.c.j1.b.k0;
import d.v.c.j1.b.o0;
import d.v.c.v0.k;
import d.v.c.x1.l;
import d.v.e.l.o1;
import d.v.g0.i;
import d.v.g0.i$c;
import d.v.i0.b;
import java.util.ArrayList;
import java.util.List;

public class MessageLikeFragment
extends p {
    private o0 f;

    public static /* synthetic */ void M(View view, int n10, MessageLike messageLike) {
        String string2;
        Object object = messageLike.getWorkType();
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 != 0 || (n10 = (int)((string2 = "circle_article").equals(object = messageLike.getWorkType()) ? 1 : 0)) == 0) {
            n10 = messageLike.getPostId();
            long l10 = n10;
            object = k.a(l10);
            messageLike = null;
            object = k0.a((String)object, false);
            l.c(view, (NavDirections)object);
        }
    }

    private /* synthetic */ void N(View object, int n10, MessageLike messageLike) {
        object = this.getActivity();
        n10 = messageLike.getUserId();
        UserPageActivity.d((Activity)object, n10);
    }

    private /* synthetic */ void P(View object, int n10, MessageLike object2) {
        object = new ArrayList();
        String string2 = d.v.f.i.g.m(this.requireContext(), 2131951903);
        int n11 = o1.a(this.requireContext(), 2131099739);
        Object object3 = new d.v.g0.o(string2, n11);
        object.add(object3);
        object = i.w(false).B((List)object);
        object3 = new c(this, (MessageLike)object2);
        object = ((i)object).D((i$c)object3);
        object3 = this.getChildFragmentManager();
        object2 = i.class.getName();
        ((DialogFragment)object).show((FragmentManager)object3, (String)object2);
    }

    private /* synthetic */ void R(MessageLike messageLike, int n10) {
        if (n10 == 0) {
            o0 o02 = this.f;
            MessagePageType messagePageType = MessagePageType.MESSAGE_LIKE;
            int n11 = messageLike.getId();
            o02.c(messagePageType, n11, null);
        }
    }

    public void D() {
        this.f.G();
    }

    public void E() {
        this.f.J();
    }

    public /* synthetic */ void O(View view, int n10, MessageLike messageLike) {
        this.N(view, n10, messageLike);
    }

    public /* synthetic */ void Q(View view, int n10, MessageLike messageLike) {
        this.P(view, n10, messageLike);
    }

    public /* synthetic */ void S(MessageLike messageLike, int n10) {
        this.R(messageLike, n10);
    }

    public o k() {
        MessageLikeFragment$a messageLikeFragment$a = new MessageLikeFragment$a();
        d.v.f.f.b b10 = d.v.c.j1.b.b.a;
        messageLikeFragment$a.u(b10);
        b10 = new h(this);
        messageLikeFragment$a.v(b10);
        b10 = new g(this);
        messageLikeFragment$a.n(b10);
        return messageLikeFragment$a;
    }

    public LiveData l() {
        return this.f.e();
    }

    public RecyclerView$ItemDecoration m() {
        return null;
    }

    public RecyclerView$LayoutManager n() {
        o o10 = this.c;
        Context context = this.getContext();
        return o10.d(context, 1);
    }

    public LiveData o() {
        return this.f.d();
    }

    public void onResume() {
        super.onResume();
        o0 o02 = this.f;
        MessagePageType messagePageType = MessagePageType.MESSAGE_LIKE;
        o02.N(messagePageType);
    }

    public void s() {
        String string2 = d.v.f.i.g.m(this.requireContext(), 2131952545);
        this.I(string2);
        this.K(true);
        this.G(2131231809);
        string2 = d.v.f.i.g.m(this.requireContext(), 2131952544);
        this.H(string2);
    }

    public void t() {
        o0 o02;
        this.f = o02 = (o0)d.v.i0.b.c(this.requireActivity()).get(o0.class);
    }
}

