package me.xuwanjin.jetpackcomposedemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Radius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import me.xuwanjin.jetpackcomposedemo.constraintlayout.ConstraintLayoutActivity
import me.xuwanjin.jetpackcomposedemo.text.TextActivity
import me.xuwanjin.jetpackcomposedemo.text.TextFieldActivity

class MainActivity : AppCompatActivity() {
    @ExperimentalLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn() {
                val context = ContextAmbient.current
                ButtonComponent(
                    context = context,
                    intent = Intent(context, TextActivity::class.java),
                    buttonText = "text"
                )
                ButtonComponent(
                    context = context,
                    intent = Intent(context, TextFieldActivity::class.java),
                    buttonText = "textfield"
                )
                ButtonComponent(
                    context = context,
                    intent = Intent(context, ConstraintLayoutActivity::class.java) ,
                    buttonText = "ConstraintLayoutActivity"
                )
            }
        }
    }
}

@Composable
fun ButtonComponent(context: Context, intent: Intent, buttonText: String) {
    Button(
        onClick = {
            context.startActivity(intent)
        },
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.Gray,
    ) {
        Text(
            text = buttonText,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.fillMaxSize().padding(8.dp)
        )
    }
}




