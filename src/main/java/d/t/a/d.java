/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 */
package d.t.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.yalantis.ucrop.R$color;
import com.yalantis.ucrop.R$dimen;
import com.yalantis.ucrop.R$id;
import com.yalantis.ucrop.R$layout;
import com.yalantis.ucrop.R$string;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import d.t.a.d$b;
import d.t.a.d$c;
import d.t.a.d$d;
import d.t.a.d$e;
import d.t.a.d$f;
import d.t.a.d$h;
import d.t.a.d$j;
import d.t.a.e;
import d.t.a.i.i;
import d.t.a.j.a;
import d.t.a.j.b;
import d.t.a.j.b$b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class d
extends Fragment {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 3;
    public static final String E = "UCropFragment";
    private static final long F = 50L;
    private static final int G = 3;
    private static final int H = 15000;
    private static final int I = 42;
    public static final int y = 90;
    public static final Bitmap.CompressFormat z = Bitmap.CompressFormat.JPEG;
    private e a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private Transition f;
    private UCropView g;
    private GestureCropImageView h;
    private OverlayView i;
    private ViewGroup j;
    private ViewGroup k;
    private ViewGroup l;
    private ViewGroup m;
    private ViewGroup n;
    private ViewGroup o;
    private List p;
    private TextView q;
    private TextView r;
    private View s;
    private Bitmap.CompressFormat t;
    private int u;
    private int[] v;
    private b$b w;
    private final View.OnClickListener x;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public d() {
        Object object;
        this.p = object = new ArrayList();
        this.t = object = z;
        this.u = 90;
        Object object2 = object = (Object)new int[3];
        object2[0] = (Bitmap.CompressFormat)true;
        object2[1] = (Bitmap.CompressFormat)2;
        object2[2] = (Bitmap.CompressFormat)3;
        this.v = (int[])object;
        super(this);
        this.w = object;
        super(this);
        this.x = object;
    }

    private void A(int n10) {
        GestureCropImageView gestureCropImageView = this.h;
        float f10 = n10;
        gestureCropImageView.y(f10);
        this.h.A();
    }

    private void B(int n10) {
        int n11;
        GestureCropImageView gestureCropImageView = this.h;
        int[] nArray = this.v;
        int n12 = nArray[n10];
        int n13 = 0;
        int n14 = 3;
        int n15 = 1;
        if (n12 != n14 && (n11 = nArray[n10]) != n15) {
            n11 = 0;
            nArray = null;
        } else {
            n11 = n15;
        }
        gestureCropImageView.setScaleEnabled(n11 != 0);
        gestureCropImageView = this.h;
        nArray = this.v;
        n12 = nArray[n10];
        if (n12 == n14 || (n10 = nArray[n10]) == (n11 = 2)) {
            n13 = n15;
        }
        gestureCropImageView.setRotateEnabled(n13 != 0);
    }

    private void C(float f10) {
        TextView textView = this.q;
        if (textView != null) {
            Object object;
            Locale locale = Locale.getDefault();
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object = Float.valueOf(f10);
            object = String.format(locale, "%.1f\u00b0", objectArray);
            textView.setText((CharSequence)object);
        }
    }

    private void D(int n10) {
        TextView textView = this.q;
        if (textView != null) {
            textView.setTextColor(n10);
        }
    }

    private void F(Bundle object) {
        Object object2 = (Uri)object.getParcelable("com.yalantis.ucrop.InputUri");
        Object object3 = (Uri)object.getParcelable("com.yalantis.ucrop.OutputUri");
        this.y((Bundle)object);
        if (object2 != null && object3 != null) {
            object = this.h;
            try {
                ((b)object).o((Uri)object2, (Uri)object3);
            }
            catch (Exception exception) {
                object2 = this.a;
                d$j d$j = this.u(exception);
                object2.a(d$j);
            }
        } else {
            object = this.a;
            int n10 = R$string.ucrop_error_input_data_is_absent;
            object3 = this.getString(n10);
            object2 = new NullPointerException((String)object3);
            object2 = this.u((Throwable)object2);
            object.a((d$j)object2);
        }
    }

    private void G() {
        int n10 = this.e;
        if (n10 != 0) {
            ViewGroup viewGroup = this.j;
            n10 = viewGroup.getVisibility();
            if (n10 == 0) {
                n10 = R$id.state_aspect_ratio;
                this.J(n10);
            } else {
                n10 = R$id.state_scale;
                this.J(n10);
            }
        } else {
            n10 = 0;
            Object var2_3 = null;
            this.B(0);
        }
    }

    private void H(float f10) {
        TextView textView = this.r;
        if (textView != null) {
            Object object;
            Locale locale = Locale.getDefault();
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            float f11 = 100.0f;
            int n11 = (int)(f10 *= f11);
            objectArray[0] = object = Integer.valueOf(n11);
            object = String.format(locale, "%d%%", objectArray);
            textView.setText((CharSequence)object);
        }
    }

    private void I(int n10) {
        TextView textView = this.r;
        if (textView != null) {
            textView.setTextColor(n10);
        }
    }

    private void J(int n10) {
        boolean bl2 = this.e;
        if (!bl2) {
            return;
        }
        ViewGroup viewGroup = this.j;
        int n11 = R$id.state_aspect_ratio;
        int n12 = 1;
        float f10 = Float.MIN_VALUE;
        int n13 = n10 == n11 ? n12 : 0;
        viewGroup.setSelected(n13 != 0);
        viewGroup = this.k;
        n13 = R$id.state_rotate;
        int n14 = n10 == n13 ? n12 : 0;
        viewGroup.setSelected(n14 != 0);
        viewGroup = this.l;
        n14 = R$id.state_scale;
        int n15 = n10 == n14 ? n12 : 0;
        viewGroup.setSelected(n15 != 0);
        viewGroup = this.m;
        n15 = 8;
        n11 = n10 == n11 ? 0 : n15;
        viewGroup.setVisibility(n11);
        viewGroup = this.n;
        n11 = n10 == n13 ? 0 : n15;
        viewGroup.setVisibility(n11);
        viewGroup = this.o;
        if (n10 == n14) {
            n15 = 0;
        }
        viewGroup.setVisibility(n15);
        this.s(n10);
        if (n10 == n14) {
            this.B(0);
        } else if (n10 == n13) {
            this.B(n12);
        } else {
            n10 = 2;
            this.B(n10);
        }
    }

    private void K(Bundle object, View view) {
        int n10;
        float f10;
        int n11;
        String string2;
        int n12;
        d.t.a.g.a a10;
        int n13;
        Object object2 = "com.yalantis.ucrop.AspectRatioSelectedByDefault";
        int n14 = object.getInt((String)object2, 0);
        Object object3 = "com.yalantis.ucrop.AspectRatioOptions";
        object = object.getParcelableArrayList((String)object3);
        int n15 = 1065353216;
        float f11 = 1.0f;
        if (object == null || (n13 = ((ArrayList)object).isEmpty()) != 0) {
            n14 = 2;
            object = new ArrayList();
            a10 = new d.t.a.g.a(null, f11, f11);
            ((ArrayList)object).add(a10);
            float f12 = 3.0f;
            a10 = new d.t.a.g.a(null, f12, 4.0f);
            ((ArrayList)object).add(a10);
            n12 = R$string.ucrop_label_original;
            string2 = this.getString(n12).toUpperCase();
            n11 = 0;
            a10 = new d.t.a.g.a(string2, 0.0f, 0.0f);
            ((ArrayList)object).add(a10);
            a10 = new d.t.a.g.a(null, f12, 2.0f);
            ((ArrayList)object).add(a10);
            n12 = 1098907648;
            f10 = 16.0f;
            n10 = 0x41100000;
            f12 = 9.0f;
            a10 = new d.t.a.g.a(null, f10, f12);
            ((ArrayList)object).add(a10);
        }
        n13 = R$id.layout_aspect_ratio;
        view = (LinearLayout)view.findViewById(n13);
        n12 = -1;
        f10 = 0.0f / 0.0f;
        a10 = new LinearLayout.LayoutParams(0, n12);
        ((LinearLayout.LayoutParams)a10).weight = f11;
        object = ((ArrayList)object).iterator();
        while ((n15 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object3 = (d.t.a.g.a)object.next();
            string2 = this.getLayoutInflater();
            n10 = R$layout.ucrop_aspect_ratio;
            string2 = (FrameLayout)string2.inflate(n10, null);
            string2.setLayoutParams((ViewGroup.LayoutParams)a10);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView)string2.getChildAt(0);
            n11 = this.b;
            aspectRatioTextView.setActiveColor(n11);
            aspectRatioTextView.setAspectRatio((d.t.a.g.a)object3);
            view.addView((View)string2);
            object3 = this.p;
            object3.add(string2);
        }
        object = (ViewGroup)this.p.get(n14);
        boolean bl2 = true;
        object.setSelected(bl2);
        object = this.p.iterator();
        while (bl2 = object.hasNext()) {
            view = (ViewGroup)object.next();
            object2 = new d$b(this);
            view.setOnClickListener((View.OnClickListener)object2);
        }
    }

    private void L(View view) {
        int n10 = R$id.text_view_rotate;
        Object object = (TextView)view.findViewById(n10);
        this.q = object;
        n10 = R$id.rotate_scroll_wheel;
        Object object2 = (HorizontalProgressWheelView)view.findViewById(n10);
        d$c d$c = new d$c(this);
        object2.setScrollingListener(d$c);
        object = (HorizontalProgressWheelView)view.findViewById(n10);
        int n11 = this.b;
        ((HorizontalProgressWheelView)((Object)object)).setMiddleLineColor(n11);
        n10 = R$id.wrapper_reset_rotate;
        object = view.findViewById(n10);
        object2 = new d$d(this);
        object.setOnClickListener((View.OnClickListener)object2);
        n10 = R$id.wrapper_rotate_by_angle;
        view = view.findViewById(n10);
        object = new d$e(this);
        view.setOnClickListener((View.OnClickListener)object);
        int n12 = this.b;
        this.D(n12);
    }

    private void M(View view) {
        TextView textView;
        int n10 = R$id.text_view_scale;
        this.r = textView = (TextView)view.findViewById(n10);
        n10 = R$id.scale_scroll_wheel;
        HorizontalProgressWheelView horizontalProgressWheelView = (HorizontalProgressWheelView)view.findViewById(n10);
        d$f d$f = new d$f(this);
        horizontalProgressWheelView.setScrollingListener(d$f);
        view = (HorizontalProgressWheelView)view.findViewById(n10);
        n10 = this.b;
        view.setMiddleLineColor(n10);
        int n11 = this.b;
        this.I(n11);
    }

    private void N(View view) {
        int n10 = R$id.image_view_state_scale;
        Object object = (ImageView)view.findViewById(n10);
        int n11 = R$id.image_view_state_rotate;
        ImageView imageView = (ImageView)view.findViewById(n11);
        int n12 = R$id.image_view_state_aspect_ratio;
        view = (ImageView)view.findViewById(n12);
        Drawable drawable2 = object.getDrawable();
        int n13 = this.b;
        i i10 = new i(drawable2, n13);
        object.setImageDrawable((Drawable)i10);
        i10 = imageView.getDrawable();
        int n14 = this.b;
        object = new i((Drawable)i10, n14);
        imageView.setImageDrawable((Drawable)object);
        imageView = view.getDrawable();
        n12 = this.b;
        object = new i((Drawable)imageView, n12);
        view.setImageDrawable((Drawable)object);
    }

    public static /* synthetic */ void h(d d10, float f10) {
        d10.C(f10);
    }

    public static /* synthetic */ void i(d d10, float f10) {
        d10.H(f10);
    }

    public static /* synthetic */ UCropView j(d d10) {
        return d10.g;
    }

    public static /* synthetic */ View k(d d10) {
        return d10.s;
    }

    public static /* synthetic */ e l(d d10) {
        return d10.a;
    }

    public static /* synthetic */ GestureCropImageView m(d d10) {
        return d10.h;
    }

    public static /* synthetic */ List n(d d10) {
        return d10.p;
    }

    public static /* synthetic */ void o(d d10) {
        d10.z();
    }

    public static /* synthetic */ void p(d d10, int n10) {
        d10.A(n10);
    }

    public static /* synthetic */ void q(d d10, int n10) {
        d10.J(n10);
    }

    private void r(View view) {
        View view2 = this.s;
        if (view2 == null) {
            Context context = this.getContext();
            this.s = view2 = new View(context);
            int bl2 = -1;
            view2 = new RelativeLayout.LayoutParams(bl2, bl2);
            context = this.s;
            context.setLayoutParams((ViewGroup.LayoutParams)view2);
            view2 = this.s;
            boolean bl3 = true;
            view2.setClickable(bl3);
        }
        int n10 = R$id.ucrop_photobox;
        view = (RelativeLayout)view.findViewById(n10);
        view2 = this.s;
        view.addView(view2);
    }

    private void s(int n10) {
        Transition transition;
        int n11;
        View view = this.getView();
        if (view != null) {
            view = this.getView();
            n11 = R$id.ucrop_photobox;
            view = (ViewGroup)view.findViewById(n11);
            transition = this.f;
            TransitionManager.beginDelayedTransition((ViewGroup)view, transition);
        }
        view = this.l;
        n11 = R$id.text_view_scale;
        view = view.findViewById(n11);
        n11 = R$id.state_scale;
        int n12 = 0;
        int n13 = 8;
        if (n10 == n11) {
            n11 = 0;
            transition = null;
        } else {
            n11 = n13;
        }
        view.setVisibility(n11);
        view = this.j;
        n11 = R$id.text_view_crop;
        view = view.findViewById(n11);
        n11 = R$id.state_aspect_ratio;
        if (n10 == n11) {
            n11 = 0;
            transition = null;
        } else {
            n11 = n13;
        }
        view.setVisibility(n11);
        view = this.k;
        n11 = R$id.text_view_rotate;
        view = view.findViewById(n11);
        n11 = R$id.state_rotate;
        if (n10 != n11) {
            n12 = n13;
        }
        view.setVisibility(n12);
    }

    private void w(View view) {
        int n10 = R$id.ucrop;
        Object object = (UCropView)view.findViewById(n10);
        this.g = object;
        object = ((UCropView)((Object)object)).getCropImageView();
        this.h = object;
        object = this.g.getOverlayView();
        this.i = object;
        object = this.h;
        b$b b$b = this.w;
        ((b)object).setTransformImageListener(b$b);
        n10 = R$id.image_view_logo;
        object = (ImageView)view.findViewById(n10);
        int n11 = this.d;
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
        object.setColorFilter(n11, mode);
        n10 = R$id.ucrop_frame;
        view = view.findViewById(n10);
        n10 = this.c;
        view.setBackgroundColor(n10);
    }

    public static d x(Bundle bundle) {
        d d10 = new d();
        d10.setArguments(bundle);
        return d10;
    }

    private void y(Bundle bundle) {
        float f10;
        int n10;
        float f11;
        int n11;
        Object object = bundle.getString("com.yalantis.ucrop.CompressionFormatName");
        int n12 = TextUtils.isEmpty((CharSequence)object);
        if (n12 == 0) {
            object = Bitmap.CompressFormat.valueOf((String)object);
        } else {
            n11 = 0;
            f11 = 0.0f;
            object = null;
        }
        if (object == null) {
            object = z;
        }
        this.t = object;
        f11 = 1.26E-43f;
        Object object2 = "com.yalantis.ucrop.CompressionQuality";
        this.u = n11 = bundle.getInt((String)object2, 90);
        object = bundle.getIntArray("com.yalantis.ucrop.AllowedGestures");
        if (object != null && (n12 = ((Object)object).length) == (n10 = 3)) {
            this.v = (int[])object;
        }
        object = this.h;
        n10 = 0;
        n12 = bundle.getInt("com.yalantis.ucrop.MaxBitmapSize", 0);
        ((b)object).setMaxBitmapSize(n12);
        object = this.h;
        float f12 = bundle.getFloat("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f);
        ((a)object).setMaxScaleMultiplier(f12);
        object = this.h;
        long l10 = bundle.getInt("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500);
        ((a)object).setImageToWrapCropBoundsAnimDuration(l10);
        object = this.i;
        n12 = (int)(bundle.getBoolean("com.yalantis.ucrop.FreeStyleCrop", false) ? 1 : 0);
        ((OverlayView)((Object)object)).setFreestyleCropEnabled(n12 != 0);
        object = this.i;
        object2 = this.getResources();
        int n13 = R$color.ucrop_color_default_dimmed;
        n12 = object2.getColor(n13);
        n12 = bundle.getInt("com.yalantis.ucrop.DimmedLayerColor", n12);
        ((OverlayView)((Object)object)).setDimmedColor(n12);
        object = this.i;
        n12 = (int)(bundle.getBoolean("com.yalantis.ucrop.CircleDimmedLayer", false) ? 1 : 0);
        ((OverlayView)((Object)object)).setCircleDimmedLayer(n12 != 0);
        object = this.i;
        n13 = 1;
        n12 = bundle.getBoolean("com.yalantis.ucrop.ShowCropFrame", n13 != 0);
        ((OverlayView)((Object)object)).setShowCropFrame(n12 != 0);
        object = this.i;
        object2 = this.getResources();
        int n14 = R$color.ucrop_color_default_crop_frame;
        n12 = object2.getColor(n14);
        n12 = bundle.getInt("com.yalantis.ucrop.CropFrameColor", n12);
        ((OverlayView)((Object)object)).setCropFrameColor(n12);
        object = this.i;
        object2 = this.getResources();
        n14 = R$dimen.ucrop_default_crop_frame_stoke_width;
        n12 = object2.getDimensionPixelSize(n14);
        n12 = bundle.getInt("com.yalantis.ucrop.CropFrameStrokeWidth", n12);
        ((OverlayView)((Object)object)).setCropFrameStrokeWidth(n12);
        object = this.i;
        n12 = (int)(bundle.getBoolean("com.yalantis.ucrop.ShowCropGrid", n13 != 0) ? 1 : 0);
        ((OverlayView)((Object)object)).setShowCropGrid(n12 != 0);
        object = this.i;
        n13 = 2;
        n12 = bundle.getInt("com.yalantis.ucrop.CropGridRowCount", n13);
        ((OverlayView)((Object)object)).setCropGridRowCount(n12);
        object = this.i;
        n12 = bundle.getInt("com.yalantis.ucrop.CropGridColumnCount", n13);
        ((OverlayView)((Object)object)).setCropGridColumnCount(n12);
        object = this.i;
        object2 = this.getResources();
        n13 = R$color.ucrop_color_default_crop_grid;
        n12 = object2.getColor(n13);
        n12 = bundle.getInt("com.yalantis.ucrop.CropGridColor", n12);
        ((OverlayView)((Object)object)).setCropGridColor(n12);
        object = this.i;
        object2 = this.getResources();
        n13 = R$dimen.ucrop_default_crop_grid_stoke_width;
        n12 = object2.getDimensionPixelSize(n13);
        n12 = bundle.getInt("com.yalantis.ucrop.CropGridStrokeWidth", n12);
        ((OverlayView)((Object)object)).setCropGridStrokeWidth(n12);
        object = "com.yalantis.ucrop.AspectRatioX";
        n12 = 0;
        f12 = 0.0f;
        object2 = null;
        f11 = bundle.getFloat((String)object, 0.0f);
        Object object3 = "com.yalantis.ucrop.AspectRatioY";
        float f13 = bundle.getFloat((String)object3, 0.0f);
        String string2 = "com.yalantis.ucrop.AspectRatioSelectedByDefault";
        n14 = bundle.getInt(string2, 0);
        ArrayList arrayList = bundle.getParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions");
        float f14 = f11 - 0.0f;
        float f15 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (f15 > 0 && (f15 = (f10 = f13 - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) > 0) {
            object2 = this.j;
            if (object2 != null) {
                n14 = 8;
                object2.setVisibility(n14);
            }
            object2 = this.h;
            ((a)object2).setTargetAspectRatio(f11 /= f13);
        } else if (arrayList != null && n14 < (n11 = arrayList.size())) {
            object = this.h;
            object2 = (d.t.a.g.a)arrayList.get(n14);
            f12 = ((d.t.a.g.a)object2).b();
            object3 = (d.t.a.g.a)arrayList.get(n14);
            f13 = ((d.t.a.g.a)object3).c();
            ((a)object).setTargetAspectRatio(f12 /= f13);
        } else {
            object = this.h;
            ((a)object).setTargetAspectRatio(0.0f);
        }
        object = "com.yalantis.ucrop.MaxSizeX";
        n11 = bundle.getInt((String)object, 0);
        object2 = "com.yalantis.ucrop.MaxSizeY";
        int n15 = bundle.getInt((String)object2, 0);
        if (n11 > 0 && n15 > 0) {
            object2 = this.h;
            ((a)object2).setMaxResultImageSizeX(n11);
            object = this.h;
            ((a)object).setMaxResultImageSizeY(n15);
        }
    }

    private void z() {
        GestureCropImageView gestureCropImageView = this.h;
        float f10 = -gestureCropImageView.getCurrentAngle();
        gestureCropImageView.y(f10);
        this.h.A();
    }

    public void E(e e10) {
        this.a = e10;
    }

    public void O(View view, Bundle bundle) {
        Object object = this.getContext();
        int n10 = R$color.ucrop_color_widget_active;
        int n11 = ContextCompat.getColor((Context)object, n10);
        this.b = n11 = bundle.getInt("com.yalantis.ucrop.UcropColorControlsWidgetActive", n11);
        object = this.getContext();
        n10 = R$color.ucrop_color_default_logo;
        n11 = ContextCompat.getColor((Context)object, n10);
        this.d = n11 = bundle.getInt("com.yalantis.ucrop.UcropLogoColor", n11);
        n10 = 0;
        LayoutInflater layoutInflater = null;
        n11 = (int)(bundle.getBoolean("com.yalantis.ucrop.HideBottomControls", false) ? 1 : 0);
        int n12 = 1;
        this.e = n11 ^= n12;
        object = this.getContext();
        int n13 = R$color.ucrop_color_crop_background;
        n11 = ContextCompat.getColor((Context)object, n13);
        String string2 = "com.yalantis.ucrop.UcropRootViewBackgroundColor";
        this.c = n11 = bundle.getInt(string2, n11);
        this.w(view);
        object = this.a;
        object.b(n12 != 0);
        n11 = (int)(this.e ? 1 : 0);
        if (n11 != 0) {
            n11 = R$id.controls_wrapper;
            object = (ViewGroup)view.findViewById(n11);
            object.setVisibility(0);
            layoutInflater = LayoutInflater.from((Context)this.getContext());
            n13 = R$layout.ucrop_controls;
            layoutInflater.inflate(n13, (ViewGroup)object, n12 != 0);
            this.f = object = new AutoTransition();
            long l10 = 50;
            ((Transition)object).setDuration(l10);
            n11 = R$id.state_aspect_ratio;
            object = (ViewGroup)view.findViewById(n11);
            this.j = object;
            layoutInflater = this.x;
            object.setOnClickListener((View.OnClickListener)layoutInflater);
            n11 = R$id.state_rotate;
            object = (ViewGroup)view.findViewById(n11);
            this.k = object;
            layoutInflater = this.x;
            object.setOnClickListener((View.OnClickListener)layoutInflater);
            n11 = R$id.state_scale;
            object = (ViewGroup)view.findViewById(n11);
            this.l = object;
            layoutInflater = this.x;
            object.setOnClickListener((View.OnClickListener)layoutInflater);
            n11 = R$id.layout_aspect_ratio;
            object = (ViewGroup)view.findViewById(n11);
            this.m = object;
            n11 = R$id.layout_rotate_wheel;
            object = (ViewGroup)view.findViewById(n11);
            this.n = object;
            n11 = R$id.layout_scale_wheel;
            object = (ViewGroup)view.findViewById(n11);
            this.o = object;
            this.K(bundle, view);
            this.L(view);
            this.M(view);
            this.N(view);
        } else {
            int n14 = R$id.ucrop_frame;
            object = (RelativeLayout.LayoutParams)view.findViewById(n14).getLayoutParams();
            ((RelativeLayout.LayoutParams)object).bottomMargin = 0;
            view = view.findViewById(n14);
            view.requestLayout();
        }
    }

    public void onAttach(Context object) {
        Object object2;
        block4: {
            block3: {
                boolean bl2;
                block2: {
                    super.onAttach((Context)object);
                    object2 = this.getParentFragment();
                    bl2 = object2 instanceof e;
                    if (!bl2) break block2;
                    object = (e)((Object)this.getParentFragment());
                    this.a = object;
                    break block3;
                }
                bl2 = object instanceof e;
                if (!bl2) break block4;
                object = (e)object;
                this.a = object;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        object = object.toString();
        stringBuilder.append((String)object);
        stringBuilder.append(" must implement UCropFragmentCallback");
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int n10 = R$layout.ucrop_fragment_photobox;
        layoutInflater = layoutInflater.inflate(n10, viewGroup, false);
        viewGroup = this.getArguments();
        this.O((View)layoutInflater, (Bundle)viewGroup);
        this.F((Bundle)viewGroup);
        this.G();
        this.r((View)layoutInflater);
        return layoutInflater;
    }

    public void t() {
        Object object = this.s;
        boolean bl2 = true;
        object.setClickable(bl2);
        this.a.b(bl2);
        object = this.h;
        Bitmap.CompressFormat compressFormat = this.t;
        int n10 = this.u;
        d$h d$h = new d$h(this);
        ((a)object).v(compressFormat, n10, d$h);
    }

    public d$j u(Throwable throwable) {
        Intent intent = new Intent();
        throwable = intent.putExtra("com.yalantis.ucrop.Error", (Serializable)throwable);
        d$j d$j = new d$j(this, 96, (Intent)throwable);
        return d$j;
    }

    public d$j v(Uri uri, float f10, int n10, int n11, int n12, int n13) {
        Intent intent = new Intent();
        uri = intent.putExtra("com.yalantis.ucrop.OutputUri", (Parcelable)uri).putExtra("com.yalantis.ucrop.CropAspectRatio", f10).putExtra("com.yalantis.ucrop.ImageWidth", n12).putExtra("com.yalantis.ucrop.ImageHeight", n13).putExtra("com.yalantis.ucrop.OffsetX", n10).putExtra("com.yalantis.ucrop.OffsetY", n11);
        d$j d$j = new d$j(this, -1, (Intent)uri);
        return d$j;
    }
}

