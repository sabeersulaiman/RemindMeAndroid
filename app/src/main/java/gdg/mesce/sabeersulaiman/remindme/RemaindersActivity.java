package gdg.mesce.sabeersulaiman.remindme;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RemaindersActivity extends AppCompatActivity {

    private ListView mListView;
    private RemindersDBAdaptor mDbAdapter;
    private RemindersCursorAdaptor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remainders);
        mListView = (ListView) findViewById(R.id.RemainderListView);

        mDbAdapter = new RemindersDBAdaptor(this);
        mDbAdapter.open();

        Cursor cursor = mDbAdapter.fetchAllReminders();

        String[] from = new String[]{
                RemindersDBAdaptor.COL_CONTENT
        };

        int[] to = new int[]{
                R.id.rowText
        };

        mCursor = new RemindersCursorAdaptor(
                RemaindersActivity.this,
                R.layout.remainder_list_item,
                cursor,
                from,
                to,
                0
        );

        mListView.setAdapter(mCursor);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_remainders, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id)
        {
            case R.id.action_new:
                Log.d(getLocalClassName(), "create new Reminder");
                return true;
            case R.id.action_exit:
                finish();
                return true;
            default:
                //error
                break;
        }

        return false;
    }
}
