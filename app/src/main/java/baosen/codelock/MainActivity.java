package baosen.codelock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //displaySettings();
        displayPinlock();
        //displayPasswordLock();

        //EditText passwordEditText = findViewById(R.id.passwordEditText);
        //passwordEditText.setText("Penis!");
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
