/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentUris
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ProviderInfo
 *  android.content.pm.Signature
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 */
package androidx.core.provider;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontProvider$1;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat$FontFamilyResult;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FontProvider {
    private static final Comparator sByteArrayComparator;

    static {
        FontProvider$1 fontProvider$1 = new FontProvider$1();
        sByteArrayComparator = fontProvider$1;
    }

    private FontProvider() {
    }

    private static List convertToByteArrayList(Signature[] signatureArray) {
        int n10;
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        for (int i10 = 0; i10 < (n10 = signatureArray.length); ++i10) {
            byte[] byArray = signatureArray[i10].toByteArray();
            arrayList.add(byArray);
        }
        return arrayList;
    }

    private static boolean equalsByteArrayList(List list, List list2) {
        int n10;
        int n11 = list.size();
        if (n11 != (n10 = list2.size())) {
            return false;
        }
        for (n11 = 0; n11 < (n10 = list.size()); ++n11) {
            byte[] byArray;
            byte[] byArray2 = (byte[])list.get(n11);
            n10 = (int)(Arrays.equals(byArray2, byArray = (byte[])list2.get(n11)) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    private static List getCertificates(FontRequest fontRequest, Resources resources) {
        List list = fontRequest.getCertificates();
        if (list != null) {
            return fontRequest.getCertificates();
        }
        int n10 = fontRequest.getCertificatesArrayResId();
        return FontResourcesParserCompat.readCerts(resources, n10);
    }

    public static FontsContractCompat$FontFamilyResult getFontFamilyResult(Context fontsContractCompat$FontInfoArray, FontRequest fontRequest, CancellationSignal cancellationSignal) {
        Object object = fontsContractCompat$FontInfoArray.getPackageManager();
        Resources resources = fontsContractCompat$FontInfoArray.getResources();
        if ((object = FontProvider.getProvider(object, fontRequest, resources)) == null) {
            return FontsContractCompat$FontFamilyResult.create(1, null);
        }
        object = object.authority;
        fontsContractCompat$FontInfoArray = FontProvider.query((Context)fontsContractCompat$FontInfoArray, fontRequest, (String)object, cancellationSignal);
        return FontsContractCompat$FontFamilyResult.create(0, fontsContractCompat$FontInfoArray);
    }

    public static ProviderInfo getProvider(PackageManager object, FontRequest object2, Resources object3) {
        Object object4 = ((FontRequest)object2).getProviderAuthority();
        ProviderInfo providerInfo = object.resolveContentProvider((String)object4, 0);
        if (providerInfo != null) {
            String string2 = providerInfo.packageName;
            String string3 = ((FontRequest)object2).getProviderPackage();
            int n10 = string2.equals(string3);
            if (n10 != 0) {
                int n11;
                object4 = providerInfo.packageName;
                n10 = 64;
                object = FontProvider.convertToByteArrayList(object.getPackageInfo((String)object4, (int)n10).signatures);
                object4 = sByteArrayComparator;
                Collections.sort(object, object4);
                object2 = FontProvider.getCertificates((FontRequest)object2, (Resources)object3);
                for (int i10 = 0; i10 < (n11 = object2.size()); ++i10) {
                    object4 = (Collection)object2.get(i10);
                    object3 = new ArrayList(object4);
                    object4 = sByteArrayComparator;
                    Collections.sort(object3, object4);
                    n11 = (int)(FontProvider.equalsByteArrayList((List)object, (List)object3) ? 1 : 0);
                    if (n11 == 0) continue;
                    return providerInfo;
                }
                return null;
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Found content provider ");
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append(", but package was not ");
            object2 = ((FontRequest)object2).getProviderPackage();
            ((StringBuilder)object3).append((String)object2);
            object2 = ((StringBuilder)object3).toString();
            object = new PackageManager.NameNotFoundException((String)object2);
            throw object;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("No package found for authority: ");
        ((StringBuilder)object2).append((String)object4);
        object2 = ((StringBuilder)object2).toString();
        object = new PackageManager.NameNotFoundException((String)object2);
        throw object;
    }

    public static FontsContractCompat$FontInfo[] query(Context context, FontRequest fontRequest, String fontsContractCompat$FontInfoArray, CancellationSignal cancellationSignal) {
        String string2;
        Object object;
        FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArray2;
        block46: {
            int n10;
            Uri uri;
            int n11;
            int n12;
            int n13;
            Object object2;
            String string3;
            Object object3;
            String string4;
            Object object4;
            String string5;
            Object object5;
            Uri.Builder builder;
            block45: {
                block44: {
                    fontsContractCompat$FontInfoArray2 = fontsContractCompat$FontInfoArray;
                    object = new ArrayList();
                    builder = new Uri.Builder();
                    string2 = "content";
                    builder = builder.scheme(string2).authority((String)fontsContractCompat$FontInfoArray).build();
                    object5 = new Uri.Builder();
                    fontsContractCompat$FontInfoArray2 = object5.scheme(string2).authority((String)fontsContractCompat$FontInfoArray).appendPath("file").build();
                    string2 = null;
                    object5 = "_id";
                    string5 = "file_id";
                    object4 = "font_ttc_index";
                    string4 = "font_variation_settings";
                    object3 = "font_weight";
                    string3 = "font_italic";
                    object2 = "result_code";
                    object4 = new String[]{object5, string5, object4, string4, object3, string3, object2};
                    n13 = Build.VERSION.SDK_INT;
                    n12 = 16;
                    n11 = 1;
                    uri = null;
                    if (n13 <= n12) break block44;
                    object5 = context.getContentResolver();
                    string4 = "query = ?";
                    object3 = new String[n11];
                    string5 = fontRequest.getQuery();
                    object3[0] = string5;
                    n10 = 0;
                    string3 = null;
                    string5 = builder;
                    object2 = cancellationSignal;
                    string2 = object5.query((Uri)builder, object4, string4, object3, null, cancellationSignal);
                    break block45;
                }
                object5 = context.getContentResolver();
                string4 = "query = ?";
                object3 = new String[n11];
                string5 = fontRequest.getQuery();
                object3[0] = string5;
                n10 = 0;
                string3 = null;
                string5 = builder;
                try {
                    string2 = object5.query((Uri)builder, object4, string4, object3, null);
                }
                catch (Throwable throwable) {
                    if (string2 != null) {
                        string2.close();
                    }
                    throw throwable;
                }
            }
            if (string2 != null) {
                n13 = string2.getCount();
                if (n13 <= 0) break block46;
                object = "result_code";
                int n14 = string2.getColumnIndex((String)object);
                object5 = new ArrayList();
                string5 = "_id";
                n12 = string2.getColumnIndex(string5);
                object4 = "file_id";
                int n15 = string2.getColumnIndex((String)object4);
                string4 = "font_ttc_index";
                int n16 = string2.getColumnIndex(string4);
                object3 = "font_weight";
                int n17 = string2.getColumnIndex((String)object3);
                string3 = "font_italic";
                n10 = string2.getColumnIndex(string3);
                while (true) {
                    int n18;
                    int n19;
                    int n20;
                    int n21;
                    block50: {
                        int n22;
                        block49: {
                            long l10;
                            block48: {
                                block47: {
                                    n21 = string2.moveToNext();
                                    if (n21 == 0) break;
                                    n21 = -1;
                                    if (n14 == n21) break block47;
                                    n20 = string2.getInt(n14);
                                    break block48;
                                }
                                n20 = 0;
                            }
                            if (n16 != n21) {
                                n19 = string2.getInt(n16);
                            } else {
                                n19 = 0;
                            }
                            if (n15 == n21) {
                                n22 = n20;
                                l10 = string2.getLong(n12);
                                uri = ContentUris.withAppendedId((Uri)builder, (long)l10);
                            } else {
                                n22 = n20;
                                l10 = string2.getLong(n15);
                                uri = ContentUris.withAppendedId((Uri)fontsContractCompat$FontInfoArray2, (long)l10);
                            }
                            if (n17 != n21) {
                                n20 = string2.getInt(n17);
                            } else {
                                n20 = 400;
                            }
                            if (n10 != n21) {
                                n21 = string2.getInt(n10);
                                if (n21 != n11) break block49;
                                n21 = n22;
                                n18 = n11;
                                break block50;
                            }
                        }
                        n18 = 0;
                        n21 = n22;
                    }
                    object2 = FontsContractCompat$FontInfo.create(uri, n19, n20, n18 != 0, n21);
                    ((ArrayList)object5).add(object2);
                    uri = null;
                    continue;
                    break;
                }
                object = object5;
            }
        }
        if (string2 != null) {
            string2.close();
        }
        fontsContractCompat$FontInfoArray2 = new FontsContractCompat$FontInfo[]{};
        return ((ArrayList)object).toArray(fontsContractCompat$FontInfoArray2);
    }
}

