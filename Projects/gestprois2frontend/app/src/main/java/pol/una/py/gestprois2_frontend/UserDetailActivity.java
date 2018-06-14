package pol.una.py.gestprois2_frontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        ((TextView)findViewById(R.id.edEmail)).setText(getIntent().getStringExtra("email"));
        ((TextView)findViewById(R.id.edTaskDescription)).setText(getIntent().getStringExtra("name"));
    }
}
