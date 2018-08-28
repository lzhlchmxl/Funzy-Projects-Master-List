package com.project.studysmarter.studysmarter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class ToDoItem implements Serializable{
    private String mToDoText;
    private boolean mHasReminder;
    private int mTodoColor;
    private Date mToDoDate;
    private UUID mTodoIdentifier;
    private long mTaskDuration;
    private String mCategory;

    private static final String TODOTEXT = "todotext";
    private static final String TODOREMINDER = "todoreminder";
    private static final String TODOCOLOR = "todocolor";
    private static final String TODODATE = "tododate";
    private static final String TODOIDENTIFIER = "todoidentifier";
    private static final String TASKDURATION = "taskduration";
    private static final String CATEGORY = "taskcategory";


    public ToDoItem(String todoCategory, String todoBody, boolean hasReminder, Date toDoDate){
        mToDoText = todoBody;
        mHasReminder = hasReminder;
        mToDoDate = toDoDate;
        mTodoColor = 1677725;
        mTodoIdentifier = UUID.randomUUID();
        mTaskDuration = 0L;
        mCategory = todoCategory;
    }

    public ToDoItem(JSONObject jsonObject) throws JSONException{
        mToDoText = jsonObject.getString(TODOTEXT);
        mHasReminder = jsonObject.getBoolean(TODOREMINDER);
        mTodoColor = jsonObject.getInt(TODOCOLOR);
        mTodoIdentifier = UUID.fromString(jsonObject.getString(TODOIDENTIFIER));
        mTaskDuration = jsonObject.getLong(TASKDURATION);
        mCategory = jsonObject.getString(CATEGORY);

        if(jsonObject.has(TODODATE)){
            mToDoDate = new Date(jsonObject.getLong(TODODATE));
        }

    }

    public JSONObject toJSON() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(TODOTEXT, mToDoText);
        jsonObject.put(TODOREMINDER, mHasReminder);
        jsonObject.put(TASKDURATION, mTaskDuration);
        jsonObject.put(CATEGORY, mCategory);
        if(mToDoDate!=null){
            jsonObject.put(TODODATE, mToDoDate.getTime());
        }
        jsonObject.put(TODOCOLOR, mTodoColor);
        jsonObject.put(TODOIDENTIFIER, mTodoIdentifier.toString());

        return jsonObject;
    }


    public ToDoItem(){
        this("housework", "Clean my room", true, new Date());
    }

    public String getToDoText() {
        return mToDoText;
    }

    public void setToDoText(String mToDoText) {
        this.mToDoText = mToDoText;
    }

    public boolean hasReminder() {
        return mHasReminder;
    }

    public void setHasReminder(boolean mHasReminder) {
        this.mHasReminder = mHasReminder;
    }

    public int getTodoColor() {
        return mTodoColor;
    }

    public void setTodoColor(int mTodoColor) {
        this.mTodoColor = mTodoColor;
    }

    public Date getToDoDate() {

        Date tempDate = new Date(2050, 1,1);
        if (hasReminder()) {
            tempDate = mToDoDate;
        }

        return tempDate;
    }

    public void setToDoDate(Date mToDoDate) {
        this.mToDoDate = mToDoDate;
    }

    public long getTaskDuration() {
        return mTaskDuration;
    }

    public void setTaskDuration(long mTaskDuration) {
        this.mTaskDuration = mTaskDuration;
    }

    public String getCategory() { return mCategory;}

    public void setCategory(String mCategory) {this.mCategory = mCategory;}


    public UUID getIdentifier(){
        return mTodoIdentifier;
    }
}

