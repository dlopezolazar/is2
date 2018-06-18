package pol.una.py.gestprois2_frontend;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
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
import java.util.List;

import pol.una.py.gestprois2_frontend.adapter.StoryListViewAdapter;
import pol.una.py.gestprois2_frontend.model.SprintModel;
import pol.una.py.gestprois2_frontend.model.StoryModel;
import pol.una.py.gestprois2_frontend.model.UserModel;

public class StoryActivity extends AppCompatActivity {

    private static final String STORY = "http://192.168.1.4:8080/gestprois2-backend/api/story";
    //private static final String STORY = "http://192.168.0.112:8080/gestprois2-backend/api/story";

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
                        JSONObject jsonUSer = null;
                        StoryModel storyModel;
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
                            jsonUSer = jsonObject.getJSONObject("usuario");
                            storyModel.setUser(new UserModel(
                                    jsonUSer.getInt("idUsuario"),
                                    jsonUSer.getString("correo"),
                                    jsonUSer.getString("nombreCompleto"),
                                    jsonUSer.getString("uid")
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

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    StoryModel sm = (StoryModel) adapterView.getItemAtPosition(i);
                    Intent intent = new Intent(StoryActivity.this, StoryDetailActivity.class);
                    intent.putExtra("taskDescription", sm.getTaskDescription());
                    intent.putExtra("userName", sm.getUser().getUid());
                    intent.putExtra("state", sm.getState());
                    intent.putExtra("sprintId", sm.getSprint().getSprintId().toString());
                    intent.putExtra("userId", sm.getUser().getUserId().toString());
                    intent.putExtra("id", sm.getIdTask().toString());
                    startActivity(intent);
                }
            });

            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    StoryModel sm = (StoryModel) parent.getItemAtPosition(position);
                    final String deleteEndpoint = STORY+"/"+sm.getIdTask();
                    AlertDialog.Builder myQuittingDialogBox =new AlertDialog.Builder(StoryActivity.this)
                            //set message, title, and icon
                            .setTitle("Delete")
                            .setMessage("Esta seguro de eliminar?")
                            .setPositiveButton("Si", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int whichButton) {
                                    //your deleting code
                                    StringRequest request = new StringRequest(Request.Method.DELETE, deleteEndpoint, new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            finish();
                                            startActivity(getIntent());
                                            Log.d("Deleted Story: ", response.toString());
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

                                    dialog.dismiss();
                                }

                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    dialog.dismiss();

                                }
                            });
                    myQuittingDialogBox.show();

                    return true;
                }
            });

        }
    }
}
