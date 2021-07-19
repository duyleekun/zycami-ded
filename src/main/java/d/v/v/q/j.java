/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  android.text.TextUtils
 *  android.util.Size
 */
package d.v.v.q;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Size;
import com.meicam.sdk.NvsAVFileInfo;
import com.meicam.sdk.NvsColor;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsVideoResolution;
import com.zhiyun.editorinterface.EditConfig$a;
import com.zhiyun.editorinterface.edit.MediaType;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.h.b;
import d.v.h.e.a;
import d.v.h.e.d;
import d.v.v.j.h;
import java.util.ArrayList;
import java.util.List;

public class j {
    public static String a(int n10) {
        int n11 = Color.alpha((int)n10);
        int n12 = Color.blue((int)n10);
        int n13 = Color.green((int)n10);
        n10 = Color.red((int)n10);
        String string2 = j.b(n11);
        String string3 = j.b(n12);
        String string4 = j.b(n13);
        String string5 = j.b(n10);
        StringBuilder stringBuilder = new StringBuilder("#");
        stringBuilder.append(string2);
        stringBuilder.append(string5);
        stringBuilder.append(string4);
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    private static String b(int n10) {
        String string2 = Integer.toHexString(n10);
        string2 = "00".concat(string2);
        int n11 = string2.length() + -2;
        int n12 = string2.length();
        return string2.substring(n11, n12);
    }

    public static NvsColor c(String string2) {
        boolean bl2;
        if (!(string2 == null || string2 != null && (bl2 = string2.isEmpty()))) {
            float f10;
            float f11 = 1.0f;
            NvsColor nvsColor = new NvsColor(f11, f11, f11, f11);
            int n10 = Color.parseColor((String)string2);
            f11 = (0xFF000000 & n10) >>> 24;
            float f12 = 255.0f;
            nvsColor.a = f11 /= f12;
            nvsColor.r = f11 = (float)((0xFF0000 & n10) >> 16) / f12;
            nvsColor.g = f11 = (float)((0xFF00 & n10) >> 8) / f12;
            nvsColor.b = f10 = (float)(n10 & 0xFF) / f12;
            return nvsColor;
        }
        return null;
    }

    public static int d() {
        return j.e(j.h().getMediaInfoList());
    }

    public static int e(List object) {
        int n10;
        int n11 = 0;
        if (object != null && (n10 = object.size()) != 0) {
            float[] fArray;
            float f10;
            float f11 = ((d)(object = (d)object.get(0))).r();
            float f12 = f11 - (f10 = (fArray = EditConfig$a.k)[0]);
            Object object2 = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
            if (object2 <= 0) {
                return 0;
            }
            n11 = 5;
            f10 = fArray[n11];
            float f13 = f11 - f10;
            object2 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
            if (object2 <= 0) {
                return n11;
            }
            n11 = 1;
            f10 = fArray[n11];
            float f14 = f11 - f10;
            object2 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
            if (object2 <= 0) {
                return n11;
            }
            n11 = 2;
            f10 = fArray[n11];
            float f15 = f11 - f10;
            object2 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
            if (object2 <= 0) {
                return n11;
            }
            n11 = 3;
            float f16 = fArray[n11];
            float f17 = f11 - f16;
            Object object3 = f17 == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1);
            if (object3 <= 0) {
                // empty if block
            }
        }
        return n11;
    }

    public static d f(a object) {
        d d10 = new d();
        Object object2 = ((a)object).i();
        object2 = d10.p((String)object2);
        Object object3 = ((a)object).e();
        object2 = ((a)object2).l((String)object3);
        object3 = ((a)object).f();
        object2 = ((a)object2).m((MediaType)((Object)object3));
        long l10 = ((a)object).d();
        object2 = ((a)object2).k(l10);
        boolean bl2 = ((a)object).j();
        object2 = ((a)object2).n(bl2);
        object3 = ((a)object).g();
        object2 = ((a)object2).o((String)object3);
        object = ((b)object).a();
        ((b)object2).b((String)object);
        return j.k(d10);
    }

    public static List g(a[] aArray) {
        ArrayList<a> arrayList = new ArrayList<a>();
        for (a a10 : aArray) {
            String string2;
            if (a10 == null || (string2 = a10.e()) == null || (a10 = j.f(a10)) == null) continue;
            arrayList.add(a10);
        }
        return arrayList;
    }

    private static NvsTimelineData h() {
        return h.t().n();
    }

