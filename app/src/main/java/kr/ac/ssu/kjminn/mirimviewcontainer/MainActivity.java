package kr.ac.ssu.kjminn.mirimviewcontainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper flipper;
    float downX, upX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flipper);
        flipper = findViewById(R.id.flipper);
        Button btnPrev = findViewById(R.id.btn_prev);
        Button btnNext = findViewById(R.id.btn_next);
        btnPrev.setOnClickListener(btnListener);
        btnNext.setOnClickListener(btnListener);


        flipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    downX = event.getX();
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    upX = event.getX();
                    if(downX > upX){
                        flipper.showNext();
                    }else if(downX  < upX){
                        flipper.showPrevious();
                    }
                }

                Toast.makeText(getApplicationContext(), (downX - upX) + "", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_prev:
                    flipper.setFlipInterval(1000);
                    flipper.startFlipping();
                    break;
                case R.id.btn_next:
                    flipper.stopFlipping();
                    break;
            }
        }
    };

/*    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_prev:
                    flipper.showPrevious();
                    break;
                case R.id.btn_next:
                    flipper.showNext();
                    break;
            }
        }
    };*/
}