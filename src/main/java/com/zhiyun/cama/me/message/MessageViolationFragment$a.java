/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.SpannableString
 *  android.text.TextUtils
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.widget.TextView
 */
package com.zhiyun.cama.me.message;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.zhiyun.cama.data.database.model.Approval;
import com.zhiyun.cama.data.database.model.MessageViolation;
import com.zhiyun.cama.me.message.MessageViolationFragment$a$a;
import com.zhiyun.net.Punish;
import d.v.a.f.c.b;
import d.v.c.h1.o;
import d.v.c.j1.b.b0;
import d.v.c.j1.b.c0;
import d.v.c.j1.b.d0;
import d.v.c.j1.b.e0;
import d.v.c.j1.b.f0;
import d.v.c.n0.e;
import d.v.c.p0.m;
import d.v.c.w0.gf;
import d.v.c.w0.kf;
import d.v.e.l.m1;
import d.v.e.l.o1;
import d.v.e.l.t1;
import d.v.f.i.g;

public class MessageViolationFragment$a
extends o {
    private static final int k = 1002;
    private static final int l = 1003;
    private static final DiffUtil$ItemCallback m;
    private d.v.f.f.b g;
    private d.v.f.f.b h;
    private d.v.f.f.b i;
    private d.v.f.f.b j;

    static {
        MessageViolationFragment$a$a messageViolationFragment$a$a = new MessageViolationFragment$a$a();
        m = messageViolationFragment$a$a;
    }

    public MessageViolationFragment$a() {
        DiffUtil$ItemCallback diffUtil$ItemCallback = m;
        super(diffUtil$ItemCallback);
    }

    private /* synthetic */ boolean o(int n10, View view) {
        d.v.f.f.b b10 = this.j;
        Object object = this.getItem(n10);
        b10.a(view, n10, object);
        return true;
    }

    private /* synthetic */ void q(int n10, View view) {
        d.v.f.f.b b10 = this.g;
        Object object = this.getItem(n10);
        b10.a(view, n10, object);
    }

    private /* synthetic */ void s(int n10, MessageViolation messageViolation, View view) {
        d.v.f.f.b b10 = this.i;
        if (b10 != null) {
            b10.a(view, n10, messageViolation);
        }
    }

    private /* synthetic */ void u(int n10, MessageViolation messageViolation, View view) {
        d.v.f.f.b b10 = this.i;
        if (b10 != null) {
            b10.a(view, n10, messageViolation);
        }
    }

    private /* synthetic */ void w(int n10, MessageViolation messageViolation, View view) {
        this.h.a(view, n10, messageViolation);
    }

    private void y(e e10, int n10, int n11) {
        Object object;
        Object object2;
        String string2;
        int n12;
        String string3;
        Object object3;
        int n13;
        MessageViolationFragment$a messageViolationFragment$a = this;
        Object object4 = e10;
        int n14 = n10;
        MessageViolation messageViolation = (MessageViolation)this.getItem(n10);
        Object object5 = e10.a;
        boolean n15 = object5 instanceof gf;
        if (!n15) {
            return;
        }
        object5 = (gf)object5;
        Object object6 = ((gf)object5).f;
        Object object7 = ((gf)object5).d;
        Object object8 = ((gf)object5).e;
        TextView textView = ((gf)object5).c;
        object5 = ((gf)object5).b;
        object7.setBreakStrategy(0);
        Object object9 = m1.O(messageViolation.getCreateAt());
        object8.setText((CharSequence)object9);
        object8 = messageViolation.getVerb();
        object9 = "punish_notice";
        boolean bl2 = ((String)object9).equals(object8);
        boolean bl3 = false;
        Object object10 = null;
        if (bl2) {
            n13 = messageViolation.getRefId();
            object3 = messageViolation.getPunish();
            string3 = messageViolation.getForever();
            String string4 = messageViolation.getPunish_endtime();
            n12 = b.N().i().getId();
            string2 = String.valueOf(n12);
            object2 = messageViolation.getBuild_time();
            String string5 = messageViolation.getAppeal_id();
            String string6 = "";
            object = object8;
            object8 = new Punish(n13, (String)object3, string3, string4, string2, (String)object2, string5, string6);
        } else {
            int n16 = messageViolation.getRefId();
            String string7 = messageViolation.getDegree();
            String string8 = messageViolation.getBuild_time();
            String string9 = messageViolation.getRefuse_reason();
            String string10 = messageViolation.getClassify();
            String string11 = messageViolation.getCircle_name();
            String string12 = "";
            String string13 = "";
            object8 = new Approval(n16, string7, string8, string9, string10, string11, string12, string13);
            object10 = object8;
            bl2 = false;
            object8 = null;
        }
        object = ((RecyclerView$ViewHolder)object4).itemView.getContext();
        String string14 = messageViolation.getVerb();
        object3 = new c0(messageViolationFragment$a, n14, messageViolation);
        object8 = d.v.c.p0.m.f((Context)object, string14, (Approval)object10, (Punish)object8, (View.OnClickListener)object3);
        bl3 = true;
        object = (SpannableString)object8.get((int)(bl3 ? 1 : 0));
        string14 = object.toString();
        object3 = messageViolation.getVerb();
        boolean bl4 = ((String)object9).equals(object3);
        if (!bl4) {
            object9 = new StringBuilder();
            ((StringBuilder)object9).append(string14);
            ((StringBuilder)object9).append("\n\n");
            object = d.v.f.i.g.q(((RecyclerView$ViewHolder)object4).itemView, 2131951662);
            ((StringBuilder)object9).append((String)object);
            object3 = ((StringBuilder)object9).toString();
            n13 = 0;
            string14 = null;
            string3 = d.v.f.i.g.q(((RecyclerView$ViewHolder)object4).itemView, 2131951876);
            object9 = ((RecyclerView$ViewHolder)object4).itemView;
            n12 = 2131099756;
            int n17 = o1.e((View)object9, n12);
            string2 = null;
            object2 = object9 = new f0(messageViolationFragment$a, n14, messageViolation);
            object = t1.a(null, (String)object3, string3, n17, false, (View.OnClickListener)object9);
        }
        object8 = (CharSequence)object8.get(0);
        object6.setText((CharSequence)object8);
        object7.setBreakStrategy(0);
        object6 = LinkMovementMethod.getInstance();
        object7.setMovementMethod((MovementMethod)object6);
        object7.setText((CharSequence)object);
        object6 = messageViolation.getHas_punish();
        object7 = "1";
        boolean bl5 = ((String)object7).equals(object6);
        if (bl5) {
            textView.setEnabled(false);
            int n18 = 8;
            object5.setVisibility(n18);
            object4 = ((RecyclerView$ViewHolder)object4).itemView;
            int n19 = 2131951650;
            object4 = d.v.f.i.g.q((View)object4, n19);
            textView.setText((CharSequence)object4);
            int n23 = o1.e((View)textView, 2131099765);
            textView.setTextColor(n23);
        } else {
            textView.setEnabled(bl3);
            object5.setVisibility(0);
            object5 = messageViolation.getAppeal_id();
            int n20 = TextUtils.isEmpty((CharSequence)object5);
            int n21 = 2131099826;
            if (n20 != 0) {
                object4 = ((RecyclerView$ViewHolder)object4).itemView;
                n20 = 2131951639;
                object4 = d.v.f.i.g.q((View)object4, n20);
                textView.setText((CharSequence)object4);
                int n24 = o1.e((View)textView, n21);
                textView.setTextColor(n24);
            } else {
                object5 = messageViolation.getAppeal_status();
                n20 = (int)(((String)object7).equals(object5) ? 1 : 0);
                if (n20 != 0) {
                    object4 = ((RecyclerView$ViewHolder)object4).itemView;
                    n20 = 2131951653;
                    object4 = d.v.f.i.g.q((View)object4, n20);
                    textView.setText((CharSequence)object4);
                    int n22 = o1.e((View)textView, 2131099739);
                    textView.setTextColor(n22);
                } else {
                    object7 = "2";
                    object5 = messageViolation.getAppeal_status();
                    n20 = (int)(((String)object7).equals(object5) ? 1 : 0);
                    if (n20 != 0) {
                        object4 = ((RecyclerView$ViewHolder)object4).itemView;
                        n20 = 2131951646;
                        object4 = d.v.f.i.g.q((View)object4, n20);
                        textView.setText((CharSequence)object4);
                        int n23 = o1.e((View)textView, n21);
                        textView.setTextColor(n23);
                    } else {
                        object4 = ((RecyclerView$ViewHolder)object4).itemView;
                        n20 = 2131951648;
                        object4 = d.v.f.i.g.q((View)object4, n20);
                        textView.setText((CharSequence)object4);
                        int n24 = o1.e((View)textView, n21);
                        textView.setTextColor(n24);
                    }
                }
            }
        }
        object4 = messageViolationFragment$a.h;
        if (object4 != null) {
            object4 = new e0(messageViolationFragment$a, n14, messageViolation);
            textView.setOnClickListener((View.OnClickListener)object4);
        }
    }

    private void z(e object, int n10, int n11) {
        Object object2 = (MessageViolation)this.getItem(n10);
        Object[] objectArray = (kf)((e)object).a;
        TextView textView = objectArray.c;
        TextView textView2 = objectArray.a;
        objectArray = objectArray.b;
        textView2.setBreakStrategy(0);
        String string2 = m1.O(((MessageViolation)object2).getCreateAt());
        objectArray.setText((CharSequence)string2);
        objectArray = ((RecyclerView$ViewHolder)object).itemView;
        int n12 = 2131951664;
        objectArray = d.v.f.i.g.q((View)objectArray, n12);
        textView.setText((CharSequence)objectArray);
        objectArray = ((MessageViolation)object2).getSource();
        n11 = (int)(TextUtils.isEmpty((CharSequence)objectArray) ? 1 : 0);
        int n13 = 2131951666;
        if (n11 == 0) {
            objectArray = ((MessageViolation)object2).getSource();
            objectArray.hashCode();
            string2 = "share_post";
            n12 = (int)(objectArray.equals(string2) ? 1 : 0);
            if (n12 == 0 && (n11 = (int)(objectArray.equals(string2 = "user") ? 1 : 0)) != 0) {
                n13 = 2131951665;
            }
        }
        textView2.setBreakStrategy(0);
        object = ((RecyclerView$ViewHolder)object).itemView;
        objectArray = new Object[1];
        string2 = object.getContext();
        object2 = ((MessageViolation)object2).getBuild_time();
        objectArray[0] = object2 = m1.H((Context)string2, (String)object2);
        object = d.v.f.i.g.r((View)object, n13, objectArray);
        textView2.setText((CharSequence)object);
    }

    public void A(d.v.f.f.b b10) {
        this.h = b10;
    }

    public void B(d.v.f.f.b b10) {
        this.i = b10;
    }

    public void C(d.v.f.f.b b10) {
        this.g = b10;
    }

    public void D(d.v.f.f.b b10) {
        this.j = b10;
    }

    public int a(int n10) {
        int n11 = 1002;
        if (n10 == n11) {
            return 2131558706;
        }
        return 2131558708;
    }

    public int getDefItemViewType(int n10) {
        int n11 = n10 + -1;
        String string2 = ((MessageViolation)this.getItem(n11)).getVerb();
        string2.hashCode();
        int n12 = string2.hashCode();
        int n13 = -1;
        switch (n12) {
            default: {
                break;
            }
            case 1890717688: {
                String string3 = "person_production_approval_notice";
                n11 = (int)(string2.equals(string3) ? 1 : 0);
                if (n11 == 0) break;
                n13 = 3;
                break;
            }
            case 999771522: {
                String string4 = "punish_notice";
                n11 = (int)(string2.equals(string4) ? 1 : 0);
                if (n11 == 0) break;
                n13 = 2;
                break;
            }
            case 413606253: {
                String string5 = "person_info_approval_notice";
                n11 = (int)(string2.equals(string5) ? 1 : 0);
                if (n11 == 0) break;
                n13 = 1;
                break;
            }
            case -1006622296: {
                String string6 = "repeal_approval_notice";
                n11 = (int)(string2.equals(string6) ? 1 : 0);
                if (n11 == 0) break;
                n13 = 0;
            }
        }
        switch (n13) {
            default: {
                return super.getDefItemViewType(n10);
            }
            case 1: 
            case 2: 
            case 3: {
                return 1002;
            }
            case 0: 
        }
        return 1003;
    }

    public void i(e e10, int n10) {
        int n11;
        int n12 = n10 + 1;
        if ((n12 = this.getDefItemViewType(n12)) != (n11 = 1002)) {
            n11 = 1003;
            if (n12 != n11) {
                return;
            }
            this.z(e10, n10, n12);
        } else {
            this.y(e10, n10, n12);
        }
        Object object = this.j;
        if (object != null) {
            object = e10.itemView;
            d0 d02 = new d0(this, n10);
            object.setOnLongClickListener((View.OnLongClickListener)d02);
        }
        if ((object = this.g) != null) {
            e10 = e10.itemView;
            object = new b0(this, n10);
            e10.setOnClickListener((View.OnClickListener)object);
        }
    }

    public /* synthetic */ boolean p(int n10, View view) {
        return this.o(n10, view);
    }

    public /* synthetic */ void r(int n10, View view) {
        this.q(n10, view);
    }

    public /* synthetic */ void t(int n10, MessageViolation messageViolation, View view) {
        this.s(n10, messageViolation, view);
    }

    public /* synthetic */ void v(int n10, MessageViolation messageViolation, View view) {
        this.u(n10, messageViolation, view);
    }

    public /* synthetic */ void x(int n10, MessageViolation messageViolation, View view) {
        this.w(n10, messageViolation, view);
    }
}

