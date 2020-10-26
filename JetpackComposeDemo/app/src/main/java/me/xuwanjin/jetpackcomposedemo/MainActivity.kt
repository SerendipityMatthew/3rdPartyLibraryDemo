package me.xuwanjin.jetpackcomposedemo

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.recyclerview.widget.RecyclerView
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutTest()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ConstraintLayoutTest() {
    val context = ContextAmbient.current
    ConstraintLayout(
        modifier = Modifier.wrapContentHeight()
            .fillMaxWidth()
    ) {
        val (tileImageContainer, readTime, bookmark
        ) = createRefs()

        ConstraintLayout(
            modifier = Modifier.background(color = Color.White)
                .constrainAs(tileImageContainer) {
                    start.linkTo(
                        parent.start,
                    )
                    end.linkTo(
                        parent.end
                    )
                }
                .fillMaxWidth()
                .wrapContentHeight(),
        ) {
            val (titleText, flyTitleText, articleImage) = createRefs()
            Text(
                text = "Matthew",
                color = Color.Red,
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Left,
                modifier = Modifier.wrapContentHeight()
                    .width(200.dp)
                    .clickable {
                        toast("Matthew", context)
                    }.constrainAs(titleText) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
            )
            Text(
                text = "Mona",
                color = Color.Red,
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Left,
                modifier = Modifier.wrapContentHeight()
                    .width(200.dp)
                    .clickable {
                        toast("Mona", context)
                    }.constrainAs(flyTitleText) {
                        top.linkTo(
                            titleText.bottom
                        )
                    },
            )
            Image(
                vectorResource(R.drawable.ic_launcher_foreground),
                modifier = Modifier
                    .background(color = Color.White)
                    .width(200.dp)
                    .height(110.dp)
                    .clickable {
                        toast("Mona", context)
                    }
                    .constrainAs(articleImage) {
                        end.linkTo(parent.end)
                    }
            )

        }
        Text(
            text = "read time",
            color = Color.Red,
            fontSize = 15.sp,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.wrapContentSize()
                .clickable {
                    toast("Matthew", context)
                }.constrainAs(readTime) {
                    linkTo(
                        top = tileImageContainer.bottom,
                        bottom = parent.bottom,
                    )
                },
        )
        Image(
            vectorResource(R.drawable.ic_grain),
            modifier = Modifier
                .background(color = Color.Green)
                .wrapContentHeight()
                .wrapContentWidth()
                .clickable {
                    toast("Mona", context)
                }
                .constrainAs(bookmark) {
                    end.linkTo(
                        parent.end
                    )
                    top.linkTo(
                        tileImageContainer.bottom
                    )
                    bottom.linkTo(
                        parent.bottom
                    )
                }
        )
    }
}


private fun toast(string: String, context: Context) {
    Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
}

