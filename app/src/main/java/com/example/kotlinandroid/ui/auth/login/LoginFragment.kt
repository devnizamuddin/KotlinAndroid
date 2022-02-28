package com.example.kotlinandroid.ui.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinandroid.R
import com.example.kotlinandroid.databinding.FragmentLoginBinding
import com.example.kotlinandroid.ui.auth.signup.SignUpViewModel
import com.example.kotlinandroid.ui.auth.signup.SignupFragment
import com.example.kotlinandroid.uitls.ManageFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentLoginBinding
    lateinit var viewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        val manageFragment = ManageFragment(requireActivity())
        binding.signupBtn.setOnClickListener {
            manageFragment.changeFragmentWithBackStack(
                SignupFragment(),
                R.id.auth_container,
                "login"
            )
        }

        binding.loginBtn.setOnClickListener(View.OnClickListener {
            view->

            val email = binding.emailEt.text.toString()
            val password = binding.passwordEt.text.toString()
            viewModel.loginUser(email,password)

                    })

        return binding.root
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}