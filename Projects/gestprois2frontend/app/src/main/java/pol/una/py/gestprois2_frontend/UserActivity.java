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

import pol.una.py.gestprois2_frontend.adapter.UserListViewAdapter;
import pol.una.py.gestprois2_frontend.model.UserModel;

public class UserActivity extends AppCompatActivity {


    private static final String USUARIO = "http://192.168.1.5:8080/gestprois2-backend/api/usuario";

    ListView listView;
    String jsonObjectResponse ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        listView = findViewById(R.id.userListView);

        StringRequest request = new StringRequest(Request.Method.GET, USUARIO, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                jsonObjectResponse = response;
                new UserListResponse(UserActivity.this).execute();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UserActivity.this, "Some error occurred -> " + error,
                        Toast.LENGTH_LONG).show();
                Log.e("VOLLEY", error.getStackTrace().toString());
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(UserActivity.this);
        rQueue.add(request);

    }

    @Override
    public void onBackPressed() {
        // Write your code here
        setContentView(R.layout.activity_home);
        super.onBackPressed();

    }

    private class UserListResponse extends AsyncTask<Void, Void, Void> {

        public Context context;

        // Creating List of Subject class.
        List<UserModel> customList;

        public UserListResponse(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            try {

                // Checking whether FinalJSonObject is not equals to null.
                if (jsonObjectResponse != null) {
                    // Creating and setting up JSON array as null.
                    JSONArray jsonArray = null;
                    try {
                        // Adding JSON response object into JSON array.
                        jsonArray = new JSONArray(jsonObjectResponse);

                        // Creating JSON Object.
                        JSONObject jsonObject;

                        // Creating Subject class object.
                        UserModel user;
                        // Defining CustomSubjectNamesList AS Array List.
                        customList = new ArrayList<>();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            user = new UserModel();
                            jsonObject = jsonArray.getJSONObject(i);
                            //Storing ID into subject list.
                            user.setEmail(jsonObject.getString("correo"));
                            //Storing Subject name in subject list.
                            user.setFullName(jsonObject.getString("nombreCompleto"));

                            // Adding subject list object into CustomSubjectNamesList.
                            customList.add(user);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result){
            // After all done loading set complete CustomSubjectNamesList with application context to ListView adapter.
            UserListViewAdapter adapter = new UserListViewAdapter(customList, context);
            // Setting up all data into ListView.
            listView.setAdapter(adapter);

            // Hiding progress bar after all JSON loading done.
            // progressBar.setVisibility(View.GONE);
        }
    }

}
