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

import pol.una.py.gestprois2_frontend.adapter.RolListViewAdapter;
import pol.una.py.gestprois2_frontend.model.RolModel;

public class RolActivity extends AppCompatActivity {

    private static final String ROL = "http://192.168.1.2:8080/gestprois2-backend/api/rol";
    //private static final String ROL = "http://192.168.0.112:8080/gestprois2-backend/api/rol";

    ListView listView;
    String jsonObjectResponse ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rol);

        listView = findViewById(R.id.rolListView);
        StringRequest request = new StringRequest(Request.Method.GET, ROL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                jsonObjectResponse = response;
                new RolActivity.RolListResponse(RolActivity.this).execute();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RolActivity.this, "Some error occurred -> " + error,
                        Toast.LENGTH_LONG).show();
                Log.e("VOLLEY", error.getStackTrace().toString());
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(RolActivity.this);
        rQueue.add(request);

        //Al dar click sobre el button + se desplega la vista para crear nuevo rol
        FloatingActionButton buttonNew = findViewById(R.id.butonNewRol);
        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RolActivity.this, RolDetailActivity.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        // Write your code here
        setContentView(R.layout.activity_home);
        super.onBackPressed();

    }

    private class RolListResponse extends AsyncTask<Void, Void, Void> {

        public Context context;

        // Creating List of Subject class.
        List<RolModel> customList;

        public RolListResponse(Context context) {
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
                        RolModel rol;
                        // Defining CustomSubjectNamesList AS Array List.
                        customList = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            rol = new RolModel();
                            jsonObject = jsonArray.getJSONObject(i);
                            rol.setIdRol(jsonObject.getInt("idRol"));
                            rol.setRolDescription(jsonObject.getString("rolDescripcion"));
                            customList.add(rol);
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
            RolListViewAdapter adapter = new RolListViewAdapter(customList, context);
            // Setting up all data into ListView.
            listView.setAdapter(adapter);

            //Esto sirve para cuando das click sobre un elemento de la lista
            //se guarda los atributos y se le pasa a la vista siguiente
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    RolModel u = (RolModel) adapterView.getItemAtPosition(i);
                    Intent intent = new Intent(RolActivity.this, RolDetailActivity.class);
                    intent.putExtra("descripcion", u.getRolDescription());
                    intent.putExtra("id", u.getIdRol().toString());
                    startActivity(intent);
                }
            });

            //Esto sirve para que al mantener presionado un elemento de la lista nos pregunte
            //si estamos seguros de eliminar el registro
            //si -> elimina
            //no -> cierra popup, vuelva a mostrar la lista
            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
                    RolModel um = (RolModel) parent.getItemAtPosition(position);
                    final String deleteEndpoint = ROL+"/"+um.getIdRol();
                    AlertDialog.Builder myQuittingDialogBox =new AlertDialog.Builder(RolActivity.this)
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
                                            Log.d("Deleted Rol: ", response.toString());
                                        }
                                    }, new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            Toast.makeText(RolActivity.this, "Some error occurred -> " + error,
                                                    Toast.LENGTH_LONG).show();
                                            Log.e("VOLLEY", error.getStackTrace().toString());
                                        }
                                    });

                                    RequestQueue rQueue = Volley.newRequestQueue(RolActivity.this);
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
            // Hiding progress bar after all JSON loading done.
            // progressBar.setVisibility(View.GONE);
        }
    }
    
}
