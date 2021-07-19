/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.util.SparseArray
 */
package com.zhiyun.cama.camera.story.review;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.ResConfig$AppResType;
import com.zhiyun.cama.camera.story.review.StoryReviewViewModel$ReviewStatus;
import com.zhiyun.cama.camera.story.review.StoryReviewViewModel$a;
import com.zhiyun.editorinterface.compose.ComposeParams;
import com.zhiyun.editorinterface.compose.ComposeParams$Resolution;
import com.zhiyun.editorsdk.ComposeUseCase;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.protocol.constants.Model;
import d.v.c.m0;
import d.v.c.s0.h7.k0;
import d.v.c.s0.h7.s0.t;
import d.v.c.s0.h7.s0.u;
import d.v.c.s0.h7.s0.v;
import d.v.c.s0.h7.s0.w;
import d.v.c.s0.h7.s0.x;
import d.v.c.v0.n.d;
import d.v.e.j.a;
import d.v.e.k.e;
import d.v.e.l.k2;
import d.v.e.l.s1;
import d.v.e.l.w1;
import d.v.e0.ce;
import d.v.h.c.b$a;
import d.v.j.b;
import e.a.f0;
import e.a.v0.g;
import e.a.z;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StoryReviewViewModel
extends AndroidViewModel {
    private MutableLiveData a;
    private MutableLiveData b;
    private MutableLiveData c;
    private MutableLiveData d;
    private MutableLiveData e;
    private MutableLiveData f;
    private ComposeUseCase g;
    private boolean h;
    private String i;
    private e.a.s0.b j;
    private final d k;

    public StoryReviewViewModel(Application object) {
        super((Application)object);
        super();
        this.a = object;
        super();
        this.b = object;
        super();
        this.c = object;
        super();
        this.d = object;
        super();
        this.e = object;
        super();
        this.f = object;
        object = d.v.c.v0.n.d.s();
        this.k = object;
    }

    private /* synthetic */ void F(List list, d.v.h.e.d object) {
        boolean bl2;
        e.a.s0.b b10 = this.j;
        if (b10 != null && (bl2 = b10.isDisposed())) {
            return;
        }
        b10 = this.getApplication();
        object = ((d.v.h.e.a)object).e();
        File file = new File((String)object);
        if ((object = k0.e((Context)b10, file)) != null) {
            list.add(object);
        }
    }

    private void I(List list, List list2) {
        boolean bl2 = this.u();
        if (bl2 && !(bl2 = d.v.j.b.f(list2))) {
            list.clear();
            t t10 = new t(this, list);
            list2.forEach(t10);
        }
    }

    public static /* synthetic */ boolean b(StoryReviewViewModel storyReviewViewModel, boolean bl2) {
        storyReviewViewModel.h = bl2;
        return bl2;
    }

    public static /* synthetic */ MutableLiveData c(StoryReviewViewModel storyReviewViewModel) {
        return storyReviewViewModel.f;
    }

    public static /* synthetic */ MutableLiveData d(StoryReviewViewModel storyReviewViewModel) {
        return storyReviewViewModel.e;
    }

    private /* synthetic */ void w(List list, List list2, Integer n10) {
        this.I(list, list2);
    }

    public static /* synthetic */ void y(List list) {
        boolean bl2 = d.v.j.b.f(list);
        if (bl2) {
            return;
        }
        x x10 = x.a;
        list.forEach(x10);
    }

    private /* synthetic */ void z(String object, Integer object2) {
        this.g = object2 = new ComposeUseCase();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("story_");
        long l10 = System.currentTimeMillis();
        ((StringBuilder)object2).append(l10);
        ((StringBuilder)object2).append("_");
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(".mp4");
        object = k2.A(((StringBuilder)object2).toString()).toString();
        this.i = object;
        this.g.b((String)object);
        object = this.g;
        object2 = new StoryReviewViewModel$a(this);
        ((ComposeUseCase)object).d((b$a)object2);
        object = this.g;
        object2 = new ComposeParams();
        ComposeParams$Resolution composeParams$Resolution = ComposeParams$Resolution.RESOLUTION_1080P;
        object2 = ((ComposeParams)object2).i(composeParams$Resolution);
        ((ComposeUseCase)object).e((ComposeParams)object2);
        this.g.f();
        this.h = true;
    }

    public /* synthetic */ void A(String string2, Integer n10) {
        this.z(string2, n10);
    }

    public /* synthetic */ void G(List list, d.v.h.e.d d10) {
        this.F(list, d10);
    }

    public void H(String object, List object2) {
        Object object3 = this.f;
        int n10 = 1;
        Object object4 = n10;
        ((MutableLiveData)object3).setValue(object4);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            object = ((String)object).trim();
            object3 = " ";
            object4 = "_";
            object = ((String)object).replace((CharSequence)object3, (CharSequence)object4);
        }
        object3 = new ArrayList();
        object4 = this.j;
        if (object4 != null) {
            object4.dispose();
        }
        object4 = z.t3(0);
        w w10 = new w(this, (List)object3, (List)object2);
        object2 = ((z)object4).f2(w10);
        object4 = new u((List)object3);
        object2 = ((z)object2).Z1((e.a.v0.a)object4);
        object3 = d.v.e.k.e.g();
        object2 = ((z)object2).z0((f0)object3);
        object3 = new v(this, (String)object);
        this.j = object = ((z)object2).f2((g)object3).a();
    }

    public void J(boolean bl2) {
        MutableLiveData mutableLiveData = this.b;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
    }

    public void K(boolean bl2) {
        Object object;
        MutableLiveData mutableLiveData = this.a;
        object = bl2 ? StoryReviewViewModel$ReviewStatus.SINGLE_REVIEW : ((bl2 = ((d)(object = this.k)).D()) ? StoryReviewViewModel$ReviewStatus.TOTAL_REVIEW : StoryReviewViewModel$ReviewStatus.SETTING_REVIEW);
        mutableLiveData.setValue(object);
    }

    public void L(int n10) {
        MutableLiveData mutableLiveData = this.d;
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
    }

    public void M(StoryReviewViewModel$ReviewStatus storyReviewViewModel$ReviewStatus) {
        this.a.setValue((Object)storyReviewViewModel$ReviewStatus);
    }

    public boolean N() {
        boolean bl2 = this.k.D() ^ true;
        this.k.v0(bl2);
        return bl2;
    }

    public boolean P() {
        boolean bl2 = this.k.I() ^ true;
        this.k.A0(bl2);
        return bl2;
    }

    public void Q(int n10) {
        MutableLiveData mutableLiveData = this.c;
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
    }

    public void e() {
        boolean bl2;
        Object object = this.g;
        if (object != null && (bl2 = this.h)) {
            ((ComposeUseCase)object).a();
            object = this.i;
            boolean bl3 = TextUtils.isEmpty((CharSequence)object);
            if (!bl3) {
                object = Uri.parse((String)this.i);
                s1.i((Uri)object);
            }
        }
        if ((object = this.j) != null) {
            object.dispose();
        }
    }

    public MutableLiveData f() {
        return this.b;
    }

    public boolean g() {
        boolean bl2;
        Object object = this.b.getValue();
        if (object != null && (bl2 = ((Boolean)(object = (Boolean)this.b.getValue())).booleanValue())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public MutableLiveData i() {
        return this.e;
    }

    public MutableLiveData j() {
        return this.f;
    }

    public String k() {
        Object object = m0.d();
        boolean bl2 = ce.z1();
        if (bl2) {
            Object object2;
            object = ce.E0().y0().b;
            int n10 = ((Model)((Object)object)).getCode();
            String string2 = w1.a();
            boolean bl3 = string2.equals(object2 = "zh_CN".toLowerCase());
            string2 = bl3 ? "zh_hans" : ((bl2 = string2.equals(object2 = "zh_TW".toLowerCase())) ? "zh_hant" : "en");
            object2 = ResConfig$AppResType.WATERMARK;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "ic_xj_sy_";
            stringBuilder.append(string3);
            stringBuilder.append(n10);
            stringBuilder.append("_");
            stringBuilder.append(string2);
            stringBuilder.append(".png");
            object = stringBuilder.toString();
            object = TemEditorConfig.c((a)object2, (String)object);
        }
        return object;
    }

    public int l(SparseArray sparseArray, List list) {
        int n10 = sparseArray.size();
        int n11 = list.size();
        int n12 = -1;
        if (n10 == n11) {
            return n12;
        }
        for (n10 = 0; n10 < (n11 = list.size()); ++n10) {
            Object object = sparseArray.get(n10);
            if (object != null) continue;
            n12 = n10;
            break;
        }
        return n12;
    }

    public MutableLiveData m() {
        return this.c;
    }

    public MutableLiveData n() {
        return this.a;
    }

    public StoryReviewViewModel$ReviewStatus o() {
        Object object = this.a.getValue();
        object = object == null ? StoryReviewViewModel$ReviewStatus.SINGLE_REVIEW : (StoryReviewViewModel$ReviewStatus)((Object)this.a.getValue());
        return object;
    }

    public void onCleared() {
        super.onCleared();
        ComposeUseCase composeUseCase = this.g;
        if (composeUseCase != null) {
            composeUseCase.c();
        }
    }

    public MutableLiveData p() {
        return this.d;
    }

    public int r() {
        int n10;
        Object object = this.d.getValue();
        if (object == null) {
            n10 = -1;
        } else {
            object = (Integer)this.d.getValue();
            n10 = (Integer)object;
        }
        return n10;
    }

    public String[] s(SparseArray sparseArray) {
        int n10;
        String[] stringArray = new String[]{};
        if (sparseArray != null && (n10 = sparseArray.size()) != 0) {
            int n11 = sparseArray.size();
            stringArray = new String[n11];
            for (int i10 = 0; i10 < (n10 = sparseArray.size()); ++i10) {
                String string2 = ((d.v.h.e.a)sparseArray.valueAt(i10)).e();
                boolean bl2 = s1.q(string2);
                if (!bl2) continue;
                stringArray[i10] = string2;
            }
        }
        return stringArray;
    }

    public boolean t() {
        return this.k.D();
    }

    public boolean u() {
        return this.k.I();
    }

    public boolean v() {
        boolean bl2;
        StoryReviewViewModel$ReviewStatus storyReviewViewModel$ReviewStatus;
        StoryReviewViewModel$ReviewStatus storyReviewViewModel$ReviewStatus2 = this.o();
        if (storyReviewViewModel$ReviewStatus2 == (storyReviewViewModel$ReviewStatus = StoryReviewViewModel$ReviewStatus.SINGLE_REVIEW)) {
            bl2 = true;
        } else {
            bl2 = false;
            storyReviewViewModel$ReviewStatus2 = null;
        }
        return bl2;
    }

    public /* synthetic */ void x(List list, List list2, Integer n10) {
        this.w(list, list2, n10);
    }
}

