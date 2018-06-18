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
import java.util.Date;

public class StoryDetailActivity extends AppCompatActivity {

    private static final String STORY = "http://192.168.1.4:8080/gestprois2-backend/api/story";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);

        ((TextView)findViewById(R.id.edTaskDescription)).setText(getIntent().getStringExtra("taskDescription"));
        ((TextView)findViewById(R.id.edUser)).setText(getIntent().getStringExtra("userName"));
        ((TextView)findViewById(R.id.edState)).setText(getIntent().getStringExtra("state"));
        ((TextView)findViewById(R.id.txtFecha)).setText(new Date().toString());

        FloatingActionButton buttonSave = findViewById(R.id.faGuardar);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int requestMethod = Request.Method.POST;
                final Integer idTask;
                if(getIntent().getStringExtra("id")!= null){
                    idTask = Integer.parseInt(getIntent().getStringExtra("id"));
                    requestMethod = Request.Method.PUT;
                } else{
                    idTask = null;
                }

                JSONObject body = new JSONObject();
                try {
                    body.put("descripcion", ((TextView) findViewById(R.id.edTaskDescription)).getText().toString());
                    body.put("estado", ((TextView) findViewById(R.id.edState)).getText().toString());
                    body.put("sprintId", (getIntent().getStringExtra("id")));
                    body.put("idUsuario", ((TextView) findViewById(R.id.edUser)).getText().toString());
                    body.put("storyId", idTask != null? idTask.toString():null);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                final String requestBody = body.toString();

                StringRequest request = new StringRequest(requestMethod, STORY, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        startActivity(new Intent(StoryDetailActivity.this, UserActivity.class));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(StoryDetailActivity.this, "Some error occurred -> " + error,
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

                RequestQueue rQueue = Volley.newRequestQueue(StoryDetailActivity.this);
                rQueue.add(request);
            }
        });
    }
}