    public static NvsVideoResolution i(int n10) {
        boolean bl2;
        Object object = j.h().getMediaInfoList();
        if (object != null && !(bl2 = object.isEmpty())) {
            object = (d)object.get(0);
            return j.j(n10, (d)object);
        }
        return null;
    }

    /*
     * Unable to fully structure code
     */
    public static NvsVideoResolution j(int var0, d var1_1) {
        block4: {
            block5: {
                block6: {
                    block7: {
                        var2_2 = 960;
                        var3_3 = 1280;
                        var4_4 = 1.794E-42f;
                        var5_5 = 720;
                        if (var0 == 0) break block5;
                        var6_6 = 2;
                        if (var0 == var6_6) break block4;
                        var6_6 = 3;
                        if (var0 == var6_6) ** GOTO lbl-1000
                        var6_6 = 4;
                        if (var0 == var6_6) break block6;
                        var7_7 = 5;
                        if (var0 == var7_7) break block7;
                        var2_2 = var5_5;
                        break block4;
                    }
lbl17:
                    // 2 sources

                    while (true) {
                        var8_10 = var5_5;
                        var5_5 = var2_2;
                        var2_2 = var8_10;
                        break block4;
                        break;
                    }
                }
                if (var1_1 != null) {
                    var9_9 = var1_1.z();
                    var7_8 = var9_9.getWidth();
                    if (var7_8 >= (var0 = var9_9.getHeight())) {
                        var7_8 = var7_8 * var5_5 / var0;
                        var0 = var7_8 % 4;
                        var2_2 = var7_8 - var0;
                    } else {
                        var0 = var0 * var5_5 / var7_8;
                        var7_8 = var0 % 2;
                        var2_2 = var0 - var7_8;
                        ** continue;
                    }
                }
                break block5;
lbl-1000:
                // 1 sources

                {
                    var2_2 = var3_3;
                }
                break block4;
            }
            var2_2 = var5_5;
            var5_5 = var3_3;
        }
        var9_9 = new NvsVideoResolution();
        var9_9.imageWidth = var2_2;
        var9_9.imageHeight = var5_5;
        return var9_9;
    }

    public static d k(d d10) {
        block9: {
            MediaType mediaType;
            MediaType mediaType2;
            int n10;
            Object object;
            float f10;
            Object object2;
            int n11;
            Object object3;
            Size size;
            float f11;
            int n12;
            block11: {
                block10: {
                    n12 = 0;
                    f11 = 0.0f;
                    size = null;
                    if (d10 == null) {
                        return null;
                    }
                    boolean bl2 = d10.j();
                    object3 = bl2 ? d10.g() : d10.e();
                    n11 = TextUtils.isEmpty((CharSequence)object3);
                    if (n11 != 0) {
                        return null;
                    }
                    object2 = NvsStreamingContext.getInstance();
                    object3 = object2.getAVFileInfo((String)object3);
                    if (object3 == null) {
                        return null;
                    }
                    n11 = 0;
                    f10 = 0.0f;
                    object2 = null;
                    object = ((NvsAVFileInfo)object3).getVideoStreamDimension(0);
                    if (object == null || (n10 = object.width) == 0 && (n10 = object.height) == 0) break block9;
                    n12 = ((NvsAVFileInfo)object3).getVideoStreamRotation(0);
                    n11 = 1;
                    f10 = Float.MIN_VALUE;
                    if (n12 == n11) break block10;
                    n11 = 3;
                    f10 = 4.2E-45f;
                    if (n12 != n11) break block11;
                }
                n12 = object.width;
                object.width = n11 = object.height;
                object.height = n12;
            }
            n11 = object.width;
            int n13 = object.height;
            size = new Size(n11, n13);
            d10.c0(size);
            n11 = size.getWidth();
            f10 = n11;
            n12 = size.getHeight();
            f11 = n12;
            d10.T(f10 /= f11);
            long l10 = ((NvsAVFileInfo)object3).getDuration();
            long l11 = 0L;
            n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
            long l12 = 3000000L;
            long l13 = n10 != 0 && (mediaType2 = d10.f()) == (mediaType = MediaType.VIDEO) ? l10 : l12;
            d10.k(l13);
            l13 = d10.u();
            n11 = (int)(l13 == l11 ? 0 : (l13 < l11 ? -1 : 1));
            if (n11 == 0) {
                object2 = d10.f();
                if (object2 != (object = MediaType.GIF) && (object2 = d10.f()) != (object = MediaType.IMAGE)) {
                    d10.W(l10);
                } else {
                    d10.W(l12);
                }
            }
            return d10;
        }
        return null;
    }
}

