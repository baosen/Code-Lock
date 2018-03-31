package baosen.codelock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        final Button pincodeUnlockButton = findViewById(R.id.pincodeUnlockButton);
        pincodeUnlockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codeTypeSet = CodeType.PINCODE;
                code = getPincodeInputted();
                accessSettings();
            }
        });
    }

    // Returns the text string inside the pincode edit text.
    private String getPincodeInputted() {
        return ((EditText)findViewById(R.id.pincodeEditText)).getText().toString();
    }

    // Returns the text string inside the password edit text.
    private String getPasswordInputted() {
        return ((EditText)findViewById(R.id.passwordEditText)).getText().toString();
    }

    private void askUserToSetNewPassword() {
        setTitle("Set new password");
        setContentView(R.layout.activity_set_passwordlock);
        final Button setNewPasswordButton = findViewById(R.id.setNewPasswordButton);
        setNewPasswordButton.setOnClickListener(new View.OnClickListener() {
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

    // Setup menu settings buttons.
    private void setupMenuSettingsButtons() {
        final Button setNewPincodeSettingsButton = findViewById(R.id.setNewPincodeSettingsButton);
        setNewPincodeSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askUserToSetNewPincode();
            }
        });

        final Button setNewPasswordSettingsButton = findViewById(R.id.setNewPasswordSettingsButton);
        setNewPasswordSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askUserToSetNewPassword();
            }
        });

    }

    private void setInfoTextViewInUnlockPincodeActivity(final String message) {
        TextView infoTextView = findViewById(R.id.unlockPincodeInfoTextView);
        infoTextView.setText(message);
    }

    private void setInfoTextViewInUnlockPasswordActivity(final String message) {
        TextView infoTextView = findViewById(R.id.unlockPasswordInfotextView);
        infoTextView.setText(message);
    }

    private void displaySettings() {
        setTitle("Settings");
        setContentView(R.layout.activity_settings);
        setupMenuSettingsButtons();
    }

    private void displayPasswordLock() {
        setTitle("Unlock with password");
        setContentView(R.layout.activity_passwordlock);

        Button passwordUnlockButton = findViewById(R.id.passwordUnlockButton);
        passwordUnlockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getPasswordInputted().equals(code)) {
                    displaySettings();
                    return;
                }
                setInfoTextViewInUnlockPasswordActivity("Incorrect password!");
            }
        });
    }

    private void displayPinlock() {
        setTitle("Unlock with pincode");
        setContentView(R.layout.activity_pincodelock);

        Button unlockButton = findViewById(R.id.pincodeUnlockButton);
        unlockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getPincodeInputted().equals(code)) {
                    displaySettings();
                    return;
                }
                setInfoTextViewInUnlockPincodeActivity("Incorrect pincode!");
            }
        });
    }
}
