package castanedo.carlos.kotlinappcarloscastanedo.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import castanedo.carlos.kotlinappcarloscastanedo.MainActivity
import castanedo.carlos.kotlinappcarloscastanedo.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterFragment : Fragment(), OnClickListener {

    private lateinit var auth: FirebaseAuth
    private lateinit var navController: NavController
    lateinit var edTxtEmail: EditText
    lateinit var edTxtPassword: EditText
    lateinit var edTxtRePassword: EditText
    lateinit var registerButton: Button
    lateinit var cancelButton: Button

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
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edTxtEmail = view.findViewById(R.id.edTxtEmailRegister)
        edTxtPassword = view.findViewById(R.id.edTxtPasswordRegister)
        edTxtRePassword = view.findViewById(R.id.edTxtRePasswordRegister)
        registerButton = view.findViewById(R.id.registerButtonRegister)
        cancelButton = view.findViewById(R.id.cancelButtonRegister)

        registerButton.setOnClickListener(this)
        cancelButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.registerButtonRegister) {
            val sEmail = edTxtEmail.text.toString()
            val sPassword = edTxtPassword.text.toString()
            val sRePassword = edTxtRePassword.text.toString()

            if (sEmail.isEmpty() || sPassword.isEmpty()) {
                Toast.makeText(
                    requireActivity(),
                    "Authentication failed.",
                    Toast.LENGTH_SHORT,
                ).show()
                return
            } else if (sPassword != sRePassword) {
                Toast.makeText(
                    requireActivity(),
                    "Passwords are not the same.",
                    Toast.LENGTH_SHORT,
                ).show()
                return
            } else {
                auth.createUserWithEmailAndPassword(sEmail, sPassword)
                    .addOnCompleteListener(requireActivity()) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            navController.navigate(R.id.action_registerFragment_to_loginFragment)
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                requireActivity(),
                                "Authentication failed.",
                                Toast.LENGTH_SHORT,
                            ).show()
                        }
                    }

            }
        }
        else if(v!!.id == R.id.cancelButtonRegister){
            navController.navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
}