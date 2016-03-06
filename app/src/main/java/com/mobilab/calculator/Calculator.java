package com.mobilab.calculator;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    Button sifir,bir,iki,uc,dort,bes,alti,yedi,sekiz,dokuz;
    Button ac,nokta,carp,bol,cikar,topla,esittir,sil;
    TextView sonuc;

    float sayi1= (float) 0.0,sayi2= (float) 0.0,hesap=0;
    int islem;
    boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initialize();
        sifir.setOnClickListener(this);
        bir.setOnClickListener(this);
        iki.setOnClickListener(this);
        uc.setOnClickListener(this);
        dort.setOnClickListener(this);
        bes.setOnClickListener(this);
        alti.setOnClickListener(this);
        yedi.setOnClickListener(this);
        sekiz.setOnClickListener(this);
        dokuz.setOnClickListener(this);
        ac.setOnClickListener(this);
        nokta.setOnClickListener(this);
        carp.setOnClickListener(this);
        bol.setOnClickListener(this);
        cikar.setOnClickListener(this);
        topla.setOnClickListener(this);
        esittir.setOnClickListener(this);
        sil.setOnClickListener(this);


    }
    //OnCreateContext
    //getMenuInflater().inflate(R.menu.altmenu,menu);


    @Override
    public void registerForContextMenu(View view) {
        super.registerForContextMenu(view);
    }

    private void initialize() {
        sonuc=(TextView)findViewById(R.id.tvSonuc);
        sifir=(Button)findViewById(R.id.btn0);
        bir=(Button)findViewById(R.id.btn1);
        iki=(Button)findViewById(R.id.btn2);
        uc=(Button)findViewById(R.id.btn3);
        dort=(Button)findViewById(R.id.btn4);
        bes=(Button)findViewById(R.id.btn5);
        alti=(Button)findViewById(R.id.btn6);
        yedi=(Button)findViewById(R.id.btn7);
        sekiz=(Button)findViewById(R.id.btn8);
        dokuz=(Button)findViewById(R.id.btn9);
        ac=(Button)findViewById(R.id.btnAC);
        nokta=(Button)findViewById(R.id.btnNokta);
        carp=(Button)findViewById(R.id.btnCarp);
        bol=(Button)findViewById(R.id.btnBol);
        cikar=(Button)findViewById(R.id.btnCikar);
        topla=(Button)findViewById(R.id.btnTopla);
        esittir=(Button)findViewById(R.id.btnEsittir);
        sil=(Button)findViewById(R.id.btnSil);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        if(sonuc.getText().toString().equals("0") || sonuc.getText().toString().equals("0.0") || sonuc.getText().toString().equals("Infinity")){
            sonuc.setText("");
        }
        switch (v.getId()){
            case R.id.btn0:
                sonuc.setText(sonuc.getText().toString()+"0");
                break;
            case R.id.btn1:
                sonuc.setText(sonuc.getText().toString()+"1");
                break;
            case R.id.btn2:
                sonuc.setText(sonuc.getText().toString()+"2");
                break;
            case R.id.btn3:
                sonuc.setText(sonuc.getText().toString()+"3");
                break;
            case R.id.btn4:
                sonuc.setText(sonuc.getText().toString()+"4");
                break;
            case R.id.btn5:
                sonuc.setText(sonuc.getText().toString()+"5");
                break;
            case R.id.btn6:
                sonuc.setText(sonuc.getText().toString()+"6");
                break;
            case R.id.btn7:
                sonuc.setText(sonuc.getText().toString()+"7");
                break;
            case R.id.btn8:
                sonuc.setText(sonuc.getText().toString()+"8");
                break;
            case R.id.btn9:
                sonuc.setText(sonuc.getText().toString()+"9");
                break;
            case R.id.btnAC:
                sonuc.setText("0");
                break;
            case R.id.btnNokta:
                sonuc.setText(sonuc.getText().toString()+".");
                break;
            case R.id.btnSil:
                if(sonuc.getText().length()>0) {
                    String text = sonuc.getText().toString();
                    sonuc.setText(text.substring(0, text.length() - 1));
                }
                break;
            case R.id.btnTopla:
                if(!sonuc.getText().toString().equals("")) {
                        sayi1 =Float.parseFloat(sonuc.getText().toString());
                    islem=1;
                    hesap=sayi1+hesap;
                    sonuc.setText("");
                }

                break;
            case R.id.btnCikar:
                if(!sonuc.getText().toString().equals("")) {
                    sayi1 = Float.parseFloat(sonuc.getText().toString());
                    islem=2;
                    sonuc.setText("");
                }
                break;
            case R.id.btnCarp:
                if(!sonuc.getText().toString().equals("")) {
                        sayi1 = Float.parseFloat(sonuc.getText().toString());
                    islem=3;
                    sonuc.setText("");
                }
                break;
            case R.id.btnBol:
                if(!sonuc.getText().toString().equals("")) {
                    sayi1 = Float.parseFloat(sonuc.getText().toString());
                    islem=4;
                    sonuc.setText("");
                }
                break;
            case R.id.btnEsittir:
                if(islem==1 && !sonuc.getText().toString().equals("")){
                    sayi2=Float.parseFloat(sonuc.getText().toString());
                    hesap=hesap+sayi2;
                }
                else if(islem==2 && !sonuc.getText().toString().equals("")){
                    sayi2=Float.parseFloat(sonuc.getText().toString());
                    hesap=sayi1-sayi2;
                }
                else if(islem==3 && !sonuc.getText().toString().equals("")){
                    sayi2=Float.parseFloat(sonuc.getText().toString());
                    hesap=sayi1*sayi2;
                }
                else if(islem==4 && !sonuc.getText().toString().equals("")){
                    sayi2=Float.parseFloat(sonuc.getText().toString());
                    try {
                        hesap=sayi1/sayi2;
                    }catch (Exception e){
                        sonuc.setText("0");
                    }
                }
                sonuc.setText(String.valueOf(hesap));
                hesap=0;
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                AlertDialog.Builder alert=new AlertDialog.Builder(this);
                    alert.setMessage("Erciyes University Mobil Application Developer Groups").setCancelable(false);
                    alert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                return true;
            case  R.id.logout:
                alert = new AlertDialog.Builder(this);

                alert.setMessage("Are you sure to exit?").setCancelable(false);
                alert.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alert.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog = alert.create();
                alertDialog.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
