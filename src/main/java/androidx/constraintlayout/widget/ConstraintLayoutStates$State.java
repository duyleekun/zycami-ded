/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayoutStates$Variant;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintLayoutStates$State {
    public int mConstraintID;
    public ConstraintSet mConstraintSet;
    public int mId;
    public ArrayList mVariants;

    public ConstraintLayoutStates$State(Context context, XmlPullParser xmlPullParser) {
        Object object = new ArrayList();
        this.mVariants = object;
        this.mConstraintID = -1;
        xmlPullParser = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
        object = R$styleable.State;
        xmlPullParser = context.obtainStyledAttributes((AttributeSet)xmlPullParser, (int[])object);
        int n10 = xmlPullParser.getIndexCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            int n12 = xmlPullParser.getIndex(i10);
            if (n12 == (n11 = R$styleable.State_android_id)) {
                n11 = this.mId;
                this.mId = n12 = xmlPullParser.getResourceId(n12, n11);
                continue;
            }
            n11 = R$styleable.State_constraints;
            if (n12 != n11) continue;
            n11 = this.mConstraintID;
            this.mConstraintID = n12 = xmlPullParser.getResourceId(n12, n11);
            Object object2 = context.getResources();
            n11 = this.mConstraintID;
            object2 = object2.getResourceTypeName(n11);
            Object object3 = context.getResources();
            int n13 = this.mConstraintID;
            object3.getResourceName(n13);
            object3 = "layout";
            n12 = ((String)object3).equals(object2) ? 1 : 0;
            if (n12 == 0) continue;
            this.mConstraintSet = object2;
            n11 = this.mConstraintID;
            ((ConstraintSet)object2).clone(context, n11);
        }
        xmlPullParser.recycle();
    }

    public void add(ConstraintLayoutStates$Variant constraintLayoutStates$Variant) {
        this.mVariants.add(constraintLayoutStates$Variant);
    }

    public int findMatch(float f10, float f11) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.mVariants)).size()); ++i10) {
            object = (ConstraintLayoutStates$Variant)this.mVariants.get(i10);
            n10 = ((ConstraintLayoutStates$Variant)object).match(f10, f11) ? 1 : 0;
            if (n10 == 0) continue;
            return i10;
        }
        return -1;
    }
}

