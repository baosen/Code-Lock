package baosen.codelock;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.telecom.Connection;
import android.telecom.ConnectionRequest;
import android.telecom.ConnectionService;
import android.telecom.PhoneAccountHandle;
import android.telephony.PhoneNumberUtils;

@RequiresApi(api = Build.VERSION_CODES.M)
public class CodeLockTelephonyConnectionService extends ConnectionService { // TODO: Inherit from TelephonyConnectionService.
    @Override
    public Connection onCreateOutgoingConnection(PhoneAccountHandle connectionManagerPhoneAccount, final ConnectionRequest request) {
        String numberToDial = request.getAddress().getSchemeSpecificPart();

        // Check if the user is dialing an emergency number.
        if (PhoneNumberUtils.isLocalEmergencyNumber(this, numberToDial))
            // Do the call!
            return super.onCreateOutgoingConnection(connectionManagerPhoneAccount, request);

        // TODO: Ask for code.
    }
}
