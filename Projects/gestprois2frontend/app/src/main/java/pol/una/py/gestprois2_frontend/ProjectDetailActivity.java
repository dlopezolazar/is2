package pol.una.py.gestprois2_frontend;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class ProjectDetailActivity extends AppCompatActivity {

    private static final String PROJECT = "http://192.168.1.4:8080/gestprois2-backend/api/proyecto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        FloatingActionButton buttonSave = findViewById(R.id.fabSaveProject);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject body = new JSONObject();
                try {
                    body.put("nombre", ((TextView) findViewById(R.id.edNombreProyecto)).getText().toString());
                    body.put("fechaInicio", ((TextView) findViewById(R.id.edFechaInicio)).getText().toString());
                    body.put("fechaFin", ((TextView) findViewById(R.id.edFechaFin)).getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                final String requestBody = body.toString();

                StringRequest request = new StringRequest(Request.Method.POST, PROJECT, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        startActivity(new Intent(ProjectDetailActivity.this, ProjectActivity.class));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ProjectDetailActivity.this, "Some error occurred -> " + error,
                                Toast.LENGTH_LONG).show();
                        Log.e("VOLLEY", error.getStackTrace().toString());
                    }
                }) {
                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8";
                    }

                    @Override
                    public byte[] getBody() throws AuthFailureError {
                        try {
                            return requestBody == null ? null : requestBody.getBytes("utf-8");
                        } catch (UnsupportedEncodingException uee) {
                            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                            return null;
                        }
                    }
                };

                RequestQueue rQueue = Volley.newRequestQueue(ProjectDetailActivity.this);
                rQueue.add(request);
            }
        });
    }
}
