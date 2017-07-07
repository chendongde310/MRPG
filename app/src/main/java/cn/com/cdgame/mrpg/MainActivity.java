package cn.com.cdgame.mrpg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.cdgame.mrpg.abst.Emotion;
import cn.com.cdgame.mrpg.abst.Friendliness;
import cn.com.cdgame.mrpg.abst.Job;
import cn.com.cdgame.mrpg.object.npc.BaseNPC;
import cn.com.cdgame.mrpg.object.npc.TalkCallback;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        test();
    }

    BaseNPC testnpc;
    private void test() {
        testnpc = new BaseNPC();
        testnpc.setAge("20");
        testnpc.setGender("M");
        testnpc.setName("小王");
        testnpc.setId("npc000000001");
        Emotion emotion = new Emotion();
        emotion.value = 0;
        Job job = new Job();  //职业
        job.setJobId("job000251525");
        job.setName("商贩");
        job.setLv("1");
        Friendliness friendliness = new Friendliness(); //友善值
        friendliness.value = 10;
        testnpc.setJob(job);
        testnpc.setFriendliness(friendliness);
        testnpc.setEmotion(emotion);
    }

    @OnClick(R.id.button)
    public void onClick() {
        testnpc.talking(editText.getText().toString(), new TalkCallback() {
            @Override
            public void onNext(String reply) {
                textView.setText(reply);
            }

            @Override
            public void onError() {
                textView.setText("这个人不知道你在说什么的样子");
            }
        });
    }
}
