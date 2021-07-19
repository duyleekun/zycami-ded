/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 */
package d.v.c.x0.c.c;

import android.graphics.Color;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.editorsdk.decoration.DecorationUseCases;
import d.v.e.i.h;
import d.v.h.d.d;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class f
extends ViewModel {
    private static final int[] c;
    private MutableLiveData a;
    private MutableLiveData b;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[48];
        int[] nArray3 = nArray;
        nArray2[0] = -1;
        nArray3[1] = -9145228;
        nArray2[2] = -16777216;
        nArray3[3] = -65536;
        nArray2[4] = -246;
        nArray3[5] = -16711915;
        nArray2[6] = -15132161;
        nArray3[7] = -1703681;
        nArray2[8] = -1788753;
        nArray3[9] = -25224;
        nArray2[10] = -1603770;
        nArray3[11] = -44205;
        nArray2[12] = -1847114;
        nArray3[13] = -1253255;
        nArray2[14] = -3034766;
        nArray3[15] = -3412013;
        nArray2[16] = -6963584;
        nArray3[17] = -5114806;
        nArray2[18] = -13381312;
        nArray3[19] = -16270171;
        nArray2[20] = -6562327;
        nArray3[21] = -14497309;
        nArray2[22] = -16736001;
        nArray3[23] = -14919425;
        nArray2[24] = -6837548;
        nArray3[25] = -4081665;
        nArray2[26] = -8156161;
        nArray3[27] = -10202902;
        nArray2[28] = -2188120;
        nArray3[29] = -2321686;
        nArray2[30] = -1020245;
        nArray3[31] = -1097313;
        nArray2[32] = -8281985;
        nArray3[33] = -10589044;
        nArray2[34] = -9153111;
        nArray3[35] = -11272022;
        nArray2[36] = -6476616;
        nArray3[37] = -6927288;
        nArray2[38] = -6194576;
        nArray3[39] = -4614214;
        nArray2[40] = -7466478;
        nArray3[41] = -8104183;
        nArray2[42] = -10259653;
        nArray3[43] = -13541817;
        nArray2[44] = -15635573;
        nArray3[45] = -15844741;
        nArray2[46] = -11915081;
        nArray3[47] = -7194016;
        c = nArray;
    }

    public f() {
        MutableLiveData mutableLiveData;
        this.a = mutableLiveData = new MutableLiveData();
        this.b = mutableLiveData = new MutableLiveData();
    }

    public boolean b(d d10, int n10) {
        boolean bl2 = false;
        if (d10 == null) {
            return false;
        }
        int[] nArray = DecorationUseCases.a(n10);
        int n11 = this.d(d10);
        int n12 = d10.x();
        boolean bl3 = true;
        int n13 = nArray[bl3];
        int n14 = nArray[2];
        int n15 = 3;
        n10 = nArray[n15];
        if (n12 == (n10 = Color.argb((int)n11, (int)n13, (int)n14, (int)n10))) {
            bl2 = bl3;
        }
        return bl2;
    }

    public void c(d object, d object2, List list) {
        int n10;
        int n11;
        if (object == null) {
            if (object2 == null) {
                object = this.f();
                int n12 = -1;
                object2 = n12;
                h.g((MutableLiveData)object, object2);
            }
            return;
        }
        int n13 = ((d)object).x();
        if (n13 != (n11 = ((d)object2).x())) {
            return;
        }
        n11 = 0;
        object2 = null;
        for (n13 = 0; n13 < (n10 = list.size()); ++n13) {
            Integer n14;
            int n15;
            n10 = ((d)object).x();
            if (n10 != (n15 = (n14 = (Integer)list.get(n13)).intValue())) continue;
            n11 = n13;
            break;
        }
        object = this.a;
        object2 = n11;
        h.g((MutableLiveData)object, object2);
    }

    public int d(d d10) {
        if (d10 == null) {
            return 255;
        }
        return DecorationUseCases.a(d10.x())[0];
    }

    public int e(d d10, List list) {
        int n10;
        int n11 = this.d(d10);
        if (d10 != null) {
            int n12;
            for (n10 = 0; n10 < (n12 = list.size()); ++n10) {
                int[] nArray = DecorationUseCases.a((Integer)list.get(n10));
                int n13 = d10.x();
                int n14 = nArray[1];
                int n15 = nArray[2];
                int n16 = 3;
                n12 = nArray[n16];
                if (n13 != (n12 = Color.argb((int)n11, (int)n14, (int)n15, (int)n12))) {
                    continue;
                }
                break;
            }
        } else {
            n10 = -1;
        }
        return n10;
    }

    public MutableLiveData f() {
        return this.a;
    }

    public int g() {
        int n10;
        Object object = this.a.getValue();
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            object = (Integer)this.a.getValue();
            n10 = (Integer)object;
        }
        return n10;
    }

    public List i() {
        Stream<Integer> stream = Arrays.stream(c).boxed();
        Collector collector = Collectors.toList();
        return stream.collect(collector);
    }

    public MutableLiveData j() {
        return this.b;
    }

    public void k(int n10, int n11) {
        MutableLiveData mutableLiveData = this.a;
        Integer n12 = n10;
        h.g(mutableLiveData, n12);
    }
}

