package com.example.demo_home

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Khai báo và liên kết với ID trong XML
        val editName = findViewById<EditText>(R.id.editName)
        val editAge = findViewById<EditText>(R.id.editAge)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val tvResult = findViewById<TextView>(R.id.tvResult) // Sửa thành đúng ID của TextView hiển thị kết quả

        // Xử lý khi nhấn nút Kiểm tra
        btnCheck.setOnClickListener {
            val name = editName.text.toString().trim()
            val ageText = editAge.text.toString().trim()

            // Kiểm tra nếu các trường bị để trống
            if (name.isEmpty() || ageText.isEmpty()) {
                tvResult.text = getString(R.string.error_empty_fields)
                return@setOnClickListener
            }

            // Chuyển đổi tuổi thành số nguyên
            val age = ageText.toIntOrNull()
            if (age == null || age < 0) {
                tvResult.text = getString(R.string.error_invalid_age)
                return@setOnClickListener
            }

            // Phân loại độ tuổi
            val category = when {
                age > 65 -> getString(R.string.category_old)
                age in 6..65 -> getString(R.string.category_adult)
                age in 2..5 -> getString(R.string.category_child)
                else -> getString(R.string.category_baby)
            }

            // Hiển thị kết quả
            tvResult.text = getString(R.string.result_message, name, category)
        }
    }
}
