/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.device.connect.help;

import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.device.connect.help.ConnectHelpFragment;

public class ConnectHelpFragment$a {
    public final /* synthetic */ ConnectHelpFragment a;

    public ConnectHelpFragment$a(ConnectHelpFragment connectHelpFragment) {
        this.a = connectHelpFragment;
    }

    public void a() {
        NavHostFragment.findNavController(this.a).popBackStack();
    }
}

