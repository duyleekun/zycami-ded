/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Atom$ContainerAtom
extends Atom {
    public final List containerChildren;
    public final long endPosition;
    public final List leafChildren;

    public Atom$ContainerAtom(int n10, long l10) {
        super(n10);
        ArrayList arrayList;
        this.endPosition = l10;
        this.leafChildren = arrayList = new ArrayList();
        this.containerChildren = arrayList = new ArrayList();
    }

    public void add(Atom$ContainerAtom atom$ContainerAtom) {
        this.containerChildren.add(atom$ContainerAtom);
    }

    public void add(Atom$LeafAtom atom$LeafAtom) {
        this.leafChildren.add(atom$LeafAtom);
    }

    public int getChildAtomOfTypeCount(int n10) {
        int n11;
        List list = this.leafChildren;
        int n12 = list.size();
        int n13 = 0;
        Atom$ContainerAtom atom$ContainerAtom = null;
        int n14 = 0;
        for (n11 = 0; n11 < n12; ++n11) {
            Atom$LeafAtom atom$LeafAtom = (Atom$LeafAtom)this.leafChildren.get(n11);
            int n15 = atom$LeafAtom.type;
            if (n15 != n10) continue;
            ++n14;
        }
        list = this.containerChildren;
        n12 = list.size();
        while (n13 < n12) {
            atom$ContainerAtom = (Atom$ContainerAtom)this.containerChildren.get(n13);
            n11 = atom$ContainerAtom.type;
            if (n11 == n10) {
                ++n14;
            }
            ++n13;
        }
        return n14;
    }

    public Atom$ContainerAtom getContainerAtomOfType(int n10) {
        List list = this.containerChildren;
        int n11 = list.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            Atom$ContainerAtom atom$ContainerAtom = (Atom$ContainerAtom)this.containerChildren.get(i10);
            int n12 = atom$ContainerAtom.type;
            if (n12 != n10) continue;
            return atom$ContainerAtom;
        }
        return null;
    }

    public Atom$LeafAtom getLeafAtomOfType(int n10) {
        List list = this.leafChildren;
        int n11 = list.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            Atom$LeafAtom atom$LeafAtom = (Atom$LeafAtom)this.leafChildren.get(i10);
            int n12 = atom$LeafAtom.type;
            if (n12 != n10) continue;
            return atom$LeafAtom;
        }
        return null;
    }

    public String toString() {
        String string2 = Atom.getAtomTypeString(this.type);
        String string3 = Arrays.toString(this.leafChildren.toArray());
        String string4 = Arrays.toString(this.containerChildren.toArray());
        int n10 = String.valueOf(string2).length() + 22;
        int n11 = String.valueOf(string3).length();
        n10 += n11;
        n11 = String.valueOf(string4).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append(" leaves: ");
        stringBuilder.append(string3);
        stringBuilder.append(" containers: ");
        stringBuilder.append(string4);
        return stringBuilder.toString();
    }
}

