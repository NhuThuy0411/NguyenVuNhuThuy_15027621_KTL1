package com.example.student.myapplication;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private EditText edTen, edSDT;
    private Button Laythongtin, xong;
    private TextView chonSP;
    //private String sanPham = "";
    //private CharSequence[] habbits = {"Nuoc ngot", "Bia", "Trai cay", "Ruou", "Do nham"};
    //final boolean choised[] = {false, true, true, false, true};
    private CheckBox sp01, sp02, sp03, sp04, sp05;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        AnhXa();
        XuLy();
    }

    public void AnhXa(){
        edTen = (EditText) findViewById(R.id.edHoten);
        edSDT = (EditText) findViewById(R.id.edSoDT);
        Laythongtin =(Button) findViewById(R.id.btnLaySP);
        //chonSP = (TextView) findViewById(R.id.tvChonSP);


    }

    public void XuLy(){
        Laythongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(Main2Activity.this);
                dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR);
                dialog.setContentView(R.layout.dialog);
                dialog.getWindow().setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                dialog.show();
                sp01 = (CheckBox) dialog.findViewById(R.id.sp1);
                sp02 = (CheckBox) dialog.findViewById(R.id.sp2);
                sp03 = (CheckBox) dialog.findViewById(R.id.sp3);
                sp04 = (CheckBox) dialog.findViewById(R.id.sp4);
                sp05 = (CheckBox) dialog.findViewById(R.id.sp5);
                xong = (Button)  dialog.findViewById(R.id.btnxong);
                xong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String chonsp = "";
                        if(sp01.isChecked()){
                            chonsp += "" +sp01.getText().toString();
                        }
                        if(sp02.isChecked()){
                            chonsp += "" +sp02.getText().toString();
                        }
                        if(sp03.isChecked()){
                            chonsp += "" +sp03.getText().toString();
                        }
                        if(sp04.isChecked()){
                            chonsp += "" +sp04.getText().toString();
                        }
                        if(sp05.isChecked()){
                            chonsp += "" +sp05.getText().toString();
                        }
                        dialog.cancel();

                        String thongtin = "Khach hang: " +edTen.getText().toString()+ "SDT:" +edSDT.getText().toString()+ "San pham dat: " +chonsp;
                        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                        intent.putExtra("thongtin", thongtin);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}

