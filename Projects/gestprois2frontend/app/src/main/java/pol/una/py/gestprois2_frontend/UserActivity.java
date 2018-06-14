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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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
import pol.una.py.gestprois2_frontend.model.StoryModel;
import pol.una.py.gestprois2_frontend.model.UserModel;

public class UserActivity extends AppCompatActivity {


    //private static final String USUARIO = "http://192.168.1.61:8080/gestprois2-backend/api/usuario";
    private static final String USUARIO = "http://192.168.0.112:8080/gestprois2-backend/api/usuario";

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

        //Al dar click sobre el button + se desplega la vista para crear nuevo usuario
        FloatingActionButton buttonNew = findViewById(R.id.butonNew);
        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this, UserDetailActivity.class));
            }
        });

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
                            user.setUserId(jsonObject.getInt("idUsuario"));
                            user.setEmail(jsonObject.getString("correo"));
                            user.setFullName(jsonObject.getString("nombreCompleto"));
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

            //Esto sirve para cuando das click sobre un elemento de la lista
            //se guarda los atributos y se le pasa a la vista siguiente
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    UserModel u = (UserModel) adapterView.getItemAtPosition(i);
                    Intent intent = new Intent(UserActivity.this, UserDetailActivity.class);
                    intent.putExtra("email", u.getEmail());
                    intent.putExtra("name", u.getFullName());
                    startActivity(intent);
                }
            });

            //Esto sirve para que al mantener presionado un elemento de la lista nos pregunte
            //si estamos seguros de eliminar el registro
            //si -> elimina
            //no -> cierra popup, vuelva a mostrar la lista
            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    UserModel um = (UserModel) parent.getItemAtPosition(position);
                    final String deleteEndpoint = USUARIO+"/"+um.getUserId();
                    AlertDialog.Builder myQuittingDialogBox =new AlertDialog.Builder(UserActivity.this)
                            //set message, title, and icon
                            .setTitle("Delete")
                            .setMessage("Esta seguro de eliminar?")
                            .setPositiveButton("Si", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int whichButton) {
                                    //your deleting code
                                    StringRequest request = new StringRequest(Request.Method.DELETE, deleteEndpoint, new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            Log.d("Deleted Story: ", response.toString());
                                        }
                                    }, new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            Toast.makeText(UserActivity.this, "Some error occurred -> " + error,
                                                    Toast.LENGTH_LONG).show();
                                            Log.e("VOLLEY", error.getStackTrace().toString());
                                        }
                                    });

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
            // Hiding progress bar after all JSON loading done.
            // progressBar.setVisibility(View.GONE);
        }
    }

}
