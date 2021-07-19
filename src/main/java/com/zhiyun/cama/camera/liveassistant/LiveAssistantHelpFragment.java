/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 */
package com.zhiyun.cama.camera.liveassistant;

import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentTransaction;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantHelpFragment$b;
import com.zhiyun.cama.main.me.WebViewFragment;
import d.v.c.v0.u.z;
import d.v.c.w0.f9;
import d.v.f.h.a;

public class LiveAssistantHelpFragment
extends a {
    public static final String b;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = z.m().g();
        stringBuilder.append(string2);
        stringBuilder.append("livehelp");
        b = stringBuilder.toString();
    }

    private WebViewFragment j() {
        String string2 = b;
        boolean bl2 = true;
        return WebViewFragment.S(string2, false, bl2, bl2);
    }

    public static LiveAssistantHelpFragment k() {
        LiveAssistantHelpFragment liveAssistantHelpFragment = new LiveAssistantHelpFragment();
        Bundle bundle = new Bundle();
        liveAssistantHelpFragment.setArguments(bundle);
        return liveAssistantHelpFragment;
    }

    private void l() {
        FragmentTransaction fragmentTransaction = this.getChildFragmentManager().beginTransaction();
        WebViewFragment webViewFragment = this.j();
        fragmentTransaction.replace(2131362512, webViewFragment).commit();
    }

    public int h() {
        return 2131558603;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (f9)viewDataBinding;
        LiveAssistantHelpFragment$b liveAssistantHelpFragment$b = new LiveAssistantHelpFragment$b(null);
        ((f9)viewDataBinding).z(liveAssistantHelpFragment$b);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.l();
    }
}

