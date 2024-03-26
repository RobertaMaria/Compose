package com.guilhermegaspar.workout.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.guilhermegaspar.workout.R
import com.guilhermegaspar.workout.domain.entity.Result
import com.guilhermegaspar.workout.presentation.viewmodel.WorkoutViewModel
import com.guilhermegaspar.workout.ui.theme.WorkoutTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel: WorkoutViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getExercise()
        viewModel.getExerciseImage()
        setContent {
            WorkoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", viewModel = viewModel)
                }
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, viewModel: WorkoutViewModel) {
    val collectAsState by viewModel.state.collectAsState()
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
        Row(
            Modifier
                .padding(8.dp)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            collectAsState.list.forEach {
                CategoryItem(it.name)
            }
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Latest Movie")
            Text(text = "View all")
        }

        Row(
            Modifier
                .padding(8.dp)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            collectAsState.imageList.forEach {
                MovieSection(it.image)
            }
        }
    }
}

@Composable
fun MovieSection(image: String) {
    Surface(shape = RoundedCornerShape(15.dp), shadowElevation = 4.dp) {
        Column(
            Modifier
                .heightIn(250.dp, 300.dp)
                .widthIn(200.dp)
        ) {
            Image(
                modifier = Modifier.size(128.dp),
                painter = rememberAsyncImagePainter(image),
                contentDescription = null
            )
        }
    }
}

@Composable
fun CategoryItem(name: String) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Row() {
            Image(
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(Color.Green),
                painter = painterResource(id = R.drawable.ic_android_black),
                contentDescription = null
            )

            Text(text = name, fontSize = 15.sp)

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    WorkoutTheme {
        //Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryItemPreview() {
    WorkoutTheme {
        //CategoryItem()
    }
}

@Preview
@Composable
fun MovieSectionPreview() {
    WorkoutTheme {
        MovieSection("https://wger.de/media/exercise-images/91/Crunches-1.png")
    }
}