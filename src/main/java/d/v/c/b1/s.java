/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.b1;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.editorsdk.draft.DraftUseCase;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import d.v.c.b1.a;
import d.v.c.b1.b;
import d.v.c.b1.c;
import d.v.c.b1.d;
import d.v.c.b1.e;
import d.v.c.b1.p;
import d.v.c.b1.r;
import d.v.e.i.h;
import d.v.e.l.c1;
import d.v.e.l.s1;
import d.v.j.e.i.a1;
import e.a.i0;
import e.a.p0;
import e.a.v0.g;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class s
extends ViewModel {
    private final DraftUseCase a;
    private MutableLiveData b;
    private LiveData c;
    private a1 d;

    public s() {
        Object object = new MutableLiveData();
        this.b = object;
        this.a = object = new DraftUseCase();
        this.d = object = d.v.j.e.c.a();
    }

    private /* synthetic */ void j(long l10) {
        TemplatePOJO templatePOJO = this.d.d().B(l10);
        Object object = this.a.b(l10);
        Object object2 = d.v.c.b1.d.a;
        p p10 = p.a;
        ((i0)object).c((g)object2, p10);
        if (templatePOJO != null) {
            boolean bl2;
            object = templatePOJO.getTemplateVideoList().iterator();
            while (bl2 = object.hasNext()) {
                object2 = ((TemplateVideo)object.next()).getReversePath();
                boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
                if (bl3) continue;
                s1.h((String)object2);
            }
        }
    }

    public static /* synthetic */ r l(TemplatePOJO templatePOJO) {
        long l10 = templatePOJO.getDraft().getDraftId();
        String string2 = templatePOJO.getTemplateData().getCoverUrl();
        String string3 = templatePOJO.getDraft().getContentDesc();
        double d10 = templatePOJO.getTemplateData().getVideoTime();
        int n10 = templatePOJO.getTemplateData().getVideoCount();
        r r10 = new r(l10, string2, string3, d10, n10);
        return r10;
    }

    public static /* synthetic */ boolean m(String string2, TemplatePOJO object) {
        boolean bl2;
        object = ((TemplatePOJO)object).getDraft().getContentDesc();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3 && (bl2 = string2.equals(object))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public static /* synthetic */ void n(Boolean bl2) {
    }

    public static /* synthetic */ void o(d.v.e.g.e e10, Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            e10.a();
        }
    }

    public void b(long l10) {
        Executor executor = c1.b().d();
        e e10 = new e(this, l10);
        executor.execute(e10);
    }

    public List c() {
        Object object = this.c;
        object = object != null && (object = ((LiveData)object).getValue()) != null ? (List)this.c.getValue() : Collections.emptyList();
        return object;
    }

    public LiveData d() {
        LiveData liveData;
        this.c = liveData = this.a.d();
        return liveData;
    }

    public List e(List stream) {
        if (stream == null) {
            return Collections.emptyList();
        }
        stream = stream.stream();
        Object object = d.v.c.b1.b.a;
        stream = stream.map(object);
        object = Collectors.toList();
        return (List)stream.collect(object);
    }

    public MutableLiveData f() {
        return this.b;
    }

    public boolean g(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return false;
        }
        Stream stream = this.c().stream();
        c c10 = new c(string2);
        return stream.anyMatch(c10);
    }

    public boolean i(int n10, r object) {
        object = this.b;
        Integer n11 = n10;
        h.e((MutableLiveData)object, n11);
        return true;
    }

    public /* synthetic */ void k(long l10) {
        this.j(l10);
    }

    public void p(long l10, String object, d.v.e.g.e e10) {
        i0 i02 = this.a.I(l10, (String)object);
        Object object2 = d.v.e.k.e.f();
        i02 = i02.s((p0)object2);
        object2 = new a(e10);
        object = p.a;
        i02.c((g)object2, (g)object);
    }
}

