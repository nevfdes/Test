package com.persistent.esansad.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by pranav_tendolkar on 4/2/2015.
 */
public class MemberOfParliamentORM {
    private static final String TAG = "MemberOfParliamentORM";

    private static final  String Amount_recommended="Amount_recommended";
    private static final  String last_name="last_name";
    private static final  String District="District";
    private static final  String education_details="education_details";
    private static final  String house="house";
    private static final  String image="image";
    private static final  String elected="elected";
    private static final  String Percent_of_utilisation_over_released="Percent_of_utilisation_over_released";
    private static final  String  questions="questions";
    private static final  String private_bills="private_bills";
    private static final  String first_name="first_name";
    private static final  String state="state";
    private static final  String term_end="term_end";
    private static final  String party="party";

    private static final  String email="email";
    private static final  String Amount_sanctioned="Amount_sanctioned";
    private static final  String Unspent_balance="Unspent_balance";

    private static final  String Amount_available_with_interest="Amount_available_with_interest";
    private static final  String Entitlement_of_Constituency="Entitlement_of_Constituency";
    private static final  String gender="gender";
    private static final  String age="age";
    private static final  String mp_id="mp_id";
    private static final  String attendance_percentage="attendance_percentage";
    private static final  String Released_by_government_of_India="Released_by_government_of_India";

    private static final  String education_qualification="education_qualification";
    private static final  String Expenditure_incurred="Expenditure_incurred";
    private static final  String constituency="constituency";


    private static final  String TABLE_NAME="MP";
    private static final  String COMMA_SEP=",";


    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    Amount_recommended + " " + "INTEGER" + COMMA_SEP +
                    last_name + " " + "TEXT" + COMMA_SEP +
                    District + " " + "TEXT" + COMMA_SEP +
                    education_details + " " + "TEXT" + COMMA_SEP +
                    house + " " + "TEXT" + COMMA_SEP +
                    image + " " + "TEXT" + COMMA_SEP +
                    elected + " " + "TEXT" + COMMA_SEP +
                    first_name + " " + "TEXT" + COMMA_SEP +
                    state + " " + "TEXT" + COMMA_SEP +
                    term_end + " " + "TEXT" + COMMA_SEP +
                    party + " " + "TEXT" + COMMA_SEP +
                    email + " " + "TEXT" + COMMA_SEP +
                    gender + " " + "TEXT" + COMMA_SEP +
                    mp_id + " " + "TEXT" + COMMA_SEP +
                    education_qualification + " " + "TEXT" + COMMA_SEP +
                    constituency + " " + "TEXT PRIMARY KEY" + COMMA_SEP +

                    Percent_of_utilisation_over_released + " " + "INTEGER" + COMMA_SEP +
                    questions + " " + "INTEGER" + COMMA_SEP +
                    private_bills + " " + "INTEGER" + COMMA_SEP +
                    Unspent_balance + " " + "INTEGER" + COMMA_SEP +
                    Amount_available_with_interest + " " + "INTEGER" + COMMA_SEP +
                    Amount_sanctioned + " " + "INTEGER" + COMMA_SEP +
                    Entitlement_of_Constituency + " " + "INTEGER" + COMMA_SEP +
                    attendance_percentage + " " + "INTEGER" + COMMA_SEP +
                    Released_by_government_of_India + " " + "INTEGER" + COMMA_SEP +
                    Expenditure_incurred + " " + "INTEGER" + COMMA_SEP +
                    ")";

    public static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;




    public static void insertMP(Context context, MemberOfParliament mp) {
        DatabaseWrapper databaseWrapper = new DatabaseWrapper(context);
        SQLiteDatabase database = databaseWrapper.getWritableDatabase();

        ContentValues values = postToContentValues(mp);
        long postId = database.insert(MemberOfParliamentORM.TABLE_NAME, "null", values);
        Log.i(TAG, "Inserted new Post with ID: " + postId);

        database.close();
    }

    /**
     * Packs a Post object into a ContentValues map for use with SQL inserts.
     */
    private static ContentValues postToContentValues(MemberOfParliament mp) {
        ContentValues values = new ContentValues();
        values.put(MemberOfParliamentORM.Amount_recommended, mp.getAmount_recommended());
        values.put(MemberOfParliamentORM.last_name, mp.getLast_name());
        values.put(MemberOfParliamentORM.District, mp.getDistrict());
        values.put(MemberOfParliamentORM.education_details, mp.getEducation_details());
        values.put(MemberOfParliamentORM.house, mp.getHouse());
        values.put(MemberOfParliamentORM.image, mp.getImage());
        values.put(MemberOfParliamentORM.elected, mp.getElected());
        values.put(MemberOfParliamentORM.Percent_of_utilisation_over_released, mp.getPercent_of_utilisation_over_released());
        values.put(MemberOfParliamentORM.questions, mp.getQuestions());
        values.put(MemberOfParliamentORM.private_bills, mp.getPrivate_bills());
        values.put(MemberOfParliamentORM.first_name, mp.getFirst_name());
        values.put(MemberOfParliamentORM.state, mp.getState());
        values.put(MemberOfParliamentORM.term_end, mp.getTerm_end());
        values.put(MemberOfParliamentORM.party, mp.getParty());
        values.put(MemberOfParliamentORM.email, mp.getEmail());
        values.put(MemberOfParliamentORM.Amount_sanctioned, mp.getAmount_sanctioned());
        values.put(MemberOfParliamentORM.Unspent_balance, mp.getUnspent_balance());
        values.put(MemberOfParliamentORM.Amount_available_with_interest, mp.getAmount_available_with_interest());
        values.put(MemberOfParliamentORM.Entitlement_of_Constituency, mp.getConstituency());
        values.put(MemberOfParliamentORM.Amount_available_with_interest, mp.getAmount_available_with_interest());
        values.put(MemberOfParliamentORM.gender, mp.getGender());
        values.put(MemberOfParliamentORM.age, mp.getAge());
        values.put(MemberOfParliamentORM.mp_id, mp.getMp_id());
        values.put(MemberOfParliamentORM.attendance_percentage, mp.getAttendance_percentage());
        values.put(MemberOfParliamentORM.Released_by_government_of_India, mp.getReleased_by_government_of_India());
        values.put(MemberOfParliamentORM.education_qualification, mp.getEducation_qualification());
        values.put(MemberOfParliamentORM.Expenditure_incurred, mp.getExpenditure_incurred());
        values.put(MemberOfParliamentORM.constituency, mp.getConstituency());

        return values;
    }



