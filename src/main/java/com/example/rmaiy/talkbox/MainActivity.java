package com.example.rmaiy.talkbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    List<TalkBox> messageList = new ArrayList<TalkBox>();
    TalkBoxAdapter talkBoxAdapter;
    ListView listView;
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initArrayList();
        talkBoxAdapter = new TalkBoxAdapter(MainActivity.this, R.layout.talkbox, messageList);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(talkBoxAdapter);
        editText = (EditText) findViewById(R.id.message);
        button = (Button) findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (!text.equals("")) {
                    TalkBox talkBox = new TalkBox(TalkBox.RECEIVE_MESSAGE, text);
                    messageList.add(talkBox);
                    talkBoxAdapter.notifyDataSetChanged();
                    listView.setSelection(messageList.size());
                    editText.setText("");
                }
            }
        });

    }

    public void initArrayList() {
        TalkBox m1 = new TalkBox(TalkBox.SEND_MESSAGE, "hello");
        TalkBox m2 = new TalkBox(TalkBox.RECEIVE_MESSAGE, "world");
        TalkBox m3 = new TalkBox(TalkBox.SEND_MESSAGE, "haha");
        messageList.add(m1);
        messageList.add(m2);
        messageList.add(m3);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
