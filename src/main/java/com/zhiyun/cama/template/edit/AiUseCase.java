/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.zhiyun.cama.template.edit;

import android.util.SparseArray;
import androidx.core.util.Pair;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.template.edit.AiUseCase$a;
import com.zhiyun.cama.template.edit.AiUseCase$b;
import com.zhiyun.cama.template.edit.AiUseCase$c;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import d.q.a.d;
import d.q.a.d0;
import d.q.a.f0.f.b;
import d.v.c.u1.m.f;
import d.v.c.u1.m.g;
import d.v.c.u1.m.h;
import d.v.c.u1.m.i;
import d.v.c.u1.m.j;
import d.v.c.u1.m.k;
import d.v.c.u1.m.l;
import d.v.c.u1.m.m;
import d.v.c.u1.m.n;
import d.v.c.u1.m.o;
import d.v.c.u1.m.p;
import d.v.c.u1.m.y0;
import d.v.c.u1.m.z0;
import d.v.e.k.e;
import d.v.j.e.c;
import d.v.j.e.i.a1;
import d.v.j.e.i.c1;
import d.v.j.e.i.d1;
import d.v.j.g.b0;
import e.a.i0;
import e.a.j0;
import e.a.k0;
import e.a.l0;
import e.a.m0;
import e.a.p0;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import m.a.a;

