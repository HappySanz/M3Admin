package com.happysanz.m3admin.activity.tnsrlmmodule;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.happysanz.m3admin.R;
import com.happysanz.m3admin.activity.piamodule.AddCenterDetailActivity;
import com.happysanz.m3admin.helper.AlertDialogHelper;
import com.happysanz.m3admin.helper.ProgressDialogHelper;
import com.happysanz.m3admin.interfaces.DialogClickListener;
import com.happysanz.m3admin.servicehelpers.ServiceHelper;
import com.happysanz.m3admin.serviceinterfaces.IServiceListener;
import com.happysanz.m3admin.utils.M3AdminConstants;
import com.happysanz.m3admin.utils.M3Validator;
import com.happysanz.m3admin.utils.PreferenceStorage;

import org.json.JSONException;
import org.json.JSONObject;

import static android.util.Log.d;

public class AddNewPiaActivity extends AppCompatActivity implements IServiceListener, DialogClickListener {

    private static final String TAG = PiaActivity.class.getName();

    Button addNewPia;
    private ServiceHelper serviceHelper;
    private ProgressDialogHelper progressDialogHelper;
    String uniqueNumber, name, address, email, phone;
    EditText uNumber, piaName, piaAddress, piaEmail, piaPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pia);
        serviceHelper = new ServiceHelper(this);
        serviceHelper.setServiceListener(this);
        progressDialogHelper = new ProgressDialogHelper(this);

        uNumber = findViewById(R.id.pia_id);
        piaName = findViewById(R.id.pia_name);
        piaAddress = findViewById(R.id.pia_address);
        piaEmail = findViewById(R.id.pia_mail);
        piaPhone = findViewById(R.id.pia_phone);

        addNewPia = (Button) findViewById(R.id.save_pia);
        addNewPia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validateFields()){
                    uniqueNumber = uNumber.getText().toString();
                    name = piaName.getText().toString();
                    address = piaAddress.getText().toString();
                    email = piaEmail.getText().toString();
                    phone = piaPhone.getText().toString();

                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put(M3AdminConstants.PARAMS_USER_ID, PreferenceStorage.getUserId(getApplicationContext()));
                        jsonObject.put(M3AdminConstants.PARAMS_UNIQUE_NUMBER, uniqueNumber);
                        jsonObject.put(M3AdminConstants.PARAMS_NAME, name);
                        jsonObject.put(M3AdminConstants.PARAMS_ADDRESS, address);
                        jsonObject.put(M3AdminConstants.PARAMS_EMAIL, email);
                        jsonObject.put(M3AdminConstants.PARAMS_PHONE, phone);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    progressDialogHelper.showProgressDialog(getString(R.string.progress_loading));
                    String url = M3AdminConstants.BUILD_URL + M3AdminConstants.CREATE_PIA;
                    serviceHelper.makeGetServiceCall(jsonObject.toString(), url);
                }

            }
        });

        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onAlertPositiveClicked(int tag) {

    }

    @Override
    public void onAlertNegativeClicked(int tag) {

    }

    private boolean validateSignInResponse(JSONObject response) {
        boolean signInSuccess = false;
        if ((response != null)) {
            try {
                String status = response.getString("status");
                String msg = response.getString(M3AdminConstants.PARAM_MESSAGE);
                d(TAG, "status val" + status + "msg" + msg);

                if ((status != null)) {
                    if (((status.equalsIgnoreCase("activationError")) || (status.equalsIgnoreCase("alreadyRegistered")) ||
                            (status.equalsIgnoreCase("notRegistered")) || (status.equalsIgnoreCase("error")))) {
                        signInSuccess = false;
                        d(TAG, "Show error dialog");
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
    public void onResponse(JSONObject response) {
        progressDialogHelper.hideProgressDialog();
        if (validateSignInResponse(response)) {
            Intent intent = new Intent(this, PiaActivity.class);
            Toast.makeText(AddNewPiaActivity.this, "You have just created a profile for " + name + "!", Toast.LENGTH_SHORT).show();
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onError(String error) {

    }

    private boolean validateFields() {

        if (!M3Validator.checkNullString(this.uNumber.getText().toString().trim())) {
            uNumber.setError(getString(R.string.err_prn));
            requestFocus(uNumber);
            return false;
        } else if (!M3Validator.checkNullString(this.piaName.getText().toString().trim())) {
            piaName.setError(getString(R.string.err_name));
            requestFocus(piaName);
            return false;
        }else if (!M3Validator.checkNullString(this.piaAddress.getText().toString().trim())) {
            piaAddress.setError(getString(R.string.err_address));
            requestFocus(piaAddress);
            return false;
        }else if (!M3Validator.checkNullString(this.piaEmail.getText().toString().trim())) {
            piaEmail.setError(getString(R.string.err_mail));
            requestFocus(piaEmail);
            return false;
        }else if (!M3Validator.isEmailValid(this.piaEmail.getText().toString().trim())) {
            piaEmail.setError(getString(R.string.err_mail));
            requestFocus(piaEmail);
            return false;
        }else if (!M3Validator.checkMobileNumLength(this.piaPhone.getText().toString().trim())) {
            piaPhone.setError(getString(R.string.err_number_length));
            requestFocus(piaPhone);
            return false;
        }else if (!M3Validator.checkNullString(this.piaPhone.getText().toString().trim())) {
            piaPhone.setError(getString(R.string.err_number));
            requestFocus(piaPhone);
            return false;
        } else if (!M3Validator.checkUniqueNumLength(this.uNumber.getText().toString().trim())) {
            uNumber.setError(getString(R.string.err_min_uniq_length));
            requestFocus(uNumber);
            return false;
        }else {
            return true;
        }
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

}