    private static final SimpleDateFormat _dateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);

    public static List<MemberOfParliament> getAllMPs(Context context) {
        DatabaseWrapper databaseWrapper = new DatabaseWrapper(context);
        SQLiteDatabase database = databaseWrapper.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM " + MemberOfParliamentORM.TABLE_NAME, null);

        Log.i(TAG, "Loaded " + cursor.getCount() + " Posts...");
        List<MemberOfParliament> postList = new ArrayList<MemberOfParliament>();

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                MemberOfParliament post = cursorToPost(cursor);
                postList.add(post);
                cursor.moveToNext();
            }
            Log.i(TAG, "Posts loaded successfully.");
        }

        database.close();

        return postList;
    }



    public static MemberOfParliament getMP(String constituency,Context context) {
        DatabaseWrapper databaseWrapper = new DatabaseWrapper(context);
        SQLiteDatabase database = databaseWrapper.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM " + MemberOfParliamentORM.TABLE_NAME+" WHERE constituency="+constituency, null);

        Log.i(TAG, "Loaded " + cursor.getCount() + " Posts...");
        //List<MemberOfParliament> postList = new ArrayList<MemberOfParliament>();
        MemberOfParliament memberOfParliament=null;
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                 memberOfParliament= cursorToPost(cursor);
        }

//        if(memberOfParliament== null)
//            throw new Resources.NotFoundException();



            Log.i(TAG, "Posts loaded successfully.");
        }

        database.close();

        return  memberOfParliament;
    }




    /**
     * Populates a Post object with data from a Cursor
     * @param cursor
     * @return
     */
    private static MemberOfParliament cursorToPost(Cursor cursor) {
        MemberOfParliament post = new MemberOfParliament();
        post.setAmount_recommended(cursor.getFloat(cursor.getColumnIndex(Amount_recommended)));
        post.setLast_name(cursor.getString(cursor.getColumnIndex(last_name)));
        post.setDistrict(cursor.getString(cursor.getColumnIndex(District)));
        post.setEducation_details(cursor.getString(cursor.getColumnIndex(education_details)));
        post.setHouse(cursor.getString(cursor.getColumnIndex(house)));
        post.setImage(cursor.getString(cursor.getColumnIndex(image)));
        post.setPercent_of_utilisation_over_released(cursor.getFloat(cursor.getColumnIndex(Percent_of_utilisation_over_released)));
        post.setQuestions(cursor.getInt(cursor.getColumnIndex(questions)));
        post.setPrivate_bills(cursor.getInt(cursor.getColumnIndex(private_bills)));
        post.setFirst_name(cursor.getString(cursor.getColumnIndex(first_name)));
        post.setState(cursor.getString(cursor.getColumnIndex(state)));
        post.setTerm_end(cursor.getString(cursor.getColumnIndex(term_end)));
        post.setParty(cursor.getString(cursor.getColumnIndex(party)));
        post.setEmail(cursor.getString(cursor.getColumnIndex(email)));
        post.setAmount_sanctioned(cursor.getFloat(cursor.getColumnIndex(Amount_sanctioned)));
        post.setUnspent_balance(cursor.getFloat(cursor.getColumnIndex(Unspent_balance)));
        post.setAmount_available_with_interest(cursor.getFloat(cursor.getColumnIndex(Amount_available_with_interest)));
        post.setEntitlement_of_Constituency(cursor.getFloat(cursor.getColumnIndex(Entitlement_of_Constituency)));
        post.setGender(cursor.getString(cursor.getColumnIndex(gender)));
        post.setAge(cursor.getInt(cursor.getColumnIndex(age)));
        post.setMp_id(cursor.getString(cursor.getColumnIndex(mp_id)));
        post.setAttendance_percentage(cursor.getInt(cursor.getColumnIndex(attendance_percentage)));
        post.setReleased_by_government_of_India(cursor.getFloat(cursor.getColumnIndex(Released_by_government_of_India)));
        post.setEducation_qualification(cursor.getString(cursor.getColumnIndex(education_qualification)));
        post.setConstituency(cursor.getString(cursor.getColumnIndex(constituency)));

        return post;
    }







}
