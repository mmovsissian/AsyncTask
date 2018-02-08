package com.example.pink24.myapplication5;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button button;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textview);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAsyncTask myAsyncTask= new MyAsyncTask();
                myAsyncTask.execute("3");
            }
        });
    }

        class  MyAsyncTask extends AsyncTask<String,String,String>{

            @Override
            protected String doInBackground(String... strings) {
                int time = Integer.parseInt(strings[0]);
                try {
                    Thread.sleep(time*1000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }

                return strings[0];
            }
            ProgressDialog progressDialog;


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog=ProgressDialog.show(MainActivity.this, "Progres",
                        "wait 3 seconds");
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressDialog.dismiss();
                text.setText("finish"+3+"seconds");

            }
        }



}
