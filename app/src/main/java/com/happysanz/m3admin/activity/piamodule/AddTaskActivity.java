package com.happysanz.m3admin.activity.piamodule;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.happysanz.m3admin.R;
import com.happysanz.m3admin.bean.pia.StoreMobilizer;
import com.happysanz.m3admin.helper.AlertDialogHelper;
import com.happysanz.m3admin.helper.ProgressDialogHelper;
import com.happysanz.m3admin.interfaces.DialogClickListener;
import com.happysanz.m3admin.servicehelpers.ServiceHelper;
import com.happysanz.m3admin.serviceinterfaces.IServiceListener;
import com.happysanz.m3admin.utils.AppValidator;
import com.happysanz.m3admin.utils.M3AdminConstants;
import com.happysanz.m3admin.utils.PreferenceStorage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AddTaskActivity extends AppCompatActivity implements View.OnClickListener, IServiceListener, DialogClickListener, DatePickerDialog.OnDateSetListener {

    private static final String TAG = AddTaskActivity.class.getName();

    private DatePickerDialog mDatePicker;
    private SimpleDateFormat mDateFormatter;
    private ServiceHelper serviceHelper;
    private ProgressDialogHelper progressDialogHelper;
    Spinner spnMobilizer;
    String storeMobilizerId = "", res;
    Button save;
    private List<String> mStatusList = new ArrayList<String>();
    private ArrayAdapter<String> mStatusAdapter = null;

    EditText txtTitle, txtDetails, txtDate;
    private TextView txtStatus, txtType;
    private List<String> mTypeList = new ArrayList<String>();
    private ArrayAdapter<StoreMobilizer> mTypeAdapter = null;
    private String tasktypeID = "";
    ArrayList<StoreMobilizer> classesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task_activity);
        serviceHelper = new ServiceHelper(this);
        serviceHelper.setServiceListener(this);
        progressDialogHelper = new ProgressDialogHelper(this);
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), TaskActivity.class);
//                startActivity(intent);
                finish();
            }
        });
        TextView text1 = findViewById(R.id.title);
        text1.setText(PreferenceStorage.getMobName(this) + " - Create Task");
        storeMobilizerId = PreferenceStorage.getMobId(this);
        spnMobilizer = findViewById(R.id.spn_mobilizer);
        txtTitle = findViewById(R.id.task_title);
        txtDetails = findViewById(R.id.task_link);
        txtDate = findViewById(R.id.task_date);
        txtDate.setOnClickListener(this);
        txtDate.setFocusable(false);
        loadMobilizers();
        spnMobilizer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                StoreMobilizer classList = (StoreMobilizer) parent.getSelectedItem();

                storeMobilizerId = classList.getMobilizerId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        save = findViewById(R.id.save_task);
        save.setOnClickListener(this);
        mDateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);


        txtStatus = findViewById(R.id.status);
        txtStatus.setOnClickListener(this);
        txtStatus.setFocusable(false);

        mStatusList.add("Ongoing");
        mStatusList.add("Completed");

        mStatusAdapter = new ArrayAdapter<String>(this, R.layout.gender_layout, R.id.gender_name, mStatusList) { // The third parameter works around ugly Android legacy. http://stackoverflow.com/a/18529511/145173
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                Log.d(TAG, "getview called" + position);
                View view = getLayoutInflater().inflate(R.layout.gender_layout, parent, false);
                TextView gendername = (TextView) view.findViewById(R.id.gender_name);
                gendername.setText(mStatusList.get(position));

                // ... Fill in other views ...
                return view;
            }
        };

        txtType = findViewById(R.id.task_type);
        txtType.setOnClickListener(this);
        txtType.setFocusable(false);

