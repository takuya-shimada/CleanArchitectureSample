package tyfrontier.cleanarchitecturesample.presentation.view.component;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import tyfrontier.cleanarchitecturesample.R;

public class ArticleListItemView extends LinearLayout {

    @Bind(R.id.title) TextView title;
    @Bind(R.id.user) TextView userName;
    @Bind(R.id.tags) TextView tags;
    @Bind(R.id.time) TextView time;

    public ArticleListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void setTitle(CharSequence title) {
        this.title.setText(title);
    }

    public void setUserName(CharSequence userName) {
        this.userName.setText(userName);
    }

    public void setTags(CharSequence tags) {
        this.tags.setText(tags);
    }

    public void setTime(CharSequence time) {
        this.time.setText(time);
    }
}
