/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 */
package androidx.core.graphics;

import android.graphics.Path;
import androidx.core.graphics.PathParser$ExtractFloatResult;
import androidx.core.graphics.PathParser$PathDataNode;
import java.util.ArrayList;

public class PathParser {
    private static final String LOGTAG = "PathParser";

    private PathParser() {
    }

    private static void addNode(ArrayList arrayList, char c10, float[] fArray) {
        PathParser$PathDataNode pathParser$PathDataNode = new PathParser$PathDataNode(c10, fArray);
        arrayList.add(pathParser$PathDataNode);
    }

    public static boolean canMorph(PathParser$PathDataNode[] pathParser$PathDataNodeArray, PathParser$PathDataNode[] pathParser$PathDataNodeArray2) {
        if (pathParser$PathDataNodeArray != null && pathParser$PathDataNodeArray2 != null) {
            int n10 = pathParser$PathDataNodeArray.length;
            int n11 = pathParser$PathDataNodeArray2.length;
            if (n10 != n11) {
                return false;
            }
            for (n10 = 0; n10 < (n11 = pathParser$PathDataNodeArray.length); ++n10) {
                Object object = pathParser$PathDataNodeArray[n10];
                n11 = ((PathParser$PathDataNode)object).mType;
                Object object2 = pathParser$PathDataNodeArray2[n10];
                int n12 = ((PathParser$PathDataNode)object2).mType;
                if (n11 == n12 && (n11 = ((Object)(object = (Object)pathParser$PathDataNodeArray[n10].mParams)).length) == (n12 = ((Object)(object2 = (Object)pathParser$PathDataNodeArray2[n10].mParams)).length)) {
                    continue;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public static float[] copyOfRange(float[] object, int n10, int n11) {
        if (n10 <= n11) {
            int n12 = ((float[])object).length;
            if (n10 >= 0 && n10 <= n12) {
                n12 -= n10;
                n12 = Math.min(n11 -= n10, n12);
                float[] fArray = new float[n11];
                System.arraycopy(object, n10, fArray, 0, n12);
                return fArray;
            }
            object = new ArrayIndexOutOfBoundsException;
            object();
            throw object;
        }
        object = new IllegalArgumentException;
        object();
        throw object;
    }

    public static PathParser$PathDataNode[] createNodesFromPathData(String pathParser$PathDataNodeArray) {
        char c10;
        char c11;
        if (pathParser$PathDataNodeArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        char c12 = c11 = '\u0001';
        char c13 = '\u0000';
        String string2 = null;
        while (c12 < (c10 = pathParser$PathDataNodeArray.length())) {
            string2 = pathParser$PathDataNodeArray.substring(c13, c12 = PathParser.nextStart((String)pathParser$PathDataNodeArray, c12)).trim();
            c10 = string2.length();
            if (c10 > '\u0000') {
                float[] fArray = PathParser.getFloats(string2);
                c13 = string2.charAt(0);
                PathParser.addNode(arrayList, c13, fArray);
            }
            char c14 = c12 + 1;
            c13 = c12;
            c12 = c14;
        }
        if ((c12 -= c13) == c11 && c13 < (c11 = pathParser$PathDataNodeArray.length())) {
            char c15 = pathParser$PathDataNodeArray.charAt(c13);
            float[] fArray = new float[]{};
            PathParser.addNode(arrayList, c15, fArray);
        }
        pathParser$PathDataNodeArray = new PathParser$PathDataNode[arrayList.size()];
        return arrayList.toArray(pathParser$PathDataNodeArray);
    }

    public static Path createPathFromPathData(String string2) {
        Path path = new Path();
        Object object = PathParser.createNodesFromPathData(string2);
        if (object != null) {
            try {
                PathParser$PathDataNode.nodesToPath(object, path);
                return path;
            }
            catch (RuntimeException runtimeException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error in parsing ");
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                object = new RuntimeException(string2, runtimeException);
                throw object;
            }
        }
        return null;
    }

    public static PathParser$PathDataNode[] deepCopyNodes(PathParser$PathDataNode[] pathParser$PathDataNodeArray) {
        int n10;
        if (pathParser$PathDataNodeArray == null) {
            return null;
        }
        int n11 = pathParser$PathDataNodeArray.length;
        PathParser$PathDataNode[] pathParser$PathDataNodeArray2 = new PathParser$PathDataNode[n11];
        for (int i10 = 0; i10 < (n10 = pathParser$PathDataNodeArray.length); ++i10) {
            PathParser$PathDataNode pathParser$PathDataNode;
            PathParser$PathDataNode pathParser$PathDataNode2 = pathParser$PathDataNodeArray[i10];
            pathParser$PathDataNodeArray2[i10] = pathParser$PathDataNode = new PathParser$PathDataNode(pathParser$PathDataNode2);
        }
        return pathParser$PathDataNodeArray2;
    }

    /*
     * Unable to fully structure code
     */
    private static void extract(String var0, int var1_1, PathParser$ExtractFloatResult var2_2) {
        var2_2.mEndWithNegOrDot = false;
        var4_4 = false;
        var5_5 = false;
        var6_6 = false;
        for (var3_3 = var1_1; var3_3 < (var7_7 = var0.length()); ++var3_3) {
            block9: {
                block7: {
                    block8: {
                        var7_7 = var0.charAt(var3_3);
                        var8_8 = 32;
                        var9_9 = true;
                        if (var7_7 == var8_8) break block7;
                        var8_8 = 69;
                        if (var7_7 == var8_8 || var7_7 == (var8_8 = 101)) break block8;
                        switch (var7_7) {
                            default: {
                                ** GOTO lbl26
                            }
                            case 46: {
                                if (var5_5) ** GOTO lbl20
                                var4_4 = false;
                                var5_5 = var9_9;
                                break block9;
lbl20:
                                // 1 sources

                                var2_2.mEndWithNegOrDot = var9_9;
                                break;
                            }
                            case 45: {
                                if (var3_3 != var1_1 && !var4_4) {
                                    var2_2.mEndWithNegOrDot = var9_9;
                                    break;
                                }
lbl26:
                                // 3 sources

                                var4_4 = false;
                                break block9;
                            }
                        }
                    }
                    var4_4 = var9_9;
                    break block9;
                    {
                        ** case 44:
                    }
                }
                var4_4 = false;
                var6_6 = var9_9;
            }
            if (var6_6) break;
        }
        var2_2.mEndPosition = var3_3;
    }

    private static float[] getFloats(String string2) {
        int n10;
        Object var1_1 = null;
        int n11 = string2.charAt(0);
        if (n11 != (n10 = 122) && (n11 = string2.charAt(0)) != (n10 = 90)) {
            n11 = string2.length();
            Object object = new float[n11];
            Object object2 = new PathParser$ExtractFloatResult();
            int n12 = string2.length();
            int n13 = 1;
            float f10 = Float.MIN_VALUE;
            int n14 = 0;
            while (n13 < n12) {
                int n15;
                block14: {
                    PathParser.extract(string2, n13, (PathParser$ExtractFloatResult)object2);
                    n15 = ((PathParser$ExtractFloatResult)object2).mEndPosition;
                    if (n13 >= n15) break block14;
                    int n16 = n14 + 1;
                    String string3 = string2.substring(n13, n15);
                    f10 = Float.parseFloat(string3);
                    object[n14] = f10;
                    n14 = n16;
                }
                n13 = (int)(((PathParser$ExtractFloatResult)object2).mEndWithNegOrDot ? 1 : 0);
                if (n13 != 0) {
                    n13 = n15;
                    continue;
                }
                n13 = n15 + 1;
            }
            try {
                return PathParser.copyOfRange((float[])object, 0, n14);
            }
            catch (NumberFormatException numberFormatException) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("error in parsing \"");
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append("\"");
                string2 = ((StringBuilder)object2).toString();
                object = new RuntimeException(string2, numberFormatException);
                throw object;
            }
        }
        return new float[0];
    }

    public static boolean interpolatePathDataNodes(PathParser$PathDataNode[] object, PathParser$PathDataNode[] pathParser$PathDataNodeArray, PathParser$PathDataNode[] pathParser$PathDataNodeArray2, float f10) {
        if (object != null && pathParser$PathDataNodeArray != null && pathParser$PathDataNodeArray2 != null) {
            int n10 = ((PathParser$PathDataNode[])object).length;
            int n11 = pathParser$PathDataNodeArray.length;
            if (n10 == n11 && (n10 = pathParser$PathDataNodeArray.length) == (n11 = pathParser$PathDataNodeArray2.length)) {
                n10 = (int)(PathParser.canMorph(pathParser$PathDataNodeArray, pathParser$PathDataNodeArray2) ? 1 : 0);
                if (n10 == 0) {
                    return false;
                }
                for (n11 = 0; n11 < (n10 = ((PathParser$PathDataNode[])object).length); ++n11) {
                    PathParser$PathDataNode pathParser$PathDataNode = object[n11];
                    PathParser$PathDataNode pathParser$PathDataNode2 = pathParser$PathDataNodeArray[n11];
                    PathParser$PathDataNode pathParser$PathDataNode3 = pathParser$PathDataNodeArray2[n11];
                    pathParser$PathDataNode.interpolatePathDataNode(pathParser$PathDataNode2, pathParser$PathDataNode3, f10);
                }
                return true;
            }
            object = new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
            throw object;
        }
        object = new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
        throw object;
    }

    private static int nextStart(String string2, int n10) {
        int n11;
        while (n10 < (n11 = string2.length())) {
            block6: {
                int n12;
                block5: {
                    n11 = string2.charAt(n10);
                    n12 = n11 + -65;
                    int n13 = n11 + -90;
                    if ((n12 *= n13) <= 0) break block5;
                    n12 = n11 + -97;
                    n13 = n11 + -122;
                    if ((n12 *= n13) > 0) break block6;
                }
                if (n11 != (n12 = 101) && n11 != (n12 = 69)) {
                    return n10;
                }
            }
            ++n10;
        }
        return n10;
    }

    public static void updateNodes(PathParser$PathDataNode[] pathParser$PathDataNodeArray, PathParser$PathDataNode[] pathParser$PathDataNodeArray2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = pathParser$PathDataNodeArray2.length); ++i10) {
            int n11;
            PathParser$PathDataNode pathParser$PathDataNode = pathParser$PathDataNodeArray[i10];
            Object object = pathParser$PathDataNodeArray2[i10];
            pathParser$PathDataNode.mType = n11 = ((PathParser$PathDataNode)object).mType;
            pathParser$PathDataNode = null;
            for (n10 = 0; n10 < (n11 = ((Object)(object = (Object)pathParser$PathDataNodeArray2[i10].mParams)).length); ++n10) {
                object = pathParser$PathDataNodeArray[i10].mParams;
                float[] fArray = pathParser$PathDataNodeArray2[i10].mParams;
                float f10 = fArray[n10];
                object[n10] = f10;
            }
        }
    }
}

