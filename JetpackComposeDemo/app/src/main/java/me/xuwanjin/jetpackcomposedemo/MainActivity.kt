package me.xuwanjin.jetpackcomposedemo

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import androidx.ui.tooling.preview.PreviewParameter
import me.xuwanjin.jetpackcomposedemo.ui.JetpackComposeDemoTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
            bottomNavigationBar()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeDemoTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun bottomNavigationBar() {
    Scaffold(
        bottomBar = {
            BottomNavigation(
                content = {
                    BottomNavigationItemHello()
                }
            )
        }
    ) {

    }

}

@Composable
fun BottomNavigationItemHello() {
    val context: Context = ContextAmbient.current
    BottomNavigationItem(
        
        icon = { Icon(vectorResource(R.drawable.ic_grain)) },
        selected = true,
        onClick = {
            toast("ic_grain", context = context)
        }
    )
    BottomNavigationItem(
        icon = { Icon(vectorResource(R.drawable.ic_featured)) },
        selected = false,
        onClick = {
            toast("ic_featured", context = context)
        }
    )
    BottomNavigationItem(
        icon = { Icon(vectorResource(R.drawable.ic_search)) },
        selected = false,
        onClick = {
            toast("ic_search", context = context)
        }
    )
    BottomNavigationItem(
        icon = { Icon(vectorResource(R.drawable.ic_search)) },
        selected = false,
        onClick = {
            toast("ic_search", context = context)
        }
    )
}

private fun toast(string: String, context: Context) {
    Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
}
