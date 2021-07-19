/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

import androidx.lifecycle.MutableLiveData;
import com.kwai.auth.common.InternalResponse;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.data.me.remote.KWaiManager;
import com.zhiyun.cama.data.me.remote.KWaiManager$OnKWaiLoginCallback;
import com.zhiyun.cama.data.me.remote.data.KwaiTokenInfo;
import d.l.a.b;
import d.v.c.v0.u.c0.f;
import d.v.e.i.h;
import d.v.e.l.c1;
import java.util.concurrent.Executor;

public class KWaiManager$2
implements b {
    public final /* synthetic */ KWaiManager this$0;
    public final /* synthetic */ KWaiManager$OnKWaiLoginCallback val$callback;

    public KWaiManager$2(KWaiManager kWaiManager, KWaiManager$OnKWaiLoginCallback kWaiManager$OnKWaiLoginCallback) {
        this.this$0 = kWaiManager;
        this.val$callback = kWaiManager$OnKWaiLoginCallback;
    }

    private /* synthetic */ void a(InternalResponse object, KWaiManager$OnKWaiLoginCallback object2) {
        int n10;
        Object object3 = null;
        for (int i10 = 0; object3 == null && i10 < (n10 = 5); ++i10) {
            object3 = this.this$0;
            String string2 = ((InternalResponse)object).getCode();
            object3 = KWaiManager.access$100((KWaiManager)object3, string2);
        }
        if (object3 != null) {
            if (object2 != null) {
                object2.onSuccess((KwaiTokenInfo)object3);
            } else {
                h.g(KWaiManager.access$200(this.this$0), object3);
                object = KWaiManager.access$000(this.this$0);
                object2 = PagingRequestHelper$Status.SUCCESS;
                h.g((MutableLiveData)object, object2);
            }
        } else if (object2 != null) {
            object = "get accessToken fail";
            object2.onFailed((String)object);
        } else {
            object = KWaiManager.access$000(this.this$0);
            object2 = PagingRequestHelper$Status.FAILED;
            h.g((MutableLiveData)object, object2);
        }
    }

    public /* synthetic */ void b(InternalResponse internalResponse, KWaiManager$OnKWaiLoginCallback kWaiManager$OnKWaiLoginCallback) {
        this.a(internalResponse, kWaiManager$OnKWaiLoginCallback);
    }

    public void onCancel() {
        Object object = this.val$callback;
        if (object != null) {
            String string2 = "get accessToken cancel";
            object.onFailed(string2);
        } else {
            object = KWaiManager.access$000(this.this$0);
            PagingRequestHelper$Status pagingRequestHelper$Status = PagingRequestHelper$Status.FAILED;
            h.g((MutableLiveData)object, (Object)pagingRequestHelper$Status);
        }
    }

    public void onFailed(String object, int n10, String string2) {
        object = this.val$callback;
        if (object != null) {
            object.onFailed(string2);
        } else {
            object = KWaiManager.access$000(this.this$0);
            PagingRequestHelper$Status pagingRequestHelper$Status = PagingRequestHelper$Status.FAILED;
            h.g((MutableLiveData)object, (Object)pagingRequestHelper$Status);
        }
    }

    public void onSuccess(InternalResponse internalResponse) {
        Executor executor = c1.b().e();
        KWaiManager$OnKWaiLoginCallback kWaiManager$OnKWaiLoginCallback = this.val$callback;
        f f10 = new f(this, internalResponse, kWaiManager$OnKWaiLoginCallback);
        executor.execute(f10);
    }
}

