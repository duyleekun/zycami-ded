/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.util.Log
 */
package d.m.a.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.meishe.cafconvertor.webpcoder.FrameSequence;
import com.meishe.cafconvertor.webpcoder.FrameSequence$a;
import com.meishe.cafconvertor.webpcoder.WebpImageView$b;
import d.m.a.g.a$e;
import d.m.a.g.d$a;
import d.m.a.g.d$b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class d
implements WebpImageView$b {
    private static final String g = "d";
    private static d h;
    private Context a;
    public int b = -1;
    private FrameSequence c;
    private FrameSequence$a d;
    private d$a e;
    private d$b f;

    private d(Context context) {
        this.a = context;
    }

    private static Bitmap b(a$e object, int n10, int n11) {
        Bitmap.Config config;
        Bitmap.Config config2;
        int n12 = (object = object.a(n10, n11)).getWidth();
        if (n12 >= n10 && (n10 = object.getHeight()) >= n11 && (config2 = object.getConfig()) == (config = Bitmap.Config.ARGB_8888)) {
            return object;
        }
        object = new IllegalArgumentException("Invalid bitmap provided");
        throw object;
    }

    private byte[] d(InputStream inputStream) {
        int n10;
        int n11;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n12 = 4096;
        byte[] byArray = new byte[n12];
        while ((n11 = -1) != (n10 = inputStream.read(byArray))) {
            n11 = 0;
            byteArrayOutputStream.write(byArray, 0, n10);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d e(Context context) {
        Object object = h;
        if (object != null) return h;
        object = d.class;
        synchronized (object) {
            d d10 = h;
            if (d10 != null) return h;
            h = d10 = new d(context);
            return h;
        }
    }

    public void a(int n10, Bitmap bitmap, long l10) {
        d$b d$b = this.f;
        if (d$b != null) {
            d$b.a(n10, bitmap, l10);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(InputStream inputStream) {
        Throwable throwable2222222;
        String string2;
        block12: {
            String string3;
            Object object;
            Object object2;
            block13: {
                int n10;
                int n11;
                string2 = "io not closed in right way : ";
                object2 = this.d(inputStream);
                object2 = FrameSequence.d((byte[])object2);
                int n12 = 1;
                ((FrameSequence)object2).l(n12);
                this.c = object2;
                this.d = object2 = ((FrameSequence)object2).b();
                object2 = this.c;
                this.b = n11 = ((FrameSequence)object2).h();
                this.e = object2 = new d$a();
                object2 = this.c;
                n11 = ((FrameSequence)object2).j();
                object = this.c;
                n12 = ((FrameSequence)object).i();
                Object var8_16 = null;
                for (int i10 = 0; i10 < (n10 = this.b); ++i10) {
                    d$b d$b;
                    long l10;
                    int n13;
                    d$a d$a = this.e;
                    FrameSequence$a frameSequence$a = this.d;
                    long l11 = frameSequence$a.b(i10, (Bitmap)(d$a = d.m.a.g.d.b(d$a, n11, n12)), n13 = i10 + -2);
                    long l12 = l11 - (l10 = (long)20);
                    Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object3 < 0) {
                        l11 = 100;
                    }
                    if ((d$b = this.f) == null) continue;
                    d$b.a(i10, (Bitmap)d$a, l11);
                }
                if (inputStream == null) return;
                {
                    catch (Throwable throwable2222222) {
                        break block12;
                    }
                    catch (Exception exception) {}
                    {
                        object = g;
                        StringBuilder stringBuilder = new StringBuilder();
                        String string4 = "error happens when FrameSequence.decodeByteArray";
                        stringBuilder.append(string4);
                        object2 = exception.getMessage();
                        stringBuilder.append((String)object2);
                        object2 = stringBuilder.toString();
                        Log.e((String)object, (String)object2);
                        if (inputStream == null) return;
                    }
                    try {
                        inputStream.close();
                        return;
                    }
                    catch (IOException iOException) {
                        object2 = g;
                        object = new StringBuilder();
                        break block13;
                    }
                }
                try {
                    inputStream.close();
                    return;
                }
                catch (IOException iOException) {
                    object2 = g;
                    object = new StringBuilder();
                }
            }
            ((StringBuilder)object).append(string2);
            string3 = ((Throwable)((Object)string3)).getMessage();
            ((StringBuilder)object).append(string3);
            string3 = ((StringBuilder)object).toString();
            Log.e((String)object2, (String)string3);
            return;
        }
        if (inputStream == null) throw throwable2222222;
        try {
            inputStream.close();
            throw throwable2222222;
        }
        catch (IOException iOException) {
            String string5 = g;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            String string6 = iOException.getMessage();
            stringBuilder.append(string6);
            string6 = stringBuilder.toString();
            Log.e((String)string5, (String)string6);
        }
        throw throwable2222222;
    }

    public void f(d$b d$b) {
        this.f = d$b;
    }

    public void g(InputStream inputStream) {
        this.c(inputStream);
    }
}

