package com.example.student.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button dathang;
    private TextView ten, sodienthoai, sanpham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        XuLy();
        Show();
    }

    public void AnhXa(){
        dathang = (Button) findViewById(R.id.btnDatHang);
        ten = (TextView) findViewById(R.id.tvTen);
        sodienthoai = (TextView) findViewById(R.id.tvSDT);
        sanpham = (TextView) findViewById(R.id.tvSP);
    }

    public void XuLy(){
        dathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    public void Show(){
    Intent intent = getIntent();

        String thongtinshow = intent.getStringExtra("thongtin");
        ten.setText(thongtinshow);
    }
}
