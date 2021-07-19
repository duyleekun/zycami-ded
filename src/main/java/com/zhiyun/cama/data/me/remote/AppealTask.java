/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.cama.data.me.remote;

import android.text.TextUtils;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.data.api.entity.IntegerEntity;
import com.zhiyun.cama.data.database.TypeListStringConverters;
import com.zhiyun.cama.data.database.model.Appeal;
import com.zhiyun.cama.data.database.model.Approval;
import com.zhiyun.cama.data.database.model.MessageViolation;
import com.zhiyun.cama.data.database.model.Works;
import com.zhiyun.cama.data.me.remote.AliyunManager;
import com.zhiyun.cama.data.me.remote.CommunityManager;
import com.zhiyun.net.BaseEntity;
import com.zhiyun.net.Punish;
import d.v.a.f.b.a;
import d.v.c.v0.u.c0.b;
import d.v.c.v0.u.c0.c;
import d.v.c.v0.u.c0.d;
import d.v.c.v0.u.c0.e;
import d.v.e.l.c1;
import d.v.e.l.m1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.r;

public class AppealTask
implements Runnable {
    private String mAppealReason;
    private Approval mApproval;
    private a mCallback;
    private List mPics;
    private Punish mPunish;
    private String mType;

    public AppealTask(String string2, Approval approval, Punish punish, String string3, List list, a a10) {
        this.mType = string2;
        this.mApproval = approval;
        this.mPunish = punish;
        this.mAppealReason = string3;
        this.mPics = list;
        this.mCallback = a10;
    }

    private /* synthetic */ void a(IntegerEntity integerEntity) {
        this.mCallback.onSuccess(integerEntity);
    }

    private /* synthetic */ void c(IntegerEntity object) {
        a a10 = this.mCallback;
        String string2 = ((BaseEntity)object).toString();
        Throwable throwable = new Throwable(string2);
        int n10 = ((BaseEntity)object).errcode;
        object = ((BaseEntity)object).errmsg;
        a10.onError(throwable, n10, (String)object);
    }

    private void changeLocalData(int n10, int n11) {
        Object object;
        d.v.c.v0.u.b0.b b10 = d.v.c.v0.u.b0.b.g();
        Object object2 = b10.l((String)(object = this.mType), n10);
        if (object2 != null) {
            object = String.valueOf(n11);
            ((MessageViolation)object2).setAppeal_id((String)object);
            b10.q((MessageViolation)object2);
        }
        if ((n10 = (int)(((String)(object = "person_production_approval_notice")).equals(object2 = this.mType) ? 1 : 0)) != 0 && (object2 = b10.n(n10 = this.mApproval.getId())) != null) {
            object = new Appeal(n11);
            ((Works)object2).setAppeal((Appeal)object);
            b10.s((Works)object2);
        }
    }

    private /* synthetic */ void e() {
        a a10 = this.mCallback;
        Throwable throwable = new Throwable("entity = null");
        a10.onError(throwable, -1, "");
    }

    private /* synthetic */ void g(Exception exception) {
        this.mCallback.onError(exception, -1, "");
    }

    public /* synthetic */ void b(IntegerEntity integerEntity) {
        this.a(integerEntity);
    }

    public /* synthetic */ void d(IntegerEntity integerEntity) {
        this.c(integerEntity);
    }

    public /* synthetic */ void f() {
        this.e();
    }

    public /* synthetic */ void h(Exception exception) {
        this.g(exception);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object = "-";
        Object object2 = "punish_notice";
        try {
            Object object3;
            Object object4;
            int n10;
            Object object5;
            Iterator iterator2;
            Object object6;
            int n11;
            int n12;
            Object object7;
            int n13;
            Object object8;
            Iterator iterator3;
            Object object9 = this.mType;
            int n14 = ((String)object2).equals(object9);
            object9 = null;
            if (n14 != 0) {
                n14 = 2;
                iterator3 = this.mPunish;
                iterator3 = ((Punish)((Object)iterator3)).getUserId();
                object8 = this.mPunish;
                n13 = ((Punish)object8).getId();
                object8 = String.valueOf(n13);
                object7 = this.mPunish;
                n12 = ((Punish)object7).getId();
                n11 = n14;
                object6 = null;
                iterator2 = iterator3;
                object5 = object8;
            } else {
                n14 = 1;
                iterator3 = d.v.a.f.c.b.N();
                iterator3 = ((d.v.a.f.c.b)((Object)iterator3)).i();
                n10 = ((UserInfo)((Object)iterator3)).getId();
                iterator3 = String.valueOf(n10);
                object8 = this.mApproval;
                n13 = ((Approval)object8).getId();
                object8 = String.valueOf(n13);
                object7 = this.mApproval;
                n12 = ((Approval)object7).getId();
                n11 = n14;
                object5 = null;
                iterator2 = iterator3;
                object6 = object8;
            }
            object2 = new ArrayList();
            iterator3 = this.mPics;
            if (iterator3 != null && (n10 = (int)(iterator3.isEmpty() ? 1 : 0)) == 0) {
                iterator3 = this.mPics;
                iterator3 = iterator3.iterator();
                while ((n13 = (int)(iterator3.hasNext() ? 1 : 0)) != 0) {
                    object8 = iterator3.next();
                    boolean bl2 = TextUtils.isEmpty((CharSequence)(object8 = (String)object8));
                    if (bl2) continue;
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append((String)((Object)iterator2));
                    ((StringBuilder)object4).append((String)object);
                    object3 = this.mPics;
                    int n15 = object3.indexOf(object8);
                    ((StringBuilder)object4).append(n15);
                    ((StringBuilder)object4).append((String)object);
                    long l10 = System.currentTimeMillis();
                    object3 = m1.h(l10);
                    ((StringBuilder)object4).append((String)object3);
                    object3 = ".jpg";
                    ((StringBuilder)object4).append((String)object3);
                    object4 = ((StringBuilder)object4).toString();
                    object3 = AliyunManager.instance();
                    object8 = ((AliyunManager)object3).uploadAppealPicFile((String)object4, (String)object8, null);
                    object2.add(object8);
                }
            }
            object4 = CommunityManager.getInstance();
            object3 = this.mAppealReason;
            String string2 = TypeListStringConverters.stringListToString(object2);
            object = ((CommunityManager)object4).createCommitAppeal((String)((Object)iterator2), n11, (String)object3, string2, (String)object5, (String)object6);
            object = object.execute();
            object = ((r)object).a();
            if ((object = (IntegerEntity)object) != null && (n14 = ((BaseEntity)object).errcode) == 0) {
                n14 = ((IntegerEntity)object).id;
                this.changeLocalData(n12, n14);
                object2 = c1.b();
                object2 = ((c1)object2).c();
                object9 = new c(this, (IntegerEntity)object);
                object2.execute((Runnable)object9);
                return;
            }
            if (object != null) {
                object2 = c1.b();
                object2 = ((c1)object2).c();
                object9 = new d(this, (IntegerEntity)object);
                object2.execute((Runnable)object9);
                return;
            }
            object = c1.b();
            object = ((c1)object).c();
            object2 = new b(this);
            object.execute((Runnable)object2);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object2 = c1.b().c();
            e e10 = new e(this, exception);
            object2.execute(e10);
        }
    }
}

