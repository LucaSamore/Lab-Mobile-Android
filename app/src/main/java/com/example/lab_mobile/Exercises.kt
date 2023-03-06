package com.example.lab_mobile

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab_mobile.ui.theme.Purple40
import com.example.lab_mobile.ui.theme.Purple80

@Composable
fun OrientationChange(configuration: Configuration) {
    when(configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            Greeting(name = "landscape")
        }
        else -> {
            Greeting(name = "Portrait!")
        }
    }
}


@Composable
fun VerticalLayout(configuration: Configuration) {
    Column() {
        Greeting(name = "Android")
        OrientationChange(configuration = configuration)
    }
}

@Composable
fun HorizontalLayout(configuration: Configuration) {
    Row() {
        Greeting(name = "Android")
        OrientationChange(configuration = configuration)
    }
}

@Composable
fun BoxConstraintsLayout() {
    BoxWithConstraints() {
        val scope = this
        Column() {
            if (scope.maxHeight >= 400.dp) {
                Greeting(name = ">= 400dp")
            }
            Spacer(modifier = Modifier.size(15.dp))
            Text(text = "minH = ${scope.minHeight} \n" +
                    "maxH ${scope.maxHeight} \n" +
                    "minW = ${scope.minWidth} \n" +
                    "maxW = ${scope.maxWidth}")

        }
    }
}

@Composable
fun Greeting(names: List<String>) {
    names.forEach { Text(text = "Hello $it!") }
}

@Composable
fun ListNames() {
    val names = listOf("A", "S", "D", "Q")

    Column() {
        Greeting(names = names)
    }
}

@Composable
fun ScrollableList() {
    val size = 50
    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp) ) {
        items(size) {
            Text(
                text = "Item n# $it",
                color = if(isSystemInDarkTheme()) Purple80 else Purple40,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}