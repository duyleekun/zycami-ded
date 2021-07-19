/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.R$styleable;
import org.xmlpull.v1.XmlPullParser;

public class StateSet$Variant {
    public int mConstraintID;
    public int mId;
    public boolean mIsLayout;
    public float mMaxHeight;
    public float mMaxWidth;
    public float mMinHeight;
    public float mMinWidth;

    public StateSet$Variant(Context context, XmlPullParser xmlPullParser) {
        float f10;
        this.mMinWidth = f10 = 0.0f / 0.0f;
        this.mMinHeight = f10;
        this.mMaxWidth = f10;
        this.mMaxHeight = f10;
        this.mConstraintID = -1;
        f10 = 0.0f;
        this.mIsLayout = false;
        xmlPullParser = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
        int[] nArray = R$styleable.Variant;
        xmlPullParser = context.obtainStyledAttributes((AttributeSet)xmlPullParser, nArray);
        int n10 = xmlPullParser.getIndexCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            float f11;
            float f12;
            Object object;
            Object object2;
            int n11;
            int n12 = xmlPullParser.getIndex(i10);
            if (n12 == (n11 = R$styleable.Variant_constraints)) {
                n11 = this.mConstraintID;
                this.mConstraintID = n12 = xmlPullParser.getResourceId(n12, n11);
                object2 = context.getResources();
                n11 = this.mConstraintID;
                object2 = object2.getResourceTypeName(n11);
                object = context.getResources();
                int n13 = this.mConstraintID;
                object.getResourceName(n13);
                object = "layout";
                n12 = (int)(((String)object).equals(object2) ? 1 : 0);
                if (n12 == 0) continue;
                n12 = 1;
                f12 = Float.MIN_VALUE;
                this.mIsLayout = n12;
                continue;
            }
            n11 = R$styleable.Variant_region_heightLessThan;
            if (n12 == n11) {
                f11 = this.mMaxHeight;
                this.mMaxHeight = f12 = xmlPullParser.getDimension(n12, f11);
                continue;
            }
            n11 = R$styleable.Variant_region_heightMoreThan;
            if (n12 == n11) {
                f11 = this.mMinHeight;
                this.mMinHeight = f12 = xmlPullParser.getDimension(n12, f11);
                continue;
            }
            n11 = R$styleable.Variant_region_widthLessThan;
            if (n12 == n11) {
                f11 = this.mMaxWidth;
                this.mMaxWidth = f12 = xmlPullParser.getDimension(n12, f11);
                continue;
            }
            n11 = R$styleable.Variant_region_widthMoreThan;
            if (n12 == n11) {
                f11 = this.mMinWidth;
                this.mMinWidth = f12 = xmlPullParser.getDimension(n12, f11);
                continue;
            }
            object2 = "ConstraintLayoutStates";
            object = "Unknown tag";
            Log.v((String)object2, (String)object);
        }
        xmlPullParser.recycle();
    }

    public boolean match(float f10, float f11) {
        float f12;
        float f13;
        int n10;
        float f14;
        float f15;
        float f16 = this.mMinWidth;
        int n11 = Float.isNaN(f16);
        if (n11 == 0 && (n11 = (f15 = f10 - (f16 = this.mMinWidth)) == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1)) < 0) {
            return false;
        }
        f16 = this.mMinHeight;
        n11 = Float.isNaN(f16);
        if (n11 == 0 && (n11 = (int)((f14 = f11 - (f16 = this.mMinHeight)) == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1))) < 0) {
            return false;
        }
        f16 = this.mMaxWidth;
        n11 = (int)(Float.isNaN(f16) ? 1 : 0);
        if (n11 == 0 && (n10 = (f13 = f10 - (f16 = this.mMaxWidth)) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) > 0) {
            return false;
        }
        f10 = this.mMaxHeight;
        n10 = Float.isNaN(f10);
        return n10 != 0 || (n10 = (int)((f12 = f11 - (f10 = this.mMaxHeight)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) <= 0;
    }
}

