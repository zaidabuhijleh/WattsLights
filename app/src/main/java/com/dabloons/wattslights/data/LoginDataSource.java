package com.dabloons.wattslights.data;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.dabloons.wattslights.data.model.LoggedInUser;
import com.dabloons.wattslights.data.model.User;
//import com.dabloons.wattslights.ui.login.LoggedInUserView;
import com.dabloons.wattslights.ui.login.LoginActivity;
//import com.dabloons.wattslights.ui.login.LoginResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource extends Activity {

    private FirebaseAuth mAuth;
    private  LoggedInUser loggedInUser;
    private FirebaseFirestore db;

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            mAuth = FirebaseAuth.getInstance();
            db = FirebaseFirestore.getInstance();
            mAuth.signInWithEmailAndPassword(username, password)
                    .addOnCompleteListener(LoginDataSource.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
//                                updateUiWithUser(new LoginResult(new LoggedInUserView(user.getDisplayName())).getSuccess());
                                updateUser(user);

                            } else {

                               updateUser(null);
                            }
                        }
                    });


            return  loggedInUser != null ? new Result.Success<>(loggedInUser) : new Result.Error(new IOException("Error logging in"));
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void updateUser(FirebaseUser firebaseUser)
    {
        if(firebaseUser == null)
        {
            loggedInUser = null;
        }
        else
        {
            loggedInUser = new LoggedInUser(firebaseUser.getUid(), firebaseUser.getDisplayName());
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}