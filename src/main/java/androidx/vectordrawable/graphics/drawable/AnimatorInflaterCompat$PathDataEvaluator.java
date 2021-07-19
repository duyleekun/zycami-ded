/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 */
package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.PathParser$PathDataNode;

public class AnimatorInflaterCompat$PathDataEvaluator
implements TypeEvaluator {
    private PathParser$PathDataNode[] mNodeArray;

    public AnimatorInflaterCompat$PathDataEvaluator() {
    }

    public AnimatorInflaterCompat$PathDataEvaluator(PathParser$PathDataNode[] pathParser$PathDataNodeArray) {
        this.mNodeArray = pathParser$PathDataNodeArray;
    }

    public PathParser$PathDataNode[] evaluate(float f10, PathParser$PathDataNode[] pathParser$PathDataNodeArray, PathParser$PathDataNode[] pathParser$PathDataNodeArray2) {
        int n10 = PathParser.canMorph(pathParser$PathDataNodeArray, pathParser$PathDataNodeArray2);
        if (n10 != 0) {
            int n11;
            PathParser$PathDataNode[] pathParser$PathDataNodeArray3 = this.mNodeArray;
            n10 = PathParser.canMorph(pathParser$PathDataNodeArray3, pathParser$PathDataNodeArray);
            if (n10 == 0) {
                pathParser$PathDataNodeArray3 = PathParser.deepCopyNodes(pathParser$PathDataNodeArray);
                this.mNodeArray = pathParser$PathDataNodeArray3;
            }
            pathParser$PathDataNodeArray3 = null;
            for (n10 = 0; n10 < (n11 = pathParser$PathDataNodeArray.length); ++n10) {
                PathParser$PathDataNode pathParser$PathDataNode = this.mNodeArray[n10];
                PathParser$PathDataNode pathParser$PathDataNode2 = pathParser$PathDataNodeArray[n10];
                PathParser$PathDataNode pathParser$PathDataNode3 = pathParser$PathDataNodeArray2[n10];
                pathParser$PathDataNode.interpolatePathDataNode(pathParser$PathDataNode2, pathParser$PathDataNode3, f10);
            }
            return this.mNodeArray;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        throw illegalArgumentException;
    }
}

