/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 */
package d.v.c.t0;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.ICompositeTask;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.MediaType;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OnCompositeListener$State;
import com.quvideo.mobile.external.component.cloudengine.QVCloudEngine;
import com.quvideo.mobile.external.component.cloudengine.model.CompositeConfig;
import com.quvideo.mobile.external.component.cloudengine.model.CompositeConfig$Media;
import com.quvideo.mobile.external.component.cloudengine.model.CompositeConfig$Resolution;
import com.quvideo.mobile.external.component.cloudengine.model.RequestError;
import d.v.c.t0.g;
import d.v.c.t0.h;
import d.v.c.t0.v$a;
import d.v.c.t0.v$b;
import d.v.e.l.b2;
import d.v.e.l.m1;
import d.v.e.l.s1;
import d.v.h.e.a;
import java.util.List;
import java.util.stream.Collectors;

public class v
extends AndroidViewModel {
    public MutableLiveData a;
    public MutableLiveData b;
    public MutableLiveData c;
    private ICompositeTask d;
    private long e;
    private CompositeConfig$Resolution f;
    private List g;
    public String h;
    public int i;

    public v(Application object) {
        super((Application)object);
        Integer n10 = 0;
        super(n10);
        this.a = object;
        super();
        this.b = object;
        super();
        this.c = object;
    }

    public static /* synthetic */ ICompositeTask b(v v10, ICompositeTask iCompositeTask) {
        v10.d = iCompositeTask;
        return iCompositeTask;
    }

    public static /* synthetic */ void c(v v10, OnCompositeListener$State onCompositeListener$State) {
        v10.m(onCompositeListener$State);
    }

    private MediaType e(Enum enum_) {
        com.zhiyun.editorinterface.edit.MediaType mediaType = com.zhiyun.editorinterface.edit.MediaType.VIDEO;
        enum_ = mediaType == enum_ ? MediaType.VIDEO : MediaType.IMAGE;
        return enum_;
    }

    public static /* synthetic */ Boolean f(RequestError object) {
        boolean bl2;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((RequestError)object).getMessage())))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private /* synthetic */ CompositeConfig$Media g(a object) {
        String string2 = s1.G(Uri.parse((String)object.e()));
        object = object.f();
        object = this.e((Enum)object);
        string2 = Uri.parse((String)string2);
        CompositeConfig$Media compositeConfig$Media = new CompositeConfig$Media((MediaType)((Object)object), (Uri)string2);
        return compositeConfig$Media;
    }

    private void j(long l10, CompositeConfig$Resolution object, List list) {
        Application application = this.getApplication();
        boolean bl2 = b2.m((Context)application);
        if (!bl2) {
            MutableLiveData mutableLiveData = this.c;
            object = d.v.f.i.g.m((Context)application, 2131951841);
            RequestError requestError = new RequestError((String)object, -1);
            mutableLiveData.setValue(requestError);
            return;
        }
        long l11 = System.currentTimeMillis();
        Object object2 = m1.l(l11, "yyyy-MM-dd HH:mm:ss");
        this.h = object2;
        object2 = new CompositeConfig(l10, (CompositeConfig$Resolution)((Object)object), list);
        v$a v$a = new v$a(this, l11, (Context)application);
        QVCloudEngine.composite((CompositeConfig)object2, v$a);
    }

    private void m(OnCompositeListener$State object) {
        Object object2 = v$b.a;
        int n10 = object.ordinal();
        int n11 = 1;
        if ((n10 = object2[n10]) != n11) {
            n11 = 3;
            if (n10 != n11) {
                n11 = 4;
                if (n10 != n11) {
                    n11 = 5;
                    if (n10 == n11) {
                        object = this.a;
                        n11 = 100;
                        object2 = n11;
                        d.v.e.i.h.e((MutableLiveData)object, object2);
                    }
                } else {
                    object = this.a;
                    n11 = 80;
                    object2 = n11;
                    d.v.e.i.h.e((MutableLiveData)object, object2);
                }
            } else {
                object = this.a;
                n11 = 50;
                object2 = n11;
                d.v.e.i.h.e((MutableLiveData)object, object2);
            }
        } else {
            object = this.a;
            n11 = 0;
            object2 = 0;
            d.v.e.i.h.e((MutableLiveData)object, object2);
        }
    }

    public LiveData d() {
        MutableLiveData mutableLiveData = this.c;
        h h10 = d.v.c.t0.h.a;
        return Transformations.map(mutableLiveData, h10);
    }

    public /* synthetic */ CompositeConfig$Media i(a a10) {
        return this.g(a10);
    }

    public void k() {
        this.c.setValue(null);
        long l10 = this.e;
        CompositeConfig$Resolution compositeConfig$Resolution = this.f;
        List list = this.g;
        this.j(l10, compositeConfig$Resolution, list);
    }

    public void l(long l10, CompositeConfig$Resolution compositeConfig$Resolution, List object) {
        object = object.stream();
        Object object2 = new g(this);
        object = object.map(object2);
        object2 = Collectors.toList();
        object = (List)object.collect(object2);
        this.e = l10;
        this.f = compositeConfig$Resolution;
        this.g = object;
        this.j(l10, compositeConfig$Resolution, (List)object);
    }

    public void onCleared() {
        ICompositeTask iCompositeTask = this.d;
        if (iCompositeTask != null) {
            iCompositeTask.cancelUpload();
            iCompositeTask = this.d;
            iCompositeTask.release();
        }
    }
}

