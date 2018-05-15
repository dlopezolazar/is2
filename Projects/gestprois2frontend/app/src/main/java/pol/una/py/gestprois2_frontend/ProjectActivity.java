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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pol.una.py.gestprois2_frontend.adapter.ProjectListViewAdapter;
import pol.una.py.gestprois2_frontend.model.ProjectModel;

public class ProjectActivity extends AppCompatActivity {

    private static final String PROJECT = "http://192.168.1.5:8080/gestprois2-backend/api/proyecto";

    ListView listView;
    String jsonObjectResponse ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        listView = findViewById(R.id.projectListView);

        StringRequest request = new StringRequest(Request.Method.GET, PROJECT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                jsonObjectResponse = response;
                new ProjectListResponse(ProjectActivity.this).execute();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ProjectActivity.this, "Some error occurred -> " + error,
                        Toast.LENGTH_LONG).show();
                Log.e("VOLLEY", error.getStackTrace().toString());
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(ProjectActivity.this);
        rQueue.add(request);
    }

    private class ProjectListResponse extends AsyncTask<Void, Void, Void>{
        public Context context;
        List<ProjectModel> listProjects;

        public ProjectListResponse(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                if(jsonObjectResponse != null){
                    JSONArray jsonArray = null;
                    try {
                        jsonArray = new JSONArray(jsonObjectResponse);
                        JSONObject jsonObject = null;
                        ProjectModel projectModel;
                        listProjects = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            projectModel = new ProjectModel();
                            jsonObject = jsonArray.getJSONObject(i);
                            projectModel.setProjectId(jsonObject.getString("idProyecto"));
                            projectModel.setProjectName(jsonObject.getString("nombre"));
                            projectModel.setProjectInitDate(jsonObject.getString("fechaInicio"));
                            projectModel.setProjectEndDate(jsonObject.getString("fechaFin"));

                            listProjects.add(projectModel);
                        }
                    } catch (JSONException ex){
                        ex.printStackTrace();
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result){
            ProjectListViewAdapter adapter = new ProjectListViewAdapter(listProjects, context);
            listView.setAdapter(adapter);
            // progressBar.setVisibility(View.GONE);
        }
    }
}
