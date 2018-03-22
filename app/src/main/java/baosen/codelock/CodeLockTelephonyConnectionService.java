package baosen.codelock;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.telecom.Connection;
import android.telecom.ConnectionRequest;
import android.telecom.ConnectionService;
import android.telecom.PhoneAccountHandle;

@RequiresApi(api = Build.VERSION_CODES.M)
public class CodeLockTelephonyConnectionService extends ConnectionService { // TODO: Inherit from TelephonyConnectionService.
    @Override
    public Connection onCreateOutgoingConnection(PhoneAccountHandle connectionManagerPhoneAccount, final ConnectionRequest request) {
        return super.onCreateOutgoingConnection(connectionManagerPhoneAccount, request);
    }
}
