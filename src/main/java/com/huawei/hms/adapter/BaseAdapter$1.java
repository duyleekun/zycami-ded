/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.huawei.hms.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

public class BaseAdapter$1
implements SystemObserver {
    public final /* synthetic */ BaseAdapter this$0;

    public BaseAdapter$1(BaseAdapter baseAdapter) {
        this.this$0 = baseAdapter;
    }

    public boolean onSolutionResult(Intent object, String object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        boolean bl3 = true;
        String string2 = "BaseAdapter";
        if (bl2) {
            HMSLog.e(string2, "onSolutionResult but id is null");
            object = BaseAdapter.access$000(this.this$0);
            if (object == null) {
                HMSLog.e(string2, "onSolutionResult baseCallBack null");
                return bl3;
            }
            object2 = BaseAdapter.access$100(this.this$0, -6);
            object.onError((String)object2);
            return bl3;
        }
        Object object3 = BaseAdapter.access$700(this.this$0);
        bl2 = ((String)object2).equals(object3);
        int n10 = 0;
        Object object4 = null;
        if (bl2) {
            boolean bl4;
            boolean n11;
            object3 = new StringBuilder();
            String string3 = "onSolutionResult + id is :";
            ((StringBuilder)object3).append(string3);
            ((StringBuilder)object3).append((String)object2);
            object2 = ((StringBuilder)object3).toString();
            HMSLog.i(string2, (String)object2);
            object2 = BaseAdapter.access$000(this.this$0);
            if (object2 == null) {
                HMSLog.e(string2, "onResult baseCallBack null");
                return bl3;
            }
            long l10 = 0L;
            if (object == null) {
                HMSLog.e(string2, "onSolutionResult but data is null");
                object = BaseAdapter.access$100(this.this$0, -7);
                object3 = this.this$0;
                string2 = BaseAdapter.access$300((BaseAdapter)object3);
                object4 = BaseAdapter.access$200(this.this$0);
                BaseAdapter.access$800((BaseAdapter)object3, (Context)string2, (ResponseHeader)object4, l10);
                object2.onError((String)object);
                return bl3;
            }
            object3 = "kit_update_result";
            boolean bl42 = object.hasExtra((String)object3);
            if (bl42) {
                boolean bl5 = object.getIntExtra((String)object3, 0);
                object3 = new StringBuilder();
                object4 = "kit_update_result is ";
                ((StringBuilder)object3).append((String)object4);
                ((StringBuilder)object3).append((int)(bl5 ? 1 : 0));
                object3 = ((StringBuilder)object3).toString();
                HMSLog.i(string2, (String)object3);
                if (bl5 == bl3) {
                    HMSLog.e(string2, "kit update success,replay request");
                    object = this.this$0;
                    BaseAdapter.access$900((BaseAdapter)object);
                } else {
                    HMSLog.e(string2, "kit update failed");
                    object3 = this.this$0;
                    object = BaseAdapter.access$1000((BaseAdapter)object3, (int)(bl5 ? 1 : 0));
                    int n12 = -10;
                    object = BaseAdapter.access$1100((BaseAdapter)object3, n12, (String)object).toJson();
                    object2.onError((String)object);
                }
                return bl3;
            }
            HMSLog.e(string2, "onComplete for on activity result");
            object3 = object.getStringExtra("json_header");
            string2 = object.getStringExtra("json_body");
            object4 = JsonUtil.getInfoFromJsonobject((String)object3, "status_code");
            Object object5 = JsonUtil.getInfoFromJsonobject((String)object3, "error_code");
            String string4 = "HMS_FOREGROUND_RES_UI";
            boolean bl5 = object.hasExtra(string4);
            if (bl5) {
                object = object.getStringExtra(string4);
                string4 = "uiDuration";
                boolean bl6 = (object = JsonUtil.getInfoFromJsonobject((String)object, string4)) instanceof Long;
                if (bl6) {
                    object = (Long)object;
                    l10 = (Long)object;
                }
            }
            if ((n11 = object4 instanceof Integer) && (bl4 = object5 instanceof Integer)) {
                int n13 = (Integer)object4;
                n10 = (Integer)object5;
                BaseAdapter.access$100(this.this$0, n10);
                BaseAdapter.access$200(this.this$0).setStatusCode(n13);
                object = this.this$0;
                object4 = BaseAdapter.access$300((BaseAdapter)object);
                object5 = BaseAdapter.access$200(this.this$0);
                BaseAdapter.access$800((BaseAdapter)object, (Context)object4, (ResponseHeader)object5, l10);
            } else {
                object = this.this$0;
                n10 = -8;
                BaseAdapter.access$100((BaseAdapter)object, n10);
                object = this.this$0;
                object4 = BaseAdapter.access$300((BaseAdapter)object);
                object5 = BaseAdapter.access$200(this.this$0);
                BaseAdapter.access$800((BaseAdapter)object, (Context)object4, (ResponseHeader)object5, l10);
            }
            object2.onComplete((String)object3, string2, null);
            return bl3;
        }
        return false;
    }

    public boolean onUpdateResult(int n10) {
        return false;
    }
}

