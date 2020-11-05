package kr.ac.ssu.kjminn.mirimviewcontainer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class TabActivityTest2 extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test2);
        TabHost tabHost = getTabHost();
        TabHost.TabSpec tabSpecPark = tabHost.newTabSpec("PARK").setIndicator("박세리");
        tabSpecPark.setContent(R.id.linear_park);
        tabHost.addTab(tabSpecPark);

        TabHost.TabSpec tabSpecSon = tabHost.newTabSpec("SON").setIndicator("손예진");
        tabSpecSon.setContent(R.id.linear_son);
        tabHost.addTab(tabSpecSon);

        TabHost.TabSpec tabSpecAhn = tabHost.newTabSpec("AHN").setIndicator("안현모");
        tabSpecAhn.setContent(R.id.linear_ahn);
        tabHost.addTab(tabSpecAhn);

        TabHost.TabSpec tabSpecFall = tabHost.newTabSpec("FALL").setIndicator("가~~을");
        tabSpecFall.setContent(R.id.linear_fall);
        tabHost.addTab(tabSpecFall);

        tabHost.setCurrentTab(0);
    }
}