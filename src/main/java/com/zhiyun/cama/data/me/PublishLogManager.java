/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me;

import com.zhiyun.cama.data.api.entity.PublishLogList;
import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.cama.data.database.dao.PublishLogDao;
import com.zhiyun.cama.data.database.model.PublishLog;
import com.zhiyun.cama.data.me.PublishLogManager$ReasonCode;
import com.zhiyun.common.util.Times;
import com.zhiyun.net.BaseEntity;
import d.v.c.v0.l.j;
import d.v.c.v0.u.l;
import d.v.c.v0.u.m;
import d.v.e.l.c1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import k.r;
import m.a.a;

public class PublishLogManager {
    private static final int c = 50;
    private static volatile PublishLogManager d;
    private final c1 a;
    private final PublishLogDao b;

    private PublishLogManager() {
        Object object = c1.b();
        this.a = object;
        this.b = object = DatabaseHelper.getInstance().getDataBase().publishLogDao();
    }

    private void a(PublishLog publishLog) {
        Executor executor = this.a.a();
        l l10 = new l(this, publishLog);
        executor.execute(l10);
    }

    private void c(List list) {
        this.b.deletePublishLog(list);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static PublishLogManager d() {
        Object object = d;
        if (object != null) return d;
        object = PublishLogManager.class;
        synchronized (object) {
            PublishLogManager publishLogManager = d;
            if (publishLogManager != null) return d;
            d = publishLogManager = new PublishLogManager();
            return d;
        }
    }

    private List e() {
        return this.b.loadPublishLog();
    }

    private /* synthetic */ void f(PublishLog publishLog) {
        Object[] objectArray = new Object[]{};
        m.a.a.b("START", objectArray);
        this.j(publishLog);
    }

    private /* synthetic */ void h() {
        Object[] objectArray = new Object[]{};
        m.a.a.b("UPLOAD", objectArray);
        this.l();
    }

    private void j(PublishLog publishLog) {
        PublishLogDao publishLogDao = this.b;
        PublishLog[] publishLogArray = new PublishLog[]{publishLog};
        publishLogDao.insert(publishLogArray);
    }

    private void l() {
        block15: {
            Object[] objectArray = this.e();
            int n10 = objectArray.size();
            Object object = new StringBuilder();
            ((StringBuilder)object).append("total size = ");
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            Object[] objectArray2 = new Object[]{};
            m.a.a.b((String)object, objectArray2);
            int n11 = objectArray.isEmpty();
            if (n11 == 0) {
                n11 = 50;
                if (n10 > n11) {
                    n10 = n11;
                }
                objectArray = objectArray.subList(0, n10);
                Object object2 = new PublishLogList();
                object = new ArrayList();
                ((PublishLogList)object2).data = object;
                object.addAll(objectArray);
                object = j.a;
                object2 = object.h((PublishLogList)object2);
                object2 = object2.execute();
                object2 = ((r)object2).a();
                object2 = (BaseEntity)object2;
                if (object2 == null) break block15;
                n10 = ((BaseEntity)object2).errcode;
                if (n10 != 0) break block15;
                try {
                    this.c((List)objectArray);
                    this.l();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                    objectArray = new Object[]{};
                    object2 = "END WITH ERROR";
                    m.a.a.b((String)object2, objectArray);
                }
            } else {
                objectArray = new Object[]{};
                String string2 = "END WITH SUCCESS";
                m.a.a.b(string2, objectArray);
            }
        }
    }

    public void b(String string2, String string3, String string4, String string5, PublishLogManager$ReasonCode publishLogManager$ReasonCode, String string6, String string7, String string8) {
        Object object = "";
        Object object2 = string6 == null ? object : string6;
        Object object3 = string7 == null ? object : string7;
        String string9 = Times.TIME.getDate();
        String string10 = PublishLogManager$ReasonCode.access$000(publishLogManager$ReasonCode);
        object = new PublishLog(string2, string3, string4, string5, string10, (String)object2, (String)object3, string9, string8);
        this.a((PublishLog)object);
        this.k();
    }

    public /* synthetic */ void g(PublishLog publishLog) {
        this.f(publishLog);
    }

    public /* synthetic */ void i() {
        this.h();
    }

    public void k() {
        Executor executor = this.a.a();
        m m10 = new m(this);
        executor.execute(m10);
    }
}

