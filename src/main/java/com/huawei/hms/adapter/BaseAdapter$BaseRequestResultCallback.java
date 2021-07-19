/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Parcelable
 *  android.text.TextUtils
 */
package com.huawei.hms.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.adapter.BaseAdapter$BaseCallBack;
import com.huawei.hms.adapter.CoreBaseResponse;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import java.util.concurrent.atomic.AtomicBoolean;

public class BaseAdapter$BaseRequestResultCallback
implements ResultCallback {
    private AtomicBoolean isFirstRsp;
    public final /* synthetic */ BaseAdapter this$0;

    public BaseAdapter$BaseRequestResultCallback(BaseAdapter object) {
        this.this$0 = object;
        this.isFirstRsp = object = new AtomicBoolean(true);
    }

    private void handleSolutionIntent(BaseAdapter$BaseCallBack baseAdapter$BaseCallBack, CoreBaseResponse object) {
        String string2 = "baseCallBack.onComplete";
        HMSLog.i("BaseAdapter", string2);
        Object object2 = ((CoreBaseResponse)object).getPendingIntent();
        if (object2 != null) {
            string2 = ((CoreBaseResponse)object).getJsonHeader();
            object = ((CoreBaseResponse)object).getJsonBody();
            baseAdapter$BaseCallBack.onComplete(string2, (String)object, (Parcelable)object2);
            return;
        }
        object2 = ((CoreBaseResponse)object).getIntent();
        if (object2 != null) {
            string2 = ((CoreBaseResponse)object).getJsonHeader();
            object = ((CoreBaseResponse)object).getJsonBody();
            baseAdapter$BaseCallBack.onComplete(string2, (String)object, (Parcelable)object2);
            return;
        }
        object2 = ((CoreBaseResponse)object).getJsonHeader();
        object = ((CoreBaseResponse)object).getJsonBody();
        baseAdapter$BaseCallBack.onComplete((String)object2, (String)object, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onResult(ResolveResult object) {
        BaseAdapter$BaseCallBack baseAdapter$BaseCallBack = BaseAdapter.access$000(this.this$0);
        String string2 = "BaseAdapter";
        if (baseAdapter$BaseCallBack == null) {
            HMSLog.e(string2, "onResult baseCallBack null");
            return;
        }
        int n10 = -1;
        if (object == null) {
            HMSLog.e(string2, "result null");
            object = BaseAdapter.access$100(this.this$0, n10);
            baseAdapter$BaseCallBack.onError((String)object);
            return;
        }
        if ((object = (CoreBaseResponse)((ResolveResult)object).getValue()) == null) {
            HMSLog.e(string2, "response null");
            object = BaseAdapter.access$100(this.this$0, n10);
            baseAdapter$BaseCallBack.onError((String)object);
            return;
        }
        Object object2 = ((CoreBaseResponse)object).getJsonHeader();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (bl2) {
            HMSLog.e(string2, "jsonHeader null");
            object = BaseAdapter.access$100(this.this$0, n10);
            baseAdapter$BaseCallBack.onError((String)object);
            return;
        }
        Object object3 = ((CoreBaseResponse)object).getJsonHeader();
        object2 = BaseAdapter.access$200(this.this$0);
        JsonUtil.jsonToEntity((String)object3, (IMessageEntity)object2);
        object3 = this.isFirstRsp;
        bl2 = true;
        int n11 = 0;
        Object object4 = null;
        n10 = (int)(((AtomicBoolean)object3).compareAndSet(bl2, false) ? 1 : 0);
        if (n10 != 0) {
            object3 = this.this$0;
            object2 = BaseAdapter.access$300((BaseAdapter)object3);
            object4 = BaseAdapter.access$200(this.this$0);
            BaseAdapter.access$400((BaseAdapter)object3, (Context)object2, (ResponseHeader)object4);
        }
        if ((n10 = (int)(((String)(object2 = "intent")).equals(object3 = BaseAdapter.access$200(this.this$0).getResolution()) ? 1 : 0)) == 0) {
            this.handleSolutionIntent(baseAdapter$BaseCallBack, (CoreBaseResponse)object);
            return;
        }
        object3 = BaseAdapter.access$500(this.this$0);
        object2 = new StringBuilder();
        object4 = "activity is ";
        ((StringBuilder)object2).append((String)object4);
        ((StringBuilder)object2).append(object3);
        object2 = ((StringBuilder)object2).toString();
        HMSLog.i(string2, (String)object2);
        if (object3 != null && !(bl2 = object3.isFinishing())) {
            object2 = ((CoreBaseResponse)object).getPendingIntent();
            n11 = -9;
            if (object2 != null) {
                object = BaseAdapter.access$300(this.this$0);
                boolean bl3 = Util.isAvailableLibExist((Context)object);
                if (bl3) {
                    BaseAdapter.access$600(this.this$0, (Activity)object3, (Parcelable)object2);
                    return;
                }
                object = BaseAdapter.access$100(this.this$0, n11);
                baseAdapter$BaseCallBack.onError((String)object);
                return;
            }
            if ((object = ((CoreBaseResponse)object).getIntent()) == null) {
                HMSLog.e(string2, "hasResolution is true but NO_SOLUTION");
                object = this.this$0;
                int n12 = -4;
                object = BaseAdapter.access$100((BaseAdapter)object, n12);
                baseAdapter$BaseCallBack.onError((String)object);
                return;
            }
            string2 = BaseAdapter.access$300(this.this$0);
            boolean bl4 = Util.isAvailableLibExist((Context)string2);
            if (bl4) {
                BaseAdapter.access$600(this.this$0, (Activity)object3, (Parcelable)object);
                return;
            }
            object = BaseAdapter.access$100(this.this$0, n11);
            baseAdapter$BaseCallBack.onError((String)object);
            return;
        }
        HMSLog.e(string2, "activity null");
        this.handleSolutionIntent(baseAdapter$BaseCallBack, (CoreBaseResponse)object);
    }
}

