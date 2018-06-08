package pol.una.py.gestprois2_frontend;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

import pol.una.py.gestprois2_frontend.adapter.StoryListViewAdapter;
import pol.una.py.gestprois2_frontend.model.ProjectModel;
import pol.una.py.gestprois2_frontend.model.SprintModel;
import pol.una.py.gestprois2_frontend.model.StoryModel;
import pol.una.py.gestprois2_frontend.model.UserModel;

public class StoryActivity extends AppCompatActivity {

    //private static final String STORY = "http://192.168.1.61:8080/gestprois2-backend/api/sprint";
    private static final String STORY = "http://192.168.0.112:8080/gestprois2-backend/api/story";

    ListView listView;
    String jsonObjectResponse ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        listView = findViewById(R.id.storyListView);

        final String ENDPOINT = STORY+"/"+getIntent().getStringExtra("sprintId");

        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                jsonObjectResponse = response;
                new StoryListResponse(StoryActivity.this).execute();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(StoryActivity.this, "Some error occurred -> " + error,
                        Toast.LENGTH_LONG).show();
                Log.e("VOLLEY", error.getStackTrace().toString());
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(StoryActivity.this);
        rQueue.add(request);

        FloatingActionButton buttonNew = findViewById(R.id.butonNew);
        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StoryActivity.this, StoryDetailActivity.class));
            }
        });
    }

    private class StoryListResponse extends AsyncTask<Void, Void, Void>{

        private Context context;
        private List<StoryModel> listStory;

        public StoryListResponse(Context context) {
            this.context = context;
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
                        JSONObject jsonSprint = null;
                        JSONObject jsonProject = null;
                        JSONObject jsonUSer = null;
                        StoryModel storyModel;
                        SprintModel sprintModel;
                        listStory = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            storyModel = new StoryModel();
                            jsonObject = jsonArray.getJSONObject(i);
                            storyModel.setIdTask(jsonObject.getInt("idTarea"));
                            storyModel.setTaskDescription(jsonObject.getString("descripcion"));
                            storyModel.setState(jsonObject.getString("estado"));
                            jsonSprint = jsonObject.getJSONObject("sprint");
                            storyModel.setSprint(new SprintModel(
                                    jsonSprint.getString("sprintId"),
                                    jsonSprint.getString("description"),
                                    jsonSprint.getString("fechaInicio"),
                                    jsonSprint.getString("fechaFin"),
                                    ""
                            ));
                            /*jsonProject = jsonObject.getJSONObject("proyecto");
                            storyModel.setProject(new ProjectModel(
                                    jsonObject.getString("idProyecto"),
                                    jsonObject.getString("nombre"),
                                    jsonObject.getString("fechaInicio"),
                                    jsonObject.getString("fechaFin")
                            ));*/
                            jsonUSer = jsonObject.getJSONObject("usuario");
                            storyModel.setUser(new UserModel(
                                    jsonUSer.getString("correo"),
                                    jsonUSer.getString("nombreCompleto")
                            ));

                            listStory.add(storyModel);
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
            StoryListViewAdapter adapter = new StoryListViewAdapter(listStory, context);
            listView.setAdapter(adapter);

        }
    }
}
