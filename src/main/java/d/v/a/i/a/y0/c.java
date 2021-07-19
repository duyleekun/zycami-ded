/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.Button
 */
package d.v.a.i.a.y0;

import android.widget.Button;
import com.zhiyun.account.R$string;

public class c
implements Runnable {
    private Button a;
    private final int b;

    public c(Button button, int n10) {
        this.a = button;
        this.b = n10;
    }

    public void a() {
        this.b();
        Button button = this.a;
        Object object = this.b + 1;
        button.setTag(object);
        this.a.setEnabled(false);
        button = this.a;
        object = new StringBuilder();
        int n10 = this.b;
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" s");
        object = ((StringBuilder)object).toString();
        button.setText((CharSequence)object);
        this.a.post((Runnable)this);
    }

    public void b() {
        this.a.setEnabled(true);
        Button button = this.a;
        int n10 = R$string.me_get_code;
        button.setText(n10);
        this.a.removeCallbacks((Runnable)this);
    }

    public void run() {
        Object object = (Integer)this.a.getTag();
        int n10 = (Integer)object + -1;
        if (n10 <= 0) {
            this.a.setEnabled(true);
            object = this.a;
            int n11 = R$string.me_get_code;
            object.setText(n11);
        } else {
            Button button = this.a;
            Comparable<Integer> comparable = n10;
            button.setTag((Object)comparable);
            this.a.setEnabled(false);
            button = this.a;
            comparable = new Comparable<Integer>();
            ((StringBuilder)comparable).append(n10);
            ((StringBuilder)comparable).append(" s");
            object = ((StringBuilder)comparable).toString();
            button.setText((CharSequence)object);
            object = this.a;
            long l10 = 1000L;
            object.postDelayed((Runnable)this, l10);
        }
    }
}

