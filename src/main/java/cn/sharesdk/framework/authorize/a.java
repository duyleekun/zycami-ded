/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.content.Intent;
import cn.sharesdk.framework.authorize.AuthorizeHelper;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;

public class a
extends FakeActivity {
    public AuthorizeHelper a;

    public AuthorizeHelper a() {
        return this.a;
    }

    public void a(AuthorizeHelper authorizeHelper) {
        this.a = authorizeHelper;
        authorizeHelper = MobSDK.getContext();
        super.show((Context)authorizeHelper, null);
    }

    public void show(Context object, Intent intent) {
        object = new RuntimeException("This method is deprecated, use show(AuthorizeHelper, Intent) instead");
        throw object;
    }
}

