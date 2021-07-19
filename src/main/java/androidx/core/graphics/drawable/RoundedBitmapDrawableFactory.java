/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable21;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable;
import java.io.InputStream;

public final class RoundedBitmapDrawableFactory {
    private static final String TAG = "RoundedBitmapDrawableFa";

    private RoundedBitmapDrawableFactory() {
    }

    public static RoundedBitmapDrawable create(Resources resources, Bitmap bitmap) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            RoundedBitmapDrawable21 roundedBitmapDrawable21 = new RoundedBitmapDrawable21(resources, bitmap);
            return roundedBitmapDrawable21;
        }
        RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable roundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable = new RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable(resources, bitmap);
        return roundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable;
    }

    public static RoundedBitmapDrawable create(Resources object, InputStream object2) {
        Object object3 = BitmapFactory.decodeStream((InputStream)object2);
        if ((object3 = ((RoundedBitmapDrawable)((Object)(object = RoundedBitmapDrawableFactory.create((Resources)object, (Bitmap)object3)))).getBitmap()) == null) {
            object3 = new StringBuilder();
            String string2 = "RoundedBitmapDrawable cannot decode ";
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(object2);
            object2 = ((StringBuilder)object3).toString();
            object3 = TAG;
            Log.w((String)object3, (String)object2);
        }
        return object;
    }

    public static RoundedBitmapDrawable create(Resources object, String string2) {
        Object object2 = BitmapFactory.decodeFile((String)string2);
        if ((object2 = ((RoundedBitmapDrawable)((Object)(object = RoundedBitmapDrawableFactory.create((Resources)object, (Bitmap)object2)))).getBitmap()) == null) {
            object2 = new StringBuilder();
            String string3 = "RoundedBitmapDrawable cannot decode ";
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
            object2 = TAG;
            Log.w((String)object2, (String)string2);
        }
        return object;
    }
}

