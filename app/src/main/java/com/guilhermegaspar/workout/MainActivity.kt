package com.guilhermegaspar.workout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guilhermegaspar.workout.ui.theme.WorkoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(Modifier.widthIn(200.dp)) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(id = R.drawable.baseline_menu),
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Blue),
                painter = painterResource(id = R.drawable.ic_android_black),
                contentDescription = null
            )
        }
        Text(modifier = Modifier.padding(16.dp), text = "Hi, Roberta")
        Text(modifier = Modifier.padding(start = 16.dp), text = "Qual seu filme favorito?")
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Categorias")
            Text(text = "View all")
        }
//        Row(
//            Modifier
//                .padding(8.dp)
//                .horizontalScroll(rememberScrollState()),
//            horizontalArrangement = Arrangement.spacedBy(16.dp)
//        ){
//            CategoryItem()
//            CategoryItem()
//            CategoryItem()
//            CategoryItem()
//        }

    }
}

@Preview
@Composable
fun CategoryItem() {
    Surface(

        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
//        Image(
//            Modifier.padding(16.dp),
//            painter = painterResource(id = R.drawable.ic_android_black),
//            contentDescription = null
//        )
        Text(text = "Hollywood", fontSize = 15.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    WorkoutTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryItemPreview() {
    WorkoutTheme {
        CategoryItem()
    }
}