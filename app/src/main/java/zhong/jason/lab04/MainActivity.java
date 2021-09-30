package zhong.jason.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> layout;
    Button next, prev;
    int count = -1;
    String TAG = "zhong.jason.lab04.sharedprefs";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int countonCreate=0;
    int countonStart=0;
    int countonResume=0;
    int countonPause=0;
    int countonStop=0;
    int countonRestart=0;
    int countonDestroy=0;
    int rCreate = 0, rStart = 0, rResume = 0, rPause= 0, rStop = 0, rRestart = 0, rDestroy = 0;
    TextView cr1, st1, re1, pa1 ,sto1, de1, res1;
    TextView cr2, st2, re2, pa2 ,sto2, de2, res2;
    Button rlife, rRun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next = findViewById(R.id.next);
        prev = findViewById(R.id.previous);
        layout = new ArrayList<>();
        layout.add(R.layout.layout1);
        layout.add(R.layout.layout2);
        layout.add(R.layout.layout3);
        layout.add(R.layout.layout4);
        layout.add(R.layout.layout5);
        layout.add(R.layout.layout6);
        layout.add(R.layout.layout7);
        setContentView(R.layout.layoutcycle);
        cr1= findViewById(R.id.cr);
        st1=findViewById(R.id.st);
        re1=findViewById(R.id.re);
        pa1=findViewById(R.id.pa);
        sto1=findViewById(R.id.sto);
        de1=findViewById(R.id.de);
        res1=findViewById(R.id.res);
        cr2= findViewById(R.id.cr1);
        st2=findViewById(R.id.st1);
        re2=findViewById(R.id.re1);
        pa2=findViewById(R.id.pa1);
        sto2=findViewById(R.id.sto1);
        de2=findViewById(R.id.de1);
        res2=findViewById(R.id.res1);
        rlife = findViewById(R.id.reset1);
        rRun = findViewById(R.id.reset2);
        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        setInitialValues();
        countonCreate+=1;
        rCreate++;
        storeValues();
        setContentView(R.layout.activity_main);
    }
    private void setInitialValues(){
        countonCreate=sharedPreferences.getInt("onCreate",0);
        countonStart=sharedPreferences.getInt("onStart",0);
        countonResume=sharedPreferences.getInt("onResume",0);
        countonPause=sharedPreferences.getInt("onPause",0);
        countonStop=sharedPreferences.getInt("onStop",0);
        countonRestart=sharedPreferences.getInt("onRestart",0);
        countonDestroy=sharedPreferences.getInt("onDestroy",0);


    }
    private void storeValues() {
        editor.putInt("onCreate", countonCreate);
        editor.putInt("onStart", countonStart);
        editor.putInt("onResume", countonResume);
        editor.putInt("onPause", countonPause);
        editor.putInt("onStop", countonStop);
        editor.putInt("onRestart", countonRestart);
        editor.putInt("onDestroy", countonDestroy);
        editor.apply();
        cr1.setText("onCreate: " + countonCreate);
        st1.setText("onStart: " + countonStart);
        re1.setText("onResume: " + countonResume);
        pa1.setText("onPause: " + countonPause);
        sto1.setText("onStop: " + countonStop);
        de1.setText("onRestart: " + countonRestart);
        res1.setText("onDestroy: " + countonDestroy);
        cr2.setText("onCreate: " + rCreate);
        st2.setText("onStart: " + rStart);
        re2.setText("onResume: " + rResume);
        pa2.setText("onPause: " + rPause);
        sto2.setText("onStop: " + rStop);
        de2.setText("onRestart: " + rRestart);
        res2.setText("onDestroy: " + rDestroy);
        System.out.println("Values onCreate: " + countonCreate);
        System.out.println("Values onStart: " + countonStart);
        System.out.println("Values onResume: " + countonResume);
        System.out.println("Values onPause: " + countonPause);
        System.out.println("Values onStop: " + countonStop);
        System.out.println("Values onRestart: " + countonRestart);
        System.out.println("Values onDestroy: " + countonDestroy);
        System.out.println("Values ***************************");
        System.out.println("Values onCreate: " + rCreate);
        System.out.println("Values onStart: " + rStart);
        System.out.println("Values onResume: " + rResume);
        System.out.println("Values onPause: " + rPause);
        System.out.println("Values onStop: " + rStop);
        System.out.println("Values onRestart: " + rRestart);
        System.out.println("Values onDestroy: " + rDestroy);
        System.out.println("Values ***************************");
    }
        public void goNext(View view) {
            count = ++count % layout.size();
            setContentView(layout.get(count));
        }
        public void goPrev(View view){
            if (--count < 0) count = layout.size() - 1;
            setContentView(layout.get(count));
        }
        public void goCycle(View view){
        setContentView(R.layout.layoutcycle);
            cr1.setText("onCreate: " + countonCreate);
            st1.setText("onStart: " + countonStart);
            re1.setText("onResume: " + countonResume);
            pa1.setText("onPause: " + countonPause);
            sto1.setText("onStop: " + countonStop);
            de1.setText("onRestart: " + countonRestart);
            res1.setText("onDestroy: " + countonDestroy);
            cr2.setText("onCreate: " + rCreate);
            st2.setText("onStart: " + rStart);
            re2.setText("onResume: " + rResume);
            pa2.setText("onPause: " + rPause);
            sto2.setText("onStop: " + rStop);
            de2.setText("onRestart: " + rRestart);
            res2.setText("onDestroy: " + rDestroy);
        }
        public void goBack(View view) {
            setContentView(R.layout.layout1);
        }
    public void resetLife(View view){
        countonCreate = 0;
        countonDestroy = 0;
        countonRestart = 0;
        countonStop = 0;
        countonResume = 0;
        countonPause = 0;
        countonStart = 0;
        storeValues();
    }

    public void resetRun(View view){
        rCreate = 0;
        rDestroy = 0;
        rRestart = 0;
        rStop = 0;
        rResume = 0;
        rPause = 0;
        rStart = 0;
        storeValues();
    }
    @Override
    protected void onStart() {
        super.onStart();
        countonStart+=1;
        rStart +=1;
        storeValues();
    }

    @Override
    protected void onResume() {
        super.onResume();
        countonResume+=1;
        rResume++;
        storeValues();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countonPause+=1;
        rPause++;
        storeValues();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countonStop+=1;
        rStop++;
        storeValues();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countonRestart+=1;
        rRestart++;
        storeValues();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countonDestroy++;
        rDestroy++;
        storeValues();
    }
}