package com.company.fragmentproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button addA,removeA,replaceA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addA=findViewById(R.id.showFragmentA);
        removeA=findViewById(R.id.removeFragmentA);
        replaceA=findViewById(R.id.replaceFragmentA);

        addA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentOne fragmentOne=new FragmentOne();

                FragmentManager fragmentManager=getSupportFragmentManager();

                FragmentTransaction transaction=fragmentManager.beginTransaction();

                transaction.add(R.id.linearlayout,fragmentOne,"FragmentOne");
                transaction.commit();
            }
        });

        removeA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager manager=getSupportFragmentManager();

                FragmentTransaction transaction=manager.beginTransaction();

                FragmentOne fragmentOne= (FragmentOne) manager.findFragmentByTag("FragmentOne");

                if(fragmentOne!=null) {
                    transaction.remove(fragmentOne);
                    transaction.commit();
                }
                else{
                    Toast.makeText(MainActivity.this,"Add Fragment First",Toast.LENGTH_SHORT).show();
                }
            }
        });

        replaceA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTwo fragmentTwo=new FragmentTwo();
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();

                transaction.replace(R.id.linearlayout,fragmentTwo,"FragmentTwo");

                transaction.commit();

            }
        });
    }
}