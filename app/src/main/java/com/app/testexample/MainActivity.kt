package com.app.testexample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.testexample.adapter.UserAdapter
import com.app.testexample.databinding.ActivityMainBinding
import com.app.testexample.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var imageAdapter : UserAdapter

    private val viewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        imageAdapter = UserAdapter()
        viewModel.responseImages.observe(this) { cases ->
            binding.recyclerView.apply {
                adapter = imageAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
                setHasFixedSize(true)
                imageAdapter.submitList(cases.data)
            }
        }
    }
}