/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath;
import org.xmlpull.v1.XmlPullParser;

public class VectorDrawableCompat$VClipPath
extends VectorDrawableCompat$VPath {
    public VectorDrawableCompat$VClipPath() {
    }

    public VectorDrawableCompat$VClipPath(VectorDrawableCompat$VClipPath vectorDrawableCompat$VClipPath) {
        super(vectorDrawableCompat$VClipPath);
    }

    private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
        int n10;
        int n11;
        PathParser$PathDataNode[] pathParser$PathDataNodeArray = typedArray.getString(0);
        if (pathParser$PathDataNodeArray != null) {
            this.mPathName = pathParser$PathDataNodeArray;
        }
        if ((pathParser$PathDataNodeArray = typedArray.getString(n11 = 1)) != null) {
            pathParser$PathDataNodeArray = PathParser.createNodesFromPathData((String)pathParser$PathDataNodeArray);
            this.mNodes = pathParser$PathDataNodeArray;
        }
        this.mFillRule = n10 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 2, 0);
    }

    public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        Object object = "pathData";
        boolean bl2 = TypedArrayUtils.hasAttribute(xmlPullParser, (String)object);
        if (!bl2) {
            return;
        }
        object = AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH;
        resources = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, (int[])object);
        this.updateStateFromTypedArray((TypedArray)resources, xmlPullParser);
        resources.recycle();
    }

    public boolean isClipPath() {
        return true;
    }
}

