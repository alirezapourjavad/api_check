package com.example.myapplication2.home

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.myapplication2.databinding.HomeFragmentBinding
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class HomeFragment : Fragment() {

    var android_id = ""

    lateinit var binding: HomeFragmentBinding
    private lateinit var viewModel: HomeViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAndroidId(requireContext())
        var re = viewModel.responseId
        viewModel.callApiRequestCheckUser(re)

        setText()

        viewModel.response.observe(viewLifecycleOwner) {
            Glide.with(requireActivity()).load("http://130.185.73.21" + it.photo)
                .into(binding.imgAdver)
            binding.tvLink.text = it.link
        }

        viewModel.checkConnection.observe(viewLifecycleOwner) {
            if (it == 100) {
                Toast.makeText(requireContext(), "ok", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.checkConnection2.observe(viewLifecycleOwner) {
            if (it == 100) {
                Toast.makeText(requireContext(), "check ok", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "error check", Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun setText() {

        binding.tvAndroidId.text = android_id
//        viewModel.response2.observe(viewLifecycleOwner) {
//            if (it.userExist == true) {
//                binding.tvCheckAnswer.text = "true"
//            } else {
//                binding.tvCheckAnswer.text = "false"
//            }
//        }

    }
}