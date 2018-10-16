package com.example.kelompok3.pmo2_pert2;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class music_player extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    Button cari,stop;
    EditText txt_cari;
    ListView list;
    MediaPlayer mp;

    private  static final String SD_PATH =
            new String(Environment
                    .getExternalStorageDirectory()
                    .getPath());
    String vSd_path = "";
    private List<String> lagu = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        cari = findViewById(R.id.btn_cari);
        stop = findViewById(R.id.btn_stop);
        txt_cari = findViewById(R.id.et_cari);
        list = findViewById(R.id.list_item);

        stop.setOnClickListener(this);
        cari.setOnClickListener(this);
        list.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cari:

                Updatedaftar();

                break;
            case R.id.btn_stop:
                mp.release();
                list.setEnabled(true);
                stop.setEnabled(false);
                break;
        }

    }
    public void Updatedaftar(){
        lagu.clear();
        if (txt_cari .getText().toString().isEmpty()){
            vSd_path = SD_PATH;

        }else {
            vSd_path = txt_cari.getText().toString().trim();
        }
        File home = new File(vSd_path);
        if (home.listFiles(new filter()).length > 0){
            for (File file : home.listFiles(new filter())){
                lagu.add(file.getName());
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_item,lagu);
       try {
           list.setAdapter(adapter);
       }catch (Exception e){

       }


    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
        txt_cari.setText(lagu.get(arg2));
        mp = new MediaPlayer();
        try{
            if (mp.isPlaying()){
                mp.stop();
            }
            mp.setDataSource(vSd_path+"/"+lagu.get(arg2));
            mp.prepare();
            mp.start();
            list.setEnabled(false);
            stop.setEnabled(true);
            txt_cari.setText(vSd_path+"/"+lagu.get(arg2));
        }catch (Exception e){
            Toast.makeText(this,"kesalahan",Toast.LENGTH_SHORT).show();
        }
    }
}
