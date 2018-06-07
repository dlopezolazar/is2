package pol.una.py.gestprois2_frontend;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
import java.util.Date;
import java.util.List;

import pol.una.py.gestprois2_frontend.adapter.SprintListViewAdapter;
import pol.una.py.gestprois2_frontend.model.SprintModel;

public class SprintActivity extends AppCompatActivity {

    //private static final String SPRINT = "http://192.168.1.61:8080/gestprois2-backend/api/sprint";
    private static final String SPRINT = "http://192.168.0.112:8080/gestprois2-backend/api/sprint";

    ListView listView;
    String jsonObjectResponse ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprint);

        listView = findViewById(R.id.sprintListView);

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
        List<SprintModel> listSprint;

        public SprintListResponse(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String projectDesc = getIntent().getStringExtra("projectName");
                if(jsonObjectResponse != null){
                    JSONArray jsonArray = null;
                    try {
                        jsonArray = new JSONArray(jsonObjectResponse);
                        JSONObject jsonObject = null;
                        SprintModel sprintModel;
                        listSprint = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            sprintModel = new SprintModel();
                            jsonObject = jsonArray.getJSONObject(i);
                            sprintModel.setSprintId(jsonObject.getInt("sprintId"));
                            sprintModel.setSprintDescription(jsonObject.getString("sprintDescription"));
                            sprintModel.setInitDate(jsonObject.getString("initDate"));
                            sprintModel.setEndDate(jsonObject.getString("endDate"));
                            sprintModel.setProjectDescription(projectDesc);

                            listSprint.add(sprintModel);
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
            SprintListViewAdapter adapter = new SprintListViewAdapter(listSprint, context);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    SprintModel s = (SprintModel) adapterView.getItemAtPosition(i);
                    Intent intent = new Intent(SprintActivity.this, StoryActivity.class);
                    intent.putExtra("sprintId", s.getSprintId());
                    startActivity(intent);
                }
            });

        }
    }
}
