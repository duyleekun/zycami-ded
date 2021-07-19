/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapShader
 *  android.graphics.ColorFilter
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.AnimationDrawable
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.ClipDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.ShapeDrawable
 *  android.graphics.drawable.shapes.RoundRectShape
 *  android.graphics.drawable.shapes.Shape
 *  android.util.AttributeSet
 *  android.widget.ProgressBar
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.WrappedDrawable;

public class AppCompatProgressBarHelper {
    private static final int[] TINT_ATTRS;
    private Bitmap mSampleTile;
    private final ProgressBar mView;

    static {
        int[] nArray = new int[]{16843067, 16843068};
        TINT_ATTRS = nArray;
    }

    public AppCompatProgressBarHelper(ProgressBar progressBar) {
        this.mView = progressBar;
    }

    private Shape getDrawableShape() {
        float[] fArray;
        float[] fArray2 = fArray = new float[8];
        float[] fArray3 = fArray;
        fArray2[0] = 5.0f;
        fArray3[1] = 5.0f;
        fArray2[2] = 5.0f;
        fArray3[3] = 5.0f;
        fArray2[4] = 5.0f;
        fArray3[5] = 5.0f;
        fArray2[6] = 5.0f;
        fArray3[7] = 5.0f;
        RoundRectShape roundRectShape = new RoundRectShape(fArray, null, null);
        return roundRectShape;
    }

    private Drawable tileify(Drawable drawable2, boolean n10) {
        int n11 = drawable2 instanceof WrappedDrawable;
        if (n11 != 0) {
            Object object = drawable2;
            object = (WrappedDrawable)drawable2;
            Drawable drawable3 = object.getWrappedDrawable();
            if (drawable3 != null) {
                Drawable drawable4 = this.tileify(drawable3, n10 != 0);
                object.setWrappedDrawable(drawable4);
            }
        } else {
            n11 = drawable2 instanceof LayerDrawable;
            int n12 = 1;
            if (n11 != 0) {
                drawable2 = (LayerDrawable)drawable2;
                n10 = drawable2.getNumberOfLayers();
                Drawable[] drawableArray = new Drawable[n10];
                int n13 = 0;
                Object var9_12 = null;
                Object var11_15 = null;
                for (int i10 = 0; i10 < n10; ++i10) {
                    Drawable drawable5;
                    int n14 = drawable2.getId(i10);
                    Drawable drawable6 = drawable2.getDrawable(i10);
                    int n15 = 16908301;
                    if (n14 != n15 && n14 != (n15 = 16908303)) {
                        n14 = 0;
                        drawable5 = null;
                    } else {
                        n14 = n12;
                    }
                    drawableArray[i10] = drawable5 = this.tileify(drawable6, n14 != 0);
                }
                LayerDrawable layerDrawable = new LayerDrawable(drawableArray);
                while (n13 < n10) {
                    n11 = drawable2.getId(n13);
                    layerDrawable.setId(n13, n11);
                    ++n13;
                }
                return layerDrawable;
            }
            n11 = drawable2 instanceof BitmapDrawable;
            if (n11 != 0) {
                drawable2 = (BitmapDrawable)drawable2;
                Bitmap bitmap = drawable2.getBitmap();
                Bitmap bitmap2 = this.mSampleTile;
                if (bitmap2 == null) {
                    this.mSampleTile = bitmap;
                }
                Shape shape = this.getDrawableShape();
                bitmap2 = new ShapeDrawable(shape);
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
                shape = new BitmapShader(bitmap, tileMode, tileMode2);
                bitmap2.getPaint().setShader((Shader)shape);
                bitmap = bitmap2.getPaint();
                drawable2 = drawable2.getPaint().getColorFilter();
                bitmap.setColorFilter((ColorFilter)drawable2);
                if (n10) {
                    n10 = 3;
                    drawable2 = new ClipDrawable((Drawable)bitmap2, n10, n12);
                    bitmap2 = drawable2;
                }
                return bitmap2;
            }
        }
        return drawable2;
    }

    private Drawable tileifyIndeterminate(Drawable drawable2) {
        int n10 = drawable2 instanceof AnimationDrawable;
        if (n10 != 0) {
            int n11;
            drawable2 = (AnimationDrawable)drawable2;
            n10 = drawable2.getNumberOfFrames();
            AnimationDrawable animationDrawable = new AnimationDrawable();
            int n12 = drawable2.isOneShot();
            animationDrawable.setOneShot(n12 != 0);
            n12 = 0;
            while (true) {
                n11 = 10000;
                if (n12 >= n10) break;
                Drawable drawable3 = drawable2.getFrame(n12);
                boolean bl2 = true;
                drawable3 = this.tileify(drawable3, bl2);
                drawable3.setLevel(n11);
                n11 = drawable2.getDuration(n12);
                animationDrawable.addFrame(drawable3, n11);
                ++n12;
            }
            animationDrawable.setLevel(n11);
            drawable2 = animationDrawable;
        }
        return drawable2;
    }

    public Bitmap getSampleTile() {
        return this.mSampleTile;
    }

    public void loadFromAttributes(AttributeSet object, int n10) {
        int[] nArray;
        Context context = this.mView.getContext();
        object = TintTypedArray.obtainStyledAttributes(context, (AttributeSet)object, nArray = TINT_ATTRS, n10, 0);
        Drawable drawable2 = ((TintTypedArray)object).getDrawableIfKnown(0);
        if (drawable2 != null) {
            context = this.mView;
            drawable2 = this.tileifyIndeterminate(drawable2);
            context.setIndeterminateDrawable(drawable2);
        }
        if ((drawable2 = ((TintTypedArray)object).getDrawableIfKnown(n10 = 1)) != null) {
            context = this.mView;
            drawable2 = this.tileify(drawable2, false);
            context.setProgressDrawable(drawable2);
        }
        ((TintTypedArray)object).recycle();
    }
}

