package castanedo.carlos.kotlinappcarloscastanedo.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import castanedo.carlos.kotlinappcarloscastanedo.MainActivity
import castanedo.carlos.kotlinappcarloscastanedo.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment(), OnClickListener {

    private lateinit var auth: FirebaseAuth
    private lateinit var navController: NavController
    lateinit var edTxtEmail:EditText
    lateinit var edTxtPassword:EditText
    lateinit var loginButton:Button
    lateinit var registerButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        auth = Firebase.auth
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edTxtEmail = view.findViewById(R.id.edTxtEmailLogin)
        edTxtPassword = view.findViewById(R.id.edTxtPasswordLogin)
        loginButton = view.findViewById(R.id.loginButtonLogin)
        registerButton = view.findViewById(R.id.registerButtonLogin)

        loginButton.setOnClickListener(this)
        registerButton.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.loginButtonLogin){
            val sEmail = edTxtEmail.text.toString()
            val sPassword = edTxtPassword.text.toString()

            if (sEmail.isEmpty() || sPassword.isEmpty()) {
                Toast.makeText(
                    requireActivity(),
                    "Authentication failed.",
                    Toast.LENGTH_SHORT,
                ).show()
                return
            }

            auth.signInWithEmailAndPassword(sEmail, sPassword)
                .addOnCompleteListener(requireActivity()) { task ->

                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        var mainActivity: Intent = Intent(requireActivity(), MainActivity::class.java)
                        startActivity(mainActivity)
                        requireActivity().finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(
                            requireActivity(),
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }

        } else if(v!!.id == R.id.registerButtonLogin){
            navController.navigate(R.id.action_loginFragment_to_registerFragment2)
        }
    }


}