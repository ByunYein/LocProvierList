package com.example.locprovierlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {

    TextView mTextView;
    LocationManager locMgr;
    List<String> locProviders;
    Button mbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView=findViewById(R.id.txtOutput);
        locMgr=(LocationManager)getSystemService(LOCATION_SERVICE);
        locProviders=locMgr.getAllProviders();

        mbutton=findViewById(R.id.button);




        mbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                /*  String s = "";
              for( i=0 : i<locProviders.size()){
                    s+="Loc. Provider"+locProviders.get(i)+"\n"
                            +"Status:"+locMgr.isProviderEnabled(locProviders.get(i))+"\n\n";

                i++;
                }
                */
                for(String s: locProviders){

                    s+=("Loc. Provider"+locProviders.size()+"\n"
                            +"Status:"+locMgr.isProviderEnabled(String.valueOf(s))+"\n\n");

                    mTextView.append(""+s);
                }

            }
        });

    }
}