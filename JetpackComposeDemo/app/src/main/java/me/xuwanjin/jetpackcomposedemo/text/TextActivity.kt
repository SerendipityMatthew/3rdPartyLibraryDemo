package me.xuwanjin.jetpackcomposedemo.text

import android.content.Context
import android.graphics.fonts.FontFamily
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.font.FontFamily.Companion.SansSerif
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.xuwanjin.jetpackcomposedemo.R

class TextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                val context = ContextAmbient.current
                SimpleText(context , getString(R.string.app_name))
            }
        }
    }
}

@Composable
fun SimpleText(context: Context, string: String) {
    Text(
        text = string,
        modifier = Modifier.wrapContentHeight().clickable(onClick = {
            Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
        }),
        color = Color(context.getColor(R.color.design_default_color_primary_dark)),
        fontSize = 20.sp,
        textAlign = TextAlign.Left,
        textDecoration = TextDecoration.LineThrough,
        letterSpacing = TextUnit.Companion.Sp(12),
        lineHeight = TextUnit.Companion.Sp(30),
        fontFamily = SansSerif,
        fontWeight = FontWeight.ExtraLight,


        )
}