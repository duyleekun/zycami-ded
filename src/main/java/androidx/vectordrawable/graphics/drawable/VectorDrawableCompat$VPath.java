/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$Theme
 *  android.graphics.Path
 *  android.util.Log
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Path;
import android.util.Log;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VObject;

public abstract class VectorDrawableCompat$VPath
extends VectorDrawableCompat$VObject {
    public static final int FILL_TYPE_WINDING;
    public int mChangingConfigurations;
    public int mFillRule = 0;
    public PathParser$PathDataNode[] mNodes = null;
    public String mPathName;

    public VectorDrawableCompat$VPath() {
        super(null);
    }

    public VectorDrawableCompat$VPath(VectorDrawableCompat$VPath pathParser$PathDataNodeArray) {
        super(null);
        int n10;
        String string2;
        this.mPathName = string2 = pathParser$PathDataNodeArray.mPathName;
        this.mChangingConfigurations = n10 = pathParser$PathDataNodeArray.mChangingConfigurations;
        pathParser$PathDataNodeArray = PathParser.deepCopyNodes(pathParser$PathDataNodeArray.mNodes);
        this.mNodes = pathParser$PathDataNodeArray;
    }

    public void applyTheme(Resources.Theme theme) {
    }

    public boolean canApplyTheme() {
        return false;
    }

    public PathParser$PathDataNode[] getPathData() {
        return this.mNodes;
    }

    public String getPathName() {
        return this.mPathName;
    }

    public boolean isClipPath() {
        return false;
    }

    public String nodesToString(PathParser$PathDataNode[] pathParser$PathDataNodeArray) {
        int n10;
        String string2 = " ";
        for (int i10 = 0; i10 < (n10 = pathParser$PathDataNodeArray.length); ++i10) {
            int n11;
            Object object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            char c10 = pathParser$PathDataNodeArray[i10].mType;
            ((StringBuilder)object).append(c10);
            ((StringBuilder)object).append(":");
            string2 = ((StringBuilder)object).toString();
            object = pathParser$PathDataNodeArray[i10].mParams;
            for (int i11 = 0; i11 < (n11 = ((Object)object).length); ++i11) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                Object object2 = object[i11];
                stringBuilder.append((float)object2);
                stringBuilder.append(",");
                string2 = stringBuilder.toString();
            }
        }
        return string2;
    }

    public void printVPath(int n10) {
        Object object = "";
        for (int i10 = 0; i10 < n10; ++i10) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append("    ");
            object = stringBuilder.toString();
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append((String)object);
        charSequence.append("current path is :");
        object = this.mPathName;
        charSequence.append((String)object);
        charSequence.append(" pathData is ");
        object = this.mNodes;
        object = this.nodesToString((PathParser$PathDataNode[])object);
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        Log.v((String)"VectorDrawableCompat", (String)charSequence);
    }

    public void setPathData(PathParser$PathDataNode[] pathParser$PathDataNodeArray) {
        PathParser$PathDataNode[] pathParser$PathDataNodeArray2 = this.mNodes;
        boolean bl2 = PathParser.canMorph(pathParser$PathDataNodeArray2, pathParser$PathDataNodeArray);
        if (!bl2) {
            pathParser$PathDataNodeArray = PathParser.deepCopyNodes(pathParser$PathDataNodeArray);
            this.mNodes = pathParser$PathDataNodeArray;
        } else {
            pathParser$PathDataNodeArray2 = this.mNodes;
            PathParser.updateNodes(pathParser$PathDataNodeArray2, pathParser$PathDataNodeArray);
        }
    }

    public void toPath(Path path) {
        path.reset();
        PathParser$PathDataNode[] pathParser$PathDataNodeArray = this.mNodes;
        if (pathParser$PathDataNodeArray != null) {
            PathParser$PathDataNode.nodesToPath(pathParser$PathDataNodeArray, path);
        }
    }
}

