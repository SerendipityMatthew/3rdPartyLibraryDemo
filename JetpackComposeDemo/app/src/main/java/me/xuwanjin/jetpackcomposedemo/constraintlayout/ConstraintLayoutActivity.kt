package me.xuwanjin.jetpackcomposedemo.constraintlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class ConstraintLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutTest(Modifier.fillMaxSize())
        }
    }
}

@Composable
fun ConstraintLayoutTest(modifier: Modifier) {
    ConstraintLayout(
        modifier = modifier.fillMaxSize()
            .background(Color.Blue),
    ) {
        var (matthew, mona, angela, lilian, jessica) = createRefs()
        Text(
            text = "Matthew",
            modifier = Modifier.wrapContentSize()
                .background(Color.Green)
                .constrainAs(matthew) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            color = Color.Red,
        )
        Text(
            text = "Mona",
            modifier = Modifier.wrapContentSize()
                .background(Color.Green)
                .constrainAs(mona) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top, margin = 20.dp)
                    bottom.linkTo(matthew.top, margin = 20.dp)
                },
            color = Color.Red,
        )
        Text(
            text = "Angela",
            modifier = Modifier.wrapContentSize()
                .background(Color.Green)
                .constrainAs(angela) {
                    start.linkTo(parent.start)
                    end.linkTo(matthew.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            color = Color.Red,
        )
        Text(
            text = "Jessica",
            modifier = Modifier.wrapContentSize()
                .background(Color.Green)
                .constrainAs(jessica) {
                    start.linkTo(matthew.end)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            color = Color.Red,
        )
        Text(
            text = "Lilian",
            modifier = Modifier.wrapContentSize()
                .background(Color.Green)
                .constrainAs(lilian) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(matthew.bottom)
                    bottom.linkTo(parent.bottom)
                },
            color = Color.Red,
        )
    }
}