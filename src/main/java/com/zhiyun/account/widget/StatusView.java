/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package com.zhiyun.account.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.widget.StatusView$Status;
import com.zhiyun.account.widget.StatusView$a;
import d.v.a.g.a;
import d.v.e.l.o1;
import d.v.f.i.g;
import l.a.q.g0.u;

public class StatusView
extends FrameLayout {
    private a a;
    private ObservableField b;
    private ObservableField c;

    public StatusView(Context context) {
        this(context, null);
    }

    public StatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StatusView(Context object, AttributeSet attributeSet, int n10) {
        super(object, attributeSet, n10);
        super();
        this.b = object;
        super();
        this.c = object;
        this.b();
    }

    private void b() {
        Object object = LayoutInflater.from((Context)this.getContext());
        int n10 = R$layout.base_status_view;
        object = (a)DataBindingUtil.inflate((LayoutInflater)object, n10, (ViewGroup)this, true);
        this.a = object;
        ObservableField observableField = this.b;
        ((a)object).B(observableField);
        object = this.a;
        observableField = this.c;
        ((a)object).A(observableField);
        this.a();
    }

    public void a() {
        FrameLayout frameLayout = this.a.b;
        int n10 = 8;
        frameLayout.setVisibility(n10);
        this.a.c.setVisibility(n10);
        this.a.e.setVisibility(n10);
        this.a.d.setVisibility(n10);
    }

    public void c() {
        this.a();
        this.a.b.setVisibility(0);
        this.a.e.setVisibility(0);
    }

    public void d() {
        this.a();
        this.a.b.setVisibility(0);
        this.a.c.setVisibility(0);
    }

    public void e() {
        this.a();
        this.a.b.setVisibility(0);
        this.a.d.setVisibility(0);
    }

    public void setBackgroundColor(int n10) {
        this.a.getRoot().setBackgroundColor(n10);
    }

    public void setEmptyImage(int n10) {
        ObservableField observableField = this.c;
        Drawable drawable2 = o1.o(this.getResources(), n10);
        observableField.set(drawable2);
    }

    public void setEmptyImage(Drawable drawable2) {
        this.c.set(drawable2);
    }

    public void setEmptyText(int n10) {
        TextView textView = this.a.e;
        String string2 = g.o(this.getResources(), n10);
        textView.setText((CharSequence)string2);
    }

    public void setEmptyText(String string2) {
        TextView textView = this.a.e;
        Object[] objectArray = new Object[]{};
        u.o(textView, string2, objectArray);
    }

    public void setErrorImage(int n10) {
        ObservableField observableField = this.b;
        Drawable drawable2 = o1.o(this.getResources(), n10);
        observableField.set(drawable2);
    }

    public void setErrorImage(Drawable drawable2) {
        this.b.set(drawable2);
    }

    public void setErrorText(int n10) {
        TextView textView = this.a.f;
        String string2 = g.o(this.getResources(), n10);
        textView.setText((CharSequence)string2);
    }

    public void setErrorText(String string2) {
        TextView textView = this.a.f;
        Object[] objectArray = new Object[]{};
        u.o(textView, string2, objectArray);
    }

    public void setOnClickErrorListener(View.OnClickListener onClickListener) {
        this.a.a.setOnClickListener(onClickListener);
    }

    public void setStatus(StatusView$Status statusView$Status) {
        if (statusView$Status == null) {
            this.a();
            return;
        }
        int[] nArray = StatusView$a.a;
        int n10 = statusView$Status.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 == n11) {
                    this.d();
                }
            } else {
                this.e();
            }
        } else {
            this.a();
        }
    }

    public void setTextColor(int n10) {
        this.a.e.setTextColor(n10);
    }
}