//        mTypeList.add("Field Work");
//        mTypeList.add("Office Work");


    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Calendar newDate = Calendar.getInstance();
        newDate.set(year, monthOfYear, dayOfMonth);
        txtDate.setText(mDateFormatter.format(newDate.getTime()));
    }

    private void loadMobilizers() {
        res = "spnWork";
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(M3AdminConstants.KEY_USER_ID, PreferenceStorage.getUserId(getApplicationContext()));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        progressDialogHelper.showProgressDialog(getString(R.string.progress_loading));
        String url = M3AdminConstants.BUILD_URL + M3AdminConstants.GET_WORK_TYPE_MASTER;
        serviceHelper.makeGetServiceCall(jsonObject.toString(), url);
    }

    @Override
    public void onClick(View view) {
        if (view == save) {
            if (validateFields()) {
                sendTaskValues();
            }
        } else if (view == txtDate) {
            showBirthdayDate();
        } else if (view == txtStatus) {
            showGenderList();
        } else if (view == txtType) {
            showTypeList();
        }
    }

    private void showGenderList() {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(this);

        builderSingle.setTitle("Select Status");
        View view = getLayoutInflater().inflate(R.layout.gender_header_layout, null);
        TextView header = (TextView) view.findViewById(R.id.gender_header);
        header.setText("Select Status");
        builderSingle.setCustomTitle(view);

        builderSingle.setAdapter(mStatusAdapter
                ,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strName = mStatusList.get(which);
                        txtStatus.setText(strName);
                    }
                });
        builderSingle.show();
    }

    private void showTypeList() {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(this);

        builderSingle.setTitle("Select Type");
        View view = getLayoutInflater().inflate(R.layout.gender_header_layout, null);
        TextView header = (TextView) view.findViewById(R.id.gender_header);
        header.setText("Select Type");
        builderSingle.setCustomTitle(view);

        builderSingle.setAdapter(mTypeAdapter
                ,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        StoreMobilizer classList = (StoreMobilizer) classesList.get(which);
                        txtType.setText(classList.getMobilizerName());
                        tasktypeID = classList.getMobilizerId();
                        if (tasktypeID.equalsIgnoreCase("2") || tasktypeID.equalsIgnoreCase("1")) {
                            findViewById(R.id.ti_task_title).setVisibility(View.VISIBLE);
                        } else {
                            findViewById(R.id.ti_task_title).setVisibility(View.GONE);
                        }
                    }
                });
        builderSingle.show();
    }

    private boolean validateFields() {
        if (!AppValidator.checkNullString(this.txtTitle.getText().toString().trim())) {
            if (tasktypeID.equalsIgnoreCase("2") || tasktypeID.equalsIgnoreCase("1")) {
                AlertDialogHelper.showSimpleAlertDialog(this, "Give your task a title");
                return false;
            } else {
                return true;
            }
        } else if (!AppValidator.checkNullString(this.txtDetails.getText().toString().trim())) {
            AlertDialogHelper.showSimpleAlertDialog(this, "Write your task");
            return false;
        } else if (!AppValidator.checkNullString(this.txtDate.getText().toString().trim())) {
            AlertDialogHelper.showSimpleAlertDialog(this, "Choose the date");
            return false;
        } else if (!AppValidator.checkNullString(this.txtType.getText().toString().trim())) {
            AlertDialogHelper.showSimpleAlertDialog(this, "Choose task type");
            return false;
        } else if (!AppValidator.checkNullString(storeMobilizerId)) {
            AlertDialogHelper.showSimpleAlertDialog(this, "Select mobilizer");
            return false;
        } else {
            return true;
        }
    }

    private void sendTaskValues() {
        res = "addval";

        String title = txtTitle.getText().toString();
        String details = txtDetails.getText().toString();
        String serverFormatDate = "";
        String Task = "";
        Task = tasktypeID;

        if (txtDate.getText().toString() != null && txtDate.getText().toString() != "") {

            String date = txtDate.getText().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
            Date testDate = null;
            try {
                testDate = sdf.parse(date);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            serverFormatDate = formatter.format(testDate);
            System.out.println(".....Date..." + serverFormatDate);
        }
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(M3AdminConstants.KEY_USER_ID, PreferenceStorage.getUserId(getApplicationContext()));
            jsonObject.put(M3AdminConstants.PARAMS_MOBILIZER_ID, storeMobilizerId);
            jsonObject.put(M3AdminConstants.PARAMS_TASK_TITLE, title);
            jsonObject.put(M3AdminConstants.PARAMS_TASK_COMMENTS, details);
            jsonObject.put(M3AdminConstants.PARAMS_TASK_DATE, serverFormatDate);
            jsonObject.put(M3AdminConstants.PARAMS_TASK_ID, "");
            jsonObject.put(M3AdminConstants.PARAMS_TASK_TYPE, Task);
            jsonObject.put(M3AdminConstants.PARAMS_STATUS, txtStatus.getText().toString());
            jsonObject.put(M3AdminConstants.PARAMS_CREATED_AT, "");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        progressDialogHelper.showProgressDialog(getString(R.string.progress_loading));
        String url = M3AdminConstants.BUILD_URL + M3AdminConstants.TASK_ADD;
        serviceHelper.makeGetServiceCall(jsonObject.toString(), url);
    }

    private void showBirthdayDate() {
        Log.d(TAG, "Show the birthday date");
        Calendar newCalendar = Calendar.getInstance();
        String currentdate = txtDate.getText().toString();
        Log.d(TAG, "current date is" + currentdate);
        int month = newCalendar.get(Calendar.MONTH);
        int day = newCalendar.get(Calendar.DAY_OF_MONTH);
        int year = newCalendar.get(Calendar.YEAR);
        if ((currentdate != null) && !(currentdate.isEmpty())) {
            //extract the date/month and year
            try {
                Date startDate = mDateFormatter.parse(currentdate);
                Calendar newDate = Calendar.getInstance();

                newDate.setTime(startDate);
                month = newDate.get(Calendar.MONTH);
                day = newDate.get(Calendar.DAY_OF_MONTH);
                year = newDate.get(Calendar.YEAR);
                Log.d(TAG, "month" + month + "day" + day + "year" + year);

            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                mDatePicker = new DatePickerDialog(this, R.style.datePickerTheme, this, year, month, day);
                mDatePicker.show();
            }
        } else {
            Log.d(TAG, "show default date");

            mDatePicker = new DatePickerDialog(this, R.style.datePickerTheme, this, year, month, day);
            mDatePicker.show();
        }
    }

    @Override
    public void onAlertPositiveClicked(int tag) {

    }

    @Override
    public void onAlertNegativeClicked(int tag) {

    }

    @Override
    public void onResponse(JSONObject response) {
        progressDialogHelper.hideProgressDialog();
        if (validateSignInResponse(response)) {

            try {
                if (res.equalsIgnoreCase("spnWork")) {
                    JSONArray getData = response.getJSONArray("result");
                    int getLength = getData.length();
                    String subjectName = null;
                    Log.d(TAG, "userData dictionary" + getData.toString());

                    String classId = "";
                    String className = "";
                    for (int i = 0; i < getLength; i++) {

                        classId = getData.getJSONObject(i).getString("id");
                        className = getData.getJSONObject(i).getString("work_type");

                        classesList.add(new StoreMobilizer(classId, className));
                    }

                    //fill data in spinner
//                    ArrayAdapter<StoreMobilizer> adapter = new ArrayAdapter<StoreMobilizer>(getApplicationContext(), R.layout.spinner_item_ns, classesList);
//                    spnMobilizer.setAdapter(adapter);

                    mTypeAdapter = new ArrayAdapter<StoreMobilizer>(this, R.layout.gender_layout, R.id.gender_name, classesList) { // The third parameter works around ugly Android legacy. http://stackoverflow.com/a/18529511/145173
                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            Log.d(TAG, "getview called" + position);
                            View view = getLayoutInflater().inflate(R.layout.gender_layout, parent, false);
                            TextView gendername = (TextView) view.findViewById(R.id.gender_name);
                            gendername.setText(classesList.get(position).getMobilizerName());

                            // ... Fill in other views ...
                            return view;
                        }
                    };

                } else {
                    Toast.makeText(this, "You've just created a task!", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getApplicationContext(), TaskActivity.class);
//                    startActivity(intent);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean validateSignInResponse(JSONObject response) {
        boolean signInSuccess = false;
        if ((response != null)) {
            try {
                String status = response.getString("status");
                String msg = response.getString(M3AdminConstants.PARAM_MESSAGE);
                Log.d(TAG, "status val" + status + "msg" + msg);

                if ((status != null)) {
                    if (((status.equalsIgnoreCase("activationError")) || (status.equalsIgnoreCase("alreadyRegistered")) ||
                            (status.equalsIgnoreCase("notRegistered")) || (status.equalsIgnoreCase("error")))) {
                        signInSuccess = false;
                        Log.d(TAG, "Show error dialog");
                        AlertDialogHelper.showSimpleAlertDialog(this, msg);

                    } else {
                        signInSuccess = true;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return signInSuccess;
    }

    @Override
    public void onError(String error) {

    }
}
