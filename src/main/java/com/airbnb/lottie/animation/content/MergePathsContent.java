/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  android.graphics.Path$Op
 *  android.os.Build$VERSION
 */
package com.airbnb.lottie.animation.content;

import android.graphics.Matrix;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.content.GreedyContent;
import com.airbnb.lottie.animation.content.MergePathsContent$1;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.model.content.MergePaths$MergePathsMode;
import java.util.List;
import java.util.ListIterator;

public class MergePathsContent
implements PathContent,
GreedyContent {
    private final Path firstPath;
    private final MergePaths mergePaths;
    private final String name;
    private final Path path;
    private final List pathContents;
    private final Path remainderPath;

    public MergePathsContent(MergePaths object) {
        Object object2;
        this.firstPath = object2 = new Path();
        this.remainderPath = object2 = new Path();
        this.path = object2 = new Path();
        this.pathContents = object2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            object2 = ((MergePaths)object).getName();
            this.name = object2;
            this.mergePaths = object;
            return;
        }
        object = new IllegalStateException("Merge paths are not supported pre-KitKat.");
        throw object;
    }

    private void addPaths() {
        List list;
        int n10;
        for (int i10 = 0; i10 < (n10 = (list = this.pathContents).size()); ++i10) {
            list = this.path;
            Path path = ((PathContent)this.pathContents.get(i10)).getPath();
            list.addPath(path);
        }
    }

    private void opFirstPathWithRest(Path.Op op) {
        Object object;
        int n10;
        Object object2;
        this.remainderPath.reset();
        this.firstPath.reset();
        Object object3 = this.pathContents;
        int n11 = object3.size();
        int n12 = 1;
        n11 -= n12;
        while (n11 >= n12) {
            object2 = (PathContent)this.pathContents.get(n11);
            n10 = object2 instanceof ContentGroup;
            if (n10 != 0) {
                object2 = (ContentGroup)object2;
                object = ((ContentGroup)object2).getPathList();
                for (int i10 = object.size() - n12; i10 >= 0; i10 += -1) {
                    Path path = ((PathContent)object.get(i10)).getPath();
                    Matrix matrix = ((ContentGroup)object2).getTransformationMatrix();
                    path.transform(matrix);
                    matrix = this.remainderPath;
                    matrix.addPath(path);
                }
            } else {
                object = this.remainderPath;
                object2 = object2.getPath();
                object.addPath((Path)object2);
            }
            n11 += -1;
        }
        object3 = this.pathContents;
        Path path = null;
        boolean bl2 = (object3 = (PathContent)object3.get(0)) instanceof ContentGroup;
        if (bl2) {
            object3 = (ContentGroup)object3;
            object2 = ((ContentGroup)object3).getPathList();
            for (n12 = 0; n12 < (n10 = object2.size()); ++n12) {
                object = ((PathContent)object2.get(n12)).getPath();
                Matrix matrix = ((ContentGroup)object3).getTransformationMatrix();
                object.transform(matrix);
                matrix = this.firstPath;
                matrix.addPath((Path)object);
            }
        } else {
            path = this.firstPath;
            object3 = object3.getPath();
            path.set((Path)object3);
        }
        object3 = this.path;
        path = this.firstPath;
        object2 = this.remainderPath;
        object3.op(path, (Path)object2, op);
    }

    public void absorbContent(ListIterator listIterator) {
        Object object;
        boolean bl2;
        while ((bl2 = listIterator.hasPrevious()) && (object = listIterator.previous()) != this) {
        }
        while (bl2 = listIterator.hasPrevious()) {
            object = (Content)listIterator.previous();
            boolean bl3 = object instanceof PathContent;
            if (!bl3) continue;
            List list = this.pathContents;
            object = (PathContent)object;
            list.add(object);
            listIterator.remove();
        }
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        this.path.reset();
        Object object = this.mergePaths;
        Object object2 = ((MergePaths)object).isHidden();
        if (object2 != 0) {
            return this.path;
        }
        object = MergePathsContent$1.$SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode;
        MergePaths$MergePathsMode mergePaths$MergePathsMode = this.mergePaths.getMode();
        int n10 = mergePaths$MergePathsMode.ordinal();
        object2 = object[n10];
        if (object2 != (n10 = 1)) {
            n10 = 2;
            if (object2 != n10) {
                n10 = 3;
                if (object2 != n10) {
                    n10 = 4;
                    if (object2 != n10) {
                        n10 = 5;
                        if (object2 == n10) {
                            object = Path.Op.XOR;
                            this.opFirstPathWithRest((Path.Op)object);
                        }
                    } else {
                        object = Path.Op.INTERSECT;
                        this.opFirstPathWithRest((Path.Op)object);
                    }
                } else {
                    object = Path.Op.REVERSE_DIFFERENCE;
                    this.opFirstPathWithRest((Path.Op)object);
                }
            } else {
                object = Path.Op.UNION;
                this.opFirstPathWithRest((Path.Op)object);
            }
        } else {
            this.addPaths();
        }
        return this.path;
    }

    public void setContents(List list, List list2) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.pathContents).size()); ++i10) {
            object = (PathContent)this.pathContents.get(i10);
            object.setContents(list, list2);
        }
    }
}

