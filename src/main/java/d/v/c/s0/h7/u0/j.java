/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.c.s0.h7.u0;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.android.CameraView;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.cama.camera.story.track.TrackDescriptionBean;
import com.zhiyun.cama.camera.widget.StoryProgressBar;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPOJO;
import com.zhiyun.image.Images;
import com.zhiyun.protocol.constants.Model;
import d.v.c.s0.h7.k0;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.u0.a;
import d.v.c.s0.h7.u0.b;
import d.v.c.s0.h7.u0.c;
import d.v.c.s0.h7.u0.d;
import d.v.c.s0.h7.u0.e;
import d.v.c.s0.h7.u0.f;
import d.v.c.s0.h7.u0.j$a;
import d.v.c.s0.h7.u0.j$b;
import d.v.c.s0.h7.u0.k;
import d.v.c.s0.h7.u0.l;
import d.v.c.s0.s6;
import d.v.c.w0.yh;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class j {
    private static final int h = 0;
    private static final int i = 0;
    private static final long j = 5000000L;
    private final Context a;
    private final LifecycleOwner b;
    private final m0 c;
    private final BleViewModel d;
    private final l e;
    private int f;
    private int g;

    public j(Context context, LifecycleOwner lifecycleOwner, BleViewModel bleViewModel, m0 m02, l l10) {
        this.a = context;
        this.b = lifecycleOwner;
        this.d = bleViewModel;
        this.c = m02;
        this.e = l10;
    }

    public static /* synthetic */ l a(j j10) {
        return j10.e;
    }

    public static /* synthetic */ void b(j j10, int n10, int n11, k0 k02, CameraView cameraView) {
        j10.u(n10, n11, k02, cameraView);
    }

    private boolean c(List object) {
        boolean bl2;
        if (object != null && !(bl2 = object.isEmpty())) {
            BleViewModel bleViewModel;
            float f10;
            Object object2 = (Boolean)this.d.L.getValue();
            bl2 = d.v.e.h.a.c(object2);
            if (!bl2) {
                object = this.d.D;
                object2 = 2131951950;
                ((d.v.e.i.j)object).setValue(object2);
                return false;
            }
            object2 = this.d.x();
            boolean bl3 = l.t((List)object, (Model)((Object)object2), f10 = (bleViewModel = this.d).w());
            if (!bl3) {
                object = this.d.D;
                object2 = 2131953153;
                ((d.v.e.i.j)object).setValue(object2);
                return false;
            }
            return true;
        }
        return false;
    }

    private void d(yh yh2) {
        CheckBox checkBox = yh2.a;
        Object object = new c(yh2);
        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object);
        yh2.a.setChecked(true);
        checkBox = yh2.a;
        object = new a(this, yh2);
        checkBox.setOnTouchListener((View.OnTouchListener)object);
    }

    public static /* synthetic */ void f(yh yh2, CompoundButton compoundButton, boolean bl2) {
        yh2 = yh2.o;
        int n10 = bl2 ? 0 : 8;
        yh2.setVisibility(n10);
    }

    private /* synthetic */ boolean g(yh yh2, View view, MotionEvent motionEvent) {
        boolean bl2 = motionEvent.getAction();
        boolean bl3 = false;
        if (bl2) {
            boolean bl4 = true;
            if (bl2 == bl4) {
                float f10 = motionEvent.getRawY();
                float f11 = this.g;
                f10 = Math.abs(f10 - f11);
                int n10 = 1101004800;
                f11 = 20.0f;
                float f12 = f10 - f11;
                Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
                if (object > 0) {
                    f10 = motionEvent.getRawX();
                    n10 = this.f;
                    f11 = n10;
                    f10 = Math.abs(f10 - f11);
                    f11 = motionEvent.getRawY();
                    int n11 = this.g;
                    float f13 = n11;
                    float f14 = f10 - (f11 = Math.abs(f11 - f13));
                    Object object2 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
                    if (object2 < 0) {
                        int n12;
                        float f15;
                        yh2 = yh2.a;
                        f10 = motionEvent.getRawY();
                        float f16 = f10 - (f15 = (float)(n12 = this.g));
                        Object object3 = f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1);
                        if (object3 < 0) {
                            bl3 = bl4;
                        }
                        yh2.setChecked(bl3);
                        return bl4;
                    }
                }
            }
        } else {
            int n13;
            this.f = n13 = (int)motionEvent.getRawX();
            float f17 = motionEvent.getRawY();
            this.g = n13 = (int)f17;
        }
        return false;
    }

    private /* synthetic */ void i(yh yh2, View object, int n10, TrackDescriptionBean object2) {
        object = (Boolean)this.e.e.getValue();
        boolean bl2 = d.v.e.h.a.c((Boolean)object);
        if (bl2) {
            return;
        }
        if (object2 != null && (object = ((TrackDescriptionBean)object2).getDescription()) != null) {
            object = yh2.t;
            object2 = ((TrackDescriptionBean)object2).getDescription().a();
            object.setText((CharSequence)object2);
        } else {
            object = yh2.t;
            object2 = "";
            object.setText((CharSequence)object2);
        }
        object = this.e.b;
        object2 = n10;
        ((MutableLiveData)object).setValue(object2);
        object = (Map)this.e.c.getValue();
        int n11 = this.c.j();
        object2 = n11;
        Integer n12 = n10;
        object.put(object2, n12);
        object2 = this.e.c;
        ((MutableLiveData)object2).setValue(object);
        if (n10 == 0) {
            yh2 = yh2.t;
            object = this.a;
            n10 = 2131953154;
            object = d.v.f.i.g.m((Context)object, n10);
            yh2.setText((CharSequence)object);
        }
    }

    private /* synthetic */ void k(yh object, k object2, Map iterator2) {
        int n10;
        boolean bl2 = iterator2.isEmpty();
        if (bl2) {
            object2 = this.e.f;
            iterator2 = Boolean.FALSE;
            ((MutableLiveData)object2).setValue(iterator2);
            ((yh)object).r.m();
            return;
        }
        bl2 = false;
        iterator2 = iterator2.entrySet().iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            Object object3 = iterator2.next();
            Object object4 = (Integer)object3.getValue();
            int n11 = d.v.e.h.d.c((Integer)object4);
            Context context = null;
            if (n11 == 0) {
                object4 = ((yh)object).r;
                object3 = (Integer)object3.getKey();
                n10 = (Integer)object3;
                ((StoryProgressBar)object4).r(n10, null);
                continue;
            }
            bl2 = true;
            Object object5 = this.e.n();
            object4 = (TrackDescriptionBean)object5.get(n11);
            if (object4 != null && (object5 = ((TrackDescriptionBean)object4).getIcon()) != null) {
                object4 = ((TrackDescriptionBean)object4).getIcon().getSmall();
            } else {
                n11 = 0;
                object4 = null;
            }
            object4 = ((k)object2).e((String)object4);
            boolean bl3 = TextUtils.isEmpty((CharSequence)object4);
            if (bl3) {
                object4 = ((yh)object).r;
                object3 = (Integer)object3.getKey();
                n10 = (Integer)object3;
                ((StoryProgressBar)object4).r(n10, null);
                continue;
            }
            context = this.a;
            object5 = new j$a(this, (yh)object, (Map.Entry)object3);
            Images.w(context, object4, (d.v.l.f)object5);
        }
        object = this.e.f;
        object2 = bl2;
        ((MutableLiveData)object).setValue(object2);
    }

    private /* synthetic */ void m(k object, yh yh2, Integer n10) {
        Map map = (Map)this.e.c.getValue();
        int n11 = d.v.e.h.d.c((Integer)map.get(n10));
        ((k)object).j(n11);
        object = this.e.b;
        n10 = n11;
        ((MutableLiveData)object).setValue(n10);
        object = (Boolean)this.e.e.getValue();
        boolean bl2 = d.v.e.h.a.c((Boolean)object);
        if (!bl2) {
            object = yh2.a;
            boolean bl3 = true;
            object.setChecked(bl3);
        }
    }

    private /* synthetic */ void o(s6 viewModel, DialogFragment object) {
        ((s6)viewModel).d();
        viewModel = this.c;
        object = CameraSet$StoryState.STORY_LIST;
        ((m0)viewModel).g0((CameraSet$StoryState)((Object)object));
    }

    private void u(int n10, int n11, k0 k02, CameraView cameraView) {
        long l10 = 5000000L;
        j$b j$b = new j$b(this, cameraView, n10, n11, k02);
        if ((n10 = (int)(k02.g0(n10, false, 0, l10, j$b) ? 1 : 0)) == 0) {
            d.v.e.i.j j10 = this.d.D;
            n11 = 2131953153;
            Integer n12 = n11;
            j10.setValue(n12);
        }
    }

    private boolean v(k0 object) {
        Boolean bl2 = (Boolean)this.e.e.getValue();
        boolean bl3 = d.v.e.h.a.c(bl2);
        if (bl3) {
            ((k0)object).i0();
            object = this.e.d;
            bl2 = Boolean.FALSE;
            ((MutableLiveData)object).setValue(bl2);
            this.e.e.setValue(bl2);
            return true;
        }
        return false;
    }

    public void e(yh yh2) {
        k k10 = new k();
        Object object = new d(this, yh2);
        k10.i((d.v.f.f.b)object);
        object = this.e.n();
        k10.d((List)object);
        k10.j(0);
        yh2.q.setAdapter(k10);
        object = yh2.q;
        Object object2 = this.a;
        object2 = k10.f((Context)object2, 7);
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object2);
        object = this.e.c;
        object2 = this.b;
        Observer observer = new b(this, yh2, k10);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.c.i();
        object2 = this.b;
        observer = new f(this, k10, yh2);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        this.d(yh2);
    }

    public /* synthetic */ boolean h(yh yh2, View view, MotionEvent motionEvent) {
        return this.g(yh2, view, motionEvent);
    }

    public /* synthetic */ void j(yh yh2, View view, int n10, TrackDescriptionBean trackDescriptionBean) {
        this.i(yh2, view, n10, trackDescriptionBean);
    }

    public /* synthetic */ void l(yh yh2, k k10, Map map) {
        this.k(yh2, k10, map);
    }

    public /* synthetic */ void n(k k10, yh yh2, Integer n10) {
        this.m(k10, yh2, n10);
    }

    public /* synthetic */ void p(s6 s62, DialogFragment dialogFragment) {
        this.o(s62, dialogFragment);
    }

    public void q(k0 k02, CameraView cameraView) {
        int n10 = this.v(k02);
        if (n10 == 0) {
            Object object = this.c.o();
            Object object2 = this.e;
            long l10 = 5000000L;
            boolean bl2 = this.c((List)(object = ((l)object2).l((TemplatePOJO)object, l10)));
            if (bl2) {
                object2 = this.e.e;
                Boolean bl3 = Boolean.TRUE;
                ((MutableLiveData)object2).setValue(bl3);
                bl2 = false;
                object2 = null;
                n10 = object.size() + -1;
                this.u(0, n10, k02, cameraView);
            }
        }
    }

    public void r(k0 k02, CameraView cameraView) {
        int n10 = this.v(k02);
        if (n10 == 0) {
            Serializable serializable = new Serializable();
            Object object = this.e.j();
            serializable.add((ScriptTrackPOJO)object);
            n10 = this.c((List)((Object)serializable));
            if (n10 != 0) {
                serializable = this.c.j();
                n10 = d.v.e.h.d.c(serializable);
                object = this.e.e;
                Boolean bl2 = Boolean.TRUE;
                ((MutableLiveData)object).setValue(bl2);
                object = this.e.d;
                ((MutableLiveData)object).setValue(bl2);
                this.u(n10, n10, k02, cameraView);
            }
        }
    }

    public void s(boolean bl2) {
        this.e.y(bl2);
    }

    public boolean t(FragmentManager fragmentManager, s6 s62) {
        Object object;
        Object object2 = this.e;
        boolean bl2 = ((l)object2).r();
        if (bl2 && (object2 = CameraSet$StoryState.STORY_RECORD) == (object = this.c.v()) && (object2 = Model.SMOOTHQ3) != (object = this.d.x())) {
            object = this.a;
            object2 = new k$b((Context)object);
            object = d.v.f.i.g.m(this.a, 2131953155);
            object2 = (k$b)((k$a)object2).B((String)object);
            object = new e(this, s62);
            ((k$b)((k$b)((k$a)object2).w((d.v.f.f.a)object)).s()).D(fragmentManager);
            return true;
        }
        return false;
    }
}

