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
import java.util.HashMap;
import java.util.Map;

public class UserDetailActivity extends AppCompatActivity {

    //private static final String USUARIO = "http://192.168.0.112:8080/gestprois2-backend/api/usuario";
    private static final String USUARIO = "http://192.168.1.4:8080/gestprois2-backend/api/usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        ((TextView)findViewById(R.id.edEmail)).setText(getIntent().getStringExtra("email"));
        ((TextView)findViewById(R.id.edFullName)).setText(getIntent().getStringExtra("name"));
        ((TextView)findViewById(R.id.edUserName)).setText(getIntent().getStringExtra("uid"));

        FloatingActionButton buttonSave = findViewById(R.id.faGuardar);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Metodo por defecto POST, caso contrario hacemos un PUT.
                 */
                int requestMethod = Request.Method.POST;
                final Integer userId;
                if(getIntent().getStringExtra("id")!= null){
                    userId = Integer.parseInt(getIntent().getStringExtra("id"));
                    requestMethod = Request.Method.PUT;
                } else{
                    userId = null;
                }

                JSONObject body = new JSONObject();
                try {
                    body.put("nombreCompleto", ((TextView) findViewById(R.id.edFullName)).getText().toString());
                    body.put("correo", ((TextView) findViewById(R.id.edEmail)).getText().toString());
                    body.put("uid", ((TextView) findViewById(R.id.edUserName)).getText().toString());
                    body.put("idUsuario", userId != null? userId.toString():null);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                final String requestBody = body.toString();

                StringRequest request = new StringRequest(requestMethod, USUARIO, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        
                        startActivity(new Intent(UserDetailActivity.this, UserActivity.class));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UserDetailActivity.this, "Some error occurred -> " + error,
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

                RequestQueue rQueue = Volley.newRequestQueue(UserDetailActivity.this);
                rQueue.add(request);
            }
        });
    }
}
