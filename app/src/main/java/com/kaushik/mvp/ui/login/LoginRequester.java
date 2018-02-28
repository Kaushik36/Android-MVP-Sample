package com.kaushik.mvp.ui.login;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.kaushik.mvp.MvpApp;
import com.kaushik.mvp.data.network.VolleyCustomRequest;
import com.kaushik.mvp.utils.APIUtils;
import com.kaushik.mvp.utils.AppData;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by Kaushik on 28-02-2018.
 */

public class LoginRequester {

    private Context context;

    private Map<String, String> params;

    private OnLoginResponse delegate;

    public LoginRequester(Context context, Map<String, String> params, OnLoginResponse delegate) {

        this.context = context;
        this.params = params;
        this.delegate = delegate;

    }

    public void responseLogin() {

        String url = APIUtils.BASE_URL + APIUtils.LOGIN_URL;

        AppData.showLogMessage("URL: "+url);

        // Tag used to cancel the request
        String tag_json_obj = "json_obj_req_for_login";

        VolleyCustomRequest jsObjRequest = new VolleyCustomRequest(url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                AppData.showLogMessage("LOGIN_SUCCESS_TAG : "+response.toString());

                try {

                    if(response.optString("status").equalsIgnoreCase("success")){
                        delegate.onLoginSuccess(response.optString("message"));
                    }
                    else{
                        if (response.optString("message").matches("Account has been removed, Please contact to admin for re-active")){
                            delegate.onLoginSuccess("Login Successful");
                        }
                        else {
                            delegate.onLoginError(response.optString("message"));
                        }

                    }

                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                AppData.showLogMessage("LOGIN_ERROR_TAG : "+error.toString());

                delegate.onLoginError(error.getMessage());
            }
        });

          /* time out setting is optional */

        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(
                120000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


        MvpApp.getInstance().getRequestQueue().getCache().clear();
        MvpApp.getInstance().addToRequestQueue(jsObjRequest, tag_json_obj);


    }

}
