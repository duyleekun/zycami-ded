/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.SparseArray
 *  android.webkit.URLUtil
 */
package com.zhiyun.device.firmware;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.webkit.URLUtil;
import androidx.core.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.device.data.local.entity.DeviceInfo;
import com.zhiyun.device.data.local.entity.FirmwareInfo;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel$FirmwareFailType;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel$a;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel$b;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel$c;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel$d;
import com.zhiyun.net.download.DownloadApi;
import com.zhiyun.net.download.DownloadService;
import com.zhiyun.protocol.constants.Model;
import com.zhiyun.protocol.message.bl.other.UpgradeLink;
import com.zhiyun.stabilizer.exception.StabilizerDisconnectionException;
import d.v.e.f;
import d.v.e.l.b2;
import d.v.e.l.k2;
import d.v.e.l.p2;
import d.v.e.l.s1;
import d.v.e.l.x1;
import d.v.e0.ce;
import d.v.e0.xd;
import d.v.g.g.a0;
import d.v.g.g.b;
import d.v.g.g.b0;
import d.v.g.g.c0;
import d.v.g.g.d1;
import d.v.g.g.f0;
import d.v.g.g.g0;
import d.v.g.g.h0;
import d.v.g.g.i0;
import d.v.g.g.j0;
import d.v.g.g.k0;
import d.v.g.g.l0;
import d.v.g.g.m0;
import d.v.g.g.n0;
import d.v.g.g.o0;
import d.v.g.g.p0;
import d.v.g.g.q0;
import d.v.g.g.r0;
import d.v.g.g.s;
import d.v.g.g.s0;
import d.v.g.g.t;
import d.v.g.g.t0;
import d.v.g.g.u;
import d.v.g.g.u0;
import d.v.g.g.v;
import d.v.g.g.v0;
import d.v.g.g.w;
import d.v.g.g.w0;
import d.v.g.g.x;
import d.v.g.g.x0;
import d.v.g.g.y;
import d.v.g.g.y0;
import d.v.g.g.z;
import d.v.g.g.z0;
import e.a.e0;
import e.a.v0.g;
import e.a.v0.o;
import e.a.v0.r;
import g.d0;
import io.reactivex.internal.functions.Functions;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import k.d;
import kotlin.io.FilesKt__UtilsKt;
import m.a.a;

