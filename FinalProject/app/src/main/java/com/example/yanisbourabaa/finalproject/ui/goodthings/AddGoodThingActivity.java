package com.example.yanisbourabaa.finalproject.ui.goodthings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import com.example.yanisbourabaa.finalproject.R;
import com.example.yanisbourabaa.finalproject.datamanagers.DataManager;
import com.example.yanisbourabaa.finalproject.datamanagers.DataManagerImpl;
import com.example.yanisbourabaa.finalproject.model.Thing;
import com.example.yanisbourabaa.finalproject.ui.home.HomeFragment;
import com.rengwuxian.materialedittext.MaterialEditText;

public class AddGoodThingActivity extends AppCompatActivity {

    DataManager mDataManager = DataManagerImpl.getInstance();
    int index;
    boolean empty;


    MaterialEditText materialEditText;
    Switch mSwitch;
    SeekBar mSeekBar;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_good_thing);

        index = getIntent().getExtras().getInt(HomeFragment.INDEX_OF_GOODTHING);
        empty = getIntent().getExtras().getBoolean(HomeFragment.GOODTHING_IS_EMPTY);

        materialEditText = (MaterialEditText) findViewById(R.id.add_good_et);
        mSwitch = (Switch) findViewById(R.id.add_good_switch);
        mSeekBar = (SeekBar) findViewById(R.id.add_good_seekbar);
        mButton = (Button) findViewById(R.id.add_good_btn);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sThing = materialEditText.getText().toString();
                if (!sThing.isEmpty()) {
                    Thing thing = new Thing(sThing, mSwitch.isActivated(), mSeekBar.getProgress());
                    if (mSwitch.isActivated())
                        mDataManager.addHappyThing(thing);
                    if (empty)
                        mDataManager.addThing(thing);
                    else
                        mDataManager.changeThing(index, thing);
                }
                finish();
            }
        });
    }
}
