/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.zhiyun.cama.set.server;

import android.text.TextUtils;
import android.view.View;
import com.zhiyun.cama.data.api.entity.ServerEntity;
import com.zhiyun.cama.set.server.ServersFragment;
import com.zhiyun.net.NetConfiguration;
import d.v.c.n0.c;
import d.v.c.q1.i0.e;
import d.v.c.w0.ug;

public class ServersFragment$a
extends c {
    public final /* synthetic */ ServersFragment b;

    public ServersFragment$a(ServersFragment serversFragment) {
        this.b = serversFragment;
    }

    private /* synthetic */ void e(ServerEntity serverEntity, View object) {
        object = NetConfiguration.create();
        String string2 = serverEntity.config.api;
        object = ((NetConfiguration)object).setHost(string2);
        string2 = serverEntity.env;
        object = ((NetConfiguration)object).setEnv(string2);
        string2 = serverEntity.config.service;
        object = ((NetConfiguration)object).addOtherHost("service", string2);
        string2 = serverEntity.config.purchaseOverseas;
        ((NetConfiguration)object).addOtherHost("purchase", string2);
        ServersFragment.j(this.b).f(serverEntity);
        this.notifyDataSetChanged();
    }

    public int a(int n10) {
        return 2131558766;
    }

    public void b(d.v.c.n0.e object, int n10) {
        object = (ug)((d.v.c.n0.e)object).a;
        ServerEntity serverEntity = (ServerEntity)this.getItem(n10);
        Object object2 = serverEntity.server_name;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2 && (object2 = ServersFragment.j(this.b).c()) != null) {
            object2 = serverEntity.server_name;
            String string2 = ServersFragment.j((ServersFragment)this.b).c().server_name;
            bl2 = ((String)object2).equals(string2);
            ((ug)object).A(bl2);
        }
        object2 = serverEntity.toString();
        ((ug)object).B((String)object2);
        object = ((ug)object).a;
        object2 = new e(this, serverEntity);
        object.setOnClickListener((View.OnClickListener)object2);
    }

    public /* synthetic */ void f(ServerEntity serverEntity, View view) {
        this.e(serverEntity, view);
    }
}

