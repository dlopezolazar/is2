package pol.una.py.gestprois2_frontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button mButtonUsuario = findViewById(R.id.btnUsuarios);
        mButtonUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, UserActivity.class));

            }
        });

        Button mButtonProject = findViewById(R.id.btnProyectos);
        mButtonProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ProjectActivity.class));
            }
        });

        Button mButtonRoles = findViewById(R.id.buttonRoles);
        mButtonRoles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, RolActivity.class));

            }
        });


    }
}
