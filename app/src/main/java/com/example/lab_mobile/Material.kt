package com.example.lab_mobile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BottomAppBarFunction() {
    BottomAppBar() {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Menu, contentDescription = "Menu")
        }

        Spacer(modifier = Modifier.weight(1f, true))

        IconButton(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.baseline_shopping_cart_24),
                contentDescription = "Shopping cart"
            )
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Favorite, contentDescription = "Favourites")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldFunction() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Add, contentDescription = "Add item")
            }
        },
        bottomBar = { BottomAppBarFunction() }
    ) {
        ListItems(padding = it)
    }
}

@Composable
fun ListItems(padding: PaddingValues) {
    LazyColumn(
        modifier = Modifier.padding(padding),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(50) {
            ListItemsImage(it)
        }
    }
}

@Composable
fun ListItem(index: Int) {
    Text(
        text = "Item n# $index",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSecondaryContainer
    )
}

@Composable
fun ListItemsImage(index: Int) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_android_24),
            contentDescription = "Android logo",
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onSecondaryContainer)
        )
        Spacer(modifier = Modifier.width(15.dp))
        ListItem(index = index)
    }
}