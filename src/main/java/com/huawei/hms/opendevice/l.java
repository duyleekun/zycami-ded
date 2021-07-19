/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResp;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.n;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

public class l
extends TaskApiCall {
    public Context a;
    public TokenReq b;

    public l(String string2, TokenReq tokenReq, Context context, String string3) {
        String string4 = JsonUtil.createJsonString(tokenReq);
        super(string2, string4, string3);
        this.a = context;
        this.b = tokenReq;
    }

    public void a(PushClient pushClient, ResponseErrorCode responseErrorCode, String object, d.j.d.a.l object2) {
        int n10 = responseErrorCode.getErrorCode();
        if (n10 != 0) {
            object = HmsInstanceId.TAG;
            Object object3 = new StringBuilder();
            String string2 = "TokenTask failed, ErrorCode: ";
            object3.append(string2);
            int n11 = responseErrorCode.getErrorCode();
            object3.append(n11);
            object3 = object3.toString();
            HMSLog.e((String)object, (String)object3);
            int n12 = responseErrorCode.getErrorCode();
            object = ErrorEnum.fromCode(n12);
            object3 = ErrorEnum.ERROR_UNKNOWN;
            if (object != object3) {
                object = ((ErrorEnum)((Object)object)).toApiException();
                ((d.j.d.a.l)object2).c((Exception)object);
            } else {
                n11 = responseErrorCode.getErrorCode();
                String string3 = responseErrorCode.getErrorReason();
                object3 = new Status(n11, string3);
                object = new ApiException((Status)object3);
                ((d.j.d.a.l)object2).c((Exception)object);
            }
        } else {
            Object object4;
            Object object5 = new TokenResp();
            n10 = ((TokenResp)(object = (TokenResp)JsonUtil.jsonToEntity((String)object, (IMessageEntity)object5))).getRetCode();
            if ((object5 = ErrorEnum.fromCode(n10)) != (object4 = ErrorEnum.SUCCESS)) {
                object = ((ErrorEnum)((Object)object5)).toApiException();
                ((d.j.d.a.l)object2).c((Exception)object);
                object = HmsInstanceId.TAG;
                object2 = new StringBuilder();
                object4 = "TokenTask failed, StatusCode:";
                ((StringBuilder)object2).append((String)object4);
                n10 = ((ErrorEnum)((Object)object5)).getExternalCode();
                ((StringBuilder)object2).append(n10);
                object2 = ((StringBuilder)object2).toString();
                HMSLog.e((String)object, (String)object2);
            } else {
                object5 = new TokenResult();
                object4 = ((TokenResp)object).getToken();
                ((TokenResult)object5).setToken((String)object4);
                object4 = ((TokenResp)object).getBelongId();
                ((TokenResult)object5).setBelongId((String)object4);
                object4 = ErrorEnum.fromCode(((TokenResp)object).getRetCode());
                int n13 = ((ErrorEnum)((Object)object4)).getExternalCode();
                ((TokenResult)object5).setRetCode(n13);
                ((d.j.d.a.l)object2).d(object5);
                object = ((TokenResp)object).getToken();
                boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                if (bl2) {
                    HMSLog.i(HmsInstanceId.TAG, "GetTokenTask receive a empty token, please check HmsMessageService.onNewToken receive result.");
                    pushClient = pushClient.getContext();
                    object = this.getUri();
                    q.a((Context)pushClient, (String)object, responseErrorCode);
                    return;
                }
                object2 = this.b.getSubjectId();
                this.a((String)object, (String)object2);
                object2 = this.a;
                n.a((Context)object2, (String)object);
            }
        }
        pushClient = pushClient.getContext();
        object = this.getUri();
        q.a((Context)pushClient, (String)object, responseErrorCode);
    }

    public final void a(String string2, String string3) {
        Object object = i.a(this.a).b(string3);
        boolean bl2 = ((String)object).equals(string2);
        if (!bl2) {
            object = HmsInstanceId.TAG;
            String string4 = "receive a token, refresh the local token";
            HMSLog.i((String)object, string4);
            object = i.a(this.a);
            ((i)object).b(string3, string2);
        }
    }

    public int getMinApkVersion() {
        TokenReq tokenReq = this.b;
        boolean bl2 = tokenReq.isMultiSender();
        if (bl2) {
            return 50004300;
        }
        return 30000000;
    }
}