public class AiUseCase
implements LifecycleObserver {
    private static final int f = 255;
    private static final int g = 0;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 3;
    private a1 a;
    private final LifecycleOwner b;
    private List c;
    private int d;
    private final Object e;

    public AiUseCase(LifecycleOwner lifecycleOwner, boolean bl2) {
        int n10;
        Object object = new ArrayList();
        this.c = object;
        this.d = n10 = -1;
        this.e = object = new Object();
        this.b = lifecycleOwner;
        if (bl2) {
            c1 c12 = d.v.j.e.c.a();
            this.a = c12;
            this.I(lifecycleOwner);
        }
    }

    public static /* synthetic */ boolean A(List object, List list, int n10) {
        long l10;
        long l11 = ((d.v.h.e.a)object.get(n10)).d();
        long l12 = l11 - (l10 = b0.h((TemplateVideo)(object = (TemplateVideo)list.get(n10))));
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 >= 0) {
            object2 = 1;
        } else {
            object2 = 0;
            object = null;
        }
        return (boolean)object2;
    }

    private /* synthetic */ int F(List object, List object2, List list, SparseArray sparseArray, boolean bl2, int n10) {
        Object e10;
        Object object3 = e10 = object.get(n10);
        object3 = (AiUseCase$c)e10;
        object2 = (TemplateVideo)object2.get(n10);
        long l10 = b0.h((TemplateVideo)object2);
        int n11 = ((AiUseCase$c)object3).c;
        int n12 = 1;
        if (n11 == 0) {
            long l11;
            int n13;
            ((AiUseCase$c)object3).a = n13 = ((AiUseCase$c)object3).b;
            ((AiUseCase$c)object3).c = n12;
            ((AiUseCase$c)object3).d = l11 = ((AiUseCase$c)object3).d - l10;
        } else {
            n11 = object.size();
            if ((n10 += n12) >= n11) {
                boolean bl3 = false;
                object = null;
            } else {
                object = (AiUseCase$c)object.get(n10);
            }
            object3 = this.M(list, (AiUseCase$c)object3, (AiUseCase$c)object, l10, sparseArray, bl2);
        }
        return ((AiUseCase$c)object3).a;
    }

    public static /* synthetic */ d.v.h.e.a H(List list, int n10) {
        return ((d.v.h.e.a)list.get(n10)).c();
    }

    private void I(LifecycleOwner lifecycleOwner) {
        Object object = this.a.d();
        int[] nArray = new int[]{-1, 0};
        int n10 = 1;
        int[] nArray2 = new int[n10];
        nArray2[0] = 0;
        Object object2 = new int[n10];
        object2[0] = 0;
        Boolean bl2 = Boolean.TRUE;
        object2 = ((d1)object).c0(nArray, nArray2, (int[])object2, bl2, null);
        object = new g(this);
        ((LiveData)object2).observe(lifecycleOwner, (Observer)object);
    }

    private TemplatePOJO J(List list, List list2) {
        List list3 = this.N(list, list2);
        int n10 = this.d;
        if (n10 == 0) {
            return this.S(list, list3);
        }
        list2 = this.P(list, list2);
        return this.T(list, (SparseArray)list2);
    }

    private AiUseCase$c M(List list, AiUseCase$c aiUseCase$c, AiUseCase$c aiUseCase$c2, long l10, SparseArray sparseArray, boolean bl2) {
        AiUseCase$c aiUseCase$c3;
        Object object;
        long l11;
        long l12;
        long l13;
        Object object2 = aiUseCase$c;
        AiUseCase$c aiUseCase$c4 = aiUseCase$c2;
        SparseArray sparseArray2 = sparseArray;
        int n10 = 0;
        Object object3 = null;
        int n11 = 1;
        long l14 = aiUseCase$c.d;
        if (bl2 ? (l13 = (l12 = l14 - (l11 = 500000L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) >= 0 : (l13 = l14 == l10 ? 0 : (l14 < l10 ? -1 : 1)) >= 0) {
            l13 = n11;
        } else {
            l13 = 0;
            object = null;
        }
        if (l13 != false) {
            long l15;
            ((AiUseCase$c)object2).a = n10 = ((AiUseCase$c)object2).b;
            ((AiUseCase$c)object2).d = l15 = ((AiUseCase$c)object2).d - l10;
            aiUseCase$c3 = object2;
        } else {
            aiUseCase$c3 = aiUseCase$c.a();
            int n12 = aiUseCase$c3.b + n11;
            l13 = list.size();
            if (n12 < l13) {
                n10 = n11;
            }
            if (n10 != 0) {
                object = object3 = sparseArray2.get(n12);
                object = (AiUseCase$c)object3;
                if (object == null) {
                    aiUseCase$c3.a = n12;
                    boolean bl3 = true;
                    object = (d.v.h.e.a)list.get(n12);
                    l14 = ((d.v.h.e.a)object).d();
                    long l16 = l14 - l10;
                    object3 = new AiUseCase$c(this, n12, n12, bl3, l16);
                    sparseArray2.put(n12, object3);
                    if (aiUseCase$c4 != null && n12 == (n10 = aiUseCase$c4.b)) {
                        long l17;
                        aiUseCase$c4.c = n11;
                        aiUseCase$c4.d = l17 = aiUseCase$c4.d - l10;
                    }
                } else {
                    object2 = this;
                    object3 = list;
                    aiUseCase$c4 = aiUseCase$c2;
                    l14 = l10;
                    sparseArray2 = sparseArray;
                    this.M(list, (AiUseCase$c)object, aiUseCase$c2, l10, sparseArray, bl2);
                }
            } else {
                long l18;
                aiUseCase$c3.a = n12 = aiUseCase$c3.b;
                aiUseCase$c3.d = l18 = aiUseCase$c3.d - l10;
            }
        }
        return aiUseCase$c3;
    }

    private List N(List list, List list2) {
        p p10 = p.a;
        boolean bl2 = d.v.j.b.f(list = this.g(list, list2, p10));
        if (bl2) {
            return null;
        }
        this.d = 0;
        return list;
    }

    private SparseArray P(List list, List list2) {
        int n10;
        SparseArray sparseArray = new SparseArray();
        Object object = d.v.c.u1.m.b.a;
        int n11 = (int)(d.v.j.b.f((List)(object = this.g(list, list2, (d.v.e.g.a)object))) ? 1 : 0);
        if (n11 == 0) {
            n11 = 1;
            this.d = n11;
            sparseArray.put(n11, object);
        }
        object = d.v.c.u1.m.d.a;
        list = this.g(list, list2, (d.v.e.g.a)object);
        boolean bl2 = d.v.j.b.f(list);
        int n12 = 2;
        if (!bl2) {
            this.d = n12;
            sparseArray.put(n12, (Object)list);
        }
        if ((n10 = sparseArray.size()) == n12) {
            this.d = n10 = 3;
        }
        return sparseArray;
    }

    private List Q(List object, TemplatePOJO collector, boolean bl2) {
        List list = ((TemplatePOJO)((Object)collector)).getTemplateVideoList();
        List list2 = this.c((List)object, (TemplatePOJO)((Object)collector));
        SparseArray sparseArray = new SparseArray();
        int n10 = list2.size();
        collector = IntStream.range(0, n10);
        n n11 = new n(this, list2, list, (List)object, sparseArray, bl2);
        collector = collector.map(n11);
        o o10 = new o((List)object);
        object = collector.mapToObj(o10);
        collector = Collectors.toList();
        return object.collect(collector);
    }

    private TemplatePOJO R(List list, List list2, List list3) {
        list2.addAll(list3);
        list2 = this.d(list, list2);
        return this.e(list, list2);
    }

    private TemplatePOJO S(List list, List list2) {
        int n10;
        int n11 = list2.size();
        if (n11 == (n10 = 1)) {
            return (TemplatePOJO)list2.get(0);
        }
        return this.e(list, list2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private TemplatePOJO T(List object, SparseArray object2) {
        int n10 = 2;
        List list = (List)object2.get(n10);
        int n11 = 1;
        object2 = (List)object2.get(n11);
        int n12 = this.d;
        if (n12 == n11) return this.U((List)object, (List)object2);
        if (n12 == n10) return this.V((List)object, list);
        n10 = 3;
        if (n12 == n10) {
            return this.R((List)object, list, (List)object2);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("\u4e0d\u5e94\u8be5\u4f1a\u8c03\u7528\u5230\u8fd9\u91cc,\u5f53\u524d\u6a21\u677f\u5339\u914d\u72b6\u6001\uff1a");
        n10 = this.d;
        ((StringBuilder)object2).append(n10);
        object2 = ((StringBuilder)object2).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    private TemplatePOJO U(List list, List list2) {
        list2 = this.d(list, list2);
        return this.e(list, list2);
    }

    private TemplatePOJO V(List list, List list2) {
        list2 = this.d(list, list2);
        return this.e(list, list2);
    }

    private List b(List stream, TemplatePOJO collector) {
        int n10 = stream.size();
        List list = ((TemplatePOJO)((Object)collector)).getTemplateVideoList();
        int n11 = list.size();
        int n12 = 0;
        int n13 = 1;
        if (n10 != n13 && n11 != n13) {
            if (n10 == n11) {
                return stream;
            }
            if (n10 < n11) {
                n12 = n13;
            }
            return this.Q((List)((Object)stream), (TemplatePOJO)((Object)collector), n12 != 0);
        }
        stream = (d.v.h.e.a)stream.get(0);
        collector = IntStream.range(0, n11);
        i i10 = new i((d.v.h.e.a)((Object)stream));
        stream = collector.mapToObj(i10);
        collector = Collectors.toList();
        return stream.collect(collector);
    }

    private List c(List list, TemplatePOJO object) {
        object = ((TemplatePOJO)object).getTemplateVideoList();
        ArrayList<Object> arrayList = list.stream();
        Object object2 = y0.a;
        long l10 = arrayList.mapToLong(object2).sum();
        long l11 = object.size();
        int n10 = object.size();
        Object object3 = 0;
        object = IntStream.range(0, n10);
        Object object4 = new f(list, l10 /= l11);
        object = object.map((IntUnaryOperator)object4).toArray();
        arrayList = new ArrayList<Object>();
        Object object5 = (d.v.h.e.a)list.get(0);
        long l12 = ((d.v.h.e.a)object5).d();
        int n11 = -1;
        boolean n12 = false;
        object4 = object2;
        object2 = new AiUseCase$c(this, n11, 0, false, l12);
        arrayList.add(object2);
        for (int i10 = 1; i10 < (object3 = ((Object)object).length); ++i10) {
            object3 = object[i10];
            Object object6 = i10 + -1;
            Object object7 = object[object6];
            if (object3 == object7) {
                object3 = object[object6];
                object5 = arrayList.get((int)object3);
                arrayList.add(object5);
                continue;
            }
            n11 = -1;
            Object object8 = object[i10];
            object6 = object[i10];
            l12 = ((d.v.h.e.a)list.get((int)object6)).d();
            object4 = object5;
            object5 = new AiUseCase$c(this, n11, (int)object8, false, l12);
            arrayList.add(object5);
        }
        return arrayList;
    }

    private List d(List object, List collector) {
        Object object2;
        int n10;
        int n11 = collector.size();
        if (n11 == (n10 = 1)) {
            return collector;
        }
        int n12 = object.size();
        Object object3 = collector.stream();
        h h10 = d.v.c.u1.m.h.a;
        object3 = object3.mapToInt(h10).distinct().toArray();
        h10 = null;
        Object object4 = object3[0];
        object4 = Math.abs(n12 - object4);
        while (n10 < (object2 = ((Object)object3).length)) {
            object2 = object3[n10];
            if ((object2 = Math.abs(n12 - object2)) < object4) {
                object4 = object2;
            }
            ++n10;
        }
        collector = collector.stream();
        object3 = new d.v.c.u1.m.a((int)object4, n12);
        object = collector.filter(object3);
        collector = Collectors.toList();
        return object.collect(collector);
    }

    private TemplatePOJO e(List list, List object) {
        int n10 = object.size();
        Object object2 = 0;
        int n11 = 1;
        if (n10 == n11) {
            return (TemplatePOJO)object.get(0);
        }
        Collector collector = list.stream();
        y0 y02 = y0.a;
        long l10 = collector.mapToLong(y02).sum();
        collector = object.stream();
        d.v.c.u1.m.e e10 = d.v.c.u1.m.e.a;
        collector = (Collector)collector.mapToLong(e10).distinct().toArray();
        Object object3 = collector[0];
        object3 = Math.abs(l10 - object3);
        while (n11 < (object2 = ((Object)collector).length)) {
            reference var13_11 = collector[n11];
            reference cfr_temp_0 = (var13_11 = (reference)Math.abs(l10 - var13_11)) - object3;
            object2 = cfr_temp_0 == 0 ? 0 : (cfr_temp_0 < 0 ? -1 : 1);
            if (object2 < 0) {
                object3 = var13_11;
            }
            ++n11;
        }
        object = object.stream();
        collector = new Collector((long)object3, l10);
        object = object.filter(collector);
        collector = Collectors.toList();
        object = object.collect(collector);
        return this.f(list, (List)object);
    }

    private TemplatePOJO f(List list, List list2) {
        int n10 = list2.size();
        int n11 = 0;
        int n12 = 1;
        if (n10 == n12) {
            return (TemplatePOJO)list2.get(0);
        }
        n10 = list.size();
        Stream stream = list2.stream();
        d.v.c.u1.m.c c10 = new d.v.c.u1.m.c(n10, list);
        list = stream.map(c10);
        Object object = Collectors.toList();
        list = list.collect(object);
        object = (Long)list.get(0);
        long l10 = (Long)object;
        while (n12 < (n10 = list.size())) {
            object = (Long)list.get(n12);
            long l11 = (Long)object;
            long l12 = l11 - l10;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 > 0) {
                n11 = n12;
                l10 = l11;
            }
            ++n12;
        }
        return (TemplatePOJO)list2.get(n11);
    }

    private List g(List object, List collector, d.v.e.g.a a10) {
        int n10 = object.size();
        collector = collector.stream();
        m m10 = new m(a10, n10);
        object = collector.filter(m10);
        collector = Collectors.toList();
        return object.collect(collector);
    }

    public static /* synthetic */ d.v.h.e.a i(d.v.h.e.a a10, int n10) {
        return a10.c();
    }

    public static /* synthetic */ int j(List list, long l10, int n10) {
        long l11 = n10;
        return b0.c(list, l10 *= l11);
    }

    public static /* synthetic */ int k(TemplatePOJO templatePOJO) {
        return templatePOJO.getTemplateVideoList().size();
    }

    public static /* synthetic */ boolean l(int n10, int n11, TemplatePOJO object) {
        int n12 = (object = ((TemplatePOJO)object).getTemplateVideoList()).size() - n11;
        n11 = Math.abs(n12);
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public static /* synthetic */ boolean m(long l10, long l11, TemplatePOJO object) {
        object = ((TemplatePOJO)object).getTemplateVideoList().stream();
        z0 z02 = z0.a;
        long l12 = (object = object.mapToLong(z02)).sum();
        long l13 = l10 - (l11 = Math.abs(l11 - l12));
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        object2 = object2 == false ? (Object)1 : (Object)0;
        return (boolean)object2;
    }

    public static /* synthetic */ long n(TemplatePOJO object) {
        object = ((TemplatePOJO)object).getTemplateVideoList().stream();
        z0 z02 = z0.a;
        return object.mapToLong(z02).sum();
    }

    public static /* synthetic */ Long o(int n10, List list, TemplatePOJO object) {
        object = ((TemplatePOJO)object).getTemplateVideoList();
        n10 = Math.min(object.size(), n10);
        IntStream intStream = IntStream.range(0, n10);
        k k10 = new k(list, (List)object);
        return intStream.filter(k10).count();
    }

    public static /* synthetic */ boolean p(d.v.e.g.a a10, int n10, TemplatePOJO object) {
        boolean bl2;
        boolean bl3 = d.v.j.b.f((List)(object = ((TemplatePOJO)object).getTemplateVideoList()));
        if (!bl3 && (bl2 = a10.a(n10, object))) {
            bl2 = true;
        } else {
            bl2 = false;
            a10 = null;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void r(List object) {
        Object object2;
        boolean bl2 = d.v.j.b.f((List)object);
        if (bl2) {
            object = null;
            this.c = null;
        } else {
            object2 = new ArrayList(object);
            this.c = object2;
        }
        object = this.e;
        synchronized (object) {
            object2 = this.e;
            object2.notifyAll();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void t(List object, k0 k02) {
        Object object2 = this.e;
        synchronized (object2) {
            while (true) {
                boolean bl2;
                Object object3 = this.c;
                Object[] objectArray = null;
                if (object3 == null || !(bl2 = object3.isEmpty())) break;
                object3 = "\u7b49\u5f85\u6a21\u677f\u5217\u8868-------------";
                objectArray = new Object[]{};
                m.a.a.i((String)object3, objectArray);
                object3 = this.e;
                long l10 = 500L;
                object3.wait(l10);
            }
        }
        object2 = this.c;
        if (object2 == null) {
            object2 = new Object[]{};
            m.a.a.i("\u672c\u5730\u6ca1\u6709\u6a21\u677f", (Object[])object2);
            object = new IllegalArgumentException("\u6ca1\u6709\u6a21\u677f\u6570\u636e\u53ef\u7528");
            k02.onError((Throwable)object);
            return;
        }
        object2 = this.J((List)object, (List)object2);
        object = this.b((List)object, (TemplatePOJO)object2);
        object = Pair.create(((TemplatePOJO)object2).getTemplateData().getId(), object);
        k02.onSuccess(object);
    }

    private /* synthetic */ void v(List list, TemplatePOJO templatePOJO, k0 k02) {
        list = this.b(list, templatePOJO);
        k02.onSuccess(list);
    }

    public static /* synthetic */ boolean x(int n10, List list) {
        int n11 = list.size();
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public static /* synthetic */ boolean y(int n10, List list) {
        int n11 = list.size();
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public static /* synthetic */ boolean z(int n10, List list) {
        int n11 = list.size();
        n10 = n10 > n11 ? 1 : 0;
        return n10 != 0;
    }

    public /* synthetic */ int G(List list, List list2, List list3, SparseArray sparseArray, boolean bl2, int n10) {
        return this.F(list, list2, list3, sparseArray, bl2, n10);
    }

    public boolean K(TemplatePOJO object, List object2, Consumer consumer, Consumer consumer2) {
        boolean bl2 = d.v.j.b.f((List)object2);
        if (!bl2 && object != null) {
            l l10 = new l(this, (List)object2, (TemplatePOJO)object);
            object = i0.H(l10);
            object2 = d.v.e.k.e.f();
            object = ((i0)object).s((p0)object2);
            object2 = d.q.a.d.a(d.q.a.f0.f.b.h(this.b));
            object = (d0)((i0)object).o((j0)object2);
            object2 = new AiUseCase$b(this, consumer, consumer2);
            object = (e.a.s0.b)((Object)object.h((l0)object2));
            return true;
        }
        return false;
    }

    public boolean L(List object, BiConsumer biConsumer, Consumer consumer) {
        boolean bl2 = d.v.j.b.f((List)object);
        if (bl2) {
            return false;
        }
        Object object2 = new j(this, (List)object);
        object = i0.H((m0)object2);
        object2 = d.v.e.k.e.f();
        object = ((i0)object).s((p0)object2);
        object2 = d.q.a.d.a(d.q.a.f0.f.b.h(this.b));
        object = (d0)((i0)object).o((j0)object2);
        object2 = new AiUseCase$a(this, biConsumer, consumer);
        object = (e.a.s0.b)((Object)object.h((l0)object2));
        return true;
    }

    public void destory() {
        List list = this.c;
        if (list != null) {
            list.clear();
        }
    }

    public /* synthetic */ void s(List list) {
        this.r(list);
    }

    public /* synthetic */ void u(List list, k0 k02) {
        this.t(list, k02);
    }

    public /* synthetic */ void w(List list, TemplatePOJO templatePOJO, k0 k02) {
        this.v(list, templatePOJO, k02);
    }
}

