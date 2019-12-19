package com.e9ab98e991ab.nav;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.e9ab98e991ab.nav.databinding.ActivityMainBinding;
import com.e9ab98e991ab.nav.fragment.ClassificationFragment;
import com.e9ab98e991ab.nav.fragment.HomeFragment;
import com.e9ab98e991ab.nav.fragment.MineFragment;
import com.e9ab98e991ab.nav.fragment.TopicFragment;
import com.e9ab98e991ab.nav.moduler.NavItem;
import com.google.common.collect.Lists;
import com.jkb.fragment.rigger.annotation.Puppet;
import com.jkb.fragment.rigger.rigger.Rigger;

@Puppet(containerViewId = R.id.main_container, stickyStack = true)
public class MainJavaActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setTitle(R.string.app_name_java);
        init();
    }

    private void init() {
        mainBinding.navContainer.addItem(
                Lists.newArrayList(
                new NavItem(R.string.home, R.raw.icon_home, R.color.blue),
                new NavItem(R.string.classification, R.raw.icon_home, R.color.red),
                new NavItem(R.string.topic, R.raw.icon_home, R.color.yellow),
                new NavItem(R.string.mine, R.raw.icon_home, R.color.green)
        ));
        mainBinding.navContainer.setCustomSelectedPosition(0);
        Rigger.getRigger(this).startFragment(HomeFragment.newInstance());
        mainBinding.navContainer.setOnItemClickListener((newPosition, oldPosition) -> {
            Toast.makeText(this,"newPosition:"+newPosition+" oldPosition:"+oldPosition,Toast.LENGTH_SHORT).show();
            mainBinding.navContainer.setCustomSelectedPosition(newPosition);
            switch (newPosition){
                case 0:
                    Rigger.getRigger(this).startFragment(HomeFragment.newInstance());
                    break;
                case 1:
                    Rigger.getRigger(this).startFragment(ClassificationFragment.newInstance());
                    break;
                case 2:
                    Rigger.getRigger(this).startFragment(TopicFragment.newInstance());
                    break;
                case 3:
                    Rigger.getRigger(this).startFragment(MineFragment.newInstance());
                    break;
                    default:
                        break;
            }

        });

    }


}
