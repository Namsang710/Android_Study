package com.example.practice_customcalender

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.practice_customcalender.databinding.ActivityMainBinding
import com.example.practice_customcalender.ui.theme.Practice_CustomCalenderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val monthListManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) // 가로로 전환하기 위해서 HORIZONTAL 속성 주기
        val monthListAdapter = AdapterMonth()

        binding.recyclerviewCustomcalendar.apply {
            layoutManager = monthListManager
            adapter = monthListAdapter
            scrollToPosition(Int.MAX_VALUE / 2)
        }


        val snap = PagerSnapHelper()
        snap.attachToRecyclerView(binding.recyclerviewCustomcalendar)

        // 리사이클러뷰를 통한 커스텀 달력 구현은 성능이 좋지 않음.
        // 다른 커스텀달력 라이브러리를 사용하려했으나 Kotlin DSL에 적용되지 않는듯... 라이브러리 설치가 안됨


        // git commit 테스트
    }
}

