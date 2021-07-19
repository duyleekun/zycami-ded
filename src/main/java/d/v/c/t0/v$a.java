/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.t0;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.quvideo.mobile.external.component.cloudcomposite.model.CompositeFinishResponse;
import com.quvideo.mobile.external.component.cloudcomposite.model.CompositePreResponse;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.ICompositeTask;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OnCompositeListener;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OnCompositeListener$State;
import com.quvideo.mobile.external.component.cloudengine.QVCloudEngine;
import com.quvideo.mobile.external.component.cloudengine.model.RequestError;
import d.v.c.t0.i0;
import d.v.c.t0.v;
import d.v.e.i.e;
import d.v.e.i.h;
import d.v.f.i.g;
import java.util.Collections;
import m.a.a;

public class v$a
implements OnCompositeListener {
    public final /* synthetic */ long a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ v c;

    public v$a(v v10, long l10, Context context) {
        this.c = v10;
        this.a = l10;
        this.b = context;
    }

    public void onFailure(ICompositeTask object, RequestError object2, OnCompositeListener$State object3, boolean bl2) {
        int n10;
        v.b(this.c, (ICompositeTask)object);
        object = new StringBuilder();
        ((StringBuilder)object).append("composite error. message = ");
        object3 = ((RequestError)object2).getMessage();
        ((StringBuilder)object).append((String)object3);
        ((StringBuilder)object).append(", code = ");
        int n11 = ((RequestError)object2).getCode();
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        Object object4 = new Object[]{};
        m.a.a.e((String)object, object4);
        object = this.c.c;
        String string2 = g.m(this.b, 2131951834);
        int n12 = ((RequestError)object2).getCode();
        object4 = new RequestError(string2, n12);
        h.g((MutableLiveData)object, object4);
        long l10 = System.currentTimeMillis();
        object4 = this.c;
        long l11 = this.a;
        object4.i = n10 = (int)(l10 - l11) / 1000;
        object = i0.e();
        object2 = this.c;
        object4 = ((v)object2).h;
        n12 = ((v)object2).i;
        ((i0)object).h((String)object4, "", 0, n12);
    }

    public void onNext(ICompositeTask iCompositeTask, OnCompositeListener$State onCompositeListener$State) {
        v.c(this.c, onCompositeListener$State);
    }

    public void onPreComposite(ICompositeTask iCompositeTask, CompositePreResponse compositePreResponse) {
        v.b(this.c, iCompositeTask);
    }

    public void onSuccess(ICompositeTask object, CompositeFinishResponse object2) {
        int n10;
        v.b(this.c, (ICompositeTask)object);
        long l10 = System.currentTimeMillis();
        object = this.c;
        long l11 = this.a;
        ((v)object).i = n10 = (int)(l10 - l11) / 1000;
        QVCloudEngine.report(Collections.singletonList(((CompositeFinishResponse)object2).getFileId()));
        object = this.c.b;
        Object object3 = new e(object2);
        h.g((MutableLiveData)object, object3);
        object = i0.e();
        object3 = this.c.h;
        object2 = ((CompositeFinishResponse)object2).getFileUrl();
        int n11 = this.c.i;
        ((i0)object).h((String)object3, (String)object2, 1, n11);
    }

    public void onUploadProgress(ICompositeTask object, int n10) {
        v.b(this.c, (ICompositeTask)object);
        object = this.c.a;
        Integer n11 = (int)((float)n10 * 0.2f);
        h.e((MutableLiveData)object, n11);
    }
}

