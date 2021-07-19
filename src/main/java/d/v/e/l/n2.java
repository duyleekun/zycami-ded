/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.Toast
 */
package d.v.e.l;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.zhiyun.common.R$drawable;
import com.zhiyun.common.widget.RotateTextView;
import d.v.e.f;
import d.v.e.l.h2;
import d.v.e.l.o1;

public final class n2 {
    private static Toast a;
    private static Toast b;
    private static ImageView c;
    private static Toast d;

    private n2() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    private static void a(int n10, String string2) {
        Toast toast = a;
        if (toast == null) {
            Toast toast2;
            a = toast2 = Toast.makeText((Context)f.a().b(), (CharSequence)string2, (int)n10);
            int n11 = 17;
            toast = null;
            toast2.setGravity(n11, 0, 0);
            toast2 = a;
            toast2.show();
        } else {
            toast.setText((CharSequence)string2);
            string2 = a;
            string2.setDuration(n10);
            Toast toast3 = a;
            toast3.show();
        }
    }

    public static void b(Context context, int n10, int n11) {
        n2.g(o1.L(context, n10), n11, 0);
    }

    public static void c(View view, int n10, int n11) {
        n2.b(view.getContext(), n10, n11);
    }

    public static void d(Fragment fragment, int n10, int n11) {
        n2.b(fragment.requireContext(), n10, n11);
    }

    public static void e(String string2) {
        Toast toast = a;
        if (toast == null) {
            toast = f.a().b();
            TextView textView = new TextView((Context)toast);
            textView.setText((CharSequence)string2);
            Configuration configuration = toast.getResources().getConfiguration();
            float f10 = configuration.fontScale;
            float f11 = 14.0f / f10;
            textView.setTextSize(f11);
            textView.setTextColor(-1);
            f11 = 280.0f;
            int n10 = h2.b(f11);
            textView.setMaxWidth(n10);
            n10 = R$drawable.shape_rectangle_toast;
            textView.setBackgroundResource(n10);
            string2 = new Toast((Context)toast);
            a = string2;
            string2.setView((View)textView);
            string2 = a;
            toast = null;
            string2.setDuration(0);
            string2 = a;
            int n11 = 17;
            string2.setGravity(n11, 0, 0);
            string2 = a;
            string2.show();
        } else {
            boolean bl2 = (toast = toast.getView()) instanceof TextView;
            if (bl2) {
                Toast toast2 = toast;
                toast2 = (TextView)toast;
                toast2.setText((CharSequence)string2);
                a.setView((View)toast);
                string2 = a;
                string2.show();
            }
        }
    }

    public static void f(String string2, int n10) {
        Toast toast = b;
        if (toast == null) {
            toast = f.a().b();
            RotateTextView rotateTextView = new RotateTextView((Context)toast);
            rotateTextView.setText(string2);
            Configuration configuration = toast.getResources().getConfiguration();
            float f10 = configuration.fontScale;
            float f11 = 14.0f / f10;
            rotateTextView.setTextSize(f11);
            rotateTextView.setTextColor(-1);
            f11 = 280.0f;
            int n11 = h2.b(f11);
            rotateTextView.setMaxWidth(n11);
            n11 = R$drawable.shape_rectangle_toast;
            rotateTextView.setBackgroundResource(n11);
            rotateTextView.setDirection(n10);
            string2 = new Toast((Context)toast);
            b = string2;
            string2.setView((View)rotateTextView);
            string2 = b;
            n10 = 0;
            string2.setDuration(0);
            string2 = b;
            int n12 = 17;
            string2.setGravity(n12, 0, 0);
            string2 = b;
            string2.show();
        } else {
            boolean bl2 = (toast = toast.getView()) instanceof RotateTextView;
            if (bl2) {
                Object object = toast;
                object = (RotateTextView)toast;
                object.setText((CharSequence)string2);
                ((RotateTextView)object).setDirection(n10);
                b.setView((View)toast);
                string2 = b;
                string2.show();
            }
        }
    }

    public static void g(String string2, int n10, int n11) {
        Application application = f.a().b();
        RotateTextView rotateTextView = new RotateTextView((Context)application);
        rotateTextView.setText(string2);
        rotateTextView.setTextColor(-1);
        int n12 = R$drawable.shape_rectangle_dark_gray_16_corner;
        rotateTextView.setBackgroundResource(n12);
        rotateTextView.setDirection(n10);
        if (n11 != 0) {
            rotateTextView.setLeftCompoundDrawables(n11);
        }
        string2 = new Toast((Context)application);
        string2.setView((View)rotateTextView);
        string2.setDuration(0);
        n11 = -30;
        int n13 = 300;
        if (n10 == 0) {
            n10 = 0x800005;
            string2.setGravity(n10, n13, n11);
        } else {
            int n14 = 1;
            int n15 = 100;
            int n16 = 30;
            if (n10 == n14) {
                n10 = 48;
                string2.setGravity(n10, n16, n15);
            } else {
                n14 = 2;
                if (n10 == n14) {
                    n10 = 0x800003;
                    string2.setGravity(n10, n13, n11);
                } else {
                    n10 = 80;
                    string2.setGravity(n10, n16, n15);
                }
            }
        }
        string2.show();
    }

    public static void h(String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            Toast toast = a;
            if (toast != null) {
                toast.cancel();
                n10 = 0;
                toast = null;
                a = null;
            }
            toast = f.a().c();
            string2 = Toast.makeText((Context)toast, (CharSequence)string2, (int)0);
            a = string2;
            string2.show();
        } else {
            Toast toast = a;
            if (toast == null) {
                toast = f.a().c();
                string2 = Toast.makeText((Context)toast, (CharSequence)string2, (int)0);
                a = string2;
            } else {
                toast.setText((CharSequence)string2);
            }
            string2 = a;
            string2.show();
        }
    }

    public static void i(int n10, String string2) {
        Application application = f.a().b();
        int n11 = Build.VERSION.SDK_INT;
        float f10 = 16.0f;
        int n12 = 17;
        int n13 = 28;
        if (n11 >= n13) {
            ImageView imageView;
            string2 = Toast.makeText((Context)application, (CharSequence)string2, (int)0);
            string2.setGravity(n12, 0, 0);
            LinearLayout linearLayout = (LinearLayout)string2.getView();
            c = imageView = new ImageView((Context)application);
            int n14 = h2.b(f10);
            imageView.setPadding(0, n14, 0, 0);
            application = c;
            application.setImageResource(n10);
            ImageView imageView2 = c;
            linearLayout.addView((View)imageView2, 0);
            string2.show();
        } else {
            Toast toast;
            Toast toast2 = d;
            if (toast2 == null) {
                string2 = Toast.makeText((Context)application, (CharSequence)string2, (int)0);
                d = string2;
                string2.setGravity(n12, 0, 0);
                string2 = (LinearLayout)d.getView();
                toast2 = new ImageView((Context)application);
                c = toast2;
                int n15 = h2.b(f10);
                toast2.setPadding(0, n15, 0, 0);
                application = c;
                application.setImageResource(n10);
                toast = c;
                string2.addView((View)toast, 0);
            } else {
                toast2.setText((CharSequence)string2);
                string2 = c;
                string2.setImageResource(n10);
            }
            toast = d;
            toast.show();
        }
    }
}

