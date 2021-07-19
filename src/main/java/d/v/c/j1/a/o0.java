/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.webkit.MimeTypeMap
 */
package d.v.c.j1.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.data.PagingRequestHelper$b;
import com.zhiyun.cama.data.api.entity.ProductEntity;
import com.zhiyun.cama.data.api.entity.ProductVersionEntity;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.data.me.remote.AliyunManager;
import com.zhiyun.cama.me.help.data.FeedbackSet$AdviceType;
import com.zhiyun.cama.me.help.data.FeedbackSet$Rate;
import com.zhiyun.cama.me.help.data.FeedbackSet$Type;
import d.v.c.j1.a.b0;
import d.v.c.j1.a.c0;
import d.v.c.j1.a.d0;
import d.v.c.j1.a.e0;
import d.v.c.j1.a.f0;
import d.v.c.j1.a.g0;
import d.v.c.j1.a.h0;
import d.v.c.j1.a.i0;
import d.v.c.j1.a.j0;
import d.v.c.j1.a.o0$a;
import d.v.c.j1.a.o0$b;
import d.v.c.j1.a.o0$c;
import d.v.c.j1.a.o0$d;
import d.v.c.j1.a.o0$e;
import d.v.c.j1.a.o0$f;
import d.v.c.j1.a.o0$g;
import d.v.c.j1.a.o0$h;
import d.v.c.j1.a.o0$i;
import d.v.c.v0.f;
import d.v.c.v0.g;
import d.v.c.v0.u.x;
import d.v.e.h.d;
import d.v.e.i.j;
import d.v.e.l.s1;
import e.a.c1.b;
import e.a.q0.c.a;
import e.a.v0.o;
import e.a.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class o0
extends ViewModel {
    public static final int D = 255;
    public static final int E = 255;
    public static final int F = 10501;
    public static final int G = 10502;
    public static final int H = 10503;
    public static final int I = 10504;
    public static final int J = 10505;
    public final List A;
    public final FeedbackSet$AdviceType[] B;
    public final List C;
    private final x a;
    private final MutableLiveData b;
    private final LiveData c;
    private final LiveData d;
    private final LiveData e;
    public final MutableLiveData f;
    public final MutableLiveData g;
    public final MutableLiveData h;
    public final MutableLiveData i;
    public j j;
    public j k;
    public j l;
    public j m;
    public MutableLiveData n;
    public final MutableLiveData o;
    public MutableLiveData p;
    public MutableLiveData q;
    public final MutableLiveData r;
    public final MutableLiveData s;
    public final MutableLiveData t;
    public final MutableLiveData u;
    public final MutableLiveData v;
    public final List w;
    public final MutableLiveData x;
    public final List y;
    public final FeedbackSet$Rate[] z;

    public o0() {
        Object object;
        int n10;
        Object object2 = new MutableLiveData();
        this.b = object2;
        object2 = new MutableLiveData();
        this.f = object2;
        object2 = new MutableLiveData();
        this.g = object2;
        object2 = new MutableLiveData();
        this.h = object2;
        object2 = new MutableLiveData();
        this.i = object2;
        this.j = object2;
        super();
        this.k = object2;
        super();
        this.l = object2;
        super();
        this.m = object2;
        object2 = new MutableLiveData();
        this.n = object2;
        object2 = new MutableLiveData();
        this.o = object2;
        object2 = new MutableLiveData();
        this.p = object2;
        object2 = new MutableLiveData();
        this.q = object2;
        object2 = new MutableLiveData();
        this.r = object2;
        object2 = new MutableLiveData();
        this.s = object2;
        object2 = new MutableLiveData();
        this.t = object2;
        object2 = new MutableLiveData();
        this.u = object2;
        object2 = new MutableLiveData();
        this.v = object2;
        object2 = new ArrayList();
        this.w = object2;
        this.x = object2 = new MutableLiveData();
        object2 = new ArrayList();
        this.y = object2;
        object2 = new ArrayList();
        this.A = object2;
        object2 = new ArrayList();
        this.C = object2;
        object2 = FeedbackSet$Rate.values();
        this.z = object2;
        int n11 = ((FeedbackSet$Rate[])object2).length;
        int n12 = 0;
        Object object3 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            object = object2[n10];
            List list = this.A;
            int n13 = ((FeedbackSet$Rate)((Object)object)).getStringRes();
            object = n13;
            list.add(object);
        }
        object2 = FeedbackSet$AdviceType.values();
        this.B = object2;
        n11 = ((Enum[])object2).length;
        while (n12 < n11) {
            object3 = object2[n12];
            object = this.C;
            n10 = ((FeedbackSet$AdviceType)((Object)object3)).getStringRes();
            object3 = n10;
            object.add(object3);
            ++n12;
        }
        object2 = d.v.c.v0.f.a();
        this.a = object2;
        object2 = this.b;
        Object object4 = new b0(this);
        object2 = Transformations.map((LiveData)object2, (Function)object4);
        this.e = object2;
        object4 = j0.a;
        this.c = object4 = Transformations.switchMap((LiveData)object2, (Function)object4);
        object4 = h0.a;
        object2 = Transformations.switchMap((LiveData)object2, (Function)object4);
        this.d = object2;
        object2 = this.b;
        object4 = Boolean.TRUE;
        ((MutableLiveData)object2).setValue(object4);
        object2 = this.o;
        object4 = Boolean.FALSE;
        ((MutableLiveData)object2).setValue(object4);
    }

    public static /* synthetic */ String A(List object) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string2 = (String)object.next();
            stringBuilder.append(string2);
            string2 = ",";
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    private void R(List object, e.a.v0.g g10, e.a.v0.g g11) {
        object = e.a.z.W2((Iterable)object);
        Object object2 = e.a.c1.b.d();
        object = ((z)object).L5((e.a.h0)object2);
        object2 = c0.a;
        object = ((z)object).H3((o)object2).X6();
        object2 = i0.a;
        object = ((e.a.i0)object).z0((o)object2);
        object2 = e.a.q0.c.a.c();
        ((e.a.i0)object).O0((e.a.h0)object2).c(g10, g11);
    }

    public static /* synthetic */ ProductEntity b(o0 o02, String string2) {
        return o02.i(string2);
    }

    public static /* synthetic */ ProductVersionEntity c(o0 o02, String string2) {
        return o02.j(string2);
    }

    private ProductEntity i(String string2) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            return null;
        }
        Iterator iterator2 = this.v.getValue();
        if (iterator2 != null && (n10 = (iterator2 = (List)this.v.getValue()).size()) > 0) {
            boolean bl2;
            iterator2 = ((List)this.v.getValue()).iterator();
            while (bl2 = iterator2.hasNext()) {
                ProductEntity productEntity = (ProductEntity)iterator2.next();
                String string3 = productEntity.title;
                boolean bl3 = string2.equals(string3);
                if (!bl3) continue;
                return productEntity;
            }
        }
        iterator2 = new Iterator();
        ((ProductEntity)iterator2).id = -1;
        ((ProductEntity)iterator2).title = string2;
        return iterator2;
    }

    private ProductVersionEntity j(String string2) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            return null;
        }
        Iterator iterator2 = this.x.getValue();
        if (iterator2 != null && (n10 = (iterator2 = (List)this.x.getValue()).size()) > 0) {
            boolean bl2;
            iterator2 = ((List)this.x.getValue()).iterator();
            while (bl2 = iterator2.hasNext()) {
                ProductVersionEntity productVersionEntity = (ProductVersionEntity)iterator2.next();
                String string3 = productVersionEntity.version;
                boolean bl3 = string2.equals(string3);
                if (!bl3) continue;
                return productVersionEntity;
            }
        }
        iterator2 = new Iterator();
        ((ProductVersionEntity)iterator2).id = -1;
        ((ProductVersionEntity)iterator2).version = string2;
        return iterator2;
    }

    private /* synthetic */ void o(String string2, d.v.a.f.b.a a10, String string3) {
        x x10 = this.a;
        CharSequence charSequence = new StringBuilder();
        int n10 = d.v.e.h.d.c((Integer)this.f.getValue());
        charSequence.append(n10);
        String string4 = "";
        charSequence.append(string4);
        charSequence = charSequence.toString();
        n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n10 != 0) {
            string2 = " ";
        }
        x10.b((String)charSequence, string2, string3, a10);
    }

    public static /* synthetic */ void r(d.v.a.f.b.a a10, Throwable throwable) {
        a10.onError(throwable, -1, "");
    }

    private /* synthetic */ void s(Feedback feedback, String string2, String string3, String string4, Context context, d.v.a.f.b.a a10, String string5) {
        String string6;
        Object object;
        o0 o02 = this;
        x x10 = this.a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string4);
        if (bl2) {
            object = " ";
            string6 = object;
        } else {
            string6 = string4;
        }
        object = o02.r.getValue();
        String string7 = "";
        Object object2 = object == null ? string7 : (object = ((ProductEntity)o02.r.getValue()).title);
        object = o02.p.getValue();
        Object object3 = object == null ? string7 : (object = ((FeedbackSet$Type)((Object)o02.p.getValue())).getApiName());
        object = o02.s.getValue();
        Object object4 = object == null ? string7 : (object = ((ProductVersionEntity)o02.s.getValue()).version);
        object = o02.t.getValue();
        Object object5 = object == null ? string7 : (object = ((FeedbackSet$Rate)((Object)o02.t.getValue())).getApiName());
        object = o02.u.getValue();
        Object object6 = object == null ? string7 : (object = ((FeedbackSet$AdviceType)((Object)o02.u.getValue())).getApiName());
        string7 = context;
        String string8 = d.v.f.i.g.m(context, 2131953241);
        object = feedback;
        string7 = string2;
        x10.k(feedback, string2, string3, string6, (String)object2, (String)object3, string5, (String)object4, (String)object5, (String)object6, string8, a10);
    }

    public static /* synthetic */ void u(d.v.a.f.b.a a10, Throwable throwable) {
        a10.onError(throwable, -1, "");
    }

    private /* synthetic */ g v(Boolean bl2) {
        return this.a.loadFeedbackList();
    }

    public static /* synthetic */ LiveData x(g g10) {
        return g10.a;
    }

    public static /* synthetic */ LiveData y(g g10) {
        return g10.b;
    }

    public static /* synthetic */ String z(String string2) {
        Object object = Uri.parse((String)string2);
        object = d.v.e.f.a().c().getContentResolver().getType(object);
        Object object2 = MimeTypeMap.getSingleton();
        object = object2.getExtensionFromMimeType((String)object);
        boolean bl2 = s1.R(string2);
        if (bl2) {
            object2 = new StringBuilder();
            long l10 = System.currentTimeMillis();
            ((StringBuilder)object2).append(l10);
            ((StringBuilder)object2).append("");
            Object object3 = new Random();
            int n10 = ((Random)object3).nextInt();
            ((StringBuilder)object2).append(n10);
            object3 = ".";
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            string2 = s1.H(string2);
            object2 = AliyunManager.instance();
            string2 = ((AliyunManager)object2).uploadFeedbackFileSync((String)object, string2);
        }
        return string2;
    }

    public void F(int n10) {
        this.h.setValue(null);
        this.i.setValue(null);
        Object object = this.g;
        PagingRequestHelper$Status pagingRequestHelper$Status = PagingRequestHelper$Status.RUNNING;
        Object object2 = new PagingRequestHelper$b(pagingRequestHelper$Status);
        ((MutableLiveData)object).setValue(object2);
        object = this.a;
        object2 = new o0$d(this);
        object.g(n10, (d.v.a.f.b.a)object2);
    }

    public void G(Context context, boolean bl2) {
        Object object;
        if (!bl2 && (object = this.v.getValue()) != null) {
            return;
        }
        this.v.setValue(null);
        this.w.clear();
        object = this.a;
        o0$b o0$b = new o0$b(this, context, bl2);
        object.n(o0$b);
    }

    public void H(Context object, boolean bl2) {
        Object object2;
        if (!bl2 && (object2 = this.x.getValue()) != null) {
            return;
        }
        object2 = this.r.getValue();
        if (object2 == null) {
            if (!bl2) {
                j j10 = this.l;
                int n10 = 2131952269;
                object = d.v.f.i.g.m(object, n10);
                j10.setValue(object);
            }
            return;
        }
        int n11 = -1;
        Object object3 = (ProductEntity)this.r.getValue();
        int n12 = ((ProductEntity)object3).id;
        if (n11 == n12) {
            this.G((Context)object, bl2);
            return;
        }
        this.x.setValue(null);
        this.y.clear();
        object2 = this.a;
        object3 = ((ProductEntity)this.r.getValue()).code;
        o0$c o0$c = new o0$c(this, bl2, (Context)object);
        object2.D((String)object3, o0$c);
    }

    public void I() {
        Object object = this.e.getValue();
        if (object != null) {
            object = ((g)this.e.getValue()).d;
            object.load();
        }
    }

    public void J() {
        this.q.setValue(null);
        this.r.setValue(null);
        this.s.setValue(null);
        MutableLiveData mutableLiveData = this.t;
        Enum enum_ = FeedbackSet$Rate.ONCE;
        mutableLiveData.setValue(enum_);
        mutableLiveData = this.u;
        enum_ = FeedbackSet$AdviceType.OTHER;
        mutableLiveData.setValue(enum_);
        this.x.setValue(null);
        this.y.clear();
    }

    public void K() {
        MutableLiveData mutableLiveData = this.f;
        Object object = mutableLiveData.getValue();
        mutableLiveData.setValue(object);
    }

    public void L() {
        Object object = this.e.getValue();
        if (object != null) {
            object = ((g)this.e.getValue()).c;
            object.load();
        }
    }

    public void M(int n10) {
        FeedbackSet$AdviceType[] feedbackSet$AdviceTypeArray;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (feedbackSet$AdviceTypeArray = this.B).length)) {
            MutableLiveData mutableLiveData = this.u;
            FeedbackSet$AdviceType feedbackSet$AdviceType = feedbackSet$AdviceTypeArray[n10];
            mutableLiveData.setValue((Object)feedbackSet$AdviceType);
        }
    }

    public void N(Context context, int n10) {
        Object object;
        int n11;
        Object object2;
        if (n10 >= 0 && (object2 = this.v.getValue()) != null && (n11 = (object2 = (List)this.v.getValue()).size()) > 0 && n10 < (n11 = (object2 = (List)this.v.getValue()).size()) && (object = (ProductEntity)(object2 = (List)this.v.getValue()).get(n10)) != null && (n11 = (int)(((ProductEntity)object).equals(object2 = this.r.getValue()) ? 1 : 0)) == 0) {
            this.r.setValue(object);
            object = this.s;
            n11 = 0;
            object2 = null;
            ((MutableLiveData)object).setValue(null);
            n10 = 1;
            this.H(context, n10 != 0);
        }
    }

    public void P(int n10) {
        int n11;
        Object object;
        if (n10 >= 0 && (object = this.x.getValue()) != null && (n11 = (object = (List)this.x.getValue()).size()) > 0 && n10 < (n11 = (object = (List)this.x.getValue()).size())) {
            object = this.s;
            List list = (List)this.x.getValue();
            Object e10 = list.get(n10);
            ((MutableLiveData)object).setValue(e10);
        }
    }

    public void Q(int n10) {
        FeedbackSet$Rate[] feedbackSet$RateArray;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (feedbackSet$RateArray = this.z).length)) {
            MutableLiveData mutableLiveData = this.t;
            FeedbackSet$Rate feedbackSet$Rate = feedbackSet$RateArray[n10];
            mutableLiveData.setValue((Object)feedbackSet$Rate);
        }
    }

    public void d(Context object, Feedback object2) {
        Object object3 = this.j;
        Comparable<Boolean> comparable = Boolean.TRUE;
        ((j)object3).setValue(comparable);
        object3 = new o0$g(this, (Context)object);
        object = this.a;
        comparable = new Comparable<Boolean>();
        int n10 = ((Feedback)object2).getId();
        ((StringBuilder)comparable).append(n10);
        ((StringBuilder)comparable).append("");
        object2 = ((StringBuilder)comparable).toString();
        object.q((String)object2, (d.v.a.f.b.a)object3);
    }

    public void e(Context object, Feedback object2) {
        Object object3 = this.j;
        Comparable<Boolean> comparable = Boolean.TRUE;
        ((j)object3).setValue(comparable);
        object3 = new o0$f(this, (Context)object);
        object = this.a;
        comparable = new Comparable<Boolean>();
        int n10 = ((Feedback)object2).getId();
        ((StringBuilder)comparable).append(n10);
        ((StringBuilder)comparable).append("");
        object2 = ((StringBuilder)comparable).toString();
        object.z((String)object2, (d.v.a.f.b.a)object3);
    }

    public void f(Context object, String object2, List list) {
        Object object3 = this.j;
        Boolean bl2 = Boolean.TRUE;
        ((j)object3).setValue(bl2);
        object3 = new o0$h(this, (Context)object);
        object = new g0(this, (String)object2, (d.v.a.f.b.a)object3);
        object2 = new e0((d.v.a.f.b.a)object3);
        this.R(list, (e.a.v0.g)object, (e.a.v0.g)object2);
    }

    public void g(Context context, Feedback feedback, String string2, String string3, String string4, String string5, String string6, List list) {
        d0 d02;
        String string7;
        String string8;
        Object object = this.j;
        Object object2 = Boolean.TRUE;
        ((j)object).setValue(object2);
        object = (FeedbackSet$Type)((Object)this.p.getValue());
        if (object == null) {
            return;
        }
        object2 = o0$i.a;
        Object object3 = ((Enum)object).ordinal();
        Object object4 = 1;
        if ((object3 = (Object)object2[object3]) != object4 && object3 != (object4 = 2)) {
            string8 = string2;
            string7 = string3;
        } else {
            string8 = string4;
            string7 = string5;
        }
        o0$e o0$e = new o0$e(this, context, feedback);
        object = d02;
        object2 = this;
        d02 = new d0(this, feedback, string6, string8, string7, context, o0$e);
        object = new f0(o0$e);
        object2 = list;
        this.R(list, d02, (e.a.v0.g)object);
    }

    public LiveData k() {
        return this.c;
    }

    public LiveData l() {
        return this.d;
    }

    public void m(Feedback object) {
        this.q.setValue(object);
        MutableLiveData mutableLiveData = this.r;
        Object object2 = object.getDeviceModel();
        object2 = this.i((String)object2);
        mutableLiveData.setValue(object2);
        mutableLiveData = this.s;
        object2 = object.getFirmwareVersion();
        object2 = this.j((String)object2);
        mutableLiveData.setValue(object2);
        mutableLiveData = this.t;
        object2 = new StringBuilder();
        int n10 = object.getFrequency();
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append("");
        object2 = FeedbackSet$Rate.from(((StringBuilder)object2).toString());
        mutableLiveData.setValue(object2);
        mutableLiveData = this.u;
        object = FeedbackSet$AdviceType.from(object.getAdvice_target());
        mutableLiveData.setValue(object);
    }

    public void n() {
        x x10 = this.a;
        o0$a o0$a = new o0$a(this);
        x10.o(o0$a);
    }

    public /* synthetic */ void p(String string2, d.v.a.f.b.a a10, String string3) {
        this.o(string2, a10, string3);
    }

    public /* synthetic */ void t(Feedback feedback, String string2, String string3, String string4, Context context, d.v.a.f.b.a a10, String string5) {
        this.s(feedback, string2, string3, string4, context, a10, string5);
    }

    public /* synthetic */ g w(Boolean bl2) {
        return this.v(bl2);
    }
}

