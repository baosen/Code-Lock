package baosen.passlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_lock);

        EditText passwordEditText = findViewById(R.id.passwordEditText);
        passwordEditText.setText("Penis!");
    }
}
