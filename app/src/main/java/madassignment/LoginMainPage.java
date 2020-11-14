package madassignment;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;


public class LoginMainPage extends AppCompatActivity {

    RequestQueue queue;
    String urlgen ="https://official-joke-api.appspot.com/jokes/general/random";
    String urlpro = "https://official-joke-api.appspot.com/jokes/programming/random";
    String urlran = "https://official-joke-api.appspot.com/random_joke";
    TextView txtjokes,txtid,txtType,txtSetup,txtpunch;
    TextView txtjokes1,txtid1,txtType1,txtSetup1,txtpunch1;
    ProgressBar progressBar;
    ProgressBar progressBar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        queue=Volley.newRequestQueue(this);
        txtjokes=findViewById(R.id.txtJokes);
        txtid=findViewById(R.id.txtID);
        txtType=findViewById(R.id.txtType);
        txtSetup=findViewById(R.id.txtSetup);
        txtpunch=findViewById(R.id.txtPunch);

        progressBar=findViewById(R.id.progressBar);


        txtid1=findViewById(R.id.txtID1);
        txtType1=findViewById(R.id.txtType1);
        txtSetup1=findViewById(R.id.txtSetup1);
        txtpunch1=findViewById(R.id.txtPunch1);

        progressBar1=findViewById(R.id.progressBar1);


    }
    public void getranJokes(View view) {
        progressBar.setVisibility(View.VISIBLE);
        JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(Request.Method.GET, urlran, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        int ID=0;
                        String type,setup,punch;
                        try {
                            ID=response.getInt("id");
                            type=response.getString("type");
                            setup=response.getString("setup");
                            punch=response.getString("punchline");
                            Joke joke=new Joke(ID,type,setup,punch);
                            txtid.setText(joke.getID()+"");
                            txtid.setVisibility(View.VISIBLE);
                            txtType.setText(joke.getType()+"");
                            txtType.setVisibility(View.VISIBLE);
                            txtSetup.setText(joke.getSetup()+"");
                            txtSetup.setVisibility(View.VISIBLE);
                            txtpunch.setText(joke.getPunchLine()+"");
                            txtpunch.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.INVISIBLE);
                        } catch (JSONException e) {

                            e.printStackTrace();
                        }

                        txtjokes.setText("Response: " +ID);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String err=error.toString();
                        txtjokes.setText("Cannot Get Data: " +error.toString());

                    }
                });
        queue.add(jsonObjectRequest);


    }

    public void getgenJokes(View view) {
        progressBar.setVisibility(View.VISIBLE);
        JsonArrayRequest jsonArrayRequest =
                new JsonArrayRequest(Request.Method.GET, urlgen, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        JSONObject obj = new JSONObject();
                        try {
                            obj.put("Joke", response);
                        } catch(JSONException e) {
                            e.printStackTrace();
                        }
                        //System.out.println(obj.toString());
                        progressBar.setVisibility(View.INVISIBLE);
                        txtjokes.setText(obj.toString());
                        //int ID=0;
                     /*   String type,setup,punch;
                        try {
                            ID=response.getInt("id");
                            type=response.getString("type");
                            setup=response.getString("setup");
                            punch=response.getString("punchline");
                            Joke joke=new Joke(ID,type,setup,punch);
                            txtid1.setText(joke.getID()+"");
                            txtid1.setVisibility(View.VISIBLE);
                            txtType1.setText(joke.getType()+"");
                            txtType1.setVisibility(View.VISIBLE);
                            txtSetup1.setText(joke.getSetup()+"");
                            txtSetup1.setVisibility(View.VISIBLE);
                            txtpunch1.setText(joke.getPunchLine()+"");
                            txtpunch1.setVisibility(View.VISIBLE);
                            progressBar1.setVisibility(View.INVISIBLE);
                        } catch (JSONException e) {

                            e.printStackTrace();
                        }

                       */ //txtjokes.setText("Response: " +ID);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String err=error.toString();
                        txtjokes.setText("Cannot Get Data: " +error.toString());

                    }
                });

        queue.add(jsonArrayRequest);


    }
    public void getproJokes(View view) {
        progressBar.setVisibility(View.VISIBLE);
       JsonArrayRequest jsonArrayRequest =
                new JsonArrayRequest(Request.Method.GET, urlpro, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        JSONObject obj = new JSONObject();
                        try {
                            obj.put("Joke", response);
                        } catch(JSONException e) {
                            e.printStackTrace();
                        }
                        //System.out.println(obj.toString());
                        progressBar.setVisibility(View.INVISIBLE);
                        txtjokes.setText(obj.toString());

                       /* String type,setup,punch;
                        try {
                            ID=response.getInt("id");
                            type=response.getString("type");
                            setup=response.getString("setup");
                            punch=response.getString("punchline");
                            Joke joke=new Joke(ID,type,setup,punch);
                            txtid.setText(joke.getID()+"");
                            txtid.setVisibility(View.VISIBLE);
                            txtType.setText(joke.getType()+"");
                            txtType.setVisibility(View.VISIBLE);
                            txtSetup.setText(joke.getSetup()+"");
                            txtSetup.setVisibility(View.VISIBLE);
                            txtpunch.setText(joke.getPunchLine()+"");
                            txtpunch.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.INVISIBLE);
                        } catch (JSONException e) {

                            e.printStackTrace();
                        }*/

                        //txtjokes1.setText("Response: " +response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String err=error.toString();
                        txtjokes.setText("Cannot Get Data: " +error.toString());

                    }
                });

        queue.add(jsonArrayRequest);


    }
}