/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.cama.publish;

import android.text.TextUtils;
import com.zhiyun.cama.publish.PublishFragment;
import d.v.x.b;

public class PublishFragment$b
implements b {
    public final /* synthetic */ PublishFragment a;

    public PublishFragment$b(PublishFragment publishFragment) {
        this.a = publishFragment;
    }

    public void a() {
        PublishFragment.B(this.a);
    }

    public void b() {
        Object object = this.a;
        Object object2 = PublishFragment.v((PublishFragment)object).m();
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = PublishFragment.x((PublishFragment)object, (String)object2)));
        if (bl2) {
            PublishFragment.y(this.a);
            object = this.a;
            PublishFragment.z((PublishFragment)object);
        } else {
            object2 = this.a;
            PublishFragment.A((PublishFragment)object2, (String)object);
        }
    }
}

