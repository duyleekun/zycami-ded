/*
 * Decompiled with CFR 0.151.
 */
package d.o.a.a.b.c;

import com.quvideo.mobile.external.platform.uploader.OooO;
import com.quvideo.mobile.external.platform.uploader.OooOo00;
import java.util.HashMap;

public class d {
    public static void a(String object) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String string2 = "unique_key";
        hashMap.put(string2, (String)object);
        object = OooOo00.a().b;
        if (object != null) {
            object = OooOo00.a().b;
            string2 = "Dev_Event_OSS_Upload_Cancle";
            object.OooO00o(string2, hashMap);
        }
    }

    public static void b(String object, int n10) {
        HashMap<String, CharSequence> hashMap = new HashMap<String, CharSequence>();
        String string2 = "unique_key";
        hashMap.put(string2, (CharSequence)object);
        object = new StringBuilder();
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("");
        object = ((StringBuilder)object).toString();
        hashMap.put("errorCode", (CharSequence)object);
        String string3 = "new";
        hashMap.put("mode", string3);
        object = OooOo00.a().b;
        if (object != null) {
            object = OooOo00.a().b;
            string3 = "Dev_Event_OSS_Upload_Retry";
            object.OooO00o(string3, hashMap);
        }
    }

    public static void c(String object, int n10, int n11) {
        HashMap<String, CharSequence> hashMap = new HashMap<String, CharSequence>();
        hashMap.put("unique_key", (CharSequence)object);
        object = new StringBuilder();
        ((StringBuilder)object).append(n10);
        String string2 = "";
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        String string3 = "oldErrorCode";
        hashMap.put(string3, (CharSequence)object);
        object = new StringBuilder();
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        hashMap.put("newErrorCode", (CharSequence)object);
        string2 = "new";
        hashMap.put("mode", string2);
        object = OooOo00.a().b;
        if (object != null) {
            object = OooOo00.a().b;
            string2 = "Dev_Event_OSS_Upload_Retry_fail";
            object.OooO00o(string2, hashMap);
        }
    }

    public static void d(String object, int n10, String string2) {
        HashMap<String, CharSequence> hashMap = new HashMap<String, CharSequence>();
        String string3 = "unique_key";
        hashMap.put(string3, (CharSequence)object);
        object = new StringBuilder();
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("");
        object = ((StringBuilder)object).toString();
        String string4 = "errorCode";
        hashMap.put(string4, (CharSequence)object);
        hashMap.put("errorMsg", string2);
        object = OooOo00.a().b;
        if (object != null) {
            object = OooOo00.a().b;
            string4 = "Dev_Event_OSS_Upload_Fail";
            object.OooO00o(string4, hashMap);
        }
    }

    public static void e(String object, OooO object2) {
        HashMap<Object, String> hashMap = new HashMap<Object, String>();
        String string2 = "unique_key";
        hashMap.put(string2, (String)object);
        object = ((OooO)object2).toString();
        object2 = "uploadFileEntity";
        hashMap.put(object2, (String)object);
        object = OooOo00.a().b;
        if (object != null) {
            object = OooOo00.a().b;
            object2 = "Dev_Event_OSS_Upload_Add";
            object.OooO00o((String)object2, hashMap);
        }
    }

    public static void f(String object, String string2, String string3) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String string4 = "unique_key";
        hashMap.put(string4, (String)object);
        hashMap.put("oldUrl", string2);
        hashMap.put("newUrl", string3);
        object = OooOo00.a().b;
        if (object != null) {
            object = OooOo00.a().b;
            string2 = "Dev_Event_OSS_Upload_Url_Error";
            object.OooO00o(string2, hashMap);
        }
    }

    public static void g(String object) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String string2 = "unique_key";
        hashMap.put(string2, (String)object);
        object = OooOo00.a().b;
        if (object != null) {
            object = OooOo00.a().b;
            string2 = "Dev_Event_OSS_Upload_Success";
            object.OooO00o(string2, hashMap);
        }
    }

    public static void h(String object, OooO object2) {
        HashMap<Object, String> hashMap = new HashMap<Object, String>();
        String string2 = "unique_key";
        hashMap.put(string2, (String)object);
        object = ((OooO)object2).toString();
        object2 = "uploadFileEntity";
        hashMap.put(object2, (String)object);
        object = OooOo00.a().b;
        if (object != null) {
            object = OooOo00.a().b;
            object2 = "Dev_Event_OSS_Upload_Start";
            object.OooO00o((String)object2, hashMap);
        }
    }
}

