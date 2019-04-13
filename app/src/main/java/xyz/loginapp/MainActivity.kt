package xyz.loginapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.signup.*



class MainActivity : AppCompatActivity() {

    lateinit var handler: DataBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.Layout.activity_main)

        handler = DataBaseHelper(this)

        showHome()


        signup_home.setOnClickListener{
            showSignUpPage()
        }


        login_home.setOnClickListener{
            showloginpage()
        }

        submit.setOnClickListener{
            handler.insertUserData(username.text.toString(), Email.text.toString(),
                Password.text.toString())
            showHome()
        }


        login_main.setOnClickListener{
            if(handler.userPresent(login_email.text.toString(), login_password.text.toString()))
            {
                Toast.makeText(this, "Login Successfully ", Toast.LENGTH_SHORT).show()

            }
            else {
                Toast.makeText(this, "Invalid User", Toast.LENGTH_SHORT).show()
            }
        }










    }

    private fun showloginpage(){

        .visibility=View.VISIBLE
        layout_signup.visibility=View.GONE
        homepage.visibility=View.GONE

    }

    private fun showSignUpPage(){

        layout_signup.visibility=View.VISIBLE
        layout_login.visibility=View.GONE
        homepage.visibility=View.GONE
    }

    private fun showHome(){

        homepage.visibility=View.VISIBLE
        layout_signup.visibility=View.GONE
        layout_login.visibility=View.GONE
    }



}


