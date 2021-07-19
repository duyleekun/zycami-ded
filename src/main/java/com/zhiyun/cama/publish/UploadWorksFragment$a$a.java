/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.publish;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.publish.UploadCEMediaInfo;
import com.zhiyun.cama.publish.UploadWorksFragment$a;
import d.v.c.m1.b;
import d.v.c.m1.d.l$b;
import d.v.c.n1.m2;
import d.v.c.n1.m2$b;

public class UploadWorksFragment$a$a
implements l$b {
    public final /* synthetic */ UploadCEMediaInfo a;
    public final /* synthetic */ UploadWorksFragment$a b;

    public UploadWorksFragment$a$a(UploadWorksFragment$a uploadWorksFragment$a, UploadCEMediaInfo uploadCEMediaInfo) {
        this.b = uploadWorksFragment$a;
        this.a = uploadCEMediaInfo;
    }

    public void a() {
        d.v.c.m1.b.e(this.b.a);
    }

    public void b() {
        NavController navController = NavHostFragment.findNavController(this.b.a);
        m2$b m2$b = m2.a(this.a);
        navController.navigate(m2$b);
    }
}

