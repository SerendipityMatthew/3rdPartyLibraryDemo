package me.xuwanjin.jetpackcomposedemo.text

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent

class TextFieldActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldTest()
        }
    }
}

@Composable
fun TextFieldTest() {
    var hello = "Matthew TextField"
    TextField(value = hello, onValueChange = {
        Log.d("Matthew", "TextFieldTest: $it")
    }, modifier = Modifier.clickable(onClick = {
    }))
}