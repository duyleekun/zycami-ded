/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

import com.google.gson.Gson;
import d.v.a.f.a.a;
import d.v.c.v0.l.g;
import d.v.c.v0.l.j;
import d.v.e.l.w1;
import k.d;

public class CommunityManager {
    private static volatile CommunityManager instance;

    private CommunityManager() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static CommunityManager getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = CommunityManager.class;
        synchronized (object) {
            CommunityManager communityManager = instance;
            if (communityManager != null) return instance;
            instance = communityManager = new CommunityManager();
            return instance;
        }
    }

    private String getLang() {
        return w1.a();
    }

    private String getToken() {
        return d.v.a.f.c.d.d.F().K();
    }

    private int getUserId() {
        return d.v.a.f.c.d.d.F().L().getId();
    }

    public d createAddReadCount(int n10) {
        g g10 = g.a;
        String string2 = this.getToken();
        return g10.c(string2, n10);
    }

    public d createCommitAppeal(String string2, int n10, String string3, String string4, String string5, String string6) {
        return d.v.c.v0.l.d.a.g(string2, n10, string3, string4, string5, string6);
    }

    public d createDeleteMessage(int n10) {
        g g10 = g.a;
        String string2 = this.getToken();
        return g10.b(string2, n10);
    }

    public d createMessageRead(int n10, String string2) {
        g g10 = g.a;
        String string3 = this.getToken();
        return g10.d(string3, n10, string2);
    }

    public d createMessageUnreadCount() {
        g g10 = g.a;
        String string2 = this.getToken();
        String string3 = this.getLang();
        return g10.h(string2, string3);
    }

    public d createPublishWorks(String string2, String[] stringArray, String string3, String string4, String string5, String string6, int n10, int n11, int n12, String string7, String string8, int n13, String string9) {
        String string10;
        j j10 = j.a;
        String string11 = this.getToken();
        Object object = new Gson();
        Object object2 = stringArray;
        object2 = ((Gson)object).toJson(stringArray);
        object = null;
        String string12 = n10 > 0 ? (string10 = String.valueOf(n10)) : null;
        String string13 = n11 > 0 ? (string10 = String.valueOf(n11)) : null;
        if (n12 > 0) {
            object = String.valueOf(n12);
        }
        Gson gson = object;
        String string14 = this.getLang();
        object = string2;
        string10 = string3;
        return j10.g(string11, string2, (String)object2, string3, string4, "android", string5, string6, string12, string13, (String)((Object)gson), string7, string5, string8, n13, string9, string14);
    }

    public d createSaveTemplateConfig(String string2, String string3) {
        j j10 = j.a;
        String string4 = this.getToken();
        return j10.e(string4, string2, string3);
    }

    public d createUserDetail(int n10) {
        a a10 = a.a;
        String string2 = this.getToken();
        return a10.e(n10, string2);
    }

    public d getAppealDetail(String string2) {
        d.v.c.v0.l.d d10 = d.v.c.v0.l.d.a;
        int n10 = this.getUserId();
        String string3 = this.getLang();
        return d10.e(string2, n10, string3);
    }
}

