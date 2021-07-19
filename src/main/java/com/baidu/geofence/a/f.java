/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.baidu.geofence.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.geofence.GeoFenceListener;
import com.baidu.geofence.a.a;
import com.baidu.geofence.a.f$a;
import com.baidu.geofence.model.DPoint;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.location.b.aa;
import com.baidu.location.h.l;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class f
extends com.baidu.location.h.f
implements LBSAuthManagerListener {
    private final String a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private DPoint f;
    private float q;
    private int r;
    private String s;
    private boolean t = false;
    private GeoFenceListener u;
    private String v;
    private ArrayList w;
    private f$a x;

    public f(Context context, boolean bl2, GeoFenceListener geoFenceListener, ArrayList arrayList) {
        HashMap hashMap;
        this.a = "https://api.map.baidu.com/sdkproxy/v2/lbs_locsdk/place/v2/search";
        this.k = hashMap = new HashMap();
        this.e = bl2;
        this.w = arrayList;
        this.u = geoFenceListener;
        LBSAuthManager.getInstance(context).authenticate(false, "lbs_locsdk", null, this);
    }

    public static /* synthetic */ GeoFenceListener a(f f10) {
        return f10.u;
    }

    private void a() {
        boolean bl2 = this.t;
        if (bl2) {
            return;
        }
        this.t = true;
        ExecutorService executorService = aa.a().c();
        this.a(executorService);
    }

    public static /* synthetic */ String b(f f10) {
        return f10.v;
    }

    public static /* synthetic */ f$a c(f f10) {
        return f10.x;
    }

    public void a(float f10) {
        this.q = f10;
    }

    public void a(int n10) {
        this.r = n10;
    }

    public void a(f$a f$a) {
        this.x = f$a;
    }

    public void a(DPoint dPoint) {
        this.f = dPoint;
    }

    public void a(String string2) {
        this.v = string2;
    }

    /*
     * Exception decompiling
     */
    public void a(boolean var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 27[TRYBLOCK] [27 : 483->486)] org.json.JSONException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        CharSequence charSequence = ",";
        CharSequence charSequence2 = "UTF-8";
        int n10 = 128;
        StringBuffer stringBuffer = new StringBuffer(n10);
        HashMap<CharSequence, CharSequence> hashMap = new HashMap<CharSequence, CharSequence>();
        String string2 = this.b;
        hashMap.put("query", string2);
        string2 = this.c;
        hashMap.put("token", string2);
        string2 = this.d;
        hashMap.put("tag", string2);
        Object object = "json";
        hashMap.put("output", (CharSequence)object);
        Object object2 = "20";
        hashMap.put("page_size", (CharSequence)object2);
        String string3 = "gcj02ll";
        hashMap.put("ret_coordtype", string3);
        string2 = "query=";
        try {
            stringBuffer.append(string2);
            string2 = this.b;
            string2 = URLEncoder.encode(string2, (String)charSequence2);
            stringBuffer.append(string2);
            string2 = "&output=";
            stringBuffer.append(string2);
            string2 = URLEncoder.encode((String)object, (String)charSequence2);
            stringBuffer.append(string2);
            string2 = "&ret_coordtype=";
            stringBuffer.append(string2);
            string2 = URLEncoder.encode(string3, (String)charSequence2);
            stringBuffer.append(string2);
            string2 = "&token=";
            stringBuffer.append(string2);
            string2 = this.c;
            string2 = URLEncoder.encode(string2, (String)charSequence2);
            stringBuffer.append(string2);
            string2 = "&tag=";
            stringBuffer.append(string2);
            string2 = this.d;
            string2 = URLEncoder.encode(string2, (String)charSequence2);
            stringBuffer.append(string2);
            string2 = "&page_size=";
            stringBuffer.append(string2);
            string2 = URLEncoder.encode((String)object2, (String)charSequence2);
            stringBuffer.append(string2);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
        int n11 = this.e;
        if (n11 != 0) {
            n11 = 2;
            object = "&location=";
            try {
                stringBuffer.append((String)object);
                object = new StringBuilder();
                object2 = this.f;
                double d10 = ((DPoint)object2).getLatitude();
                ((StringBuilder)object).append(d10);
                ((StringBuilder)object).append((String)charSequence);
                object2 = this.f;
                d10 = ((DPoint)object2).getLongitude();
                ((StringBuilder)object).append(d10);
                object = ((StringBuilder)object).toString();
                object = URLEncoder.encode((String)object, (String)charSequence2);
                stringBuffer.append((String)object);
                object = "&coord_type=";
                stringBuffer.append((String)object);
                object = String.valueOf(n11);
                object = URLEncoder.encode((String)object, (String)charSequence2);
                stringBuffer.append((String)object);
                object = "&radius=";
                stringBuffer.append((String)object);
                float f10 = this.q;
                object = String.valueOf(f10);
                charSequence2 = URLEncoder.encode((String)object, (String)charSequence2);
                stringBuffer.append((String)charSequence2);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            }
            charSequence2 = new StringBuilder();
            object = this.f;
            double d11 = ((DPoint)object).getLatitude();
            ((StringBuilder)charSequence2).append(d11);
            ((StringBuilder)charSequence2).append((String)charSequence);
            d11 = this.f.getLongitude();
            ((StringBuilder)charSequence2).append(d11);
            charSequence = ((StringBuilder)charSequence2).toString();
            hashMap.put("location", charSequence);
            charSequence = String.valueOf(n11);
            hashMap.put("coord_type", charSequence);
            float f11 = this.q;
            charSequence = String.valueOf(f11);
            charSequence2 = "radius";
        } else {
            charSequence = "&region=";
            stringBuffer.append((String)charSequence);
            try {
                charSequence = this.s;
                charSequence = URLEncoder.encode((String)charSequence, (String)charSequence2);
                stringBuffer.append((String)charSequence);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            }
            charSequence = this.s;
            charSequence2 = "region";
        }
        hashMap.put(charSequence2, charSequence);
        charSequence = com.baidu.geofence.a.a.a(hashMap, "&");
        stringBuffer.append("&sign=");
        stringBuffer.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("https://api.map.baidu.com/sdkproxy/v2/lbs_locsdk/place/v2/search?");
        charSequence2 = stringBuffer.toString();
        ((StringBuilder)charSequence).append((String)charSequence2);
        charSequence = ((StringBuilder)charSequence).toString();
        this.h = charSequence;
    }

    public void b(String string2) {
        this.b = string2;
    }

    public void c(String string2) {
        this.d = string2;
    }

    public void d(String string2) {
        this.s = string2;
    }

    public void onAuthResult(int n10, String string2) {
        block11: {
            Object object;
            String string3 = "token";
            if (n10 != 0 && (object = this.u) != null) {
                int n11 = 11;
                String string4 = this.v;
                object.onGeoFenceCreateFinished(null, n11, string4);
            }
            if (string2 != null) {
                object = new JSONObject(string2);
                boolean bl2 = object.has(string3);
                if (!bl2) break block11;
                object = object.optString(string3);
                this.c = object;
                n10 = (int)(com.baidu.location.h.l.b() ? 1 : 0);
                if (n10 != 0) break block11;
                object = this.c;
                n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                if (n10 != 0) break block11;
                try {
                    this.a();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}

