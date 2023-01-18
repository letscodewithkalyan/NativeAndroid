package com.example.mynotes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mynotes.R
import com.example.mynotes.databinding.FragmentLoginBinding
import com.example.mynotes.models.UserRequest
import com.example.mynotes.utils.NetworkResult
import com.example.mynotes.utils.TokenManager
import com.example.mynotes.viewmodels.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding:FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val authViewModel by activityViewModels<AuthViewModel>()

    @Inject
    lateinit var tokenManager: TokenManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentLoginBinding.inflate(inflater, container, false)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleEvents()
        bindObservers()
    }

    fun handleEvents()
    {
        binding.loginButton.setOnClickListener {
            var result = validateUserInput()
            if(result.first){
                val userRequest = UserRequest(binding.email.toString(), binding.password.toString(),"")
                authViewModel.loginUser(userRequest)
            }else{
                Toast.makeText(context,result.second,Toast.LENGTH_LONG).show()
            }
        }
        binding.btnSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }

    fun bindObservers(){
        authViewModel.userResponseLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Success -> {
                    tokenManager.saveToken(it.data!!.token)
                    var bundle = bundleOf("amount" to "test")
                    findNavController().navigate(
                        R.id.action_loginFragment_to_notesHomeFragment,
                        bundle
                    );
                }
                is NetworkResult.Error -> {
                    Toast.makeText(this.context, "Error", Toast.LENGTH_LONG).show()
                }
                is NetworkResult.Loading -> {

                }
            }
        }
    }

    fun onLoginClicked()
    {

    }

    fun validateUserInput():Pair<Boolean, String> {
        var email = binding.email.text.toString()
        var password = binding.password.text.toString()
        return authViewModel.validateLoginCredentials(email,password)
    }
}