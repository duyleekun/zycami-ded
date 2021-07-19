/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.util.DisplayMetrics
 *  android.view.Window
 */
package d.m.a.g;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import com.meishe.cafconvertor.R$id;
import com.meishe.cafconvertor.R$layout;
import com.meishe.cafconvertor.webpcoder.WebpImageView;
import com.meishe.cafconvertor.webpcoder.WebpImageView$b;
import d.m.a.g.b;
import java.io.InputStream;

public class c
extends Activity {
    private WebpImageView a;
    private String b;
    private int c;

    public c() {
        String string2;
        this.b = string2 = c.class.getSimpleName();
        this.c = -1;
    }

    private static int a(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private static int b(Context context) {
        int n10;
        String string2;
        String string3;
        String string4;
        int n11 = (context = context.getResources()).getIdentifier(string4 = "status_bar_height", string3 = "dimen", string2 = "android");
        if (n11 > 0) {
            n10 = context.getDimensionPixelSize(n11);
        } else {
            n10 = 0;
            context = null;
        }
        return n10;
    }

    public void c(InputStream inputStream) {
        this.a.f(inputStream, 1);
        this.a.g();
    }

    public int d() {
        WebpImageView webpImageView = this.a;
        if (webpImageView != null) {
            return webpImageView.getCount();
        }
        return -1;
    }

    public void e(WebpImageView$b webpImageView$b) {
        WebpImageView webpImageView = this.a;
        if (webpImageView != null) {
            webpImageView.setOnWebpFrameCallback(webpImageView$b);
        }
    }

    public void onCreate(Bundle object) {
        super.onCreate(object);
        d.m.a.g.b.a = this;
        int n10 = d.m.a.g.c.a(this);
        int n11 = d.m.a.g.c.b((Context)this);
        Window window = this.getWindow();
        int n12 = -1;
        if ((n10 -= n11) == 0) {
            n10 = n12;
        }
        window.setLayout(n12, n10);
        n10 = R$layout.activity_nvs_decoder;
        this.setContentView(n10);
        n10 = R$id.webp_image_view;
        object = (WebpImageView)this.findViewById(n10);
        this.a = object;
    }

    public void onDestroy() {
        super.onDestroy();
        this.a.c();
    }
}

