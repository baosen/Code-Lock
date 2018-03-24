package baosen.codelock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    TelecomManager telecomManager;

    // The type of code the user will protect its payment-ridden functions.
    private enum CodeType {
        PINCODE,
        PASSWORD,
    }

    private CodeType codeTypeSet;
    private String code; // TODO: Hash it with bcrypt!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        accessSettings();
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
                codeTypeSet = CodeType.PINCODE;
                code = getPincodeInputted();
                accessSettings();
            }
        });
    }

    private String getPincodeInputted() {
        return ((EditText)findViewById(R.id.editText2)).getText().toString();
    }

    private void askUserToSetNewPassword() {
        setTitle("Set new password");
        setContentView(R.layout.activity_set_passwordlock);
        final Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codeTypeSet = CodeType.PASSWORD;
                code = ((EditText)findViewById(R.id.passwordEditText)).getText().toString();
                accessSettings();
            }
        });
    }

    private void accessSettings() {
        if (codeTypeSet == CodeType.PASSWORD) {
            displayPasswordLock();
        } else if (codeTypeSet == CodeType.PINCODE) {
            displayPinlock();
        } else { // No lock currently set.
            displaySettings();
        }
    }

    private void setupSettingsButtons() {
        Button setNewPincodeButton = findViewById(R.id.button2);
        setNewPincodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askUserToSetNewPincode();
            }
        });

        Button setNewPasswordButton = findViewById(R.id.button6);
        setNewPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askUserToSetNewPassword();
            }
        });
    }

    private void displaySettings() {
        setTitle("Settings");
        setContentView(R.layout.activity_settings);
        setupSettingsButtons();
    }

    private void displayPasswordLock() {
        setTitle("Unlock with password");
        setContentView(R.layout.activity_passwordlock);
    }

    private void displayPinlock() {
        setTitle("Unlock with pincode");
        setContentView(R.layout.activity_pincodelock);

        Button unlockButton = findViewById(R.id.button3);
        unlockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getPincodeInputted().equals(code))
                    displaySettings();
            }
        });
    }
}
