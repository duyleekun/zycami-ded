/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.b0.e.c;

import android.content.Context;
import com.faceunity.wrapper.faceunity;
import com.zhiyun.renderengine.bean.TextureFormat;
import com.zhiyun.renderengine.engine.IRenderEngine;
import com.zhiyun.renderengine.engine.RenderEngineType;
import com.zhiyun.renderengine.engine.faceunity.FaceUnityPlatform;
import com.zhiyun.renderengine.engine.faceunity.FaceUnityPlatform$Key;
import d.v.b0.d.d;
import d.v.b0.f.b;
import java.util.Iterator;

public class a
extends d.v.b0.e.a
implements IRenderEngine {
    private int j;
    private int k;
    private int l = 0;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int v() {
        int n10 = this.k;
        int n11 = 3;
        int n12 = 2;
        int n13 = 180;
        int n14 = 270;
        int n15 = 1;
        int n16 = 90;
        if (n10 == n14) {
            n10 = this.j;
            if (n10 == n15) {
                n10 = this.e;
                return n10 / 90;
            }
            n10 = this.e;
            if (n10 == n13) return 0;
            if (n10 != 0) return n10 / 90;
            return n12;
        }
        if (n10 != n16) return 0;
        n10 = this.j;
        if (n10 == 0) {
            n10 = this.e;
            if (n10 == n16) return n11;
            if (n10 != n14) return n10 / 90;
            return n15;
        }
        n10 = this.e;
        if (n10 == 0) {
            return n12;
        }
        if (n10 == n16) return n11;
        if (n10 != n13) return n15;
        return 0;
    }

    private void w() {
        faceunity.fuOnCameraChange();
    }

    public void a(int n10, int n11) {
        int n12;
        this.j = n10;
        this.k = n11;
        this.w();
        this.l = n12 = this.v();
        Object object = new StringBuilder();
        ((StringBuilder)object).append("onInputChange mInputOrientation: ");
        int n13 = this.k;
        ((StringBuilder)object).append(n13);
        ((StringBuilder)object).append("  mDeviceOrientation:");
        n13 = this.e;
        ((StringBuilder)object).append(n13);
        ((StringBuilder)object).append("  mRotationMode:");
        n13 = this.l;
        ((StringBuilder)object).append(n13);
        ((StringBuilder)object).append("  effects.size:");
        Object object2 = this.h;
        n13 = object2.size();
        ((StringBuilder)object).append(n13);
        d.v.b0.j.b.a(((StringBuilder)object).toString());
        n12 = this.l;
        faceunity.fuSetDefaultRotationMode(n12);
        object = this.h.iterator();
        while ((n13 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = (d)object.next();
            if (object2 == null) continue;
            object2.a(n10, n11);
        }
    }

    public int e(byte[] byArray, TextureFormat textureFormat, int n10, boolean bl2, int n11, int n12) {
        boolean bl3;
        Iterator iterator2 = this.h.iterator();
        int n13 = -1;
        while (bl3 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            Object object = e10;
            object = (d)e10;
            n13 = object.m(byArray, textureFormat, n10, bl2, n11, n12);
        }
        return n13;
    }

    public int g(byte[] byArray, TextureFormat textureFormat, int n10, int n11) {
        boolean bl2;
        Iterator iterator2 = this.h.iterator();
        int n12 = -1;
        while (bl2 = iterator2.hasNext()) {
            d d10 = (d)iterator2.next();
            n12 = d10.c(byArray, textureFormat, n10, n11);
        }
        return n12;
    }

    public int h(int n10, int n11, int n12) {
        boolean bl2;
        Iterator iterator2 = this.h.iterator();
        int n13 = -1;
        while (bl2 = iterator2.hasNext()) {
            d d10 = (d)iterator2.next();
            n13 = d10.b(n10, n11, n12);
        }
        return n13;
    }

    public RenderEngineType j() {
        return RenderEngineType.FACE_UNITY_ENGINE;
    }

    public boolean k(Context context) {
        if (context == null) {
            return false;
        }
        super.k(context);
        FaceUnityPlatform.f();
        context = this.d;
        FaceUnityPlatform$Key faceUnityPlatform$Key = FaceUnityPlatform$Key.KEY_FACE_AI;
        FaceUnityPlatform.j(context, faceUnityPlatform$Key);
        faceunity.fuSetMaxFaces(4);
        return true;
    }

    public int[] l() {
        int[] nArray;
        int[] nArray2 = nArray = new int[6];
        int[] nArray3 = nArray;
        nArray2[0] = 1;
        nArray3[1] = 2;
        nArray2[2] = 3;
        nArray3[3] = 4;
        nArray2[4] = 5;
        nArray3[5] = 103;
        return nArray;
    }

    public d m(int n10) {
        d.v.b0.d.e.b b10 = new d.v.b0.d.e.b();
        return b10;
    }

    public boolean n() {
        boolean bl2;
        super.n();
        Iterator iterator2 = this.h.iterator();
        while (bl2 = iterator2.hasNext()) {
            d d10 = (d)iterator2.next();
            if (d10 == null) continue;
            d10.f();
        }
        this.i();
        faceunity.fuDestroyAllItems();
        faceunity.fuDone();
        faceunity.fuOnDeviceLost();
        return false;
    }

    public TextureFormat[] o() {
        TextureFormat textureFormat = TextureFormat.NV21;
        TextureFormat[] textureFormatArray = new TextureFormat[]{textureFormat};
        return textureFormatArray;
    }

    public void q(b b10) {
        this.c = b10 = this.c;
    }

    public void t(int n10) {
        int n11 = this.e;
        if (n11 != n10) {
            this.e = n10;
            n10 = this.v();
            faceunity.fuSetDefaultRotationMode(n10);
            this.l = n10;
        }
    }
}

