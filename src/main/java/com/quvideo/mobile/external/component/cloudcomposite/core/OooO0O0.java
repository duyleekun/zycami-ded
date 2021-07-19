/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.quvideo.mobile.external.component.cloudcomposite.core;

import android.content.Context;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooO0o;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.ICompositeTask;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OnCompositeListener;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OooO00o;
import d.o.a.a.a.a.b.b;
import e.a.z;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class OooO0O0 {
    public static String OooO0o = "CloudComposite";
    private static OooO0O0 OooO0oO;
    private boolean OooO00o = false;
    private Context OooO0O0;
    private OooO00o OooO0OO;
    private com.quvideo.mobile.external.component.cloudcomposite.protocal.OooO0O0 OooO0Oo;
    private List OooO0o0;

    static {
        OooO0O0 oooO0O0;
        OooO0oO = oooO0O0 = new OooO0O0();
    }

    private OooO0O0() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        this.OooO0o0 = copyOnWriteArrayList = new CopyOnWriteArrayList();
    }

    public static OooO0O0 OooO0O0() {
        return OooO0oO;
    }

    public z OooO00o(int n10, int n11, int n12) {
        boolean bl2 = this.OooO00o;
        if (!bl2) {
            com.quvideo.mobile.external.platform.log.OooO00o.OooO0O0(OooO0o, "has not been initialized");
            return null;
        }
        return com.quvideo.mobile.external.platform.api.cloudengine.OooO0O0.OooO00o(n10, n11, n12);
    }

    public void OooO00o() {
        boolean bl2;
        boolean bl3 = this.OooO00o;
        if (!bl3) {
            com.quvideo.mobile.external.platform.log.OooO00o.OooO0O0(OooO0o, "has not been initialized");
            return;
        }
        Iterator iterator2 = this.OooO0o0.iterator();
        while (bl2 = iterator2.hasNext()) {
            ICompositeTask iCompositeTask = (ICompositeTask)iterator2.next();
            iCompositeTask.cancelUpload();
            List list = this.OooO0o0;
            list.remove(iCompositeTask);
        }
    }

    public void OooO00o(Context context, OooO00o oooO00o, com.quvideo.mobile.external.component.cloudcomposite.protocal.OooO0O0 oooO0O0) {
        this.OooO0O0 = context = context.getApplicationContext();
        this.OooO0OO = oooO00o;
        this.OooO0Oo = oooO0O0;
        this.OooO00o = true;
    }

    public void OooO00o(OooO0o oooO0o, OnCompositeListener onCompositeListener) {
        boolean bl2 = this.OooO00o;
        if (!bl2) {
            com.quvideo.mobile.external.platform.log.OooO00o.OooO0O0(OooO0o, "has not been initialized");
            return;
        }
        List list = this.OooO0o0;
        Context context = this.OooO0O0;
        b b10 = new b(context, oooO0o, onCompositeListener);
        list.add(b10);
    }

    public void OooO00o(ICompositeTask iCompositeTask) {
        this.OooO0o0.remove(iCompositeTask);
    }

    public OooO00o OooO0OO() {
        return this.OooO0OO;
    }

    public com.quvideo.mobile.external.component.cloudcomposite.protocal.OooO0O0 OooO0Oo() {
        return this.OooO0Oo;
    }
}

