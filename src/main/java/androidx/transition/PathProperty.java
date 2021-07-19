/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.graphics.PointF
 *  android.util.Property
 */
package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

public class PathProperty
extends Property {
    private float mCurrentFraction;
    private final float mPathLength;
    private final PathMeasure mPathMeasure;
    private final PointF mPointF;
    private final float[] mPosition;
    private final Property mProperty;

    public PathProperty(Property property, Path path) {
        float f10;
        String string2 = property.getName();
        super(Float.class, string2);
        Object object = new float[2];
        this.mPosition = object;
        object = new PointF;
        super();
        this.mPointF = (PointF)object;
        this.mProperty = property;
        super(path, false);
        this.mPathMeasure = property;
        this.mPathLength = f10 = property.getLength();
    }

    public Float get(Object object) {
        return Float.valueOf(this.mCurrentFraction);
    }

    public void set(Object object, Float object2) {
        Object object3;
        this.mCurrentFraction = object3 = ((Float)object2).floatValue();
        Object object4 = this.mPathMeasure;
        Object object5 = this.mPathLength;
        float f10 = ((Float)object2).floatValue();
        object2 = this.mPosition;
        object4.getPosTan(object5 *= f10, (float[])object2, null);
        object2 = this.mPointF;
        object4 = this.mPosition;
        ((PointF)object2).x = object5 = (Object)object4[0];
        ((PointF)object2).y = object3 = (Object)object4[1];
        this.mProperty.set(object, object2);
    }
}

