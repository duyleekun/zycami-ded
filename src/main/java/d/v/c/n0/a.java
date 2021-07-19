/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.n0;

import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.zhiyun.image.Images;
import com.zhiyun.protocol.constants.WorkingMode;
import d.v.c.s0.q6;
import java.util.Optional;

public class a {
    public static void a(ImageView imageView, WorkingMode object) {
        object = Optional.ofNullable(object);
        WorkingMode workingMode = WorkingMode.PF;
        int n10 = q6.e(((Optional)object).orElse(workingMode));
        imageView.setImageResource(n10);
    }

    public static void b(ImageView imageView, Animation animation) {
        if (animation != null) {
            imageView.startAnimation(animation);
            boolean bl2 = false;
            animation = null;
            imageView.setVisibility(0);
        } else {
            imageView.clearAnimation();
            int n10 = 4;
            imageView.setVisibility(n10);
        }
    }

    public static void c(TextView textView, boolean bl2) {
        if (!bl2) {
            bl2 = false;
            textView.setTypeface(null);
        }
    }

    public static void d(ImageView imageView, boolean bl2) {
        imageView.setEnabled(bl2);
    }

    public static void e(ImageView imageView, String string2) {
        Images.F(imageView, string2, 16, 2131232189);
    }

    public static void f(ImageView imageView, int n10) {
        imageView.setImageResource(n10);
    }

    public static void g(ImageView imageView, String string2) {
        Images.H(imageView, string2, 8, 2131231494);
    }
}

