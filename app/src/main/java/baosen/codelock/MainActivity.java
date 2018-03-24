package baosen.codelock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    TelecomManager telecomManager;

    // The type of code the user will protect its payment-ridden functions.
    private enum CodeType {
        PINCODE,
        PASSWORD,
    }

    private CodeType codeTypeSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        accessSettings();

        //displaySettings();
        //displayPinlock();
        //displayPasswordLock();

        //EditText passwordEditText = findViewById(R.id.passwordEditText);
        //telecomManager = getTelecomService();
    }

    private TelecomManager getTelecomService() {
        return (TelecomManager) getSystemService(TELECOM_SERVICE);
    }

    private void askUserToSetNewPincode() {
        setTitle("Set new pincode");
        setContentView(R.layout.activity_set_pincodelock);
        final Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySettings();
            }
        });
    }

    private void askUserToSetNewPassword() {
        setTitle("Set new password");
        setContentView(R.layout.activity_set_passwordlock);
        final Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySettings();
            }
        });
    }

    private void accessSettings() {
        if (codeTypeSet == CodeType.PASSWORD) {
            askUserToSetNewPassword();
        } else if (codeTypeSet == CodeType.PINCODE) {
            askUserToSetNewPincode();
        } else { // No lock currently set.
            displaySettings();
        }
    }

    private void displaySettings() {
        setTitle("Settings");
        setContentView(R.layout.activity_settings);
    }

    private void displayPasswordLock() {
        setTitle("Unlock with password");
        setContentView(R.layout.activity_passwordlock);
    }

    private void displayPinlock() {
        setTitle("Unlock with pincode");
        setContentView(R.layout.activity_pincodelock);
    }
}
