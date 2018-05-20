package pol.una.py.gestprois2_frontend;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

import pol.una.py.gestprois2_frontend.model.ProjectModel;
import pol.una.py.gestprois2_frontend.model.SprintModel;

public class SprintActivity extends AppCompatActivity {

    private static final String SPRINT = "http://192.168.1.4:8080/gestprois2-backend/api/sprint";

    ListView listView;
    String jsonObjectResponse ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprint);

        String ENDPOINT = SPRINT+"/"+getIntent().getStringExtra("projectId");

        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                jsonObjectResponse = response;
                new SprintActivity.SprintListResponse(SprintActivity.this).execute();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SprintActivity.this, "Some error occurred -> " + error,
                        Toast.LENGTH_LONG).show();
                Log.e("VOLLEY", error.getStackTrace().toString());
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(SprintActivity.this);
        rQueue.add(request);

    }

    private class SprintListResponse extends AsyncTask<Void, Void, Void>{

        public Context context;
        List<SprintModel> listProjects;

        public SprintListResponse(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
