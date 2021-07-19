/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.ColorSpace
 *  android.graphics.ColorSpace$Named
 *  android.graphics.ImageDecoder
 *  android.graphics.ImageDecoder$ImageInfo
 *  android.graphics.ImageDecoder$OnHeaderDecodedListener
 *  android.graphics.ImageDecoder$OnPartialImageListener
 *  android.graphics.ImageDecoder$Source
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package d.c.a.o.m;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import d.c.a.o.m.a;
import d.c.a.o.m.a$a$a;

public class a$a
implements ImageDecoder.OnHeaderDecodedListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ DecodeFormat d;
    public final /* synthetic */ DownsampleStrategy e;
    public final /* synthetic */ PreferredColorSpace f;
    public final /* synthetic */ a g;

    public a$a(a a10, int n10, int n11, boolean bl2, DecodeFormat decodeFormat, DownsampleStrategy downsampleStrategy, PreferredColorSpace preferredColorSpace) {
        this.g = a10;
        this.a = n10;
        this.b = n11;
        this.c = bl2;
        this.d = decodeFormat;
        this.e = downsampleStrategy;
        this.f = preferredColorSpace;
    }

    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source object) {
        int n10;
        object = this.g.a;
        int n11 = this.a;
        int n12 = this.b;
        int n13 = this.c;
        int n14 = 0;
        int n15 = object.c(n11, n12, n13 != 0, false);
        n11 = 1;
        if (n15 != 0) {
            n15 = 3;
            imageDecoder.setAllocator(n15);
        } else {
            imageDecoder.setAllocator(n11);
        }
        object = this.d;
        Enum enum_ = DecodeFormat.PREFER_RGB_565;
        if (object == enum_) {
            imageDecoder.setMemorySizePolicy(0);
        }
        object = new a$a$a(this);
        imageDecoder.setOnPartialImageListener((ImageDecoder.OnPartialImageListener)object);
        object = imageInfo.getSize();
        n12 = this.a;
        n13 = -1 << -1;
        float f10 = -0.0f;
        if (n12 == n13) {
            n12 = object.getWidth();
        }
        if ((n10 = this.b) == n13) {
            n10 = object.getHeight();
        }
        DownsampleStrategy downsampleStrategy = this.e;
        int n16 = object.getWidth();
        int n17 = object.getHeight();
        float f11 = downsampleStrategy.b(n16, n17, n12, n10);
        f10 = (float)object.getWidth() * f11;
        n13 = Math.round(f10);
        float f12 = (float)object.getHeight() * f11;
        n10 = Math.round(f12);
        String string2 = "ImageDecoder";
        n16 = (int)(Log.isLoggable((String)string2, (int)2) ? 1 : 0);
        if (n16 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Resizing from [");
            int n18 = object.getWidth();
            stringBuilder.append(n18);
            String string3 = "x";
            stringBuilder.append(string3);
            n15 = object.getHeight();
            stringBuilder.append(n15);
            stringBuilder.append("] to [");
            stringBuilder.append(n13);
            stringBuilder.append(string3);
            stringBuilder.append(n10);
            stringBuilder.append("] scaleFactor: ");
            stringBuilder.append(f11);
            object = stringBuilder.toString();
            Log.v((String)string2, (String)object);
        }
        imageDecoder.setTargetSize(n13, n10);
        n15 = Build.VERSION.SDK_INT;
        n12 = 28;
        f11 = 3.9E-44f;
        if (n15 >= n12) {
            boolean bl2;
            object = this.f;
            enum_ = PreferredColorSpace.DISPLAY_P3;
            if (object == enum_ && (object = imageInfo.getColorSpace()) != null && (bl2 = (imageInfo = imageInfo.getColorSpace()).isWideGamut())) {
                n14 = n11;
            }
            imageInfo = n14 != 0 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB;
            imageInfo = ColorSpace.get((ColorSpace.Named)imageInfo);
            imageDecoder.setTargetColorSpace((ColorSpace)imageInfo);
        } else {
            int n19 = 26;
            if (n15 >= n19) {
                imageInfo = ColorSpace.get((ColorSpace.Named)ColorSpace.Named.SRGB);
                imageDecoder.setTargetColorSpace((ColorSpace)imageInfo);
            }
        }
    }
}

