/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 */
package com.zhiyun.cama.help;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentTransaction;
import com.zhiyun.cama.help.EditorHelpActivity$a;
import com.zhiyun.cama.main.me.WebViewFragment;
import d.v.c.l0$b;
import d.v.c.q0.a;
import d.v.c.w0.i;
import d.v.f.i.g;

public class EditorHelpActivity
extends a {
    private i b;
    private WebViewFragment c;

    public static /* synthetic */ WebViewFragment i(EditorHelpActivity editorHelpActivity) {
        return editorHelpActivity.c;
    }

    private void j() {
        Object object = l0$b.b;
        boolean bl2 = true;
        this.c = object = WebViewFragment.S((String)object, false, bl2, bl2);
        object = this.getSupportFragmentManager().beginTransaction();
        WebViewFragment webViewFragment = this.c;
        ((FragmentTransaction)object).replace(2131362512, webViewFragment).commit();
    }

    public int d() {
        return 2131558434;
    }

    public void f(ViewDataBinding viewDataBinding, Bundle object) {
        super.f(viewDataBinding, (Bundle)object);
        viewDataBinding = (i)viewDataBinding;
        this.b = viewDataBinding;
        object = new EditorHelpActivity$a(this);
        ((i)viewDataBinding).z((EditorHelpActivity$a)object);
        viewDataBinding = this.b.b.c;
        object = g.m((Context)this, 2131952139);
        viewDataBinding.setText((CharSequence)object);
        this.b.b.a.setVisibility(8);
        this.j();
    }
}

