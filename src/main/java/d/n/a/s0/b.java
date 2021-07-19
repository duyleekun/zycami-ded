/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.s0;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class b {
    private static final Map a;

    static {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        Integer n10 = 0;
        hashMap.put(n10, "GATT_SUCCESS");
        n10 = 1;
        hashMap.put(n10, "GATT_INVALID_HANDLE");
        n10 = 2;
        hashMap.put(n10, "GATT_READ_NOT_PERMIT");
        n10 = 3;
        hashMap.put(n10, "GATT_WRITE_NOT_PERMIT");
        n10 = 4;
        hashMap.put(n10, "GATT_INVALID_PDU");
        n10 = 5;
        hashMap.put(n10, "GATT_INSUF_AUTHENTICATION");
        n10 = 6;
        hashMap.put(n10, "GATT_REQ_NOT_SUPPORTED");
        n10 = 7;
        hashMap.put(n10, "GATT_INVALID_OFFSET");
        n10 = 8;
        hashMap.put(n10, "GATT_INSUF_AUTHORIZATION or GATT_CONN_TIMEOUT");
        n10 = 9;
        hashMap.put(n10, "GATT_PREPARE_Q_FULL");
        n10 = 10;
        hashMap.put(n10, "GATT_NOT_FOUND");
        n10 = 11;
        hashMap.put(n10, "GATT_NOT_LONG");
        n10 = 12;
        hashMap.put(n10, "GATT_INSUF_KEY_SIZE");
        n10 = 13;
        hashMap.put(n10, "GATT_INVALID_ATTR_LEN");
        n10 = 14;
        hashMap.put(n10, "GATT_ERR_UNLIKELY");
        n10 = 15;
        hashMap.put(n10, "GATT_INSUF_ENCRYPTION");
        n10 = 16;
        hashMap.put(n10, "GATT_UNSUPPORT_GRP_TYPE");
        n10 = 17;
        hashMap.put(n10, "GATT_INSUF_RESOURCE");
        n10 = 19;
        hashMap.put(n10, "GATT_CONN_TERMINATE_PEER_USER");
        n10 = 22;
        hashMap.put(n10, "GATT_CONN_TERMINATE_LOCAL_HOST");
        n10 = 34;
        hashMap.put(n10, "GATT_CONN_LMP_TIMEOUT");
        n10 = 62;
        hashMap.put(n10, "GATT_CONN_FAIL_ESTABLISH");
        n10 = 135;
        hashMap.put(n10, "GATT_ILLEGAL_PARAMETER");
        n10 = 128;
        hashMap.put(n10, "GATT_NO_RESOURCES");
        n10 = 129;
        hashMap.put(n10, "GATT_INTERNAL_ERROR");
        n10 = 130;
        hashMap.put(n10, "GATT_WRONG_STATE");
        n10 = 131;
        hashMap.put(n10, "GATT_DB_FULL");
        n10 = 132;
        hashMap.put(n10, "GATT_BUSY");
        n10 = 133;
        hashMap.put(n10, "GATT_ERROR");
        n10 = 134;
        hashMap.put(n10, "GATT_CMD_STARTED");
        n10 = 136;
        hashMap.put(n10, "GATT_PENDING");
        n10 = 137;
        hashMap.put(n10, "GATT_AUTH_FAIL");
        n10 = 138;
        hashMap.put(n10, "GATT_MORE");
        n10 = 139;
        hashMap.put(n10, "GATT_INVALID_CFG");
        n10 = 140;
        hashMap.put(n10, "GATT_SERVICE_STARTED");
        n10 = 141;
        hashMap.put(n10, "GATT_ENCRYPED_NO_MITM");
        n10 = 142;
        hashMap.put(n10, "GATT_NOT_ENCRYPTED");
        n10 = 143;
        hashMap.put(n10, "GATT_CONGESTED");
        n10 = 253;
        hashMap.put(n10, "GATT_CCC_CFG_ERR");
        n10 = 254;
        hashMap.put(n10, "GATT_PRC_IN_PROGRESS");
        n10 = 255;
        hashMap.put(n10, "GATT_OUT_OF_RANGE");
        n10 = 256;
        hashMap.put(n10, "GATT_CONN_CANCEL");
        a = Collections.unmodifiableMap(hashMap);
    }

    private b() {
    }

    public static String a(int n10) {
        Map map = a;
        Object object = n10;
        if ((object = (String)map.get(object)) == null) {
            object = "UNKNOWN";
        }
        return object;
    }
}

