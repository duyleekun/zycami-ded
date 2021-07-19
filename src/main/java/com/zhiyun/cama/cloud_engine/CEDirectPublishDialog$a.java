/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.cloud_engine;

import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.cloud_engine.CEDirectPublishDialog;
import com.zhiyun.cama.publish.PublishActivity;

public class CEDirectPublishDialog$a {
    public final /* synthetic */ CEDirectPublishDialog a;

    public CEDirectPublishDialog$a(CEDirectPublishDialog cEDirectPublishDialog) {
        this.a = cEDirectPublishDialog;
    }

    public void a() {
        NavHostFragment.findNavController(this.a).popBackStack();
    }

    public void b() {
        NavHostFragment.findNavController(this.a).popBackStack();
        Object object = this.a.getArguments();
        if (object != null) {
            object = object.getString("ARGUMENTS_FILEURL");
            CEDirectPublishDialog cEDirectPublishDialog = this.a;
            PublishActivity.k(cEDirectPublishDialog, (String)object);
        }
    }
}

