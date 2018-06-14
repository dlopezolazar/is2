package pol.una.py.gestprois2_frontend;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class StoryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);

        ((TextView)findViewById(R.id.edTaskDescription)).setText(getIntent().getStringExtra("taskDescription"));
        ((TextView)findViewById(R.id.edUser)).setText(getIntent().getStringExtra("userName"));
        ((TextView)findViewById(R.id.edState)).setText(getIntent().getStringExtra("state"));
        ((TextView)findViewById(R.id.txtFecha)).setText(new Date().toString());

        FloatingActionButton buttonSave = findViewById(R.id.faGuardar);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //llamar a post de guardar
            }
        });
    }
}
