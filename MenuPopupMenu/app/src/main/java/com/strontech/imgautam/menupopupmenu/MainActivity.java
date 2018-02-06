package com.strontech.imgautam.menupopupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btn);
                popupMenu.getMenuInflater().inflate(R.menu.my_popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        switch (id) {
                            case R.id.item1:
                                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.item2:
                                Toast.makeText(MainActivity.this, "haaaahaaaa", Toast.LENGTH_SHORT).show();
                                break;
                        }

                        return false;
                    }
                });

                //it is last line in this onClick method
                popupMenu.show();
            }
        });

    }
}
