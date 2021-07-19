/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
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
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.yalantis.ucrop.R$color;
import com.yalantis.ucrop.R$dimen;
import com.yalantis.ucrop.R$drawable;
import com.yalantis.ucrop.R$id;
import com.yalantis.ucrop.R$layout;
import com.yalantis.ucrop.R$menu;
import com.yalantis.ucrop.R$string;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import d.t.a.c$b;
import d.t.a.c$c;
import d.t.a.c$d;
import d.t.a.c$e;
import d.t.a.c$f;
import d.t.a.c$h;
import d.t.a.i.i;
import d.t.a.j.a;
import d.t.a.j.b;
import d.t.a.j.b$b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class c
extends AppCompatActivity {
    public static final int E = 90;
    public static final Bitmap.CompressFormat F = Bitmap.CompressFormat.JPEG;
    public static final int G = 0;
    public static final int H = 1;
    public static final int I = 2;
    public static final int J = 3;
    private static final String K = "UCropActivity";
    private static final long L = 50L;
    private static final int M = 3;
    private static final int N = 15000;
    private static final int O = 42;
    private int A;
    private int[] B;
    private b$b C;
    private final View.OnClickListener D;
    private String a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private boolean k = true;
    private UCropView l;
    private GestureCropImageView m;
    private OverlayView n;
    private ViewGroup o;
    private ViewGroup p;
    private ViewGroup q;
    private ViewGroup r;
    private ViewGroup s;
    private ViewGroup t;
    private List u;
    private TextView v;
    private TextView w;
    private View x;
    private Transition y;
    private Bitmap.CompressFormat z;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public c() {
        Object object;
        this.u = object = new ArrayList();
        this.z = object = F;
        this.A = 90;
        Object object2 = object = (Object)new int[3];
        object2[0] = (Bitmap.CompressFormat)true;
        object2[1] = (Bitmap.CompressFormat)2;
        object2[2] = (Bitmap.CompressFormat)3;
        this.B = (int[])object;
        super(this);
        this.C = object;
        super(this);
        this.D = object;
    }

    private void A() {
        int n10 = this.j;
        if (n10 != 0) {
            ViewGroup viewGroup = this.o;
            n10 = viewGroup.getVisibility();
            if (n10 == 0) {
                n10 = R$id.state_aspect_ratio;
                this.G(n10);
            } else {
                n10 = R$id.state_scale;
                this.G(n10);
            }
        } else {
            n10 = 0;
            Object var2_3 = null;
            this.w(0);
        }
    }

    private void D(float f10) {
        TextView textView = this.w;
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

    private void E(int n10) {
        TextView textView = this.w;
        if (textView != null) {
            textView.setTextColor(n10);
        }
    }

    private void F(int n10) {
        Window window;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12 && (window = this.getWindow()) != null) {
            n12 = -1 << -1;
            window.addFlags(n12);
            window.setStatusBarColor(n10);
        }
    }

    private void G(int n10) {
        boolean bl2 = this.j;
        if (!bl2) {
            return;
        }
        ViewGroup viewGroup = this.o;
        int n11 = R$id.state_aspect_ratio;
        int n12 = 1;
        float f10 = Float.MIN_VALUE;
        int n13 = n10 == n11 ? n12 : 0;
        viewGroup.setSelected(n13 != 0);
        viewGroup = this.p;
        n13 = R$id.state_rotate;
        int n14 = n10 == n13 ? n12 : 0;
        viewGroup.setSelected(n14 != 0);
        viewGroup = this.q;
        n14 = R$id.state_scale;
        int n15 = n10 == n14 ? n12 : 0;
        viewGroup.setSelected(n15 != 0);
        viewGroup = this.r;
        n15 = 8;
        n11 = n10 == n11 ? 0 : n15;
        viewGroup.setVisibility(n11);
        viewGroup = this.s;
        n11 = n10 == n13 ? 0 : n15;
        viewGroup.setVisibility(n11);
        viewGroup = this.t;
        if (n10 == n14) {
            n15 = 0;
        }
        viewGroup.setVisibility(n15);
        this.q(n10);
        if (n10 == n14) {
            this.w(0);
        } else if (n10 == n13) {
            this.w(n12);
        } else {
            n10 = 2;
            this.w(n10);
        }
    }

    private void H() {
        int n10 = this.c;
        this.F(n10);
        n10 = R$id.toolbar;
        Object object = (Toolbar)this.findViewById(n10);
        int n11 = this.b;
        object.setBackgroundColor(n11);
        n11 = this.e;
        ((Toolbar)((Object)object)).setTitleTextColor(n11);
        n11 = R$id.toolbar_title;
        TextView textView = (TextView)object.findViewById(n11);
        int n12 = this.e;
        textView.setTextColor(n12);
        String string2 = this.a;
        textView.setText((CharSequence)string2);
        n11 = this.g;
        textView = ContextCompat.getDrawable((Context)this, n11).mutate();
        n12 = this.e;
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
        textView.setColorFilter(n12, mode);
        ((Toolbar)((Object)object)).setNavigationIcon((Drawable)textView);
        this.setSupportActionBar((Toolbar)((Object)object));
        object = this.getSupportActionBar();
        if (object != null) {
            n11 = 0;
            textView = null;
            ((ActionBar)object).setDisplayShowTitleEnabled(false);
        }
    }

    private void I(Intent object) {
        boolean bl2;
        int n10;
        AspectRatioTextView aspectRatioTextView;
        int n11;
        Object object2;
        float f10;
        d.t.a.g.a a10;
        int n12;
        int n13;
        String string2 = "com.yalantis.ucrop.AspectRatioSelectedByDefault";
        c$b c$b = null;
        int bl22 = object.getIntExtra(string2, 0);
        Object object3 = "com.yalantis.ucrop.AspectRatioOptions";
        object = object.getParcelableArrayListExtra((String)object3);
        int n14 = 1065353216;
        float f11 = 1.0f;
        if (object == null || (n13 = ((ArrayList)object).isEmpty()) != 0) {
            n12 = 2;
            object = new ArrayList();
            a10 = new d.t.a.g.a(null, f11, f11);
            ((ArrayList)object).add(a10);
            f10 = 3.0f;
            a10 = new d.t.a.g.a(null, f10, 4.0f);
            ((ArrayList)object).add(a10);
            int n15 = R$string.ucrop_label_original;
            object2 = this.getString(n15).toUpperCase();
            n11 = 0;
            aspectRatioTextView = null;
            a10 = new d.t.a.g.a((String)object2, 0.0f, 0.0f);
            ((ArrayList)object).add(a10);
            a10 = new d.t.a.g.a(null, f10, 2.0f);
            ((ArrayList)object).add(a10);
            n15 = 1098907648;
            float f12 = 16.0f;
            n10 = 0x41100000;
            f10 = 9.0f;
            a10 = new d.t.a.g.a(null, f12, f10);
            ((ArrayList)object).add(a10);
        }
        n13 = R$id.layout_aspect_ratio;
        a10 = (LinearLayout)this.findViewById(n13);
        n10 = -1;
        f10 = 0.0f / 0.0f;
        object2 = new LinearLayout.LayoutParams(0, n10);
        object2.weight = f11;
        object = ((ArrayList)object).iterator();
        while ((n14 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object3 = (d.t.a.g.a)object.next();
            LayoutInflater layoutInflater = this.getLayoutInflater();
            n11 = R$layout.ucrop_aspect_ratio;
            layoutInflater = (FrameLayout)layoutInflater.inflate(n11, null);
            layoutInflater.setLayoutParams((ViewGroup.LayoutParams)object2);
            aspectRatioTextView = (AspectRatioTextView)layoutInflater.getChildAt(0);
            int n16 = this.d;
            aspectRatioTextView.setActiveColor(n16);
            aspectRatioTextView.setAspectRatio((d.t.a.g.a)object3);
            a10.addView((View)layoutInflater);
            object3 = this.u;
            object3.add(layoutInflater);
        }
        object = (ViewGroup)this.u.get(n12);
        boolean bl3 = true;
        object.setSelected(bl3);
        object = this.u.iterator();
        while (bl2 = object.hasNext()) {
            string2 = (ViewGroup)object.next();
            c$b = new c$b(this);
            string2.setOnClickListener((View.OnClickListener)c$b);
        }
    }

    private void J() {
        int n10 = R$id.text_view_rotate;
        Object object = (TextView)this.findViewById(n10);
        this.v = object;
        n10 = R$id.rotate_scroll_wheel;
        Object object2 = (HorizontalProgressWheelView)this.findViewById(n10);
        c$c c$c = new c$c(this);
        object2.setScrollingListener(c$c);
        object = (HorizontalProgressWheelView)this.findViewById(n10);
        int n11 = this.d;
        ((HorizontalProgressWheelView)((Object)object)).setMiddleLineColor(n11);
        n10 = R$id.wrapper_reset_rotate;
        object = this.findViewById(n10);
        object2 = new c$d(this);
        object.setOnClickListener((View.OnClickListener)object2);
        n10 = R$id.wrapper_rotate_by_angle;
        object = this.findViewById(n10);
        object2 = new c$e(this);
        object.setOnClickListener((View.OnClickListener)object2);
        n10 = this.d;
        this.y(n10);
    }

    private void K() {
        int n10 = R$id.text_view_scale;
        Object object = (TextView)this.findViewById(n10);
        this.w = object;
        n10 = R$id.scale_scroll_wheel;
        HorizontalProgressWheelView horizontalProgressWheelView = (HorizontalProgressWheelView)this.findViewById(n10);
        c$f c$f = new c$f(this);
        horizontalProgressWheelView.setScrollingListener(c$f);
        object = (HorizontalProgressWheelView)this.findViewById(n10);
        int n11 = this.d;
        ((HorizontalProgressWheelView)((Object)object)).setMiddleLineColor(n11);
        n10 = this.d;
        this.E(n10);
    }

    private void L() {
        int n10 = R$id.image_view_state_scale;
        Object object = (ImageView)this.findViewById(n10);
        int n11 = R$id.image_view_state_rotate;
        ImageView imageView = (ImageView)this.findViewById(n11);
        int n12 = R$id.image_view_state_aspect_ratio;
        ImageView imageView2 = (ImageView)this.findViewById(n12);
        Drawable drawable2 = object.getDrawable();
        int n13 = this.d;
        i i10 = new i(drawable2, n13);
        object.setImageDrawable((Drawable)i10);
        i10 = imageView.getDrawable();
        int n14 = this.d;
        object = new i((Drawable)i10, n14);
        imageView.setImageDrawable((Drawable)object);
        imageView = imageView2.getDrawable();
        int n15 = this.d;
        object = new i((Drawable)imageView, n15);
        imageView2.setImageDrawable((Drawable)object);
    }

    private void M(Intent intent) {
        int n10;
        int n11 = R$color.ucrop_color_statusbar;
        n11 = ContextCompat.getColor((Context)this, n11);
        this.c = n11 = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", n11);
        n11 = R$color.ucrop_color_toolbar;
        n11 = ContextCompat.getColor((Context)this, n11);
        this.b = n11 = intent.getIntExtra("com.yalantis.ucrop.ToolbarColor", n11);
        n11 = R$color.ucrop_color_active_controls_color;
        n11 = ContextCompat.getColor((Context)this, n11);
        this.d = n11 = intent.getIntExtra("com.yalantis.ucrop.UcropColorControlsWidgetActive", n11);
        n11 = R$color.ucrop_color_toolbar_widget;
        n11 = ContextCompat.getColor((Context)this, n11);
        this.e = n11 = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarWidgetColor", n11);
        n11 = R$drawable.ucrop_ic_cross;
        this.g = n11 = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCancelDrawable", n11);
        n11 = R$drawable.ucrop_ic_done;
        String string2 = "com.yalantis.ucrop.UcropToolbarCropDrawable";
        this.h = n11 = intent.getIntExtra(string2, n11);
        Object object = intent.getStringExtra("com.yalantis.ucrop.UcropToolbarTitleText");
        this.a = object;
        if (object == null) {
            object = this.getResources();
            n10 = R$string.ucrop_label_edit_photo;
            object = object.getString(n10);
        }
        this.a = object;
        n11 = R$color.ucrop_color_default_logo;
        n11 = ContextCompat.getColor((Context)this, n11);
        this.i = n11 = intent.getIntExtra("com.yalantis.ucrop.UcropLogoColor", n11);
        object = "com.yalantis.ucrop.HideBottomControls";
        n10 = 0;
        string2 = null;
        n11 = (int)(intent.getBooleanExtra((String)object, false) ? 1 : 0);
        int n12 = 1;
        this.j = n11 ^= n12;
        n11 = R$color.ucrop_color_crop_background;
        n11 = ContextCompat.getColor((Context)this, n11);
        String string3 = "com.yalantis.ucrop.UcropRootViewBackgroundColor";
        this.f = n11 = intent.getIntExtra(string3, n11);
        this.H();
        this.s();
        n11 = (int)(this.j ? 1 : 0);
        if (n11 != 0) {
            n11 = R$id.ucrop_photobox;
            object = (ViewGroup)this.findViewById(n11);
            int n13 = R$id.controls_wrapper;
            object = (ViewGroup)object.findViewById(n13);
            object.setVisibility(0);
            string2 = LayoutInflater.from((Context)this);
            n13 = R$layout.ucrop_controls;
            string2.inflate(n13, (ViewGroup)object, n12 != 0);
            this.y = object = new AutoTransition();
            long l10 = 50;
            ((Transition)object).setDuration(l10);
            n11 = R$id.state_aspect_ratio;
            object = (ViewGroup)this.findViewById(n11);
            this.o = object;
            string2 = this.D;
            object.setOnClickListener((View.OnClickListener)string2);
            n11 = R$id.state_rotate;
            object = (ViewGroup)this.findViewById(n11);
            this.p = object;
            string2 = this.D;
            object.setOnClickListener((View.OnClickListener)string2);
            n11 = R$id.state_scale;
            object = (ViewGroup)this.findViewById(n11);
            this.q = object;
            string2 = this.D;
            object.setOnClickListener((View.OnClickListener)string2);
            n11 = R$id.layout_aspect_ratio;
            object = (ViewGroup)this.findViewById(n11);
            this.r = object;
            n11 = R$id.layout_rotate_wheel;
            object = (ViewGroup)this.findViewById(n11);
            this.s = object;
            n11 = R$id.layout_scale_wheel;
            object = (ViewGroup)this.findViewById(n11);
            this.t = object;
            this.I(intent);
            this.J();
            this.K();
            this.L();
        }
    }

    public static /* synthetic */ void d(c c10, float f10) {
        c10.x(f10);
    }

    public static /* synthetic */ void f(c c10, float f10) {
        c10.D(f10);
    }

    public static /* synthetic */ UCropView h(c c10) {
        return c10.l;
    }

    public static /* synthetic */ View i(c c10) {
        return c10.x;
    }

    public static /* synthetic */ boolean j(c c10, boolean bl2) {
        c10.k = bl2;
        return bl2;
    }

    public static /* synthetic */ GestureCropImageView k(c c10) {
        return c10.m;
    }

    public static /* synthetic */ List l(c c10) {
        return c10.u;
    }

    public static /* synthetic */ void m(c c10) {
        c10.u();
    }

    public static /* synthetic */ void n(c c10, int n10) {
        c10.v(n10);
    }

    public static /* synthetic */ void o(c c10, int n10) {
        c10.G(n10);
    }

    private void p() {
        View view;
        View view2 = this.x;
        if (view2 == null) {
            this.x = view2 = new View((Context)this);
            int bl2 = -1;
            view2 = new RelativeLayout.LayoutParams(bl2, bl2);
            int n10 = R$id.toolbar;
            view2.addRule(3, n10);
            view = this.x;
            view.setLayoutParams((ViewGroup.LayoutParams)view2);
            view2 = this.x;
            boolean bl3 = true;
            view2.setClickable(bl3);
        }
        int n11 = R$id.ucrop_photobox;
        view2 = (RelativeLayout)this.findViewById(n11);
        view = this.x;
        view2.addView(view);
    }

    private void q(int n10) {
        int n11 = R$id.ucrop_photobox;
        ViewGroup viewGroup = (ViewGroup)this.findViewById(n11);
        Transition transition = this.y;
        TransitionManager.beginDelayedTransition(viewGroup, transition);
        viewGroup = this.q;
        int n12 = R$id.text_view_scale;
        viewGroup = viewGroup.findViewById(n12);
        n12 = R$id.state_scale;
        int n13 = 0;
        int n14 = 8;
        if (n10 == n12) {
            n12 = 0;
            transition = null;
        } else {
            n12 = n14;
        }
        viewGroup.setVisibility(n12);
        viewGroup = this.o;
        n12 = R$id.text_view_crop;
        viewGroup = viewGroup.findViewById(n12);
        n12 = R$id.state_aspect_ratio;
        if (n10 == n12) {
            n12 = 0;
            transition = null;
        } else {
            n12 = n14;
        }
        viewGroup.setVisibility(n12);
        viewGroup = this.p;
        n12 = R$id.text_view_rotate;
        viewGroup = viewGroup.findViewById(n12);
        n12 = R$id.state_rotate;
        if (n10 != n12) {
            n13 = n14;
        }
        viewGroup.setVisibility(n13);
    }

    private void s() {
        int n10 = R$id.ucrop;
        Object object = (UCropView)this.findViewById(n10);
        this.l = object;
        object = ((UCropView)((Object)object)).getCropImageView();
        this.m = object;
        object = this.l.getOverlayView();
        this.n = object;
        object = this.m;
        b$b b$b = this.C;
        ((b)object).setTransformImageListener(b$b);
        n10 = R$id.image_view_logo;
        object = (ImageView)this.findViewById(n10);
        int n11 = this.i;
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
        object.setColorFilter(n11, mode);
        n10 = R$id.ucrop_frame;
        b$b = this.findViewById(n10);
        int n12 = this.f;
        b$b.setBackgroundColor(n12);
        n11 = (int)(this.j ? 1 : 0);
        if (n11 == 0) {
            b$b = (RelativeLayout.LayoutParams)this.findViewById(n10).getLayoutParams();
            n12 = 0;
            mode = null;
            ((RelativeLayout.LayoutParams)b$b).bottomMargin = 0;
            object = this.findViewById(n10);
            object.requestLayout();
        }
    }

    private void t(Intent intent) {
        float f10;
        int n10;
        float f11;
        int n11;
        Object object = intent.getStringExtra("com.yalantis.ucrop.CompressionFormatName");
        int n12 = TextUtils.isEmpty((CharSequence)object);
        if (n12 == 0) {
            object = Bitmap.CompressFormat.valueOf((String)object);
        } else {
            n11 = 0;
            f11 = 0.0f;
            object = null;
        }
        if (object == null) {
            object = F;
        }
        this.z = object;
        f11 = 1.26E-43f;
        Object object2 = "com.yalantis.ucrop.CompressionQuality";
        this.A = n11 = intent.getIntExtra((String)object2, 90);
        object = intent.getIntArrayExtra("com.yalantis.ucrop.AllowedGestures");
        if (object != null && (n12 = ((Object)object).length) == (n10 = 3)) {
            this.B = (int[])object;
        }
        object = this.m;
        n10 = 0;
        n12 = intent.getIntExtra("com.yalantis.ucrop.MaxBitmapSize", 0);
        ((b)object).setMaxBitmapSize(n12);
        object = this.m;
        float f12 = intent.getFloatExtra("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f);
        ((a)object).setMaxScaleMultiplier(f12);
        object = this.m;
        long l10 = intent.getIntExtra("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500);
        ((a)object).setImageToWrapCropBoundsAnimDuration(l10);
        object = this.n;
        n12 = (int)(intent.getBooleanExtra("com.yalantis.ucrop.FreeStyleCrop", false) ? 1 : 0);
        ((OverlayView)((Object)object)).setFreestyleCropEnabled(n12 != 0);
        object = this.n;
        object2 = this.getResources();
        int n13 = R$color.ucrop_color_default_dimmed;
        n12 = object2.getColor(n13);
        n12 = intent.getIntExtra("com.yalantis.ucrop.DimmedLayerColor", n12);
        ((OverlayView)((Object)object)).setDimmedColor(n12);
        object = this.n;
        n12 = (int)(intent.getBooleanExtra("com.yalantis.ucrop.CircleDimmedLayer", false) ? 1 : 0);
        ((OverlayView)((Object)object)).setCircleDimmedLayer(n12 != 0);
        object = this.n;
        n13 = 1;
        n12 = intent.getBooleanExtra("com.yalantis.ucrop.ShowCropFrame", n13 != 0);
        ((OverlayView)((Object)object)).setShowCropFrame(n12 != 0);
        object = this.n;
        object2 = this.getResources();
        int n14 = R$color.ucrop_color_default_crop_frame;
        n12 = object2.getColor(n14);
        n12 = intent.getIntExtra("com.yalantis.ucrop.CropFrameColor", n12);
        ((OverlayView)((Object)object)).setCropFrameColor(n12);
        object = this.n;
        object2 = this.getResources();
        n14 = R$dimen.ucrop_default_crop_frame_stoke_width;
        n12 = object2.getDimensionPixelSize(n14);
        n12 = intent.getIntExtra("com.yalantis.ucrop.CropFrameStrokeWidth", n12);
        ((OverlayView)((Object)object)).setCropFrameStrokeWidth(n12);
        object = this.n;
        n12 = (int)(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropGrid", n13 != 0) ? 1 : 0);
        ((OverlayView)((Object)object)).setShowCropGrid(n12 != 0);
        object = this.n;
        n13 = 2;
        n12 = intent.getIntExtra("com.yalantis.ucrop.CropGridRowCount", n13);
        ((OverlayView)((Object)object)).setCropGridRowCount(n12);
        object = this.n;
        n12 = intent.getIntExtra("com.yalantis.ucrop.CropGridColumnCount", n13);
        ((OverlayView)((Object)object)).setCropGridColumnCount(n12);
        object = this.n;
        object2 = this.getResources();
        n13 = R$color.ucrop_color_default_crop_grid;
        n12 = object2.getColor(n13);
        n12 = intent.getIntExtra("com.yalantis.ucrop.CropGridColor", n12);
        ((OverlayView)((Object)object)).setCropGridColor(n12);
        object = this.n;
        object2 = this.getResources();
        n13 = R$dimen.ucrop_default_crop_grid_stoke_width;
        n12 = object2.getDimensionPixelSize(n13);
        n12 = intent.getIntExtra("com.yalantis.ucrop.CropGridStrokeWidth", n12);
        ((OverlayView)((Object)object)).setCropGridStrokeWidth(n12);
        object = "com.yalantis.ucrop.AspectRatioX";
        n12 = 0;
        f12 = 0.0f;
        object2 = null;
        f11 = intent.getFloatExtra((String)object, 0.0f);
        Object object3 = "com.yalantis.ucrop.AspectRatioY";
        float f13 = intent.getFloatExtra((String)object3, 0.0f);
        String string2 = "com.yalantis.ucrop.AspectRatioSelectedByDefault";
        n14 = intent.getIntExtra(string2, 0);
        ArrayList arrayList = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        float f14 = f11 - 0.0f;
        float f15 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (f15 > 0 && (f15 = (f10 = f13 - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) > 0) {
            object2 = this.o;
            if (object2 != null) {
                n14 = 8;
                object2.setVisibility(n14);
            }
            object2 = this.m;
            ((a)object2).setTargetAspectRatio(f11 /= f13);
        } else if (arrayList != null && n14 < (n11 = arrayList.size())) {
            object = this.m;
            object2 = (d.t.a.g.a)arrayList.get(n14);
            f12 = ((d.t.a.g.a)object2).b();
            object3 = (d.t.a.g.a)arrayList.get(n14);
            f13 = ((d.t.a.g.a)object3).c();
            ((a)object).setTargetAspectRatio(f12 /= f13);
        } else {
            object = this.m;
            ((a)object).setTargetAspectRatio(0.0f);
        }
        object = "com.yalantis.ucrop.MaxSizeX";
        n11 = intent.getIntExtra((String)object, 0);
        object2 = "com.yalantis.ucrop.MaxSizeY";
        int n15 = intent.getIntExtra((String)object2, 0);
        if (n11 > 0 && n15 > 0) {
            object2 = this.m;
            ((a)object2).setMaxResultImageSizeX(n11);
            object = this.m;
            ((a)object).setMaxResultImageSizeY(n15);
        }
    }

    private void u() {
        GestureCropImageView gestureCropImageView = this.m;
        float f10 = -gestureCropImageView.getCurrentAngle();
        gestureCropImageView.y(f10);
        this.m.A();
    }

    private void v(int n10) {
        GestureCropImageView gestureCropImageView = this.m;
        float f10 = n10;
        gestureCropImageView.y(f10);
        this.m.A();
    }

    private void w(int n10) {
        int n11;
        GestureCropImageView gestureCropImageView = this.m;
        int[] nArray = this.B;
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
        gestureCropImageView = this.m;
        nArray = this.B;
        n12 = nArray[n10];
        if (n12 == n14 || (n10 = nArray[n10]) == (n11 = 2)) {
            n13 = n15;
        }
        gestureCropImageView.setRotateEnabled(n13 != 0);
    }

    private void x(float f10) {
        TextView textView = this.v;
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

    private void y(int n10) {
        TextView textView = this.v;
        if (textView != null) {
            textView.setTextColor(n10);
        }
    }

    private void z(Intent object) {
        Object object2 = (Uri)object.getParcelableExtra("com.yalantis.ucrop.InputUri");
        Uri uri = (Uri)object.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        this.t((Intent)object);
        if (object2 != null && uri != null) {
            object = this.m;
            try {
                ((b)object).o((Uri)object2, uri);
            }
            catch (Exception exception) {
                this.B(exception);
                this.finish();
            }
        } else {
            int n10 = R$string.ucrop_error_input_data_is_absent;
            object2 = this.getString(n10);
            object = new NullPointerException((String)object2);
            this.B((Throwable)object);
            this.finish();
        }
    }

    public void B(Throwable throwable) {
        Intent intent = new Intent();
        throwable = intent.putExtra("com.yalantis.ucrop.Error", (Serializable)throwable);
        this.setResult(96, (Intent)throwable);
    }

    public void C(Uri uri, float f10, int n10, int n11, int n12, int n13) {
        Intent intent = new Intent();
        uri = intent.putExtra("com.yalantis.ucrop.OutputUri", (Parcelable)uri).putExtra("com.yalantis.ucrop.CropAspectRatio", f10).putExtra("com.yalantis.ucrop.ImageWidth", n12).putExtra("com.yalantis.ucrop.ImageHeight", n13).putExtra("com.yalantis.ucrop.OffsetX", n10).putExtra("com.yalantis.ucrop.OffsetY", n11);
        this.setResult(-1, (Intent)uri);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int n10 = R$layout.ucrop_activity_photobox;
        this.setContentView(n10);
        bundle = this.getIntent();
        this.M((Intent)bundle);
        this.z((Intent)bundle);
        this.A();
        this.p();
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        Object object;
        MenuInflater menuInflater = this.getMenuInflater();
        int n10 = R$menu.ucrop_menu_activity;
        menuInflater.inflate(n10, menu2);
        int n11 = R$id.menu_loader;
        menuInflater = menu2.findItem(n11);
        Drawable drawable2 = menuInflater.getIcon();
        int n12 = 1;
        if (drawable2 != null) {
            drawable2.mutate();
            int n13 = this.e;
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
            drawable2.setColorFilter(n13, mode);
            try {
                menuInflater.setIcon(drawable2);
            }
            catch (IllegalStateException illegalStateException) {
                n13 = 2;
                object = new Object[n13];
                mode = null;
                String string2 = illegalStateException.getMessage();
                object[0] = string2;
                n10 = R$string.ucrop_mutate_exception_hint;
                string2 = this.getString(n10);
                object[n12] = string2;
                string2 = String.format("%s - %s", (Object[])object);
                object = K;
                Log.i((String)object, (String)string2);
            }
            menuInflater = (Animatable)menuInflater.getIcon();
            menuInflater.start();
        }
        n11 = R$id.menu_crop;
        menu2 = menu2.findItem(n11);
        n11 = this.h;
        menuInflater = ContextCompat.getDrawable((Context)this, n11);
        if (menuInflater != null) {
            menuInflater.mutate();
            n10 = this.e;
            object = PorterDuff.Mode.SRC_ATOP;
            menuInflater.setColorFilter(n10, object);
            menu2.setIcon((Drawable)menuInflater);
        }
        return n12 != 0;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int n10 = menuItem.getItemId();
        int n11 = R$id.menu_crop;
        boolean bl2 = true;
        if (n10 == n11) {
            this.r();
            return bl2;
        }
        n10 = menuItem.getItemId();
        if (n10 == (n11 = 16908332)) {
            this.onBackPressed();
            return bl2;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onPrepareOptionsMenu(Menu menu2) {
        int n10 = R$id.menu_crop;
        MenuItem menuItem = menu2.findItem(n10);
        boolean bl2 = this.k ^ true;
        menuItem.setVisible(bl2);
        n10 = R$id.menu_loader;
        menuItem = menu2.findItem(n10);
        bl2 = this.k;
        menuItem.setVisible(bl2);
        return super.onPrepareOptionsMenu(menu2);
    }

    public void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.m;
        if (gestureCropImageView != null) {
            gestureCropImageView.u();
        }
    }

    public void r() {
        Object object = this.x;
        boolean bl2 = true;
        object.setClickable(bl2);
        this.k = bl2;
        this.supportInvalidateOptionsMenu();
        object = this.m;
        Bitmap.CompressFormat compressFormat = this.z;
        int n10 = this.A;
        c$h c$h = new c$h(this);
        ((a)object).v(compressFormat, n10, c$h);
    }
}

