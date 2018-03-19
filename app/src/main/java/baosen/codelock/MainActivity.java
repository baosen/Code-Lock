package baosen.codelock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_lock);
        setContentView(R.layout.activity_pinlock);

        //EditText passwordEditText = findViewById(R.id.passwordEditText);
        //passwordEditText.setText("Penis!");
    }
}
