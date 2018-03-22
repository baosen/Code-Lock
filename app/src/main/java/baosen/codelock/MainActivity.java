package baosen.codelock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;

public class MainActivity extends AppCompatActivity {
    TelecomManager telecomManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //displaySettings();
        displayPinlock();
        //displayPasswordLock();

        //EditText passwordEditText = findViewById(R.id.passwordEditText);
        telecomManager = getTelecomService();
    }

    private TelecomManager getTelecomService() {
        return (TelecomManager) getSystemService(TELECOM_SERVICE);
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
        setContentView(R.layout.activity_pinlock);
    }
}
