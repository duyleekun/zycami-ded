/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.View
 */
package com.zhiyun.cama.me.message;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.account.SimpleWebViewActivity;
import com.zhiyun.cama.data.MessagePageType;
import com.zhiyun.cama.data.database.model.MessageSystem;
import com.zhiyun.cama.main.me.user.UserPageActivity;
import com.zhiyun.cama.me.message.MessageSystemFragment$a;
import d.v.c.j1.b.i;
import d.v.c.j1.b.j;
import d.v.c.j1.b.l0;
import d.v.c.j1.b.o;
import d.v.c.j1.b.o0;
import d.v.c.j1.b.p;
import d.v.c.v0.k;
import d.v.c.x1.l;
import d.v.e.l.o1;
import d.v.f.i.g;
import d.v.g0.i$c;
import d.v.i0.b;
import java.util.ArrayList;
import java.util.List;

public class MessageSystemFragment
extends d.v.c.h1.p {
    private o0 f;

    private /* synthetic */ void M(View object, int n10, MessageSystem object2) {
        String string2;
        Object object3 = this.f;
        int n11 = ((MessageSystem)object2).getId();
        ((o0)object3).b(n11);
        object3 = ((MessageSystem)object2).getVerb();
        ((String)object3).hashCode();
        n11 = ((String)object3).hashCode();
        int n12 = -1;
        switch (n11) {
            default: {
                break;
            }
            case 539232087: {
                string2 = "post_notice";
                n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                if (n10 == 0) break;
                n12 = 3;
                break;
            }
            case -414090440: {
                string2 = "share_notice";
                n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                if (n10 == 0) break;
                n12 = 2;
                break;
            }
            case -494885976: {
                string2 = "url_notice";
                n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                if (n10 == 0) break;
                n12 = 1;
                break;
            }
            case -835808726: {
                string2 = "text_notice";
                n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                if (n10 == 0) break;
                n12 = 0;
            }
        }
        switch (n12) {
            default: {
                break;
            }
            case 2: 
            case 3: {
                n10 = ((MessageSystem)object2).getObjectId();
                long l10 = n10;
                object3 = l0.b(k.a(l10), false);
                l.c(object, (NavDirections)object3);
                break;
            }
            case 1: {
                object = this.getActivity();
                object3 = this.requireContext();
                n11 = 2131952547;
                object3 = g.m((Context)object3, n11);
                object2 = ((MessageSystem)object2).getContent();
                SimpleWebViewActivity.h((Activity)object, (String)object3, (String)object2);
                break;
            }
            case 0: {
                object3 = ((MessageSystem)object2).getTitle();
                string2 = ((MessageSystem)object2).getCreateAt();
                object2 = ((MessageSystem)object2).getContent();
                object3 = l0.a((String)object3, string2, (String)object2);
                l.c(object, (NavDirections)object3);
            }
        }
    }

    private /* synthetic */ void O(View object, int n10, MessageSystem messageSystem) {
        object = this.getActivity();
        n10 = messageSystem.getUserId();
        UserPageActivity.d((Activity)object, n10);
    }

    private /* synthetic */ void Q(View object, int n10, MessageSystem object2) {
        object = new ArrayList();
        String string2 = g.m(this.requireContext(), 2131951903);
        int n11 = o1.a(this.requireContext(), 2131099739);
        Object object3 = new d.v.g0.o(string2, n11);
        object.add(object3);
        object = d.v.g0.i.w(false).B((List)object);
        object3 = new j(this, (MessageSystem)object2);
        object = ((d.v.g0.i)object).D((i$c)object3);
        object3 = this.getChildFragmentManager();
        object2 = d.v.g0.i.class.getName();
        ((DialogFragment)object).show((FragmentManager)object3, (String)object2);
    }

    private /* synthetic */ void S(MessageSystem messageSystem, int n10) {
        if (n10 == 0) {
            o0 o02 = this.f;
            MessagePageType messagePageType = MessagePageType.MESSAGE_SYSTEM;
            int n11 = messageSystem.getId();
            o02.c(messagePageType, n11, null);
        }
    }

    public void D() {
        this.f.H();
    }

    public void E() {
        this.f.K();
    }

    public /* synthetic */ void N(View view, int n10, MessageSystem messageSystem) {
        this.M(view, n10, messageSystem);
    }

    public /* synthetic */ void P(View view, int n10, MessageSystem messageSystem) {
        this.O(view, n10, messageSystem);
    }

    public /* synthetic */ void R(View view, int n10, MessageSystem messageSystem) {
        this.Q(view, n10, messageSystem);
    }

    public /* synthetic */ void T(MessageSystem messageSystem, int n10) {
        this.S(messageSystem, n10);
    }

    public d.v.c.h1.o k() {
        MessageSystemFragment$a messageSystemFragment$a = new MessageSystemFragment$a();
        d.v.f.f.b b10 = new p(this);
        messageSystemFragment$a.x(b10);
        b10 = new i(this);
        messageSystemFragment$a.y(b10);
        b10 = new o(this);
        messageSystemFragment$a.w(b10);
        return messageSystemFragment$a;
    }

    public LiveData l() {
        return this.f.f();
    }

    public RecyclerView$ItemDecoration m() {
        return null;
    }

    public RecyclerView$LayoutManager n() {
        d.v.c.h1.o o10 = this.c;
        Context context = this.getContext();
        return o10.d(context, 1);
    }

    public LiveData o() {
        return this.f.k();
    }

    public void onResume() {
        super.onResume();
        o0 o02 = this.f;
        MessagePageType messagePageType = MessagePageType.MESSAGE_SYSTEM;
        o02.N(messagePageType);
    }

    public void s() {
        String string2 = g.m(this.requireContext(), 2131952547);
        this.I(string2);
        this.K(true);
        this.G(2131231809);
        string2 = g.m(this.requireContext(), 2131952544);
        this.H(string2);
    }

    public void t() {
        o0 o02;
        this.f = o02 = (o0)d.v.i0.b.c(this.requireActivity()).get(o0.class);
    }
}

