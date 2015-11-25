/**
 * Created by Sabeer Sulaiman on 11/25/2015.
 */
public class Reminder {

    private int mId;
    private String mContent;
    private int mImp;

    public Reminder(int id, String content, int imp)
    {
        mId = id;
        mContent = content;
        mImp = imp;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public int getmImp() {
        return mImp;
    }

    public void setmImp(int mImp) {
        this.mImp = mImp;
    }
}