public class FirmwareUpgradeViewModel
extends ViewModel {
    private static final String A = "PREPARE_UPGRADE_FILE_FAILED";
    private static final String B = "GET_BATTERY_FAILED";
    private static final String C = "BATTERY_LOW";
    private static final String D = "SCAN_OR_CONNECT_FAILED";
    private static final String E = "FAILED_AND_NO_RETRY";
    private static final int F = 850;
    private static final int G = 520;
    private static final int H = 926;
    private static final int I = 876;
    private static final int J = 210;
    public static final int m = 0;
    public static final int n = 1;
    public static final int o = 2;
    public static final int p = 3;
    public static final int q = 4;
    public static final int r = 5;
    public static final int s = 6;
    public static final int t = 7;
    public static final int u = 8;
    public static final int v = 9;
    public static final int w = 10;
    private static final String x = "WIFI_DISCONNECT";
    private static final String y = "BLE_DISCONNECT";
    private static final String z = "GET_MODULE_FAILED";
    private MutableLiveData a;
    private MutableLiveData b;
    private MutableLiveData c;
    private MutableLiveData d;
    private MutableLiveData e;
    private MutableLiveData f;
    private String g;
    private d h;
    private List i;
    private e.a.s0.b j;
    private e.a.s0.b k;
    private e.a.s0.b l;

    public FirmwareUpgradeViewModel() {
        Integer n10 = 0;
        ArrayList arrayList = new ArrayList(n10);
        this.a = arrayList;
        arrayList = new ArrayList(n10);
        this.b = arrayList;
        arrayList = new ArrayList();
        this.c = arrayList;
        arrayList = new ArrayList();
        this.d = arrayList;
        arrayList = new ArrayList();
        this.e = arrayList;
        arrayList = new ArrayList();
        this.f = arrayList;
        this.i = arrayList = new ArrayList();
        this.d();
    }

    private /* synthetic */ void B0(Pair pair, e.a.b0 b02) {
        this.Q0(pair, b02);
    }

    private /* synthetic */ e0 D0(Pair pair, Integer object) {
        object = new r0(this, pair);
        return e.a.z.y1((e.a.c0)object);
    }

    private void F(SparseArray sparseArray) {
        int n10;
        this.i.clear();
        String string2 = this.u();
        for (int i10 = 0; i10 < (n10 = sparseArray.size()); ++i10) {
            Object object = (FirmwareInfo)sparseArray.valueAt(i10);
            Object object2 = URLUtil.guessFileName((String)((FirmwareInfo)object).getUrl(), null, null);
            File file = new File(string2, (String)object2);
            object2 = file.getPath();
            ((FirmwareInfo)object).setPath((String)object2);
            object = this.i;
            object2 = sparseArray.valueAt(i10);
            object.add(object2);
        }
    }

    public static /* synthetic */ void F0(FirmwareUpgradeViewModel firmwareUpgradeViewModel, Pair pair) {
        firmwareUpgradeViewModel.V0(pair);
    }

    private boolean G(FirmwareInfo object) {
        Object object2 = s1.D(((FirmwareInfo)object).getUrl());
        String string2 = this.u();
        long l10 = ((FirmwareInfo)object).getFilesize();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        boolean bl2 = true;
        if (l12 == false) {
            return bl2;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        string2 = File.separator;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        object2 = new File((String)object);
        long l13 = ((File)object2).length();
        l12 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
        string2 = null;
        if (l12 > 0) {
            l12 = (long)bl2;
        } else {
            l12 = 0;
            object = null;
        }
        l11 = ((File)object2).length();
        long l14 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (l14 == false) {
            l14 = (long)bl2;
        } else {
            l14 = 0;
            object2 = null;
        }
        if (l12 != false && l14 != false) {
            bl2 = false;
        }
        return bl2;
    }

    public static /* synthetic */ void G0(FirmwareUpgradeViewModel firmwareUpgradeViewModel, FirmwareInfo firmwareInfo) {
        firmwareUpgradeViewModel.X0(firmwareInfo);
    }

    private boolean H() {
        String string2 = this.j();
        String string3 = this.l();
        return TextUtils.equals((CharSequence)string2, (CharSequence)string3) ^ true;
    }

    public static /* synthetic */ void H0(FirmwareUpgradeViewModel firmwareUpgradeViewModel, Pair pair) {
        firmwareUpgradeViewModel.e(pair);
    }

    public static /* synthetic */ void I(FirmwareUpgradeViewModel firmwareUpgradeViewModel, Throwable throwable) {
        firmwareUpgradeViewModel.i(throwable);
    }

    private Pair I0(Pair object, String object2) {
        boolean bl2;
        Object object3 = new StringBuilder();
        String string2 = this.u();
        object3.append(string2);
        string2 = File.separator;
        object3.append(string2);
        object3 = object3.toString();
        string2 = s1.D(((FirmwareInfo)((Pair)object).second).getPath());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object3);
        object3 = FirmwareUpgradeViewModel.v(string2);
        stringBuilder.append((String)object3);
        object3 = stringBuilder.toString();
        object2 = s1.A((String)object3, (String)object2);
        if (object2 != null && (bl2 = ((File)object2).isFile())) {
            object3 = new Object[]{object2};
            m.a.a.b("Add file to upgrade list: %s", object3);
            object = ((Pair)object).first;
            object3 = new Pair(object, object2);
            return object3;
        }
        return null;
    }

    public static /* synthetic */ e.a.z J(FirmwareUpgradeViewModel firmwareUpgradeViewModel, FirmwareInfo firmwareInfo) {
        return firmwareUpgradeViewModel.N0(firmwareInfo);
    }

    private boolean J0(Pair object) {
        int n10;
        int n11;
        boolean bl2 = false;
        Object object2 = new Object[]{};
        m.a.a.b("filter matched items", (Object[])object2);
        object2 = (xd)((Pair)object).first;
        object = (FirmwareInfo)((Pair)object).second;
        Model model = ((xd)object2).c();
        if (model != null && (n11 = ((FirmwareInfo)object).getSerial()) == (n10 = ((Model)((Object)(object2 = ((xd)object2).c()))).getOtaCode())) {
            bl2 = true;
        }
        return bl2;
    }

    public static /* synthetic */ boolean K(FirmwareUpgradeViewModel firmwareUpgradeViewModel, Pair pair) {
        return firmwareUpgradeViewModel.K0(pair);
    }

    private boolean K0(Pair object) {
        File file = (File)((Pair)object).first;
        object = (k.r)((Pair)object).second;
        Object object2 = ((k.r)object).a();
        boolean bl2 = false;
        if (object2 == null) {
            boolean bl3 = file.exists();
            if (bl3) {
                file.delete();
            }
            return false;
        }
        object = (d0)((k.r)object).a();
        long l10 = ((d0)object).contentLength();
        Object object3 = file.exists();
        boolean bl4 = true;
        if (object3) {
            long l11 = file.length();
            long l12 = l11 - l10;
            object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3) {
                bl2 = bl4;
            }
            return bl2;
        }
        return bl4;
    }

    public static /* synthetic */ void L(FirmwareUpgradeViewModel firmwareUpgradeViewModel, List list) {
        firmwareUpgradeViewModel.S0(list);
    }

    public static /* synthetic */ void M(FirmwareUpgradeViewModel firmwareUpgradeViewModel, Integer n10) {
        firmwareUpgradeViewModel.R0(n10);
    }

    public static /* synthetic */ boolean N(FirmwareUpgradeViewModel firmwareUpgradeViewModel, Pair pair) {
        return firmwareUpgradeViewModel.J0(pair);
    }

    private e.a.z N0(FirmwareInfo object) {
        String string2 = ((FirmwareInfo)object).getUrl();
        String string3 = this.u();
        String string4 = s1.D(string2);
        File file = new File(string3, string4);
        long l10 = file.length();
        object = (DownloadApi)DownloadService.getDownloadRetrofit(((FirmwareInfo)object).getUrl(), 20).g(DownloadApi.class);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bytes=");
        stringBuilder.append(l10);
        stringBuilder.append("-");
        string3 = stringBuilder.toString();
        this.h = object = object.download(string3, string2);
        object = object.execute();
        return e.a.z.t3(Pair.create(file, object));
    }

    public static /* synthetic */ void P(FirmwareUpgradeViewModel firmwareUpgradeViewModel, Pair pair) {
        firmwareUpgradeViewModel.P0(pair);
    }

    /*
     * Exception decompiling
     */
    private void P0(Pair var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static /* synthetic */ void Q(FirmwareUpgradeViewModel firmwareUpgradeViewModel, Throwable throwable) {
        firmwareUpgradeViewModel.f(throwable);
    }

    private void Q0(Pair objectArray, e.a.b0 b02) {
        Object object = (xd)objectArray.first;
        UpgradeLink upgradeLink = ((xd)object).b();
        objectArray = (File)objectArray.second;
        byte[] byArray = s1.i0((File)objectArray);
        long l10 = objectArray.length();
        int n10 = (int)l10;
        String string2 = x1.a((File)objectArray);
        if (byArray == null) {
            objectArray = new IllegalArgumentException("File data is null");
            b02.onError((Throwable)objectArray);
            return;
        }
        int n11 = 1;
        Object object2 = new Object[n11];
        objectArray = objectArray.getName();
        object2[0] = objectArray;
        m.a.a.b("To be upgrade file is : %s", (Object[])object2);
        objectArray = new Object[n11];
        objectArray[0] = upgradeLink;
        m.a.a.b("To be upgrade link is : %s", objectArray);
        objectArray = new Object[n11];
        objectArray[0] = string2;
        m.a.a.b("To be upgrade md5 is : %s", objectArray);
        objectArray = new Object[n11];
        objectArray[0] = object = Integer.valueOf(n10);
        m.a.a.b("To be upgrade appSize is : %s", objectArray);
        object2 = ce.E0();
        FirmwareUpgradeViewModel$c firmwareUpgradeViewModel$c = new FirmwareUpgradeViewModel$c(this, b02);
        ((ce)object2).j7(upgradeLink, byArray, n10, string2, firmwareUpgradeViewModel$c);
    }

    public static /* synthetic */ boolean R(FirmwareUpgradeViewModel firmwareUpgradeViewModel, FirmwareInfo firmwareInfo) {
        return firmwareUpgradeViewModel.G(firmwareInfo);
    }

    private void R0(Integer serializable) {
        int n10;
        int n11 = serializable;
        if (n11 != (n10 = -1)) {
            int n12 = serializable;
            if (n12 >= (n11 = 50)) {
                return;
            }
            serializable = new IllegalArgumentException(C);
            throw serializable;
        }
        serializable = new IllegalArgumentException(B);
        throw serializable;
    }

    private /* synthetic */ void S(e.a.b0 b02) {
        ce ce2 = ce.E0();
        FirmwareUpgradeViewModel$b firmwareUpgradeViewModel$b = new FirmwareUpgradeViewModel$b(this, b02);
        ce2.T0(firmwareUpgradeViewModel$b);
    }

    private void S0(List object) {
        boolean bl2;
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        String string2 = "Get modules result: %s";
        m.a.a.b(string2, objectArray);
        if (object != null && !(bl2 = object.isEmpty())) {
            return;
        }
        object = new IllegalArgumentException(z);
        throw object;
    }

    private void T0(List object) {
        boolean bl2;
        if (object != null && !(bl2 = object.isEmpty())) {
            return;
        }
        object = new IllegalArgumentException(A);
        throw object;
    }

    public static /* synthetic */ e0 U(List object, xd xd2) {
        object = e.a.z.W2((Iterable)object);
        s0 s02 = new s0(xd2);
        return ((e.a.z)object).H3(s02);
    }

    private void U0() {
        boolean bl2 = this.L0();
        if (bl2 && (bl2 = this.H())) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(x);
            throw illegalArgumentException;
        }
    }

    private /* synthetic */ e0 V(Pair pair) {
        e.a.z z10 = e.a.z.t3(this.W0(pair));
        Object object = new z0(pair);
        z10 = z10.o2((r)object);
        object = new g0(pair);
        z10 = z10.s2((o)object);
        object = new a0(this, pair);
        return z10.H3((o)object);
    }

    private void V0(Pair object) {
        boolean bl2;
        UpgradeLink upgradeLink;
        object = (xd)((Pair)object).first;
        if (object == null) {
            return;
        }
        UpgradeLink upgradeLink2 = ((xd)object).b();
        if (upgradeLink2 == (upgradeLink = UpgradeLink.WIFI)) {
            boolean bl3 = this.H();
            if (bl3) {
                object = new IllegalArgumentException(x);
                throw object;
            }
        } else if ((object = ((xd)object).b()) == (upgradeLink2 = UpgradeLink.BLE) && !(bl2 = ce.z1())) {
            object = new IllegalArgumentException(y);
            throw object;
        }
    }

    private boolean W0(Pair object) {
        Object object2 = new Object[]{object};
        m.a.a.b("try unzip. %s", (Object[])object2);
        object2 = new StringBuilder();
        String string2 = this.u();
        ((StringBuilder)object2).append(string2);
        string2 = File.separator;
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        object = s1.D(((FirmwareInfo)((Pair)object).second).getPath());
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)object2);
        CharSequence charSequence2 = FirmwareUpgradeViewModel.v((String)object);
        ((StringBuilder)charSequence).append((String)charSequence2);
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        ((StringBuilder)charSequence2).append(string2);
        string2 = ((StringBuilder)charSequence2).toString();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)object2);
        ((StringBuilder)charSequence).append((String)object);
        object = ((StringBuilder)charSequence).toString();
        return p2.b(string2, (String)object);
    }

    public static /* synthetic */ boolean X(Pair pair) {
        boolean bl2;
        if (pair != null) {
            bl2 = true;
        } else {
            bl2 = false;
            pair = null;
        }
        return bl2;
    }

    private void X0(FirmwareInfo object) {
        Object[] objectArray = this.a;
        int n10 = 1;
        Integer n11 = n10;
        objectArray.setValue(n11);
        int n12 = this.i.indexOf(object);
        objectArray = new StringBuilder();
        objectArray.append("(");
        objectArray.append(n12 += n10);
        objectArray.append("/");
        n12 = this.i.size();
        objectArray.append(n12);
        objectArray.append(")");
        object = objectArray.toString();
        objectArray = new Object[n10];
        objectArray[0] = object;
        m.a.a.b("ready download part: %s", objectArray);
    }

    private /* synthetic */ void Y(e.a.b0 b02) {
        ce ce2 = ce.E0();
        FirmwareUpgradeViewModel$d firmwareUpgradeViewModel$d = new FirmwareUpgradeViewModel$d(this, b02);
        ce2.f1(firmwareUpgradeViewModel$d);
    }

    private /* synthetic */ void a0() {
        MutableLiveData mutableLiveData = this.a;
        Integer n10 = 4;
        mutableLiveData.setValue(n10);
        this.h = null;
    }

    public static /* synthetic */ MutableLiveData b(FirmwareUpgradeViewModel firmwareUpgradeViewModel) {
        return firmwareUpgradeViewModel.a;
    }

    public static /* synthetic */ MutableLiveData c(FirmwareUpgradeViewModel firmwareUpgradeViewModel) {
        return firmwareUpgradeViewModel.b;
    }

    private /* synthetic */ e0 c0(Pair pair) {
        e.a.z z10 = this.s();
        Object object = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object);
        object = new x(this);
        z10 = z10.f2((g)object);
        object = new q0(this, pair);
        z10 = z10.s2((o)object);
        object = new i0(pair);
        return z10.H3((o)object);
    }

    private void e(Pair object) {
        String string2;
        block5: {
            block8: {
                block7: {
                    int n10;
                    Object object2;
                    block6: {
                        object2 = (Integer)((Pair)object).first;
                        int n11 = (Integer)object2;
                        n10 = 210;
                        string2 = E;
                        if (n11 == n10) break block5;
                        n10 = 520;
                        if (n11 == n10) break block6;
                        int n12 = 926;
                        if (n11 == n12) {
                            object = this.a;
                            n11 = 10;
                            object2 = n11;
                            ((MutableLiveData)object).setValue(object2);
                        }
                        break block7;
                    }
                    object2 = this.a;
                    n10 = 6;
                    Integer n13 = n10;
                    ((MutableLiveData)object2).setValue(n13);
                    object = (xd)((Pair)object).second;
                    boolean bl2 = ((xd)object).e();
                    if (bl2) break block8;
                }
                return;
            }
            object = new IllegalArgumentException(string2);
            throw object;
        }
        object = new IllegalArgumentException(string2);
        throw object;
    }

    private /* synthetic */ void e0() {
        MutableLiveData mutableLiveData = this.a;
        Integer n10 = 10;
        mutableLiveData.setValue(n10);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void f(Throwable object) {
        int n10;
        block20: {
            n10 = 0;
            Object var3_3 = null;
            Object object2 = new Object[]{};
            m.a.a.g((Throwable)object, "upload failed. ", (Object[])object2);
            object2 = this.a;
            int n11 = 9;
            Object object3 = n11;
            ((MutableLiveData)object2).setValue(object3);
            object2 = ((Throwable)object).getMessage();
            if (object2 == null) {
                return;
            }
            int n12 = object instanceof IllegalArgumentException;
            if (n12 == 0) {
                boolean bl2 = object instanceof StabilizerDisconnectionException;
                if (!bl2) return;
                object = this.c;
                FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType = FirmwareUpgradeViewModel$FirmwareFailType.TYPE_FAILED_OTHER;
                ((MutableLiveData)object).setValue((Object)firmwareUpgradeViewModel$FirmwareFailType);
                return;
            }
            object = ((Throwable)object).getMessage();
            ((String)object).hashCode();
            n12 = -1;
            n11 = ((String)object).hashCode();
            switch (n11) {
                case 1605543975: {
                    String string2 = z;
                    boolean bl3 = ((String)object).equals(string2);
                    if (!bl3) break;
                    n10 = 6;
                    break block20;
                }
                case 1508409080: {
                    String string3 = B;
                    boolean bl4 = ((String)object).equals(string3);
                    if (!bl4) break;
                    n10 = 5;
                    break block20;
                }
                case 412306924: {
                    String string4 = D;
                    boolean bl5 = ((String)object).equals(string4);
                    if (!bl5) break;
                    n10 = 4;
                    break block20;
                }
                case -117386782: {
                    String string5 = C;
                    boolean bl6 = ((String)object).equals(string5);
                    if (!bl6) break;
                    n10 = 3;
                    break block20;
                }
                case -182793403: {
                    String string6 = A;
                    boolean bl7 = ((String)object).equals(string6);
                    if (!bl7) break;
                    n10 = 2;
                    break block20;
                }
                case -659479546: {
                    String string7 = x;
                    boolean bl8 = ((String)object).equals(string7);
                    if (!bl8) break;
                    n10 = 1;
                    break block20;
                }
                case -1705306592: {
                    object3 = y;
                    boolean bl9 = ((String)object).equals(object3);
                    if (bl9) break block20;
                }
            }
            n10 = n12;
        }
        switch (n10) {
            default: {
                return;
            }
            case 6: {
                object = this.c;
                FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType = FirmwareUpgradeViewModel$FirmwareFailType.TYPE_GET_MODULE_FAILED;
                ((MutableLiveData)object).setValue((Object)firmwareUpgradeViewModel$FirmwareFailType);
                return;
            }
            case 5: {
                object = this.c;
                FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType = FirmwareUpgradeViewModel$FirmwareFailType.TYPE_GET_BATTERY_FAILED;
                ((MutableLiveData)object).setValue((Object)firmwareUpgradeViewModel$FirmwareFailType);
                return;
            }
            case 4: {
                object = this.c;
                FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType = FirmwareUpgradeViewModel$FirmwareFailType.TYPE_SCAN_OR_CONNECT_FAILED;
                ((MutableLiveData)object).setValue((Object)firmwareUpgradeViewModel$FirmwareFailType);
                return;
            }
            case 3: {
                object = this.c;
                FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType = FirmwareUpgradeViewModel$FirmwareFailType.TYPE_BATTERY_LOW;
                ((MutableLiveData)object).setValue((Object)firmwareUpgradeViewModel$FirmwareFailType);
                return;
            }
            case 2: {
                object = this.c;
                FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType = FirmwareUpgradeViewModel$FirmwareFailType.TYPE_PREPARE_UPGRADE_FILE_FAILED;
                ((MutableLiveData)object).setValue((Object)firmwareUpgradeViewModel$FirmwareFailType);
                this.g();
                return;
            }
            case 1: {
                object = this.c;
                FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType = FirmwareUpgradeViewModel$FirmwareFailType.TYPE_WIFI_DISCONNECT;
                ((MutableLiveData)object).setValue((Object)firmwareUpgradeViewModel$FirmwareFailType);
                return;
            }
            case 0: 
        }
        object = this.c;
        FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType = FirmwareUpgradeViewModel$FirmwareFailType.TYPE_BLE_DISCONNECT;
        ((MutableLiveData)object).setValue((Object)firmwareUpgradeViewModel$FirmwareFailType);
    }

    private void g() {
        Object object = this.u();
        Object object2 = new File((String)object);
        FilesKt__UtilsKt.V((File)object2);
        object2 = this.a;
        object = 0;
        ((MutableLiveData)object2).setValue(object);
    }

    private /* synthetic */ void g0(Boolean bl2) {
        this.U0();
    }

    private void i(Throwable throwable) {
        Object object = this.h;
        boolean bl2 = object.isCanceled();
        if (bl2) {
            object = this.a;
            int n10 = 3;
            Integer n11 = n10;
            ((MutableLiveData)object).setValue(n11);
        } else {
            object = this.a;
            int n12 = 2;
            Integer n13 = n12;
            ((MutableLiveData)object).setValue(n13);
        }
        this.d.setValue(throwable);
    }

    private /* synthetic */ e0 i0(Boolean bl2) {
        return this.x();
    }

    private String j() {
        Object object;
        block10: {
            int n10;
            Object[] objectArray;
            block9: {
                objectArray = "\"";
                try {
                    object = d.v.e.f.a();
                }
                catch (Exception exception) {
                    objectArray = new Object[]{};
                    m.a.a.x("Firmware: \u83b7\u53d6\u8fde\u63a5WiFi\u7684SSID\u5931\u8d25", objectArray);
                    return "";
                }
                object = ((f)object).c();
                object = b2.e((Context)object);
                boolean bl2 = ((String)object).startsWith((String)objectArray);
                n10 = 1;
                if (!bl2) break block9;
                object = ((String)object).substring(n10);
            }
            boolean n11 = ((String)object).endsWith((String)objectArray);
            if (!n11) break block10;
            int n12 = ((String)object).length() - n10;
            object = ((String)object).substring(0, n12);
        }
        return object;
    }

    private /* synthetic */ e0 k0(List list) {
        List list2 = this.i;
        return this.w(list, list2);
    }

    private String l() {
        Object object = this.f;
        object = object != null && (object = ((LiveData)object).getValue()) != null ? ((DeviceInfo)this.f.getValue()).getDeviceName() : "";
        return object;
    }

    private /* synthetic */ void m0(SparseArray sparseArray, Boolean bl2) {
        this.F(sparseArray);
    }

    private /* synthetic */ e0 o0(Boolean bl2) {
        return e.a.z.W2(this.i);
    }

    private /* synthetic */ void q0(FirmwareInfo object) {
        this.e.setValue(object);
        object = this.a;
        Integer n10 = 0;
        ((MutableLiveData)object).setValue(n10);
    }

    private e.a.z s() {
        c0 c02 = new c0(this);
        return e.a.z.y1(c02);
    }

    private /* synthetic */ void s0(Throwable object) {
        boolean bl2 = object instanceof NoSuchElementException;
        if (bl2) {
            object = this.a;
            int n10 = 4;
            Integer n11 = n10;
            ((MutableLiveData)object).setValue(n11);
        }
    }

    private String u() {
        return k2.K().getAbsolutePath();
    }

    public static /* synthetic */ void u0(FirmwareUpgradeViewModel firmwareUpgradeViewModel, List list) {
        firmwareUpgradeViewModel.T0(list);
    }

    public static String v(String string2) {
        int n10;
        if (string2 == null) {
            return "";
        }
        String string3 = ".";
        int n11 = string2.lastIndexOf(string3);
        if (n11 == (n10 = -1)) {
            return string2.trim();
        }
        return string2.substring(0, n11).trim();
    }

    public static /* synthetic */ Pair v0(Pair object, Integer n10) {
        object = ((Pair)object).first;
        return Pair.create(n10, object);
    }

    public static /* synthetic */ Pair w0(xd xd2, FirmwareInfo firmwareInfo) {
        return Pair.create(xd2, firmwareInfo);
    }

    private e.a.z x() {
        Object object = new Object[]{};
        m.a.a.b("ready get modules", (Object[])object);
        object = this.a;
        Integer n10 = 5;
        ((MutableLiveData)object).setValue(n10);
        object = new d.v.g.g.e0(this);
        return e.a.z.y1((e.a.c0)object);
    }

    public static /* synthetic */ boolean x0(Pair stringArray, Boolean bl2) {
        boolean bl3;
        boolean bl4 = bl2;
        if (bl4 && (stringArray = ((xd)stringArray.first).d()) != null) {
            bl3 = true;
        } else {
            bl3 = false;
            stringArray = null;
        }
        return bl3;
    }

    public static /* synthetic */ e0 y0(Pair pair, Boolean bl2) {
        return e.a.z.Q2(((xd)pair.first).d());
    }

    private /* synthetic */ Pair z0(Pair pair, String string2) {
        return this.I0(pair, string2);
    }

    public void A(DeviceInfo object, SparseArray object2) {
        this.f.setValue(object);
        object = this.e;
        Object object3 = object2.valueAt(0);
        ((MutableLiveData)object).setValue(object3);
        object = this.a;
        Object object4 = 0;
        ((MutableLiveData)object).setValue(object4);
        object = e.a.z.t3(Boolean.TRUE);
        object4 = new t(this, (SparseArray)object2);
        object = ((e.a.z)object).f2((g)object4);
        object2 = new h0(this);
        object = ((e.a.z)object).s2((o)object2);
        object2 = new k0(this);
        object = ((e.a.z)object).o2((r)object2).r2();
        object2 = new y0(this);
        object4 = new w0(this);
        this.j = object = ((e.a.i0)object).c((g)object2, (g)object4);
    }

    public /* synthetic */ Pair A0(Pair pair, String string2) {
        return this.z0(pair, string2);
    }

    public /* synthetic */ void C0(Pair pair, e.a.b0 b02) {
        this.B0(pair, b02);
    }

    public /* synthetic */ e0 E0(Pair pair, Integer n10) {
        return this.D0(pair, n10);
    }

    public boolean L0() {
        boolean bl2 = ce.A1();
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        Model model = ce.E0().y0().b;
        Model model2 = Model.COV_01;
        if (model == model2) {
            bl3 = true;
        }
        return bl3;
    }

    public void M0() {
        d d10 = this.h;
        if (d10 != null) {
            d10.cancel();
        }
    }

    public void O0() {
    }

    public /* synthetic */ void T(e.a.b0 b02) {
        this.S(b02);
    }

    public /* synthetic */ e0 W(Pair pair) {
        return this.V(pair);
    }

    public /* synthetic */ void Z(e.a.b0 b02) {
        this.Y(b02);
    }

    public /* synthetic */ void b0() {
        this.a0();
    }

    public void d() {
        boolean bl2;
        Iterator iterator2 = d1.i().h().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = (String)iterator2.next();
            d1 d12 = d1.i();
            FirmwareUpgradeViewModel$a firmwareUpgradeViewModel$a = new FirmwareUpgradeViewModel$a(this);
            d12.b(string2, firmwareUpgradeViewModel$a);
        }
    }

    public /* synthetic */ e0 d0(Pair pair) {
        return this.c0(pair);
    }

    public /* synthetic */ void f0() {
        this.e0();
    }

    public /* synthetic */ void h0(Boolean bl2) {
        this.g0(bl2);
    }

    public /* synthetic */ e0 j0(Boolean bl2) {
        return this.i0(bl2);
    }

    public MutableLiveData k() {
        return this.f;
    }

    public /* synthetic */ e0 l0(List list) {
        return this.k0(list);
    }

    public MutableLiveData m() {
        return this.d;
    }

    public MutableLiveData n() {
        return this.c;
    }

    public /* synthetic */ void n0(SparseArray sparseArray, Boolean bl2) {
        this.m0(sparseArray, bl2);
    }

    public MutableLiveData o() {
        return this.e;
    }

    public void onCleared() {
        boolean bl2;
        e.a.s0.b b10 = this.j;
        if (b10 != null && !(bl2 = b10.isDisposed())) {
            b10 = this.j;
            b10.dispose();
        }
        if ((b10 = this.k) != null && !(bl2 = b10.isDisposed())) {
            b10 = this.k;
            b10.dispose();
        }
        if ((b10 = this.l) != null && !(bl2 = b10.isDisposed())) {
            b10 = this.l;
            b10.dispose();
        }
        ce.E0().E();
        d1.i().f();
    }

    public MutableLiveData p() {
        return this.a;
    }

    public /* synthetic */ e0 p0(Boolean bl2) {
        return this.o0(bl2);
    }

    public List r() {
        return this.i;
    }

    public /* synthetic */ void r0(FirmwareInfo firmwareInfo) {
        this.q0(firmwareInfo);
    }

    public MutableLiveData t() {
        return this.b;
    }

    public /* synthetic */ void t0(Throwable throwable) {
        this.s0(throwable);
    }

    public e.a.z w(List object, List object2) {
        object = e.a.z.W2((Iterable)object);
        m0 m02 = new m0((List)object2);
        object = ((e.a.z)object).s2(m02);
        object2 = new z(this);
        object = ((e.a.z)object).o2((r)object2);
        object2 = new t0(this);
        object = ((e.a.z)object).s2((o)object2);
        object2 = d.v.g.g.y.a;
        return ((e.a.z)object).o2((r)object2).X6().v1();
    }

    public void y() {
        Object object = e.a.z.W2(this.i);
        Object object2 = new k0(this);
        object = ((e.a.z)object).o2((r)object2);
        object2 = e.a.q0.c.a.c();
        object = ((e.a.z)object).i4((e.a.h0)object2);
        object2 = new u0(this);
        object = ((e.a.z)object).f2((g)object2);
        object2 = e.a.c1.b.d();
        object = ((e.a.z)object).i4((e.a.h0)object2);
        object2 = new s(this);
        object = ((e.a.z)object).s2((o)object2);
        object2 = new v(this);
        object = ((e.a.z)object).o2((r)object2);
        object2 = new b0(this);
        object = ((e.a.z)object).f2((g)object2);
        object2 = e.a.q0.c.a.c();
        object = ((e.a.z)object).i4((e.a.h0)object2);
        object2 = new j0(this);
        object = ((e.a.z)object).Y1((e.a.v0.a)object2);
        object2 = Functions.h();
        d.v.g.g.r r10 = new d.v.g.g.r(this);
        this.k = object = ((e.a.z)object).c((g)object2, r10);
    }

    public void z() {
        Object object = this.b;
        Object object2 = 0;
        ((MutableLiveData)object).setValue(object2);
        object = e.a.z.t3(Boolean.TRUE);
        object2 = new d.v.g.g.d0(this);
        object = ((e.a.z)object).f2((g)object2);
        object2 = new l0(this);
        object = ((e.a.z)object).s2((o)object2);
        object2 = new w(this);
        object = ((e.a.z)object).f2((g)object2);
        object2 = e.a.c1.b.d();
        object = ((e.a.z)object).i4((e.a.h0)object2);
        object2 = new v0(this);
        object = ((e.a.z)object).s2((o)object2);
        object2 = e.a.q0.c.a.c();
        object = ((e.a.z)object).i4((e.a.h0)object2);
        object2 = new o0(this);
        object = ((e.a.z)object).f2((g)object2);
        object2 = d.v.g.g.b.a;
        object = ((e.a.z)object).s2((o)object2);
        object2 = e.a.c1.b.d();
        object = ((e.a.z)object).i4((e.a.h0)object2);
        object2 = new p0(this);
        object = ((e.a.z)object).f2((g)object2);
        object2 = new n0(this);
        object = ((e.a.z)object).s2((o)object2);
        object2 = e.a.q0.c.a.c();
        object = ((e.a.z)object).i4((e.a.h0)object2);
        object2 = new x0(this);
        object = ((e.a.z)object).f2((g)object2);
        object2 = Functions.h();
        f0 f02 = new f0(this);
        u u10 = new u(this);
        this.l = object = ((e.a.z)object).f((g)object2, f02, u10);
    }
}

