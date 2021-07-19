/*
 * Decompiled with CFR 0.151.
 */
package j$;

import j$.d;
import j$.time.Instant;
import java.util.Date;

public class $r8$retargetLibraryMember$virtualDispatch$Date$toInstant$dispatchHolder {
    public static Instant toInstant(Date date) {
        boolean bl2 = date instanceof d;
        if (bl2) {
            return ((d)((Object)date)).a();
        }
        return Instant.D(date.getTime());
    }
}

