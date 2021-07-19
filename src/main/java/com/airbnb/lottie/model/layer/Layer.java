/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.Layer$LayerType;
import com.airbnb.lottie.model.layer.Layer$MatteType;
import java.util.List;
import java.util.Locale;

public class Layer {
    private final LottieComposition composition;
    private final boolean hidden;
    private final List inOutKeyframes;
    private final long layerId;
    private final String layerName;
    private final Layer$LayerType layerType;
    private final List masks;
    private final Layer$MatteType matteType;
    private final long parentId;
    private final int preCompHeight;
    private final int preCompWidth;
    private final String refId;
    private final List shapes;
    private final int solidColor;
    private final int solidHeight;
    private final int solidWidth;
    private final float startFrame;
    private final AnimatableTextFrame text;
    private final AnimatableTextProperties textProperties;
    private final AnimatableFloatValue timeRemapping;
    private final float timeStretch;
    private final AnimatableTransform transform;

    public Layer(List list, LottieComposition lottieComposition, String string2, long l10, Layer$LayerType layer$LayerType, long l11, String string3, List list2, AnimatableTransform animatableTransform, int n10, int n11, int n12, float f10, float f11, int n13, int n14, AnimatableTextFrame animatableTextFrame, AnimatableTextProperties animatableTextProperties, List list3, Layer$MatteType layer$MatteType, AnimatableFloatValue animatableFloatValue, boolean bl2) {
        this.shapes = list;
        this.composition = lottieComposition;
        this.layerName = string2;
        this.layerId = l10;
        this.layerType = layer$LayerType;
        this.parentId = l11;
        this.refId = string3;
        this.masks = list2;
        this.transform = animatableTransform;
        this.solidWidth = n10;
        this.solidHeight = n11;
        this.solidColor = n12;
        this.timeStretch = f10;
        this.startFrame = f11;
        this.preCompWidth = n13;
        this.preCompHeight = n14;
        this.text = animatableTextFrame;
        this.textProperties = animatableTextProperties;
        this.inOutKeyframes = list3;
        this.matteType = layer$MatteType;
        this.timeRemapping = animatableFloatValue;
        this.hidden = bl2;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public long getId() {
        return this.layerId;
    }

    public List getInOutKeyframes() {
        return this.inOutKeyframes;
    }

    public Layer$LayerType getLayerType() {
        return this.layerType;
    }

    public List getMasks() {
        return this.masks;
    }

    public Layer$MatteType getMatteType() {
        return this.matteType;
    }

    public String getName() {
        return this.layerName;
    }

    public long getParentId() {
        return this.parentId;
    }

    public int getPreCompHeight() {
        return this.preCompHeight;
    }

    public int getPreCompWidth() {
        return this.preCompWidth;
    }

    public String getRefId() {
        return this.refId;
    }

    public List getShapes() {
        return this.shapes;
    }

    public int getSolidColor() {
        return this.solidColor;
    }

    public int getSolidHeight() {
        return this.solidHeight;
    }

    public int getSolidWidth() {
        return this.solidWidth;
    }

    public float getStartProgress() {
        float f10 = this.startFrame;
        float f11 = this.composition.getDurationFrames();
        return f10 / f11;
    }

    public AnimatableTextFrame getText() {
        return this.text;
    }

    public AnimatableTextProperties getTextProperties() {
        return this.textProperties;
    }

    public AnimatableFloatValue getTimeRemapping() {
        return this.timeRemapping;
    }

    public float getTimeStretch() {
        return this.timeStretch;
    }

    public AnimatableTransform getTransform() {
        return this.transform;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public String toString() {
        return this.toString("");
    }

    public String toString(String string2) {
        String string3;
        int n10;
        int n11;
        Object[] objectArray;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        String string4 = this.getName();
        stringBuilder.append(string4);
        string4 = "\n";
        stringBuilder.append(string4);
        Object object = this.composition;
        long l10 = this.getParentId();
        object = ((LottieComposition)object).layerModelForId(l10);
        if (object != null) {
            stringBuilder.append("\t\tParents: ");
            objectArray = ((Layer)object).getName();
            stringBuilder.append((String)objectArray);
            objectArray = this.composition;
            long l11 = ((Layer)object).getParentId();
            object = objectArray.layerModelForId(l11);
            while (object != null) {
                stringBuilder.append("->");
                objectArray = ((Layer)object).getName();
                stringBuilder.append((String)objectArray);
                objectArray = this.composition;
                l11 = ((Layer)object).getParentId();
                object = objectArray.layerModelForId(l11);
            }
            stringBuilder.append(string2);
            stringBuilder.append(string4);
        }
        if ((n11 = (object = this.getMasks()).isEmpty()) == 0) {
            stringBuilder.append(string2);
            stringBuilder.append("\tMasks: ");
            object = this.getMasks();
            n11 = object.size();
            stringBuilder.append(n11);
            stringBuilder.append(string4);
        }
        if ((n11 = this.getSolidWidth()) != 0 && (n11 = this.getSolidHeight()) != 0) {
            stringBuilder.append(string2);
            stringBuilder.append("\tBackground: ");
            object = Locale.US;
            n10 = 3;
            objectArray = new Object[n10];
            Integer n12 = this.getSolidWidth();
            objectArray[0] = n12;
            n12 = this.getSolidHeight();
            objectArray[1] = n12;
            int n13 = 2;
            int n14 = this.getSolidColor();
            n12 = n14;
            objectArray[n13] = n12;
            string3 = "%dx%d %X\n";
            object = String.format((Locale)object, string3, objectArray);
            stringBuilder.append((String)object);
        }
        if ((n11 = (int)((object = this.shapes).isEmpty() ? 1 : 0)) == 0) {
            stringBuilder.append(string2);
            stringBuilder.append("\tShapes:\n");
            object = this.shapes.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                objectArray = object.next();
                stringBuilder.append(string2);
                string3 = "\t\t";
                stringBuilder.append(string3);
                stringBuilder.append(objectArray);
                stringBuilder.append(string4);
            }
        }
        return stringBuilder.toString();
    }
}

