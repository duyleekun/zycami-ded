/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package cn.sharesdk.framework.a;

import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.network.HTTPPart;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import com.mob.tools.network.RawNetworkCallback;
import java.util.ArrayList;

public class b
extends NetworkHelper {
    private static b a;

    private b() {
    }

    public static b a() {
        b b10 = a;
        if (b10 == null) {
            a = b10 = new b();
        }
        return a;
    }

    private void a(String string2, int n10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && n10 > 0) {
            ShareSDK.logApiEvent(string2, n10);
        }
    }

    public String a(String string2, ArrayList arrayList, KVPair kVPair, String string3, int n10) {
        return this.a(string2, arrayList, kVPair, null, string3, n10);
    }

    public String a(String string2, ArrayList arrayList, KVPair kVPair, ArrayList arrayList2, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut, String string3, int n10) {
        this.a(string3, n10);
        return super.httpPost(string2, arrayList, kVPair, arrayList2, networkHelper$NetworkTimeOut);
    }

    public String a(String string2, ArrayList arrayList, KVPair kVPair, ArrayList arrayList2, String string3, int n10) {
        return this.a(string2, arrayList, kVPair, arrayList2, null, string3, n10);
    }

    public String a(String string2, ArrayList arrayList, String string3, int n10) {
        return this.a(string2, arrayList, (ArrayList)null, (NetworkHelper$NetworkTimeOut)null, string3, n10);
    }

    public String a(String string2, ArrayList arrayList, ArrayList arrayList2, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut, String string3, int n10) {
        this.a(string3, n10);
        return super.httpGet(string2, arrayList, arrayList2, networkHelper$NetworkTimeOut);
    }

    public void a(String string2, ArrayList arrayList, HTTPPart hTTPPart, RawNetworkCallback rawNetworkCallback, String string3, int n10) {
        this.a(string3, n10);
        super.rawPost(string2, arrayList, hTTPPart, rawNetworkCallback, null);
    }

    public String b(String string2, ArrayList arrayList, String string3, int n10) {
        return this.a(string2, arrayList, null, string3, n10);
    }

    public String b(String string2, ArrayList arrayList, ArrayList arrayList2, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut, String string3, int n10) {
        this.a(string3, n10);
        return super.jsonPost(string2, arrayList, arrayList2, networkHelper$NetworkTimeOut);
    }
}

