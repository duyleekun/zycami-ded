/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 *  android.view.View
 */
package com.zhiyun.cama.me.message;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.account.SimpleWebViewActivity;
import com.zhiyun.cama.appeal.AppealActivity;
import com.zhiyun.cama.appeal.detail.AppealDetailActivity;
import com.zhiyun.cama.data.MessagePageType;
import com.zhiyun.cama.data.database.model.Approval;
import com.zhiyun.cama.data.database.model.MessageViolation;
import com.zhiyun.cama.me.message.MessageViolationFragment$a;
import com.zhiyun.net.Punish;
import d.v.c.h1.o;
import d.v.c.h1.p;
import d.v.c.j1.b.g0;
import d.v.c.j1.b.h0;
import d.v.c.j1.b.i0;
import d.v.c.j1.b.o0;
import d.v.c.j1.b.p0;
import d.v.c.v0.k;
import d.v.c.x1.l;
import d.v.f.i.g;
import d.v.i0.b;

public class MessageViolationFragment
extends p {
    public static final int g = 1234;
    private o0 f;

    private /* synthetic */ void M(View object, int n10, MessageViolation object2) {
        if (object2 != null && (object = this.getActivity()) != null) {
            object = ((MessageViolation)object2).getAppeal_id();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) {
                object = ((MessageViolation)object2).getVerb();
                String string2 = "punish_notice";
                bl2 = string2.equals(object);
                n10 = 1234;
                if (bl2) {
                    int n11 = ((MessageViolation)object2).getRefId();
                    String string3 = ((MessageViolation)object2).getPunish();
                    String string4 = ((MessageViolation)object2).getForever();
                    String string5 = ((MessageViolation)object2).getPunish_endtime();
                    int n12 = d.v.a.f.c.b.N().i().getId();
                    String string6 = String.valueOf(n12);
                    String string7 = ((MessageViolation)object2).getBuild_time();
                    String string8 = ((MessageViolation)object2).getAppeal_id();
                    String string9 = "";
                    object = new Punish(n11, string3, string4, string5, string6, string7, string8, string9);
                    object2 = ((MessageViolation)object2).getVerb();
                    AppealActivity.H(this, (String)object2, (Punish)object, n10);
                } else {
                    int n13 = ((MessageViolation)object2).getRefId();
                    String string10 = ((MessageViolation)object2).getDegree();
                    String string11 = ((MessageViolation)object2).getBuild_time();
                    String string12 = ((MessageViolation)object2).getRefuse_reason();
                    String string13 = ((MessageViolation)object2).getClassify();
                    String string14 = ((MessageViolation)object2).getCircle_name();
                    String string15 = "";
                    String string16 = "";
                    object = new Approval(n13, string10, string11, string12, string13, string14, string15, string16);
                    object2 = ((MessageViolation)object2).getVerb();
                    AppealActivity.G(this, (String)object2, (Approval)object, n10);
                }
            } else {
                object = (Activity)this.getContext();
                String string17 = ((MessageViolation)object2).getVerb();
                object2 = ((MessageViolation)object2).getAppeal_id();
                AppealDetailActivity.v((Activity)object, string17, (String)object2);
            }
        }
    }

    private /* synthetic */ void O(View object, int n10, MessageViolation messageViolation) {
        if (messageViolation != null && (object = this.getActivity()) != null) {
            object = messageViolation.getVerb();
            ((String)object).hashCode();
            String string2 = "person_info_approval_notice";
            n10 = (int)(((String)object).equals(string2) ? 1 : 0);
            if (n10 == 0) {
                string2 = "person_production_approval_notice";
                boolean bl2 = ((String)object).equals(string2);
                if (bl2) {
                    long l10 = messageViolation.getSource_id();
                    object = k.a(l10);
                    n10 = 0;
                    string2 = null;
                    object = p0.b((String)object, false);
                    l.f(this, (NavDirections)object);
                }
            } else {
                int n11 = 2131362317;
                l.d(this, n11);
            }
        }
    }

    private /* synthetic */ void Q(View object, int n10, MessageViolation object2) {
        object = this.requireActivity();
        String string2 = d.v.f.i.g.o(this.getResources(), 2131951876);
        object2 = d.v.f.i.g.o(this.getResources(), 2131951874);
        SimpleWebViewActivity.h((Activity)object, string2, (String)object2);
    }

    public void D() {
        this.f.I();
    }

    public void E() {
        this.f.M();
    }

    public /* synthetic */ void N(View view, int n10, MessageViolation messageViolation) {
        this.M(view, n10, messageViolation);
    }

    public /* synthetic */ void P(View view, int n10, MessageViolation messageViolation) {
        this.O(view, n10, messageViolation);
    }

    public /* synthetic */ void R(View view, int n10, MessageViolation messageViolation) {
        this.Q(view, n10, messageViolation);
    }

    public o k() {
        MessageViolationFragment$a messageViolationFragment$a = new MessageViolationFragment$a();
        d.v.f.f.b b10 = new i0(this);
        messageViolationFragment$a.A(b10);
        b10 = new g0(this);
        messageViolationFragment$a.C(b10);
        b10 = new h0(this);
        messageViolationFragment$a.B(b10);
        return messageViolationFragment$a;
    }

    public LiveData l() {
        return this.f.i();
    }

    public RecyclerView$ItemDecoration m() {
        return null;
    }

    public RecyclerView$LayoutManager n() {
        FragmentActivity fragmentActivity = this.getActivity();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context)fragmentActivity);
        return linearLayoutManager;
    }

    public LiveData o() {
        return this.f.l();
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        int n12 = 1234;
        if (n10 == n12 && n11 == (n10 = -1) && intent != null) {
            String string2 = intent.getStringExtra("type");
            String string3 = intent.getStringExtra("appeal_id");
            intent = (Activity)this.getContext();
            AppealDetailActivity.v((Activity)intent, string2, string3);
        }
    }

    public void onResume() {
        super.onResume();
        o0 o02 = this.f;
        MessagePageType messagePageType = MessagePageType.MESSAGE_PERSONAL;
        o02.N(messagePageType);
    }

    public void s() {
        String string2 = d.v.f.i.g.s(this, 2131953282);
        this.I(string2);
        this.J();
        this.K(true);
        this.G(2131231809);
        string2 = d.v.f.i.g.s(this, 2131952544);
        this.H(string2);
    }

    public void t() {
        o0 o02;
        this.f = o02 = (o0)d.v.i0.b.c(this.requireActivity()).get(o0.class);
    }
}

